--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela TELEFONE_CLIENTE
CREATE TABLE IF NOT EXISTS `lab04db`.`telefone_cliente` (
  `telefone_id` INT(11) NOT NULL COMMENT 'Identificador da tabela telefone.',
  `pessoa_id` INT(11) NOT NULL COMMENT 'Identificador da tabela pessoa.',
  PRIMARY KEY (`telefone_id`, `pessoa_id`),
  INDEX `fk_telefone_has_cliente_telefone1_idx` (`telefone_id` ASC) VISIBLE,
  INDEX `fk_telefone_pessoa_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_clitente_cliente`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `lab04db`.`cliente` (`pessoa_id`),
  CONSTRAINT `fk_telefone_cliente_telefone`
    FOREIGN KEY (`telefone_id`)
    REFERENCES `lab04db`.`telefone` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM TELEFONE_CLIENTE;