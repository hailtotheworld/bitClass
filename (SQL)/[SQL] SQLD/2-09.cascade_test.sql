-- cascade test

drop table s;
drop table t;

create table t
(c integer primary key,
 d integer);
 
INSERT INTO t VALUES (1,1);
INSERT INTO t VALUES (2,1);
 
select * from t;

create table s
(b integer primary key,
 c integer references t(c) on delete cascade,
 k integer);
 
insert into s values (1,1,10);
insert into s values (2,1,450);

select * from s;

-------
delete from t;


