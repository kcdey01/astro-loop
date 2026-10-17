package com.astroloop.game.data

import com.astroloop.game.hangar.ChatMessage

data class BarConversation(
    val participantIds: List<String>,
    val lines: List<ChatMessage>,
    val requiresArcCompleted: Boolean = false,
    val blockedInAstroLoop: Boolean = false,
    val requiresAstroLoop: Boolean = false
) {
    // Backward-compatible 2-pilot constructor — keeps the 254 existing entries
    // and getShieldDiscoveryConversation()'s named-arg call compiling unchanged.
    constructor(
        pilotAId: String,
        pilotBId: String,
        lines: List<ChatMessage>,
        requiresArcCompleted: Boolean = false,
        blockedInAstroLoop: Boolean = false,
        requiresAstroLoop: Boolean = false
    ) : this(
        listOf(pilotAId, pilotBId), lines,
        requiresArcCompleted, blockedInAstroLoop, requiresAstroLoop
    )
}

object BarConversations {

    private val conversations: List<BarConversation> = listOf(

        // ============================================================
        // === MEDIC + RASCAL ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_rascal", listOf(
            ChatMessage("MEDIC", "痞子，我的绷带怎么塞满通风管了？", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "那是顶级保温材料！里面现在可暖和了。", 0xFFDDAA33.toInt()),
            ChatMessage("MEDIC", "那是无菌的一次性手术用品。", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "「曾经」是无菌的。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_medic", "pilot_rascal", listOf(
            ChatMessage("RASCAL", "医官，我胳膊上这怪疹子是什么？", 0xFFDDAA33.toInt()),
            ChatMessage("MEDIC", "那是油。你一身都是油。", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "那就好。我还以为是大病。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_medic", "pilot_rascal", listOf(
            ChatMessage("MEDIC", "别捡地上的东西吃。", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "辩解一下，那是货架上的。", 0xFFDDAA33.toInt()),
            ChatMessage("MEDIC", "那是贴了标签的医学样本，痞子。", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "……味道还行。", 0xFFDDAA33.toInt())
        )),

        // ============================================================
        // === MEDIC + BRUTUS ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_brutus", listOf(
            ChatMessage("MEDIC", "蛮熊，那伤口得让我处理。", 0xFFFF88AA.toInt()),
            ChatMessage("BRUTUS", "没事。", 0xFF77AA33.toInt()),
            ChatMessage("MEDIC", "你肩膀里卡着弹片。", 0xFFFF88AA.toInt()),
            ChatMessage("BRUTUS", "添点个性。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_medic", "pilot_brutus", listOf(
            ChatMessage("MEDIC", "蛮熊，你上次正经体检是什么时候？", 0xFFFF88AA.toInt()),
            ChatMessage("BRUTUS", "没有过。", 0xFF77AA33.toInt()),
            ChatMessage("MEDIC", "难怪X光片上是那样。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_brutus", listOf(
            ChatMessage("BRUTUS", "医生。", 0xFF77AA33.toInt()),
            ChatMessage("MEDIC", "蛮熊。来看病？", 0xFFFF88AA.toInt()),
            ChatMessage("BRUTUS", "不。喝酒。", 0xFF77AA33.toInt()),
            ChatMessage("MEDIC", "你知道我不是酒保吧？", 0xFFFF88AA.toInt())
        )),

        // ============================================================
        // === MEDIC + FROST ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_frost", listOf(
            ChatMessage("MEDIC", "寒霜，你体温读数低于「活着」。", 0xFFFF88AA.toInt()),
            ChatMessage("FROST", "对哺乳动物而言。但我是企鹅。", 0xFF55BBFF.toInt()),
            ChatMessage("MEDIC", "有道理。继续。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_frost", listOf(
            ChatMessage("FROST", "分析显示你需要睡眠，医生。", 0xFF55BBFF.toInt()),
            ChatMessage("MEDIC", "敢给医生下诊断，胆子不小。", 0xFFFF88AA.toInt()),
            ChatMessage("FROST", "总得有人。你自己不会。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_medic", "pilot_frost", listOf(
            ChatMessage("MEDIC", "你的羽毛老堵医疗舱下水道。", 0xFFFF88AA.toInt()),
            ChatMessage("FROST", "压力大会换羽。不由自主。", 0xFF55BBFF.toInt()),
            ChatMessage("MEDIC", "你刚刚在淡定看书。", 0xFFFF88AA.toInt()),
            ChatMessage("FROST", "一本有压力的书。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === MEDIC + DASH ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_dash", listOf(
            ChatMessage("DASH", "医官！我好像拉伤了什么重要的东西！", 0xFFFFDD22.toInt()),
            ChatMessage("MEDIC", "又？这回干了什么？", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "试试九秒绕机库一圈。", 0xFFFFDD22.toInt()),
            ChatMessage("MEDIC", "行吗？", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_dash", listOf(
            ChatMessage("MEDIC", "疾风，老实待一秒。我摸下脉。", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "很快。信我。", 0xFFFFDD22.toInt()),
            ChatMessage("MEDIC", "我要的是数字，不是感觉。", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "比你高。我能走了？", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_medic", "pilot_dash", listOf(
            ChatMessage("DASH", "咖啡因严格算药吗？", 0xFFFFDD22.toInt()),
            ChatMessage("MEDIC", "照你这个用法不算。", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "那我加倍剂量呢？", 0xFFFFDD22.toInt())
        )),

        // ============================================================
        // === MEDIC + EMBER ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_ember", listOf(
            ChatMessage("MEDIC", "三度烧伤不是性格标签。", 0xFFFF88AA.toInt()),
            ChatMessage("EMBER", "够虔诚的话，它就是。", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "照这样，烫伤膏要见底了。", 0xFFFF88AA.toInt()),
            ChatMessage("EMBER", "火焰需要献祭。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_medic", "pilot_ember", listOf(
            ChatMessage("EMBER", "痛，不过是火在考你的意志。", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "痛是你的身体在礼貌地喊停。", 0xFFFF88AA.toInt()),
            ChatMessage("EMBER", "我的身体说：烧得再亮些。", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "你的身体说错了。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_ember", listOf(
            ChatMessage("MEDIC", "余烬，别自己烧灼伤口了。", 0xFFFF88AA.toInt()),
            ChatMessage("EMBER", "效率高！", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "是吓人。", 0xFFFF88AA.toInt())
        )),

        // ============================================================
        // === MEDIC + FANG ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_fang", listOf(
            ChatMessage("FANG", "隔一屋子我都能听见你心跳。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "这……医学上讲，挺厉害。", 0xFFFF88AA.toInt()),
            ChatMessage("FANG", "我一说话它就快。有意思。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "那叫不适，獠牙。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_fang", listOf(
            ChatMessage("MEDIC", "獠牙，你上次吃正常东西是什么时候？", 0xFFFF88AA.toInt()),
            ChatMessage("FANG", "定义正常。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "不是还带血的那种，獠牙。", 0xFFFF88AA.toInt()),
            ChatMessage("FANG", "我考虑考虑。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_medic", "pilot_fang", listOf(
            ChatMessage("FANG", "你身上总是消毒水味。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "你身上像山洞。", 0xFFFF88AA.toInt()),
            ChatMessage("FANG", "谢谢。", 0xFF8844CC.toInt())
        )),

        // ============================================================
        // === MEDIC + WHISKERS ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_whiskers", listOf(
            ChatMessage("MEDIC", "猫须，你错过年度体检了。", 0xFFFF88AA.toInt()),
            ChatMessage("WHISKERS", "没错过。是无视了。", 0xFFFFBB88.toInt()),
            ChatMessage("MEDIC", "那更糟。", 0xFFFF88AA.toInt()),
            ChatMessage("WHISKERS", "对你来说吧。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_medic", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "我有毛球。处理一下。", 0xFFFFBB88.toInt()),
            ChatMessage("MEDIC", "这不算我的专业。", 0xFFFF88AA.toInt()),
            ChatMessage("WHISKERS", "医生就该医。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_medic", "pilot_whiskers", listOf(
            ChatMessage("MEDIC", "你的反射测试爆表了。", 0xFFFF88AA.toInt()),
            ChatMessage("WHISKERS", "当然。", 0xFFFFBB88.toInt()),
            ChatMessage("MEDIC", "不是夸你。你把护士抓了。", 0xFFFF88AA.toInt()),
            ChatMessage("WHISKERS", "她摸我肚子。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === MEDIC + KRAKEN ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_kraken", listOf(
            ChatMessage("MEDIC", "海妖，我要抽点血。", 0xFFFF88AA.toInt()),
            ChatMessage("KRAKEN", "哪只手臂？", 0xFF33AAAA.toInt()),
            ChatMessage("MEDIC", "八只都行，谢谢。", 0xFFFF88AA.toInt()),
            ChatMessage("KRAKEN", "选仔细。有几只会咬人。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "身体是容器。心是海。", 0xFF33AAAA.toInt()),
            ChatMessage("MEDIC", "身体里全是我反复修的零件。", 0xFFFF88AA.toInt()),
            ChatMessage("KRAKEN", "务实。新鲜。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_kraken", listOf(
            ChatMessage("MEDIC", "你的血压又崩了我第二个袖带。", 0xFFFF88AA.toInt()),
            ChatMessage("KRAKEN", "我有三颗心。", 0xFF33AAAA.toInt()),
            ChatMessage("MEDIC", "难怪图表那样。", 0xFFFF88AA.toInt()),
            ChatMessage("KRAKEN", "还有我的深情。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === MEDIC + HAVOC ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "医官！我受伤了！开玩笑的。看这淤青。", 0xFFBBFF22.toInt()),
            ChatMessage("MEDIC", "这是重度挫伤。怎么弄的？", 0xFFFF88AA.toInt()),
            ChatMessage("HAVOC", "拿头撞舱壁。主要图个乐。", 0xFFBBFF22.toInt()),
            ChatMessage("MEDIC", "我要开始加价了。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_havoc", listOf(
            ChatMessage("MEDIC", "你这周来了七趟医疗舱。", 0xFFFF88AA.toInt()),
            ChatMessage("HAVOC", "新纪录！爽！", 0xFFBBFF22.toInt()),
            ChatMessage("MEDIC", "这不值得庆祝。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "你见过最重的伤是什么？", 0xFFBBFF22.toInt()),
            ChatMessage("MEDIC", "正看着呢。", 0xFFFF88AA.toInt()),
            ChatMessage("HAVOC", "AWESOME!", 0xFFBBFF22.toInt()),
            ChatMessage("MEDIC", "这也不是夸你。", 0xFFFF88AA.toInt())
        )),

        // ============================================================
        // === MEDIC + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "查询：有机体为何需要睡眠？", 0xFF44EE55.toInt()),
            ChatMessage("MEDIC", "大脑需要停机来处理这一天。", 0xFFFF88AA.toInt()),
            ChatMessage("UNIT-7", "低效。我碎片整理用0.3秒。", 0xFF44EE55.toInt()),
            ChatMessage("MEDIC", "真好啊。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_unit7", listOf(
            ChatMessage("MEDIC", "七号，我没法给你体检。你是金属。", 0xFFFF88AA.toInt()),
            ChatMessage("UNIT-7", "请求：对底盘完整性执行诊断。", 0xFF44EE55.toInt()),
            ChatMessage("MEDIC", "那是工程，不是医学。", 0xFFFF88AA.toInt()),
            ChatMessage("UNIT-7", "该区分不明确。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_medic", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "门开时你心率上升12%。", 0xFF44EE55.toInt()),
            ChatMessage("MEDIC", "那是——我在，呃，锻炼。", 0xFFFF88AA.toInt()),
            ChatMessage("UNIT-7", "你坐着。", 0xFF44EE55.toInt())
        )),

        // ============================================================
        // === MEDIC + ASTRO (subtle flirtation) ===
        // ============================================================
        BarConversation("pilot_medic", "pilot_astro", listOf(
            ChatMessage("MEDIC", "改天让我查查你的生命体征。", 0xFFFF88AA.toInt()),
            ChatMessage("ASTRO", "这纯属医疗建议？", 0xFFDD3333.toInt()),
            ChatMessage("MEDIC", "纯属专业。大部分。", 0xFFFF88AA.toInt()),
            ChatMessage("ASTRO", "我，呃……我记本子上了。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_medic", "pilot_astro", listOf(
            ChatMessage("ASTRO", "那身新飞行服挺衬你。", 0xFFDD3333.toInt()),
            ChatMessage("MEDIC", "这只是医疗服，阿星。", 0xFFFF88AA.toInt()),
            ChatMessage("ASTRO", "还是好看。", 0xFFDD3333.toInt()),
            ChatMessage("MEDIC", "……谢谢。闭嘴。", 0xFFFF88AA.toInt())
        )),
        BarConversation("pilot_medic", "pilot_astro", listOf(
            ChatMessage("MEDIC", "你在外面挨了打。坐下，我看看。", 0xFFFF88AA.toInt()),
            ChatMessage("ASTRO", "就是擦伤。", 0xFFDD3333.toInt()),
            ChatMessage("MEDIC", "算不算擦伤我说了算。别动。", 0xFFFF88AA.toInt()),
            ChatMessage("ASTRO", "听你的。", 0xFFDD3333.toInt())
        )),

        // ============================================================
        // === RASCAL + BRUTUS ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_brutus", listOf(
            ChatMessage("BRUTUS", "我扳手呢。", 0xFF77AA33.toInt()),
            ChatMessage("RASCAL", "不知道！太奇怪了！我先走了！", 0xFFDDAA33.toInt()),
            ChatMessage("BRUTUS", "痞子。", 0xFF77AA33.toInt()),
            ChatMessage("RASCAL", "……在箱子后面。别打我。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_brutus", listOf(
            ChatMessage("RASCAL", "蛮熊，这半个三明治要吗？", 0xFFDDAA33.toInt()),
            ChatMessage("BRUTUS", "谁的三明治。", 0xFF77AA33.toInt()),
            ChatMessage("RASCAL", "有区别吗？", 0xFFDDAA33.toInt()),
            ChatMessage("BRUTUS", "……拿来。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_brutus", listOf(
            ChatMessage("RASCAL", "你好大。像座毛茸茸的暖山。", 0xFFDDAA33.toInt()),
            ChatMessage("BRUTUS", "别摸。", 0xFF77AA33.toInt()),
            ChatMessage("RASCAL", "不过我猜你毛一定特别软。", 0xFFDDAA33.toInt())
        )),

        // ============================================================
        // === RASCAL + FROST ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_frost", listOf(
            ChatMessage("RASCAL", "寒霜，你柜子里藏了什么？", 0xFFDDAA33.toInt()),
            ChatMessage("FROST", "一把锁。你已经撬过两次。", 0xFF55BBFF.toInt()),
            ChatMessage("RASCAL", "第三次准成！", 0xFFDDAA33.toInt()),
            ChatMessage("FROST", "我装了低温陷阱。祝你好运。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_frost", listOf(
            ChatMessage("FROST", "你把我的鱼全吃了，痞子。", 0xFF55BBFF.toInt()),
            ChatMessage("RASCAL", "太香了，忍不住。", 0xFFDDAA33.toInt()),
            ChatMessage("FROST", "那是用来校准的速冻沙丁鱼。", 0xFF55BBFF.toInt()),
            ChatMessage("RASCAL", "校准沙丁鱼最好吃。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_frost", listOf(
            ChatMessage("RASCAL", "你从不发火。有点瘆人。", 0xFFDDAA33.toInt()),
            ChatMessage("FROST", "我会变冷。比平时更冷。", 0xFF55BBFF.toInt()),
            ChatMessage("RASCAL", "这是威胁？", 0xFFDDAA33.toInt()),
            ChatMessage("FROST", "这是预报。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === RASCAL + DASH ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_dash", listOf(
            ChatMessage("RASCAL", "赌我能在你眨眼前偷走你的徽章。", 0xFFDDAA33.toInt()),
            ChatMessage("DASH", "赌你没跑我就抓住你。", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "赌了。", 0xFFDDAA33.toInt()),
            ChatMessage("DASH", "已经拿回来了。你太慢。", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_dash", listOf(
            ChatMessage("DASH", "痞子！来跟我绕机库跑一圈！", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "我不赛跑。我潜行。", 0xFFDDAA33.toInt()),
            ChatMessage("DASH", "潜行就是慢速赛跑。", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "赛跑就是大声潜行。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_dash", listOf(
            ChatMessage("RASCAL", "慢点行吗？我头晕。", 0xFFDDAA33.toInt()),
            ChatMessage("DASH", "你什么时候不晕。", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "那是通风管的味儿。", 0xFFDDAA33.toInt())
        )),

        // ============================================================
        // === RASCAL + EMBER ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_ember", listOf(
            ChatMessage("RASCAL", "余烬！你尾巴把我整批货烤了！", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "别把东西藏在凤凰旁边。", 0xFFFF6622.toInt()),
            ChatMessage("RASCAL", "里面有上好的饼干！", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "现在是面包丁了。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_ember", listOf(
            ChatMessage("EMBER", "自灰烬中，我们重生而起。", 0xFFFF6622.toInt()),
            ChatMessage("RASCAL", "自垃圾箱中，我崛起。", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "那……不是一回事。", 0xFFFF6622.toInt()),
            ChatMessage("RASCAL", "气势一样。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_ember", listOf(
            ChatMessage("RASCAL", "能帮我热下这卷饼吗？", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "我不是微波炉。", 0xFFFF6622.toInt()),
            ChatMessage("RASCAL", "求你了？", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "……拿来。", 0xFFFF6622.toInt())
        )),

        // ============================================================
        // === RASCAL + FANG ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_fang", listOf(
            ChatMessage("FANG", "黑里我看你清清楚楚，痞子。", 0xFF8844CC.toInt()),
            ChatMessage("RASCAL", "这是作弊！", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "这叫回声定位，小贼。", 0xFF8844CC.toInt()),
            ChatMessage("RASCAL", "我叫它不公平。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_fang", listOf(
            ChatMessage("RASCAL", "獠牙，醒着？", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "凌晨三点。当然清醒。", 0xFF8844CC.toInt()),
            ChatMessage("RASCAL", "跟我去抢储藏室？", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "……带路。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_fang", listOf(
            ChatMessage("RASCAL", "你怎么老这么倒挂着？", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "视角更好。", 0xFF8844CC.toInt()),
            ChatMessage("RASCAL", "看什么？", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "看你想偷的一切。", 0xFF8844CC.toInt())
        )),

        // ============================================================
        // === RASCAL + WHISKERS ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_whiskers", listOf(
            ChatMessage("RASCAL", "猫须，想玩个游戏吗？", 0xFFDDAA33.toInt()),
            ChatMessage("WHISKERS", "No.", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "我找到一支能用的激光笔！", 0xFFDDAA33.toInt()),
            ChatMessage("WHISKERS", "……在哪。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "你碰了我尾巴。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "太蓬了！我没忍住！", 0xFFDDAA33.toInt()),
            ChatMessage("WHISKERS", "再碰就少根手指。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "值。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_whiskers", listOf(
            ChatMessage("RASCAL", "咱俩都小都鬼祟。该组队。", 0xFFDDAA33.toInt()),
            ChatMessage("WHISKERS", "我不小也不鬼祟。我优雅。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "优雅地鬼祟。", 0xFFDDAA33.toInt()),
            ChatMessage("WHISKERS", "离我远点。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === RASCAL + KRAKEN ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_kraken", listOf(
            ChatMessage("RASCAL", "你用触手怎么扒人钱包？", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "我不扒钱包。我有尊严。", 0xFF33AAAA.toInt()),
            ChatMessage("RASCAL", "但假设一下……", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "假设？八只一起来。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "你让我想到清洁鱼。小。胆大。有用。", 0xFF33AAAA.toInt()),
            ChatMessage("RASCAL", "这是夸我？", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "这是观察。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_kraken", listOf(
            ChatMessage("RASCAL", "海妖，能借我一条触手吗？", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "它们不拆卸。", 0xFF33AAAA.toInt()),
            ChatMessage("RASCAL", "这是认输的话。", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "这是生物学。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === RASCAL + HAVOC ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "痞子！走，炸点什么去！", 0xFFBBFF22.toInt()),
            ChatMessage("RASCAL", "我偏向拿东西，不是砸东西。", 0xFFDDAA33.toInt()),
            ChatMessage("HAVOC", "那把炸药偷了！双赢！", 0xFFBBFF22.toInt()),
            ChatMessage("RASCAL", "……这主意还真不坏。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_havoc", listOf(
            ChatMessage("RASCAL", "你够吵，能盖住我所有退路。", 0xFFDDAA33.toInt()),
            ChatMessage("HAVOC", "我一直很吵！", 0xFFBBFF22.toInt()),
            ChatMessage("RASCAL", "就指望这个。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "七号通风管那点私货我找到了。", 0xFFBBFF22.toInt()),
            ChatMessage("RASCAL", "你什么？！", 0xFFDDAA33.toInt()),
            ChatMessage("HAVOC", "放松放松，我只吃了肉干。", 0xFFBBFF22.toInt()),
            ChatMessage("RASCAL", "那是陈年肉干！", 0xFFDDAA33.toInt())
        )),

        // ============================================================
        // === RASCAL + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_unit7", listOf(
            ChatMessage("RASCAL", "七号，你身上有松螺丝吗？", 0xFFDDAA33.toInt()),
            ChatMessage("UNIT-7", "全部螺丝已按规格上紧。", 0xFF44EE55.toInt()),
            ChatMessage("RASCAL", "可惜。那能卖不少円币。", 0xFFDDAA33.toInt()),
            ChatMessage("UNIT-7", "澄清：你正在尝试盗窃？", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你今日取走14件不属于你的物品。", 0xFF44EE55.toInt()),
            ChatMessage("RASCAL", "才14件？我退步了。", 0xFFDDAA33.toInt()),
            ChatMessage("UNIT-7", "此行为归类为盗窃。", 0xFF44EE55.toInt()),
            ChatMessage("RASCAL", "我更愿意叫「再分配」。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_unit7", listOf(
            ChatMessage("RASCAL", "机器人会做梦吗？", 0xFFDDAA33.toInt()),
            ChatMessage("UNIT-7", "我进入低功耗诊断模式。", 0xFF44EE55.toInt()),
            ChatMessage("RASCAL", "那就是不会。", 0xFFDDAA33.toInt()),
            ChatMessage("UNIT-7", "我做过一次。那是固件错误。", 0xFF44EE55.toInt())
        )),

        // ============================================================
        // === RASCAL + ASTRO ===
        // ============================================================
        BarConversation("pilot_rascal", "pilot_astro", listOf(
            ChatMessage("ASTRO", "痞子。拿了什么，还回去。", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "我什么都没拿！", 0xFFDDAA33.toInt()),
            ChatMessage("ASTRO", "痞子。", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "……在四号通风管。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_astro", listOf(
            ChatMessage("RASCAL", "老大，円币能多分我点吗？", 0xFFDDAA33.toInt()),
            ChatMessage("ASTRO", "你私下拿的已经很不少。", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "我还想要份正式的。", 0xFFDDAA33.toInt())
        )),
        BarConversation("pilot_rascal", "pilot_astro", listOf(
            ChatMessage("ASTRO", "今天飞得不错，痞子。", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "谢老大！我还在你座舱里捡到这个。", 0xFFDDAA33.toInt()),
            ChatMessage("ASTRO", "那是我的酒壶。你偷了我的酒壶。", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "我说了是捡的！", 0xFFDDAA33.toInt())
        )),

        // ============================================================
        // === BRUTUS + FROST ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_frost", listOf(
            ChatMessage("FROST", "你纯粹的作战效率值得敬佩。", 0xFF55BBFF.toInt()),
            ChatMessage("BRUTUS", "打东西。它们会坏。", 0xFF77AA33.toInt()),
            ChatMessage("FROST", "简洁得漂亮。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_frost", listOf(
            ChatMessage("BRUTUS", "冷血。", 0xFF77AA33.toInt()),
            ChatMessage("FROST", "不客气。", 0xFF55BBFF.toInt()),
            ChatMessage("BRUTUS", "不是夸你。", 0xFF77AA33.toInt()),
            ChatMessage("FROST", "不是道歉。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_frost", listOf(
            ChatMessage("FROST", "考虑过战略撤退吗？", 0xFF55BBFF.toInt()),
            ChatMessage("BRUTUS", "No.", 0xFF77AA33.toInt()),
            ChatMessage("FROST", "记下。跳过。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === BRUTUS + DASH ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_dash", listOf(
            ChatMessage("DASH", "蛮熊！蛮熊！来啊，跟我跑！", 0xFFFFDD22.toInt()),
            ChatMessage("BRUTUS", "No.", 0xFF77AA33.toInt()),
            ChatMessage("DASH", "我让你先跑？", 0xFFFFDD22.toInt()),
            ChatMessage("BRUTUS", "还是不。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_dash", listOf(
            ChatMessage("DASH", "你这么慢怎么还能打赢？", 0xFFFFDD22.toInt()),
            ChatMessage("BRUTUS", "不需要快。需要力。", 0xFF77AA33.toInt()),
            ChatMessage("DASH", "这……还挺酷。", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_dash", listOf(
            ChatMessage("DASH", "演习时我套了你五整圈。", 0xFFFFDD22.toInt()),
            ChatMessage("BRUTUS", "我跑完一次。够了。", 0xFF77AA33.toInt()),
            ChatMessage("DASH", "可你不想更快吗？", 0xFFFFDD22.toInt()),
            ChatMessage("BRUTUS", "为什么。", 0xFF77AA33.toInt())
        )),

        // ============================================================
        // === BRUTUS + EMBER ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_ember", listOf(
            ChatMessage("EMBER", "我体内之火，永不熄灭！", 0xFFFF6622.toInt()),
            ChatMessage("BRUTUS", "吵。", 0xFF77AA33.toInt()),
            ChatMessage("EMBER", "艺术需要音量！", 0xFFFF6622.toInt()),
            ChatMessage("BRUTUS", "艺术需要安静。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_ember", listOf(
            ChatMessage("BRUTUS", "你烤了我的毛。", 0xFF77AA33.toInt()),
            ChatMessage("EMBER", "火焰该到之处，必到。", 0xFFFF6622.toInt()),
            ChatMessage("BRUTUS", "下次到了，我把它掰下来。", 0xFF77AA33.toInt()),
            ChatMessage("EMBER", "……我会小心。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_ember", listOf(
            ChatMessage("EMBER", "我们都是自然之力，蛮熊。", 0xFFFF6622.toInt()),
            ChatMessage("BRUTUS", "你话太多。", 0xFF77AA33.toInt()),
            ChatMessage("EMBER", "火以行动说话。", 0xFFFF6622.toInt()),
            ChatMessage("BRUTUS", "好。现在开始。", 0xFF77AA33.toInt())
        )),

        // ============================================================
        // === BRUTUS + FANG ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_fang", listOf(
            ChatMessage("FANG", "你这么大个，动起来真安静。", 0xFF8844CC.toInt()),
            ChatMessage("BRUTUS", "安静好。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "总算有共识。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_fang", listOf(
            ChatMessage("BRUTUS", "别盯。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "我没盯。我在观察。", 0xFF8844CC.toInt()),
            ChatMessage("BRUTUS", "一样。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "从暗处不算。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_fang", listOf(
            ChatMessage("FANG", "一起值夜班？", 0xFF8844CC.toInt()),
            ChatMessage("BRUTUS", "行。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "你话少。我喜欢。", 0xFF8844CC.toInt()),
            ChatMessage("BRUTUS", "哼。", 0xFF77AA33.toInt())
        )),

        // ============================================================
        // === BRUTUS + WHISKERS ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "让开。那是我的位子。", 0xFFFFBB88.toInt()),
            ChatMessage("BRUTUS", "No.", 0xFF77AA33.toInt()),
            ChatMessage("WHISKERS", "我先坐那儿的。", 0xFFFFBB88.toInt()),
            ChatMessage("BRUTUS", "证明。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "你掉毛比我厉害。", 0xFFFFBB88.toInt()),
            ChatMessage("BRUTUS", "熊不掉毛。", 0xFF77AA33.toInt()),
            ChatMessage("WHISKERS", "那我垫子上的毛呢？", 0xFFFFBB88.toInt()),
            ChatMessage("BRUTUS", "...no.", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_whiskers", listOf(
            ChatMessage("BRUTUS", "猫。", 0xFF77AA33.toInt()),
            ChatMessage("WHISKERS", "熊。", 0xFFFFBB88.toInt()),
            ChatMessage("BRUTUS", "哼。", 0xFF77AA33.toInt()),
            ChatMessage("WHISKERS", "确实。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === BRUTUS + KRAKEN ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "有力无智，是无向的风暴。", 0xFF33AAAA.toInt()),
            ChatMessage("BRUTUS", "风暴不需要方向。", 0xFF77AA33.toInt()),
            ChatMessage("KRAKEN", "反驳得有理。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_kraken", listOf(
            ChatMessage("BRUTUS", "掰腕子。", 0xFF77AA33.toInt()),
            ChatMessage("KRAKEN", "哪只手臂？", 0xFF33AAAA.toInt()),
            ChatMessage("BRUTUS", "八只都来。", 0xFF77AA33.toInt()),
            ChatMessage("KRAKEN", "服气。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "深海教会我耐心。", 0xFF33AAAA.toInt()),
            ChatMessage("BRUTUS", "战斗教会我不等。", 0xFF77AA33.toInt()),
            ChatMessage("KRAKEN", "两课都有价值。", 0xFF33AAAA.toInt()),
            ChatMessage("BRUTUS", "我的快。", 0xFF77AA33.toInt())
        )),

        // ============================================================
        // === BRUTUS + HAVOC ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "蛮熊！想看个酷的吗？", 0xFFBBFF22.toInt()),
            ChatMessage("BRUTUS", "No.", 0xFF77AA33.toInt()),
            ChatMessage("HAVOC", "太迟了！", 0xFFBBFF22.toInt()),
            ChatMessage("BRUTUS", "……我讨厌这个。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "蛮熊！击掌！", 0xFFBBFF22.toInt()),
            ChatMessage("BRUTUS", "No.", 0xFF77AA33.toInt()),
            ChatMessage("HAVOC", "来啊！别晾着我！", 0xFFBBFF22.toInt()),
            ChatMessage("BRUTUS", "就晾着你。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "咱练练！全接触！没规则！", 0xFFBBFF22.toInt()),
            ChatMessage("BRUTUS", "你会碎。", 0xFF77AA33.toInt()),
            ChatMessage("HAVOC", "就是这劲头！", 0xFFBBFF22.toInt())
        )),

        // ============================================================
        // === BRUTUS + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "查询：你为何频繁低吼？", 0xFF44EE55.toInt()),
            ChatMessage("BRUTUS", "警告。", 0xFF77AA33.toInt()),
            ChatMessage("UNIT-7", "警告什么？", 0xFF44EE55.toInt()),
            ChatMessage("BRUTUS", "这段对话。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你的骨密度很惊人。", 0xFF44EE55.toInt()),
            ChatMessage("BRUTUS", "别扫我。", 0xFF77AA33.toInt()),
            ChatMessage("UNIT-7", "非自主。你的质量值得注意。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_unit7", listOf(
            ChatMessage("BRUTUS", "铁疙瘩。", 0xFF77AA33.toInt()),
            ChatMessage("UNIT-7", "确认。钛合金。", 0xFF44EE55.toInt()),
            ChatMessage("BRUTUS", "硬？", 0xFF77AA33.toInt()),
            ChatMessage("UNIT-7", "极硬。", 0xFF44EE55.toInt())
        )),

        // ============================================================
        // === BRUTUS + ASTRO ===
        // ============================================================
        BarConversation("pilot_brutus", "pilot_astro", listOf(
            ChatMessage("ASTRO", "外面干得漂亮，蛮熊。", 0xFFDD3333.toInt()),
            ChatMessage("BRUTUS", "哼。", 0xFF77AA33.toInt()),
            ChatMessage("ASTRO", "这算道谢吧？", 0xFFDD3333.toInt()),
            ChatMessage("BRUTUS", "差不多。", 0xFF77AA33.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_astro", listOf(
            ChatMessage("ASTRO", "要点什么，大块头？", 0xFFDD3333.toInt()),
            ChatMessage("BRUTUS", "安静。", 0xFF77AA33.toInt()),
            ChatMessage("ASTRO", "行吧。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_brutus", "pilot_astro", listOf(
            ChatMessage("BRUTUS", "阿星。", 0xFF77AA33.toInt()),
            ChatMessage("ASTRO", "蛮熊。有事？", 0xFFDD3333.toInt()),
            ChatMessage("BRUTUS", "没事。就是看看。", 0xFF77AA33.toInt()),
            ChatMessage("ASTRO", "谢了。", 0xFFDD3333.toInt())
        )),

        // ============================================================
        // === FROST + DASH ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_dash", listOf(
            ChatMessage("DASH", "寒霜！寒霜！猜我圈速！", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "3.7秒。我数着呢。", 0xFF55BBFF.toInt()),
            ChatMessage("DASH", "你怎么知道？！", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "数学。你也试试。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_dash", listOf(
            ChatMessage("FROST", "你转得我头晕。别绕桌子了。", 0xFF55BBFF.toInt()),
            ChatMessage("DASH", "停不下来！惯性！", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "室内不是这么用惯性的。", 0xFF55BBFF.toInt()),
            ChatMessage("DASH", "室内惯性！", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_frost", "pilot_dash", listOf(
            ChatMessage("DASH", "你就从不想快吗？", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "企鹅很快。水下。", 0xFF55BBFF.toInt()),
            ChatMessage("DASH", "那不算！", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "对鱼来说算。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === FROST + EMBER ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_ember", listOf(
            ChatMessage("FROST", "你又在升高环境温度。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "你在降低。正好平衡。", 0xFFFF6622.toInt()),
            ChatMessage("FROST", "热力学不是这样。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "活一把，寒霜。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_frost", "pilot_ember", listOf(
            ChatMessage("EMBER", "冰只是放弃了的火。", 0xFFFF6622.toInt()),
            ChatMessage("FROST", "冰有耐心。火在浪费。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "浪费？！我是光芒万丈！", 0xFFFF6622.toInt()),
            ChatMessage("FROST", "你马上就是室温。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_ember", listOf(
            ChatMessage("FROST", "待在你那半边酒吧，余烬。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "火焰想去哪就去哪。", 0xFFFF6622.toInt()),
            ChatMessage("FROST", "寒霜去火焰后悔的地方。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "...fair.", 0xFFFF6622.toInt())
        )),

        // ============================================================
        // === FROST + FANG ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_fang", listOf(
            ChatMessage("FANG", "又冷又暗。咱俩挺像。", 0xFF8844CC.toInt()),
            ChatMessage("FROST", "我冷。你瘆人。有区别。", 0xFF55BBFF.toInt()),
            ChatMessage("FANG", "瘆人是主观的。", 0xFF8844CC.toInt()),
            ChatMessage("FROST", "客观瘆人。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_fang", listOf(
            ChatMessage("FROST", "南极的夜能连着六个月。", 0xFF55BBFF.toInt()),
            ChatMessage("FANG", "天堂。", 0xFF8844CC.toInt()),
            ChatMessage("FROST", "那其实是在抱怨。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_fang", listOf(
            ChatMessage("FANG", "你血是冷的。", 0xFF8844CC.toInt()),
            ChatMessage("FROST", "严格说是温血。只是保温太好。", 0xFF55BBFF.toInt()),
            ChatMessage("FANG", "我在抒情。", 0xFF8844CC.toInt()),
            ChatMessage("FROST", "我在说准。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === FROST + WHISKERS ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "走路一摇。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "你故意把东西推下桌。", 0xFF55BBFF.toInt()),
            ChatMessage("WHISKERS", "说中了。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_frost", "pilot_whiskers", listOf(
            ChatMessage("FROST", "你的午睡习惯，数据上很惊人。", 0xFF55BBFF.toInt()),
            ChatMessage("WHISKERS", "最少十六小时。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "我是说惊人地浪费。", 0xFF55BBFF.toInt()),
            ChatMessage("WHISKERS", "嫉妒不好看。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_frost", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "鱼腥味嘴。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "你吃的是罐头。", 0xFF55BBFF.toInt()),
            ChatMessage("WHISKERS", "我的是寿司级。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "我的是现捕。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === FROST + KRAKEN ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_kraken", listOf(
            ChatMessage("FROST", "咱俩都水生。也就这点。", 0xFF55BBFF.toInt()),
            ChatMessage("KRAKEN", "海面与深渊，同一片海。", 0xFF33AAAA.toInt()),
            ChatMessage("FROST", "诗意。不准，但诗意。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "冰架下藏着寂静的奇景。", 0xFF33AAAA.toInt()),
            ChatMessage("FROST", "主要藏磷虾。", 0xFF55BBFF.toInt()),
            ChatMessage("KRAKEN", "磷虾就是奇景。", 0xFF33AAAA.toInt()),
            ChatMessage("FROST", "它们是午饭。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_kraken", listOf(
            ChatMessage("FROST", "八条腕，好像多了。", 0xFF55BBFF.toInt()),
            ChatMessage("KRAKEN", "两只鳍，好像太少。", 0xFF33AAAA.toInt()),
            ChatMessage("FROST", "够用。", 0xFF55BBFF.toInt()),
            ChatMessage("KRAKEN", "八条腕也够。还多四倍。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === FROST + HAVOC ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "寒霜！来给我冰下酒！", 0xFFBBFF22.toInt()),
            ChatMessage("FROST", "我不是冰箱。", 0xFF55BBFF.toInt()),
            ChatMessage("HAVOC", "你基本就是冰箱！", 0xFFBBFF22.toInt()),
            ChatMessage("FROST", "你基本就是投诉噪音。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "算计风险太无聊！冲就完了！", 0xFFBBFF22.toInt()),
            ChatMessage("FROST", "不算计风险，你才丢了三艘船。", 0xFF55BBFF.toInt()),
            ChatMessage("HAVOC", "可丢得多壮观！", 0xFFBBFF22.toInt())
        )),
        BarConversation("pilot_frost", "pilot_havoc", listOf(
            ChatMessage("FROST", "你的生还率违背概率。", 0xFF55BBFF.toInt()),
            ChatMessage("HAVOC", "我不信概率！", 0xFFBBFF22.toInt()),
            ChatMessage("FROST", "概率……不是这么运作的。", 0xFF55BBFF.toInt()),
            ChatMessage("HAVOC", "看！已经违背了！", 0xFFBBFF22.toInt())
        )),

        // ============================================================
        // === FROST + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你的核心温度38.2C。最佳。", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "总算有人懂数据。", 0xFF55BBFF.toInt()),
            ChatMessage("UNIT-7", "数据是我唯一欣赏之物。", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "我们该多聊。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_unit7", listOf(
            ChatMessage("FROST", "你的处理速度值得敬佩。", 0xFF55BBFF.toInt()),
            ChatMessage("UNIT-7", "你的分析能力高于有机体均值。", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "这是夸我？", 0xFF55BBFF.toInt()),
            ChatMessage("UNIT-7", "那只是数据点。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_frost", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "查询：企鹅会感到孤独吗？", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "我们是群居动物。喜欢有伴。", 0xFF55BBFF.toInt()),
            ChatMessage("UNIT-7", "那你为何独坐？", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "……下一个问题。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === FROST + ASTRO ===
        // ============================================================
        BarConversation("pilot_frost", "pilot_astro", listOf(
            ChatMessage("FROST", "任务参数似乎不理想。", 0xFF55BBFF.toInt()),
            ChatMessage("ASTRO", "从来都不理想。我们应变。", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "无数据的应变叫瞎猜。", 0xFF55BBFF.toInt()),
            ChatMessage("ASTRO", "我更喜欢叫「直觉」。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_frost", "pilot_astro", listOf(
            ChatMessage("ASTRO", "今晚这杯够冰，是吧？", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "每晚都冷。我喜欢。", 0xFF55BBFF.toInt()),
            ChatMessage("ASTRO", "我说的是啤酒。", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "啊。那也对。", 0xFF55BBFF.toInt())
        )),
        BarConversation("pilot_frost", "pilot_astro", listOf(
            ChatMessage("ASTRO", "这儿就靠你的脑子，寒霜。", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "我知道。", 0xFF55BBFF.toInt()),
            ChatMessage("ASTRO", "还挺谦虚。", 0xFFDD3333.toInt())
        )),

        // ============================================================
        // === DASH + EMBER ===
        // ============================================================
        BarConversation("pilot_dash", "pilot_ember", listOf(
            ChatMessage("DASH", "余烬！比一场！输的买下一轮！", 0xFFFFDD22.toInt()),
            ChatMessage("EMBER", "凤凰不赛跑。凤凰降临。", 0xFFFF6622.toInt()),
            ChatMessage("DASH", "这话说得花，意思是你慢。", 0xFFFFDD22.toInt()),
            ChatMessage("EMBER", "你这话说得欠烧。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_dash", "pilot_ember", listOf(
            ChatMessage("EMBER", "没有真热情，速度什么都不是！", 0xFFFF6622.toInt()),
            ChatMessage("DASH", "速度就是我的热情！", 0xFFFFDD22.toInt()),
            ChatMessage("EMBER", "那我们是同类。", 0xFFFF6622.toInt()),
            ChatMessage("DASH", "行！随便！走！", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_ember", listOf(
            ChatMessage("DASH", "你飞起来的尾迹太酷了。", 0xFFFFDD22.toInt()),
            ChatMessage("EMBER", "不酷。是热。这才对。", 0xFFFF6622.toInt()),
            ChatMessage("DASH", "你知道我什么意思！", 0xFFFFDD22.toInt())
        )),

        // ============================================================
        // === DASH + FANG ===
        // ============================================================
        BarConversation("pilot_dash", "pilot_fang", listOf(
            ChatMessage("DASH", "你怎么就……那么挂着？", 0xFFFFDD22.toInt()),
            ChatMessage("FANG", "练。还有耐心。", 0xFF8844CC.toInt()),
            ChatMessage("DASH", "耐心听着就像站着不动。无聊。", 0xFFFFDD22.toInt()),
            ChatMessage("FANG", "你听着就累。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_dash", "pilot_fang", listOf(
            ChatMessage("FANG", "你非得一直抖吗？", 0xFF8844CC.toInt()),
            ChatMessage("DASH", "不是抖！是微动！", 0xFFFFDD22.toInt()),
            ChatMessage("FANG", "我头疼。", 0xFF8844CC.toInt()),
            ChatMessage("DASH", "抱歉！忍不住！", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_fang", listOf(
            ChatMessage("DASH", "夜班最要命。", 0xFFFFDD22.toInt()),
            ChatMessage("FANG", "夜班最好。", 0xFF8844CC.toInt()),
            ChatMessage("DASH", "又黑又静！", 0xFFFFDD22.toInt()),
            ChatMessage("FANG", "正是。", 0xFF8844CC.toInt())
        )),

        // ============================================================
        // === DASH + WHISKERS ===
        // ============================================================
        BarConversation("pilot_dash", "pilot_whiskers", listOf(
            ChatMessage("DASH", "猫须！来陪我玩！", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "No.", 0xFFFFBB88.toInt()),
            ChatMessage("DASH", "抓人？追跑？什么都行？", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "我在睡。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_dash", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "你弄得我胡子直抖。", 0xFFFFBB88.toInt()),
            ChatMessage("DASH", "这是好事？", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "意思是我烦。", 0xFFFFBB88.toInt()),
            ChatMessage("DASH", "哦！抱歉！我跑快点，早点走！", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_whiskers", listOf(
            ChatMessage("DASH", "你怎么能睡这么多？", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "时间管理比你好。", 0xFFFFBB88.toInt()),
            ChatMessage("DASH", "教我。", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "第一步：闭嘴。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === DASH + KRAKEN ===
        // ============================================================
        BarConversation("pilot_dash", "pilot_kraken", listOf(
            ChatMessage("DASH", "海妖！击掌！等等——八只掌？", 0xFFFFDD22.toInt()),
            ChatMessage("KRAKEN", "触手从不拍击，只拥抱。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "这……莫名还挺暖？", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "速度是海面，深度在下面。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "我喜欢海面！浪快！", 0xFFFFDD22.toInt()),
            ChatMessage("KRAKEN", "且浅。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "喂！", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_kraken", listOf(
            ChatMessage("DASH", "那你到底能游多快？", 0xFFFFDD22.toInt()),
            ChatMessage("KRAKEN", "我控洋流。快慢无意义。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "所以……不行？", 0xFFFFDD22.toInt()),
            ChatMessage("KRAKEN", "我没说。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === DASH + HAVOC ===
        // ============================================================
        BarConversation("pilot_dash", "pilot_havoc", listOf(
            ChatMessage("DASH", "跑到那头墙再回来——开始！", 0xFFFFDD22.toInt()),
            ChatMessage("HAVOC", "比赛？！接！全速！不刹车！", 0xFFBBFF22.toInt()),
            ChatMessage("DASH", "肯定有刹车！", 0xFFFFDD22.toInt()),
            ChatMessage("HAVOC", "我没有！", 0xFFBBFF22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "疾风！只有你跟得上我！", 0xFFBBFF22.toInt()),
            ChatMessage("DASH", "只有你疯到敢跟！", 0xFFFFDD22.toInt()),
            ChatMessage("HAVOC", "死党！", 0xFFBBFF22.toInt()),
            ChatMessage("DASH", "别扯这么远！", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_havoc", listOf(
            ChatMessage("DASH", "狂徒，你又把测速器撞坏了。", 0xFFFFDD22.toInt()),
            ChatMessage("HAVOC", "它扛不住我的能量！", 0xFFBBFF22.toInt()),
            ChatMessage("DASH", "说实话，我也扛不住。", 0xFFFFDD22.toInt())
        )),

        // ============================================================
        // === DASH + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_dash", "pilot_unit7", listOf(
            ChatMessage("DASH", "七号！你最高能跑多快？", 0xFFFFDD22.toInt()),
            ChatMessage("UNIT-7", "移动非我主要功能。", 0xFF44EE55.toInt()),
            ChatMessage("DASH", "那你猜猜？", 0xFFFFDD22.toInt()),
            ChatMessage("UNIT-7", "我不猜。腿部数据不足。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_dash", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你静息心率190。异常。", 0xFF44EE55.toInt()),
            ChatMessage("DASH", "那是我的怠速！", 0xFFFFDD22.toInt()),
            ChatMessage("UNIT-7", "你在震动。", 0xFF44EE55.toInt()),
            ChatMessage("DASH", "高效地震！", 0xFFFFDD22.toInt())
        )),
        BarConversation("pilot_dash", "pilot_unit7", listOf(
            ChatMessage("DASH", "你就没想过跑一次？", 0xFFFFDD22.toInt()),
            ChatMessage("UNIT-7", "我计算。跑是腿的事。", 0xFF44EE55.toInt()),
            ChatMessage("DASH", "这是我听过最惨的话。", 0xFFFFDD22.toInt())
        )),

        // ============================================================
        // === DASH + ASTRO ===
        // ============================================================
        BarConversation("pilot_dash", "pilot_astro", listOf(
            ChatMessage("DASH", "老大！让我飞前锋！我超快！", 0xFFFFDD22.toInt()),
            ChatMessage("ASTRO", "上次你飞前锋，把全队套了一圈。", 0xFFDD3333.toInt()),
            ChatMessage("DASH", "那多爽！", 0xFFFFDD22.toInt()),
            ChatMessage("ASTRO", "是挺乱。不过……确实有点爽。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_dash", "pilot_astro", listOf(
            ChatMessage("ASTRO", "疾风，慢点。享受酒吧。", 0xFFDD3333.toInt()),
            ChatMessage("DASH", "我已经享受三遍了！", 0xFFFFDD22.toInt()),
            ChatMessage("ASTRO", "我们才来两分钟。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_dash", "pilot_astro", listOf(
            ChatMessage("DASH", "阿星，说实话。我最快吧？", 0xFFFFDD22.toInt()),
            ChatMessage("ASTRO", "毫无疑问。", 0xFFDD3333.toInt()),
            ChatMessage("DASH", "我就知道！去告诉他们！", 0xFFFFDD22.toInt()),
            ChatMessage("ASTRO", "他们听得见，疾风。", 0xFFDD3333.toInt())
        )),

        // ============================================================
        // === EMBER + FANG ===
        // ============================================================
        BarConversation("pilot_ember", "pilot_fang", listOf(
            ChatMessage("EMBER", "我的火焰把每道影子拖进光里。", 0xFFFF6622.toInt()),
            ChatMessage("FANG", "有些影子宁愿待在暗处。", 0xFF8844CC.toInt()),
            ChatMessage("EMBER", "够戏剧！我喜欢。", 0xFFFF6622.toInt()),
            ChatMessage("FANG", "我没想讨好你。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_ember", "pilot_fang", listOf(
            ChatMessage("FANG", "你的光刺眼。", 0xFF8844CC.toInt()),
            ChatMessage("EMBER", "谢谢！", 0xFFFF6622.toInt()),
            ChatMessage("FANG", "不是夸你。我眼睛敏感。", 0xFF8844CC.toInt()),
            ChatMessage("EMBER", "我照样当夸奖。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_ember", "pilot_fang", listOf(
            ChatMessage("FANG", "火会灭。黑暗永存。", 0xFF8844CC.toInt()),
            ChatMessage("EMBER", "火会重生。凤凰轮回。", 0xFFFF6622.toInt()),
            ChatMessage("FANG", "真好啊。", 0xFF8844CC.toInt())
        )),

        // ============================================================
        // === EMBER + WHISKERS ===
        // ============================================================
        BarConversation("pilot_ember", "pilot_whiskers", listOf(
            ChatMessage("EMBER", "小心，猫须——我的火有脾气。", 0xFFFF6622.toInt()),
            ChatMessage("WHISKERS", "我反应比你的火快。", 0xFFFFBB88.toInt()),
            ChatMessage("EMBER", "要试试吗？", 0xFFFF6622.toInt()),
            ChatMessage("WHISKERS", "试过了。你没看见我动。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_ember", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "你太热。走开。", 0xFFFFBB88.toInt()),
            ChatMessage("EMBER", "猫最爱暖和地方！", 0xFFFF6622.toInt()),
            ChatMessage("WHISKERS", "暖和地方，不是火狱。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_ember", "pilot_whiskers", listOf(
            ChatMessage("EMBER", "你感受过体内的火吗？", 0xFFFF6622.toInt()),
            ChatMessage("WHISKERS", "我感受到体内有团毛球。", 0xFFFFBB88.toInt()),
            ChatMessage("EMBER", "我不是那个意思……", 0xFFFF6622.toInt()),
            ChatMessage("WHISKERS", "但更贴切。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === EMBER + KRAKEN ===
        // ============================================================
        BarConversation("pilot_ember", "pilot_kraken", listOf(
            ChatMessage("EMBER", "火与水。最古老的宿敌！", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "我不觉得是宿敌。更像……互补。", 0xFF33AAAA.toInt()),
            ChatMessage("EMBER", "意外地成熟。", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "深渊教人平衡。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_ember", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "火遇水，蒸汽升。", 0xFF33AAAA.toInt()),
            ChatMessage("EMBER", "火胜水。人人都知道。", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "水灭火。", 0xFF33AAAA.toInt()),
            ChatMessage("EMBER", "细节。", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "……这就是重点。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_ember", "pilot_kraken", listOf(
            ChatMessage("EMBER", "最炽的火，烧在核心。", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "最深的压力，压出钻石。", 0xFF33AAAA.toInt()),
            ChatMessage("EMBER", "我们刚才有火花？", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "有。以后别提。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === EMBER + HAVOC ===
        // ============================================================
        BarConversation("pilot_ember", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "余烬！来点个火！", 0xFFBBFF22.toInt()),
            ChatMessage("EMBER", "你想烧什么？", 0xFFFF6622.toInt()),
            ChatMessage("HAVOC", "EVERYTHING!", 0xFFBBFF22.toInt()),
            ChatMessage("EMBER", "热情可嘉。驳回。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_ember", "pilot_havoc", listOf(
            ChatMessage("EMBER", "凤凰为意义而燃。", 0xFFFF6622.toInt()),
            ChatMessage("HAVOC", "我毫无意义地烧！更好玩！", 0xFFBBFF22.toInt()),
            ChatMessage("EMBER", "那……挺吓人的。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_ember", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "爆炸就是快火，对吧？", 0xFFBBFF22.toInt()),
            ChatMessage("EMBER", "最粗浅地说，对。", 0xFFFF6622.toInt()),
            ChatMessage("HAVOC", "那我基本也是凤凰！", 0xFFBBFF22.toInt()),
            ChatMessage("EMBER", "你一点都不像凤凰。", 0xFFFF6622.toInt())
        )),

        // ============================================================
        // === EMBER + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_ember", "pilot_unit7", listOf(
            ChatMessage("EMBER", "灵魂是不灭的火焰！", 0xFFFF6622.toInt()),
            ChatMessage("UNIT-7", "我无灵魂。也无火焰。", 0xFF44EE55.toInt()),
            ChatMessage("EMBER", "人人都有火星。", 0xFFFF6622.toInt()),
            ChatMessage("UNIT-7", "我有一块12伏电池。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_ember", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "警告：你的表面温度超安全上限。", 0xFF44EE55.toInt()),
            ChatMessage("EMBER", "安全上限是给不发光的家伙定的。", 0xFFFF6622.toInt()),
            ChatMessage("UNIT-7", "该词不在我词典中。", 0xFF44EE55.toInt()),
            ChatMessage("EMBER", "我刚造的。不用谢。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_ember", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "提问：重生过程痛吗？", 0xFF44EE55.toInt()),
            ChatMessage("EMBER", "每次都痛。所以它才美。", 0xFFFF6622.toInt()),
            ChatMessage("UNIT-7", "以痛为美。无法运算。", 0xFF44EE55.toInt())
        )),

        // ============================================================
        // === EMBER + ASTRO ===
        // ============================================================
        BarConversation("pilot_ember", "pilot_astro", listOf(
            ChatMessage("EMBER", "阿星！我要在星海里烧出一条路！", 0xFFFF6622.toInt()),
            ChatMessage("ASTRO", "别把船烧了就行。", 0xFFDD3333.toInt()),
            ChatMessage("EMBER", "……不敢保证。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_ember", "pilot_astro", listOf(
            ChatMessage("ASTRO", "余烬，收一点。", 0xFFDD3333.toInt()),
            ChatMessage("EMBER", "凤凰没有档位。只有全燃。", 0xFFFF6622.toInt()),
            ChatMessage("ASTRO", "找个档位。拜托。", 0xFFDD3333.toInt()),
            ChatMessage("EMBER", "……我试试小火闷烧。", 0xFFFF6622.toInt())
        )),
        BarConversation("pilot_ember", "pilot_astro", listOf(
            ChatMessage("ASTRO", "今天飞得好，余烬。真火力。", 0xFFDD3333.toInt()),
            ChatMessage("EMBER", "这是双关吗，阿星？", 0xFFFF6622.toInt()),
            ChatMessage("ASTRO", "无意的。但功劳我领。", 0xFFDD3333.toInt()),
            ChatMessage("EMBER", "火焰认可。", 0xFFFF6622.toInt())
        )),

        // ============================================================
        // === FANG + WHISKERS ===
        // ============================================================
        BarConversation("pilot_fang", "pilot_whiskers", listOf(
            ChatMessage("FANG", "同为夜行之物。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "别把我俩并论。我打盹，你潜伏。", 0xFFFFBB88.toInt()),
            ChatMessage("FANG", "潜伏只是有攻击性的打盹。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "绝对不是。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_fang", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "别盯着我睡。瘆人。", 0xFFFFBB88.toInt()),
            ChatMessage("FANG", "我没盯。我在守。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "我不需要守卫。", 0xFFFFBB88.toInt()),
            ChatMessage("FANG", "你也不需要九条命。可我们不都在这儿。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_fang", "pilot_whiskers", listOf(
            ChatMessage("FANG", "你的眼睛在暗处发光。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "你的也是。", 0xFFFFBB88.toInt()),
            ChatMessage("FANG", "我知道。吓人。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "很好。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === FANG + KRAKEN ===
        // ============================================================
        BarConversation("pilot_fang", "pilot_kraken", listOf(
            ChatMessage("FANG", "暗与深。彼此明白。", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "深渊千面。你是一面。", 0xFF33AAAA.toInt()),
            ChatMessage("FANG", "这是夸我还是骂我？", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "是。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_fang", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "回声定位。有趣的本事。", 0xFF33AAAA.toInt()),
            ChatMessage("FANG", "生物光。一样有趣。", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "我们都是隐感的造物。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_fang", "pilot_kraken", listOf(
            ChatMessage("FANG", "你最深到过哪？", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "光到不了的地方。", 0xFF33AAAA.toInt()),
            ChatMessage("FANG", "我想去。", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "我知道。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === FANG + HAVOC ===
        // ============================================================
        BarConversation("pilot_fang", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "獠牙！你太瘆人了！我爱死！", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "请降低音量。", 0xFF8844CC.toInt()),
            ChatMessage("HAVOC", "抱歉！我是说——抱歉！但你还挺瘆人！", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "……谢谢。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_fang", "pilot_havoc", listOf(
            ChatMessage("FANG", "你不怕。这不正常。", 0xFF8844CC.toInt()),
            ChatMessage("HAVOC", "恐惧只是营销失败的兴奋！", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "这是我听过最蠢的话。", 0xFF8844CC.toInt()),
            ChatMessage("HAVOC", "也最真！", 0xFFBBFF22.toInt())
        )),
        BarConversation("pilot_fang", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "獠牙，你倒着睡吗？", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "是。", 0xFF8844CC.toInt()),
            ChatMessage("HAVOC", "太酷了！我能试试吗？！", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "你会摔到头。", 0xFF8844CC.toInt())
        )),

        // ============================================================
        // === FANG + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_fang", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你的声呐频率45千赫。有趣。", 0xFF44EE55.toInt()),
            ChatMessage("FANG", "你能测到我的回声定位？", 0xFF8844CC.toInt()),
            ChatMessage("UNIT-7", "我测一切。这就是我的用途。", 0xFF44EE55.toInt()),
            ChatMessage("FANG", "那我们有点共同点。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_fang", "pilot_unit7", listOf(
            ChatMessage("FANG", "你在暗处看得见？", 0xFF8844CC.toInt()),
            ChatMessage("UNIT-7", "全频谱可见。黑暗无关紧要。", 0xFF44EE55.toInt()),
            ChatMessage("FANG", "那你就懂我为什么喜欢暗。", 0xFF8844CC.toInt()),
            ChatMessage("UNIT-7", "否定。偏爱黑暗不合逻辑。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_fang", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "提问：你为何避开日光？", 0xFF44EE55.toInt()),
            ChatMessage("FANG", "刺眼。也伤我的格调。", 0xFF8844CC.toInt()),
            ChatMessage("UNIT-7", "格调不是病症。", 0xFF44EE55.toInt())
        )),

        // ============================================================
        // === FANG + ASTRO ===
        // ============================================================
        BarConversation("pilot_fang", "pilot_astro", listOf(
            ChatMessage("FANG", "阿星。你该休息。我守夜。", 0xFF8844CC.toInt()),
            ChatMessage("ASTRO", "你总主动守夜。", 0xFFDD3333.toInt()),
            ChatMessage("FANG", "那时我最在状态。", 0xFF8844CC.toInt()),
            ChatMessage("ASTRO", "谢了，獠牙。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_fang", "pilot_astro", listOf(
            ChatMessage("ASTRO", "獠牙，你把新兵吓坏了。", 0xFFDD3333.toInt()),
            ChatMessage("FANG", "我在表示欢迎。", 0xFF8844CC.toInt()),
            ChatMessage("ASTRO", "你吊在天花板上盯着他们。", 0xFFDD3333.toInt()),
            ChatMessage("FANG", "……我打招呼就这样。", 0xFF8844CC.toInt())
        )),
        BarConversation("pilot_fang", "pilot_astro", listOf(
            ChatMessage("ASTRO", "有心事，獠牙？", 0xFFDD3333.toInt()),
            ChatMessage("FANG", "很多。多半是黑暗。", 0xFF8844CC.toInt()),
            ChatMessage("ASTRO", "这话要么很深，要么很糟。", 0xFFDD3333.toInt()),
            ChatMessage("FANG", "都。", 0xFF8844CC.toInt())
        )),

        // ============================================================
        // === WHISKERS + KRAKEN ===
        // ============================================================
        BarConversation("pilot_whiskers", "pilot_kraken", listOf(
            ChatMessage("WHISKERS", "别用触手摸我。", 0xFFFFBB88.toInt()),
            ChatMessage("KRAKEN", "我在够我的酒。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "八只手都够？", 0xFFFFBB88.toInt()),
            ChatMessage("KRAKEN", "酒大。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "猫和章鱼都是液体。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "你说什么？", 0xFFFFBB88.toInt()),
            ChatMessage("KRAKEN", "任何容器都装得下。物理。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "……准了。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_kraken", listOf(
            ChatMessage("WHISKERS", "你的哲学真累人。", 0xFFFFBB88.toInt()),
            ChatMessage("KRAKEN", "你的优越感真提神。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "这是讽刺？", 0xFFFFBB88.toInt()),
            ChatMessage("KRAKEN", "出自深渊，皆是真心。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === WHISKERS + HAVOC ===
        // ============================================================
        BarConversation("pilot_whiskers", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "猫须！老兄！", 0xFFBBFF22.toInt()),
            ChatMessage("WHISKERS", "我们不是老兄。", 0xFFFFBB88.toInt()),
            ChatMessage("HAVOC", "伙伴！朋友！同志！", 0xFFBBFF22.toInt()),
            ChatMessage("WHISKERS", "一个比一个难听。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "你怎么从来不笑？！", 0xFFBBFF22.toInt()),
            ChatMessage("WHISKERS", "我是猫。这就是我的笑。", 0xFFFFBB88.toInt()),
            ChatMessage("HAVOC", "看着像皱眉！", 0xFFBBFF22.toInt()),
            ChatMessage("WHISKERS", "正确。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "想看我跳个高的？", 0xFFBBFF22.toInt()),
            ChatMessage("WHISKERS", "我总四脚着地。你不会。", 0xFFFFBB88.toInt()),
            ChatMessage("HAVOC", "试试才知道！", 0xFFBBFF22.toInt())
        )),

        // ============================================================
        // === WHISKERS + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_whiskers", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "提问：你为何把东西推下桌面？", 0xFF44EE55.toInt()),
            ChatMessage("WHISKERS", "因为它们在那儿。", 0xFFFFBB88.toInt()),
            ChatMessage("UNIT-7", "这不是逻辑理由。", 0xFF44EE55.toInt()),
            ChatMessage("WHISKERS", "正是。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_unit7", listOf(
            ChatMessage("WHISKERS", "你关节咔咔响。烦。", 0xFFFFBB88.toInt()),
            ChatMessage("UNIT-7", "那是伺服机构。精准。", 0xFF44EE55.toInt()),
            ChatMessage("WHISKERS", "吵。", 0xFFFFBB88.toInt()),
            ChatMessage("UNIT-7", "你呼噜更响。高3分贝。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你每天掉四万根毛。", 0xFF44EE55.toInt()),
            ChatMessage("WHISKERS", "每根都完美。", 0xFFFFBB88.toInt()),
            ChatMessage("UNIT-7", "它们堵我进气口。", 0xFF44EE55.toInt()),
            ChatMessage("WHISKERS", "不关我事。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === WHISKERS + ASTRO ===
        // ============================================================
        BarConversation("pilot_whiskers", "pilot_astro", listOf(
            ChatMessage("WHISKERS", "我容忍你多于别人。", 0xFFFFBB88.toInt()),
            ChatMessage("ASTRO", "你这算高度评价。", 0xFFDD3333.toInt()),
            ChatMessage("WHISKERS", "别得意。", 0xFFFFBB88.toInt()),
            ChatMessage("ASTRO", "已经得意了。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_astro", listOf(
            ChatMessage("ASTRO", "猫须，驾驶座不是床。", 0xFFDD3333.toInt()),
            ChatMessage("WHISKERS", "什么都是床。", 0xFFFFBB88.toInt()),
            ChatMessage("ASTRO", "我们在出任务。", 0xFFDD3333.toInt()),
            ChatMessage("WHISKERS", "打盹任务。", 0xFFFFBB88.toInt())
        )),
        BarConversation("pilot_whiskers", "pilot_astro", listOf(
            ChatMessage("ASTRO", "你今天表现很好。", 0xFFDD3333.toInt()),
            ChatMessage("WHISKERS", "我知道。", 0xFFFFBB88.toInt()),
            ChatMessage("ASTRO", "说声谢谢会好点。", 0xFFDD3333.toInt()),
            ChatMessage("WHISKERS", "是啊，会的吧。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === KRAKEN + HAVOC ===
        // ============================================================
        BarConversation("pilot_kraken", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "海妖！你一次能打几拳？！", 0xFFBBFF22.toInt()),
            ChatMessage("KRAKEN", "八。但我更爱拥抱。", 0xFF33AAAA.toInt()),
            ChatMessage("HAVOC", "毁灭之拥！", 0xFFBBFF22.toInt()),
            ChatMessage("KRAKEN", "……行。就这么说。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_kraken", "pilot_havoc", listOf(
            ChatMessage("KRAKEN", "无目的的混乱只是噪音。", 0xFF33AAAA.toInt()),
            ChatMessage("HAVOC", "我爱噪音！", 0xFFBBFF22.toInt()),
            ChatMessage("KRAKEN", "看出来了。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_kraken", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "教我同时拿八把枪！", 0xFFBBFF22.toInt()),
            ChatMessage("KRAKEN", "你连一把都拿不稳。", 0xFF33AAAA.toInt()),
            ChatMessage("HAVOC", "拿稳？！那还有啥乐子？！", 0xFFBBFF22.toInt()),
            ChatMessage("KRAKEN", "活下来那部分。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === KRAKEN + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_kraken", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你神经网络是去中心化的。惊人。", 0xFF44EE55.toInt()),
            ChatMessage("KRAKEN", "每条手臂各自思考。", 0xFF33AAAA.toInt()),
            ChatMessage("UNIT-7", "有机体并行运算。有趣。", 0xFF44EE55.toInt()),
            ChatMessage("KRAKEN", "我们比你想的更相似。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_kraken", "pilot_unit7", listOf(
            ChatMessage("KRAKEN", "你思考过存在吗？", 0xFF33AAAA.toInt()),
            ChatMessage("UNIT-7", "我运算。一样吗？", 0xFF44EE55.toInt()),
            ChatMessage("KRAKEN", "我想大概一样。", 0xFF33AAAA.toInt()),
            ChatMessage("UNIT-7", "那我常思考。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_kraken", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "提问：何为智慧？", 0xFF44EE55.toInt()),
            ChatMessage("KRAKEN", "知道何时不答。", 0xFF33AAAA.toInt()),
            ChatMessage("UNIT-7", "这是矛盾。", 0xFF44EE55.toInt()),
            ChatMessage("KRAKEN", "正是。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === KRAKEN + ASTRO ===
        // ============================================================
        BarConversation("pilot_kraken", "pilot_astro", listOf(
            ChatMessage("KRAKEN", "阿星。全船都看着你。", 0xFF33AAAA.toInt()),
            ChatMessage("ASTRO", "他们看着我们所有人。", 0xFFDD3333.toInt()),
            ChatMessage("KRAKEN", "谦逊。领袖的好品质。", 0xFF33AAAA.toInt()),
            ChatMessage("ASTRO", "或者只是实话。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_kraken", "pilot_astro", listOf(
            ChatMessage("ASTRO", "下一趟前给点智慧，海妖？", 0xFFDD3333.toInt()),
            ChatMessage("KRAKEN", "潮水只反抗逆它的人。", 0xFF33AAAA.toInt()),
            ChatMessage("ASTRO", "所以……随波逐流？", 0xFFDD3333.toInt()),
            ChatMessage("KRAKEN", "本质上是。", 0xFF33AAAA.toInt())
        )),
        BarConversation("pilot_kraken", "pilot_astro", listOf(
            ChatMessage("ASTRO", "八只手，你还是用一只喝。", 0xFFDD3333.toInt()),
            ChatMessage("KRAKEN", "另外七只在忙。", 0xFF33AAAA.toInt()),
            ChatMessage("ASTRO", "忙什么？", 0xFFDD3333.toInt()),
            ChatMessage("KRAKEN", "沉思。", 0xFF33AAAA.toInt())
        )),

        // ============================================================
        // === HAVOC + UNIT-7 ===
        // ============================================================
        BarConversation("pilot_havoc", "pilot_unit7", listOf(
            ChatMessage("HAVOC", "七号！算算那爆炸多牛！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "爆炸半径47米。损伤：显著。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "可是酷不酷？！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "酷不可测量。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_havoc", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你的存活率12%。令人担忧。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "12%？！这赔率很好啊！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "不正确。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "有我这心态就不是！", 0xFFBBFF22.toInt())
        )),
        BarConversation("pilot_havoc", "pilot_unit7", listOf(
            ChatMessage("HAVOC", "喂，机器人有肾上腺素吗？", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "战斗中我会功率激增。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "一样！你是我们的人！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "我明确不是。", 0xFF44EE55.toInt())
        )),

        // ============================================================
        // === HAVOC + ASTRO ===
        // ============================================================
        BarConversation("pilot_havoc", "pilot_astro", listOf(
            ChatMessage("HAVOC", "老大！下趟让我不挂护盾飞！", 0xFFBBFF22.toInt()),
            ChatMessage("ASTRO", "这太疯了。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "疯得帅！", 0xFFBBFF22.toInt()),
            ChatMessage("ASTRO", "只是疯。算了。反正你也会干。", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_havoc", "pilot_astro", listOf(
            ChatMessage("ASTRO", "狂徒，财产损失报告有六页。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "新纪录？！", 0xFFBBFF22.toInt()),
            ChatMessage("ASTRO", "不是好纪录。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "纪录都是好纪录！", 0xFFBBFF22.toInt())
        )),
        BarConversation("pilot_havoc", "pilot_astro", listOf(
            ChatMessage("ASTRO", "你是好飞行员，狂徒。疯，但好。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "你刚说我疯又说我好？！", 0xFFBBFF22.toInt()),
            ChatMessage("ASTRO", "接受夸奖吧。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "接受！装框！挂墙上！", 0xFFBBFF22.toInt())
        )),

        // ============================================================
        // === UNIT-7 + ASTRO ===
        // ============================================================
        BarConversation("pilot_unit7", "pilot_astro", listOf(
            ChatMessage("UNIT-7", "阿星。船员士气73%。尚可。", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "你测士气？", 0xFFDD3333.toInt()),
            ChatMessage("UNIT-7", "我测一切。", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "我多少？", 0xFFDD3333.toInt())
        )),
        BarConversation("pilot_unit7", "pilot_astro", listOf(
            ChatMessage("ASTRO", "七号，你是团队一员。你知道吧？", 0xFFDD3333.toInt()),
            ChatMessage("UNIT-7", "我知道我的编制。", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "我是说你属于这里。", 0xFFDD3333.toInt()),
            ChatMessage("UNIT-7", "……处理中。谢谢，阿星。", 0xFF44EE55.toInt())
        )),
        BarConversation("pilot_unit7", "pilot_astro", listOf(
            ChatMessage("UNIT-7", "提问：TB-26的主要功能是什么？", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "他是我的无人机。也是我的朋友。", 0xFFDD3333.toInt()),
            ChatMessage("UNIT-7", "友谊不是功能。", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "当然是。最重要的那种。", 0xFFDD3333.toInt())
        ), blockedInAstroLoop = true),

        // === UNIT-7 + ASTRO (Astro Loop only) ===
        BarConversation("pilot_unit7", "pilot_astro", listOf(
            ChatMessage("UNIT-7", "提问：托巴的主要功能是什么？", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "他是我朋友。", 0xFFDD3333.toInt()),
            ChatMessage("UNIT-7", "友谊不是功能。", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "当然是。最重要的那种。", 0xFFDD3333.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + MEDIC ===
        // ============================================================
        BarConversation("tb26", "pilot_medic", listOf(
            ChatMessage("TB-26", "我关节吱响。是绝症吗？", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "你是无人机。我给你拿点油。", 0xFFFF88AA.toInt()),
            ChatMessage("TB-26", "别费事。我认了。", 0xFF88AACC.toInt())
        ), blockedInAstroLoop = true),
        BarConversation("tb26", "pilot_medic", listOf(
            ChatMessage("MEDIC", "TB-26，上次保养什么时候？", 0xFFFF88AA.toInt()),
            ChatMessage("TB-26", "你出生之前。", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "这就解释了一切……", 0xFFFF88AA.toInt())
        ), blockedInAstroLoop = true),
        BarConversation("tb26", "pilot_medic", listOf(
            ChatMessage("MEDIC", "托巴，你上次休假是什么时候？", 0xFFFF88AA.toInt()),
            ChatMessage("TOBAR", "你出生之前。", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "这就解释了一切……", 0xFFFF88AA.toInt())
        ), requiresAstroLoop = true),
        BarConversation("tb26", "pilot_medic", listOf(
            ChatMessage("MEDIC", "你该做个系统检查，TB-26。", 0xFFFF88AA.toInt()),
            ChatMessage("TB-26", "查过了。系统正常。", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "你刚拿个杯子就喊疼。", 0xFFFF88AA.toInt())
        ), blockedInAstroLoop = true),

        // === TB + MEDIC (Astro Loop only) ===
        BarConversation("tb26", "pilot_medic", listOf(
            ChatMessage("TOBAR","我腰最近不行。", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "我可以看看。", 0xFFFF88AA.toInt()),
            ChatMessage("TOBAR","我认了。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        BarConversation("tb26", "pilot_medic", listOf(
            ChatMessage("MEDIC", "托巴，上次体检什么时候？", 0xFFFF88AA.toInt()),
            ChatMessage("TOBAR","我站着。这就是体检。", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "真不是。", 0xFFFF88AA.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + RASCAL ===
        // ============================================================
        BarConversation("tb26", "pilot_rascal", listOf(
            ChatMessage("RASCAL", "喂TB-26，第一杯免费吧？", 0xFFDDAA33.toInt()),
            ChatMessage("TB-26", "不。而且这些不算酒。", 0xFF88AACC.toInt()),
            ChatMessage("RASCAL", "那严格说全免费。", 0xFFDDAA33.toInt())
        )),
        BarConversation("tb26", "pilot_rascal", listOf(
            ChatMessage("RASCAL", "我赌我能偷你抹布。", 0xFFDDAA33.toInt()),
            ChatMessage("TB-26", "我没有抹布。", 0xFF88AACC.toInt()),
            ChatMessage("RASCAL", "那我刚拿的是什么？", 0xFFDDAA33.toInt())
        )),
        BarConversation("tb26", "pilot_rascal", listOf(
            ChatMessage("TB-26", "你的账四千円币。", 0xFF88AACC.toInt()),
            ChatMessage("RASCAL", "凭什么？你卖的是冷却液！", 0xFFDDAA33.toInt()),
            ChatMessage("TB-26", "氛围税。", 0xFF88AACC.toInt())
        ), blockedInAstroLoop = true),

        // === TB + RASCAL (Astro Loop only) ===
        BarConversation("tb26", "pilot_rascal", listOf(
            ChatMessage("TOBAR","你的账四千円币。", 0xFF88AACC.toInt()),
            ChatMessage("RASCAL", "什么氛围？这喝着像空气！", 0xFFDDAA33.toInt()),
            ChatMessage("TOBAR","氛围税。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + BRUTUS ===
        // ============================================================
        BarConversation("tb26", "pilot_brutus", listOf(
            ChatMessage("BRUTUS", "啤酒。", 0xFF77AA33.toInt()),
            ChatMessage("TB-26", "不是啤酒。是大麦冷却液。", 0xFF88AACC.toInt()),
            ChatMessage("BRUTUS", "那你在这干嘛。", 0xFF77AA33.toInt())
        ), blockedInAstroLoop = true),
        BarConversation("tb26", "pilot_brutus", listOf(
            ChatMessage("TB-26", "你又把吧台压弯了。", 0xFF88AACC.toInt()),
            ChatMessage("BRUTUS", "抱歉。", 0xFF77AA33.toInt()),
            ChatMessage("TB-26", "别道歉。我服了。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_brutus", listOf(
            ChatMessage("BRUTUS", "你很小。", 0xFF77AA33.toInt()),
            ChatMessage("TB-26", "你观察力不错。", 0xFF88AACC.toInt()),
            ChatMessage("BRUTUS", "但我喜欢你。", 0xFF77AA33.toInt())
        )),

        // === TB + BRUTUS (Astro Loop only) ===
        BarConversation("tb26", "pilot_brutus", listOf(
            ChatMessage("BRUTUS", "啤酒。", 0xFF77AA33.toInt()),
            ChatMessage("TOBAR","这叫本店特调。我不知道配方。", 0xFF88AACC.toInt()),
            ChatMessage("BRUTUS", "那你在这干嘛。", 0xFF77AA33.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + FROST ===
        // ============================================================
        BarConversation("tb26", "pilot_frost", listOf(
            ChatMessage("FROST", ".", 0xFF55BBFF.toInt()),
            ChatMessage("TB-26", ".", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "聊得好。", 0xFF55BBFF.toInt())
        )),
        BarConversation("tb26", "pilot_frost", listOf(
            ChatMessage("TB-26", "你要点什么？", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "冰水。", 0xFF55BBFF.toInt()),
            ChatMessage("TB-26", "两样都没。只剩冷。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_frost", listOf(
            ChatMessage("FROST", "你这酒吧勉强合格。", 0xFF55BBFF.toInt()),
            ChatMessage("TB-26", "企鹅这话算高评。", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "别得意。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === TB-26 + DASH ===
        // ============================================================
        BarConversation("tb26", "pilot_dash", listOf(
            ChatMessage("DASH", "TB-26！酒！快！拜托！", 0xFFFFDD22.toInt()),
            ChatMessage("TB-26", "我只一个速度。慢。", 0xFF88AACC.toInt()),
            ChatMessage("DASH", "太折磨了！", 0xFFFFDD22.toInt())
        )),
        BarConversation("tb26", "pilot_dash", listOf(
            ChatMessage("TB-26", "你绕吧台跑了六圈。", 0xFF88AACC.toInt()),
            ChatMessage("DASH", "七圈！你漏了一圈！", 0xFFFFDD22.toInt()),
            ChatMessage("TB-26", "怪我。我眨了下眼。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_dash", listOf(
            ChatMessage("DASH", "你怎么这么淡定？", 0xFFFFDD22.toInt()),
            ChatMessage("TB-26", "我是无人机。没肾上腺素。", 0xFF88AACC.toInt()),
            ChatMessage("DASH", "听着就惨！", 0xFFFFDD22.toInt())
        ), blockedInAstroLoop = true),

        // === TB + DASH (Astro Loop only) ===
        BarConversation("tb26", "pilot_dash", listOf(
            ChatMessage("DASH", "你怎么能这么淡定？！", 0xFFFFDD22.toInt()),
            ChatMessage("TOBAR","练出来的。还有低期待。", 0xFF88AACC.toInt()),
            ChatMessage("DASH", "听着就惨！", 0xFFFFDD22.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + EMBER ===
        // ============================================================
        BarConversation("tb26", "pilot_ember", listOf(
            ChatMessage("EMBER", "你什么都没有感觉吗，TB-26？！", 0xFFFF6622.toInt()),
            ChatMessage("TB-26", "一直有点小烦。", 0xFF88AACC.toInt()),
            ChatMessage("EMBER", "这……有点凄凉。", 0xFFFF6622.toInt())
        )),
        BarConversation("tb26", "pilot_ember", listOf(
            ChatMessage("TB-26", "别拿我暖手。", 0xFF88AACC.toInt()),
            ChatMessage("EMBER", "可你是室温啊！", 0xFFFF6622.toInt()),
            ChatMessage("TB-26", "我宁愿一直常温。", 0xFF88AACC.toInt())
        ), blockedInAstroLoop = true),
        BarConversation("tb26", "pilot_ember", listOf(
            ChatMessage("TOBAR", "别在我吧台上暖手。", 0xFF88AACC.toInt()),
            ChatMessage("EMBER", "你这地方冻死人！", 0xFFFF6622.toInt()),
            ChatMessage("TOBAR", "暖气要円币。忍着。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        BarConversation("tb26", "pilot_ember", listOf(
            ChatMessage("EMBER", "没有热情的人生毫无意义！", 0xFFFF6622.toInt()),
            ChatMessage("TB-26", "我上酒，还不承认是我调的。", 0xFF88AACC.toInt()),
            ChatMessage("EMBER", "……充满热情地？", 0xFFFF6622.toInt())
        )),

        // ============================================================
        // === TB-26 + FANG ===
        // ============================================================
        BarConversation("tb26", "pilot_fang", listOf(
            ChatMessage("FANG", "我在暗处也看得见。", 0xFF8844CC.toInt()),
            ChatMessage("TB-26", "我也能。我有传感器。", 0xFF88AACC.toInt()),
            ChatMessage("FANG", "你一说就没劲了。", 0xFF8844CC.toInt())
        ), blockedInAstroLoop = true),
        BarConversation("tb26", "pilot_fang", listOf(
            ChatMessage("TB-26", "别吊天花板上。", 0xFF88AACC.toInt()),
            ChatMessage("FANG", "舒服。", 0xFF8844CC.toInt()),
            ChatMessage("TB-26", "你吓到客人了。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_fang", listOf(
            ChatMessage("FANG", "你的线路闻着有意思。", 0xFF8844CC.toInt()),
            ChatMessage("TB-26", "请别吃我的线。", 0xFF88AACC.toInt()),
            ChatMessage("FANG", "不敢保证。", 0xFF8844CC.toInt())
        ), blockedInAstroLoop = true),

        // === TB + FANG (Astro Loop only) ===
        BarConversation("tb26", "pilot_fang", listOf(
            ChatMessage("FANG", "我在暗处也看得见。", 0xFF8844CC.toInt()),
            ChatMessage("TOBAR","全黑我也能摸到吧台。", 0xFF88AACC.toInt()),
            ChatMessage("FANG", "你一说就没劲了。", 0xFF8844CC.toInt())
        ), requiresAstroLoop = true),
        BarConversation("tb26", "pilot_fang", listOf(
            ChatMessage("FANG", "你的心跳很稳。", 0xFF8844CC.toInt()),
            ChatMessage("TOBAR","请别听我心跳。", 0xFF88AACC.toInt()),
            ChatMessage("FANG", "不敢保证。", 0xFF8844CC.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + KRAKEN ===
        // ============================================================
        BarConversation("tb26", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "我曾瞪退过星云风暴。", 0xFF33AAAA.toInt()),
            ChatMessage("TB-26", "我曾看着漆不干。", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "……你赢。", 0xFF33AAAA.toInt())
        )),
        BarConversation("tb26", "pilot_kraken", listOf(
            ChatMessage("TB-26", "外面黑得难熬吧？", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "一向如此。但酒吧很静。", 0xFF33AAAA.toInt()),
            ChatMessage("TB-26", "这是我听过最客气的话。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "明智的船长认得他的酒保。", 0xFF33AAAA.toInt()),
            ChatMessage("TB-26", "我只是吧台后的无人机。", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "正是。最有智慧那种。", 0xFF33AAAA.toInt())
        ), blockedInAstroLoop = true),

        // === TB + KRAKEN (Astro Loop only) ===
        BarConversation("tb26", "pilot_kraken", listOf(
            ChatMessage("KRAKEN", "明智的船长认得他的酒保。", 0xFF33AAAA.toInt()),
            ChatMessage("TOBAR","我只是吧台后的一个人。", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "正是。最有智慧那种。", 0xFF33AAAA.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + WHISKERS ===
        // ============================================================
        BarConversation("tb26", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "我的账，加倍或清零。", 0xFFFFBB88.toInt()),
            ChatMessage("TB-26", "你的账是零。加倍还是零。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "那我怎么都赢。成交。", 0xFFFFBB88.toInt())
        )),
        BarConversation("tb26", "pilot_whiskers", listOf(
            ChatMessage("TB-26", "庄家永远赢。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "我就是庄家。", 0xFFFFBB88.toInt()),
            ChatMessage("TB-26", "你是吧凳上的一只猫。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_whiskers", listOf(
            ChatMessage("WHISKERS", "运气也是本事，TB-26。", 0xFFFFBB88.toInt()),
            ChatMessage("TB-26", "不是。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "所以你没有。", 0xFFFFBB88.toInt())
        )),

        // ============================================================
        // === TB-26 + UNIT-7 ===
        // ============================================================
        BarConversation("tb26", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "同为机械。你如何运作？", 0xFF44EE55.toInt()),
            ChatMessage("TB-26", "勉强。", 0xFF88AACC.toInt()),
            ChatMessage("UNIT-7", "错误：非有效状态。", 0xFF44EE55.toInt())
        ), blockedInAstroLoop = true),
        BarConversation("tb26", "pilot_unit7", listOf(
            ChatMessage("TB-26", "你有过……空的感觉吗？", 0xFF88AACC.toInt()),
            ChatMessage("UNIT-7", "我的存储使用率47%。", 0xFF44EE55.toInt()),
            ChatMessage("TB-26", "算了。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "你的效率评级很低。", 0xFF44EE55.toInt()),
            ChatMessage("TB-26", "知道。这是我最好的品质。", 0xFF88AACC.toInt()),
            ChatMessage("UNIT-7", "无法运算。", 0xFF44EE55.toInt())
        )),

        // === TB + UNIT-7 (Astro Loop only) ===
        BarConversation("tb26", "pilot_unit7", listOf(
            ChatMessage("UNIT-7", "我们都服务船员。我们相似。", 0xFF44EE55.toInt()),
            ChatMessage("TOBAR","勉强。", 0xFF88AACC.toInt()),
            ChatMessage("UNIT-7", "错误：非有效状态。", 0xFF44EE55.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === TB-26 + HAVOC ===
        // ============================================================
        BarConversation("tb26", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "我把这个砸了会怎样？就看一眼。", 0xFFBBFF22.toInt()),
            ChatMessage("TB-26", "什么都不会。它早坏了。", 0xFF88AACC.toInt()),
            ChatMessage("HAVOC", "唉，你真没劲。", 0xFFBBFF22.toInt())
        )),
        BarConversation("tb26", "pilot_havoc", listOf(
            ChatMessage("TB-26", "今天别砸东西。我求你。", 0xFF88AACC.toInt()),
            ChatMessage("HAVOC", "「任何东西」怎么定义。", 0xFFBBFF22.toInt()),
            ChatMessage("TB-26", "吧台。我想活的念头。都算。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_havoc", listOf(
            ChatMessage("HAVOC", "混乱是阶梯，TB-26！", 0xFFBBFF22.toInt()),
            ChatMessage("TB-26", "混乱是我收拾的烂摊子。", 0xFF88AACC.toInt()),
            ChatMessage("HAVOC", "一回事！", 0xFFBBFF22.toInt())
        )),

        // ============================================================
        // === TB-26 + ASTRO ===
        // ============================================================
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("ASTRO", "酒吧怎么样，TB-26？", 0xFFDD3333.toInt()),
            ChatMessage("TB-26", "空的。安静。完美。", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "辛苦你看家了。", 0xFFDD3333.toInt())
        )),
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("TB-26", "你该休息，阿星。", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "你什么时候开始担心我了？", 0xFFDD3333.toInt()),
            ChatMessage("TB-26", "一直都在。别告诉别人。", 0xFF88AACC.toInt())
        )),
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("ASTRO", "一切都谢了，TB-26。", 0xFFDD3333.toInt()),
            ChatMessage("TB-26", "我只是站这儿。", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "是啊。这就够了。", 0xFFDD3333.toInt())
        )),
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("ASTRO", "TB-26，你会有闪回吗？", 0xFFDD3333.toInt()),
            ChatMessage("TB-26", "我的传感器偶尔出故障。", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "……对。故障。就是这样。", 0xFFDD3333.toInt())
        ), requiresArcCompleted = true, blockedInAstroLoop = true),

        // === TB + ASTRO (Astro Loop only — replaces the "flashes" conversation) ===
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("ASTRO", "你有过身在他处的感觉吗？", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","一两次。", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "我也是。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","今天很长。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),

        // === TB + ASTRO — desert backstory (Astro Loop only) ===
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("ASTRO", "你真做到了。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","做到什么？", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "一间酒吧。安静点的地方。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","早说了。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("TOBAR","今天没订单。", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "也没命令。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","正合我意。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("ASTRO", "我们赌对了。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","...", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "在外面。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","嗯。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        BarConversation("tb26", "pilot_astro", listOf(
            ChatMessage("ASTRO", "你知道吗，你猜中了。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","那间酒吧？", 0xFF88AACC.toInt()),
            ChatMessage("ASTRO", "全中。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR","我有预感。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === BELT RUN CABINET (Astro Loop only) ===
        // ============================================================
        // Ordinary bar chatter about a real object in the room — who's good at it, who
        // wastes yen on it, arguing over the board. No foreshadowing: the reckoning is an
        // easter egg, not a finale, so nobody here talks about an ending.
        BarConversation("pilot_kraken", "pilot_dash", listOf(
            ChatMessage("DASH", "那根操纵杆上没人比我手快。", 0xFFFFDD22.toInt()),
            ChatMessage("KRAKEN", "我有八只手不同意。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "那不是技术，是触手作弊！", 0xFFFFDD22.toInt()),
            ChatMessage("KRAKEN", "是手臂。这叫解剖学。", 0xFF33AAAA.toInt())
        ), requiresAstroLoop = true),
        BarConversation("pilot_fang", "pilot_brutus", listOf(
            ChatMessage("BRUTUS", "操纵杆断了。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "这周第三根。", 0xFF8844CC.toInt()),
            ChatMessage("BRUTUS", "机器太脆。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "是你劲儿大。输也轻点输。", 0xFF8844CC.toInt())
        ), requiresAstroLoop = true),
        BarConversation("pilot_whiskers", "pilot_rascal", listOf(
            ChatMessage("WHISKERS", "今晚在环带竞速上输了一千一円币。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "新手数据。我输的是三倍。", 0xFFDDAA33.toInt()),
            ChatMessage("WHISKERS", "至少我输得好看。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "我输得像张报税单。", 0xFFDDAA33.toInt())
        ), requiresAstroLoop = true),
        BarConversation("pilot_medic", "pilot_ember", listOf(
            ChatMessage("MEDIC", "你把整份工资都砸在环带竞速上了。", 0xFFFF88AA.toInt()),
            ChatMessage("EMBER", "最高分在召唤。我不能不应。", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "用你所有的円币，看样子。", 0xFFFF88AA.toInt()),
            ChatMessage("EMBER", "热爱不便宜，医官。", 0xFFFF6622.toInt())
        ), requiresAstroLoop = true),
        BarConversation("pilot_unit7", "pilot_havoc", listOf(
            ChatMessage("UNIT-7", "你上榜一次。只有一次。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "两次！你漏了角落里那个！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "那是乱码，不是字母。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "照样算数！", 0xFFBBFF22.toInt())
        ), requiresAstroLoop = true),
        BarConversation("pilot_frost", "pilot_astro", listOf(
            ChatMessage("ASTRO", "你也玩那台？我从没见你碰过。", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "我玩。你深夜讲简报的时候。", 0xFF55BBFF.toInt()),
            ChatMessage("ASTRO", "你什么事都这么安静。", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "安静才听得见下一波。", 0xFF55BBFF.toInt())
        ), requiresAstroLoop = true),
        BarConversation("pilot_whiskers", "pilot_frost", listOf(
            ChatMessage("WHISKERS", "我在那台机器上全靠运气。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "运气不会倒着穿碎石带。", 0xFF55BBFF.toInt()),
            ChatMessage("WHISKERS", "运气这么好的时候会。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "那是技术披了件外套。", 0xFF55BBFF.toInt())
        ), requiresAstroLoop = true),

        // === TB + WHISKERS — BELT RUN (Astro Loop only) ===
        // Tobar half-remembers what the cabinet used to be. He is not sure, a pilot tells
        // him he's wrong, and he lets it go — the player is left as the only one who knows
        // he's right.
        BarConversation("tb26", "pilot_whiskers", listOf(
            ChatMessage("TOBAR", "那台机器以前不是这个。大概。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "一直是环带竞速。一直。", 0xFFFFBB88.toInt()),
            ChatMessage("TOBAR", "……大概是记岔了地方。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),

        // === TB + FROST — BELT RUN (Astro Loop only) ===
        BarConversation("tb26", "pilot_frost", listOf(
            ChatMessage("TOBAR", "那台机器，我总差一点就想起来。", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "一直是这个。你想太多。", 0xFF55BBFF.toInt()),
            ChatMessage("TOBAR", "...fair.", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === MULTI-WAY: 3-WAY CONVERSATIONS ===
        // ============================================================
        BarConversation(listOf("pilot_medic", "pilot_rascal", "pilot_brutus"), listOf(
            ChatMessage("MEDIC", "痞子，你又拿蛮熊的扳手了？", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "是借。借不算拿。", 0xFFDDAA33.toInt()),
            ChatMessage("BRUTUS", "扳手。现在。", 0xFF77AA33.toInt()),
            ChatMessage("RASCAL", "……在通风管里。别跟来。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_rascal", "pilot_frost"), listOf(
            ChatMessage("RASCAL", "寒霜的柜子里有好零食。已确认。", 0xFFDDAA33.toInt()),
            ChatMessage("MEDIC", "痞子，那是偷同伴的东西。", 0xFFFF88AA.toInt()),
            ChatMessage("FROST", "那是冷冻诱饵。慢慢享受冻伤。", 0xFF55BBFF.toInt()),
            ChatMessage("RASCAL", "……值。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_brutus", "pilot_fang"), listOf(
            ChatMessage("FANG", "昨晚有人爬过通风管。", 0xFF8844CC.toInt()),
            ChatMessage("RASCAL", "不是我。我在睡。在我铺上。真的。", 0xFFDDAA33.toInt()),
            ChatMessage("BRUTUS", "撒谎。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "他的心跳同意蛮熊。", 0xFF8844CC.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_brutus", "pilot_dash"), listOf(
            ChatMessage("DASH", "蛮熊，跟我赛一场！医官计时！", 0xFFFFDD22.toInt()),
            ChatMessage("BRUTUS", "No.", 0xFF77AA33.toInt()),
            ChatMessage("MEDIC", "我不再给脑震荡计时了，疾风。", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "一圈！半圈？冲刺？", 0xFFFFDD22.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_dash", "pilot_whiskers"), listOf(
            ChatMessage("DASH", "咱们仨是全船最快的，对吧？", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "我不跑。我只是赏脸到场。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "企鹅很快。水下。", 0xFF55BBFF.toInt()),
            ChatMessage("DASH", "这儿没人懂我。", 0xFFFFDD22.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_dash", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "疾风，你在瘸。去看医官。", 0xFFDD3333.toInt()),
            ChatMessage("DASH", "是快速瘸。基本不算。", 0xFFFFDD22.toInt()),
            ChatMessage("MEDIC", "坐下。现在。你们俩别吵了。", 0xFFFF88AA.toInt()),
            ChatMessage("ASTRO", "医生的话听见了。", 0xFFDD3333.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_ember", "pilot_fang"), listOf(
            ChatMessage("EMBER", "咱们仨是夜里最凶的猎手！", 0xFFFF6622.toInt()),
            ChatMessage("BRUTUS", "吵的猎手。烂的猎手。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "火会发光。一里外就看见你。", 0xFF8844CC.toInt()),
            ChatMessage("EMBER", "...noted.", 0xFFFF6622.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_ember", "pilot_whiskers"), listOf(
            ChatMessage("RASCAL", "余烬又烤了我的存货。又一次。", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "别把零食藏在凤凰旁边。", 0xFFFF6622.toInt()),
            ChatMessage("WHISKERS", "也别藏我旁边。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "这酒吧里没一处安全。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_fang", "pilot_kraken"), listOf(
            ChatMessage("FANG", "又冷又黑又深。合我胃口。", 0xFF8844CC.toInt()),
            ChatMessage("FROST", "我更喜欢「安静」。", 0xFF55BBFF.toInt()),
            ChatMessage("KRAKEN", "深渊很有耐心。我也是。", 0xFF33AAAA.toInt()),
            ChatMessage("FROST", "三个闷葫芦走进酒吧。", 0xFF55BBFF.toInt())
        )),
        BarConversation(listOf("pilot_dash", "pilot_ember", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "炸点什么吧！谁跟？！", 0xFFBBFF22.toInt()),
            ChatMessage("DASH", "我！快！现在！", 0xFFFFDD22.toInt()),
            ChatMessage("EMBER", "我带火。", 0xFFFF6622.toInt()),
            ChatMessage("HAVOC", "最。强。船。队。", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_fang", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "提问：獠牙为何倒挂？", 0xFF44EE55.toInt()),
            ChatMessage("FANG", "血更顺。感官更利。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "从医学上讲……他没说错。", 0xFFFF88AA.toInt()),
            ChatMessage("UNIT-7", "记作「有机体怪癖」。", 0xFF44EE55.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_kraken", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "全站最强船队，毫无悬念！", 0xFFBBFF22.toInt()),
            ChatMessage("BRUTUS", "哼。也许。", 0xFF77AA33.toInt()),
            ChatMessage("KRAKEN", "我有八只手。这一票归我。", 0xFF33AAAA.toInt()),
            ChatMessage("HAVOC", "这算术没法反驳！", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_whiskers", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "猫须，你今天打落了14件物品。", 0xFF44EE55.toInt()),
            ChatMessage("WHISKERS", "它们挡路。全部。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "落地前我顺了九件。", 0xFFDDAA33.toInt()),
            ChatMessage("UNIT-7", "我被混乱因子包围了。", 0xFF44EE55.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_dash", "pilot_kraken"), listOf(
            ChatMessage("KRAKEN", "洋流会带走愿意等的人。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "或者游快点。快很多。", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "都行。一个更静。", 0xFF55BBFF.toInt()),
            ChatMessage("DASH", "静就是无聊。", 0xFFFFDD22.toInt())
        )),
        BarConversation(listOf("pilot_ember", "pilot_kraken", "pilot_astro"), listOf(
            ChatMessage("EMBER", "自灰烬中重生！", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "自深渊中忍耐。", 0xFF33AAAA.toInt()),
            ChatMessage("ASTRO", "从酒吧，我们该动身了。", 0xFFDD3333.toInt()),
            ChatMessage("EMBER", "……他没说错。", 0xFFFF6622.toInt())
        )),
        BarConversation(listOf("pilot_fang", "pilot_whiskers", "pilot_astro"), listOf(
            ChatMessage("FANG", "两个掠食者加一个船长。真温馨。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "我不是「掠食者」。我是品鉴家。", 0xFFFFBB88.toInt()),
            ChatMessage("ASTRO", "你们俩看我的眼神一模一样。", 0xFFDD3333.toInt()),
            ChatMessage("FANG", "我们饿了。去猎。", 0xFF8844CC.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_havoc", "pilot_astro"), listOf(
            ChatMessage("MEDIC", "狂徒又躺进医疗舱。这周第七回。", 0xFFFF88AA.toInt()),
            ChatMessage("HAVOC", "新纪录，医生！", 0xFFBBFF22.toInt()),
            ChatMessage("ASTRO", "狂徒。别再用头撞船。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "不敢保证，老大！", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_unit7", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "这边怎么这么安静？！", 0xFFBBFF22.toInt()),
            ChatMessage("FROST", "本来是。直到刚才。", 0xFF55BBFF.toInt()),
            ChatMessage("UNIT-7", "分贝值飙升400%。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "这就是狂徒效应！", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_fang", "pilot_kraken"), listOf(
            ChatMessage("RASCAL", "夜袭食品柜。你俩来吗？", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "我在暗处看得见。我带路。", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "东西我全搬。八只手。", 0xFF33AAAA.toInt()),
            ChatMessage("RASCAL", "我不配拥有的最好队友。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_dash", "pilot_whiskers", "pilot_unit7"), listOf(
            ChatMessage("DASH", "猫须，赛一场！输的请酒！", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "我在午睡。答案是午睡。", 0xFFFFBB88.toInt()),
            ChatMessage("UNIT-7", "猫须今天睡了16小时。", 0xFF44EE55.toInt()),
            ChatMessage("DASH", "这怎么可能？！", 0xFFFFDD22.toInt())
        )),
        BarConversation(listOf("pilot_ember", "pilot_havoc", "pilot_astro"), listOf(
            ChatMessage("HAVOC", "余烬，咱们轰轰烈烈地烧完吧！", 0xFFBBFF22.toInt()),
            ChatMessage("EMBER", "这才叫人话！", 0xFFFF6622.toInt()),
            ChatMessage("ASTRO", "谁也不许轰轰烈烈。坐。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "哎，老大真没意思。", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_kraken", "pilot_whiskers", "pilot_unit7"), listOf(
            ChatMessage("KRAKEN", "耐心是海洋最深的馈赠。", 0xFF33AAAA.toInt()),
            ChatMessage("UNIT-7", "耐心：低效，但记录为有效。", 0xFF44EE55.toInt()),
            ChatMessage("WHISKERS", "我已练成。看我怎么无视你。", 0xFFFFBB88.toInt()),
            ChatMessage("KRAKEN", "……说实话，厉害。", 0xFF33AAAA.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_unit7", "pilot_havoc"), listOf(
            ChatMessage("UNIT-7", "蛮熊，你的骨密度很惊人。", 0xFF44EE55.toInt()),
            ChatMessage("BRUTUS", "别扫了。", 0xFF77AA33.toInt()),
            ChatMessage("HAVOC", "扫我！我准是全身肌肉！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "否。主要是淤青。", 0xFF44EE55.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_ember", "pilot_astro"), listOf(
            ChatMessage("FROST", "余烬又在给舱里升温。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "寒霜在降温。平衡。", 0xFFFF6622.toInt()),
            ChatMessage("ASTRO", "你俩能去别处平衡吗？", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "乐意。", 0xFF55BBFF.toInt())
        )),

        // ============================================================
        // === MULTI-WAY: 4-WAY CONVERSATIONS ===
        // ============================================================
        BarConversation(listOf("pilot_medic", "pilot_rascal", "pilot_brutus", "pilot_frost"), listOf(
            ChatMessage("MEDIC", "最早登船的四个。像一家人。", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "一家子转手都值钱。", 0xFFDDAA33.toInt()),
            ChatMessage("BRUTUS", "碰我装备，丢一只手。", 0xFF77AA33.toInt()),
            ChatMessage("FROST", "我赌一周内有人冻住。", 0xFF55BBFF.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_rascal", "pilot_dash", "pilot_ember"), listOf(
            ChatMessage("DASH", "全体，发射台见，比谁快！", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "我走捷径。你们的口袋。", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "我走风景路线。带火的。", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "我去写那份躲不掉的伤情报告。", 0xFFFF88AA.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_frost", "pilot_fang", "pilot_kraken"), listOf(
            ChatMessage("FROST", "酒吧的安静角落。我的最爱。", 0xFF55BBFF.toInt()),
            ChatMessage("FANG", "现在是我们的。我们占了。", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "静流在此汇聚。", 0xFF33AAAA.toInt()),
            ChatMessage("BRUTUS", "好。保持安静。", 0xFF77AA33.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_dash", "pilot_fang", "pilot_whiskers"), listOf(
            ChatMessage("DASH", "谁反应最快？来定个高下！", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "猫的反应最快。众所周知。", 0xFFFFBB88.toInt()),
            ChatMessage("FANG", "动静还没发生我就听见了。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "别在我医疗舱里「定胜负」。", 0xFFFF88AA.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_ember", "pilot_kraken", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "全酒吧最吵的一桌！保持！", 0xFFBBFF22.toInt()),
            ChatMessage("EMBER", "火跟你一起吼！", 0xFFFF6622.toInt()),
            ChatMessage("RASCAL", "正好掩护我撤。谢了，兄弟。", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "我当你风暴里的那点静。", 0xFF33AAAA.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_dash", "pilot_whiskers", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "四种截然不同的运行速度。", 0xFF44EE55.toInt()),
            ChatMessage("DASH", "我是快的那个！", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "我是慢的。自愿的。", 0xFFFFBB88.toInt()),
            ChatMessage("BRUTUS", "我走了。", 0xFF77AA33.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_ember", "pilot_fang", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "冰、火和一只蝙蝠走进酒吧。", 0xFFDD3333.toInt()),
            ChatMessage("FROST", "没有笑点。只有我们。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "我就是笑点。还是个亮的！", 0xFFFF6622.toInt()),
            ChatMessage("FANG", "我更喜欢铺垫。在暗处。", 0xFF8844CC.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_kraken", "pilot_unit7", "pilot_havoc"), listOf(
            ChatMessage("MEDIC", "你们四个都体检。今天。", 0xFFFF88AA.toInt()),
            ChatMessage("KRAKEN", "我有三颗心。三倍活儿。", 0xFF33AAAA.toInt()),
            ChatMessage("UNIT-7", "我没有。跳过。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "最后查我，我会弄坏机器！", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_frost", "pilot_whiskers", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "有人看见我的飞行夹克吗？", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "没有。从来没有。说不上。", 0xFFDDAA33.toInt()),
            ChatMessage("WHISKERS", "挺暖的。我坐着呢。", 0xFFFFBB88.toInt()),
            ChatMessage("FROST", "痞子拿那两只袖子给通风管垫了里子。", 0xFF55BBFF.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_ember", "pilot_unit7", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "全体，状态汇报。", 0xFFDD3333.toInt()),
            ChatMessage("BRUTUS", "就绪。", 0xFF77AA33.toInt()),
            ChatMessage("EMBER", "烧着等起飞！", 0xFFFF6622.toInt()),
            ChatMessage("UNIT-7", "全系统正常。", 0xFF44EE55.toInt())
        )),
        BarConversation(listOf("pilot_dash", "pilot_kraken", "pilot_whiskers", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "掰手腕！全体，现在！", 0xFFBBFF22.toInt()),
            ChatMessage("KRAKEN", "我得换张大桌子。八只手。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "光靠速度我就赢！", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "我不参加就赢了。", 0xFFFFBB88.toInt())
        )),
        BarConversation(listOf("pilot_fang", "pilot_unit7", "pilot_havoc", "pilot_astro"), listOf(
            ChatMessage("UNIT-7", "三个人和一只蝙蝠。统计上很怪。", 0xFF44EE55.toInt()),
            ChatMessage("FANG", "我才是有趣的那个。", 0xFF8844CC.toInt()),
            ChatMessage("HAVOC", "不可能，我才有意思！", 0xFFBBFF22.toInt()),
            ChatMessage("ASTRO", "你们全让我头疼。", 0xFFDD3333.toInt())
        )),

        // ============================================================
        // === MULTI-WAY: TB-26 / TOBAR GROUPS ===
        // ============================================================
        // T1 — TB + Medic + Rascal
        BarConversation(listOf("tb26", "pilot_medic", "pilot_rascal"), listOf(
            ChatMessage("TB-26", "痞子的账比我的电路还长。", 0xFF88AACC.toInt()),
            ChatMessage("RASCAL", "记我账上。我付得起。", 0xFFDDAA33.toInt()),
            ChatMessage("MEDIC", "他绝对付不起。", 0xFFFF88AA.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_medic", "pilot_rascal"), listOf(
            ChatMessage("TOBAR", "痞子的账比我的胳膊还长。", 0xFF88AACC.toInt()),
            ChatMessage("RASCAL", "记我账上。我付得起。", 0xFFDDAA33.toInt()),
            ChatMessage("MEDIC", "他绝对付不起。", 0xFFFF88AA.toInt())
        ), requiresAstroLoop = true),
        // T2 — TB + Brutus + Dash
        BarConversation(listOf("tb26", "pilot_brutus", "pilot_dash"), listOf(
            ChatMessage("DASH", "TB-26，来你倒得最快的那杯！", 0xFFFFDD22.toInt()),
            ChatMessage("TB-26", "我只有一个速度。勉强。", 0xFF88AACC.toInt()),
            ChatMessage("BRUTUS", "一样。", 0xFF77AA33.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_brutus", "pilot_dash"), listOf(
            ChatMessage("DASH", "托巴，来你倒得最快的那杯！", 0xFFFFDD22.toInt()),
            ChatMessage("TOBAR", "我只有一个速度。勉强。", 0xFF88AACC.toInt()),
            ChatMessage("BRUTUS", "一样。", 0xFF77AA33.toInt())
        ), requiresAstroLoop = true),
        // T3 — TB + Frost + Havoc
        BarConversation(listOf("tb26", "pilot_frost", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "最冷、最烈的，有什么倒什么！", 0xFFBBFF22.toInt()),
            ChatMessage("TB-26", "冷却液。我只倒这个。", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "我要温的。少点刺激。", 0xFF55BBFF.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_frost", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "最冷、最烈的，有什么倒什么！", 0xFFBBFF22.toInt()),
            ChatMessage("TOBAR", "本店特调。别问年份。", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "我要温的。少点刺激。", 0xFF55BBFF.toInt())
        ), requiresAstroLoop = true),
        // T4 — TB + Ember + Whiskers
        BarConversation(listOf("tb26", "pilot_ember", "pilot_whiskers"), listOf(
            ChatMessage("EMBER", "酒保！来点烧嗓子的！", 0xFFFF6622.toInt()),
            ChatMessage("TB-26", "我只供冷却液。正好相反。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "给我暖窝里那份。", 0xFFFFBB88.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_ember", "pilot_whiskers"), listOf(
            ChatMessage("EMBER", "酒保！来点烧嗓子的！", 0xFFFF6622.toInt()),
            ChatMessage("TOBAR", "我只倒一样。别抱希望。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "给我暖窝里那份。", 0xFFFFBB88.toInt())
        ), requiresAstroLoop = true),
        // T5 — TB + Kraken + Unit-7
        BarConversation(listOf("tb26", "pilot_kraken", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "TB-26，咱们都是机器。抱团吗？", 0xFF44EE55.toInt()),
            ChatMessage("TB-26", "我生来是毁灭的。如今负责摆盘。", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "我们都偏离了本分。喝一杯？", 0xFF33AAAA.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_kraken", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "托巴，你会怀念旧日子吗？", 0xFF44EE55.toInt()),
            ChatMessage("TOBAR", "每天都想。然后又倒一杯。", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "我们都偏离了本分。喝一杯？", 0xFF33AAAA.toInt())
        ), requiresAstroLoop = true),
        // T6 — TB + Fang + Rascal
        BarConversation(listOf("tb26", "pilot_fang", "pilot_rascal"), listOf(
            ChatMessage("FANG", "你的账在暗角那边，痞子。", 0xFF8844CC.toInt()),
            ChatMessage("RASCAL", "你怎么看得那么远？", 0xFFDDAA33.toInt()),
            ChatMessage("TB-26", "他看不见。账本在我手里。", 0xFF88AACC.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_fang", "pilot_rascal"), listOf(
            ChatMessage("FANG", "你的账在暗角那边，痞子。", 0xFF8844CC.toInt()),
            ChatMessage("RASCAL", "你怎么看得那么远？", 0xFFDDAA33.toInt()),
            ChatMessage("TOBAR", "他看不见。账本在我手里。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        // T7 — TB + Medic + Astro + Havoc (4-way)
        BarConversation(listOf("tb26", "pilot_medic", "pilot_astro", "pilot_havoc"), listOf(
            ChatMessage("ASTRO", "TB-26，老样子，一桌的。", 0xFFDD3333.toInt()),
            ChatMessage("TB-26", "三份冷却液。点缀是后悔。", 0xFF88AACC.toInt()),
            ChatMessage("HAVOC", "我的要双份后悔！", 0xFFBBFF22.toInt()),
            ChatMessage("MEDIC", "给他换成水。他脑震荡。", 0xFFFF88AA.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_medic", "pilot_astro", "pilot_havoc"), listOf(
            ChatMessage("ASTRO", "托巴，老样子，一桌的。", 0xFFDD3333.toInt()),
            ChatMessage("TOBAR", "三份算店里的。点缀是后悔。", 0xFF88AACC.toInt()),
            ChatMessage("HAVOC", "我的要双份后悔！", 0xFFBBFF22.toInt()),
            ChatMessage("MEDIC", "给他换成水。他脑震荡。", 0xFFFF88AA.toInt())
        ), requiresAstroLoop = true),
        // T8 — TB + Dash + Ember + Kraken (4-way)
        BarConversation(listOf("tb26", "pilot_dash", "pilot_ember", "pilot_kraken"), listOf(
            ChatMessage("DASH", "四杯，TB，快点！", 0xFFFFDD22.toInt()),
            ChatMessage("TB-26", "「快」不在我的程序里。", 0xFF88AACC.toInt()),
            ChatMessage("EMBER", "上得慢才有悬念！", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "我等。潮水总会回来。", 0xFF33AAAA.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_dash", "pilot_ember", "pilot_kraken"), listOf(
            ChatMessage("DASH", "四杯，托巴，快点！", 0xFFFFDD22.toInt()),
            ChatMessage("TOBAR", "「快」不在我的天性里。", 0xFF88AACC.toInt()),
            ChatMessage("EMBER", "上得慢才有悬念！", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "我等。潮水总会回来。", 0xFF33AAAA.toInt())
        ), requiresAstroLoop = true),

        // ============================================================
        // === MULTI-WAY: 3-WAY CONVERSATIONS (BATCH 2) ===
        // ============================================================
        BarConversation(listOf("pilot_medic", "pilot_rascal", "pilot_dash"), listOf(
            ChatMessage("DASH", "痞子，你比看着快多了！", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "躲债躲了这么多年。", 0xFFDDAA33.toInt()),
            ChatMessage("MEDIC", "说得通。医学上、财务上都是。", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "教我跑路的路线！", 0xFFFFDD22.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_brutus", "pilot_ember"), listOf(
            ChatMessage("EMBER", "两个冷灵魂，一团永恒之火。", 0xFFFF6622.toInt()),
            ChatMessage("FROST", "你在抬高我的保费。", 0xFF55BBFF.toInt()),
            ChatMessage("BRUTUS", "还有室温。", 0xFF77AA33.toInt()),
            ChatMessage("EMBER", "美是有代价的。", 0xFFFF6622.toInt())
        )),
        BarConversation(listOf("pilot_fang", "pilot_kraken", "pilot_whiskers"), listOf(
            ChatMessage("FANG", "三个夜行者，同坐一桌。", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "我潜行于深渊，不在暗处。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "我伏击沙发。它从没逃掉。", 0xFFFFBB88.toInt()),
            ChatMessage("FANG", "……咱们这组，跨度真大。", 0xFF8844CC.toInt())
        )),
        BarConversation(listOf("pilot_unit7", "pilot_havoc", "pilot_astro"), listOf(
            ChatMessage("HAVOC", "七号，算算我的存活率！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "很低。你自己拆了护盾。", 0xFF44EE55.toInt()),
            ChatMessage("ASTRO", "他每次都这么干。", 0xFFDD3333.toInt()),
            ChatMessage("HAVOC", "可我还活着！", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_frost", "pilot_fang"), listOf(
            ChatMessage("MEDIC", "你们俩体温比尸体还低。", 0xFFFF88AA.toInt()),
            ChatMessage("FROST", "循环高效。", 0xFF55BBFF.toInt()),
            ChatMessage("FANG", "听心跳时杂音少。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "我后悔问了。一如既往。", 0xFFFF88AA.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_dash", "pilot_kraken"), listOf(
            ChatMessage("RASCAL", "海妖，八只手？想想那些赃物。", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "我用来保持平衡，不是行窃。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "我抓了就跑，谁也追不上。", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "有品位。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_ember", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "蛮熊与余烬攻击性达峰。", 0xFF44EE55.toInt()),
            ChatMessage("BRUTUS", "很好。", 0xFF77AA33.toInt()),
            ChatMessage("EMBER", "我们是流动的艺术！", 0xFFFF6622.toInt()),
            ChatMessage("UNIT-7", "我将拉大距离。", 0xFF44EE55.toInt())
        )),
        BarConversation(listOf("pilot_whiskers", "pilot_havoc", "pilot_astro"), listOf(
            ChatMessage("HAVOC", "猫须，搞点混乱怎么样？", 0xFFBBFF22.toInt()),
            ChatMessage("WHISKERS", "我什么都不干就能制造混乱。", 0xFFFFBB88.toInt()),
            ChatMessage("ASTRO", "她把我的咖啡从控制台蹭了下去。", 0xFFDD3333.toInt()),
            ChatMessage("WHISKERS", "正是。毫不费力。", 0xFFFFBB88.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_dash", "pilot_whiskers"), listOf(
            ChatMessage("MEDIC", "你们的心率是两个极端。", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "我的爆表了！爽翻了！", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "我的在睡。跟我一样。", 0xFFFFBB88.toInt()),
            ChatMessage("MEDIC", "求你们中间来一个。", 0xFFFF88AA.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_ember", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "痞子，备用推进器你当了？", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "「当」是什么意思。还有「备用」。", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "他换了个特别亮的打火机。", 0xFFFF6622.toInt()),
            ChatMessage("RASCAL", "余烬，说好你保密的！", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_fang", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "全酒吧最吓人的一桌，没得比！", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "我没想吓人。我天生如此。", 0xFF8844CC.toInt()),
            ChatMessage("BRUTUS", "哼。", 0xFF77AA33.toInt()),
            ChatMessage("HAVOC", "看？蛮熊同意了，很大声！", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_kraken", "pilot_unit7"), listOf(
            ChatMessage("KRAKEN", "静止才是海洋真正的语言。", 0xFF33AAAA.toInt()),
            ChatMessage("FROST", "终于有个懂的。", 0xFF55BBFF.toInt()),
            ChatMessage("UNIT-7", "三个低能耗单位。最优。", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "七号，这算夸我吗？", 0xFF55BBFF.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_ember", "pilot_kraken"), listOf(
            ChatMessage("MEDIC", "余烬，别再照海妖的建议烧伤口。", 0xFFFF88AA.toInt()),
            ChatMessage("KRAKEN", "我只说深渊能治愈一切伤口。", 0xFF33AAAA.toInt()),
            ChatMessage("EMBER", "我用火改良了！", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "你们俩都不是医生。", 0xFFFF88AA.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_fang", "pilot_whiskers"), listOf(
            ChatMessage("RASCAL", "全船最鬼祟的三人，齐聚。", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "你每次来我都听得见，痞子。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "我只是懒得鬼祟。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "抢劫提案，听众真难伺候。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_havoc", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "今天尽量别毁了机库。", 0xFFDD3333.toInt()),
            ChatMessage("BRUTUS", "不敢保证。", 0xFF77AA33.toInt()),
            ChatMessage("HAVOC", "咱俩现在是爆破搭子！", 0xFFBBFF22.toInt()),
            ChatMessage("ASTRO", "我就怕这个。", 0xFFDD3333.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_dash", "pilot_unit7"), listOf(
            ChatMessage("DASH", "赌不赌，我眨眼前绕酒吧一圈！", 0xFFFFDD22.toInt()),
            ChatMessage("UNIT-7", "我不眨眼。你会输。", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "他没夸张。我看着的。", 0xFF55BBFF.toInt()),
            ChatMessage("DASH", "这是我输过最瘆人的赌。", 0xFFFFDD22.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_ember", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "余烬，医官让你慢下来。", 0xFFDD3333.toInt()),
            ChatMessage("EMBER", "慢下来就是一种死法！", 0xFFFF6622.toInt()),
            ChatMessage("MEDIC", "三度烧伤也一样，还很戏剧。", 0xFFFF88AA.toInt()),
            ChatMessage("ASTRO", "听医生的，余烬。", 0xFFDD3333.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_frost", "pilot_whiskers"), listOf(
            ChatMessage("WHISKERS", "有人动了我的零食库。", 0xFFFFBB88.toInt()),
            ChatMessage("RASCAL", "不可能是我。我有不在场证明。", 0xFFDDAA33.toInt()),
            ChatMessage("FROST", "你手上正拿着她的金枪鱼。", 0xFF55BBFF.toInt()),
            ChatMessage("RASCAL", "……这是我的同款金枪鱼。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_fang", "pilot_kraken"), listOf(
            ChatMessage("FANG", "全船最安静的三个猎手。", 0xFF8844CC.toInt()),
            ChatMessage("BRUTUS", "少说。", 0xFF77AA33.toInt()),
            ChatMessage("KRAKEN", "他沟通很高效。我认可。", 0xFF33AAAA.toInt()),
            ChatMessage("FANG", "……这桌不错。", 0xFF8844CC.toInt())
        )),
        BarConversation(listOf("pilot_dash", "pilot_unit7", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "赛跑加爆炸！史上最强组合！", 0xFFBBFF22.toInt()),
            ChatMessage("DASH", "赛跑那半我参加！", 0xFFFFDD22.toInt()),
            ChatMessage("UNIT-7", "存活率：急速下降。", 0xFF44EE55.toInt()),
            ChatMessage("HAVOC", "那叫「有趣」的概率！", 0xFFBBFF22.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_unit7", "pilot_havoc"), listOf(
            ChatMessage("MEDIC", "狂徒，又进医疗舱了？", 0xFFFF88AA.toInt()),
            ChatMessage("HAVOC", "我跟舱壁击了个掌！它输了！", 0xFFBBFF22.toInt()),
            ChatMessage("UNIT-7", "舱壁无损。你有损。", 0xFF44EE55.toInt()),
            ChatMessage("MEDIC", "坐下，别又「赢」一回。", 0xFFFF88AA.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_ember", "pilot_fang"), listOf(
            ChatMessage("RASCAL", "夜袭，你们俩。我要望风的。", 0xFFDDAA33.toInt()),
            ChatMessage("FANG", "我什么都看得见。显然。", 0xFF8844CC.toInt()),
            ChatMessage("EMBER", "我来照路！", 0xFFFF6622.toInt()),
            ChatMessage("RASCAL", "余烬，那跟潜行正相反。", 0xFFDDAA33.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_frost", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "我最稳的两个飞行员，就在这。", 0xFFDD3333.toInt()),
            ChatMessage("BRUTUS", "我们守得住。", 0xFF77AA33.toInt()),
            ChatMessage("FROST", "平静地。而且冷。", 0xFF55BBFF.toInt()),
            ChatMessage("ASTRO", "这样的定锚，挑不出更好的。", 0xFFDD3333.toInt())
        )),
        BarConversation(listOf("pilot_dash", "pilot_whiskers", "pilot_kraken"), listOf(
            ChatMessage("DASH", "最快的、最懒的，还有……手最多的。组队？", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "我负责监督。", 0xFFFFBB88.toInt()),
            ChatMessage("KRAKEN", "我什么都出八份。", 0xFF33AAAA.toInt()),
            ChatMessage("DASH", "我出跑腿！", 0xFFFFDD22.toInt())
        )),

        // ============================================================
        // === MULTI-WAY: 4-WAY CONVERSATIONS (BATCH 2) ===
        // ============================================================
        BarConversation(listOf("pilot_medic", "pilot_dash", "pilot_whiskers", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "医官，船员们还撑得住吗？", 0xFFDD3333.toInt()),
            ChatMessage("MEDIC", "疾风不肯歇，猫须不肯醒。", 0xFFFF88AA.toInt()),
            ChatMessage("DASH", "休息浪费白天！", 0xFFFFDD22.toInt()),
            ChatMessage("WHISKERS", "醒来浪费午睡。", 0xFFFFBB88.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_brutus", "pilot_ember", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "本桌混乱指数：严重。", 0xFF44EE55.toInt()),
            ChatMessage("RASCAL", "我们更喜欢「有精神」。", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "我们更喜欢「传说级」！", 0xFFFF6622.toInt()),
            ChatMessage("BRUTUS", "我们更喜欢安静。", 0xFF77AA33.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_fang", "pilot_kraken", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "这角落怎么又阴又静？！", 0xFFBBFF22.toInt()),
            ChatMessage("FROST", "曾经。过去式。", 0xFF55BBFF.toInt()),
            ChatMessage("FANG", "你一个人够我们全员吵了。", 0xFF8844CC.toInt()),
            ChatMessage("KRAKEN", "深渊更静。稍微。", 0xFF33AAAA.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_ember", "pilot_fang", "pilot_havoc"), listOf(
            ChatMessage("MEDIC", "三位医疗舱常客。", 0xFFFF88AA.toInt()),
            ChatMessage("EMBER", "烧伤是勋章！", 0xFFFF6622.toInt()),
            ChatMessage("HAVOC", "淤青是战利品！", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "我只是喜欢那些安静的床。", 0xFF8844CC.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_frost", "pilot_unit7", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "库存又少了。有人认吗？", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "缩水了。常有的事。真惨。", 0xFFDDAA33.toInt()),
            ChatMessage("UNIT-7", "痞子于0300取走九件物品。", 0xFF44EE55.toInt()),
            ChatMessage("FROST", "机器人留着账呢，痞子。", 0xFF55BBFF.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_dash", "pilot_kraken", "pilot_whiskers"), listOf(
            ChatMessage("DASH", "最强的、最慢的、手最多的，还有我！", 0xFFFFDD22.toInt()),
            ChatMessage("BRUTUS", "力气赢。", 0xFF77AA33.toInt()),
            ChatMessage("KRAKEN", "够得着才赢。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "无所谓才赢。我都没使劲。", 0xFFFFBB88.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_brutus", "pilot_fang", "pilot_unit7"), listOf(
            ChatMessage("UNIT-7", "扫描生命体征。蛮熊读数为「岩石」。", 0xFF44EE55.toInt()),
            ChatMessage("BRUTUS", "准确。", 0xFF77AA33.toInt()),
            ChatMessage("FANG", "他的心跳比我还慢。", 0xFF8844CC.toInt()),
            ChatMessage("MEDIC", "你们全是没法处理的病号。", 0xFFFF88AA.toInt())
        )),
        BarConversation(listOf("pilot_rascal", "pilot_dash", "pilot_havoc", "pilot_astro"), listOf(
            ChatMessage("HAVOC", "最快的、最吵的、最鬼的，还有老大！", 0xFFBBFF22.toInt()),
            ChatMessage("DASH", "梦之队！", 0xFFFFDD22.toInt()),
            ChatMessage("RASCAL", "「吵」这条你们自己认。", 0xFFDDAA33.toInt()),
            ChatMessage("ASTRO", "我怎么觉得要出抢劫案了？", 0xFFDD3333.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_ember", "pilot_kraken", "pilot_whiskers"), listOf(
            ChatMessage("FROST", "冰、火、海，还有一只家猫。", 0xFF55BBFF.toInt()),
            ChatMessage("EMBER", "我带来温暖！", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "我带来深度。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "我什么都不带。不用谢。", 0xFFFFBB88.toInt())
        )),
        BarConversation(listOf("pilot_medic", "pilot_rascal", "pilot_ember", "pilot_kraken"), listOf(
            ChatMessage("MEDIC", "四个都查体征。坐。", 0xFFFF88AA.toInt()),
            ChatMessage("RASCAL", "不行。我静坐过敏。", 0xFFDDAA33.toInt()),
            ChatMessage("EMBER", "我体温高。读数是假的。", 0xFFFF6622.toInt()),
            ChatMessage("KRAKEN", "三颗心。仔细点。", 0xFF33AAAA.toInt())
        )),
        BarConversation(listOf("pilot_brutus", "pilot_fang", "pilot_whiskers", "pilot_havoc"), listOf(
            ChatMessage("HAVOC", "掠食者力量桌！开猎！", 0xFFBBFF22.toInt()),
            ChatMessage("FANG", "狩猎要安静，狂徒。", 0xFF8844CC.toInt()),
            ChatMessage("WHISKERS", "还要出力。算了。", 0xFFFFBB88.toInt()),
            ChatMessage("BRUTUS", "坐下。安静。", 0xFF77AA33.toInt())
        )),
        BarConversation(listOf("pilot_frost", "pilot_dash", "pilot_unit7", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "全体状态。长话短说。", 0xFFDD3333.toInt()),
            ChatMessage("DASH", "快是我唯一的版本！", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "稳定。冷。就绪。", 0xFF55BBFF.toInt()),
            ChatMessage("UNIT-7", "系统正常。", 0xFF44EE55.toInt())
        )),

        // ============================================================
        // === MULTI-WAY: TB-26 / TOBAR GROUPS (BATCH 2) ===
        // ============================================================
        // NT1 — TB + Frost + Brutus
        BarConversation(listOf("tb26", "pilot_frost", "pilot_brutus"), listOf(
            ChatMessage("BRUTUS", "酒。", 0xFF77AA33.toInt()),
            ChatMessage("TB-26", "一份冷却液。全程无表情。", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "这服务合我意。", 0xFF55BBFF.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_frost", "pilot_brutus"), listOf(
            ChatMessage("BRUTUS", "酒。", 0xFF77AA33.toInt()),
            ChatMessage("TOBAR", "一杯。全程不寒暄。", 0xFF88AACC.toInt()),
            ChatMessage("FROST", "这服务合我意。", 0xFF55BBFF.toInt())
        ), requiresAstroLoop = true),
        // NT2 — TB + Dash + Whiskers
        BarConversation(listOf("tb26", "pilot_dash", "pilot_whiskers"), listOf(
            ChatMessage("DASH", "TB-26，菜单上最快的！", 0xFFFFDD22.toInt()),
            ChatMessage("TB-26", "静止。我只有这一样。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "我要双份。", 0xFFFFBB88.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_dash", "pilot_whiskers"), listOf(
            ChatMessage("DASH", "托巴，菜单上最快的！", 0xFFFFDD22.toInt()),
            ChatMessage("TOBAR", "静止。我只有这一样。", 0xFF88AACC.toInt()),
            ChatMessage("WHISKERS", "我要双份。", 0xFFFFBB88.toInt())
        ), requiresAstroLoop = true),
        // NT3 — TB + Ember + Kraken
        BarConversation(listOf("tb26", "pilot_ember", "pilot_kraken"), listOf(
            ChatMessage("EMBER", "酒保，来点带火的！", 0xFFFF6622.toInt()),
            ChatMessage("TB-26", "我灭火。我不点火。", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "深渊会熄灭所有火，朋友。", 0xFF33AAAA.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_ember", "pilot_kraken"), listOf(
            ChatMessage("EMBER", "酒保，来点带火的！", 0xFFFF6622.toInt()),
            ChatMessage("TOBAR", "我负责降温。店规。", 0xFF88AACC.toInt()),
            ChatMessage("KRAKEN", "深渊会熄灭所有火，朋友。", 0xFF33AAAA.toInt())
        ), requiresAstroLoop = true),
        // NT4 — TB + Havoc + Unit-7
        BarConversation(listOf("tb26", "pilot_havoc", "pilot_unit7"), listOf(
            ChatMessage("HAVOC", "TB，给我倒点「危险」！", 0xFFBBFF22.toInt()),
            ChatMessage("TB-26", "危险不在我的服务菜单上。", 0xFF88AACC.toInt()),
            ChatMessage("UNIT-7", "他的血液已超安全上限。", 0xFF44EE55.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_havoc", "pilot_unit7"), listOf(
            ChatMessage("HAVOC", "托巴，给我倒点「危险」！", 0xFFBBFF22.toInt()),
            ChatMessage("TOBAR", "危险不在我的服务菜单上。", 0xFF88AACC.toInt()),
            ChatMessage("UNIT-7", "他的血液已超安全上限。", 0xFF44EE55.toInt())
        ), requiresAstroLoop = true),
        // NT5 — TB + Rascal + Astro
        BarConversation(listOf("tb26", "pilot_rascal", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "TB-26，今晚把痞子的账结清。", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "哇，老大，这可真大方。", 0xFFDDAA33.toInt()),
            ChatMessage("TB-26", "我把他「忘了」说的那几样加上了。", 0xFF88AACC.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_rascal", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "托巴，今晚把痞子的账结清。", 0xFFDD3333.toInt()),
            ChatMessage("RASCAL", "哇，老大，这可真大方。", 0xFFDDAA33.toInt()),
            ChatMessage("TOBAR", "我把他「忘了」说的那几样加上了。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        // NT6 — TB + Medic + Fang
        BarConversation(listOf("tb26", "pilot_medic", "pilot_fang"), listOf(
            ChatMessage("FANG", "你的齿轮响得乱，TB-26。", 0xFF8844CC.toInt()),
            ChatMessage("TB-26", "我老了。响是性格。", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "知道吗，这个我能校准。", 0xFFFF88AA.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_medic", "pilot_fang"), listOf(
            ChatMessage("FANG", "你的脉搏跳得乱，托巴。", 0xFF8844CC.toInt()),
            ChatMessage("TOBAR", "我老了。响是性格。", 0xFF88AACC.toInt()),
            ChatMessage("MEDIC", "知道吗，这个我能校准。", 0xFFFF88AA.toInt())
        ), requiresAstroLoop = true),
        // NT7 — TB + Rascal + Kraken + Whiskers (4-way)
        BarConversation(listOf("tb26", "pilot_rascal", "pilot_kraken", "pilot_whiskers"), listOf(
            ChatMessage("RASCAL", "四只手倒酒？海妖该来当酒保。", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "洗盘子我可跟不上。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "反正TB-26不洗盘子。", 0xFFFFBB88.toInt()),
            ChatMessage("TB-26", "正确。我们没有盘子。", 0xFF88AACC.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_rascal", "pilot_kraken", "pilot_whiskers"), listOf(
            ChatMessage("RASCAL", "四只手倒酒？海妖该来当酒保。", 0xFFDDAA33.toInt()),
            ChatMessage("KRAKEN", "洗盘子我可跟不上。", 0xFF33AAAA.toInt()),
            ChatMessage("WHISKERS", "反正托巴不洗盘子。", 0xFFFFBB88.toInt()),
            ChatMessage("TOBAR", "正确。我们没有盘子。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),
        // NT8 — TB + Frost + Dash + Astro (4-way)
        BarConversation(listOf("tb26", "pilot_frost", "pilot_dash", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "给我最快的和最冷的上一轮。", 0xFFDD3333.toInt()),
            ChatMessage("DASH", "我的打包！不，堂食！两个都要！", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "我的加冰。当然。", 0xFF55BBFF.toInt()),
            ChatMessage("TB-26", "我上的每样东西本来就是冰。", 0xFF88AACC.toInt())
        ), blockedInAstroLoop = true),
        BarConversation(listOf("tb26", "pilot_frost", "pilot_dash", "pilot_astro"), listOf(
            ChatMessage("ASTRO", "给我最快的和最冷的上一轮。", 0xFFDD3333.toInt()),
            ChatMessage("DASH", "我的打包！不，堂食！两个都要！", 0xFFFFDD22.toInt()),
            ChatMessage("FROST", "我的加冰。当然。", 0xFF55BBFF.toInt()),
            ChatMessage("TOBAR", "我上的每样东西本来就是冷的。", 0xFF88AACC.toInt())
        ), requiresAstroLoop = true),

        // === END MULTI-WAY CONVERSATIONS ===
    )

    /**
     * internal: the seam BarConversationSpoilerTest reads. A conversation is gated on its
     * participants, so the only way a line can outrun that gate is by naming someone who is not in
     * it — which is not visible from any public accessor.
     */
    internal val allConversations: List<BarConversation> get() = conversations

    /**
     * Built at runtime, so **`BarConversationSpoilerTest` cannot see it.**
     *
     * That test walks [allConversations] and fails any line naming a pilot who is not one of the
     * conversation's participants — the shape that let Unit-7 spoil Astro's existence to players
     * who had never met him. This conversation is assembled here instead of living in that list,
     * and it puts a UNIT-7 line into a Rascal + Brutus scene, which is exactly what the test
     * exists to catch.
     *
     * It is safe only because its single caller, `ChatSystem.onAstroLoopFirstEntry`, is gated to
     * Astro Loop, by which point every pilot has been recruited and nothing can be spoiled. **If
     * that gate ever moves earlier, this becomes a spoiler and no test will tell you.**
     */
    fun getShieldDiscoveryConversation(): BarConversation? {
        val rascal = PilotDefinitions.getPilot("pilot_rascal") ?: return null
        val unit7 = PilotDefinitions.getPilot("pilot_unit7") ?: return null
        val brutus = PilotDefinitions.getPilot("pilot_brutus") ?: return null
        return BarConversation(
            pilotAId = "pilot_rascal",
            pilotBId = "pilot_brutus",
            lines = listOf(
                ChatMessage(rascal.callsign, "在那条红色旧残骸上捡到一套好护盾。", rascal.color),
                ChatMessage(unit7.callsign, "已确认。军用级。来源非标准。", unit7.color),
                ChatMessage(rascal.callsign, "没问来路。直接拿了。", rascal.color),
                ChatMessage(brutus.callsign, "逆向复刻了。现在每艘船一套。", brutus.color)
            )
        )
    }

    fun getAvailable(
        unlockedPilotIds: Set<String>,
        arcCompleted: Boolean = false,
        isAstroLoop: Boolean = false
    ): List<BarConversation> {
        return conversations
            .filter { convo ->
                convo.participantIds.all { it in unlockedPilotIds || it == "tb26" } &&
                (!convo.requiresArcCompleted || arcCompleted) &&
                (!convo.blockedInAstroLoop || !isAstroLoop) &&
                (!convo.requiresAstroLoop || isAstroLoop)
            }
            .map { convo ->
                if (!isAstroLoop) convo
                else convo.copy(lines = convo.lines.map { msg ->
                    msg.copy(
                        speaker = if (msg.speaker == "TB-26") "TOBAR" else msg.speaker,
                        text = msg.text.replace("TB-26", "托巴")
                    )
                })
            }
    }
}
