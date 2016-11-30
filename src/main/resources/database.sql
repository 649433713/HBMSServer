-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: hbmsdatabase
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `appeal`
--

DROP TABLE IF EXISTS `appeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appeal` (
  `appealID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `appealTime` datetime DEFAULT '2000-01-01 00:00:00',
  `userID` varchar(10) DEFAULT NULL,
  `webMarketerID` varchar(10) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `appealState` tinyint(4) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  PRIMARY KEY (`appealID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appeal`
--

LOCK TABLES `appeal` WRITE;
/*!40000 ALTER TABLE `appeal` DISABLE KEYS */;
/*!40000 ALTER TABLE `appeal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentinfo`
--

DROP TABLE IF EXISTS `commentinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentinfo` (
  `commentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hotelID` int(10) unsigned NOT NULL,
  `score` int(11) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `picture1` varchar(50) DEFAULT NULL,
  `picture2` varchar(50) DEFAULT NULL,
  `picture3` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`commentID`),
  KEY `hotelID_idx` (`hotelID`),
  CONSTRAINT `hotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`hotelID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentinfo`
--

LOCK TABLES `commentinfo` WRITE;
/*!40000 ALTER TABLE `commentinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `commentinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditrecord`
--

DROP TABLE IF EXISTS `creditrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditrecord` (
  `creditRecordID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userID` varchar(10) DEFAULT NULL,
  `changeType` tinyint(4) DEFAULT NULL,
  `reasonType` tinyint(4) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`creditRecordID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditrecord`
--

LOCK TABLES `creditrecord` WRITE;
/*!40000 ALTER TABLE `creditrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `hotelID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `region` int(10) unsigned NOT NULL,
  `introduction` varchar(200) DEFAULT NULL,
  `star` tinyint(4) DEFAULT NULL,
  `environment1` varchar(50) DEFAULT NULL,
  `environment2` varchar(50) DEFAULT NULL,
  `environment3` varchar(50) DEFAULT NULL,
  `facility` varchar(200) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`hotelID`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'如家连锁酒店','13 Nanjing Rd.',1,'a very expensive hotel',3,'NOPIC','NOPIC','NOPIC','feel like living in your own home, but a little bit noisy',3),(2,'７天连锁酒店','120 Nanjing Rd.',1,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(3,'君悦大酒店','648 Nanjing Rd.',1,'a holy-expensive hotel, built in 1900',5,'NOPIC','NOPIC','NOPIC','we call it royal, what else can you imagine?',5),(4,'格林豪泰连锁酒店','1 Yunnan Rd.',1,'a fundamentally equipped hotel, and the service is of standard',2,'NOPIC','NOPIC','NOPIC','basically equipped, standardized service provided',4),(5,'７天连锁酒店','100 Tianyaoqiao Rd.',2,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(6,'君悦大酒店','648 Tianyaoqiao Rd.',2,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(7,'格林豪泰连锁酒店','123 S. Wanping Rd.',2,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(8,'７天连锁酒店','120 Zhaojiabang Rd.',2,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(9,'希尔顿酒店','6610 W. Nanjing Rd.',3,'a holy-expensive hotel, never try without a moderate wallet',5,'NOPIC','NOPIC','NOPIC','maybe the most fantastic furnish in Shanghai',4),(10,'汉庭连锁酒店','800 W. Nanjing Rd.',3,'a very cheap chain hotel',2,'NOPIC','NOPIC','NOPIC','best choice for tourists from nearby cities',5),(11,'７天连锁酒店','100 Tianyaoqiao Rd.',4,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(12,'君悦大酒店','648 Tianyaoqiao Rd.',4,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(13,'格林豪泰连锁酒店','123 S. Wanping Rd.',4,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(14,'７天连锁酒店','120 Zhaojiabang Rd.',4,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(15,'格林豪泰连锁酒店','100 Tianyaoqiao Rd.',5,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(16,'君悦大酒店','648 Tianyaoqiao Rd.',5,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(17,'速８连锁酒店','123 S. Wanping Rd.',5,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(18,'７天连锁酒店','120 Zhaojiabang Rd.',5,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(19,'速８连锁酒店','100 Tianyaoqiao Rd.',6,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(20,'君悦大酒店','648 Tianyaoqiao Rd.',6,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(21,'格林豪泰连锁酒店','123 S. Wanping Rd.',6,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(22,'希尔顿酒店','120 Zhaojiabang Rd.',6,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(23,'７天连锁酒店','100 Tianyaoqiao Rd.',7,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(24,'希尔顿酒店','648 Tianyaoqiao Rd.',7,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(25,'格林豪泰连锁酒店','123 S. Wanping Rd.',7,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(26,'７天连锁酒店','120 Zhaojiabang Rd.',7,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',5),(27,'７天连锁酒店','100 Tianyaoqiao Rd.',8,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(28,'君悦大酒店','648 Tianyaoqiao Rd.',8,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(29,'速８连锁酒店','123 S. Wanping Rd.',8,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(30,'希尔顿酒店','120 Zhaojiabang Rd.',8,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(31,'７天连锁酒店','100 Tianyaoqiao Rd.',9,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(32,'希尔顿酒店','648 Tianyaoqiao Rd.',9,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(33,'格林豪泰连锁酒店','123 S. Wanping Rd.',9,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(34,'７天连锁酒店','120 Zhaojiabang Rd.',9,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(35,'７天连锁酒店','100 Tianyaoqiao Rd.',10,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(36,'君悦大酒店','648 Tianyaoqiao Rd.',10,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(37,'格林豪泰连锁酒店','123 S. Wanping Rd.',10,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(38,'７天连锁酒店','120 Zhaojiabang Rd.',10,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',5),(39,'格林豪泰连锁酒店','100 Tianyaoqiao Rd.',11,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(40,'君悦大酒店','648 Tianyaoqiao Rd.',11,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(41,'速８连锁酒店','123 S. Wanping Rd.',11,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(42,'７天连锁酒店','120 Zhaojiabang Rd.',11,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(43,'速８连锁酒店','100 Tianyaoqiao Rd.',12,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',5),(44,'君悦大酒店','648 Tianyaoqiao Rd.',12,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(45,'格林豪泰连锁酒店','123 S. Wanping Rd.',12,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(46,'希尔顿酒店','120 Zhaojiabang Rd.',12,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(47,'７天连锁酒店','100 Tianyaoqiao Rd.',13,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(48,'希尔顿酒店','648 Tianyaoqiao Rd.',13,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(49,'格林豪泰连锁酒店','123 S. Wanping Rd.',13,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',5),(50,'７天连锁酒店','120 Zhaojiabang Rd.',13,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(51,'７天连锁酒店','100 Tianyaoqiao Rd.',14,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(52,'君悦大酒店','648 Tianyaoqiao Rd.',14,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(53,'速８连锁酒店','123 S. Wanping Rd.',14,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(54,'希尔顿酒店','120 Zhaojiabang Rd.',14,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(55,'７天连锁酒店','100 Tianyaoqiao Rd.',15,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(56,'希尔顿酒店','648 Tianyaoqiao Rd.',15,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(57,'格林豪泰连锁酒店','123 S. Wanping Rd.',15,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(58,'７天连锁酒店','120 Zhaojiabang Rd.',15,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',5),(59,'７天连锁酒店','100 Tianyaoqiao Rd.',16,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(60,'君悦大酒店','648 Tianyaoqiao Rd.',16,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(61,'格林豪泰连锁酒店','123 S. Wanping Rd.',16,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(62,'７天连锁酒店','120 Zhaojiabang Rd.',16,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(63,'格林豪泰连锁酒店','100 Tianyaoqiao Rd.',17,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(64,'君悦大酒店','648 Tianyaoqiao Rd.',17,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(65,'速８连锁酒店','123 S. Wanping Rd.',17,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(66,'７天连锁酒店','120 Zhaojiabang Rd.',17,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(67,'速８连锁酒店','100 Tianyaoqiao Rd.',18,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(68,'君悦大酒店','648 Tianyaoqiao Rd.',18,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(69,'格林豪泰连锁酒店','123 S. Wanping Rd.',18,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(70,'希尔顿酒店','120 Zhaojiabang Rd.',18,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(71,'７天连锁酒店','100 Tianyaoqiao Rd.',19,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',5),(72,'希尔顿酒店','648 Tianyaoqiao Rd.',19,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(73,'格林豪泰连锁酒店','123 S. Wanping Rd.',19,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(74,'７天连锁酒店','120 Zhaojiabang Rd.',19,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(75,'７天连锁酒店','100 Tianyaoqiao Rd.',20,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(76,'君悦大酒店','648 Tianyaoqiao Rd.',20,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(77,'速８连锁酒店','123 S. Wanping Rd.',20,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(78,'希尔顿酒店','120 Zhaojiabang Rd.',20,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',5),(79,'７天连锁酒店','100 Tianyaoqiao Rd.',21,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(80,'希尔顿酒店','648 Tianyaoqiao Rd.',21,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(81,'格林豪泰连锁酒店','123 S. Wanping Rd.',21,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(82,'７天连锁酒店','120 Zhaojiabang Rd.',21,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(83,'７天连锁酒店','100 Tianyaoqiao Rd.',22,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(84,'君悦大酒店','648 Tianyaoqiao Rd.',22,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(85,'格林豪泰连锁酒店','123 S. Wanping Rd.',22,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(86,'７天连锁酒店','120 Zhaojiabang Rd.',22,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',5),(87,'格林豪泰连锁酒店','100 Tianyaoqiao Rd.',23,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(88,'君悦大酒店','648 Tianyaoqiao Rd.',23,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(89,'速８连锁酒店','123 S. Wanping Rd.',23,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(90,'７天连锁酒店','120 Zhaojiabang Rd.',23,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(91,'速８连锁酒店','100 Tianyaoqiao Rd.',24,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(92,'君悦大酒店','648 Tianyaoqiao Rd.',24,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(93,'格林豪泰连锁酒店','123 S. Wanping Rd.',24,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(94,'希尔顿酒店','120 Zhaojiabang Rd.',24,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(95,'７天连锁酒店','100 Tianyaoqiao Rd.',25,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',5),(96,'希尔顿酒店','648 Tianyaoqiao Rd.',25,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(97,'格林豪泰连锁酒店','123 S. Wanping Rd.',25,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(98,'７天连锁酒店','120 Zhaojiabang Rd.',25,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(99,'７天连锁酒店','100 Tianyaoqiao Rd.',26,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(100,'君悦大酒店','648 Tianyaoqiao Rd.',26,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(101,'速８连锁酒店','123 S. Wanping Rd.',26,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(102,'希尔顿酒店','120 Zhaojiabang Rd.',26,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(103,'７天连锁酒店','100 Tianyaoqiao Rd.',27,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',3),(104,'希尔顿酒店','648 Tianyaoqiao Rd.',27,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(105,'格林豪泰连锁酒店','123 S. Wanping Rd.',27,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(106,'７天连锁酒店','120 Zhaojiabang Rd.',27,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',5),(107,'速８连锁酒店','100 Tianyaoqiao Rd.',28,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',5),(108,'君悦大酒店','648 Tianyaoqiao Rd.',28,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(109,'格林豪泰连锁酒店','123 S. Wanping Rd.',28,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',3),(110,'希尔顿酒店','120 Zhaojiabang Rd.',28,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',3),(111,'７天连锁酒店','100 Tianyaoqiao Rd.',29,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',5),(112,'希尔顿酒店','648 Tianyaoqiao Rd.',29,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(113,'格林豪泰连锁酒店','123 S. Wanping Rd.',29,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(114,'７天连锁酒店','120 Zhaojiabang Rd.',29,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(115,'７天连锁酒店','100 Tianyaoqiao Rd.',30,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(116,'君悦大酒店','648 Tianyaoqiao Rd.',30,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(117,'速８连锁酒店','123 S. Wanping Rd.',30,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(118,'希尔顿酒店','120 Zhaojiabang Rd.',30,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(119,'７天连锁酒店','100 Tianyaoqiao Rd.',31,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(120,'希尔顿酒店','648 Tianyaoqiao Rd.',31,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(121,'格林豪泰连锁酒店','123 S. Wanping Rd.',31,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',5),(122,'７天连锁酒店','120 Zhaojiabang Rd.',31,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(123,'７天连锁酒店','100 Tianyaoqiao Rd.',32,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',5),(124,'君悦大酒店','648 Tianyaoqiao Rd.',32,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(125,'格林豪泰连锁酒店','123 S. Wanping Rd.',32,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(126,'７天连锁酒店','120 Zhaojiabang Rd.',32,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(127,'格林豪泰连锁酒店','100 Tianyaoqiao Rd.',33,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',3),(128,'君悦大酒店','648 Tianyaoqiao Rd.',33,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(129,'速８连锁酒店','123 S. Wanping Rd.',33,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(130,'７天连锁酒店','120 Zhaojiabang Rd.',33,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',4),(131,'速８连锁酒店','100 Tianyaoqiao Rd.',34,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(132,'君悦大酒店','648 Tianyaoqiao Rd.',34,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(133,'格林豪泰连锁酒店','123 S. Wanping Rd.',34,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4),(134,'希尔顿酒店','120 Zhaojiabang Rd.',34,'a very cheap hotel',3,'NOPIC','NOPIC','NOPIC','good enough, but a little bit noisy',5),(135,'７天连锁酒店','100 Tianyaoqiao Rd.',35,'a secret garden hidden inside of the downtown',3,'NOPIC','NOPIC','NOPIC','environment is not good',2),(136,'希尔顿酒店','648 Tianyaoqiao Rd.',35,'a holy-expensive hotel, built in 2016, symbolize the life of the rich',5,'NOPIC','NOPIC','NOPIC','everything is perfect except the traffic',4),(137,'格林豪泰连锁酒店','123 S. Wanping Rd.',35,'a very cheap chain hotel',3,'NOPIC','NOPIC','NOPIC','maybe the service here is better than other chains',4);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotelpromotion`
--

DROP TABLE IF EXISTS `hotelpromotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotelpromotion` (
  `hotelPromotionID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotelID` int(10) unsigned NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `content` varchar(30) DEFAULT NULL,
  `startDate` date DEFAULT '2000-01-01',
  `endDate` date DEFAULT '2030-01-01',
  `minRankAvailable` int(11) DEFAULT '1',
  `maxRankAvailable` int(11) DEFAULT '10',
  PRIMARY KEY (`hotelPromotionID`),
  KEY `promotionOfHotelID_idx` (`hotelID`),
  CONSTRAINT `promotionOfHotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`hotelID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotelpromotion`
--

LOCK TABLES `hotelpromotion` WRITE;
/*!40000 ALTER TABLE `hotelpromotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotelpromotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlist`
--

DROP TABLE IF EXISTS `orderlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderlist` (
  `orderID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `generateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cancelTime` datetime DEFAULT NULL,
  `executeDDL` datetime DEFAULT NULL,
  `hotelID` int(10) unsigned NOT NULL,
  `orderState` tinyint(4) DEFAULT NULL,
  `checkinTime` datetime DEFAULT NULL,
  `checkoutTime` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `hasChild` tinyint(4) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `orderOfHotelID_idx` (`hotelID`),
  CONSTRAINT `orderOfHotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`hotelID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlist`
--

LOCK TABLES `orderlist` WRITE;
/*!40000 ALTER TABLE `orderlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `regionID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `province` varchar(30) DEFAULT NULL,
  `town` varchar(30) DEFAULT NULL,
  `regionName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`regionID`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'上海','上海','南京路'),(2,'上海','上海','徐家汇'),(3,'上海','上海','静安寺'),(4,'上海','上海','淮海路'),(5,'上海','上海','陆家嘴'),(6,'浙江','杭州','武林'),(7,'浙江','杭州','湖滨'),(8,'浙江','杭州','钱江新城'),(9,'浙江','杭州','城西'),(10,'江苏','苏州','观前'),(11,'江苏','苏州','石路'),(12,'江苏','苏州','平江新城'),(13,'江苏','苏州','吴中'),(14,'江苏','南京','新街口'),(15,'江苏','南京','湖南路'),(16,'江苏','南京','夫子庙'),(17,'江苏','南京','中央门'),(18,'浙江','宁波','天一'),(19,'浙江','宁波','城隍庙'),(20,'浙江','宁波','鼓楼步行街'),(21,'湖北','武汉','江汉路'),(22,'湖北','武汉','中央文化区'),(23,'湖北','武汉','武广'),(24,'福建','厦门','中山路'),(25,'湖南','长沙','五一'),(26,'湖南','长沙','溁湾镇'),(27,'广东','广州','天河中心'),(28,'广东','广州','上下九'),(29,'广东','广州','北京路'),(30,'广东','深圳','华侨城'),(31,'广东','深圳','东门'),(32,'广东','深圳','南山'),(33,'广东','深圳','龙岗'),(34,'重庆','重庆','解放碑'),(35,'重庆','重庆','沙坪坝');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roominfo`
--

DROP TABLE IF EXISTS `roominfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roominfo` (
  `roomInfoID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotelID` int(10) unsigned NOT NULL,
  `roomID` varchar(10) DEFAULT NULL,
  `roomType` varchar(30) DEFAULT NULL,
  `roomPrice` int(11) DEFAULT NULL,
  `roomState` tinyint(4) DEFAULT NULL,
  `detailedInfo1` datetime DEFAULT NULL,
  `detailedInfo2` datetime DEFAULT NULL,
  PRIMARY KEY (`roomInfoID`),
  KEY `hotelID_idx` (`hotelID`),
  KEY `hotelID_idx2` (`hotelID`),
  CONSTRAINT `roomOfHotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`hotelID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roominfo`
--

LOCK TABLES `roominfo` WRITE;
/*!40000 ALTER TABLE `roominfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `roominfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` varchar(10) DEFAULT NULL,
  `accountName` varchar(30) DEFAULT 'User',
  `password` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT 'User',
  `contact` varchar(30) DEFAULT NULL,
  `portrait` varchar(50) DEFAULT NULL,
  `creditValue` bigint(20) DEFAULT NULL,
  `memberType` tinyint(4) DEFAULT NULL,
  `memberInfo` varchar(30) DEFAULT NULL,
  `rank` smallint(6) DEFAULT NULL,
  `hotelID` int(10) unsigned NOT NULL,
  `workID` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webpromotion`
--

DROP TABLE IF EXISTS `webpromotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webpromotion` (
  `webPromotionID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `webPromotionType` tinyint(4) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `startDate` date DEFAULT '2000-01-01',
  `endDate` date DEFAULT '2050-01-01',
  `minRankAvailable` int(11) DEFAULT '1',
  `maxRankAvailable` int(11) DEFAULT '10',
  `regionAvailableList` varchar(3003) DEFAULT '000',
  PRIMARY KEY (`webPromotionID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webpromotion`
--

LOCK TABLES `webpromotion` WRITE;
/*!40000 ALTER TABLE `webpromotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `webpromotion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-01  1:50:39
