drop procedure if exists ifProc2;

DELIMITER $$
CREATE procedure ifProc2()
BEGIN
	declare myNum INT;
    Set myNum = 200;
    IF myNum = 100 THEN
		select '100입니다';
	ELSE
		select '100이 아닙니다.';
	End if;

END $$
DELIMITER ;

call ifProc2();



drop procedure if exists ifProc3;
delimiter $$
create procedure ifProc3()
begin
	declare debutDate DATE;
    declare curDate DATE;
    declare days INT;
    
    select debut_date INTO debutDate
    from member
    where mem_id='APN';
    
    set curDate = current_date();
    set days = datediff(curDate,debutDate);
    
    if(days/365) >= 5 then
		select concat('데뷔한지', days, '일이 지났습니다. 5년이 더 지났네요') as 5년;
	elseif (days/365) >= 3 then
		select concat('데뷔한지',days,'일이 지났습니다. 3년이 더 지났네요');
	else
		select concat('데뷔한지',days,'일이 지났습니다. 3년미만');
	end if;
    

end $$;

delimiter ;

call ifProc3();





































