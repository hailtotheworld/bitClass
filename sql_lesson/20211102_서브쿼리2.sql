

-- 2021.11.02

-- 중첩 질의

-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장

select avg(sal)
from emp;

-- 2073.214285714285714285714285714285714286



-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
-- 평균 주문금액
select avg(saleprice) from orders;


--각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
SELECT avg(saleprice)
FROM orders
where custid=1;

select custid, orderid, saleprice
from orders O
where saleprice > (SELECT avg(saleprice)FROM orders OA where OA.custid=o.custid)
;













