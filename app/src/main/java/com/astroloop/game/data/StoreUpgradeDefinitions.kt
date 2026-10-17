package com.astroloop.game.data

import com.astroloop.game.core.GameConfig
import kotlin.math.roundToInt

/**
 * The permanent upgrades sold in the hangar store, in the order they are laid out.
 *
 * Lifted out of `StorePageRenderer.drawStorePage` so the copy is testable and sits with every other
 * definitions object. **The order is the layout** — the renderer walks this list and derives each
 * tile's row and column from its index across a 3-wide grid, so reordering moves tiles on screen.
 *
 * The store's fiction is black-market salvage, and the names carry it. `Salvage Plate` (hull) and
 * `Scavenger Rig` (drops) reading as near-synonyms is deliberate flavour, not an oversight.
 */
object StoreUpgradeDefinitions {

    /** How a value is written on a card back. */
    enum class Format { FLAT, PERCENT }

    /**
     * What kind of number a card can honestly print for an effect.
     *
     * Only some of the eight tiles have an absolute worth showing. Speed's underlying unit is
     * pixels per second, the magnet's is pixels, yen and salvage are rate multipliers, and damage
     * has no single base at all — it is per weapon. Printing those raw would be worse than
     * printing nothing.
     */
    enum class Readout {
        /** A stat the ship already has some of: "Health 80". */
        FROM_BASE,
        /** A real absolute that starts at zero: "Crit 15%". */
        ABSOLUTE,
        /** No meaningful absolute, so state the gain: "+15% ship speed". */
        RELATIVE
    }

    /**
     * One line of a tile's effect.
     *
     * [perLevel] is the amount a single level grants. The card multiplies it by the owned level for
     * the "now" figure and prints it bare for the "next" figure, so there is exactly one number here
     * and no second copy to drift.
     *
     * [shown] exists for the magnet's pull speed. The owner cut that number from the card as not
     * relevant to players, but the game still applies it, and `StoreUpgradeAgreementTest` pins it
     * against `GameState` — so it stays in the data and is skipped at the point of printing rather
     * than deleted, which would quietly drop the guard.
     */
    data class UpgradeEffect(
        val label: String,
        val perLevel: Float,
        val format: Format,
        val readout: Readout = Readout.RELATIVE,
        val base: Float = 0f,
        val shown: Boolean = true
    ) {
        // roundToInt(), not toInt(): the perLevel constants in use today all land on whole numbers,
        // but nothing about the type guarantees that — a future perLevel like 0.29f would truncate
        // its level-1 figure down a point with a green suite next to it. See
        // StoreUpgradeDefinitionsTest for the pinned value that would fail under truncation.
        private fun amount(level: Int): Int = when (format) {
            Format.FLAT -> (perLevel * level).roundToInt()
            Format.PERCENT -> (perLevel * level * 100f).roundToInt()
        }

        /** The figure as it appears on the card at [level]. */
        fun at(level: Int): String = when (readout) {
            Readout.FROM_BASE -> "$label ${(base + perLevel * level).roundToInt()}"
            Readout.ABSOLUTE -> "$label ${amount(level)}%"
            Readout.RELATIVE -> when (format) {
                Format.FLAT -> "+${amount(level)} $label"
                Format.PERCENT -> "+${amount(level)}% $label"
            }
        }

        /** What one more level adds, with no label — it sits under the figure it belongs to. */
        fun delta(): String = when (format) {
            Format.FLAT -> "+${amount(1)}"
            Format.PERCENT -> "+${amount(1)}%"
        }

        /**
         * Whether this figure says anything at [level].
         *
         * An absolute is information even at zero — "Health 50" is the ship you are flying now, and
         * showing it was the point of the change. A relative one at zero is "+0% ship speed", which
         * is noise on the card of exactly the player who has never bought this tile.
         */
        fun statesSomethingAt(level: Int): Boolean =
            shown && (readout != Readout.RELATIVE || level > 0)
    }

    /**
     * @param id the key the level is persisted under, and `null` for a tile that is not bought.
     * @param detail one plain sentence of what the upgrade does, shown on the card back. Literal
     *   rather than flavoured: the back exists to answer a purchase question, and the tile names
     *   already carry the atmosphere.
     * @param effects usually one line; the magnet is the only tile granting two separate things.
     */
    data class UpgradeTile(
        val name: String,
        val id: String?,          // null = NG+ locked
        val effect: String,
        val isNgPlus: Boolean = false,
        val detail: String = "",
        val effects: List<UpgradeEffect> = emptyList()
    ) {
        /**
         * The figures the card prints at [level], one string per shown effect.
         *
         * Absolutes appear at every level, including zero — "Health 50" is the ship you fly today.
         * Relatives drop out at zero, where they would only say "+0%".
         */
        fun effectsAt(level: Int): List<String> =
            effects.filter { it.statesSomethingAt(level) }.map { it.at(level) }

        /** What one more level buys, one string per shown effect. */
        fun nextDeltas(): List<String> = effects.filter { it.shown }.map { it.delta() }
    }

    val tiles = listOf(
        // Row 1 — Survival
        UpgradeTile(
            "打捞装甲板", "health", "+10 最大生命",
            detail = "能扛更多次伤害。",
            effects = listOf(
                UpgradeEffect("生命", 10f, Format.FLAT, Readout.FROM_BASE, base = GameConfig.SHIP_BASE_HEALTH)
            )
        ),
        UpgradeTile(
            "偏导装置", "shields", "+10 最大护盾",
            detail = "能吸收更多次伤害。",
            effects = listOf(
                UpgradeEffect("护盾", 10f, Format.FLAT, Readout.FROM_BASE, base = GameConfig.SHIP_BASE_SHIELDS)
            )
        ),
        UpgradeTile(
            "氮气加速", "speed", "+5% 飞船速度",
            detail = "飞得更快。",
            effects = listOf(UpgradeEffect("飞船速度", 0.05f, Format.PERCENT))
        ),
        // Row 2 — Combat
        UpgradeTile(
            "热弹", "damage", "+5% 全部伤害",
            detail = "所有武器的伤害都更高。",
            effects = listOf(UpgradeEffect("全部伤害", 0.05f, Format.PERCENT))
        ),
        UpgradeTile(
            "幸运弹", "crit", "+5% 暴击率",
            detail = "部分攻击造成双倍伤害。",
            effects = listOf(
                UpgradeEffect("暴击", 0.05f, Format.PERCENT, Readout.ABSOLUTE)
            )
        ),
        UpgradeTile(
            "拖运索", "magnet", "+15% 拾取范围",
            detail = "能在更远处吸取星尘。",
            effects = listOf(
                UpgradeEffect("拾取范围", 0.15f, Format.PERCENT),
                // Kept, never printed: the owner cut the pull number as not player-relevant, but the
                // game still applies it and the agreement test still pins it against GameState.
                UpgradeEffect("吸取速度", 0.20f, Format.PERCENT, shown = false)
            )
        ),
        // Row 3 — Economy + NG+
        UpgradeTile(
            "寻宝佣金", "yen_bonus", "+20% 円币收益",
            detail = "每局获得更多円币。",
            effects = listOf(UpgradeEffect("円币收益", 0.20f, Format.PERCENT))
        ),
        UpgradeTile(
            "拾荒装置", "salvage", "+20% 掉落率",
            detail = "陨石更常掉落强化。",
            effects = listOf(UpgradeEffect("强化掉落", 0.20f, Format.PERCENT))
        ),
        UpgradeTile("应急护盾", "emergency_shield", "挡下一次致命伤害", isNgPlus = true)
    )

    /**
     * The ids a player actually spends yen on.
     *
     * Every one of these must survive a save and be cleared by a reset. An id here that
     * `PersistenceManager` does not know about produces a tile that silently forgets what it sold,
     * which is why there is a test walking this list rather than a hardcoded copy of it.
     */
    val purchasableIds: List<String> = tiles.filter { !it.isNgPlus }.mapNotNull { it.id }
}
