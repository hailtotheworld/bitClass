drop table coal;

create table coal (c1 number,c2 number,c3 number);

select * from coal;

insert into coal values(1,500,3);
insert into coal values(null,null,null);
insert into coal values(null,null,3);

select sum(coalesce(c1,c2,c3))
from coal;
