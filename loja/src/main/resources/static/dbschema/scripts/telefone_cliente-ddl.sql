--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela TELEFONE_CLIENTE
CREATE TABLE IF NOT EXISTS `lab04db`.`telefone_cliente` (
  `telefone_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`telefone_id`, `cliente_id`),
  INDEX `fk_telefone_has_cliente_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_telefone_has_cliente_telefone1_idx` (`telefone_id` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_has_cliente_telefone1`
    FOREIGN KEY (`telefone_id`)
    REFERENCES `lab04db`.`telefone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefone_has_cliente_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `lab04db`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
ENGINE = InnoDB;
--rollback DELETE FROM TELEFONE_CLIENTE;