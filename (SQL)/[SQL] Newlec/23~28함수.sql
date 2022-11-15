
SELECT * FROM MEMBER;
DESC MEMBER;


INSERT INTO MEMBER(NAME,birthday) VALUES('디지몬','91-07-05');
INSERT INTO MEMBER(NAME,birthday) VALUES('포켓몬','88-04-05');

SELECT * FROM MEMBER WHERE SUBSTR(birthday,4,2) NOT IN(07,08,09);
SELECT * FROM MEMBER WHERE SUBSTR(birthday,4,2) IN(07,08,09);

SELECT * FROM MEMBER WHERE PHONE IS NULL AND SUBSTR(birthday,4,2) IN(07,08,09);

SELECT RPAD(NAME,6,'_') FROM member;


INSERT INTO MEMBER(regdate) VALUES(SYSTIMESTAMP);

SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;
SELECT CURRENT_DATE, CURRENT_TIMESTAMP FROM DUAL;

select SYSTIMESTAMP from dual;
select to_char(systimestamp, 'YYYY-MM-DD AMHH:MI') from dual;

select EXTRACT(month from sysdate) || '월' from dual;

select EXTRACT(month from regdate) from member where EXTRACT(month from regdate) in(11,12);

select * from member where 180>EXTRACT(day from sysdate)-EXTRACT(day from regdate);

select * from member where ADD_MONTHS(SYSDATE,-6) < regdate;



