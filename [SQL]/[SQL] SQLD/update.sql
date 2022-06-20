create table 주문 (
C1 number(10),
C2 DATE,
C3 VARCHAR(10),
C4 NUMBER DEFAULT 100
);

select * from 주문;

INSERT INTO 주문(C1,C2,C3) VALUES(1,SYSDATE,'TEST2');

delete 주문;
delete from 주문;

UPDATE 주문 SET C1=5;
