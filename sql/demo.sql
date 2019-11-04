/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL_docker
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:33306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 04/11/2019 15:28:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `phone_number` char(11) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '手机号',
  `password` char(40) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码',
  `salt` char(6) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码盐',
  `username` varchar(40) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `email` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '邮箱',
  `status` int(3) NOT NULL DEFAULT '0' COMMENT '状态 0默认值 1正常 11注销',
  `register_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '注册时间',
  `last_login_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '最后一次登录时间',
  `create_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_phone_number` (`phone_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '18801010101', '123456', 'test11', '', '', 1, '2019-11-04 15:26:12.313', '1970-01-01 08:00:00.000', '1970-01-01 08:00:00.000', '1970-01-01 08:00:00.000');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
