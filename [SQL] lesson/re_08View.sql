select pb.fr_name, pb.fr_phonenumber, pu.fr_u_major, pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
where pb.idx=pc.fr_ref(+) and pb.idx=pu.fr_ref(+);

-- 뷰 만들기
create or replace view phoneinfo_view
as
select pb.fr_name, pb.fr_phonenumber, pu.fr_u_major, pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
where pb.idx=pc.fr_ref(+) and pb.idx=pu.fr_ref(+);

select * from phoneinfo_view where fr_name='대학친구';


-- VIEW
-- 가상 테이블: 물리적인 테이블의 select의 결과를 테이블로 사용
-- 1. 복잡한 sql(select)문을 간단히 사용하기 위해
-- 2. 보안이 필요한 컬럼의 데이터를 보호하기 위해 (eg. 급여를 모든 직원이 확인하는건 안되잖아)
-- 3. rownum 이용해서 특정 범위의 데이터 추출할 수 있다.(eg. top5)

-- create or replace view {뷰 이름}
-- as {sub query}

-- 자주 사용되는 30번 부서에 소속된 사원들의
-- 사번과 이름과 부서번호를 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다.

select empno, ename, deptno
from emp
where deptno=30;

-- View 생성
create or replace view EMP_VIEW30
as
select empno, ename, deptno
from emp
where deptno=30;

-- 가상테이블 View를 이용해서 질의
select *
from emp_view30;

-- user_views
select * from user_views;

select *
from user_views
where view_name='EMP_VIEW30';

-- view 삭제
drop view emp_view30;


select * from emp order by hiredate;

select rownum, ename, hiredate from emp order by hiredate;

select rownum, ename, hiredate
from (select * from emp order by hiredate) -- 인라인뷰
where rownum <= 5;

-- 급여액 top3
select rownum, ename, sal
from (select * from emp order by sal desc)
where rownum <= 3;

-- 게시물의 리스트
-- 회원 리스트
-- 1 page => 1~20
-- 2 page => 21~40 이렇게 잘라내는 과정에서 rownum, 인라인뷰 이용한다.

-- 입사일 기준으로 정렬한 가상 테이블
create or replace view emp_hir
as
select *
from emp
order by hiredate;

select rownum, ename, hiredate
from emp_hir
where rownum <= 5;







