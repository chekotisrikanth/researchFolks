CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`account_type`, `designation`, `profile_pic`, `id`) VALUES ('test','it',NULL,32768);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

/*!40000 ALTER TABLE `app_user_user_profile` DISABLE KEYS */;
INSERT INTO `app_user_user_profile` (`user_id`, `user_profile_id`) VALUES (1,1),(32768,2),(32769,3);
/*!40000 ALTER TABLE `app_user_user_profile` ENABLE KEYS */;

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`country_id`, `country_name`) VALUES (1,'India'),(2,'USA');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;

/*!40000 ALTER TABLE `cpdpreport_form` DISABLE KEYS */;
INSERT INTO `cpdpreport_form` (`report_type`, `report_id`) VALUES ('CompanyProfile',1);
/*!40000 ALTER TABLE `cpdpreport_form` ENABLE KEYS */;

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`country`, `is_agreedtc`, `occupation`, `state`, `id`) VALUES ('1','','it','1',32769);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` (`sequence_name`, `sequence_next_hi_value`) VALUES ('user',2),('report',1);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;

/*!40000 ALTER TABLE `industry_report_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `industry_report_form` ENABLE KEYS */;

/*!40000 ALTER TABLE `keyskills` DISABLE KEYS */;
INSERT INTO `keyskills` (`id`, `skill`) VALUES (1,'java'),(2,'.net');
/*!40000 ALTER TABLE `keyskills` ENABLE KEYS */;

/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` (`biodata`, `country`, `is_agreedtc`, `state`, `id`) VALUES ('sdf','2','','3',1);
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;

/*!40000 ALTER TABLE `publisher_key_skill` DISABLE KEYS */;
INSERT INTO `publisher_key_skill` (`publisher_id`, `skill_id`) VALUES (1,1);
/*!40000 ALTER TABLE `publisher_key_skill` ENABLE KEYS */;

/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` (`report_id`, `country`, `industry`, `overview`, `price`, `publishing_date`, `report`, `report_title`, `table_of_contents`) VALUES (1,'1','abc','afs',123,'2016-01-06 00:00:00','1.jpg','asf','sf');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;

/*!40000 ALTER TABLE `report_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_status` ENABLE KEYS */;

/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (`state_id`, `country_id`, `state_name`) VALUES (1,1,'Telangana'),(2,1,'Ap'),(3,2,'Colorado');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email_id`, `first_name`, `last_name`, `mobile_no`, `password`, `title`, `userstatus`) VALUES (1,'sri@gmail.com','sri','ch','9032164651','s','MR','Active'),(32768,'chekotisrikanth@gmail.com','srikanth','s','9032164651','as','MR','Active'),(32769,'chekotisrikanth@gmail.com','srikanth','chikoti','9032164651','abc','MR','Active');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `type`) VALUES (1,'PUBLISHER'),(2,'ADMIN'),(3,'USER');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/* table and inset statements */

CREATE TABLE stock_exchange (
  `stock_exchange_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,  
  `company_id` INT NULL,
  PRIMARY KEY (`stock_exchange_id`));
  
  
  insert into stock_exchange(name) values('Bombay Stock Exchange');
insert into stock_exchange(name) values('National Stock Exchange');
insert into stock_exchange(name) values('Shenzhen Stock Exchange');
insert into stock_exchange(name) values('Shanghai Stock Exchange');
insert into stock_exchange(name) values('London Stock Exchange');
insert into stock_exchange(name) values('SIX Swiss Exchange');
insert into stock_exchange(name) values('NASDAQ Stock Exchange');
insert into stock_exchange(name) values('Osaka Securities Exchange');
insert into stock_exchange(name) values('JASDAQ Securities Exchange');
insert into stock_exchange(name) values('Hercules Stock Exchange');
insert into stock_exchange(name) values('Tokyo Stock Exchange');
insert into stock_exchange(name) values('Berlin Stock Exchange');
insert into stock_exchange(name) values('Frankfurt Stock Exchange');
insert into stock_exchange(name) values('Borsa Italiana');
insert into stock_exchange(name) values('Italian Stock Exchange');
insert into stock_exchange(name) values('Hong Kong Stock Exchange');
insert into stock_exchange(name) values('Korea Stock Exchange');
insert into stock_exchange(name) values('Toronto Stock Exchange');
insert into stock_exchange(name) values('TSX Venture Exchange');
insert into stock_exchange(name) values('Ghana Stock Exchange');
insert into stock_exchange(name) values('Nairobi Stock Exchange');
insert into stock_exchange(name) values('Nigerian Stock Exchange');
insert into stock_exchange(name) values('JSE Securities Exchange');
insert into stock_exchange(name) values('Zimbabwe Stock Exchange');
insert into stock_exchange(name) values('Australian Securities Exchange');
insert into stock_exchange(name) values('Dhaka Stock Exchange');
insert into stock_exchange(name) values('Indonesia Stock Exchange');
insert into stock_exchange(name) values('Malaysia Exchange');
insert into stock_exchange(name) values('Karachi Stock Exchange');
insert into stock_exchange(name) values('Philippine Stock Exchange');
insert into stock_exchange(name) values('Singapore Exchange');
insert into stock_exchange(name) values('Colombo Stock Exchange');
insert into stock_exchange(name) values('Taiwan Stock Exchange');
insert into stock_exchange(name) values('Stock Exchange of Thailand');
insert into stock_exchange(name) values('Euronext - Brussels');
insert into stock_exchange(name) values('Bulgarian Stock Exchange');
insert into stock_exchange(name) values('Zagreb Stock Exchange');
insert into stock_exchange(name) values('Cyprus Stock Exchange');
insert into stock_exchange(name) values('Euronext - Paris');
insert into stock_exchange(name) values('Athens Stock Exchange');
insert into stock_exchange(name) values('Irish Stock Exchange');
insert into stock_exchange(name) values('Luxembourg Stock Exchange');
insert into stock_exchange(name) values('Oslo Stock Exchange');
insert into stock_exchange(name) values('Warsaw Stock Exchange');
insert into stock_exchange(name) values('Euronext - Lisbon');
insert into stock_exchange(name) values('Russian Stock Exchange');
insert into stock_exchange(name) values('Istanbul Stock Exchange');
insert into stock_exchange(name) values('Egyptian Stock Exchange');
insert into stock_exchange(name) values('Tel Aviv Stock Exchange');

