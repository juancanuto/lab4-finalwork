--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Venda com os inserts

insert into `lab04db`.`venda`(id,id_cliente,id_funcionario,forma_pgto,valor_pago,num_parcelas)values(130,8,4,4,254.98,3);
insert into `lab04db`.`venda`(id,id_cliente,id_funcionario,forma_pgto,valor_pago,num_parcelas)values(131,4,5,1,178.64,0);
