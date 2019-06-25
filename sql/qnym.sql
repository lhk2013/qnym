/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : qnym

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-25 18:23:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adapterlog
-- ----------------------------
DROP TABLE IF EXISTS `adapterlog`;
CREATE TABLE `adapterlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `time` varchar(255) DEFAULT NULL,
  `controller` varchar(255) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paylog
-- ----------------------------
DROP TABLE IF EXISTS `paylog`;
CREATE TABLE `paylog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `clazz` varchar(255) DEFAULT NULL,
  `dug_level` varchar(255) DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `content1` varchar(3000) DEFAULT NULL,
  `content2` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53322 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dep
-- ----------------------------
DROP TABLE IF EXISTS `t_dep`;
CREATE TABLE `t_dep` (
  `id` bigint(20) NOT NULL,
  `dep_name` varchar(5000) DEFAULT NULL,
  `data_msg` varchar(5000) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级id',
  `level` int(10) DEFAULT NULL COMMENT '级别 1 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_disdata
-- ----------------------------
DROP TABLE IF EXISTS `t_disdata`;
CREATE TABLE `t_disdata` (
  `id` bigint(20) NOT NULL,
  `dep_id` bigint(20) DEFAULT NULL,
  `name` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_disdata_case
-- ----------------------------
DROP TABLE IF EXISTS `t_disdata_case`;
CREATE TABLE `t_disdata_case` (
  `id` bigint(20) NOT NULL,
  `disdata_id` bigint(11) DEFAULT NULL,
  `key_words` text,
  `remark` text,
  `case_label` varchar(5000) DEFAULT NULL,
  `read_num` varchar(10) DEFAULT NULL,
  `guid` varchar(5000) DEFAULT NULL,
  `bingshi` text,
  `pic_url` varchar(5000) DEFAULT NULL,
  `praise_num` varchar(10) DEFAULT NULL,
  `pl_num` varchar(10) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_disdata_case_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_disdata_case_detail`;
CREATE TABLE `t_disdata_case_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) DEFAULT NULL,
  `recommend` text,
  `data` text,
  `share_url` varchar(1000) DEFAULT NULL,
  `result` text,
  `html_content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62065 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_disdata_case_detail_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_disdata_case_detail_pic`;
CREATE TABLE `t_disdata_case_detail_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `accessery_name` varchar(1000) DEFAULT NULL,
  `pic_url` varchar(1000) DEFAULT NULL COMMENT '抓取时的url',
  `url` varchar(1000) DEFAULT NULL COMMENT '处理后的url',
  `status` int(10) DEFAULT '1' COMMENT '未处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67541 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_ex_user
-- ----------------------------
DROP TABLE IF EXISTS `t_ex_user`;
CREATE TABLE `t_ex_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `mob` bigint(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `area` varchar(10) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `cinfo` varchar(1000) NOT NULL COMMENT '手机',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8855 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for t_ex_user_bk
-- ----------------------------
DROP TABLE IF EXISTS `t_ex_user_bk`;
CREATE TABLE `t_ex_user_bk` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `mob` bigint(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `area` varchar(10) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `cinfo` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_id_card
-- ----------------------------
DROP TABLE IF EXISTS `t_id_card`;
CREATE TABLE `t_id_card` (
  `id_number` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `real_name` varchar(100) DEFAULT NULL,
  `status` tinyint(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(200) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time_stamp` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `create_time` (`create_time`) USING BTREE,
  KEY `create_time_stamp` (`create_time_stamp`) USING BTREE,
  KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=2600058 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
