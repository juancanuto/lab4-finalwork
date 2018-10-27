--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela ESTOQUE
CREATE TABLE IF NOT EXISTS `lab04db`.`estoque` (
  `id` INT NOT NULL,
  `id_produto` INT NOT NULL,
  `qtd_produto` INT(50) NULL,
  `qtd_minima` INT(50) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_estoque_produto_idx` (`id_produto` ASC) VISIBLE,
  CONSTRAINT `fk_estoque_produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `lab04db`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
--rollback DELETE FROM ESTOQUE;