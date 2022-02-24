-- 43.사원 번호가 7788인 사원과 담당 업무가 같은 
--    사원을 표시(사원 이름과 담당업무)하시오.
select *
from emp
where job=(select job
from emp
where empno=7788);

select job
from emp
where empno=7788;

-- 44. 사원번호가 7499인 사원보다 
--     급여가 많은 
--     사원을 표시하시오. 사원이름과 담당 업무
select *
from emp
where sal > (select sal
from emp
where empno=7499);

select sal
from emp
where empno=7499;

-- 45. 최소급여를 받는 
--     사원의 이름, 담당업무 및 급여를 표시하시오. 
--     (그룹함수 사용)
select *
from emp
where sal <= all(select sal from emp);

-- 46. 평균급여가 가장 적은 직급의 
--     직급 이름과 직급의 평균을 구하시오.

-- 직급별 평균급여
select avg(sal) from emp group by job;

-- 평균급여가 가장적은 액수.
select min(avg)
from (
    select avg(sal) as avg
    from emp
    group by job
)
;

select job, avg(sal)
from emp
GROUP BY job
having avg(sal) = (select min(kk)
from (select avg(sal) as kk from emp group by job));

select avg(sal)
from emp
group by job;

select min(kk)
from (select avg(sal) as kk from emp group by job);

--
select job, avg(sal)
from emp
group by job
having avg(sal) = (
    select min(kk)
    from (
        select avg(sal) as kk
        from emp
        group by job
        )        
    )
;
-- 47. 각 부서의 최소 급여를 받는 
--     사원의 이름, 급여, 부서번호를 표시하시오.


-- 각 부서의 최소 급여
select min(sal) from emp where deptno=10;

select *
from emp e1
where sal = (
    select min(sal) from emp e2 where e2.deptno=e1.deptno
    )
;

select min(sal) from emp where deptno=10;

select * 
from emp e1
where sal = (select min(sal) from emp e2 where e1.deptno=e2.deptno);

-- 48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서
--     업무가 ANALYST가 아닌 
--     사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
--  담당업무가 ANALYST인 사원들의 급여
select sal
from emp
where job='ANALYST';

select empno, ename, job, sal
from emp
where sal <= all (select sal from emp where job='ANALYST')
and job != 'ANALYST';

-- 49. 부하직원이 없는 사원의 이름을 표시하시오.
select *
from emp;

-- 50. 부하직원이 있는 사원의 이름을 표시하시오.

-- 51. BLAKE와 동일한 부서에 속한 
--     사원의 이름과 입사일을 표시하는 질의를 작성하시오.
--     ( 단 BLAKE는 제외 )

-- 52. 급여가 평균 급여보다 많은 
--     사원들의 사원 번호와 이름을 표시하되 
--     결과를 급여에 대해서 오름차순으로 정렬하시오.

-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 
--     사원의 사원 번호와 이름을 표시하시오.

-- 54. 부서위치가 DALLAS인  => deptno
--     사원의 이름과 부서번호 및 담당업무를 표시하시오.

-- 55. KING에게 보고하는 -- MGR -> KING의 사원번호
--     사원의 이름과 급여를 표시하시오.

-- 56. RESEARCH 부서의 사원에 대한 dept => deptno
--     부서번호, 사원이름 및 담당 업무를 표시하시오.

-- 57. 평균 월급보다 많은 급여를 받고 => 평균 급여
--     이름에 M이 포함된 사원과 같은 부서에서 근무하는  => 부서번호
--     사원의 사원 번호, 이름, 급여를 표시하시오.

-- 58. 평균급여가 가장 적은 업무를 찾으시오.

-- 59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 
--    사원을 표시하시오.