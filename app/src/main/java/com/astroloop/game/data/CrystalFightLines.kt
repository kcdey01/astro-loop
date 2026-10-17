package com.astroloop.game.data

import com.astroloop.game.system.CrystalPhase

object CrystalFightLines {
    // All radio lines <=35 chars — the HUD radio budget for Exo 2 at 24px.

    /**
     * The crystal's first words, over the authored opening — design decisions.
     *
     * **Rewritten for the cabinet.** This used to be ASTRO's monologue, shown at 3s/10s/17s
     * of a fight that no longer exists, and it survived stage 3 only as dead code. A design decision
     * gives the voice to the CRYSTAL, which changes who is speaking and therefore every
     * line.
     *
     * The premise it is authored against, and every word answers to it: **it was never
     * picked up in the desert. It was left. It festered. It has come back.**
     *
     * It accuses whoever is flying. That is not a continuity slip — the reckoning is
     * reachable by any of the twelve, and the crystal has been alone long enough that it no
     * longer distinguishes. Everyone who comes is the one who left it.
     */
    val opening = listOf(
        "你把我留在了沙里。",
        "没人回来找我。",
        "所以我来了这里。"
    )

    /**
     * Phase lures (CRYSTAL): part 1 on the phase change, part 2 +3.5s.
     *
     * The crystal is a LURE, not a taunt. Every line is an invitation to STOP — and stopping
     * is exactly what kills you. It never mocks the running; grief doesn't chase you screaming,
     * it whispers rest, stay, come back. The trap is never stated out loud: the player feels it.
     *
     * THE PILOT SPEAKS ZERO LINES. Answering is engaging, and engaging is stopping; the
     * silence is the refusal. (This used to say ASTRO, and pointed at a first word "in the
     * ghost phase" — a phase stage 3 deleted. The property survives the fight it was written
     * for: whoever is flying, they do not answer.)
     */
    fun taunt(p: CrystalPhase): Pair<String, String?> = when (p) {
        CrystalPhase.P1 -> "你回来了。" to "他们总会回来。"           // recognition
        CrystalPhase.P2 -> "把我捡起来。再来一轮。" to "没有什么必须结束。"  // invitation
        CrystalPhase.P3 -> "他们都还在里面。" to "你失去的每一个。"  // the offer
        CrystalPhase.P4 -> "我们还可以重新开始。" to "你和我。再一次。"        // the bargain
        CrystalPhase.P5 -> "留下——留下……" to null                                // desperation
    }

    /**
     * What the crystal says when you try to stop — a design decision.
     *
     * The pause belongs to the machine, and the machine is not the machine's any more. It
     * takes the menu, says one of these, and hands the fight back.
     *
     * The register is NOT the lure's. Everywhere else the crystal invites you to stop,
     * because stopping is what kills you; here you have already stopped, and it wants you
     * back in the air. That inversion is the mask slipping, so these are the only lines it
     * speaks that are not an offer.
     */
    val pauseDenial = listOf(
        "还不行。",
        "你没资格停下。",
        "待在我看得见的地方。"
    )

    // <=~58 chars each (bar chatter column budget)

    /**
     * The crystal's last word — a design decision. Shown in the gel strip through the win hold.
     *
     * It answers *"STAY - STAY..."*, which is SHATTER's lure and therefore the last thing
     * the player hears before killing it. The whole fight is the crystal asking someone not
     * to leave; this is what it says when they end it instead.
     *
     * **Gratitude, because the ending is a RELEASE and not a kill.** The flag has always
     * been called `crystal_released`. Nothing this thing says is ever a threat — it pleads,
     * it bargains, it offers to give back what was lost. It was left in the desert and it
     * festered, and killing it lets it go.
     *
     * There is no equivalent on a LOSS. A crystal that outlives you has nothing to thank
     * you for.
     */
    const val farewell = "……谢谢你。"

    /**
     * Bar chatter on the WIN — a design decision, and rewritten from the ground rather than
     * trimmed.
     *
     * **The pilot is not in it.** They say nothing about the fight, anywhere, which is the
     * same refusal they hold through all five patterns — and it fixes a real defect by
     * deletion: this list hardcodes its speakers, while a design decision makes the reckoning
     * reachable for any of the twelve, so a win on WHISKERS used to show ASTRO reporting
     * what happened out there.
     *
     * That is also why the old lines could not survive. Both of MEDIC's were REPLIES -
     * "Reach us?" answered the pilot's "It won't reach us now", and "Out where?" answered
     * "You'd have liked it out there, Medic". Remove the pilot and they are left answering
     * questions nobody asked.
     *
     * The gap is still the whole story: the room got better and nobody in it can be told
     * why. "Not waiting any more" is release rather than a kill, and it quietly answers the
     * crystal's own opening - "Nobody came back for me." Someone finally did.
     */
    val barChatter = listOf(
        "TOBAR" to "外面有什么东西安静下来了。",
        "MEDIC" to "什么？",
        "TOBAR" to "……我不知道。但它不再等谁了。"
    )
}
