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









