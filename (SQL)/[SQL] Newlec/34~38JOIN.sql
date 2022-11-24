select rownum, member.*
from (select rownum N, member.* from member order by name)
where N between 1 and 10;

select * from member;

select phone, name from member group by phone, name;

select id,name from member
union
select notice.writer_id, notice.title from notice;