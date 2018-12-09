--liquibase formatted sql

--changeset adriano:201812101816
--comment: População da tabela Funcionario com os inserts

insert into `lab04db`.`funcionario`(usuario_id,pessoa_id) values (698,8);
insert into `lab04db`.`funcionario`(usuario_id,pessoa_id) values (888,4);
insert into `lab04db`.`funcionario`(usuario_id,pessoa_id) values (365,5);