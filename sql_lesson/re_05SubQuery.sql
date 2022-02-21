-- 서브쿼리 (부속 질의)
-- select 구문 안에 또 다른 select 구문을 이용하는 sql문

-- SCOTT 사원의 부서 이름을 출력
select dname
from emp e,dept d
where e.deptno=d.deptno
and ename = 'SCOTT';

select dname
from emp e join dept d
on e.deptno=d.deptno
and ename = 'SCOTT';

-- SCOTT 사원의 부서 이름 찾기
-- 1. 내부 쿼리를 먼저 작성 : SCOTT 사원의 부서 번호
-- 2. 외부 쿼리 작성 : 부서 번호로 부서이름을 검색
select dname
from dept
where deptno=(
    select deptno
    from emp
    where ename='SCOTT'
);
------------------------select 부속질의------------------------
-- 마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력)

select * from orders;
select * from customer;

select 
        (select name from customer c where o.custid=c.custid) as "이름",
        sum(saleprice) as "구매액"
from orders o
group by custid
;

-- JOIN
-- 마당서점의 고객별 판매액을 보이시오
-- (결과는 고객이름과 고객별 판매액을 출력)
select o.custid, c.name, sum(saleprice)
from orders o, customer c
where o.custid=c.custid
group by o.custid, c.name;


---- 사원의 이름과 부서 이름을 출력
select * from emp;
select * from dept;

--join 사용해서 사원의 이름과 부서 이름을 출력
select e.ename, d.dname
from emp e, dept d
where e.deptno=d.deptno;

--서브쿼리 이용해서, 사원의 이름과 부서 이름을 출력
select  ename,
        (select dname from dept d where d.deptno=e.deptno)
from emp e;


------------------------from 부속질의------------------------
-- 인라인 뷰: from 뒤에 오는 서브 쿼리 -> select의 결과를 테이블로 사용

-- 고객번호가 2 이하인 고객의 판매액을 보이시오
-- (결과는 고객이름과 고객별 판매액 출력)

select * from orders;
select * from customer;

select cs.name, sum(saleprice)
from 
    (select custid, name
    from customer 
    where custid <= 2) cs,
    orders o
where o.custid = cs.custid
group by cs.name;

select o.custid, name, sum(saleprice)
from orders o, customer
where o.custid<=2
and o.custid = customer.custid
group by o.custid, name;

-- 30번 부서의 인라인 뷰를 만들어서 사용
select *
from (select * from emp where deptno=30)
;

------------------------where 부속질의------------------------
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장
select ename,sal
from emp
where sal > (select avg(sal) from emp);

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice) from orders);

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
select custid, orderid, saleprice
from orders o
where saleprice > (select avg(saleprice) from orders oa where o.custid=oa.custid);

select * from orders;
select avg(saleprice) from orders where custid=1;


-- 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원
select *
from emp
where deptno in(select DISTINCT deptno
                from emp
                where sal>=3000);

-- 3000 이상 받는 사원이 소속된 부서
select DISTINCT deptno
from emp
where sal>=3000
;

--대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select * from customer;
select * from orders;

--대한민국에 거주하는 고객
select custid from customer where address like '%대한민국%';

select sum(saleprice)
from orders
where custid in(select custid
                from customer
                where address like '%대한민국%');
                
--- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오
select * from orders;

-- max사용
select *
from orders
where saleprice > (select max(saleprice) from orders where custid=3);

select max(saleprice) from orders where custid=3;

-- all사용
select *
from orders
where saleprice > all(select saleprice from orders where custid=3);

select saleprice from orders where custid=3;


-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 많은 급여를 받는 사원의 이름, 급여를 출력
select ename, sal 
from emp
where sal > any(select sal
from emp
where deptno=30);


select sal
from emp
where deptno=30;


select sal
from emp
order by sal desc;

-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의 이름, 급여를 출력
select max(sal)
from emp
where deptno=30;

select ename, sal
from emp
where sal > (select max(sal)
from emp
where deptno=30);

select sal
from emp
where deptno=30;

select ename, sal
from emp
where sal > all(select sal
from emp
where deptno=30);

--- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오
select custid
from customer
where address like '%대한민국%';

select sum(saleprice)
from orders o
where EXISTS (select c.custid
from customer c
where address like '%대한민국%' and o.custid=c.custid);























