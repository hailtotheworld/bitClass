
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

select * from buy;

select mem_name, sum(price*amount),
	case
		when sum(price*amount)>1000 then
        '우수고객'
		when sum(price*amount)>10 then
        '일반고객'
        else
        '유령고객'
    end as 등급
from member M left join buy B
on M.mem_id = B.mem_id
group by mem_name
order by sum(price*amount) desc;

select * from member;
desc member;
show index from member;
show table status;

select * from buy;
desc buy;
SHOW CREATE TABLE buy;
show index from buy;
show table status like 'buy';

select *
from member
where mem_id="APN";

create index inx_member_addr
on member(addr);
analyze table member;

select * from member;
desc member;
show index from member;
show table status like 'member';

drop index inx_member_addr on member;

show index from buy;v_membermem_idv_member
drop index mem_id on buy;
