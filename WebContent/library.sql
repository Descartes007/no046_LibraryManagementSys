/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-12-18 17:13:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookname` varchar(20) NOT NULL COMMENT '书名',
  `author` varchar(20) NOT NULL COMMENT '作者',
  `press` varchar(20) NOT NULL COMMENT '出版社',
  `pubdate` varchar(50) NOT NULL COMMENT '出版日期',
  `type` varchar(20) NOT NULL COMMENT '图书类型',
  `bookshelf` varchar(20) NOT NULL COMMENT '书架',
  `count` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`bookname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('asp', 'fz', '人民出版社', '1998-9-9', '教科书', 'B', '55');
INSERT INTO `book` VALUES ('C', 'asd', '河南大学出版社', '2017-12-11', '计算机科学类', 'as', '10');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` varchar(20) NOT NULL COMMENT '学号',
  `bookname` varchar(20) NOT NULL COMMENT '书名',
  `type` varchar(20) NOT NULL COMMENT '类型',
  `date` varchar(50) NOT NULL COMMENT '借书日期',
  `days` int(11) NOT NULL COMMENT '借阅天数',
  `count` int(11) NOT NULL COMMENT '借阅数量',
  PRIMARY KEY (`id`,`bookname`),
  KEY `bookname` (`bookname`),
  CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`id`) REFERENCES `student` (`id`),
  CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`bookname`) REFERENCES `book` (`bookname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `username` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `islogin` int(10) NOT NULL DEFAULT '0' COMMENT '是否登录',
  `code` varchar(255) DEFAULT NULL COMMENT '激活码',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '激活状态',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('admin', 'ff0ad942f3afc7a5', '0', '', '1');
INSERT INTO `manager` VALUES ('hkq', '2c1e7cab19c3483b', '0', '57bfaa9b1b614b0e8940e12ce3a1c027', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(20) NOT NULL COMMENT '学号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `gender` varchar(20) NOT NULL COMMENT '性别',
  `phone` varchar(20) NOT NULL COMMENT '电话',
  `email` varchar(20) NOT NULL COMMENT '邮箱',
  `department` varchar(20) NOT NULL COMMENT '院系',
  `islogin` int(10) DEFAULT '0' COMMENT '是否登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1510121026', 'hkq', '男', '15824961993', '1025605919@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121027', 'hkq', '男', '15824961994', '1025605920@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121028', 'hkq', '男', '15824961995', '1025605921@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121029', 'hkq', '男', '15824961996', '1025605922@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121030', 'hkq', '男', '15824961997', '1025605923@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121031', 'hkq', '男', '15824961998', '1025605924@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121032', 'hkq', '男', '15824961999', '1025605925@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121033', 'hkq', '男', '15824962000', '1025605926@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121034', 'hkq', '男', '15824962001', '1025605927@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121035', 'hkq', '男', '15824962002', '1025605928@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121036', 'hkq', '男', '15824962003', '1025605929@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121037', 'hkq', '男', '15824962004', '1025605930@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121038', 'hkq', '男', '15824962005', '1025605931@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121039', 'hkq', '男', '15824962006', '1025605932@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121040', 'hkq', '男', '15824962007', '1025605933@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121041', 'hkq', '男', '15824962008', '1025605934@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121042', 'hkq', '男', '15824962009', '1025605935@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121043', 'hkq', '男', '15824962010', '1025605936@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121044', 'hkq', '男', '15824962011', '1025605937@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121045', 'hkq', '男', '15824962012', '1025605938@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121046', 'hkq', '男', '15824962013', '1025605939@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121047', 'hkq', '男', '15824962014', '1025605940@qq.com', '软件工程', '0');
INSERT INTO `student` VALUES ('1510121048', 'hkq', '男', '15824962015', '1025605941@qq.com', '软件工程', '0');
