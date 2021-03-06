-- MySQL Script generated by MySQL Workbench
-- Thu Feb 15 21:16:13 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `Abiturient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Abiturient` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Abiturient` (
  `Id_Abiturient` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Last_Name` VARCHAR(45) NOT NULL,
  `First_Name` VARCHAR(45) NOT NULL,
  `Second_Name` VARCHAR(45) NULL,
  `Address` VARCHAR(150) NOT NULL,
  `Passport` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id_Abiturient`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `idAbiturient_UNIQUE` ON `Abiturient` (`Id_Abiturient` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Parent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Parent` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Parent` (
  `Id_Parent` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Full_Name` VARCHAR(150) NOT NULL,
  `Passport` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Id_Abiturient` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Id_Parent`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Id_Parent_UNIQUE` ON `Parent` (`Id_Parent` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Faculty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Faculty` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Faculty` (
  `Id_Faculty` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`Id_Faculty`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Id_Faculty_UNIQUE` ON `Faculty` (`Id_Faculty` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `Name_UNIQUE` ON `Faculty` (`Name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Subject` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Subject` (
  `Id_Subject` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`Id_Subject`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Id_Subject_UNIQUE` ON `Subject` (`Id_Subject` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `Name_UNIQUE` ON `Subject` (`Name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Speciality`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Speciality` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Speciality` (
  `Id_Speciality` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(150) NOT NULL,
  `Id_Faculty` INT UNSIGNED NOT NULL,
  `First_Subject` INT UNSIGNED NOT NULL,
  `Second_Subject` INT UNSIGNED NOT NULL,
  `Third_Subject` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Id_Speciality`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Id_Speciality_UNIQUE` ON `Speciality` (`Id_Speciality` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `Name_UNIQUE` ON `Speciality` (`Name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Privilege`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Privilege` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Privilege` (
  `Id_Privilege` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`Id_Privilege`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Id_Privilege_UNIQUE` ON `Privilege` (`Id_Privilege` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `Name_UNIQUE` ON `Privilege` (`Name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `m2m_Abiturient_Privilege`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m2m_Abiturient_Privilege` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `m2m_Abiturient_Privilege` (
  `Id_Abiturient` INT UNSIGNED NOT NULL,
  `Id_Privilege` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Id_Abiturient`, `Id_Privilege`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `User` (
  `Id_User` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NOT NULL,
  `Password_Hash` VARCHAR(50) NOT NULL,
  `Role` INT UNSIGNED NOT NULL,
  `Email` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`Id_User`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Id_User_UNIQUE` ON `User` (`Id_User` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `Login_UNIQUE` ON `User` (`Login` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Exam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Exam` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Exam` (
  `Id_Abiturient` INT UNSIGNED NOT NULL,
  `First_Exam` INT UNSIGNED NULL,
  `Second_Exam` INT UNSIGNED NULL,
  `Third_Exam` INT UNSIGNED NULL,
  `Attestat` INT UNSIGNED NULL,
  PRIMARY KEY (`Id_Abiturient`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Id_Abiturient_UNIQUE` ON `Exam` (`Id_Abiturient` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
