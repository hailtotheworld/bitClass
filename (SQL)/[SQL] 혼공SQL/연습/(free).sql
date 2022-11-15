-- 데뷔일자

drop procedure if exists ifT;
delimiter $$
create procedure ifT()
begin
	declare days int;
    declare today date;
    declare debutDate date;
    
    set today = current_date();
    select debut_date into debutDate from member where mem_id='GRL';
    set days = datediff(today, debutDate);
    
	if(days/365>5) then
    select concat('5년 이상이네요. 데뷔한지',days,'지났습니다.');
	elseif(days/365<5) then
    select concat('5년미만이네요. 데뷔한지',days,'지났습니다.');
    end if;
    
end $$
delimiter ;

select * from member;

select * from member;
desc member;
SHOW CREATE TABLE member;
SHOW INDEX FROM member;