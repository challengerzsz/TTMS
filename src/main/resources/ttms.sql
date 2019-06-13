-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ttms
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `analysis_table`
--

DROP TABLE IF EXISTS `analysis_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `analysis_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `sold` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `id` (`id`),
  CONSTRAINT `analysis_table_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analysis_table`
--

LOCK TABLES `analysis_table` WRITE;
/*!40000 ALTER TABLE `analysis_table` DISABLE KEYS */;
INSERT INTO `analysis_table` VALUES (1,2,648),(2,7,495),(4,11,495);
/*!40000 ALTER TABLE `analysis_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `analysis_view`
--

DROP TABLE IF EXISTS `analysis_view`;
/*!50001 DROP VIEW IF EXISTS `analysis_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `analysis_view` AS SELECT 
 1 AS `id`,
 1 AS `username`,
 1 AS `realName`,
 1 AS `email`,
 1 AS `phone`,
 1 AS `address`,
 1 AS `sold`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `hall_table`
--

DROP TABLE IF EXISTS `hall_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hall_name` varchar(10) NOT NULL,
  `seatCount` int(11) NOT NULL,
  `describ` varchar(100) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall_table`
--

LOCK TABLES `hall_table` WRITE;
/*!40000 ALTER TABLE `hall_table` DISABLE KEYS */;
INSERT INTO `hall_table` VALUES (1,'max',90,'imax影厅',1),(2,'1号厅',90,'1号演出厅',1),(3,'2号厅',90,'2号演出厅',1),(4,'3号厅',90,'3号演出厅',1),(5,'4号厅',90,'4号演出厅',1),(6,'5号厅',90,'5号演出厅',1);
/*!40000 ALTER TABLE `hall_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies_table`
--

DROP TABLE IF EXISTS `movies_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies_table` (
  `countid` int(11) NOT NULL AUTO_INCREMENT,
  `sn` int(11) DEFAULT '0',
  `cnms` int(11) DEFAULT '0',
  `late` int(1) DEFAULT '0',
  `showInfo` varchar(50) DEFAULT NULL,
  `nm` varchar(50) NOT NULL,
  `dir` varchar(50) DEFAULT NULL,
  `star` varchar(50) DEFAULT NULL,
  `cat` varchar(50) DEFAULT NULL,
  `wish` varchar(50) DEFAULT NULL,
  `3d` int(1) DEFAULT '0',
  `pn` varchar(50) DEFAULT NULL,
  `img` varchar(300) DEFAULT NULL,
  `preSale` int(11) DEFAULT NULL,
  `vd` varchar(50) DEFAULT NULL,
  `scm` varchar(30) DEFAULT NULL,
  `sc` varchar(50) DEFAULT NULL,
  `ver` varchar(50) DEFAULT NULL,
  `rt` varchar(50) DEFAULT NULL,
  `dur` int(11) DEFAULT NULL,
  `src` varchar(50) DEFAULT NULL,
  `showDate` varchar(50) DEFAULT NULL,
  `imax` int(1) DEFAULT NULL,
  `snum` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `price` double DEFAULT '0',
  `id` varchar(10) NOT NULL,
  `status` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `countid` (`countid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_table`
--

LOCK TABLES `movies_table` WRITE;
/*!40000 ALTER TABLE `movies_table` DISABLE KEYS */;
INSERT INTO `movies_table` VALUES (18,0,0,0,'2018-06-15 下周五上映','猛虫过江','小沈阳','小沈阳,潘斌龙,宋芸桦','喜剧,动作','27525',0,'167','http://p0.meituan.net/165.220/movie/5fd19e095c4ac795cc291179356152c52921178.jpg',1,'','test update','0.0','2D','下周五上映',99,'','',0,'1206','',0,'1139994',1),(13,0,0,0,'今天1家影院放映5场','一纸婚约','张辉','刘熙阳,张一山,杨紫','剧情,爱情','13435',0,'49','http://p0.meituan.net/165.220/movie/88ed4e34107a963df120d562d201d43077447.jpg',1,'','叶子的真假婚姻，她将何去何从','0.0','2D','本周五上映',91,'','',0,'916','',0,'1182289',0),(19,0,0,0,'今天14家影院放映24场','昼颜','西谷弘','上户彩,斋藤工,伊藤步','剧情,爱情','25319',0,'93','http://p0.meituan.net/165.220/movie/7b2eaac36faaa57864935e20fde7885a242723.jpg',0,'','一部尺8888888','8.2','2D','2018-05-18上映',126,'','',0,'11679','',0,'1187542',0),(24,0,0,0,'2018-06-16 下周六上映','吃货宇宙','陈廖宇','姜小亮,刘思童,冯妮娜','喜剧,动画,科幻','11653',0,'69','http://p1.meituan.net/165.220/movie/2f5fcbfb55c10663af5a3e94a95e9bf7630675.jpg',1,'','美食大爆炸，吃货快回家','0.0','2D','下周六上映',89,'','',0,'136','',0,'1197507',1),(21,0,0,0,'今天12家影院放映19场','给19岁的我自己','黄朝亮','林柏宏,石安妮,王芊','爱情','19013',0,'43','http://p0.meituan.net/165.220/movie/13190b29d1aa9b0320ccb76f14c0a87512058133.jpg',0,'','神秘木盒能否找回错失的爱','7.7','2D','2018-05-29上映',98,'','',0,'5810','',0,'1198834',1),(3,0,0,0,'今天6家影院放映6场','厕所英雄','什里·那拉扬·辛','阿克谢·库玛尔,布米·佩德卡尔,阿努潘·凯尔','剧情,爱情','16946',0,'43','http://p1.meituan.net/165.220/movie/899b0a8c57fc44e93e83b9f0dae649f1767221.jpg',1,'','印度家中没有厕所引发的革命','0.0','2D','本周五上映',150,'','',0,'637','',0,'1199331',1),(2,0,0,0,'今天12家影院放映12场','深海越狱','帕夏·帕特里基','尚格·云顿,杜夫·龙格尔,阿尔·萨皮恩扎','剧情,动作,犯罪','89114',0,'24','http://p0.meituan.net/165.220/movie/200526fd0facc141caeef984314f7ef8328722.jpg',1,'','看中情局特工斗智斗勇，逃离潜艇','0.0','2D/中国巨幕','本周五上映',104,'','',0,'1743','',0,'1200045',1),(8,0,0,0,'今天88家影院放映327场','寂静之地','约翰·卡拉辛斯基','艾米莉·布朗特,约翰·卡拉辛斯基,诺亚·尤佩','剧情,恐怖,惊悚','136814',0,'149','http://p1.meituan.net/165.220/movie/dc07682883ccbcdfb3ae532e2a90d4ff1342251.jpg',0,'','一部让人屏住呼吸，神经紧绷的电影','7.3','2D/中国巨幕/全景声','2018-05-18上映',91,'','',0,'145662','',0,'1203554',1),(7,0,0,0,'今天98家影院放映666场','哆啦A梦：大雄的金银岛','今井一晓','水田山葵,大原惠美,嘉数由美','动画,冒险','104964',0,'98','http://p0.meituan.net/165.220/movie/37534bc363906ab61233c089d1db47ac1093181.jpg',0,'','大雄、静香与胖虎，童年记忆','8.1','2D/中国巨幕','2018-06-01上映',109,'','',0,'59150','',0,'1207042',1),(26,0,0,0,'2018-06-15 下周五上映','泄密者','邱礼涛','吴镇宇,张智霖,佘诗曼','动作,悬疑,犯罪','21526',0,'78','http://p1.meituan.net/165.220/movie/e01828f23b5b170421a2a577630a7aa01215952.jpg',1,'','','0.0','2D','下周五上映',102,'','',0,'190','',0,'1208008',1),(14,0,0,0,'2018-06-08 本周五上映','因果启示录','王陆涛','王姬,庹宗华,英壮','剧情','3344',0,'0','http://p1.meituan.net/165.220/movie/7d58af14047f5cf2f8c73eecfa1bc6d2283948.jpg',1,'','一个个负能量的传递 损人利己','0.0','2D','本周五上映',90,'','',0,'765','',0,'1208934',0),(1,0,0,0,'今天99家影院放映1288场','超时空同居','苏伦','雷佳音,佟丽娅,徐峥','喜剧,爱情,奇幻','127315',0,'231','http://p0.meituan.net/165.220/movie/f193e43ca706aa6bc6a26d6f53f0115a5315542.jpg',0,'','佟丽娅、雷佳音演绎超时空爱情喜剧','8.6','2D','2018-05-18上映',101,'','',0,'355088','',0,'1208942',1),(16,0,0,0,'今天30家影院放映55场','暗夜良人','王俊潾','何乙轩,李运佳,周舟','剧情,悬疑','1074',0,'60','http://p1.meituan.net/165.220/movie/173aa3cc5c729a6020b32014a60b82a75672295.jpg',0,'','最终逃离丑恶人性与是非之地','0.0','2D','本周三上映',90,'','',0,'389','',0,'1215573',1),(11,0,0,0,'今天54家影院放映143场','潜艇总动员：海底两万里','申宇','范楚绒,洪海天,李晔','动画','31783',1,'37','http://p0.meituan.net/165.220/movie/85a128c123f24a39d2772a1c4cff4a65410276.jpg',0,'','海底两万里的漫游探险','8.2','2D/3D','2018-06-01上映',75,'','',0,'15937','',0,'1216914',1),(17,0,0,0,'今天32家影院放映53场','魔镜奇缘2','陈设','','动画,冒险,家庭','23621',0,'19','http://p1.meituan.net/165.220/movie/e3a90b9f534038497683911fcd5239b92085543.jpg',0,'','寻找友谊果和时光宝石的冒险之旅','7.2','2D','2018-06-01上映',77,'','',0,'8578','',0,'1217650',1),(22,0,0,0,'今天10家影院放映10场','毛骨悚然之红衣男孩','孙杰','孙丹丹,陈奕鸣,孙家文','惊悚,悬疑','7974',0,'13','http://p1.meituan.net/165.220/movie/4dc95d4fe1589e95b1ce3409f6af9cc8992768.jpg',0,'','红衣男孩诅咒能否解除','4.6','2D','2018-06-01上映',86,'','',0,'2175','',0,'1220905',0),(20,0,0,0,'今天1家影院放映1场','恐怖浴室','陆诗雨','张星阑,刘国光,宋天湙','恐怖,惊悚','8658',0,'11','http://p0.meituan.net/165.220/movie/6f2b1b83b512d8ec417efdf09d34faa3316513.jpg',1,'','浴室水鬼谜团待解开','0.0','2D','本周五上映',90,'','',0,'657','',0,'1220908',0),(27,0,0,0,'今天1家影院放映1场','一个人的江湖','喻亢,黄建业','梁恩,屠育玮,张佳熙','动作','4074',0,'41','http://p0.meituan.net/165.220/movie/bcd22e926b49c4cd99949e169f1bcdd0853574.png',1,'','拳村少年邂逅蹉跎神秘少年','0.0','2D','本周五上映',90,'','',0,'119','',0,'1220935',0),(29,0,0,0,'今天2家影院放映3场','蓝色金鱼','唐明智','蓝燕,朱孝天,曲木古火·秋风','爱情,冒险','1698',0,'21','http://p1.meituan.net/165.220/movie/5e4882b33053bc210fa05faca3c14c0e247450.jpg',0,'','踏上文艺之旅 寻找残缺的记忆','0.0','2D','本周一上映',87,'','',0,'431','',0,'1220970',0),(4,0,0,0,'今天99家影院放映795场','复仇者联盟3：无限战争','安东尼·罗素,乔·罗素','小罗伯特·唐尼,克里斯·海姆斯沃斯,马克·鲁法洛','动作,冒险,科幻','1146071',1,'292','http://p1.meituan.net/165.220/movie/266d24fe8567632e078b3717a096d104359095.jpg',0,'','漫威电影宇宙10周年的历史性集结！','8.6','2D/IMAX 3D/中国巨幕/全景声','2018-05-11上映',150,'','',1,'1186835','',0,'248170',0),(31,0,0,0,'今天暂无场次','东北偏北','张秉坚','班赞,李滨,赖迦童','剧情,喜剧,悬疑','4315',0,'19','http://p0.meituan.net/165.220/movie/a773d8ec962c07b0df145c104500e1dc1047420.jpg',0,'','书生搭英雄，断案好神勇','7.1','2D','2015-12-11上映',103,'','',0,'998','',0,'248233',0),(12,0,0,0,'今天24家影院放映96场','狂暴巨兽','布拉德·佩顿','道恩·强森,娜奥米·哈里斯,杰弗里·迪恩·摩根','动作,冒险,科幻','160742',1,'96','http://p0.meituan.net/165.220/movie/d414df29b364e010976c4be97d5ee907290840.jpg',0,'','巨石强森主演，史诗级视觉大片！','9.0','2D/3D/IMAX 3D/中国巨幕/全景声','2018-04-13上映',108,'','',1,'712963','',0,'341624',0),(6,0,0,0,'2018-06-15 下周五上映','侏罗纪世界2','胡安·安东尼奥·巴亚纳','克里斯·帕拉特,布莱丝·达拉斯·霍华德,拉菲·斯波','动作,冒险,科幻','524371',1,'61','http://p1.meituan.net/165.220/movie/3d17aa5ee07f5d66239d8393bcb8fe5196556.jpg',1,'','寻找恐龙的欧文与克莱尔发现……','0.0','2D/3D/IMAX 3D/中国巨幕/全景声','下周五上映',128,'','',1,'10634','',0,'341628',1),(23,0,0,0,'今天6家影院放映8场','命运速递','李非','赵炳锐,吕晓霖,余皑磊','剧情,喜剧,犯罪','5514',0,'55','http://p0.meituan.net/165.220/movie/57cf2836684090810a64a8f1ee388807848233.jpg',0,'','24小时内发生的一幕人间悲喜剧','7.1','2D','2018-05-25上映',93,'','',0,'1276','',0,'341674',0),(10,0,0,0,'今天61家影院放映183场','游侠索罗：星球大战外传','朗·霍华德','阿尔登·埃伦瑞奇,艾米莉亚·克拉克,唐纳德·格洛沃','动作,科幻','34600',1,'100','http://p0.meituan.net/165.220/movie/eed84f84bdc14294c84d9b1671925a9b4594458.jpg',0,'','讲述如何发现星战最著名的宇宙飞船','7.9','2D/3D/IMAX 3D/中国巨幕/全景声','2018-05-25上映',135,'','',1,'32531','',0,'341944',0),(15,0,0,0,'今天30家影院放映72场','后来的我们','刘若英','井柏然,周冬雨,田壮壮','剧情,爱情','911022',0,'364','http://p0.meituan.net/165.220/movie/8c0af864aa72c46eb15c003d46ebfdc8602165.jpg',0,'','十年坎坷情，最强催泪弹','8.1','2D/全景声','2018-04-28上映',120,'','',0,'1057299','',0,'343720',0),(28,0,0,0,'2018-06-08 本周五上映','盯上小偷的贼','成宇兴','孙海洋,彭波,刚毅','喜剧,动作','3856',0,'31','http://p0.meituan.net/165.220/movie/7e1f6616b82f532e167a730452c90b9d653258.png',1,'','一场螳螂捕蝉寻找文物的故事','0.0','2D','本周五上映',92,'','',0,'56','',0,'344516',0),(9,0,0,0,'今天80家影院放映312场','完美陌生人','保罗·格诺维塞','朱塞佩·巴蒂斯通,安娜·福列塔,马可·贾利尼','剧情','22463',0,'83','http://p0.meituan.net/165.220/movie/42f04235cd6a27d343a3a1ef045a0662528503.jpg',0,'','这个游戏，你敢玩么？','8.5','2D','2018-05-25上映',96,'','',0,'21606','',0,'367738',0),(30,0,0,0,'今天1家影院放映1场','青年马克思','哈乌·佩克','奧古斯特·迪赫,史特凡·柯纳斯克,薇姬·克里普斯','剧情,历史,传记','2815',0,'13','http://p1.meituan.net/165.220/movie/3b5a995b705b11b5b190e9fd556eecba780985.jpg',0,'','马克思与恩格斯在巴黎的传奇相遇','8.4','2D','2018-05-05上映',115,'','',0,'2391','',0,'528054',0),(5,0,0,0,'今天5家影院放映5场','幸福马上来','冯巩,崔俊杰','冯巩,毛俊杰,刘昊然','剧情,喜剧','27007',0,'142','http://p1.meituan.net/165.220/movie/63aafb487fb6645e2a3521fce6922de5906570.jpg',1,'','调解超人马上来如何化解自己的难题','0.0','2D','本周五上映',91,'','',0,'1486','',0,'672164',0),(25,0,0,0,'今天6家影院放映7场','西小河的夏天','周全','张颂文,谭卓,顾宝明','剧情,家庭','3924',0,'162','http://p0.meituan.net/165.220/movie/71999ce35a12a661bb82a87ed49cfa1d2148527.jpg',0,'','2018年的晓阳会怀念10年前的夏天吗','7.9','2D','2018-05-25上映',102,'','',0,'1053','',0,'879019',0);
/*!40000 ALTER TABLE `movies_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger delete_movie_trigger after delete
on movies_table for each row begin
delete from schedule_table where movieId = old.id;
delete from ticket_table where movieId = old.id;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `schedule_table`
--

DROP TABLE IF EXISTS `schedule_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieId` varchar(10) NOT NULL,
  `hallId` int(11) NOT NULL,
  `price` double DEFAULT '0',
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `endTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  UNIQUE KEY `id` (`id`),
  KEY `movieId` (`movieId`),
  KEY `hallId` (`hallId`),
  CONSTRAINT `schedule_table_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies_table` (`id`),
  CONSTRAINT `schedule_table_ibfk_2` FOREIGN KEY (`hallId`) REFERENCES `hall_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_table`
--

LOCK TABLES `schedule_table` WRITE;
/*!40000 ALTER TABLE `schedule_table` DISABLE KEYS */;
INSERT INTO `schedule_table` VALUES (10,'1197507',1,22,'2016-06-15 01:05:00','2016-06-15 02:34:00'),(11,'1139994',1,15,'2016-06-25 05:40:00','2016-06-25 07:19:00'),(12,'1139994',5,15,'2016-06-25 07:40:00','2016-06-25 09:19:00'),(13,'1187542',1,22,'2018-06-16 00:05:00','2018-06-16 02:11:00');
/*!40000 ALTER TABLE `schedule_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_table`
--

DROP TABLE IF EXISTS `ticket_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieId` varchar(10) NOT NULL,
  `hallId` int(11) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `seatRow` int(11) NOT NULL,
  `seatColumn` int(11) NOT NULL,
  `ticketPrice` double NOT NULL,
  `type` int(1) DEFAULT '0',
  `userId` int(11) DEFAULT '0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sellerId` int(11) NOT NULL DEFAULT '0',
  UNIQUE KEY `id` (`id`),
  KEY `hallId` (`hallId`),
  KEY `movieId` (`movieId`),
  CONSTRAINT `ticket_table_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies_table` (`id`),
  CONSTRAINT `ticket_table_ibfk_2` FOREIGN KEY (`hallId`) REFERENCES `hall_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_table`
--

LOCK TABLES `ticket_table` WRITE;
/*!40000 ALTER TABLE `ticket_table` DISABLE KEYS */;
INSERT INTO `ticket_table` VALUES (3,'1139994',1,'2018-06-08 16:45:05',9,11,25.5,1,0,'2018-06-08 17:21:36',2),(4,'1139994',1,'2018-06-08 16:45:05',9,16,25.5,1,0,'2018-06-08 17:21:36',2),(6,'1139994',1,'2018-06-08 16:45:12',4,8,45.5,0,1,'2018-06-14 05:45:26',0),(8,'1139994',1,'2018-06-08 16:45:12',4,7,45.5,0,1,'2018-06-14 05:45:26',0),(9,'1139994',1,'2018-06-08 16:45:12',5,7,45.5,0,1,'2018-06-14 05:47:19',0),(16,'1197507',1,'2016-06-15 01:05:00',2,8,22,0,1,'2018-06-14 09:21:52',0),(17,'1197507',1,'2016-06-15 01:05:00',3,8,22,0,1,'2018-06-14 09:21:52',0),(18,'1197507',1,'2016-06-15 01:05:00',3,9,22,0,1,'2018-06-14 09:21:52',0),(19,'1197507',1,'2016-06-15 01:05:00',3,10,22,0,1,'2018-06-14 09:21:52',0),(20,'1197507',1,'2016-06-15 01:05:00',2,10,22,0,1,'2018-06-14 09:21:52',0),(21,'1197507',1,'2016-06-15 01:05:00',2,9,22,0,1,'2018-06-14 09:21:52',0),(22,'1197507',1,'2016-06-15 01:05:00',5,7,22,0,1,'2018-06-14 10:09:03',0),(23,'1197507',1,'2016-06-15 01:05:00',1,7,22,0,1,'2018-06-14 10:09:15',0),(24,'1197507',1,'2016-06-15 01:05:00',1,1,22,0,1,'2018-06-14 10:11:22',0),(26,'1139994',5,'2016-06-25 07:40:00',5,10,15,1,0,'2018-06-14 10:42:53',11),(27,'1139994',5,'2016-06-25 07:40:00',5,9,15,1,0,'2018-06-14 10:42:53',11),(30,'1139994',5,'2016-06-25 07:40:00',6,6,15,0,1,'2018-06-15 03:18:52',0),(31,'1139994',5,'2016-06-25 07:40:00',5,6,15,0,1,'2018-06-15 03:18:52',0),(32,'1139994',5,'2016-06-25 07:40:00',4,6,15,0,1,'2018-06-15 03:18:52',0),(33,'1139994',5,'2016-06-25 07:40:00',3,6,15,0,1,'2018-06-15 03:18:52',0),(34,'1139994',5,'2016-06-25 07:40:00',2,6,15,0,1,'2018-06-15 03:18:52',0),(35,'1139994',5,'2016-06-25 07:40:00',1,6,15,0,1,'2018-06-15 03:18:52',0),(36,'1139994',5,'2016-06-25 07:40:00',1,10,15,1,0,'2018-06-15 03:40:19',2),(37,'1139994',5,'2016-06-25 07:40:00',1,9,15,1,0,'2018-06-15 03:40:19',2),(38,'1139994',5,'2016-06-25 07:40:00',1,8,15,1,0,'2018-06-15 03:40:19',2),(39,'1139994',5,'2016-06-25 07:40:00',1,7,15,1,0,'2018-06-15 03:40:19',2),(40,'1139994',5,'2016-06-25 07:40:00',1,10,15,1,0,'2018-06-15 03:40:26',2),(41,'1139994',5,'2016-06-25 07:40:00',1,9,15,1,0,'2018-06-15 03:40:26',2),(42,'1139994',5,'2016-06-25 07:40:00',1,8,15,1,0,'2018-06-15 03:40:26',2),(43,'1139994',5,'2016-06-25 07:40:00',1,7,15,1,0,'2018-06-15 03:40:26',2),(44,'1139994',1,'2016-06-25 05:40:00',5,10,15,0,1,'2018-06-15 03:41:58',0),(45,'1139994',1,'2016-06-25 05:40:00',4,10,15,0,1,'2018-06-15 03:41:58',0),(46,'1139994',1,'2016-06-25 05:40:00',3,10,15,0,1,'2018-06-15 03:41:58',0),(47,'1139994',1,'2016-06-25 05:40:00',4,5,15,0,1,'2018-06-15 03:42:48',0),(48,'1139994',1,'2016-06-25 05:40:00',4,6,15,0,1,'2018-06-15 03:42:48',0),(49,'1139994',1,'2016-06-25 05:40:00',4,7,15,0,1,'2018-06-15 03:42:48',0),(50,'1139994',1,'2016-06-25 05:40:00',1,10,15,1,0,'2018-06-15 03:43:30',2),(51,'1139994',1,'2016-06-25 05:40:00',1,8,15,1,0,'2018-06-15 03:43:30',2),(52,'1139994',1,'2016-06-25 05:40:00',1,9,15,1,0,'2018-06-15 03:43:30',2),(53,'1139994',1,'2016-06-25 05:40:00',2,10,15,1,0,'2018-06-15 03:45:00',2),(54,'1139994',1,'2016-06-25 05:40:00',2,9,15,1,0,'2018-06-15 03:45:00',2),(55,'1139994',1,'2016-06-25 05:40:00',2,8,15,1,0,'2018-06-15 03:45:00',2),(56,'1139994',1,'2016-06-25 05:40:00',2,10,15,1,0,'2018-06-15 03:45:19',2),(57,'1139994',1,'2016-06-25 05:40:00',2,9,15,1,0,'2018-06-15 03:45:19',2),(58,'1139994',1,'2016-06-25 05:40:00',2,8,15,1,0,'2018-06-15 03:45:19',2),(59,'1139994',5,'2016-06-25 07:40:00',1,4,15,1,0,'2018-06-15 04:48:02',2),(60,'1139994',5,'2016-06-25 07:40:00',1,5,15,1,0,'2018-06-15 04:48:02',2),(61,'1139994',5,'2016-06-25 07:40:00',1,3,15,1,0,'2018-06-15 04:49:55',2),(62,'1139994',5,'2016-06-25 07:40:00',1,2,15,1,0,'2018-06-15 04:49:55',2),(63,'1139994',5,'2016-06-25 07:40:00',1,1,15,1,0,'2018-06-15 04:49:55',2),(64,'1139994',5,'2016-06-25 07:40:00',2,3,15,0,1,'2018-06-15 04:53:07',0),(65,'1139994',5,'2016-06-25 07:40:00',2,2,15,0,1,'2018-06-15 04:53:07',0),(66,'1139994',5,'2016-06-25 07:40:00',2,1,15,0,1,'2018-06-15 04:53:07',0),(67,'1139994',5,'2016-06-25 07:40:00',3,3,15,0,1,'2018-06-15 04:54:22',0),(68,'1139994',5,'2016-06-25 07:40:00',3,2,15,0,1,'2018-06-15 04:54:22',0),(69,'1139994',5,'2016-06-25 07:40:00',3,1,15,0,1,'2018-06-15 04:54:22',0),(70,'1139994',5,'2016-06-25 07:40:00',2,4,15,1,0,'2018-06-15 04:56:43',2),(71,'1139994',5,'2016-06-25 07:40:00',3,4,15,0,1,'2018-06-15 04:58:08',0),(72,'1139994',5,'2016-06-25 07:40:00',2,5,15,1,0,'2018-06-15 04:59:06',2),(73,'1139994',5,'2016-06-25 07:40:00',3,5,15,1,0,'2018-06-15 04:59:06',2),(74,'1139994',5,'2016-06-25 07:40:00',2,7,15,0,1,'2018-06-15 05:08:00',0),(75,'1139994',5,'2016-06-25 07:40:00',2,8,15,1,0,'2018-06-15 05:08:45',2),(76,'1139994',5,'2016-06-25 07:40:00',2,9,15,1,0,'2018-06-15 05:08:55',2),(77,'1139994',5,'2016-06-25 07:40:00',3,7,15,0,1,'2018-06-15 06:15:16',0),(78,'1139994',5,'2016-06-25 07:40:00',2,10,15,0,1,'2018-06-15 06:24:07',0),(79,'1139994',5,'2016-06-25 07:40:00',3,10,15,1,0,'2018-06-15 07:22:05',2),(80,'1139994',5,'2016-06-25 07:40:00',3,9,15,1,0,'2018-06-15 07:22:05',2),(81,'1139994',5,'2016-06-25 07:40:00',3,8,15,1,0,'2018-06-15 07:22:05',2),(82,'1139994',5,'2016-06-25 07:40:00',4,5,15,1,0,'2018-06-15 07:25:56',2),(83,'1139994',5,'2016-06-25 07:40:00',4,8,15,0,1,'2018-06-15 07:29:00',0);
/*!40000 ALTER TABLE `ticket_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger update_analysis_trigger after insert
on ticket_table for each row begin
if new.type = 1
then
update analysis_table set sold = sold + new.ticketPrice;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger delete_analysis_trigger after delete
on ticket_table for each row begin
update analysis_table set sold = sold - old.ticketPrice where userId = old.sellerId;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` int(1) NOT NULL DEFAULT '0',
  `img` varchar(255) DEFAULT 'localhost:8080/TTMS/USER_IMGS/default.png',
  `realName` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (7,'jtt','E10ADC3949BA59ABBE56E057F20F883E',1,'localhost:8080/TTMS/USER_IMGS/default.png','jtt','123456','123456','123456','2018-06-14 09:03:05','2018-06-14 09:03:05'),(11,'liy','E10ADC3949BA59ABBE56E057F20F883E',1,'localhost:8080/TTMS/USER_IMGS/default.png','liy','1','1','1','2018-06-14 10:07:11','2018-06-14 10:07:11'),(10,'manager','E10ADC3949BA59ABBE56E057F20F883E',2,'localhost:8080/TTMS/USER_IMGS/default.png','经理','manage@qq.com','121212','address','2018-06-14 09:44:21','2018-06-14 09:44:21'),(2,'seller','E10ADC3949BA59ABBE56E057F20F883E',1,'localhost:8080/TTMS/USER_IMGS/default.png','售票员','seller@qq.com','15619258911','陕西省宝鸡市','2018-06-07 12:47:20','2018-06-07 12:47:20'),(5,'seller3','E10ADC3949BA59ABBE56E057F20F883E',0,'localhost:8080/TTMS/USER_IMGS/default.png','seller3','seller3@qq.com','14253637383','seller3 address','2018-06-11 06:21:12','2018-06-11 06:21:12'),(6,'seller4','E10ADC3949BA59ABBE56E057F20F883E',0,'localhost:8080/TTMS/USER_IMGS/default.png','seller3','seller3@qq.com','14253637383','seller3 address','2018-06-11 08:16:55','2018-06-11 08:16:55'),(1,'zsz','E10ADC3949BA59ABBE56E057F20F883E',0,'http://localhost:8080/TTMS/USER_IMGS/1/1.jpg','曾帅智','664903471@qq.com','15619258929','陕西省宝鸡市','2018-06-07 12:41:17','2018-06-07 12:41:17');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger init_analysis_trigger after insert
on user_table for each row begin
if new.type = 1 
then 
insert into analysis_table values (null, new.id, 0);
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger delete_analysis_before_delete_user_trigger before delete
on user_table for each row begin
delete from analysis_table where userId = old.id;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'ttms'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `delete_afternow_event` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `delete_afternow_event` ON SCHEDULE EVERY 10 MINUTE STARTS '2018-06-08 18:41:12' ON COMPLETION NOT PRESERVE ENABLE DO begin
delete from ticket_table where startTime < current_timestamp;
delete from schedule_table where startTime < current_timestamp;
end */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'ttms'
--

--
-- Final view structure for view `analysis_view`
--

/*!50001 DROP VIEW IF EXISTS `analysis_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `analysis_view` AS select `user`.`id` AS `id`,`user`.`username` AS `username`,`user`.`realName` AS `realName`,`user`.`email` AS `email`,`user`.`phone` AS `phone`,`user`.`address` AS `address`,`an`.`sold` AS `sold` from (`user_table` `user` join `analysis_table` `an`) where (`user`.`id` = `an`.`userId`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 18:52:36
