
insert into dept(dept_name,company_id) values ('회계',2);
insert into dept(dept_name,company_id) values ('총무',3);
insert into dept(dept_name) values ('회계');
insert into company(company_name) values ('삼성전자');


delete from dept;
delete from company;

delete from dept where dept_id = 13;

select * from company;
select * from dept;

commit;

delete from utest;
