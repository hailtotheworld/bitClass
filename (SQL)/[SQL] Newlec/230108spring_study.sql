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

