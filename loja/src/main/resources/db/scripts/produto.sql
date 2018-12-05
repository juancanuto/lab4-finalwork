--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela PRODUTO
CREATE TABLE IF NOT EXISTS `lab04db`.`produto` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela produto.',
  `id_categoria` INT(11) NOT NULL COMMENT 'Identificador da tabela categoria.',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Descrição do nome do produto.',
  `marca` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Descrição da marca do produto.',
  `modelo` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Descriçaõ do modelo do produto.',
  `cor` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Descriçaõ da cor do produto, caso aplicado.',
  `tamanho` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Descrição do tamanho do produto, caso aplicado.',
  `valor` DOUBLE NULL DEFAULT NULL COMMENT 'Descrição do valor do produto.',
  `observacao` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Observações complementares ao produto.',
  `data_fabricacao` DATETIME NULL DEFAULT NULL COMMENT 'Data de fabricação do produto.',
  PRIMARY KEY (`id`),
  INDEX `fk_produto_categoria1_idx` (`id_categoria` ASC) VISIBLE,
  CONSTRAINT `fk_produto_categoria1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `lab04db`.`categoria` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci