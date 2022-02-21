-- 집합 함수 (그룹 함수,집계 함수)
-- 하나의 행의 컬럼이 대상이 아니고, 행 그룹의 컬럼들(집합)이 대상

desc emp;
select * from emp;

select
    to_char(SUM(sal)*1200, 'L999,999,999') as "월 급여 총액(원화)",
    to_char(round(avg(sal)*1200), 'L999,999,999') as "월 급여 평균",
    count(*) as "총 사원의 수",
    count(comm) as "커미션 등록 수", --null은 제외된거야.
    to_char(sum(comm),'L999,999') as "커미션 합", --null은 제외된거야.
    to_char(avg(comm),'L999,999') as "커미션 평균", --null은 제외된거야.
    max(sal) as "가장 높은 급여",
    min(sal) as "가장 낮은 급여"
from emp;

-- 사원들의 업무의 개수
select count(distinct job) from emp;

-- 각 부서별 급여의 총합
select deptno, sum(sal)
from emp
GROUP BY deptno
order by deptno asc;

-- group by : 특정 컬럼으로 그룹핑 -> 그룹내의 평균이나 합과 같은 집합 함수를 사용할 수 있다.

-- 부서번호를 기준으로 그룹핑하고,
-- 사원의 수, 급여의 총합, 평균, 최대, 최소, 
-- 커미션 대상자 수, 커미션 평균, 커미션 총합
select deptno,
       count(*) as "사원의 수",
       sum(sal) as "급여 총합",
       round(avg(sal),0) as "급여 평균",
       max(sal) as "최대 급여",
       min(sal) as "최소 급여",
       count(comm) as "커미션 대상자 수", --null값은 집계되지 않는다
       nvl(sum(comm),0) as "커미션 총합",
       nvl(avg(comm),0) as "커미션 평균"
from emp
group by deptno
order by deptno;

select deptno, trunc(avg(sal))
from emp
--where deptno != 20 --where은 그룹하기 전에 대상을 정하는거야
group by deptno
having avg(sal)>=2000 --having은 그룹핑되어있는 집합함수 중에 특정 집합함수를 기준으로.
;









