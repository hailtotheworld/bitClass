create table test40 (
col1 varchar2(10),
col2 number(10));

select * from test40;

INSERT INTO test40 VALUES ('조조',1);
INSERT INTO test40 VALUES ('조조',1);
INSERT INTO test40 VALUES ('조조',1);
INSERT INTO test40 VALUES ('조조',2);
INSERT INTO test40 VALUES ('조조',3);

select distinct col1,col2 from test40;