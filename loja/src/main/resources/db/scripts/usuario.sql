--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela USUARIO
CREATE TABLE IF NOT EXISTS `lab04db`.`usuario` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela Usuario',
  `nome` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Nome do login de usuário.',
  `senha` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Senha de usuário.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM USUARIO;