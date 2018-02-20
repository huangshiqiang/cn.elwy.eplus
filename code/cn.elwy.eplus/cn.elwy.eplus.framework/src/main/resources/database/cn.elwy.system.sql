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
-- F方法、I索引、P分区表、S序列、T表、V视图、PR存储过程、TR触发器、TE临时表、TY类型
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
-- 表的结构 `ECT_APPL_CONF`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_APPL_CONF`;
CREATE TABLE `ECT_APPL_CONF` (
	`FID` varchar(30) not null comment '主键',
	`FCONF_CODE` varchar(30) not null comment '代码',
	`FCONF_NAME` varchar(50) not null comment '名称',
	`FCONF_TYPE` varchar(20) default null comment '类型',
	`FOBJECT_ID` varchar(30) not null comment '主体ID',
	`FOBJECT_TYPE` varchar(20) default null comment '主体类型',
	`FVALUE_TYPE` varchar(20) default null comment '值类型',
	`FVALUE` varchar(500) default null comment 'String值',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FCHECK_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FCHECKER_ID` varchar(30) default null comment '审核员',
	`FCHECK_TIME` datetime default null comment '审核时间',
	`FCREATOR_ID` varchar(30) not null comment '创建者',
	`FCREATE_TIME` datetime not null comment '创建时间',
	`FDELETOR_ID` varchar(30) default null comment '删除者',
	`FDELETE_TIME` datetime default null comment '删除时间',
	`FEDITOR_ID` varchar(30) default null comment '修改者',
	`FEDIT_TIME` datetime default null comment '修改时间',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统参数表：类型可选值：int,string,boolean,date,datetime,time,double等';

-- ----------------------------
-- 表的结构 `ECT_SYS_CONF`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_SYS_CONF`;
CREATE TABLE `ECT_SYS_CONF_FILE` (
	`FID` varchar(30) not null comment '主键',
	`FCONF_CODE` varchar(30) not null comment '代码',
	`FCONF_NAME` varchar(50) not null comment '名称',
	`FCONF_TYPE` varchar(20) default null comment '类型',
	`FVERSION` int(11) not null comment '版本',
	`FCONTENT` text comment '配置内容',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
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
-- 表的结构 `ECT_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_LOG`;
CREATE TABLE `ECT_LOG` (
	`FID` varchar(30) not null comment '主键',
	`FLOG_TYPE` varchar(20) not null comment '类型',
	`FUSER_ID` varchar(30) not null comment '操作员ID',
	`FOPERATOR` varchar(30) not null comment '操作员',
	`FLEVEL` varchar(20) not null comment '日志级别',
	`FCLIENT_IP` varchar(50) not null comment '操作IP',
	`FSERVER_IP` varchar(50) not null comment '服务器IP',
	`FVISIT_PATH` varchar(300) not null comment '访问路径',
	`FMSG` varchar(100) not null comment '日志信息',
	`FUPDATE_TIME` datetime not null comment '更新时间',
	`FCONTENT` text comment '操作内容',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统日志表';

-- ----------------------------
-- 表的结构 `ECT_DICT`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DICT`;
CREATE TABLE `ECT_DICT` (
	`FID` varchar(30) not null comment '主键',
	`FDICT_TYPE` varchar(20) not null comment '类型',
	`FDICT_CODE` varchar(30) not null comment '代码',
	`FDICT_VALUE` varchar(50) not null comment '值',
	`FORDER` int(11) default 0 comment '显示次序',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
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
) ENGINE=InnoDB default charset=utf8 comment='系统数据字典表';

-- ----------------------------
-- 表的结构 `ECT_DICT_TREE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DICT_TREE`;
CREATE TABLE `ECT_DICT_TREE` (
	`FID` varchar(30) not null comment '主键',
	`FDICT_TYPE` varchar(20) not null comment '类型',
	`FDICT_CODE` varchar(30) not null comment '代码',
	`FDICT_VALUE` varchar(50) not null comment '值',
	`FPARENT_ID` varchar(30) default null comment '上级ID',
	`FLVALUE` int(11) not null comment '左值',
	`FRVALUE` int(11) not null comment '右值',
	`FLEVEL` int(11) default null comment '层级',
	`FSUBNUM` int(11) default null comment '子节点个数',
	`FORDER` int(11) default 0 comment '显示次序',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
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
	`FLANG_CODE` varchar(30) default null comment '语种代码',
	`FDICT_TYPE` varchar(20) not null comment '字典类型',
	`FDICT_CODE` varchar(30) not null comment '字典代码',
	`FTEXT` varchar(100) default null comment '显示名称',
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
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
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
-- 表的结构 `ECT_UI_CUSTOM`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_UI_CUSTOM`;
CREATE TABLE `ECT_UI_CUSTOM` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(50) not null comment '用户ID',
	`FPATH` varchar(30) not null comment '代码',
	`FCONTENT` varchar(20) not null comment '类型',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='模块信息表';

-- ----------------------------
-- 表的结构 `ECT_MODULE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_MODULE`;
CREATE TABLE `ECT_MODULE` (
	`FID` varchar(30) not null comment '主键',
	`FNAME` varchar(50) not null comment '名称',
	`FCODE` varchar(30) not null comment '代码',
	`FTYPE` varchar(20) not null comment '类型',
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
	`FNAME` varchar(50) not null comment '名称',
	`FCODE` varchar(30) not null comment '代码',
	`FTYPE` varchar(20) not null comment '类型',
	`FNAMEPY` varchar(20) not null comment '拼音码',
	`FMODULE_ID` varchar(30) not null comment '模块ID',
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
	`FNAME` varchar(50) not null comment '名称',
	`FCODE` varchar(30) not null comment '代码',
	`FTYPE` varchar(20) not null comment '类型',
	`FPARENT_ID` varchar(30) default null comment '上级ID',
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
	`FFUNC_ID` varchar(30) not null comment '功能ID',
	`FOPER_ID` varchar(30) not null comment '操作ID',
	`FPARENT_ID` varchar(30) default null comment '上级ID',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FORDER` int(11) default 0 comment '显示次序',
	`FTARGET` varchar(20) not null comment '打开目标',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能操作信息表';

-- ----------------------------
-- 表的结构 `ECT_FUNC_DATA`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNC_DATA`;
CREATE TABLE `ECT_FUNC_DATA` (
	`FID` varchar(30) not null comment '主键',
	`FNAME` varchar(50) not null comment '名称',
	`FCODE` varchar(30) not null comment '数据代码',
	`FPROPERTY` varchar(50) not null comment '属性',
	`FFIELD` varchar(50) not null comment '字段名称',
	`FFUNC_ID` varchar(30) not null comment '功能ID',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FORDER` int(11) default 0 comment '显示次序',
	`FCLAZZ` varchar(500) not null comment '类',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能数据信息表';

-- ----------------------------
-- 恢复外键约束检查
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;