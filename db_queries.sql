create database if not exists `assessment`;

use `assessment`;


drop table if exists `crystal_harvest`;
drop table if exists `planet`;
drop table if exists `product_inventory`;
drop table if exists `product_light_saber`;
drop table if exists `product_kaiburr_crystal`;
drop table if exists `order_line`;
drop table if exists `order`;
drop table if exists `product`;
drop table if exists `force_user`;

create table if not exists `planet` (
	`id` int not null auto_increment,
    `name` varchar(100) not null,
    primary key(`id`)
) engine=InnoDB default charset=latin1;

create table if not exists `product` (
	`id` int not null auto_increment,
    `name` varchar(100) not null unique,
    `price` decimal not null,
    primary key(`id`)
) engine=InnoDB default charset=latin1;

create table if not exists `product_kaiburr_crystal` (
	`id` int not null auto_increment,
    `product_id` int not null,
    `color` varchar(30) not null,
    `power_usage` double not null,
    primary key(`id`),
    foreign key(`product_id`) references `product`(`id`) on delete cascade on update cascade
) engine=InnoDB default charset=latin1;

create table if not exists `crystal_harvest` (
	`id` int not null auto_increment,
    `planet_id` int not null,
    `kaiburr_crystal_id` int not null,
    `harvest_price` decimal not null,
    primary key(`id`),
    foreign key(`planet_id`) references `planet`(`id`) on delete cascade on update cascade,
    foreign key(`kaiburr_crystal_id`) references `product_kaiburr_crystal`(`id`) on delete cascade on update cascade
) engine=InnoDB default charset=latin1;

create table if not exists `product_light_saber` (
	`id` int not null auto_increment,
    `product_id` int not null,
    `kaiburr_crystal_id` int not null,
    primary key(`id`),
    foreign key(`product_id`) references `product`(`id`) on delete cascade on update cascade,
    foreign key(`kaiburr_crystal_id`) references `product_kaiburr_crystal`(`id`) on delete cascade on update cascade
) engine=InnoDB default charset=latin1;

create table if not exists `product_inventory` (
	`id` int not null auto_increment,
    `product_id` int not null,
    `quantity` int not null,
    primary key(`id`),
    foreign key(`product_id`) references `product`(`id`) on delete cascade on update cascade
) engine=InnoDB default charset=latin1;

create table if not exists `force_user` (
	`id` int not null auto_increment,
    `force` double,
    `has_unlimited_force` boolean default false,
    `age` int not null,
    `title` varchar(30) not null,
    primary key(`id`)
) engine=InnoDB default charset=latin1;

create table if not exists `order` (
	`id` int not null auto_increment,
    `force_user_id` int not null,
    `date` datetime not null,
    primary key(`id`),
    foreign key(`force_user_id`) references `force_user`(`id`)
) engine=InnoDB default charset=latin1;

create table if not exists `order_line` (
	`id` int not null auto_increment,
    `order_id` int not null,
    `product_id` int not null,
    `quantity` int not null,
    `unit_price` decimal not null,
    primary key(`id`),
    foreign key(`order_id`) references `order`(`id`) on delete cascade on update cascade,
    foreign key(`product_id`) references `product`(`id`)
) engine=InnoDB default charset=latin1;

/* Fill some data */
insert into product(`name`,`price`) values ('Ilum crystal', 2020);
insert into product(`name`,`price`) values ('Dantooine crystal', 190);
insert into product(`name`,`price`) values ('Dagobah crystal', 814);

insert into product_kaiburr_crystal(`product_id`, `color`, `power_usage`) values (1, 'Red', 20);
insert into product_kaiburr_crystal(`product_id`, `color`, `power_usage`) values (2, 'Blue', 19);
insert into product_kaiburr_crystal(`product_id`, `color`, `power_usage`) values (3, 'Green', 22);

insert into planet(`name`) values ('Ilum');
insert into planet(`name`) values ('Dantooine');
insert into planet(`name`) values ('Dagobah');

insert into force_user(`force`,`age`,`title`) values (50,5,'Padawan');
insert into force_user(`has_unlimited_force`,`age`,`title`) values (true,100,'Jedi master');

insert into crystal_harvest(`planet_id`,`kaiburr_crystal_id`,`harvest_price`) values (1,1,101);
insert into crystal_harvest(`planet_id`,`kaiburr_crystal_id`,`harvest_price`) values (2,2,10);
insert into crystal_harvest(`planet_id`,`kaiburr_crystal_id`,`harvest_price`) values (3,3,37);