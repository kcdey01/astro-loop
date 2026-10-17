package com.astroloop.game.data

/**
 * TB-26's nudges for the ten-minute boss.
 *
 * The boss has exactly one answer: fly as Astro, whose passive brings TB-26 along, and survive it.
 * Every other pilot is out there alone and dies. Players were reaching nine and ten minutes
 * repeatedly without ever learning that, which is a frustrating way to meet a wall.
 *
 * Which nudge lands depends on why the run failed, and the split matters more than the wording:
 * telling someone already flying Astro not to go alone is nonsense, and nonsense from the one
 * character who can see the player costs him the authority the hints depend on.
 *
 * Hints escalate with repeated failures and never run out — the last one keeps being given,
 * because a player still failing at the fifth attempt is exactly who needs it.
 */
object BossHintDefinitions {

    /** Why the last attempt failed, which decides what TB-26 says about it. */
    enum class Track {
        /** Died past ten minutes flying anyone but Astro: the answer is company. */
        SOLO,

        /** Died past ten minutes as Astro: the answer is already in hand, so endure. */
        ASTRO
    }

    /**
     * For a pilot who keeps going out alone. Escalates from an observation to a next step, stopping
     * short of naming Astro — tapping a pilot shows their passive, so "doesn't fly alone" is
     * followable, and finding it is a better moment than being handed it.
     *
     * The last rung has to survive **Astro unlocking on ALL_OTHERS**, because it is the rung that
     * repeats forever: whoever is still failing on the fifth attempt reads it, and they may or may
     * not have him by then. So it names no pilot and asks for no particular next step — "find him"
     * is something the player can act on either way, recruiting him if he is locked and selecting
     * him if he is not. An earlier version said "keep recruiting", which was nonsense to anyone
     * who already had the whole roster, and nonsense from the one character who can see the player
     * costs him the authority the hints depend on.
     */
    private val soloHints = listOf(
        "撑到十分钟了。没人能独自走到这一步。",
        "还是一个人出任务，我看得出来。",
        "有个人从不单飞。去找他。"
    )

    /** For a pilot who has the answer and is still dying: stop trading, start lasting. */
    private val astroHints = listOf(
        "很接近了。你只要还留在那儿就行。",
        "别想着打赢它。活得比它久。",
        "它自己会结束。撑到那时候。"
    )

    /**
     * How each pilot reacts to TB-26 addressing someone who is not in the room.
     *
     * Keyed by callsign because any of them may be the one who just came back, and a shared pool
     * would flatten twelve voices into one shrug. Each line is the pilot noticing the same thing
     * in their own way — none of them can see the commander, and none of them ever address the
     * commander either. Only TB-26 does both.
     *
     * Lengths respect the per-speaker chat-column budget, which is tighter for longer callsigns:
     * WHISKERS gets 55 characters where DASH gets 59. A test holds every line to its own.
     *
     * "TB-26" is safe to say here: hints only fire in normal mode, where he is not yet Tobar.
     */
    val crewReactions = mapOf(
        "MEDIC" to "TB-26，那儿没人。要不要给你做个扫描？",
        "RASCAL" to "他在跟谁说话？有钱可赚吗？",
        "FROST" to "他常这样。我已经不算这是为什么了。",
        "UNIT-7" to "未检测到接收方。TB-26 可能存在故障。",
        "DASH" to "又在跟空气说话？行吧。能走了吗？",
        "BRUTUS" to "……那儿没人。",
        "EMBER" to "他在跟鬼说话。这股戏我尊重。",
        "FANG" to "这屋里没有第二个心跳。就他一个。",
        "KRAKEN" to "他在对深渊说话。深渊没在听。",
        "WHISKERS" to "无聊。要么跟我说话，要么别说。",
        "HAVOC" to "你到底在跟谁说话？！是我吗？是我吧？",
        "ASTRO" to "小心点，TB-26。你会让其他人担心的。"
    )

    /** The returning pilot's reaction, falling back so the wiring can never end in silence. */
    fun reactionFor(callsign: String): String =
        crewReactions[callsign] ?: "……他在跟谁说话？"

    fun linesFor(track: Track): List<String> = when (track) {
        Track.SOLO -> soloHints
        Track.ASTRO -> astroHints
    }

    /**
     * The hint owed after [failures] failed attempts on [track], or null before the first one.
     *
     * Clamps to the last line rather than running out, so the most explicit nudge repeats for as
     * long as the player keeps hitting the wall.
     */
    fun hintFor(track: Track, failures: Int): String? {
        if (failures <= 0) return null
        val lines = linesFor(track)
        return lines[(failures - 1).coerceAtMost(lines.size - 1)]
    }
}
