Create DATABASE IF NOT EXISTS CovidHopital Default character set utf8 default collate utf8_general_ci;

USE CovidHopital;


DROP TABLE IF EXISTS Maladie;

DROP TABLE IF EXISTS Traitement;
DROP TABLE IF EXISTS Posologie;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS SejourHospitalier;
DROP TABLE IF EXISTS Diagnostic;
DROP TABLE IF EXISTS Patient;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Symptome;
DROP TABLE IF EXISTS Medicament;

DROP TABLE IF EXISTS Hopital;


CREATE TABLE Users(
	id_User int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	login varchar(255) NOT NULL,
	passwd varchar(255),
	Permission varchar(255)
	);

CREATE TABLE Hopital(
	id_Hopital int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomHopital varchar(255),
	ville varchar(255)
	);

CREATE TABLE Medicament(
	id_Medoc int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	descriptionMedoc varchar(255)
	);

CREATE TABLE Symptome(
	id_Symptome int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	descriptionSymptome varchar(255)
	);

CREATE TABLE Patient(
	id_Patient int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	CIN varchar(255),
	DateNaissance Date,
	Nom varchar(255),
	Prenom varchar(255),
	Tel varchar(255),
	Adresse varchar(255)
	);

CREATE TABLE Diagnostic(
	id_Diagnostic int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	date_Contamination Date,
	date_Diagnostic Date,
	date_Cloture Date,
	etat_final boolean,
	id_Patient int NOT NULL,
	FOREIGN KEY (id_Patient) REFERENCES Patient(id_Patient)
	);

CREATE TABLE SejourHospitalier(
	id_Sejour int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	debutSejour Date,
	finSejour Date,
	id_Diagnostic int NOT NULL,
	FOREIGN KEY (id_Diagnostic) REFERENCES Diagnostic(id_Diagnostic)
	);

CREATE TABLE Room(
	id_Room int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	type varchar(255),
	etat varchar(1),
	id_Sejour int NOT NULL,
	id_Hopital int NOT NULL,
	FOREIGN KEY (id_Sejour) REFERENCES SejourHospitalier(id_Sejour),
	FOREIGN KEY (id_Hopital) REFERENCES Hopital(id_Hopital)
	);

CREATE TABLE Posologie(
	id_Posologie int PRIMARY KEY AUTO_INCREMENT,
	date_debut Date,
	date_fin Date,
	nb_prise_jour int,
	id_Diagnostic int NOT NULL,
	FOREIGN KEY (id_Diagnostic) REFERENCES Diagnostic(id_Diagnostic)
	);

CREATE TABLE Maladie(
	id_Symptome int NOT NULL,
	id_Diagnostic int NOT NULL,
	PRIMARY KEY (id_Symptome,id_Diagnostic),
	FOREIGN KEY (id_Symptome) REFERENCES Symptome(id_Symptome),
	FOREIGN KEY (id_Diagnostic) REFERENCES Diagnostic(id_Diagnostic)
	);

CREATE TABLE Traitement(
	id_Medoc int NOT NULL,
	id_Posologie int NOT NULL,
	PRIMARY KEY(id_Medoc,id_Posologie),
	FOREIGN KEY (id_Medoc) REFERENCES Medicament(id_Medoc),
	FOREIGN KEY (id_Posologie) REFERENCES Posologie(id_Posologie)
	);

