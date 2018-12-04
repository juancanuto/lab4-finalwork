--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela PESSOA
CREATE TABLE IF NOT EXISTS `lab04db`.`pessoa` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL COMMENT 'Nome completo atribuído à pessoa.',
  `cpf` INT(12) NOT NULL COMMENT 'Número de Cadastro de Pessoa Física (CPF) atribuído à pessoa.',
  `rg` INT(9) NOT NULL COMMENT 'Número de Registro Geral (RG) atribuído à pessoa.',
  `data_nascimento` DATETIME NULL DEFAULT NULL COMMENT 'Data de Nascimento da pessoa.',
  `sexo` VARCHAR(2) NULL DEFAULT NULL COMMENT 'Sexo atribuído à pessoa, será definido um código de atribuição que poderá ser (Masculino,Feminino,Não Informado).',
  `endereco_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pessoa_endereco1_idx` (`endereco_id` ASC) VISIBLE,
  CONSTRAINT `fk_pessoa_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `lab04db`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci