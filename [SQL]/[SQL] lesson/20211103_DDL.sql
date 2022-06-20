

-- 2021.11.03

-- DDL : 데이터 정의어, 객체 생성, 수정, 삭제 명령어

-- 테이블 생성 : create table
-- 테이블 수정 : alter table
-- 테이블 삭제 : drop table

-- create table 테이블명 (
--      컬럼이름 데이터_타입(size) 제약조건정의(컬럼레벨정의),
--      ..... ,
--      제약조건정의(테이블레벨정의)
--);

-- 부서테이블과 유사한 테이블을 정의
create table dept_test (
    deptno number(2),
    dname varchar2(20),
    loc varchar2(20)
);

-- 테이블 삭제
drop table dept_test;

-- 사원 테이블과 유사한 구조의
--사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 EMP01 테이블을 생성해 봅시다. 
desc emp; --테이블 보자는 의미구나!!

--EMPNO    NOT NULL NUMBER(4)    
--ENAME             VARCHAR2(10) 
--SAL               NUMBER(7,2)  

create table emp01 (
    empno NUMBER(4),
    ename VARCHAR2(10),
    sal NUMBER(7,2)  
);

desc emp01;

-- 서브쿼리를 이용해서 기존 테이블의 구조를 복사하고, 튜플을 복사
-- 컬럼의 정의만 복사, 제약조건은 복사되지 않는다!!!!!!
create table emp02
as
SELECT * from emp
;

desc emp02;  -- 구조보는거야!!
select * from emp02; --데이터보는거야!!

-- 원하는 컬럼만 복사
CREATE table emp03
as
select empno, ename from emp
;

desc emp03;
SELECT   * FROM emp03;

-- 원하는 데이터만 복사
CREATE TABLE emp04
As
select * from emp where deptno=10
;

SELECT * FROM emp04;


-- 구조만 복사
SELECT    *
FROM emp
where 1=0;

CREATE table emp05
as
SELECT * FROM emp where 1=0;

desc emp05;
select * from emp05;


-- 테이블 구조의 변경 : alter table
-- 컬럼 추가 : alter table {테이블 이름} add (컬럼정의);

-- EMP01 테이블에 문자 타입의 직급(JOB) 칼럼을 추가해 봅시다.
alter table emp01
add (job VARCHAR2(9))
;

desc emp01;
select * from emp01;

alter table emp01
add (
    hiredate date,
    deptno number(2)
);

-- 컬럼의 변경 : alter table {테이블 이름} modify (컬럼정의);

--직급(JOB) 칼럼을 최대 30글자까지 저장할 수 있게 변경해 보도록 하자
alter table emp01
modify (job varchar2(30) not null)
;


-- 컬럼의 삭제: alter table {테이블 이름} drop column 컬럼이름

--EMP01 테이블의 직급 칼럼을 삭제해 보도록 합시다. 
alter table emp01 drop COLUMN job;

-- 테이블의 모든 튜플을 삭제: truncate table
-- 삭제와 동시에 commit: 바로 물리적인 반역(저장) 그래서 주의해야해!!!!!!!!!!!!!!!!!!!!!!!!!

-- emp02 테이블의 모든 데이터를 삭제
select * from emp02;
TRUNCATE table emp02;


-- 테이블 이름 변경: rename {old_name} To {new_name}
-- emp02 테이블의 이름을 test로 변경
desc emp02;
rename emp02 to test;

desc test;

drop table test;


----------------------------------------------------------------------
-- 제약 조건 확인
desc dept;
insert into dept (deptno, dname, loc)
          values (10, 'test', 'SEOUL');



-- 제약사항의 정의 : 컬럼 레벨과 테이블 레벨에서 정의
-- 컬럼 레벨 : 컬럼 바로 뒤에 제약사항을 저의

-- 테이블 삭제
drop table emp02;
create table emp02 (
    empno number(4) not null,
    ename varchar(20) not null,
    job varchar(9),
    deptno number(2)
);

desc emp02;
SELECT
    *
FROM emp02;
insert into emp02 values (10, 'test', null, null);










