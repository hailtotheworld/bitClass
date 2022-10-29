
set @var1 = 5;
set @var2 = 7;

select @var1;
select @var2;

select @var1+@var2;

set @txt = '가수이름 ->';
set @height = '166';

select @txt '가수이름', mem_name
from member
where height>@height;

set @count = 3;
prepare countTest from 'select * from member order by height desc limit ?';
execute countTest using @count;

--
select avg(price) from buy;

select cast(avg(price) as signed) from buy;
select convert(avg(price),signed) from buy;

select cast('2022!10!29' as date) from dual;
select convert('2022$10$29', date) from dual;
--
select num, concat(price, 'X', amount,'=') 가격X수량, amount 수량 from buy;
select '100'+'200'; -- 300
select concat('100','200');

-- 4-2---------------------------------------------

select * 
	from buy
	inner join member
    on buy.mem_id = member.mem_id
where buy.mem_id = 'GRL';

select * 
	from buy B
	inner join member M
	on B.mem_id = M.mem_id;
    
select B.mem_id, mem_name, prod_name, addr, concat(phone1, phone2) 
  from buy B
	inner join member M
	on B.mem_id = M.mem_id
  order by B.mem_id;
  
  -- 우리 사이트에서 한번이라도 구매한사람
select distinct B.mem_id, mem_name, addr, concat(phone1, phone2) 
	from member M
	inner join buy B
    on M.mem_id = B.mem_id
order by M.mem_id;

select count(distinct M.mem_id)
	from member M
	left outer join buy B
	on M.mem_id = B.mem_id;
  
select count(mem_id) from member;


-- 회원가입은하고 한번도 구매한적없는 회원
select * 
	from member M
    left join buy B
    on M.mem_id = B.mem_id
where b.prod_name is null;

USE market_db;
CREATE TABLE emp_table (emp CHAR(4), manager CHAR(4), phone VARCHAR(8));

INSERT INTO emp_table VALUES('대표', NULL, '0000');
INSERT INTO emp_table VALUES('영업이사', '대표', '1111');
INSERT INTO emp_table VALUES('관리이사', '대표', '2222');
INSERT INTO emp_table VALUES('정보이사', '대표', '3333');
INSERT INTO emp_table VALUES('영업과장', '영업이사', '1111-1');
INSERT INTO emp_table VALUES('경리부장', '관리이사', '2222-1');
INSERT INTO emp_table VALUES('인사부장', '관리이사', '2222-2');
INSERT INTO emp_table VALUES('개발팀장', '정보이사', '3333-1');
INSERT INTO emp_table VALUES('개발주임', '정보이사', '3333-1-1');

select * from emp_table;

-- 경리부장의 상관의 전화번호.
select B.phone
	from emp_table A
    join emp_table B
    on A.manager = B.emp
where A.emp='경리부장';

select * from buy;
desc buy;
select * 
	from member M
    left join buy B
    on M.mem_id = B.mem_id
where b.num is null;

SELECT DISTINCT M.mem_id, M.mem_name, M.addr
   FROM buy B
     INNER JOIN member M
     ON B.mem_id = M.mem_id;
     
SELECT DISTINCT M.mem_id, M.mem_name, M.addr
FROM buy B
 left JOIN member M
 ON B.mem_id = M.mem_id;
