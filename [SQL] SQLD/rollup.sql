create table test440 (
co1 varchar2(10),
co2 number(10)
);

INSERT INTO test440 VALUES ('A',100);
INSERT INTO test440 VALUES ('B',200);
INSERT INTO test440 VALUES ('C',300);
INSERT INTO test440 VALUES ('C',400);

select *
from test440;

select co1, count(*)
from test440
group by rollup(co1);

select co1, count(*)
from test440
group by rollup(co1), co1;









