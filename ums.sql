
create database UMS;


create table UMS.Login
(username varchar(15),
pass varchar(15));
insert into UMS.Login values('Aziz','abc');
drop table UMS.Admission;
create table UMS.Admission
(
Sfname varchar(30),
Slname varchar(30),
Sdob varchar(1500),
Sgender varchar(10),
Smail varchar(30),
Sphone long,
Saddress varchar(30),
Sroll int(20)  unique,
Scnic long,
Sinter int(20),
Smetric int(20),
Sdepartment varchar(40)
);
select * from UMS.Admission;
delete from UMS.Admission;
