-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: otpremnastanicahib
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.27-MariaDB

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
-- Table structure for table `busotina`
--

DROP TABLE IF EXISTS `busotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busotina` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `aktivna` bit(1) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `naftnoPolje_sifra` int(11) DEFAULT NULL,
  PRIMARY KEY (`sifra`),
  KEY `FK5pcpmhvgoysotw31dn8q4vn23` (`naftnoPolje_sifra`),
  CONSTRAINT `FK5pcpmhvgoysotw31dn8q4vn23` FOREIGN KEY (`naftnoPolje_sifra`) REFERENCES `naftnopolje` (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busotina`
--

LOCK TABLES `busotina` WRITE;
/*!40000 ALTER TABLE `busotina` DISABLE KEYS */;
INSERT INTO `busotina` VALUES (1,_binary '','Cr-2',4),(2,_binary '\0','Ku-1',1),(3,_binary '','La-1',3),(4,_binary '\0','Cr-3',4),(5,_binary '','Cr-8',4),(6,_binary '\0','La-2',3),(7,_binary '','Cr-10',4),(8,_binary '','Be-17',2),(9,_binary '\0','La-5',3),(10,_binary '','Cr-11',4),(11,_binary '','Ku-2',1),(12,_binary '\0','Cr-12',4),(13,_binary '','Be-43',2),(14,_binary '\0','Cr-13',4),(15,_binary '','La-10',3),(16,_binary '','La-12',3),(17,_binary '','La-13',3),(18,_binary '','Ku-4',1),(19,_binary '','Cr-14',4),(20,_binary '','Be-55',2),(21,_binary '','Ku-7',1),(22,_binary '\0','Ku-10',1),(23,_binary '','Be-57 ',2),(24,_binary '\0','Be-13',2),(25,_binary '','Be-28',2),(26,_binary '\0','La-14',3),(27,_binary '\0','La-15',3),(28,_binary '','La-17',3),(29,_binary '','Cr-15',4),(30,_binary '','La-18',3),(31,_binary '\0','Be-68',2),(32,_binary '','Be-82',2),(33,_binary '','La-20',3),(34,_binary '','Cr-16',4),(35,_binary '\0','Be-63',2),(36,_binary '\0','Cr-17',4),(37,_binary '','Cr-18',4),(38,_binary '','Be-38',2),(39,_binary '\0','La-21',3),(40,_binary '','La-23',3),(42,_binary '','Be-30 ß',2);
/*!40000 ALTER TABLE `busotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `naftnopolje`
--

DROP TABLE IF EXISTS `naftnopolje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `naftnopolje` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `naftnopolje`
--

LOCK TABLES `naftnopolje` WRITE;
/*!40000 ALTER TABLE `naftnopolje` DISABLE KEYS */;
INSERT INTO `naftnopolje` VALUES (1,'Kučanci'),(2,'Beničanci'),(3,'Ladislavci'),(4,'Crnac'),(5,'Obod Lacići');
/*!40000 ALTER TABLE `naftnopolje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `odrzavanje`
--

DROP TABLE IF EXISTS `odrzavanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `odrzavanje` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `datum` datetime(6) DEFAULT NULL,
  `zaposlenik_sifra` int(11) DEFAULT NULL,
  PRIMARY KEY (`sifra`),
  KEY `FKre2u165afegniwf1ncpvbuur6` (`zaposlenik_sifra`),
  CONSTRAINT `FKre2u165afegniwf1ncpvbuur6` FOREIGN KEY (`zaposlenik_sifra`) REFERENCES `zaposlenik` (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `odrzavanje`
--

LOCK TABLES `odrzavanje` WRITE;
/*!40000 ALTER TABLE `odrzavanje` DISABLE KEYS */;
INSERT INTO `odrzavanje` VALUES (1,'1963-03-27 05:55:40.005000',4),(2,'1986-10-12 15:54:19.895000',10),(3,'1959-03-21 12:27:45.909000',8),(4,'1964-10-03 07:06:37.173000',2),(5,'1965-01-15 18:38:38.051000',10),(6,'1978-12-16 21:02:55.018000',3),(7,'1978-03-20 16:11:45.642000',4),(8,'1989-03-12 14:08:36.738000',9),(9,'1987-01-28 06:45:22.036000',6),(10,'1960-03-11 14:46:56.376000',10),(11,'1966-01-11 15:58:36.844000',9),(12,'1998-10-11 07:17:40.939000',9),(13,'1980-12-19 19:31:33.970000',3),(14,'1996-05-20 04:25:12.561000',8),(15,'1973-07-13 17:37:08.045000',6),(16,'1976-07-30 20:01:23.020000',2),(17,'2023-03-28 00:00:00.000000',4),(18,'2023-03-29 00:00:00.000000',3),(19,'2023-03-28 00:00:00.000000',5),(21,'2023-04-13 00:00:00.000000',5),(22,'2023-04-14 00:00:00.000000',9),(23,'2023-04-25 00:00:00.000000',2),(24,'2023-04-12 00:00:00.000000',8),(25,'2023-04-13 00:00:00.000000',2),(26,'2023-04-15 00:00:00.000000',3),(27,'2023-04-16 00:00:00.000000',10),(28,'2023-04-17 00:00:00.000000',9),(29,'2023-04-26 00:00:00.000000',9),(30,'2023-04-27 00:00:00.000000',4),(31,'2023-04-28 00:00:00.000000',3),(32,'2023-04-29 00:00:00.000000',5),(33,'2023-04-30 00:00:00.000000',2),(34,'2023-05-01 00:00:00.000000',5),(35,'2023-05-02 00:00:00.000000',11);
/*!40000 ALTER TABLE `odrzavanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operater`
--

DROP TABLE IF EXISTS `operater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operater` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `lozinka` char(61) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operater`
--

LOCK TABLES `operater` WRITE;
/*!40000 ALTER TABLE `operater` DISABLE KEYS */;
INSERT INTO `operater` VALUES (1,'mario.zivkovic.znr@gmail.com','Mario','$2a$10$8UNWqJeL/CE0lpjsBqv2jeixdJ4OdYH/rrnH8TYIY5dTnRIWYkOP.','Živković');
/*!40000 ALTER TABLE `operater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posao`
--

DROP TABLE IF EXISTS `posao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posao` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posao`
--

LOCK TABLES `posao` WRITE;
/*!40000 ALTER TABLE `posao` DISABLE KEYS */;
INSERT INTO `posao` VALUES (1,'Konrola rada njihalica i bušotina'),(2,'Provjera PP-ventila'),(3,'Aktiviranje kugle 3\"'),(4,'Navijanje taylora'),(5,'Mjerenje nivoa aditiva'),(6,'Sipanje antipara'),(7,'Zamjena sapnice'),(8,'Tlačna proba pumpe'),(9,'Zamjena dijagrama'),(10,'Spuštanje kracera'),(12,'zamjena remenja njihalice');
/*!40000 ALTER TABLE `posao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posaobusotina`
--

DROP TABLE IF EXISTS `posaobusotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posaobusotina` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `napomena` varchar(255) DEFAULT NULL,
  `tlakCasinga` decimal(38,2) DEFAULT NULL,
  `tlakNaftovoda` decimal(38,2) DEFAULT NULL,
  `tlakTubinga` decimal(38,2) DEFAULT NULL,
  `busotina_sifra` int(11) DEFAULT NULL,
  `odrzavanje_sifra` int(11) DEFAULT NULL,
  `posao_sifra` int(11) DEFAULT NULL,
  PRIMARY KEY (`sifra`),
  KEY `FKcm89ooewyvfx8tqru4ivxke6` (`busotina_sifra`),
  KEY `FKabt4cyxv0nsgkpyhlfgvvswjp` (`odrzavanje_sifra`),
  KEY `FK2bp4lk0ue5cc83vvido3qnx9k` (`posao_sifra`),
  CONSTRAINT `FK2bp4lk0ue5cc83vvido3qnx9k` FOREIGN KEY (`posao_sifra`) REFERENCES `posao` (`sifra`),
  CONSTRAINT `FKabt4cyxv0nsgkpyhlfgvvswjp` FOREIGN KEY (`odrzavanje_sifra`) REFERENCES `odrzavanje` (`sifra`),
  CONSTRAINT `FKcm89ooewyvfx8tqru4ivxke6` FOREIGN KEY (`busotina_sifra`) REFERENCES `busotina` (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=560 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posaobusotina`
--

LOCK TABLES `posaobusotina` WRITE;
/*!40000 ALTER TABLE `posaobusotina` DISABLE KEYS */;
INSERT INTO `posaobusotina` VALUES (1,'It\'s a Battlefield',37.74,10.47,9.99,8,2,6),(3,'A Handful of Dust',47.00,10.83,12.29,13,10,1),(4,'Recalled to Life',39.14,11.24,12.75,15,14,1),(5,'The Heart Is Deceitful Above All Things',41.81,13.15,11.84,7,5,7),(6,'The Violent Bear It Away',41.08,8.67,10.84,20,8,1),(8,'Blue Remembered Earth',31.16,12.15,13.00,2,8,6),(10,'Recalled to Life',39.16,12.06,12.91,14,7,3),(11,'Time To Murder And Create',19.23,11.59,9.45,10,7,1),(13,'The Last Enemy',40.00,10.55,9.84,23,4,10),(15,'The Line of Beauty',38.24,11.34,11.35,38,10,3),(16,'Quo Vadis',45.27,11.73,10.92,3,6,10),(18,'The Grapes of Wrath',26.34,13.17,10.55,31,10,7),(20,'A Monstrous Regiment of Women',35.18,10.73,8.92,34,11,3),(21,'The Glory and the Dream',39.60,9.40,10.93,39,5,8),(22,'Time of our Darkness',25.94,12.44,13.16,31,15,2),(23,'Tirra Lirra by the River',23.38,10.95,11.60,23,5,7),(24,'To Sail Beyond the Sunset',23.01,13.10,13.24,15,9,5),(25,'Lilies of the Field',15.84,12.49,8.87,13,15,4),(26,'The Daffodil Sky',42.68,13.11,12.17,28,4,1),(27,'Things Fall Apart',19.81,12.10,12.79,9,11,3),(28,'Dying of the Light',14.48,11.06,9.62,26,8,4),(29,'Endless Night',21.17,10.98,8.83,36,14,8),(30,'Fear and Trembling',44.08,10.15,10.20,11,1,4),(31,'The Heart Is Deceitful Above All Things',10.20,11.43,8.65,26,11,6),(32,'Gone with the Wind',27.54,10.35,8.72,3,4,9),(34,'The Man Within',18.42,9.61,10.71,5,11,4),(35,'Quo Vadis',18.45,11.78,9.62,32,8,1),(36,'Shall not Perish',44.14,11.17,9.78,40,12,5),(37,'Noli Me Tangere',30.35,9.11,13.01,25,8,6),(38,'Look Homeward, Angel',47.51,11.54,11.64,24,8,1),(39,'The Line of Beauty',23.26,11.22,12.03,24,14,7),(40,'Mother Night',30.68,11.79,11.40,33,7,6),(41,'Vile Bodies',29.80,12.88,8.27,10,4,10),(42,'The Stars\' Tennis Balls',25.53,12.12,9.43,30,2,6),(43,'A Scanner Darkly',42.43,11.74,10.98,40,15,9),(44,'Behold the Man',27.25,9.70,12.93,20,1,6),(45,'The Torment of Others',14.74,8.50,10.85,31,13,4),(46,'After Many a Summer Dies the Swan',33.96,8.37,9.54,38,3,4),(47,'Precious Bane',42.62,13.28,10.90,37,14,4),(48,'Number the Stars',44.50,10.66,8.95,39,1,2),(49,'Carrion Comfort',27.83,8.56,13.11,25,9,5),(51,'Absalom, Absalom!',24.37,8.19,10.63,3,6,2),(52,'A Scanner Darkly',30.08,8.72,12.17,26,4,4),(53,'O Pioneers!',26.70,8.50,9.76,5,4,6),(54,'In a Dry Season',34.35,9.94,8.01,5,5,10),(55,'Rosemary Sutcliff',27.44,11.56,13.20,11,7,3),(56,'Beneath the Bleeding',15.95,8.64,10.98,34,10,10),(57,'Consider the Lilies',26.20,11.08,8.08,17,6,8),(59,'All the King\'s Men',21.55,11.14,12.14,11,7,4),(60,'When the Green Woods Laugh',46.81,8.75,9.79,4,3,4),(61,'The Way Through the Woods',21.07,10.47,9.95,12,5,1),(62,'The Sun Also Rises',38.00,10.14,10.87,11,10,10),(63,'Specimen Days',45.19,9.00,10.48,3,10,4),(64,'I Sing the Body Electric',28.75,9.55,10.35,2,14,8),(65,'A Time to Kill',25.25,11.09,11.05,23,7,9),(66,'To a God Unknown',25.01,10.32,8.08,4,13,8),(67,'Beyond the Mexique Bay',40.47,9.26,8.46,7,8,2),(68,'O Pioneers!',13.17,12.92,12.79,4,5,8),(69,'Cover Her Face',11.97,8.96,8.08,35,6,1),(70,'Blood\'s a Rover',22.90,11.57,12.82,15,2,9),(71,'Cover Her Face',32.69,10.48,11.39,14,8,4),(72,'Paths of Glory',41.36,13.15,10.06,40,14,9),(73,'Lilies of the Field',16.23,9.12,10.96,33,12,6),(74,'Jacob Have I Loved',22.05,11.16,11.21,8,3,4),(75,'In Death Ground',43.85,8.58,8.17,30,1,1),(76,'Vile Bodies',29.59,10.75,9.63,40,14,10),(77,'Cover Her Face',34.55,12.82,11.96,17,8,7),(78,'The Mirror Crack\'d from Side to Side',41.35,12.91,8.28,34,4,6),(79,'A Time to Kill',30.27,11.17,13.26,1,12,10),(80,'The Last Enemy',10.52,13.04,10.02,19,2,10),(81,'A Time of Gifts',14.93,9.55,8.41,4,8,4),(82,'The Wives of Bath',36.99,12.84,12.11,34,10,7),(83,'Frequent Hearses',10.64,10.72,12.15,22,12,10),(84,'Cabbages and Kings',15.11,11.95,12.62,32,9,4),(85,'If Not Now, When?',26.72,10.03,10.78,32,2,1),(86,'Mr Standfast',15.50,13.08,9.99,29,3,10),(87,'Alone on a Wide, Wide Sea',36.91,11.16,10.72,35,1,4),(89,'Pale Kings and Princes',44.97,11.41,8.58,35,10,5),(90,'No Longer at Ease',44.29,8.08,8.76,6,4,1),(91,'Absalom, Absalom!',41.45,9.59,9.05,33,1,3),(92,'A Darkling Plain',42.85,10.55,11.11,38,15,8),(93,'A Passage to India',40.90,10.94,10.92,17,3,2),(94,'The Painted Veil',36.70,10.04,13.03,39,4,3),(95,'Surprised by Joy',41.52,12.42,11.21,30,14,4),(96,'I Sing the Body Electric',40.81,10.54,11.73,3,3,3),(97,'Time To Murder And Create',43.39,11.77,12.52,29,13,1),(99,'Arms and the Man',34.10,8.65,8.33,16,9,10),(100,'Vanity Fair',36.61,11.58,11.96,26,11,8),(101,'Look Homeward, Angel',31.02,8.74,10.71,1,5,9),(102,'Far From the Madding Crowd',21.15,10.58,13.06,27,10,8),(103,'Waiting for the Barbarians',12.81,8.04,12.19,26,7,5),(104,'Noli Me Tangere',36.44,8.08,11.44,6,7,10),(105,'In Death Ground',32.30,10.14,10.74,40,4,10),(106,'Recalled to Life',19.91,8.06,11.36,36,3,7),(108,'An Evil Cradling',13.44,10.04,9.75,19,10,3),(109,'The Waste Land',26.97,9.32,9.21,15,15,10),(110,'A Handful of Dust',28.37,9.74,9.13,37,15,5),(111,'O Jerusalem!',10.07,11.83,13.19,15,14,4),(112,'Jesting Pilate',35.01,8.40,10.71,37,8,6),(113,'An Evil Cradling',28.56,12.45,8.14,38,5,1),(114,'Specimen Days',44.62,8.29,12.72,27,14,9),(115,'Such, Such Were the Joys',39.60,11.92,8.51,5,12,2),(116,'By Grand Central Station I Sat Down and Wept',44.98,11.79,8.87,10,1,8),(117,'For a Breath I Tarry',14.99,10.91,10.41,3,12,2),(118,'Ego Dominus Tuus',17.87,13.23,9.33,40,9,2),(119,'Behold the Man',22.84,11.94,11.30,18,8,2),(120,'Endless Night',43.54,11.97,9.84,24,9,3),(121,'Dance Dance Dance',41.00,8.59,11.52,9,4,6),(122,'An Instant In The Wind',26.24,9.10,10.24,26,14,4),(123,'Arms and the Man',40.56,11.15,8.51,36,8,1),(124,'No Longer at Ease',36.08,13.06,13.11,3,15,7),(125,'The Last Temptation',30.75,11.05,10.29,35,2,6),(126,'A Farewell to Arms',38.36,12.11,8.08,37,14,6),(127,'The Skull Beneath the Skin',12.01,9.91,8.83,15,10,9),(128,'Wildfire at Midnight',38.30,12.89,11.90,14,12,2),(129,'Number the Stars',44.19,13.15,10.47,21,9,7),(130,'The Moon by Night',23.31,8.26,12.35,10,10,10),(131,'Quo Vadis',24.74,9.14,8.10,14,14,8),(132,'What\'s Become of Waring',21.15,8.68,9.53,5,14,4),(133,'A Farewell to Arms',28.63,10.72,11.49,38,11,6),(134,'The Green Bay Tree',26.28,10.07,12.63,25,15,8),(135,'Taming a Sea Horse',29.52,11.57,10.18,10,5,5),(136,'Fame Is the Spur',15.64,8.21,9.26,33,9,7),(137,'The Sun Also Rises',19.21,10.35,9.25,3,3,9),(138,'Such, Such Were the Joys',47.45,9.71,12.06,37,9,10),(139,'Jacob Have I Loved',25.30,13.16,9.32,8,2,2),(140,'A Summer Bird-Cage',20.07,8.58,11.52,18,3,9),(141,'The Torment of Others',32.71,10.96,9.26,15,3,8),(142,'The Daffodil Sky',32.59,9.90,8.71,33,7,8),(144,'Look Homeward, Angel',11.39,11.90,9.95,13,1,5),(145,'All the King\'s Men',45.93,10.96,10.04,16,4,10),(146,'That Good Night',30.42,8.36,9.72,17,4,10),(147,'The Torment of Others',44.15,11.76,9.94,21,1,7),(148,'Clouds of Witness',47.50,11.50,9.26,11,4,4),(149,'The Little Foxes',18.35,8.80,8.16,36,1,5),(150,'Shall not Perish',23.48,11.32,11.83,3,4,6),(151,'Cover Her Face',25.86,8.25,11.79,7,15,8),(152,'A Time to Kill',34.17,9.84,8.59,21,14,9),(153,'Jacob Have I Loved',44.77,11.14,10.10,36,14,6),(154,'The Waste Land',33.92,12.68,10.22,31,3,1),(155,'Mother Night',23.34,12.03,13.00,12,7,8),(156,'By Grand Central Station I Sat Down and Wept',10.09,9.33,11.58,33,4,6),(157,'Oh! To be in England',29.31,11.60,12.19,27,2,1),(158,'The Needle\'s Eye',47.83,12.99,8.98,15,5,8),(159,'Fear and Trembling',16.47,8.35,10.68,27,2,3),(160,'The Last Enemy',45.76,8.13,8.06,18,4,3),(161,'The House of Mirth',32.97,10.33,10.87,33,8,8),(162,'The Far-Distant Oxus',27.19,11.99,11.60,16,11,4),(164,'The Little Foxes',27.37,12.65,9.53,3,15,2),(165,'Things Fall Apart',11.01,10.71,12.51,24,5,10),(166,'The Way Through the Woods',16.65,8.58,10.37,8,13,4),(167,'Clouds of Witness',11.47,9.89,9.01,35,13,5),(168,'No Highway',39.55,11.16,13.11,16,10,3),(169,'Death Be Not Proud',33.31,9.98,8.91,12,2,1),(170,'This Lime Tree Bower',38.66,11.15,8.37,38,2,9),(171,'The Stars\' Tennis Balls',11.94,12.41,8.74,20,12,10),(172,'Great Work of Time',19.85,12.56,12.78,9,3,8),(173,'The Moving Finger',42.38,8.16,12.76,38,8,9),(174,'Frequent Hearses',23.21,12.64,9.21,38,3,6),(175,'Little Hands Clapping',15.31,9.31,10.45,26,9,8),(176,'Specimen Days',27.97,11.60,10.29,11,5,4),(177,'To a God Unknown',47.19,9.98,11.57,28,4,8),(178,'Endless Night',17.51,12.82,12.33,31,10,2),(179,'Absalom, Absalom!',10.43,8.62,10.72,12,10,5),(180,'Edna O\'Brien',19.88,13.18,9.90,27,13,9),(181,'East of Eden',23.65,8.63,12.39,15,13,8),(183,'The Widening Gyre',24.66,8.58,8.52,30,3,2),(184,'The Moon by Night',36.36,8.03,11.31,7,14,1),(185,'Now Sleeps the Crimson Petal',23.05,9.01,10.67,37,5,6),(186,'The Wives of Bath',18.31,11.20,11.92,35,1,3),(187,'The Torment of Others',12.84,10.55,12.30,12,10,8),(188,'Beneath the Bleeding',15.62,9.58,9.55,21,1,5),(189,'Endless Night',22.54,12.93,11.41,22,9,1),(190,'A Scanner Darkly',43.74,11.27,9.64,13,8,9),(191,'The Moon by Night',40.35,11.26,10.03,20,4,5),(192,'The Monkey\'s Raincoat',32.12,11.24,12.97,38,11,8),(193,'The Other Side of Silence',45.28,12.83,12.97,34,14,2),(194,'A Catskill Eagle',27.43,10.79,8.71,1,5,4),(195,'A Summer Bird-Cage',34.81,11.31,12.51,12,3,6),(196,'Mr Standfast',18.93,8.51,12.34,22,12,5),(197,'The Wives of Bath',21.47,10.93,9.83,22,8,6),(198,'Cabbages and Kings',26.03,8.22,9.56,18,5,7),(199,'Fear and Trembling',31.34,11.71,8.73,33,13,1),(200,'The Moving Toyshop',44.60,11.01,9.90,12,8,2),(201,'Far From the Madding Crowd',26.39,11.89,10.96,11,2,2),(202,'The Violent Bear It Away',45.21,8.14,12.30,28,9,6),(203,'To Sail Beyond the Sunset',36.07,8.20,11.60,27,12,5),(204,'For Whom the Bell Tolls',10.93,12.61,8.81,8,5,10),(205,'Down to a Sunless Sea',10.74,8.41,9.52,9,14,10),(206,'promjenjeno pakovanje dpa uređaja',15.97,8.64,10.00,10,16,10),(207,'The Last Enemy',12.48,9.31,9.03,19,4,6),(208,'Consider the Lilies',14.22,9.15,10.64,15,3,2),(209,'The House of Mirth',42.13,9.58,9.41,7,11,1),(210,'The Wealth of Nations',45.70,8.79,12.97,38,2,8),(211,'Oh! To be in England',20.01,8.19,9.63,29,12,9),(212,'The Golden Bowl',24.08,11.65,12.71,15,5,7),(213,'Where Angels Fear to Tread',13.99,10.33,10.47,7,4,10),(214,'The Daffodil Sky',15.51,8.32,11.06,3,14,8),(215,'Quo Vadis',10.81,9.39,9.78,33,14,9),(216,'The Wings of the Dove',15.83,11.52,10.67,5,1,7),(217,'The Stars\' Tennis Balls',27.22,10.18,13.23,20,10,7),(218,'If I Forget Thee Jerusalem',46.66,9.00,8.10,20,12,3),(219,'The Skull Beneath the Skin',14.34,9.75,11.67,23,15,10),(220,'Number the Stars',14.50,9.89,11.61,21,12,8),(221,'If Not Now, When?',25.83,12.40,12.20,3,11,7),(222,'Fame Is the Spur',30.18,10.63,8.48,38,14,7),(223,'Alone on a Wide, Wide Sea',23.59,9.96,13.29,14,8,5),(224,'Bušotina radi dobro, promjenjena sapnica',14.79,11.76,11.48,24,16,9),(225,'Bury My Heart at Wounded Knee',32.83,11.62,8.60,5,4,5),(226,'The Cricket on the Hearth',10.14,11.52,10.53,16,15,7),(227,'Jacob Have I Loved',44.49,12.50,11.50,29,14,3),(228,'The Other Side of Silence',38.44,12.11,12.83,10,14,9),(229,'Vile Bodies',39.31,9.35,12.61,15,4,1),(230,'Ah, Wilderness!',33.97,13.04,12.97,9,13,7),(231,'Now Sleeps the Crimson Petal',35.84,13.05,8.11,5,13,4),(232,'zamjenjen dijagram, bušotina radi dobro',17.06,11.94,9.24,14,16,9),(233,'zamjenjena sapnica, bušotina radi',21.28,8.39,13.19,39,16,7),(234,'That Hideous Strength',10.87,9.10,9.84,2,13,3),(235,'A Farewell to Arms',30.28,9.91,11.40,5,14,7),(236,'In a Dry Season',23.64,12.23,11.30,17,9,3),(237,'Butter In a Lordly Dish',39.17,13.00,10.61,2,5,9),(238,'The House of Mirth',21.34,8.49,10.52,18,10,7),(239,'The Moon by Night',29.05,8.88,12.15,7,12,7),(240,'Postern of Fate',34.74,9.87,13.02,12,2,7),(241,'The House of Mirth',37.63,8.42,9.56,39,14,4),(242,'Recalled to Life',33.48,8.58,13.25,16,16,10),(243,'In a Dry Season',29.83,10.45,11.74,16,6,1),(244,'After Many a Summer Dies the Swan',34.98,12.66,10.67,4,15,10),(245,'Some Buried Caesar',15.84,10.85,10.70,7,2,5),(246,'Eyeless in Gaza',17.14,11.18,10.56,34,4,4),(247,'Ego Dominus Tuus',26.35,9.40,9.85,17,3,1),(248,'Françoise Sagan',31.43,12.15,8.96,30,1,2),(249,'When the Green Woods Laugh',17.64,12.42,8.24,17,5,6),(250,'Beneath the Bleeding',31.77,11.35,12.90,32,14,5),(251,'Fear and Trembling',14.89,9.04,12.62,9,15,4),(252,'Time of our Darkness',23.19,10.48,10.89,23,4,10),(253,'The Cricket on the Hearth',44.94,11.12,10.49,31,7,9),(254,'Jacob Have I Loved',37.05,9.19,10.20,17,8,9),(255,'As I Lay Dying',30.11,12.78,10.62,22,7,5),(256,'A Darkling Plain',47.81,12.40,8.49,7,8,6),(257,'Things Fall Apart',27.19,8.59,11.34,5,8,8),(258,'To a God Unknown',33.31,12.48,13.13,9,7,10),(259,'Look to Windward',41.51,11.94,10.90,7,1,4),(260,'Infinite Jest',22.78,8.94,11.41,8,11,5),(261,'This Lime Tree Bower',30.42,12.02,12.81,4,3,6),(262,'Antic Hay',11.08,10.12,8.24,21,13,4),(264,'Look to Windward',36.09,9.50,9.68,11,11,8),(265,'The Wives of Bath',47.39,12.26,11.35,37,14,3),(266,'The Parliament of Man',16.02,10.62,11.11,14,5,3),(267,'The Wealth of Nations',44.90,11.77,8.91,23,8,5),(268,'Mother Night',27.53,11.21,10.29,6,10,10),(269,'Great Work of Time',14.70,9.17,12.87,13,4,3),(270,'Dying of the Light',25.08,13.19,12.29,27,5,7),(271,'The Curious Incident of the Dog in the Night-Time',32.46,12.76,13.18,2,4,4),(272,'Taming a Sea Horse',19.76,11.10,12.85,5,4,7),(273,'The Heart Is a Lonely Hunter',18.71,11.89,9.71,10,3,7),(274,'Dulce et Decorum Est',38.19,10.60,12.51,38,9,8),(275,'Of Mice and Men',44.62,10.57,12.73,6,6,4),(276,'The Golden Apples of the Sun',17.61,13.11,10.32,2,10,6),(277,'A Monstrous Regiment of Women',39.85,11.13,11.59,20,7,5),(278,'A Passage to India',33.23,10.08,9.76,14,15,6),(279,'Ego Dominus Tuus',47.10,10.13,13.26,17,13,3),(280,'The Monkey\'s Raincoat',12.96,8.96,10.95,21,14,1),(281,'This Side of Paradise',12.14,11.87,9.42,17,9,4),(282,'The Wings of the Dove',40.26,12.02,12.93,25,8,4),(283,'The Wealth of Nations',40.91,12.78,11.01,11,10,10),(284,'Cover Her Face',46.53,8.34,12.33,8,2,7),(285,'Gone with the Wind',13.74,12.86,12.47,32,10,5),(286,'Great Work of Time',40.65,8.34,9.65,19,15,9),(287,'By Grand Central Station I Sat Down and Wept',42.47,8.03,12.96,27,11,1),(288,'The Moon by Night',27.58,8.45,8.26,9,12,1),(290,'A Swiftly Tilting Planet',27.76,8.84,11.03,34,1,7),(291,'Dying of the Light',26.45,12.37,12.42,34,15,4),(292,'The Waste Land',32.37,9.14,9.98,33,10,7),(293,'Carrion Comfort',19.53,11.31,12.67,20,6,4),(294,'The World, the Flesh and the Devil',34.00,11.31,8.56,5,14,10),(295,'When the Green Woods Laugh',47.48,10.45,12.97,32,2,10),(296,'The Millstone',18.17,9.37,9.20,12,2,4),(297,'O Jerusalem!',28.76,11.58,10.87,32,6,3),(298,'',40.27,9.40,12.46,6,15,2),(299,'To a God Unknown',22.71,9.05,10.12,32,15,5),(300,'Of Human Bondage',28.71,9.08,12.81,22,14,10),(301,'A Time to Kill',17.95,13.12,8.31,20,13,9),(302,'A Monstrous Regiment of Women',36.13,9.92,10.14,15,2,4),(303,'The Needle\'s Eye',23.13,12.56,11.27,24,11,6),(304,'The Daffodil Sky',35.88,8.63,8.50,17,7,6),(305,'When the Green Woods Laugh',22.20,12.15,10.76,35,9,6),(306,'From Here to Eternity',44.49,11.50,10.31,9,6,5),(307,'Fair Stood the Wind for France',39.84,9.62,9.56,14,11,5),(308,'To a God Unknown',34.22,8.17,10.89,20,9,8),(309,'To Your Scattered Bodies Go',45.22,10.92,11.13,4,6,5),(310,'That Hideous Strength',20.23,13.11,10.40,20,1,7),(311,'Butter In a Lordly Dish',43.83,9.31,12.79,35,12,8),(312,'A Swiftly Tilting Planet',20.02,11.28,8.60,35,3,7),(313,'No Longer at Ease',37.16,12.95,10.28,28,11,5),(314,'Carrion Comfort',19.48,10.06,8.10,28,11,4),(315,'That Hideous Strength',23.93,11.86,11.09,32,15,4),(316,'Pale Kings and Princes',45.36,10.43,8.95,25,7,6),(317,'Where Angels Fear to Tread',40.74,8.41,11.34,18,15,9),(318,'Tiger! Tiger!',16.18,10.38,12.12,37,13,9),(319,'The Doors of Perception',36.35,12.62,11.37,10,7,7),(320,'As I Lay Dying',21.38,9.69,10.91,22,13,4),(321,'The Grapes of Wrath',26.85,10.99,10.65,23,3,3),(322,'The Wives of Bath',45.21,10.51,13.24,15,11,7),(323,'I Will Fear No Evil',32.39,12.75,12.82,21,3,1),(324,'Specimen Days',43.95,11.06,10.24,21,3,2),(325,'Taming a Sea Horse',16.92,10.84,10.73,9,2,5),(326,'Carrion Comfort',30.30,11.48,12.29,15,5,6),(327,'The Golden Bowl',26.58,11.76,10.37,27,6,6),(328,'Such, Such Were the Joys',38.83,11.12,8.06,31,2,10),(329,'Tirra Lirra by the River',20.26,8.49,10.52,30,6,2),(330,'Nine Coaches Waiting',37.02,9.60,11.88,36,3,2),(331,'No Longer at Ease',22.25,9.11,11.83,15,7,3),(332,'The Violent Bear It Away',12.86,8.61,11.31,1,6,7),(333,'Where Angels Fear to Tread',29.66,9.30,13.21,1,4,7),(334,'The World, the Flesh and the Devil',21.35,10.35,9.08,25,10,7),(335,'Mother Night',41.31,12.72,12.96,29,1,6),(337,'The Last Enemy',15.22,12.61,11.21,21,9,4),(338,'A Confederacy of Dunces',43.51,12.70,8.59,12,14,9),(339,'The Golden Apples of the Sun',43.06,10.15,9.53,5,9,1),(341,'The Curious Incident of the Dog in the Night-Time',19.09,11.30,9.58,7,3,10),(342,'As I Lay Dying',44.48,11.19,10.77,31,13,6),(343,'Clouds of Witness',21.93,9.63,9.70,15,3,5),(344,'A Farewell to Arms',23.52,12.65,11.71,38,6,2),(345,'Clouds of Witness',36.16,8.93,11.17,23,7,5),(346,'Recalled to Life',40.28,12.01,11.28,22,4,6),(347,'The Road Less Traveled',40.67,11.45,11.99,1,6,4),(348,'Lilies of the Field',42.37,10.65,12.91,40,10,6),(349,'Such, Such Were the Joys',25.35,10.26,10.84,20,12,9),(350,'The Road Less Traveled',18.07,11.77,9.35,36,13,9),(351,'The Wind\'s Twelve Quarters',28.03,9.57,10.64,27,6,10),(352,'Lilies of the Field',21.36,8.41,11.72,14,3,9),(353,'Jacob Have I Loved',34.65,11.89,13.23,17,4,3),(354,'The Curious Incident of the Dog in the Night-Time',20.60,9.91,9.25,2,4,4),(355,'As I Lay Dying',21.09,12.57,11.33,26,12,1),(356,'The Millstone',18.29,12.11,12.86,23,4,8),(357,'Noli Me Tangere',36.41,8.52,8.57,37,5,8),(358,'Arms and the Man',29.47,12.77,12.59,13,10,1),(359,'The Torment of Others',27.09,11.79,8.27,6,12,6),(360,'To Say Nothing of the Dog',33.24,11.00,8.17,26,2,4),(361,'A Glass of Blessings',10.56,10.81,12.26,19,3,7),(362,'East of Eden',25.85,8.32,13.10,25,6,9),(363,'Those Barren Leaves, Thrones, Dominations',38.97,12.42,13.12,37,11,3),(364,'If I Forget Thee Jerusalem',34.38,12.77,12.93,21,15,5),(365,'O Pioneers!',13.96,12.04,9.79,18,1,8),(366,'An Evil Cradling',40.35,8.37,12.69,19,15,2),(367,'A Catskill Eagle',34.63,11.96,8.31,23,2,4),(368,'A Confederacy of Dunces',32.20,9.23,8.07,2,10,4),(369,'All the King\'s Men',18.16,11.02,12.17,20,1,5),(370,'The House of Mirth',32.49,9.42,9.19,27,2,3),(371,'A Time of Gifts',35.34,8.30,10.11,15,9,5),(372,'Down to a Sunless Sea',23.42,10.42,11.67,34,11,3),(373,'Moab Is My Washpot',47.85,12.90,12.56,18,13,3),(374,'The Little Foxes',39.36,12.68,11.03,20,9,9),(375,'Rosemary Sutcliff',23.98,12.42,8.78,16,8,7),(376,'Jacob Have I Loved',35.25,8.29,9.67,21,3,9),(377,'Far From the Madding Crowd',17.06,11.43,12.25,13,9,2),(378,'The Violent Bear It Away',27.87,12.86,10.83,14,6,1),(379,'A Glass of Blessings',19.78,13.20,10.14,15,8,6),(380,'Everything is Illuminated',46.65,8.50,13.14,23,13,9),(381,'Beyond the Mexique Bay',31.97,9.35,12.46,17,4,3),(382,'Dying of the Light',19.11,9.13,10.37,22,6,9),(383,'O Pioneers!',47.56,8.12,11.77,39,10,4),(384,'Number the Stars',44.25,8.48,9.81,37,10,7),(385,'Endless Night',28.95,10.71,10.89,32,1,5),(386,'The Stars\' Tennis Balls',19.39,12.37,13.15,34,11,10),(387,'Oh! To be in England',18.14,10.79,9.78,33,9,9),(388,'Surprised by Joy',31.00,12.80,8.33,31,12,1),(389,'The Daffodil Sky',30.94,10.30,13.16,36,4,9),(390,'The Moving Toyshop',18.57,12.95,13.29,30,2,6),(391,'The Stars\' Tennis Balls',17.70,12.40,11.19,12,12,7),(392,'A Scanner Darkly',42.56,11.93,12.88,21,15,7),(393,'Oh! To be in England',41.49,9.68,8.31,1,10,10),(394,'An Acceptable Time',22.37,8.20,8.99,29,4,1),(395,'A Many-Splendoured Thing',15.78,9.67,9.07,10,5,10),(396,'The Golden Bowl',30.98,8.61,11.69,31,1,7),(397,'If Not Now, When?',33.83,10.26,10.85,21,13,7),(398,'Vanity Fair',14.37,9.54,12.53,1,5,5),(400,'Number the Stars',17.42,8.94,11.76,28,12,4),(401,'No Longer at Ease',38.73,11.22,13.18,27,5,7),(402,'The Lathe of Heaven',33.09,11.12,11.07,7,10,8),(403,'A Glass of Blessings',36.43,13.14,8.98,40,14,6),(404,'Recalled to Life',34.53,11.06,11.72,39,13,7),(405,'A Confederacy of Dunces',41.91,8.54,9.15,15,15,4),(406,'In Death Ground',16.41,8.34,12.20,21,11,4),(407,'From Here to Eternity',41.18,8.13,10.82,40,15,9),(408,'Consider the Lilies',19.49,9.91,8.32,13,10,1),(409,'Infinite Jest',43.15,10.98,10.83,24,3,6),(410,'To Say Nothing of the Dog',14.91,10.27,8.25,4,9,2),(411,'The Wind\'s Twelve Quarters',31.52,11.75,11.15,12,11,2),(412,'Consider Phlebas',46.85,12.65,8.86,36,2,5),(413,'Tirra Lirra by the River',40.03,8.49,9.61,26,10,2),(415,'The Wings of the Dove',46.95,11.21,13.08,33,9,10),(416,'A Monstrous Regiment of Women',10.68,8.41,8.87,35,15,4),(417,'Dance Dance Dance',37.58,11.57,11.28,13,10,4),(418,'Surprised by Joy',18.13,8.60,12.76,6,8,7),(419,'If I Forget Thee Jerusalem',47.69,11.32,11.73,7,9,2),(420,'No Highway',45.75,10.01,11.06,38,8,9),(421,'The Grapes of Wrath',14.45,10.00,12.27,2,2,5),(422,'Rosemary Sutcliff',44.61,9.53,12.69,23,1,10),(423,'Surprised by Joy',31.25,11.29,9.95,40,13,5),(424,'Sleep the Brave',28.76,10.36,12.60,14,15,1),(425,'This Side of Paradise',46.09,8.07,12.89,5,10,4),(426,'All Passion Spent',23.99,8.29,11.75,5,13,3),(427,'All Passion Spent',45.88,12.36,10.48,25,14,2),(428,'Waiting for the Barbarians',18.36,10.72,11.04,37,2,2),(429,'In a Dry Season',28.70,8.06,13.10,40,13,5),(430,'Little Hands Clapping',42.95,8.97,13.20,4,12,10),(431,'For Whom the Bell Tolls',41.73,8.78,9.65,38,11,3),(432,'By Grand Central Station I Sat Down and Wept',15.14,8.28,11.47,12,10,4),(433,'An Instant In The Wind',10.18,9.20,8.05,33,10,5),(434,'The Last Temptation',30.22,12.65,10.87,31,6,1),(435,'Recalled to Life',47.94,12.25,11.20,21,10,3),(436,'Tirra Lirra by the River',10.74,10.43,8.11,9,1,9),(437,'Have His Carcase',15.09,11.36,8.47,12,15,10),(439,'Of Human Bondage',45.75,12.62,8.93,19,1,7),(440,'The Needle\'s Eye',38.87,11.45,8.34,33,2,10),(441,'If I Forget Thee Jerusalem',45.49,10.18,12.37,37,9,3),(442,'Dance Dance Dance',40.86,10.72,10.87,35,2,4),(443,'Sleep the Brave',44.18,12.01,9.99,20,4,3),(444,'A Swiftly Tilting Planet',12.96,9.59,9.39,30,12,9),(445,'The Far-Distant Oxus',40.89,9.65,11.58,30,2,7),(446,'The Wind\'s Twelve Quarters',43.02,8.68,12.55,19,4,4),(447,'In a Glass Darkly',31.24,10.48,10.46,32,1,2),(448,'The Torment of Others',27.22,11.13,11.51,3,6,1),(449,'Mr Standfast',22.66,8.21,11.38,2,2,7),(450,'A Time to Kill',37.15,12.39,10.18,38,4,6),(451,'Clouds of Witness',27.99,10.05,8.95,10,10,8),(452,'Blithe Spirit',41.58,9.75,8.45,24,3,1),(453,'Great Work of Time',38.01,10.46,11.62,8,12,8),(454,'O Pioneers!',41.82,12.95,12.23,40,1,10),(455,'Paths of Glory',27.91,10.05,9.57,2,3,7),(456,'From Here to Eternity',39.20,8.72,10.61,10,3,10),(457,'All the King\'s Men',15.65,8.74,10.44,9,5,2),(459,'Dulce et Decorum Est',37.64,9.48,8.80,9,4,8),(460,'Time To Murder And Create',16.77,9.55,10.47,38,6,3),(461,'The Soldier\'s Art',35.32,9.15,9.96,18,8,3),(462,'The World, the Flesh and the Devil',44.73,11.89,9.90,10,6,4),(463,'Dulce et Decorum Est',22.05,10.48,10.82,21,1,6),(464,'Dying of the Light',35.99,9.26,10.41,12,4,4),(465,'I Sing the Body Electric',21.28,10.66,8.57,29,15,6),(466,'The Doors of Perception',24.36,10.13,11.02,21,3,1),(467,'A Confederacy of Dunces',22.15,12.14,11.09,24,12,8),(468,'Vile Bodies',47.10,8.16,12.57,4,7,7),(469,'Cover Her Face',30.22,8.56,8.95,10,4,6),(470,'The World, the Flesh and the Devil',40.72,9.19,10.47,23,15,5),(471,'What\'s Become of Waring',33.57,12.94,11.29,13,3,7),(473,'Sleep the Brave',16.54,9.24,8.71,15,12,6),(474,'The Curious Incident of the Dog in the Night-Time',29.57,13.19,9.68,2,2,4),(475,'An Acceptable Time',29.41,13.03,9.76,26,7,8),(477,'The Moon by Night',22.92,11.75,11.15,38,3,9),(478,'The Heart Is a Lonely Hunter',36.30,9.50,11.60,4,4,9),(479,'A Darkling Plain',29.87,12.85,8.42,11,4,1),(480,'Blue Remembered Earth',43.17,11.49,10.94,5,3,4),(481,'A Swiftly Tilting Planet',20.53,8.42,10.46,2,4,9),(482,'Cabbages and Kings',21.62,8.61,9.60,4,5,9),(483,'For Whom the Bell Tolls',29.29,9.55,9.25,24,5,10),(484,'Now Sleeps the Crimson Petal',10.33,10.68,8.64,35,6,5),(485,'Vile Bodies',17.03,8.10,8.13,23,10,1),(486,'The Sun Also Rises',38.43,9.35,11.52,39,15,4),(487,'Where Angels Fear to Tread',10.48,11.79,12.87,34,15,9),(488,'The Cricket on the Hearth',40.89,12.69,10.81,21,15,4),(489,'As I Lay Dying',11.92,10.75,11.90,12,15,1),(490,'The Needle\'s Eye',30.40,9.50,9.77,14,12,6),(491,'Edna O\'Brien',46.25,13.23,9.26,30,9,2),(492,'Butter In a Lordly Dish',22.40,11.10,8.01,29,12,5),(493,'Absalom, Absalom!',26.42,9.99,12.17,24,4,7),(494,'Mother Night',47.37,10.58,12.23,39,12,5),(495,'Such, Such Were the Joys',43.73,9.47,10.55,7,12,6),(496,'A Passage to India',20.91,8.18,11.29,14,8,3),(497,'Look to Windward',38.17,9.56,10.05,19,5,5),(498,'The Torment of Others',17.14,12.48,12.72,40,12,4),(499,'A Glass of Blessings',36.69,9.12,10.92,25,6,1),(500,'Tender Is the Night',24.60,8.74,8.90,6,4,4),(511,'Busotina radi dobro',37.45,10.38,11.05,5,13,4),(523,'Kracer išao dobro',37.47,9.80,10.38,3,1,7),(524,'hhhhhhhhhhhhhhhhhhhhhh',38.09,12.09,13.09,1,1,1),(533,'Dotegnuta štopiksa gl.šipke',9.00,10.00,11.00,3,14,4),(534,'Sve radi super',38.09,10.00,12.09,10,18,8),(536,NULL,NULL,NULL,NULL,9,9,2),(538,'bušotina radi dobro',9.00,10.00,12.00,4,19,6),(539,'Sve je radilo dobro',10.00,11.00,12.00,7,23,7),(542,'Sve radilo dobro',0.00,0.00,0.00,10,22,10),(546,'sve radilo dobro',9.00,10.00,11.00,7,25,7),(547,'Promjenjeno pakovanje gl.šipke',9.00,10.00,11.00,1,26,1),(548,'bušotina radi dobro',10.00,11.00,12.00,3,27,7),(549,'sve radi dobro',9.00,10.50,11.00,2,23,7),(550,'Bušotina radi dobro',9.00,10.00,11.00,6,29,8),(552,'Bušotina radi dobro',9.00,10.00,11.00,4,31,7),(553,'Bušotina radi dobro',9.00,10.00,11.00,2,32,7),(555,'Nema napomene',0.00,0.00,0.00,4,33,1),(556,'Bušotina radi dobro',9.00,10.00,11.00,7,34,4),(557,'Kugla aktivirana , bušotina radi dobro',9.00,10.00,11.00,16,34,3),(558,'Kugla aktivirana, bušotina radi dobro',10.00,11.00,12.00,10,35,3),(559,'Bušotina radi dobro',9.00,10.00,11.00,15,31,4);
/*!40000 ALTER TABLE `posaobusotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaposlenik`
--

DROP TABLE IF EXISTS `zaposlenik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zaposlenik` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `oib` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `radnoMjesto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaposlenik`
--

LOCK TABLES `zaposlenik` WRITE;
/*!40000 ALTER TABLE `zaposlenik` DISABLE KEYS */;
INSERT INTO `zaposlenik` VALUES (1,'r.paco@yahoo.com','Robert','33823900947','Pačarić','Viši mobilni operater 3'),(2,'d.kovac@hotmail.com','Dinko','93811318286','Kovač','Viši mobilni operater 1'),(3,'d.mikicic@hotmail.com','Dragan','30625038428','Mikičić','Viši mobilni operater 2'),(4,'z.tusek@gmail.com','Zoran ','24741707585','Tušek','Viši mobilni operater 1'),(5,'m.peric@gmail.com','Mario','61294350108','Perić','Viši mobilni operater 2'),(6,'i.plesa@hotmail.com','Ivica ','14042023618','Pleša','Viši mobilni operater 1'),(7,'s.zivkovic@hotmail.com','Silvio','82520436145','Živković','Viši mobilni operater 1 '),(8,'z.jazo@yahoo.com','Žejlko','65406625966','Jazvanac','Viši mobilni operter 1'),(9,'a.zagar@yahoo.com','Ante','04230057300','Žagar','Viši mobilni operater 1'),(10,'j.tomic@hotmail.com','Josip','75329897603','Tomić','Viši mobilni operater 2'),(11,'n.ružić@gmail.com','Nikola','88534563091','Ružić-Mak','Viši mobilni operater 3');
/*!40000 ALTER TABLE `zaposlenik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'otpremnastanicahib'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-24 14:02:31
