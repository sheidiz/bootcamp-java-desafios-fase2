-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.1.0 - MySQL Community Server - GPL
-- Server OS:                    Linux
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

-- Dumping database structure for bootcamp-java-desafio5
CREATE DATABASE IF NOT EXISTS `bootcamp-java-desafio5`
USE `bootcamp-java-desafio5`;

-- Dumping structure for table bootcamp-java-desafio5.POKEMON
CREATE TABLE IF NOT EXISTS `POKEMON` (
  `id` int NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL DEFAULT '',
  `baseExperience` int NOT NULL DEFAULT (0),
  `height` int NOT NULL DEFAULT (0),
  `weight` int NOT NULL DEFAULT (0),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

