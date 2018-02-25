CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
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
-- Table structure for table `abiturient`
--

DROP TABLE IF EXISTS `abiturient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abiturient` (
  `Id_Abiturient` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Last_Name` varchar(45) NOT NULL,
  `First_Name` varchar(45) NOT NULL,
  `Second_Name` varchar(45) DEFAULT NULL,
  `Address` varchar(150) NOT NULL,
  `Passport` varchar(45) NOT NULL,
  `Birthdate` date NOT NULL,
  `Id_Speciality` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Id_Abiturient`),
  UNIQUE KEY `idAbiturient_UNIQUE` (`Id_Abiturient`),
  KEY `Idx_Id_Speciality_Abiturient_idx` (`Id_Speciality`),
  KEY `Idx_Id_Speciality_Abitur_idx` (`Id_Speciality`),
  CONSTRAINT `Idx_Id_Speciality_Abitur` FOREIGN KEY (`Id_Speciality`) REFERENCES `speciality` (`Id_Speciality`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abiturient`
--

LOCK TABLES `abiturient` WRITE;
/*!40000 ALTER TABLE `abiturient` DISABLE KEYS */;
INSERT INTO `abiturient` VALUES (1,'Поттер','Гарри','Джеймс','Великобритания, графство Суррей, г.Литтлиуингыв, ул.Тисовая, д.4, чулан под лестницей','BM1234567','2000-07-31',1);
/*!40000 ALTER TABLE `abiturient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `Id_Abiturient` int(10) unsigned NOT NULL,
  `First_Exam` int(10) unsigned DEFAULT NULL,
  `Second_Exam` int(10) unsigned DEFAULT NULL,
  `Third_Exam` int(10) unsigned DEFAULT NULL,
  `Attestat` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id_Abiturient`),
  UNIQUE KEY `Id_Abiturient_UNIQUE` (`Id_Abiturient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `Id_Faculty` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) NOT NULL,
  PRIMARY KEY (`Id_Faculty`),
  UNIQUE KEY `Id_Faculty_UNIQUE` (`Id_Faculty`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Гриффиндор'),(3,'Когтевран'),(4,'Пуффендуй'),(2,'Слизерин');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m2m_abiturient_privilege`
--

DROP TABLE IF EXISTS `m2m_abiturient_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m2m_abiturient_privilege` (
  `Id_Abiturient` int(10) unsigned NOT NULL,
  `Id_Privilege` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Id_Abiturient`,`Id_Privilege`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m2m_abiturient_privilege`
--

LOCK TABLES `m2m_abiturient_privilege` WRITE;
/*!40000 ALTER TABLE `m2m_abiturient_privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `m2m_abiturient_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent` (
  `Id_Parent` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Full_Name` varchar(150) NOT NULL,
  `Passport` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Id_Abiturient` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Id_Parent`),
  UNIQUE KEY `Id_Parent_UNIQUE` (`Id_Parent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `Id_Privilege` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) NOT NULL,
  PRIMARY KEY (`Id_Privilege`),
  UNIQUE KEY `Id_Privilege_UNIQUE` (`Id_Privilege`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `speciality` (
  `Id_Speciality` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) NOT NULL,
  `Id_Faculty` int(10) unsigned NOT NULL,
  `First_Subject` int(10) unsigned NOT NULL,
  `Second_Subject` int(10) unsigned NOT NULL,
  `Third_Subject` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Id_Speciality`),
  UNIQUE KEY `Id_Speciality_UNIQUE` (`Id_Speciality`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT INTO `speciality` VALUES (1,'Магическое обеспечение информационных технологий',1,5,6,1),(2,'Магические системы и сети',1,3,6,8),(3,'Маркетинг зельеварения',2,3,4,5),(4,'Защита магических технологий',3,5,1,9),(5,'Системы телепортаций',4,5,6,7);
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `Id_Subject` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) NOT NULL,
  PRIMARY KEY (`Id_Subject`),
  UNIQUE KEY `Id_Subject_UNIQUE` (`Id_Subject`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (8,'Астрономия'),(5,'Заклинания'),(1,'Защита от темных искусств'),(3,'Зельеварение'),(6,'История магии'),(2,'Квиддич'),(9,'Прорицания'),(4,'Травология'),(7,'Трансфигурация');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `Id_User` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Login` varchar(45) NOT NULL,
  `Password_Hash` varchar(50) NOT NULL,
  `Role` int(10) unsigned NOT NULL,
  `Email` varchar(150) NOT NULL,
  PRIMARY KEY (`Id_User`),
  UNIQUE KEY `Id_User_UNIQUE` (`Id_User`),
  UNIQUE KEY `Login_UNIQUE` (`Login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mydb'
--

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-16  3:14:52
