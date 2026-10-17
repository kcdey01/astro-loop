package com.astroloop.game.data

/**
 * A weapon's *presentation* and its place in the evolution tree. Deliberately holds **no combat
 * numbers**.
 *
 * It used to carry `baseDamage`, `baseCooldown`, `baseProjectileSpeed` and `baseProjectileCount`
 * alongside the real ones on the `Weapon` subclasses, and by 2026-08-11 the two had drifted apart
 * in **24 places** — Flak Cannon 33 here against 44 in the class, Phoenix Flare 1 projectile
 * against 8, Oblivion Beam a 1.0s cooldown against 0.1s. Nothing read the copies, which is exactly
 * why nobody noticed: a duplicate no code depends on has nothing holding it honest.
 *
 * They are gone rather than corrected. Syncing two tables leaves two tables, and they would drift
 * again the first time a weapon was tuned. **`WeaponFactory.create(id)` is the one place a
 * weapon's numbers live.** If a screen ever needs to show them, it should ask a real weapon
 * instance rather than a second copy of the truth.
 */
data class WeaponDef(
    val id: String,
    val name: String,
    val description: String,
    val evolutionPassive: String? = null,
    val evolutionWeaponId: String? = null,
    val levelBonuses: List<String> = listOf(
        "基础武器",
        "+30% 伤害",
        "+1 发弹丸",
        "+25% 伤害，+1 发弹丸",
        "+1 发弹丸，满级"
    )
) {
    fun getLevelDescription(level: Int): String {
        return levelBonuses.getOrElse(level - 1) { "满级" }
    }
}

object WeaponDefinitions {

    val weapons = listOf(
        WeaponDef(
            id = "pulse_cannon",
            name = "脉冲炮",
            description = "自动锁定目标的能量弹",
            evolutionPassive = "duplicator_core",
            evolutionWeaponId = "storm_cannon",
            levelBonuses = listOf(
                "1 发能量弹",
                "+1 发能量弹",
                "+1 发能量弹",
                "+1 发能量弹",
                "+1 发能量弹"
            )
        ),
        WeaponDef(
            id = "energy_saw",
            name = "能量锯",
            description = "旋转刀盘，接触即撕裂",
            evolutionPassive = "momentum_drive",
            evolutionWeaponId = "warp_saw",
            levelBonuses = listOf(
                "1 片刀刃",
                "刀刃更大",
                "刀刃更大",
                "刀刃更大",
                "刀刃更大，满级"
            )
        ),
        WeaponDef(
            id = "scatter_shot",
            name = "散射弹",
            description = "近距扇形弹丸",
            evolutionPassive = "vampiric_core",
            evolutionWeaponId = "leech_burst",
            levelBonuses = listOf(
                "5 发弹丸",
                "+2 发弹丸",
                "+2 发弹丸",
                "+2 发弹丸",
                "+2 发弹丸"
            )
        ),
        WeaponDef(
            id = "homing_missiles",
            name = "追踪导弹",
            description = "锁定目标的导弹",
            evolutionPassive = "tb26",
            evolutionWeaponId = "autonomous_ace",
            levelBonuses = listOf(
                "1 枚导弹",
                "+1 枚导弹",
                "+1 枚导弹",
                "+1 枚导弹",
                "+1 枚导弹"
            )
        ),
        WeaponDef(
            id = "ion_orbiters",
            name = "离子环",
            description = "环绕飞船的能量球",
            evolutionPassive = "cryo_field",
            evolutionWeaponId = "frost_ring",
            levelBonuses = listOf(
                "2 个环绕球",
                "+1 个环绕球",
                "+1 个环绕球",
                "+1 个环绕球",
                "+1 个环绕球"
            )
        ),
        WeaponDef(
            id = "railgun",
            name = "电磁炮",
            description = "穿透式狙击弹",
            evolutionPassive = "glass_cannon",
            evolutionWeaponId = "oblivion_beam",
            levelBonuses = listOf(
                "穿透 10 个",
                "弹道更宽",
                "弹道更宽",
                "弹道更宽",
                "光束级宽度，满级"
            )
        ),
        WeaponDef(
            id = "space_mines",
            name = "太空雷",
            description = "投掷式近爆水雷",
            evolutionPassive = "lucky_star",
            evolutionWeaponId = "jackpot_mines",
            levelBonuses = listOf(
                "1 枚太空雷",
                "爆炸范围更大",
                "+1 枚太空雷",
                "爆炸范围更大",
                "+1 枚太空雷"
            )
        ),
        WeaponDef(
            id = "solar_storm",
            name = "太阳风暴",
            description = "随机落雷",
            evolutionPassive = "phoenix_core",
            evolutionWeaponId = "phoenix_flare",
            levelBonuses = listOf(
                "1 个目标",
                "+1 个目标",
                "+1 个目标",
                "+1 个目标",
                "+1 个目标"
            )
        ),
        WeaponDef(
            id = "nova_blast",
            name = "新星爆发",
            description = "以飞船为中心爆开冲击环",
            evolutionPassive = "revenge_protocol",
            evolutionWeaponId = "lingering_nova",
            levelBonuses = listOf(
                "基础爆发",
                "半径更大",
                "半径更大",
                "半径更大",
                "半径更大"
            )
        ),
        WeaponDef(
            id = "needle_gun",
            name = "针枪",
            description = "高速穿透飞针",
            evolutionPassive = "nano_repair",
            evolutionWeaponId = "siphon_needles",
            levelBonuses = listOf(
                "3 根飞针",
                "+1 根飞针",
                "+1 根飞针",
                "+1 根飞针",
                "+1 根飞针"
            )
        ),
        WeaponDef(
            id = "cluster_bomb",
            name = "集束炸弹",
            description = "炸开后散出子弹药",
            evolutionPassive = "magnet_field",
            evolutionWeaponId = "hunter_killer",
            levelBonuses = listOf(
                "2 枚子弹药",
                "+1 枚子弹药",
                "+1 枚子弹药",
                "+1 枚子弹药",
                "+1 枚子弹药"
            )
        ),
        WeaponDef(
            id = "flak_cannon",
            name = "高射炮",
            description = "直射爆破弹",
            evolutionPassive = "extra_weapon_slot",
            evolutionWeaponId = "flak_barrage",
            levelBonuses = listOf(
                "1 发炮弹",
                "+1 发炮弹",
                "+1 发炮弹",
                "+1 发炮弹",
                "+1 发炮弹"
            )
        )
    )

    // Evolution weapons (unlocked by combining weapon + passive)
    val evolutions = listOf(
        WeaponDef(
            id = "storm_cannon",
            name = "风暴炮",
            description = "螺旋弹流铺满全场",
        ),
        WeaponDef(
            id = "warp_saw",
            name = "曲率锯",
            description = "刀盘脱体，自行猎杀",
        ),
        WeaponDef(
            id = "leech_burst",
            name = "汲取爆",
            description = "命中即回血的弹丸",
        ),
        WeaponDef(
            id = "autonomous_ace",
            name = "自主王牌",
            description = "导弹分裂，追猎新目标",
        ),
        WeaponDef(
            id = "frost_ring",
            name = "霜环",
            description = "双环能量球，永不停转",
        ),
        WeaponDef(
            id = "oblivion_beam",
            name = "湮灭光矛",
            description = "持续不断的穿透光矛",
        ),
        WeaponDef(
            id = "jackpot_mines",
            name = "赌徒之雷",
            description = "偶尔中头奖的太空雷",
        ),
        WeaponDef(
            id = "phoenix_flare",
            name = "凤凰耀斑",
            description = "在敌人脚下爆开三重火环",
        ),
        WeaponDef(
            id = "lingering_nova",
            name = "余烬新星",
            description = "爆开、留下核心、再次爆开",
        ),
        WeaponDef(
            id = "siphon_needles",
            name = "虹吸针",
            description = "穿透飞针，命中即回血",
        ),
        WeaponDef(
            id = "hunter_killer",
            name = "猎杀者",
            description = "追踪鱼雷，射速翻倍",
        ),
        WeaponDef(
            id = "flak_barrage",
            name = "高射弹幕",
            description = "一次齐射五发爆破弹",
        )
    )

    fun getWeaponDef(id: String): WeaponDef? {
        return weapons.find { it.id == id } ?: evolutions.find { it.id == id }
    }

    fun getBaseWeapons(): List<WeaponDef> = weapons

    fun getEvolutionFor(weaponId: String, passiveId: String): WeaponDef? {
        val weapon = weapons.find { it.id == weaponId } ?: return null
        if (weapon.evolutionPassive == passiveId) {
            return evolutions.find { it.id == weapon.evolutionWeaponId }
        }
        return null
    }

    fun isEvolution(id: String): Boolean = evolutions.any { it.id == id }

    fun getWeaponDisplayName(weaponId: String): String {
        return getWeaponDef(weaponId)?.name ?: weaponId
    }

    fun getEvolutionDisplayName(evolutionId: String, activePilotId: String): String {
        if (evolutionId == "autonomous_ace") {
            return if (activePilotId == "pilot_astro") "TB-26-X" else "自主王牌"
        }
        return getWeaponDef(evolutionId)?.name ?: evolutionId
    }

    /**
     * Pilot-aware weapon icon id. Astro's Autonomous Ace (TB-26-X) uses its own icon, but
     * only outside Astro-Loop runs — there the drone is the generic green one — mirroring the
     * TB-26 drone rule in PassiveDefinitions.getDroneColor().
     */
    fun getWeaponIconId(weaponId: String, activePilotId: String, isAstroLoop: Boolean = false): String {
        if (weaponId == "autonomous_ace" && activePilotId == "pilot_astro" && !isAstroLoop) return "tb26_x"
        return weaponId
    }
}
