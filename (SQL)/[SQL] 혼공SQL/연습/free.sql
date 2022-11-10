
drop procedure if exists caseT;
delimiter $$
create procedure caseT()
begin
	declare score int;
    declare grade char(1);
    
    set score = 95;
    case
		when score>90 then
        set grade = 'A';
		when score>80 then
        set grade = 'B';
		when score>70 then
        set grade = 'C';
        else
        set grade='D';
    end case;
    select grade;
end $$
delimiter ;

call caseT();


select *
from member M left join buy B
on M.mem_id = B.mem_id;








