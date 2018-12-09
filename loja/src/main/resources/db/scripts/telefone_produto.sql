--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela FORNECEDOR_PRODUTO
CREATE TABLE IF NOT EXISTS `lab04db`.`fornecedor_produto` (
  `id_fornecedor` INT(11) NOT NULL COMMENT 'Identificador da tabela forncedor.',
  `id_produto` INT(11) NOT NULL COMMENT 'Identificador da tabela produto.',
  `data_entrada` DATE NOT NULL,
  `valor_custo` DOUBLE NULL,
  PRIMARY KEY (`id_fornecedor`, `id_produto`),
  INDEX `fk_fornecedores_has_produto_produto1_idx` (`id_produto` ASC) VISIBLE,
  INDEX `fk_fornecedores_has_produto_fornecedores1_idx` (`id_fornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedores_has_produto_fornecedores1`
    FOREIGN KEY (`id_fornecedor`)
    REFERENCES `lab04db`.`fornecedor` (`id`),
  CONSTRAINT `fk_fornecedores_has_produto_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `lab04db`.`produto` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'Tabela que representa a entrada dos produtos na loja'
--rollback DELETE FROM FORNECEDOR_PRODUTO;