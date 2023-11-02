drop table member;
create table member (
member_id varchar(10),
money integer not null default 0,
primary key (member_id)
);

-- 서버의 설정사항 출력
show variables; 

SELECT @@AUTOCOMMIT;
SET AUTOCOMMIT = 1;
SET AUTOCOMMIT = 0;

insert into member values("member1",1000);

delete from member;
commit;

SET AUTOCOMMIT = 0;
commit;

select * from member;
commit;
rollback;

delete from member;
insert into member(member_id, money) values ('memberA',10000);
insert into member(member_id, money) values ('memberB',10000);

SET AUTOCOMMIT = 0;
update member set money=10000 - 2000 where member_id = 'memberA';
update member set money=10000 + 2000 where member_id = 'memberB';

update member set money=10000 - 2000 where member_id = 'memberA';
update member set money=10000 + 2000 where member_iddd = 'memberB';

select * from member;
insert into member(member_id, money) values ('memberA',10000);
update member set money=500 where member_id = 'memberA';

select * from member where member_id="memberA" for update;

select * from member;