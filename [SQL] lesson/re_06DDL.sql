create table dept(
  deptno number(2,0),
  dname  varchar2(14),
  loc    varchar2(13),
--컬럼이름 도메인정의
  constraint pk_dept primary key (deptno) );
-- constraint 제약조건이름 primary key (deptno <-이 컬럼이 PK야)

create table emp(
  empno    number(4,0),
  ename    varchar2(10),
  job      varchar2(9),
  mgr      number(4,0),
  hiredate date,
  sal      number(7,2),
  comm     number(7,2),
  deptno   number(2,0), -- null, deptno의 값들이 들어오겠구나. (외래키니까)
  constraint pk_emp primary key (empno),
  constraint fk_deptno foreign key (deptno) references dept (deptno) );
--constraint 제약조건이름 foreign key (deptno를 외래키로 할거야) references dept테이블의 (deptno컬럼을 참조해)


--- DDL: 데이터 정의어. 객체 생성,수정,삭제 명령어

-- 테이블 생성: create table
-- 테이블 수정: alter table
-- 테이블 삭제: drop table

-- create table 테이블명 (
--  컬럼이름 데이터타입(size),        ex) empno number(4,0) primary key,
--  컬럼이름 데이터타입(size),
--  컬럼이름 데이터타입(size) 제약조건정의{컬럼레벨제약조건정의},
--  제약조건정의{테이블레벨제약조건정의} ex) constraint pk_emp primary key (empno)
--  );

-- 부서테이블과 유사한 테이블을 정의
CREATE TABLE dept_test (
    deptno number(2),
    dname varchar2(20), --20바이트 영문자20,한글10
    loc varchar2(20)
);

desc dept_test;
select * from dept_test;

-- 테이블 삭제
drop table dept_test;

-- 사원 테이블과 유사한 구조의 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 EMP01 테이블을 생성
desc emp;

CREATE TABLE emp01 (
empno number(4),
ename varchar2(10 ),
sal number(7,2)
);

desc emp;

-- 서브쿼리를 이용해서 기존 테이블의 구조를 복사하고, 튜플을 복사
-- 컬럼의 정의만 복사, 제약조건은 복사되지 않는다!!!
CREATE TABLE emp02
AS
select * from emp;

desc emp02;
select * from emp02;

-- 원하는 컬럼만 복사
create table emp03
as
select empno, sal from emp;

select * from emp03;

-- 원하는 데이터만 복사
create table emp04
as
select * from emp where sal >= 3000;

select * from emp04;

-- 구조만 복사
create table emp05
as
select * from emp where 1=0;

select * from emp05;
desc emp05;

desc emp01;


--- 테이블 구조의 변경: ALTER TABLE
-- 컬럼 추가: alter table 테이블이름 add(컬럼이름 데이터형태);
ALTER TABLE EMP01
add(job varchar2(9));

desc emp01;

ALTER TABLE emp01
add(
    hiredate date,
    deptno number(2)
);

ALTER TABLE emp04
MODIFY(
    ename varchar2(30) not null
);

desc emp04;

alter table emp04
add(
    job3 varchar2(20)
);

-- ALTER TABLE 테이블이름
-- ADD --MODIFY --DROP

-- 컬럼의 삭제: ALTER TABLE 테이블이름 DROP COLUMN 컬럼이름;
ALTER TABLE emp04
drop COLUMN job3;


--- 테이블의 모든 튜플을 삭제: TRUNCATE TABLE 테이블이름;
-- 삭제와 동시에 commit 바로 물리적인 반영이 된다.
desc emp02;
select * from emp02;

TRUNCATE TABLE emp02;


--- 테이블 이름 변경: RENAME 예전이름 TO 새로운이름;

RENAME emp02 to test;

desc test;

--------------------------------------------------------------------------
--------------------------------------------------------------------------
--제약 조건 확인
desc dept;

insert into dept (deptno, dname, loc)
       values (10, 'test', 'SEOUL');
-- unique constraint (SCOTT.PK_DEPT) violated

insert into dept (deptno, dname, loc)
       values (null, 'test', 'SEOUL');
-- cannot insert NULL into ("SCOTT"."DEPT"."DEPTNO")


-- 제약사항의 정의: 컬럼 레벨과, 테이블 레벨에서 정의
-- 컬럼 레벨: 컬럼 정의 바로 뒤에 제약사항을 정의
-- 컬럼이름 데이터타입(size) 제약조건

-- 지금까지 실습에 사용했던 사원 테이블과 유사한 구조의
-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 EMP02 테이블을 생성하되
-- EMPNO와 EMPNAME 컬럼에 NOT NULL 제약 조건 설정해 봅시다.
CREATE TABLE emp02(
empno             number(4) not null,
ename             varchar2(10) not null,
JOB               VARCHAR2(9)  ,
DEPTNO            NUMBER(2)
);

insert into emp02
values(10,'test',null,null);

select * from emp02;

desc emp02;
drop table emp02;

--사원 테이블과 유사한 구조의 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된
--EMP03 테이블을 생성하되 사원번호를 유일키로 지정합시다
create table emp03(
EMPNO             NUMBER(4) CONSTRAINT emp03_empno_unique unique not null,    
ENAME             VARCHAR2(10) not null, 
JOB               VARCHAR2(9),
DEPTNO            NUMBER(2) 
);

desc emp03;
select * from emp03;
drop table emp03;

insert into emp03
values (1000,'test','manager',40);

insert into emp03
values (1000,'test2','manager2', 30);


-- 기본키 제약조건
drop table emp04;

create table emp04(
EMPNO             NUMBER(4) CONSTRAINT emp04_empno_pk PRIMARY KEY,    
ENAME             VARCHAR2(10) not null, 
JOB               VARCHAR2(9),
DEPTNO            NUMBER(2) 
);

select * from emp04;

insert into emp04
values (1000,'test','manager',40);

insert into emp04
values (1000,'test2','manager2', 30);

-- 외래키 제약
drop table emp05;

create table emp05(
EMPNO             NUMBER(4) CONSTRAINT emp05_empno_pk PRIMARY KEY,    
ENAME             VARCHAR2(10) not null, 
JOB               VARCHAR2(9),
DEPTNO            NUMBER(2) CONSTRAINT emp05_deptno_fk REFERENCES dept (deptno)
);

desc emp05;
select * from emp05;

insert into emp05 values (1000,'test2','manager2', 30);
insert into emp05 values (3000,'test2','manager2', 60);

---------------------------------------------------------
-- check 제약
drop table emp06;

create table emp06(
EMPNO             NUMBER(4) CONSTRAINT emp06_empno_pk PRIMARY KEY,    
ENAME             VARCHAR2(10) not null, 
JOB               VARCHAR2(9),
sal               number(7,2) constraint emp06_sal_ck check (sal between 500 and 5000),
gender            char(1) constraint emp06_gender_ck check (gender in('M','F')),
DEPTNO            NUMBER(2) CONSTRAINT emp06_deptno_fk REFERENCES dept (deptno)
);

desc emp06;
select * from emp06;

insert into emp06 values (1000,'test2','manager2', 900, 'M', 30);


-- DEFAULT
drop table dept01;

create table dept01 (
deptno number(2),
dname varchar2(20),
loc varchar2(20) default 'SEOUL',
regDate date default sysdate
);

insert into dept01 (deptno,dname,loc) values (10,'test','NEW YORK');
insert into dept01 (deptno,dname,loc,regdate) values (10,'test','NEW YORK','21/10/29');

select * from dept01;

---------------------------------------------------------
-- 테이블 레벨에서 제약조건 정의
-- 컬럼 정의 후 제약조건 정의
-- 컬럼 레벨에서 해야하는 선 -> not null, default

drop table emp07;

create table emp07 (
    empno number(4), -- pk
    ename varchar2(20) not null,
    sal number(7,2) CONSTRAINT emp07_sal_ck check (sal between 500 and 5000),
    deptno number(2),
    -----------------------
    -- 제약조건
    constraint emp07_empno_pk primary key (empno),
    constraint emp07_deptno_fk foreign key (deptno) REFERENCES dept (deptno)
);














