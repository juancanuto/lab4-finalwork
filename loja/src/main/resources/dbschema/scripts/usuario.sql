--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela USUARIO
CREATE TABLE IF NOT EXISTS `lab04db`.`usuario` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `senha` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
--rollback DELETE FROM USUARIO;