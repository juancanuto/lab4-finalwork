--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela TELEFONE_FORNECEDOR
CREATE TABLE IF NOT EXISTS `lab04db`.`telefone_fornecedor` (
  `telefone_id` INT(11) NOT NULL COMMENT 'Identificador da tabela telefone.',
  `fornecedor_id` INT(11) NOT NULL COMMENT 'Identificador da tabela fornecedor.',
  PRIMARY KEY (`telefone_id`, `fornecedor_id`),
  INDEX `fk_telefone_has_fornecedor_telefone1_idx` (`telefone_id` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_has_fornecedor_fornecedor`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `lab04db`.`fornecedor` (`id`),
  CONSTRAINT `fk_telefone_has_fornecedor_telefone`
    FOREIGN KEY (`telefone_id`)
    REFERENCES `lab04db`.`telefone` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM TELEFONE_FORNECEDOR;