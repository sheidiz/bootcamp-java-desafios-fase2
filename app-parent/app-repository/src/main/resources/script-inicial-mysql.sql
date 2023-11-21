CREATE DATABASE IF NOT EXISTS `bootcamp-java-desafio5`
USE `bootcamp-java-desafio5`;

#CREAR TABLAS
CREATE TABLE IF NOT EXISTS `POKEMON` (
  	id INT NOT NULL,
  	name VARCHAR(50) NOT NULL DEFAULT '',
  	baseExperience INT NOT NULL DEFAULT (0),
  	height INT NOT NULL DEFAULT (0),
  	weight INT NOT NULL DEFAULT (0),
  	PRIMARY KEY (id)
)COLLATE=utf8mb4_spanish_ci;

CREATE TABLE COVID (
	date VARCHAR(8) NOT NULL DEFAULT '',
	states INT(10) NOT NULL,
	positive INT(10) NOT NULL,
	negative INT(10) NOT NULL,
	pending INT(10) NOT NULL,
	hash VARCHAR(50) NOT NULL DEFAULT '',
	PRIMARY KEY (date) USING BTREE
)COLLATE='utf8mb4_spanish_ci';

CREATE TABLE PLACEHOLDER (
	id INT(10) NOT NULL,
	userId INT(10) NOT NULL,
	title VARCHAR(200) NOT NULL DEFAULT '',
	body VARCHAR(300) NOT NULL DEFAULT '',
	PRIMARY KEY (id) USING BTREE
)COLLATE='utf8mb4_spanish_ci';

#INSERTAR CONTENIDO
INSERT INTO POKEMON (id, name, baseExperience, height, weight) VALUES (1, 'bulbasaur', 64, 7, 69)

INSERT INTO POKEMON (id, name, baseExperience, height, weight) VALUES (2, 'ivysaur', 142, 10, 130)

INSERT INTO COVID (date, states, positive, negative, pending, hash) VALUES ('20200101', 1, 100, 100, 100, 'hash3921839028')

INSERT INTO PLACEHOLDER (id, userId, title, body) 
VALUES (1, 1, 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit', 'quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto')