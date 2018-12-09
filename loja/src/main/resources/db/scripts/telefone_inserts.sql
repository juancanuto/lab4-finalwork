--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Telefone com os inserts

insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (90,9885566,12,2);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (80,433366,11,2);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (40,51166,21,2);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (30,684446,34,1);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (20,7222566,66,1);