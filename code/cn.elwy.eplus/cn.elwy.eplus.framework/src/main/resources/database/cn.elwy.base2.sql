/*
-- --------------------------------------------------------
-- 作者：黄仕强
-- 系统版本：version 2.0
-- 创建日期：2017-02-19 20:30:00
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
-- 创建数据库: `CN_ELWY_FOSGI`
--
*/
CREATE DATABASE IF not EXISTS `CN_ELWY_FOSGI`;
USE `CN_ELWY_FOSGI`;


-- ----------------------------
-- 表的结构 `ECT_APPL`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_APPL`;
CREATE TABLE `ECT_APPL` (
  `FID` varchar(30) not null comment '主键',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FICON` varchar(100) default null comment '图标',
  `FURI` varchar(300) not null comment '链接地址',
  `FTARGET` varchar(20) not null comment '打开目标',
  `FACTION` varchar(300) not null comment '动作',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='应用信息表';

-- ----------------------------
-- 表的结构 `ECT_MODULE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_MODULE`;
CREATE TABLE `ECT_MODULE` (
  `FID` varchar(30) not null comment '主键',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
--  `FCONTEXT_PATH` varchar(50) not null comment '上下文路径',
  `FICON` varchar(100) default null comment '图标',
  `FURI` varchar(300) not null comment '链接地址',
  `FACTION` varchar(300) not null comment '动作',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='模块信息表';

-- ----------------------------
-- 表的结构 `ECT_FUNCTION`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNCTION`;
CREATE TABLE `ECT_FUNCTION` (
  `FID` varchar(30) not null comment '主键',
  `FMODULE_ID` varchar(30) not null comment '模块ID',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FICON` varchar(100) default null comment '图标',
  `FURI` varchar(300) not null comment '链接地址',
  `FACTION` varchar(300) not null comment '动作',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能信息表';

-- ----------------------------
-- 表的结构 `ECT_OPERATION`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_OPERATION`;
CREATE TABLE `ECT_OPERATION` (
  `FID` varchar(30) not null comment '主键',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FICON` varchar(100) default null comment '图标',
  `FURI` varchar(300) not null comment '链接地址',
  `FACTION` varchar(300) not null comment '操作的方法',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='操作表';

-- ----------------------------
-- 表的结构 `ECT_FUNC_OPER`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNC_OPER`;
CREATE TABLE `ECT_FUNC_OPER` (
  `FID` varchar(30) not null comment '主键',
  `FFUNC_ID` varchar(30) default null comment '功能ID',
  `FOPER_ID` varchar(30) default null comment '操作ID',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FNAME` varchar(50) not null comment '名称',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FICON` varchar(100) default null comment '图标',
  `FURI` varchar(300) not null comment '链接地址',
  `FTARGET` varchar(20) not null comment '打开目标',
  `FACTION` varchar(300) not null comment '动作',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能操作信息表';

-- ----------------------------
-- 表的结构 `ECT_FUNC_DATA`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNC_DATA`;
CREATE TABLE `ECT_FUNC_DATA` (
  `FID` varchar(30) not null comment '主键',
  `FFUNC_ID` varchar(30) default null comment '功能ID',
  `FCODE` varchar(30) not null comment '数据代码',
  `FNAME` varchar(50) not null comment '名称',
  `FPROPERTY` varchar(50) not null comment '属性',
  `FFIELD` varchar(50) not null comment '字段名称',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FCLAZZ` varchar(500) not null comment '类',
--  `FOPER_ID` varchar(30) default null comment '操作ID',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能数据信息表';

-- ----------------------------
-- 表的结构 `ECT_GRID`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GRID`;
CREATE TABLE `ECT_GRID` (
  `FID` varchar(30) not null comment '主键',
  `FFUNC_ID` varchar(30) default null comment '功能ID',
  `FCLASS_NAME` varchar(50) default null comment '类名称',
  `FPARENT_TABLE` varchar(500) default null comment '关联父表',
  `FPARENT_TABLE_FK` varchar(500) default null comment '关联父表外键',
  `FISSYNC` bit(1) default null comment '同步',
  `FTYPE` varchar(20) not null comment '类型:TABLE、VIEW',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FCAN_CUSTOM` bit(1) default 0 comment '可自定义显示',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据表格功能列表';

-- ----------------------------
-- 表的结构 `ECT_GRID_COLUMN`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GRID_COLUMN`;
CREATE TABLE `ECT_GRID_COLUMN` (
  `FID` varchar(30) not null comment '主键',
  `FTABLE_ID` varchar(30) default null comment '表格ID',
--  `FMODEL_ID` varchar(30) not null comment '模型ID',
--  `FMODEL_CODE` varchar(50) default null comment '模型代码',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FJAVA_FIELD` varchar(200) default null comment 'JAVA字段名',
  `FJAVA_TYPE` varchar(100) default null comment 'JAVA类型',
  `FJDBC_TYPE` varchar(100) default null comment 'JDBC类型',
  `FDICT_TYPE` VARCHAR(100) default null comment '字典类型',
  `FIS_PK` bit(1) default null comment '是否主键',
  `FIS_NULL` bit(1) default null comment '是否可为空',
  `FIS_INSERT` bit(1) default null comment '是否为插入字段',
  `FIS_EDIT` bit(1) default null comment '是否编辑字段',
  `FIS_LIST` bit(1) default null comment '是否列表字段',
  `FIS_QUERY` bit(1) default null comment '是否查询字段',
  `FIS_FORM` bit(1) default null comment '是否表单显示',
  `FQUERY_TYPE` VARCHAR(50) default null comment '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）',
  `FWIDGET_ID` varchar(30) default null comment '控件类型（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）',
--  `FWIDGET_PARAMS` varchar(2000) not null comment '控件JSON参数',
--  `FFIELD_LABELS` VARCHAR(50) default NULL,
--  `FFIELD_KEYS` VARCHAR(512) default NULL,
  `FSEARCH_LABEL` VARCHAR(50) default NULL,
  `FSEARC_HKEY` VARCHAR(50) default NULL,
  `FVALIDATE_TYPE` VARCHAR(50) default NULL,
  `FMIN_LENGTH` VARCHAR(20) default NULL,
  `FMAX_LENGTH` VARCHAR(20) default NULL,
  `FMIN_VALUE` VARCHAR(20) default NULL,
  `FMAX_VALUE` VARCHAR(20) default NULL,
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FSETTINGS` VARCHAR(2000) default null comment '其它设置（扩展字段JSON）',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据表格列信息表';

-- ----------------------------
-- 表的结构 `ECT_CODE_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_CODE_CONFIG`;
CREATE TABLE `ECT_CODE_CONFIG` (
  `FID` varchar(30) not null comment '主键',
--  `FMODEL_ID` varchar(30) default null comment '模型ID',
  `FNAME` varchar(50) not null comment '名称',
  `FCATEGORY` varchar(50) default null comment '分类',
  `FFILE_PATH` varchar(500) default null comment '生成文件路径',
  `FPACKAGE_NAME` varchar(200) default null comment '生成包路径',
  `FMODULE_NAME` varchar(30) default null comment '生成模块名',
  `FSUB_MODULE_NAME` varchar(30) default null comment '生成子模块名',
  `FFUNCTION_CODE` varchar(50) default null comment '功能代码',
  `FFUNCTION_NAME` varchar(50) default null comment '功能名称',
  `FFUNCTION_AUTHOR` varchar(50) default null comment '功能作者',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='代码生成配置信息表';

-- ----------------------------
-- 表的结构 `ECT_APPL_FUNC`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_APPL_FUNC`;
CREATE TABLE `ECT_APPL_FUNC` (
  `FID` varchar(30) not null comment '主键',
  `FAPPL_ID` varchar(30) not null comment '应用ID',
  `FFUNC_ID` varchar(30) default null comment '功能ID',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FLEFT_ID` varchar(30) not null comment '左ID',
  `FRIGHT_ID` varchar(30) not null comment '右ID',
  `FLEVEL` int(11) default null comment '层级',
  `FSUBNUM` int(11) default null comment '子节点个数',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FTARGET` varchar(20) not null comment '打开目标',
  `FICON` varchar(100) default null comment '图标',
  `FURI` varchar(300) not null comment '链接地址',
  `FACTION` varchar(300) not null comment '动作',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='应用功能表';

-- ----------------------------
-- 表的结构 `ECT_USER`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER`;
CREATE TABLE `ECT_USER` (
  `FID` varchar(30) not null comment '主键',
  `FROLE_ID` varchar(30) not null comment '角色ID',
  `FORG_ID` varchar(30) not null comment '机构ID',
  `FPOST_ID` varchar(30) not null comment '岗位ID',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FPASSWORD` varchar(300) default null comment '密码',
  `FREAL_NAME` varchar(20) default null comment '真实姓名',
  `FGENDER` varchar(10) default null comment '性别',
  `FBIRTHDAY` datetime not null comment '出生日期',
  `FNICKNAME` varchar(20) default null comment '昵称',
  `FJOB` varchar(20) default null comment '职位',
  `FEMAIL` varchar(100) default null comment '邮箱',
  `FADDRESS` varchar(100) default null comment '联系地址',
  `FPOSTCODE` varchar(10) default null comment '邮编',
  `FTELEPHONE` varchar(20) default null comment '电话号码',
  `FMOBILE` varchar(20) default null comment '手机号码',
  `FSAFETY` varchar(20) default null comment '安全码',
  `FLOCK_STATE` bit(1) default null comment '锁定状态',
  `FENABLE_STATE` bit(1) default null comment '生效启用状态',
  `FSTART_DATE` datetime default null comment '开始生效时间',
  `FEND_DATE` datetime default null comment '结束生效时间',
  `FLOGIN_TIME` datetime default null comment '登录时间',
  `FLOGIN_COUNT` int(11) default null comment '登录次数',
  `FCLIENT_IP` varchar(30) default null comment '客户端IP',
  `FONLINE` smallint(6) default 0 comment '是否在线',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户表';

-- ----------------------------
-- 表的结构 `ECT_ORG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_ORG`;
CREATE TABLE `ECT_ORG` (
  `FID` varchar(30) not null comment '主键',
  `FAPPL_ID` varchar(30) not null comment '应用ID',
  `FFUNC_ID` varchar(30) default null comment '功能ID',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FLEFT_ID` varchar(30) not null comment '左ID',
  `FRIGHT_ID` varchar(30) not null comment '右ID',
  `FLEVEL` int(11) default null comment '层级',
  `FSUBNUM` int(11) default null comment '子节点个数',
  `FCHARACTER` varchar(50) default null comment '机构性质',
  `FVALIDATE_CODE` varchar(50) default null comment '验证码',
  `FLINKMAN` varchar(50) default null comment '联系人',
  `FTELEPHONE` varchar(20) default null comment '电话号码',
  `FFAX` varchar(20) default null comment '传真号码',
  `FEMAIL` varchar(100) default null comment '电子信箱',
  `FSTART_DATE` datetime not null comment '成立日期',
  `FEND_DATE` datetime default null comment '撤销日期',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='机构信息表';

-- ----------------------------
-- 表的结构 `ECT_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_ROLE`;
CREATE TABLE `ECT_ROLE` (
  `FID` varchar(30) not null comment '主键',
  `FORG_ID` varchar(30) not null comment '机构ID',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FLEFT_ID` varchar(30) not null comment '左ID',
  `FRIGHT_ID` varchar(30) not null comment '右ID',
  `FLEVEL` int(11) default null comment '层级',
  `FSUBNUM` int(11) default null comment '子节点个数',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='角色信息表';

-- ----------------------------
-- 表的结构 `ECT_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_GROUP`;
CREATE TABLE `ECT_GROUP` (
  `FID` varchar(30) not null comment '主键',
  `FAPPL_ID` varchar(30) not null comment '应用ID',
  `FFUNC_ID` varchar(30) default null comment '功能ID',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FLEFT_ID` varchar(30) not null comment '左ID',
  `FRIGHT_ID` varchar(30) not null comment '右ID',
  `FLEVEL` int(11) default null comment '层级',
  `FSUBNUM` int(11) default null comment '子节点个数',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='组信息表';

-- ----------------------------
-- 表的结构 `ECT_POST`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_POST`;
CREATE TABLE `ECT_POST` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='岗位信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_ROLE`;
CREATE TABLE `ECT_USER_ROLE` (
  `FID` varchar(30) not null comment '主键',
  `FUSER_ID` varchar(30) not null comment '用户ID',
  `FROLE_ID` varchar(30) not null comment '角色ID',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户角色信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_ORG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_ORG`;
CREATE TABLE `ECT_USER_ORG` (
  `FID` varchar(30) not null comment '主键',
  `FUSER_ID` varchar(30) not null comment '用户ID',
  `FORG_ID` varchar(30) not null comment '机构ID',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户机构信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_GROUP`;
CREATE TABLE `ECT_USER_GROUP` (
  `FID` varchar(30) not null comment '主键',
  `FUSER_ID` varchar(30) not null comment '用户ID',
  `FGROUP_ID` varchar(30) not null comment '组ID',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户组信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_POST`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_POST`;
CREATE TABLE `ECT_USER_POST` (
  `FID` varchar(30) not null comment '主键',
  `FUSER_ID` varchar(30) not null comment '用户ID',
  `FPOST_ID` varchar(30) not null comment '岗位ID',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户岗位信息表';

-- ----------------------------
-- 表的结构 `ECT_ROLE_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_ROLE_GROUP`;
CREATE TABLE `ECT_ROLE_GROUP` (
  `FID` varchar(30) not null comment '主键',
  `FROLE_ID` varchar(30) not null comment '角色ID',
  `FGROUP_ID` varchar(30) not null comment '组ID',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='角色组信息表';

-- ----------------------------
-- 表的结构 `ECT_FUNC_AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FUNC_AUTHORITY`;
CREATE TABLE `ECT_FUNC_AUTHORITY` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FAPPL_ID` varchar(30) not null comment '应用ID',
  `FFUNC_ID` varchar(30) not null comment '功能ID',
  `FOPER_ID` varchar(30) not null comment '操作ID',
  `FSUBJECT_ID` varchar(30) not null comment '主体ID',
  `FSUBJECT_TYPE` varchar(20) not null comment '主体类型',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='功能权限表';

-- ----------------------------
-- 表的结构 `ECT_DATA_AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DATA_AUTHORITY`;
CREATE TABLE `ECT_DATA_AUTHORITY` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FAPPL_ID` varchar(30) not null comment '应用ID',
  `FFUNC_ID` varchar(30) not null comment '功能ID',
  `FDATA_ID` varchar(30) not null comment '数据权限ID',
  `FDATA_VALUE` varchar(300) default null comment '数据的值',
  `FSUBJECT_ID` varchar(30) not null comment '主体ID',
  `FSUBJECT_TYPE` varchar(20) not null comment '主体类型',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据权限表';

-- ----------------------------
-- 表的结构 `ECT_FIELD_AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_FIELD_AUTHORITY`;
CREATE TABLE `ECT_FIELD_AUTHORITY` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FAPPL_ID` varchar(30) not null comment '应用ID',
  `FFUNC_ID` varchar(30) not null comment '功能ID',
  `FFIELD` varchar(50) not null comment '字段名称',
  `FSUBJECT_ID` varchar(30) not null comment '主体ID',
  `FSUBJECT_TYPE` varchar(20) not null comment '主体类型',
  `FCAN_MANAGE` bit(1) default null comment '是否可以管理',
  `FINCEPT_TIME` datetime default null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='数据权限表';

-- ----------------------------
-- 表的结构 `ECT_HANDOVER`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_HANDOVER`;
CREATE TABLE `ECT_HANDOVER` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FUSER_ID` varchar(30) not null comment '用户ID',
  `FTRUSTEE_ID` varchar(30) not null comment '受托人ID',
  `FHANDOVER` bit(1) default 0 comment '是否交接',
  `FALL_AUTH` bit(1) default 0 comment '是否所有权限',
  `FINCEPT_TIME` datetime not null comment '生效时间',
  `FEXPIRY_TIME` datetime default null comment '失效时间',
  `FEXEC_TIME` datetime default null comment '执行时间',
  `FEXEC_STATE` smallint(6) default 0 comment '执行状态',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='权限交接表';

-- ----------------------------
-- 表的结构 `ECT_HAND_DETAIL`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_HAND_DETAIL`;
CREATE TABLE `ECT_HAND_DETAIL` (
  `FID` varchar(30) not null comment '主键',
  `FHANDOVER_ID` varchar(30) not null comment '交接ID',
  `FSUBJECT_ID` varchar(30) default null comment '主体类型ID',
  `FSUBJECT_TYPE` varchar(20) default null comment '交接类型',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='权限交接明细表';

-- ----------------------------
-- 表的结构 `ECT_WIDGET`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_WIDGET`;
CREATE TABLE `ECT_WIDGET` (
  `FID` varchar(30) not null comment '主键',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTYPE` varchar(20) not null comment '类型',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FINCLUDE_FILE` text not null comment '引用文件',
  `FTEMPLATE` text not null comment '控件模版',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='控件类型信息表';

-- ----------------------------
-- 表的结构 `ECT_DICT`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DICT`;
CREATE TABLE `ECT_DICT` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FORDER_NO` int(11) default 0 comment '显示次序',
  `FPARENT_ID` varchar(30) not null comment '上级ID',
  `FLEFT_ID` varchar(30) not null comment '左ID',
  `FRIGHT_ID` varchar(30) not null comment '右ID',
  `FLEVEL` int(11) default null comment '层级',
  `FSUBNUM` int(11) default null comment '子节点个数',
  `FTYPE` varchar(20) not null comment '类型',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统数据字典';

-- ----------------------------
-- 表的结构 `ECT_DICT_I18N`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_DICT_I18N`;
CREATE TABLE `ECT_DICT_I18N` (
  `FID` varchar(30) not null comment '主键',
  `FREGION` varchar(50) default null comment '字典所在域（表名）',
  `FKEY` varchar(50) default null comment '字典关键字',
  `FLANGUAGE` varchar(20) default null comment '语种',
  `FTEXT` varchar(50) default null comment '文本',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统数据字典国际化';

-- ----------------------------
-- 表的结构 `ECT_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_CONFIG`;
CREATE TABLE `ECT_CONFIG` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FOBJECT_ID` varchar(30) not null comment '对象ID',
  `FOBJECT_TYPE` varchar(20) not null comment '对象类型',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FCONTENT` text comment '配置内容',
  `FVERSION` int(11) default null comment '版本',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统配置信息表';

-- ----------------------------
-- 表的结构 `ECT_SYS_PARAM`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_SYS_PARAM`;
CREATE TABLE `ECT_SYS_PARAM` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FOBJECT_ID` varchar(30) default null comment '对象ID',
  `FOBJECT_TYPE` varchar(20) default null comment '对象类型',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FVALUE_TYPE` varchar(20) default null comment '值类型',
  `FVALUE` varchar(1000) default null comment 'String值',
  `FCREATOR_ID` varchar(30) not null comment '创建者',
  `FCREATE_TIME` datetime not null comment '创建时间',
  `FLAST_EDITOR_ID` varchar(30) default null comment '修改者',
  `FLAST_EDIT_TIME` datetime default null comment '修改时间',
  `FCHECK_STATE` smallint(6) default 0 comment '审核状态',
  `FCHECKER_ID` varchar(30) default null comment '审核员',
  `FCHECK_TIME` datetime default null comment '审核时间',
  `FDELETE_STATE` smallint(6) default 0 comment '删除状态',
  `FDELETOR_ID` varchar(30) default null comment '删除者',
  `FDELETE_TIME` datetime default null comment '删除时间',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统参数表：类型可选值：int,string,boolean,date,double等';

-- ----------------------------
-- 表的结构 `ECT_USER_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_CONFIG`;
CREATE TABLE `ECT_USER_CONFIG` (
  `FID` varchar(30) not null comment '主键',
  `FENABLE` bit(1) default 0 comment '是否启用',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FUSER_ID` varchar(30) not null comment '对象ID',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FCONTENT` text comment '配置内容',
  `FVERSION` int(11) default null comment '版本',
  `FREMARK` varchar(300) default null comment '备注',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='用户配置信息表';

-- ----------------------------
-- 表的结构 `ECT_SYSTEM_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_SYSTEM_LOG`;
CREATE TABLE `ECT_SYSTEM_LOG` (
  `FID` varchar(30) not null comment '主键',
  `FUSER_ID` varchar(30) not null comment '操作员ID',
  `FTYPE` varchar(20) not null comment '操作类型',
  `FOPERATOR` varchar(50) not null comment '操作员',
  `FCLIENT_IP` varchar(30) not null comment '操作IP',
  `FVISIT_PATH` varchar(300) not null comment '访问路径',
  `FLEVEL` varchar(20) not null comment '日志级别',
  `FSTATUS` smallint(6) default 0 comment '状态',
  `FUPDATE_TIME` datetime not null comment '更新时间',
  `FCONTENT` text comment '操作内容',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='系统日志表';

-- ----------------------------
-- 恢复外键约束检查
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;