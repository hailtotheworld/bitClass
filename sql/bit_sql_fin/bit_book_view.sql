
-- 1. 책이름과 주문금액을 포함하는 orders_view 뷰
create or replace view orders_view
as
select o.orderid as orderid, o.userid as userid, o.bookid as bookid, b.bookname as bookname, b.price as price, o.orderdate AS orderdate
from bit_orders o, bit_book b
where o.bookid = b.bookid
order by o.orderid
;

-------------------- 테스트용 데이터 --------------------------------
-- insert into bit_orders (orderid, bookid, userid, orderdate)
insert into bit_orders values (1, 1, 10, sysdate-30);
insert into bit_orders values (2, 3, 11, sysdate-30);
insert into bit_orders values (3, 5, 12, sysdate-20);
insert into bit_orders values (4, 7, 13, sysdate-10);
insert into bit_orders values (5, 9, 14, sysdate-5);