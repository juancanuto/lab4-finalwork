--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Fornecedor_Produto com os inserts

insert into `lab04db`.`fornecedor_produto`(id_fornecedor,id_produto,data_entrada,valor_custo)values (13,18,"2018-06-24",15.22);
insert into `lab04db`.`fornecedor_produto`(id_fornecedor,id_produto,data_entrada,valor_custo)values (92,37,"2018-06-02",245.45);