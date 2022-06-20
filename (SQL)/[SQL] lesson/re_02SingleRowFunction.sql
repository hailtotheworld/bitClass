select abs(-10)
from emp;
-- 이렇게 하면 값이 여러개 나오잖아. 테스트 용으로 좋지 않지.

-- dual 함수를 사용하면 된다. 단일 행. 단일 열.
-- 함수 테스트할때 좋다
select abs(-10)
from dual;

select * from dual; -- 값볼때
desc dual; -- 구조볼때

-- 함수 : 단일행 함수, 집합 함수

-- 단일행 함수: 숫자, 문자, 날짜, 변환

-- 숫자 함수
select ABS(-15.5) from dual;

select ROUND(15.193,1) from dual; --특정자릿수에서 반올림한다

select trunc(15.678,2) from dual; --특정자릿수에서 잘라낸다

select MOD(11,4) from dual;

-- 문자 함수
select LOWER('MR. SCOTT MCMILLAN') "Lowercase" from dual;
select ename, lower(ename) from emp;

select CONCAT('저는', '손흥민 입니다.') from dual;
select concat(ename,sal) from emp;
select concat('나의 이름은 ', ename) from emp;

select LPAD('Page 1',15,'*')from dual;
select RPAD('Page 1',15,'*')from dual;
select rpad('901029-1',14,'*') from dual;

select SUBSTR('901029-1000000',1,8) from dual;

SELECT rpad(SUBSTR('901029-1012345',1,8),14,'*') FROM dual;

select rpad(substr(name,1,2),5,'*') from customer;

select * from customer;

select Ltrim('     -테스트-     ') from dual;
select Rtrim('     -테스트-     ') from dual;

select trim('+' from '+++++오예+신난다+++++') from dual;

SELECT REPLACE('JACK and JUE','J','BL')from dual;

select replace('010-1234-5678','-','') from dual;

select * from emp;

select * from emp where substr(hiredate,1,2)=81;

-- 날짜 함수
select sysdate from dual;
select SYSDATE + 10 from dual;
select add_months(sysdate,4) from dual;
select sysdate, to_char(SYSdate,'yyyy.mm.dd') from dual;


-- 변환 함수

-- 날짜 -> 문자 to_char(원본,패턴)
select to_char(sysdate, 'YYYY.MM.DD day PM HH:MI:SS')from dual;
select to_char(sysdate, 'YYYY.MM.DD. HH24:MI') from dual;

select hiredate, to_char(hiredate,'YYYY.MM.DD')from emp;

-- 숫자 -> 문자 to_char(원본,패턴)
select to_char(100000, '0,000,000')from dual;
select to_char(100000.123, 'L9,999,999.99')from dual;

select sal, to_char(sal*1200,'L999,999,999,999') from emp;

--문자 -> 날짜 to_date(원본,패턴)
select to_date('2021.12.29', 'YYYY.MM.DD')from dual;
--2021.01.01~오늘
select trunc(sysdate - to_date('2021-01-01', 'YYYY-MM-DD')) from dual;

--문자 -> 숫자 to_number(원본,패턴)
select to_number('100,000','9,999,999') + 100000 from dual;

select * from emp;

select SUBSTR('ABCDEFG',3,4)from dual;

select ename, deptno,
decode(deptno,
10, 'account',
20, 'research',
30, 'sales',
40, 'operations') as dname
from emp;

select ename, deptno,
decode(substr(ename,1,1),
'K', 'K성을 가짐'
) as dname
from emp;

select * 
from emp;

select ename, job, sal,
decode(job,
'ANALYST', sal*1.05,
'SALESMAN', sal*1.1,
'MANAGER', sal*1.15,
'CLERK', sal*1.2) as upsal
from emp;

-- case when then else end : 조건식을 = 이외에 비교 연산도 할 수 있다.
select ename, job, sal,
case
when job='ANALYST' then sal*1.05
when job='SALESMAN' then sal*1.1
when job='MANAGER' then sal*1.15
when job='CLERK' then sal*1.2
else sal
end as upsal
from emp;

select ename, job, sal,
case
when sal>=5000 then '5000이상'
when sal>=3000 then '3000이상'
when sal>=2000 then '2000이상'
else '2000미만'
end as "월급수준"
from emp
order by "월급수준" desc;







