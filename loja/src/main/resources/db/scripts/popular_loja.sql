--liquibase formatted sql

--changeset adriano:201812101815
--comment: População das tabelas com os inserts

INSERT INTO `lab04db`.`endereco`(id,rua,numero,bairro,cidade,estado,cep) values (1,'Noruega',120,'Jardim Socorro','Cosmopolis',25,12455);
INSERT INTO `lab04db`.`endereco`(id,rua,numero,bairro,cidade,estado,cep)values(2,'Genival ',120,'Sao Francisco','Niteroi',63,16599);
INSERT INTO `lab04db`.`endereco`(id,rua,numero,bairro,cidade,estado,cep)values(3,'Brenzopoli',120,'Vila Equatoriana','Ponta Negra',26,12000);

INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(4,'Jose de Arimateia',355120,12445,'1979-12-20','M',1);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(5,'Tony Stark',32111,12489,'1983-05-09','M',2);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(6,'Gohan do Nascimento',55677,5543,'1995-11-29','M',3);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(7,'Elder Scrolson',5688,22111,'1949-01-10','M',1);
INSERT INTO `lab04db`.`pessoa`(id,nome,cpf,rg,data_nascimento,sexo,endereco_id)VALUES(8,'Maria de Be',986645,55783,'1999-06-23','F',2);

insert into `lab04db`.`cliente`(pessoa_id)values(8);
insert into `lab04db`.`cliente`(pessoa_id)values(4);
insert into `lab04db`.`cliente`(pessoa_id)values(5);

insert into `lab04db`.`usuario`(id,nome,senha) values (698,'Gohan do Nascimento','kamehameha');
insert into `lab04db`.`usuario`(id,nome,senha) values (888,'Maria de Be','nosql');
insert into `lab04db`.`usuario`(id,nome,senha) values (365,'Tony Stark','thanos');

insert into `lab04db`.`funcionario`(usuario_id,pessoa_id) values (698,5);
insert into `lab04db`.`funcionario`(usuario_id,pessoa_id) values (888,6);
insert into `lab04db`.`funcionario`(usuario_id,pessoa_id) values (365,7);

insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (90,9885566,12,2);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (80,433366,11,2);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (40,51166,21,2);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (30,684446,34,1);
insert into `lab04db`.`telefone`(id,numero,ddd,tipo)values (20,7222566,66,1);

insert into `lab04db`.`fornecedor`(id,nome,cnpj,endereco_id)values(13,'Nestle',77888,2);
insert into `lab04db`.`fornecedor`(id,nome,cnpj,endereco_id)values(92,'Walitta',77888,3);

insert into `lab04db`.`telefone_cliente`(telefone_id,pessoa_id)values(40,4);
insert into `lab04db`.`telefone_cliente`(telefone_id,pessoa_id)values(20,7);
insert into `lab04db`.`telefone_cliente`(telefone_id,pessoa_id)values(30,8);

insert into `lab04db`.`telefone_fornecedor`(telefone_id,fornecedor_id)values(90,13);
insert into `lab04db`.`telefone_fornecedor`(telefone_id,fornecedor_id)values(80,92);

insert into `lab04db`.`categoria`(id,nome)values(25,'alimento');
insert into `lab04db`.`categoria`(id,nome)values (28,'eletrodomestico');

insert into `lab04db`.`produto`(id,id_categoria,nome,marca,modelo,cor,tamanho,valor,observacao,data_fabricacao)values (18,25,'Charge','Nestle Chocolates','Caixa de Bombom','Azul','Medio',8.5,null,2018-12-22);
insert into `lab04db`.`produto`(id,id_categoria,nome,marca,modelo,cor,tamanho,valor,observacao,data_fabricacao)values (37,28,'Batedeira','Walita Cozinha','Master Chefe','Preto','N/D',64,teste da versão,2018-11-12);

insert into `lab04db`.`fornecedor_produto`(id_fornecedor,id_produto,data_entrada,valor_custo)values (13,18,2018-06-24,15.22);
insert into `lab04db`.`fornecedor_produto`(id_fornecedor,id_produto,data_entrada,valor_custo)values (92,37,2018-06-02,245.45);

insert into `lab04db`.`estoque`(id,id_produto,qtd_produto,qtd_minima)values(61,18,80,30);
insert into `lab04db`.`estoque`(id,id_produto,qtd_produto,qtd_minima)values(63,37,30,15);

insert into `lab04db`.`venda`(id,id_cliente,id_funcionario,forma_pgto,valor_pago,num_parcelas)values(1365,8,698,4,254.98,3);
insert into `lab04db`.`venda`(id,id_cliente,id_funcionario,forma_pgto,valor_pago,num_parcelas)values(1366,5,888,1,178.64,0);
