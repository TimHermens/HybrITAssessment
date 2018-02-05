use assessment;

insert into product(`name`,`price`) values ('Ilum crystal', 2020);
insert into product(`name`,`price`) values ('Dantooine crystal', 190);
insert into product(`name`,`price`) values ('Dagobah crystal', 814);

insert into product(`name`,`price`) values ('Obi wan saber', 1000);

insert into planet(`name`) values ('Ilum');
insert into planet(`name`) values ('Dantooine');
insert into planet(`name`) values ('Dagobah');

insert into force_user(`force`,`has_unlimited_force`,`age`,`title`,`is_jedi_master`) values (50,false,5,'Padawan',false);
insert into force_user(`force`,`has_unlimited_force`,`age`,`title`,`is_jedi_master`) values (1000,true,100,'Jedi master',true);

insert into crystal_harvest(`planet_id`,`harvest_price`) values (1,101);
insert into crystal_harvest(`planet_id`,`harvest_price`) values (2,10);
insert into crystal_harvest(`planet_id`,`harvest_price`) values (3,37);

insert into product_kaiburr_crystal(`id`, `color`, `power_usage`, `crystal_harvest_id`) values (1, 'Red', 20, 1);
insert into product_kaiburr_crystal(`id`, `color`, `power_usage`, `crystal_harvest_id`) values (2, 'Blue', 19, 2);
insert into product_kaiburr_crystal(`id`, `color`, `power_usage`, `crystal_harvest_id`) values (3, 'Green', 22, 3);

insert into product_light_saber(`id`, `kaiburr_crystal_id`) values (4,2);

insert into product_inventory(`quantity`, `product_id`) values (10, 4);