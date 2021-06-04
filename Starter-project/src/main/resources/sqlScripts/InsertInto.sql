


--obrazovanje podaci

insert into "obrazovanje"("id","naziv","stepen_strucne_spreme","opis")
values (nextval('obrazovanje_seq'),'Gimnazija','gimnazija','teritorija RS');

insert into "obrazovanje"("id","naziv","stepen_strucne_spreme","opis")
values (nextval('obrazovanje_seq'),'Ekonomska skola','4.','teritorija RS');

insert into "obrazovanje"("id","naziv","stepen_strucne_spreme","opis")
values (nextval('obrazovanje_seq'),'Tehnicka skola','5.','teritorija RS');

insert into "obrazovanje"("id","naziv","stepen_strucne_spreme","opis")
values (nextval('obrazovanje_seq'),'Poljoprivredna skola','4.','teritorija RS');

--preduzece podaci
insert into "preduzece"("id","naziv","pib","sediste","opis")
values (nextval('preduzece_seq'),'Matross DOO',3345,'Sremska Mitrovica','Prehrambeno-hemijsko');

insert into "preduzece"("id","naziv","pib","sediste","opis")
values (nextval('preduzece_seq'),'JP Vojvodinasume',3356,'Novi Sad','Javno preduzece');

insert into "preduzece"("id","naziv","pib","sediste","opis")
values (nextval('preduzece_seq'),'Euro Plastic DOO',3367,'Sremska Mitrovica', 'Zanatska radnja');

insert into "preduzece"("id","naziv","pib","sediste","opis")
values (nextval('preduzece_seq'),'Hutchinson',3356,'Ruma', 'Aerospace servisi');

--sektor podaci
insert into "sektor"("id","naziv","oznaka","preduzece")
values (nextval('sektor_seq'),'Proizvodnja','P',3);
insert into "sektor"("id","naziv","oznaka","preduzece")
values (nextval('sektor_seq'),'Proizvodnja','P',4);
insert into "sektor"("id","naziv","oznaka","preduzece")
values (nextval('sektor_seq'),'Ljudski resursi','HR',2);
insert into "sektor"("id","naziv","oznaka","preduzece")
values (nextval('sektor_seq'),'Logistika','L',1);

--radnik podaci
insert into "radnik"("id","ime","prezime","broj_lk","obrazovanje","sektor")
values (nextval('radnik_seq'),'Teodora','Perisin',6678532,1,1);
insert into "radnik"("id","ime","prezime","broj_lk","obrazovanje","sektor")
values (nextval('radnik_seq'),'Aleksa','Komosar',6688521,1,2);
insert into "radnik"("id","ime","prezime","broj_lk","obrazovanje","sektor")
values (nextval('radnik_seq'),'Jovana','Ostojic',6659687,2,3);
insert into "radnik"("id","ime","prezime","broj_lk","obrazovanje","sektor")
values (nextval('radnik_seq'),'Maja','Cetic',6321456,3,4);
insert into "radnik"("id","ime","prezime","broj_lk","obrazovanje","sektor")
values (nextval('radnik_seq'),'Sara','Kijanovic',6678541,4,4);

--Test podaci
insert into "preduzece"("id","naziv","pib","sediste","opis")
values (-100,'Test proizvodjac',3388,'test','test');

insert into "obrazovanje"("id","naziv","stepen_strucne_spreme","opis")
values (-100,'test','test','test');

insert into "sektor"("id","naziv","oznaka","preduzece")
values (-100,'test','test',2);

insert into "radnik"("id","ime","prezime","broj_lk","obrazovanje","sektor")
values (-100,'test','test',66532,1,1);

