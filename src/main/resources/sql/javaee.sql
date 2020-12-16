/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : javaee

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 11/12/2020 12:22:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'adm', '123');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` bigint(20) NULL DEFAULT NULL,
  `place` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parentId` bigint(20) NULL DEFAULT NULL,
  `Time` datetime(0) NULL DEFAULT NULL,
  `Del` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '瓜大', 18812341234, '西工大', NULL, '2015-01-01 21:20:07', 0);
INSERT INTO `department` VALUES (2, '启翔楼', 18812341235, '西工大', 1, '2015-01-01 21:22:16', 0);
INSERT INTO `department` VALUES (3, '启真楼', 18812341236, '西工大', 1, '2015-01-01 21:22:22', 0);
INSERT INTO `department` VALUES (4, '教学西座', 18812341237, '西工大', 1, '2015-01-01 21:22:35', 0);
INSERT INTO `department` VALUES (5, '教学东座', 18812341238, '西工大', 1, '2015-01-01 21:22:46', 0);
INSERT INTO `department` VALUES (6, '教西一楼', 18812341239, '西工大', 4, '2015-01-01 21:22:53', 0);
INSERT INTO `department` VALUES (7, '教西102', 18812341240, '西工大', 6, '2015-01-01 21:26:04', 0);

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NULL DEFAULT NULL,
  `Time` datetime(0) NULL DEFAULT NULL,
  `post` float NULL DEFAULT NULL,
  `performance` float NULL DEFAULT NULL,
  `workYearSalary` float NULL DEFAULT NULL,
  `Allowance` float NULL DEFAULT NULL,
  `flag` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `departmentId` bigint(20) NULL DEFAULT NULL,
  `Del` int(11) NULL DEFAULT 0,
  `RegisterTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  INDEX `departmentId`(`departmentId`) USING BTREE,
  CONSTRAINT `departmentId` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'test', '123', '123@qq.com', 'admin', 18, 1, '15109918030', 1, 1, '2020-12-10 22:07:13');
INSERT INTO `user` VALUES (7, 'test', '123', '123@qq.com', 'admin', 18, 1, '18109918030', 1, 0, '2020-12-10 22:25:44');
INSERT INTO `user` VALUES (9, 'test', '123', '123@qq.com', 'admin', 18, 1, '19109918030', 1, 0, '2020-12-10 22:26:27');

SET FOREIGN_KEY_CHECKS = 1;
