--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela FUNCIONARIO
CREATE TABLE IF NOT EXISTS `lab04db`.`funcionario` (
  `idfuncionario` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `pessoa_id` INT NOT NULL,
  PRIMARY KEY (`idfuncionario`),
  INDEX `fk_funcionario_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_funcionario_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `lab04db`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `lab04db`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
ENGINE = InnoDB;
--rollback DELETE FROM FUNCIONARIO;