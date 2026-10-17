# 星际回环 / Astro Loop —— 简体中文汉化版

本仓库是 [PubDeer/astro-loop](https://github.com/PubDeer/astro-loop) 的简体中文本地化分支。
游戏本体为 GPL-3.0-only,本分支的修改同样遵循 GPL-3.0。

## 做了什么

| 项目 | 说明 |
|---|---|
| 游戏名 | Astro Loop → **星际回环** |
| 剧情与对话 | 酒吧闲聊 1200+ 句、无线电 600+ 句、剧情/沙漠/水晶线全量翻译 |
| 内容定义 | 武器 24 种、被动 12 种、飞船 12 艘、机师 12 位、敌人 12 种、商店 9 项、教程与提示卡 |
| 界面 | 机库、商店、黑市、升级选择、HUD、暂停、死亡界面等全部中文 |
| 字体 | 内置 Noto Sans SC 子集(约 520 KB/字重),作为 Exo 2 / Orbitron 的回退字体 |
| 排版 | 换行算法支持中文按字断行,避免标点出现在行首;截断仍按实测宽度计算 |

## 汉化实现要点

1. **文本直接在数据层替换**,不做运行时语言切换。原因:游戏原本没有任何 i18n 层
   (`strings.xml` 只有一个 `app_name`),所有文案硬编码在 Kotlin 里;直接替换可以保证
   零漏译,也不会因为查表失败而回退成英文。
2. **机师代号保持拉丁字符串作为内部键**:`ChatSystem` 用 `PilotDefinitions.callsign`
   去索引闲聊池、提示和归来反应,直接改字符串会静默清空一半对话。因此中文名在显示层
   通过 `data/Callsigns.kt` 映射(`MEDIC` → 医官、`DASH` → 疾风 …),数据键不变。
3. **中文字体走回退链**:Android 10+ 用 `Typeface.CustomFallbackBuilder` 把 Noto Sans SC
   挂在 Exo 2 / Orbitron 后面,拉丁字母和数字保留原版科幻字形,中文由思源黑体渲染;
   Android 9 及以下没有该 API,直接使用中文字体(宁可牺牲拉丁字形,也不能出现豆腐块)。
4. **街机模式(`BELT RUN` / `HIGH SCORE` 等)保留英文**:那台机器的文字是
   `CabinetFont` 用笔画矢量画出来的 A–Z/0–9 字模,没有汉字字形,硬译会变成空白。
   这部分按"街机柜上的原厂英文铭牌"处理,属于有意的设计选择。

## 构建

```bash
# 需要 Android SDK 36 + JDK 17
./gradlew :app:assembleGameDebug
# 产物:app/build/outputs/apk/game/debug/app-game-debug.apk
```

## 术语表(节选)

| 英文 | 中文 | 英文 | 中文 |
|---|---|---|---|
| Pulse Cannon | 脉冲炮 | Nano Repair | 纳米修复 |
| Railgun | 电磁炮 | Glass Cannon | 玻璃大炮 |
| Flak Cannon | 高射炮 | Duplicator Core | 复制核心 |
| Storm Cannon | 风暴炮 | Oblivion Beam | 湮灭光矛 |
| Hunter-Killer | 猎杀者 | Phoenix Flare | 凤凰耀斑 |
| star dust | 星尘 | yen | 円币 |
| loop | 循环 | corruption | 侵蚀 |
| the deep | 深渊 | the desert | 沙漠 |

机师:MEDIC 医官 · RASCAL 痞子 · BRUTUS 蛮熊 · FROST 寒霜 · DASH 疾风 · EMBER 余烬 ·
FANG 獠牙 · KRAKEN 海妖 · WHISKERS 猫须 · UNIT-7 七号 · HAVOC 狂徒 · ASTRO 阿星 ·
TB-26 保留原名 · TOBAR 托巴

## 授权

与原作一致:GPL-3.0-only。内置字体 Noto Sans SC 为 SIL Open Font License 1.1。
