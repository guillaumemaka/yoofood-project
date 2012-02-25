delimiter $$

DROP DATABASE IF EXISTS notetonsta $$

CREATE DATABASE `notetonsta` /*!40100 DEFAULT CHARACTER SET latin1 */$$

DROP TABLE IF EXISTS campus $$

CREATE TABLE `campus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8$$

DROP TABLE IF EXISTS interventions $$

CREATE TABLE `interventions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `startDate` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `endDate` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `description` longtext CHARACTER SET utf8,
  `campus_id` int(11) DEFAULT NULL,
  `speaker_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `campus_fk` (`campus_id`),
  KEY `speaker_fk` (`speaker_id`),
  CONSTRAINT `campus_fk` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `speaker_fk` FOREIGN KEY (`speaker_id`) REFERENCES `speakers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1$$


DROP TABLE IF EXISTS marks $$

CREATE TABLE `marks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `speaker_mark` double DEFAULT NULL,
  `slide_mark` double DEFAULT NULL,
  `intervention_id` int(11) DEFAULT NULL,
  `idbooster` varchar(45) DEFAULT NULL,
  `coment` longtext,
  PRIMARY KEY (`id`),
  KEY `intervention_fk` (`intervention_id`),
  KEY `FK62DD346827F397F` (`intervention_id`),
  KEY `FK62DD346827F39D5` (`intervention_id`),
  CONSTRAINT `FK62DD346827F39D5` FOREIGN KEY (`intervention_id`) REFERENCES `interventions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8$$


DROP TABLE IF EXISTS speakers $$

CREATE TABLE `speakers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8$$


