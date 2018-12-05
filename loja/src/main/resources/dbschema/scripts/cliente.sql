--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela CLIENTE
CREATE TABLE IF NOT EXISTS `lab04db`.`cliente` (
  `pessoa_id` INT(11) NOT NULL COMMENT 'Identificador da tabela pessoa.',
  PRIMARY KEY (`pessoa_id`),
  INDEX `fk_cliente_pessoa_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_pessoa`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `lab04db`.`pessoa` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM CLIENTE;