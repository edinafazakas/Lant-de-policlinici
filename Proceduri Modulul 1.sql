DELIMITER // 
DROP PROCEDURE IF EXISTS verificare;
CREATE PROCEDURE verificare(n varchar(255), p varchar(255), t varchar(255), datav date) 
BEGIN 
SELECT concediu FROM programangajati Pr, utilizatori U, angajat A
WHERE U.id_ca_angajat = A.id_angajat AND Pr.id_ca_angajat = A.id_angajat 
AND U.nume = n AND U.prenume = p AND tip = t AND datapr = datav;
END 
// DELIMITER 

DELIMITER // 
DROP PROCEDURE IF EXISTS verificareAconcediu;
CREATE PROCEDURE verificareAconcediu(id int, p varchar(50), datav date) 
BEGIN 
SELECT concediu FROM programangajati Pr, utilizatori U, angajat A
WHERE U.id_ca_angajat = A.id_angajat AND Pr.id_ca_angajat = A.id_angajat 
AND A.id_angajat = id AND U.parola = p AND datapr = datav;
END 
// DELIMITER 

DELIMITER //
DROP PROCEDURE IF EXISTS CautareProgramAzi;
CREATE PROCEDURE  CautareProgramAzi(n varchar(255), p varchar(255), t varchar(255)) 
BEGIN
SELECT ora_incepere AS 'Ora incepere', ora_plecare AS 'Ora plecare', unit.denumire AS 'Unitate'
FROM Utilizatori U, Angajat A, Programangajati Pr, Unitati_medicale unit
WHERE U.id_ca_angajat = A.id_angajat AND Pr.id_ca_angajat = A.id_angajat AND Pr.unitate = unit.id_unitate_medicala
AND U.nume = n AND U.prenume = p AND tip = t AND datapr = current_date();
END 
// DELIMITER 

DELIMITER //
DROP PROCEDURE IF EXISTS ModificareProgramAngajat;
CREATE PROCEDURE  ModificareProgramAngajat(n varchar(255), p varchar(255), t varchar(255), datav date, inceput int , final int) 
BEGIN
UPDATE programangajati Pr, angajat A, utilizatori U
SET ora_incepere = inceput, ora_plecare = final
WHERE U.id_ca_angajat = A.id_angajat AND Pr.id_ca_angajat = A.id_angajat
AND U.nume = n AND U.prenume = p AND tip = t AND Pr.datapr = datav;
END 
// DELIMITER 

DELIMITER //
 DROP PROCEDURE IF EXISTS AdaugareConcediu;
CREATE PROCEDURE  AdaugareConcediu(n varchar(255), p varchar(255), t varchar(255), inceput date , final date)
BEGIN
DECLARE c int;
SELECT COUNT(id_programare) INTO c 
FROM programari P, unitati_medicale UM, programangajati Pr, angajat A, utilizatori U
WHERE U.id_ca_angajat = A.id_angajat AND id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = P.unitatea
AND id_unitate_medicala = Pr.unitate AND nume = n AND prenume = p AND tip = t;

IF(c = 0)
then UPDATE programangajati Pr, angajat A, utilizatori U
SET ora_incepere = null, ora_plecare = null, concediu = 1
WHERE U.id_ca_angajat = A.id_angajat AND Pr.id_ca_angajat = A.id_angajat
AND U.nume = n AND U.prenume = p AND tip = t AND datapr BETWEEN inceput AND final;
end if;
END 
// DELIMITER 
