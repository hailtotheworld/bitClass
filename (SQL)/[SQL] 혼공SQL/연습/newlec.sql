show databases;
show tables;

-- 사용자만들기
create user newlecture identified by '0000';

-- 특정사용자에게 특정데이터베이스의 모든 오브젝트에 대한 권한을 주겠다
grant all privileges on market_db.* to newlecture;
