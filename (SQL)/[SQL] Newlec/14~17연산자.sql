INSERT INTO NOTICE(HIT) VALUES('1');
INSERT INTO NOTICE(HIT) VALUES('12');
INSERT INTO NOTICE(HIT) VALUES('9');
INSERT INTO NOTICE(HIT) VALUES('2');
INSERT INTO NOTICE(HIT) VALUES('23');

select * from notice order by hit;

select hit + 1 "hit" from notice order by hit;

select '3'+7 from dual; --10

select 1||3 from dual; --13

select concat(3,7) from dual;

select * from member;

select name||'('||id||')' "name" from member;

select * from notice where hit in(0,1,2);

select * from notice where hit between 0 and 2;

select * from notice;

commit;

insert into notice(title) values ('전화번호로 연락주세요 010-1234-7777');
insert into notice(title) values ('선반-접시-그릇 이렇게 3가지요');
insert into notice(title) values ('JDBC란 무엇인가');
insert into notice(title) values ('JDBC드라이버 다운로드 방법');
insert into notice(title) values ('JSP에서 JDBC 사용하기');
insert into notice(title) values ('service 계층 추가하기');

select * from notice where REGEXP_LIKE(title,'01[016-9]-\d{3,4}-\d{4}');







