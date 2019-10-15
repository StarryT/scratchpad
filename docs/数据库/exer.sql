create DATABASE scratch;

use scratch

create table user
(username varchar(30) primary key,
password varchar(30) not null,
nickname varchar(30) not null,
gender char(1) not null,
phone varchar(30) not null,
email varchar(30) not null); 

create table note
(id varchar(30) primary key,
name varchar(30) not null,
content text ,
owner varchar(30) ,
foreign key(owner) references user(username));

select * from note;

insert into user
values('111','123','张三','0','12345','123qq.com');


insert into user(username,password,nickname,gender,phone,email)values
('222','234','赵二','1','23456','234qq.com'),
('333','345','李四','1','34567','345qq.com');

create table exers
(name varchar(30),
age int not null,
birthday varchar(30) not null);

alter table exers add primary key(name);

alter table exers add primary key(age);

alter table exers drop name;

alter table exers drop primary key (name)

alter table exers add COLUMN name varchar(30);

drop table exer;

select* from exers

select* from user

select username,nickname from user;

select nickname from user
where gender='1' ;

select * from user
where gender='1' ;







