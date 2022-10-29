
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
