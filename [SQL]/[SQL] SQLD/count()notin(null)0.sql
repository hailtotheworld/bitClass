drop table test291;
drop table test292;

create table test291 (
col1 number(10));

insert into test291 values(1);
insert into test291 values(2);
insert into test291 values(3);
insert into test291 values(4);

select * from test291;

create table test292 (
col1 number(10));

insert into test292 values(2);
insert into test292 values(null);

select * from test292;

select count(*)
from test291
where col1 not in(null);
