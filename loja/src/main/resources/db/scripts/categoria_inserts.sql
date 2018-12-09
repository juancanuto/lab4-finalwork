--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Categoria com os inserts

insert into `lab04db`.`categoria`(id,nome)values(25,'alimento');
insert into `lab04db`.`categoria`(id,nome)values (28,'eletrodomestico');