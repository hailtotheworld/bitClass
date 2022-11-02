CREATE DATABASE naver_db;
USE naver_db;

DROP TABLE IF EXISTS member;
CREATE TABLE member
( mem_id        CHAR(8),
  mem_name      VARCHAR(10) NOT NULL, 
  mem_number    TINYINT NOT NULL, 
  addr          CHAR(2) NOT NULL,
  phone1        CHAR(3) CHECK (phone1 IN('02','031','032','054','055','061')),
  email         CHAR(30) UNIQUE,
  height        TINYINT UNSIGNED CHECK (height>=100), 
  debut_date    DATE,
  CONSTRAINT PRIMARY KEY PK_member_mem_id (mem_id) -- 이렇게 지정하면 제약조건에 이름설정가능
);

desc member;

DROP TABLE IF EXISTS buy;  
CREATE TABLE buy
(  num          INT AUTO_INCREMENT PRIMARY KEY, 
   mem_id       CHAR(8) NOT NULL, 
   prod_name    CHAR(6) NOT NULL,
   group_name   CHAR(4),
   price        INT UNSIGNED NOT NULL,
   amount       SMALLINT UNSIGNED  NOT NULL DEFAULT 1,
   FOREIGN KEY (mem_id) REFERENCES member(mem_id) ON UPDATE CASCADE ON DELETE CASCADE
);

desc buy;

SELECT * 
FROM information_schema.table_constraints
WHERE 'member';