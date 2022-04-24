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
  `ghiChu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `viTriGhe` int DEFAULT NULL,
  PRIMARY KEY (`maChiTietVe`),
  KEY `maXe_idx` (`maXe`),
  KEY `fk_chtietxe_vexe_idx` (`maVe`),
  CONSTRAINT `fk_chitietve_xe` FOREIGN KEY (`maXe`) REFERENCES `xe` (`maXe`),
  CONSTRAINT `fk_chtietxe_vexe` FOREIGN KEY (`maVe`) REFERENCES `vexe` (`maVe`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietvexe`
--

LOCK TABLES `chitietvexe` WRITE;
/*!40000 ALTER TABLE `chitietvexe` DISABLE KEYS */;
INSERT INTO `chitietvexe` VALUES (1,1,1,NULL,3),(2,2,2,NULL,4),(3,3,1,NULL,6),(4,4,4,NULL,4);
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
  `tenChuyenXe` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioKhoiHanh` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngayDi` datetime DEFAULT NULL,
  `gia` float DEFAULT '3',
  `maTuyen` int NOT NULL,
  `maXe` int DEFAULT NULL,
  PRIMARY KEY (`maChuyenXe`),
  KEY `fk_idx` (`maTuyen`),
  KEY `fk_xe_idx` (`maXe`),
  CONSTRAINT `fk` FOREIGN KEY (`maTuyen`) REFERENCES `tuyenxe` (`maTuyen`),
  CONSTRAINT `fk_xe_chuyenXe` FOREIGN KEY (`maXe`) REFERENCES `xe` (`maXe`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuyenxe`
--

LOCK TABLES `chuyenxe` WRITE;
/*!40000 ALTER TABLE `chuyenxe` DISABLE KEYS */;
INSERT INTO `chuyenxe` VALUES (1,'SaiGon-BinhDinh','23:50:00','2022-04-26 00:00:00',300,1,1),(2,'SaiGon-KonTom','10:45:00','2022-04-24 00:00:00',350,3,2),(3,'SG-BD_PhuongTrang','11:45:00','2022-04-24 00:00:00',320,1,3),(4,'SG-BD2','11:05:00','2022-04-24 00:00:00',310,1,4);
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
  `tenKh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioiTinh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diaChi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `soDienThoai` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`maKh`),
  UNIQUE KEY `dienThoai_UNIQUE` (`soDienThoai`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Nam','Nam','Binh Dinh','123'),(2,'Vu','Nam','KomTom','12345678'),(11,'nam',NULL,NULL,'999');
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
  `tenLoaiNv` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`maLoaiNv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loainhanvien`
--

LOCK TABLES `loainhanvien` WRITE;
/*!40000 ALTER TABLE `loainhanvien` DISABLE KEYS */;
INSERT INTO `loainhanvien` VALUES (1,'Quan tri'),(2,'Phong ve');
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
  `tenNv` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaySinh` date DEFAULT NULL,
  `gioiTinh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diaChi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `soDiienThoai` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `loaiNv` int NOT NULL,
  PRIMARY KEY (`maNv`),
  UNIQUE KEY `loaiNv_UNIQUE` (`loaiNv`),
  KEY `loaiNv_idx` (`loaiNv`),
  CONSTRAINT `fk_nv_loainv` FOREIGN KEY (`loaiNv`) REFERENCES `loainhanvien` (`maLoaiNv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Messi',NULL,NULL,NULL,NULL,1),(2,'Reus',NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quydinh`
--

DROP TABLE IF EXISTS `quydinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quydinh` (
  `maQuyDinh` int NOT NULL AUTO_INCREMENT,
  `thoiGianChamNhatDatVe` int DEFAULT NULL,
  `thoiGianChamNhatMuaVe` int DEFAULT NULL,
  `thoiGianChamNhatNhanVe` int DEFAULT NULL,
  `thoiGianChamNhatDoiHuyVe` int DEFAULT NULL,
  `thoiGianVeThuHoi` int DEFAULT NULL,
  PRIMARY KEY (`maQuyDinh`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quydinh`
--

LOCK TABLES `quydinh` WRITE;
/*!40000 ALTER TABLE `quydinh` DISABLE KEYS */;
INSERT INTO `quydinh` VALUES (1,60,5,30,60,5);
/*!40000 ALTER TABLE `quydinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongtincacchuyenxe`
--

DROP TABLE IF EXISTS `thongtincacchuyenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongtincacchuyenxe` (
  `maChuyenXe` int DEFAULT NULL,
  `noiDi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `noiDen` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngayDi` date DEFAULT NULL,
  `gioKhoiHanh` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gia` float DEFAULT NULL,
  `gheConTrong` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtincacchuyenxe`
--

LOCK TABLES `thongtincacchuyenxe` WRITE;
/*!40000 ALTER TABLE `thongtincacchuyenxe` DISABLE KEYS */;
/*!40000 ALTER TABLE `thongtincacchuyenxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuyenxe`
--

DROP TABLE IF EXISTS `tuyenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuyenxe` (
  `maTuyen` int NOT NULL AUTO_INCREMENT,
  `tenTuyen` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `noiDi` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `noiDen` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`maTuyen`),
  UNIQUE KEY `tenTuyen_UNIQUE` (`tenTuyen`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuyenxe`
--

LOCK TABLES `tuyenxe` WRITE;
/*!40000 ALTER TABLE `tuyenxe` DISABLE KEYS */;
INSERT INTO `tuyenxe` VALUES (1,'SG-BD','SaiGon','BinhDinh'),(2,'BD-SG','BinhDinh','SaiGon'),(3,'SG-KT','SaiGon','KomTom');
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
  `maNv` int NOT NULL,
  `maKh` int NOT NULL,
  `maChuyenXe` int NOT NULL,
  `trangThaiVe` tinyint DEFAULT NULL,
  PRIMARY KEY (`maVe`),
  KEY `fk_vexe_nv_idx` (`maNv`),
  KEY `fk_vexe_kh_idx` (`maKh`),
  KEY `fk_vexe_chuyenxe_idx` (`maChuyenXe`),
  CONSTRAINT `fk_vexe_chuyenxe` FOREIGN KEY (`maChuyenXe`) REFERENCES `chuyenxe` (`maChuyenXe`) ON DELETE CASCADE,
  CONSTRAINT `fk_vexe_kh` FOREIGN KEY (`maKh`) REFERENCES `khachhang` (`maKh`),
  CONSTRAINT `fk_vexe_nv` FOREIGN KEY (`maNv`) REFERENCES `nhanvien` (`maNv`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vexe`
--

LOCK TABLES `vexe` WRITE;
/*!40000 ALTER TABLE `vexe` DISABLE KEYS */;
INSERT INTO `vexe` VALUES (1,2,1,1,1),(2,2,2,2,1),(3,2,2,1,1),(4,2,1,4,0);
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
  `tenXe` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `banSo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `soGhe` int DEFAULT NULL,
  PRIMARY KEY (`maXe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xe`
--

LOCK TABLES `xe` WRITE;
/*!40000 ALTER TABLE `xe` DISABLE KEYS */;
INSERT INTO `xe` VALUES (1,'Phuong Trang','59-b 12345',6),(2,'Thanh Buoi','59-c 6789',5),(3,'NamVu','77h1 6789',10),(4,'PhucLong','77h1 9876',8);
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

-- Dump completed on 2022-04-24 10:48:05
