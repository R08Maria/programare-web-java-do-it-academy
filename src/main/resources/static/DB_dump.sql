-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: do_it_academy
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `program` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `description` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'C sharp',31,'1.Introducere in C#, 2.Structuri conditionale, structuri repetitive, 3.Introducere OOP, 4.OOP partea a 2-a, 5.Aplicatie desktop partea I, 6.Aplicatie desktop parte a II-a','Cursul se adreseaza persoanelor care vor sa invete bazele programrii in C# (frameworkul .NET), indiferent daca au sau nu cunostinte tehnice. Nu sunt necesare alte cunostinte de programre pentru a urma acest curs (bineinteles daca acestea exista va vor ajuta)'),(2,'Java',32,'1.Introducere in Java, 2.Variabile, tipuri de date, operatori, 3.Clase si obiecte, 4.Conceptele programrii orientate pe obiect, 5.Modificatori de acces, 6.Incapsulare, recursivitate, 7.Baze de date in Java, 8.Aplicatie Desktop, 9.Aplicatie finala','Cursul se adreseaza persoanelor care doresc sa faca primii si cei mai grei pasi catre programre. Aceasta directie este una cu un potential urias atat in Romania cat si la nivel global. Nu sunt necesare alte cunostinte de programre pentru a urma acest curs.'),(3,'Python',27,'1.Introducere in Java, 2.Secvente decizionale si repetitive, 3.Structuri de date, 4.Operatii cu fisiere, 5.Module, 6.WEB SCRAPPING, 7.OOP, 8.Recapitulare examen final, 9.Examen final','Cursul se adreseaza persoanelor care vor sa invete bazele programrii utilizand ca limbaj python, indiferent daca au sau nu cunostinte tehnice.'),(4,'HTML, CSS, JavaScript',27,'1.Introducere notiuni FRONT-END, introducere HTML, 2.HTML, CSS, 3.CSS - Partea a II-a, 4.BOOTSTRAP, 5.JAVASCRIPT, 6.JAVASCRIPT partea a II-a, DOM, 7.JSON, 8.Recapitulare, alegere tema proiect final, 9.Prezentare aplicatie finala','Cursul se adreseaza persoanelor care vor sa invete bazele dezvoltarii interfetelor grafice pentru aplicatii web folosind HTML, CSS, Bootstrap si JavaScript, indiferent daca au sau nu cunostinte tehnice.'),(5,'Baze de date',27,'1.Introducere, 2.Tabele, 3.Legaturi intre tabele, 4.Indexarea bazelor de date, 5.View si tabele temporare, 6.Proceduri, functii, triggeri, 7.Tranzactii, 8.Exercitii recapitulative, 9.Aplicatie finala','Cursul “Baze de date MySql” se adreseaza celor care doresc sa-si insuseasca notiunile elementare despre utilizarea, proiectarea si administrarea bazelor de date.'),(6,'Linux',27,'1.Introducere, istoric, structura unui sistem Linux, 2.Instalare, partitionare, 3.Lucru cu CLI, 4.Drepturi si permisiuni, 5.Procese si servicii, 6.Basic Networking, 7.Introducere in Basic Bash Scripting, 8.Recapitulare examen final, 9.Examen final','Cursul se adreseaza persoanelor care vor sa invete sistemul de operare Linux, indiferent daca au sau nu cunostinte tehnice.'),(7,'Linux12',27,'1.Introducere, istoric, structura unui sistem Linux, 2.Instalare, partitionare, 3.Lucru cu CLI, 4.Drepturi si permisiuni, 5.Procese si servicii, 6.Basic Networking, 7.Introducere in Basic Bash Scripting, 8.Recapitulare examen final, 9.Examen final','Cursul se adreseaza persoanelor care vor sa invete sistemul de operare Linux, indiferent daca au sau nu cunostinte tehnice.'),(12,'Baze de date nivel incepator',30,'1.Introducere, 2.Tabele, 3.Legaturi intre tabele, 4.Indexarea bazelor de date, 5.View si tabele temporare, 6.Proceduri, functii, triggeri, 7.Tranzactii, 8.Exercitii recapitulative, 9.Aplicatie finala','Cursul “Baze de date MySql” se adreseaza celor care doresc sa-si insuseasca notiunile elementare despre utilizarea, proiectarea si administrarea bazelor de date.'),(13,'Baze de date nivel avansat',30,'1.Introducere, 2.Tabele, 3.Legaturi intre tabele, 4.Indexarea bazelor de date, 5.View si tabele temporare, 6.Proceduri, functii, triggeri, 7.Tranzactii, 8.Exercitii recapitulative, 9.Aplicatie finala','Cursul “Baze de date MySql” se adreseaza celor care doresc sa-si insuseasca notiunile elementare despre utilizarea, proiectarea si administrarea bazelor de date.'),(14,'Baze de date5',27,'1.Introducere, 2.Tabele, 3.Legaturi intre tabele, 4.Indexarea bazelor de date, 5.View si tabele temporare, 6.Proceduri, functii, triggeri, 7.Tranzactii, 8.Exercitii recapitulative, 9.Aplicatie finala','Cursul “Baze de date MySql” se adreseaza celor care doresc sa-si insuseasca notiunile elementare despre utilizarea, proiectarea si administrarea bazelor de date.'),(15,'Baze de date10',27,'1.Introducere, 2.Tabele, 3.Legaturi intre tabele, 4.Indexarea bazelor de date, 5.View si tabele temporare, 6.Proceduri, functii, triggeri, 7.Tranzactii, 8.Exercitii recapitulative, 9.Aplicatie finala','Cursul “Baze de date MySql” se adreseaza celor care doresc sa-si insuseasca notiunile elementare despre utilizarea, proiectarea si administrarea bazelor de date.');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructors`
--

DROP TABLE IF EXISTS `instructors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `instructors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructors`
--

LOCK TABLES `instructors` WRITE;
/*!40000 ALTER TABLE `instructors` DISABLE KEYS */;
INSERT INTO `instructors` VALUES (1,'Vasile','Preda','0771243095','vasile.preda@doitacademy.ro'),(2,'Cristi','Mazilu','0757896325','cristi.mazilu@doitacademy.ro'),(3,'Vlad','Stan','0768521478','vlad.stan@doitacademy.ro'),(4,'Vlad','Manicescu','0741234567','vlad.manicescu@doitacademy.ro'),(5,'Lucian','Voica','0741234567','lucian.voica@doitacademy.ro'),(6,'Maziluuu','Cristi','0757896325','cristi.mazilu@doitacademy.ro'),(7,'Ana','Mazilu','0757896325','cristi.mazilu@doitacademy.ro'),(8,'Bogdan','Popescu','0757896325','cristi.mazilu@doitacademy.ro');
/*!40000 ALTER TABLE `instructors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leads`
--

DROP TABLE IF EXISTS `leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_date` date DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `conversation_summary` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leads`
--

LOCK TABLES `leads` WRITE;
/*!40000 ALTER TABLE `leads` DISABLE KEYS */;
INSERT INTO `leads` VALUES (1,'Ana','Dragomir','0741234567','dragomir.alina@yahoo.com','2020-02-26','1985-03-10','Revine dupa ce se decide daca se inscrie la cursul Java sau Python'),(2,'Mihaela','Serban','0757896325','serban.mihaela@yahoo.com','2020-02-18','1980-07-16','De revenit cand este disponibil un curs de Baze de date pentru avansati'),(3,'Bogdan','Popescu','0768521478','popescu.bogdan@gmail.com','2020-03-10','1990-06-04','De revenit in toamna pentru cursul Linux'),(4,'Daniel','Stan','0741234567','stan.daniel@gmail.com','2020-05-08','2000-09-17','A facut plata curs C#'),(5,'Mihai','Bran','0746541235','bran.mihai@gmail.com','2020-04-15','1995-12-09','Este interesat de cursul de HTML, de trimis detalii pe mail'),(6,'Bianca','Olteanu','0737893694','olteanu.bianca@yahoo.com','2020-05-15','1984-03-04','Este interesata de cursul de Python, Baze de date de trimis detalii pe mail'),(7,'Victor','Ionescu','0725642318','ionescu.victor@gmail.com','2020-04-20','1987-04-14','Este interesat de cursul de Java, de trimis detalii pe mail'),(8,'Ioana','Radu','0763129182','radu.ioana@gmail.com','2020-05-14','1988-01-09','A facut plata curs Python'),(9,'Vlad','Pascu','0724391825','pascu.vlad@yahoo.com','2020-05-12','1986-10-17','A facut plata curs Java'),(10,'Andreea','Neagu','0759631475','neagu.andreea@gmail.com','2020-04-19','1985-11-22','Este interesata de cursul Baze de date, de trimis detalii pe mail'),(11,'Ramona','Andone','0749512473','andone.ramona@yahoo.com','2020-04-26','1987-04-11','A facut plata curs Java'),(12,'Valentin','Constantin','0761679348','constantin.valentin@yahoo.com','2020-01-30','1985-07-16','A facut plata curs C#'),(13,'Elena','Ardeleanu','0768985467','ardeleanu.elena@gmail.com','2020-03-19','1992-04-04','A facut plata curs Python'),(14,'Andrei','Zota','0767345827','zota.andrei@gmail.com','2019-11-08','1999-07-17','A facut plata curs Baze de date si Java'),(15,'Diana','Oprea','0728649732','oprea.diana@gmail.com','2020-01-29','1990-08-03','A facut plata curs HTML'),(16,'Daniela','Iacob','0758574691','iacob.daniela@yahoo.com','2020-04-12','1998-03-19','A facut plata curs C#'),(17,'George','Agavriloaie','076547892','agavriloaie.george@gmail.com','2020-04-04','1996-11-18','De revenit cand avem courses de HTML pentru avansati'),(18,'Alexandru','Rosu','0763129182','rosu.alexandru@gmail.com','2020-05-10','1988-02-03','A facut plata pentru cursul HTML'),(19,'Alin','Pristavu','0724391825','pristavu.alin@yahoo.com','2020-04-22','1989-11-10','A facut plata pentru cursul Python si Baze de date'),(20,'Ana-Maria','Ilie','0759631475','ilie.ana@gmail.com','2020-04-06','1997-11-01','A facut plata pentru cursul HTML si Java'),(21,'Rosu','Alexandru','0763129182','rosu.alexandru@gmail.com','2020-05-10','1988-02-03','A facut plata pentru cursul HTML');
/*!40000 ALTER TABLE `leads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learners`
--

DROP TABLE IF EXISTS `learners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `learners` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_session` int(11) NOT NULL,
  `id_lead` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_session` (`id_session`),
  KEY `learners_ibfk_2` (`id_lead`),
  CONSTRAINT `learners_ibfk_1` FOREIGN KEY (`id_session`) REFERENCES `sessions` (`id`),
  CONSTRAINT `learners_ibfk_2` FOREIGN KEY (`id_lead`) REFERENCES `leads` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learners`
--

LOCK TABLES `learners` WRITE;
/*!40000 ALTER TABLE `learners` DISABLE KEYS */;
INSERT INTO `learners` VALUES (1,6,4),(2,4,8),(3,3,9),(4,3,11),(5,6,12),(6,4,13),(7,3,14),(8,2,14),(9,7,15),(10,6,16),(11,7,18),(12,4,19),(13,2,19),(14,3,20),(15,7,20),(37,7,1);
/*!40000 ALTER TABLE `learners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferences`
--

DROP TABLE IF EXISTS `preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `preferences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_course` int(11) NOT NULL,
  `id_lead` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_courses` (`id_course`),
  KEY `id_lead` (`id_lead`),
  CONSTRAINT `preferences_ibfk_1` FOREIGN KEY (`id_course`) REFERENCES `courses` (`id`),
  CONSTRAINT `preferences_ibfk_2` FOREIGN KEY (`id_lead`) REFERENCES `leads` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferences`
--

LOCK TABLES `preferences` WRITE;
/*!40000 ALTER TABLE `preferences` DISABLE KEYS */;
INSERT INTO `preferences` VALUES (2,3,1),(3,5,2),(4,6,3),(5,1,4),(6,4,5),(7,3,6),(8,5,6),(9,2,7),(10,3,8),(11,2,9),(12,5,10);
/*!40000 ALTER TABLE `preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_instructor` int(11) NOT NULL,
  `id_course` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `live` tinyint(4) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_instructor` (`id_instructor`),
  KEY `id_course` (`id_course`),
  CONSTRAINT `sessions_ibfk_1` FOREIGN KEY (`id_instructor`) REFERENCES `instructors` (`id`),
  CONSTRAINT `sessions_ibfk_2` FOREIGN KEY (`id_course`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (1,1,1,'C# Mai 2020',0,'2021-05-15',700,15),(2,2,2,'MySQL August 2020',1,'2020-08-06',490,2),(3,3,3,'Java Iunie 2020',1,'2021-05-10',700,12),(4,4,4,'Python Iunie 2020',1,'2020-05-11',600,15),(5,5,5,'Linux August 2020',1,'2020-08-18',490,15),(6,1,6,'C# Iunie 2020',1,'2020-05-02',490,15),(7,2,5,'HTML Iunie 2020',1,'2020-05-08',490,15),(8,1,4,'C# Iunie 2021',1,'2021-05-06',590,15);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` enum('admin','instructor','learner') CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'instructor','vlad','vlad@doitacademy','dcae1f1d5c4b292623da25c42c000562'),(2,'admin','maria','maria@doitacademy','80c9ef0fb86369cd25f90af27ef53a9e'),(3,'learner','ana','ana@doitacademy','94f3b3a16d8ce064c808b16bee5003c5');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-15 17:05:42
