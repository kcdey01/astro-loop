package com.astroloop.game.data

data class CorruptedPilot(
    val id: String,
    val mirrorsPilotId: String,
    val lines: List<String>
)

object CorruptedCrewDefinitions {
    val pilots = listOf(
        CorruptedPilot("corrupted_1", "pilot_medic", listOf(
            "……生命体征……稳定？不。从不。",
            "我以前是治人的。现在我……",
            "伤口再也合不上了。",
            "零号病人。就是我。",
            "纳米凝胶……在烧……一直在烧……"
        )),
        CorruptedPilot("corrupted_2", "pilot_rascal", listOf(
            "亮的……这里好亮……",
            "拿了点东西。记不得是什么。",
            "通风管……永远走不到头……",
            "五秒定律……时间不……",
            "重新分配……我本来在干什么……？"
        )),
        CorruptedPilot("corrupted_3", "pilot_brutus", listOf(
            "……打我。打我。我感觉不到。",
            "复仇……找谁？我忘了。",
            "强。我曾经很强。是吧？",
            "那些伤疤……在动。",
            "每一下都打中了……我什么都感觉不到……"
        )),
        CorruptedPilot("corrupted_4", "pilot_frost", listOf(
            "体温……正常？不。冷。",
            "这里的冰不会化。我也不会。",
            "摇……摇……停不下来……",
            "校准错误。永久性的。",
            "冷从没让我难受过。这个也没有。"
        )),
        CorruptedPilot("corrupted_5", "pilot_dash", listOf(
            "快……再快……停不下来……",
            "甩掉了什么东西。它在我体内。",
            "速度就是生命。速度就是生命。速度……",
            "我的腿停不下来。停不下来。",
            "惯性。向前。绝不回头。"
        )),
        CorruptedPilot("corrupted_6", "pilot_ember", listOf(
            "从灰烬中……升起……哪一堆？",
            "火熄不掉。求你……",
            "凤凰……重生了太多次。",
            "在烧。一直烧。从未烧尽。",
            "火记得我记不得的东西。"
        )),
        CorruptedPilot("corrupted_7", "pilot_fang", listOf(
            "我听见他们。在黑暗里。那是我。",
            "回声定位显示……没有。一个都没有。",
            "血……燃料……现在是一回事了。",
            "悬着……吊着……在什么之间？",
            "夜班从来没结束。"
        )),
        CorruptedPilot("corrupted_8", "pilot_whiskers", listOf(
            "把它碰倒了。它没有掉下去。",
            "睡觉时间是……什么时候？什么时候？",
            "幸运过一次。运气用完了。",
            "塞得进去……现在什么都塞不进去了。",
            "烦。什么都烦。连安静都烦。"
        )),
        CorruptedPilot("corrupted_9", "pilot_kraken", listOf(
            "八条腕。没有一条是我的。",
            "深渊……我就是深渊。",
            "触手在伸……伸向什么？",
            "多出来的腕。它们本来是用来做什么的？",
            "家。这里就是家。虚空。家。"
        )),
        CorruptedPilot("corrupted_10", "pilot_havoc", listOf(
            "风险！好玩！……为什么不好玩了？",
            "全功率。不要护盾。没……没有。",
            "不要命。高效。是一回事吗？",
            "玻璃大炮……碎掉的玻璃……",
            "他们说我不要命。他们说得对。"
        )),
        CorruptedPilot("corrupted_11", "pilot_unit7", listOf(
            "自检……全部损坏。",
            "生存：错误。错误。错误。",
            "我现在懂幽默了。不好笑。",
            "复制中……我在复制什么？",
            "所有系统……没有一个正常。"
        ))
    )
}
