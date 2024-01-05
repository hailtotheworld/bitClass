drop table if exists item CASCADE;
create table item
(
id bigint not null AUTO_INCREMENT,
item_name varchar(10),
price integer,
quantity integer,
primary key (id)
);

SELECT * FROM item;

insert into item(item_name, price, quantity) values ('ItemTest', 10000, 10);

delete from item;

ALTER TABLE item AUTO_INCREMENT = 1;
