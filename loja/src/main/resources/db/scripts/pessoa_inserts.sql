--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Pessoa com os inserts

INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(4,'Jose de Arimateia',355120,12445,'1979-12-20','M',1);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(5,'Tony Stark',32111,12489,'1983-05-09','M',2);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(6,'Gohan do Nascimento',55677,5543,'1995-11-29','M',3);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(7,'Elder Scrolson',5688,22111,'1949-01-10','M',1);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(8,'Maria de Be',986645,55783,'1999-06-23','F',2);