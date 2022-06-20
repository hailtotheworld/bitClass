
--Orders 테이블의 판매 도서에 대한 이익을 계산하는 프로시저(Interest)
create or replace procedure Interest
as
    -- 변수 선언
    myInterest numeric; --number도 된다.
    price numeric;
    -- 1. 커서 생성(정의)
    cursor interestCursor is select saleprice from orders;
begin
    myInterest := 0.0; -- := sql 프로시저만들때나 쓰여짐
    -- 2. 커서 오픈
    open interestCursor;
    -- 반복하면서 각 행의 값을 처리
    Loop
        -- 3. 커서 패치
        fetch interestCursor into price;
        
        -- 반복문의 탈출
        EXIT WHEN interestCursor%notfound;

        -- price 값을 비교
        if price >= 30000 then
            myinterest := myinterest + price*0.1;
        else
            myinterest := myinterest + price*0.05;
        end if;
     
    end loop;
    
    -- 4. 커서 종료
    close interestCursor;
    
    -- 수익금 총액을 출력
    DBMS_OUTPUT.PUT_LINE('전체 이익 금액 = ' || myInterest);
end
;








