drop procedure if exists caseProc;

delimiter $$
create procedure caseProc()
begin
	declare score int;
    declare grade char(1);
    
    set score = 97;
    
    case
		when score >90 then
		set grade='A';
        when score>80 then
        set grade= 'B';
        else
        set grade='F';
    end case;
    select grade;
end $$
delimiter ;

call caseProc();

select * from buy;
select * from member;

select *
from member M
	join buy B
on M.mem_id=B.mem_id;




