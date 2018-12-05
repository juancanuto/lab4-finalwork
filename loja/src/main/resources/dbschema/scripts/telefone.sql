--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela TELEFONE
CREATE TABLE IF NOT EXISTS `lab04db`.`telefone` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela telefone.',
  `numero` INT(11) NULL DEFAULT NULL COMMENT 'Número do telefone',
  `ddd` INT(11) NULL DEFAULT NULL COMMENT 'Código DDD do Telefone.',
  `tipo` INT(2) NULL DEFAULT NULL COMMENT 'Codigo referente ao tipo de telefone.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM TELEFONE;