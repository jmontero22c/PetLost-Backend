DROP DATABASE PETLOST;
CREATE DATABASE PETLOST;
USE PETLOST;

/*------Tablas------*/
CREATE TABLE Persona (
idPersona INT PRIMARY KEY AUTO_INCREMENT,
nombres VARCHAR (60) NOT NULL,
apellidos VARCHAR (60) NOT NULL
);

CREATE TABLE Usuario (
fk_idPersona INT NOT NULL UNIQUE,
correo VARCHAR (80) NOT NULL,
contraseña VARCHAR (100) NOT NULL,
FOREIGN KEY (fk_idPersona) REFERENCES Persona(idPersona) ON DELETE RESTRICT ON UPDATE CASCADE
);
        
CREATE TABLE Contacto(
idContacto INT PRIMARY KEY AUTO_INCREMENT,
direccion VARCHAR (60) NOT NULL,
celular BIGINT  NOT NULL,
ciudad VARCHAR (50) NOT NULL,
fk_idPersona INT NOT NULL,
FOREIGN KEY (fk_idPersona) REFERENCES Persona(idPersona) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE TipoMascota(
idtipoMascota INT PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR (30) NOT NULL
);

CREATE TABLE Mascota (
idMascota INT PRIMARY KEY AUTO_INCREMENT,
fk_idPersona INT NOT NULL,
Nombre VARCHAR (30) NOT NULL,
fk_tipoMascota INT NOT NULL,
fotografia VARCHAR (100) NOT NULL,
fechaperdida DATE NOT NULL,
lugarperdida VARCHAR (80) NOT NULL,
FOREIGN KEY (fk_tipoMascota) REFERENCES TipoMascota (idtipoMascota) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (fk_idPersona) REFERENCES Persona (idPersona) ON DELETE RESTRICT ON UPDATE CASCADE
);
/*------Datos------*/
INSERT INTO TipoMascota (idtipoMascota, descripcion)
VALUES
(DEFAULT, "Gato"),
(DEFAULT, "Perro"),
(DEFAULT, "Conejo"),
(DEFAULT, "Hamster");
