/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : springtest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-28 20:12:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for idcard
-- ----------------------------
DROP TABLE IF EXISTS `idcard`;
CREATE TABLE `idcard` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `code` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of idcard
-- ----------------------------
INSERT INTO `idcard` VALUES ('1', '123456789123456789');

-- ----------------------------
-- Table structure for myuser
-- ----------------------------
DROP TABLE IF EXISTS `myuser`;
CREATE TABLE `myuser` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) DEFAULT NULL,
  `usex` varchar(40) DEFAULT NULL,
  `userage` int(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myuser
-- ----------------------------
INSERT INTO `myuser` VALUES ('1', '小李', '男', '22', '333');
INSERT INTO `myuser` VALUES ('3', '飞鸟', '女', '80', null);
INSERT INTO `myuser` VALUES ('4', '张华', '男', '43', '123456');
INSERT INTO `myuser` VALUES ('6', '没有', '男', '3', '3');
INSERT INTO `myuser` VALUES ('13', '张正常', '男', '43', '123456');
INSERT INTO `myuser` VALUES ('15', '小徐', '男', '12', '12324');
INSERT INTO `myuser` VALUES ('16', '马林', '男', '12', '22');
INSERT INTO `myuser` VALUES ('18', '叶檀', '男', '66', '66');
INSERT INTO `myuser` VALUES ('19', '小明', '女', '23', '33333');
INSERT INTO `myuser` VALUES ('20', '林先生', '女', '22', '22');
INSERT INTO `myuser` VALUES ('21', '马祥生', '女', '12', '??');
INSERT INTO `myuser` VALUES ('22', '龚大林', '男', '12', '123');
INSERT INTO `myuser` VALUES ('23', '梨花', '男', '12', '123');
INSERT INTO `myuser` VALUES ('24', '张生', '男', '45', '123456');
INSERT INTO `myuser` VALUES ('25', '杨丽', '女', '23', '123456');
INSERT INTO `myuser` VALUES ('26', '徐阳', '女', '12', '123456');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `ordersn` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '999999', '1');
INSERT INTO `orders` VALUES ('2', '88888', '1');
INSERT INTO `orders` VALUES ('3', '7777777', '31');
INSERT INTO `orders` VALUES ('4', '666666666', '31');

-- ----------------------------
-- Table structure for orders_detail
-- ----------------------------
DROP TABLE IF EXISTS `orders_detail`;
CREATE TABLE `orders_detail` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `orders_id` tinyint(2) DEFAULT NULL,
  `product_id` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_id` (`orders_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `orders_id` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orders_detail
-- ----------------------------
INSERT INTO `orders_detail` VALUES ('1', '1', '1');
INSERT INTO `orders_detail` VALUES ('2', '1', '2');
INSERT INTO `orders_detail` VALUES ('3', '2', '1');
INSERT INTO `orders_detail` VALUES ('4', '2', '2');
INSERT INTO `orders_detail` VALUES ('5', '3', '1');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` tinyint(2) NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `idcard_id` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcard_id` (`idcard_id`),
  CONSTRAINT `idcard_id` FOREIGN KEY (`idcard_id`) REFERENCES `idcard` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` tinyint(2) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '好书', '88');
INSERT INTO `product` VALUES ('2', '坏书', '8.8');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` tinyint(2) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usex` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '女');
INSERT INTO `user` VALUES ('31', '李四', '男');
INSERT INTO `user` VALUES ('35', '陈恒', '男');
INSERT INTO `user` VALUES ('36', '陈恒', '男');
INSERT INTO `user` VALUES ('37', '陈恒', '男');
INSERT INTO `user` VALUES ('38', '陈恒', '男');
INSERT INTO `user` VALUES ('39', '陈恒', '男');
INSERT INTO `user` VALUES ('40', '陈恒', '男');
INSERT INTO `user` VALUES ('41', '陈恒', '男');
INSERT INTO `user` VALUES ('42', '陈恒', '男');
INSERT INTO `user` VALUES ('43', '陈恒', '男');
INSERT INTO `user` VALUES ('44', '陈恒', '男');
INSERT INTO `user` VALUES ('45', '陈恒', '男');
INSERT INTO `user` VALUES ('46', '陈恒', '男');
INSERT INTO `user` VALUES ('47', '陈恒', '男');
INSERT INTO `user` VALUES ('48', '陈恒', '男');
INSERT INTO `user` VALUES ('49', '陈恒', '男');
INSERT INTO `user` VALUES ('50', '陈恒', '男');
INSERT INTO `user` VALUES ('51', '陈恒', '男');
INSERT INTO `user` VALUES ('52', '陈恒', '男');
INSERT INTO `user` VALUES ('53', '陈恒', '男');
INSERT INTO `user` VALUES ('54', '陈恒', '男');
INSERT INTO `user` VALUES ('55', '陈恒', '男');
INSERT INTO `user` VALUES ('56', '陈恒', '男');
INSERT INTO `user` VALUES ('57', '陈恒', '男');
INSERT INTO `user` VALUES ('58', '陈恒', '男');
INSERT INTO `user` VALUES ('59', '陈恒', '男');
