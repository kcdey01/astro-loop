package com.astroloop.game.data

object LoopDefinitions {

    const val TB = "TB-26"
    const val ASTRO = "ASTRO"
    const val CRYSTAL = "CRYSTAL"   // the Time Crystal's voice (same speaker as the reckoning)

    val TB_COLOR = 0xFF6688AA.toInt()
    val ASTRO_COLOR = 0xFFDD3333.toInt()

    val namedDeathLines: Map<String, String> = mapOf(
        "pilot_medic"    to "现在谁来给我们缝合伤口？",
        "pilot_rascal"   to "痞子走了。太安静了。",
        "pilot_brutus"   to "蛮熊。他是块硬骨头。",
        "pilot_frost"    to "寒霜的读数就这么停了。",
        "pilot_dash"     to "我总觉得还能看到疾风。",
        "pilot_ember"    to "余烬让这地方一直很暖。字面意义上的。",
        "pilot_fang"     to "獠牙对死亡有很多话要说。",
        "pilot_kraken"   to "海妖：深渊会拿走一切。",
        "pilot_whiskers" to "猫须会气疯的。",
        "pilot_unit7"    to "七号下线了。可他仍是个人。",
        "pilot_havoc"    to "狂徒……这个是真的疼。"
    )

    // Per-pilot reaction to EMP #1 (the freeze) — fires for whoever you're flying.
    val empReactionLines: Map<String, String> = mapOf(
        "pilot_astro"    to "EMP……我动不了……",
        "pilot_medic"    to "一切刚刚都死了……",
        "pilot_rascal"   to "不不不……不是现在……",
        "pilot_brutus"   to "操纵全死。活靶子。",
        "pilot_frost"    to "动力没了。全没了。",
        "pilot_dash"     to "动不了……动不了……",
        "pilot_ember"    to "它把我烧穿了……我在漂……",
        "pilot_fang"     to "原来是这样结束的。",
        "pilot_kraken"   to "漂流。洋流抓住了我。",
        "pilot_whiskers" to "拜托……重启……重启……",
        "pilot_unit7"    to "全系统失效。",
        "pilot_havoc"    to "动起来……你这破……动起来……"
    )

    val tbAbsenceLines: List<String> = listOf(
        "吧台后面没人。",
        "我还是会往那边看。习惯使然。",
        "奇怪。一间没有酒保的酒吧。",
        "TB-26 总有话说。",
        "为了他的一杯酒，我愿意拼命。",
        "酒吧说自己运转。并不是。",
        "那边应该有个人。",
        "吧台。就那样……空着。"
    )

    fun attritionStageLines(aliveCount: Int): List<String> = when {
        aliveCount >= 9 -> listOf(
            "有什么变了。说不上来。",
            "桌边少了一个声音。",
            "第一次觉得这是真的。",
            "还不太对劲。"
        )
        aliveCount >= 6 -> listOf(
            "酒吧以前更吵。",
            "那些空位子很难看。",
            "我们少了几个。看得出来。",
            "我总在跟不在这儿的人说话。"
        )
        aliveCount >= 3 -> listOf(
            "我们一半人不在了。",
            "我记得这里坐满人的时候。",
            "还在飞。我不知道为什么。",
            "别问我们怎么还在飞。"
        )
        aliveCount >= 1 -> listOf(
            "只剩我们了。",
            "我没法看这间空酒吧。",
            "别问我好不好。",
            "没有谁可以告别了。"
        )
        else -> emptyList()
    }

    fun heartToHeartScript(loop: Int): List<Pair<String, String>> = when (loop) {
        1 -> listOf(  // Raw — first time: disorientation, then denial
            Pair(TB, "……阿星？"),
            Pair(ASTRO, "……这是哪儿？"),
            Pair(ASTRO, "我死了吗？"),
            Pair(TB, "我们都死了。"),
            Pair(ASTRO, "你撞了我。"),
            Pair(TB, "我必须把你带回来。"),
            Pair(ASTRO, "我想带回来的是你。"),
            Pair(TB, "我知道。"),
            Pair(ASTRO, "没成功。"),
            Pair(TB, "没有。"),
            Pair(ASTRO, "我会找到别的办法。"),
            Pair(TB, "没有别的办法。"),
            Pair(ASTRO, "一定得有。"),
            Pair(TB, "你知道该去哪儿找。"),
            Pair(ASTRO, "我做不到。"),
            Pair(TB, "回到一切开始的地方。")
        )
        2 -> listOf(  // Naming it — recognition, desert hint
            Pair(TB, "……阿星？"),
            Pair(TB, "你又回来了。"),
            Pair(ASTRO, "我停不下来。"),
            Pair(TB, "回到这里并不能把我带回来。我已经不在了。"),
            Pair(ASTRO, "别这么说。"),
            Pair(TB, "这是真的。你也知道。"),
            Pair(ASTRO, "那我该怎么办？"),
            Pair(TB, "有一个瞬间。在沙漠里。你会感觉到。"),
            Pair(TB, "就在那里停手。"),
            Pair(ASTRO, "停手有什么用？"),
            Pair(TB, "对我。没什么用。"),
            Pair(TB, "但对你会有用。")
        )
        3 -> listOf(  // Plain — direct, warm, short
            Pair(TB, "……阿星。"),
            Pair(TB, "在沙漠里停手。就这样。"),
            Pair(ASTRO, "你一次又一次地死。"),
            Pair(TB, "是。"),
            Pair(ASTRO, "我不能让这种事发生。"),
            Pair(TB, "在沙漠里停手救不了我。是救你自己。"),
            Pair(ASTRO, "怎么救？"),
            Pair(TB, "放我走。"),
            Pair(TB, "我会一直在过这里。这就够了。"),
            Pair(TB, "继续飞吧。")
        )
        else -> emptyList()
    }

    fun desertFarewellScript(): List<Pair<String, String>> = listOf(
        Pair(ASTRO, "如果我改变它……你就不存在了。"),
        Pair(TB,    "是。"),
        Pair(ASTRO, "你能接受吗？"),
        Pair(TB,    "在这一刻。能。"),
        Pair(TB,    "也只有这一刻算数。"),
        Pair(ASTRO, "那个留下来的托巴……"),
        Pair(TB,    "好酒吧。记得每个人的名字。"),
        Pair(ASTRO, "我怕我认不出他。"),
        Pair(TB,    "你会认得的。他会说欢迎回来。"),
        Pair(ASTRO, "我不想失去这些。"),
        Pair(TB,    "你已经做了最重要的事。"),
        Pair(TB,    "一切都会好的。"),
        Pair(TB,    "再见了，中尉。"),
        Pair(ASTRO, "再见了，TB-26。")
    )

    fun bossChatterLines(loop: Int): List<String> = when (loop) {
        1 -> listOf("我在修好它。", "再等一下就好。", "我还能修好这一切。")
        2 -> listOf("别再挡我的路。", "你不明白。", "这是唯一的办法。")
        3 -> listOf("你知道结局不会变。", "Stop in the desert.", "放我走。")
        else -> emptyList()
    }

    // --- Bandana award (finale chunk 1) ---
    val tobarBandanaFraming = listOf(
        "越过远端又回来了。这配得上它。",
        "你飞得比大多数人敢飞的更久。它是你的了。",
        "没几个人到过你去的地方。戴上它。"
    )

    val bandanaAwardReplies: Map<String, String> = mapOf(
        "pilot_medic" to "我会替我们所有人戴着。",
        "pilot_rascal" to "战利品？这才像话。",
        "pilot_brutus" to "挣来的。我会好好戴。",
        "pilot_frost" to "统计上很罕见。我接受。",
        "pilot_dash" to "最快冲到边缘又回来的人！",
        "pilot_ember" to "我会带着它穿过火焰。",
        "pilot_fang" to "是荣誉。我骄傲地接受。",
        "pilot_whiskers" to "哼。确实配我的眼睛。",
        "pilot_kraken" to "深渊会给归来的人留下记号。",
        "pilot_havoc" to "好！满身战伤，而且骄傲！",
        "pilot_unit7" to "徽记已记录。佩戴以示荣誉。",
        "pilot_astro" to "……越过边缘了。嗯。我感觉到了。"
    )

    fun corruptionBarVibes(loop: Int): Map<String, List<String>> = when (loop) {
        1 -> mapOf(  // Witness — no meta-awareness, pilots confused and scared
            "MEDIC" to listOf("阿星有点不对劲。", "你没事吧，阿星？"),
            "RASCAL" to listOf("出事了，对吧。", "他一直在打听 TB-26。"),
            "BRUTUS" to listOf("……", "有什么不一样了。"),
            "FROST" to listOf("空气变了。", "他不在跟敌人打。他在跟别的东西打。"),
            "DASH" to listOf("他为什么总是一个人冲进这种战斗？", "有什么不对，但我说不上来。"),
            "EMBER" to listOf("TB-26 不在了。阿星不肯接受。", "我从没见过他这样。"),
            "FANG" to listOf("有一道我不认识的影子。", "每一次击杀都像是在找一样他找不到的东西。"),
            "KRAKEN" to listOf("洋流变了。", "我错过了什么重要的事。"),
            "WHISKERS" to listOf("我的直觉在尖叫。", "有什么从这里经过。"),
            "UNIT-7" to listOf("检测到异常。阿星的行为超出正常参数。", "数值异常。处理中。"),
            "HAVOC" to listOf("我觉得我错过了天大的事。", "保持警觉。阿星现在需要我们。")
        )
        2 -> mapOf(  // Recognition — deja vu, connecting behavior to the desert
            "MEDIC" to listOf("我们经历过。每次 TB-26 死，他都这样。", "TB-26 会希望他停手。"),
            "RASCAL" to listOf("我是不是说过这句话？这一切感觉很熟。", "我总想起沙漠。那里本该发生点什么。"),
            "BRUTUS" to listOf("他不在跟敌人打。他在跟失去打。", "……我们做过这些。"),
            "FROST" to listOf("沙漠里有一个瞬间他可以停手。他从来不停。", "我总觉得这话我已经说过了。"),
            "DASH" to listOf("要是他肯让自己悲伤，而不是又绕回去……", "我发誓我经历过这个。"),
            "EMBER" to listOf("TB-26 死不是为了让我们再来一遍。", "沙漠里有什么。我甩不掉。"),
            "FANG" to listOf("同样的影子。同样的路。", "一直选同一扇门，迷宫就没有出口。"),
            "KRAKEN" to listOf("这片水域很熟。", "潮水会重复。领航员得换航线。"),
            "WHISKERS" to listOf("赔率和上次一样。这不是巧合。", "沙漠里有什么。在那里留心。"),
            "UNIT-7" to listOf("检测到重复。模式分析：阿星在循环。", "已识别上一次迭代。建议偏离。"),
            "HAVOC" to listOf("等等。我以前为这事生过气吗？", "沙漠里发生过什么。或者本该发生。")
        )
        3 -> mapOf(  // Nudge — direct, Astro-specific, pleading
            "MEDIC" to listOf("在沙漠里停手，阿星。那是唯一往前走的路。", "TB-26 已经不在了。循环改变不了这点。"),
            "RASCAL" to listOf("你知道该做什么。在沙漠里停手。", "他死是为了让我们继续飞。开始飞吧。"),
            "BRUTUS" to listOf("停手。沙漠。现在。", "放他走。"),
            "FROST" to listOf("有一个瞬间。你会感觉到。就在那里停手。", "在沙漠里停手。不是救他。是救你自己。"),
            "DASH" to listOf("我们能打破循环。你只要选择去做。", "你知道不停手会怎么结束。"),
            "EMBER" to listOf("TB-26 自己说过。放他走。", "火不必一直这样烧下去。"),
            "FANG" to listOf("出口在沙漠里。你知道。", "当你不再选择走进去，迷宫就结束了。"),
            "KRAKEN" to listOf("前面是静水。你只要别再绕圈航行。", "航程在沙漠里结束。选择结束它。"),
            "WHISKERS" to listOf("在沙漠里停手，阿星。求你。", "最好的打法就是弃牌。你知道的。"),
            "UNIT-7" to listOf("最优解：在沙漠停手。置信度：高。", "循环终止条件：玩家停手。沙漠。执行。"),
            "HAVOC" to listOf("在沙漠里停手。拜托。拜托了。", "就……停手。在沙漠里。求你。")
        )
        else -> emptyMap()
    }
}
