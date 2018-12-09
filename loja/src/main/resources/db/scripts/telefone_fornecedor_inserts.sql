--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Telefone_Fornecedor com os inserts

insert into `lab04db`.`telefone_fornecedor`(telefone_id,fornecedor_id)values(90,13);
insert into `lab04db`.`telefone_fornecedor`(telefone_id,fornecedor_id)values(80,92);