

-- 임시 테이블 생성
create table book_log(
    bookid_l number,
    bookname_l varchar2(40),
    publisher_l varchar2(40),
    price_l number
);

select * from book_log;

-- 트리거
create or replace TRIGGER AfterInsertBook
after insert on book --book테이블에 입력되고 나서 이후 처리할라는 의미
for each row  -- 각각의 행 하나하나 입력할때마다 시행하겠다는 의미

declare
    -- 변수 선언
    average number;
begin
    insert into book_log
    values (:new.bookid, :new.bookname, :new.publisher, :new.price);
    dbms_output.put_line('book_log 테이블에 백업!');
end
;
                    
----------------------------------------------------------------------------------
-- 트리거 실행 테스트
insert into book values (20,'스포츠 과학2','이상미디어',60000);

select * from book_log;

delete from book where bookid=20;










