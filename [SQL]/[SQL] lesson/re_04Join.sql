select * from emp;
select * from dept;

-- Cross Join: 단순히 테이블 붙히는 조인
-- 컬럼을 붙히고, 행(데이터)는 집합의 합 연산 -> 전체 행은 ==> R1의 행의 개수 x R2의 행의 개수
-- emp 테이블과 dept 테이블의 join -> 14*4=56개 행

-- Cross Join 문
-- select * from 테이블명, 테이블명, 테이블명...
select *
from emp,dept
--order by deptno --> 에러가 난다. deptno가 어느 테이블에 속한 deptno인지 모르니까. column ambiguously defined
order by dept.deptno
;

select * 
from dept,emp;


-- Equi Join
-- 특정 컬럼의 값들을 비교해서 같은 결과 행만 추출

select *
from emp,dept
where emp.deptno = dept.deptno;

-- SCOTT 사원의 부서이름을 출력
select ename,dname
from emp,dept
where emp.deptno = dept.deptno
      and ename = 'SCOTT';

-- 테이블에 별칭 부여하기 -> 테이블명 별칭
select ename,dname
from emp e,dept d
where e.deptno = d.deptno
      and ename = 'SCOTT';
      

-- Non-Equi Join
select * 
from salgrade;

select ename, sal, grade
from emp e, salgrade s
where sal BETWEEN Losal AND hisal
order by sal;

select * from emp;


-- Self Join

--상관이름 구하기
select e.ename as "직원이름", m.ename "상관이름", e.mgr, e.empno
from emp e, emp m
where e.mgr = m.empno;

-- Outer Join
select e.ename as "직원이름", nvl(m.ename, '관리자없음')as "상관이름"
from emp e, emp m
where e.mgr = m.empno(+); -- 표현하고 싶은 컬럼 반대쪽에 (+) 붙혀줘. null이 없는 쪽에 붙혀.

-------------------------------------------------------------------------------------
-- ANSI JOIN
select * 
from emp, dept;

select *
from emp cross join dept;

-- Inner Join
-- select *
-- from t1 inner join t2
-- on 컬럼의 비교 조건

select e.ename,d.dname
from emp e,dept d
where e.deptno = d.deptno
and e.ename = 'SCOTT'
;

select e.ename, d.dname
from emp e inner join dept d
on e.deptno=d.deptno --on 반드시 적어줘야해.
where ename='SCOTT';

select e.ename, d.dname
from emp e join dept d --inner 문구 생략가능
on e.deptno=d.deptno
where ename='SCOTT';


--on
select *
from emp e join dept d
on e.deptno = d.deptno;

--using
select *
from emp e join dept d
using (deptno);

--natural 컬럼이름 같은게 1개 있다면 사용가능
select * 
from emp e NATURAL join dept d;


-- ANSI outer join
-- from R1 [LEFT | RIGHT | FULL] outer join R2
select * 
from emp;

-- 사원 이름과 상관의 이름을 출력
select e.ename, m.ename
from emp e left outer join emp m --null이 있는 방향을 가르켜.!!!!!
on e.mgr = m.empno;

select e.ename, m.ename
from emp m right outer join emp e
on m.empno=e.mgr;


-- 테이블 3개 조인_ 주문 내역(고객 정보, 책의 정보, 구매 정보)
-- 주문 고객의 이름과 책의 이름, 구매 날짜와 구매 금액을 출력

select * from book;
select * from customer;
select * from orders;

select c.name,b.bookname,o.orderdate,o.saleprice
from book b, customer c, orders o
where b.bookid=o.bookid and c.custid=o.custid
;




















