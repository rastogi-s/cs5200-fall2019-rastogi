
DROP  SCHEMA IF EXISTS heroku_79525cdf06e353b;
CREATE SCHEMA heroku_79525cdf06e353b;
USE heroku_79525cdf06e353b;
-- Drop all tables --
DROP TABLE IF EXISTS `website_role`;
DROP TABLE IF EXISTS `website_priviledge`;
DROP TABLE IF EXISTS `page_role`;
DROP TABLE IF EXISTS `page_priviledge`;
DROP TABLE IF EXISTS `phone`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `widget`;
DROP TABLE IF EXISTS `page`;
DROP TABLE IF EXISTS `website`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `developer`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `dtype`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `priviledge`;

-- create person table --

CREATE TABLE `person` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50),
    `username` VARCHAR(50),
    `password` VARCHAR(50),
    `email` VARCHAR(100),
    `dob` DATE
);

-- create user table --

CREATE TABLE `user` (
    `id` INT PRIMARY KEY,
    `user_agreement` BOOLEAN,
    CONSTRAINT `user_test_generalization` FOREIGN KEY (`id`)
        REFERENCES `person` (`id`)
);

-- create developer table --

CREATE TABLE `developer` (
    `id` INT PRIMARY KEY,
    `developer_key` VARCHAR(100),
    CONSTRAINT `developer_test_generalization` FOREIGN KEY (`id`)
        REFERENCES `person` (`id`)
);

-- create dtype enumeration --


CREATE TABLE `dtype` (
    `name` VARCHAR(50) PRIMARY KEY
);

-- create priviledge enumeration --

CREATE TABLE `priviledge` (
    `name` VARCHAR(50) PRIMARY KEY
);

-- create role enumeration --

CREATE TABLE `role` (
    `name` VARCHAR(50) PRIMARY KEY
);

-- create phone table --

CREATE TABLE `phone` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `pid` INT,
    `phone` VARCHAR(20),
    `primary` BOOLEAN,
    CONSTRAINT `phone_person_composition` FOREIGN KEY (`pid`)
        REFERENCES `person` (`id`)
);

-- create address table --

CREATE TABLE `address` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `pid` INT,
    `street1` VARCHAR(50),
    `street2` VARCHAR(50),
    `city` VARCHAR(50),
    `state` VARCHAR(50),
    `zip` VARCHAR(10),
    `primary` BOOLEAN,
    CONSTRAINT `address_person_composition` FOREIGN KEY (`pid`)
        REFERENCES `person` (`id`)
);

-- create website table --

CREATE TABLE `website` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `description` VARCHAR(1000),
    `created` DATE,
    `updated` DATE,
    `visits` INT,
    `creator_id` INT,
    CONSTRAINT `website_developer_aggregation` FOREIGN KEY (`creator_id`)
        REFERENCES `developer` (`id`)
);

-- create page table --

CREATE TABLE `page` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(50),
    `description` VARCHAR(1000),
    `created` DATE,
    `updated` DATE,
    `views` INT,
    `wid` INT,
    `widget_id` INT,
    CONSTRAINT `page_developer_composition` FOREIGN KEY (`wid`)
        REFERENCES `website` (`id`)
);

-- create website_role table --

CREATE TABLE `website_role` (
    `id` INT AUTO_INCREMENT,
    `role` VARCHAR(50),
    `did` INT,
    `wid` INT,
    CONSTRAINT `website_role_pk` PRIMARY KEY (`id`),
    CONSTRAINT `website_role_role_enumeration` FOREIGN KEY (`role`)
        REFERENCES `role` (`name`),
    CONSTRAINT `website_role_developer_association` FOREIGN KEY (`did`)
        REFERENCES `developer` (`id`),
    CONSTRAINT `website_role_website_association` FOREIGN KEY (`wid`)
        REFERENCES `website` (`id`)
);

-- create page_role table --

CREATE TABLE `page_role` (
    `id` INT AUTO_INCREMENT,
    `role` VARCHAR(50),
    `did` INT,
    `page_id` INT,
    CONSTRAINT `page_role_pk` PRIMARY KEY (`id`),
    CONSTRAINT `page_role_role_enumeration` FOREIGN KEY (`role`)
        REFERENCES `role` (`name`),
    CONSTRAINT `page_role_developer_association` FOREIGN KEY (`did`)
        REFERENCES `developer` (`id`),
    CONSTRAINT `page_role_page_association` FOREIGN KEY (`page_id`)
        REFERENCES `page` (`id`)
);

-- create website_priviledge table --

CREATE TABLE `website_priviledge` (
    `id` INT AUTO_INCREMENT,
    `priviledge` VARCHAR(50),
    `did` INT,
    `wid` INT,
    CONSTRAINT `website_priviledge_pk` PRIMARY KEY (`id`),
    CONSTRAINT `website_priviledge_priviledge_enumeration` FOREIGN KEY (`priviledge`)
        REFERENCES `priviledge` (`name`),
    CONSTRAINT `website_priviledge_developer_association` FOREIGN KEY (`did`)
        REFERENCES `developer` (`id`),
    CONSTRAINT `website_priviledge_website_association` FOREIGN KEY (`wid`)
        REFERENCES `website` (`id`)
);

-- create page_priviledge table --

CREATE TABLE `page_priviledge` (
    `id` INT AUTO_INCREMENT,
    `priviledge` VARCHAR(50),
    `did` INT,
    `page_id` INT,
    CONSTRAINT `page_priviledge_pk` PRIMARY KEY (`id`),
    CONSTRAINT `page_priviledge_priviledge_enumeration` FOREIGN KEY (`priviledge`)
        REFERENCES `priviledge` (`name`),
    CONSTRAINT `page_priviledge_developer_association` FOREIGN KEY (`did`)
        REFERENCES `developer` (`id`),
    CONSTRAINT `page_priviledge_page_association` FOREIGN KEY (`page_id`)
        REFERENCES `page` (`id`)
);

-- create widget table --

CREATE TABLE `widget` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `width` INT,
    `height` INT,
    `css_class` VARCHAR(50),
    `css_style` VARCHAR(50),
    `text` VARCHAR(50),
    `order` INT,
    `heading_size` INTEGER DEFAULT 2,
    `html` VARCHAR(1000),
    `youtube_url` VARCHAR(100),
    `youtube_sharable` BOOLEAN,
    `youtube_expandable` BOOLEAN,
    `image_src` VARCHAR(100),
    `dtype` VARCHAR(50) NOT NULL,
    `page_id` INT,
    CONSTRAINT `widget_dtype_enum` FOREIGN KEY (`dtype`)
        REFERENCES `dtype` (`name`),
    CONSTRAINT `widget_page_composition` FOREIGN KEY (`page_id`)
        REFERENCES `page` (`id`)
);

-- Insert data into ennumerations --

INSERT INTO `priviledge` values('create'),('read'),('update'),('delete');
INSERT INTO `role` values('owner'),('admin'),('writer'),('editor'),('reviewer');
INSERT INTO `dtype` values('youtube'),('image'),('heading'),('html');

