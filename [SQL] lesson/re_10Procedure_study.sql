-- procedure
-- 데이터를 받아서 데이터 변경처리를 프로그램 요소를 이용해서 실행

-- create or replace  프로시저이름
-- (매개변수)
-- as --선언부
-- begin --프로그램 코드 시작
-- ...프로그램코드
-- end
-- ;

-- Book테이블에 한 개의 투플을 삽입하는 프로시저
desc book;

----------~~~procedure1.sql~~~----------

-- 프로시저 호출: 실행 요청
-- exec 프로시저이름(매개변수값,...);
exec Insertbook(13,'스포츠과학','마당과학서적',25000);

select * from book;

------------------------------------------------------------------------------------------

----------~~~procedure2.sql~~~----------

-- 같은 이름의 책을 등록해보고, 다른 이름의 책을 입력
-- 같은 이름의 책 등록
select * from book;

exec bookinsertorupdate(15,'스포츠 즐거움','마당과학서적','25000');

exec bookinsertorupdate(15,'스포츠 즐거움','마당과학서적','70000'); 

------------------------------------------------------------------------------------------

----------~~~procedure3.sql~~~----------

set serveroutput on;

DECLARE
  avgVal1 number;
BEGIN
  -- 프로시저 호출
  avgprice(avgVal1);
  DBMS_OUTPUT.PUT_LINE('책값 평균: '|| avgVal1);
END;

------------------------------------------------------------------------------------------

----------~~~procedure4.sql~~~----------

set serveroutput on;
exec Interest;
















