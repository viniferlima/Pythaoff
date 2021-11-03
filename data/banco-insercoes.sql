CREATE DATABASE pythaoff;
use pythaoff;

CREATE TABLE person 
( 
 id_person INTEGER PRIMARY KEY,  
 name VARCHAR(50),  
 id_permission Integer,  
 email VARCHAR(50),  
); 

CREATE TABLE access 
( 
 id_access INTEGER PRIMARY KEY,  
 time_access DATE,  
 id_person Integer,  
); 

CREATE TABLE permission 
( 
 id_permission INTEGER PRIMARY KEY,  
 type_permission INTEGER,  
); 

CREATE TABLE course 
( 
 id_course INTEGER PRIMARY KEY,  
 name VARCHAR(30),  
 description VARCHAR(60),  
 duration INTEGER,  
); 

CREATE TABLE registration 
( 
 id_registration INTEGER PRIMARY KEY,  
 idperson Integer,  
 idclasses Integer,  
); 

CREATE TABLE grade 
( 
 id_grade INTEGER PRIMARY KEY,  
 grade FLOAT,  
 idregistration Integer,  
); 

CREATE TABLE classes 
( 
 id_class INTEGER PRIMARY KEY,  
 idcourse Integer,  
 name VARCHAR(30),  
 start_date DATE,  
 finish_date DATE,  
); 

ALTER TABLE person ADD FOREIGN KEY(id_permission) REFERENCES permission (id_permission)
ALTER TABLE access ADD FOREIGN KEY(id_person) REFERENCES person (id_person)
ALTER TABLE registration ADD FOREIGN KEY(idperson) REFERENCES person (id_person)
ALTER TABLE registration ADD FOREIGN KEY(idclasses) REFERENCES classes (id_class)
ALTER TABLE grade ADD FOREIGN KEY(idregistration) REFERENCES registration (id_registration)
ALTER TABLE classes ADD FOREIGN KEY(idcourse) REFERENCES course (id_course)

INSERT INTO permission 
VALUES 
	(1, 1),
	(2, 2);

INSERT INTO person
VALUES
  (1,'Francis Townsend',1,'neque.sed@luctuslobortisclass.org'),
  (2,'Wilma Phelps',1,'non.lacinia@diamvel.org'),
  (3,'Joan Garner',1,'mollis.duis.sit@morbisitamet.ca'),
  (4,'Chanda Holloway',1,'in.consequat@musproin.co.uk'),
  (5,'Kyle Tate',1,'sapien.gravida@nisisem.org'),
  (6,'Rose Francis',1,'dolor.fusce.mi@scelerisque.com'),
  (7,'Ivory Glenn',1,'sit.amet@mattisvelit.co.uk'),
  (8,'Ulysses Atkinson',1,'interdum@tristiquepharetra.edu'),
  (9,'Robin Austin',1,'vitae.velit.egestas@aceleifend.net'),
  (10,'Imani Malone',1,'convallis@auctor.org');
INSERT INTO person
VALUES
  (11,'Peter Flowers',2,'elementum.lorem@vitaeodio.com'),
  (12,'Sandra Valdez',2,'euismod.in@nullafacilisi.com'),
  (13,'Montana Bradford',2,'vivamus.nibh.dolor@nibhquisque.org'),
  (14,'Adele Navarro',2,'sagittis.felis.donec@duisuspendisseac.co.uk'),
  (15,'Sawyer Mack',2,'ante.lectus@accumsanlaoreet.co.uk'),
  (16,'Camden Craft',2,'nulla.integer@fuscealiquam.net'),
  (17,'Barry Reilly',2,'est.vitae.sodales@acmattisvelit.edu'),
  (18,'Lillith Malone',2,'et.libero.proin@pedeblandit.net'),
  (19,'Athena Austin',2,'quam.curabitur.vel@nullaintincidunt.com'),
  (20,'Ann White',2,'enim.gravida.sit@donecnibh.net');
INSERT INTO person
VALUES
  (21,'Dana Crawford',1,'amet@lectus.com'),
  (22,'Stacy Chandler',1,'magnis@odio.com'),
  (23,'Kyra Stuart',1,'vitae.dolor@felisullamcorperviverra.edu'),
  (24,'Hilel Ewing',1,'ante.dictum.cursus@viverramaecenasiaculis.co.uk'),
  (25,'Clementine Haynes',1,'felis.ullamcorper@etiamgravida.com'),
  (26,'Rylee Odom',1,'ultricies.adipiscing@commodoauctor.co.uk'),
  (27,'Kasimir Ratliff',1,'facilisis.suspendisse.commodo@afeugiat.net'),
  (28,'Cheryl Payne',1,'elit.erat@integervitae.net'),
  (29,'Lucas Gray',1,'vehicula.risus.nulla@vivamus.edu'),
  (30,'Tiger Rogers',1,'sit.amet.ante@adipiscing.com');
INSERT INTO person
VALUES
  (31,'Reagan Steele',1,'scelerisque.neque@magnased.net'),
  (32,'Oprah Cervantes',1,'nonummy.ipsum@condimentumdonec.org'),
  (33,'Amaya Rose',1,'sagittis@duisemper.edu'),
  (34,'Haley Camacho',1,'lorem.fringilla.ornare@nislnulla.ca'),
  (35,'Emi Lloyd',1,'felis@odiophasellus.edu'),
  (36,'Kiayada Hogan',1,'consequat.purus@maurissapiencursus.ca'),
  (37,'Coby Glass',1,'porttitor.eros@fuscefermentum.edu'),
  (38,'Imogene Lucas',1,'vel@sodales.ca'),
  (39,'Ursa Franks',1,'volutpat.nulla.dignissim@nonvestibulum.ca'),
  (40,'Rhona Hancock',1,'phasellus@at.ca');
INSERT INTO person
VALUES
  (41,'Shay Matthews',1,'hendrerit@orci.net'),
  (42,'Murphy Peterson',1,'vestibulum@semelit.edu'),
  (43,'Octavia Guy',1,'hymenaeos@duisa.com'),
  (44,'Scott Herrera',1,'aliquam.enim.nec@euelit.net'),
  (45,'Ralph Kidd',1,'morbi.sit.amet@doloregestas.com'),
  (46,'Fuller Spears',1,'purus.sapien@netuset.net'),
  (47,'Robin Stephens',1,'adipiscing.elit@morbimetus.org'),
  (48,'Wyatt Meyers',1,'dignissim.magna.a@adipiscingnon.edu'),
  (49,'Macey Patterson',1,'a.auctor@in.net'),
  (50,'Alexandra Bass',1,'odio.phasellus@tellusphasellus.com');
INSERT INTO person
VALUES
  (51,'Mona Bright',1,'urna.nunc@donecvitae.net'),
  (52,'Nigel Alston',1,'in.lorem@fringillapurus.co.uk'),
  (53,'Ulysses Larsen',1,'lacus.etiam@mollis.com'),
  (54,'Cameran Davis',1,'pretium.neque@nonsapien.net'),
  (55,'Lois Horne',1,'eu.lacus@cursusaenim.net'),
  (56,'Lillith Ryan',1,'accumsan.neque@natoquepenatibuset.com'),
  (57,'Harriet Simon',1,'accumsan@nam.org'),
  (58,'Ria Baker',1,'ipsum.suspendisse@egestas.ca'),
  (59,'Walker Wood',1,'enim.mauris.quis@etiam.edu'),
  (60,'Grant Cruz',1,'at.auctor@aliquetmagnaa.co.uk');
INSERT INTO person
VALUES
  (61,'Shaeleigh Randolph',1,'egestas@nullamlobortis.co.uk'),
  (62,'Noelle Webb',1,'metus@rutrumnonhendrerit.edu'),
  (63,'Grace Parks',1,'blandit.at@etrisus.net'),
  (64,'Jordan Combs',1,'consectetuer.euismod@orciin.co.uk'),
  (65,'Kitra Bullock',1,'interdum.ligula@sempereratin.co.uk'),
  (66,'Axel Ramirez',1,'commodo@sit.net'),
  (67,'Chase Shannon',1,'amet.ante.vivamus@arcuvestibulum.co.uk'),
  (68,'Risa Luna',1,'at.velit.cras@justo.org'),
  (69,'Finn Bates',1,'lobortis@non.co.uk'),
  (70,'Minerva Mckinney',1,'duis.cursus.diam@morbimetus.com');
INSERT INTO person
VALUES
  (71,'Hilary Kirkland',1,'justo.praesent.luctus@utquam.ca'),
  (72,'Cameran Sparks',1,'ac.arcu.nunc@turpis.net'),
  (73,'Wendy Ayala',1,'eget@sempercursus.edu'),
  (74,'Meredith Chase',1,'semper.pretium.neque@scelerisqueneque.edu'),
  (75,'Kameko Adkins',1,'natoque@tempor.org'),
  (76,'Victoria Barber',1,'tempus.eu@diamdictum.com'),
  (77,'Carissa Vance',1,'aenean.euismod@aliquamtincidunt.ca'),
  (78,'Calista David',1,'morbi.sit.amet@mauriseuelit.org'),
  (79,'Hasad Sawyer',1,'non.dui@donec.edu'),
  (80,'Sydnee Guzman',1,'at.iaculis@elit.ca');
INSERT INTO person
VALUES
  (81,'Hedwig Hart',1,'in.ornare@rutrummagnacras.net'),
  (82,'Roary Paul',1,'vulputate@lobortisauguescelerisque.edu'),
  (83,'Allistair Frye',1,'vitae@pedenuncsed.ca'),
  (84,'Aristotle Guerra',1,'nulla.aliquet.proin@nectempus.ca'),
  (85,'Aristotle Mullins',1,'at.velit.pellentesque@eutemporerat.com'),
  (86,'Sybill Blake',1,'purus.maecenas@ipsumdolor.com'),
  (87,'Daquan Hester',1,'malesuada.fringilla@fermentumfermentumarcu.ca'),
  (88,'Kaseem Wilder',1,'nullam.scelerisque@metusvitae.ca'),
  (89,'Olivia Fitzpatrick',1,'vulputate.nisi.sem@a.org'),
  (90,'Dante Chandler',1,'venenatis.vel.faucibus@posuerecubiliacurae.com');
INSERT INTO person
VALUES
  (91,'Lesley Jacobs',2,'fringilla.est@lobortisquama.ca'),
  (92,'Austin Fields',2,'proin.sed.turpis@dictum.com'),
  (93,'Amethyst Crawford',2,'quam.a@tristiquepellentesque.edu'),
  (94,'Evangeline Dean',2,'elit.curabitur@arcuac.edu'),
  (95,'Brandon Wallace',2,'rhoncus.nullam@elitnulla.net'),
  (96,'Erin Suarez',2,'aliquet@dictum.net'),
  (97,'Galena Carpenter',2,'accumsan.convallis@sem.net'),
  (98,'Daquan Wilkinson',2,'per.conubia@pharetranibh.co.uk'),
  (99,'Jerome Carey',2,'tincidunt@sociosqu.com'),
  (100,'Brody Hudson',2,'eget@egestasduisac.net');


INSERT INTO access
VALUES
  (1,'2022-10-27 09:30:25',15),
  (2,'2022-07-07 09:47:45',84),
  (3,'2020-12-21 06:17:34',37),
  (4,'2021-10-22 17:35:24',51),
  (5,'2022-05-17 09:15:20',94),
  (6,'2022-06-02 21:49:42',31),
  (7,'2022-02-14 04:11:30',95),
  (8,'2022-06-22 18:22:51',98),
  (9,'2020-12-27 09:50:41',85),
  (10,'2021-04-21 14:44:52',57);
INSERT INTO access
VALUES
  (11,'2021-05-19 22:58:03',81),
  (12,'2021-04-24 00:24:17',48),
  (13,'2022-02-09 04:43:38',39),
  (14,'2022-02-17 11:24:56',67),
  (15,'2022-09-11 00:00:10',62),
  (16,'2021-03-04 00:05:41',57),
  (17,'2021-09-11 06:54:02',61),
  (18,'2022-01-18 21:32:04',25),
  (19,'2021-08-07 11:04:28',72),
  (20,'2021-08-05 22:33:38',7);
INSERT INTO access
VALUES
  (21,'2022-05-26 22:08:08',37),
  (22,'2021-08-11 14:42:47',29),
  (23,'2021-12-08 08:46:04',53),
  (24,'2022-05-25 21:45:09',35),
  (25,'2022-06-10 04:45:47',4),
  (26,'2021-04-06 14:36:05',54),
  (27,'2021-07-01 12:27:41',88),
  (28,'2021-02-01 03:58:28',82),
  (29,'2021-04-17 11:28:41',11),
  (30,'2022-05-03 08:03:19',41);
INSERT INTO access
VALUES
  (31,'2021-11-08 08:41:35',27),
  (32,'2021-10-22 12:59:01',48),
  (33,'2022-07-07 04:27:22',68),
  (34,'2021-05-26 23:37:44',10),
  (35,'2021-04-24 13:38:04',35),
  (36,'2021-10-14 21:29:23',23),
  (37,'2021-05-23 03:04:46',98),
  (38,'2022-03-20 13:03:24',24),
  (39,'2021-07-14 08:54:01',72),
  (40,'2021-08-05 19:39:49',35);
INSERT INTO access
VALUES
  (41,'2021-09-27 17:36:14',68),
  (42,'2022-07-25 09:51:20',12),
  (43,'2021-02-28 18:21:03',93),
  (44,'2021-07-26 12:00:22',48),
  (45,'2022-06-13 08:10:36',76),
  (46,'2021-08-20 02:50:46',18),
  (47,'2022-09-11 22:40:51',1),
  (48,'2021-09-14 19:17:50',49),
  (49,'2021-06-27 02:52:16',69),
  (50,'2022-09-19 09:20:56',15);
INSERT INTO access
VALUES
  (51,'2021-10-31 19:22:54',32),
  (52,'2021-04-04 05:39:59',20),
  (53,'2020-12-15 11:22:31',36),
  (54,'2022-01-18 01:06:29',1),
  (55,'2022-04-15 11:17:33',99),
  (56,'2022-07-22 06:00:00',14),
  (57,'2022-10-01 17:03:11',95),
  (58,'2021-04-20 17:50:30',38),
  (59,'2020-11-25 00:44:58',54),
  (60,'2021-05-17 05:02:56',49);
INSERT INTO access
VALUES
  (61,'2021-12-20 08:02:56',43),
  (62,'2020-12-31 14:24:10',22),
  (63,'2022-06-18 15:48:25',40),
  (64,'2021-04-01 09:17:09',74),
  (65,'2020-11-22 15:53:55',78),
  (66,'2022-05-19 01:25:42',29),
  (67,'2022-02-12 20:02:09',32),
  (68,'2021-03-12 07:51:28',43),
  (69,'2021-11-17 14:42:50',86),
  (70,'2022-09-06 15:42:50',25);
INSERT INTO access
VALUES
  (71,'2021-04-17 16:24:54',60),
  (72,'2021-11-29 16:25:46',7),
  (73,'2021-04-27 22:59:06',31),
  (74,'2022-03-27 04:20:04',32),
  (75,'2022-04-11 05:16:02',54),
  (76,'2021-01-17 00:28:06',66),
  (77,'2021-08-11 23:54:48',37),
  (78,'2021-07-25 18:23:17',71),
  (79,'2021-03-25 13:10:27',79),
  (80,'2022-07-08 18:41:55',67);
INSERT INTO access
VALUES
  (81,'2022-08-19 21:14:41',80),
  (82,'2022-03-02 06:54:02',75),
  (83,'2022-04-11 11:17:09',3),
  (84,'2022-01-20 15:05:53',12),
  (85,'2021-06-01 19:02:18',46),
  (86,'2021-08-29 22:25:08',67),
  (87,'2021-03-31 03:06:01',85),
  (88,'2021-10-07 01:40:39',88),
  (89,'2021-08-10 17:24:46',74),
  (90,'2021-03-22 22:39:59',28);
INSERT INTO access
VALUES
  (91,'2021-08-01 07:15:23',79),
  (92,'2021-06-18 01:14:50',57),
  (93,'2022-08-04 02:53:22',68),
  (94,'2022-08-06 05:13:44',63),
  (95,'2021-04-05 05:35:07',11),
  (96,'2021-04-15 15:15:44',54),
  (97,'2021-11-08 10:27:10',42),
  (98,'2020-11-18 11:19:08',9),
  (99,'2022-07-30 10:54:02',54),
  (100,'2021-03-07 00:35:21',86);


INSERT INTO course
VALUES
  (1,'Urna PC','Cum sociis natoque penatibus et',8),
  (2,'Malesuada Industries','odio tristique pharetra. Quisque ac',1),
  (3,'Ligula Tortor Associates','consectetuer ipsum nunc id enim.',6),
  (4,'Sit Corporation','placerat, augue. Sed molestie. Sed',1),
  (5,'Faucibus Leo Associates','elit sed consequat auctor, nunc',7),
  (6,'Et Ipsum Consulting','Nunc ullamcorper, velit in aliquet',3),
  (7,'Ipsum Cursus Associates','malesuada. Integer id magna et',10),
  (8,'Ac Orci Ut LLP','hendrerit. Donec porttitor tellus non',8),
  (9,'Sodales LLP','lacus. Ut nec urna et',0),
  (10,'Tellus Non Magna Corporation','lorem, eget mollis lectus pede',5);

  
INSERT INTO classes
VALUES
  (1,4,'erat,','2022-09-26 17:23:21','2022-02-04 11:06:05'),
  (2,6,'arcu.','2022-01-09 08:11:58','2021-05-14 17:13:28'),
  (3,1,'justo','2022-03-28 01:19:00','2021-03-18 05:29:52'),
  (4,5,'lacus.','2021-05-09 09:32:01','2021-03-31 02:26:20'),
  (5,6,'elementum,','2021-09-29 10:58:16','2022-03-10 12:28:55'),
  (6,1,'et,','2021-03-09 04:40:02','2022-10-27 22:38:28'),
  (7,4,'Aliquam','2021-05-02 01:03:05','2022-07-17 13:35:56'),
  (8,4,'feugiat','2021-05-03 16:59:56','2020-11-13 13:56:12'),
  (9,1,'Morbi','2021-11-25 20:41:42','2021-10-02 05:01:39'),
  (10,9,'malesuada','2021-01-20 04:53:54','2022-09-13 02:20:54');

  INSERT INTO registration
VALUES
  (1,35,4),
  (2,94,8),
  (3,45,8),
  (4,98,2),
  (5,15,10),
  (6,84,5),
  (7,43,7),
  (8,32,1),
  (9,41,8),
  (10,20,6);
INSERT INTO registration
VALUES
  (11,68,2),
  (12,29,8),
  (13,49,9),
  (14,89,6),
  (15,13,8),
  (16,60,7),
  (17,29,5),
  (18,56,4),
  (19,9,3),
  (20,70,3);
INSERT INTO registration
VALUES
  (21,97,9),
  (22,77,6),
  (23,54,1),
  (24,72,8),
  (25,22,5),
  (26,6,2),
  (27,78,3),
  (28,18,2),
  (29,38,6),
  (30,12,3);
INSERT INTO registration
VALUES
  (31,37,9),
  (32,9,8),
  (33,14,1),
  (34,3,1),
  (35,92,10),
  (36,95,10),
  (37,26,5),
  (38,89,7),
  (39,75,6),
  (40,15,1);
INSERT INTO registration
VALUES
  (41,60,9),
  (42,66,1),
  (43,14,5),
  (44,27,7),
  (45,61,4),
  (46,41,5),
  (47,30,7),
  (48,44,3),
  (49,20,5),
  (50,31,8);
INSERT INTO registration
VALUES
  (51,56,2),
  (52,100,7),
  (53,3,8),
  (54,33,1),
  (55,50,7),
  (56,63,8),
  (57,81,3),
  (58,10,3),
  (59,50,1),
  (60,33,7);
INSERT INTO registration
VALUES
  (61,14,1),
  (62,82,6),
  (63,20,8),
  (64,23,6),
  (65,5,2),
  (66,42,1),
  (67,18,3),
  (68,95,2),
  (69,14,3),
  (70,37,6);
INSERT INTO registration
VALUES
  (71,80,5),
  (72,15,3),
  (73,67,8),
  (74,38,3),
  (75,95,1),
  (76,98,2),
  (77,83,8),
  (78,57,9),
  (79,46,8),
  (80,89,4);
INSERT INTO registration
VALUES
  (81,97,6),
  (82,25,2),
  (83,15,9),
  (84,68,1),
  (85,37,3),
  (86,36,8),
  (87,30,6),
  (88,42,7),
  (89,77,2),
  (90,74,7);
INSERT INTO registration
VALUES
  (91,54,5),
  (92,18,1),
  (93,93,1),
  (94,71,3),
  (95,97,2),
  (96,4,6),
  (97,29,2),
  (98,34,2),
  (99,45,6),
  (100,63,5);

INSERT INTO grade
VALUES
  (1,2.5,23),
  (2,16.5,31),
  (3,4.5,93),
  (4,11.5,5),
  (5,4.5,13),
  (6,11.5,72),
  (7,4.5,1),
  (8,6.5,5),
  (9,11.5,24),
  (10,6.5,60);
