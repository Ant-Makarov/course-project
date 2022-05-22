create schema public
create table users 
(
	fullName varchar(100) not null,
	email varchar(100) not null,
	phoneNumber varchar(20) not null,
	constraint users_pk primary key(phoneNumber)
)

create table post_offices 
(
	post_office_id bigint primary key,
	description varchar(1000)
)
create sequence JPA_SEQUENCE start with 20000001 increment by 1 
alter sequence JPA_SEQUENCE restart with 20000001
create table parcel_sendings
(
	sendID bigint primary key,
	senderID varchar(20) references users,
	sender_PO_ID bigint not null,
	receiver_PO_ID bigint not null,
	receiver_FIO varchar(100) not null,
	receiverPhone varchar(20) not null,
	status varchar(20),
	creation_dateTime timestamp,
	statusChange_dateTime timestamp 
)
create sequence JPA_SEQUENCE1 start with 30000001 increment by 1 
alter sequence JPA_SEQUENCE1 restart with 30000001

create table notifications 
(
	sendID bigint references parcel_sendings,
	message varchar(100),
	status varchar(10)
)
select * from parcel_sendings
select * from users 
select * from post_offices 
select * from notifications 
delete from users where id = 10000001
delete from post_offices where post_office_id = 20000001
delete from post_offices where post_office_id = 20000002
delete from parcel_sendings where sendid = 30000001
delete from parcel_sendings where sendid = 30000002
delete from parcel_sendings where sendid = 30000003
drop table users
drop table parcel_sendings 
drop table notifications
drop table post_offices 
truncate users cascade
truncate post_offices