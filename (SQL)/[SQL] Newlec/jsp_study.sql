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
                
select count(*) from notice order by regdate desc;


drop view notice_view;

-- 예약어랑 겹치면 ""안에 넣어줘야한다. ""안에 넣을때는 대소문자를 가린다..!
create view NOTICE_VIEW
as
select n.id, n.title, n.writer_id, n.regdate, n.hit, n.files, count(C.id) CMT_COUNT
from notice N left join "COMMENT" C
on N.id = C.notice_id
group by n.id, n.title, n.writer_id, n.regdate, n.hit, n.files;
-- 집계함수와 같이 사용하기위해 group by해준다
-- content 데이터형식CLOB은 join문장에 들어갈 수 없다. CLOB을 varchar로 변환하면 join문장에 들어갈 수 있는데 그러면 4000자 내로 잘리게 된다.
-- view에는 order by빼는게 좋다. order

select * from (
select rownum num, N.* 
from (select * from NOTICE_VIEW where title like '%%' order by regdate desc) N)
where num between 1 and 10;







-- 91


--regdate이상

select * from
(select * from notice
where regdate > (select regdate from notice where id = 92)
order by regdate)
where rownum = 1;

select * from
(select * from notice
where regdate < (select regdate from notice where id = 92)
order by regdate desc)
where rownum = 1;


select count(id) count from 
(select rownum num, N.* 
from (select * from notice where title like '%%' order by regdate desc) N);



select n.id, n.title, n.writer_id, n.regdate, n.hit, n.files, n.pub, count(c.notice_id)
from notice N left join "COMMENT" C on n.id = c.notice_id
group by n.id, n.title, n.writer_id, n.regdate, n.hit, n.files, n.pub;

-- 93

select * from
(select * from notice
where regdate > (select regdate from notice where id = 93)
order by regdate) where rownum = 1;

select * from
(select * from notice
where regdate < (select regdate from notice where id = 93)
order by regdate desc) where rownum = 1;

DELETE FROM notice WHERE id in(127,128);

select * from notice_view;

INSERT INTO notice(title,content) VALUES ('제목인가요', '내용입니다');

DELETE FROM notice WHERE id in(135,136);

rollback;

INSERT INTO notice (title, writer_id, content,pub) VALUES ();













