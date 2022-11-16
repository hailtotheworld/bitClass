select ROWNUM ,name from (select rownum N, member.* from member) where N between 2 and 6;

SELECT * FROM notice;



--ROWNUM은 일련번호이다. 순위가아니다