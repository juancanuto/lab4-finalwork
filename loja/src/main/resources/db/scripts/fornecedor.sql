--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela FORNECEDOR
CREATE TABLE IF NOT EXISTS `lab04db`.`fornecedor` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela forncedor.',
  `nome` VARCHAR(45) NOT NULL COMMENT 'Nome do fornecedor do produto.',
  `cnpj` INT(14) NOT NULL COMMENT 'Número do cadastro CNPJ do fornecedor.',
  `endereco_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fornecedor_endereco1_idx` (`endereco_id` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedor_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `lab04db`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM FORNECEDOR;