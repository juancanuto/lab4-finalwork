--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Telefone_Cliente com os inserts

insert into `lab04db`.`telefone_cliente`(telefone_id,pessoa_id)values(20,4);
insert into `lab04db`.`telefone_cliente`(telefone_id,pessoa_id)values(30,5);
