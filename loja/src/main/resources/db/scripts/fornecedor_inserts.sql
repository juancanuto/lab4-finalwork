--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Telefone com os inserts

insert into `lab04db`.`fornecedor`(id,nome,cnpj,endereco_id)values(13,'Nestle',77888,2);
insert into `lab04db`.`fornecedor`(id,nome,cnpj,endereco_id)values(92,'Walitta',77888,3);