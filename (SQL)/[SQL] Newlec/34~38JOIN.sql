select rownum, member.*
from (select rownum N, member.* from member order by name)
where N between 1 and 10;


select