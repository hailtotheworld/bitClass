select * from (
select rownum num, N.*
from (select * from notice order by regdate desc) N)
where num between 6 and 10;

select *
from
(select rownum num, n.*
from
(select * from notice order by regdate desc) N)
where num between 6 and 10;