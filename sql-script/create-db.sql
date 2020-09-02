DROP SCHEMA IF EXISTS `johansson-AB`;

CREATE SCHEMA `johansson-AB`;

use `johansson-AB`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `person_id` int(11) NOT NULL ,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` int(15) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `transport_ticket`;

CREATE TABLE `transport_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `extra_info` varchar(100) DEFAULT NULL,
  `worked_hours` int(10) DEFAULT NULL,
  `employee_person_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_PERSON_ID_idx` (`employee_person_id`),
  
  CONSTRAINT `FK_PERSON_ID` 
  FOREIGN KEY (`employee_person_id`) 
  REFERENCES `employee` (`person_id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
