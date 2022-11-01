select * from buy;
select * from member;
select * from emp_table;

-- 한번이라도 구매기록이 있는 회원
select distinct M.mem_id, m.mem_name
	from member M
	join buy B
    on M.mem_id = B.mem_id;

-- 가입만하고 구매한적없는회원
select *
	from member M
    left outer join buy B
    on M.mem_id=B.mem_id
where B.num is null;
    

-- 상관의 전화번호
CREATE TABLE emp_table (emp CHAR(4), manager CHAR(4), phone VARCHAR(8));
INSERT INTO emp_table VALUES('대표', NULL, '0000');
INSERT INTO emp_table VALUES('영업이사', '대표', '1111');
INSERT INTO emp_table VALUES('관리이사', '대표', '2222');
INSERT INTO emp_table VALUES('정보이사', '대표', '3333');
INSERT INTO emp_table VALUES('영업과장', '영업이사', '1111-1');
INSERT INTO emp_table VALUES('경리부장', '관리이사', '2222-1');
INSERT INTO emp_table VALUES('인사부장', '관리이사', '2222-2');
INSERT INTO emp_table VALUES('개발팀장', '정보이사', '3333-1');
INSERT INTO emp_table VALUES('개발주임', '정보이사', '3333-1-1');
select * from emp_table;

select *
	from emp_table A
    join emp_table B
    on A.manager = B.emp
where A.emp = '영업과장';



