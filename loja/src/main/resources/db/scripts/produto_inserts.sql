--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Produto com os inserts

insert into `lab04db`.`produto`(id,id_categoria,nome,marca,modelo,cor,tamanho,valor,observacao,data_fabricacao)values (18,25,'Charge','Nestle Chocolates','Caixa de Bombom','Azul','Medio',8.5,"Observação de Produto","2018-12-22");
insert into `lab04db`.`produto`(id,id_categoria,nome,marca,modelo,cor,tamanho,valor,observacao,data_fabricacao)values (37,28,'Batedeira','Walita Cozinha','Master Chefe','Preto','N/D',64,"teste da versão","2018-11-12");