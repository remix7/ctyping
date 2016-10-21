/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.0.87-community-nt : Database - ctyping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ctyping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ctyping`;

/*Table structure for table `ctyping_exam_recodes` */

DROP TABLE IF EXISTS `ctyping_exam_recodes`;

CREATE TABLE `ctyping_exam_recodes` (
  `id` int(11) NOT NULL auto_increment,
  `exam_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `content` text,
  `useTime` varchar(5) default NULL,
  `updateTime` datetime default NULL,
  `state` varchar(1) default NULL,
  `remarks` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `exam_id` (`exam_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `ctyping_exam_recodes_ibfk_1` FOREIGN KEY (`exam_id`) REFERENCES `ctyping_exams` (`id`),
  CONSTRAINT `ctyping_exam_recodes_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `ctyping_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `ctyping_exams` */

DROP TABLE IF EXISTS `ctyping_exams`;

CREATE TABLE `ctyping_exams` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `beginTime` datetime default NULL,
  `endTime` datetime default NULL,
  `question_id` int(11) default NULL,
  `createTime` datetime default NULL,
  `state` varchar(1) default NULL,
  `remarks` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `ctyping_exams_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `ctyping_questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `ctyping_questions` */

DROP TABLE IF EXISTS `ctyping_questions`;

CREATE TABLE `ctyping_questions` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(100) default NULL,
  `content` text,
  `degree` varchar(10) default NULL,
  `contentLength` varchar(5) default NULL,
  `createTime` datetime default NULL,
  `state` varchar(1) default NULL,
  `remarks` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `ctyping_scores` */

DROP TABLE IF EXISTS `ctyping_scores`;

CREATE TABLE `ctyping_scores` (
  `id` int(11) NOT NULL auto_increment,
  `exam_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `content` text,
  `useTime` varchar(5) default NULL,
  `score` varchar(5) default NULL,
  `accuracy` varchar(5) default NULL,
  `ranking` int(11) default NULL,
  `createTime` datetime default NULL,
  `state` varchar(1) default NULL,
  `remarks` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `exam_id` (`exam_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `ctyping_scores_ibfk_1` FOREIGN KEY (`exam_id`) REFERENCES `ctyping_exams` (`id`),
  CONSTRAINT `ctyping_scores_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `ctyping_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `ctyping_users` */

DROP TABLE IF EXISTS `ctyping_users`;

CREATE TABLE `ctyping_users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(40) default NULL,
  `realname` varchar(10) default NULL,
  `stuNum` varchar(20) default NULL,
  `phoneNum` varchar(15) default NULL,
  `email` varchar(30) default NULL,
  `createTime` datetime default NULL,
  `state` varchar(1) default NULL,
  `remarks` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
