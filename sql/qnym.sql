/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : qnym

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-24 11:12:54
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Records of t_id_card
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL,
  `account` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
