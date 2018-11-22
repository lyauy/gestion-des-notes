CREATE DATABASE GestionNote;
CREATE TABLE eleve
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    numero INT UNIQUE NOT NULL,
    prenom VARCHAR(50),
    nom VARCHAR(50),
    branche VARCHAR(30),
    note INT
);