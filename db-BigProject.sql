create database Wanderlust;
use Wanderlust;

create table luoghi
(
	id int primary key auto_increment,
	nome varchar(100)
    
);

create table compagnie
(
	id int primary key auto_increment,
	nome varchar(100),
	supplemento int
);

create table mezzi
(
	id int primary key auto_increment,
	tipo varchar(100),
	prezzoBase double
);


create table trasporti
(
	nome varchar(100) primary key,
	nPosti int,
	idCompagnia int,
	idMezzo int,
	foreign key(idCompagnia) 
    references compagnie (id)
	on update cascade,
	foreign key(idMezzo)
    references mezzi(id)
	on update cascade
);
select * from compagnie;
create table viaggi
(
	id int primary key auto_increment,
	idPartenza int,
	idArrivo int,
	idTrasporto varchar(100),
	oraP datetime,
	oraA datetime,
	prezzo double,
	disponibile boolean,
	cancellato boolean,
	classe int,
	foreign key (idPartenza)
    references luoghi(id)
	on update cascade
	on delete cascade,
	foreign key (idArrivo) 
    references luoghi(id) 
	on update cascade
	on delete cascade,
	foreign key (idTrasporto) 
    references trasporti(nome)
	on update cascade
	on delete cascade
);

create table motivazioni
( 
	idViaggio int,
	motivo varchar(255),
	foreign key (idViaggio)
	 references viaggi(id)

);


create table persone
(
	cf varchar(16) primary key,
	nominativo varchar(100),
	dob date,
	username varchar(100),
	password varchar(12),
	email varchar(100)
);
        
create table biglietti
(
	id int primary Key auto_increment,
	cf varchar(16),
	idViaggio int,
	prezzo double,
	foreign key(cf) 
    references persone(cf)
	on update cascade
	on delete cascade,
	foreign key (idViaggio)
    references viaggi(id)
	on update cascade
	on delete cascade
);



create table operatori
(
	cf varchar(100),
	idCompagnia int,
	sconto int,
	foreign key(cf)
	references persone(cf),
	foreign key(idCompagnia) 
	references compagnie(id)
);

create table log
(
	id int primary key auto_increment,
    data date,
    mex varchar(150)
);


insert into luoghi (nome) values
("Afghanistan"),
("Albania"),
("Algeria"),
("Andorra"),
("Angola "),
("Antigua e Barbuda "),
("Arabia Saudita "),
(" Argentina "),
("Armenia "),
("Australia "),
(" Austria "),
("Azerbaigian"),
("Bahamas"),
("Bahrein"),
("Bangladesh"),
("Barbados"),
("Belgio"),
("Belize"),
("Benin"),
("Bhutan"),
("Bielorussia"),
("Birmania"),
("Bolivia"),
("Bosnia ed Erzegovina"),
("Botswana"),
("Brasile"),
("Brunei"),
("Bulgaria"),
("Burkina Faso"),
("Burundi"),
("Cambogia"),
("Camerun"),
("Canada"),
("Capo Verde"),
("Ciad"),
("Cile"),
("Cina"),
("Cipro"),
("Colombia"),
("Camarine"),
("Corea del Nord"),
("Corea del Sud"),
("Costa d'Avorio"),
("Costa Rica"),
("Croazia"),
("Cuba"),
("Danimarca"),
("Dominica"),
("Ecuador"),
("Egito"),
("El Salvador"),
("Emirati Arabi Uniti"),
("Eritea"),
("Estonia"),
("Etiopia"),
("Figi"),
("Filippine"),
("Finlandia"),
("Francia"),
("Gabon"),
("Gambia"),
("Georgia"),
("Germania"),
("Ghana"),
("Giamaica"),
("Giappone"),
("Gibuti"),
("Giordania"),
("Grecia"),
("Grenada"),
("Guatemala"),
("Guinea"),
("Guinea-Bissau"),
("Guinea Equatoriale"),
("Guyana"),
("Haiti"),
("Honduras"),
("India"),
("Indonesia"),
("Iran"),
("Iraq"),
("Irlanda"),
("Islanda"),
("Isole Marshall"),
("Isole Salomone"),
("Israele"),
("Italia"),
("Kazakistan"),
("Kenya"),
("Kirghizistan"),
("Kiribati"),
("kuwait"),
("Laos"),
("Lesotho"),
("Lettonia"),
("Libano"),
("Liberia"),
("Libia"),
("Liechtenstein"),
("Lituania"),
("Lussemburgo"),
("Macedonia del Nord"),
("Madagascar"),
("Malawi"),
("Malaysia"),
("Maldive"),
("Mali"),
("Malta"),
("Marocco"),
("Mauritania"),
("Mauritius"),
("Messico"),
("Micronesia"),
("Moldavia"),
("Monaco"),
("Mongolia"),
("Montenegro"),
("Mozambico"),
("Namibia"),
("Nauru"),
("Nepal"),
("Nicaragua"),
("Niger"),
("Nigeria"),
("Norvegia"),
("Nuova Zelanda"),
("Oman"),
("Paesi Bassi"),
("Pakistan"),
("Palau"),
("Palestina"),
("Panama"),
("Papua Nuova Guinea"),
("Paraguay"),
("Peru"),
("Polonia"),
("Portogallo"),
("Qatar"),
("Regno Unito"),
("Repubblica Ceca"),
("Repubblica Centrafricana"),
("Repubblica del Congo"),
("Repubblica democratica del Congo"),
("Repubblica Dominicana"),
("Romania"),
("Ruanda"),
("Russia"),
("Saint Kitts e Nevis"),
("Saint Lucia"),
("Saint Vincent e Grenadine"),
("Samoa"),
("San Marino"),
("São Tomé e Príncipe"),
("Senegal"),
("Serbia"),
("Seychelles"),
("Sierra Leone"),
("Singapore"),
("Siria"),
("Slovacchia"),
("Slovenia"),
("Somalia"),
("Spagna"),
("Sri Lanka"),
("Stati Uniti"),
("Sudafrica"),
("Sudan"),
("Sudan del Sud"),
("Suriname"),
("Svezia"),
("Svizzera"),
("eSwatini"),
("Tagikistan"),
("Tanzania"),
("Thailandia"),
("Timor Est"),
("Togo"),
("Tonga"),
("Trinidad e Tobago"),
("Tunisia"),
("Turchia"),
("Turkmenistan"),
("Tuvalu"),
("Ucraina"),
("Uganda"),
("Ungheria"),
("Uruguay"),
("Uzbekistan"),
("Vanuatu"),
("Città del Vaticano"),
("Venezuela"),
("Vietnam"),
("Yemen"),
("Zambia"),
("Zimbabwe"),
("Taiwan"),
("Abcasia "),
("Artsakh"),
("Cipro del Nord"),
("Kosovo"),
("Ossezia del Sud"),
("Sahara Occidentale"),
("Somaliland"),
("Transnistria");

insert into compagnie (nome,supplemento) values
("easyjet",10),
("Raynair",10),
("Air Arabia",15),
("Air Cairo",10),
("Air Canada",20),
("Air Europa",18),
("Air France",15),
("AirDolomiti",80),
("Emirates",60),
("IBERIA",15),
("LATAM Airlines",15),
("Lufthansa",150),
("TAP AirPortugal",30),
("Vueling",10),
("British Airways",40),
("Austrian Airlines",35),
("Aerolineas Argentinas",25),
("Qatar Airways",180),
("Singapore Airlines",50),
("ANA All Nippon Airways",15),
("Japan Airlines",40),
("Cathay Pacific Airways",30),
("EVA AIR",20),
("United Airlines",100),
("American Airlines",100),
("Delta Air Lines",80),
("ZITY", 0),
("Enjoy", 1),
("SHARE NOW", 4.99),
("ATM", 0),
("FlixBus",3.0),
("ItaBus",5.0),
("Italo",10),
("Trenitalia",5.0),
("Trenord",2.0),
("Trainline",5.0),
("MSC cruises",25),
("AZAMARA",30),
("AMADEUS",20),
("Carnival",15),
("Disney Cruise Line", 50);



insert into mezzi(tipo,prezzoBase) values
("Aereo",20.50),
("Treno", 2.0),
("Macchina", 0.19),
("Bus",2.0),
("Nave", 25.0); 


insert into trasporti(nome,nPosti,idCompagnia,idMezzo) values
("Titan",20,1,1), -- compagnia easyjet id=1, mezzo aereo id=1
("Boeing 737-800",189,2,1), -- compagnia boeing id=2, mezzo aereo id=1
("Airbus A321",220,3,1),-- Air Arabia id=3, mezzo id=1
("Airbus A320",180,4,1), -- Air Cairo id=4, mezzo id=1
("Airbus A320-20",180,5,1),-- Air Canada id=5, mezzo id=1
("Boeing 787-8 V.1",274,6,1),-- Air Europa id=6, mezzo id=1
("Airbus A350-900",266,7,1),-- Air France id=7, mezzo id=1
("I-ADJK",120,8,1),-- AirDolomiti id=8, mezzo id=1
("A380",500,9,1),-- Emirates id=9, mezzo id=1
("Airbus 319-100",141,10,1),-- IBERIA id=10, mezzo id=1
("Boeing 787-9 V.3",220,11,1),-- LATAM Airlines
("Airbus A380-800",509,12,1),-- Lufthansa
("Embraer E195",118,13,1),-- TAP AirPortugal
("Airbus A320-200",180,14,1),-- Vueling
("Airbus A321-200",220,15,1),-- British Airways
("Boeing 767",157,16,1),-- Austrian Airlines
("Embraer E190",88,17,1),-- Aerolineas Argentinas
("Airbus A380-80",509,18,1),-- Qatar Airways
("Boeing 777-300 ER",184,19,1),-- Singapore Airlines
("Boeing 737-00",158,20,1),-- ANA All Nippon Airways
("ATR 42-600",48,21,1),-- Japan Airlines
("Airbus A321-00",220,22,1),-- Cathay Pacific Airways
("Boeing 777-30 ER",184,23,1),-- EVA AIR
("Bombardier CRJ200",50,24,1),-- United Airlines
("Airbus A31-200",220,25,1),-- American Airlines
("Boeing 71-200",110,26,1),-- Delta Air Lines
("Dacia Spring", 5, 27,3), -- ZITY 
("Fiat 500", 4, 28, 3), -- Enjoy
("BMW Serie 1", 5, 29, 3),-- SHARE NOW
("M5",50,30,4),-- ATM
("VDL",80,31,4),-- FlixBus idmezzo=4
("MAN",80,32,4),-- ItaBus idmezzo=4
(" Alstom AGV",462,33,2),-- Italo idmezzo=2
("FRECCIAROSSA",520,34,2),-- Trenitalia idmezzo=2
("IC 675",450,35,2),-- Trenord idmezzo=2
("IC 679",400,36,2),-- Trainline idmezzo=2
("MSC EURIBIA",6334,37,5),-- MSC cruises idmezzo=5
("AZAMARA PURSUIT",690,38,5),-- AZAMARA idmezzo=5
("Amadeus Provence",140,39,5),-- AMADEUS idmezzo=5
("Crociera Dream",3646,40,5),-- Carnival
("Crociera Disney Wish",3466,41,5);-- Disney Cruise Line

create table admin
(
	cf varchar(16) primary key,
    codice varchar(10),
	foreign key(cf) 
    references persone(cf)
    on delete cascade 
    on update cascade 
);
 
 

insert into persone values
 ("CLAUDIACARRASCO0","Claudia Carrasco","2000-03-11", "claudia", "claudia12","claudia3@gmail.com"), -- cliente
 ("RITAOLIVEIRA0000","Ritielly Oliveira","1999-01-18", "rita", "ritaoliveira","rita@gmail.com"), -- cliente
 ("NICOLAINGLESE000", "Nicola Inglese", "1995-09-17", "nicola", "nicoinglese", "nicola@gmail.com"), -- admin
 ("SAMUELEBELLANI00", "Samuele Bellani", "1995-02-25", "samuele", "samubellani", "samuele@gmail.com"), -- operatore
 ("DANIELETOSCHES00", "Daniele Tosches", "1995-04-23", "daniele", "danitosches", "daniele@gmail.com"), -- cliente
 ("LEONARDOCRISTIAN", "Leonardo Cristiani", "2002-04-03", "leonardo", "leonardo", "leonardo@gmail.com"), -- cliente
 ("LUCAAGLIARDI0000", "Luca Agliardi", "1989-07-05", "luca", "lucaagliardi", "luca@gmail.com"), -- cliente
 ("DIANALUNGOCI0000", "Diana Lungoci", "2000-12-16", "diana","dianalungoci", "diana@gmail.com"); -- operatore

insert into admin (cf,codice) values
 ("NICOLAINGLESE000", "admin");
 
 
insert into viaggi (idPartenza,idArrivo,idTrasporto,oraP,oraA,prezzo,disponibile,cancellato,classe) values
(87, 135, "Titan", '2023-07-05 05:15:00', '2023-07-05 19:45:00', 530, true, true, 2 ), 
(66, 87, "Embraer E190", '2023-01-05 11:55:00', '2023-01-05 23:10:00', 470, true, false, 2 ), 
(87, 69, "MSC EURIBIA", '2023-08-30 15:30:00', '2023-08-30 20:20:00', 890, true, false, 2 ), 
(87, 115, "VDL", '2023-09-01 05:15:00', '2023-09-01 14:10:00', 180, true, false, 2 ), 
(87, 181, "AIRBUS A321", '2023-06-05 18:00:00', '2023-06-05 22:45:00', 210, true, true, 2 );

insert into motivazioni values
(1, "Condizioni climatiche"),
(5, "Ritardo");

select * from compagnie;