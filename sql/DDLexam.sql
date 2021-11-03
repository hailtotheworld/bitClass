
-- 1. phoneInfo_basic
create table phoneInfo_basic(
    idx number(6) constraint basic_idx_NN NOT NULL,
    fr_name varchar2(20) constraint basic_frname_NN NOT NULL,
    fr_phonenumber varchar2(20)constraint basic_frphonenunmer_NN NOT NULL,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate,
    constraint obasic_idx_PK PRIMARY KEY(idx)
);
--검토------------
desc phoneInfo_basic;
SELECT * FROM phoneInfo_basic;
--검토------------

--2. phoneInfo_univ
create table phoneInfo_univ(
    idx number(6)constraint univ_idx_NN NOT NULL,
    fr_u_major varchar(20) default 'N' constraint univ_frumajor_NN NOT NULL ,
    fr_u_year number(1)default '1' constraint univ_fruyear_NN NOT NULL,
    fr_ref number(7) constraint univ_frref_NN NOT NULL references phoneInfo_basic(idx),
    constraint univ_idx_PK PRIMARY KEY(idx),
    constraint univ_fruyear_CK check(fr_u_year between 1 and 4)
);
--검토------------
desc phoneinfo_univ;
SELECT * FROM phoneInfo_univ;
--검토------------

--3. phoneInfo_com
create table phoneInfo_com(
    idx number(6) constraint com_idx_NN NOT NULL,
    fr_c_company varchar(20) default 'N' constraint com_frccompany_NN NOT NULL,
    fr_ref number(6) constraint com_frref_NN NOT NULL references phoneInfo_basic(idx),
    constraint com_idx_PK PRIMARY KEY(idx)
);
--검토------------
desc phoneInfo_com;
SELECT * FROM phoneInfo_com;
--검토------------





