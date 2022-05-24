DROP DATABASE IF EXISTS bdprog;
CREATE DATABASE IF NOT EXISTS bdprog;
USE bdprog;

CREATE TABLE IF NOT EXISTS usuario (
	codusuario int unsigned not null auto_increment,
    nombre VARCHAR(50),
    contrasenia VARCHAR(25),
    email VARCHAR(50) UNIQUE,
    edad INT UNSIGNED,
    CONSTRAINT pk_Usuario PRIMARY KEY (codusuario)
);

insert into usuario
(codusuario, nombre, contrasenia, email, edad)
values
(1,'Samuel', 'pass123', 'samuel@gmail.com',28),
(2,'Alberto', 'basket123', 'alberto@gmail.com',29),
(3,'Anne', 'garouc3n3t', 'anne@gmail.com',27);

CREATE TABLE IF NOT EXISTS jugador (
	codjugador int unsigned not null auto_increment,
    apodo VARCHAR(20) UNIQUE,
    sistemapreferido VARCHAR(25),
    iniciorol int unsigned,
    numpartidas INT UNSIGNED,
    codusuario int unsigned,
    CONSTRAINT pk_jugador PRIMARY KEY (codjugador),
    CONSTRAINT fk_jugador_usuario FOREIGN KEY (codusuario)
        REFERENCES usuario (codusuario)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

insert into jugador
(codjugador, apodo, sistemapreferido, iniciorol, numpartidas, codusuario)
values
(1,'Mapacherben','RyF',2010, 87,1),
(2,'Elros','Anima Betond Fantasy',2010, 124,2),
(3,'OliviaWhistas','Vampire',2015, 52,3);

CREATE TABLE IF NOT EXISTS partida (
	codpartida int unsigned not null auto_increment,
    titulo VARCHAR(20),
    numsesiones TINYINT UNSIGNED,
    trasfondo VARCHAR(500),
    codjugador int unsigned,
    CONSTRAINT pk_partida PRIMARY KEY (codpartida),
    CONSTRAINT fk_partida_jugador FOREIGN KEY (codjugador)
        REFERENCES jugador (codjugador)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

insert into partida
(codpartida, titulo, numsesiones, trasfondo, codjugador)
values
(1, 'La dama', 3, 'Una extraña carta llega a manos de los aventureros, una misteriosa mujer los reclama',1),
(2, 'Truhan', 1, 'La fuente del pueblo se ha secado, un extraño personaje pide oro a cambio de recuperar el agua',2),
(3, 'Lyserods, como no', 9, 'En la taberna se oye demasiado escándalo, se dice que una extraña familia está celebrando algo',3);

-- select * from usuario;
-- select * from jugador;
-- select * from partida;