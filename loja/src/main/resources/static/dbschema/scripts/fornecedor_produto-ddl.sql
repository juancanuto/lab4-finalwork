--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela FORNECEDOR_PRODUTO
CREATE TABLE IF NOT EXISTS `lab04db`.`fornecedor_produto` (
  `id_fornecedor` INT NOT NULL,
  `id_produto` INT NOT NULL,
  PRIMARY KEY (`id_fornecedor`, `id_produto`),
  INDEX `fk_fornecedores_has_produto_produto1_idx` (`id_produto` ASC) VISIBLE,
  INDEX `fk_fornecedores_has_produto_fornecedores1_idx` (`id_fornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedores_has_produto_fornecedores1`
    FOREIGN KEY (`id_fornecedor`)
    REFERENCES `lab04db`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fornecedores_has_produto_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `lab04db`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
ENGINE = InnoDB;
--rollback DELETE FROM FORNECEDOR_PRODUTO;