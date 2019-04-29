/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50558
Source Host           : 127.0.0.1:3306
Source Database       : club

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2019-04-27 15:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `activity_name` varchar(55) NOT NULL DEFAULT '' COMMENT '活动名称',
  `site` varchar(60) NOT NULL DEFAULT '' COMMENT '活动地点',
  `hold_time` varchar(80) NOT NULL DEFAULT '' COMMENT '活动举行时间',
  `introduce` text COMMENT '活动介绍',
  `apply_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `permission` int(1) NOT NULL DEFAULT '0' COMMENT '社团联是否批准',
  `activity_type_id` int(11) NOT NULL DEFAULT '0',
  `file_id` int(11) NOT NULL DEFAULT '0',
  `club_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '社团招新', '湖北师范大学若水轩', '2018年12月11日', '2018年12月9日晚6:30，“陌上花开”——山东大学《诗经》创意大赛在知新楼A1106室正式开始。共有十四支晋级队伍参赛，历史文化学院唐建军老师、杨东篱老师、章军杰老师担任此次大赛的评委。\r\n\r\n开场，主持人宣布了比赛规则，随后参赛同学按照抽签顺序开始展示。比赛中有同学借《氓》来思考现代女性的社会问题；有同学用视频来展现《月出》中男子对女子的思慕。用剧情表演展示的《绿衣》令人耳目一新；用深情朗读展现的《静女》别有意境。每个作品都具有自己的特点，一首首古老的诗经经过同学们的创意展示，拥有了更多的生机与活力。\r\n\r\n参赛的同学都拿出了自己精心准备的作品，三位评委老师认真评审每个作品，并给予评价。观看比赛的同学全神贯注地聆听着选手的讲解。随后，三位评委老师对本次比赛做出了评析，表扬了参与以及组织这次比赛的同学。唐建军老师鼓励同学们通过这次比赛进一步了解《诗经》，并更多地学习传统文化。章军杰老师建议同学们更多地把传统文化与现实相结合，创造出具有实际价值的文化作品，使之服务于社会生活。\r\n\r\n随后，工作人员根据评委老师给出的分数评选出了一、二、三等奖，并为选手颁发了奖品。在大赛第二阶段，栗子话剧社将选取优秀作品，将其编为话剧，并进行公演。\r\n\r\n最后，评委老师和这次比赛的参与者、组织者合影留念，陌上花开——山东大学《诗经》创意大赛第一阶段宣告结束。', null, '0', '2', '0', '0');
INSERT INTO `activity` VALUES ('2', '计算机协会义务为修', '湖北师范大学若水轩315', '2018年05月16日', '<p>为了更好地深入贯彻落实科学发展观，促进大学生德智体全面可持续发展，进一步弘扬国球精神，丰富大学生课余生活，增强体质以及提高心理素质，加强同学们的体育锻炼意识，促进学生文体活动的发展；同时，也为了促进各学院之间的乒乓球技术交流，提高学生的乒乓球水平，特举办第六届“山大杯”乒乓球团体赛。 由山东大学体育运动委员会主办的、山东大学乒乓球协会和山东大学体育学院承办的，由冠华体育、大川体育和国球汇赞助的“山大杯”乒乓球团体赛要来啦！ 5月19号，2018“山大杯”团体赛就将正式开赛！来，摆出一个你已经“准备好”的姿势吧！ 乒协的童鞋们已经张开双手准备拥抱来自各学院的“胖球”爱好者和可爱的你！5月19/20号，在兴隆山校区体育馆，各学院可派出男团、女团最强战队，在球场上挥汗如雨，酣畅激战！这个五月，在赛场上感受运动的魅力，让竞技体育激发你的战斗力，“山大杯”等你来战。 划重点：比赛时间：19日进行第一阶段男团女团小组赛， 20日进行第二阶段进行男团女团决赛。 比赛地点：山东大学兴隆山校区体育馆 5.19拉开战幕！各学院最强战队蓄势待发，打call倒计时！期待正式开赛，精彩上演。展山大风采，促国球发展，风里雨里，5.19兴隆山体育馆，我们等你！</p>', null, '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('3', '轮滑新生赛', '', '2018年11月24日', '醒人的秋风，满地的黄叶，\r\n那边，是哪来的人儿，这样，欢脱', null, '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('4', '极客俱乐部讲座圆满结束', '湖师教育楼', '', '<p>欢迎观看</p>', '2019-04-23 12:08:03', '0', '2', '0', '0');
INSERT INTO `activity` VALUES ('5', '6786', '4565', '2019-03-31T16:00:00.000Z', '<p>897698</p>', '2019-04-24 15:30:28', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('6', '534534', '5345', '2019-03-31T16:00:00.000Z', null, '2019-04-24 16:01:56', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('7', '5786', '645645', '2019-03-31T16:00:00.000Z', null, '2019-04-24 16:23:43', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('8', '645645', '6456', '2019-04-10T16:00:00.000Z', '<p><br></p><p>23</p><p>2</p>', '2019-04-24 16:24:02', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('9', '6456', '45656', '2019-03-31T16:00:00.000Z', null, '2019-04-24 16:24:27', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('10', '79678', '45465', '2019-04-01T16:00:00.000Z', null, '2019-04-24 16:25:11', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('11', '', '', '', null, '2019-04-26 23:16:57', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('12', '64563', '645645', '2019-03-31T16:00:00.000Z', '', '2019-04-26 23:22:50', '0', '1', '0', '0');
INSERT INTO `activity` VALUES ('13', '645645', '546345', '2019-03-31T16:00:00.000Z', '<p>31232</p>', '2019-04-26 23:25:04', '0', '1', '0', '0');

-- ----------------------------
-- Table structure for activity_type
-- ----------------------------
DROP TABLE IF EXISTS `activity_type`;
CREATE TABLE `activity_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动类型',
  `type` varchar(255) NOT NULL DEFAULT '' COMMENT '活动类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_type
-- ----------------------------
INSERT INTO `activity_type` VALUES ('1', '活动预告');
INSERT INTO `activity_type` VALUES ('2', '精彩活动回顾');

-- ----------------------------
-- Table structure for club
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club` (
  `num` int(11) NOT NULL AUTO_INCREMENT COMMENT '社团编号',
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '社团名称',
  `introduce` varchar(255) NOT NULL DEFAULT '' COMMENT '社团简介',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `club_type_id` tinyint(2) NOT NULL DEFAULT '0' COMMENT '社团类型id',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '社团状态',
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=79680 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES ('1', '计算机协会', '<p>计算机协会简介</p>', '2018-04-22 16:00:00', '1', '1');
INSERT INTO `club` VALUES ('2', '职业发展协会', '职业发展协会简介', '2019-04-23 10:41:03', '4', '1');
INSERT INTO `club` VALUES ('3', '花卉协会', '山东大学学生文献检索社团     趵突泉校区图书馆', '2019-04-23 10:41:15', '2', '0');
INSERT INTO `club` VALUES ('4', '极客俱乐部', '<p>极客俱乐部简介</p>', '2019-04-22 16:00:00', '6', '0');
INSERT INTO `club` VALUES ('5', '轩辕棋社', '轩辕棋社简介', '2019-04-24 19:04:08', '6', '0');
INSERT INTO `club` VALUES ('75675', '757', '<p>757567</p>', '2019-03-31 16:00:00', '1', '0');
INSERT INTO `club` VALUES ('79678', '9789687', '<p>6456</p>', '2021-04-05 16:00:00', '2', '0');
INSERT INTO `club` VALUES ('79679', '6456', '<p>645</p>', '2019-03-30 16:00:00', '1', '0');

-- ----------------------------
-- Table structure for club_type
-- ----------------------------
DROP TABLE IF EXISTS `club_type`;
CREATE TABLE `club_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '社团类型',
  `type` varchar(255) NOT NULL DEFAULT '' COMMENT '社团类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of club_type
-- ----------------------------
INSERT INTO `club_type` VALUES ('1', '理论学习类社团');
INSERT INTO `club_type` VALUES ('2', '艺术类型');
INSERT INTO `club_type` VALUES ('3', '公益服务类社团');
INSERT INTO `club_type` VALUES ('4', '职业发展类社团');
INSERT INTO `club_type` VALUES ('5', '体育锻炼类社团');
INSERT INTO `club_type` VALUES ('6', '兴趣爱好');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(60) NOT NULL DEFAULT '' COMMENT '文件名称',
  `file_path` varchar(120) NOT NULL DEFAULT '' COMMENT '文件路径',
  `file_type_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', '2019-04-24_120134.png', 'F:/fileSavePath/2019-04-24_120134.png', '0');
INSERT INTO `file` VALUES ('2', '2019-04-23_133236.png', 'F:/fileSavePath/2019-04-23_133236.png', '0');
INSERT INTO `file` VALUES ('3', '2019-04-23_125049.png', 'F:/fileSavePath/2019-04-23_125049.png', '0');
INSERT INTO `file` VALUES ('4', '2019-04-24_120556.png', 'F:/fileSavePath/2019-04-24_120556.png', '0');
INSERT INTO `file` VALUES ('5', '2019-04-24_120556.png', 'F:/fileSavePath/2019-04-24_120556.png', '0');
INSERT INTO `file` VALUES ('6', '2019-04-23_130350.png', 'F:/fileSavePath/2019-04-23_130350.png', '0');
INSERT INTO `file` VALUES ('7', '2019-04-23_130350.png', 'F:/fileSavePath/2019-04-23_130350.png', '0');
INSERT INTO `file` VALUES ('8', '2019-04-23_131903.png', 'F:/fileSavePath/2019-04-23_131903.png', '0');
INSERT INTO `file` VALUES ('9', '2019-04-23_133236.png', 'F:/fileSavePath/2019-04-23_133236.png', '0');
INSERT INTO `file` VALUES ('10', '2019-04-23_132307.png', 'F:/fileSavePath/2019-04-23_132307.png', '0');
INSERT INTO `file` VALUES ('11', '表格4、学士学位论文（设计）答辩申请表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('12', '表格3、学士学位论文（设计）中期检查表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('13', '表格5、学士学位论文（设计）答辩原始记录表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('14', '表格3、学士学位论文（设计）中期检查表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('15', '表格4、学士学位论文（设计）答辩申请表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('16', '表格7、学士学位论文（设计）诚信承诺书.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('17', '表格6、学士学位论文（设计）评审表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('18', '表格2、学士学位论文（设计）开题报告.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('19', '表格5、学士学位论文（设计）答辩原始记录表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('20', 'test.txt', '/test/', '0');
INSERT INTO `file` VALUES ('21', '表格5、学士学位论文（设计）答辩原始记录表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('22', 'test.txt', '/test/', '0');
INSERT INTO `file` VALUES ('23', 'test.txt', '/test/', '0');
INSERT INTO `file` VALUES ('24', 'test.txt', '/test/', '0');
INSERT INTO `file` VALUES ('25', '表格6、学士学位论文（设计）评审表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('26', '表格3、学士学位论文（设计）中期检查表.doc', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('27', '2019年特别要求.txt', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('28', '2019-04-24_122900.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('29', '2019-04-24_122900.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('30', 'p12.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('31', 'p12.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('32', 'p12.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('33', '2019-04-22_123439.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('34', 'p12.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('35', '2019-04-22_123439.png', 'fileUpload/', '0');
INSERT INTO `file` VALUES ('36', 'p12.png', 'fileUpload/', '0');

-- ----------------------------
-- Table structure for file_type
-- ----------------------------
DROP TABLE IF EXISTS `file_type`;
CREATE TABLE `file_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '社团类型',
  `type` varchar(255) NOT NULL DEFAULT '' COMMENT '社团类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_type
-- ----------------------------
INSERT INTO `file_type` VALUES ('1', '普通图片');
INSERT INTO `file_type` VALUES ('2', '常用文档');
INSERT INTO `file_type` VALUES ('3', '社团文件');

-- ----------------------------
-- Table structure for one_column
-- ----------------------------
DROP TABLE IF EXISTS `one_column`;
CREATE TABLE `one_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `club_name` varchar(80) NOT NULL DEFAULT '' COMMENT '社团名称',
  `club_summary` varchar(50) NOT NULL DEFAULT '' COMMENT '社团概况',
  `introduce` varchar(50) NOT NULL DEFAULT '' COMMENT '社团简介',
  `notice` varchar(50) NOT NULL DEFAULT '' COMMENT '社团快讯',
  `show` varchar(55) NOT NULL DEFAULT '' COMMENT '社团活动风采',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_column
-- ----------------------------
INSERT INTO `one_column` VALUES ('1', '社员名称', '社团摘要', '社团简介', '社团快讯', '活动风采');

-- ----------------------------
-- Table structure for passage
-- ----------------------------
DROP TABLE IF EXISTS `passage`;
CREATE TABLE `passage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `content` text NOT NULL COMMENT '文章内容',
  `publisher` varchar(50) NOT NULL DEFAULT '' COMMENT '文章发布者',
  `source` varchar(255) DEFAULT '' COMMENT '文章来源',
  `passage_type_id` tinyint(2) NOT NULL DEFAULT '1' COMMENT '文章类型',
  `club_id` int(11) DEFAULT '0' COMMENT '发布文章的社团id',
  `publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `click_num` int(11) NOT NULL DEFAULT '0' COMMENT '点击次数',
  `file_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of passage
-- ----------------------------
INSERT INTO `passage` VALUES ('1', '社团联简介', '这是一个社团系统，下面有许多社团，欢迎访问', '社团联管理员', '社团联', '5', '0', '2019-04-20 21:18:32', '0', '0');
INSERT INTO `passage` VALUES ('2', '社团简介', '<p>社团集合</p>', '社团管理员', '某某社团', '6', '0', '2020-05-06 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('11', '社团招新通知', '<p>欢迎报名参加</p>', '社团管理员', '22', '1', '0', '2019-03-22 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('13', '社团比赛', '欢迎报名参加', '社团管理员', '22', '2', '0', '2019-03-14 10:48:29', '0', '0');
INSERT INTO `passage` VALUES ('14', '计算机协会比成绩公布赛', '，仔细观看各个学生成绩', '社团管理员', '', '1', '0', '2019-04-10 10:47:15', '0', '0');
INSERT INTO `passage` VALUES ('15', '社团换届下周举行', '各位社团尽快完成换届', '社团管理员', '', '2', '0', '2019-04-03 10:50:35', '0', '0');
INSERT INTO `passage` VALUES ('16', '极客俱乐部下周讲座', '欢迎各位参加', '', '', '1', '0', '2019-04-03 10:50:18', '0', '0');
INSERT INTO `passage` VALUES ('17', '社团简介', '社团集合', '社团管理员', '某某社团', '6', '0', '2019-04-10 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('18', '6786', '<p>78+78+</p>', '', '', '2', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('19', '636', '<p>64646</p>', '', '', '1', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('20', '636', '<p>64646</p>', '', '', '1', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('21', '636', '<p>64646</p>', '', '', '1', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('24', '5353', '<p>42423</p>', '', '', '2', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('25', '5325', '<p>532523</p>', '', '', '2', '0', '2019-05-23 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('26', '5325', '<p>532523</p>', '', '', '2', '0', '2019-03-31 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('27', '5325', '<p>532523</p>', '', '', '2', '0', '2019-03-31 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('28', '5325', '<p>532523</p>', '', '', '2', '0', '2019-03-31 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('29', '36556', '<p>46354</p>', '', '', '1', '0', '2019-04-24 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('30', '46', '<p>64564</p>', '', '', '1', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('31', '46', '<p>64564</p>', '', '', '1', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('32', '6456', '<p>645645</p>', '', '', '1', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('33', '697489', '<p>645645</p>', '', '', '1', '0', '2019-03-30 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('34', '546', '<p>645645</p>', '', '', '2', '0', '2019-04-24 16:00:00', '0', '0');
INSERT INTO `passage` VALUES ('35', '233123', '<p>312312</p>', '', '', '1', '0', '2019-04-24 16:00:00', '0', '1');
INSERT INTO `passage` VALUES ('36', '6+65', '<p>+56+5</p>', '', '', '1', '0', '2019-04-24 16:00:00', '0', '1');
INSERT INTO `passage` VALUES ('37', '21231', '<p>31321</p>', '', '', '1', '0', '2019-04-24 16:00:00', '0', '26');
INSERT INTO `passage` VALUES ('38', '21231', '', '', '', '1', '0', '2019-04-24 16:00:00', '0', '26');
INSERT INTO `passage` VALUES ('39', '2132', '<p>1231231233</p>', '', '', '2', '0', '2019-04-24 16:00:00', '0', '27');

-- ----------------------------
-- Table structure for passage_type
-- ----------------------------
DROP TABLE IF EXISTS `passage_type`;
CREATE TABLE `passage_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章类型',
  `type` varchar(255) DEFAULT '' COMMENT '文章类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of passage_type
-- ----------------------------
INSERT INTO `passage_type` VALUES ('1', '重要通知');
INSERT INTO `passage_type` VALUES ('2', '社团要闻');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `num` varchar(30) NOT NULL DEFAULT '1' COMMENT '编号',
  `name` varchar(50) NOT NULL,
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别',
  `age` int(11) DEFAULT NULL,
  `email` varchar(80) NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `phone` varchar(50) NOT NULL,
  `club_num` int(11) NOT NULL DEFAULT '0' COMMENT '社团编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(50) NOT NULL DEFAULT '',
  `call_name` varchar(60) DEFAULT '' COMMENT '用户职称',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别（0保密，1男，2女）',
  `institute` varchar(50) NOT NULL DEFAULT '' COMMENT '学院',
  `account` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `is_active` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户是否激活（默认0，未激活；1激活）',
  `last_login_time` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sm', '', '1', 'a', '12@qq.com', '123456', '0', '2019-04-24 20:57:19', '1', '');
INSERT INTO `user` VALUES ('2', 'admin', '', '1', 'a', 'tim@qq.com', '123456', '0', '2019-04-24 20:57:27', '0', '');
INSERT INTO `user` VALUES ('10', '', '', '0', '', '18477853685@163.com', '123456', '0', '2019-04-09 23:05:17', '0', null);
INSERT INTO `user` VALUES ('11', '', '', '0', '', '18347853685@163.com', '123456', '0', '2019-04-09 23:12:22', '1', null);
INSERT INTO `user` VALUES ('12', '', '', '1', '', '17427853685@163.com', '123456', '0', '2019-04-09 23:16:46', '0', null);
INSERT INTO `user` VALUES ('13', '', '', '1', '', '16377853685@163.com', '123456', '0', '2019-04-09 23:21:12', '0', null);
INSERT INTO `user` VALUES ('14', '', '', '1', '', '18752853685@163.com', '123456', '0', '2019-04-09 23:21:49', '1', null);
INSERT INTO `user` VALUES ('15', '', '', '1', '', '183773853685@163.com', '123456', '0', '2019-04-09 23:28:23', '0', null);
INSERT INTO `user` VALUES ('16', '', '', '1', '', '18377853685@163.com', '123456', '0', '2019-04-09 23:28:47', '1', null);
INSERT INTO `user` VALUES ('17', '', '', '1', '', '14327853685@163.com', '123456', '0', '2019-04-16 16:07:50', '1', null);
INSERT INTO `user` VALUES ('18', '', '', '0', '', '18327853685@163.com', '123456', '0', '2019-04-16 16:07:57', '0', null);

-- ----------------------------
-- Table structure for user_club
-- ----------------------------
DROP TABLE IF EXISTS `user_club`;
CREATE TABLE `user_club` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职称id',
  `user_id` int(255) DEFAULT NULL COMMENT '职称名称',
  `club_id` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_club
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(45) NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '部长');
INSERT INTO `user_role` VALUES ('2', '副会长');
INSERT INTO `user_role` VALUES ('3', '社长');
