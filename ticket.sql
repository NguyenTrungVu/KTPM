CREATE DATABASE  IF NOT EXISTS `ticketdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ticketdb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketdb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `chitietvexe`
--

DROP TABLE IF EXISTS `chitietvexe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietvexe` (
  `maChiTietVe` int NOT NULL AUTO_INCREMENT,
  `maVe` int NOT NULL,
  `maXe` int NOT NULL,
  `maNv` int NOT NULL,
  `ghiChu` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `viTriGhe` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`maChiTietVe`),
  KEY `maXe_idx` (`maXe`),
  CONSTRAINT `maXe` FOREIGN KEY (`maXe`) REFERENCES `xe` (`maXe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietvexe`
--

LOCK TABLES `chitietvexe` WRITE;
/*!40000 ALTER TABLE `chitietvexe` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietvexe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chuyenxe`
--

DROP TABLE IF EXISTS `chuyenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuyenxe` (
  `maChuyenXe` int NOT NULL AUTO_INCREMENT,
  `tenChuyenXe` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioDi` time DEFAULT NULL,
  `gioDen` time DEFAULT NULL,
  `maNv` int DEFAULT NULL,
  PRIMARY KEY (`maChuyenXe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuyenxe`
--

LOCK TABLES `chuyenxe` WRITE;
/*!40000 ALTER TABLE `chuyenxe` DISABLE KEYS */;
/*!40000 ALTER TABLE `chuyenxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `maKh` int NOT NULL AUTO_INCREMENT,
  `tenKh` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioiTinh` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dienThoai` int DEFAULT NULL,
  PRIMARY KEY (`maKh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loainhanvien`
--

DROP TABLE IF EXISTS `loainhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loainhanvien` (
  `maLoaiNv` int NOT NULL AUTO_INCREMENT,
  `tenLoaiNv` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maLoaiNv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loainhanvien`
--

LOCK TABLES `loainhanvien` WRITE;
/*!40000 ALTER TABLE `loainhanvien` DISABLE KEYS */;
/*!40000 ALTER TABLE `loainhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNv` int NOT NULL AUTO_INCREMENT,
  `tenNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaySinh` datetime DEFAULT NULL,
  `gioiTinh` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dienThoai` int DEFAULT NULL,
  `loaiNv` int DEFAULT NULL,
  PRIMARY KEY (`maNv`),
  KEY `loaiNv_idx` (`loaiNv`),
  CONSTRAINT `loaiNv` FOREIGN KEY (`loaiNv`) REFERENCES `loainhanvien` (`maLoaiNv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuyenxe`
--

DROP TABLE IF EXISTS `tuyenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuyenxe` (
  `maTuyen` int NOT NULL AUTO_INCREMENT,
  `tenTuyen` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diemDi` varchar(255) DEFAULT NULL,
  `bangGia` double DEFAULT NULL,
  `diemDen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maTuyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuyenxe`
--

LOCK TABLES `tuyenxe` WRITE;
/*!40000 ALTER TABLE `tuyenxe` DISABLE KEYS */;
/*!40000 ALTER TABLE `tuyenxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vexe`
--

DROP TABLE IF EXISTS `vexe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vexe` (
  `maVe` int NOT NULL AUTO_INCREMENT,
  `giaTien` double DEFAULT NULL,
  `maNv` int DEFAULT NULL,
  `maKh` int DEFAULT NULL,
  `maChuyenXe` int DEFAULT NULL,
  PRIMARY KEY (`maVe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vexe`
--

LOCK TABLES `vexe` WRITE;
/*!40000 ALTER TABLE `vexe` DISABLE KEYS */;
/*!40000 ALTER TABLE `vexe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xe`
--

DROP TABLE IF EXISTS `xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xe` (
  `maXe` int NOT NULL AUTO_INCREMENT,
  `tenXe` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `banSo` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `soGhe` int DEFAULT NULL,
  PRIMARY KEY (`maXe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xe`
--

LOCK TABLES `xe` WRITE;
/*!40000 ALTER TABLE `xe` DISABLE KEYS */;
/*!40000 ALTER TABLE `xe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-17  9:40:30
