INSERT INTO angajat VALUES 
(1,'medic rezident ',4500,8),
(2,'medic specialist',5500,8),
(3,'medic generalist',6000,8),
(4,'medic primar',4000,8),
(5,'asistent interdependent',3000,8),
(6,'asistent dependent',2800,8),

(7,'medic rezident',4600,8),
(8,'administrator sef',6500,8),
(9,'asistent interdependent',3400,8),
(10,'asistent dependent',2700,6),
(11,'asitent administrator resurse',3900,4),

(12,'superadministrator policlinica',4500,4),
(13,'asistent administrator ',2650,4),
(14,'administrator economic',3500,8),
(15,'receptioner sef',3000,8),
(16,'receptioner zi',2700,8),
(17,'receptioner noapte',2900,8),
(18,' asistent resurse',3300,6);

INSERT INTO utilizatori VALUES
(1,'medic','medic1',54287,'Ionescu','Matei','Suceava','078513546','dr_Ionescu@yahoo.ro','36598',1,'2007-4-8','medic','medic','DA',1),
(2,'medic','medic2',94218,'Apostol','Maria','Oradea','078513547','dr_Apostol@yahoo.ro','36578',2,'2010-3-8','medic','medic','DA',2),
(3,'medic','medic3',26384,'Iorga','Antonio','Brasov','078513548','dr_Iorga@yahoo.ro','45298',3,'2020-4-9','medic','medic','NU',3),
(4,'medic','medic4',17021,'Vasilescu','Ioana','Cluj','078513549','dr_Popa@yahoo.ro','30472',4,'2015-12-12','medic','medic','DA',4),
(5,'asistent','asis5',30258,'Toma','Stefan','Suceava','0746201234','asis_Toma@yahoo.ro','36758',5,'2007-10-11','asistent','asistent','DA',5),
(6,'asistent','asis6',54214,'Miron','Vasile','Oradea','0744698195','asis_Miron@yahoo.ro','37631',6,'2020-10-11','asistent','asistent','NU',6),
(7,'medic','medic7',16345,'Ivascu','Andreea','Oradea','0745632486','IvascuAndreea@gmail.ro','65412',7,'2010-4-18','medic','medic','NU',7),
(8,'admin','medic8',27453,'Mitrache','Antonia','Cluj','0772653184','MitracheAntonia@gmail.ro','45552',8,'2009-12-3','admin','admin','DA',8),
(9,'asistent','asis9',23156,'Tudosie','Raul','Brasov','0732551222','TudosieRaul@yahoo.ro','32185',9,'2015-7-10','asistent','asistent','DA',9),
(10,'asistent','asis10',10517,'Iorgulescu','Alexandra','Cluj','0755123676','IorgulescuAlexandra@yahoo.ro','40563',10,'2010-6-25','asistent','asistent','DA',10),
(11,'resurse','resurse11',11103,'Matei','Adriana','Cluj','0724523233','MateiAdriana@gmail.ro','59770',11,'2009-2-20','resurse','resurse','NU',11),
(12,'superadmin','superadm12',16598,'Popescu','Cristi','Cluj','0745232730','Popescu.Cristi@gmail.ro','23612',12,'2014-4-12','superadmin','superadmin','DA',12),
(13,'admin','adm13',21371,'Andronache','Tudor','Suceava','0723232996','Andronache.Tudor@gmail.ro','32934',13,'2016-5-12','admin','admin','NU',13),
(14,'economic','eco14',23754,'Candor','Vasile','Suceava','0745232733','Candor.VasileR@gmail.ro','96123',14,'2013-2-19','economic','economic','NU',14),
(15,'receptioner','rece15',73016,'Dragomirescu','Mircea','Oradea','0743423576','Dragomirescu.Mircea@gmail.ro','56196',15,'2017-8-12','receptioner','receptioner','NU',15),
(16,'receptioner','rece16',11267,'Tomas','Ion','Brasov','0745277170','Tomas.Ion@gmail.ro','42834',16,'2013-4-12','receptioner','receptioner','DA',16),
(17,'receptioner','rece17',12246,'Ivan','Dragos','Suceava','0745232831','Ivan.Dragos@gmail.ro','45342',17,'2012-6-13','receptioner','receptioner','NU',17),
(18,'resurse','resurse18',34556,'Naum','Ionela','Cluj','0765232693','Naum.Ionela@gmail.ro','97462',18,'2018-5-15','resurse','resurse','NU',18);

INSERT INTO medic VALUES
(1,'radiologie','specialist',345,'chirurgie','DA','profesor',70.0,1),
(2,'neurologie','specialist',421,'explorare CT','DA','conferentiar',50.0,2),
(3,'pediatrie','specialist',756,'oncologie pediatrica','DA','profesor',60.0,3),
(4,'ortopedie','specialist',680,'chirurgie','DA','conferentiar',85.5,4),
(7,'cardiologie','specialist',612,'chirurgie','DA','profesor',81.0,7); 

INSERT INTO asistent_medical VALUES 
(5,'generalist','principal',5,1),
(7,'generalist','secundar',7,2),
(9,'laborator','principal',9,7),
(10,'laborator','secundar',10,7);

INSERT INTO pacienti VALUES

 (21,NULL,NULL,'Chiajna','Valentin','1970-02-05','m','Suceava','romana','DA'),
 (22,NULL,NULL,'Radulescu','Antonio','1963-09-18','m','Brasov','romana','DA'),
 (23,NULL,NULL,'Condor','Ana','2000-12-05','f','Oradea','romana','DA'),
 (24,NULL,NULL,'Bernulli','Andreea','1999-02-10','f','Oradea','italiana','NU'),
(25,NULL,NULL,'Darpes','Cosmina','1977-5-12','f','Brasov','romana','DA'),  
(26,NULL,NULL,'Starmina','Mario','1980-9-17','m','Suceava','romana','NU'),
(27,NULL,NULL,'Costescu','Antonia','1957-08-20','f','Cluj','romana','DA'),
(28,'alergii de tipul 1','insuficienta cardiaca','Antonio','Cosmin','2002-7-13','m','Brasov','romana','DA'),  
(29,'alergii de tipul 2','Roseata si edem','Sortescu','Ion','1998-9-17','m','Cluj','romana','NU'),
(30,'alergii alimentare','hipertensiune arteriala','Mircea','Maria','2003-10-20','f','Cluj','romana','DA');


INSERT INTO unitati_medicale VALUES -- Ioana
(1,'UnitSUCEAVA','Suceava'),
(2,'UnitCLUJ','Cluj'),
(3,'UnitORADEA','Oradea'),
(4,'UnitBRASOV','Brasov');

INSERT INTO program VALUES 
(1,'2021-01-01',8,22,1), -- unit 1
(2,'2021-02-01',8,22,1), 
(3,'2021-03-01',8,22,1), 
(4,'2021-04-01',8,22,1), 
(5,'2021-05-01',8,22,1), 
(6,'2021-06-01',8,22,1), 
(7,'2021-07-01',8,22,1), 
(8,'2021-08-01',9,22,1), 
(9,'2021-09-01',9,22,1), 
(10,'2021-01-02',8,22,1), 
(11,'2021-01-03',8,22,1), 
(12,'2021-01-04',8,22,1), 
(13,'2021-01-05',8,22,1), 
(14,'2021-01-06',8,22,1), 
(15,'2021-01-07',8,22,1), 
(16,'2021-01-08',8,22,1), 
(17,'2021-01-09',8,22,1), 
(18,'2021-01-10',8,22,1), 
(19,'2021-01-11',8,22,1), 
(20,'2021-01-12',8,22,1), 
(21,'2021-01-13',8,22,1), 
(22,'2021-01-14',8,22,1), 
(23,'2021-01-15',8,22,1), 
(24,'2021-01-16',8,22,1), 
(25,'2021-01-17',8,22,1), 
 (26,'2021-01-18',8,22,1), 
 (27,'2021-01-19',8,22,1), 
 (28,'2021-01-20',8,22,1), 
 (29,'2021-01-21',8,22,1), 
 (30,'2021-01-22',8,22,1), 
 (31,'2021-01-23',8,22,1), 
 
(32,'2021-01-23',8,16,2), -- unit 2
(33,'2021-02-23',8,16,2),
(34,'2021-03-23',8,16,2),
(35,'2021-04-23',8,16,2),
(36,'2021-05-23',8,16,2),
(37,'2021-06-23',8,16,2),
(38,'2021-07-23',8,16,2),
(39,'2021-08-23',8,16,2),
(40,'2021-09-23',8,16,2),
(41,'2021-01-24',8,16,2),
(42,'2021-01-25',8,16,2),
(43,'2021-01-26',8,16,2),
(44,'2021-01-27',8,16,2),
(45,'2021-01-28',8,16,2),
(46,'2021-01-29',8,16,2),
(47,'2021-05-22',8,16,2), 
(48,'2021-05-23',8,16,2),
(49,'2021-05-24',8,16,2),
(50,'2021-05-25',8,16,2),
(51,'2021-05-26',8,16,2),
(52,'2021-05-27',8,16,2),
(53,'2021-05-28',8,16,2),
(54,'2021-05-29',8,16,2),
(55,'2021-05-30',8,16,2),
(56,'2021-06-01',8,16,2),
(57,'2021-06-02',8,16,2),
(58,'2021-06-03',8,16,2),
(59,'2021-06-04',8,16,2),
(60,'2021-06-05',8,16,2),
(61,'2021-06-06',8,16,2),
(62,'2021-06-07',8,16,2),

(63,'2021-06-08',9,17,3), -- unit 3
(64,'2021-06-09',9,17,3),
(65,'2021-06-10',9,17,3),
(66,'2021-06-11',9,17,3),
(67,'2021-06-12',9,17,3),
(68,'2021-06-14',9,17,3),
(69,'2021-06-15',9,17,3),
(70,'2021-06-13',9,17,3),
(71,'2021-06-16',9,17,3),
(72,'2021-06-17',9,17,3),
(73,'2021-06-18',9,17,3),
(74,'2021-06-19',9,17,3),
(75,'2021-06-21',9,17,3),
(76,'2021-06-22',9,17,3),
 (77,'2021-06-23',10,15,3), 
 (78,'2021-06-24',10,15,3),
 (79,'2021-06-25',10,15,3),
 (80,'2021-06-26',10,15,3),
 (81,'2021-06-27',14,22,3),
 (82,'2021-06-28',14,22,3),
 (83,'2021-07-01',10,15,3),
 (84,'2021-07-02',9,15,3),
 (85,'2021-07-03',9,15,3),
 (86,'2021-07-04',10,15,3),
 (87,'2021-07-05',10,15,3),
 (88,'2021-07-06',14,22,3),
 (89,'2021-07-07',14,22,3),
 (90,'2021-07-08',14,22,3),
 (91,'2021-07-09',10,15,3),
 (92,'2021-07-10',10,23,3), 
 (93,'2021-07-11',10,23,3);

INSERT INTO programangajati VALUES
(1,1,'2021-01-01',null,null,1,1), -- medic 1
(2,1,'2021-01-02',8,16,1,0), 
(3,1,'2021-01-03',8,16,1,0), 
(4,1,'2021-01-04',8,16,1,0), 
(5,1,'2021-01-04',18,22,1,0),
(6,1,'2021-01-05',8,16,1,0),
(7,1,'2021-01-06',8,16,1,0),
(8,1,'2021-01-07',8,16,1,0),
(9,1,'2021-01-08',8,16,1,0),
(10,1,'2021-01-09',8,16,1,0),
(11,1,'2021-01-10',8,16,1,0),
(12,1,'2021-01-11',8,16,1,0),
(13,1,'2021-01-12',8,16,1,1),
(14,1,'2021-01-13',8,16,1,1),
(15,1,'2021-01-14',8,16,1,0),
(16,1,'2021-01-15',8,16,1,0),

(17,2,'2021-01-01',8,16,2,0), -- medic 2
(18,2,'2021-01-02',8,16,2,1),
(19,2,'2021-01-03',8,16,2,0),
(20,2,'2021-01-04',8,16,2,0),
(21,2,'2021-01-05',8,16,2,0),
(22,2,'2021-01-06',8,16,2,0),
(23,2,'2021-01-07',8,16,2,0),
(24,2,'2021-01-08',8,16,2,0),
(25,2,'2021-01-09',8,16,2,1),
(26,2,'2021-01-10',8,16,2,0),
(27,2,'2021-01-11',8,16,2,0),
(28,2,'2021-01-12',8,16,2,0),
(29,2,'2021-01-13',8,16,2,0),
(30,2,'2021-01-14',8,16,2,0),
(31,2,'2021-01-15',8,16,2,0),

(32,5,'2021-01-01',8,16,2,0), -- asistent 5
(33,5,'2021-01-02',8,16,2,0),
(34,5,'2021-01-03',8,16,2,0),
(35,5,'2021-01-04',8,16,2,0),
(36,5,'2021-01-05',8,16,2,0),
(37,5,'2021-01-06',8,16,2,1),
(38,5,'2021-01-07',8,16,2,0),
(39,5,'2021-01-08',8,16,2,0),
(40,5,'2021-01-09',8,16,2,1),
(41,5,'2021-01-10',8,16,2,0),
(42,5,'2021-01-11',8,16,2,0),
(43,5,'2021-01-12',8,16,2,0),
(44,5,'2021-01-13',8,16,2,1),
(45,5,'2021-01-14',8,16,2,0),
(46,5,'2021-01-15',8,16,2,0),

(47,7,'2021-01-01',8,16,1,0), -- asistent 7
(48,7,'2021-01-02',8,16,1,0),
(49,7,'2021-01-03',8,16,1,0),
(50,7,'2021-01-04',8,16,1,0),
(51,7,'2021-01-05',8,16,1,0),
(52,7,'2021-01-06',8,16,1,0),
(53,7,'2021-01-07',8,16,1,0),
(54,7,'2021-01-08',8,16,1,1),
(55,7,'2021-01-09',8,16,1,0),
(56,7,'2021-01-10',8,16,1,0),
(57,7,'2021-01-11',8,16,1,0),
(58,7,'2021-01-12',8,16,1,0),
(59,7,'2021-01-13',8,16,1,0),
(60,7,'2021-01-14',8,16,1,0),
(61,7,'2021-01-15',8,16,1,0),

(62,3,'2021-01-01',9,17,3,0), -- medic 3
(63,3,'2021-01-02',9,17,3,0),
(64,3,'2021-01-03',9,17,3,0),
(65,3,'2021-01-04',9,17,3,0),
(66,3,'2021-01-05',9,17,3,0),
(67,3,'2021-01-06',9,17,3,0),
(68,3,'2021-01-07',9,17,3,0),
(69,3,'2021-01-08',9,17,3,0),
(70,3,'2021-01-09',9,17,3,0),
(71,3,'2021-01-10',9,17,3,0),
(72,3,'2021-01-11',9,17,3,0),
(73,3,'2021-01-12',9,17,3,0),
(74,3,'2021-01-13',9,17,3,0),
(75,3,'2021-01-14',9,17,3,0),
(76,3,'2021-01-15',9,17,3,0),

 (77,4,'2021-01-01',10,15,4,0), -- medic 4
 (78,4,'2021-01-02',10,15,4,0),
 (79,4,'2021-01-03',10,15,4,0),
 (80,4,'2021-01-04',10,15,4,0),
 (81,4,'2021-01-05',14,22,4,0),
 (82,4,'2021-01-06',14,22,4,0),
 (83,4,'2021-01-07',10,15,4,0),
 (84,4,'2021-01-08',null,15,4,1),
 (85,4,'2021-01-09',null,15,4,1),
 (86,4,'2021-01-10',10,15,4,0),
 (87,4,'2021-01-11',10,15,4,0),
 (88,4,'2021-01-12',14,22,4,0),
 (89,4,'2021-01-13',14,22,4,0),
 (90,4,'2021-01-14',14,22,4,0),
 (91,4,'2021-01-15',10,15,4,0),
 
 (92,7,'2021-01-01',null,null,1,1), -- medic 7
 (93,7,'2021-01-02',null,null,1,1),
 (94,7,'2021-01-03',12,18,1,0),
 (95,7,'2021-01-04',12,18,1,0),
 (96,7,'2021-01-05',12,18,1,0),
 (97,7,'2021-01-06',12,18,1,0),
 (98,7,'2021-01-07',12,18,1,0),
 (99,7,'2021-01-08',12,18,1,0),
 (100,7,'2021-01-09',12,18,1,0),
 (101,7,'2021-01-10',12,18,1,0),
 (102,7,'2021-01-11',12,18,1,0),
 (103,7,'2021-01-12',12,18,1,0),
 (104,7,'2021-01-13',12,18,1,1),
 (105,7,'2021-01-14',12,18,1,0),
 (106,7,'2021-01-15',12,18,1,0),
 
 (107,8,'2021-01-01',9,17,2,1), -- admin 8
 (108,8,'2021-01-02',9,17,2,0),
 (109,8,'2021-01-03',9,17,2,0),
 (110,8,'2021-01-04',9,17,2,0),
 (111,8,'2021-01-05',9,17,2,1),
 (112,8,'2021-01-06',9,17,2,0),
 (113,8,'2021-01-07',9,17,2,0),
 (114,8,'2021-01-08',9,17,2,0),
 (115,8,'2021-01-09',9,17,2,0),
 (116,8,'2021-01-10',9,17,2,0),
 (117,8,'2021-01-11',9,17,2,0),
 (118,8,'2021-01-12',9,17,2,0),
 (119,8,'2021-01-13',9,17,2,1),
 (120,8,'2021-01-14',9,17,2,0),
 (121,8,'2021-01-15',9,17,2,0),
 
 (122,9,'2021-01-01',9,17,1,0), -- asistent 9
 (123,9,'2021-01-02',9,17,1,0),
 (124,9,'2021-01-03',9,17,1,0), 
 (125,9,'2021-01-04',9,17,1,0),
 (126,9,'2021-01-05',9,17,1,1),
 (127,9,'2021-01-06',9,17,1,0),
 (128,9,'2021-01-07',9,17,1,0),
 (129,9,'2021-01-08',9,17,1,0),
 (130,9,'2021-01-09',9,17,1,0),
 (131,9,'2021-01-10',9,17,1,0),
 (132,9,'2021-01-11',9,17,1,0),
 (133,9,'2021-01-12',9,17,1,0),
 (134,9,'2021-01-13',9,17,1,0),
 (135,9,'2021-01-14',9,17,1,0),
 (136,9,'2021-01-15',9,17,1,0),
 
 (137,10,'2021-01-01',12,18,1,0), -- asistent 10
 (138,10,'2021-01-02',12,18,1,1),
 (139,10,'2021-01-03',12,18,1,0),
 (140,10,'2021-01-04',12,18,1,0),
 (141,10,'2021-01-05',12,18,1,0),
 (142,10,'2021-01-06',12,18,1,0),
 (143,10,'2021-01-07',12,18,1,0),
 (144,10,'2021-01-08',12,18,1,1),
 (145,10,'2021-01-09',12,18,1,0),
 (146,10,'2021-01-10',12,18,1,0),
 (147,10,'2021-01-11',12,18,1,0),
 (148,10,'2021-01-12',12,18,1,0),
 (149,10,'2021-01-13',12,18,1,0),
 (150,10,'2021-01-14',12,18,1,0),
 (151,10,'2021-01-15',12,18,1,1),
 
 (152,11,'2021-01-01',8,12,3,0), -- resurse 11 inspector
 (153,11,'2021-01-02',8,12,3,0),
 (154,11,'2021-01-03',8,12,3,0),
 (155,11,'2021-01-04',8,12,3,0),
 (156,11,'2021-01-05',8,12,3,0),
 (157,11,'2021-01-06',8,12,3,0),
 (158,11,'2021-01-07',8,12,3,1),
 (159,11,'2021-01-08',8,12,3,0),
 (160,11,'2021-01-09',8,12,3,0),
 (161,11,'2021-01-10',8,12,3,0),
 (162,11,'2021-01-11',8,12,3,1),
 (163,11,'2021-01-12',8,12,3,0),
 (164,11,'2021-01-13',8,12,3,0),
 (165,11,'2021-01-14',8,12,3,0),
 (166,11,'2021-01-15',8,12,3,0),
 
 (167,12,'2021-01-01',10,14,4,0), -- super admin 12
 (168,12,'2021-01-02',10,14,4,1),
 (169,12,'2021-01-03',10,14,4,0),
 (170,12,'2021-01-04',10,14,4,0),
 (171,12,'2021-01-05',10,14,4,0),
 (172,12,'2021-01-06',10,14,4,0),
 (173,12,'2021-01-07',10,14,4,0),
 (174,12,'2021-01-08',10,14,4,0),
 (175,12,'2021-01-09',10,14,4,0),
 (176,12,'2021-01-10',10,14,4,1),
 (177,12,'2021-01-11',10,14,4,0),
 (178,12,'2021-01-12',10,14,4,0),
 (179,12,'2021-01-13',10,14,4,0),
 (180,12,'2021-01-14',10,14,4,0),
 (181,12,'2021-01-15',10,14,4,0),
 
 (182,13,'2021-01-01',10,16,3,0), -- admin 13
 (183,13,'2021-01-02',12,16,3,1),
 (184,13,'2021-01-03',12,16,3,0),
 (185,13,'2021-01-04',12,16,3,0),
 (186,13,'2021-01-05',12,16,3,0),
 (187,13,'2021-01-06',12,16,3,0),
 (188,13,'2021-01-07',12,16,3,0),
 (189,13,'2021-01-08',12,16,3,0),
 (190,13,'2021-01-09',12,16,3,0),
 (191,13,'2021-01-10',12,16,3,0),
 (192,13,'2021-01-11',12,16,3,0),
 (193,13,'2021-01-12',12,16,3,0),
 (194,13,'2021-01-13',12,16,3,0),
 (195,13,'2021-01-14',12,16,3,0),
 (196,13,'2021-01-15',12,16,3,0),
 
 (197,14,'2021-01-01',11,17,1,0), -- economic 14
 (198,14,'2021-01-02',11,17,1,0),
 (199,14,'2021-01-03',11,17,1,0),
 (200,14,'2021-01-04',11,17,1,0),
 (201,14,'2021-01-05',11,17,1,0),
 (202,14,'2021-01-06',11,17,1,0),
 (203,14,'2021-01-07',11,17,1,0),
 (204,14,'2021-01-08',11,17,1,0),
 (205,14,'2021-01-09',11,17,1,0),
 (206,14,'2021-01-10',11,17,1,0),
 (207,14,'2021-01-11',11,17,1,0),
 (208,14,'2021-01-12',11,17,1,0),
 (209,14,'2021-01-13',11,17,1,0),
 (210,14,'2021-01-14',11,17,1,0),
 (211,14,'2021-01-15',11,17,1,0),

 (212,15,'2021-01-01',08,16,2,0), -- receptioner 15
 (213,15,'2021-01-02',08,16,2,0),
 (214,15,'2021-01-03',08,16,2,0),
 (215,15,'2021-01-04',08,16,2,0),
 (216,15,'2021-01-05',08,16,2,0),
 (217,15,'2021-01-06',08,16,2,0),
 (218,15,'2021-01-07',08,16,2,0),
 (219,15,'2021-01-08',08,16,2,0),
 (220,15,'2021-01-09',08,16,2,0),
 (221,15,'2021-01-10',08,16,2,0),
 (222,15,'2021-01-11',08,16,2,0),
 (223,15,'2021-01-12',08,16,2,0),
 (224,15,'2021-01-13',08,16,2,0),
 (225,15,'2021-01-14',08,16,2,0),
 (226,15,'2021-01-15',08,16,2,0),
 
 (227,16,'2021-01-01',10,18,3,0), -- receptioner 16
 (228,16,'2021-01-02',10,18,3,0),
 (229,16,'2021-01-03',10,18,3,0),
 (230,16,'2021-01-04',10,18,3,0),
 (231,16,'2021-01-05',10,18,3,0),
 (232,16,'2021-01-06',10,18,3,0),
 (233,16,'2021-01-07',10,18,3,0),
 (234,16,'2021-01-08',10,18,3,0),
 (235,16,'2021-01-09',10,18,3,0),
 (236,16,'2021-01-10',10,18,3,0),
 (237,16,'2021-01-11',10,18,3,0),
 (238,16,'2021-01-12',10,18,3,0),
 (239,16,'2021-01-13',10,18,3,0),
 (240,16,'2021-01-14',10,18,3,0),
 (241,16,'2021-01-15',10,18,3,0),
 
 (242,17,'2021-01-01',11,19,4,0), -- receptioner 17 
 (243,17,'2021-01-02',11,19,4,0),
 (244,17,'2021-01-03',11,19,4,0),
 (245,17,'2021-01-04',11,19,4,0),
 (246,17,'2021-01-05',11,19,4,0),
 (247,17,'2021-01-06',11,19,4,0),
 (248,17,'2021-01-07',11,19,4,0),
 (249,17,'2021-01-08',11,19,4,0),
 (250,17,'2021-01-09',11,19,4,0),
 (251,17,'2021-01-10',11,19,4,0),
 (252,17,'2021-01-11',11,19,4,0),
 (253,17,'2021-01-12',11,19,4,0),
 (254,17,'2021-01-13',11,19,4,0),
 (255,17,'2021-01-14',11,19,4,0),
 (256,17,'2021-01-15',11,19,4,0),
 
 
 (257,18,'2021-01-01',14,20,1,0), -- resurse 18
 (258,18,'2021-01-02',14,20,1,0),
 (259,18,'2021-01-03',14,20,1,0),
 (260,18,'2021-01-04',14,20,1,0),
 (261,18,'2021-01-05',14,20,1,0),
 (262,18,'2021-01-06',14,20,1,0),
 (263,18,'2021-01-07',14,20,1,0),
 (264,18,'2021-01-08',14,20,1,0),
 (265,18,'2021-01-09',14,20,1,0),
 (266,18,'2021-01-10',14,20,1,0),
 (267,18,'2021-01-11',14,20,1,0),
 (268,18,'2021-01-12',14,20,1,0),
 (269,18,'2021-01-13',14,20,1,0),
 (270,18,'2021-01-14',14,20,1,0),
 (271,18,'2021-01-15',14,20,1,0);

INSERT INTO servicii VALUES
 (1,'cardiologie','specialist',100,60,'ecograf'), 
 (2,'cardiologie','specialist',200,60,'holter'),
 (3,'neurologie','specialist',100,60,'CT'),
 (4,'pediatrie','specialist',100,60,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (5,'ortopedie','specialist',100,60,'punere ghips');

INSERT INTO cabinete  VALUES 
 (1,1,1, 'ecograf'), 
 (2,2,2,'ecograf'),
 (3,1,3,'ecograf,holter'),
 (4,3,4,'ecograf'),
 (5,4,7,'ecograf'),
 (6,1,1,'holter'), 
 (7,1,2,'CT'),
 (8,1,3,'punere ghips'),
  (9,2,4,'holter'), 
 (10,2,7,'CT'),
 (11,2,1,'punere ghips'),
  (12,3,2,'holter'), 
 (13,3,3,'CT'),
 (14,3,4,'punere ghips'),
  (15,4,7,'holter'), 
 (16,4,1,'CT'),
 (17,1,2,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (18,2,3,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (19,3,4,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (20,4,7,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru');
INSERT INTO programari VALUES 
(1,21, 1,0,0,8,9,'2021-12-12',1,1,1),
(2,22, 2,0,0,8,10,'2022-12-13',2,2,2),
(3,25, 5,0,0,9,10,'2021-12-14',3,4,4),
(4,28, 4,0,0,11,12,'2021-12-15',4,5,7),
(5,22, 2,0,0,8,9,'2021-12-16',1,1,1),
(6,24, 3,0,0,8,9,'2021-12-17',2,2,2),
(7,23, 2,0,0,8,9,'2021-12-18',3,4,4),
(8,29, 1,0,0,8,9,'2021-12-19',4,5,7),

(9,21, 1,0,0,8,9,'2021-11-12',1,1,1),
(10,22, 2,0,0,8,10,'2022-10-13',2,2,2),
(11,25, 5,0,0,9,10,'2021-09-14',3,4,4),
(12,28, 4,0,0,11,12,'2021-08-15',4,5,7),
(13,22, 2,0,0,8,9,'2021-07-16',1,1,1),
(14,24, 3,0,0,8,9,'2021-06-17',2,2,2),
(15,23, 2,0,0,8,9,'2021-05-18',3,4,4),
(16,29, 1,0,0,8,9,'2021-04-19',4,5,7);

INSERT INTO istoricbonuri VALUES 
(1,1,100), 
(2,2,200),
(3,3,300),
(4,4,100),
(5,5,100),
(6,6,200),
(7,7,300),
(8,8,100), 
(9,9,200),
(10,10,300),
(11,11,100),
(12,12,100),
(13,13,200),
(14,14,300),
(15,15,500),
(16,16,500);

INSERT INTO istoric_salariu VALUES
(1,1,'2007-04-08',3000), (2,1,'2010-04-08',3500), (3,1,'2015-04-08',4250),(4,1,'2020-04-08',5000),
(5,5,'2007-10-11',1500), (6,5,'2014-10-11',3000), (7,5,'2020-10-11',4000),
(8,10,'2010-06-25',2500),
(9,12,'2014-04-12',2500),
(10,13,'2016-05-12',2000),
(11,14,'2013-02-19',3000),
(12,6,'2020-10-11',3500),
(13,15,'2017-08-12',2500),
(14,9,'2015-07-10',3800),
(15,16,'2013-04-12',2500),
(16,17,'2012-06-13',2500),
(17,3,'2020-04-09',1000),
(18,4,'2015-12-12',8000),
(19,11,'2009-02-20',3850),
(20,18,'2018-05-15',3500),
(21,2,'2010-03-08',6000),
(22,8,'2009-12-03',7200),
(23,7,'2018-11-01',5060);

/*INSERT INTO raport_medical VALUES 
(1,1,'programare holter- anemii?','anemie','concord'),
(2,2,'perfect sanatos','nu sunt','odihna, fara stres'),
(3,3,'se continua medicamentatia medicamentatie','nu sunt','concord'),
(4,4,'raceala','nu sunt','nurofen raceala si gripa + teraflu'),
(5,5,'revenire la control peste o luna','nu sunt','paduden(daca exist dureri)'),
(6,6,'totul a decors bine','nu sunt', 'nu sunt'), 
(7,7,'totul a decors bine','nu sunt', 'nu sunt'),
(8,8,'totul a decors bine','nu sunt', 'se recomanda sa stea o saptamana fara sa faca prea mult efort, iar dupa sa inceapa sa faca in fiecare zi miscare');*/

INSERT INTO raport_medical VALUES 
(1,1,'programare holter- anemii?','anemie','consult','bla','mancat mai sanatos',1),
(2,2,'programare holter- roseata?','roseata','consult','bla','mancat mai sanatos',2),
(3,3,'programare holter- insuficienta cardiaca?','insuficienta cardiaca','consult','bla','mancat mai sanatos',3),
(4,4,'programare holter- hipertensiune?','hipertensiune','consult','bla','mancat mai sanatos',4),
(5,5,'programare holter- anemii?','anemie','consult','bla','mancat mai sanatos',5),
(6,6,'programare holter- roseata?','roseata','consult','bla','mancat mai sanatos',6),
(7,7,'programare holter- insuficienta cardiaca?','insuficienta cardiaca','consult','bla','mancat mai sanatos',7),
(8,8,'programare holter- hipertensiune?','hipertensiune','consult','bla','mancat mai sanatos',8),
(9,9,'programare holter- anemii?','anemie','consult','bla','mancat mai sanatos',1),
(10,10,'programare holter- roseata?','roseata','consult','bla','mancat mai sanatos',2),
(11,11,'programare holter- insuficienta cardiaca?','insuficienta cardiaca','consult','bla','mancat mai sanatos',3),
(12,12,'programare holter- hipertensiune?','hipertensiune','consult','bla','mancat mai sanatos',4),
(13,13,'programare holter- anemii?','anemie','consult','bla','mancat mai sanatos',5),
(14,14,'programare holter- roseata?','roseata','consult','bla','mancat mai sanatos',6),
(15,15,'programare holter- insuficienta cardiaca?','insuficienta cardiaca','consult','bla','mancat mai sanatos',7),
(16,16,'programare holter- hipertensiune?','hipertensiune','consult','bla','mancat mai sanatos',8);

