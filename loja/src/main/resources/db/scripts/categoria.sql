--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela CATEGORIA
CREATE TABLE IF NOT EXISTS `lab04db`.`categoria` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela categoria.',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Descrição da categoria.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM CATEGORIA;