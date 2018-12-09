--liquibase formatted sql

--changeset adriano:201812101815
--comment: População da tabela Endereco com os inserts

INSERT INTO `lab04db`.`endereco`(id,rua,numero,bairro,cidade,estado,cep) values (1,'Noruega',120,'Jardim Socorro','Cosmopolis',25,12455);
INSERT INTO `lab04db`.`endereco`(id,rua,numero,bairro,cidade,estado,cep)values(2,'Genival ',120,'Sao Francisco','Niteroi',63,16599);
INSERT INTO `lab04db`.`endereco`(id,rua,numero,bairro,cidade,estado,cep)values(3,'Brenzopoli',120,'Vila Equatoriana','Ponta Negra',26,12000);