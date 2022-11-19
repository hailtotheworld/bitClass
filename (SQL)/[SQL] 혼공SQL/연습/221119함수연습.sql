SET GLOBAL log_bin_trust_function_creators = 1;

drop function if exists testTT;
delimiter $$
create function testTT(num1 int,num2 int)
	returns int
begin
	return num1 + num2;
end $$
delimiter ;

select testTT(7,10) from dual;



-- 원하는 년도를 넣으면 활동년수를 알려주는 함수
drop function if exists testTT2;
delimiter $$
create function testTT2(knowYear int)
	returns int
begin
	return knowYear - extract(year from debutDate);
end $$
delimiter ;


select member.*, extract(year from sysdate()) - extract(year from debut_date) from member;

select * from member;




