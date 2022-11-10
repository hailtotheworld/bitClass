SELECT B.mem_id 'Member ID', M.mem_name AS 'Member Name', 
            B.prod_name "Product Name", 
            CONCAT(M.phone1, M.phone2) AS "Office Phone" 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;
         
create view  v_num1 as
    SELECT B.mem_id 'Member ID', M.mem_name AS 'Member Name', 
            B.prod_name "Product Name", 
            CONCAT(M.phone1, M.phone2) AS "Office Phone" 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;
         
select `Member ID` from v_num1;

show create view v_num1;

check table buy;
check table v_num1;

show create table member;


select *
from member
order by height desc
limit 1,3;

select * from member;

select count(*)
from member; -- 10

select count(phone1)
from member;

select * from buy;

select num, concat(price,'*',amount) 총구매액, price*amount from buy;


