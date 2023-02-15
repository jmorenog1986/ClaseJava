create database clasejava;
use clasejava;
create table Personas(
documento int,
nombre varchar(45) not null,
apellido varchar(45) not null,
email varchar(45) null,
primary key(documento)
);
alter table personas
modify email varchar(150) null;
