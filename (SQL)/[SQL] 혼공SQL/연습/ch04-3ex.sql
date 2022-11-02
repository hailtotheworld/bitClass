-- if문예제. 데뷔년도별 다른 메시지 출력하는 프로시저

drop procedure if exists ifProc;
delimiter $$
create procedure ifProc()
begin
	declare debutDate date;
    declare curDate date;
    declare days int;
    
    select debut_date into debutDate
    from member
    where mem_id='BLK';
    
    set curDate = current_date();
    set days = datediff(curDate,debutDate);
    
    if(days/365) >= 5 then
    select concat('5년넘었습니다',days);
    elseif(days/365) >= 3 then
	select concat('3년넘었습니다',days);
    else
	select concat('3년미만이네요.',days);
    end if;

end $$

delimiter ;

call ifProc();

-- 점수별로 학점주기
drop procedure if exists caseProc;
delimiter $$
create procedure caseProc()
begin
	declare score int;
    declare grade char(1);
    
    set score = 70;
    
    case
		when score>=90 then
        set grade='A';
		when score>=80 then
        set grade='B';
        else
		set grade='C';
	end case;
    select grade;
end $$
delimiter ;

call caseProc();

-- 구매금액별 등급
select mem_name, sum(price*amount),
	case
		when sum(price*amount)>1500 then
		'우수고객'
        when sum(price*amount)>1000 then
		'일반고객'
		when sum(price*amount)>1 then
		'그냥고객'
		else
		'유령고객'
    end "등급"
from member M
left join buy B
on M.mem_id=B.mem_id
group by mem_name
order by sum(price*amount) desc;

-- 1부터 100까지의 합 procedure
drop procedure if exists while1;
delimiter $$
create procedure while1()
begin
	declare i int;
    declare sum int;
    set i=0;
	set sum=0;
    
    while(i<100) do
    set i=i+1;
    set sum=sum+i;
    end while;
    select sum;
end $$
delimiter ;
call while1();

-- 4의 배수 빼고 더해, 1000넘기전까지만
drop procedure if exists while2;
delimiter $$
create procedure while2()
begin
	declare i int;
    declare sum int;
    set i=0;
    set sum=0;
    
    myWhile:
    while(i<=100) do
		set i=i+1;
		if(i%4=0) then
        iterate myWhile;
        end if;
        
        set sum=sum+i;
    

                
		if(sum>1000) then
        leave myWhile;
        end if;
	end while;
    select sum;
end $$
delimiter ;
call while2();

select * from member;

SET @name='에이핑크';
PREPARE myQuery FROM 'select * from member where mem_name=?';
EXECUTE myQuery USING @name;
DEALLOCATE PREPARE myQuery;	

drop table if exists gate;
create table gate (id int auto_increment primary key,entry_time datetime);
set @curDate = current_timestamp();
prepare Q from 'insert into gate values(null,?)';
execute Q using @curDate;
deallocate prepare Q;

select * from gate;




