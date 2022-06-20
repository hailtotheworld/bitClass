--동일한 도서가 있는지 점검한 후 삽입하는 프로시저(BookInsertOrUpdate)

create or replace procedure BookInsertOrUpdate (
    -- 매개변수
    myBookId number,
    myBookName varchar2,
    myPublisher varchar2,
    myPrice number
)
as
    -- 변수선언
    mycount number;
begin
    -- 입력받은 책이름으로 같은 이름의 책을 보유하는지 여부 확인 숫자
    select count(*) into mycount from book -- INTO: select count(*)의 결과를 변수 mycount에 넣어주는 역할을 한다.
    where bookname like myBookname; -- where bookname = myBookname;
    
    -- 책의 개수로 분기: 수정 또는 입력
    if mycount != 0 then
        -- 가격 수정
        update book set price = myPrice where bookname like myBookname;
    else 
        -- 데이터(행) 입력
        insert into book values(myBookId,myBookName,myPublisher,myPrice);
    end if;
end
;
















