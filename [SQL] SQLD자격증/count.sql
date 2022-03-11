create table test441 (
co1 number(10)
);

INSERT INTO test441 VALUES (1);
INSERT INTO test441 VALUES (2);
INSERT INTO test441 VALUES (3);
INSERT INTO test441 VALUES (4);

select *
from test441;

select count(*)
from test441
having count(*)>4; --공집합이다

select count(*)
from test441
where 1=2; --0

select sum(co1)
from test441
where 1=2; --null

select max(co1)
from test441
where 1=2;--null
