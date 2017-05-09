/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : p1_shop

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-04-27 10:40:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(10) NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) NOT NULL,
  `gprice` double(18,0) NOT NULL,
  `gnum` int(11) NOT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO goods VALUES ('2', 'orange', '20', '100');
INSERT INTO goods VALUES ('3', 'banana', '12', '100');
INSERT INTO goods VALUES ('4', 'cherry', '23', '100');
INSERT INTO goods VALUES ('5', 'table', '12', '100');
INSERT INTO goods VALUES ('6', 'cup', '34', '100');
INSERT INTO goods VALUES ('7', 'chair', '16', '100');
INSERT INTO goods VALUES ('8', 'board', '23', '100');
INSERT INTO goods VALUES ('9', 'beer', '5', '100');
INSERT INTO goods VALUES ('10', 'cola', '4', '100');
INSERT INTO goods VALUES ('11', 'apple2', '10', '80');
INSERT INTO goods VALUES ('12', 'orange2', '20', '100');
INSERT INTO goods VALUES ('13', 'banana2', '12', '100');
INSERT INTO goods VALUES ('14', 'cherry2', '23', '100');
INSERT INTO goods VALUES ('15', 'table2', '12', '100');
INSERT INTO goods VALUES ('16', 'cup2', '34', '100');
INSERT INTO goods VALUES ('17', 'chair2', '16', '100');
INSERT INTO goods VALUES ('18', 'board2', '23', '100');
INSERT INTO goods VALUES ('19', 'beer2', '5', '100');
INSERT INTO goods VALUES ('20', 'cola2', '4', '100');
INSERT INTO goods VALUES ('21', 'apple3', '10', '100');
INSERT INTO goods VALUES ('22', 'orange3', '20', '100');
INSERT INTO goods VALUES ('23', 'banana3', '12', '100');
INSERT INTO goods VALUES ('24', 'cherry3', '23', '100');
INSERT INTO goods VALUES ('25', 'table3', '12', '100');
INSERT INTO goods VALUES ('26', 'cup3', '34', '100');
INSERT INTO goods VALUES ('27', 'chair3', '16', '100');
INSERT INTO goods VALUES ('28', 'board3', '23', '100');
INSERT INTO goods VALUES ('29', 'beer3', '5', '100');
INSERT INTO goods VALUES ('30', 'cola3', '4', '100');
INSERT INTO goods VALUES ('31', 'apple4', '10', '80');
INSERT INTO goods VALUES ('32', 'orange4', '20', '100');
INSERT INTO goods VALUES ('33', 'banana4', '12', '100');
INSERT INTO goods VALUES ('34', 'cherry4', '23', '100');
INSERT INTO goods VALUES ('35', 'table4', '12', '100');
INSERT INTO goods VALUES ('36', 'cup4', '34', '100');
INSERT INTO goods VALUES ('37', 'chair4', '16', '100');
INSERT INTO goods VALUES ('38', 'board4', '23', '100');
INSERT INTO goods VALUES ('39', 'beer4', '5', '100');
INSERT INTO goods VALUES ('40', 'cola4', '4', '100');
INSERT INTO goods VALUES ('41', 'apple5', '10', '100');
INSERT INTO goods VALUES ('42', 'orange5', '20', '100');
INSERT INTO goods VALUES ('43', 'banana5', '12', '100');
INSERT INTO goods VALUES ('44', 'cherry5', '23', '100');
INSERT INTO goods VALUES ('45', 'table5', '12', '100');
INSERT INTO goods VALUES ('46', 'cup5', '34', '100');
INSERT INTO goods VALUES ('47', 'chair5', '16', '100');
INSERT INTO goods VALUES ('48', 'board5', '23', '100');
INSERT INTO goods VALUES ('49', 'beer5', '5', '100');
INSERT INTO goods VALUES ('50', 'cola5', '4', '100');
INSERT INTO goods VALUES ('53', 'test2', '20', '100');
INSERT INTO goods VALUES ('54', 'test3', '20', '100');

-- ----------------------------
-- Table structure for `gsales`
-- ----------------------------
DROP TABLE IF EXISTS `gsales`;
CREATE TABLE `gsales` (
  `gsid` int(10) NOT NULL AUTO_INCREMENT,
  `gid` int(10) NOT NULL,
  `sid` int(10) NOT NULL,
  `sdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `snum` int(11) NOT NULL,
  PRIMARY KEY (`gsid`),
  KEY `fgid` (`gid`),
  KEY `fsid` (`sid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of gsales
-- ----------------------------
INSERT INTO gsales VALUES ('1', '1', '1', '2017-04-24 15:20:09', '20');
INSERT INTO gsales VALUES ('2', '1', '1', '2017-04-24 15:21:12', '20');
INSERT INTO gsales VALUES ('3', '11', '1', '2017-04-24 15:21:12', '20');
INSERT INTO gsales VALUES ('4', '31', '1', '2017-04-24 15:21:13', '20');

-- ----------------------------
-- Table structure for `salesman`
-- ----------------------------
DROP TABLE IF EXISTS `salesman`;
CREATE TABLE `salesman` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `spassword` varchar(20) NOT NULL,
  `sname` varchar(10) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of salesman
-- ----------------------------
INSERT INTO salesman VALUES ('1', 'admin', 'admin');
INSERT INTO salesman VALUES ('2', '1234', 'test');
INSERT INTO salesman VALUES ('4', 'test', '123454');
INSERT INTO salesman VALUES ('5', '1234', 'test33');
