USE market_db;
DROP PROCEDURE IF EXISTS user_proc1;
DELIMITER $$
CREATE PROCEDURE user_proc1(IN userName VARCHAR(10))
BEGIN
  SELECT * FROM member WHERE mem_name = userName; 
END $$
DELIMITER ;

CALL user_proc1('에이핑크');

drop procedure if exists proc1;
delimiter $$
create procedure proc1(in name varchar(10))
begin
	select * from member where mem_name=name;
end $$
delimiter ;

call proc1('소녀시대');



DROP PROCEDURE IF EXISTS dynamic_proc;
DELIMITER $$
CREATE PROCEDURE dynamic_proc(
    IN tableName VARCHAR(20)
)
BEGIN
  SET @sqlQuery = CONCAT('SELECT * FROM ', tableName);
  PREPARE myQuery FROM @sqlQuery;
  EXECUTE myQuery;
  DEALLOCATE PREPARE myQuery;
END $$
DELIMITER ;

CALL dynamic_proc ('member');




























drop procedure if exists testP1;
delimiter $$
create procedure testP1(
	IN txtValue varchar(10),
    OUT outValue int)
begin
	insert into notable values(null, txtValue);
    select max(id) into outValue from notable;
end $$
delimiter ;

drop table if exists notable;
create table notable(
	id int auto_increment primary key,
    text varchar(10));

call testP1('아이디',@myValue);
select @myValue;







