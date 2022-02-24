-- DML: 입력, 수정, 삭제

-- 테이스 테이블 생성
drop table dept01;

-- 테이블 구조만 복사해오기
create table dept01
as
select * from dept where 1=0;

select * from dept01;
desc dept01;

-- 데이터의 입력:
-- INSERT INTO {테이블명} (컬럼명,...) VALUES (data,...)
-- 입력하고자 하는 컬럼의 개수와 입력데이터의 개수는 일치해야한다.
-- 컬럼의 도메인과 입력데이터의 타입이 일치해야 한다!!
-- 컬럼의 제약중에 not null인 컬럼을 생략하면 안된다!!

insert into dept01 (deptno, dname, loc)
             values (10,'DEV','서울');
             
-- 모든 컬럼의 데이터를 입력할 경우 컬럼을 기술하는것을 생략해도 된다.
insert into dept01 values(20,'회계','서울');

-- null 값 삽입하는 방법
insert into dept01 values(20,'회계',null);
insert into dept01 (deptno, dname) values(30,'운영');
insert into dept01 values(40,'서비스','');

----------------------------------------------------
-- 서브 쿼리를 이용한 데이터 입력

drop table dept02;

create table dept02
as
select * from dept where 1=0;

-- 서브 쿼리를 이용해서 데이터 삽입
insert into dept02
select * from dept;

desc dept02;
select * from dept02;

--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
-- update 테이블이름 set 컬럼이름=값, 컬럼이름=값 ... where 행선택조건

drop table emp01;
create table emp01
as
select * from emp;

desc emp01;

select * from emp01;

-- 1. 모든 사원의 부서번호를 30번으로 수정합시다.
--    모든 사원은 where 절을 사용하지 않는 경우.
UPDATE emp01
SET deptno=30;

-- 2. 이번엔 모든 사원의 급여를 10% 인상
UPDATE emp01
SET sal = sal*1.1;

-- 3. 모든 사원의 입사일을 오늘로 수정
UPDATE emp01
SET hiredate = sysdate;

select * from emp01;
-- 1.부서번호가 10번인 사원의 부서번호를 30번으로 수정합시다.
select *
from emp01
where deptno=10;

update emp01
set deptno=30
where deptno=10;

-- 2. 급여가 3000 이상인 사원만 급여를 10% 인상합시다
select * 
from emp01
where sal >= 3000;

update emp01
set sal = sal*1.1
where sal >= 3000;

-- 3. 1987년에 입사한 사원의 입사일이 오늘로 수정합시다
select *
from emp01
where substr(hiredate,1,2)=87;

update emp01
set hiredate = sysdate
where substr(hiredate,1,2)=87;

select * from emp01;
-- 두개 이상의 컬럼을 변경할 때는 ,(컴마)를 쓰고 바꾸고자하는 컬럼을 추가
-- 1.SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다.
update emp01
set deptno=20, job='MANAGER'
where ename='SCOTT';

-- 2.SCOTT 사원의 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정합시다.
update emp01
set hiredate=sysdate, sal=50, comm=4000
where ename='SCOTT';

select * from dept01;
-- 1. 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.
drop table dept01;
create table dept01
as
select * from dept;

select loc
from dept01
where deptno=40;

update dept01
set loc = (select loc
            from dept01
            where deptno=40)
where deptno=20; 

-- 1. 부서번호가 20인 부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경하기
select dname,loc
from dept01
where deptno=40;

update dept01
set (dname, loc) = (select dname,loc
                    from dept01
                    where deptno=40)
where deptno=20;

select * from dept01;
-- "행"을 삭제하는 DELETE

--부서 테이블의 모든 행을 삭제합시다
DELETE FROM dept01;

rollback; --> 마지막 커밋된 위치로 이동, 마지막 커밋후 작업된 DML 반영이 되지 않는다!!

--부서 테이블에서 30번 부서만 삭제합시다.
delete from dept01
where deptno=30;

commit;

--사원 테이블에서 부서명이 SALES인 사원을 모두 삭제해봅시다.
drop table emp01;
create table emp01
as
select * from emp;

select * from emp01;

select deptno from dept where dname='SALES';

delete from emp01
where deptno = (select deptno from dept where dname='SALES');


















