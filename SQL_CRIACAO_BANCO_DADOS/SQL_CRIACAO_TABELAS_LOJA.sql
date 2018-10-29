-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab04db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lab04db` ;

-- -----------------------------------------------------
-- Schema lab04db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab04db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `lab04db` ;

-- -----------------------------------------------------
-- Table `lab04db`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`categoria` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela categoria.',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Descrição da categoria.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`endereco`
-- -----------------------------------------------------
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
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`pessoa` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL COMMENT 'Nome completo atribuído à pessoa.',
  `cpf` INT(12) NOT NULL COMMENT 'Número de Cadastro de Pessoa Física (CPF) atribuído à pessoa.',
  `rg` INT(9) NOT NULL COMMENT 'Número de Registro Geral (RG) atribuído à pessoa.',
  `data_nascimento` DATETIME NULL DEFAULT NULL COMMENT 'Data de Nascimento da pessoa.',
  `sexo` VARCHAR(2) NULL DEFAULT NULL COMMENT 'Sexo atribuído à pessoa, será definido um código de atribuição que poderá ser (Masculino,Feminino,Não Informado).',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`cliente` (
  `endereco_id` INT(11) NOT NULL COMMENT 'Identificador da tabela endereco.',
  `pessoa_id` INT(11) NOT NULL COMMENT 'Identificador da tabela pessoa.',
  PRIMARY KEY (`pessoa_id`),
  INDEX `fk_cliente_endereco_idx` (`endereco_id` ASC) VISIBLE,
  INDEX `fk_cliente_pessoa_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_endereco`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `lab04db`.`endereco` (`id`),
  CONSTRAINT `fk_cliente_pessoa`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `lab04db`.`pessoa` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`produto`
-- -----------------------------------------------------
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
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`estoque`
-- -----------------------------------------------------
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
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`fornecedor` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela forncedor.',
  `nome` VARCHAR(45) NOT NULL COMMENT 'Nome do fornecedor do produto.',
  `cnpj` INT(14) NOT NULL COMMENT 'Número do cadastro CNPJ do fornecedor.',
  `id_endereco` INT(20) NULL DEFAULT NULL COMMENT 'Identificador da tabela endereco',
  PRIMARY KEY (`id`),
  INDEX `fk_fornecedor_endereco_idx` (`id_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedor_endereco`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `lab04db`.`endereco` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`fornecedor_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`fornecedor_produto` (
  `id_fornecedor` INT(11) NOT NULL COMMENT 'Identificador da tabela forncedor.',
  `id_produto` INT(11) NOT NULL COMMENT 'Identificador da tabela produto.',
  PRIMARY KEY (`id_fornecedor`, `id_produto`),
  INDEX `fk_fornecedores_has_produto_produto1_idx` (`id_produto` ASC) VISIBLE,
  INDEX `fk_fornecedores_has_produto_fornecedores1_idx` (`id_fornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedores_has_produto_fornecedores1`
    FOREIGN KEY (`id_fornecedor`)
    REFERENCES `lab04db`.`fornecedor` (`id`),
  CONSTRAINT `fk_fornecedores_has_produto_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `lab04db`.`produto` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`usuario` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela Usuario',
  `nome` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Nome do login de usuário.',
  `senha` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Senha de usuário.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`funcionario` (
  `usuario_id` INT(11) NOT NULL COMMENT 'Identificador da tabela usuario.',
  `pessoa_id` INT(11) NOT NULL COMMENT 'Identificador da tabela pessoa.',
  INDEX `fk_funcionario_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_funcionario_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  PRIMARY KEY (`pessoa_id`),
  CONSTRAINT `fk_funcionario_pessoa`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `lab04db`.`pessoa` (`id`),
  CONSTRAINT `fk_funcionario_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `lab04db`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`telefone` (
  `id` INT(11) NOT NULL COMMENT 'Identificador da tabela telefone.',
  `numero` INT(11) NULL DEFAULT NULL COMMENT 'Número do telefone',
  `ddd` INT(11) NULL DEFAULT NULL COMMENT 'Código DDD do Telefone.',
  `tipo` INT(2) NULL DEFAULT NULL COMMENT 'Codigo referente ao tipo de telefone.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`telefone_cliente`
-- -----------------------------------------------------
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
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`telefone_fornecedor`
-- -----------------------------------------------------
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
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lab04db`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab04db`.`venda` (
  `id` INT(20) NOT NULL COMMENT 'Identificador da tabela venda.',
  `id_cliente` INT(20) NOT NULL COMMENT 'Identificador da tabela cliente.',
  `id_produto` INT(20) NOT NULL COMMENT 'Identificador da tabela produto.',
  `id_funcionario` INT(11) NOT NULL COMMENT 'Identificador da tabela funcionario.',
  `forma_pgto` INT(20) NOT NULL COMMENT 'Codigo referente à forma de pagamento.',
  `valor_pago` DOUBLE NOT NULL COMMENT 'Valor pago pela venda do produto.',
  `num_parcelas` INT(10) NOT NULL COMMENT 'Número de parcelas da venda do produto.',
  PRIMARY KEY (`id`),
  INDEX `fk_venda_produto1_idx` (`id_produto` ASC) VISIBLE,
  INDEX `fk_venda_cliente_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_venda_funcionario_idx` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_venda_produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `lab04db`.`produto` (`id`),
  CONSTRAINT `fk_venda_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `lab04db`.`cliente` (`pessoa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `lab04db`.`funcionario` (`pessoa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
