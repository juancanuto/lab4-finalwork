--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela VENDA
CREATE TABLE IF NOT EXISTS `lab04db`.`venda` (
  `id` INT(20) NOT NULL,
  `id_cliente` INT(20) NOT NULL,
  `id_produto` INT(20) NOT NULL,
  `id_funcionario` INT NOT NULL,
  `forma_pgto` INT(20) NOT NULL COMMENT 'Tabela utilizada para registro dos dados de venda de produtos à clientes.',
  `valor_pago` DOUBLE NOT NULL,
  `num_parcelas` INT(10) NOT NULL,
  PRIMARY KEY (`id`, `id_cliente`, `id_funcionario`),
  INDEX `fk_venda_produto1_idx` (`id_produto` ASC) VISIBLE,
  INDEX `fk_venda_cliente_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_venda_funcionario1_idx` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_venda_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `lab04db`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `lab04db`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `lab04db`.`funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
--rollback DELETE FROM VENDA;