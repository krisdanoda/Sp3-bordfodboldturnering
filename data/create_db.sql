create database sp3;

create table Team(
team_id tinyint primary key,
team_name varchar(255),
score smallint);

use sp3;

create table TMatch(
match_id tinyint primary key,
teamid1 tinyint,
teamid2 tinyint,
score1 smallint,
score2 smallint,
match_date varchar(255));

show tables;
select * from Team;

insert into Team value(1, "Astralis", 10);
insert into Team value(2, "Batemax", 5);
insert into Team value(3, "Camponoglo", 7);
insert into Team value(4, "Djernis", 25);
insert into Team value(5, "Estragon", 30);
insert into Team value(6, "x", 25);
insert into Team value(7, "y", 30);

show databases;

insert into TMatch value(1, 1, 2, 3, 2, "02-01-22");
insert into TMatch value(2, 3, 4, 0, 1, "15-01-22");
insert into TMatch value(3, 5, 6, 2, 3, "16-01-22");
insert into TMatch value(4, 7, 8, 5, 1, "18-01-22");
insert into TMatch value(5, 9, 10, 4, 0, "20-01-22");

select * from TMatch;
select * from Team;

-- sletter udvalgte rækker fra 'Team'-tabellen
DELETE FROM Team WHERE team_id > 5;
delete from TMatch where match_id = 6;
