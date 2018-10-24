--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela FORNECEDOR
CREATE TABLE IF NOT EXISTS `lab04db`.`fornecedor` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` INT(14) NOT NULL,
  `id_endereco` INT(20) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fornecedor_endereco_idx` (`id_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedor_endereco`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `lab04db`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
ENGINE = InnoDB;
--rollback DELETE FROM FORNECEDOR;