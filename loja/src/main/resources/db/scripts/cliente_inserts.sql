--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Cliente com os inserts

insert into `lab04db`.`cliente`(pessoa_id)values(8);
insert into `lab04db`.`cliente`(pessoa_id)values(4);
insert into `lab04db`.`cliente`(pessoa_id)values(5);