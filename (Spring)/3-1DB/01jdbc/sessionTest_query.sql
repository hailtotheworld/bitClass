SELECT * FROM test.member;

commit;


SELECT @@AUTOCOMMIT;

SET AUTOCOMMIT = 0;

update member set money=1777 where member_id = 'memberA';


select * from member where member_id="memberA";