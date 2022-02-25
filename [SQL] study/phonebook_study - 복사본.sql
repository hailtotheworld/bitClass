drop table phoneinfo_com;
drop table phoneinfo_univ;
drop table phoneInfo_basic;

CREATE table phoneInfo_basic (
    idx number(6) constraint pi_basic_idx_PK primary key,
    fr_name VARCHAR2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20) ,
    fr_address varchar2(20),
    fr_regdate date default sysdate
);

-- phoneInfo_basic 테이블 PK -> idx에 입력할 일련번호
-- 시퀀스 생성
create sequence pib_idx_seq
    start with 1
    increment by 1
    minvalue 1
    maxvalue 999999
;

---- (1) insert: create
desc phoneInfo_basic;

insert into phoneInfo_basic
    values(pib_idx_seq.nextval,'그냥친구','010-0000-0001','11@gmail.com','런던',sysdate);
insert into phoneInfo_basic
    values(pib_idx_seq.nextval,'그냥친구22','010-0000-0002','22@gmail.com','뉴욕',sysdate);

---- (2) select
select * from phoneInfo_basic;

-- 이름으로 검색
select * from phoneInfo_basic where fr_name like '%손%';
-- 전화번호 검색
select * from phoneInfo_basic where fr_phonenumber like '%0002%';
-- 시스템 내부에서 관리자가 검색
-- 예) 리스트 -> 상세보기
select * from phoneInfo_basic where idx=1;

---- (3) update
-- 시스템 내부에서 변경 페이지를 이용한 데이터 수정
update phoneinfo_basic
SET fr_name='SON',fr_phonenumber='010-0000-0011',fr_email='son11@gmail.com',fr_address='서울'
where idx=1;

---- (4) delete
DELETE FROM phoneinfo_basic
WHERE idx=1;

-----------------------------------------------------------------------------------------------

create table phoneinfo_univ (
    idx number(6),
    fr_u_major VARCHAR2(20) default 'N' not null,
    fr_u_year number(1) default 1  not null, --check (fr_u_year between 1 and 4),
    fr_ref number(6) not null,
    constraint pi_univ_idx_PK primary key (idx),
    constraint chk check (fr_u_year between 1 and 4), -- 테이블 레벨에서 check  제약 설정 
    constraint pi_univ_ref_FK FOREIGN KEY (fr_ref) REFERENCES phoneInfo_basic (idx)
);

-- sequence
create sequence piu_idx_seq
    start with 1
    INCREMENT by 1
    maxvalue 999999
;

---- (1) insert
-- 친구 정보를 입력: 기본 정보 + 학교 정보. 2개로 나누었음
-- 1. 기본 정보 입력
insert into phoneInfo_basic
    values(PIB_IDX_SEQ.nextval,'대학친구','010-3333-1111','33@gmail.com','런던',sysdate);
-- 2. 학교 정보 입력
insert into phoneinfo_univ
    values(piu_idx_seq.nextval,'축구','1',PIB_IDX_SEQ.currval);

---- (2) select
select * from phoneinfo_univ u; -- 이 테이블 데이터만으로는 의미가 없다.

select * from phoneinfo_basic b, phoneinfo_univ u
where b.idx = u.fr_ref;

-- 기본 정보만 입력된 데이터도 출력: outer join
select b.fr_name, b.fr_phonenumber,
       nvl(u.fr_u_major,'입력정보없음') as "major",
       nvl(u.fr_u_year,0) as "year",
       to_char(b.fr_regdate,'YYYY.MM.DD HH24:mi') as "regdate"
from phoneinfo_basic b, phoneinfo_univ u
where b.idx = u.fr_ref(+);

select *
from phoneinfo_basic b, phoneinfo_univ u
where b.idx = u.fr_ref(+);

---- (3) update
update phoneinfo_univ
set fr_u_major='야구',fr_u_year=4 --idx, fr_ref는 변경되면 안된다!
where idx=1; 

---- (4) delete
-- 자식 테이블의 데이터를 먼저 삭제
delete from phoneinfo_univ where idx=1;
-- delete from phoneinfo_univ where fr_ref=7; 중복될수 있으니까 지우지 않는다!!
-- 다음에 부모 테이블의 데이터를 삭제
delete from phoneinfo_basic where idx=3;
-----------------------------------------------------------------------------------------------

create table phoneinfo_com (
    idx number(6) constraint pi_com_idx_PK primary key,
    fr_c_company VARCHAR2(20) default 'N' not null,
    fr_ref number(6) not null constraint pi_com_ref_FK REFERENCES phoneinfo_basic (idx)
);

-- sequence
create sequence pic_idx_seq
    maxvalue 999999;

---- (1) insert
select * from  phoneinfo_basic;
insert into phoneinfo_basic
        values(PIB_IDX_SEQ.nextval, '회사친구', '010-2222-1111', 'h@gmail.com', '서울', sysdate);
insert into phoneinfo_com
        values(PIC_IDX_SEQ.nextval,'네이버', PIB_IDX_SEQ.currval);
        
-- 회사 친구 입력: 기본 정보 입력 -> 회사 정보 입력

---- (2) select
select *
from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref(+);

---- (3) update
update phoneinfo_com
set fr_c_company = '쿠팡'
where idx=1;

---- (4) update
-- 자식 테이블 행 먼저 삭제
DELETE FROM phoneinfo_com WHERE idx=1;
-- 부모 테이블 행 삭제
DELETE FROM phoneinfo_basic WHERE idx=4;


--- 전체 데이터 리스트 출력: 테이블 3개 JOIN
select *
from phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
where pb.idx=pc.fr_ref(+) and pb.idx=pu.fr_ref(+);

-- 뷰 만들기
create or replace view phoneinfo_view
as
select pb.fr_name, pb.fr_phonenumber, pu.fr_u_major, pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
where pb.idx=pc.fr_ref(+) and pb.idx=pu.fr_ref(+);

select * from phoneinfo_view where fr_name='대학친구';






