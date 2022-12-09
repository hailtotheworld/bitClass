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

select * from
(select rownum num, N.*
from
(select * from notice order by regdate desc) N)
where num between 6 and 10;

select count(*) count from
(select rownum num, N.*
from
(select * from notice order by regdate desc) N);


select *
from (select * from notice where regdate > (select regdate from notice where id=50) order by regdate)
where rownum = 1;
 

select *
from (select * from notice where regdate < (select regdate from notice where id=50) order by regdate desc)
where rownum = 1;


select count(id) count from ( 
				select rownum num, N.* 
				from (select * from notice where title like '%%' order by regdate desc) N) ;
                
              
select * from notice order by regdate desc;
                
select count(id) count from 
(select rownum num, N.*
from (select * from notice where title like '%제목%' order by regdate desc) N)
where num between 6 and 10;

select * from notice order by regdate;

select * from
(select * from notice
where regdate < (select regdate from notice where id = 8) order by regdate desc)
where rownum = 1;
                
                
--다음글    
--1regdate큰목록들찾아내봐
--2정렬
--3rownum
                
select * from notice order by regdate desc;                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                

