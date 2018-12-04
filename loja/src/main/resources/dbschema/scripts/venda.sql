--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela VENDA
CREATE TABLE IF NOT EXISTS `lab04db`.`venda` (
  `id` INT(20) NOT NULL COMMENT 'Identificador da tabela venda.',
  `id_cliente` INT(20) NOT NULL COMMENT 'Identificador da tabela cliente.',
  `id_funcionario` INT(11) NOT NULL COMMENT 'Identificador da tabela funcionario.',
  `forma_pgto` INT(20) NOT NULL COMMENT 'Codigo referente à forma de pagamento.',
  `valor_pago` DOUBLE NOT NULL COMMENT 'Valor pago pela venda do produto.',
  `num_parcelas` INT(10) NOT NULL COMMENT 'Número de parcelas da venda do produto.',
  PRIMARY KEY (`id`),
  INDEX `fk_venda_cliente_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_venda_funcionario_idx` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_venda_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `lab04db`.`cliente` (`pessoa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `lab04db`.`funcionario` (`pessoa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci