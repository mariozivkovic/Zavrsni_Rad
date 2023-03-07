drop database if exists otpremnastanica;
create database otpremnastanica default charset utf8;
use otpremnastanica;

create table zaposlenik(
    sifra int not null primary key auto_increment,
    ime varchar(59)not null,
    prezime varchar(50)not null,
    oib char(11),
    email varchar(50)not null,
    radnomjesto varchar(50) not null

);

create table odrzavanje(
   sifra int not null primary key auto_increment,
    datum datetime,
    zaposlenik int not null 
);

create table posao(
sifra int not null primary key auto_increment,
naziv varchar(100) not null
);

create table naftno_polje(
    sifra int not null primary key auto_increment,
    naziv varchar(50) not null
    
);


create table busotina(
    sifra int not null primary key auto_increment,
    naziv varchar(20) not null,
    aktivna boolean not null,
    naftno_polje_sifra int  not null
);


create table odrzavanje_posao_busotina(
    sifra int not null primary key auto_increment,
    odrzavanje_sifra int not null,
    posao_sifra int not null,
    busotina_sifra int not null,
    napomena varchar(100),
    tlak_tubinga decimal(18,2) not null,
    tlak_casinga decimal(18,2) not null,
    tlak_naftovoda decimal(18,2) not null
);

alter table odrzavanje add foreign key (zaposlenik) references zaposlenik(sifra);
alter table busotina add foreign key (naftno_polje_sifra) references naftno_polje(sifra);
alter table odrzavanje_posao_busotina add foreign key (odrzavanje_sifra) references odrzavanje(sifra);
alter table odrzavanje_posao_busotina add foreign key (posao_sifra) references posao(sifra);
alter table odrzavanje_posao_busotina add foreign key (busotina_sifra) references busotina(sifra);



insert into zaposlenik (sifra,ime,prezime,oib,email,radnomjesto)
values (1,'Mario','Živković', 47014940109,'mzivkovic@gmail.com','Viši mobilni operater1'),
       (2,'Ante','Tomić', 92284205967,'atomic@gmail.com','Viši mobilni operater1'),
        (3,'Josip','Žagar', 19436503181,'jzagar@gmail.com','Viši mobilni operater2'),
         (4,'Zoran','Krivošija', 25423574017,'zkrivosija@gmail.com','Viši mobilni operater1');
        


insert into odrzavanje (sifra,datum,zaposlenik)
values (1,'2022-12-05 07:00:00-19:00:00',1),    # 1
		(2,'2022-12-05 19:00:00-07:00:00',2),   # 2
		(3,'2022-12-06 07:00:00-19:00:00',1),   # 3
        (4,'2022-12-06 19:00:00-07:00:00',2);   # 4
       



insert into posao (sifra,naziv)
values (1,'Aktiviranje kugle 3",uzimanje uzorka,zapisivanje nivoa aditiva u DPA rezervoaru,spuštanje kracera'), # 1
        (2,'Aktiviranje kugle 3",zapisivanje nivoa aditiva u DPA rezervoaru,uzimanje uzorka'),                  # 2
        (3,'Aktiviranje kugle 3",zapisivanje nivoa aditiva u DPA rezervoaru'),                                  # 3
        (4,'Povlačenje kugle 3" na češlju La-3'),                                                               # 4
        (5,'Povlačenje kugle 3" na češlju Cr-2 te aktiviranje iste na bušotinu'),                               # 5
        (6,'Kontrola rada bušotina i njihalica'),                                                               # 6
        (7,'Povlačenje kugle 3" na češlju La-2'),                                                               # 7
        (8,'Spuštanje kracera,zamjena dijagrama'),                                                              # 8
        (9,'spuštanje kracera');                                                                                # 9
       
       


insert into naftno_polje (sifra,naziv)
values (1,'Crnac'),          # 1
		(2,'Ladislavci'),    # 2
		(3,'Beničanci'),     # 3
		(4,'Kućanci');       # 4
	


insert into busotina (sifra,naziv,aktivna,naftno_polje_sifra)
values (1,'La-20',true,2),    # 1
		(2,'La-10',true,2),   # 2
		(3,'La-17',true,2),   # 3
		(4,'La-13',true,2),   # 4
		(5,'La-18',true,2),   # 5
		(6,'La-12',true,2),   # 6
		(7,'Cr-3',true,1),    # 7
		(8,'Cr-13',true,1),   # 8
		(9,'Cr-14',true,1),   # 9
		(10,'Cr-12',true,1),   # 10
		(11,'Ku-4',true,4);    # 11
	


insert into odrzavanje_posao_busotina (sifra,odrzavanje_sifra,posao_sifra,busotina_sifra,tlak_tubinga,tlak_casinga,tlak_naftovoda,napomena)
values (1,1,1,1,10.5,39.1,9.5,'Bušotina radi dobro'),                                                                # 1
		(2,1,2,2,11.5,38.1,10.5,'Bušotina radi dobro'),                                                              # 2
		(3,1,2,3,9.5,1.5,9.1,'Bušotina radi dobro'),                                                                 # 3
		(4,1,2,4,12.1,39.5,11.5,'Bušotina radi dobro'),                                                              # 4
		(5,2,8,1,10.5,39.1,9.5,'Bušotina radi dobro,kracer išao dobro'),                                             # 5
		(6,2,9,11,10.1,40.1,9.5,'Bušotina radi dobro,kracer išao dobro'),                                            # 6
		(7,3,3,5,12.5,7.1,9.5,'Bušotina radi dobro'),                                                                # 7
		(8,3,3,6,10.5,3.5,9.2,'Bušotina radi dobro'),                                                                # 8
		(9,4,8,1,10.3,39.2,9.5,'Bušotina radi dobro,kracer išao dobro'),                                             # 9
		(10,4,9,11,8.5,38.9,7.5,'Bušotina radi dobro, kracer išao dobro');                                            # 10
	
        