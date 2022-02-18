-- 로그인한 사용자가 보유하고 있는 테이블 정보를 가지고 있는 메타데이터 테이블
SELECT * FROM tab;

-- 테이블의 구조 확인 
desc emp;

select * from emp;
select * from dept;
SELECT loc, deptno, dname FROM dept;
SELECT * from book;
SELECT * from customer;
select orderid, custid from orders;

-- select 구문에서 컬럼의 산술연산이 가능
select ename, sal, sal+comm, sal + nvl(comm,0), sal*12+nvl(comm,0) from emp;

-- 별칭을 이용해서 컬럼이름 사용
select ename, sal 월급, sal*12+nvl(comm,0) as 연봉
from emp;

-- 문자열을 연결해주는 || 연산자
select ename||' is a '||job as "그의 직책은" from emp;

-- 사원들이 소속된 부서 번호 출력
select DISTINCT deptno
from emp;

-- 서점에 입점한 출판사 리스트
select DISTINCT publisher
from book;

select DISTINCT deptno, job
from emp;

select * -- 출력하고자 하는 컬럼
from emp -- 대상 테이블
where sal >= 3000; -- 조건: 비교연산 또는 논리연산 => 행을 찾을 조건


select * 
from emp
where sal BETWEEN 1000 AND 2000;

select *
from emp
where comm is not null;

-- 10번 부서에 소속된 -> 행을 검색할 조건
-- 사원의 리스트 출력
select *
from emp
where deptno=10;

select empno, ename, sal
from emp
where ename='FORD'; -- 문자열 비교시 반드시 작은 따옴표 사용!!
-- 비교하는 문자열 데이터는 대소문자 구별!!

-- 날짜 비교: 82년 이후 입사자
SELECT *
FROM emp
where hiredate >= '82/01/01';

-- 10번 부서 소속인 사원들 중에서 -> and
-- 직급이 MANAGER인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력하려고
select ename,deptno,job
from emp
where deptno=10 and job='MANAGER';

--10번 부서에 소속된 사원이거나 -> or
--직급이 MANAGER인 사람을 검색하여
--사원명, 부서번호, 직급을 출력
select ename,deptno,job
from emp
where deptno=10 or job='MANAGER';

-- 부서번호가 10번이 아닌 사원의
-- 사원이름, 부서번호, 직급을 출력
select ename,deptno,job
from emp
--where not deptno = 10;
--where deptno != 10;
where deptno <> 10;

-- 2000에서 3000 사이의 급여를 받는 사원 : 조건
select *
from emp
where sal between 2000 and 3000;
--where sal >=2000 and sal<=3000;

-- 1987년에 입사한 사원을 출력해 봅시다
select *
from emp
where hiredate between '87/01/01' and '87/12/31';

--커미션이 300 이거나 500 이거나 1400 인 사원을 검색
select *
from emp
--where comm=300 or comm=500 or comm=1400;
where comm in(300,500,1400);

-- like 패턴 검색
-- F로 시작하는 이름을 가진 사원을 검색
select * 
from emp
where ename like 'F%'
;

--이름 중 A를 포함하는 사원을 검색해
SELECT * 
from emp
where ename like '%A%';

--N으로 끝나는 데이터를 찾아봅시다
select *
from emp
where ename like '%N';

-- 이름의 두 번째 글자가 A인 사원을 찾으세요
select *
from emp
where ename like '_A%';

--이름에 A를 포함하지 않은 사람만을 검색
SELECT * 
from emp
where ename not like '%A%';

-- 커미션을 받지 않는 사원을 검색
SELECT * 
from emp
where comm is null;

-- 커미션을 받는 사원을 검색
SELECT * 
from emp
where comm is not null and comm > 0;

-- 정렬을 위한 order by 절
-- order by 컬럼명 {[asc] | desc}

-- 급여 컬럼을 기준으로 오름차순
select *
from emp
ORDER BY sal asc;
-- ORDER BY sal;

-- 사원 이름순으로 정렬
select *
from emp
ORDER BY ename asc;

-- 입사일 순으로 정렬
select *
from emp
order by hiredate, sal;











