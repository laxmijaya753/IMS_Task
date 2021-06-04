  
drop schema ims_schema;

CREATE SCHEMA IF NOT EXISTS `ims_schema`;

USE `ims_schema` ;

CREATE TABLE IF NOT EXISTS `ims_schema`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


create table  IF NOT EXISTS `ims_schema`.`item`(item_id int PRIMARY KEY AUTO_INCREMENT,name varchar(20),value1  decimal(12, 2) NOT NULL);

create table   IF NOT EXISTS `ims_schema`.`order_items` (order_id int PRIMARY KEY AUTO_INCREMENT,
   customer_id int,item_id1 int,item_name varchar(25),quantity int ,cost   decimal(12, 2) ,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
 FOREIGN KEY (item_id1) REFERENCES item(item_id)
);



create table   IF NOT EXISTS `ims_schema`.`  orders`  (orderid int PRIMARY KEY AUTO_INCREMENT,customer_id1 int );