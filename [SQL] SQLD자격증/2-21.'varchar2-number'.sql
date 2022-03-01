--
drop table test21;

create table test21
(idx varchar(10) PRIMARY KEY,
number12 number);

INSERT INTO test21 VALUES (100,111);

INSERT INTO test21 VALUES ('200',222);

select * from test21;

update test21 set idx='5000' where idx='1000';

-- 도메인이 varchar2 이더라도 값이 숫자라면,
-- '' 해도 되고 안해도 된다.