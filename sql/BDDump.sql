CREATE DATABASE  IF NOT EXISTS `sat` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sat`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: sat
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `items` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'table',5,5),(2,'carParts',20,4),(3,'computers',500,3),(4,'mobilePhone',700,1),(5,'humanOrgans',1000,1),(6,'tv',800,2),(7,'clother',30,1),(8,'sexToys',50,1),(9,'guitars',300,1),(10,'pils',40,1),(11,'drugs',100,1),(12,'wepons',1000,10),(13,'bullets',3,2),(14,'musicDisk',4,1),(15,'programmers',750,3),(16,'candies',1,2),(17,'batteries',2,1),(18,'alcohol',15,10),(19,'instruments',45,15),(20,'notebook',900,2),(21,'hardDisk',40,1),(22,'food',3,7),(23,'cable',2,2),(24,'boat',150,10),(25,'mummy',850,6),(26,'bag',60,3),(27,'footwear',90,2),(28,'tshort',5,1),(29,'bigBox',450,25),(30,'littleBox',220,12);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stocks` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocks`
--

LOCK TABLES `stocks` WRITE;
/*!40000 ALTER TABLE `stocks` DISABLE KEYS */;
INSERT INTO `stocks` VALUES (1,'FirstLittleStock'),(2,'FirstMediumStock'),(3,'FirstBigStock'),(4,'SecondLittleStock'),(5,'SecondMediumStock'),(6,'SecondBigStock'),(7,'ThirdLittleStock'),(8,'ThirdMediumStock'),(9,'ThirdBigStock'),(10,'4tfLittleStock');
/*!40000 ALTER TABLE `stocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocks_has_items`
--

DROP TABLE IF EXISTS `stocks_has_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stocks_has_items` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stocks_id` int(10) unsigned NOT NULL,
  `items_id` int(10) unsigned NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`,`stocks_id`,`items_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_stocks_has_items_items1_idx` (`items_id`),
  KEY `fk_stocks_has_items_stocks1_idx` (`stocks_id`),
  CONSTRAINT `fk_stocks_has_items_items1` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`),
  CONSTRAINT `fk_stocks_has_items_stocks1` FOREIGN KEY (`stocks_id`) REFERENCES `stocks` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocks_has_items`
--

LOCK TABLES `stocks_has_items` WRITE;
/*!40000 ALTER TABLE `stocks_has_items` DISABLE KEYS */;
INSERT INTO `stocks_has_items` VALUES (1,1,1,34),(2,1,2,133),(3,1,3,73),(4,1,4,14),(5,1,5,0),(6,1,6,0),(7,1,7,0),(8,1,8,0),(9,1,9,0),(10,1,10,0),(11,1,11,0),(12,1,12,0),(13,1,13,0),(14,1,14,0),(15,1,15,0),(16,1,16,0),(17,1,17,0),(18,1,18,0),(19,1,19,0),(20,1,20,0),(21,1,21,0),(22,1,22,0),(23,1,23,0),(24,1,24,0),(25,1,25,0),(26,1,26,0),(27,1,27,0),(28,1,28,0),(29,1,29,0),(30,1,30,0),(31,2,1,0),(32,2,2,0),(33,2,3,0),(34,2,4,0),(35,2,5,0),(36,2,6,0),(37,2,7,0),(38,2,8,0),(39,2,9,0),(40,2,10,0),(41,2,11,0),(42,2,12,0),(43,2,13,0),(44,2,14,0),(45,2,15,0),(46,2,16,0),(47,2,17,0),(48,2,18,0),(49,2,19,0),(50,2,20,0),(51,2,21,0),(52,2,22,0),(53,2,23,0),(54,2,24,0),(55,2,25,0),(56,2,26,0),(57,2,27,0),(58,2,28,0),(59,2,29,0),(60,2,30,0),(61,3,1,0),(62,3,2,0),(63,3,3,0),(64,3,4,0),(65,3,5,0),(66,3,6,0),(67,3,7,0),(68,3,8,0),(69,3,9,0),(70,3,10,0),(71,3,11,0),(72,3,12,0),(73,3,13,0),(74,3,14,0),(75,3,15,0),(76,3,16,0),(77,3,17,0),(78,3,18,0),(79,3,19,0),(80,3,20,0),(81,3,21,0),(82,3,22,0),(83,3,23,0),(84,3,24,0),(85,3,25,0),(86,3,26,0),(87,3,27,0),(88,3,28,0),(89,3,29,0),(90,3,30,0),(91,4,1,0),(92,4,2,0),(93,4,3,0),(94,4,4,0),(95,4,5,0),(96,4,6,0),(97,4,7,0),(98,4,8,0),(99,4,9,0),(100,4,10,0),(101,4,11,0),(102,4,12,0),(103,4,13,0),(104,4,14,0),(105,4,15,0),(106,4,16,0),(107,4,17,0),(108,4,18,0),(109,4,19,0),(110,4,20,0),(111,4,21,0),(112,4,22,0),(113,4,23,0),(114,4,24,0),(115,4,25,0),(116,4,26,0),(117,4,27,0),(118,4,28,0),(119,4,29,0),(120,4,30,0),(121,5,1,0),(122,5,2,0),(123,5,3,0),(124,5,4,0),(125,5,5,0),(126,5,6,0),(127,5,7,0),(128,5,8,0),(129,5,9,0),(130,5,10,0),(131,5,11,0),(132,5,12,0),(133,5,13,0),(134,5,14,0),(135,5,15,0),(136,5,16,0),(137,5,17,0),(138,5,18,0),(139,5,19,0),(140,5,20,0),(141,5,21,0),(142,5,22,0),(143,5,23,0),(144,5,24,0),(145,5,25,0),(146,5,26,0),(147,5,27,0),(148,5,28,0),(149,5,29,0),(150,5,30,0),(151,6,1,0),(152,6,2,0),(153,6,3,0),(154,6,4,0),(155,6,5,0),(156,6,6,0),(157,6,7,0),(158,6,8,0),(159,6,9,0),(160,6,10,0),(161,6,11,0),(162,6,12,0),(163,6,13,0),(164,6,14,0),(165,6,15,0),(166,6,16,0),(167,6,17,0),(168,6,18,0),(169,6,19,0),(170,6,20,0),(171,6,21,0),(172,6,22,0),(173,6,23,0),(174,6,24,0),(175,6,25,0),(176,6,26,0),(177,6,27,0),(178,6,28,0),(179,6,29,0),(180,6,30,0),(181,7,1,0),(182,7,2,0),(183,7,3,0),(184,7,4,0),(185,7,5,0),(186,7,6,0),(187,7,7,0),(188,7,8,0),(189,7,9,0),(190,7,10,0),(191,7,11,0),(192,7,12,0),(193,7,13,0),(194,7,14,0),(195,7,15,0),(196,7,16,0),(197,7,17,0),(198,7,18,0),(199,7,19,0),(200,7,20,0),(201,7,21,0),(202,7,22,0),(203,7,23,0),(204,7,24,0),(205,7,25,0),(206,7,26,0),(207,7,27,0),(208,7,28,0),(209,7,29,0),(210,7,30,0),(211,8,1,0),(212,8,2,0),(213,8,3,0),(214,8,4,0),(215,8,5,0),(216,8,6,0),(217,8,7,0),(218,8,8,0),(219,8,9,0),(220,8,10,0),(221,8,11,0),(222,8,12,0),(223,8,13,0),(224,8,14,0),(225,8,15,0),(226,8,16,0),(227,8,17,0),(228,8,18,0),(229,8,19,0),(230,8,20,0),(231,8,21,0),(232,8,22,0),(233,8,23,0),(234,8,24,0),(235,8,25,0),(236,8,26,0),(237,8,27,0),(238,8,28,0),(239,8,29,0),(240,8,30,0),(241,9,1,0),(242,9,2,0),(243,9,3,0),(244,9,4,0),(245,9,5,0),(246,9,6,0),(247,9,7,0),(248,9,8,0),(249,9,9,0),(250,9,10,0),(251,9,11,0),(252,9,12,0),(253,9,13,0),(254,9,14,0),(255,9,15,0),(256,9,16,0),(257,9,17,0),(258,9,18,0),(259,9,19,0),(260,9,20,0),(261,9,21,0),(262,9,22,0),(263,9,23,0),(264,9,24,0),(265,9,25,0),(266,9,26,0),(267,9,27,0),(268,9,28,0),(269,9,29,0),(270,9,30,0),(271,10,1,0),(272,10,2,0),(273,10,3,0),(274,10,4,0),(275,10,5,0),(276,10,6,0),(277,10,7,0),(278,10,8,0),(279,10,9,0),(280,10,10,0),(281,10,11,0),(282,10,12,0),(283,10,13,0),(284,10,14,0),(285,10,15,0),(286,10,16,0),(287,10,17,0),(288,10,18,0),(289,10,19,0),(290,10,20,0),(291,10,21,0),(292,10,22,0),(293,10,23,0),(294,10,24,0),(295,10,25,0),(296,10,26,0),(297,10,27,0),(298,10,28,0),(299,10,29,0),(300,10,30,0);
/*!40000 ALTER TABLE `stocks_has_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracks`
--

DROP TABLE IF EXISTS `tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tracks` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transport_id` int(10) unsigned NOT NULL,
  `color` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Tracks_transport1_idx` (`transport_id`),
  CONSTRAINT `fk_Tracks_transport1` FOREIGN KEY (`transport_id`) REFERENCES `transport` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracks`
--

LOCK TABLES `tracks` WRITE;
/*!40000 ALTER TABLE `tracks` DISABLE KEYS */;
INSERT INTO `tracks` VALUES (1,1,'green'),(2,3,'red'),(3,4,'white');
/*!40000 ALTER TABLE `tracks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trains`
--

DROP TABLE IF EXISTS `trains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trains` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transport_id` int(10) unsigned NOT NULL,
  `number_of_wagons` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Trains_transport1_idx` (`transport_id`),
  CONSTRAINT `fk_Trains_transport1` FOREIGN KEY (`transport_id`) REFERENCES `transport` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trains`
--

LOCK TABLES `trains` WRITE;
/*!40000 ALTER TABLE `trains` DISABLE KEYS */;
INSERT INTO `trains` VALUES (1,2,'20'),(2,5,'10');
/*!40000 ALTER TABLE `trains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transport` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `max_сarrying_сapacity` int(11) NOT NULL,
  `types_of_transports_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tracks_types_of_transports1_idx` (`types_of_transports_id`),
  CONSTRAINT `fk_tracks_types_of_transports1` FOREIGN KEY (`types_of_transports_id`) REFERENCES `types_of_transports` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport`
--

LOCK TABLES `transport` WRITE;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
INSERT INTO `transport` VALUES (1,'mb_actros',20,1),(2,'train_name',200,2),(3,'gezel',5,1),(4,'mini_gezel',3,1),(5,'little_train',50,2);
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types_of_transports`
--

DROP TABLE IF EXISTS `types_of_transports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `types_of_transports` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types_of_transports`
--

LOCK TABLES `types_of_transports` WRITE;
/*!40000 ALTER TABLE `types_of_transports` DISABLE KEYS */;
INSERT INTO `types_of_transports` VALUES (1,'auto'),(2,'train'),(3,'all');
/*!40000 ALTER TABLE `types_of_transports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types_of_transports_has_stocks`
--

DROP TABLE IF EXISTS `types_of_transports_has_stocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `types_of_transports_has_stocks` (
  `types_of_transports_id` int(10) unsigned NOT NULL,
  `stocks_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`types_of_transports_id`,`stocks_id`),
  KEY `fk_types_of_transports_has_stocks_stocks1_idx` (`stocks_id`),
  KEY `fk_types_of_transports_has_stocks_types_of_transports1_idx` (`types_of_transports_id`),
  CONSTRAINT `fk_types_of_transports_has_stocks_stocks1` FOREIGN KEY (`stocks_id`) REFERENCES `stocks` (`id`),
  CONSTRAINT `fk_types_of_transports_has_stocks_types_of_transports1` FOREIGN KEY (`types_of_transports_id`) REFERENCES `types_of_transports` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types_of_transports_has_stocks`
--

LOCK TABLES `types_of_transports_has_stocks` WRITE;
/*!40000 ALTER TABLE `types_of_transports_has_stocks` DISABLE KEYS */;
INSERT INTO `types_of_transports_has_stocks` VALUES (1,1),(2,1),(1,2),(1,3),(2,4),(1,5),(1,6),(1,7),(2,7),(1,8),(2,8),(2,9),(1,10);
/*!40000 ALTER TABLE `types_of_transports_has_stocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sat'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-19 10:29:50
