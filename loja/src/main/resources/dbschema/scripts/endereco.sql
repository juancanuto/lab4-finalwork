--liquibase formatted sql

--changeset adriano:201810210022
--comment: Criando a estrutura da tabela ENDERECO
CREATE TABLE IF NOT EXISTS `lab04db`.`endereco` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela endereco.',
  `rua` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Nome da rua.',
  `numero` INT(10) NULL DEFAULT NULL COMMENT 'Numero da residência',
  `bairro` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Bairro da residência.',
  `cidade` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Cidade da residência',
  `estado` INT(10) NULL DEFAULT NULL COMMENT 'Código referente ao estado federativo da residência',
  `cep` INT(8) NOT NULL COMMENT 'Número do código de endereçamento postal.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
--rollback DELETE FROM ENDERECO;