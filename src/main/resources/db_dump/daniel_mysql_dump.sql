-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: daniel
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `input_device`
--

DROP TABLE IF EXISTS `input_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `input_device` (
  `id` int NOT NULL,
  `input_type` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `input_device_name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `input_device`
--

LOCK TABLES `input_device` WRITE;
/*!40000 ALTER TABLE `input_device` DISABLE KEYS */;
INSERT INTO `input_device` VALUES (10,'sensor','DHT11'),(20,'relay','przekaznik'),(30,'plc','sterownik_PLC'),(40,'diode','dioda'),(50,'sensor','DS1820');
/*!40000 ALTER TABLE `input_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `params_map`
--

DROP TABLE IF EXISTS `params_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `params_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `input_device_id` int NOT NULL,
  `unit_input_id` int NOT NULL,
  `rw` varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `index` int NOT NULL,
  `active` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `params_map_unit_input_FK` (`unit_input_id`),
  CONSTRAINT `params_map_unit_input_FK` FOREIGN KEY (`unit_input_id`) REFERENCES `unit_input` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `params_map`
--

LOCK TABLES `params_map` WRITE;
/*!40000 ALTER TABLE `params_map` DISABLE KEYS */;
INSERT INTO `params_map` VALUES (1,30,23,'r',10,'true','Licznik pojemników'),(2,30,23,'rw',11,'true','Stan pracy pompy'),(3,30,23,'r',12,'true','Waga'),(4,30,23,'r',13,'true','Temperatura cieczy'),(5,30,23,'r',14,'true','Przepływ'),(6,30,23,'rw',15,'true','Wzmocnienie Kp'),(7,30,23,'rw',16,'true','Czas zdwojenia Ti'),(8,30,23,'rw',17,'true','Czas wyprzedzenia Td'),(9,30,23,'r',18,'true','Stan pracy linii'),(10,30,23,'r',19,'true','Położenie nalewaka'),(11,30,23,'r',20,'false',NULL),(12,30,23,'r',21,'false','Testowy'),(13,30,23,'r',22,'false','Testowy2');
/*!40000 ALTER TABLE `params_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readings`
--

DROP TABLE IF EXISTS `readings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `readings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit_id` int NOT NULL,
  `unit_input_id` int NOT NULL,
  `value` int NOT NULL,
  `read_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `param_id` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `UnitInputId` (`unit_input_id`),
  KEY `unit_id` (`unit_id`),
  CONSTRAINT `readings_ibfk_1` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`net_ident`),
  CONSTRAINT `readings_ibfk_5` FOREIGN KEY (`unit_input_id`) REFERENCES `unit_input` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readings`
--

LOCK TABLES `readings` WRITE;
/*!40000 ALTER TABLE `readings` DISABLE KEYS */;
INSERT INTO `readings` VALUES (5,100,19,21,'2018-02-11 13:31:33',0),(8,101,20,22,'2018-02-11 13:33:52',0),(14,4,22,21,'2018-02-11 15:52:11',0),(15,4,22,21,'2018-02-11 15:57:11',0),(17,4,22,21,'2018-02-11 16:07:12',0),(18,4,22,21,'2018-02-11 16:12:12',0),(19,4,22,21,'2018-02-11 16:17:12',0),(20,4,22,21,'2018-02-11 16:22:13',0),(21,4,22,21,'2018-02-11 16:27:13',0),(22,4,22,22,'2018-02-11 16:32:13',0),(24,4,22,47,'2018-02-11 16:41:02',0),(25,4,22,36,'2018-02-11 16:42:03',0),(26,4,22,36,'2018-02-11 16:43:03',0),(27,4,22,36,'2018-02-11 16:44:03',0),(28,4,22,35,'2018-02-11 16:45:04',0),(29,4,22,35,'2018-02-11 16:46:04',0),(31,4,22,35,'2018-02-11 16:48:04',0),(32,4,22,35,'2018-02-11 16:49:05',0),(34,4,22,35,'2018-02-11 16:51:05',0),(35,4,22,35,'2018-02-11 16:52:05',0),(37,4,22,35,'2018-02-11 16:54:06',0),(38,4,22,34,'2018-02-11 16:55:06',0),(39,4,22,34,'2018-02-11 16:56:07',0),(40,4,22,34,'2018-02-11 16:57:07',0),(41,4,22,33,'2018-02-11 16:58:07',0),(43,4,22,33,'2018-02-11 17:00:08',0),(44,4,22,33,'2018-02-11 17:01:08',0),(46,4,22,33,'2018-02-11 17:03:09',0),(47,4,22,32,'2018-02-11 17:04:09',0),(49,4,22,32,'2018-02-11 17:06:09',0),(50,4,22,32,'2018-02-11 17:07:10',0),(52,4,22,31,'2018-02-11 17:09:10',0),(53,4,22,31,'2018-02-11 17:10:11',0),(54,4,22,31,'2018-02-11 17:11:11',0),(55,4,22,31,'2018-02-11 17:12:11',0),(56,4,22,30,'2018-02-11 17:13:11',0),(58,4,22,30,'2018-02-11 17:15:12',0),(59,4,22,30,'2018-02-11 17:16:12',0),(61,4,22,29,'2018-02-11 17:19:13',0),(62,4,22,29,'2018-02-11 17:20:13',0),(64,4,22,29,'2018-02-11 17:22:14',0),(65,4,22,29,'2018-08-13 18:00:44',0),(67,4,22,29,'2018-02-11 17:25:15',0),(68,4,22,29,'2018-02-11 17:26:15',0),(69,4,22,28,'2018-02-11 17:27:15',0),(70,4,22,28,'2018-02-11 17:28:16',0);
/*!40000 ALTER TABLE `readings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_type`
--

DROP TABLE IF EXISTS `request_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_type` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `request` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_type`
--

LOCK TABLES `request_type` WRITE;
/*!40000 ALTER TABLE `request_type` DISABLE KEYS */;
INSERT INTO `request_type` VALUES (0,'Wymuszenie odczytu'),(1,'Zmiana interwalu odczytu'),(2,'Polecenie odpytania rejestru sterownika'),(3,'Zapytanie o informacje konfiguracyjne'),(4,'Odczyt wszystkich rejestrow PLC'),(5,'Zapis do rejestru PLC'),(6,'Ustawienie aktywnych parametrów');
/*!40000 ALTER TABLE `request_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit_type` int NOT NULL,
  `net_ident` int NOT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `UnitType` (`unit_type`),
  KEY `net_ident` (`net_ident`),
  CONSTRAINT `unit_ibfk_1` FOREIGN KEY (`unit_type`) REFERENCES `unit_type` (`unit_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,1,100,'2018-02-11 13:06:12'),(2,1,101,'2018-02-11 13:32:57'),(3,1,2,'2018-02-11 14:17:48'),(4,1,4,'2018-02-11 14:23:22');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_input`
--

DROP TABLE IF EXISTS `unit_input`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_input` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit_net_ident` int NOT NULL,
  `input_type_id` int NOT NULL,
  `input_number` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Unit_net_ident` (`unit_net_ident`),
  KEY `InputTypeId` (`input_type_id`),
  KEY `InputNumber` (`input_number`),
  CONSTRAINT `unit_input_ibfk_2` FOREIGN KEY (`input_type_id`) REFERENCES `input_device` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_input`
--

LOCK TABLES `unit_input` WRITE;
/*!40000 ALTER TABLE `unit_input` DISABLE KEYS */;
INSERT INTO `unit_input` VALUES (19,100,10,1),(20,101,10,1),(21,2,10,1),(22,4,10,1),(23,4,30,2);
/*!40000 ALTER TABLE `unit_input` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_request`
--

DROP TABLE IF EXISTS `unit_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_request` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `unit_net_ident` int NOT NULL,
  `request_type` int NOT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `send_date` datetime DEFAULT NULL,
  `unit_input_id` int DEFAULT NULL,
  `value` int DEFAULT NULL,
  `register` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `unit_request_request_type_FK` (`request_type`),
  KEY `unit_req_unit` (`unit_net_ident`),
  CONSTRAINT `unit_req_unit` FOREIGN KEY (`unit_net_ident`) REFERENCES `unit` (`net_ident`),
  CONSTRAINT `unit_request_request_type_FK` FOREIGN KEY (`request_type`) REFERENCES `request_type` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_request`
--

LOCK TABLES `unit_request` WRITE;
/*!40000 ALTER TABLE `unit_request` DISABLE KEYS */;
INSERT INTO `unit_request` VALUES (2,4,0,'2017-11-30 21:22:10','2017-11-30 22:22:10',1,NULL,NULL),(3,4,1,'2017-11-30 21:22:10','2017-11-30 22:22:10',1,20,NULL),(4,4,0,'2017-11-30 21:22:43','2017-11-30 22:22:43',1,NULL,NULL),(10,2,1,'2018-02-11 14:21:51','2018-02-11 15:21:51',21,10,NULL),(11,4,1,'2018-02-11 14:24:54','2018-02-11 15:24:54',1,10,NULL),(12,4,0,'2018-02-11 14:25:27','2018-02-11 15:25:27',1,NULL,NULL),(13,4,0,'2018-02-11 14:25:27','2018-02-11 15:25:27',1,NULL,NULL),(14,4,0,'2018-02-11 14:33:07','2018-02-11 15:33:07',1,NULL,NULL),(15,4,1,'2018-02-11 14:34:16','2018-02-11 15:34:16',1,1,NULL),(16,4,1,'2018-02-11 15:47:47','2018-02-11 16:47:47',1,1,NULL),(17,4,1,'2018-02-11 15:53:08','2018-02-11 16:53:08',1,5,NULL),(24,4,1,'2018-03-17 18:20:23','2018-03-17 19:20:23',1,10,NULL),(25,4,1,'2018-03-17 18:20:24','2018-03-17 19:20:24',1,10,NULL),(26,4,1,'2018-03-17 18:20:24','2018-03-17 19:20:24',1,10,NULL),(29,4,1,'2018-03-17 18:20:24','2018-03-17 19:20:24',1,10,NULL),(30,4,0,'2018-03-17 18:20:24','2018-03-17 19:20:24',1,10,NULL),(31,4,0,'2018-03-17 18:20:24','2018-03-17 19:20:24',1,15,NULL),(32,100,0,'2018-03-17 18:20:24','2018-03-17 19:20:24',1,0,NULL),(33,101,1,'2018-03-17 18:20:24','2018-03-17 19:20:24',1,15,NULL),(34,4,1,'2018-03-17 18:21:01','2018-03-17 19:21:01',1,15,NULL),(39,4,1,'2018-03-17 18:22:15','2018-03-17 19:22:15',1,15,NULL),(50,4,0,'2018-03-17 18:23:42','2018-03-17 19:23:42',1,0,NULL),(51,4,0,'2018-05-13 16:05:49','2018-05-13 18:05:49',1,15,NULL),(52,100,0,'2018-05-13 16:05:50','2018-05-13 18:05:50',1,1,NULL),(53,2,0,'2018-05-13 16:05:50','2018-05-13 18:05:50',1,1,NULL),(59,100,0,'2018-08-11 19:02:56',NULL,1,0,NULL),(60,4,2,'2018-08-11 19:19:49',NULL,2,0,55),(61,100,4,'2018-08-11 20:57:36',NULL,1,0,0),(62,100,3,'2018-08-11 22:04:41',NULL,0,0,0),(63,100,6,'2018-08-11 22:05:05',NULL,0,0,0),(64,100,1,'2018-08-16 20:03:30',NULL,1,10,0);
/*!40000 ALTER TABLE `unit_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_type`
--

DROP TABLE IF EXISTS `unit_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_type` (
  `unit_type` int NOT NULL COMMENT 'typ urzadzenia',
  `unit_name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`unit_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_type`
--

LOCK TABLES `unit_type` WRITE;
/*!40000 ALTER TABLE `unit_type` DISABLE KEYS */;
INSERT INTO `unit_type` VALUES (1,'ESP8266'),(2,'STM');
/*!40000 ALTER TABLE `unit_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-14 19:04:25
