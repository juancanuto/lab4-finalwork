--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Usuario com os inserts

insert into `lab04db`.`usuario`(id,nome,senha) values (698,'Gohan do Nascimento','kamehameha');
insert into `lab04db`.`usuario`(id,nome,senha) values (888,'Maria de Be','nosql');
insert into `lab04db`.`usuario`(id,nome,senha) values (365,'Tony Stark','thanos');