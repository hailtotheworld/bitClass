-- function: 데이터를 받아서 처리후 결과를 반환

create or replace function func_interest(
    price number
) return int
IS
    -- 변수 선언
    myInterest NUMBER;
begin
    -- 30,000원 이상이면 10%, 미만이면 5% 값을 반환
    if price >= 30000 then
        myInterest := price*0.1;
    else
        myInterest := price*0.05;
    end if;
    
end
;






