
drop procedure if exists ifT;

delimiter $$
create procedure ifT()
begin
	declare days int;
    declare now date;
    declare debuDate date;
    
    set now = current_date();
    select debut_date into debuDate from member where mem_id='BLK';
    set days = datediff(now,debuDate);
    
    if(days>365) then
    select '1년넘었습니다';
    elseif(datediff<365) then
    select '1년미만입니다.';
    end if;
end $$
delimiter ;

call ifT();