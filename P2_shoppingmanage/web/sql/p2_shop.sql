/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : p2_shop

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-05-05 10:08:24
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `good`
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `gid` int(10) NOT NULL AUTO_INCREMENT,
  `gname` varchar(32) NOT NULL,
  `gnum` int(10) NOT NULL,
  `gmade` varchar(32) DEFAULT NULL,
  `gprice` double(10,2) NOT NULL,
  `gbalance` double(10,2) NOT NULL,
  `gpic` varchar(32) NOT NULL,
  `tid` int(10) NOT NULL,
  PRIMARY KEY (`gid`),
  KEY `good_type` (`tid`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO good VALUES ('1', '沃特篮球鞋', '100', '佛山', '180.00', '500.00', '001.jpg', '1');
INSERT INTO good VALUES ('2', '安踏运动鞋', '100', '福州', '120.00', '800.00', '002.jpg', '1');
INSERT INTO good VALUES ('3', '耐克运动鞋', '100', '广州', '500.00', '1000.00', '003.jpg', '1');
INSERT INTO good VALUES ('4', '阿迪达斯T血衫', '100', '上海', '388.00', '600.00', '004.jpg', '2');
INSERT INTO good VALUES ('5', '李宁文化衫', '100', '广州', '180.00', '900.00', '005.jpg', '2');
INSERT INTO good VALUES ('6', '小米3', '100', '北京', '1999.00', '3000.00', '006.jpg', '3');
INSERT INTO good VALUES ('7', '小米2S', '100', '北京', '1299.00', '1000.00', '007.jpg', '3');
INSERT INTO good VALUES ('8', 'thinkpad笔记本', '100', '北京', '6999.00', '500.00', '008.jpg', '4');
INSERT INTO good VALUES ('9', 'dell笔记本', '100', '北京', '3900.00', '500.00', '009.jpg', '4');
INSERT INTO good VALUES ('10', 'ipad5', '100', '北京', '5900.00', '500.00', '010.jpg', '4');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) NOT NULL,
  `date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gid` int(10) NOT NULL,
  `num` int(10) NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `tid` int(10) NOT NULL AUTO_INCREMENT,
  `tname` varchar(32) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO type VALUES ('1', '鞋子');
INSERT INTO type VALUES ('2', '衬衫');
INSERT INTO type VALUES ('3', '手机');
INSERT INTO type VALUES ('4', '电子产品');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `realname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'wskyt', '1234', null, null);
