drop table country if exists;
create table country (
  id int primary key auto_increment,
  name varchar(32),
  code varchar(20),
  order_num integer default 1
);
drop table addres if exists;
create table addres (
  id int primary key auto_increment,
  addres varchar(32),
);

drop table person_addres if exists;
create table person_addres (
  id int primary key auto_increment,
  user_id int,
  addres_id int
);



drop table person if exists;
create table person (
  id int primary key auto_increment,
  name varchar(32),
  age integer,
  status integer default 1 not null,
  role integer default 1 not null,
  country_id int not null
);

insert into person (id, name, age,status,role,country_id) values(1,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(2,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(3,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(4,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(5,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(6,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(7,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(8,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(9,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(10,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(11,'andy',12,1,1,1);
insert into person (id, name, age,status,role,country_id) values(12,'andy',12,1,1,1);

insert into addres (id, addres ) values(1,'beijing');
insert into addres (id, addres ) values(2,'shanghai');


insert into person_addres (id, user_id ,addres_id) values(1,1,1);
insert into person_addres (id, user_id, addres_id) values(2,1,2);
insert into person_addres (id, user_id, addres_id) values(3,2,2);
insert into person_addres (id, user_id, addres_id) values(4,2,1);



insert into country (id, name, code,order_num) values(1,'Angola','AO',1);
insert into country (id, name, code,order_num) values(2,'Afghanistan','AF',2);
insert into country (id, name, code,order_num) values(3,'Albania','AL',2);


