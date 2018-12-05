--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela VENDA
CREATE TABLE IF NOT EXISTS `lab04db`.`item_venda` (
  `data_venda` DATE NULL,
  `quantidade` INT NULL,
  `venda_id` INT(20) NOT NULL,
  `produto_id` INT(11) NOT NULL,
  INDEX `fk_item_venda_venda1_idx` (`venda_id` ASC) VISIBLE,
  INDEX `fk_item_venda_produto1_idx` (`produto_id` ASC) VISIBLE,
  PRIMARY KEY (`venda_id`, `produto_id`),
  CONSTRAINT `fk_item_venda_venda1`
    FOREIGN KEY (`venda_id`)
    REFERENCES `lab04db`.`venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_venda_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `lab04db`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
