--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela PRODUTO
CREATE TABLE IF NOT EXISTS `lab04db`.`produto` (
  `id` INT NOT NULL,
  `id_categoria` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `cor` VARCHAR(45) NULL,
  `tamanho` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  `observacao` VARCHAR(45) NULL,
  `data_fabricacao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_categoria1_idx` (`id_categoria` ASC) VISIBLE,
  CONSTRAINT `fk_produto_categoria1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `lab04db`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
--rollback DELETE FROM PRODUTO;