/*
-- --------------------------------------------------------
-- 作者：黄仕强
-- 系统版本：version 2.0
-- 创建日期：2018-02-19 20:30:00
-- 版权所有：2027-02-19 All Right Reserved IN www.elwy.cn
-- 文件描述：创建数据库表、视图以及初始化系统数据
-- 表名命名规则：
-- 1.前两个字母表示应用名称，用于区分不同的系统
-- 2.第三个字母到"_"前的字符表示对象类型，可以取值：
--   F方法、I索引、P分区表、S序列、T表、V视图、PR存储过程、TR触发器、TE临时表、TY类型
-- 3.FSTATUS: 0应用、11系统，不可删除、20系统，不可以删除和修改
*/

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET FOREIGN_KEY_CHECKS=0;

/*
-- --------------------------------------------------------
-- 创建数据库: `CN_ELWY_EPLUS`
--
*/
CREATE DATABASE IF not EXISTS `CN_ELWY_EPLUS`;
USE `CN_ELWY_EPLUS`;


-- ----------------------------
-- 表的结构 `ECT_DICT`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DICT`;
CREATE TABLE `ECT_DICT` (
	`FID` varchar(30) not null comment '主键',
	`FDICT_TYPE` varchar(20) not null comment '类型',
	`FDICT_CODE` varchar(30) not null comment '代码',
	`FDICT_VALUE` varchar(200) not null comment '值',
	`FPARENT_CODE` varchar(30) default null comment '上级代码',
	`FLVALUE` int(11) not null comment '左值',
	`FRVALUE` int(11) not null comment '右值',
	`FLEVEL` int(11) default null comment '层级',
	`FSUBNUM` int(11) default null comment '子节点个数',
	`FORDER` int(11) default 0 comment '显示次序',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统数据字典树表';

-- ----------------------------
-- 表的结构 `ECT_LANGUAGE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_LANGUAGE`;
CREATE TABLE `ECT_LANGUAGE` (
	`FID` varchar(30) not null comment '主键',
	`FLANG_CODE` varchar(30) default null comment '代码',
	`FLANG_NAME` varchar(50) default null comment '名称',
	`FREGION` varchar(50) default null comment '地区',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统语种表';

-- ----------------------------
-- 表的结构 `ECT_DICT_I18N`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DICT_I18N`;
CREATE TABLE `ECT_DICT_I18N` (
	`FID` varchar(30) not null comment '主键',
	`FDICT_TYPE` varchar(20) not null comment '字典类型',
	`FDICT_CODE` varchar(30) not null comment '字典代码',
	`FLANG_CODE` varchar(30) default null comment '语种代码',
	`FTEXT` varchar(200) default null comment '显示名称',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统数据字典国际化表';

-- ----------------------------
-- 表的结构 `ECT_APPL`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_APPL`;
CREATE TABLE `ECT_APPL` (
	`FID` varchar(30) not null comment '主键',
	`FAPPL_TYPE` varchar(20) not null comment '类型',
	`FAPPL_CODE` varchar(30) not null comment '代码',
	`FAPPL_NAME` varchar(50) not null comment '名称',
	`FICON` varchar(50) default null comment '图标',
	`FORDER` int(11) default 0 comment '显示次序',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='应用信息表';

-- ----------------------------
-- 表的结构 `ECT_MODULE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_MODULE`;
CREATE TABLE `ECT_MODULE` (
	`FID` varchar(30) not null comment '主键',
	`FMODULE_TYPE` varchar(20) not null comment '类型',
	`FMODULE_CODE` varchar(30) not null comment '代码',
	`FMODULE_NAME` varchar(50) not null comment '名称',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FORDER` int(11) default 0 comment '显示次序',
	`FICON` varchar(100) default null comment '图标',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='模块信息表';

-- ----------------------------
-- 表的结构 `ECT_FUNCTION`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNCTION`;
CREATE TABLE `ECT_FUNCTION` (
	`FID` varchar(30) not null comment '主键',
	`FFUNC_TYPE` varchar(20) not null comment '类型',
	`FFUNC_CODE` varchar(30) not null comment '代码',
	`FFUNC_NAME` varchar(50) not null comment '名称',
	`FNAMEPY` varchar(20) not null comment '拼音码',
	`FMODULE_CODE` varchar(30) not null comment '模块代码',
	`FDISPLAYABLE` bit(1) default 0 comment '可显示',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FORDER` int(11) default 0 comment '显示次序',
	`FTARGET` varchar(20) not null comment '打开目标',
	`FICON` varchar(100) default null comment '图标',
	`FURL` varchar(200) not null comment '链接地址',
	`FACTION` varchar(300) not null comment '动作',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能信息表';

-- ----------------------------
-- 表的结构 `ECT_OPERATION`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_OPERATION`;
CREATE TABLE `ECT_OPERATION` (
	`FID` varchar(30) not null comment '主键',
	`FOPER_TYPE` varchar(20) not null comment '类型',
	`FOPER_CODE` varchar(30) not null comment '代码',
	`FOPER_NAME` varchar(50) not null comment '名称',
	`FPARENT_CODE` varchar(30) default null comment '上级代码',
	`FICON` varchar(100) default null comment '图标',
	`FURL` varchar(200) not null comment '链接地址',
	`FACTION` varchar(300) not null comment '操作的方法',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='操作表';

-- ----------------------------
-- 表的结构 `ECT_FUNC_OPER`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNC_OPER`;
CREATE TABLE `ECT_FUNC_OPER` (
	`FID` varchar(30) not null comment '主键',
	`FFUNC_CODE` varchar(30) not null comment '功能代码',
	`FOPER_CODE` varchar(30) not null comment '操作代码',
	`FPARENT_CODE` varchar(30) default null comment '上级代码',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FORDER` int(11) default 0 comment '显示次序',
	`FTARGET` varchar(20) not null comment '打开目标',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能操作信息表';

-- ----------------------------
-- 表的结构 `ECT_DATA_ACL`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DATA_ACL`;
CREATE TABLE `ECT_DATA_ACL` (
	`FID` varchar(30) not null comment '主键',
	`FDATA_CODE` varchar(30) not null comment '代码',
	`FDATA_NAME` varchar(50) not null comment '名称',
	`FPROPERTY` varchar(30) not null comment '属性',
	`FFIELD` varchar(30) not null comment '字段名称',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FORDER` int(11) default 0 comment '显示次序',
	`FCLAZZ` varchar(200) not null comment '类',
	`FPARAMETER` varchar(4000) not null comment '参数',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据访问信息表';

-- ----------------------------
-- 表的结构 `ECT_SYS_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_SYS_CONFIG`;
CREATE TABLE `ECT_SYS_CONFIG` (
	`FID` varchar(30) not null comment '主键',
	`FCONF_TYPE` varchar(20) default null comment '类型',
	`FCONF_CODE` varchar(30) not null comment '代码',
	`FCONF_NAME` varchar(50) not null comment '名称',
	`FVERSION` varchar(20) not null comment '版本',
	`FCONTENT` text comment '配置内容',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统配置信息表';

-- ----------------------------
-- 表的结构 `ECT_SYS_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_SYS_LOG`;
CREATE TABLE `ECT_SYS_LOG` (
	`FID` varchar(30) not null comment '主键',
	`FLOG_TYPE` varchar(20) not null comment '类型',
	`FUSER_ID` varchar(30) not null comment '操作员ID',
	`FOPERATOR` varchar(30) not null comment '操作员',
	`FLEVEL` varchar(20) not null comment '日志级别',
	`FCLIENT_IP` varchar(50) not null comment '操作IP',
	`FSERVER_IP` varchar(50) not null comment '服务器IP',
	`FVISIT_PATH` varchar(500) not null comment '访问路径',
	`FMSG` varchar(2000) not null comment '日志信息',
	`FUPDATE_TIME` datetime not null comment '更新时间',
	`FCONTENT` text comment '操作内容',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统日志表';

-- ----------------------------
-- 表的结构 `ECT_DATASOURCE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DATASOURCE`;
CREATE TABLE `ECT_DATASOURCE` (
	`FID` varchar(30) not null comment '主键',
	`FDS_KEY` varchar(30) not null comment '数据源key',
	`FDS_CODE` varchar(30) not null comment '数据源代码',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据源映射表';

-- ----------------------------
-- 表的结构 `ECT_MENU`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_MENU`;
CREATE TABLE `ECT_MENU` (
	`FID` varchar(30) not null comment '主键',
	`FMENU_TYPE` varchar(20) not null comment '类型',
	`FMENU_CODE` varchar(30) not null comment '代码',
	`FMENU_NAME` varchar(50) not null comment '名称',
	`FAPPL_CODE` varchar(30) not null comment '应用代码',
	`FFUNC_CODE` varchar(30) default null comment '功能代码',
	`FPARENT_CODE` varchar(30) default null comment '上级代码',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FORDER` int(11) default 0 comment '显示次序',
	`FLVALUE` int(11) not null comment '左值',
	`FRVALUE` int(11) not null comment '右值',
	`FLEVEL` int(11) default null comment '层级',
	`FSUBNUM` int(11) default null comment '子节点个数',
	`FTARGET` varchar(20) not null comment '打开目标',
	`FICON` varchar(100) default null comment '图标',
	`FURL` varchar(200) not null comment '链接地址',
	`FDYNAMIC_MENU` varchar(300) default null comment '动态菜单',
	`FACTION` varchar(300) not null comment '动作',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='应用菜单表';

-- ----------------------------
-- 表的结构 `ECT_USER`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER`;
CREATE TABLE `ECT_USER` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_TYPE` varchar(20) not null comment '类型',
	`FUSER_CODE` varchar(30) not null comment '代码',
	`FUSER_NAME` varchar(50) not null comment '名称',
	`FROLE_CODE` varchar(30) not null comment '角色代码',
	`FORG_CODE` varchar(30) not null comment '机构代码',
	`FPOST_CODE` varchar(30) not null comment '岗位代码',
	`FNICKNAME` varchar(20) default null comment '昵称',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FLOCK_STATE` smallint(1) default null comment '锁定状态',
	`FONLINE` smallint(6) default 0 comment '是否在线',
	`FSAFETY` varchar(20) default null comment '安全码',
	`FINCEPT_TIME` datetime default null comment '生效时间',
	`FEXPIRY_TIME` datetime default null comment '失效时间',
	`FLOGIN_TIME` datetime default null comment '登录时间',
	`FLOGIN_COUNT` int(11) default null comment '登录次数',
	`FCLIENT_IP` varchar(30) default null comment '客户端IP',
	`FPASSWORD` varchar(300) default null comment '密码',
	`FREAL_NAME` varchar(20) default null comment '真实姓名',
	`FSEX` varchar(10) default null comment '性别',
	`FBIRTHDAY` datetime default null comment '出生日期',
	`FTELEPHONE` varchar(20) default null comment '电话号码',
	`FMOBILE` varchar(20) default null comment '手机号码',
	`FJOB` varchar(20) default null comment '职位',
	`FPOSTCODE` varchar(10) default null comment '邮编',
	`FEMAIL` varchar(100) default null comment '邮箱',
	`FADDRESS` varchar(100) default null comment '联系地址',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户表';

-- ----------------------------
-- 表的结构 `ECT_ORG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_ORG`;
CREATE TABLE `ECT_ORG` (
	`FID` varchar(30) not null comment '主键',
	`FORG_TYPE` varchar(20) not null comment '类型',
	`FORG_CODE` varchar(30) not null comment '代码',
	`FORG_NAME` varchar(50) not null comment '名称',
	`FPARENT_CODE` varchar(30) default null comment '上级代码',
	`FINCEPT_TIME` datetime default null comment '生效时间',
	`FEXPIRY_TIME` datetime default null comment '失效时间',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FORDER` int(11) default 0 comment '显示次序',
	`FLVALUE` int(11) not null comment '左值',
	`FRVALUE` int(11) not null comment '右值',
	`FLEVEL` int(11) default null comment '层级',
	`FSUBNUM` int(11) default null comment '子节点个数',
	`FCHARACTER` varchar(30) default null comment '机构性质',
	`FVALIDATE_CODE` varchar(30) default null comment '验证码',
	`FLINKMAN` varchar(50) default null comment '联系人',
	`FTELEPHONE` varchar(20) default null comment '电话号码',
	`FFAX` varchar(20) default null comment '传真号码',
	`FEMAIL` varchar(100) default null comment '电子信箱',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='机构信息表';

-- ----------------------------
-- 表的结构 `ECT_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_ROLE`;
CREATE TABLE `ECT_ROLE` (
	`FID` varchar(30) not null comment '主键',
	`FROLE_TYPE` varchar(20) not null comment '类型',
	`FROLE_CODE` varchar(30) not null comment '代码',
	`FROLE_NAME` varchar(50) not null comment '名称',
	`FORG_CODE` varchar(30) not null comment '机构代码',
	`FPARENT_CODE` varchar(30) default null comment '上级代码',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FORDER` int(11) default 0 comment '显示次序',
	`FLVALUE` int(11) not null comment '左值',
	`FRVALUE` int(11) not null comment '右值',
	`FLEVEL` int(11) default null comment '层级',
	`FSUBNUM` int(11) default null comment '子节点个数',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='角色信息表';

-- ----------------------------
-- 表的结构 `ECT_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GROUP`;
CREATE TABLE `ECT_GROUP` (
	`FID` varchar(30) not null comment '主键',
	`FGROUP_TYPE` varchar(20) not null comment '类型',
	`FGROUP_CODE` varchar(30) not null comment '代码',
	`FGROUP_NAME` varchar(50) not null comment '名称',
	`FPARENT_CODE` varchar(30) default null comment '上级代码',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FORDER` int(11) default 0 comment '显示次序',
	`FLVALUE` int(11) not null comment '左值',
	`FRVALUE` int(11) not null comment '右值',
	`FLEVEL` int(11) default null comment '层级',
	`FSUBNUM` int(11) default null comment '子节点个数',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='组信息表';

-- ----------------------------
-- 表的结构 `ECT_POST`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_POST`;
CREATE TABLE `ECT_POST` (
	`FID` varchar(30) not null comment '主键',
	`FPOST_TYPE` varchar(20) not null comment '类型',
	`FPOST_CODE` varchar(30) not null comment '代码',
	`FPOST_NAME` varchar(50) not null comment '名称',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='岗位信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_SUBJECT`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_SUBJECT`;
CREATE TABLE `ECT_USER_SUBJECT` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(30) not null comment '用户ID',
	`FSUBJECT_TYPE` varchar(20) not null comment '主体类型',
	`FSUBJECT_CODE` varchar(30) not null comment '主体代码',
	`FCAN_MANAGE` bit(1) default null comment '是否可以管理',
	`FINCEPT_TIME` datetime default null comment '生效时间',
	`FEXPIRY_TIME` datetime default null comment '失效时间',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户主体信息表';

-- ----------------------------
-- 表的结构 `ECT_FUNC_AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNC_AUTHORITY`;
CREATE TABLE `ECT_FUNC_AUTHORITY` (
	`FID` varchar(30) not null comment '主键',
	`FSUBJECT_TYPE` varchar(20) not null comment '主体类型',
	`FSUBJECT_CODE` varchar(30) not null comment '主体代码',
	`FFUNC_CODE` varchar(30) not null comment '功能代码',
	`FOPER_CODE` varchar(30) not null comment '操作代码',
	`FPERMISSION` int(11) default 1 comment '权限：0.禁用、1.只读、2.可授权',
	`FINCEPT_TIME` datetime default null comment '生效时间',
	`FEXPIRY_TIME` datetime default null comment '失效时间',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能权限表';

-- ----------------------------
-- 表的结构 `ECT_DATA_AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DATA_AUTHORITY`;
CREATE TABLE `ECT_DATA_AUTHORITY` (
	`FID` varchar(30) not null comment '主键',
	`FSUBJECT_TYPE` varchar(20) not null comment '主体类型',
	`FSUBJECT_CODE` varchar(30) not null comment '主体代码',
	`FDATA_CODE` varchar(30) not null comment '数据权限CODE',
	`FDATA_VALUE` text not null comment '数据权限值',
	`FPERMISSION` int(11) default 1 comment '权限：0.禁用、1.只读、2.可授权',
	`FINCEPT_TIME` datetime default null comment '生效时间',
	`FEXPIRY_TIME` datetime default null comment '失效时间',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据权限表';

-- ----------------------------
-- 表的结构 `ECT_FIELD_AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FIELD_AUTHORITY`;
CREATE TABLE `ECT_FIELD_AUTHORITY` (
	`FID` varchar(30) not null comment '主键',
	`FSUBJECT_TYPE` varchar(20) not null comment '主体类型',
	`FSUBJECT_CODE` varchar(30) not null comment '主体代码',
	`FDATA_CODE` varchar(30) not null comment '数据代码',
	`FFIELD` varchar(30) not null comment '字段名称',
	`FPERMISSION` int(11) default 1 comment '权限：0.禁用、1.只读、2.可授权',
	`FINCEPT_TIME` datetime default null comment '生效时间',
	`FEXPIRY_TIME` datetime default null comment '失效时间',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据权限表';

-- ----------------------------
-- 表的结构 `ECT_HANDOVER`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_HANDOVER`;
CREATE TABLE `ECT_HANDOVER` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(30) not null comment '用户ID',
	`FTRUSTEE_ID` varchar(30) not null comment '受托人ID',
	`FHANDOVER` bit(1) default 0 comment '是否交接',
	`FALL_AUTH` bit(1) default 0 comment '是否所有权限',
	`FINCEPT_TIME` datetime not null comment '生效时间',
	`FEXPIRY_TIME` datetime default null comment '失效时间',
	`FEXEC_TIME` datetime default null comment '执行时间',
	`FEXEC_STATE` smallint(6) default 0 comment '执行状态',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDITOR_ID` varchar(30) default null comment '审核员',
	`FAUDIT_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='权限交接表';

-- ----------------------------
-- 表的结构 `ECT_HAND_DETAIL`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_HAND_DETAIL`;
CREATE TABLE `ECT_HAND_DETAIL` (
	`FID` varchar(30) not null comment '主键',
	`FHANDOVER_ID` varchar(30) not null comment '交接ID',
	`FSUBJECT_TYPE` varchar(20) default null comment '主体类型',
	`FSUBJECT_CODE` varchar(30) not null comment '主体代码',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='权限交接明细表';

-- ----------------------------
-- 表的结构 `ECT_USER_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_CONFIG`;
CREATE TABLE `ECT_USER_CONFIG` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(30) not null comment '用户ID',
	`FCONF_CODE` varchar(30) not null comment '代码',
	`FCONF_NAME` varchar(50) not null comment '名称',
	`FVERSION` int(11) default null comment '版本',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FCONTENT` text comment '配置内容',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户配置信息表';


-- ----------------------------
-- 恢复外键约束检查
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;