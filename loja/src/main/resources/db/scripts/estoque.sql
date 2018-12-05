--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela ESTOQUE
CREATE TABLE IF NOT EXISTS `lab04db`.`estoque` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela estoque.',
  `id_produto` INT(11) NOT NULL COMMENT 'Identificador da tabela produto.',
  `qtd_produto` INT(50) NULL DEFAULT NULL COMMENT 'Quantidade do produto em estoque.',
  `qtd_minima` INT(50) NULL DEFAULT NULL COMMENT 'Quantidade mínima do produto em estoque.',
  PRIMARY KEY (`id`),
  INDEX `fk_estoque_produto_idx` (`id_produto` ASC) VISIBLE,
  CONSTRAINT `fk_estoque_produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `lab04db`.`produto` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM ESTOQUE;