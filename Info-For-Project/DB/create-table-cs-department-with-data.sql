-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for computer-science-faculty
CREATE DATABASE IF NOT EXISTS `computer-science-faculty` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `computer-science-faculty`;

-- Dumping structure for table computer-science-faculty.disciplines
CREATE TABLE IF NOT EXISTS `disciplines` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `credits` int(11) DEFAULT 0,
  `teacher_pk` int(11) DEFAULT NULL,
  `students_signed` int(11) DEFAULT 0,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `disciplines_pk_uindex` (`pk`),
  UNIQUE KEY `disciplines_name_uindex` (`name`),
  KEY `teacher_pk` (`teacher_pk`),
  CONSTRAINT `teacher_pk` FOREIGN KEY (`teacher_pk`) REFERENCES `teachers` (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Dumping data for table computer-science-faculty.disciplines: ~3 rows (approximately)
REPLACE INTO `disciplines` (`pk`, `name`, `credits`, `teacher_pk`, `students_signed`) VALUES
	(2, 'Algebra', 25, 1, 1),
	(13, 'Networking basic', 20, 1, 0),
	(14, 'OOP basic', 30, 5, 0);

-- Dumping structure for table computer-science-faculty.journal
CREATE TABLE IF NOT EXISTS `journal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discipline_fk` int(11) DEFAULT NULL,
  `student_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `journal_id_uindex` (`id`),
  KEY `discipline_fk` (`discipline_fk`),
  KEY `student_fk` (`student_fk`),
  CONSTRAINT `discipline_fk` FOREIGN KEY (`discipline_fk`) REFERENCES `disciplines` (`pk`),
  CONSTRAINT `student_fk` FOREIGN KEY (`student_fk`) REFERENCES `students` (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table computer-science-faculty.journal: ~1 rows (approximately)
REPLACE INTO `journal` (`id`, `discipline_fk`, `student_fk`) VALUES
	(11, 2, 6);

-- Dumping structure for table computer-science-faculty.students
CREATE TABLE IF NOT EXISTS `students` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `year_in_uni` int(11) DEFAULT NULL,
  `credits` int(11) DEFAULT 0,
  `count_of_studies` int(11) DEFAULT 0,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `students_pk_uindex` (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table computer-science-faculty.students: ~9 rows (approximately)
REPLACE INTO `students` (`pk`, `first_name`, `last_name`, `year_in_uni`, `credits`, `count_of_studies`) VALUES
	(1, 'Ivan', 'Ivanov', 1, 0, 0),
	(2, 'Petar', 'Petrov', 2, 0, 0),
	(3, 'Stoyan', 'Kostov', 3, 0, 0),
	(6, 'Grigorii', 'Vazov', 2, 25, 1),
	(7, 'Asen', 'Petkov', 1, 0, 0),
	(8, 'Mariela', 'Kirilova', 2, 0, 0),
	(9, 'Karolina', 'Kirilova', 2, 0, 0),
	(10, 'Ivan', 'Botev', 3, 0, 0),
	(12, 'Kalin', 'Penchev', 1, 0, 0),
	(15, 'Martin', 'Nikolov', 2, 0, 0);

-- Dumping structure for table computer-science-faculty.teachers
CREATE TABLE IF NOT EXISTS `teachers` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `title` varchar(60) DEFAULT NULL,
  `discipline_count` int(11) DEFAULT 0,
  `students_count` int(11) DEFAULT 0,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `teachers_pk_uindex` (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table computer-science-faculty.teachers: ~4 rows (approximately)
REPLACE INTO `teachers` (`pk`, `first_name`, `last_name`, `title`, `discipline_count`, `students_count`) VALUES
	(1, 'Petar', 'Petrov', 'Professor', 2, 1),
	(2, 'Ivan', 'Nikolaev', 'Instructor', 0, 0),
	(3, 'Yassen', 'Bonev', 'Associate Professor', 0, 0),
	(5, 'John', 'Atanasov', 'Professor', 1, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
