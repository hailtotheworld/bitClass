

--
drop table dept01;

create table dept01
as
SELECT
    *
FROM dept where 1=0;

desc dept01;

SELECT
    *
FROM dept01;

insert into dept01 (deptno, dname, loc)
            values (10, 'DEV', 'SEOUL');
            
-- 서브 쿼리를 이용한 데이터 입력

drop table dept02;

create table dept02
as
SELECT    * FROM dept where 1=2;

select * from dept02;

-- 서브 쿼리를 이용해서 데이터 삽입
insert into dept02 select * from dept;














