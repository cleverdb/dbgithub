/*
Navicat MySQL Data Transfer

Source Server         : docker
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-05 18:00:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_classes
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes` (
  `id` varchar(10) NOT NULL,
  `classes_name` varchar(50) NOT NULL COMMENT '衣服类别名称',
  `remark` varchar(255) DEFAULT NULL,
  `parent_id` varchar(10) DEFAULT NULL,
  `user_id` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `primary_id` (`id`) USING BTREE,
  KEY `classes_user` (`user_id`),
  KEY `classes_classes` (`parent_id`),
  CONSTRAINT `classes_classes` FOREIGN KEY (`parent_id`) REFERENCES `t_classes` (`id`),
  CONSTRAINT `classes_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classes
-- ----------------------------
INSERT INTO `t_classes` VALUES ('1', '春装', null, null, '1');
INSERT INTO `t_classes` VALUES ('2', '夏装', null, null, '1');
INSERT INTO `t_classes` VALUES ('3', '秋装', null, null, '1');
INSERT INTO `t_classes` VALUES ('4', '冬装', null, null, '1');
INSERT INTO `t_classes` VALUES ('5', '春装', null, null, '2');
INSERT INTO `t_classes` VALUES ('6', '针织衫', null, '1', '1');

-- ----------------------------
-- Table structure for t_clothes
-- ----------------------------
DROP TABLE IF EXISTS `t_clothes`;
CREATE TABLE `t_clothes` (
  `id` varchar(10) NOT NULL,
  `clo_name` varchar(25) NOT NULL,
  `clo_color` varchar(20) DEFAULT NULL,
  `clo_price` double(10,2) DEFAULT NULL,
  `clo_picture` varchar(255) DEFAULT NULL,
  `clo_start` char(2) NOT NULL,
  `classes_id` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `primary_id` (`id`) USING BTREE,
  KEY `clo_classes` (`classes_id`),
  CONSTRAINT `clo_classes` FOREIGN KEY (`classes_id`) REFERENCES `t_classes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_clothes
-- ----------------------------

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary` (
  `id` varchar(10) NOT NULL,
  `key` int(4) NOT NULL,
  `value` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
INSERT INTO `t_dictionary` VALUES ('6f6a9d4e4d', '10', '颜色');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(10) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `phone` decimal(11,0) NOT NULL,
  `birthday` date NOT NULL,
  `sex` char(1) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `primary_id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'dongbo', '13802305684', '2018-02-02', '1', '312312123');
INSERT INTO `t_user` VALUES ('2', 'lvxiang', '15630485623', '2018-02-15', '0', '123456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) NOT NULL,
  `reg_time` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `UK_d2ia11oqhsynodbsi46m80vfc` (`nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
