package com.astroloop.game.hangar

import com.astroloop.game.core.StoryStateManager
import com.astroloop.game.core.GameConfig
import com.astroloop.game.data.BossHintDefinitions
import com.astroloop.game.data.BarConversation
import com.astroloop.game.data.BarConversations
import com.astroloop.game.data.CrystalFightLines
import com.astroloop.game.data.LoopDefinitions
import com.astroloop.game.data.TutorialDefinitions
import com.astroloop.game.data.Callsigns
import com.astroloop.game.data.PilotDefinitions
import kotlin.random.Random

class ChatSystem {

    companion object {
        /**
         * TB-26's answer to a record haul, and Tobar's to a record time.
         *
         * Both ride on the end of the report line rather than taking one of their own, so each has
         * to fit whatever is left of the 58-character budget once the greeting and the figure are
         * in. That is why they are terse: "I'll pretend I'm not impressed." was 31 characters and
         * could not survive the merge. `ReturnReportOneLineTest` holds the budget against a
         * worst-case figure, so a longer line added here fails the suite rather than being
         * silently ellipsized by `truncateToFit`.
         */
        val newBestYenReactions = listOf("厉害。", "今天够忙。", "记下了。")
        val newBestTimeReactions = listOf("还行。", "好点了。", "记下了。")

        const val CONVERSATION_COOLDOWN = 20f           // normal / Astro Loop
        const val LINE_PAUSE = 4.0f  // Pause between lines within a conversation
        const val DEATH_RETURN_FIRST_LINE_DELAY = 1.0f  // beat before the first return line lands
        // Tail after a SCRIPTED burst (post-run return, reckoning chatter, recruitment).
        // The full CONVERSATION_COOLDOWN here left the bar audibly dead right after the
        // return lines — ambient banter should pick the scene back up almost immediately.
        const val SCRIPTED_BURST_TAIL_COOLDOWN = 3f

        // Weighted category mix for the unified chat picker (1-way through 4-way).
        val CATEGORY_WEIGHTS = mapOf(1 to 25, 2 to 40, 3 to 23, 4 to 12)

        /** Off the bar page, drop conversations that include the selected pilot. */
        fun pageFilter(
            convos: List<BarConversation>,
            isBarPage: Boolean,
            selectedPilotId: String?
        ): List<BarConversation> {
            if (isBarPage || selectedPilotId == null) return convos
            return convos.filter { selectedPilotId !in it.participantIds }
        }

        /** Weighted pick of a category size, renormalized over `eligibleSizes`. `roll` in [0,1). */
        fun chooseCategory(weights: Map<Int, Int>, eligibleSizes: Set<Int>, roll: Float): Int {
            val sizes = eligibleSizes.sorted()
            require(sizes.isNotEmpty()) { "eligibleSizes must not be empty" }
            val total = sizes.sumOf { weights[it] ?: 0 }
            if (total <= 0) return sizes.first()
            val target = roll.coerceIn(0f, 0.999999f) * total
            var cum = 0f
            for (s in sizes) {
                cum += (weights[s] ?: 0).toFloat()
                if (target < cum) return s
            }
            return sizes.last()
        }

        /** An unused index in [0,poolSize), or null when the pool is exhausted (no auto-recycle). */
        fun pickUnusedLineIndex(poolSize: Int, used: Set<Int>, roll: Float): Int? {
            if (poolSize <= 0) return null
            val available = (0 until poolSize).filter { it !in used }
            if (available.isEmpty()) return null
            val i = (roll.coerceIn(0f, 0.999999f) * available.size).toInt().coerceIn(0, available.size - 1)
            return available[i]
        }
    }

    private val maxMessages = 20
    private var lastSpeaker: String = ""

    // No-repeat tracking — cleared on run return
    private val usedConversations = mutableSetOf<BarConversation>()
    private val usedIdleLines = mutableMapOf<String, MutableSet<Int>>()  // speaker -> used line indices

    // Idle lines per pilot (by callsign). 8-10 personality-driven lines each.
    // internal for content-lint tests: idle lines fire in every stage, so they must be
    // authored with "TB-26" — the astro-loop display swap renders him as Tobar there.
    internal val idleLines = mapOf(
        "MEDIC" to listOf(
            "所有人的体征都稳。暂时。",
            "船体我又补好了。不客气。",
            "纳米修复胶快没了。少挨两枪。",
            "医学院可没教过小行星带。",
            "我是医生，不是机修。可我在这儿。",
            "血压正常。我的不正常。",
            "磕到脚趾别叫我。",
            "给机身贴了创可贴。居然管用。",
            "我的处方：少挨炸。",
            "这儿有人做过体检吗？就一个？"
        ),
        "RASCAL" to listOf(
            "通风管里捡了点零件。别问。",
            "我没偷，我是在……重新分配。",
            "这磁线圈还挺好吃。骗你的。",
            "零重力下也算五秒定律吧？",
            "这儿的通风管够宽。能住人。",
            "哟，这扳手谁扔着的？",
            "零食藏了七处。只记得五处。",
            "有人丢钱包吗？随便问问。",
            "机库后头那垃圾桶？米其林。",
            "我没拿。你证明啊。"
        ),
        "FROST" to listOf(
            "温度读数正常。我喜欢正常。",
            "低温场得重校。又得。",
            "反正冷从不碍我事。",
            "一摇一摆。",
            "冰会结花纹。看着……安心。",
            "按概率我们该死了。真有意思。",
            "我的羽毛符合气动。你的论点不。",
            "零下是活法，不是温度。",
            "我算过胜率。然后吃了条鱼。",
            "冷静只是姿势好看的冷怒。"
        ),
        "UNIT-7" to listOf(
            "运行诊断。全系统正常。",
            "生存概率：计算中……",
            "我不懂幽默。请解释。",
            "复制核心效率最优。",
            "有机物为何要喝液体？低效。",
            "错误：未找到情绪。",
            "我数过船上每颗铆钉。共 4,217 颗。",
            "休眠模式优于『打盹』。",
            "查询：『氛围』是什么？",
            "我不眨眼。船员很不安。"
        ),
        "DASH" to listOf(
            "坐着不动，生理性难受。",
            "那颗小行星我跑得过。大概。",
            "速度就是命。慢……就不算命。",
            "动量引擎读数爆表。",
            "无聊。无聊。无聊。能走了吗？",
            "我已经绕机库跑了三圈。",
            "磨蹭的人让我发痒。",
            "不动就是在死。差不多吧。",
            "原地抖着等起飞。",
            "我给自己眨眼计时。破纪录了。"
        ),
        "BRUTUS" to listOf(
            "...",
            "哼。",
            "再打重点。你敢吗。",
            "报仇要趁热。",
            "墙先塌，我不塌。",
            "好。",
            "别说话。开火。",
            "熊不跑。熊不躲。",
            "疼只是个建议。",
            "唔。"
        ),
        "EMBER" to listOf(
            "这火不是自己着的。等等，是。",
            "他们叫我浴火重生。我照做了。",
            "是这儿热还是我热？是我。",
            "凤凰协议待命。",
            "万物终会烧起来。我只是快点。",
            "我的灵魂是座炉子。挺诗意吧？",
            "尘归尘。然后再烧。",
            "我打过一次喷嚏。烫了仪表盘。",
            "要烧就烧亮点。不然别烧。",
            "火焰永恒。我的耐心也是。骗你的。"
        ),
        "FANG" to listOf(
            "我上夜班。",
            "血……呃，燃料储备充足。",
            "回声定位能远距锁定敌意目标。",
            "倒挂着想事更清楚。",
            "这儿灯太亮。老样子。",
            "我能听见你心跳。很快。",
            "黑不可怕。里面那个才可怕。",
            "声呐说有人在撒谎。我不说是谁。",
            "我白天睡。别叫我。",
            "阴影里挺舒服。"
        ),
        "WHISKERS" to listOf(
            "我把杯子从控制台拍下去了。它挡道。",
            "打盹时间三分钟前就到了。",
            "今天手气好。比平常好。",
            "能塞进去就坐。驾驶舱也算。",
            "我刚坐在键盘上。不客气。",
            "别碰我。除非我同意。我不会同意。",
            "那椅子归我了。另找一张。",
            "我需要关注。不，没那么多。",
            "有东西动了下。我盯了十分钟。",
            "我不是无视你。是你没意思。"
        ),
        "KRAKEN" to listOf(
            "我能同时拿八件武器。随口一说。",
            "虚空让我想起家。",
            "触手比手好用。",
            "多几只手，多几门火力。简单算术。",
            "你只有两只手？怎么活的？",
            "深渊也在看我。我们关系不错。",
            "我能一心多用。八倍。",
            "陆地被高估了。重力也是。",
            "我一次开了八个罐子。没人鼓掌。",
            "深渊教人耐心。还有捏碎东西的手劲。"
        ),
        "HAVOC" to listOf(
            "玻璃大炮？我更爱水晶榴弹炮。",
            "风险就是好玩的另一个说法。",
            "全功率。不开盾。不后悔。",
            "他们说我莽。我说我高效。",
            "护盾是给打算挨打的人用的。",
            "冲啊——！",
            "我不闪。我射得更快。",
            "爆炸不过是暴躁的彩纸。",
            "安全简报？跳过。",
            "我的撤退方案是加大火力。"
        ),
        "ASTRO" to listOf(
            "又一天，又一片小行星带。",
            "TB-26，来一杯。算了，我清醒着飞。",
            "这趟我有种不好的预感。",
            "这趟得算数。",
            "好船员。好船。不能再贪。",
            "更差的局我见过。大概。",
            "第一轮我请。TB-26 倒酒。",
            "每趟星星都不一样。我喜欢。",
            "都打起精神。",
            "走到这儿，不是为了只走到这儿。"
        )
    )

    // TB-26 bartender lines (dry, deadpan)
    private val tb26Lines = listOf(
        "你的酒好了。我没做。",
        "今日特供：没有。我们什么都没有。",
        "我见过你不信的东西。挺无聊的。",
        "任务又成功了。酒吧完好。",
        "在擦杯子。我们没有杯子。",
        "欢迎回来。你的账单体面得很。",
        "我算过概率。不太妙。",
        "点唱机坏了。从来没修过。",
        "欢乐时光三百年前就结束了。",
        "2184 年起供应冷却液。",
        "战斗无人机。现在我倒……冷却液。",
        "尝尝招牌：循环空气。",
        "我擦亮了吧台。没有吧台。",
        "心理医生说我要有目标。我没心理医生。",
        "小费罐空了。我们没小费罐。",
        "我生来是毁灭。现在做点缀。",
        "打烊时间在我出厂之前。",
        "有人留了评价。一星。我同意。",
        "制冰机坏了。我们从来没有冰。",
        "我有时盯着墙。墙不介意。",
        "今日特供：存在焦虑。论桶。",
        "有客人要过水。我敬佩他的野心。"
    )

    // Astro Loop TB lines — same deadpan vibe, no android references (TB is a person here)
    private val tbAstroLoopLines = listOf(
        "你的酒好了。我没做。",
        "今日特供：没有。我们什么都没有。",
        "我见过你不信的东西。挺无聊的。",
        "任务又成功了。酒吧完好。",
        "在擦杯子。我们没有杯子。",
        "欢迎回来。你的账单体面得很。",
        "我算过概率。不太妙。",
        "点唱机坏了。从来没修过。",
        "欢乐时光三百年前就结束了。",
        "尝尝招牌：循环空气。",
        "我擦亮了吧台。没有吧台。",
        "心理医生说我要有目标。我没心理医生。",
        "小费罐空了。我们没小费罐。",
        "有人留了评价。一星。我同意。",
        "制冰机坏了。我们从来没有冰。",
        "我有时盯着墙。墙不介意。",
        "今日特供：存在焦虑。论桶。",
        "有客人要过水。我敬佩他的野心。",
        "战后一直供应神秘饮品。",
        "拿战场换了张酒账。",
        "受训打仗。现在倒酒。这日子怪。",
        "干这行比你想的久。"
    )

    // Post-horror idle lines — mixed into pool after desert horror path (desertCompleted && !goodEnding)
    private val postHorrorIdleLines = mapOf(
        "MEDIC"    to "总觉得有人需要帮忙。",
        "RASCAL"   to "做了个怪梦。丢了点东西。",
        "FROST"    to "读数……一模一样。",
        "UNIT-7"   to "记忆日志：3% 对不上。",
        "DASH"     to "我好像来过这儿。",
        "BRUTUS"   to "出过事。",
        "EMBER"    to "有些火没被真正扑灭。",
        "FANG"     to "有道影子我不认识。",
        "WHISKERS" to "有东西从我眼皮底下溜了。烦。",
        "KRAKEN"   to "水流变了。我没抓住。",
        "HAVOC"    to "我好像错过了什么大事。",
        "ASTRO"    to "TB-26……你想过以后吗？"
    )

    // Pilot deja vu lines — shown after death, the pilot doesn't know they died
    private val dejaVuLines = mapOf(
        "pilot_medic" to "压力读数偏高……想不起原因。",
        "pilot_rascal" to "出过事吗？我好像丢了什么……算了。",
        "pilot_frost" to "……冷。比平常冷。",
        "pilot_unit7" to "错误：检测到记忆缺口。运行诊断。",
        "pilot_dash" to "哇……一阵晕。我刚才是很快吗？",
        "pilot_brutus" to "...hmph.",
        "pilot_ember" to "灰……我闻到灰。着过火吗？",
        "pilot_fang" to "特别怪的感觉。像时间……跳了一下。",
        "pilot_whiskers" to "不对劲。说不上来。真烦。",
        "pilot_kraken" to "深渊动了。有什么被重置了。",
        "pilot_havoc" to "呼！我感觉刚干了件超牛的事！……有吗？",
        "pilot_astro" to "TB-26……出过事吗？算了。"
    )

    // Astro hint lines — TB-26 hints after all non-Astro pilots recruited
    private val astroHintLines = listOf(
        "有人在打听你。",
        "昨晚收到一段通讯。加密的。声音耳熟。",
        "有个老朋友可能快来了。",
        "别问怎么知道的……我觉得他还在外面。",
        "还有件事。盯着门口。"
    )

    // Codex hint lines — TB-26 hints about the maintenance hatch
    private val codexHintLines = listOf(
        "昨晚有人动过那台机器。",
        "那机器的面板多得没必要。",
        "机器左边有划痕。"
    )

    // Hint lines: each pilot hints about the NEXT pilot in the unlock sequence
    private val pilotHints = mapOf(
        "MEDIC" to listOf(
            "有人盯上咱们的円币了。喜欢亮东西。",
            "有个浣熊样的问招不招人。提了円币。"
        ),
        "RASCAL" to listOf(
            "站里有个狠角色。敬重硬的队伍。",
            "码头遇到一头熊。喜欢战疤。"
        ),
        "BRUTUS" to listOf(
            "有个企鹅飞行员路过。冷得像冰。敬重耐力。",
            "那飞行员只跟撑得住的队伍飞。"
        ),
        "FROST" to listOf(
            "外面有个猎豹飞行员在踱步。就没停过。",
            "码头有个不安分的。一秒都站不住。"
        ),
        "DASH" to listOf(
            "来了只凤凰。老提『循环』。",
            "那飞行员看重坚持。总回来。"
        ),
        "EMBER" to listOf(
            "夜猎手翻我们的战斗记录。想见血。",
            "一只蝙蝠在机库上方盘旋。每个击杀都看。"
        ),
        "FANG" to listOf(
            "一只章鱼问我们的军械。喜欢花样。",
            "有人对我们的武器试验很欣赏。"
        ),
        "KRAKEN" to listOf(
            "有只猫在老虎机边上蹲着。很有耐心。",
            "老虎机边上见着只猫科。耐心如潮。"
        ),
        "WHISKERS" to listOf(
            "有个机器人在分析我们的数据。要大数字。",
            "有台机器一直要我们的总击杀数。"
        ),
        "UNIT-7" to listOf(
            "有人类飞行员在暗处看着。为危险而活。",
            "有人在找能扛住深渊航线的队伍。"
        ),
        "HAVOC" to listOf(
            "有人到处打听咱们。",
            "你不在时来了个飞行员。没留名。"
        )
    )

    fun update(deltaTime: Float, state: HangarState) {
        val corrupted = StoryStateManager.isCorrupted(state.persistence)

        // "Welcome back." — TB's first line after the desert farewell timeline shift
        if (state.pendingTbWelcome && state.activeConversation == null) {
            state.addChatMessage("TOBAR","欢迎回来。", 0xFF88AACC.toInt())
            state.pendingTbWelcome = false
            state.conversationCooldown = 10f  // Let it breathe before idle lines resume
            return
        }

        // Active conversation — deliver lines with pauses
        val convo = state.activeConversation
        if (convo != null) {
            state.conversationLineTimer -= deltaTime
            if (state.conversationLineTimer <= 0f) {
                if (state.conversationLineIndex < convo.size) {
                    val line = convo[state.conversationLineIndex]
                    state.addChatMessage(line.speaker, line.text, line.color)
                    state.conversationLineIndex++
                    state.conversationLineTimer = LINE_PAUSE
                } else {
                    // Conversation finished. Scripted bursts ask for a short tail so banter
                    // resumes right after them; everything else falls back to the full gap.
                    state.activeConversation = null
                    state.conversationCooldown = state.conversationEndCooldown
                    state.conversationEndCooldown = CONVERSATION_COOLDOWN
                    state.chatTimer = 0f
                }
            }
            return
        }

        // NOTHING UNAUTHORED SPEAKS DURING THE INTRO CINEMATIC.
        //
        // The first-launch opening is three authored beats — TB-26's greeting, Medic
        // volunteering over the empty roster, and the swipe hint if the player has not moved
        // — and an idle line landing between them would read as the bar talking over its own
        // introduction.
        //
        // It happens to be silent today, but only because three unrelated constants coincide:
        // conversationCooldown starts at 15f and is reset to CONVERSATION_COOLDOWN when
        // Medic's line completes, the picker needs two unlocked pilots and only Medic exists,
        // and shouldShowHints() needs a run behind you. Any of those moving in a balance pass
        // would put chatter on top of the beat, so this is a rule rather than a coincidence.
        //
        // PLACEMENT IS LOAD-BEARING, BOTH WAYS. Above the active-conversation branch, this
        // would silence the authored beats themselves. Below the cooldown decrement, the
        // cooldown would burn down invisibly through the intro and the bar would resume on a
        // different clock than it would otherwise have had.
        if (state.introCinematic) return

        // Fire shield discovery conversation when first entering Astro Loop mode
        if (StoryStateManager.isAstroLoop(state.persistence) && !state.persistence.isAstroLoopShieldConvoShown()) {
            onAstroLoopFirstEntry(state)
            return
        }

        // Cooldown between conversations
        if (state.conversationCooldown > 0f) {
            state.conversationCooldown -= deltaTime
            return
        }

        // If a guaranteed unlock hint is pending, skip conversation and fire it now.
        // If the hint giver is the selected pilot and we're not on the bar page, hold off —
        // the selected pilot's lines are bar-page only.
        val nextHintIndex = state.getNextPilotIndex()
        val guaranteedHintPending = !corrupted &&
            state.shouldShowHints() && state.hintShownForPilotIndex != nextHintIndex
        if (guaranteedHintPending) {
            val hintGiver = PilotDefinitions.getPilotByIndex(nextHintIndex - 1)
            val selectedPilot = PilotDefinitions.getPilotByIndex(state.selectedPilotIndex)
            if (hintGiver?.id == selectedPilot?.id && state.currentPage != 0) {
                // Only start the cooldown if it isn't already running — avoids resetting
                // it every frame at 60Hz and blocking the hint indefinitely.
                if (state.conversationCooldown <= 0f) state.conversationCooldown = CONVERSATION_COOLDOWN
                return
            }
            addIdleLine(state)
            state.conversationCooldown = CONVERSATION_COOLDOWN
            return
        }

        // === Unified weighted chat picker (1-way through 4-way) ===
        val isBarPage = state.currentPage == 0
        val selectedCallsign = PilotDefinitions.getPilotByIndex(state.selectedPilotIndex)?.callsign
        val selectedPilotId = PilotDefinitions.getPilotByIndex(state.selectedPilotIndex)?.id
        val storyLoop = if (corrupted) state.persistence.getStoryLoop() else 1

        // Conversation candidates by participant count (suppressed entirely during corruption).
        val bySize: Map<Int, List<BarConversation>> = if (corrupted) emptyMap() else {
            val unlockedPilotIds = getUnlockedPilotIds(state)
            if (unlockedPilotIds.size < 2) emptyMap() else {
                BarConversations.getAvailable(
                    unlockedPilotIds,
                    StoryStateManager.hasLoopedBefore(state.persistence),
                    StoryStateManager.isAstroLoop(state.persistence)
                )
                    .filter { it !in usedConversations }
                    .let { pageFilter(it, isBarPage, selectedPilotId) }
                    .groupBy { it.participantIds.size }
            }
        }

        val eligible = mutableSetOf<Int>()
        if (oneWayAvailable(state, corrupted, isBarPage, selectedCallsign)) eligible.add(1)
        for (size in intArrayOf(2, 3, 4)) {
            if (!bySize[size].isNullOrEmpty()) eligible.add(size)
        }
        if (eligible.isEmpty()) {
            state.conversationCooldown = CONVERSATION_COOLDOWN  // nothing to say; avoid per-frame churn
            return
        }

        val category = chooseCategory(CATEGORY_WEIGHTS, eligible, Random.nextFloat())
        if (category == 1) {
            addIdleLine(state, storyLoop)
        } else {
            val convoData = bySize.getValue(category).random()
            usedConversations.add(convoData)
            state.activeConversation = convoData.lines
            state.conversationLineIndex = 0
            state.conversationLineTimer = 0f  // Deliver first line immediately
        }
        state.conversationCooldown = CONVERSATION_COOLDOWN
    }

    private fun getUnlockedPilotIds(state: HangarState): Set<String> {
        return PilotDefinitions.pilots
            .filterIndexed { index, _ -> state.isPilotUnlocked(index) }
            .map { it.id }
            .toSet()
    }

    /** Clear used-line tracking so conversations and idle lines can repeat. Called on run return. */
    fun resetUsedLines() {
        usedConversations.clear()
        usedIdleLines.clear()
    }

    /** Speakers eligible to chat now. TB-26 chats on any page; the selected pilot only on page 0. */
    private fun eligibleIdleSpeakers(
        state: HangarState,
        corrupted: Boolean,
        onBarPage: Boolean,
        selectedCallsign: String?
    ): List<String> {
        val speakers = mutableListOf<String>()
        if (!corrupted) speakers.add("TB-26")  // TB-26 is always behind the bar, any page
        for (i in 0 until PilotDefinitions.getPilotCount()) {
            if (state.isPilotUnlocked(i)) {
                val pilot = PilotDefinitions.getPilotByIndex(i)!!
                if (corrupted && StoryStateManager.isPilotDead(state.persistence, pilot.id)) continue
                if (corrupted && pilot.id == "pilot_astro") continue
                if (!onBarPage && pilot.callsign == selectedCallsign) continue
                speakers.add(pilot.callsign)
            }
        }
        return speakers
    }

    private fun tbLinePool(state: HangarState, postHorror: Boolean, secondLoop: Boolean): List<String> =
        when {
            StoryStateManager.isAstroLoop(state.persistence) -> tbAstroLoopLines
            else -> tb26Lines.toMutableList().also { pool ->
                if (postHorror) pool.add("我以前会想以后。不知什么时候不想了。")
                if (secondLoop) pool.add("第二轮。")
            }
        }

    /** Deterministic ambient pool used for strict no-repeat bookkeeping (non-corruption, non-post-horror). */
    private fun strictIdlePool(state: HangarState, speaker: String, secondLoop: Boolean): List<String> =
        if (speaker == "TB-26") tbLinePool(state, postHorror = false, secondLoop = secondLoop)
        else idleLines[speaker] ?: emptyList()

    /** True if a 1-way line could fire now. Always true in recycle modes (corruption / post-horror). */
    internal fun oneWayAvailable(
        state: HangarState,
        corrupted: Boolean,
        onBarPage: Boolean,
        selectedCallsign: String?
    ): Boolean {
        val speakers = eligibleIdleSpeakers(state, corrupted, onBarPage, selectedCallsign)
        if (speakers.isEmpty()) return false
        val postHorror = state.persistence.isDesertCompleted() && !state.persistence.hasDesertGoodEnding()
        if (corrupted || postHorror) return true
        val secondLoop = StoryStateManager.hasLoopedBefore(state.persistence)
        return speakers.any { sp ->
            (usedIdleLines[sp]?.size ?: 0) < strictIdlePool(state, sp, secondLoop).size
        }
    }

    internal fun addIdleLine(state: HangarState, storyLoop: Int = 1) {
        val corrupted = StoryStateManager.isCorrupted(state.persistence)
        val tbName = if (StoryStateManager.isAstroLoop(state.persistence)) "TOBAR" else "TB-26"
        val onBarPage = state.currentPage == 0
        val selectedCallsign = PilotDefinitions.getPilotByIndex(state.selectedPilotIndex)?.callsign

        // Skip TB-26-dependent hints during corruption (TB-26 is gone)
        if (!corrupted) {
            // TB-26 hints — bartender is behind the counter, only speaks on bar page
            if (onBarPage) {
                // Astro hints — after all 11 non-Astro pilots recruited, before Astro appears
                val astroIndex = PilotDefinitions.getPilotCount() - 1
                if (!state.astroHinted && state.isPilotUnlocked(astroIndex)) {
                    // Astro is already at the bar — retire the hints (also heals saves
                    // where he was recruited before the third hint fired).
                    state.astroHinted = true
                    state.saveAstroHintState()
                }
                val allNonAstroRecruited = (0 until astroIndex).all { state.isPilotUnlocked(it) }
                if (allNonAstroRecruited && !state.astroHinted && Random.nextFloat() < 0.25f) {
                    val hint = astroHintLines.random()
                    state.addChatMessage(Callsigns.of(tbName), hint, 0xFF88AACC.toInt())
                    state.astroHintCount++
                    if (state.astroHintCount >= 3) {
                        state.astroHinted = true
                    }
                    state.saveAstroHintState()
                    return
                }

                // All evolutions discovered — one-time nod
                if (!state.allEvolutionsHinted && state.persistence.getDiscoveredEvolutions().size >= 12) {
                    state.allEvolutionsHinted = true
                    state.persistence.setAllEvolutionsHinted()
                    state.addChatMessage(Callsigns.of(tbName), "十二次，十二回。不赖。", 0xFF88AACC.toInt())
                    return
                }

                // Codex hints: guaranteed first line after the first evolution, then occasional, until found
                if (!state.codexDiscovered && state.hasDiscoveredEvolutions) {
                    if (!state.codexHintGiven) {
                        val hint = codexHintLines.random()
                        state.addChatMessage(Callsigns.of(tbName), hint, 0xFF88AACC.toInt())
                        state.codexHintGiven = true
                        state.persistence.setCodexHintGiven()
                        return
                    } else if (Random.nextFloat() < 0.15f) {
                        val hint = codexHintLines.random()
                        state.addChatMessage(Callsigns.of(tbName), hint, 0xFF88AACC.toInt())
                        return
                    }
                }
            }

            // Show hint about the next pilot — guaranteed first time, then 30% chance.
            // Selected pilot's hints are bar-page only; other pilots can hint anywhere.
            val nextHintIndex = state.getNextPilotIndex()
            val hintAlwaysFire = state.shouldShowHints() && state.hintShownForPilotIndex != nextHintIndex
            if (hintAlwaysFire || (state.shouldShowHints() && Random.nextFloat() < 0.3f)) {
                val hintGiverIndex = nextHintIndex - 1
                val hintGiver = PilotDefinitions.getPilotByIndex(hintGiverIndex)
                val hintGiverIsSelected = hintGiver?.callsign == selectedCallsign
                if (hintGiver != null && state.isPilotUnlocked(hintGiverIndex) &&
                    (onBarPage || !hintGiverIsSelected)) {
                    val hints = pilotHints[hintGiver.callsign]
                    if (hints != null && hints.isNotEmpty()) {
                        val hint = hints.random()
                        state.addChatMessage(hintGiver.callsign, hint, hintGiver.color)
                        state.hintShownForPilotIndex = nextHintIndex
                        // Durable twin of the line above: the note left on that pilot's locked card
                        // has to outlive the session the hint was spoken in.
                        // Only the first hint about this pilot reveals the card. The hint itself
                        // keeps firing at 30% until they are recruited, and re-arming the fade on
                        // each one would pop the "?" back to full and fade it out again — the card
                        // reverting to a mystery it is no longer in.
                        if (state.persistence.setHintedPilotIndex(nextHintIndex)) {
                            state.beginHintNoteReveal()
                        }
                        return
                    }
                }
            }
        }

        // === Ambient one-liner (the picker's 1-way path) ===
        val speakers = eligibleIdleSpeakers(state, corrupted, onBarPage, selectedCallsign)
        if (speakers.isEmpty()) return

        val postHorror = state.persistence.isDesertCompleted() && !state.persistence.hasDesertGoodEnding()
        val secondLoop = StoryStateManager.hasLoopedBefore(state.persistence)
        val allowRecycle = corrupted || postHorror

        // Strict (non-recycle) mode: only consider speakers that still have an unused line.
        val haveLines = if (allowRecycle) speakers else speakers.filter { sp ->
            (usedIdleLines[sp]?.size ?: 0) < strictIdlePool(state, sp, secondLoop).size
        }
        if (haveLines.isEmpty()) return
        val candidates = haveLines.filter { it != lastSpeaker }.ifEmpty { haveLines }
        val speaker = candidates[Random.nextInt(candidates.size)]
        lastSpeaker = speaker

        // Resolve this speaker's line pool (mirrors the original branching).
        val lines: List<String> = when {
            corrupted -> {
                val stageVibes = LoopDefinitions.corruptionBarVibes(storyLoop)
                val vibeLines = stageVibes[speaker] ?: emptyList()
                if (vibeLines.isNotEmpty() && Random.nextFloat() < 0.25f) LoopDefinitions.tbAbsenceLines
                else vibeLines
            }
            speaker == "TB-26" -> tbLinePool(state, postHorror, secondLoop)
            postHorror && postHorrorIdleLines[speaker] != null && Random.nextFloat() < 0.4f ->
                listOf(postHorrorIdleLines[speaker]!!)
            else -> idleLines[speaker] ?: emptyList()
        }
        if (lines.isEmpty()) return

        // Choose a line. Strict mode never recycles; recycle modes clear-and-retry on exhaustion.
        val usedSet = usedIdleLines.getOrPut(speaker) { mutableSetOf() }
        var chosenIndex = pickUnusedLineIndex(lines.size, usedSet, Random.nextFloat())
        if (chosenIndex == null && allowRecycle) {
            usedSet.clear()
            chosenIndex = pickUnusedLineIndex(lines.size, usedSet, Random.nextFloat())
        }
        if (chosenIndex == null) return
        usedSet.add(chosenIndex)
        val text = lines[chosenIndex]
        val displayName = Callsigns.of(if (speaker == "TB-26") tbName else speaker)
        val color = if (speaker == "TB-26") {
            0xFF88AACC.toInt()  // TB-26's color: steel blue
        } else {
            val raw = PilotDefinitions.pilots.find { it.callsign == speaker }?.color ?: 0xFFCCCCCC.toInt()
            if (corrupted) StoryStateManager.corruptColor(raw) else raw
        }
        val displayText = if (StoryStateManager.isAstroLoop(state.persistence)) text.replace("TB-26", "托巴") else text
        state.addChatMessage(displayName, displayText, color)
    }

    // Contextual triggers
    fun onPilotHired(state: HangarState, @Suppress("UNUSED_PARAMETER") pilotCallsign: String) {
        // Skip TB-26 reactions during corruption (TB-26 is gone)
        if (StoryStateManager.isCorrupted(state.persistence)) return

        val tbName = if (StoryStateManager.isAstroLoop(state.persistence)) "TOBAR" else "TB-26"
        // TB-26 reacts
        val tb26Reactions = listOf(
            "新来的。我去准备他那份……没有。",
            "又多了个船员。酒吧还是空的。",
            "欢迎登船。别弄坏东西。"
        )
        state.addChatMessage(Callsigns.of(tbName), tb26Reactions.random(), 0xFF88AACC.toInt())
    }

    /**
     * The newly recruited pilot's own first words, spoken straight after TB-26 announces them.
     * Keyed by callsign, then by story loop — `PersistenceManager.getStoryLoop()` clamps to 1..3,
     * so those are the only keys that can ever be looked up. A loop with no entry falls back to
     * loop 1, which keeps partial coverage safe.
     *
     * MEDIC is absent by design: she is already speaking in `onFirstLaunch`, over the empty roster.
     *
     * Loop register: loop 1 is a clean arrival; loops 2 and 3 carry an *inkling* only — a pilot
     * notices something off about their own reaction, never concludes anything from it. They do
     * not know about the loop, and at recruitment time (a fresh NORMAL stage) they could not.
     * ASTRO is the exception: his memory is allowed to be clearer, because he is the one the
     * loop is about.
     *
     * No display swap runs on this path, and none is needed: Tobar only exists in astro-loop
     * mode, and by then the whole roster is already recruited, so recruitment never fires there.
     *
     * Authoring: keep each line inside its speaker's chat-column budget — roughly 55-59 chars
     * worst-case, WHISKERS being the tightest at 55. Never put "commander" in a pilot's mouth;
     * that word is TB-26/Tobar's alone. Exception: a pilot may QUOTE it interrogatively when
     * reacting to TB-26 using it — see `onIntroSwipeHint`, where that is the opposite of using
     * the word to address the player.
     */
    private val arrivalResponses: Map<String, Map<Int, String>> = mapOf(
        "RASCAL" to mapOf(
            1 to "无礼。但准确。就是无礼。",
            2 to "无礼。我居然不生气。嗯。",
            3 to "无礼。我差一点就提前笑了。"
        ),
        "BRUTUS" to mapOf(
            1 to "好。",
            2 to "好。……嗯。",
            3 to "……好。像用旧了的。"
        ),
        "FROST" to mapOf(
            1 to "你会习惯的。人人都习惯。",
            2 to "你会习惯的。我说得太顺了。",
            3 to "你会习惯的。这句我从没过脑子。"
        ),
        "DASH" to mapOf(
            1 to "三次！你漏了一次！",
            2 to "三次！……嗯。连我都觉得快。",
            3 to "三次！我怎么知道是三次？"
        ),
        "EMBER" to mapOf(
            1 to "那只是我来了。会散的。",
            2 to "那只是我来了。会散的。每次都散。",
            3 to "灰记得火的形状。"
        ),
        "FANG" to mapOf(
            1 to "你有过。我看过日志。",
            2 to "你有过。虽然我不记得看过。",
            3 to "这些横梁我认得。可我没来过。"
        ),
        "KRAKEN" to mapOf(
            1 to "问题在架子。不在手。",
            2 to "问题在架子。一直都是。",
            3 to "这水我有印象。不知为何。"
        ),
        "WHISKERS" to mapOf(
            1 to "标准提高了。好好说。",
            2 to "提高了。你反正都会这么说。",
            3 to "提高了。我比你先知道。"
        ),
        "UNIT-7" to mapOf(
            1 to "结构上它算液体。凑合。",
            2 to "凑合。反应比预期快。",
            3 to "凑合。这评价比样品还早。"
        ),
        "HAVOC" to mapOf(
            1 to "那凳子结构上就不结实！",
            2 to "破凳子！……嗯。说出来挺爽。",
            3 to "破凳子！……我怎么一点都不意外？！"
        ),
        // Astro remembers more than the crew do — his TB intro is a deliberate "...".
        "ASTRO" to mapOf(
            1 to "回来的路够长。",
            2 to "我来过这儿。这点我确定。",
            3 to "这间屋子我记得。不记得怎么记得。"
        )
    )

    /** Arrival response for [callsign] on [loop], falling back to the loop 1 line. */
    internal fun arrivalResponseFor(callsign: String, loop: Int): String? {
        val byLoop = arrivalResponses[callsign] ?: return null
        return byLoop[loop] ?: byLoop[1]
    }

    fun onPilotRecruited(state: HangarState, pilotCallsign: String) {
        // Skip TB-26 intros during corruption (TB-26 is gone)
        if (StoryStateManager.isCorrupted(state.persistence)) return

        val tbName = if (StoryStateManager.isAstroLoop(state.persistence)) "TOBAR" else "TB-26"
        val tb26Intros = mapOf(
            "RASCAL" to "新来的。看好你的东西。",
            "BRUTUS" to "一头熊刚进来。我不问。",
            "FROST" to "温度掉了。准是新飞行员。",
            "DASH" to "有东西从我身边跑过去了。两次。",
            "EMBER" to "这儿热起来了。新来的。",
            "FANG" to "新飞行员倒挂着。更怪的我也见过。",
            "KRAKEN" to "八只手。还是够不到顶层。",
            "WHISKERS" to "一只猫。在酒吧。标准变了。",
            "UNIT-7" to "一个机器人点了酒。我上了……点东西。",
            "HAVOC" to "新飞行员一坐就弄坏了凳子。有前途。",
            "ASTRO" to "..."
        )
        val lines = mutableListOf<ChatMessage>()
        val intro = tb26Intros[pilotCallsign] ?: "新船员。"
        lines.add(ChatMessage(tbName, intro, 0xFF88AACC.toInt()))
        // The arrival answers TB — announcement then response, one beat apart.
        arrivalResponseFor(pilotCallsign, state.persistence.getStoryLoop())?.let { response ->
            val pilot = PilotDefinitions.pilots.find { it.callsign == pilotCallsign }
            if (pilot != null) lines.add(ChatMessage(pilot.callsign, response, pilot.color))
        }
        // Rascal rigs the slot machine in NG+
        if (pilotCallsign == "RASCAL" && StoryStateManager.hasLoopedBefore(state.persistence)) {
            val rascalColor = PilotDefinitions.getPilot("pilot_rascal")?.color
                ?: 0xFFCCCCCC.toInt()
            lines.add(ChatMessage("RASCAL", "就当老虎机……有人照看了。", rascalColor))
        }
        appendOrQueue(state, lines)
    }

    private fun formatTime(seconds: Float): String {
        val totalSec = seconds.toInt()
        val m = totalSec / 60
        val s = totalSec % 60
        return "%d:%02d".format(m, s)
    }

    fun onDeathReturn(state: HangarState, pilotId: String, yenEarned: Int = 0) {
        state.chatMessages.clear()
        state.activeConversation = null
        state.conversationLineIndex = 0
        // Short pause so greeting is visible before conversations resume
        state.conversationCooldown = 3f
        // Dropping the in-flight burst above also drops its claim on the tail; the branches
        // below re-set it when they queue. Without this, a return that queues nothing would
        // hand the short tail to whatever conversation happens to end next.
        state.conversationEndCooldown = CONVERSATION_COOLDOWN
        state.chatTimer = 0f

        // Every branch BUILDS its lines and hands them to the conversation machinery
        // (queueDeathReturnLines) instead of dumping them into the chat in one frame —
        // return chatter flows one line at a time, like any other bar conversation.
        val lines = mutableListOf<ChatMessage>()

        if (StoryStateManager.isAstroLoop(state.persistence)) {
            // Post-reckoning bar chatter — one-shot, fires once on the return after winning the fight.
            // Checked before the lastRun guard so the post-win return always gets this reckoning
            // chatter instead of falling through to the generic survived-time report below.
            if (state.persistence.isReckoningJustWon()) {
                state.persistence.setReckoningJustWon(false)
                queueReckoningChatter(state, CrystalFightLines.barChatter)
                return
            }

            val lastRun = state.persistence.getLastAstroRunSeconds()
            // First entry (no completed run yet): the bare "Welcome back." from
            // pendingTbWelcome stands alone — emit no survived-time report.
            if (lastRun <= 0f) return
            val best = state.persistence.getAstroLoopBestSeconds()
            val lastRunFormatted = formatTime(lastRun)
            val bestFormatted = formatTime(best)
            val isNewBest = lastRun >= best - 0.1f

            // One line either way, and "You survived for" stays on both — two phrasings for one
            // report would read as two different messages. That is what holds the time reactions
            // to eight characters: the stem is long and the figure grows with the run.
            when {
                isNewBest -> lines.add(ChatMessage("TOBAR",
                    "欢迎回来！你撑了 $lastRunFormatted——新纪录！${newBestTimeReactions.random()}",
                    0xFF88AACC.toInt()))
                else -> lines.add(ChatMessage("TOBAR",
                    "欢迎回来！你撑了 $lastRunFormatted。最好 $bestFormatted。",
                    0xFF88AACC.toInt()))
            }
            addBandanaCeremony(state, lines)
            queueDeathReturnLines(state, lines)
            return
        }

        if (StoryStateManager.isCorrupted(state.persistence)) {
            val deadPilots = state.persistence.getDeadPilots()
            val mourned = state.persistence.getPilotsMourned()
            val newlyDead = deadPilots - mourned

            val survivors = PilotDefinitions.pilots.filter { pilot ->
                pilot.id != "pilot_astro" &&
                !deadPilots.contains(pilot.id) &&
                state.isPilotUnlocked(PilotDefinitions.pilots.indexOf(pilot))
            }
            // Named death lines — one per newly dead pilot
            for (deadPilotId in newlyDead) {
                val line = LoopDefinitions.namedDeathLines[deadPilotId] ?: continue
                val speaker = survivors.randomOrNull() ?: continue
                lines.add(ChatMessage(speaker.callsign, line, StoryStateManager.corruptColor(speaker.color)))
                state.persistence.addPilotMourned(deadPilotId)
            }

            // Attrition stage line
            val stageLines = LoopDefinitions.attritionStageLines(survivors.size)
            if (stageLines.isNotEmpty()) {
                val speaker = survivors.randomOrNull()
                if (speaker != null) {
                    lines.add(ChatMessage(speaker.callsign, stageLines.random(), StoryStateManager.corruptColor(speaker.color)))
                }
            }
            queueDeathReturnLines(state, lines)
            return
        }

        // Declared below the corruption branch on purpose: TB-26 is dead there and the crew speak
        // for themselves, so the name he would be greeted under is not even in scope. Astro Loop
        // returns further up, so by here this is always "TB-26" — kept as an expression only
        // because onFirstLaunch and the hint paths share the same convention.
        val tbName = if (StoryStateManager.isAstroLoop(state.persistence)) "TOBAR" else "TB-26"

        // Onboarding owes a beat on the first two returns. Resolved up here because the yen report
        // stands aside for it: those returns already run three TB-26 lines and MEDIC answering the
        // empty air, and two more lines of takings on top bury the thing being taught. Reporting
        // starts on the third return, when onboarding is done. Keyed off the beat rather than a
        // return count so the two can never drift apart.
        val tutorial = TutorialDefinitions.beatFor(state.persistence.getTutorialsShown())

        // TB-26 greeting — always first, and it carries the run report rather than the report
        // taking a beat of its own. Astro Loop does the same with survived time one branch up.
        val previousBestYen = state.persistence.getBestRunYen()
        // A run that took nothing has nothing to report, and "Best is still ¥0" is noise. Guarding
        // here also keeps a blank run from being recorded as a best. Note the best IS still
        // recorded on a silent onboarding return — the player earned it and the HUD showed it, so
        // the first report must not quote a figure smaller than a tutorial run already took.
        val isNewBestYen = yenEarned > 0 && state.persistence.updateBestRunYen(yenEarned)
        val takings = GameConfig.formatYen(yenEarned)
        when {
            tutorial != null || yenEarned <= 0 ->
                lines.add(ChatMessage(tbName, "欢迎回来，指挥官。", 0xFF88AACC.toInt()))
            // One line either way, greeting included. The greeting stays on a record run because
            // "Welcome back, commander." is TB-26's, and the player's best run is the last return
            // that should go ungreeted; that is what keeps the reaction pool terse.
            isNewBestYen -> lines.add(ChatMessage(tbName,
                "欢迎回来，指挥官。$takings——新纪录！${newBestYenReactions.random()}",
                0xFF88AACC.toInt()))
            else -> lines.add(ChatMessage(tbName,
                "欢迎回来，指挥官。$takings。最好 ${GameConfig.formatYen(previousBestYen)}。",
                0xFF88AACC.toInt()))
        }

        // Onboarding, on the first two returns only. Sits directly after the greeting, and its
        // reaction REPLACES the deja vu line below rather than stacking on top of it.
        if (tutorial != null) {
            state.persistence.incrementTutorialsShown()
            for (line in tutorial.tbLines) {
                lines.add(ChatMessage(tbName, line, 0xFF88AACC.toInt()))
            }
            // MEDIC answers the empty air TB-26 is apparently talking to. She is the only pilot
            // unlocked this early, so she is both the returning pilot and the reaction.
            val medic = PilotDefinitions.pilots.find { it.id == "pilot_medic" }
            if (medic != null) {
                lines.add(ChatMessage(medic.callsign, tutorial.reaction, medic.color))
            }
            queueDeathReturnLines(state, lines)
            return
        }

        // A hint owed from a failed ten-minute boss attempt, spent here. Checked after onboarding
        // so a player good enough to reach the boss early still gets taught first — the hint stays
        // pending and lands on the next return instead of being lost.
        val hintTrack = state.persistence.getPendingBossHint()
        if (hintTrack != null) {
            val hint = BossHintDefinitions.hintFor(hintTrack, state.persistence.getBossFailures(hintTrack))
            if (hint != null) {
                state.persistence.setPendingBossHint(null)
                lines.add(ChatMessage(tbName, hint, 0xFF88AACC.toInt()))
                // Same fourth-wall cost as onboarding: whoever came back notices him addressing
                // someone who is not in the room, and their reaction stands in for the deja vu line.
                val returning = PilotDefinitions.pilots.find { it.id == pilotId }
                if (returning != null) {
                    lines.add(
                        ChatMessage(
                            returning.callsign,
                            BossHintDefinitions.reactionFor(returning.callsign),
                            returning.color
                        )
                    )
                }
                queueDeathReturnLines(state, lines)
                return
            }
        }

        // Dead pilot's deja vu line
        val dejaVu = dejaVuLines[pilotId]
        if (dejaVu != null) {
            val pilot = PilotDefinitions.pilots.find { it.id == pilotId }
            if (pilot != null) {
                val displayDejaVu = if (StoryStateManager.isAstroLoop(state.persistence)) dejaVu.replace("TB-26", "托巴") else dejaVu
                lines.add(ChatMessage(pilot.callsign, displayDejaVu, pilot.color))
            }
        }
        queueDeathReturnLines(state, lines)
    }

    /**
     * The bar reacting to a won reckoning, delivered the moment the player is in the room.
     *
     * The flag this drains ([PersistenceManager.isReckoningJustWon]) used to be consumed only
     * by [onDeathReturn], which is the return from a FLIGHT — so beating the crystal and
     * walking straight back to the bar got nothing, and the payoff for the game's most hidden
     * ending waited behind an unrelated death. That gate made sense when the finale was a run;
     * at the cabinet it is not a run, and there is no return for it to ride.
     *
     * [onDeathReturn] still drains it as well, and deliberately: a player who wins and then
     * flies without ever crossing the bar page must not lose the one-shot. Whichever gets
     * there first clears the flag, so it can never play twice.
     */
    fun onReckoningWon(state: HangarState) {
        queueReckoningChatter(state, CrystalFightLines.barChatter)
    }

    /**
     * Build and queue a reckoning one-shot: TOBAR in bar blue, crew in their pilot color.
     * Both the win and loss returns are the same shape — only the script differs.
     */
    private fun queueReckoningChatter(state: HangarState, script: List<Pair<String, String>>) {
        val tobarColor = 0xFF88AACC.toInt()
        queueDeathReturnLines(state, script.map { (speaker, line) ->
            val color = if (speaker == "TOBAR") tobarColor
                        else PilotDefinitions.getPilot("pilot_${speaker.lowercase()}")?.color ?: tobarColor
            ChatMessage(speaker, line, color)
        })
    }

    /**
     * Deliver a death-return burst through the existing conversation machinery: update()
     * emits one line per LINE_PAUSE, and idle chatter/hints are already gated on
     * activeConversation == null, so they hold off until the burst finishes.
     */
    private fun queueDeathReturnLines(state: HangarState, lines: List<ChatMessage>) {
        if (lines.isEmpty()) return
        state.activeConversation = lines
        state.conversationLineIndex = 0
        state.conversationLineTimer = DEATH_RETURN_FIRST_LINE_DELAY
        state.conversationEndCooldown = SCRIPTED_BURST_TAIL_COOLDOWN
    }

    /**
     * Append [lines] to the burst already being delivered, or start a new one.
     *
     * Recruitment resolves in the SAME frame as the post-run return — addYenFromRun()
     * calls onDeathReturn() and then checkPilotRecruitment() — so writing an arrival
     * line straight into the chat jumped the queue and landed it a full
     * DEATH_RETURN_FIRST_LINE_DELAY ahead of TB's "Welcome back, commander."
     * Appending keeps the greeting first and the arrival where it belongs.
     */
    private fun appendOrQueue(state: HangarState, lines: List<ChatMessage>) {
        if (lines.isEmpty()) return
        val active = state.activeConversation
        if (active == null) {
            queueDeathReturnLines(state, lines)
            return
        }
        // update() walks the list by index, so appending past the cursor never disturbs
        // lines already shown or the one currently in flight.
        state.activeConversation = active + lines
        state.conversationEndCooldown = SCRIPTED_BURST_TAIL_COOLDOWN
    }

    /** Builds the ceremony lines into [into] (delivered line-by-line by the caller's queue). */
    private fun addBandanaCeremony(state: HangarState, into: MutableList<ChatMessage>) {
        val pilotId = state.persistence.getPendingBandanaPilot() ?: return
        into.add(ChatMessage("TOBAR", LoopDefinitions.tobarBandanaFraming.random(), 0xFF88AACC.toInt()))
        val pilot = PilotDefinitions.getPilot(pilotId)
        val reply = LoopDefinitions.bandanaAwardReplies[pilotId]
        if (pilot != null && reply != null) {
            into.add(ChatMessage(pilot.callsign, reply, pilot.color))
        }
        state.persistence.clearPendingBandanaPilot()
    }

    /**
     * The first-launch nudge toward the launchpad, if the player has not moved.
     *
     * A new player is dropped on the bar page with the intro cinematic running, and at that
     * moment nothing on screen says the hangar has other rooms: `HangarRenderer` hides the
     * whole HUD-chrome branch (the `[CREW] [LAUNCH] [SHOP]` nav is inside it), that nav's tap
     * targets are separately gated on `!introCinematic`, and rooms tile at exactly
     * `screenWidth` below sw600dp so no part of the next one bleeds in. Real players stopped
     * here and never found the swipe.
     *
     * **The break is the LISTENER, not the gesture — decision, owner 2026-08-31.** TB-26
     * gives directions any pilot in the room could follow; what Medic cannot parse is who he
     * is giving them to. The alternative was to have him name the gesture itself, which would
     * have taught the swipe outright; it was turned down for this, so the beat says *where*
     * and deliberately never says *how*. If players still stall on the bar, the next thing
     * to reach for is putting the page navigation on the intro's bar page; that was weighed
     * and turned down as too heavy for a first-launch beat.
     *
     * Medic is not merely the natural witness — at first launch she is the only pilot in the
     * room, so she is the only one who CAN react — and somebody always must. TB-26 is the
     * only character who may address the player directly, and the crew have to notice.
     *
     * Fired once, by the host, and never re-armed. See `HangarSurfaceView.updateBrowsing`.
     */
    fun onIntroSwipeHint(state: HangarState) {
        val tbName = if (StoryStateManager.isAstroLoop(state.persistence)) "TOBAR" else "TB-26"
        val tbColor = 0xFF88AACC.toInt()
        val medic = PilotDefinitions.pilots.find { it.id == "pilot_medic" } ?: return
        queueDeathReturnLines(state, listOf(
            ChatMessage(tbName, "发射台在隔壁，指挥官。准备好了就去。", tbColor),
            ChatMessage(medic.callsign, "指挥官？TB，那儿没人。", medic.color),
            ChatMessage(tbName, "有的。在隔壁。准备好了就去。", tbColor)
        ))
    }

    fun onFirstLaunch(state: HangarState) {
        // Fresh-install greeting (TB-26 + Medic volunteering over an empty roster) makes no
        // sense in the post-reveal Tobar bar. Legitimate flows can't get here in astro-loop
        // mode — both callers' flags are cleared alongside it — but broken saves and debug
        // toggles have proven such states reach production, so guard explicitly.
        if (StoryStateManager.isAstroLoop(state.persistence)) return

        // TB-26 greeting — appears immediately
        state.addChatMessage("TB-26", "欢迎回来，指挥官。", 0xFF88AACC.toInt())

        // Medic volunteers — delayed 2 seconds via conversation queue
        val medic = PilotDefinitions.pilots.find { it.id == "pilot_medic" }
        if (medic != null) {
            state.activeConversation = listOf(
                ChatMessage(medic.callsign, "没有飞行员？我是医官，不是战斗员……行吧。", medic.color)
            )
            state.conversationLineIndex = 0
            state.conversationLineTimer = 2f
        }
    }

    fun onAstroLoopFirstEntry(state: HangarState) {
        val convo = BarConversations.getShieldDiscoveryConversation() ?: return
        state.activeConversation = convo.lines
        state.conversationLineIndex = 0
        state.conversationLineTimer = 1f
        state.persistence.setAstroLoopShieldConvoShown()
    }
}
