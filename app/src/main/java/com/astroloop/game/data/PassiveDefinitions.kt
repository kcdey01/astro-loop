package com.astroloop.game.data

data class PassiveDef(
    val id: String,
    val name: String,
    val description: String,
    val effectPerStack: String
)

object PassiveDefinitions {

    val passives = listOf(
        PassiveDef(
            id = "nano_repair",
            name = "纳米修复",
            description = "随时间恢复生命",
            effectPerStack = "+0.4 生命/秒"
        ),
        PassiveDef(
            id = "duplicator_core",
            name = "复制核心",
            description = "额外增加一发弹丸",
            effectPerStack = "所有武器 +1 发弹丸"
        ),
        PassiveDef(
            id = "magnet_field",
            name = "磁场",
            description = "扩大拾取范围",
            effectPerStack = "+30% 拾取范围"
        ),
        PassiveDef(
            id = "phoenix_core",
            name = "凤凰核心",
            description = "死亡时复活一次",
            effectPerStack = "一次性复活"
        ),
        PassiveDef(
            id = "extra_weapon_slot",
            name = "武器扩容",
            description = "获得第 5 个武器槽",
            effectPerStack = "+1 武器槽\n-1 被动槽"
        ),
        PassiveDef(
            id = "tb26",
            name = "TB-26",
            description = "与 TB-26 并肩作战",
            effectPerStack = "+1 架无人机"
        ),
        PassiveDef(
            id = "combat_drone",
            name = "战斗无人机",
            description = "部署战斗无人机",
            effectPerStack = "+1 架无人机"
        ),
        PassiveDef(
            id = "momentum_drive",
            name = "动量驱动",
            description = "移动时伤害提升",
            effectPerStack = "移动时\n+8% 伤害"
        ),
        PassiveDef(
            id = "cryo_field",
            name = "低温场",
            description = "飞船周围形成减速区",
            effectPerStack = "+25% 范围"
        ),
        PassiveDef(
            id = "lucky_star",
            name = "幸运星",
            description = "更多强化，随机选择",
            effectPerStack = "自动强化\n+50% 掉落"
        ),
        PassiveDef(
            id = "revenge_protocol",
            name = "报复协议",
            description = "受击后射速爆发",
            effectPerStack = "受击后\n射速 ×2"
        ),
        PassiveDef(
            id = "vampiric_core",
            name = "吸血核心",
            description = "从附近陨石汲取生命",
            effectPerStack = "每颗陨石\n+0.1 生命/跳"
        ),
        PassiveDef(
            id = "glass_cannon",
            name = "玻璃大炮",
            description = "没有护盾，极高伤害",
            effectPerStack = "+100% 伤害，护盾失效"
        )
    )

    fun getPassiveDef(id: String): PassiveDef? {
        return passives.find { it.id == id }
    }

    fun getAllPassives(): List<PassiveDef> = passives

    const val ASTRO_PILOT_ID = "pilot_astro"
    const val DRONE_COLOR_COMBAT = 0xFF55CC66.toInt()   // Tactical green
    const val DRONE_COLOR_TB26 = 0xFF88AACC.toInt()      // Steel blue

    fun getDisplayName(passiveId: String, activePilotId: String, isAstroLoopRun: Boolean = false): String {
        if (passiveId == "tb26") {
            return if (activePilotId == ASTRO_PILOT_ID && !isAstroLoopRun) "TB-26" else "战斗无人机"
        }
        return getPassiveDef(passiveId)?.name ?: passiveId
    }

    fun getDroneColor(passiveId: String, activePilotId: String, isAstroLoopRun: Boolean = false): Int {
        return if (passiveId == "tb26" && activePilotId == ASTRO_PILOT_ID && !isAstroLoopRun)
            DRONE_COLOR_TB26
        else
            DRONE_COLOR_COMBAT
    }

    fun getEffectivePassiveId(passiveId: String, activePilotId: String, isAstroLoopRun: Boolean = false): String {
        return if (passiveId == "tb26" && activePilotId == ASTRO_PILOT_ID && isAstroLoopRun)
            "combat_drone"
        else passiveId
    }
}
