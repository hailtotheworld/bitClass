

-- (12) 도서의가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select orderid, price-saleprice
from book b, orders o
where b.bookid = o.bookid
and price-saleprice >= all(select price-saleprice
from book b, orders o
where b.bookid = o.bookid)
;

select price-saleprice
from book b, orders o
where b.bookid = o.bookid;


-- (13) 도서의 판매액 평균 보다 자신의 구매액 평균이 더 높은 고객의 이름
select avg(saleprice) from orders s;

select name, avg(saleprice)
from customer c, orders o
where o.custid = c.custid
GROUP BY name
having avg(saleprice) > (select avg(saleprice) from orders);

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name, count(publisher)
from customer c, book b, orders o
where c.custid=o.custid and b.bookid=o.bookid
group by name
having count(distinct publisher)>1;







