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
insert into member(member_id, money) values ('data3',10000);
insert into member(member_id, money) values ('data4',10000);
commit;

select * from member;
commit;
rollback;




