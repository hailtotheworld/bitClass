desc member;

select * from member;

insert into member(id, pwd) values('newlec','111');
insert into member(id, pwd) values('dragon','111');
insert into member(id, pwd) values('test','111');

select id as user_id,name,pwd from member;

update member set pwd='222',name='뉴렉' where id='newlec';
delete from member where id = 'test';