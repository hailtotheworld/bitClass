CREATE TABLE MEMBER (
    ID       VARCHAR2(50),
    PWD      NVARCHAR2(50),
    NAME     NVARCHAR2(50),
--  GENDER   CHAR(6),      --1글자3바이트
--  GENDER   CHAR(2 CHAR), --1글자3바이트
    GENDER   NCHAR(2),     --1글자2바이트
    AGE      NUMBER,
    BIRTHDAY CHAR(10), --1990-10-29
    PHONE    CHAR(13), --010-1234-5678
    REGDATE  DATE
);

drop table member;

INSERT into member(gender) VALUES('남성');

select * from member;

select length('ab') from dual;
select lengthb('ab') from dual; --lengthb는 몇바이트 쓰는지 알려준다.

select length('한글') from dual; --2
select lengthb('한글') from dual; --6 한글은 한글자에 3바이트씩 차지한다.

select * from nls_database_parameters;