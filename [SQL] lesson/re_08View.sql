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
