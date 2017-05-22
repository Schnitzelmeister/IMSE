package at.ac.ac.univie.imse.SS2017.team1.database;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

	public static void main(String args[]) {
		System.out.println(generateRandomData(entityTyp.description,2));
	}

	public static ArrayList<Integer> generateRandomInteger(Integer quantityOfRandomNumbers, Integer randomMinNumber,
			Integer randomMaxNumber) {
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

		for (int i = 0; i < quantityOfRandomNumbers; ++i) {
			randomNumbers.add(ThreadLocalRandom.current().nextInt(randomMinNumber, randomMaxNumber));
		}

		return randomNumbers;
	}
	
	public static ArrayList<String> generateRandomStrings(Integer quantityOfRandomStrings, Integer numberOfUsedBits){
		ArrayList<String> randomStrings = new ArrayList<String>();
		SecureRandom random = new SecureRandom();
		
		for(int i=0;i<quantityOfRandomStrings;++i){
			// numberOfUsedBits recommended -> 64 
			randomStrings.add(new BigInteger(numberOfUsedBits, random).toString(32));		
		}
		return randomStrings;
	}
	
	public static ArrayList<Boolean> generateRandomBooleans(Integer quantityOfRandomBoolean, Boolean isAlwaystrue){
		ArrayList<Boolean> randomBooleans = new ArrayList<Boolean>();
		Double compareNumber = 0.5;
		
		if(isAlwaystrue!=null && isAlwaystrue==true){
			compareNumber = 1.0;
		}
		if(isAlwaystrue!=null && isAlwaystrue==false){
			compareNumber = 0.0;
		}
		
		for(int i=0;i<quantityOfRandomBoolean;++i){
			randomBooleans.add(Math.random()<compareNumber);
		}
		
		return randomBooleans;
	}
	
	public static ArrayList<String> generateRandomCreditCards(Integer quantityOfRandomCreditCards){
		ArrayList<String> randomCreditCards = new ArrayList<String>();
		ArrayList<Integer> randomNumbers = generateRandomInteger(quantityOfRandomCreditCards*4, 1000, 9999);
		
		for(int i=0;i<quantityOfRandomCreditCards*4;i+=4){
			randomCreditCards.add(randomNumbers.get(i)+"-"+randomNumbers.get(i+1)+"-"+randomNumbers.get(i+2)+
					"-"+randomNumbers.get(i+3));
		}
		
		return randomCreditCards;
	}
	
	public static ArrayList<String> generateRandomDates(Integer quantityOfRandomDates){
		ArrayList<String> randomDates = new ArrayList<String>();
		ArrayList<Integer> randomNumbersPostfix = generateRandomInteger(quantityOfRandomDates, 100000, 999999);
		ArrayList<Integer> randomNumbersPrefix = generateRandomInteger(quantityOfRandomDates, 00000, 
				Integer.parseInt(Long.toString(System.currentTimeMillis()).substring(2, 7)));
		
		String fixedTimePeriod = String.valueOf(Long.toString(System.currentTimeMillis()).substring(0, 2));
		
		for(int i=0;i<quantityOfRandomDates;++i){
			randomDates.add(fixedTimePeriod+randomNumbersPrefix.get(i)+randomNumbersPostfix.get(i));
		}
		
		return randomDates;
	}
	
	public static ArrayList<Float> generateRandomFloats(Integer quantityOfRandomFloats, Integer randomMinNumber, 
			Integer randomMaxNumber) {
		ArrayList<Float> randomFloatNumber = new ArrayList<Float>();
		Random random = new Random();
		
		for(int i=0;i<quantityOfRandomFloats;++i){
			randomFloatNumber.add(Float.valueOf((float) ((Math.round((randomMinNumber+random.nextFloat()*
					(randomMaxNumber-randomMinNumber))*100))/100.00)));
		}
		
		return randomFloatNumber;
		
	}

	
	public static ArrayList<String> getSurNames() {
		String surnames = "Paul Jonas Finn Fynn Leon Luis Louis Lukas Lucas Maximilian Felix Noah Elias Julian Max Tim Moritz Henry Henri Niklas Niclas Philipp Jakob Jacob Tom Jan Emil Alexander David Oskar Oscar Fabian Anton Erik Eric Rafael Raphael Matteo Leo Mats Mads Simon Jannik Yannik Yannick Yannic Lennard Lennart Liam Linus Hannes Mika Vincent Adrian Jonathan Theo Nico Niko Till Benjamin Florian Marlon Julius Nick Samuel Nils Niels Johannes Jona Jonah Carl Karl Daniel Lennox Aaron Mattis Mathis Matthis Ole Leonard Constantin Konstantin Sebastian Jannis Janis Yannis Colin Collin Joel Tobias Lenny Lenni Milan Johann Joshua Dominic Dominik Maxim Maksim John Mohammed Muhammad Timo Robin Valentin Jayden Jaden Benedikt Justus Levin Damian Phil Toni Tony Levi Jamie Lian Kilian Malte Noel Jason Bennet Tyler Tayler Gabriel Sam Michael Artur Arthur Bastian Bruno Lasse Marc Mark Pepe Luke Luc Oliver Marvin Marwin Emilio Silas Emir Lars Leopold Richard Lias Elia Eliah Matti Theodor Christian Jannes Tristan Leandro Marcel Frederik Frederic Connor Conner Manuel Dean Adam Diego Piet Franz Fritz Hugo Michel Ilias Ilyas Nicolas Nikolas Matthias Dennis Jeremy Neo Finnley Finley Finlay Marco Marko Pascal Fabio Ludwig Malik Nikita Henrik Lionel Martin Clemens Klemens Lorenz Milo Ian Len Lenn Arne Emilian Yusuf Lio Jasper Lion Maik Meik Mike Ferdinand Thomas Bela Konrad Marius Hendrik Julien Eddi Eddy Friedrich Can Ali Berat Maurice Andreas Taylor Kevin Alessio Kai Kay Laurens Laurenz Patrick Laurin Janne Justin Markus Marcus Carlo Karlo Kian Leonardo Willi Willy Benno Devin Luan Gustav Leonhard Mert Chris Thore Leander Magnus Robert Nevio Ryan Yasin Fiete Henning Arian Roman Korbinian Carlos Jonte Alessandro Peter Deniz Nino Alex Antonio Mailo Brian Bryan Amir Christopher Thilo Tilo Charlie Charly Damien Mehmet Ricardo Riccardo Curt Kurt Dario Joris Victor Viktor Darian Josef Joseph Christoph Georg Jack Kaan Mick Enno Kjell Aiden Ayden Domenic Domenik Jesper Enes Oemer Titus Hamza Mustafa Mikail Torben Thorben Jaron Ruben Bjarne Miran Stefan Stephan Claas Klaas Sascha Tammo Cedric Cedrik Edgar Jerome Leif Leonas Lino Romeo Andre Nathan Tino William Hanno Sami Ahmet Miguel Steven Emin Lean Mirac Semih Sinan Etienne Ibrahim Mario Timon Xaver Armin Efe Janosch Kerem Mio Wilhelm Albert Erwin Hans Marian Anthony Cem Emre Eymen Leonidas Aras Ensar Kenan Kuzey Lutz Selim Tamme Valentino Danny Emanuel Giuliano Hassan Hasan Kerim Umut Amin Arda Danilo Eren Mattes Vince Arvid Darius Dustin Jake Jarne Jim Marten Sean James Jean Lucien Rayan Elian Emirhan Furkan Jonne Kalle Karim Milian Timur Damon Enrico Marek Quentin Alwin Angelo Jesse Otto Samir Yassin Bilal Caspar Jannek Janek Jarno Maddox Mahir Marlo Rico Tjark Elija Elijah Iven Yven Joscha Nikolai Rocco Sven Berkay Dion Gregor Jano Koray Ramon Sandro Taylan Davin Francesco Jamal Jordan Lewis Omar Pius Taha Veit Amar Eduard Gianluca Ismail Joost Jost Lucian Miko Sirac Thies Alfred Dylan Eray Flynn Hauke Logan Melvin Younes Ilja Jon Mete Tamino Alan Arjen Jenke Johnny Keno Loris Milow Santino Tiago Thiago Burak Fabrizio Gian Hennes Kirill Lorik Luiz Peer Talha Tizian Tommy Yunus Aidan Baran Bjoern Cornelius Dorian Hagen Leano Quinn Youssef Benny Bent Ege Gero Ivan Kimi Levent Luuk Maris Miro Sören Stanley Vito Yigit Batuhan Edwin Jakub Juri Kiyan Meo Musa Raul Ron Ruezgar Said Sammy Santiago Severin Adem Adriano Alexandros Ansgar August Bo Dejan Eyüp Fridolin Hueseyin Ilay Jay Jimmy Josua Merlin Nathanael Quirin Azad Davide Denny Evan Giuseppe Jari Jascha Neven Pierre Rick Tarik Vinzenz Ahmad Amon Andrej Aurel Bosse Demian Ethan Joe Joey Nelio Rene Salvatore Simeon";
		return new ArrayList<String>(Arrays.asList(surnames.split(" ")));
	}

	public static ArrayList<String> getNames() {
		String names = "Gruber Huber Bauer Wagner Mueller Pichler Steiner Moser Mayer Hofer Berger Leitner Fuchs Eder Fischer Schmid Winkler Schwarz Weber Maier Schneider Reiter Mayr Schmidt Wimmer Baumgartner Egger Lang Brunner Auer Lechner Binder Wallner Wolf Aigner Ebner Koller Lehner Haas Schuster Holzer Graf Lackner Haider Strasser Koch Weiss Wieser Stadler Koenig Boehm Krenn Kaiser Seidl Kern Fink Kaufmann Fritz Mair Ortner Winter Hofbauer Hauser Posch Riegler Hackl Maurer Hofmann Karner Mayrhofer Riedl Schober Strobl Reisinger Resch Kogler Rainer Neubauer Unger Jaeger Schwaiger Horvath Brandstaetter Muellner Grabner Friedl Frank Weiß Klein Hartl Hager Schweiger Kainz Lindner Hoeller Sommer Zimmermann Hoffmann Wiesinger Thaler Kofler Krammer Pirker Steininger Pfeiffer Haslinger Zauner Mandl Richter Baumann Walter Angerer Herzog Huemer Ecker Koeck Brandstetter Hammer Rauch Hahn Stangl Schwab Konrad Novak Bruckner Brandl Fellner Putz Holzinger Hauer Zach Kurz Mayerhofer Plank Grill Wurm Hafner Kraus Braun Steindl Bayer Stocker Ertl Mader Rath Fasching Platzer Rieder Hartmann Stoeckl Roth Oswald Feichtinger Rieger Schauer Hoelzl Sturm Pfeifer Kastner Stöger Knapp Haller Langer Burgstaller Froehlich Bacher Gassner Schlager Stockinger Hutter Schreiner Neumann Prinz Singer Gasser Lorenz Schuetz Knoll Burger Bischof Traxler Neuhold Hermann Jovanovic Pucher Zechner Vogl Haberl Ziegler Hoedl Leitgeb Kerschbaumer Fruehwirth Thurner Rauscher Pilz Deutsch Puehringer Weinberger Windisch Schloegl Peter Ofner Brugger Schindler Bichler Raab Karl Aichinger Schaffer Trummer Nagl Leeb Gabriel Kreuzer Friedrich Lenz Schuh Fuerst Ernst Unterberger Wurzer Beck Muehlbacher Humer Hoefler Scheiber Schweighofer Brandner Maierhofer Neuwirth Edlinger Reiterer Werner Brenner Ritter Wachter Sattler Petrovic Siegl Renner Eichinger Schreiber Sailer Nowak Schmied Artner Geiger Messner Glaser Kellner Luger Spitzer Denk Reindl Rauter Harrer Loeffler Kroell Baier Dorner Hirsch Schulz Weidinger Klinger Walch Holzmann Steger Doppler Peer Wittmann Swoboda Simon Urban Gangl Schubert Schachinger Schoepf Hofstaetter Haemmerle Steurer Reichl Eichberger Redl Zehetner Schiller Sonnleitner Staudinger Burtscher Franz Dietrich Schoen Schatz Loidl Boeck Gartner Ott Meyer Neuhauser Bader Zeilinger Bogner Albrecht Plattner Pointner Meixner Meier Weninger Lamprecht Hoermann Pinter Gross Amann Handler Lederer Heinrich Poelzl Huetter Amon Forster Jungwirth Forstner Schuller Schranz Schneeberger Lettner Buchinger Schiefer Herbst Nikolic Gmeiner Stark Aschauer Buchegger Steinberger Bergmann Lengauer Eberl Rechberger Kramer Kollmann Heindl Pfeffer Janisch Greiner Koeberl Probst Lutz Reiner Thaller Klug Bernhard Buchner Kopp Steinkellner Zeller Rupp Trimmel Kugler Schachner Seebacher Pacher Nußbaumer Abraham Bachmann Sauer Beer Neuner Penz Groß Martin Walcher Wechselberger Fleischhacker Wild Strauß Riedler Nemeth Kohl Geisler Suppan Springer Rabl Gratzer Gruenwald Fuehrer Wegscheider Scharf Steinbauer Kraft Kapeller Fiedler Achleitner Reinisch Pokorny Wieland Weigl Kremser Stummer Glatz Toth Poeschl";
		return new ArrayList<String>(Arrays.asList(names.split(" ")));
	}

	public static ArrayList<String> getProductNames() {
		String productNames = "check out";
		return new ArrayList<String>(Arrays.asList(productNames.split(" ")));
	}
	
	public static ArrayList<String> getProductCategories() {
		String categories = "Zeitschriften Uhren Technik Wissenschaft Spielzeug Software Schuhe Handtaschen Schmuck Beauty Musikinstrumente Musik Lebensmittel Getränke Küche Haushalt Taschen Rucksäcke Koffer Klassik Kamera Foto Haustier Handmade Geschenkgutscheine Garten Games Fashion Elektronik Foto Elektro-Großgeräte DVD Blu-Ray Drogerie Körperpflege Computer Bürobedarf Bücher Beleuchtung Bekleidung Beauty Baumarkt Baby Auto Motorrad Apps Spiele";
		return new ArrayList<String>(Arrays.asList(categories.split(" ")));
	}
	
	public static ArrayList<String> getCities(){
    	String cities = "Allentsteig Altheim Althofen Amstetten Ansfelden Attnang-Puchheim Bad-Aussee Bad-Hall Bad-Ischl Bad-Leonfelden Bad-Radkersburg Bad-St.Leonhard-im-Lavanttal Bad-Voeslau Baden Baernbach Berndorf Bischofshofen Bleiburg Bludenz Braunau-am-Inn Bregenz Bruck-an-der-Leitha Bruck-an-der-Mur Deutsch-Wagram Deutschlandsberg Dornbirn Drosendorf-Zissersdorf Duernstein Ebenfurth Ebreichsdorf Eferding Eggenburg Eisenerz Eisenstadt Enns Fehring Feldbach Feldkirch Feldkirchen-in-Kaernten Ferlach Fischamend Frauenkirchen Freistadt Friedberg Friesach Frohnleiten Fuerstenfeld Gallneukirchen Gaenserndorf Geras Gerasdorf-bei-Wien Gfoehl Gleisdorf Gloggnitz Gmuend Gmuend-in-Kaernten Gmunden Graz Grein Grieskirchen Groß Gerungs Groß-Enzersdorf Groß-Siegharts Guessing Haag Hainburg-an-der-Donau Hainfeld Hall-in-Tirol Hallein Hardegg Hartberg Heidenreichstein Hermagor-Pressegger-See Herzogenburg Hohenems Hollabrunn Horn Imst Innsbruck Jennersdorf Judenburg Kapfenberg Kindberg Kirchdorf-an-der-Krems Kirchschlag-in-der-Buckligen-Welt Kitzbuehel Klagenfurt-am-Woerthersee Klosterneuburg Knittelfeld Koeflach Korneuburg Krems-an-der-Donau Kufstein Laa-an-der-Thaya Laakirchen Landeck Langenlois Leibnitz Leoben Leonding Lienz Liezen Lilienfeld Linz Litschau Maissau Mank Mannersdorf-am-Leithagebirge Marchegg Marchtrenk Mariazell Mattersburg Mattighofen Mautern-an-der-Donau Melk Mistelbach Mittersill Moedling Murau Mureck Muerzzuschlag Neufeld-an-der-Leitha Neulengbach Neumarkt-am-Wallersee Neunkirchen Neusiedl-am-See Oberndorf-bei-Salzburg Oberpullendorf Oberwart Oberwoelz Perg Peuerbach Pinkafeld Poechlarn Poysdorf Pregarten Pressbaum Pulkau Purbach-am-Neusiedler-See Purkersdorf Raabs-an-der-Thaya Radenthein Radstadt Rattenberg Retz Ried-im-Innkreis Rohrbach-Berg Rottenmann Rust Saalfelden-am-Steinernen-Meer Salzburg Sankt-Andrae Sankt-Veit-an-der-Glan Schaerding Scheibbs Schladming Schrattenthal Schrems Schwanenstadt Schwaz Schwechat Seekirchen-am-Wallersee Spielberg Spittal-an-der-Drau St.Johann-im-Pongau St.Pölten St.Valentin Stadtschlaining Steyr Steyregg Stockerau Straßburg Ternitz Traiskirchen Traismauer Traun Trieben Trofaiach Tulln-an-der-Donau Villach Vils Voecklabruck Voitsberg Voelkermarkt Waidhofen-an-der-Thaya Waidhofen-an-der-Ybbs Weitra Weiz Wels Wien Wiener-Neustadt Wieselburg Wilhelmsburg Wolfsberg Wolkersdorf-im-Weinviertel Woergl Ybbs-an-der-Donau Zell-am-See Zeltweg Zistersdorf Zwettl-Niederoesterreich";
    	return new ArrayList<String>(Arrays.asList(cities.split(" ")));
	}
	
	public static ArrayList<String> getDescription() {
		String description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
		ArrayList<String> descriptionList = new ArrayList<String>();
		
		descriptionList.add(description);
		return descriptionList;
	}
	
	public static ArrayList<String> generateRandomStreetNames(Integer quantityOfRandomStreetNames){
		ArrayList<String> streets = generateRandomData(entityTyp.Names, quantityOfRandomStreetNames);
		ArrayList<String> streetList = new ArrayList<String>();
		ArrayList<Integer> randomNumbers = generateRandomInteger(quantityOfRandomStreetNames, 1, 150);
		for(int i=0;i<streets.size();++i){
			if(i%10!=0){
				streetList.add(streets.get(i)+"strasse "+randomNumbers.get(i));
			} else {
				streetList.add(streets.get(i)+"gasse "+randomNumbers.get(i));
			}
		}
		return streetList;
	}
	
	public static ArrayList<String> getFullAddress(Integer quantityOfRandomAddresses){
		ArrayList<Integer> addressId = generateRandomInteger(quantityOfRandomAddresses, 50000000, 99999999);
		ArrayList<String> streetList = generateRandomStreetNames(quantityOfRandomAddresses);
		ArrayList<String> cityList = generateRandomData(entityTyp.cities, quantityOfRandomAddresses);
		ArrayList<Integer> postalCodeList = generateRandomInteger(quantityOfRandomAddresses, 1010, 9990);
		ArrayList<String> randomAddresses = new ArrayList<String>();
		
		for(int i=0;i<quantityOfRandomAddresses;++i){
			randomAddresses.add(addressId.get(i)+" "+streetList.get(i)+" "+postalCodeList.get(i)+" "+
					cityList.get(i));
		}
		
		return randomAddresses;
		
	}
	
	public static ArrayList<String> getFullNames() {
		ArrayList<String> surnamesList = new ArrayList<String>();
		ArrayList<String> namesList = new ArrayList<String>();
		ArrayList<String> fullNamesList = new ArrayList<String>();
		Integer smallerIndex = 0;

		surnamesList = getSurNames();
		namesList = getNames();

		if (surnamesList.size() > namesList.size()) {
			smallerIndex = namesList.size();
		} else {
			smallerIndex = surnamesList.size();
		}

		for (int i = 0; i < smallerIndex; ++i) {
			fullNamesList.add(surnamesList.get(i) + " " + namesList.get(i));
		}

		return fullNamesList;
	}
	
	
	public static ArrayList<String> generateRandomMobileNumbers(Integer quantityOfRandomMobileNumbers) {
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		ArrayList<String> randomMobileNumbers = new ArrayList<String>();
		randomNumbers = generateRandomInteger(quantityOfRandomMobileNumbers, 1000000, 9999999);

		for (int i = 0; i < quantityOfRandomMobileNumbers; ++i) {
			switch (i % 5) {
			case 0:
				randomMobileNumbers.add("0664/" + randomNumbers.get(i));
				break;
			case 1:
				randomMobileNumbers.add("0676/" + randomNumbers.get(i));
				break;
			case 2:
				randomMobileNumbers.add("0660/" + randomNumbers.get(i));
				break;
			case 3:
				randomMobileNumbers.add("0699/" + randomNumbers.get(i));
				break;
			case 4:
				randomMobileNumbers.add("0680/" + randomNumbers.get(i));
				break;
			}
		}

		return randomMobileNumbers;
	}

	public static ArrayList<String> generateRandomEmailAccounts(ArrayList<String> fullNamesList) {
		ArrayList<String> EmailAccounts = new ArrayList<String>();
		ArrayList<String> formattedNamesForEmailAccounts = new ArrayList<String>();
		Integer fullNamesListSize = fullNamesList.size();

		for (int j = 0; j < fullNamesListSize; ++j) {
			formattedNamesForEmailAccounts.add(fullNamesList.get(j).replaceFirst(" ", "."));
		}

		for (int i = 0; i < fullNamesListSize; ++i) {
			switch (i % 5) {
			case 0:
				EmailAccounts.add(formattedNamesForEmailAccounts.get(i) + "@hotmail.com");
				break;
			case 1:
				EmailAccounts.add(formattedNamesForEmailAccounts.get(i) + "@gmail.com");
				break;
			case 2:
				EmailAccounts.add(formattedNamesForEmailAccounts.get(i) + "@gmx.at");
				break;
			case 3:
				EmailAccounts.add(formattedNamesForEmailAccounts.get(i) + "@webmail.com");
				break;
			case 4:
				EmailAccounts.add(formattedNamesForEmailAccounts.get(i) + "@google.com");
				break;
			}
		}
		return EmailAccounts;
	}

	public static ArrayList<String> generateRandomData(entityTyp typ, Integer quantityOfEntity) {

		Integer var = 1;
		Integer entityListsize = 0;
		ArrayList<String> entityList = new ArrayList<String>();
		ArrayList<String> randomEntityAmount = new ArrayList<String>();

		if (typ.equals(entityTyp.productNames)) {
			entityList = getProductNames();
		}

		if (typ.equals(entityTyp.Names)) {
			entityList = getNames();
		}

		if (typ.equals(entityTyp.surNames)) {
			entityList = getSurNames();
		}

		if (typ.equals(entityTyp.fullNames)) {
			entityList = getFullNames();
		}
		
		if (typ.equals(entityTyp.productCategories)) {
			entityList = getProductCategories();
		}
		
		if (typ.equals(entityTyp.productCategories)) {
			entityList = getProductCategories();
		}
		
		if (typ.equals(entityTyp.cities)) {
			entityList = getCities();
		}
		
		if (typ.equals(entityTyp.description)) {
			entityList = getDescription();
		}

		entityListsize = entityList.size();
		var = quantityOfEntity / entityListsize;

		for (int j = 0; j < var; ++j) {
			Collections.shuffle(entityList);
			for (int i = 0; i < entityListsize; i++) {
				randomEntityAmount.add(entityList.get(i));
			}
		}
		if (quantityOfEntity % entityListsize != 0) {
			for (int k = 0; k < quantityOfEntity % entityListsize; ++k) {
				randomEntityAmount.add(entityList.get(k));
			}
		}

		return randomEntityAmount;

	}

	public enum entityTyp {
		productNames, surNames, Names, fullNames, productCategories, cities, description
	}

}