/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 118.31.16.35:3306
 Source Schema         : db01

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 13/03/2021 20:12:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user01', 'e10adc3949ba59abbe56e057f20f883e', '13860220001', NULL, '2021-02-10 23:08:12');
INSERT INTO `user` VALUES (2, 'user02', 'e10adc3949ba59abbe56e057f20f883e', '13860220002', 'https://qyl-bucket.oss-cn-hangzhou.aliyuncs.com/image/0c23fe8a-d517-44c8-9acc-7a806b57a07f.png', '2021-02-21 14:14:02');
INSERT INTO `user` VALUES (3, 'user03', 'e10adc3949ba59abbe56e057f20f883e', '13860220003', 'https://qyl-bucket.oss-cn-hangzhou.aliyuncs.com/image/65235113-537d-4bd0-9965-ffb09dc4b74c.png', '2021-02-21 14:18:59');
INSERT INTO `user` VALUES (4, 'user04', 'e10adc3949ba59abbe56e057f20f883e', '13860220004', NULL, '2021-02-22 23:38:19');
INSERT INTO `user` VALUES (5, 'user05', 'e10adc3949ba59abbe56e057f20f883e', '13860220005', NULL, '2021-02-23 00:03:30');
INSERT INTO `user` VALUES (6, 'user06', 'e10adc3949ba59abbe56e057f20f883e', '13860220006', NULL, '2021-02-23 00:20:14');
INSERT INTO `user` VALUES (7, 'qingyuan', 'e10adc3949ba59abbe56e057f20f883e', '13860220008', NULL, '2021-03-11 20:08:26');
INSERT INTO `user` VALUES (8, 'user09', 'e10adc3949ba59abbe56e057f20f883e', '13860220009', NULL, '2021-03-11 23:57:45');

SET FOREIGN_KEY_CHECKS = 1;
