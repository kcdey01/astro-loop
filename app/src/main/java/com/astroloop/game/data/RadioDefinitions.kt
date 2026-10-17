package com.astroloop.game.data

object RadioDefinitions {

    private val lines: Map<String, Map<String, List<String>>> = mapOf(

        // =====================================================================
        // ALWAYS-TRIGGER EVENTS (3 lines per pilot)
        // =====================================================================

        "shields_down" to mapOf(
            "pilot_medic" to listOf("护盾没了！当心！", "护盾全失——小心点！", "护盾发生器掉线了！"),
            "pilot_rascal" to listOf("护盾爆了！该溜了！", "没护盾？没事……大概吧。", "咱这是裸奔啊！"),
            "pilot_brutus" to listOf("护盾没了。", "哼。没盾。", "好。现在算私仇了。"),
            "pilot_frost" to listOf("护盾缓冲耗尽。", "无护盾运行。不理想。", "冷笑话：护盾没了。"),
            "pilot_dash" to listOf("护盾没了！得再快点！", "没盾了——速度就是装甲！", "护盾丢了！全都躲开！"),
            "pilot_ember" to listOf("护盾烧穿了！", "没盾？那我烧得更旺！", "暴露了！给我点起来！"),
            "pilot_fang" to listOf("盾……没了。我摸到虚空了。", "无盾。黑暗逼近。", "暴露了。好。让他们来。"),
            "pilot_whiskers" to listOf("护盾没了。真烦。", "啧。没盾。太掉价。", "这活儿我可没签过！"),
            "pilot_kraken" to listOf("护盾矩阵离线。", "触手准备挨打。", "无盾。深渊护我。"),
            "pilot_havoc" to listOf("护盾没了！冲啊——！", "谁需要护盾啊？！", "裸船体！刺激拉满！"),
            "pilot_unit7" to listOf("护盾状态：耗尽。", "警告：护盾发生器离线。", "存活率：重算中。"),
            "pilot_astro" to listOf("护盾没了。都打起精神。", "护盾丢了——TB-26，看住尾后。", "没盾。更糟的也熬过。")
        ),

        "big_hit" to mapOf(
            "pilot_medic" to listOf(
                "重击！谁在开船？！",
                "仪表全飙红了！",
                "我是医生，不是靶子！"
            ),
            "pilot_rascal" to listOf(
                "哇！差点赔光本钱！",
                "这不在抢劫计划里！",
                "嗷！尾巴都疼！"
            ),
            "pilot_brutus" to listOf(
                "哼。打得够重。",
                "疼。正好记着。",
                "这笔他们要还。"
            ),
            "pilot_frost" to listOf(
                "船体显著受损。已记录。",
                "从概率上说……不幸。",
                "冰受压也会裂。"
            ),
            "pilot_dash" to listOf(
                "嗷！还是慢了！",
                "重击！躲得再快点！",
                "这一下牙都震松了！"
            ),
            "pilot_ember" to listOf(
                "这一击只是给我煽风！",
                "他们打得狠——我们更狠！",
                "痛，只是火的燃料！"
            ),
            "pilot_fang" to listOf(
                "痛……有种味道。",
                "重击。黑暗醒了。",
                "这一下扎得深。我记着。"
            ),
            "pilot_whiskers" to listOf(
                "喂？！看着点船！",
                "太没礼貌了。真没礼貌。",
                "九条命都闪了一遍。"
            ),
            "pilot_kraken" to listOf(
                "船体在哼，像鲸歌。",
                "利维坦也怕鱼叉。",
                "重压。深渊在试我。"
            ),
            "pilot_havoc" to listOf(
                "好一击！再来一次！",
                "哈哈！这下真疼了！",
                "大伤害！我还站着！"
            ),
            "pilot_unit7" to listOf(
                "警告：船体完整度损失超 25%。",
                "撞击：严重。建议规避。",
                "结构损伤已记录。谨慎。"
            ),
            "pilot_astro" to listOf(
                "重击——船体撑住了。勉强。",
                "震得 TB-26 电路乱跳。我也乱。",
                "重击。抖抖就过。"
            )
        ),

        "low_health" to mapOf(
            "pilot_medic" to listOf(
                "船体危急——绷带用完了！",
                "心跳平了！再一下就没！",
                "生命体征全红——全部！"
            ),
            "pilot_rascal" to listOf(
                "要散架了！撤不撤？",
                "全靠胶带和运气撑着！",
                "再蹭一下就成废铁！"
            ),
            "pilot_brutus" to listOf(
                "船体危急。还打。",
                "在漏。不在乎。",
                "快死了。好。"
            ),
            "pilot_frost" to listOf(
                "船体低于 20%。胜率：下降。",
                "薄冰。比平时更薄。",
                "危急。别再挨一下。"
            ),
            "pilot_dash" to listOf(
                "船体快没了！跑不过！",
                "打烂了！再一下就是轰！",
                "危急！走走走走走！"
            ),
            "pilot_ember" to listOf(
                "只剩一点火星——别灭！",
                "我们成余烬了！不能这样！",
                "离灰只差一口气！继续打！"
            ),
            "pilot_fang" to listOf(
                "快到尽头了。我听见了。",
                "死很近。翅尖擦过。",
                "船体在流血。太脆。"
            ),
            "pilot_whiskers" to listOf(
                "丢人。几乎飞不动了。",
                "我拒绝死在这铁罐里。",
                "船体危急？！不可接受。"
            ),
            "pilot_kraken" to listOf(
                "船体开裂。深渊在唤。",
                "沉向深渊。撑住。",
                "快被压碎了。该上浮。"
            ),
            "pilot_havoc" to listOf(
                "船体危急！最带劲的部分！",
                "快死了！从没这么活过！",
                "还剩一击！来啊！"
            ),
            "pilot_unit7" to listOf(
                "船体危急。终止在即。",
                "警告：再撞一次＝失败。",
                "存活率近零。已记录。"
            ),
            "pilot_astro" to listOf(
                "船体危急——这里要稳。",
                "只剩一线。TB-26，稳住。",
                "再一下就完。打准点。"
            )
        ),

        "phoenix" to mapOf(
            "pilot_medic" to listOf(
                "病人抢回来了！医学奇迹！",
                "平了又回来了！我爱这行！",
                "除颤成功！回来了！别再来！"
            ),
            "pilot_rascal" to listOf(
                "哈！好浣熊压不死！",
                "死神抓不住我！滑得很！",
                "死了又回来！钱还在！"
            ),
            "pilot_brutus" to listOf(
                "死了。回来了。更气。",
                "还没完。",
                "死太无聊。回来了。"
            ),
            "pilot_frost" to listOf(
                "复活完成。正在支撑。",
                "从冷里回来。更冷了。",
                "临床死亡：短暂。已恢复。"
            ),
            "pilot_dash" to listOf(
                "我回来了！死神追不上！",
                "第二条命！别浪费！",
                "死神也拖不住我！"
            ),
            "pilot_ember" to listOf(
                "从灰烬里爬起来！天生如此！",
                "凤凰杀不死！我就是火！",
                "残烬成烈焰——我又活了！"
            ),
            "pilot_fang" to listOf(
                "我尝过死。死像我。",
                "从黑里回来。它没准备好。",
                "连虚空都吐我出来。"
            ),
            "pilot_whiskers" to listOf(
                "当然。还没烦够。",
                "死？省省。命还多着。",
                "太不体面。此事不提。"
            ),
            "pilot_kraken" to listOf(
                "深渊把我退回来了。还不到时候。",
                "自深渊归。海妖不倒。",
                "死不过是另一片海。"
            ),
            "pilot_havoc" to listOf(
                "死了又回来！今天最爽！",
                "第二回合！哈哈哈哈！",
                "死神留不住我！谁都留不住！"
            ),
            "pilot_unit7" to listOf(
                "重启完成。系统正常。",
                "错误：死亡日志。状态：覆写。",
                "已体验终止。继续运行。"
            ),
            "pilot_astro" to listOf(
                "回来了！TB-26，自检！",
                "凤凰核心救了我们。还没完。",
                "从边上回来了。都警醒点。"
            )
        ),

        "boss_spawn" to mapOf(
            "pilot_medic" to listOf(
                "巨型敌舰！准备接伤患！",
                "那玩意儿真大！要补货！",
                "扫描到 Boss！我的心！"
            ),
            "pilot_rascal" to listOf(
                "又大又亮！肯定有油水！",
                "Boss 来了！最大一票！",
                "这家伙够大！能偷的更多！"
            ),
            "pilot_brutus" to listOf(
                "大的。好。",
                "Boss。终于有点挑战。",
                "我的。"
            ),
            "pilot_frost" to listOf(
                "大型敌舰。正在算弱点。",
                "Boss 级。要求精准。",
                "热信号：极大。"
            ),
            "pilot_dash" to listOf(
                "Boss！太大了！跑得过吗？！",
                "大目标！得快！",
                "这玩意儿太大！上啊！"
            ),
            "pilot_ember" to listOf(
                "配得上的柴堆！烧起来！",
                "越大，烧得越亮！",
                "终于！够得上传说的火！"
            ),
            "pilot_fang" to listOf(
                "黑暗里有庞然大物在动。",
                "巨大的影子。我欢迎。",
                "听得见它心跳。好响。"
            ),
            "pilot_whiskers" to listOf(
                "又大又丑。我最爱。",
                "Boss？无聊。快点收场。",
                "丑陋。速毁。"
            ),
            "pilot_kraken" to listOf(
                "同为巨兽。敬它。",
                "庞然大物浮上来了。动了。",
                "泰坦。让触手碰一碰。"
            ),
            "pilot_havoc" to listOf(
                "Boss 战！！好耶好耶好耶！",
                "大目标！火力拉满！",
                "终于有值得开火的了！"
            ),
            "pilot_unit7" to listOf(
                "Boss 级。威胁：极高。",
                "大型敌舰。战斗协议启动。",
                "正在计算对敌策略。"
            ),
            "pilot_astro" to listOf(
                "Boss 接近。TB-26，武器待发。",
                "镜里有大的。稳住。",
                "Boss 级接触。拆了它。"
            )
        ),

        "evolution" to mapOf(
            "pilot_medic" to listOf(
                "进化了！这才是好药！",
                "进化了！预后：必死！",
                "完全进化！这方子我开！"
            ),
            "pilot_rascal" to listOf(
                "哟，亮闪闪的新升级！中头彩！",
                "进化了！现在值大钱！",
                "瞧这玩意儿！抢劫史上最肥！"
            ),
            "pilot_brutus" to listOf(
                "更强了。好。",
                "进化。他们完了。",
                "多点力。少废话。"
            ),
            "pilot_frost" to listOf(
                "进化。效率：显著。",
                "武器输出已达最优。优雅。",
                "进化了。这算式真美。"
            ),
            "pilot_dash" to listOf(
                "进化了！我们挡不住了！",
                "太帅了！试试！",
                "进化！更快！更强！更多！"
            ),
            "pilot_ember" to listOf(
                "进化！火焰升腾！",
                "火中重生！一身烈焰！",
                "熔炉才炼得出伟大！"
            ),
            "pilot_fang" to listOf(
                "进化。它的饿更利了。",
                "更暗。更致命。完美。",
                "它的低语变成尖叫了。"
            ),
            "pilot_whiskers" to listOf(
                "终于配得上我的天赋。",
                "进化。早该如此。",
                "可以接受。堪用了。"
            ),
            "pilot_kraken" to listOf(
                "深渊之力流过去了。",
                "海妖蜕皮。进化了。",
                "自深处，真正的力量升起。"
            ),
            "pilot_havoc" to listOf(
                "进化了！这玩意儿疯了！",
                "最大功率！哈哈哈哈！",
                "进化！没人扛得住这个！"
            ),
            "pilot_unit7" to listOf(
                "进化完成。输出 +347%。",
                "进化。现在我们是威胁。",
                "输出现在……很可观。"
            ),
            "pilot_astro" to listOf(
                "进化了！TB-26，看见这数据？",
                "完全进化。这才够劲。",
                "进化锁定。收尾。"
            )
        ),

        // =====================================================================
        // CHANCE-TRIGGER EVENTS (2 lines per pilot)
        // =====================================================================

        "first_weapon" to mapOf(
            "pilot_medic" to listOf(
                "新武器！好药！",
                "捡得好！选择更多了。"
            ),
            "pilot_rascal" to listOf(
                "先到先得！谁捡归谁！",
                "到手一把！开局不错。"
            ),
            "pilot_brutus" to listOf(
                "拿到武器了。走。",
                "枪多了。好。"
            ),
            "pilot_frost" to listOf(
                "首件武器上线。伤害曲线？",
                "有意思。先算算。"
            ),
            "pilot_dash" to listOf(
                "新武器！火力翻倍！",
                "有枪了！射速多快？！"
            ),
            "pilot_ember" to listOf(
                "第一点火星！烧了天！",
                "有武器了！火都是小起来的。"
            ),
            "pilot_fang" to listOf(
                "第一把武器。夜猎开始。",
                "有牙了。黑暗长牙了。"
            ),
            "pilot_whiskers" to listOf(
                "武器。终于。我都无聊了。",
                "可以。这把有点潜力。"
            ),
            "pilot_kraken" to listOf(
                "像触手找到了着力点。",
                "有武器了。深渊所赐。"
            ),
            "pilot_havoc" to listOf(
                "第一把武器！开派对！",
                "有枪很危险！冲！"
            ),
            "pilot_unit7" to listOf(
                "武器已整合。效率提升。",
                "副武器。军火在涨。"
            ),
            "pilot_astro" to listOf(
                "第一把武器装好。TB-26，热机。",
                "装弹上膛。开始了。"
            )
        ),

        "weapon_maxed" to mapOf(
            "pilot_medic" to listOf(
                "满级！一整剂毁灭！",
                "五级！这武器很健康！"
            ),
            "pilot_rascal" to listOf(
                "满级！值大价钱！",
                "升满了！从来没这么亮！"
            ),
            "pilot_brutus" to listOf(
                "满级。够了。",
                "全力。砸。"
            ),
            "pilot_frost" to listOf(
                "效率最大化。舒服。",
                "巅峰性能。数据：漂亮。"
            ),
            "pilot_dash" to listOf(
                "满级！现在太快了！",
                "五级！还能再高吗？！"
            ),
            "pilot_ember" to listOf(
                "最大功率！超新星！",
                "满级！熔炉永燃！"
            ),
            "pilot_fang" to listOf(
                "满级。完美的猎手。",
                "磨利了。暗中全是牙。"
            ),
            "pilot_whiskers" to listOf(
                "满级。勉强算够。",
                "五级。可真够久的。"
            ),
            "pilot_kraken" to listOf(
                "长满了。触手伸到最远。",
                "已抵最深。壮丽。"
            ),
            "pilot_havoc" to listOf(
                "满级！无限力量！",
                "满级！再多点火力！"
            ),
            "pilot_unit7" to listOf(
                "升级上限。无更多收益。",
                "5 级。性能：最优。"
            ),
            "pilot_astro" to listOf(
                "满级——这就是我们的重炮。",
                "五级。TB-26，标为主武器。"
            )
        ),

        "passive_maxed" to mapOf(
            "pilot_medic" to listOf(
                "被动满级！最佳疗程！",
                "叠满！预防保健！"
            ),
            "pilot_rascal" to listOf(
                "被动满级！口袋塞满了！",
                "叠满！金库搬空了！"
            ),
            "pilot_brutus" to listOf(
                "满级。更强。",
                "叠满。好。"
            ),
            "pilot_frost" to listOf(
                "全叠满。最优配置。",
                "满层。效率见顶。"
            ),
            "pilot_dash" to listOf(
                "被动满级！拉满了！",
                "叠满！我感觉到了！"
            ),
            "pilot_ember" to listOf(
                "满级！内火烧得最亮！",
                "叠满——火全点起来了！"
            ),
            "pilot_fang" to listOf(
                "静默之力，全醒了。",
                "全叠满。影子更深了。"
            ),
            "pilot_whiskers" to listOf(
                "满级。早该如此。",
                "叠满。我配得上这么多。"
            ),
            "pilot_kraken" to listOf(
                "饱满了。深流在走。",
                "满层。深渊的压强。"
            ),
            "pilot_havoc" to listOf(
                "被动满级！叠起来了！",
                "叠满！感觉太爽！"
            ),
            "pilot_unit7" to listOf(
                "被动已满。无法再升。",
                "槽位全满。效率：峰值。"
            ),
            "pilot_astro" to listOf(
                "被动满级。多一分是一分。",
                "那个叠满了。扎实。"
            )
        ),

        "first_enemy" to mapOf(
            "pilot_medic" to listOf(
                "敌舰！病号来了。",
                "敌人！别受伤——我就两只手！"
            ),
            "pilot_rascal" to listOf(
                "来客了！身上肯定有货！",
                "敌人！该摸口袋了！"
            ),
            "pilot_brutus" to listOf(
                "敌人。终于。",
                "目标。好。"
            ),
            "pilot_frost" to listOf(
                "检测到敌舰。冷处理协议。",
                "敌情接触。计算中。"
            ),
            "pilot_dash" to listOf(
                "敌人！来了！我准备好了！",
                "敌舰！跟他们赛一场！"
            ),
            "pilot_ember" to listOf(
                "敌人！新鲜柴火！",
                "敌舰进入——柴堆备好了！"
            ),
            "pilot_fang" to listOf(
                "猎物。我听见引擎在抖。",
                "黑里的船。还不知道我在。"
            ),
            "pilot_whiskers" to listOf(
                "哦，敌人。真有新意。",
                "敌人。连飞都不得安生。"
            ),
            "pilot_kraken" to listOf(
                "水面上的船。拖下来。",
                "像游在我地盘上的鱼。"
            ),
            "pilot_havoc" to listOf(
                "敌人！终于有东西可打了！",
                "他们来了！开火！"
            ),
            "pilot_unit7" to listOf(
                "检测到敌意目标。武器：解锁。",
                "敌情接触。战斗例程启动。"
            ),
            "pilot_astro" to listOf(
                "第一波。TB-26，注意。",
                "镜里有敌。处理掉。"
            )
        ),

        "density_spike" to mapOf(
            "pilot_medic" to listOf(
                "太多了！救不过来！",
                "铺天盖地！分诊要疯了！"
            ),
            "pilot_rascal" to listOf(
                "到处都是！有点刺激！",
                "全是人！没法摸包！"
            ),
            "pilot_brutus" to listOf(
                "目标多。拳头多。",
                "蜂群。来吧。"
            ),
            "pilot_frost" to listOf(
                "密度飙升。数据难看。",
                "敌数增加。胜率：不利。"
            ),
            "pilot_dash" to listOf(
                "太多了！得穿过去！",
                "到处都是！全速闪避！"
            ),
            "pilot_ember" to listOf(
                "一群！正好给炼狱添柴！",
                "挤满天空——全烧了！"
            ),
            "pilot_fang" to listOf(
                "蜂群变稠。盛宴。",
                "这么多心跳。这么多猎物。"
            ),
            "pilot_whiskers" to listOf(
                "荒唐。一点距离感都没有。",
                "围我？！懂不懂礼貌？！"
            ),
            "pilot_kraken" to listOf(
                "成群结队。好抓。",
                "一群。海妖开饭。"
            ),
            "pilot_havoc" to listOf(
                "目标这么多！天堂啊！",
                "到处都是！爽死了！"
            ),
            "pilot_unit7" to listOf(
                "密度超出参数。",
                "警报：目标密集区。"
            ),
            "pilot_astro" to listOf(
                "变密了。TB-26，跟紧。",
                "敌数攀升——保持警觉。"
            )
        ),

        "yen_milestone" to mapOf(
            "pilot_medic" to listOf(
                "发财了！够开家医院！",
                "这么多！保险都赔不起！"
            ),
            "pilot_rascal" to listOf(
                "全是円币！史上最大票！",
                "发了！我先替他拿着。"
            ),
            "pilot_brutus" to listOf(
                "円币多。多买弹药。",
                "有钱。不管。继续打。"
            ),
            "pilot_frost" to listOf(
                "円币可观。冷硬的运气。",
                "利润率：优异。"
            ),
            "pilot_dash" to listOf(
                "这么多円币！叮当叮当！",
                "全速发财！"
            ),
            "pilot_ember" to listOf(
                "烈火铸金！",
                "円币溢出！财富如烟！"
            ),
            "pilot_fang" to listOf(
                "黑暗敬重财富。",
                "财富在虚空低语。"
            ),
            "pilot_whiskers" to listOf(
                "收入还行。也许留下。",
                "总算。配得上我的价钱。"
            ),
            "pilot_kraken" to listOf(
                "深渊之宝。归我。",
                "円币成海。沉金。"
            ),
            "pilot_havoc" to listOf(
                "发财了！全买枪！",
                "看这円币！炸钱！"
            ),
            "pilot_unit7" to listOf(
                "円币超预期。记录。",
                "円币达标。效率：显著。"
            ),
            "pilot_astro" to listOf(
                "收获不小。回头我请酒。",
                "TB-26，记下来——最肥的一票。"
            )
        ),

        // =====================================================================
        // COMBAT START (always triggers once at game start)
        // =====================================================================

        "combat_start" to mapOf(
            "pilot_medic" to listOf("都活着回来。"),
            "pilot_rascal" to listOf("去捞一票！走！"),
            "pilot_brutus" to listOf("终于。"),
            "pilot_frost" to listOf("引擎冷。武器热。走。"),
            "pilot_dash" to listOf("走走走走走！"),
            "pilot_ember" to listOf("点火。全点了。"),
            "pilot_fang" to listOf("进黑暗。我该在的地方。"),
            "pilot_whiskers" to listOf("行吧。快点打完。"),
            "pilot_kraken" to listOf("深渊在唤。我们应。"),
            "pilot_havoc" to listOf("全功率！不后悔！"),
            "pilot_unit7" to listOf("战斗系统上线。发射。"),
            "pilot_astro" to listOf("随时可以，TB-26。")
        ),

        // =====================================================================
        // NEAR MISS — reflexive dodge reactions (2-3 lines per pilot)
        // =====================================================================

        "near_miss" to mapOf(
            "pilot_medic" to listOf(
                "太近了！心脏受不了！",
                "差点撞上！让我缓一下。",
                "呼！差点得给自己出诊！"
            ),
            "pilot_rascal" to listOf(
                "哈！没打中！我太滑了！",
                "哟！差点削到我尾巴！",
                "想得美！逮不着这浣熊！"
            ),
            "pilot_brutus" to listOf(
                "没中。",
                "近。还不够近。",
                "啧。打歪了。"
            ),
            "pilot_frost" to listOf(
                "偏差：可忽略。记录。",
                "距两米内。够紧。",
                "险。统计上正常。"
            ),
            "pilot_dash" to listOf(
                "哇！太近！再快，再快！",
                "差点中！还得更快！",
                "擦到了！我反应一流！"
            ),
            "pilot_ember" to listOf(
                "就这点火力？",
                "险！那发燎到我们了！",
                "险险闪过——火不退！"
            ),
            "pilot_fang" to listOf(
                "那发贴着我耳边过。",
                "近。死亡擦过我的翼。",
                "差点。但猎手是我。"
            ),
            "pilot_whiskers" to listOf(
                "有没有搞错？！看着打！",
                "放肆。太近了。",
                "哼。本喵反应无懈可击。"
            ),
            "pilot_kraken" to listOf(
                "像洋流一样掠过。近。",
                "深渊退了半步。罕见。",
                "那发擦到触须。"
            ),
            "pilot_havoc" to listOf(
                "哇！太爽了！",
                "差点打中我！再来！",
                "哈哈！好险！我爱死这了！"
            ),
            "pilot_unit7" to listOf(
                "近失。偏差：1.3 米。",
                "规避成功。重新计算。",
                "弹体通过，在容差内。"
            ),
            "pilot_astro" to listOf(
                "惊险。保持警觉，TB-26。",
                "差点被切。睁大眼。",
                "躲得紧。稳住。"
            )
        ),

        // =====================================================================
        // KILL STREAK — 3+ rapid kills, celebratory (2-3 lines per pilot)
        // =====================================================================

        "kill_streak" to mapOf(
            "pilot_medic" to listOf(
                "敌机坠落！没人需要救！",
                "连杀！分诊轻松多了！",
                "三架！没丢一个伤员！"
            ),
            "pilot_rascal" to listOf(
                "连击！看这堆货！",
                "三连！这是金矿！",
                "手气正旺！最爽一票！"
            ),
            "pilot_brutus" to listOf(
                "再来。别停。",
                "连杀。好。",
                "三架。不够。"
            ),
            "pilot_frost" to listOf(
                "击杀效率飙升。可观。",
                "多杀。数据漂亮。",
                "连杀确认。冷静精准。"
            ),
            "pilot_dash" to listOf(
                "轰！轰！轰！停不下来！",
                "连杀！燃了！快就是杀！",
                "三架！下一个谁？！"
            ),
            "pilot_ember" to listOf(
                "火链！一架接一架！",
                "连杀！火势蔓延！",
                "一架接一架——炼狱！"
            ),
            "pilot_fang" to listOf(
                "今夜猎获丰厚。",
                "三猎物，三杀。干净。",
                "一道影。无人见。"
            ),
            "pilot_whiskers" to listOf(
                "当然。我打得像散步。",
                "连杀。本喵的水准。",
                "三架。困。下一个？"
            ),
            "pilot_kraken" to listOf(
                "如船沉入深渊。",
                "残骸成宴。海妖进食。",
                "拖下三架。还有更多。"
            ),
            "pilot_havoc" to listOf(
                "连杀！哈哈哈爽！",
                "三架！继续！",
                "连杀！到处爆炸！"
            ),
            "pilot_unit7" to listOf(
                "多杀。效率：最优。",
                "连杀生效。战力：上升。",
                "连续清除已确认。"
            ),
            "pilot_astro" to listOf(
                "三架速清。状态正好。",
                "连杀——TB-26，压住。",
                "顺了。别松。"
            )
        ),

        // =====================================================================
        // TIME MILESTONES — survival timestamps (1 line per pilot)
        // =====================================================================

        "time_2min" to mapOf(
            "pilot_medic" to listOf("两分钟。体征平稳。"),
            "pilot_rascal" to listOf("两分钟！才热身！"),
            "pilot_brutus" to listOf("两分钟。还没开打。"),
            "pilot_frost" to listOf("两分钟。基线已立。"),
            "pilot_dash" to listOf("两分钟！才刚开始！"),
            "pilot_ember" to listOf("两分钟。火才刚起。"),
            "pilot_fang" to listOf("两分钟。猎还没热。"),
            "pilot_whiskers" to listOf("两分钟。还算能忍。"),
            "pilot_kraken" to listOf("两分钟。仍在浅水。"),
            "pilot_havoc" to listOf("两分钟！才刚热身！"),
            "pilot_unit7" to listOf("2:00。系统全正常。"),
            "pilot_astro" to listOf("两分钟。进入状态了。")
        ),

        "time_4min" to mapOf(
            "pilot_medic" to listOf("四分钟！零伤亡！"),
            "pilot_rascal" to listOf("四分钟！货堆起来了！"),
            "pilot_brutus" to listOf("四分钟。开始有意思。"),
            "pilot_frost" to listOf("四分钟。生存曲线：良好。"),
            "pilot_dash" to listOf("四分钟，还在飙！"),
            "pilot_ember" to listOf("四分钟——火还稳。"),
            "pilot_fang" to listOf("黑暗中四分钟。不错。"),
            "pilot_whiskers" to listOf("四分钟。比多数人强。"),
            "pilot_kraken" to listOf("四分钟。洋流托着我们。"),
            "pilot_havoc" to listOf("四分钟纯混乱！再来！"),
            "pilot_unit7" to listOf("4:00。表现符合参数。"),
            "pilot_astro" to listOf("四分钟。稳，TB-26。")
        ),

        "time_6min" to mapOf(
            "pilot_medic" to listOf("六分钟——有点悬了！"),
            "pilot_rascal" to listOf("六分钟！够刺激！我喜欢！"),
            "pilot_brutus" to listOf("六分钟。这才算打。"),
            "pilot_frost" to listOf("六分钟。威胁密度：上升。"),
            "pilot_dash" to listOf("六分钟！外面疯了！"),
            "pilot_ember" to listOf("六分钟——熔炉更旺了！"),
            "pilot_fang" to listOf("六分钟。猎物更黑了。"),
            "pilot_whiskers" to listOf("六分钟。有点佩服了。"),
            "pilot_kraken" to listOf("六分钟。深渊的压力。"),
            "pilot_havoc" to listOf("六分钟！混乱不停！"),
            "pilot_unit7" to listOf("6:00。威胁升级：显著。"),
            "pilot_astro" to listOf("六分钟。稳住，TB-26。")
        ),

        "time_8min" to mapOf(
            "pilot_medic" to listOf("八分钟！我们够硬！"),
            "pilot_rascal" to listOf("八分钟！最长的一票！"),
            "pilot_brutus" to listOf("八分钟。服。"),
            "pilot_frost" to listOf("八分钟。已进前列。"),
            "pilot_dash" to listOf("八分钟！我们是传奇！"),
            "pilot_ember" to listOf("八分钟——火里锻出来的！"),
            "pilot_fang" to listOf("八分钟。没几个活到这。"),
            "pilot_whiskers" to listOf("八分钟。我承认，不赖。"),
            "pilot_kraken" to listOf("深渊八分钟。到家了。"),
            "pilot_havoc" to listOf("八分钟！停不下来！"),
            "pilot_unit7" to listOf("8:00。续航：异常。"),
            "pilot_astro" to listOf("八分钟。老兵水准，TB-26。")
        ),

        // =====================================================================
        // ASTRO LOOP EXTENDED MILESTONES (indices 4-7, Astro Loop mode only)
        // =====================================================================

        "time_10min" to mapOf(
            "pilot_medic"    to listOf("十分钟。还是零伤亡。"),
            "pilot_rascal"   to listOf("十分钟！我破纪录了？"),
            "pilot_brutus"   to listOf("十分钟。我们该在这。"),
            "pilot_frost"    to listOf("十分钟。生存曲线：强。"),
            "pilot_dash"     to listOf("十分钟！还在跑！更快！"),
            "pilot_ember"    to listOf("十分钟。火不会累。"),
            "pilot_fang"     to listOf("十分钟。猎还在。"),
            "pilot_whiskers" to listOf("十分钟。准了。"),
            "pilot_kraken"   to listOf("十分钟。洋流还稳。"),
            "pilot_havoc"    to listOf("十分钟！混乱万岁！"),
            "pilot_unit7"    to listOf("10:00。输出持续。确认。"),
            "pilot_astro"    to listOf("十分钟。没减速。")
        ),

        "time_12min" to mapOf(
            "pilot_medic"    to listOf("十二分钟。出色。"),
            "pilot_rascal"   to listOf("十二分钟！要成传说了！"),
            "pilot_brutus"   to listOf("十二分钟。到的人少。"),
            "pilot_frost"    to listOf("十二分钟。统计异常值。"),
            "pilot_dash"     to listOf("十二分钟！写进历史！"),
            "pilot_ember"    to listOf("十二分钟。火稳如初。"),
            "pilot_fang"     to listOf("十二分钟。只剩巅峰。"),
            "pilot_whiskers" to listOf("十二分钟。真服了。"),
            "pilot_kraken"   to listOf("十二分钟。无图的洋流。"),
            "pilot_havoc"    to listOf("十二分钟！天空归我们！"),
            "pilot_unit7"    to listOf("12:00。超出全部常规。"),
            "pilot_astro"    to listOf("十二分钟。这地方我认得。")
        ),

        "time_14min" to mapOf(
            "pilot_medic"    to listOf("十四分钟。有点特别。"),
            "pilot_rascal"   to listOf("十四分钟。连我都服。"),
            "pilot_brutus"   to listOf("十四分钟。没来过。"),
            "pilot_frost"    to listOf("十四分钟。没有数据。"),
            "pilot_dash"     to listOf("十四分钟！没人到过！"),
            "pilot_ember"    to listOf("十四分钟。不灭之火。"),
            "pilot_fang"     to listOf("十四分钟。猎之巅峰。"),
            "pilot_whiskers" to listOf("十四分钟。这次不一样。"),
            "pilot_kraken"   to listOf("十四分钟。图上没有。"),
            "pilot_havoc"    to listOf("十四分钟！永不停！"),
            "pilot_unit7"    to listOf("14:00。先例：无。"),
            "pilot_astro"    to listOf("十四分钟。这是我的。")
        ),

        "time_16min" to mapOf(
            "pilot_medic"    to listOf("十六分钟。值了。"),
            "pilot_rascal"   to listOf("十六分钟。没法更好了。"),
            "pilot_brutus"   to listOf("十六分钟。我见过了。"),
            "pilot_frost"    to listOf("十六分钟。数据要重写。"),
            "pilot_dash"     to listOf("十六分钟。就是这趟。"),
            "pilot_ember"    to listOf("十六分钟。我们成传奇。"),
            "pilot_fang"     to listOf("十六分钟。我是巅峰。"),
            "pilot_whiskers" to listOf("十六分钟。连我都没话说。"),
            "pilot_kraken"   to listOf("十六分钟。深渊即家。"),
            "pilot_havoc"    to listOf("十六分钟……对。就这样。"),
            "pilot_unit7"    to listOf("16:00。无法归类。"),
            "pilot_astro"    to listOf("十六分钟。够了。")
        ),

        "astro_echo" to mapOf(
            "pilot_medic" to listOf("十分钟。有点不对。"),
            "pilot_rascal" to listOf("十分钟。这很怪吧？"),
            "pilot_brutus" to listOf("十分钟。空气沉了。"),
            "pilot_frost" to listOf("十分钟。有东西偏了。"),
            "pilot_dash" to listOf("十分钟。你也感觉到了？"),
            "pilot_ember" to listOf("十分钟。空气不对。"),
            "pilot_fang" to listOf("十分钟。本能发痒。"),
            "pilot_whiskers" to listOf("十分钟。毛都炸了。"),
            "pilot_kraken" to listOf("十分钟。洋流怪。"),
            "pilot_havoc" to listOf("十分钟。有东西在响。"),
            "pilot_unit7" to listOf("10:00。异常。来源未知。"),
            "pilot_astro" to listOf("十分钟。像来过。")
        ),

        // =====================================================================
        // POST-HORROR ALTERNATES (desertCompleted && !hasDesertGoodEnding)
        // =====================================================================

        "combat_start_horror" to mapOf(
            "pilot_medic"    to listOf("都活着。又一次。"),
            "pilot_rascal"   to listOf("外面这感觉……熟。"),
            "pilot_frost"    to listOf("同一片天。换一趟。"),
            "pilot_brutus"   to listOf("又来了。"),
            "pilot_dash"     to listOf("上了。又来。"),
            "pilot_ember"    to listOf("有些灰，不会凉。"),
            "pilot_fang"     to listOf("有东西跟着我们。"),
            "pilot_whiskers" to listOf("又来。真新鲜。"),
            "pilot_kraken"   to listOf("深渊记得。"),
            "pilot_havoc"    to listOf("又来！……等等。走！"),
            "pilot_unit7"    to listOf("运行日志：递增。"),
            "pilot_astro"    to listOf("这次打对。")
        ),

        "time_8min_horror" to mapOf(
            "pilot_medic"    to listOf("八分钟。仔细看。"),
            "pilot_rascal"   to listOf("八分钟。有东西来了。"),
            "pilot_frost"    to listOf("八分钟。偏差将至。"),
            "pilot_brutus"   to listOf("八分钟。它要来了。"),
            "pilot_dash"     to listOf("八分钟！它来了！"),
            "pilot_ember"    to listOf("八分钟。火变了。"),
            "pilot_fang"     to listOf("八分钟。黑暗在动。"),
            "pilot_whiskers" to listOf("八分钟。熟悉。"),
            "pilot_kraken"   to listOf("八分钟。深渊动了。"),
            "pilot_havoc"    to listOf("八分钟！它总是——"),
            "pilot_unit7"    to listOf("8:00。与上轮数据吻合。"),
            "pilot_astro"    to listOf("八分钟。有东西在这。")
        ),

        // =====================================================================
        // RETREAT HOME \u2014 Astro Loop mode, pilot heads back to base
        // =====================================================================

        "retreat_home" to mapOf(
            "pilot_medic" to listOf(
                "中弹了——后撤。",
                "这伤得找人看看。",
                "撤。还完整。"
            ),
            "pilot_rascal" to listOf(
                "今天不死。酒吧见！",
                "留着命，明天再骗。",
                "我撤了。别太想我。"
            ),
            "pilot_brutus" to listOf(
                "后撤。没完。",
                "中弹。撤出。",
                "我退出。重整。"
            ),
            "pilot_frost" to listOf(
                "后撤。条件不利。",
                "撤退。不理想。",
                "我到这。暂时。"
            ),
            "pilot_dash" to listOf(
                "我走了——全速南下！",
                "脱队！全速！",
                "护盾开着，全速往南！"
            ),
            "pilot_ember" to listOf(
                "趁还没更糟，先撤。",
                "引擎还热——回家。",
                "我讨厌跑。但我在跑。"
            ),
            "pilot_fang" to listOf(
                "猎，改日再续。",
                "我选何时死。不是今天。",
                "不在这。走了。"
            ),
            "pilot_kraken" to listOf(
                "后撤。深渊在唤。",
                "下潜脱离。还没完。",
                "我上浮。这事继续。"
            ),
            "pilot_whiskers" to listOf(
                "趁运气没干，先溜！",
                "刚耗掉一条命。",
                "太险了。我撤。"
            ),
            "pilot_unit7" to listOf(
                "启动紧急撤退。",
                "脱离。返航基地。",
                "护盾启动。后撤。"
            ),
            "pilot_havoc" to listOf(
                "老子不这么死！",
                "走——按我的规矩。",
                "撤。但我会回来。"
            ),
            "pilot_astro" to listOf(
                "没完。只是不在这。",
                "后撤。还没结束。",
                "退。我会收尾。"
            )
        )
    )

    fun getLines(pilotId: String, eventType: String, filterTb26: Boolean = false): List<String>? {
        val eventLines = lines[eventType] ?: return null
        val pilotLines = eventLines[pilotId] ?: return null
        if (filterTb26 && pilotId == "pilot_astro") {
            val filtered = pilotLines.filter { "TB-26" !in it }
            if (filtered.isNotEmpty()) return filtered
            // All lines mention TB-26 — use solo fallback (may be null for some events)
            return soloAstroLines[eventType]
        }
        return pilotLines
    }

    fun getLine(pilotId: String, eventType: String, filterTb26: Boolean = false): String? =
        getLines(pilotId, eventType, filterTb26)?.randomOrNull()

    // Solo Astro lines for events where all normal lines reference TB-26
    private val soloAstroLines = mapOf(
        "combat_start" to listOf("系统正常。起飞。"),
        "time_4min" to listOf("四分钟。目前不错。"),
        "time_6min" to listOf("六分钟。别分神。"),
        "time_8min" to listOf("八分钟。老兵的地界。")
    )
}
