-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gadgetbadget
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `Item_id` int NOT NULL AUTO_INCREMENT,
  `Item_Name` varchar(300) NOT NULL,
  `Item_Desc` varchar(800) NOT NULL,
  `Item_price` varchar(100) NOT NULL,
  `Stock_qty` int NOT NULL,
  PRIMARY KEY (`Item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (23,'Hangbag','100%25+natural+organic+real+coconut+women+Hangbag','100.0',11),(24,'Necklace','100%252525%252Bnatural%252Borganic%252Breal%252Bcoconut%252Bwomen%252BNecklace','100.0',450),(34,'Plastic flowers','he magic of science makes these recycled plastic flowers beautiful','350.0',50);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `Proj_id` int NOT NULL AUTO_INCREMENT,
  `Proj_type` varchar(400) NOT NULL,
  `Proj_name` varchar(400) NOT NULL,
  `Proj_link` varchar(1200) NOT NULL,
  `Proj_Desc` varchar(1200) NOT NULL,
  `Price` varchar(100) NOT NULL,
  `Submit_date` varchar(100) NOT NULL,
  PRIMARY KEY (`Proj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (2,'Java','Resturent management','https://drive.google.com/file/d/1DQuIHjBdxsLVCod9ZSKXBU86MQ8_1a3-/view?usp=sharing','DineOut is an Android based Restaurant Management System including ordering, billing kitchen, hall and inventory management.','5000.0','04/13/2021'),(3,'Php','Hospital Management','https://drive.google.com/file/d/1cJKWYpOlmpCBalK-aL7uku0xF8v9ANoB/view?usp=sharing','Using XAMMP including chanelling docter,get repot','60000.0','04/14/2021'),(6,'Java','Employeee management','https://drive.google.com/file/d/1G6Sxk8Z4nB2GHVc8IsGWuTc_xc4eq2cu/view?usp=sharing','complete crud opeation','30000.0','04/21/20211'),(13,'C#','Resturent management','https://drive.google.com/file/d/1G6Sxk8Z4nB2GHVc8IsGWuTc_xc4eq2cu/view?usp=sharing','menu management,order management,delivery management','20000','04/22/2021'),(26,'Python','online banking','https://drive.google.com/file/d/1DQuIHjBdxsLVCod9ZSKXBU86MQ8_1a3-/view?usp=sharing','completed project','12000.00','5.13.2021');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-13 19:20:50
