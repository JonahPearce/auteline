create database if not exists Auteline;
use Auteline;

create table Account (
	account_number int,
    password int,
    balance float
);

insert into Account(account_number, password, balance)
values (11111, 11111, 100.00);