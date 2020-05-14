//package com.st.smartsecurity.controller;
//
//import com.qs.common.core.response.BaseResponse;
//import com.st.smartsecurity.annotation.PassToken;
//import com.st.smartsecurity.pojo.vo.CompanyVO;
//import com.st.smartsecurity.service.JsCityCompanyService;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 江苏产业生态图公司管理
// * @author lhm
// */
//@RestController
//@RequestMapping("jsCompany")
////@Api(value = "jsCompany", tags = "江苏城市公司接口", position = 1)
//public class JsCityCompanyController {
//
//    @Autowired
//    JsCityCompanyService jsCityCompanyService;
//
//    @PostMapping("addCompany")
//    @ApiOperation(value = "添加公司")
//    @PassToken
//    public BaseResponse addCompany(){
//        String companyInfo = "[{\"index\":\"102\",\"city\":\"无锡\",\"company\":\"江苏卓胜微电子股份有限公司\",\"business\":\"射频前端芯片领域的研究、开发与销售\",\"product\":\"射频前端芯片、低功耗蓝牙微控制器\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"103\",\"city\":\"无锡\",\"company\":\"无锡好达电子有限公司\",\"business\":\"电子元件及组件的制造、加工、销售\",\"product\":\"表面波滤波器、双工器、谐振器\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"104\",\"city\":\"无锡\",\"company\":\"无锡中普微电子有限公司\",\"business\":\"电子产品、半导体集成电路、传感器的设计\",\"product\":\"射频IC设计、研发及销售，产品涵盖GSM、W-CDMA、TD-SCDMA、CDMA2000以及快速演变的TD-LTE，提供2G/3G/4G全面的射频前端解决方案\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"105\",\"city\":\"无锡\",\"company\":\"中国电子科技集团公司第五十八研究所\",\"business\":\"集成电路设计、掩膜制版、工艺加工、测试、封装及可靠性检测\",\"elements\":\"算法、芯片\"},\n" +
//                "                    {\"index\":\"106\",\"city\":\"无锡\",\"company\":\"江苏钜芯集成电路技术股份有限公司\",\"business\":\"集成电路、软件的设计、开发、销售；集成电路芯片的封装、测试、销售；封装与测试、物联网、电子产品的技术开发；电子元器件的销售\",\"product\":\"集成电路、软件的设计、开发、销售；集成电路芯片的封装\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"107\",\"city\":\"无锡\",\"company\":\"无锡深南电路有限公司\",\"business\":\"模组封装产品、电子装联、印刷电路板、通讯科技产品\",\"elements\":\"算法、芯片、模块\"},\n" +
//                "                    {\"index\":\"108\",\"city\":\"无锡\",\"company\":\"无锡硅动力微电子股份有限公司\",\"business\":\"半导体集成电路及电子产品（不含发射装置）的设计、开发、生产、销售\",\"product\":\"电源管理、音响、通信、马达控制、汽车电子等门类的先进集成电路，电路涉及Bipolar 、 CMOS 、 BiCMOS 等工艺\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"109\",\"city\":\"无锡\",\"company\":\"神宇通信科技股份公司\",\"business\":\"通信技术的技术开发、技术咨询、技术服务及技术转让；同轴电缆、专用电缆、连接器、连接器电缆组件、微波天线、馈线的技术开发、生产、销售；金丝材、银丝材、铜线材的加工；模具、夹具的设计、开发及生产；通讯器材\",\"product\":\"细微射频同轴电缆\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"110\",\"city\":\"无锡\",\"company\":\"星科金朋半导体(江阴)有限公司\",\"business\":\"集成电路研究、设计；BGA、PGA、CSP等\",\"product\":\"三维集成\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"111\",\"city\":\"无锡\",\"company\":\"江阴科利达电子有限公司\",\"business\":\"柔性电路板、柔性连接电缆、刚性电路板的制造、加工、销售及相关表面贴装\",\"product\":\"柔性电路板、柔性连接电缆\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"112\",\"city\":\"无锡\",\"company\":\"江苏亨鑫科技有限公司\",\"business\":\"通信科技产品的研究、设计、开发和制造\",\"elements\":\"算法、芯片、模块、终端\"},\n" +
//                "                    {\"index\":\"113\",\"city\":\"无锡\",\"company\":\"江苏俊知技术有限公司\",\"business\":\"电子元器件的研发、生产、技术服务；射频同轴电缆、通信电源用软电缆、特种电缆、移动通信系统交换设备、光纤、光缆及附件、光电子器件的制造，木盘制造及包装服务；从事无线互联网天馈系统、无线覆盖终端系统、馈线、天线、跳线、无源器件、光/电调制解调器、路由器、室内光纤分布系统、CPE终端、DAS系统、电解铜及铜制品的批发、进出口业务；贵金属销售\",\"product\":\"通信电缆、光纤、CPE终端、DAS系统\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"114\",\"city\":\"无锡\",\"company\":\"健鼎（无锡）电子有限公司\",\"business\":\"片式元器件、高密度互连积层板、柔性线路板（多层挠性板）、刚挠印刷电路板，半导体、元器件专用材料（BGA载板、覆晶载板），电子专用设备；本公司生产排放物的再利用技术开发；\",\"product\":\"BGA载板、覆晶载板\",\"elements\":\"芯片、模块\"},\n" +
//                "                    {\"index\":\"115\",\"city\":\"无锡\",\"company\":\"江苏安科瑞电器制造有限公司\",\"business\":\"网络电力仪表、电量传感器、继电器、电能质量治理装置、有源滤波装置、逆变器、光伏汇流箱、智能电动机控制器、医疗洁净电源柜、低压开关柜、通信机柜、中压保护装置、消防电子产品、半导体照明、通讯管理机、数据采集器的制造、研究、开发、销售；电力监控、电能节能管理、建筑能耗监测、电气火灾监控领域内的技术开发、技术服务、技术转让；电池管理系统、电动汽车供电系统、电动车电量仪、光伏发电储能系统、智能照明控制系统、智能动力控制系统、智能空调控制系统的研究、开发、生产、加工；太阳能光伏发电；仪器仪表的检测服务；自营和代理各类商品及技术的进出口业务，但国家限定企业经营或禁止进出口的商品和技术除外；汽车充电桩系统、电动自行车充电桩系统的研究、开发、销售；汽车充电桩设备、电动自行车充电桩设备的生产、销售。\",\"product\":\"仪表、光伏发电储能系统、智能照明控制系统、智能动力控制系统、智能空调控制系统\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"116\",\"city\":\"无锡\",\"company\":\"江阴众和电力仪表有限公司\",\"business\":\"仪表、电能表、电能计量箱、汽轮机及配件、输配电及控制设备的研究、开发、制造、加工、销售；电工仪器仪表\",\"product\":\"仪表、电能表、电能计量箱、汽车电子\",\"elements\":\"芯片、模块\"},\n" +
//                "                    {\"index\":\"117\",\"city\":\"无锡\",\"company\":\"江苏航天大为科技股份有限公司\",\"business\":\"计算机软硬件、电子产品、通信设备、机械设备的技术开发、技术服务；工业自动控制系统装置的制造及销售； 仪器仪表、IC卡、电子产品、通讯及广播电视设备（不含卫星广播电视地面接收设施及发射装置）、电力电子元器件的销售；智能灯光、音响控制系统工程、建筑智能化工程、消防工程、机电设备安装工程、计算机网络系统工程的施工\",\"product\":\"电子警察系统、车辆行踪监控系统、停车管理系统、通信息采集与动态交通诱导系统\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"118\",\"city\":\"无锡\",\"company\":\"江苏和亿智能科技有限公司\",\"business\":\"工业自动控制系统装置的研发、设计、制造、安装、销售、调试及维修、保养、技术服务、技术转让；电气机械及器材的技术开发、技术服务\",\"product\":\"变频器、PLC、一体化控制器、同步驱动系统\",\"elements\":\"算法、芯片、模块、系统\"},\n" +
//                "                    {\"index\":\"119\",\"city\":\"无锡\",\"company\":\"江苏数字鹰科技股份有限公司\",\"business\":\"智能无人飞行器、智能车载设备、机械化农业及园艺机具的研发、制造、销售、服务及技术开发和技术转让；工业机器人、工业自动控制系统装置、环境保护专用设备、自动化监控设备、摄像机、雷达\",\"product\":\"无人机及相关产品\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"120\",\"city\":\"无锡\",\"company\":\"江苏优企天下科技有限公司\",\"business\":\"计算机网络、物联网的技术开发、技术转让、技术服务\",\"elements\":\"系统、网络\"},\n" +
//                "                    {\"index\":\"121\",\"city\":\"无锡\",\"company\":\"无锡信捷电气股份有限公司\",\"business\":\"电气机械及器材、工业自动控制系统装置的开发、制造、销售；工业自动化控制软件的技术开发、技术转让、技术咨询和技术服务；自营和代理各类商品及技术的进出口业务\",\"product\":\"PLC、HMI、整体式控制器\",\"elements\":\"模块\"},\n" +
//                "                    {\"index\":\"122\",\"city\":\"无锡\",\"company\":\"无锡盈达聚力科技有限公司\",\"business\":\"通信传输设备、通信交换设备、通信终端设备\",\"product\":\"PLC、人机界面（HMI）、变频器、伺服系统、机器视觉\",\"elements\":\"算法、芯片、模块、终端、系统\"},\n" +
//                "                    {\"index\":\"123\",\"city\":\"无锡\",\"company\":\"无锡云瞳科技有限公司\",\"business\":\"计算机软硬件的研发；计算机网络设备的安装与维护\",\"elements\":\"算法\"},\n" +
//                "                    {\"index\":\"124\",\"city\":\"无锡\",\"company\":\"江苏天安智联科技股份有限公司\",\"business\":\"传感器、无线通讯设备、电子产品、电子元器件\",\"product\":\"车联网、智能车载\",\"elements\":\"终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"125\",\"city\":\"无锡\",\"company\":\"轻客智能科技（江苏）有限公司\",\"business\":\"物联网、车辆网络信息、集成电路、计算机硬件、计算机软件、电子元器件、机械电器设备、通讯设备、医疗电子设备的技术开发及数据处理；计算机互联网技术开发、技术服务；提供上述产品的技术转让、技术咨询、技术服务、系统集成、批发、佣金代理\",\"product\":\"智能穿戴设备、智能家居产品\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"126\",\"city\":\"无锡\",\"company\":\"无锡沃格自动化科技股份有限公司\",\"business\":\"工业自动控制系统装置、机械设备的研发、装配及生产、销售；机械设备的安装、维修并提供技术咨询、技术服务；通用机械及配件、汽车零配件、电子元器件的销售；自营和代理各类商品及技术的进出口业务\",\"product\":\"智能装备、智能化工厂\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"127\",\"city\":\"无锡\",\"company\":\"无锡小天鹅股份有限公司\",\"business\":\"家用电器、工业陶瓷产品、环保型干洗设备、清洗机械设备、后续整理设备及零配件的制造、销售及售后服务；洗涤服务；机械加工；自营和代理各类商品及技术的进出口业务\",\"product\":\"全自动波轮洗衣机、滚筒洗衣机、搅拌式洗衣机全种类洗衣机\",\"elements\":\"算法、芯片、终端\"},\n" +
//                "                    {\"index\":\"128\",\"city\":\"无锡\",\"company\":\"易视腾科技股份有限公司\",\"business\":\"互联网的技术开发、技术咨询、技术服务、技术转让；软件的开发；计算机系统集成；计算机、软件及辅助设备的销售；电子产品的研发、销售；自营和代理各类商品和技术的进出口\",\"product\":\"超清视频\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"129\",\"city\":\"无锡\",\"company\":\"江苏智联天地科技有限公司\",\"business\":\"电子产品、通信设备（含手机、不含卫星电视广播地面接收设施和发射装置）、仪器仪表（不含计量器具）、计算机、软件及辅助设备的研发、技术转让、技术咨询、技术服务、生产、销售及维修；信息系统集成服务\",\"product\":\"手机设计、研发、制造\",\"elements\":\"模块、终端、系统\"},\n" +
//                "                    {\"index\":\"130\",\"city\":\"无锡\",\"company\":\"无锡变格新材料科技有限公司\",\"business\":\"碳材料及其他新材料的研发与应用、技术服务、技术推广、技术咨询、技术转让，计算机零部件、电子器件、电子元件及组件的制造、加工；从事上述产品的批发、佣金代理（拍卖除外）、进出口业务\",\"product\":\"碳材料及其他新材料\",\"elements\":\"模块、终端\"},\n" +
//                "                    {\"index\":\"131\",\"city\":\"无锡\",\"company\":\"法尔胜泓昇集团有限公司\",\"business\":\"钢铁产品、机电产品、钢丝绳、钢丝、预应力钢丝\",\"product\":\"钢丝绳、钢丝、预应力钢丝\",\"elements\":\"终端\"},\n" +
//                "                    {\"index\":\"132\",\"city\":\"无锡\",\"company\":\"信越（江苏）光棒有限公司\",\"business\":\"生产光纤用预制棒及其副产品（限二氧化硅粉、石英玻璃屑、盐酸、回收四氯化硅）\",\"product\":\"光纤用预制棒、二氧化硅粉、石英玻璃屑、盐酸、回收四氯化硅\"},\n" +
//                "                    {\"index\":\"133\",\"city\":\"无锡\",\"company\":\"远东通讯有限公司\",\"business\":\"通信设备零售；光纤光缆、光电子器件、电子产品、通讯设备、机电设备的研发、制造、销售和安装服务；安全监测系统的研发和销售；金属材料的销售\",\"product\":\"光纤光缆、安全监测系统\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"134\",\"city\":\"无锡\",\"company\":\"无锡市德科立光电子技术有限公司\",\"business\":\"光电子产品、光纤放大器、光模块、子系统、光器件、高速光电收发芯片的技术开发、技术服务、制造、销售；通讯、数据中心系统集成及工程承包，并提供测试及技术咨询服务；自营和代理各类商品及技术的进出口\",\"product\":\"高速光电收发芯片\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"135\",\"city\":\"无锡\",\"company\":\"无锡雷华网络技术有限公司\",\"business\":\"网络技术及产品、集成电路、卫星定位接收系统、电子产品、机械产品的设计、开发、制造；通信设备（不含卫星电视广播地面接收设施）、有线电视网络设备及广播设备的设计、开发、制造、销售、安装、技术服务、技术转让；计算机软件的设计、开发；计算机系统集成；销售自产产品并提供系统工程的安装及技术服务；自营各类商品及技术的进出口业务，但国家限定企业经营或禁止进出口的商品及技术除外。\",\"product\":\"卫星定位接收系统\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"136\",\"city\":\"无锡\",\"company\":\"无锡雪浪数制科技有限公司\",\"business\":\"网络技术、信息技术、集成电路、电子产品、通信设备\",\"product\":\"工业互联网平台\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"137\",\"city\":\"无锡\",\"company\":\"无锡公安部交通管理科学研究所\",\"business\":\"道路交通管理工程技术研究\",\"product\":\"公安交通管理科技信息化、道路交通事故预防及鉴定、城市和公路交通管控、公安交通管理大数据及云计算、物联网涉车管理、公安交通指挥中心设计建设、机动车及驾驶人牌证、自动驾驶运行安全研发测试、交通安全宣教装备等技术研发应用，负责全国道路交通安全产品和交警执法装备质量监督检测、全国公安交警干部培训\",\"elements\":\"算法、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"138\",\"city\":\"无锡\",\"company\":\"无锡贝斯特精机股份有限公司\",\"business\":\"组合工艺装备、工业机器人、工业自动控制系统装备、机床附件、工具夹具、汽车零部件及配件、飞机机舱设施零部件、风动与电动工具、金属结构件的设计、制造、销售、技术开发、技术咨询、技术服务、技术转让\",\"product\":\"零部件加工、智能制造\",\"elements\":\"算法、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"139\",\"city\":\"无锡\",\"company\":\"无锡华云数据技术服务有限公司\",\"business\":\"第一类增值电信业务中的国内因特网虚拟专用网业务和因特网数据中心业务；第一类增值电信业务中的互联网接入服务业务；第一类增值电信业务中的内容分发网络业务；网络信息技术领域的技术开发、技术服务；计算机软件及智能化控制\",\"product\":\"大数据服务、超融合产品、公有云、IDC转云\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"140\",\"city\":\"无锡\",\"company\":\"浪潮卓数大数据产业发展有限公司\",\"business\":\"在大数据、信息、网络科技领域内从事技术开发、技术咨询、技术转让、技术服务；计算机系统集成服务；网络工程服务；计算机软硬件的销售；设计、制作、代理及发布各类广告业务；展览展示服务；会议服务；企业形象策划服务；摄影服务；房屋租赁服务；物业管理\",\"product\":\"公有云、边缘云和混合云三种模式，采用 1 (公有云） / N ( 边缘云）的部署架构。平台总体架构分为边缘、IaaS、通用PaaS、工业PaaS、SaaS 五部分\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"142\",\"city\":\"无锡\",\"company\":\"无锡艾德思奇软件有限公司\",\"business\":\"计算机软件的开发、销售；技术服务、技术开发、技术转让、技术咨询；设计、制作、代理、发布国内广告业务；移动通讯领域信息技术的推广\",\"product\":\"搜索、信息流、分发类营销管理产品\",\"elements\":\"算法、模块、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"143\",\"city\":\"无锡\",\"company\":\"无锡洲翔成套焊接设备有限公司\",\"business\":\"研发、生产焊接成套设备、金属切割设备、焊接辅机、电焊机、卷板机\",\"product\":\"焊接成套设备、金属切割设备、焊接辅机、电焊机、卷板机\",\"elements\":\"模块、终端\"},\n" +
//                "                    {\"index\":\"144\",\"city\":\"无锡\",\"company\":\"帆软软件有限公司\",\"business\":\"计算机、软件及辅助设备的技术开发、技术咨询、技术服务、技术转让、销售；计算机系统集成；商务咨询\",\"product\":\"自助大数据分析的BI软件\",\"elements\":\"系统、网络\"},\n" +
//                "                    {\"index\":\"145\",\"city\":\"无锡\",\"company\":\"江苏丰华联合科技有限公司\",\"business\":\"计算机系统及软硬件的技术开发、技术转让、技术咨询、技术服务；面向成年人开展的培训服务（不含国家统一认可的职业证书类培训）；集成电路芯片、集成电路模块、人工智能超级计算机平台及终端的开发、集成及技术服务；计算机软硬件及辅助设备、通讯器材及设备（不含卫星广播电视地面接收设施和发射装置）、通用设备、专用设备、电子产品、五金产品、电气机械及器材、教学设备、安防设备、音响设备、塑胶制品、体育器材及用品、文教用品、服装、办公用品及设备、家具、纸制品、仪器仪表、纺织品、建筑材料、摩托车及零部件、摄影器材、消防器材、酒店用品、厨房设备、电力设备、礼品、汽车用品、汽车及配件、电动自行车、应急救援设备、I、II类医疗器械、润滑油、化工产品及原料（不含危险化学品）、燃料油（不含成品油和危险化学品）、装潢材料（不含危险化学品）、环保设备、工程检测设备、水暖设备、电器设备、印刷设备、警用器材、交通运输设备、户外用\",\"product\":\"动态人脸识别技术为核心的智能视频分析系统的研发\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"146\",\"city\":\"无锡\",\"company\":\"中辰电缆股份有限公司\",\"business\":\"电线、电缆、光缆及电工器材、输配电及控制设备、电气信号设备装置的研宄、开发、制造、销售；电缆附件、电缆盘、塑料粒子的制造、销售；自营和代理各类商品及技术的进出口业务\",\"product\":\"电线电缆;控制电缆;架空电缆;橡套电缆;分支电缆;计算机电缆;裸电线;中高压电力电缆;\",\"elements\":\"模块\"},\n" +
//                "                    {\"index\":\"147\",\"city\":\"无锡\",\"company\":\"无锡江南电缆有限公司\",\"business\":\"生产电线电缆及其原辅材料、附件，耐高温绝缘材料（F、H级），绝缘成型件，电缆盘具；研究、开发、设计电线电缆及其原辅材料；分布式光伏发电；从事矿产品（不含铁矿石、氧化铝、铝土矿）、煤炭、食品（\",\"product\":\"电线电缆\",\"elements\":\"模块\"},\n" +
//                "                    {\"index\":\"148\",\"city\":\"无锡\",\"company\":\"远东控股集团有限公司\",\"business\":\"项目投资、股权投资、贵金属投资咨询、利用企业自有资产对外投资及投资管理（国家法律法规禁止限制的领域除外）、资产管理（国有资产除外）；自营和代理各类商品及技术的进出口业务\",\"product\":\"智慧能源\",\"elements\":\"算法、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"149\",\"city\":\"无锡\",\"company\":\"江苏亨鑫科技有限公司\",\"business\":\"射频同轴电缆、漏泄同轴电缆、高温同轴电缆、移动通信系统交换设备（含连接器、射频组件、天线、无线通信接入设备、接收机、发射机）的研发、制造、包装和维修维护服务；通信系统集成和安装\",\"product\":\"天线、电缆\",\"elements\":\"模块、终端\"},\n" +
//                "                    {\"index\":\"150\",\"city\":\"无锡\",\"company\":\"江苏江阴港港口集团股份有限公司\",\"business\":\"为船舶提供码头设施服务；在港区内提供货物装卸、仓储、物流服务；为国内、国际航行船舶提供淡水供应；保税仓储；国际港务信息咨询；分布式光伏发电；自营和代理各类商品和技术的进出口业务。\",\"product\":\"智能装卸\",\"elements\":\"算法、模块、终端\"},\n" +
//                "                    {\"index\":\"151\",\"city\":\"无锡\",\"company\":\"江苏微之润智能技术有限公司\",\"business\":\"人工智能、传感器、网络与通信、自动化、软件的技术开发、技术推广、技术转让、技术咨询、技术服务、技术运维；仪器仪表、智能设备的设计、研发、制造、销售、安装；气象、环境、交通、水利、农业、市政、应急、通信行业信息化的咨询（不含投资咨询、教育咨询）、设计与建设；云计算平台研发与信息服务；计算机软硬件系统服务与系统集成施工服务；增值电信业务（凭有效许可证经营）；科学研究与试验发展；电子、电器产品的销售及安装；自营和代理各类商品及技术的进出口业务，但国家限定企业经营或禁止进出口的商品和技术除外。\",\"product\":\"矿石、钢材、化工、煤炭、木材、液体化工、粮食、集装箱装卸、仓储及国际船务、货运代理、国内水路、陆路货运代理、外轮理货、船舶港作拖带\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"153\",\"city\":\"无锡\",\"company\":\"瀚云科技有限公司\",\"business\":\"计算机软硬件、信息技术、数据处理和存储技术、电子产品的技术研发、技术咨询、技术服务、技术成果转让；信息系统集成服务；工程管理服务；计算机软硬件、电子产品的设计服务；行业性实业投资；网上销售网络设备；自营和代理各类商品和技术的进出口\",\"product\":\"瀚云工业网关、瀚云工业物联网平台\",\"elements\":\"算法、模块、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"154\",\"city\":\"无锡\",\"company\":\"无锡品冠衣联网信息技术有限公司\",\"business\":\"物联网技术研发、技术服务；电子产品的研发、生产、销售、技术服务；智能化工程研发、设计、施工；通用机械、专用设备的研发、销售、维修、租赁；软件开发；计算机系统服务；自有房屋销售、租赁（不含融资性租赁）；物业管理；会议服务；组织文化艺术交流活动；行业性实业投资。\",\"product\":\"RFID电子标签的设计、生产、电子标签的初始化、RFID相关设备的设计制造、RFID互联网+云平台的服务和运营\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"155\",\"city\":\"无锡\",\"company\":\"无锡华洋滚动轴承有限公司\",\"business\":\"轴承及轴承配件的设计、研发及制造；自营和代理各类商品及技术的进出口业务（国家限定企业经营或禁止进出口的商品和技术除外）；金属材料、通用机械及配件、家用电器、仪表仪器、五金、电动工具的销售；普通货运\",\"product\":\"轴承、检测设备\",\"elements\":\"模块\"},\n" +
//                "                    {\"index\":\"156\",\"city\":\"无锡\",\"company\":\"无锡市第二人民医院\",\"product\":\"智慧医疗\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"157\",\"city\":\"无锡\",\"company\":\"无锡物联网创新促进中心\",\"business\":\"从事物联网技术、半导体技术、传感器技术、计算机技术、电子技术领域的技术开发、技术转让、技术咨询、技术服务；计算机系统集成、网络工程；集成电路设计、调试、维护；贸易咨询；会务及展览服务；自营和代理各类商品及技术的进出口业务（国家限定企业经营或禁止进出口的商品及技术除外）；机械设备的租赁（不含融资性租赁）；计算机软硬件及辅助设备、电子产品的生产、销售。\",\"product\":\"先进感知、工业互联网、车联网\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"158\",\"city\":\"无锡\",\"company\":\"无锡中电科物联网创新研发中心\",\"business\":\"物联网系统的体系结构研究、基础理论研究和关键技术研究\",\"elements\":\"算法、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"159\",\"city\":\"无锡\",\"company\":\"北大软微学院无锡产学研合作教育基地\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"160\",\"city\":\"无锡\",\"company\":\"复旦大学无锡研究院\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"161\",\"city\":\"无锡\",\"company\":\"江南大学物联网工程学院\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"162\",\"city\":\"无锡\",\"company\":\"国家超级计算无锡中心\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"163\",\"city\":\"无锡\",\"company\":\"江苏物联网研究发展中心\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"164\",\"city\":\"无锡\",\"company\":\"无锡物联网产业研究院\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"165\",\"city\":\"无锡\",\"company\":\"中国移动物联网研究院\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"166\",\"city\":\"无锡\",\"company\":\"中国联通物联网研究院\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"167\",\"city\":\"无锡\",\"company\":\"中国电信物联网分公司\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"},\n" +
//                "                    {\"index\":\"168\",\"city\":\"无锡\",\"company\":\"国家专用集成电路系统工程技术研究中心\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"}\n" +
//                "                ]";
//        int cityId = 5;
//        jsCityCompanyService.addCompany(cityId, companyInfo);
//        return BaseResponse.success();
//    }
//
//    @GetMapping("test")
//    @ApiOperation(value = "test")
//    @PassToken
//    public BaseResponse test(){
//        return BaseResponse.success();
//    }
//
//    @GetMapping("testString")
//    @ApiOperation(value = "testString")
//    @PassToken
//    public BaseResponse testString(String string){
//        return BaseResponse.success(string);
//    }
//
//    @GetMapping("testJson")
//    @ApiOperation(value = "testJson")
//    @PassToken
//    public BaseResponse testJson(CompanyVO companyVO){
//        return BaseResponse.success(companyVO);
//    }
//}
