-- index
select * from member where member_name='아이유';

create index idx_member_name on member(member_name);

-- view
create view member_view
as
select * from member;

select * from member_view;

-- 스토어드 프로시저
DELIMITER //
create procedure myProc()
begin
	select * from member where member_name='나훈아';
	select * from product where product_name='삼각김밥';
end //
DELIMITER ;

CALL myProc();


