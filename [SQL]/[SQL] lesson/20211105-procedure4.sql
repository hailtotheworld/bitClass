

--procedure

-- Orders 테이블의 판매 도서에 대한 이익을 계산하는 프로시저(Interest)
CREATE or REPLACE PROCEDURE interest
as
    -- 변수 선언
    myInterest numberic;
    price numberic;
    -- 1. 커서 생성(정의)
    cursor interestCursor IS SELECT saleprice from orders;    
begin 
    price := 0.0;
    -- 2. 커서 오픈
    open interestCursor;
    -- 반복하면서 각 행의 값을 처리
    Loop
        -- 3. 커서 패치
        fetch interestCursor into price;
        
        -- 반복문의 탈출
        exit when interestcursor%notfound;
        
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
    DBMS_OUTPUT_PUT_line('전체 이익 금액 = '|| myInterest);
end;

----------------------------------------------------------
 CREATE OR REPLACE PROCEDURE Interest
AS
myInterest NUMERIC;
Price NUMERIC;
CURSOR InterestCursor IS SELECT saleprice FROM Orders;
BEGIN
myInterest := 0.0;
OPEN InterestCursor;
LOOP
FETCH InterestCursor INTO Price;
EXIT WHEN InterestCursor%NOTFOUND;
IF Price >= 30000 THEN
myInterest := myInterest + Price * 0.1;
ELSE
myInterest := myInterest + Price * 0.05;
END IF;
END LOOP;
CLOSE InterestCursor;
DBMS_OUTPUT.PUT_LINE(' 전체 이익 금액 = ' || myInterest);
END;






