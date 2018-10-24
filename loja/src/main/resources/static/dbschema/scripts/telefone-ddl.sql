--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela TELEFONE
CREATE TABLE IF NOT EXISTS `lab04db`.`telefone` (
  `id` INT NOT NULL,
  `numero` INT NULL,
  `ddd` INT NULL,
  `tipo` INT(2) NULL,
  PRIMARY KEY (`id`));
ENGINE = InnoDB;
--rollback DELETE FROM TELEFONE;