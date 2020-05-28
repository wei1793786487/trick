/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : ticket

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-05-28 12:47:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back
-- ----------------------------
DROP TABLE IF EXISTS `back`;
CREATE TABLE `back` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `trickname` varchar(11) DEFAULT NULL,
  `back_money` varchar(255) DEFAULT NULL,
  `to_address` varchar(255) DEFAULT NULL,
  `start_address` varchar(255) DEFAULT NULL,
  `oper_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of back
-- ----------------------------
INSERT INTO `back` VALUES ('3', '大黄', 'p240', '32.4', '日照', '曲阜师范法学', '2020-05-28 12:44:58');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `menu` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', 'ROLE_ADMIN', '{\r\n    \"clearInfo\": {\r\n      \"clearUrl\": \"#\"\r\n    },\r\n    \"homeInfo\": {\r\n      \"title\": \"首页\",\r\n      \"icon\": \"fa fa-home\",\r\n      \"href\": \"welcome.html\"\r\n    },\r\n    \"logoInfo\": {\r\n      \"title\": \"后台管理\",\r\n      \"image\": \"../images/logo.png\",\r\n      \"href\": \"\"\r\n    },\r\n    \r\n    \"menuInfo\": {\r\n      \"currency\": {\r\n        \"title\": \"常规管理\",\r\n        \"icon\": \"fa fa-address-book\",\r\n        \"child\": [\r\n          {\r\n            \"title\": \"首页\",\r\n            \"href\": \"welcome.html\",\r\n            \"icon\": \"fa fa-home\",\r\n            \"target\": \"_self\"\r\n          },\r\n   \r\n          {\r\n            \"title\": \"用户管理\",\r\n            \"href\": \"user.html\",\r\n            \"icon\": \"fa fa-child\",\r\n            \"target\": \"_self\"\r\n          },\r\n          {\r\n            \"title\": \"票务管理\",\r\n            \"href\": \"ticket.html\",\r\n            \"icon\": \"fa fa-flag\",\r\n            \"target\": \"_self\"\r\n          },\r\n          {\r\n            \"title\": \"信息管理\",\r\n            \"href\": \"message.html\",\r\n            \"icon\": \"fa fa-glass\",\r\n            \"target\": \"_self\"\r\n          },\r\n                {\r\n            \"title\": \"退订记录\",\r\n            \"href\": \"back.html\",\r\n            \"icon\": \"fa fa-cubes\",\r\n            \"target\": \"_self\"\r\n          },\r\n       {\r\n            \"title\": \"订单统计\",\r\n            \"href\": \"Statistics.html\",\r\n            \"icon\": \"fa fa-database\",\r\n            \"target\": \"_self\"\r\n          },\r\n       {\r\n            \"title\": \"销售情况\",\r\n            \"href\": \"Sales.html\",\r\n            \"icon\": \"fa fa-folder-o\",\r\n            \"target\": \"_self\"\r\n          },\r\n        \r\n          {\r\n            \"title\": \"日志管理\",\r\n            \"href\": \"slog.html\",\r\n            \"icon\": \"fa fa-inbox\",\r\n            \"target\": \"_self\"\r\n          \r\n          }\r\n        ]\r\n      }\r\n    }\r\n  }');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` text,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `add_name` varchar(11) DEFAULT NULL,
  `createtime` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '<span style=\"font-style: italic;\">哒哒哒<span style=\"text-decoration-line: underline;\"></span></span><br><p><br></p>', 'user', '1', '', '2020-03-16 03:40');
INSERT INTO `message` VALUES ('2', '<p>请输入内容<b>\n                    </b></p><p>13131313131</p>', 'user', '1', null, '2020-03-16 03:40');
INSERT INTO `message` VALUES ('3', '<p>请输入内容<b>\n                    </b></p><p>代理</p>', 'user', '1', null, '2020-03-16 03:40');
INSERT INTO `message` VALUES ('4', '<p>请输入内容11113<b></b></p><p><br></p>', 'dahdh1', '1', 'user', '2020-03-16 03:40');
INSERT INTO `message` VALUES ('5', '<p>131313</p>', 'add', '1', null, '2020-03-16 03:40');
INSERT INTO `message` VALUES ('6', '<p><img src=\"../images/154938cc59e14b99862b87d09f74e0e2.jpg\" style=\"max-width:100%;\"><br></p>', '重要童子', '1', null, '2020-03-16 03:40');
INSERT INTO `message` VALUES ('8', '<p>我不好<b></b></p><p>大</p>', '你好', '1', 'user', '2020-03-16 03:40');
INSERT INTO `message` VALUES ('9', '<p><br></p><p><img src=\"../images/4c1e3b1e58e348209225176b8e8572b9.jpg\" style=\"max-width:100%;\"><br></p>', '车站炸了，大家以后不用来了', '1', 'user', '2020-03-16 03:40');
INSERT INTO `message` VALUES ('10', '<p>车站是不会包的</p>', '我不信', '1', 'user', '2020-03-16 03:40');
INSERT INTO `message` VALUES ('11', '<p>请输入内容<b>\n                    </b></p><p>哒哒哒</p>', '我说被炸了就是被炸了 麻蛋', '1', 'user', '2020-03-16 01:57:43');
INSERT INTO `message` VALUES ('27', '<p><img src=\"../images/420040b88e0249958e5fab38b933c9a8.jpg\" style=\"max-width:100%;\"><br></p><p><span style=\"font-style: italic;\">大哥说要干死你</span></p>', '达拉不投资要货', '1', 'user', '2020-03-16 16:56:37');
INSERT INTO `message` VALUES ('37', 'ad', '留言没有题目', '0', '小明', '2020-03-18 00:05:06');
INSERT INTO `message` VALUES ('36', '？？？？？\n', '留言没有题目', '0', 'user', '2020-03-17 23:35:28');
INSERT INTO `message` VALUES ('35', '我是你爸爸', '留言没有题目', '0', 'user', '2020-03-17 23:35:21');
INSERT INTO `message` VALUES ('34', '你是谁', '留言没有题目', '0', 'user', '2020-03-17 23:35:15');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `pay` int(11) unsigned DEFAULT NULL COMMENT '0为未支付，1为支付',
  `createtime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `1` (`uid`),
  KEY `111` (`tid`),
  CONSTRAINT `1` FOREIGN KEY (`uid`) REFERENCES `sys_user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `111` FOREIGN KEY (`tid`) REFERENCES `ticketing` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('admin', 'nLZXe/qvtb582/KSnRVOzA==', 'sg+tRpq4YBC8A1xzNr48MA==', '2020-03-07 16:13:16');
INSERT INTO `persistent_logins` VALUES ('大黄', '4QY3LPawn1bPUxL3LR7h7A==', '0X4egJKAOoWanTv3MXDIPg==', '2020-05-28 12:04:56');
INSERT INTO `persistent_logins` VALUES ('admin', 'RuF1uTLuazG8M3EITK79JQ==', 'm8HNuFWc1XQqlf38kZqeMQ==', '2020-03-12 18:17:19');
INSERT INTO `persistent_logins` VALUES ('admin', 'GzjkFZRxWNc5cNo4sm+8ug==', 'WhqlKAo1xBrmm9HKpRCR6Q==', '2020-03-12 18:48:17');
INSERT INTO `persistent_logins` VALUES ('大黄', 'RhcG2cdjd7AxU9jF/wStfQ==', 'grCyd/g6j0HFYzx7LT2Hlg==', '2020-05-28 12:04:37');
INSERT INTO `persistent_logins` VALUES ('大黄', 'SwtYyS+rJLepXXV7MvhQ+g==', 'IVruQirKnT12SNc1rIl32w==', '2020-05-28 12:04:26');
INSERT INTO `persistent_logins` VALUES ('大黄', 'sjRKcmF/j7ktlRfylBYkuw==', 'FaqA2DSEfADAwbTeQOfM5w==', '2020-05-28 12:04:27');
INSERT INTO `persistent_logins` VALUES ('大黄', 'yW3KtdpqTL8Szp2QRAGiqw==', 'zTrVT0xCPPvqZJwmNWZgDA==', '2020-05-28 11:51:54');
INSERT INTO `persistent_logins` VALUES ('大黄', 'VJiFlybYcdAoeYxkshosjA==', 'ipscJUC4YXEOysrH4Z+2fg==', '2020-05-28 12:03:15');
INSERT INTO `persistent_logins` VALUES ('大黄', 'nhMeLlx1IJQAWRydCQKSMg==', 'tgR31f3qPYS8WNNi/56w+g==', '2020-05-28 12:04:37');
INSERT INTO `persistent_logins` VALUES ('大黄', 'yUBl9QiKUmRmhuQu4hs78Q==', 'uvJKm0EJ3Lc8VVCxxgQmQQ==', '2020-05-28 12:04:37');
INSERT INTO `persistent_logins` VALUES ('大黄', 'FGLz0SGaOg7g/jtG1eTPFQ==', '9paUUA1FGUWrk2Sc4+DAYA==', '2020-05-28 12:04:27');
INSERT INTO `persistent_logins` VALUES ('大黄', 'syhsIgRWdW7/rVdTwAWpOw==', 'Elu7dCRi8T3LB6dKxiGH+w==', '2020-05-28 12:04:27');
INSERT INTO `persistent_logins` VALUES ('大黄', '7MZ4kMJgRqFScj7NP4f7nQ==', 'OjPH13IwudqxtkwNii7OHQ==', '2020-05-28 12:04:27');
INSERT INTO `persistent_logins` VALUES ('user', 'rPsT6BKTd79DsqUEjSUZ1w==', '7G0a/0HfGI6I0n/NNDcO0Q==', '2020-05-28 12:06:54');
INSERT INTO `persistent_logins` VALUES ('user', 'Yt/nzUtqzYP0ET2l7MQ1yg==', 'RDIUawwVES1/5Cx7U48O8Q==', '2020-05-28 11:50:25');
INSERT INTO `persistent_logins` VALUES ('user', '8QZbVq/m8SrpaXgrQIgNwQ==', 'huMKd83C0CxzbPHpNaswUw==', '2020-05-28 11:14:03');
INSERT INTO `persistent_logins` VALUES ('大黄', 'lpNLLUNbYg3i8D2aSojWOw==', 'c0CRwHcXZof3jilkLZBgNA==', '2020-05-28 12:05:43');
INSERT INTO `persistent_logins` VALUES ('user', 'sa+cwhz6SMA4uTz/LdXSag==', 'cpuMilnY4dKziAfFGNeJrA==', '2020-05-28 12:34:31');
INSERT INTO `persistent_logins` VALUES ('user', 'YC7WfWWH6hDBqSpxuifQzg==', 'c/ZLI0SVLsST15vlEgvdJg==', '2020-05-28 12:43:27');
INSERT INTO `persistent_logins` VALUES ('user', 'QfjozhYrv32ma/VRQetEgg==', 'Z/prqjFSKFMCLFpzFBce+A==', '2020-05-28 12:44:02');
INSERT INTO `persistent_logins` VALUES ('大黄', 's3STEk6WvQjm7Of7FEvKzg==', 'yKhGCkwi6KoMNFcCzgifYQ==', '2020-05-28 12:44:34');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `id_card` varchar(32) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `lasttime` varchar(32) DEFAULT NULL,
  `role` varchar(32) DEFAULT 'ROLE_USER',
  `isEnabled` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'user', '0', '$2a$10$VkK2rJEvZzovaq8PHPQYfubVai80kzWqISjunj2RbXv/uOSF8JO5S', '5625654', '127.0.0.1', '2020-05-28 12:44:01', 'ROLE_ADMIN', '0');
INSERT INTO `sys_user` VALUES ('3', '消息', '0', '$2a$10$y/GAqxWUG/AqkctRwU0hB.vZzJDkpDWwRJkUKxzaZJLk9pdrBcZbG', '1111', null, null, 'ROLE_ADMIN', '0');
INSERT INTO `sys_user` VALUES ('4', '小', null, '$2a$10$UjMlSsjLsHiq0Qxa034sG.itTeuMIrPN9cza7OyPw0sLNNATMm8l.', null, '127.0.0.1', '2020-03-18 00:04:47', 'ROLE_USER', '0');
INSERT INTO `sys_user` VALUES ('5', '大黄', null, '$2a$10$okTAU4PUVp6Po/aNMpEff.ZBr9K7W2ftti54gD6eo9bSG4lksJnKK', null, '127.0.0.1', '2020-05-28 12:44:33', 'ROLE_USER', '0');

-- ----------------------------
-- Table structure for ticketing
-- ----------------------------
DROP TABLE IF EXISTS `ticketing`;
CREATE TABLE `ticketing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `train_name` varchar(255) DEFAULT NULL,
  `s_address` varchar(255) DEFAULT NULL,
  `e_address` varchar(255) DEFAULT NULL,
  `s_time` varchar(255) DEFAULT NULL,
  `e_time` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticketing
-- ----------------------------
INSERT INTO `ticketing` VALUES ('1', 'k250', '日照', '曲阜', '08:00', '04:04', '30', '2020-03-18 19:44:23', '25.41');
INSERT INTO `ticketing` VALUES ('9', 'p240', '曲阜师范法学', '日照', '17:04', '20:19', '21', '2020-03-13 11:56:36', '34.1');
INSERT INTO `ticketing` VALUES ('10', '不知发票', '日照', '曲阜师范', '04:04', '03:04', '32', '2020-03-13 11:57:38', '11.1');
INSERT INTO `ticketing` VALUES ('11', 'k1331', '曲阜师范1131', '方法', '07:08', '02:05', '321', '2020-03-13 19:05:27', '78.4');
INSERT INTO `ticketing` VALUES ('12', '哒哒', '曲阜', '日照', '06:00', '00:02', '1', '2020-03-16 21:04:06', '1');

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addid` int(11) DEFAULT NULL,
  `name` varchar(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(32) DEFAULT NULL,
  `requestType` varchar(32) DEFAULT NULL,
  `requestParam` text,
  `user` varchar(32) DEFAULT NULL,
  `ip` varchar(32) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`addid`),
  CONSTRAINT `uid` FOREIGN KEY (`addid`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_log
-- ----------------------------
INSERT INTO `user_log` VALUES ('1', '1', '用户登录', '0', '/isLife', 'GET', '{}', 'user', '127.0.0.1', '133', '2020-03-18 18:07:38');
INSERT INTO `user_log` VALUES ('2', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"343p\",\"username\":\"user\"}', 'user', '127.0.0.1', '91', '2020-05-27 09:20:55');
INSERT INTO `user_log` VALUES ('3', '1', '查看消息列表', '0', '/message', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '82', '2020-05-27 09:20:59');
INSERT INTO `user_log` VALUES ('4', '1', '查看订单详情', '0', '/order', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '26', '2020-05-27 09:21:00');
INSERT INTO `user_log` VALUES ('5', '1', '查看票务', '0', '/ticket', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '19', '2020-05-27 09:21:01');
INSERT INTO `user_log` VALUES ('6', '1', '超管查询日志', '0', '/log/all', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '24', '2020-05-27 09:21:02');
INSERT INTO `user_log` VALUES ('7', '1', '查看票务', '0', '/ticket', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '8', '2020-05-27 09:21:04');
INSERT INTO `user_log` VALUES ('8', '1', '查看所有用户', '0', '/user', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '11', '2020-05-27 09:21:05');
INSERT INTO `user_log` VALUES ('9', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"5f9j\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '29', '2020-05-27 09:23:56');
INSERT INTO `user_log` VALUES ('10', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '5', '2020-05-27 09:24:53');
INSERT INTO `user_log` VALUES ('11', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '10', '2020-05-27 09:25:08');
INSERT INTO `user_log` VALUES ('12', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '5', '2020-05-27 09:25:19');
INSERT INTO `user_log` VALUES ('13', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '6', '2020-05-27 09:25:31');
INSERT INTO `user_log` VALUES ('14', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '8', '2020-05-27 09:26:12');
INSERT INTO `user_log` VALUES ('15', '5', '用户登录', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '125', '2020-05-27 09:27:30');
INSERT INTO `user_log` VALUES ('16', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '21', '2020-05-27 09:27:32');
INSERT INTO `user_log` VALUES ('17', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '13', '2020-05-27 09:27:40');
INSERT INTO `user_log` VALUES ('18', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '8', '2020-05-27 09:27:44');
INSERT INTO `user_log` VALUES ('19', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '7', '2020-05-27 09:27:45');
INSERT INTO `user_log` VALUES ('20', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '9', '2020-05-27 09:28:02');
INSERT INTO `user_log` VALUES ('21', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '17', '2020-05-27 09:28:16');
INSERT INTO `user_log` VALUES ('22', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '6', '2020-05-27 09:28:26');
INSERT INTO `user_log` VALUES ('23', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '15948', '2020-05-27 09:28:28');
INSERT INTO `user_log` VALUES ('24', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '80263', '2020-05-27 09:29:24');
INSERT INTO `user_log` VALUES ('25', '1', '用户登录', '0', '/isLife', 'GET', '{}', 'user', '127.0.0.1', '137', '2020-05-27 20:07:13');
INSERT INTO `user_log` VALUES ('26', '1', '登录异常', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"jftr\",\"username\":\"user\"}', 'user', '127.0.0.1', '13', '2020-05-27 20:07:50');
INSERT INTO `user_log` VALUES ('27', '1', '登录异常', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"3ytk\",\"username\":\"user\"}', 'user', '127.0.0.1', '10', '2020-05-27 20:08:07');
INSERT INTO `user_log` VALUES ('28', '1', '用户登录', '0', '/verifyCode.jpg', 'GET', '{\"1590581533818\":\"\"}', 'user', '127.0.0.1', '121', '2020-05-27 20:12:14');
INSERT INTO `user_log` VALUES ('29', '1', '登录异常', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"汉化m\",\"username\":\"user\"}', 'user', '127.0.0.1', '6', '2020-05-27 20:12:37');
INSERT INTO `user_log` VALUES ('30', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"j6q9\",\"username\":\"user\"}', 'user', '127.0.0.1', '12', '2020-05-27 20:12:58');
INSERT INTO `user_log` VALUES ('31', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '89', '2020-05-27 20:13:00');
INSERT INTO `user_log` VALUES ('32', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"tdmy\",\"username\":\"user\"}', 'user', '127.0.0.1', '18', '2020-05-27 20:14:55');
INSERT INTO `user_log` VALUES ('33', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '10', '2020-05-27 20:14:57');
INSERT INTO `user_log` VALUES ('34', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"skkl\",\"username\":\"user\"}', 'user', '127.0.0.1', '33', '2020-05-27 20:15:31');
INSERT INTO `user_log` VALUES ('35', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '9', '2020-05-27 20:15:33');
INSERT INTO `user_log` VALUES ('36', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '7', '2020-05-27 20:16:02');
INSERT INTO `user_log` VALUES ('37', '1', '用户登录', '0', '/verifyCode.jpg', 'GET', '{\"1590585403905\":\"\"}', 'user', '127.0.0.1', '15', '2020-05-27 21:16:44');
INSERT INTO `user_log` VALUES ('38', '1', '登录异常', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"没32\",\"username\":\"user\"}', 'user', '127.0.0.1', '2', '2020-05-27 21:16:46');
INSERT INTO `user_log` VALUES ('39', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"6l9e\",\"username\":\"user\"}', 'user', '127.0.0.1', '33', '2020-05-27 21:17:15');
INSERT INTO `user_log` VALUES ('40', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '10', '2020-05-27 21:17:16');
INSERT INTO `user_log` VALUES ('41', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"KV57\",\"username\":\"user\"}', 'user', '127.0.0.1', '14', '2020-05-27 21:19:13');
INSERT INTO `user_log` VALUES ('42', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '17', '2020-05-27 21:19:15');
INSERT INTO `user_log` VALUES ('43', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '6', '2020-05-27 21:19:53');
INSERT INTO `user_log` VALUES ('44', '1', '登录异常', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"XR39\",\"username\":\"user\"}', 'user', '127.0.0.1', '3', '2020-05-27 21:20:06');
INSERT INTO `user_log` VALUES ('45', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"A5W4\",\"username\":\"user\"}', 'user', '127.0.0.1', '35', '2020-05-27 21:20:12');
INSERT INTO `user_log` VALUES ('46', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '7', '2020-05-27 21:20:14');
INSERT INTO `user_log` VALUES ('47', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"aapq\",\"username\":\"user\"}', 'user', '127.0.0.1', '27', '2020-05-27 21:22:07');
INSERT INTO `user_log` VALUES ('48', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '6', '2020-05-27 21:22:23');
INSERT INTO `user_log` VALUES ('49', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '6', '2020-05-27 21:22:31');
INSERT INTO `user_log` VALUES ('50', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"tha5\",\"username\":\"user\"}', 'user', '127.0.0.1', '14', '2020-05-27 21:22:46');
INSERT INTO `user_log` VALUES ('51', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '7', '2020-05-27 21:22:48');
INSERT INTO `user_log` VALUES ('52', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"9ms2\",\"username\":\"user\"}', 'user', '127.0.0.1', '137', '2020-05-27 21:23:42');
INSERT INTO `user_log` VALUES ('53', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '91', '2020-05-27 21:23:45');
INSERT INTO `user_log` VALUES ('54', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '12', '2020-05-27 21:24:56');
INSERT INTO `user_log` VALUES ('55', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '15', '2020-05-27 21:25:54');
INSERT INTO `user_log` VALUES ('56', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"wcnh\",\"username\":\"user\"}', 'user', '127.0.0.1', '35', '2020-05-27 21:26:51');
INSERT INTO `user_log` VALUES ('57', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"9l8b\",\"username\":\"user\"}', 'user', '127.0.0.1', '16', '2020-05-27 21:28:47');
INSERT INTO `user_log` VALUES ('58', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '14', '2020-05-27 21:29:12');
INSERT INTO `user_log` VALUES ('59', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '15', '2020-05-27 21:30:44');
INSERT INTO `user_log` VALUES ('60', '5', '用户登录', '0', '/isLife', 'GET', '{}', '大黄', '127.0.0.1', '18', '2020-05-27 21:31:22');
INSERT INTO `user_log` VALUES ('61', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"amcy\",\"username\":\"user\"}', 'user', '127.0.0.1', '30', '2020-05-27 21:31:33');
INSERT INTO `user_log` VALUES ('62', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '9', '2020-05-27 21:31:35');
INSERT INTO `user_log` VALUES ('63', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"f7u5\",\"username\":\"user\"}', 'user', '127.0.0.1', '35', '2020-05-27 21:32:44');
INSERT INTO `user_log` VALUES ('64', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '12', '2020-05-27 21:32:45');
INSERT INTO `user_log` VALUES ('65', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '7', '2020-05-27 21:33:26');
INSERT INTO `user_log` VALUES ('66', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '13', '2020-05-27 21:33:36');
INSERT INTO `user_log` VALUES ('67', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"6qcd\",\"username\":\"user\"}', 'user', '127.0.0.1', '44', '2020-05-27 21:37:20');
INSERT INTO `user_log` VALUES ('68', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"kcul\",\"username\":\"user\"}', 'user', '127.0.0.1', '33', '2020-05-27 21:39:49');
INSERT INTO `user_log` VALUES ('69', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '10', '2020-05-27 21:41:35');
INSERT INTO `user_log` VALUES ('70', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '7', '2020-05-27 21:41:53');
INSERT INTO `user_log` VALUES ('71', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"qwen\",\"username\":\"user\"}', 'user', '127.0.0.1', '34', '2020-05-27 21:45:33');
INSERT INTO `user_log` VALUES ('72', '1', '用户登录', '0', '/verifyCode.jpg', 'GET', '{\"1590635642143\":\"\"}', 'user', '127.0.0.1', '145', '2020-05-28 11:14:03');
INSERT INTO `user_log` VALUES ('73', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '124', '2020-05-28 11:14:12');
INSERT INTO `user_log` VALUES ('74', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"xssj\",\"username\":\"user\"}', 'user', '127.0.0.1', '35', '2020-05-28 11:14:19');
INSERT INTO `user_log` VALUES ('75', '1', '查看消息列表', '0', '/message', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '26', '2020-05-28 11:14:23');
INSERT INTO `user_log` VALUES ('76', '1', '查看订单详情', '0', '/order', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '32', '2020-05-28 11:14:24');
INSERT INTO `user_log` VALUES ('77', '1', '查看所有用户', '0', '/user', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '13', '2020-05-28 11:14:28');
INSERT INTO `user_log` VALUES ('78', '1', '查看票务', '0', '/ticket', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '24', '2020-05-28 11:14:29');
INSERT INTO `user_log` VALUES ('79', '1', '用户登录', '0', '/isLife', 'GET', '{}', 'user', '127.0.0.1', '172', '2020-05-28 11:50:25');
INSERT INTO `user_log` VALUES ('80', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"axxq\",\"username\":\"user\"}', 'user', '127.0.0.1', '45', '2020-05-28 11:50:37');
INSERT INTO `user_log` VALUES ('81', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"lww9\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '25', '2020-05-28 11:51:54');
INSERT INTO `user_log` VALUES ('82', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '19', '2020-05-28 11:52:01');
INSERT INTO `user_log` VALUES ('83', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '22', '2020-05-28 11:52:08');
INSERT INTO `user_log` VALUES ('84', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '6', '2020-05-28 11:52:09');
INSERT INTO `user_log` VALUES ('85', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '21', '2020-05-28 11:52:27');
INSERT INTO `user_log` VALUES ('86', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '85', '2020-05-28 11:52:29');
INSERT INTO `user_log` VALUES ('87', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '4', '2020-05-28 11:52:32');
INSERT INTO `user_log` VALUES ('88', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '3', '2020-05-28 11:52:33');
INSERT INTO `user_log` VALUES ('89', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '4', '2020-05-28 11:52:33');
INSERT INTO `user_log` VALUES ('90', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '4', '2020-05-28 11:52:33');
INSERT INTO `user_log` VALUES ('91', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '3', '2020-05-28 11:52:33');
INSERT INTO `user_log` VALUES ('92', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '3', '2020-05-28 11:52:33');
INSERT INTO `user_log` VALUES ('93', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '4', '2020-05-28 11:52:33');
INSERT INTO `user_log` VALUES ('94', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '5', '2020-05-28 11:52:34');
INSERT INTO `user_log` VALUES ('95', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '3', '2020-05-28 11:52:34');
INSERT INTO `user_log` VALUES ('96', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '3', '2020-05-28 11:52:34');
INSERT INTO `user_log` VALUES ('97', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '3', '2020-05-28 11:52:34');
INSERT INTO `user_log` VALUES ('98', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '4', '2020-05-28 11:52:34');
INSERT INTO `user_log` VALUES ('99', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '16', '2020-05-28 11:52:34');
INSERT INTO `user_log` VALUES ('100', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '4', '2020-05-28 11:52:34');
INSERT INTO `user_log` VALUES ('101', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '6', '2020-05-28 11:52:45');
INSERT INTO `user_log` VALUES ('102', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"1\"}', '大黄', '127.0.0.1', '4', '2020-05-28 11:53:34');
INSERT INTO `user_log` VALUES ('103', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '7', '2020-05-28 11:55:27');
INSERT INTO `user_log` VALUES ('104', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '3', '2020-05-28 11:55:43');
INSERT INTO `user_log` VALUES ('105', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '19', '2020-05-28 11:56:41');
INSERT INTO `user_log` VALUES ('106', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '29', '2020-05-28 11:56:50');
INSERT INTO `user_log` VALUES ('107', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '6', '2020-05-28 11:56:51');
INSERT INTO `user_log` VALUES ('108', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '24', '2020-05-28 11:56:52');
INSERT INTO `user_log` VALUES ('109', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"7j6q\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '15', '2020-05-28 11:57:46');
INSERT INTO `user_log` VALUES ('110', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '9', '2020-05-28 11:58:28');
INSERT INTO `user_log` VALUES ('111', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '12', '2020-05-28 11:58:31');
INSERT INTO `user_log` VALUES ('112', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"2\"}', '大黄', '127.0.0.1', '18', '2020-05-28 11:58:40');
INSERT INTO `user_log` VALUES ('113', '5', '用户登录', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '129', '2020-05-28 12:03:15');
INSERT INTO `user_log` VALUES ('114', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '21', '2020-05-28 12:03:23');
INSERT INTO `user_log` VALUES ('115', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '30', '2020-05-28 12:03:31');
INSERT INTO `user_log` VALUES ('116', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '8', '2020-05-28 12:03:32');
INSERT INTO `user_log` VALUES ('117', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '18', '2020-05-28 12:03:39');
INSERT INTO `user_log` VALUES ('118', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"3\"}', '大黄', '127.0.0.1', '27', '2020-05-28 12:03:43');
INSERT INTO `user_log` VALUES ('119', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '9', '2020-05-28 12:03:44');
INSERT INTO `user_log` VALUES ('120', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '6', '2020-05-28 12:04:07');
INSERT INTO `user_log` VALUES ('121', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '16', '2020-05-28 12:04:26');
INSERT INTO `user_log` VALUES ('122', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '27', '2020-05-28 12:04:27');
INSERT INTO `user_log` VALUES ('123', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '35', '2020-05-28 12:04:27');
INSERT INTO `user_log` VALUES ('124', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '30', '2020-05-28 12:04:27');
INSERT INTO `user_log` VALUES ('125', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '15', '2020-05-28 12:04:27');
INSERT INTO `user_log` VALUES ('126', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '14', '2020-05-28 12:04:37');
INSERT INTO `user_log` VALUES ('127', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '35', '2020-05-28 12:04:37');
INSERT INTO `user_log` VALUES ('128', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"u3ya\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '34', '2020-05-28 12:04:37');
INSERT INTO `user_log` VALUES ('129', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"55r5\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '13', '2020-05-28 12:04:56');
INSERT INTO `user_log` VALUES ('130', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"abps\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '14', '2020-05-28 12:05:43');
INSERT INTO `user_log` VALUES ('131', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '5', '2020-05-28 12:05:54');
INSERT INTO `user_log` VALUES ('132', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '6', '2020-05-28 12:05:55');
INSERT INTO `user_log` VALUES ('133', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '5', '2020-05-28 12:06:02');
INSERT INTO `user_log` VALUES ('134', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '14', '2020-05-28 12:06:09');
INSERT INTO `user_log` VALUES ('135', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '4', '2020-05-28 12:06:11');
INSERT INTO `user_log` VALUES ('136', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '22', '2020-05-28 12:06:13');
INSERT INTO `user_log` VALUES ('137', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"4\"}', '大黄', '127.0.0.1', '14', '2020-05-28 12:06:18');
INSERT INTO `user_log` VALUES ('138', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '10', '2020-05-28 12:06:19');
INSERT INTO `user_log` VALUES ('139', '1', '用户登录', '0', '/order', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '17', '2020-05-28 12:06:54');
INSERT INTO `user_log` VALUES ('140', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '18', '2020-05-28 12:06:57');
INSERT INTO `user_log` VALUES ('141', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"wf9l\",\"username\":\"user\"}', 'user', '127.0.0.1', '12', '2020-05-28 12:07:05');
INSERT INTO `user_log` VALUES ('142', '1', '查看订单详情', '0', '/order', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '7', '2020-05-28 12:07:09');
INSERT INTO `user_log` VALUES ('143', '1', '查看订单详情', '0', '/order', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '8', '2020-05-28 12:07:11');
INSERT INTO `user_log` VALUES ('144', '1', '查看消息列表', '0', '/message', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '8', '2020-05-28 12:07:12');
INSERT INTO `user_log` VALUES ('145', '1', '', '0', '/message/6', 'GET', '{}', 'user', '127.0.0.1', '3', '2020-05-28 12:07:15');
INSERT INTO `user_log` VALUES ('146', '1', '查看票务', '0', '/ticket', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '8', '2020-05-28 12:07:21');
INSERT INTO `user_log` VALUES ('147', '1', '超管查询日志', '0', '/log/all', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '18', '2020-05-28 12:07:22');
INSERT INTO `user_log` VALUES ('148', '1', '用户登录', '0', '/isLife', 'GET', '{}', 'user', '127.0.0.1', '165', '2020-05-28 12:34:31');
INSERT INTO `user_log` VALUES ('149', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"vlyg\",\"username\":\"user\"}', 'user', '127.0.0.1', '31', '2020-05-28 12:34:42');
INSERT INTO `user_log` VALUES ('150', '1', '用户登录', '0', '/back', 'DELETE', '{\"ids[]\":\"1\"}', 'user', '127.0.0.1', '121', '2020-05-28 12:43:27');
INSERT INTO `user_log` VALUES ('151', '1', '查看所有用户', '0', '/user/', 'GET', '{}', 'user', '127.0.0.1', '17', '2020-05-28 12:43:55');
INSERT INTO `user_log` VALUES ('152', '1', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"crxf\",\"username\":\"user\"}', 'user', '127.0.0.1', '31', '2020-05-28 12:44:02');
INSERT INTO `user_log` VALUES ('153', '1', '查看票务', '0', '/ticket', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '17', '2020-05-28 12:44:06');
INSERT INTO `user_log` VALUES ('154', '1', '查看订单详情', '0', '/order', 'GET', '{\"limit\":\"15\",\"page\":\"1\"}', 'user', '127.0.0.1', '24', '2020-05-28 12:44:07');
INSERT INTO `user_log` VALUES ('155', '5', '用户登录', '0', '/login', 'POST', '{\"password\":\"密码不可见\",\"captcha\":\"7tsb\",\"username\":\"大黄\"}', '大黄', '127.0.0.1', '30', '2020-05-28 12:44:34');
INSERT INTO `user_log` VALUES ('156', '5', '', '0', '/message/11', 'GET', '{}', '大黄', '127.0.0.1', '13', '2020-05-28 12:44:38');
INSERT INTO `user_log` VALUES ('157', '5', '', '0', '/message/9', 'GET', '{}', '大黄', '127.0.0.1', '6', '2020-05-28 12:44:39');
INSERT INTO `user_log` VALUES ('158', '5', '', '0', '/message/11', 'GET', '{}', '大黄', '127.0.0.1', '8', '2020-05-28 12:44:40');
INSERT INTO `user_log` VALUES ('159', '5', '', '0', '/message/27', 'GET', '{}', '大黄', '127.0.0.1', '8', '2020-05-28 12:44:41');
INSERT INTO `user_log` VALUES ('160', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '13', '2020-05-28 12:44:43');
INSERT INTO `user_log` VALUES ('161', '5', '', '0', '/ticket/9', 'GET', '{}', '大黄', '127.0.0.1', '7', '2020-05-28 12:44:49');
INSERT INTO `user_log` VALUES ('162', '5', '添加订单消息', '0', '/order', 'POST', '{\"tid\":\"9\"}', '大黄', '127.0.0.1', '20', '2020-05-28 12:44:56');
INSERT INTO `user_log` VALUES ('163', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '20', '2020-05-28 12:44:56');
INSERT INTO `user_log` VALUES ('164', '5', '删除订单信息', '0', '/order', 'DELETE', '{\"ids[]\":\"5\"}', '大黄', '127.0.0.1', '38', '2020-05-28 12:44:58');
INSERT INTO `user_log` VALUES ('165', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '6', '2020-05-28 12:44:58');
INSERT INTO `user_log` VALUES ('166', '5', '查看订单详情', '0', '/order', 'GET', '{}', '大黄', '127.0.0.1', '7', '2020-05-28 12:44:59');
