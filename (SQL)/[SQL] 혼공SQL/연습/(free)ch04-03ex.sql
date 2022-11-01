drop procedure if exists ifProc3;
delimiter $$
create procedure ifProc3()
begin
	declare debutDate date;
    declare curDate date;
    declare days int;
    
    select debut_date into debutDate
    from member
    where mem_id='BLK';
    set curDate = current_date();
    set days = datediff(curDate,debutDate);
    
    if(days/365 >= 5) then
		select concat('데뷔한지 5년지났습니다',days,'일지났어요');
	elseif(days/365 >=3) then
		select concat('데뷔한지 3년지났습니다',days,'일지났어요');
	else
		select concat('데뷔한지 3년미만',days,'일지났어요');
	end if;

end $$
delimiter ;
call ifProc3();

select M.mem_id, mem_name, sum(price*amount),
	case
		when sum(price*amount) >= 1500 then '최우수고객'
		when sum(price*amount) >= 1000 then '우수고객'
        when sum(price*amount) >= 0 then '일반고객'
        else '유령고객'
    end "등급"
    
	from member M
	left join buy B
	on M.mem_id = B.mem_id
group by M.mem_id
order by sum(price*amount) desc;


DROP PROCEDURE IF EXISTS caseProc; 
delimiter $$
create procedure caseProc()
begin
	declare score int;
    declare result char(1);
    set score=88;
    case
		when score>=90 then
        set result = 'A';
		when score>=80 then
        set result = 'B';
        else
		set result='F';
	end case;
    select result;
end $$
delimiter ;
call caseProc();


-- 1~100 더하는 프로시저 만들어봐
drop procedure if exists hap;
delimiter $$
create procedure hap()
begin
	declare i int;
    declare sum int;
	set i=1;
    set sum=0;
    
    while(i<=100) do
    set sum = sum+i;
    set i=i+1;
    end while;
    
    select sum;
end $$
delimiter ;
call hap();


-- 4의 배수 제외하고, 총값이 1000넘으면 종료해
drop procedure if exists hap;
delimiter $$
create procedure hap()
begin
	declare i int;
    declare sum int;
	set i=1;
    set sum=0;
    
    myWhile:
    while(i<=100) do
	  if(i%4=0) then
        set i=i+1;
        iterate myWhile;
	  end if;
    
      if(sum>1000) then
      leave myWhile;
      end if;
      
    set sum = sum+i;
    set i=i+1;
    
    end while;
    
    select sum;
end $$
delimiter ;
call hap();

drop table if exists gate_table;
create table gate_table(id int auto_increment primary key, entry_time datetime);

set @curDate = current_timestamp();
prepare myQuery From 'insert into gate_table values(null,?)';
execute myQuery using @curDate;
deallocate prepare myQuery;

select * from gate_table;




