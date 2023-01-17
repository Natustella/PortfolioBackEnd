-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Portfolio` DEFAULT CHARACTER SET utf8 ;
USE `Portfolio` ;

-- -----------------------------------------------------
-- Table `Portfolio`.`Acerca_de`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Acerca_de` (
  `idAcerca de` INT NOT NULL,
  `Descripción` VARCHAR(200) NULL,
  PRIMARY KEY (`idAcerca de`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Detalle` (
  `idDetalle` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Título` VARCHAR(50) NOT NULL,
  `Ubicación` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idDetalle`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Portfolio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Portfolio` (
  `idPortfolio` INT NOT NULL AUTO_INCREMENT,
  `URL_Banner` VARCHAR(100) NULL,
  `URL_Profile_Picture` VARCHAR(100) NULL,
  `Acerca_de_idAcerca de` INT NOT NULL,
  `Detalle_idDetalle` INT NOT NULL,
  PRIMARY KEY (`idPortfolio`, `Acerca_de_idAcerca de`, `Detalle_idDetalle`),
  UNIQUE INDEX `idPortfolio_UNIQUE` (`idPortfolio` ASC) VISIBLE,
  INDEX `fk_Portfolio_Acerca_de1_idx` (`Acerca_de_idAcerca de` ASC) VISIBLE,
  INDEX `fk_Portfolio_Detalle1_idx` (`Detalle_idDetalle` ASC) VISIBLE,
  CONSTRAINT `fk_Portfolio_Acerca_de1`
    FOREIGN KEY (`Acerca_de_idAcerca de`)
    REFERENCES `Portfolio`.`Acerca_de` (`idAcerca de`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Portfolio_Detalle1`
    FOREIGN KEY (`Detalle_idDetalle`)
    REFERENCES `Portfolio`.`Detalle` (`idDetalle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `E-mail` VARCHAR(45) NOT NULL,
  `Clave` VARCHAR(45) NOT NULL,
  `Portfolio_idPortfolio` INT NOT NULL,
  `Portfolio_Acerca_de_idAcerca de` INT NOT NULL,
  `Portfolio_Detalle_idDetalle` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `Portfolio_idPortfolio`, `Portfolio_Acerca_de_idAcerca de`, `Portfolio_Detalle_idDetalle`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) VISIBLE,
  UNIQUE INDEX `E-mail_UNIQUE` (`E-mail` ASC) VISIBLE,
  UNIQUE INDEX `Clave_UNIQUE` (`Clave` ASC) VISIBLE,
  INDEX `fk_Usuario_Portfolio1_idx` (`Portfolio_idPortfolio` ASC, `Portfolio_Acerca_de_idAcerca de` ASC, `Portfolio_Detalle_idDetalle` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Portfolio1`
    FOREIGN KEY (`Portfolio_idPortfolio` , `Portfolio_Acerca_de_idAcerca de` , `Portfolio_Detalle_idDetalle`)
    REFERENCES `Portfolio`.`Portfolio` (`idPortfolio` , `Acerca_de_idAcerca de` , `Detalle_idDetalle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Perfil` (
  `idPerfil` INT NOT NULL,
  `Rol` VARCHAR(45) NULL,
  PRIMARY KEY (`idPerfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Experiencia` (
  `idExperiencia` INT NOT NULL,
  `Posición` VARCHAR(45) NULL,
  `URL_Logo` VARCHAR(200) NULL,
  `Empresa` VARCHAR(45) NULL,
  `Desde` DATE NULL,
  `Hasta` DATE NULL,
  `Actividad` VARCHAR(100) NULL,
  `Es_trabajo_actual` TINYINT NULL,
  `Portfolio_idPortfolio` INT NOT NULL,
  PRIMARY KEY (`idExperiencia`, `Portfolio_idPortfolio`),
  INDEX `fk_Experiencia_Portfolio_idx` (`Portfolio_idPortfolio` ASC) VISIBLE,
  CONSTRAINT `fk_Experiencia_Portfolio`
    FOREIGN KEY (`Portfolio_idPortfolio`)
    REFERENCES `Portfolio`.`Portfolio` (`idPortfolio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Cursos` (
  `idCursos` INT NOT NULL,
  `Título` VARCHAR(45) NULL,
  `URL_imagen` VARCHAR(200) NULL,
  `Dado_en` VARCHAR(50) NULL,
  `Fecha` DATE NULL,
  `Portfolio_idPortfolio` INT NOT NULL,
  PRIMARY KEY (`idCursos`, `Portfolio_idPortfolio`),
  INDEX `fk_Cursos_Portfolio1_idx` (`Portfolio_idPortfolio` ASC) VISIBLE,
  CONSTRAINT `fk_Cursos_Portfolio1`
    FOREIGN KEY (`Portfolio_idPortfolio`)
    REFERENCES `Portfolio`.`Portfolio` (`idPortfolio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Proyectos` (
  `idProyectos` INT NOT NULL,
  `Descripcion` VARCHAR(200) NULL,
  `Portfolio_idPortfolio` INT NOT NULL,
  PRIMARY KEY (`idProyectos`, `Portfolio_idPortfolio`),
  INDEX `fk_Proyectos_Portfolio1_idx` (`Portfolio_idPortfolio` ASC) VISIBLE,
  CONSTRAINT `fk_Proyectos_Portfolio1`
    FOREIGN KEY (`Portfolio_idPortfolio`)
    REFERENCES `Portfolio`.`Portfolio` (`idPortfolio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Skills` (
  `idSkills` INT NOT NULL,
  `Habilidad` VARCHAR(30) NULL,
  `Porcentaje` INT NULL,
  `Portfolio_idPortfolio` INT NOT NULL,
  PRIMARY KEY (`idSkills`, `Portfolio_idPortfolio`),
  INDEX `fk_Skills_Portfolio1_idx` (`Portfolio_idPortfolio` ASC) VISIBLE,
  CONSTRAINT `fk_Skills_Portfolio1`
    FOREIGN KEY (`Portfolio_idPortfolio`)
    REFERENCES `Portfolio`.`Portfolio` (`idPortfolio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Perfil_has_Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Perfil_has_Usuario` (
  `Perfil_idPerfil` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`Perfil_idPerfil`, `Usuario_idUsuario`),
  INDEX `fk_Perfil_has_Usuario_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Perfil_has_Usuario_Perfil1_idx` (`Perfil_idPerfil` ASC) VISIBLE,
  CONSTRAINT `fk_Perfil_has_Usuario_Perfil1`
    FOREIGN KEY (`Perfil_idPerfil`)
    REFERENCES `Portfolio`.`Perfil` (`idPerfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Perfil_has_Usuario_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `Portfolio`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
