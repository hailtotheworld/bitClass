--2.37

drop table service;


create table service(
idx varchar2(100) primary key,
name varchar2(100) null);

insert into service values(001,'1번');

insert into service values(002,'2번');

insert into service values('3번','3번');
DELETE FROM service WHERE idx='3번';

select * from service where idx=1;

select * from service;