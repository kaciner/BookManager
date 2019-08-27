/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.1.49-community : Database - db_book
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES , OLD_SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `bookTypeId` int(11) DEFAULT NULL,
  `bookDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookTypeId` (`bookTypeId`),
  CONSTRAINT `t_book_ibfk_1` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`bookName`,`author`,`sex`,`price`,`bookTypeId`,`bookDesc`) values (1,'java','xx','男',100,1,'');

/*Table structure for table `t_booktype` */

DROP TABLE IF EXISTS `t_booktype`;

CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) DEFAULT NULL,
  `bookTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_booktype` */

insert  into `t_booktype`(`id`,`bookTypeName`,`bookTypeDesc`) values (1,'计算机类','计算机相关图书');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`) values (1,'dubowen','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
