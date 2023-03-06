drop database if exists Policlinica;
CREATE DATABASE IF NOT EXISTS Policlinica;
use Policlinica;
CREATE TABLE IF NOT EXISTS Angajat (
Id_angajat INT NOT NULL,
Functie VARCHAR(45) NOT NULL,
Salar_neg INT NOT NULL,
Nr_ore INT NOT NULL,
PRIMARY KEY (Id_angajat));
 
 CREATE TABLE IF NOT EXISTS Asistent_medical (
Id_asis_medical INT NOT NULL,
Tip VARCHAR(20),
Grad VARCHAR(20),
Id_ca_utilizator INT NOT NULL,
id_de_la_medic int,
PRIMARY KEY (Id_asis_medical));
CREATE TABLE IF NOT EXISTS Medic (
Id_medic INT NOT NULL,
Specialitate VARCHAR(20) NOT NULL,
Grad VARCHAR(20) NOT NULL,
Cod_Parafa INT UNIQUE NOT NULL,
Competente_detinute VARCHAR(45) NOT NULL,
Titlu_Stiintific VARCHAR(20), -- poate sa nu aiba
Postul_Didactic VARCHAR(20), -- poate sa nu aiba
Procent_neg_servicii FLOAT(4,1) NOT NULL,
PRIMARY KEY(Id_medic),
Id_ca_utilizator INT NOT NULL);
 
 CREATE TABLE IF NOT EXISTS Servicii (
Id_servicii INT NOT NULL, 
Secialitate varchar(20),
Necesitate_competente VARCHAR(45),
Pret INT, 
Durata INT,
echipament_necesar varchar(255),
PRIMARY KEY (Id_servicii));
drop table if exists Program;
CREATE TABLE IF NOT EXISTS Program(
id_program int primary key, 
datapr date,
ora_deschidere int,
ora_inchidere int,
unitate int);
drop table if exists Unitati_Medicale;
CREATE TABLE IF NOT EXISTS Unitati_Medicale
(id_unitate_medicala int primary key,
denumire varchar(255),
adresa varchar(255));
drop table if exists cabinete;
CREATE TABLE IF NOT EXISTS cabinete(
id_cabinet int primary key,
id_unitate int, 
id_medic int,
echipamente varchar(255));
drop table if exists Utilizatori;
CREATE TABLE IF NOT EXISTS Utilizatori(
id_utilizator int unique primary key, tip varchar(255),
parola varchar(50),
CNP int(13), nume varchar(255), prenume varchar(255), 
adresa varchar(255), nr_telefon varchar(255),
mail varchar(255), cont varchar(255), 
nr_contract int, data_angajarii date,
functie varchar(255), rol varchar(255) , 
vaccin varchar(10),
id_ca_angajat int);
drop table if exists Programari;
CREATE TABLE IF NOT EXISTS Programari(
id_programare int primary key,
id_pacient int,
id_serviciupr int,
id_serviciupr2 int,
id_serviciupr3 int,
ora_inceperii int,
ora_finalizarii int,
datapacient date, #yyyy-mm-dd
unitatea int,
cabinetul int,
medicul int);
drop table if exists ProgramAngajati;
CREATE TABLE IF NOT EXISTS ProgramAngajati(
id_prang int primary key,
id_ca_angajat int,
datapr date,
ora_incepere int,
ora_plecare int,
unitate int,
concediu bool);
drop table if exists Pacienti;
CREATE TABLE IF NOT EXISTS Pacienti(
id_pacient int primary key,
alergii varchar(255),
boli varchar(255),
nume varchar(30),
prenume varchar(50),
datanasterii date,
sexul char,
domiciliu varchar(255),
cetatenie varchar(30),
asigurare varchar(10));
drop table if exists IstoricBonuri;
CREATE TABLE IF NOT EXISTS IstoricBonuri(
id_bon int primary key,
id_de_la_programare int,
sumaplatita varchar(255));
drop table if exists raport_medical;
CREATE TABLE IF NOT EXISTS raport_medical(
id_fisa int primary key, 
id_programare int,
istoric varchar(255),
simptome varchar(255),
investigatii varchar(255),
diagnostic varchar(255),
recomandari varchar(255),
validare int);
drop table if exists Istoric_Salariu;
CREATE TABLE IF NOT EXISTS Istoric_Salariu(
id_salariu int primary key,
id_angajat int,
data_aplicarii date,
salariu int);
Alter table Istoric_Salariu
add FOREIGN KEY (id_angajat) REFERENCES angajat(id_angajat);
Alter table Asistent_medical
add FOREIGN KEY (Id_ca_utilizator) REFERENCES utilizatori(id_utilizator),
add FOREIGN KEY (Id_de_la_medic) REFERENCES Medic(id_medic);
Alter table Medic
add FOREIGN KEY (Id_ca_utilizator) REFERENCES utilizatori(id_utilizator);
alter table raport_medical
-- add FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
add FOREIGN KEY (id_programare) REFERENCES Programari(id_programare);
Alter table Utilizatori
add FOREIGN KEY (id_ca_angajat) REFERENCES Angajat(id_angajat);
Alter table Program
add FOREIGN KEY (unitate) references Unitati_Medicale(id_unitate_medicala);
Alter table Programari
add FOREIGN KEY (unitatea) references Unitati_Medicale(id_unitate_medicala),
add foreign key (id_serviciupr) references Servicii(id_servicii),
-- add foreign key (id_serviciupr2) references Servicii(id_servicii),
-- add foreign key (id_serviciupr3) references Servicii(id_servicii),
add foreign key (medicul) references Medic(Id_medic),
add foreign key (cabinetul) references cabinete(id_cabinet),
add FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient);
Alter table ProgramAngajati
add FOREIGN KEY (unitate) references Unitati_Medicale(id_unitate_medicala),
add FOREIGN KEY (id_ca_angajat) references Angajat(Id_angajat);
alter table cabinete
add foreign key(id_unitate) references Unitati_Medicale(id_unitate_medicala),
add foreign key(id_medic) references Medic(Id_medic);
Alter table Istoricbonuri
add FOREIGN KEY (id_de_la_programare) REFERENCES Programari(id_programare);