--ROWNUM은 일련번호이다. 순위가아니다
select ROWNUM ,name from (select rownum N, member.* from member) where N between 2 and 6;

--정렬된 상태에서의 일련번호 123456789
SELECT ROW_NUMBER() OVER (ORDER BY nvl(hit,0) desc), notice.* FROM notice;

--정렬된 상태에서의 순위 123446779
SELECT RANK() OVER (ORDER BY nvl(hit,0) desc), notice.* FROM notice;

--12344677
SELECT DENSE_RANK() OVER (ORDER BY nvl(hit,0) desc), notice.* FROM notice;

