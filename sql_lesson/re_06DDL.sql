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
    ename varchar2(30)
);

desc emp04;

















