use market_db;

select * from member;

select mem_id from member;

select addr 주소, debut_date "데뷔 일자", mem_name from member;

select * from member where mem_name='블랙핑크';

select * from member where mem_number=4;


select *
from member
where height > (select height from member where mem_name='블랙핑크');

select height from member where mem_name='블랙핑크';

select mem_id, sum(amount) from buy group by mem_id;

select mem_id, sum(amount*price) from buy group by mem_id;

SELECT * FROM market_db.buy;

select mem_id, avg(price) from buy group by mem_id;

select mem_id, sum(price*amount) from buy group by mem_id having sum(price*amount)>=1000;



