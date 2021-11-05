

-- 2021.11.05
-- procedure
-- 데이터를 받아서 데이터 변경처리를 프로그램 요소를 이용해서 실행

-- create or replace {프로시저 이름} (매개변수)
-- as -- 선언부
-- begin -- 프로그램 코드 실행
-- ......
-- end
-- ;

desc book;
-- Book테이블에 한 개의 튜플을 삽입하는 프로시저
CREATE or replace PROCEDURE InsertBook(
    -- 매개변수 선언
    myBookId in number,
    myBookName in VARCHAR2,
    myPublisher in varchar2,
    myPrice in number
)
as
begin -- 코드 실행 시작
    -- 핵심처리 코드
    -- 매개변수로 받은 데이터를 이용해서 데이터 삽입.
    insert into book (bookid, bookname, publisher, price)
    values (myBookId, myBookName, myPublisher, myPrice);
end -- 코드 실행 종료
;

-- 프로시저 호출 : 실행 요청
-- exec 프로시저이름(매개변수값,....);
exec insertbook(13, '스포츠과학', '마당과학서적', 25000);


















