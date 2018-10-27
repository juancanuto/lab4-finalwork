--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela CLIENTE
CREATE TABLE IF NOT EXISTS `lab04db`.`cliente` (
  `id` INT NOT NULL,
  `endereco_id` INT NOT NULL,
  `id_pessoa` INT NOT NULL,
  PRIMARY KEY (`id`, `id_pessoa`),
  INDEX `fk_cliente_endereco1_idx` (`endereco_id` ASC) VISIBLE,
  INDEX `fk_cliente_pessoa_idx` (`id_pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `lab04db`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_pessoa`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `lab04db`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
--rollback DELETE FROM CLIENTE;