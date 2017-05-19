
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPaket {
	
	public static void main(String args[]){
		System.out.print(generateRandomMobileNumbers(342));
	}
	
	
	public static ArrayList<Integer> generateRandomInteger(Integer quantityOfRandomNumbers, Integer randomFromNumber, Integer randomUpToNumber){
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		
		for(int i=0;i<quantityOfRandomNumbers;++i){
			randomNumbers.add(ThreadLocalRandom.current().nextInt(randomFromNumber, randomUpToNumber));
		}
		
		return randomNumbers;
	}

		
		public static ArrayList<String> generateRandomMobileNumbers(Integer quantityOfRandomMobileNumbers){
			ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
			ArrayList<String> randomMobileNumbers = new ArrayList<String>();
			randomNumbers = generateRandomInteger(quantityOfRandomMobileNumbers,1000000,9999999);
				
			for(int i=0;i<quantityOfRandomMobileNumbers;++i){
				switch(i%5){
					case 0:
						randomMobileNumbers.add("0664/"+randomNumbers.get(i));
						break;
					case 1:
						randomMobileNumbers.add("0676/"+randomNumbers.get(i));
						break;
					case 2:
						randomMobileNumbers.add("0660/"+randomNumbers.get(i));
						break;
					case 3:
						randomMobileNumbers.add("0699/"+randomNumbers.get(i));
						break;
					case 4:
						randomMobileNumbers.add("0680/"+randomNumbers.get(i));
						break;
				}
			}	
			
			return randomMobileNumbers;
		}
		
		
		public static ArrayList<String> generateRandomSurnames(Integer quantityOfRandomSurnames){
	    	String surnames = "Paul Jonas Finn Fynn Leon Luis Louis Lukas Lucas Maximilian Felix Noah Elias Julian Max Tim Moritz Henry Henri Niklas Niclas Philipp Jakob Jacob Tom Jan Emil Alexander David Oskar Oscar Fabian Anton Erik Eric Rafael Raphael Matteo Leo Mats Mads Simon Jannik Yannik Yannick Yannic Lennard Lennart Liam Linus Hannes Mika Vincent Adrian Jonathan Theo Nico Niko Till Benjamin Florian Marlon Julius Nick Samuel Nils Niels Johannes Jona Jonah Carl Karl Daniel Lennox Aaron Mattis Mathis Matthis Ole Leonard Constantin Konstantin Sebastian Jannis Janis Yannis Colin Collin Joel Tobias Lenny Lenni Milan Johann Joshua Dominic Dominik Maxim Maksim John Mohammed Muhammad Timo Robin Valentin Jayden Jaden Benedikt Justus Levin Damian Phil Toni Tony Levi Jamie Lian Kilian Malte Noel Jason Bennet Tyler Tayler Gabriel Sam Michael Artur Arthur Bastian Bruno Lasse Marc Mark Pepe Luke Luc Oliver Marvin Marwin Emilio Silas Emir Lars Leopold Richard Lias Elia Eliah Matti Theodor Christian Jannes Tristan Leandro Marcel Frederik Frederic Connor Conner Manuel Dean Adam Diego Piet Franz Fritz Hugo Michel Ilias Ilyas Nicolas Nikolas Matthias Dennis Jeremy Neo Finnley Finley Finlay Marco Marko Pascal Fabio Ludwig Malik Nikita Henrik Lionel Martin Clemens Klemens Lorenz Milo Ian Len Lenn Arne Emilian Yusuf Lio Jasper Lion Maik Meik Mike Ferdinand Thomas Bela Konrad Marius Hendrik Julien Eddi Eddy Friedrich Can Ali Berat Maurice Andreas Taylor Kevin Alessio Kai Kay Laurens Laurenz Patrick Laurin Janne Justin Markus Marcus Carlo Karlo Kian Leonardo Willi Willy Benno Devin Luan Gustav Leonhard Mert Chris Thore Leander Magnus Robert Nevio Ryan Yasin Fiete Henning Arian Roman Korbinian Carlos Jonte Alessandro Peter Deniz Nino Alex Antonio Mailo Brian Bryan Amir Christopher Thilo Tilo Charlie Charly Damien Mehmet Ricardo Riccardo Curt Kurt Dario Joris Victor Viktor Darian Josef Joseph Christoph Georg Jack Kaan Mick Enno Kjell Aiden Ayden Domenic Domenik Jesper Enes Oemer Titus Hamza Mustafa Mikail Torben Thorben Jaron Ruben Bjarne Miran Stefan Stephan Claas Klaas Sascha Tammo Cedric Cedrik Edgar Jerome Leif Leonas Lino Romeo Andre Nathan Tino William Hanno Sami Ahmet Miguel Steven Emin Lean Mirac Semih Sinan Etienne Ibrahim Mario Timon Xaver Armin Efe Janosch Kerem Mio Wilhelm Albert Erwin Hans Marian Anthony Cem Emre Eymen Leonidas Aras Ensar Kenan Kuzey Lutz Selim Tamme Valentino Danny Emanuel Giuliano Hassan Hasan Kerim Umut Amin Arda Danilo Eren Mattes Vince Arvid Darius Dustin Jake Jarne Jim Marten Sean James Jean Lucien Rayan Elian Emirhan Furkan Jonne Kalle Karim Milian Timur Damon Enrico Marek Quentin Alwin Angelo Jesse Otto Samir Yassin Bilal Caspar Jannek Janek Jarno Maddox Mahir Marlo Rico Tjark Elija Elijah Iven Yven Joscha Nikolai Rocco Sven Berkay Dion Gregor Jano Koray Ramon Sandro Taylan Davin Francesco Jamal Jordan Lewis Omar Pius Taha Veit Amar Eduard Gianluca Ismail Joost Jost Lucian Miko Sirac Thies Alfred Dylan Eray Flynn Hauke Logan Melvin Younes Ilja Jon Mete Tamino Alan Arjen Jenke Johnny Keno Loris Milow Santino Tiago Thiago Burak Fabrizio Gian Hennes Kirill Lorik Luiz Peer Talha Tizian Tommy Yunus Aidan Baran Bjoern Cornelius Dorian Hagen Leano Quinn Youssef Benny Bent Ege Gero Ivan Kimi Levent Luuk Maris Miro Sören Stanley Vito Yigit Batuhan Edwin Jakub Juri Kiyan Meo Musa Raul Ron Ruezgar Said Sammy Santiago Severin Adem Adriano Alexandros Ansgar August Bo Dejan Eyüp Fridolin Hueseyin Ilay Jay Jimmy Josua Merlin Nathanael Quirin Azad Davide Denny Evan Giuseppe Jari Jascha Neven Pierre Rick Tarik Vinzenz Ahmad Amon Andrej Aurel Bosse Demian Ethan Joe Joey Nelio Rene Salvatore Simeon";
	    	ArrayList<String> surnamesList = new ArrayList<String>(Arrays.asList(surnames.split(" ")));
	    	ArrayList<String> randomSurnames = new ArrayList<String>();	
	    	Integer var = quantityOfRandomSurnames/100;
	    	
	    	for(int j=0;j<var;++j){
		    	Collections.shuffle(surnamesList);
		    	for (int i=0; i<100; i++) {
		    		randomSurnames.add(surnamesList.get(i));
		    	}    		
	    	}

        	return randomSurnames;
		}
		
		
		public static ArrayList<String> generateRandomNames(Integer quantityOfRandomNames){
			String names="Gruber Huber Bauer Wagner Mueller Pichler Steiner Moser Mayer Hofer Berger Leitner Fuchs Eder Fischer Schmid Winkler Schwarz Weber Maier Schneider Reiter Mayr Schmidt Wimmer Baumgartner Egger Lang Brunner Auer Lechner Binder Wallner Wolf Aigner Ebner Koller Lehner Haas Schuster Holzer Graf Lackner Haider Strasser Koch Weiss Wieser Stadler Koenig Boehm Krenn Kaiser Seidl Kern Fink Kaufmann Fritz Mair Ortner Winter Hofbauer Hauser Posch Riegler Hackl Maurer Hofmann Karner Mayrhofer Riedl Schober Strobl Reisinger Resch Kogler Rainer Neubauer Unger Jaeger Schwaiger Horvath Brandstaetter Muellner Grabner Friedl Frank Weiß Klein Hartl Hager Schweiger Kainz Lindner Hoeller Sommer Zimmermann Hoffmann Wiesinger Thaler Kofler Krammer Pirker Steininger Pfeiffer Haslinger Zauner Mandl Richter Baumann Walter Angerer Herzog Huemer Ecker Koeck Brandstetter Hammer Rauch Hahn Stangl Schwab Konrad Novak Bruckner Brandl Fellner Putz Holzinger Hauer Zach Kurz Mayerhofer Plank Grill Wurm Hafner Kraus Braun Steindl Bayer Stocker Ertl Mader Rath Fasching Platzer Rieder Hartmann Stoeckl Roth Oswald Feichtinger Rieger Schauer Hoelzl Sturm Pfeifer Kastner Stöger Knapp Haller Langer Burgstaller Froehlich Bacher Gassner Schlager Stockinger Hutter Schreiner Neumann Prinz Singer Gasser Lorenz Schuetz Knoll Burger Bischof Traxler Neuhold Hermann Jovanovic Pucher Zechner Vogl Haberl Ziegler Hoedl Leitgeb Kerschbaumer Fruehwirth Thurner Rauscher Pilz Deutsch Puehringer Weinberger Windisch Schloegl Peter Ofner Brugger Schindler Bichler Raab Karl Aichinger Schaffer Trummer Nagl Leeb Gabriel Kreuzer Friedrich Lenz Schuh Fuerst Ernst Unterberger Wurzer Beck Muehlbacher Humer Hoefler Scheiber Schweighofer Brandner Maierhofer Neuwirth Edlinger Reiterer Werner Brenner Ritter Wachter Sattler Petrovic Siegl Renner Eichinger Schreiber Sailer Nowak Schmied Artner Geiger Messner Glaser Kellner Luger Spitzer Denk Reindl Rauter Harrer Loeffler Kroell Baier Dorner Hirsch Schulz Weidinger Klinger Walch Holzmann Steger Doppler Peer Wittmann Swoboda Simon Urban Gangl Schubert Schachinger Schoepf Hofstaetter Haemmerle Steurer Reichl Eichberger Redl Zehetner Schiller Sonnleitner Staudinger Burtscher Franz Dietrich Schoen Schatz Loidl Boeck Gartner Ott Meyer Neuhauser Bader Zeilinger Bogner Albrecht Plattner Pointner Meixner Meier Weninger Lamprecht Hoermann Pinter Gross Amann Handler Lederer Heinrich Poelzl Huetter Amon Forster Jungwirth Forstner Schuller Schranz Schneeberger Lettner Buchinger Schiefer Herbst Nikolic Gmeiner Stark Aschauer Buchegger Steinberger Bergmann Lengauer Eberl Rechberger Kramer Kollmann Heindl Pfeffer Janisch Greiner Koeberl Probst Lutz Reiner Thaller Klug Bernhard Buchner Kopp Steinkellner Zeller Rupp Trimmel Kugler Schachner Seebacher Pacher Nußbaumer Abraham Bachmann Sauer Beer Neuner Penz Groß Martin Walcher Wechselberger Fleischhacker Wild Strauß Riedler Nemeth Kohl Geisler Suppan Springer Rabl Gratzer Gruenwald Fuehrer Wegscheider Scharf Steinbauer Kraft Kapeller Fiedler Achleitner Reinisch Pokorny Wieland Weigl Kremser Stummer Glatz Toth Poeschl";
			ArrayList<String> namesList = new ArrayList<String>(Arrays.asList(names.split(" ")));
	    	ArrayList<String> randomNames= new ArrayList<String>();
	    	Integer var = quantityOfRandomNames/100;
	    	
	    	for(int j=0;j<var;++j){
		    	Collections.shuffle(namesList);
		    	for (int i=0; i<100; i++) {
		    		randomNames.add(namesList.get(i));
		    	}    		
	    	}

        	return randomNames;
		}
		
		
		public static ArrayList<String> generateFullNames(Integer quantityOfFullNames){
			ArrayList<String> surnamesList = new ArrayList<String>();
			ArrayList<String> namesList = new ArrayList<String>();
			ArrayList<String> fullNamesList = new ArrayList<String>();
			
			surnamesList = generateRandomSurnames(quantityOfFullNames);
			namesList = generateRandomNames(quantityOfFullNames);
			
			for(int i=0;i<quantityOfFullNames;++i){
				fullNamesList.add(surnamesList.get(i) + " " + namesList.get(i));
			}
			
			return fullNamesList;
		}
		
		
		public static ArrayList<String> generateRandomEmailAccounts(ArrayList<String> fullNamesList){
			ArrayList<String> EmailAccounts = new ArrayList<String>();
			ArrayList<String> formattedNamesForEmailAccounts = new ArrayList<String>();
			Integer fullNamesListSize = fullNamesList.size();
			
			for(int j=0;j<fullNamesListSize;++j){
				formattedNamesForEmailAccounts.add(fullNamesList.get(j).replaceFirst(" ", "."));
			}
			
			for(int i=0;i<fullNamesListSize;++i){
				switch(i%5){
					case 0:
						EmailAccounts.add(formattedNamesForEmailAccounts.get(i)+"@hotmail.com");
						break;
					case 1:
						EmailAccounts.add(formattedNamesForEmailAccounts.get(i)+"@gmail.com");
						break;
					case 2:
						EmailAccounts.add(formattedNamesForEmailAccounts.get(i)+"@gmx.at");
						break;
					case 3:
						EmailAccounts.add(formattedNamesForEmailAccounts.get(i)+"@webmail.com");
						break;
					case 4:
						EmailAccounts.add(formattedNamesForEmailAccounts.get(i)+"@google.com");
						break;
				}
			}
			
			return EmailAccounts;
		}
		
}
