--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela PESSOA
CREATE TABLE IF NOT EXISTS `lab04db`.`pessoa` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL COMMENT 'Nome completo atribuído à pessoa.',
  `cpf` INT(12) NOT NULL COMMENT 'Número de Cadastro de Pessoa Física (CPF) atribuído à pessoa.',
  `rg` INT(9) NOT NULL COMMENT 'Número de Registro Geral (RG) atribuído à pessoa.',
  `data_nascimento` DATETIME NULL COMMENT 'Data de Nascimento da pessoa.',
  `sexo` VARCHAR(2) NULL COMMENT 'Sexo atribuído à pessoa, será definido um código de atribuição que poderá ser (Masculino,Feminino,Não Informado).',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

--rollback DROP TABLE pessoa;