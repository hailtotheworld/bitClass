select *
from
(select rownum num, N.*
from
(select * from notice order by regdate desc) N);


select *
from
(select rownum num, N.*
from
(select * from notice order by regdate desc) N)
where num = (select num
from
(select rownum num, N.*
from
(select * from notice order by regdate desc) N)
where id = 6)-1;

select * from notice where id = (
select id
from
(select * from notice where regdate > (select regdate from notice where id = 7) order by regdate desc)
where rownum = 1);

select * 
from
(select * from notice where regdate < (select regdate from notice where id = 8) order by regdate desc)
where rownum = 1;


select id
from 
(select * from notice where regdate > (select regdate from notice where id = 70) order by regdate) 
where rownum = 1;

select * from notice where id = '7' ;


