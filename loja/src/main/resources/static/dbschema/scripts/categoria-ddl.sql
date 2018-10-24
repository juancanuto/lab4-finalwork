--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela CATEGORIA
CREATE TABLE IF NOT EXISTS `lab04db`.`categoria` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
ENGINE = InnoDB;
--rollback DELETE FROM CATEGORIA;