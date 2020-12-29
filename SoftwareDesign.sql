-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema SoftwareDesign
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SoftwareDesign
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SoftwareDesign` DEFAULT CHARACTER SET utf8 ;
USE `SoftwareDesign` ;

-- -----------------------------------------------------
-- Table `SoftwareDesign`.`Dormitory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`Dormitory` (
  `pdormitory` INT NOT NULL,
  `dname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pdormitory`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SoftwareDesign`.`Major`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`Major` (
  `pmajor` INT NOT NULL,
  `mname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pmajor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SoftwareDesign`.`University`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`University` (
  `univ` INT NOT NULL,
  `uname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`univ`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SoftwareDesign`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`User` (
  `id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `pname` VARCHAR(45) NOT NULL,
  `pgender` INT NOT NULL,
  `pmbti` INT NOT NULL,
  `univ` INT NOT NULL,
  `pmajor` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `pdormitory` INT NOT NULL,
  `psmoke` TINYINT NOT NULL,
  `pcomment` VARCHAR(128) NOT NULL,
  `page` INT NOT NULL,
  `pcontact` VARCHAR(45) NOT NULL,
  `pstime` INT NOT NULL,
  `pshour` INT NOT NULL,
  `hasMatchBefore` TINYINT NOT NULL,
  `isMatched` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_User_Dormitory1`
    FOREIGN KEY (`pdormitory`)
    REFERENCES `SoftwareDesign`.`Dormitory` (`pdormitory`),
  CONSTRAINT `fk_User_Major1`
    FOREIGN KEY (`pmajor`)
    REFERENCES `SoftwareDesign`.`Major` (`pmajor`),
  CONSTRAINT `fk_User_University1`
    FOREIGN KEY (`univ`)
    REFERENCES `SoftwareDesign`.`University` (`univ`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_User_Dormitory1` ON `SoftwareDesign`.`User` (`pdormitory` ASC) VISIBLE;

CREATE INDEX `fk_User_University1` ON `SoftwareDesign`.`User` (`univ` ASC) VISIBLE;

CREATE INDEX `fk_User_id_idx` ON `SoftwareDesign`.`User` (`id` ASC) VISIBLE;

CREATE INDEX `fk_User_Major1_idx` ON `SoftwareDesign`.`User` (`pmajor` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `SoftwareDesign`.`DenyMatch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`DenyMatch` (
  `did` VARCHAR(45) NOT NULL,
  `otherid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`did`, `otherid`),
  CONSTRAINT `fk_denyMatch_User`
    FOREIGN KEY (`did`)
    REFERENCES `SoftwareDesign`.`User` (`id`),
  CONSTRAINT `fk_denyMatch_User1`
    FOREIGN KEY (`otherid`)
    REFERENCES `SoftwareDesign`.`User` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_denyMatch_User1` ON `SoftwareDesign`.`DenyMatch` (`otherid` ASC) VISIBLE;

CREATE INDEX `fk_denyMatch_id_idx` ON `SoftwareDesign`.`DenyMatch` (`did` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `SoftwareDesign`.`Request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`Request` (
  `rid` VARCHAR(45) NOT NULL,
  `otherid` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`rid`, `otherid`),
  CONSTRAINT `fk_Request_User1`
    FOREIGN KEY (`rid`)
    REFERENCES `SoftwareDesign`.`User` (`id`),
  CONSTRAINT `fk_Request_User2`
    FOREIGN KEY (`otherid`)
    REFERENCES `SoftwareDesign`.`User` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_Request_User1_idx` ON `SoftwareDesign`.`Request` (`rid` ASC) VISIBLE;

CREATE INDEX `fk_Request_User2_idx` ON `SoftwareDesign`.`Request` (`otherid` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `SoftwareDesign`.`SavedMatch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`SavedMatch` (
  `sid` VARCHAR(45) NOT NULL,
  `otherid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sid`, `otherid`),
  CONSTRAINT `fk_SavedMatch_User1`
    FOREIGN KEY (`sid`)
    REFERENCES `SoftwareDesign`.`User` (`id`),
  CONSTRAINT `fk_SavedMatch_User2`
    FOREIGN KEY (`otherid`)
    REFERENCES `SoftwareDesign`.`User` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_SavedMatch_User2` ON `SoftwareDesign`.`SavedMatch` (`otherid` ASC) VISIBLE;

CREATE INDEX `fk_SavedMatch_id_idx` ON `SoftwareDesign`.`SavedMatch` (`sid` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `SoftwareDesign`.`Matched`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SoftwareDesign`.`Matched` (
  `mid` VARCHAR(45) NOT NULL,
  `otherid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`mid`, `otherid`),
  CONSTRAINT `fk_Matched_User1`
    FOREIGN KEY (`mid`)
    REFERENCES `SoftwareDesign`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matched_User2`
    FOREIGN KEY (`otherid`)
    REFERENCES `SoftwareDesign`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Matched_User2_idx` ON `SoftwareDesign`.`Matched` (`otherid` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
