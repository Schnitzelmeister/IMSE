CREATE TABLE Benutzer(
	BenutzerID int NOT NULL AUTO_INCREMENT,
    Login varchar(255) NOT NULL UNIQUE,
    Passwort varchar(255) NOT NULL,
    Vorname varchar(255),
    Nachname varchar(255),
    IBAN int,
    CONSTRAINT PK_Benutzer PRIMARY KEY(BenutzerID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE Mitarbeiter(
	MitarbeiterID int NOT NULL,
    ManagerID int,
    Stelle varchar(255) NOT NULL,
    Gehalt int,
    CONSTRAINT FK_Manager_TABLE_MITARBEITER FOREIGN KEY(ManagerID) REFERENCES Mitarbeiter(MitarbeiterID),
    CONSTRAINT FK_Mitarbeiter_TABLE_MITARBEITER FOREIGN KEY(MitarbeiterID) REFERENCES Benutzer(BenutzerID),
    CONSTRAINT PK_Mitarbeiter_TABLE_MITARBEITER PRIMARY KEY(MitarbeiterID)
);

CREATE TABLE Kunde(
	KundenID int NOT NULL,
    Stadt varchar(255) NOT NULL,
    Straße varchar(255) NOT NULL,
    PLZ int NOT NULL,
    Telefonnr varchar(60),
    CONSTRAINT FK_Mitarbeiter_TABLE_KUNDE FOREIGN KEY(KundenID) REFERENCES Benutzer(BenutzerID),
    CONSTRAINT PK_Mitarbeiter_TABLE_KUNDE PRIMARY KEY(KundenID)
);

CREATE TABLE Wunschliste(
	WListeID int NOT NULL AUTO_INCREMENT, 
	KundenID int NOT NULL,
	WListeName varchar(255) NOT NULL,
    CONSTRAINT FK_Wunschliste_WEAK_ENTITY FOREIGN KEY(KundenID) REFERENCES Kunde(KundenID) ON DELETE CASCADE,
    CONSTRAINT PK_Wunschliste PRIMARY KEY(WListeID, KundenID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE Produkt(
	ProduktID int NOT NULL AUTO_INCREMENT,
    Menge int,
    ProduktName varchar(255) NOT NULL,
    Beschreibung TEXT,
    Kategorie varchar(255),
    Kaufpreis FLOAT(7,2),
    Verkaufspreis FLOAT(7,2),
    CONSTRAINT PK_Produkt PRIMARY KEY(ProduktID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE Hersteller(
	HerstellerID int NOT NULL AUTO_INCREMENT,
    HerstellerName varchar(255),
    Branche varchar(255),
    CONSTRAINT PK_Hersteller PRIMARY KEY(HerstellerID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE kauft(
	KundenID int NOT NULL,
    ProduktID int NOT NULL,
	CONSTRAINT FK_kauft_KundenID FOREIGN KEY(KundenID) REFERENCES Kunde(KundenID),
    CONSTRAINT FK_kauft_ProduktID FOREIGN KEY(ProduktID) REFERENCES Produkt(ProduktID),
    CONSTRAINT PK_kauft PRIMARY KEY(KundenID, ProduktID)    
);

CREATE TABLE beinhaltet(
	WListeID int NOT NULL,
    KundenID int NOT NULL,
    ProduktID int NOT NULL,
    CONSTRAINT FK_beinhaltet_WListeID FOREIGN KEY(WListeID) REFERENCES Wunschliste(WListeID),
    CONSTRAINT FK_beinhaltet_KundenID FOREIGN KEY(KundenID) REFERENCES Wunschliste(KundenID),
    CONSTRAINT FK_beinhaltet_ProduktID FOREIGN KEY(ProduktID) REFERENCES Produkt(ProduktID),
    CONSTRAINT PK_beinhaltet PRIMARY KEY(WListeID, KundenID)    
);






