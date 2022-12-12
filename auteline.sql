create database if not exists Auteline;
use Auteline;

create table if not exists Account (
	account_number int,
    password int,
    balance float
);

insert into Account(account_number, password, balance)
values ((11111, 11111, 1000.00),
        (22222, 11111, 1000.00)
        (33333, 11111, 1000.00)
        (44444, 11111, 1000.00)
        (55555, 11111, 1000.00)
        (66666, 11111, 1000.00)
        (77777, 11111, 1000.00)
        (88888, 11111, 1000.00)
        (99999, 11111, 1000.00)
        (12345, 11111, 1000.00)
        );
