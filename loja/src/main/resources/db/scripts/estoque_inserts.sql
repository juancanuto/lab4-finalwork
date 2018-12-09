--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Categoria com os inserts

insert into `lab04db`.`estoque`(id,id_produto,qtd_produto,qtd_minima)values(61,18,80,30);
insert into `lab04db`.`estoque`(id,id_produto,qtd_produto,qtd_minima)values(63,37,30,15);
