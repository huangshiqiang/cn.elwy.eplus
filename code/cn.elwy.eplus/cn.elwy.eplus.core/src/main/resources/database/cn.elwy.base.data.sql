/*
-- --------------------------------------------------------
-- 作者：黄仕强
-- 系统版本：version 2.0
-- 创建日期：2018-02-19 20:30:00
-- 版权所有：2027-02-19 All Right Reserved IN www.elwy.cn
-- 文件描述：创建数据库表、视图以及初始化系统数据
-- 表名命名规则：
-- 1.前两个字母表示应用名称，用于区分不同的系统
-- 3.第三个字母到"_"前的字符表示对象类型，可以取值：
--   F方法、I索引、P分区表、S序列、T表、V视图、PR存储过程、TR触发器、TE临时表、TY类型
--
*/

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET FOREIGN_KEY_CHECKS=0;

/*
-- --------------------------------------------------------
-- 创建数据库: `CN_ELWY_FOSGI`
--
*/
CREATE DATABASE IF NOT EXISTS `CN_ELWY_FOSGI`;
USE `CN_ELWY_FOSGI`;


-- ----------------------------
-- 表的结构 `ECT_USER`
-- ----------------------------
INSERT INTO `ECT_USER` (`FID`, `FROLE_ID`, `FORG_ID`, `FPOST_ID`, `FCODE`, `FNAME`, `FTYPE`, `FENABLE`, `FPASSWORD`, `FREAL_NAME`, `FGENDER`, `FBIRTHDAY`, `FNICKNAME`, `FJOB`, `FEMAIL`, `FADDRESS`, `FPOSTCODE`, `FTELEPHONE`, `FMOBILE`, `FSAFETY`, `FLOCK_STATE`, `FENABLE_STATE`, `FSTART_DATE`, `FEND_DATE`, `FLOGIN_TIME`, `FLOGIN_COUNT`, `FCLIENT_IP`, `FONLINE`, `FCREATOR_ID`, `FCREATE_TIME`, `FLAST_EDITOR_ID`, `FLAST_EDIT_TIME`, `FCHECK_STATE`, `FCHECKER_ID`, `FCHECK_TIME`, `FDELETE_STATE`, `FDELETOR_ID`, `FDELETE_TIME`, `FREMARK`) VALUES 
(100001, 1, 1, 1, 'fa', 'E览无余', '1', true, 'fa', '1', '1', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100002, 1, 1, 1, 'fb', '苝飄', '11', true, 'fa', '11', '11', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100003, 3, 3, 3, 'fc', '♂男dé糊涂', '3', true, 'fa', '3', '3', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100005, 1, 1, 1, 'ba', 'E览无余', '1', true, 'fa', '1', '1', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100006, 1, 1, 1, 'bb', '苝飄', '11', true, 'fa', '11', '11', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100007, 3, 3, 3, 'bc', '♂男dé糊涂', '3', true, 'fa', '3', '3', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100008, 1, 1, 1, 'da', 'E览无余', '1', true, 'fa', '1', '1', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100009, 1, 1, 1, 'db', '苝飄', '11', true, 'fa', '11', '11', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100010, 3, 3, 3, 'dc', '♂男dé糊涂', '3', true, 'fa', '3', '3', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100011, 1, 1, 1, 'ea', 'E览无余', '1', true, 'fa', '1', '1', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100012, 1, 1, 1, 'eb', '苝飄', '11', true, 'fa', '11', '11', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100013, 3, 3, 3, 'ec', '♂男dé糊涂', '3', true, 'fa', '3', '3', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100015, 1, 1, 1, 'fb', '苝飄', '11', true, 'fa', '11', '11', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', ''),
(100016, 1, 1, 1, 'fb', '苝飄', '11', true, 'fa', '11', '11', '2017-2-19 20:30:00', '', '', '', '', '', '', '', '0', true, false, '2017-2-19 20:30:00', '2017-2-19 20:30:00', '2017-2-19 20:30:00', 1, '', 0, 0, '2017-2-19 20:30:00', 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', 0, 1, '2017-2-19 20:30:00', '');

INSERT INTO `ECT_APPL` (`FID`, `FCODE`, `FNAME`, `FTYPE`, `FENABLE`, `FORDER_NO`, `FPARENT_ID`, `FICON`, `FURI`, `FACTION`, `FCREATOR_ID`, `FCREATE_TIME`, `FLAST_EDITOR_ID`, `FLAST_EDIT_TIME`, `FCHECK_STATE`, `FCHECKER_ID`, `FCHECK_TIME`, `FDELETE_STATE`, `FDELETOR_ID`, `FDELETE_TIME`, `FREMARK`) VALUES 
(10000, 'gkzx', '管控中心', '1', true, 0, 0, NULL, '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10001, 'bbzx', '报表中心', '1', true, 0, 0, NULL, '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10002, 'xxzx', '消息中心', '1', true, 0, 0, NULL, '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO `ect_function` (`FID`, `FMODULE_ID`, `FCODE`, `FNAME`, `FTYPE`, `FENABLE`, `FORDER_NO`, `FICON`, `FURI`, `FACTION`, `FREMARK`) VALUES 
(10000, 0, 'sofa-report@const', '常量管理', '', true, 0, NULL, '', '', NULL),
(10001, 0, 'sofa-report@datasource', '数据源管理', '', true, 0, NULL, '', '', NULL),
(10002, 0, 'sofa-report@template', '模板管理', '', true, 0, NULL, '', '', NULL),
(10003, 0, 'sofa-report@stub', '报表存根', '', true, 0, NULL, '', '', NULL),
(10004, 0, 'sofa-report@report', '报表管理', '', true, 0, NULL, '', '', NULL),
(10005, 0, 'sofa-report@scene', '场景管理', '', true, 0, NULL, '', '', NULL),
(10006, 0, 'sofa-log-manage', '日志记录管理', '', true, 0, NULL, '', '', NULL),
(10007, 0, 'sofa-log-config', '日志配置管理', '', true, 0, NULL, '', '', NULL),
(10008, 0, 'sofa-app-appfunc', '应用功能树管理', '', true, 0, NULL, '', '', NULL),
(10009, 0, 'sofa-app-application', '应用信息管理', '', true, 0, NULL, '', '', NULL),
(10010, 0, 'deploy_arti_list', '部署列表', '', true, 0, NULL, '/sofa-deploy/artifact', '', NULL),
(10011, 0, 'deploy_comp_dep_rel', '组件依赖关系', '', true, 0, NULL, '/sofa-deploy/component', '', NULL),
(10012, 0, 'deploy_comp_list', '组件列表', '', true, 0, NULL, '/sofa-deploy/component', '', NULL),
(10013, 0, 'sofa-portal@menu_list', '门户菜单管理', '', true, 0, NULL, '/sofa-portal/menu.ctrl', '', NULL),
(10014, 0, 'sofa-messageCenter', '消息中心', '', true, 0, NULL, 'messageCenter.ctrl', '', NULL),
(10015, 0, 'sofa-foundation-post', '岗位管理', '', true, 0, NULL, '/sofa-basalinfo/positionMgr.ctrl?', '', NULL),
(10016, 0, 'sofa-foundation-org', '机构管理', '', true, 0, NULL, '/sofa-basalinfo/orgMgr.ctrl?', '', NULL),
(10017, 0, 'sofa-foundation-category', '字典类目管理', '', true, 0, NULL, '/sofa-basalinfo/dictCategoryMgr.ctrl?', '', NULL),
(10018, 0, 'sofa-foundation-user', '用户管理', '', true, 0, NULL, '/sofa-basalinfo/userMgr.ctrl?', '', NULL),
(10019, 0, 'sofa-foundation-region', '行政区域管理', '', true, 0, NULL, '/sofa-basalinfo/districtMgr.ctrl?', '', NULL),
(10020, 0, 'sofa-foundation-dictionary', '数据字典管理', '', true, 0, NULL, '/sofa-basalinfo/dataDictMgr.ctrl?', '', NULL),
(10021, 0, 'sofa-foundation-specialcalendar', '特殊日期管理', '', true, 0, NULL, '/sofa-basalinfo/specialDateMgr.ctrl?', '', NULL),
(10022, 0, 'sofa-schedule', '任务调度', '', true, 0, NULL, '', '', NULL),
(10023, 0, 'sofa-schedule-monitor', '任务监控', '', true, 0, NULL, '', '', NULL),
(10024, 0, 'sofa-schedule-task', '任务管理', '', true, 0, NULL, '', '', NULL),
(10025, 0, 'sofa-schedule-trigger', '计划管理', '', true, 0, NULL, '', '', NULL),
(10026, 0, 'sofa-flowengineCoop-start', '启动流程', '', true, 0, NULL, '', '', NULL),
(10027, 0, 'sofa-flowengineMng-catalog', '流程分类管理', '', true, 0, NULL, '', '', NULL),
(10028, 0, 'sofa-flowengineCoop-processed', '已办任务', '', true, 0, NULL, '', '', NULL),
(10029, 0, 'sofa-flowengineCoop-unprocess', '待办任务', '', true, 0, NULL, '', '', NULL),
(10030, 0, 'sofa-flowengineMng-definition', '流程定义管理', '', true, 0, NULL, '', '', NULL),
(10031, 0, 'sofa-flowengineMng-instance', '流程实例管理', '', true, 0, NULL, '', '', NULL),
(10032, 0, 'sofa-flowengineMng-template', '流程模版管理', '', true, 0, NULL, '', '', NULL),
(10033, 0, 'sofa-svcmgr@service_dir_list', '服务目录管理', '', true, 0, NULL, '/sofa-svcmgr/serviceDiretory.ctrl?', '', NULL),
(10034, 0, 'sofa-svcmgr@service_reg_list', '服务管理', '', true, 0, NULL, '/sofa-svcmgr/serviceManager.ctrl?', '', NULL),
(10035, 0, 'sofa-svcmgr@dest_mgr', '消息内容管理', '', true, 0, NULL, '/sofa-svcmgr/brokerMgrCtrl.ctrl?', '', NULL),
(10036, 0, 'sofa-security-sso', '登入登出', '', true, 0, NULL, '', '', NULL),
(10037, 0, 'sofa_configcenter_system', '配置资源管理', '', true, 0, NULL, '/sofa-configcenter/pages/index.jsp', '', NULL),
(10038, 0, 'sofa-authorization-handover', '权限交接及委托', '', true, 0, NULL, '', '', NULL),
(10039, 0, 'sofa-authorization-aclquery', '权限查询', '', true, 0, NULL, '', '', NULL),
(10040, 0, 'sofa-authorization-dataacl', '数据权限管理', '', true, 0, NULL, '', '', NULL),
(10041, 0, 'sofa-authorization-useracl', '用户授权', '', true, 0, NULL, '', '', NULL),
(10042, 0, 'sofa-authorization-roleacl', '角色授权', '', true, 0, NULL, '', '', NULL),
(10043, 0, 'sofa-authorization-orgacl', '机构授权', '', true, 0, NULL, '', '', NULL),
(10044, 0, 'sofa-cache@statist_list', '缓存统计', '', true, 0, NULL, '/sofa-cache/statistController.ctrl?', '', NULL),
(10045, 0, 'sofa-cache@cache_manager', '缓存内容管理', '', true, 0, NULL, '/sofa-cache/cacheContentCtrl.ctrl?', '', NULL),
(10046, 0, 'sofa-security-encryptkey', '用户密钥管理', '', true, 0, NULL, '/sofa-security/userEncryptKeyMgr.ctrl?', '', NULL),
(10047, 0, 'sofa-security@LoginUserSession', '在线用户列表', '', true, 0, NULL, 'loginUserSession.ctrl', '', NULL),
(10048, 0, 'sofa-security@LoginManager', '登录管理设置', '', true, 0, NULL, 'loginManager.ctrl', '', NULL),
(10049, 0, 'sofa-security@terminalIdentification', '终端认证管理', '', true, 0, NULL, '/sofa-security/ctrl/terminalIdentification/', '', NULL),
(10050, 0, 'sofa_reportcent_reportdeploy_manager', '报表部署管理', '', true, 0, NULL, '/sofa-reportcent/ReportDeployManage.ctrl', '', NULL),
(10051, 0, 'sofa_reportcent_sharedParam_manager', '参数共享管理', '', true, 0, NULL, '/sofa-reportcent/ReportSharedParamController.ctrl', '', NULL),
(10052, 0, 'sofa_reportcent_reportlist_manager', '报表管理', '', true, 0, NULL, '/sofa-reportcent/ReportManage.ctrl', '', NULL),
(10053, 0, 'sofa_reportcent_reportShared_manager', '报表共享管理', '', true, 0, NULL, '/sofa-reportcent/ReportSharedRuleController.ctrl', '', NULL),
(10054, 0, 'sofa_reportcent_dataset_manager', '数据源管理', '', true, 0, NULL, '/sofa-reportcent/Datasource.ctrl', '', NULL),
(10055, 0, 'sofa_reportcent_system_regiest', '系统注册管理', '', true, 0, NULL, '/sofa-reportcent/BusinessSystem.ctrl', '', NULL),
(10056, 0, 'HolidayInfo', '节假日信息', '', true, 0, NULL, '/ReportViewer/HolidayInfo.ctrl?', '', NULL),
(10057, 0, '', '', '', true, 0, NULL, '', '', NULL),
(10058, 0, 'DictIndex', '数据字典管理', '', true, 0, NULL, '/ReportViewer/DictIndex.ctrl', '', NULL),
(10059, 0, 'GsReportConfigMonth', '国寿报表管理-月报', '', true, 0, NULL, '/ReportViewer/GsReportConfigMonth.ctrl', '', NULL),
(10060, 0, 'FtpPathManage', 'FTP路径管理', '', true, 0, NULL, '/ReportViewer/FtpPathManage.ctrl', '', NULL),
(10061, 0, 'CumulativeRate', '累计净值增长率设置', '', true, 0, NULL, '/ReportViewer/CumulativeRate.ctrl', '', NULL),
(10062, 0, 'CircMonthReportConfiger', '保监会报表管理-月报', '', true, 0, NULL, '/ReportViewer/CircMonthReportConfiger.ctrl', '', NULL),
(10063, 0, 'OrgInfo', '机构信息管理', '', true, 0, NULL, '/ReportViewer/OrgInfo.ctrl', '', NULL),
(10064, 0, 'Invtmanager', '投资经理信息管理', '', true, 0, NULL, '/ReportViewer/Invtmanager.ctrl', '', NULL),
(10065, 0, 'ReportExportSetting', '报表导出设置', '', true, 0, NULL, '/ReportViewer/ReportExportSetting.ctrl', '', NULL),
(10066, 0, 'RoleUser', '信息披露权限设置', '', true, 0, NULL, '/ReportViewer/roleAuthority.ctrl', '', NULL),
(10067, 0, 'DailyReport', '常用报表', '', true, 0, NULL, '/ReportViewer/DailyReport.ctrl', '', NULL),
(10068, 0, 'ElementData', '公共元素信息管理', '', true, 0, NULL, '/ReportViewer/ElementData.ctrl', '', NULL),
(10069, 0, 'PortCls', '分级基金信息', '', true, 0, NULL, '/ReportViewer/PortClsInfo.ctrl?', '', NULL),
(10070, 0, 'Certificate', '证书信息管理', '', true, 0, NULL, '/ReportViewer/certificate.ctrl', '', NULL),
(10071, 0, 'GsReportConfig', '国寿报表管理-日报', '', true, 0, NULL, '/ReportViewer/GsReportConfig.ctrl', '', NULL),
(10072, 0, 'ExtDataImport', '外部数据导入', '', true, 0, NULL, '/ReportViewer/ExtDataImport.ctrl', '', NULL),
(10073, 0, 'ParamSet', '基金基本信息', '', true, 0, NULL, '/ReportViewer/PortBaseInfo.ctrl?', '', NULL),
(10074, 0, 'TemplateManager', '模版管理', '', true, 0, NULL, '/ReportViewer/TemplateManager.ctrl', '', NULL),
(10075, 0, 'ReportConfig', '信息披露管理', '', true, 0, NULL, '/ReportViewer/ReportConfig.ctrl?', '', NULL),
(10076, 0, 'DayReportConfig', '日报披露管理', '', true, 0, NULL, '/ReportViewer/DayReportConfig.ctrl?', '', NULL),
(10077, 0, 'loadData_page', '数据抽取', '', true, 0, NULL, '/ams-bbzx/loadDataController.ctrl?', '', NULL),
(10078, 0, 'PortWeekEnd_page', '组合样本周信息管理', '', true, 0, NULL, '/ams-bbzx/portWeekEnd.ctrl?', '', NULL),
(10079, 0, 'upload_page', '文件上传', '', true, 0, NULL, '/ams-bbzx/upload.ctrl?', '', NULL),
(10080, 0, 'ngzqngcw000025_page', '主从基金固定费用报', '', true, 0, NULL, '/ams-bbzx//ngzqngcw000025Controller.ctrl?', '', NULL),
(10081, 0, 'exportRegReport_page', '监管报表导出', '', true, 0, NULL, '/ams-bbzx/exportRegReport.ctrl?', '', NULL),
(10082, 0, 'DatAssType_page', '资管云费用设置', '', true, 0, NULL, '/ams-bbzx/DatAssType.ctrl?', '', NULL),
(10083, 0, 'BiPortParam_page', '日常报表组合参数维护', '', true, 0, NULL, '/ams-bbzx/BiPortParam.ctrl?', '', NULL),
(10084, 0, 'bbzx_productinfor', '产品信息维护', '', true, 0, NULL, '/ams-bbzx/productinfor.ctrl?', '', NULL),
(10085, 0, 'Jjshfe_page', '日常报表基金到期赎回份额', '', true, 0, NULL, '/ams-bbzx/Jjshfe.ctrl?', '', NULL),
(10086, 0, 'ssgsxx', '上市公司信息', '', true, 0, NULL, '/ams-bbzx/ssgsxxController.ctrl?', '', NULL),
(10087, 0, 'bbzx_portBaseInfo', '参数配置', '', true, 0, NULL, '/ams-bbzx/portBaseInfo.ctrl?', '', NULL),
(10088, 0, 'Gljzzs', '关联基准指数', '', true, 0, NULL, '/ams-bbzx/gljzzsController.ctrl?', '', NULL),
(10089, 0, 'bbzx_monthDataMaintain', '资信数据维护', '', true, 0, NULL, '/ams-bbzx/vhCreditInfo.ctrl?', '', NULL),
(10090, 0, 'tctaskinfo_page', '任务调度管理', '', true, 0, NULL, '/ams-bbzx/tctaskinfo.ctrl?', '', NULL),
(10091, 0, 'BiDictionary_page', '日常报表数据字典维护', '', true, 0, NULL, '/ams-bbzx/BiDictionary.ctrl?', '', NULL),
(10092, 0, 'taskCorelation_page', '任务关联设置', '', true, 0, NULL, '/ams-bbzx/taskCorelation.ctrl?', '', NULL),
(10093, 0, 'RG_DataMaint', '日常报表认购数据维护', '', true, 0, NULL, '/ams-bbzx/RG_DataMaintController.ctrl?', '', NULL),
(10094, 0, 'FengGeInfo_page', '证券风格信息', '', true, 0, NULL, '/ams-bbzx/fengGeInfo.ctrl?', '', NULL),
(10095, 0, 'bbzx_vhTaData', 'TA数据维护', '', true, 0, NULL, '/ams-bbzx/vhTaData.ctrl?', '', NULL),
(10096, 0, 'Gbbkxx', '股本板块信息', '', true, 0, NULL, '/ams-bbzx/gbbkxxController.ctrl?', '', NULL),
(10097, 0, 'logInfo_page', '操作日志查询', '', true, 0, NULL, '/ams-bbzx/logInfo.ctrl?', '', NULL),
(10098, 0, 'Jtfl_page', '日常报表计提费率设置', '', true, 0, NULL, '/ams-bbzx/Jtfl.ctrl?', '', NULL),
(10099, 0, 'innerDictionary', '数据字典信息维护', '', true, 0, NULL, '/ams-bbzx/innerDictionaryController.ctrl?', '', NULL),
(11000, 0, 'Tzbd_page', '日常报表投资标的维护', '', true, 0, NULL, '/ams-bbzx/Tzbd.ctrl?', '', NULL),
(11001, 0, 'bbzx_portReferenceInfo', '组合业绩基准信息', '', true, 0, NULL, '/ams-bbzx/portReferenceInfo.ctrl?', '', NULL),
(11002, 0, 'bbzx_vhOtherData', '其他数据维护', '', true, 0, NULL, '/ams-bbzx/vhOtherData.ctrl?', '', NULL),
(11003, 0, 'groupSortController', '组合分类信息维护', '', true, 0, NULL, '/ams-bbzx/groupSortController.ctrl?', '', NULL),
(11004, 0, 'tcportparam_page', '组合参数配置', '', true, 0, NULL, '/ams-bbzx/tcportparam.ctrl?', '', NULL),
(11005, 0, 'targetStandard_page', '业绩基准信息维护', '', true, 0, NULL, '/ams-bbzx/targetStandard.ctrl?', '', NULL),
(11006, 0, 'reportSet_page', '指标信息查询', '', true, 0, NULL, '/ams-bbzx/reportSet.ctrl?', '', NULL),
(11007, 0, 'Zffy_page', '日常报表支付费用维护', '', true, 0, NULL, '/ams-bbzx/Zffy.ctrl?', '', NULL),
(11008, 0, 'cfxx', '成份信息', '', true, 0, NULL, '/ams-bbzx/cfxxController.ctrl?', '', NULL),
(11009, 0, 'portTreeConf_page', '报表树形控件配置', '', true, 0, NULL, '/ams-bbzx/portTreeConf.ctrl?', '', NULL),
(11010, 0, 'portTreeTypeController', '组合树配置', '', true, 0, NULL, '/ams-bbzx/portTreeTypeController.ctrl?', '', NULL),
(11011, 0, 'bbzx_Currency', '各种货币对美元折算率', '', true, 0, NULL, '/ams-bbzx/Currency.ctrl?', '', NULL),
(11012, 0, 'Xtcssz_page', '日常报表信托参数维护', '', true, 0, NULL, '/ams-bbzx/Xtcssz.ctrl?', '', NULL),
(11013, 0, 'iniport_page', '初始化组合信息', '', true, 0, NULL, '/ams-bbzx/iniport.ctrl?', '', NULL),
(11014, 0, 'taskinfo_page', '任务信息', '', true, 0, NULL, '/ams-bbzx/taskController.ctrl?', '', NULL),
(11015, 0, 'Xtyj_page', '日常报表信托预警设置', '', true, 0, NULL, '/ams-bbzx/Xtyj.ctrl?', '', NULL);



INSERT INTO `ect_appl_func` (`FID`, `FAPPL_ID`, `FFUNC_ID`, `FCODE`, `FNAME`, `FTYPE`, `FENABLE`, `FORDER_NO`, `FPARENT_ID`, `FLEFT_ID`, `FRIGHT_ID`, `FLEVEL`, `FSUBNUM`, `FICON`, `FURI`, `FTARGET`, `FACTION`, `FCREATOR_ID`, `FCREATE_TIME`, `FLAST_EDITOR_ID`, `FLAST_EDIT_TIME`, `FCHECK_STATE`, `FCHECKER_ID`, `FCHECK_TIME`, `FDELETE_STATE`, `FDELETOR_ID`, `FDELETE_TIME`, `FREMARK`) VALUES 
(10000, 10000, 10000, 'gkzx', '管控中心', '', true, 0, 0, 1, 45, 1, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10001, 10000, 10000, '', '系统管理', '', true, 0, 0, 2, 7, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10002, 10000, 10000, '', '论坛交流', '', true, 0, 0, 3, 4, 3, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10003, 10000, 10000, '', '树结构', '', true, 0, 0, 5, 6, 3, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10004, 10000, 10000, '', '主子表', '', true, 0, 0, 8, 13, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10005, 10000, 10000, '', '单表', '', true, 0, 0, 9, 12, 3, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10006, 10000, 10000, '', '组件演示', '', true, 0, 0, 10, 11, 4, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10007, 10000, 10000, '', '修改密码', '', true, 0, 0, 14, 15, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10008, 10000, 10000, '', '个人信息', '', true, 0, 0, 16, 17, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10009, 10000, 10000, '', '用户管理', '', true, 0, 0, 18, 29, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10010, 10000, 10000, '', '角色管理', '', true, 0, 0, 19, 28, 3, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10011, 10000, 10000, '', '机构管理', '', true, 0, 0, 20, 27, 4, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10012, 10000, 10000, '', '菜单管理', '', true, 0, 0, 21, 26, 5, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10013, 10000, 10000, '', '日志查询', '', true, 0, 0, 22, 25, 6, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10014, 10000, 10000, '', '字典管理', '', true, 0, 0, 23, 24, 7, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10016, 10000, 10000, '', '审批测试', '', true, 0, 0, 30, 31, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10017, 10000, 10000, '', '我的通告', '', true, 0, 0, 32, 42, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10018, 10000, 10000, '', '通告管理', '', true, 0, 0, 34, 41, 3, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10019, 10000, 10000, '', '请假办理', '', true, 0, 0, 35, 40, 4, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10020, 10000, 10000, '', '代码模板管理', '', true, 0, 0, 36, 39, 5, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10021, 10000, 10000, '', '业务表配置', '', true, 0, 0, 37, 38, 6, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10022, 10000, 10000, '', '生成方案配置', '', true, 0, 0, 43, 44, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10023, 10000, 10000, '', '信息量统计', '', true, 0, 0, 46, 49, 1, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10024, 10000, 10000, '', '切换站点', '', true, 0, 0, 47, 48, 2, NULL, NULL, '', '', '', 0, '0000-0-0 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- 恢复外键约束检查
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;