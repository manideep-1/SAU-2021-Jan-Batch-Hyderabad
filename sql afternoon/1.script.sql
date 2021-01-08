create table product
(
	product_code integer primary key,
	product_name varchar(100),
	unit_price integer
)
create table sell
(
	product_code integer,
	sales_executive_id integer,
	customer_id integer
)
select * from sell
create table salesexecutive
(
	sales_executive_id integer primary key,
	name varchar(100),
	date_born date,
	mobile_number integer
)
create table grouped
(
	category_code integer,
	product_code integer
)
create table category
(
	category_code integer primary key,
	category_name varchar(100)
)
create table buy
(
	product_code integer,
	customer_id integer,
	date_of_purchase date,
	number_of_units integer
)
create table customer
(
	customer_id integer primary key,
	name varchar(100),
	date_born date,
	mobile_number integer,
	gender varchar(10)
)
create table has
(
	customer_id integer,
	location_code integer
)
create table location
(
	location_code integer primary key,
	location_name varchar(100)
)

insert into product values(1,'headphones',200);
insert into product values(2,'samsungphones',20000);
insert into product values(3,'apple iphone',200000);
insert into product values(4,'fossil watch',22000);
select * from product;

insert into salesexecutive values(1,'Manideep','2000-04-23',74162);
insert into salesexecutive values(2,'anudeep','2000-02-20',84988);
insert into salesexecutive values(3,'swetha','1999-12-13',70368);
insert into salesexecutive values(4,'abhigna','2000-07-22',83416);
select * from salesexecutive

insert into customer values(1,'divisha','2000-04-11',16255,'Female');
insert into customer values(2,'spoorthy','1999-12-15',55858,'Female');
insert into customer values(3,'saran','2000-03-11',12555,'Male');
insert into customer values(4,'Pavankalyan','2000-04-11',14465,'Male');
select * from customer;

insert into location values(1,'Hyderabad');
insert into location values(2,'nalgonda');
insert into location values(3,'miryalaguda');
insert into location values(4,'warangal');
select * from location;

insert into has values(1,1);
insert into has values(2,2);
insert into has values(3,3);
insert into has values(4,4);
select * from has

insert into sell values(1,1,1);
insert into sell values(2,2,2);
insert into sell values(3,3,3);
insert into sell values(4,4,4);
select * from sell

insert into grouped values(1,1);
insert into grouped values(1,2);
insert into grouped values(2,3);
insert into grouped values(3,4);
select * from grouped;

insert into buy values(1,1,'2021-01-06',3);
insert into buy values(2,2,'2021-01-05',2);
insert into buy values(3,3,'2021-01-04',1);
insert into buy values(4,4,'2021-01-03',5);
insert into buy values(2,1,'2021-01-02',3);
insert into buy values(1,2,'2021-01-01',2);
insert into buy values(4,1,'2020-12-31',5);
select * from buy;


2. Write a query to retrieve the most sold product per day in a specific location 
(take any location) in last week.
select product_name,location_name from product 
natural join buy natural join customer natural join has natural join location 
where location_name='Hyderabad' and 
date_of_purchase between '2020-12-27' and'2021-01-03' order by number_of_units desc limit 1;
3. Write a query to list all the sales persons details along with the 
count of products sold by them (if any) till current date.
select sales_executive_id,name,date_born,mobile_number,sum(number_of_units)
from salesexecutive natural join sell natural join buy group by sales_executive_id ;
