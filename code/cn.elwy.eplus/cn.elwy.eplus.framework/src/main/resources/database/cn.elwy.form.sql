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
-- 表的结构 `ECT_FUNC_SERVICE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNC_SERVICE`;
CREATE TABLE `ECT_FUNC_SERVICE` (
  `FID` varchar(30) not null comment '主键',
  `FFUNC_CODE` varchar(30) default null comment '功能代码',
  `FOBJECT_TYPE` varchar(20) not null comment '类型:TABLE、VIEW',
  `FOBJECT_NAME` varchar(30) not null comment '表或视图名',
  `FCLASS_NAME` varchar(50) default null comment '类名称',
--  `FPARENT_TABLE` varchar(500) default null comment '关联父表',
--  `FPARENT_TABLE_FK` varchar(500) default null comment '关联父表外键',
  `FISSYNC` bit(1) default null comment '同步',
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
) ENGINE=InnoDB default charset=utf8 comment='数据表格功能列表';

-- ----------------------------
-- 表的结构 `ECT_GRID`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GRID`;
CREATE TABLE `ECT_GRID` (
  `FID` varchar(30) not null comment '主键',
	`FGRID_CODE` varchar(30) not null comment '代码',
	`FGRID_NAME` varchar(50) not null comment '名称',
  `FFUNC_CODE` varchar(30) default null comment '功能代码',
  `FCAN_CUSTOM` bit(1) default 0 comment '可自定义显示',
--  `FORDER_NO` int(11) default 0 comment '显示次序',
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
) ENGINE=InnoDB default charset=utf8 comment='数据表格功能列表';

-- ----------------------------
-- 表的结构 `ECT_GRID_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GRID_INFO`;
CREATE TABLE `ECT_GRID_INFO` (
	`FID` varchar(30) not null comment '主键',
	`FGRID_CODE` varchar(30) not null comment '表格代码',
	`FCOLUMN_CODE` varchar(30) not null comment '代码',
	`FCOLUMN_NAME` varchar(50) not null comment '名称',
	`FPROPERTY` varchar(30) not null comment '属性',
	`FIS_LIST` bit(1) default null comment '是否列表字段',
	`FIS_SHOW` bit(1) default null comment '是否显示字段',
	`FIS_FORM` bit(1) default null comment '是否表单显示',
	`FIS_EDIT` bit(1) default null comment '是否编辑字段',
	`FWIDTH` int(11) not null comment '列宽',
	`FCOLSPAN` int(11) default 1 comment '跨列',
	`FROWSPAN` int(11) default 1 comment '跨行',
	`FLEVEL` int(11) default null comment '层级',
	`FALIGN` varchar(20) not null comment '对齐',
	`FQUERY_STATE` int(11) default null comment '是否高级查询',
	`FQUERY_TYPE` VARCHAR(30) default null comment '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）',
	`FDICT_TYPE` varchar(30) default null comment '字典类型',
	`FFORMAT` varchar(50) not null comment '格式化',

	`FREQUIRED` bit(1) default 0 comment '是否必填',
	`FMIN_LENGTH` int(11) default 0 comment '最小长度',
	`FMAX_LENGTH` int(11) default 0 comment '最大长度',
	`FMIN_VALUE` VARCHAR(20) default null comment '最小值',
	`FMAX_VALUE` VARCHAR(20) default null comment '最大值',
	`FVALIDATE_TYPE` VARCHAR(30) default null comment '验证类型',
	`FWIDGET_ID` varchar(30) not null comment '控件类型（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）',

	`FIS_PK` bit(1) default null comment '是否主键',
	`FIS_NULL` bit(1) default null comment '是否可为空',
	`FIS_INSERT` bit(1) default null comment '是否为插入字段',
	`FJAVA_TYPE` varchar(30) default null comment 'JAVA类型',
	`FJDBC_TYPE` varchar(30) default null comment 'JDBC类型',
--	`FWIDGET_PARAMS` varchar(2000) not null comment '控件JSON参数',
--	`FFIELD_LABELS` VARCHAR(50) default null comment '字段标签',
--	`FFIELD_KEYS` VARCHAR(512) default null comment '字段关键字',
--	`FSEARCH_LABEL` VARCHAR(50) default null comment '查询标签',
--	`FSEARC_HKEY` VARCHAR(50) default null comment '查询快捷键',
--	`FSETTINGS` VARCHAR(2000) default null comment '其它设置（扩展字段JSON）',

--	`FDISPLAYABLE` varchar(30) not null comment '可显示',
	`FORDER` int(11) default 0 comment '显示次序',
	`FREMARK` varchar(200) default null comment '备注',
	PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据表格列信息表';


-- ----------------------------
-- 表的结构 `ECT_WIDGETS`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_WIDGETS`;
CREATE TABLE `ECT_WIDGETS` (
	`FID` varchar(30) not null comment '主键',
	`FNAME` varchar(50) not null comment '名称',
	`FCODE` varchar(30) not null comment '代码',
	`FTYPE` varchar(20) not null comment '类型',
	`FGROUP` varchar(20) not null comment '分组',
	`FENABLE` bit(1) default 0 comment '是否启用',
	`FAUDIT_STATE` smallint(6) default 0 comment '审核状态',
	`FDELETE_STATE` smallint(6) default 0 comment '删除状态',
	`FEDIT_STATE` smallint(6) not null comment '编辑状态',
	`FORDER` int(11) default 0 comment '显示次序',
	`FICON` varchar(100) default null comment '图标',
	`FCONTENT` text not null comment '控件内容',
  `FINCLUDE_FILE` text not null comment '引用文件',
  `FTEMPLATE` text not null comment '控件模版',
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
) ENGINE=InnoDB default charset=utf8 comment='控件库列表';


-- ----------------------------
-- 表的结构 `ECT_GENERATE_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GENERATE_CONFIG`;
CREATE TABLE `ECT_GENERATE_CONFIG` (
	`FID` varchar(30) not null comment '主键',
	`FGENE_CODE` varchar(50) not null comment '代码',
	`FGENE_NAME` varchar(50) not null comment '名称',
	
	`FFILE_PATH` varchar(500) default null comment '生成文件路径',
	`FPACKAGE_NAME` varchar(200) default null comment '生成包路径',
	`FMODULE_NAME` varchar(30) default null comment '生成模块名',
	`FSUB_MODULE_NAME` varchar(30) default null comment '生成子模块名',
	`FFUNCTION_CODE` varchar(50) default null comment '功能代码',
	`FFUNCTION_NAME` varchar(50) default null comment '功能名称',
	`FFUNCTION_AUTHOR` varchar(50) default null comment '功能作者',
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
) ENGINE=InnoDB default charset=utf8 comment='代码生成配置信息表';

-- ----------------------------
-- 表的结构 `ECT_GENERATE_CODE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GENERATE_CODE`;
CREATE TABLE `ECT_GENERATE_CODE` (
	`FID` varchar(30) not null comment '主键',
	`FGENE_CODE` varchar(30) not null comment '生成配置代码',
	`FGRID_CODE` varchar(30) not null comment '表格代码',
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
) ENGINE=InnoDB default charset=utf8 comment='代码生成配置信息表';


-- ----------------------------
-- 恢复外键约束检查
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;