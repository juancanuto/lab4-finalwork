--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela ENDERECO
CREATE TABLE IF NOT EXISTS `lab04db`.`endereco` (
  `id` INT NOT NULL,
  `rua` VARCHAR(45) NULL,
  `numero` INT(10) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` INT(10) NULL,
  `cep` INT(8) NOT NULL,
  PRIMARY KEY (`id`));
ENGINE = InnoDB;
--rollback DELETE FROM ENDERECO;