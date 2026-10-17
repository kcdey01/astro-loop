package com.astroloop.game.data

import com.astroloop.game.render.CrystalPalette

object DesertDefinitions {

    // Speaker constants
    const val TB = "TOBAR"
    const val ASTRO = "ASTRO"
    const val COMMAND = "COMMAND"
    const val CRYSTAL = "CRYSTAL"

    // Colors
    val TB_COLOR = 0xFF88AACC.toInt()
    val ASTRO_COLOR = 0xFFDD3333.toInt()
    val COMMAND_COLOR = 0xFF999999.toInt()
    val CRYSTAL_COLOR = CrystalPalette.MID

    data class DesertLine(
        val speaker: String,
        val text: String,
        val color: Int,
        val trigger: DesertTrigger = DesertTrigger.TIMER,
        val delay: Float = 3f,
        val interrupt: Boolean = false
    )

    enum class DesertTrigger {
        TIMER,
        SCENE_START,
        FIRST_ENEMIES,
        FIRST_KILL,
        SECOND_WAVE,
        AFTER_KILLS,
        PHASE2_START,
        AMBIGUOUS_TARGET,
        NEAR_SETTLEMENT,
        PLAYER_SHOOTS,
        PLAYER_CONTINUES,
        STOP_CHECK,
        PLAYER_FIRES_AFTER_STOP,
        ALL_CLEARED,
        AFTERMATH,
        AUTO,
        CIVILIANS_VISIBLE,
        SIGNATURES_VISIBLE,
        PLAYER_FIRES_AT_CIVILIANS,
        PLAYER_HIT_WALL,
        BOMBARDMENT_DELAY
    }

    val phase1Lines = listOf(
        DesertLine(TB, "看好路，中尉。", TB_COLOR, DesertTrigger.SCENE_START, 2f),
        DesertLine(ASTRO, "你管这叫路，托巴？", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "说得也对。", TB_COLOR, DesertTrigger.TIMER, 3f),
        DesertLine(TB, "北面有接触。轻装甲。", TB_COLOR, DesertTrigger.FIRST_ENEMIES, 1f),
        DesertLine(ASTRO, "收到，托巴。", ASTRO_COLOR, DesertTrigger.TIMER, 3f),
        DesertLine(TB, "打得漂亮。", TB_COLOR, DesertTrigger.FIRST_KILL, 1f),
        DesertLine(TB, "指挥部：目标，北面两格。", TB_COLOR, DesertTrigger.TIMER, 11f),
        DesertLine(ASTRO, "指挥部什么都说。", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "这倒是没法反驳。", TB_COLOR, DesertTrigger.TIMER, 3f),
        DesertLine(TB, "你想过之后的事吗？", TB_COLOR, DesertTrigger.TIMER, 13f),
        DesertLine(ASTRO, "之后什么？", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "这场战争。所有这些。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(ASTRO, "有时候。", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "我总在想之后。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(ASTRO, "是吗？", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "一间酒吧。安静点的地方。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(ASTRO, "你？开酒吧，托巴？", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "记得每个人的名字。酒要好。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "没有命令。没有调度。", TB_COLOR, DesertTrigger.TIMER, 3f),
        DesertLine(ASTRO, "……嗯。也许吧。", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "更多接触。正前方。", TB_COLOR, DesertTrigger.SECOND_WAVE, 1f),
        DesertLine(ASTRO, "外面热闹起来了。", ASTRO_COLOR, DesertTrigger.AFTER_KILLS, 1f),
        DesertLine(TB, "跟从前一样。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(ASTRO, "这就是从前，托巴。", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "哈。说得对，中尉。", TB_COLOR, DesertTrigger.TIMER, 3f)
    )

    val phase2Lines = listOf(
        DesertLine(COMMAND, "已定位目标。聚落中心。", COMMAND_COLOR, DesertTrigger.PHASE2_START, 1f),
        DesertLine(TB, "收到，指挥部。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "中尉……这些读数。", TB_COLOR, DesertTrigger.AMBIGUOUS_TARGET, 1f),
        DesertLine(TB, "信号很轻。太轻了。", TB_COLOR, DesertTrigger.SIGNATURES_VISIBLE, 4f),
        DesertLine(TB, "那些不像战斗人员。", TB_COLOR, DesertTrigger.CIVILIANS_VISIBLE, 1f),
        DesertLine(TB, "中尉。", TB_COLOR, DesertTrigger.TIMER, 6f),
        DesertLine(TB, "他们在跑。", TB_COLOR, DesertTrigger.PLAYER_FIRES_AT_CIVILIANS, 1f),
        DesertLine(TB, "我们该停手。", TB_COLOR, DesertTrigger.STOP_CHECK, 4f)
    )

    val goodEndingLines = listOf(
        DesertLine(TB, "……你停手了。", TB_COLOR, DesertTrigger.AUTO, 6f),
        DesertLine(ASTRO, "他们不是士兵。", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "不。他们不是。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(ASTRO, "指挥部说——", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "我知道指挥部说了什么。", TB_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "回家吧，中尉。", TB_COLOR, DesertTrigger.TIMER, 5f),
        DesertLine(ASTRO, "那间酒吧？", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "那间酒吧。", TB_COLOR, DesertTrigger.TIMER, 4f)
    )

    val horrorLines = listOf(
        DesertLine(ASTRO, "冲不过去。", ASTRO_COLOR, DesertTrigger.PLAYER_HIT_WALL, 1f),
        DesertLine(COMMAND, "按计划实施轰炸。", COMMAND_COLOR, DesertTrigger.NEAR_SETTLEMENT, 1f),
        DesertLine(ASTRO, "指挥部，我不确定这些是——", ASTRO_COLOR, DesertTrigger.TIMER, 3f),
        DesertLine(COMMAND, "你有你的命令，中尉。", COMMAND_COLOR, DesertTrigger.BOMBARDMENT_DELAY, 1.2f, interrupt = true),
        DesertLine(TB, "……我们做了什么？", TB_COLOR, DesertTrigger.AFTERMATH, 6f),
        DesertLine(ASTRO, "……我做了什么？", ASTRO_COLOR, DesertTrigger.TIMER, 4f)
    )

    val crystalLines = listOf(
        DesertLine(CRYSTAL, "我可以撤销这一切。", CRYSTAL_COLOR, DesertTrigger.AUTO, 3f),
        DesertLine(ASTRO, "我不能—— 动手吧。把它修好。", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(TB, "阿星，离它远点！", TB_COLOR, DesertTrigger.TIMER, 3f),
        DesertLine(CRYSTAL, "代价必须有人付。", CRYSTAL_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(ASTRO, "不。不！", ASTRO_COLOR, DesertTrigger.TIMER, 3f),
        DesertLine(TB, "好疼—— 好疼，阿星。", TB_COLOR, DesertTrigger.TIMER, 5f),
        // The reveal. The old name is reached for and the new one arrives in the same breath —
        // this is where the player learns that TOBAR is TB-26, rather than inferring it later
        // from a bartender's voice.
        DesertLine(ASTRO, "……托巴？TB？", ASTRO_COLOR, DesertTrigger.TIMER, 4f),
        DesertLine(CRYSTAL, "代价已付。", CRYSTAL_COLOR, DesertTrigger.TIMER, 5f)
    )

    val allLines: List<DesertLine> = phase1Lines + phase2Lines + goodEndingLines + horrorLines + crystalLines

    /**
     * Whether this pass through the desert withholds the choice.
     *
     * The first pass is on rails: Tobar never says "We should stop.", the branch never arms, and
     * the village is destroyed. The choice returns on every later pass, so reaching the good
     * ending is something the loop grants on a second run at the same moment rather than
     * something available the first time you are there.
     *
     * Keyed on the story loop because the desert recurs with it: the horror path calls
     * `incrementStoryLoop()` and sends the player back around the arc, while the good ending is
     * terminal and enters ASTRO_LOOP. In normal play `incrementStoryLoop()` is only ever called
     * at the end of the horror path, so loop 1 is exactly "has never finished the desert".
     */
    fun isForcedHorror(storyLoop: Int): Boolean = storyLoop <= 1

    /**
     * The phase-1 script, minus Tobar's stop line when the pass is forced.
     *
     * Removing the line removes the branch: its `STOP_CHECK` trigger is what arms the stop check,
     * so a script without it can only end one way. Filtered by trigger rather than by index or
     * text so re-authoring the surrounding lines cannot silently re-arm the choice.
     */
    fun phase2LinesFor(forcedHorror: Boolean): List<DesertLine> =
        if (forcedHorror) phase2Lines.filter { it.trigger != DesertTrigger.STOP_CHECK }
        else phase2Lines
}
