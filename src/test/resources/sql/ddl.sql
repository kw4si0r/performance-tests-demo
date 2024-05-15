--drop table if exists city cascade ;
--drop table if exists country cascade ;
--drop table if exists user cascade ;
--drop table if exists user_details cascade ;
--
--create table city (c_status integer, c_id bigint not null, c_other bigint, c_name varchar(255), primary key (c_id));
--
--create table country (s_status integer not null, s_id bigint not null, s_created varchar(255) not null, s_name varchar(255));
--
--ALTER TABLE country ADD CONSTRAINT country_pk PRIMARY KEY (s_id, s_status,s_created);
--
--
--create table user (u_type integer, u_email varchar(255) not null, primary key (u_email));
--
--create table user_details (d_email varchar(255) not null, d_name varchar(255), d_surname varchar(255), primary key (d_email));
--

--alter table city add constraint city_country_fk foreign key (c_status, c_other) references country(s_status, s_id);

drop table if exists city cascade ;
drop table if exists country cascade ;
drop table if exists user cascade ;
drop table if exists user_details cascade ;

create table city (c_status integer, c_id bigint not null, c_other bigint, c_name varchar(255), primary key (c_id));
create table country (s_status integer not null, s_id bigint not null, s_created varchar(255) not null, s_name varchar(255), primary key (s_status, s_id, s_created)
--, unique (s_status, s_id)
)
create table user (u_type integer, u_email varchar(255) not null, primary key (u_email));
create table user_details (d_email varchar(255) not null, d_name varchar(255), d_surname varchar(255), primary key (d_email));