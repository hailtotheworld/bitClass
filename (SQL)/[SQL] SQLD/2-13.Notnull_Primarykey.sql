--2-12
-- not null과 primary key 같이 제약조건으로 줄 수 있다.

create table empsqld
(empno varchar(10) not null primary key,
datetime timestamp not null);

select * from empsqld;

drop table empsqld;