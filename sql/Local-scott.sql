UPDATE dept
SET dname = 'dev', loc = 'INDIA'
where deptno = 75;

DELETE FROM dept WHERE deptno=75;

SELECT
    *
FROM emp;

select * from CONTAINERS;

SELECT * FROM    CONSTRAINTS;

-- 1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index

CREATE INDEX emp_index ON EMP(ename);

--2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오.
--view 의 이름은 emp_view 로 하시오. 

select * from emp,dept;

create or REPLACE view emp_view
As
select * from emp,dept where emp.deptno = dept.deptno;