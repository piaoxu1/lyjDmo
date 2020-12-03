/*
 Navicat MySQL Data Transfer

 Source Server         : ypn
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : house_system

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 30/08/2020 06:43:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for myarea
-- ----------------------------
DROP TABLE IF EXISTS `myarea`;
CREATE TABLE `myarea`  (
  `AID` int(0) NOT NULL AUTO_INCREMENT,
  `ANAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`AID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myarea
-- ----------------------------
INSERT INTO `myarea` VALUES (1, '洪山区');
INSERT INTO `myarea` VALUES (2, '武昌区');
INSERT INTO `myarea` VALUES (3, '东湖高新技术开发区');
INSERT INTO `myarea` VALUES (4, '汉阳区');
INSERT INTO `myarea` VALUES (5, '测试区');
INSERT INTO `myarea` VALUES (6, '岳麓区');
INSERT INTO `myarea` VALUES (7, '天心区');
INSERT INTO `myarea` VALUES (8, '雨花区');
INSERT INTO `myarea` VALUES (9, '岳麓区');
INSERT INTO `myarea` VALUES (10, '北塔区');
INSERT INTO `myarea` VALUES (11, '北塔区');
INSERT INTO `myarea` VALUES (12, '雨花区');
INSERT INTO `myarea` VALUES (13, '岳麓区');
INSERT INTO `myarea` VALUES (14, '岳麓区');
INSERT INTO `myarea` VALUES (15, '天心区');
INSERT INTO `myarea` VALUES (16, '北塔区');

-- ----------------------------
-- Table structure for mybiao
-- ----------------------------
DROP TABLE IF EXISTS `mybiao`;
CREATE TABLE `mybiao`  (
  `BID` int(0) NOT NULL AUTO_INCREMENT,
  `HID` int(0) NULL DEFAULT NULL,
  `DKD` float NULL DEFAULT NULL,
  `SKD` float NULL DEFAULT NULL,
  `MKD` float NULL DEFAULT NULL,
  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mybiao
-- ----------------------------
INSERT INTO `mybiao` VALUES (1, 1, 70, 50, 20, '8/23', 1);
INSERT INTO `mybiao` VALUES (2, 2, 7, 7, 7, '2020-08-30 04:54:14', 2);
INSERT INTO `mybiao` VALUES (3, 1, 8, 8, 8, '2020-08-30 04:59:59', 2);
INSERT INTO `mybiao` VALUES (4, 1, 8, 8, 8, '2020-08-30 05:01:04', 2);
INSERT INTO `mybiao` VALUES (5, 1, 8, 8, 8, '2020-08-30 05:02:55', 2);
INSERT INTO `mybiao` VALUES (6, 1, 5, 5, 5, '2020-08-30 05:06:43', 2);
INSERT INTO `mybiao` VALUES (7, 2, 8, 5, 8, '2020-08-30 06:34:12', 2);

-- ----------------------------
-- Table structure for mybs
-- ----------------------------
DROP TABLE IF EXISTS `mybs`;
CREATE TABLE `mybs`  (
  `BID` int(0) NOT NULL AUTO_INCREMENT,
  `HID` int(0) NULL DEFAULT NULL,
  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mybs
-- ----------------------------
INSERT INTO `mybs` VALUES (1, 1, '8/23', '门坏了', 2);
INSERT INTO `mybs` VALUES (2, 2, '2020-08-30 05:13:08', '备注', 1);
INSERT INTO `mybs` VALUES (3, 2, '2020-08-30 05:23:46', 'ces', 1);
INSERT INTO `mybs` VALUES (4, 3, '2020-08-30 06:34:25', 'ddasds', 1);

-- ----------------------------
-- Table structure for mycus
-- ----------------------------
DROP TABLE IF EXISTS `mycus`;
CREATE TABLE `mycus`  (
  `CID` int(0) NOT NULL AUTO_INCREMENT,
  `CNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CSEX` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CTEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CTEL1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CCARD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mycus
-- ----------------------------
INSERT INTO `mycus` VALUES (1, 'Clearlove', '男', '7777777', '6666666', '77');
INSERT INTO `mycus` VALUES (2, 'Clearlove', '男', '7777777', '6666666', '77');
INSERT INTO `mycus` VALUES (3, '嘻嘻', '男', '123', '12', '3');
INSERT INTO `mycus` VALUES (4, '嘻嘻', '男', '678', '231', '12312');
INSERT INTO `mycus` VALUES (5, '嘻嘻', '男', '987', '987', '0999');
INSERT INTO `mycus` VALUES (6, '简自豪', '男', 'Uzi', 'forevergod', '66666');
INSERT INTO `mycus` VALUES (7, '明凯', '男', '777777', 'edg', '43077777777777');
INSERT INTO `mycus` VALUES (8, '简自豪', '男', 'Uzi', 'forevergod', '66666');
INSERT INTO `mycus` VALUES (9, '明凯', '男', '123', 'forevergod', '66666');
INSERT INTO `mycus` VALUES (10, '简自豪', '男', 'Uzi', 'forevergod', '43077777777777');
INSERT INTO `mycus` VALUES (11, '测试', '男', '123', '12', '3');
INSERT INTO `mycus` VALUES (12, 'gdx', '男', '151515', 'wdnm', '43077777777777');
INSERT INTO `mycus` VALUES (13, '测试名', '女', '777', '777', '4305');
INSERT INTO `mycus` VALUES (14, '明凯', '男', '777777', 'edg', 'Clearlove');
INSERT INTO `mycus` VALUES (15, '简自豪', '男', '777777', 'forevergod', '43077777777777');
INSERT INTO `mycus` VALUES (16, '明凯', '男', '777777', '12', 'Clearlove');
INSERT INTO `mycus` VALUES (17, '简自豪', '女', '123', '12', '3');
INSERT INTO `mycus` VALUES (18, '嘻嘻', '女', '123', '12', '3');
INSERT INTO `mycus` VALUES (19, '测试', '男', '777777', 'edg', '43077777777777');

-- ----------------------------
-- Table structure for mydept
-- ----------------------------
DROP TABLE IF EXISTS `mydept`;
CREATE TABLE `mydept`  (
  `PID` int(0) NOT NULL AUTO_INCREMENT,
  `PNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PFLAG` int(0) NULL DEFAULT NULL,
  `PREMARK` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mydept
-- ----------------------------
INSERT INTO `mydept` VALUES (1, '管理规划部', 0, '管理部门,不可删除');
INSERT INTO `mydept` VALUES (2, '房管一部', 0, '主要负责房源信息录入');
INSERT INTO `mydept` VALUES (3, '房管二部', 0, '主要负责房子出租');
INSERT INTO `mydept` VALUES (4, '房管三部', 0, '主要负责房子出租');
INSERT INTO `mydept` VALUES (5, '测试部', 0, '主要负责测试');
INSERT INTO `mydept` VALUES (6, '测试部', 0, '主要负责测试');
INSERT INTO `mydept` VALUES (14, '嘻嘻', 0, '试试水');
INSERT INTO `mydept` VALUES (15, '测试', 0, '是');
INSERT INTO `mydept` VALUES (16, '这是测试数据呀', 0, '这是测试数据呀');
INSERT INTO `mydept` VALUES (17, '财经部', 0, '登记开支收费');
INSERT INTO `mydept` VALUES (18, '这是测试数据呀', 0, 'sss');
INSERT INTO `mydept` VALUES (19, 'sssss', 0, 'sssss');

-- ----------------------------
-- Table structure for mydj
-- ----------------------------
DROP TABLE IF EXISTS `mydj`;
CREATE TABLE `mydj`  (
  `MID` int(0) NOT NULL AUTO_INCREMENT,
  `MDATE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EID` int(0) NULL DEFAULT NULL,
  `CID` int(0) NULL DEFAULT NULL,
  `HID` int(0) NULL DEFAULT NULL,
  `MIMG` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MYJ` float NULL DEFAULT NULL,
  `MYZJ` float NULL DEFAULT NULL,
  `MFLAG` int(0) NULL DEFAULT 0,
  `MBEGintIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mydj
-- ----------------------------
INSERT INTO `mydj` VALUES (1, '8/22', 2, 2, 1, '合同图片', 1, 1, 0, '9/22');
INSERT INTO `mydj` VALUES (3, '8/26', 2, 1, 1, NULL, 100, 100, 0, '9/26');
INSERT INTO `mydj` VALUES (4, '8/26', 2, 2, 1, NULL, 66, 66, 0, '9/26');
INSERT INTO `mydj` VALUES (5, '8/26', 2, 1, 1, NULL, 777, 777, 0, '9/26');
INSERT INTO `mydj` VALUES (6, '8/26', 2, 1, 1, NULL, 777, 777, 0, '2020-08-29');
INSERT INTO `mydj` VALUES (7, '8/26', 2, 1, 1, NULL, 88, 88, 0, '2022-08-26');
INSERT INTO `mydj` VALUES (8, '2020-08-27 14:47:07', 2, 1, 3, NULL, 88, 88, 0, '2020-08-29');
INSERT INTO `mydj` VALUES (9, '2020-08-30 04:01:27', 2, 1, 2, NULL, 777, 777, 0, '2020-08-29');
INSERT INTO `mydj` VALUES (10, '2020-08-30 06:33:54', 2, 2, 2, NULL, 777, 777, 0, '2020-09-05');

-- ----------------------------
-- Table structure for myemp
-- ----------------------------
DROP TABLE IF EXISTS `myemp`;
CREATE TABLE `myemp`  (
  `EID` int(0) NOT NULL AUTO_INCREMENT,
  `PID` int(0) NULL DEFAULT NULL,
  `JID` int(0) NULL DEFAULT NULL,
  `ENAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EPSW` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EREALNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ETEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EFLAG` int(0) NULL DEFAULT NULL,
  `EREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`EID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myemp
-- ----------------------------
INSERT INTO `myemp` VALUES (1, 1, 1, 'admin', 'admin', '赵本山', '13995668339', '武汉市洪山区120号', 0, '此人为系统管理员，不可删除');
INSERT INTO `myemp` VALUES (2, 2, 2, 'liuxq', '123', '刘小庆', '13995668330', '武汉市洪山区121号', 0, '优秀的置业顾问');
INSERT INTO `myemp` VALUES (3, 3, 2, 'zhaozw', '123', '赵子武', '15895668330', '武汉市洪山区122号', 0, '优秀的置业顾问');
INSERT INTO `myemp` VALUES (4, 3, 2, 'zhanghy', '123', '张海洋', '13095668331', '武汉市洪山区123号', 0, '优秀的置业顾问');
INSERT INTO `myemp` VALUES (5, 2, 1, 'ypn', 'xixi', '真实姓名', '15673977521', '湖南邵阳', 0, '测试数据');
INSERT INTO `myemp` VALUES (6, 1, 1, 'sss', 'sss', 'sss', 'sss', 'sss', 0, 'SSS');
INSERT INTO `myemp` VALUES (7, 1, 1, 'sss', 'sss', 'sss', 'sss', 'sss', 0, 'ssss');

-- ----------------------------
-- Table structure for myhouse
-- ----------------------------
DROP TABLE IF EXISTS `myhouse`;
CREATE TABLE `myhouse`  (
  `HID` int(0) NOT NULL AUTO_INCREMENT,
  `SID` int(0) NULL DEFAULT NULL,
  `AID` int(0) NULL DEFAULT NULL,
  `HADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HFH` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HHX` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HMJ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HCX` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HMONEY` float NULL DEFAULT NULL,
  `HWF` float NULL DEFAULT NULL,
  `HDX` float NULL DEFAULT NULL,
  `HSF` float NULL DEFAULT NULL,
  `HMQ` float NULL DEFAULT NULL,
  `DKD` float NULL DEFAULT NULL,
  `SKD` float NULL DEFAULT NULL,
  `MKD` float NULL DEFAULT NULL,
  `HJP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HIMG` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HFLAG` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`HID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myhouse
-- ----------------------------
INSERT INTO `myhouse` VALUES (1, 2, 2, '洪山区保利花园小区', 'A区4栋2单元801室', '3室2厅2卫', '130', '坐北朝南', 3500, 1800, 0.5, 1.2, 1.2, 456, 456, 789, 'BLHY', 'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', '0');
INSERT INTO `myhouse` VALUES (2, 2, 2, '豪天宾馆', '228号', '3室2厅2卫', '130', '坐北朝南', 3500, 1800, 0.5, 1.2, 1.2, 456, 456, 789, 'BLHY', 'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', '1');
INSERT INTO `myhouse` VALUES (3, 2, 1, '豪天宾馆', '228号', '3室2厅2卫', '130', '坐北朝南', 3500, 1800, 0.5, 1.2, 1.2, 456, 456, 789, 'BLHY', 'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', '1');
INSERT INTO `myhouse` VALUES (4, 1, 2, '豪天宾馆', '228号', '3室2厅2卫', '130', '坐北朝南', 3500, 1800, 0.5, 1.2, 1.2, 456, 456, 789, 'BLHY', 'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', '1');
INSERT INTO `myhouse` VALUES (5, 1, 1, '豪天宾馆', '228号', '3室2厅2卫', '130', '坐北朝南', 3500, 1800, 0.5, 1.2, 1.2, 456, 456, 789, 'BLHY', 'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', '1');
INSERT INTO `myhouse` VALUES (6, 1, 1, '洪山区保利花园小区', 'A区4栋2单元801室', '3室2厅2卫', '130', '坐北朝南', 3500, 1800, 0.5, 1.2, 1.2, 456, 456, 789, 'BLHY', 'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', '0');
INSERT INTO `myhouse` VALUES (7, 2, 1, '测试酒店', '7140', '六人寝', '150', '坐南朝北', 777, 28, 0.9, 1.1, 1.5, 777, 666, 789, 'HJP', '备注', '0', '1');
INSERT INTO `myhouse` VALUES (8, 1, 1, '测试', '7', '测试', '7', '测试', 7, 7, 7, 7, 7, 7, 7, 7, 'cs', 'Clearlove', '0', '1');
INSERT INTO `myhouse` VALUES (10, 4, 4, '测试', '7', '测试', '7', '测试', 7, 7, 7, 7, 7, 7, 7, 7, 'cs', 'ss', '0', '1');

-- ----------------------------
-- Table structure for myht
-- ----------------------------
DROP TABLE IF EXISTS `myht`;
CREATE TABLE `myht`  (
  `HTID` int(0) NOT NULL AUTO_INCREMENT,
  `HTNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HTREMARK` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`HTID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myht
-- ----------------------------
INSERT INTO `myht` VALUES (1, '合同1', '这是测试');
INSERT INTO `myht` VALUES (6, NULL, NULL);
INSERT INTO `myht` VALUES (7, NULL, NULL);
INSERT INTO `myht` VALUES (8, NULL, NULL);
INSERT INTO `myht` VALUES (9, NULL, NULL);
INSERT INTO `myht` VALUES (10, NULL, NULL);
INSERT INTO `myht` VALUES (11, '啦啦啦啦', NULL);
INSERT INTO `myht` VALUES (12, '啦啦啦啦', NULL);
INSERT INTO `myht` VALUES (13, '演示', NULL);

-- ----------------------------
-- Table structure for myjs
-- ----------------------------
DROP TABLE IF EXISTS `myjs`;
CREATE TABLE `myjs`  (
  `JID` int(0) NOT NULL AUTO_INCREMENT,
  `JNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`JID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myjs
-- ----------------------------
INSERT INTO `myjs` VALUES (1, '系统管理员');
INSERT INTO `myjs` VALUES (2, '置业顾问');
INSERT INTO `myjs` VALUES (3, '会计');
INSERT INTO `myjs` VALUES (8, '测试员');
INSERT INTO `myjs` VALUES (9, '国产中单');
INSERT INTO `myjs` VALUES (10, '工具人');
INSERT INTO `myjs` VALUES (11, '工具人');
INSERT INTO `myjs` VALUES (12, '测试员');
INSERT INTO `myjs` VALUES (13, '国产中单');
INSERT INTO `myjs` VALUES (14, '测试员');
INSERT INTO `myjs` VALUES (15, '工具人');
INSERT INTO `myjs` VALUES (16, '国产中单');

-- ----------------------------
-- Table structure for mysf
-- ----------------------------
DROP TABLE IF EXISTS `mysf`;
CREATE TABLE `mysf`  (
  `YID` int(0) NOT NULL AUTO_INCREMENT,
  `MID` int(0) NULL DEFAULT NULL,
  `EID` int(0) NULL DEFAULT NULL,
  `MYZJ` float NULL DEFAULT NULL,
  `MBEGintIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`YID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mysf
-- ----------------------------
INSERT INTO `mysf` VALUES (1, 1, 1, 7, '8/23');

-- ----------------------------
-- Table structure for myshouru
-- ----------------------------
DROP TABLE IF EXISTS `myshouru`;
CREATE TABLE `myshouru`  (
  `SID` int(0) NOT NULL AUTO_INCREMENT,
  `EID` int(0) NULL DEFAULT NULL,
  `SMONEY` float NULL DEFAULT NULL,
  `STM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myshouru
-- ----------------------------
INSERT INTO `myshouru` VALUES (1, 2, 2000, '77', '8/23', '嘻嘻嘻');
INSERT INTO `myshouru` VALUES (2, 2, 777, '条目', '时间', '这是测试数据');
INSERT INTO `myshouru` VALUES (3, 2, 500, '客户房租', '1987', 'S');
INSERT INTO `myshouru` VALUES (4, 2, 500, '客户房租', '1986', ' ds');
INSERT INTO `myshouru` VALUES (5, 2, 500, '客户房租', '1986', '我叼你妈');
INSERT INTO `myshouru` VALUES (6, 2, 500, '客户物损赔偿', '1983', 'ss');
INSERT INTO `myshouru` VALUES (7, 2, 500, '其它', '1982', '777');

-- ----------------------------
-- Table structure for mysort
-- ----------------------------
DROP TABLE IF EXISTS `mysort`;
CREATE TABLE `mysort`  (
  `SID` int(0) NOT NULL AUTO_INCREMENT,
  `SNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mysort
-- ----------------------------
INSERT INTO `mysort` VALUES (1, '标准住宅');
INSERT INTO `mysort` VALUES (2, '标准厂房');
INSERT INTO `mysort` VALUES (3, '标准仓库');
INSERT INTO `mysort` VALUES (4, '标准车位');
INSERT INTO `mysort` VALUES (12, '演示');
INSERT INTO `mysort` VALUES (13, '海景房');
INSERT INTO `mysort` VALUES (17, '啦啦啦啦');
INSERT INTO `mysort` VALUES (18, '海景房');
INSERT INTO `mysort` VALUES (19, '测试专用');
INSERT INTO `mysort` VALUES (20, '演示');
INSERT INTO `mysort` VALUES (21, '茅草房');
INSERT INTO `mysort` VALUES (22, '测试专用');
INSERT INTO `mysort` VALUES (23, '海景房');
INSERT INTO `mysort` VALUES (24, '看看');
INSERT INTO `mysort` VALUES (25, '海景房');
INSERT INTO `mysort` VALUES (26, '海景房');
INSERT INTO `mysort` VALUES (27, '海景房');

-- ----------------------------
-- Table structure for mytf
-- ----------------------------
DROP TABLE IF EXISTS `mytf`;
CREATE TABLE `mytf`  (
  `TID` int(0) NOT NULL AUTO_INCREMENT,
  `MID` int(0) NULL DEFAULT NULL,
  `EID` int(0) NULL DEFAULT NULL,
  `TYZJ` float NULL DEFAULT NULL,
  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`TID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for myzc
-- ----------------------------
DROP TABLE IF EXISTS `myzc`;
CREATE TABLE `myzc`  (
  `CID` int(0) NOT NULL AUTO_INCREMENT,
  `CTITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREMARK` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myzc
-- ----------------------------
INSERT INTO `myzc` VALUES (1, 'title', '2020-08-28 15:44:37', '备注信息');
INSERT INTO `myzc` VALUES (13, 'Hello', '2020-08-28 16:50:09', 's');
INSERT INTO `myzc` VALUES (14, '测试', '2020-08-28 16:50:54', '成功！！');
INSERT INTO `myzc` VALUES (15, '测试', '2020-08-28 16:51:45', '这是一条测试数据！！！！！！');
INSERT INTO `myzc` VALUES (16, '你好世界！', '2020-08-28 17:00:28', 'Hello world!');
INSERT INTO `myzc` VALUES (17, '测试', '2020-08-29 19:40:26', 'fs');
INSERT INTO `myzc` VALUES (18, '你好世界！', '2020-08-29 22:26:39', '&nbsp;多少岁');
INSERT INTO `myzc` VALUES (19, 'Hello', '2020-08-30 06:35:47', 'heih');

-- ----------------------------
-- Table structure for myzhichu
-- ----------------------------
DROP TABLE IF EXISTS `myzhichu`;
CREATE TABLE `myzhichu`  (
  `ZID` int(0) NOT NULL AUTO_INCREMENT,
  `EID` int(0) NULL DEFAULT NULL,
  `ZMONEY` float NULL DEFAULT NULL,
  `ZTM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ZTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ZREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ZID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myzhichu
-- ----------------------------
INSERT INTO `myzhichu` VALUES (1, 2, 200, '测试', '8/23', '备注');
INSERT INTO `myzhichu` VALUES (2, 2, 777, '房屋维修', '1987', '试试');
INSERT INTO `myzhichu` VALUES (3, 2, 777, '常用物件', '9.711538461538461538', 'DSAD');
INSERT INTO `myzhichu` VALUES (4, 2, 777, '其它', '0.307692307', '嘎嘎嘎');
INSERT INTO `myzhichu` VALUES (5, 2, 777, '常用物件', '1986', '的撒打算');
INSERT INTO `myzhichu` VALUES (6, 2, 777, '常用物件', '1986', 'jQuery183036714903202751215_1598457192086?');
INSERT INTO `myzhichu` VALUES (7, 2, 777, '常用物件', '1986', '打那么多');
INSERT INTO `myzhichu` VALUES (8, 2, 777, '房屋维修', '1983', 's  ');
INSERT INTO `myzhichu` VALUES (9, 2, 777, '房屋维修', '1982', 's');
INSERT INTO `myzhichu` VALUES (10, 2, 777, '其它', '1982', 'xxx');

SET FOREIGN_KEY_CHECKS = 1;
