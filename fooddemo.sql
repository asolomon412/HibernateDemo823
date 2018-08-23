create database fooddemo;
use fooddemo;

CREATE TABLE `food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(40) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

INSERT INTO `food` VALUES (1,'Vegetable','Orange root vegetable.','Carrot'),(2,'Fruit','Sweet and crunchy.','App