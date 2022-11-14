
SELECT * from notice;

SELECT * from notice where rownum BETWEEN 1 and 5;

SELECT * from notice where rownum <= 5;

SELECT * from notice where rownum BETWEEN 6 and 10; --안됨

select * from (select ROWNUM num, notice.* from notice) where num between 6 and 12;

