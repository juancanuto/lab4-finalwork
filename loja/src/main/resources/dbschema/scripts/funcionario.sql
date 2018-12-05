--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela FUNCIONARIO
CREATE TABLE IF NOT EXISTS `lab04db`.`funcionario` (
  `usuario_id` INT(11) NOT NULL COMMENT 'Identificador da tabela usuario.',
  `pessoa_id` INT(11) NOT NULL COMMENT 'Identificador da tabela pessoa.',
  INDEX `fk_funcionario_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_funcionario_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  PRIMARY KEY (`pessoa_id`),
  CONSTRAINT `fk_funcionario_pessoa`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `lab04db`.`pessoa` (`id`),
  CONSTRAINT `fk_funcionario_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `lab04db`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM FUNCIONARIO;