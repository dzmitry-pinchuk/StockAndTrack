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
) ENGINE=InnoDB AUTO_INCREMENT=3542 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocks_has_items`
--

LOCK TABLES `stocks_has_items` WRITE;
/*!40000 ALTER TABLE `stocks_has_items` DISABLE KEYS */;
INSERT INTO `stocks_has_items` VALUES (1,1,1,34),(2,1,2,133),(4,1,4,1),(5,1,5,4),(6,1,6,5),(7,1,7,11),(11,1,11,1),(12,1,12,57),(13,1,13,52),(14,1,14,1),(16,1,16,4),(17,1,17,1),(18,1,18,7),(19,1,19,4),(20,1,20,5),(21,1,21,4),(22,1,22,4),(23,1,23,2),(24,1,24,8),(25,1,25,1),(26,1,26,1),(27,1,27,4),(28,1,28,3),(29,1,29,1),(30,1,30,5),(31,2,1,8),(32,2,2,3),(33,2,3,2),(34,2,4,13),(35,2,5,16),(36,2,6,17),(37,2,7,7),(38,2,8,8),(39,2,9,2),(40,2,10,6),(41,2,11,13),(42,2,12,6),(43,2,13,8),(44,2,14,6),(45,2,15,12),(46,2,16,3),(47,2,17,1),(48,2,18,5),(49,2,19,7),(50,2,20,17),(51,2,21,10),(52,2,22,5),(53,2,23,3),(54,2,24,2),(55,2,25,13),(56,2,26,7),(57,2,27,16),(58,2,28,9),(59,2,29,8),(60,2,30,5),(70,3,10,2),(71,3,11,7),(72,3,12,2),(73,3,13,8),(74,3,14,3),(75,3,15,8),(76,3,16,2),(77,3,17,88),(78,3,18,26),(81,3,21,36),(82,3,22,9),(83,3,23,2),(84,3,24,6),(85,3,25,90),(86,3,26,2),(91,4,1,485),(92,4,2,24),(93,4,3,8),(96,4,6,2),(97,4,7,8),(98,4,8,4),(99,4,9,247),(100,4,10,8),(101,4,11,35),(102,4,12,7),(103,4,13,57),(104,4,14,6),(105,4,15,9),(106,4,16,6),(107,4,17,3),(108,4,18,2),(109,4,19,4),(110,4,20,7),(116,4,26,36),(117,4,27,8),(118,4,28,2),(119,4,29,89),(120,4,30,3),(121,5,1,14),(122,5,2,9),(123,5,3,5),(124,5,4,2),(125,5,5,6),(126,5,6,8),(127,5,7,9),(128,5,8,87),(129,5,9,6),(130,5,10,7),(138,5,18,3),(139,5,19,7),(140,5,20,9),(141,5,21,3),(142,5,22,4),(143,5,23,2),(151,6,1,4),(152,6,2,8),(153,6,3,3),(157,6,7,2),(158,6,8,4),(159,6,9,7),(160,6,10,9),(161,6,11,9),(162,6,12,7),(163,6,13,6),(164,6,14,4),(165,6,15,3),(166,6,16,33),(167,6,17,2),(168,6,18,3456),(169,6,19,7),(170,6,20,8),(171,6,21,3),(172,6,22,444),(173,6,23,5),(174,6,24,7),(175,6,25,7778),(176,6,26,85),(183,7,3,874),(184,7,4,24),(185,7,5,7),(186,7,6,9),(187,7,7,25),(188,7,8,76),(189,7,9,24),(190,7,10,735),(191,7,11,2),(192,7,12,7),(193,7,13,8),(210,7,30,37),(211,8,1,864),(212,8,2,34),(213,8,3,7),(214,8,4,53),(215,8,5,87),(216,8,6,35),(217,8,7,7),(218,8,8,5),(219,8,9,34),(220,8,10,23),(221,8,11,6),(222,8,12,7),(223,8,13,537),(224,8,14,864),(233,8,23,357),(234,8,24,2),(235,8,25,6),(236,8,26,8),(237,8,27,9),(238,8,28,1),(239,8,29,1),(240,8,30,1),(241,9,1,1),(242,9,2,356),(243,9,3,75),(244,9,4,342),(245,9,5,245),(246,9,6,8),(247,9,7,6),(248,9,8,96),(249,9,9,35),(250,9,10,57),(251,9,11,46),(252,9,12,3),(259,9,19,246),(260,9,20,236),(261,9,21,15),(262,9,22,235),(264,9,24,976),(265,9,25,347),(266,9,26,37),(267,9,27,3),(268,9,28,315),(269,9,29,3),(270,9,30,6),(271,10,1,6),(272,10,2,7),(273,10,3,8),(274,10,4,3),(275,10,5,9),(276,10,6,3),(277,10,7,3),(299,10,29,246),(300,10,30,358);
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

-- Dump completed on 2018-08-23 12:32:02
