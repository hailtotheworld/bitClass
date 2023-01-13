select * from noticeview
where title like '%%'
order by regdate desc
limit 0,10;
  -- <, 개
  
select count(id) from notice
where title like '%%';

select * from noticeview
where id = 3;

select * from notice;

select * from notice
where id>3
order by regdate asc
limit 0,1;

select * from notice
where id<5
order by regdate desc
limit 0,1;


-- next
select * from notice
where regdate > (select regdate from notice where id=3)
limit 1;

-- prev
select * from notice
where regdate < (select regdate from notice where id=7)
order by regdate desc
limit 1;

select * from notice;

  update Notice
  set
  	pub = case id
  			when 6 then 1
            when 7 then 1
  		  end
  where id in(6,7);
  


  
update notice
  		set pub = 
  		case
  			when id = 14 then 0
  			when id = 15 then 0
  		end
where id in(14,15);

delete from notice
where id;
rollback;

select * from notice;

SELECT @@AUTOCOMMIT;
SET AUTOCOMMIT = 0; 

SHOW GLOBAL VARIABLES;

select * from notice;
commit;
rollback;
delete from notice;

use sys;

select * from notice;
commit;

delete from notice where id = 21;
commit;

show binary logs;

select * from notice;
commit;


select * from notice;
delete from notice;
commit;

  	update notice
  	set pub =
  		case
			when id = 1 then 0
			when id = 2 then 0
			when id = 14 then 1
			when id = 15 then 1
  	    end
  	where id in(1,2,14,15);
    
select * from notice;

commit;
delete from notice where title like '%18%';

use newlecture;



