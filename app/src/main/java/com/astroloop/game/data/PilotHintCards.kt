package com.astroloop.game.data

/**
 * What the bar has written on a locked pilot's card, once somebody has hinted about them.
 *
 * A hint is spoken once, in passing, several runs before the player can act on it — and then it is
 * gone. The card is where it stays: after the hint drops, the `?` on that pilot becomes a short
 * note of what the bar knows, which is a reminder of how to earn them.
 *
 * **These are notes, not speech.** Third person, in quotes, about the pilot rather than to anyone —
 * so nothing here addresses the commander, which is TB-26's alone.
 *
 * The notes deliberately restate the *condition* rather than the pilot's character. The idle
 * chatter already carries the character ("A raccoon type asked about openings"); what the player
 * cannot recover once the conversation has scrolled away is what they are supposed to go and do.
 */
object PilotHintCards {

    /**
     * Keyed by pilot id. MEDIC has none — she is free and never locked.
     *
     * ASTRO's note names **both** halves of `ALL_OTHERS`: every pilot *and* every ship. A note that
     * said only "a full crew" would mislead a player sitting one hull short of him, and his is the
     * only condition a player can complete half of without noticing.
     */
    val notes: Map<String, String> = mapOf(
        "pilot_rascal" to "「在找円币。」",
        "pilot_brutus" to "「敬重伤疤。」",
        "pilot_frost" to "「想要一支能活下来的队伍。」",
        "pilot_dash" to "「从不停下。」",
        "pilot_ember" to "「数着你回来的次数。」",
        "pilot_fang" to "「要在战绩板上见血。」",
        "pilot_kraken" to "「喜欢花样。」",
        "pilot_whiskers" to "「在老虎机旁等你。」",
        "pilot_unit7" to "「想要大数字。」",
        "pilot_havoc" to "「为深入长跑而活。」",
        "pilot_astro" to "「要集齐所有机师和飞船。」"
    )

    private val astroIndex = PilotDefinitions.pilots.indexOfFirst { it.id == "pilot_astro" }

    /**
     * The note to draw on [pilotIndex]'s locked card, or null to leave the `?` alone.
     *
     * @param hintedPilotIndex the highest pilot index whose hint has been spoken by the pilot
     *   before them (HAVOC hints about Astro, so this can reach Astro's index). Persisted, because a reminder that forgets itself when the app closes is not
     *   a reminder.
     * @param astroHinted whether TB-26 has given at least one of his own Astro hints. Astro is the
     *   one pilot foreshadowed from two directions — TB-26's `astroHintLines` and HAVOC's entry in
     *   the pilot chain — so his card reveals on either, not on TB's alone.
     * @param hasLoopedBefore from story loop 2 onward, `checkPilotUnlockCondition` unlocks any
     *   non-Astro pilot after a single run whatever their stated condition says. A note about yen
     *   or kills would be actively wrong there, so every card goes back to `?`.
     */
    fun cardFor(
        pilotIndex: Int,
        hintedPilotIndex: Int,
        astroHinted: Boolean,
        hasLoopedBefore: Boolean
    ): String? {
        if (hasLoopedBefore) return null
        val pilot = PilotDefinitions.getPilotByIndex(pilotIndex) ?: return null
        val note = notes[pilot.id] ?: return null
        // Astro is foreshadowed twice over, by design: TB-26 through his own astroHintLines, and
        // HAVOC through the chain, two people noticing the same stranger. Either landing means the
        // bar has learned something, so either reveals the card — keying only off TB's would leave
        // a player who happened to hear HAVOC staring at a "?" about something already told to them.
        val hinted =
            if (pilotIndex == astroIndex) astroHinted || pilotIndex <= hintedPilotIndex
            else pilotIndex <= hintedPilotIndex
        return if (hinted) note else null
    }
}
