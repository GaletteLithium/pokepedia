package silvallie.modules.upload;

import silvallie.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class uploadSprites {
	public static void main(String[] args) throws InterruptedException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Images\\Friends\\Peluches\\");
		String extension = "png";
		String edit_description = "Upload peluches Friends";
		String source = "Extraction réalisée par {{ut|SombrAbsol}}.";
		boolean createGeneralRedirection = false;
		boolean rename = false;
		int starting_version = 0;
		boolean justOne = true;


		File contents[] = folderPath.listFiles();
		boolean eraseRedirectsAnyway = true;
		if (!source.equals("")) {
			source = "|source=" + source;
		}
		String description = "== Description ==\n{{#invoke:Description|sprite" + source + "}}";
		// description = "";

		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String ogUploadName		= "Fichier:" + contents[i].getName();
			String uploadName		= "Fichier:" + contents[i].getName();
			System.out.println(uploadName);
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals("." + extension)) {
				uploadName = uploadName.replace("interrogation", "?");


				Page filePage = new Page(uploadName);
				Page ogFilePage = new Page(uploadName);
				String fileContents = filePage.getContent();
				int version = starting_version;


				if (createGeneralRedirection) {

					String generalRedirectionName = uploadName.replaceFirst(" [^\\s]*\\." + extension, "." + extension);
					Page generalRedirectionPage = new Page(generalRedirectionName);
					String generalRedirectionContents = generalRedirectionPage.getContent();

					if (generalRedirectionContents == null || !(generalRedirectionContents.contains("#REDIRECT"))) {
						Login.login("Matt.");
						API.delete(generalRedirectionName, "[Modification par robot] Page supprimée pour permettre une nouvelle redirection");
						Login.login("Silvallié");
					}
					generalRedirectionPage.setContent("#REDIRECTION [[" + uploadName + "]]\n[[Catégorie:Miniature Pokémon]]",
							"Redirection vers [[" + uploadName + "]]");

				}
				else if (rename) {
					while (fileContents != null) {
						version++;
						uploadName = ogUploadName.replace(".png", "-v" + version + "." + extension);

						filePage = new Page(uploadName);
						fileContents = filePage.getContent();

					}
				}

				if (version != 0) {
					System.out.println("Renommage "+ogUploadName+" => "+uploadName);
					API.rename(ogUploadName, uploadName, false, "Renommage "+ogUploadName+" => "+uploadName);
				}
				// to erase
				if (eraseRedirectsAnyway || !fileContents.contains("#REDIRECT")) {

					System.out.println("Upload "+ogUploadName);
					boolean uploaded = API.upload(ogUploadName, contents[i], description,
							////						"Correction du fichier");
							edit_description);
					// filePage.setContent(description, edit_description);

					if (justOne) {
						break;
					}
				}

				TimeUnit.SECONDS.sleep(1);
			}
		}

		Silvallie.endRun(startTime);
	}

	public static void deprecated(String[] args) {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Images\\Friends\\Peluches\\");
		String gamesShortName = "EB";
		String gamesLongName = "Épée et Bouclier";
		boolean justOne = true;



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

		Silvallie.endRun(startTime);
	}
}
