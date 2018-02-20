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
-- 创建数据库: `CN_ELWY_EPLUS`
--
*/
CREATE DATABASE IF not EXISTS `CN_ELWY_EPLUS`;
USE `CN_ELWY_EPLUS`;


-- ----------------------------
-- 表的结构 `ECT_R_TEMPLATE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_R_TEMPLATE`;
CREATE TABLE `ECT_R_TEMPLATE` (
  `FID` varchar(30) not null comment '主键',
  `FCODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FFORM_WIDTH` double(11) default 0 comment '表单宽度',
  `FFORM_HEIGHT` double(11) default 0 comment '表单高度',
  `FPATH_RULE` varchar(50) not null comment '路径规则',
  `FNAME_RULE` varchar(50) not null comment '名称规则',
  `FRENDERER` varchar(30) not null comment '渲染',
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
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='应用信息表';

-- ----------------------------
-- 表的结构 `ECT_R_PARAMS_HISTORY`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_R_PARAMS_HISTORY`;
CREATE TABLE `ECT_R_PARAMS_HISTORY` (
  `FID` varchar(30) not null comment '主键',
  `FUSER_ID` varchar(30) not null comment '代码',
  `FREPORT_CODE` varchar(30) not null comment '代码',
  `FNAME` varchar(50) not null comment '名称',
  `FTIME` double(11) default 0 comment '表单宽度',
  `FPARAMS` text comment '表单参数',
  `FPATH_RULE` varchar(50) not null comment '路径规则',
  `FNAME_RULE` varchar(50) not null comment '名称规则',
  `FRENDERER` varchar(30) not null comment '渲染',
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
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB default charset=utf8 comment='应用信息表';

-- ----------------------------
-- 恢复外键约束检查
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;