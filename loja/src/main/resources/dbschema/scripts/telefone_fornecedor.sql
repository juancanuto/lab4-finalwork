--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela TELEFONE_FORNECEDOR
CREATE TABLE IF NOT EXISTS `lab04db`.`telefone_fornecedor` (
  `telefone_id` INT NOT NULL,
  `fornecedor_id` INT NOT NULL,
  PRIMARY KEY (`telefone_id`, `fornecedor_id`),
  INDEX `fk_telefone_has_fornecedor_fornecedor1_idx` (`fornecedor_id` ASC) VISIBLE,
  INDEX `fk_telefone_has_fornecedor_telefone1_idx` (`telefone_id` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_has_fornecedor_telefone1`
    FOREIGN KEY (`telefone_id`)
    REFERENCES `lab04db`.`telefone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefone_has_fornecedor_fornecedor1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `lab04db`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
--rollback DELETE FROM TELEFONE_FORNECEDOR;