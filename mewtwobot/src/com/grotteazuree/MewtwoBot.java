package com.grotteazuree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;


public class MewtwoBot {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("start");

		Login.login("Silvallié"); // à commenter
		// API.login(username, password);
		
		//sync();
		MewtwoBot bot = new MewtwoBot();
		bot.run();

		System.out.println("stop");
	}

	
	
	
	
	
	
	
	@SuppressWarnings("unused")
	public void run() throws IOException {
		
//		File folderPath = new File("D:\\Poképédia\\Images\\GO\\Bonbons\\");
		
//		File folderPath = new File("D:\\Poképédia\\Découpes\\Résultats\\objetsHOME\\");

		File folderPath = new File("D:\\Poképédia\\JCC\\Épée et Bouclier Origine Perdue TG\\");

		File listPath = new File("D:\\Poképédia\\JCC\\description_upload.txt");
		
//		File listPath = new File("D:\\Poképédia\\Robot\\createSpriteRedirections\\DEPS.txt");
		
//		createSpriteRedirections(listPath, "DEPS", "EB", "Diamant Étincelant et Perle Scintillante", false);
		 
//		uploadAttacks(folderPath, "LPA", "Légendes Pokémon : Arceus", true, false);
		
//		uploadCards(folderPath, listPath, false);

//		uploadFiles(folderPath, "[[Catégorie:Miniature Pokémon (Légendes Pokémon : Arceus)]]", true);
		
//		uploadFilesWithDescriptions(folderPath, listPath, ".png", false, true);

//		File folderPath = new File("D:\\Poképédia\\Images\\GO\\Bonbons\\");
//		uploadCandies(folderPath, false);
		
//		uploadItems(folderPath, "Smile", "HOME", false);
		
//		uploadSprites(folderPath, "Upload Miniatures LPA", "", false, 0, true);
		
//		addDex("Hisui", false, false);
		
//		deleteDuplicateFiles(false);
		
		
		fullUpdateLocations();
		
	}
	
	public void fullUpdateLocations() throws IOException {
		dumpContentFromPages(false);
		pythonLocDataConverter();
		uploadLocations(false);
		
	}
	
	
	public void savePage(String path, Page page) throws IOException {
		String pageName = page.getTitle();
		String pageSave = pageName.replace(":", "-");
		
		Path saveFilePath = Path.of(path + pageSave + ".txt");			
		String pageContent = page.getContent();
		
		Files.writeString(saveFilePath, pageContent);
		System.out.println(pageName + " dump ok");
	}
	
	public void dumpContentFromPages(boolean justOne) throws IOException {

		String[] categoryNames = new String[] {"Lieu de Kanto", "Arène de Kanto", "Lieu des Îles Sevii", "Lieu de Johto", "Arène de Johto", "Lieu de Hoenn", "Arène de Hoenn", "Lieu de Sinnoh", "Arène de Sinnoh", "Cachette de Pokémon", "Lieu d'Unys", "Arène d'Unys", "Lieu de Kalos", "Arène de Kalos", "Lieu d'Alola", "Lieu de Galar", "Arène de Galar", "Antre de Pokémon", "Lieu de Hisui"};
		String[] moreArticles = new String[] {"Pokémon mouvant", "Monde Distorsion", "Réserve Naturelle", "Pokémon Rubis Oméga et Saphir Alpha : Version démo spéciale", "Expédition Dynamax", "Régiona", "Quête des Taupiqueur d'Alola"};
		String path = "D:\\Poképédia\\Robot\\dumps\\locdump\\";
		List<PageCollection> pageCollections = new ArrayList<>();
		for(int i=0; i<categoryNames.length; i++) {
			
			PageCollection pageCollection = new PageCollection(
					new int[] {API.NS_MAIN},
					API.FILTER_NONREDIRECTS,
					categoryNames[i]
				);
			pageCollections.add(pageCollection);
			System.out.println(categoryNames[i] + " category dump ok");
		}
		

		
		System.out.println("\n********\nFILEDUMP\n********\n");
		

		
		int counter = 0;
		for(PageCollection pageCollection : pageCollections) {
			Page page = pageCollection.getNextPage();
	
			while(page!=null) {
				
				savePage(path, page);
				
				if (justOne) {
					break;
				}
				
				page = pageCollection.getNextPage();
			}
			System.out.println("\n********\nCategory " + categoryNames[counter] + " ok\n********\n");
			counter++;
		}
		for(String article : moreArticles) {
			Page page = new Page(article);
			savePage(path, page);
		}
		System.out.println("\n********\nBonus pages ok\n********\n");
		
	}
	
	public void pythonLocDataConverter() throws IOException {
		Process p = Runtime.getRuntime().exec("python \"D:\\Poképédia\\Robot\\locdata_converter.py\"");
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
		    System.out.println(line);
		}
	}
	
	public void uploadLocations(boolean justOne) throws IOException {
		File folderPath = new File("D:\\Poképédia\\Robot\\dumps\\locdump_converted\\");

		File contents[] = folderPath.listFiles();
		
		
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].getName();
			contentString = contentString.replace("_", ":");
			contentString = contentString.replace(".txt", "");
			String uploadName		= "Module:Localisations/Données/" + contentString;
			
			Page filePage = new Page(uploadName);
			

			FileReader		fr		= new FileReader(contents[i]);
			BufferedReader	br		= new BufferedReader(fr);
			String			currentLine			= br.readLine();
			String 			locations = "";
			
			while (currentLine != null) {
				locations		+= currentLine + "\n";
				currentLine		= br.readLine();
			}
			currentLine		= br.readLine();
			
			Page page = new Page(uploadName);
			page.setContent(locations, "Mise à jour des localisations");
			System.out.println(uploadName + " ok");
			
			if (justOne) {
				break;
			}
		}
	}

	public void uploadFiles(File folderPath, String categories, boolean justOne) {
		
		File contents[] = folderPath.listFiles();
		
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			uploadName = uploadName.replace("Plume Blanc Réel ", "");
			String location = uploadName.replaceFirst(" (?<num>[0-9]*) PPk2.png", "").replace("Fichier:", "");
			String num = uploadName.replace(" PPk2.png", "").replaceAll("[^[0-9 ]*]", "").replace(" ", "");
			uploadName = uploadName.replaceFirst(" (?<num>[0-9]*) PPk2.png", " Plume Blanc Réel $1 PPk2.png");
			

			String descriptionHeader = "== Description ==\n\n";
			String description = "Plume Blanc Réel";
			if (!num.equals("")) {
				description += " " + num;
			}
			description += " du lieu [[" + location + "]] dans {{Jeu|PPk2}}.\n\n" + categories;
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				boolean uploaded = API.upload(uploadName, contents[i], descriptionHeader + description, description);

				Page filePage = new Page(uploadName);
				filePage.setContent(descriptionHeader + description, description);
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadCandies(File folderPath, boolean justOne) {
		
		File contents[] = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";
				
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				String pokemon			= uploadName.replace("Fichier:Sprite Bonbon ", "").replace(" GO.png", "");
				String ndex				= Integer.toString(PokeData.getPokemonNum(pokemon));
				ndex = "0".repeat(3 - ndex.length()) + ndex;
				String description = "[[Bonbon#Pokémon GO|Bonbon]] [[" + pokemon + "]] dans {{Jeu|GO}}.\n"
						+ "\n"
						+ "{{Informations Fichier\n"
						+ "| Source = [https://pokemongo.fandom.com/wiki/Category:Candy_assets Pokémon GO Wiki]\n"
						+ "| Auteur = [[Niantic]]\n"
						+ "}}\n"
						+ "\n"
						+ "[[Catégorie:Sprite de Bonbon (GO)|" + ndex + "]]";
				
				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i], descriptionHeader + description,
						description);
//						"Correction du fichier");
//						"Suppression des métadonnées");
				
				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
				page.setContent(descriptionHeader + description, description);
				
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadItems(File folderPath, String gamesShortName, String gamesLongName, boolean justOne) {
		
		File contents[] = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";
				
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				String itemName = uploadName.replace("Fichier:Miniature ", "").replace(" " + gamesShortName + ".png", "");
				if (itemName.substring(0, 2).equals("CT") || itemName.substring(0, 2).equals("CS")) {
					String ctcs = itemName.substring(0, 2);
					String type = itemName.substring(3);
					itemName = ctcs + "]] [[" + type + " (type)|" + type;
				}
				
				String description = "Miniature de l'objet [[" + itemName + "]] dans {{Jeu|" + gamesShortName
						+ "}}.\n\n[[Catégorie:Miniature d'objet (" + gamesLongName + ")]]";
				
				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i], descriptionHeader + description,
						description);
//						"Correction du fichier");
//						"Suppression des métadonnées");
				
				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
//				page.setContent(descriptionHeader + description, description);
				
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadSprites(File folderPath, String edit_description, String source, boolean rename, int starting_version, boolean justOne) {
		File contents[] = folderPath.listFiles();
		if (!source.equals("")) {
			source = "|source=" + source;
		}
		String description = "== Description ==\n{{#invoke:Description|sprite" + source + "}}";
		description = "";
		
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String ogUploadName		= "Fichier:" + contents[i].getName();
			String uploadName		= "Fichier:" + contents[i].getName();
			System.out.println(uploadName);
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				uploadName = uploadName.replace("interrogation", "?");

				
				Page filePage = new Page(uploadName);
				Page ogFilePage = new Page(uploadName);
				String fileContents = filePage.getContent();
				int version = starting_version;
				
				if (rename) {
					while (fileContents != null) {
						version++;
						uploadName = ogUploadName.replace(".png", "-v" + version + ".png");
	
						filePage = new Page(uploadName);
						fileContents = filePage.getContent();
						
					}
				}
				
//				if (version != 0) {
//					System.out.println("Renommage "+ogUploadName+" => "+uploadName);
//					 API.rename(ogUploadName, uploadName, false, "Renommage "+ogUploadName+" => "+uploadName);
//				}
				
				
				System.out.println("Upload "+uploadName);
				boolean uploaded = API.upload(uploadName, contents[i], description,
////						"Correction du fichier");
						edit_description);
				filePage.setContent(description, edit_description);
				
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadSprites(File folderPath, String gamesShortName, String gamesLongName, boolean justOne) {
		
		File contents[] = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";
				
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				String imageType = "Sprite";
				String categoryType = "Sprite";
				if (uploadName.contains("Fichier:Pose ")) {
					imageType = "Pose";
				}
				if (uploadName.contains("Fichier:Miniature ")) {
					imageType = "Miniature";
					categoryType = "Miniature";
				}
				String 		pokeNumberWithForm 	= uploadName.replace("Fichier:" + imageType + " ", "").replace(" " + gamesShortName + ".png", "");
				String[] 	pokeNumberSplit 	= pokeNumberWithForm.split(" ");
				String		pokeNumberString	= pokeNumberSplit[0];
				int 		pokeNumber 			= Integer.parseInt(pokeNumberString);
				String 		pokeName 			= PokeData.getPokemonName(pokeNumber);
				String 		nomSpecialForme 	= null;
				String 		formCategorySuffix 	= "";
				
				int pnsLength = pokeNumberSplit.length;
				int pnsBeginning = 1;
				
				if (pnsBeginning < pnsLength) {
					pnsBeginning++;
					
					
					switch(pokeNumberSplit[pnsBeginning - 1]) {
						case "Alola":
							pokeName += " d'Alola";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Galar":
							pokeName += " de Galar";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Hisui":
							pokeName += " de Hisui";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Méga":
							pokeName = "Méga-" + pokeName;
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Gigamax":
							pokeName += " Gigamax";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Infinimax":
							pokeName += " Infinimax";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Noir":
							if (pokeName == "Kyurem") {
								pokeName += " Noir";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Blanc":
							if (pokeName == "Kyurem") {
								pokeName += " Blanc";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Ailes de l'Auore":
							pokeName += " Ailes de l'Aurore";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Crinière du Couchant":
							pokeName += " Crinière du Couchant";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Ultra":
							if (pokeName == "Necrozma") {
								pokeName = "Ultra-" + pokeName;
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Cavalier du Froid":
							if (pokeName == "Sylveroy") {
								pokeName += " Cavalier du Froid";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Cavalier d'Effroi":
							if (pokeName == "Sylveroy") {
								pokeName += " Cavalier d'Effroi";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						default:
							pnsBeginning--;
							break;
					}
				}
				
				String last = pokeNumberSplit[pnsLength - 1];
				
				switch(pokeNumber) {
					case 25:	// Pikachu
						if (last.equals(pokeNumberString)) {
							break;
						} else if (last.equals("Cosplayeur") || last.equals("Rockeur") || last.equals("Lady")
								 || last.equals("Star") || last.equals("Docteur") || last.equals("Catcheur")
								 || last.equals("Partenaire")) {
							nomSpecialForme = "";
						} else if (pokeNumberSplit[1].equals("Casquette")) {
							nomSpecialForme = " à";
						}
						break;
					case 133:	// Évoli
						if (last.equals("Partenaire")) {
							nomSpecialForme = "";
						}
						break;
					case 201:	// Zarbi
						nomSpecialForme = "";
						formCategorySuffix = " " + pokeNumberSplit[pnsBeginning];
						break;
					case 412:	// Cheniti
						nomSpecialForme = " Cape";
						break;
					case 413:	// Cheniselle
						nomSpecialForme = " Cape";
						break;
					case 421:	// Ceriflor
						nomSpecialForme = " Temps";
						break;
					case 422:	// Sancoki
						nomSpecialForme = " Mer";
						break;
					case 423:	// Tritosor
						nomSpecialForme =  " Mer";
						break;
					case 479:	// Motisma
						nomSpecialForme = "";
						break;
					case 493:	// Arceus
						nomSpecialForme = " Type";
						break;
					case 550:	// Bargantua
						nomSpecialForme = " Motif";
						break;
					case 555:	// Darumacho
						nomSpecialForme = " Mode";
						if (last.equals("") || last.equals(pokeNumberString)) {
							nomSpecialForme += " Normal";
						}
						break;
					case 647:	// Keldeo
						nomSpecialForme = " Aspect";
						if (last.equals("") || last.equals(pokeNumberString)) {
							nomSpecialForme += " Normal";
						}
						break;
					case 649:	// Genesect
						if (!(last.equals("") || last.equals(pokeNumberString))) {
							nomSpecialForme = " avec son [[Module]]";
						}
						break;
					case 666:	// Prismillon
						nomSpecialForme = " Motif";
						break;
					case 669:	// Flabébé
						nomSpecialForme = " Fleur";
						break;
					case 670:	// Floette
						if (!pokeNumberSplit[pnsBeginning].equals("Éternelle")) {
							nomSpecialForme = " Fleur";
						}
						break;
					case 671:	// Florges
						nomSpecialForme = " Fleur";
						break;
					case 676:	// Couafarel
						if (!(last.equals("") || last.equals(pokeNumberString) || last.equals("Sauvage"))) {
							nomSpecialForme = " Coupe";
						}
						break;
					case 710:	// Pitrouille
						nomSpecialForme = " Taille";
						break;
					case 711:	// Banshitrouye
						nomSpecialForme = " Taille";
						break;
					case 716:	// Xerneas
						nomSpecialForme = " Mode";
						break;
					case 720:	// Hoopa
						nomSpecialForme = "";
						break;
					case 741:	// Plumeline
						nomSpecialForme = " Style";
					case 773:	// Silvallié
						nomSpecialForme = " dans sa [[forme]] Type : ";
						break;
					case 774:	// Météno
						if (!(last.equals("") || last.equals(pokeNumberString) || last.equals("Météore"))) {
							nomSpecialForme = " Noyau";
						}
						break;
					case 877:	// Morpeko
						nomSpecialForme = " Mode";
						break;
					case 892:	// Shifours
						nomSpecialForme = " Style";
						break;
				}
				
				
				// suffixes de forme
				String genre = "";
				if (pnsBeginning < pnsLength && pokeNumberSplit[pnsBeginning].equals("♂")) {
					genre = " mâle";
					pokeNumberSplit[pnsBeginning] = "";
					pnsBeginning++;
				} else if (pnsBeginning < pnsLength && pokeNumberSplit[pnsBeginning].equals("♀")) {
					genre = " femelle";
					pokeNumberSplit[pnsBeginning] = "";
					pnsBeginning++;
				}
				
				String dosDescription = "";
				String dosCategorie = "";
				if (pokeNumberSplit[pnsLength - 1].equals("dos")) {
					dosDescription = ", de dos,";
					dosCategorie = " de dos";
					pnsLength--;
				}
				
				String chromatiqueDescription = "";
				String chromatiqueCategorie = "";
				if (pokeNumberSplit[pnsLength - 1].equals("chromatique")) {
					chromatiqueDescription = " [[chromatique]]";
					chromatiqueCategorie = " chromatique";
					pnsLength--;
				}
				

				String forme = "";
				boolean formeInit = false;
				if (nomSpecialForme != null) {
					forme = nomSpecialForme;
					formeInit = true;
				}
				for (int j = 1; j < pnsLength; j++) {
					if (!pokeNumberSplit[j].equals("")) {
						if (!formeInit) {
							forme += " dans sa [[forme]] " + pokeNumberSplit[j];
							formeInit = true;
						} else {
							forme += " " + pokeNumberSplit[j];
						}
					}
				}

				
				String description = imageType + " " + Util.de(pokeName) + "[[" + pokeName + "]]" + genre + chromatiqueDescription
						+ forme + dosDescription + " dans {{Jeu|" + gamesShortName
						+ "}}.\n\n" + "Source : Serebii\n\n" + "[[Catégorie:Image Pokémon représentant " + pokeName + formCategorySuffix
						+ "]]\n[[Catégorie:" + categoryType + " Pokémon" + chromatiqueCategorie + dosCategorie + " (" + gamesLongName + ")]]";

				
				System.out.println(description);
				System.out.println("=============");
				
//				boolean uploaded = true;
				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i], descriptionHeader + description,
//						"Correction du fichier");
						description);
				Page filePage = new Page(uploadName);
				filePage.setContent(descriptionHeader + description, description);
				
				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(contentString);
//				page.setContent(descriptionHeader + description, description);
				
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadCards(File folderPath, File listPath, boolean justOne) throws IOException {
		FileReader		fr					= new FileReader(listPath);
		BufferedReader	br					= new BufferedReader(fr);
		
		String			delimiter			= "XXXXX";
		String			currentLine			= br.readLine();
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";
		

		File contents[] = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				while (currentLine != null && !(currentLine.equals(delimiter))) {
					description		+= currentLine + "\n";
					currentLine		= br.readLine();
				}
				currentLine		= br.readLine();
				

				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i],
						descriptionHeader + description, description);
				String uploadSituation;
				if (uploaded)
					uploadSituation = "ok";
				else
					uploadSituation = "PAS OK !!!!";
				System.out.println(description);

				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
				page.setContent(descriptionHeader + description, description);
				
				System.out.println(uploadName + " " + uploadSituation);
				

				if (justOne) {
					break;
				}
			}
		}
		
		br.close();
	}
	
	public void uploadAttacks(File folderPath, String gameShortName, String gameLongName, boolean upload, boolean justOne) throws IOException {		
		String			delimiter			= ";";
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";
		

		File contents[] = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String fileName			= contents[i].getName();
			
			if (fileName.substring(fileName.length()-4,fileName.length()).equals(".mp4")) {
				String nameList	= fileName.substring(0,fileName.length()-4);
				
				String[] listNames = nameList.split(delimiter);
				
				String attackName = listNames[0];
				String uploadName = "Fichier:" + attackName + " " + gameShortName + ".mp4";
				String[] attackLinkThenPrecision = attackName.split(" \\(");
				String attackLink = attackLinkThenPrecision[0];
				String attackPrecision = "";
				if (attackLinkThenPrecision.length > 1) {
					attackPrecision = " (" + attackLinkThenPrecision[1];
				}
				
				description += "Animation de la [[capacité]] [[" + attackLink + "]]" + attackPrecision
							+ " dans {{Jeu|" + gameShortName + "}}.\n\n"
							+ "[[Catégorie:Image de capacité de " + gameLongName + "]]";
				
				for(int j=1; j<listNames.length; j++) {
					description += "\n[[Catégorie:Image Pokémon représentant " + listNames[j] + "]]";
				}
				
				System.out.println("\n=== " + uploadName + " ===");
				System.out.println(description);

				if (upload) {
					boolean uploaded = API.upload(uploadName, contents[i],
							descriptionHeader + description, description);
					String uploadSituation;
					if (uploaded)
						uploadSituation = "ok";
					else
						uploadSituation = "PAS OK !!!!";
					System.out.println(description);
	
					// These two lines shouldn't do anything unless the description wasn't set by the upload before.
					// For instance, if there was already an existing version.
//					Page page = new Page(uploadName);
//					page.setContent(descriptionHeader + description, description);
					
					System.out.println(uploadName + " " + uploadSituation);
				}
				

				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadFilesWithDescriptions(File folderPath, File listPath, String fileExtension, boolean justOne, boolean upload) throws IOException {
		FileReader		fr					= new FileReader(listPath);
		BufferedReader	br					= new BufferedReader(fr);

		String			delimiter			= "XXXXX";
		String			currentLine			= br.readLine();
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";
		

		File contents[] = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(fileExtension)) {
				while (currentLine != null && !(currentLine.equals(delimiter))) {
					description		+= currentLine + "\n";
					currentLine		= br.readLine();
				}
				currentLine		= br.readLine();
				
				if (upload) {

					boolean uploaded = API.upload(uploadName, contents[i],
							descriptionHeader + description, description);
					String uploadSituation;
					if (uploaded)
						uploadSituation = "ok";
					else
						uploadSituation = "PAS OK !!!!";
					System.out.println(description);

					// These two lines shouldn't do anything unless the description wasn't set by the upload before.
					// For instance, if there was already an existing version.
					Page page = new Page(uploadName);
					page.setContent(descriptionHeader + description, description);
					
					System.out.println(uploadName + " " + uploadSituation);
				} else {
					System.out.println("==== " + uploadName + " ====");
					System.out.println(description);
				}
				

				

				if (justOne) {
					break;
				}
			}
		}
		
		br.close();
	}
	
	public void createSpriteRedirections(File listPath, String from, String to, String gameLongName, boolean justOne) throws IOException {
		FileReader		fr						= new FileReader(listPath);
		BufferedReader	br						= new BufferedReader(fr);

		String			delimiter				= "XXXXX";
		String			currentLine				= "currentLine";
		String			currentRedirectionPage	= "currentRedirectionPage";
		
		String 			category				= "Sprite Pokémon";

		
		while (!currentLine.equals("")) {
			currentLine				= br.readLine();
			currentRedirectionPage 	= currentLine.replace(to, from);
			category				= "Sprite Pokémon ";

			if (currentLine.contains(" chromatique ")) {
				category += "chromatique ";
			}
			if (currentLine.contains(" dos ")) {
				category += "de dos ";
			}
			category += "(" + gameLongName + ")";
				
			Page page = new Page(currentRedirectionPage);
			if (page.getContent() != null) {
				System.out.println(currentRedirectionPage + " was already written.");
				continue;
			}
			page.setContent("#REDIRECTION [[" + currentLine + "]]\n\n[[Catégorie:" + category + "]]", "Page redirigée vers [[" + currentLine + "]], ajout automatique de catégorie [[Catégorie:" + category + "]]");
			
			System.out.println(currentLine + " => " + currentRedirectionPage + " ok");

			if (justOne) {
				break;
			}
		}
		
		br.close();
	}
	
	public void deleteDuplicateFiles(boolean justOne) {
		String[] 	filesToKeep		= {"Miniature Lune Ball NB.png", "Miniature Plaque Fantô NB.png", "Miniature Niveau Ball NB.png", "Miniature Orbe Flamme NB.png", "Miniature Baie Charti NB.png", "Miniature Roche Chaude NB.png", "Miniature Masse Ball NB.png", "Miniature Foss. Plaque NB.png", "Miniature Bonbon Rage NB.png", "Miniature Plaque Hydro NB.png", "Miniature Baie Chocco NB.png", "Miniature Nœud Destin NB.png", "Miniature Ralentiqueue NB.png", "Miniature Orbe Vie NB.png", "Miniature Pierre Aube NB.png", "Miniature Baie Cobaba NB.png", "Miniature Baie Sédra NB.png", "Miniature Plaque Fer NB.png", "Miniature Roche Glace NB.png", "Miniature Bulbe NB.png", "Miniature Orbe Toxique NB.png", "Miniature B. Étreinte NB.png", "Miniature Lentil. Zoom NB.png", "Miniature Piquants NB.png", "Miniature Plaque Poing NB.png", "Miniature Balle Fer NB.png", "Miniature Boue Noire NB.png", "Miniature Foss. Armure NB.png", "Miniature Pierre Magma NB.png", "Miniature Plaque Herbe NB.png", "Miniature Plaque Terre NB.png", "Miniature Plaque Ombre NB.png", "Miniature Baie Pomroz NB.png", "Miniature Baie Babiri NB.png", "Miniature Baie Micle NB.png", "Miniature Pierre Éclat NB.png", "Miniature Baie Ratam NB.png", "Miniature Compét'Ball NB.png", "Miniature Speed Ball NB.png", "Miniature Plaque Volt NB.png", "Miniature Roche Lisse NB.png", "Miniature Plaquinsect NB.png", "Miniature Plaque Roc NB.png", "Miniature Plaque Toxic NB.png", "Miniature Roche Humide NB.png", "Miniature Lent. Pouv. NB.png", "Miniature Électiriseur NB.png", "Miniature Foss. Plume NB.png", "Miniature Pile NB.png", "Miniature Baie Lampou NB.png", "Miniature Baie Chérim NB.png", "Miniature Baie Kébia NB.png", "Miniature Lumargile NB.png", "Miniature Pierre Nuit NB.png", "Miniature Mémoire Ball NB.png", "Miniature Soin Ball NB.png", "Miniature Baie Pocpoc NB.png", "Miniature Plaquesprit NB.png", "Miniature Gracidée NB.png", "Miniature Copain Ball NB.png", "Miniature Love Ball NB.png", "Miniature Plaque Flam NB.png", "Miniature Plaque Draco NB.png", "Miniature Croc Rasoir NB.png", "Miniature Pt de Mire NB.png", "Miniature Baie Jaboca NB.png", "Miniature Baie Zalis NB.png", "Miniature Casque Brut NB.png", "Miniature Baie Pommo NB.png", "Miniature Baie Jouca NB.png", "Miniature Bouton Fuite NB.png", "Miniature Poképlumet NB.png", "Miniature Maxi Pépite NB.png", "Miniature Loupe NB.png", "Miniature Baie Nanone NB.png", "Miniature Rapide Ball NB.png", "Miniature Sombre Ball NB.png", "Miniature Carapace Mue NB.png", "Miniature Baie Fraigo NB.png", "Miniature Foss. Crâne NB.png", "Miniature Appât Ball NB.png", "Miniature Plaque Glace NB.png", "Miniature Rêve Ball NB.png", "Miniature Plaque Ciel NB.png", "Miniature Baie Panga NB.png", "Miniature Protecteur NB.png", "Miniature Baie Parma NB.png", "Miniature Magmariseur NB.png"};
		String[] 	filesToDelete	= {"Miniature Lune Ball SL.png", "Miniature Plaque Fantôme SL.png", "Miniature Niveau Ball SL.png", "Miniature Orbe Flamme SL.png", "Miniature Baie Charti SL.png", "Miniature Roche Chaude SL.png", "Miniature Masse Ball SL.png", "Miniature Fossile Plaque SL.png", "Miniature Bonbon Rage SL.png", "Miniature Plaque Hydro SL.png", "Miniature Baie Chocco SL.png", "Miniature Nœud Destin SL.png", "Miniature Ralentiqueue SL.png", "Miniature Orbe Vie SL.png", "Miniature Pierre Aube SL.png", "Miniature Baie Cobaba SL.png", "Miniature Baie Sédra SL.png", "Miniature Plaque Fer SL.png", "Miniature Roche Glace SL.png", "Miniature Bulbe SL.png", "Miniature Orbe Toxique SL.png", "Miniature Bande Étreinte SL.png", "Miniature Lentille Zoom SL.png", "Miniature Piquants SL.png", "Miniature Plaque Poing SL.png", "Miniature Balle Fer SL.png", "Miniature Boue Noire SL.png", "Miniature Fossile Armure SL.png", "Miniature Pierre Magma SL.png", "Miniature Plaque Herbe SL.png", "Miniature Plaque Terre SL.png", "Miniature Plaque Ombre SL.png", "Miniature Baie Pomroz SL.png", "Miniature Baie Babiri SL.png", "Miniature Baie Micle SL.png", "Miniature Pierre Éclat SL.png", "Miniature Baie Ratam SL.png", "Miniature Compét'Ball SL.png", "Miniature Speed Ball SL.png", "Miniature Plaque Volt SL.png", "Miniature Roche Lisse SL.png", "Miniature Plaque Insecte SL.png", "Miniature Plaque Roc SL.png", "Miniature Plaque Toxic SL.png", "Miniature Roche Humide SL.png", "Miniature Lentille Pouvoir SL.png", "Miniature Électriseur SL.png", "Miniature Fossile Plume SL.png", "Miniature Pile SL.png", "Miniature Baie Lampou SL.png", "Miniature Baie Chérim SL.png", "Miniature Baie Kébia SL.png", "Miniature Lumargile SL.png", "Miniature Pierre Nuit SL.png", "Miniature Mémoire Ball SL.png", "Miniature Soin Ball SL.png", "Miniature Baie Pocpoc SL.png", "Miniature Plaque Esprit SL.png", "Miniature Gracidée SL.png", "Miniature Copain Ball SL.png", "Miniature Love Ball SL.png", "Miniature Plaque Flamme SL.png", "Miniature Plaque Draco SL.png", "Miniature Croc Rasoir SL.png", "Miniature Point de Mire SL.png", "Miniature Baie Jaboca SL.png", "Miniature Baie Zalis SL.png", "Miniature Casque Brut SL.png", "Miniature Baie Pommo SL.png", "Miniature Baie Jouca SL.png", "Miniature Bouton Fuite SL.png", "Miniature Poké Plumet SL.png", "Miniature Maxi Pépite SL.png", "Miniature Loupe SL.png", "Miniature Baie Nanone SL.png", "Miniature Rapide Ball SL.png", "Miniature Sombre Ball SL.png", "Miniature Carapace Mue SL.png", "Miniature Baie Fraigo SL.png", "Miniature Fossile Crâne SL.png", "Miniature Appât Ball SL.png", "Miniature Plaque Glace SL.png", "Miniature Rêve Ball SL.png", "Miniature Plaque Ciel SL.png", "Miniature Baie Panga SL.png", "Miniature Protecteur SL.png", "Miniature Baie Parma SL.png", "Miniature Magmariseur SL.png"};
		String		category		= "[[Catégorie:Miniature d'objet (Soleil et Lune)]]";
		
		for(int i = 0; i < filesToKeep.length; i++) {
			String	toKeep			= "Fichier:" + filesToKeep[i];
			String	toDelete		= "Fichier:" + filesToDelete[i];
			Page	pageToKeep		= new Page(toKeep);
			Page	pageToDelete	= new Page(toDelete);
			
//			API.delete(toDelete, "Remplacement par une redirection vers le fichier identique [[" + toKeep + "]]");
			pageToDelete.setContent("#REDIRECTION [[" + toKeep + "]]\n\n" + category, "Création de redirection vers [[" + toKeep + "]]");
			
			System.out.println("ok: " + toKeep + " => " + toDelete);
			
			if (justOne) {
				break;
			}
			
		}
	}
	
	
	public void addDex(String region, boolean secondary, boolean justOne) {
		String[][] theList = {{"002", "Efflèche"}, {"004", "Héricendre"}, {"005", "Feurisson"}, {"006", "Typhlosion de Hisui"}, {"007", "Moustillon"}, {"008", "Mateloutre"}, {"009", "Clamiral de Hisui"}, {"010", "Keunotor"}, {"011", "Castorno"}, {"012", "Étourmi"}, {"013", "Étourvol"}, {"014", "Étouraptor"}, {"015", "Lixy"}, {"016", "Luxio"}, {"017", "Luxray"}, {"018", "Chenipotte"}, {"019", "Armulys"}, {"020", "Charmillon"}, {"021", "Blindalys"}, {"022", "Papinox"}, {"023", "Ponyta"}, {"024", "Galopa"}, {"025", "Évoli"}, {"026", "Aquali"}, {"027", "Voltali"}, {"028", "Pyroli"}, {"029", "Mentali"}, {"030", "Noctali"}, {"031", "Phyllali"}, {"032", "Givrali"}, {"033", "Nymphali"}, {"034", "Nosferapti"}, {"035", "Nosferalto"}, {"036", "Nostenfer"}, {"037", "Baudrive"}, {"038", "Grodrive"}, {"039", "Crikzik"}, {"040", "Mélokrik"}, {"041", "Mustébouée"}, {"042", "Mustéflott"}, {"043", "Cheniti"}, {"044", "Cheniselle"}, {"045", "Papilord"}, {"046", "Racaillou"}, {"047", "Gravalanch"}, {"048", "Grolem"}, {"049", "Cerfrousse"}, {"050", "Cerbyllin"}, {"051", "Goinfrex"}, {"052", "Ronflex"}, {"053", "Paras"}, {"054", "Parasect"}, {"055", "Pichu"}, {"056", "Pikachu"}, {"057", "Raichu"}, {"058", "Abra"}, {"059", "Kadabra"}, {"060", "Alakazam"}, {"061", "Ouisticram"}, {"062", "Chimpenfeu"}, {"063", "Simiabraz"}, {"064", "Laporeille"}, {"065", "Lockpin"}, {"066", "Ceribou"}, {"067", "Ceriflor"}, {"068", "Psykokwak"}, {"069", "Akwakwak"}, {"070", "Apitrini"}, {"071", "Apireine"}, {"072", "Insécateur"}, {"073", "Cizayox"}, {"074", "Hachécateur"}, {"075", "Scarhino"}, {"076", "Mime Jr."}, {"077", "M. Mime"}, {"078", "Capumain"}, {"079", "Capidextre"}, {"080", "Magicarpe"}, {"081", "Léviator"}, {"082", "Sancoki"}, {"083", "Tritosor"}, {"084", "Qwilfish de Hisui"}, {"085", "Qwilpik"}, {"086", "Ptiravi"}, {"087", "Leveinard"}, {"088", "Leuphorie"}, {"089", "Rozbouton"}, {"090", "Rosélia"}, {"091", "Roserade"}, {"092", "Vortente"}, {"093", "Chlorobule"}, {"094", "Fragilady de Hisui"}, {"095", "Saquedeneu"}, {"096", "Bouldeneu"}, {"097", "Barloche"}, {"098", "Barbicha"}, {"099", "Cradopaud"}, {"100", "Coatox"}, {"101", "Tarsal"}, {"102", "Kirlia"}, {"103", "Gardevoir"}, {"104", "Gallame"}, {"105", "Yanma"}, {"106", "Yanmega"}, {"107", "Hippopotas"}, {"108", "Hippodocus"}, {"109", "Pachirisu"}, {"110", "Moufouette"}, {"111", "Moufflair"}, {"112", "Teddiursa"}, {"113", "Ursaring"}, {"114", "Ursaking"}, {"115", "Mucuscule"}, {"116", "Colimucus de Hisui"}, {"117", "Muplodocus de Hisui"}, {"118", "Onix"}, {"119", "Steelix"}, {"120", "Rhinocorne"}, {"121", "Rhinoféros"}, {"122", "Rhinastoc"}, {"123", "Manzaï"}, {"124", "Simularbre"}, {"125", "Excelangue"}, {"126", "Coudlangue"}, {"127", "Togepi"}, {"128", "Togetic"}, {"129", "Togekiss"}, {"130", "Tortipouss"}, {"131", "Boskara"}, {"132", "Torterra"}, {"133", "Porygon"}, {"134", "Porygon2"}, {"135", "Porygon-Z"}, {"136", "Fantominus"}, {"137", "Spectrum"}, {"138", "Ectoplasma"}, {"139", "Spiritomb"}, {"140", "Cornèbre"}, {"141", "Corboss"}, {"142", "Zarbi"}, {"143", "Obalie"}, {"144", "Phogleur"}, {"145", "Kaimorse"}, {"146", "Rémoraid"}, {"147", "Octillery"}, {"148", "Rapion"}, {"149", "Drascore"}, {"150", "Caninos de Hisui"}, {"151", "Arcanin de Hisui"}, {"152", "Chaglam"}, {"153", "Chaffreux"}, {"154", "Machoc"}, {"155", "Machopeur"}, {"156", "Mackogneur"}, {"157", "Pijako"}, {"158", "Skelénox"}, {"159", "Téraclope"}, {"160", "Noctunoir"}, {"161", "Tiplouf"}, {"162", "Prinplouf"}, {"163", "Pingoléon"}, {"164", "Babimanta"}, {"165", "Démanta"}, {"166", "Bargantua"}, {"167", "Paragruel"}, {"168", "Goupix"}, {"168", "Goupix d'Alola"}, {"169", "Feunard"}, {"169", "Feunard d'Alola"}, {"170", "Tentacool"}, {"171", "Tentacruel"}, {"172", "Écayon"}, {"173", "Luminéon"}, {"174", "Magby"}, {"175", "Magmar"}, {"176", "Maganon"}, {"177", "Magnéti"}, {"178", "Magnéton"}, {"179", "Magnézone"}, {"180", "Archéomire"}, {"181", "Archéodong"}, {"182", "Élekid"}, {"183", "Élektek"}, {"184", "Élekable"}, {"185", "Scorplane"}, {"186", "Scorvol"}, {"187", "Griknot"}, {"188", "Carmache"}, {"189", "Carchacrok"}, {"190", "Tarinor"}, {"191", "Tarinorme"}, {"192", "Voltorbe de Hisui"}, {"193", "Électrode de Hisui"}, {"194", "Motisma"}, {"195", "Korillon"}, {"196", "Éoko"}, {"197", "Feuforêve"}, {"198", "Magirêve"}, {"199", "Mélo"}, {"200", "Mélofée"}, {"201", "Mélodelfe"}, {"202", "Farfuret"}, {"202", "Farfuret de Hisui"}, {"203", "Farfurex"}, {"204", "Dimoret"}, {"205", "Stalgamin"}, {"206", "Oniglali"}, {"207", "Momartik"}, {"208", "Kranidos"}, {"209", "Charkos"}, {"210", "Dinoclier"}, {"211", "Bastiodon"}, {"212", "Marcacrin"}, {"213", "Cochignon"}, {"214", "Mammochon"}, {"215", "Grelaçon"}, {"216", "Séracrawl de Hisui"}, {"217", "Blizzi"}, {"218", "Blizzaroi"}, {"219", "Zorua de Hisui"}, {"220", "Zoroark de Hisui"}, {"221", "Furaiglon"}, {"222", "Gueriaigle de Hisui"}, {"223", "Riolu"}, {"224", "Lucario"}, {"225", "Créhelf"}, {"226", "Créfollet"}, {"227", "Créfadet"}, {"228", "Heatran"}, {"229", "Regigigas"}, {"230", "Cresselia"}, {"231", "Fulguris"}, {"232", "Boréas"}, {"233", "Démétéros"}, {"234", "Amovénus"}, {"235", "Dialga"}, {"236", "Palkia"}, {"237", "Giratina"}, {"238", "Arceus"}, {"239", "Phione"}, {"240", "Manaphy"}, {"241", "Shaymin"}, {"242", "Darkrai"}};
		for (String[] couple : theList) {
			String num = couple[0];
			String pokeName = couple[1];
			
			Page pokePage = new Page(pokeName);
			
			String contents = pokePage.getContent();
			String patternSearch;
			String patternSetBeginning;
			
			if (secondary) {
				if (!contents.contains("dex-secondaires"))  {
					patternSearch = "(?<name>\\|[ ]*dex[ ]*=[^\n]*)\n";
					patternSetBeginning = "$1//";
				} else {
					patternSearch = "(?<name>\\|[ ]*dex-secondaires[ ]*=[^\n]*)\n";
					patternSetBeginning = "$1\n| dex-secondaires=";
				}
			} else {
				if (!contents.contains("| dex"))  {
					patternSearch = "(?<name>\\|[ ]*ndex[ ]*=[^\n]*)\n";
					patternSetBeginning = "$1\n| dex=";
				} else {
					patternSearch = "(?<name>\\|[ ]*dex[ ]*=[^\n]*)\n";
					if (contents.contains("dex=\n") || contents.contains("dex= \n")) {
						patternSetBeginning = "$1";
					} else {
						patternSetBeginning = "$1//";
					}
				}
			}
			Pattern p = Pattern.compile(patternSearch, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
			
			String newContents = p.matcher(contents).replaceAll(patternSetBeginning + region + "/" + num + "\n");
			
//			System.out.println(newContents);
			pokePage.setContent(newContents, "Ajout du numéro de Pokédex de la région " + Util.de(region) + region);
			
			if (justOne) {
				break;
			}
		}
	}
	
	/**
	 * Méthode de remplacement specifique objets et monnaue PDM 
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au remplacement appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param trigger une chaine de texte devant être présente dans les pages pour déclencher le remplacement. Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Évite de casser plein de pages durant les tests.
	 **/
	public void replacePDMCash(String from, int[] nameSpaces, String categoryName, String trigger, String firstPageName, boolean justOne) {
		String to = null;
		
		PageCollection pagesG3 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la troisième génération");
		PageCollection pagesG4 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la quatrième génération");
		PageCollection pagesG5 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la cinquième génération");
		PageCollection pagesG6 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la sixième génération");
		
		PageCollection pageCollection = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, categoryName);
		
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String text;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			if(pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM1}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM2}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM3}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM4}}";
			} else {
				to = null;
			}

			if(to!=null) {
				try {
					text = page.getContent(false);
					if(text!=null && (trigger==null || text.indexOf(trigger)!=-1)) {
						System.out.println("FOUND in page ["+page.getTitle()+"]");
	
						String newText = text.replaceAll(from, to);
	
						if(!newText.equals(text)) {
							page.setContent(newText, "Remplacement "+from+" => "+to);
							System.out.println("\tSaved");
							if(justOne) {
								break;
							}
						} else {
							System.out.println("\tSkipped (no change)");
						}
					}
				} catch (Exception e) {
					System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
					e.printStackTrace();
				}
			} else {
				System.out.println("\tSkipped (multigen)");
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}
	
	/**
	 * Méthode de renommage générique. Les tableaux "from" et "to" fonctionnent de paire et doivent donc être de même longueur.
	 * @param from chaines à remplacer (regexp)
	 * @param to chaines de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au renommage appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param keepRedirect true pour maintenir une redirection entre l'ancien et le nouveau nom, false sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Evite de casser plein de pages durant les tests.
	 **/
	public void renameTrainerSprites(String[] from, String[] to, int[] nameSpaces, String categoryName, String firstPageName, boolean keepRedirect, boolean justOne) {
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
						API.FILTER_NONREDIRECTS,
						categoryName
				);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String pageName;
		String newPageName;
		String text;
		int numFromTo;
		while(page!=null) {
			if(counter>=100) {
				//System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();
				newPageName = pageName;
				for(numFromTo=0; numFromTo<from.length; numFromTo++) {
					newPageName = newPageName.replaceAll(from[numFromTo], to[numFromTo]);
				}
				if(!newPageName.equals(pageName)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");
					text = page.getContent(false);
					if(Util.count(text, "[Cc]at[ée]gor[iy]e?\\s*:\\s*[Ss]prite personnage") + Util.count(text, "[Cc]at[ée]gor[iy]e?\\s*:\\s*[Mm]iniature personnage") > 1) {
						System.err.println("\tCannot save : multiple categories for ["+page.getTitle()+"]");
					} else {
						API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
						System.out.println("\tSaved");
					}
					if(justOne) {
						break;
					}
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}

	
	/**
	 * Méthode de renommage générique 
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au renommage appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param keepRedirect true pour maintenir une redirection entre l'ancien et le nouveau nom, false sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Evite de casser plein de pages durant les tests.
	 **/
	public void rename(String from, String to, int[] nameSpaces, String categoryName, String firstPageName, boolean keepRedirect, boolean justOne) {
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
						API.FILTER_NONREDIRECTS,
						categoryName
				);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String pageName;
		String newPageName;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();
				newPageName = pageName.replaceAll(from, to);
				if(!newPageName.equals(pageName)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");
					API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
					System.out.println("\tSaved");
					if(justOne) {
						break;
					}
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}
	
	/**
	 * Méthode de remplacement générique 
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au remplacement appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param trigger une chaine de texte devant être présente dans les pages pour déclencher le remplacement. Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Evite de casser plein de pages durant les tests.
	 **/
	public void replace(String from, String to, int[] nameSpaces, String categoryName, String trigger, String firstPageName, boolean justOne) {
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
						API.FILTER_NONREDIRECTS,
						categoryName
				);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String text;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				text = page.getContent(false);
				if(text!=null && (trigger==null || text.indexOf(trigger)!=-1)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");

					String newText = text.replaceAll(from, to);

					if(!newText.equals(text)) {
						page.setContent(newText, "Remplacement "+from+" => "+to);
						System.out.println("\tSaved");
						if(justOne) {
							break;
						}
					} else {
						System.out.println("\tSkipped (no change)");
					}
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}

	/**
	 * Upload tout le contenu d'un dossier et affecte les images à la catégorie indiquée.
	 * @param path le chemin local vers un dossier contenu tous les fichiers à uploader.
	 * @param categoryName le nom de la catégorie à laquelle les fichiers doivent être attachés (sans namespace devant).
	 */
	public void upload(String path, String categoryName) {
		File folder = new File(path);
		if(!folder.exists() || !folder.isDirectory()) {
			System.out.println("path is not a valid folder");
			return;
		}
		File[] files = folder.listFiles();
		for(int i=0; i<files.length; i++) {
			try {
				if(files[i].isFile()) {
					StringBuffer uploadName = new StringBuffer("Fichier:");
					uploadName.append(files[i].getName());

					StringBuffer description = new StringBuffer();
					description.append("[[Catégorie:"+categoryName+"]]\n");

					API.upload(uploadName.toString(), files[i], "", "Upload "+categoryName);
					Page page = new Page(uploadName.toString());
					page.setContent(description.toString(), "Upload "+categoryName);
					System.out.println("\t["+uploadName.toString()+"] ok");
				}
			} catch (Exception e) {
				System.out.println("["+files[i].getName()+"] "+e.getMessage());
			}
		}
	}


	public void sync() {
		System.out.println("sync start");
		PageCollection pageCollection = new PageCollection(API.NS_ALL, API.FILTER_ALL);
		Page page = pageCollection.getNextPage();
		int counter = 0;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}
			page.sync();
			page = pageCollection.getNextPage();
			counter++;
		}
		System.out.println("sync stop");
	}

}
