
drop function if exists testTT;

SET GLOBAL log_bin_trust_function_creators = 1;

delimiter $$
create function testTT(num1 int, num2 int)
	returns int
begin
	return num1 + num2;
end $$
delimiter ;


drop function if exists testTT2;

-- 현재년도를 입력하면 활동년도를 출력
delimiter $$
create function testTT2(yearData int, name varchar(10))
	returns int
begin
	declare debutYear int;
	select extract(year from debut_date) into debutYear from member where mem_name = name;
    return yearData - debutYear;
end $$
delimiter ;


select testTT2(2013,'오마이걸') from dual;

select extract(year from debut_date) from member;


select * from member;

