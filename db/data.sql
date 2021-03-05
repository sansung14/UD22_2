CREATE database UD22;
USE UD22;
CREATE TABLE `cliente` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(250) DEFAULT NULL,
	`apellido` varchar(250) DEFAULT NULL,
	`direccion` varchar(250) DEFAULT NULL,
	`dni` int(11) DEFAULT NULL,
	`fecha` date DEFAULT NULL,
	PRIMARY KEY (`id`)
);
CREATE TABLE `videos` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`title` varchar(250) DEFAULT NULL,
	`director` varchar(250) DEFAULT NULL,
	`cli_id` int(11) DEFAULT NULL,
	PRIMARY KEY (`id`),
    CONSTRAINT `videos_fk` FOREIGN KEY (`cli_id`) REFERENCES `cliente` (`id`)
);
