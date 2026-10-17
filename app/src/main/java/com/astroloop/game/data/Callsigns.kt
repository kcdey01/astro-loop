package com.astroloop.game.data

/**
 * Chinese display names for the crew's callsigns.
 *
 * The callsign strings themselves stay Latin in the data on purpose: they are **keys**, not
 * only labels. `ChatSystem` looks up idle lines, hints and arrival responses by
 * `PilotDefinitions.callsign`, and the bar data files tag every line with the same string, so
 * translating them at the source would silently empty half the conversation pools. Translation
 * therefore happens at the last moment, on the way to the screen.
 *
 * TB-26 stays as-is: it is a unit designation, the way R2-D2 is, and it is also compared against
 * by string in the boss-hint and story code.
 */
object Callsigns {

    private val zh: Map<String, String> = mapOf(
        "MEDIC" to "医官",
        "RASCAL" to "痞子",
        "BRUTUS" to "蛮熊",
        "FROST" to "寒霜",
        "DASH" to "疾风",
        "EMBER" to "余烬",
        "FANG" to "獠牙",
        "KRAKEN" to "海妖",
        "WHISKERS" to "猫须",
        "UNIT-7" to "七号",
        "HAVOC" to "狂徒",
        "ASTRO" to "阿星",
        "TOBAR" to "托巴",
        "CRYSTAL" to "水晶",
        "COMMAND" to "指挥部"
    )

    /** Chinese name for [callsign], or [callsign] itself when it has none (TB-26, BOSS, …). */
    fun of(callsign: String): String = zh[callsign] ?: callsign
}
