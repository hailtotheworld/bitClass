drop table test23;

create table test23 (
col1 number(10),
col2 number(10),
col3 number(10),
col4 number(10));

INSERT INTO test23 VALUES (10,10,10,20);
INSERT INTO test23 VALUES (10,10,10,20);
INSERT INTO test23 VALUES (10,10,null,20);

select * from test23;

select sum(col1+col2+col3+col4) from test23;