
-- 2021.11.05
-- procedure

-- Book 테이블에 저장된 도서의 평균가격을 반환하는 프로시저
create or replace procedure avgPrice(
    avgVal out number --out은 받는게 아니라 출력한다는 의미
)
AS
begin
    select avg(price) into avgVal from book where price is not null;
end
;


