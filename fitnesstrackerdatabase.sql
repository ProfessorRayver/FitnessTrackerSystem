CREATE DATABASE  IF NOT EXISTS `fitnesstrackerdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fitnesstrackerdb`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: fitnesstrackerdb
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bmi_data`
--

DROP TABLE IF EXISTS `bmi_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bmi_data` (
  `username` varchar(200) NOT NULL,
  `weight` int NOT NULL,
  `height` double NOT NULL,
  `bmi` int NOT NULL,
  `bmi_category` varchar(200) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bmi_data`
--

LOCK TABLES `bmi_data` WRITE;
/*!40000 ALTER TABLE `bmi_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `bmi_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumedtbl`
--

DROP TABLE IF EXISTS `consumedtbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumedtbl` (
  `mealname` varchar(100) NOT NULL,
  `mealtime` varchar(45) NOT NULL,
  `carbohydrates` double NOT NULL,
  `fat` double NOT NULL,
  `protein` double NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumedtbl`
--

LOCK TABLES `consumedtbl` WRITE;
/*!40000 ALTER TABLE `consumedtbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumedtbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mealtbl`
--

DROP TABLE IF EXISTS `mealtbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mealtbl` (
  `mealname` varchar(100) NOT NULL,
  `carbohydrates` double NOT NULL,
  `fat` double NOT NULL,
  `protein` double NOT NULL,
  PRIMARY KEY (`mealname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mealtbl`
--

LOCK TABLES `mealtbl` WRITE;
/*!40000 ALTER TABLE `mealtbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `mealtbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idusers` varchar(250) NOT NULL,
  `idpass` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `sex` varchar(250) NOT NULL,
  `age` int NOT NULL,
  UNIQUE KEY `user_id_UNIQUE` (`idusers`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_log`
--

DROP TABLE IF EXISTS `workout_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_log` (
  `selected` varchar(250) NOT NULL,
  `calories_burned` double NOT NULL,
  `logdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_log`
--

LOCK TABLES `workout_log` WRITE;
/*!40000 ALTER TABLE `workout_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `workout_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workoutplan`
--

DROP TABLE IF EXISTS `workoutplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workoutplan` (
  `currentworkoutplan` varchar(1000) NOT NULL,
  `workoutplancol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workoutplan`
--

LOCK TABLES `workoutplan` WRITE;
/*!40000 ALTER TABLE `workoutplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `workoutplan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-16  1:26:07
