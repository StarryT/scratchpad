CREATE DATABASE `scratch` CHARSET UTF8;

USE `scratch`;

CREATE TABLE `user`(
`username` VARCHAR(30) PRIMARY KEY,
`password` VARCHAR(30) NOT NULL,
`nickname` VARCHAR(30)  NOT NULL,
`gender` CHAR(1)  NOT NULL,
`phone` VARCHAR(30)  NOT NULL,
`email` VARCHAR(30)  NOT NULL
)CHARSET  utf8 ENGINE INNODB; 

CREATE TABLE `note`(
`id` VARCHAR(30) PRIMARY KEY,
`name` VARCHAR(30)  NOT NULL,
`content` TEXT ,
`owner` VARCHAR(30) ,
FOREIGN KEY(`owner`) REFERENCES user(`username`)
)CHARSET  utf8 ENGINE INNODB;