drop database if exists orders;
create database orders;
use orders;
create table orders(
order_id int auto_increment,
order_date date,
customer_name varchar(128),
ship_address varchar(128),
notes text,
tax decimal(2,2) default '0.05',
constraint pk_order_id primary key (order_id)
);

create table order_details(
id int auto_increment,
product varchar(64),
unit_price decimal (3,2),
discount decimal (3,2) default '1.0',
quantity int,
order_id int,
constraint pk_id primary key (id),
constraint fk_order_id foreign key (order_id) references orders(order_id)
);

grant all privileges on orders to 'cw'@'%';
flush privileges;