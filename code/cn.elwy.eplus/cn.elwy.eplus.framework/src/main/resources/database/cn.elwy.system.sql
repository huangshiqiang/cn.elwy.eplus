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
-- 表的结构 `ECT_USER_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_ROLE`;
CREATE TABLE `ECT_USER_ROLE` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(30) not null comment '用户ID',
	`FROLE_CODE` varchar(30) not null comment '角色代码',
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
) ENGINE=InnoDB default charset=utf8 comment='用户角色信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_ORG`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_ORG`;
CREATE TABLE `ECT_USER_ORG` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(30) not null comment '用户ID',
	`FORG_CODE` varchar(30) not null comment '机构代码',
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
) ENGINE=InnoDB default charset=utf8 comment='用户机构信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_GROUP`;
CREATE TABLE `ECT_USER_GROUP` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(30) not null comment '用户ID',
	`FGROUP_CODE` varchar(30) not null comment '组代码',
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
) ENGINE=InnoDB default charset=utf8 comment='用户组信息表';

-- ----------------------------
-- 表的结构 `ECT_USER_POST`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_USER_POST`;
CREATE TABLE `ECT_USER_POST` (
	`FID` varchar(30) not null comment '主键',
	`FUSER_ID` varchar(30) not null comment '用户ID',
	`FPOST_CODE` varchar(30) not null comment '岗位代码',
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
) ENGINE=InnoDB default charset=utf8 comment='用户岗位信息表';

-- ----------------------------
-- 表的结构 `ECT_ROLE_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `ECT_ROLE_GROUP`;
CREATE TABLE `ECT_ROLE_GROUP` (
	`FID` varchar(30) not null comment '主键',
	`FROLE_CODE` varchar(30) not null comment '角色代码',
	`FGROUP_CODE` varchar(30) not null comment '组代码',
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
) ENGINE=InnoDB default charset=utf8 comment='角色组信息表';

-- ----------------------------
-- 恢复外键约束检查
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;