CREATE DATABASE IF NOT EXISTS disestock;
USE disestock;

DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (
    id_usuario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    rol VARCHAR(50) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_usuario)
);

INSERT INTO usuarios (nombre, apellido, correo, rol, estado)
VALUES
('Fernando', 'Montoya', 'fernando.montoya@disestock.com', 'Administrador', 'Activo'),
('Laura', 'Gomez', 'laura.gomez@disestock.com', 'Bodeguero', 'Activo');