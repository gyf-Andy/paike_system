/*
 Navicat Premium Data Transfer

 Source Server         : 数据库
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : paike_system

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 24/04/2021 18:31:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(15)  NOT NULL COMMENT '账号',
  `password` varchar(255)  NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(5)  NULL DEFAULT NULL COMMENT '姓名',
  `identity` varchar(10)  NULL DEFAULT NULL COMMENT '身份',
  PRIMARY KEY (`id`, `account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (25, '123', '9c3b5c0672cd599ccf1019bddaa8089b', '123', 'root');
INSERT INTO `admin` VALUES (27, '1233', '8787', '77', 'normal');
INSERT INTO `admin` VALUES (34, '123232', '12323', '12', 'normal');
INSERT INTO `admin` VALUES (35, '1239', '12312412', 'ggg', 'normal');
INSERT INTO `admin` VALUES (36, '1231', '12312', '郭云飞', 'normal');
INSERT INTO `admin` VALUES (38, '999', '222444', '333', 'normal');
INSERT INTO `admin` VALUES (39, '0909', '0909', '999', 'normal');
INSERT INTO `admin` VALUES (40, '1231231', '1231231', '111', 'normal');
INSERT INTO `admin` VALUES (42, 'yt6', 'rtyrtyr', 'ryrty', 'normal');
INSERT INTO `admin` VALUES (43, '2', '2', NULL, 'normal');
INSERT INTO `admin` VALUES (44, '544545', '45454545', 'gyf', 'normal');
INSERT INTO `admin` VALUES (45, '34324', '2343', '23423', 'normal');
INSERT INTO `admin` VALUES (46, '43112', 'eef8248c0feb8f32d5b00d196076ce8b', '23123', 'normal');

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `classroomName` varchar(10)  NOT NULL COMMENT '教室名',
  `seating` int(5) NULL DEFAULT NULL COMMENT '座位数',
  `projector` int(1) NULL DEFAULT NULL COMMENT '教室是否有投影仪1.有 0.无',
  `allocation` int(1) NULL DEFAULT NULL COMMENT '教室是否已分配1.是 0.无',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (1, '11-313', 70, 1, 1);
INSERT INTO `classroom` VALUES (5, '11-328', 60, 0, 0);
INSERT INTO `classroom` VALUES (9, '8-401', 70, 1, 0);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `courseCode` varchar(10)  NULL DEFAULT NULL COMMENT '课程编码',
  `courseName` varchar(10)  NULL DEFAULT NULL COMMENT '课程名',
  `faculty` varchar(10)  NULL DEFAULT NULL COMMENT '课程所属院系',
  `classHours` int(5) NULL DEFAULT NULL COMMENT '课时数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '0021', '软件测试', '电子信息工程学院', 17);
INSERT INTO `course` VALUES (3, '0023', '高数', '校级公共课', 17);

-- ----------------------------
-- Table structure for coursetable
-- ----------------------------
DROP TABLE IF EXISTS `coursetable`;
CREATE TABLE `coursetable`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '课表数据编号',
  `classroomName` varchar(10)  NULL DEFAULT NULL COMMENT '教室编号',
  `courseName` varchar(10)  NULL DEFAULT NULL COMMENT '课程名',
  `teacherName` varchar(5)  NULL DEFAULT NULL COMMENT '教师名',
  `faculty` varchar(10)  NULL DEFAULT NULL COMMENT '专业名',
  `day` int(1) NULL DEFAULT NULL COMMENT '周几的课',
  `whichSection` int(1) NULL DEFAULT NULL COMMENT '第几节',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coursetable
-- ----------------------------
INSERT INTO `coursetable` VALUES (1, '11-313', '软件测试', '郭云飞', '软件工程', 1, 2);
INSERT INTO `coursetable` VALUES (2, '11-313', '软件测试', '123', '软件工程', 1, 1);
INSERT INTO `coursetable` VALUES (3, '11-313', '软件测试', '123', '计算机科学与技术', 1, 1);
INSERT INTO `coursetable` VALUES (4, '11-313', '软件测试', '123', '信息管理', 1, 1);
INSERT INTO `coursetable` VALUES (5, '11-328', '软件测试', '333', '软件工程', 4, 1);
INSERT INTO `coursetable` VALUES (6, '8-401', '高数', '李志钦', '计算机科学与技术', 5, 3);
INSERT INTO `coursetable` VALUES (7, '11-328', '软件测试', '李志钦', '计算机科学与技术', 5, 1);

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `id` int(5) NOT NULL,
  `professionCode` varchar(10)  NULL DEFAULT NULL COMMENT '专业代码',
  `professionName` varchar(15)  NULL DEFAULT NULL COMMENT '专业名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES (1, '00011', '软件工程');
INSERT INTO `profession` VALUES (2, '00012', '计算机科学与技术');
INSERT INTO `profession` VALUES (3, '00013', '信息管理');
INSERT INTO `profession` VALUES (4, '00014', '护理系');
INSERT INTO `profession` VALUES (5, '00015', '会计');
INSERT INTO `profession` VALUES (6, '00016', '人工智能');
INSERT INTO `profession` VALUES (7, '00017', '法律');
INSERT INTO `profession` VALUES (8, '00018', '3423312');
INSERT INTO `profession` VALUES (9, '00019', '3423');
INSERT INTO `profession` VALUES (10, '00020', '水水大王');
INSERT INTO `profession` VALUES (11, '00021', '嘟嘟嘟嘟');
INSERT INTO `profession` VALUES (12, '00022', '嗒嗒嗒');
INSERT INTO `profession` VALUES (13, '00021', '带来大量的');
INSERT INTO `profession` VALUES (14, '00022', '嘀哩嘀哩');
INSERT INTO `profession` VALUES (15, '00023', '豆腐干士大夫');
INSERT INTO `profession` VALUES (16, '00024', '荒古东方棍');
INSERT INTO `profession` VALUES (17, '00025', '盛大富翁');
INSERT INTO `profession` VALUES (18, '00026', '反对反对');
INSERT INTO `profession` VALUES (19, '00027', '法撒旦');
INSERT INTO `profession` VALUES (20, '00028', '大大是');
INSERT INTO `profession` VALUES (21, '00029', '按时发放大哥');
INSERT INTO `profession` VALUES (22, '00020', '哈根达斯');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `account` varchar(15)  NULL DEFAULT NULL,
  `password` varchar(15)  NULL DEFAULT NULL,
  `studentName` varchar(5)  NULL DEFAULT NULL,
  `department` varchar(10)  NULL DEFAULT NULL,
  `studentClass` varchar(10)  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (6, '32', '123', '12312', '123', '123');
INSERT INTO `student` VALUES (7, '1234123', '132', '123', '123', '123');
INSERT INTO `student` VALUES (8, '123321', '12323123', '郭云飞', '电子信息工程系', '2');
INSERT INTO `student` VALUES (9, '434343', '23423423', '郭云飞', '电子信息工程系', '软件工程二班');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account` varchar(15)  NULL DEFAULT NULL,
  `password` varchar(255)  NULL DEFAULT NULL,
  `teacherName` varchar(5)  NULL DEFAULT NULL,
  `faculty` varchar(10)  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '123', '123', '123', '123');
INSERT INTO `teacher` VALUES (3, '3333', '33333', '333', '3333');
INSERT INTO `teacher` VALUES (4, '4445', 'a669ac6793329036230c57e1b11bd2af', '4445', '4445');
INSERT INTO `teacher` VALUES (5, '8989', '467dd53ebefd8b9af3bfa8bbc01708a7', '李志钦', '会计学院');

SET FOREIGN_KEY_CHECKS = 1;
