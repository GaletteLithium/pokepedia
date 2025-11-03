package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.File;
import java.io.IOException;

public class uploadAttacks {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Images\\PBR\\Capacités Pokémon Battle Revolution\\");
		String gameShortName = "PBR";
		String gameLongName = "Battle Revolution";
		String extension = ".mp4";
		String source = "Capture d'écran par {{Ut|Ludghe}}";
		String author = "[[GAME FREAK (studio de développement)|GAME FREAK]]";
		boolean addToPage = true;
		boolean upload = true;
		boolean justOne = true;

		run(folderPath, gameShortName, gameLongName, extension, source, author, addToPage, upload, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Uploads attack animations from a given folder
	 * @param folderPath Path to the folder containing the attack images to upload
	 * @param gameShortName Abbreviated form of the games the artworks originate from, used in the files' title (example: EV)
	 * @param gameLongName Long form of the games the artworks originate from, used in the category (example: Écarlate et Violet)
	 * @param extension The extension of the files (example: .mp4)
	 * @param source The source of the files to add in the description
	 * @param author The author of the files to add in the description
	 * @param addToPage Set to true to automatically add the attack animation to the attack page
	 * @param upload Set to true to upload the attack animation
	 * @param justOne Set to true to stop after the first upload. Please use this on the first run to avoid accidents
	 */
	private static void run(File folderPath, String gameShortName, String gameLongName, String extension, String source, String author, boolean addToPage, boolean upload, boolean justOne) {
		String			delimiter			= "&";
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";

		File[] contents = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String fileName			= contents[i].getName();

			if (fileName.endsWith(extension)) {
				String nameList	= fileName.substring(0,fileName.length()-4);
				nameList = nameList.replace("_", "'");
				nameList = nameList.replace("$", "&");
				nameList = nameList.replace(" " + gameShortName + "&", "&");

				String[] listNames = nameList.split(delimiter);

				String attackName = listNames[0];
				String uploadName = "Fichier:" + attackName + " " + gameShortName + extension;
				String[] attackLinkThenPrecision = attackName.split(" \\(");
				String attackLink = attackLinkThenPrecision[0];
				String attackPrecision = "";
				if (attackLinkThenPrecision.length > 1) {
					attackPrecision = " (" + attackLinkThenPrecision[1];
				}

//				if (skip && !attackLink.equals("Clairvoyance")) {
//					continue;
//				} else {
//					skip = false;
//				}

				// homonymies
				Page attackPage = new Page(attackLink);
				String attackPageContents = attackPage.getContent();
				if (attackPageContents.contains("{{homonymie}}") || attackPageContents.contains("{{Homonymie}}")) {
					attackLink = attackLink + " (capacité)|" + attackLink;
				}

				description += "Animation de la [[capacité]] [[" + attackLink + "]]" + attackPrecision
						+ " dans {{Jeu|" + gameShortName + "}}.\n\n"
						+ "{{Informations Fichier\n"
						+ "| Source = " + source + ".\n"
						+ "| Auteur = " + author + "\n"
						+ "}}\n\n"
						+ "[[Catégorie:Image de capacité de Pokémon " + gameLongName + "]]";

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
//					System.out.println(description);

					// These two lines shouldn't do anything unless the description wasn't set by the upload before.
					// For instance, if there was already an existing version.
					Page page = new Page(uploadName);
					page.setContent(descriptionHeader + description, description);

					System.out.println(uploadName + " " + uploadSituation);
				}

				if (addToPage) {
					attackPage = new Page(attackLink.replaceAll("\\|[^\n]*", ""));
					String attackPageContentsOrigins = attackPage.getContent();

//					Pattern p = Pattern.compile("(?<a>{{#invoke:Représentations antérieures[^}]*)}}");
//
//					boolean firstGame = true;
//					Stream<MatchResult> strings = p.matcher(attackPageContents).results();
//
//					for (MatchResult m : (Iterable<MatchResult>) () -> strings.iterator()) {
//
//						String game = attackPageContents.subSequence(m.start() + 1, attackPageContents.indexOf(".", m.start())).toString();
//						if (firstGame) {
//							firstGame = false;
//						} else {
//							attackPageContents = attackPageContents + "/";
//						}
//						gamesString = gamesString + game;
//					}
//					attackPageContents.replaceFirst(attackPrecision, attackPageContents)

//					attackPageContents = attackPageContentsOrigins.replaceFirst("(?<a>\\{\\{#invoke:Représentations antérieures[^\\n]*)\\}\\}", "$1/NB}}");
					attackPageContents = attackPageContentsOrigins.replaceFirst(
							"(?<a>\\{\\{#invoke:Représentations antérieures[^\\n]*)\\}\\}",
							"=== Jeux principaux ===\n$1}}\n\n=== Jeux secondaires ===\n" +
									"{{#invoke:Représentations antérieures|capacite|" + gameShortName + "}}");

//					attackPageContents = attackPageContents.replace("LPA/NB", "NB/LPA");
//					attackPageContents = attackPageContents.replace("DEPS/NB", "NB/DEPS");
//					attackPageContents = attackPageContents.replace("EB/NB", "NB/EB");
//					attackPageContents = attackPageContents.replace("LGPE/NB", "NB/LGPE");
//					attackPageContents = attackPageContents.replace("USUL/NB", "NB/USUL");
//					attackPageContents = attackPageContents.replace("SL/NB", "NB/SL");
//					attackPageContents = attackPageContents.replace("ROSA/NB", "NB/ROSA");
//					attackPageContents = attackPageContents.replace("XY/NB", "NB/XY");
//					attackPageContents = attackPageContents.replace("N2B2/NB", "NB/N2B2");
//					attackPageContents = attackPageContents.replace("NB/NB/", "NB/");

					attackPageContents = attackPageContents.replace("=== Jeux principaux ===\n=== Jeux principaux ===", "=== Jeux principaux ===");
					attackPageContents = attackPageContents.replaceAll(
							"=== Jeux secondaires ===\n\\{\\{#invoke:Représentations antérieures\\|capacite\\|" + gameShortName + "\\}\\}\\n+" +
									"=== Jeux secondaires ===\n\\{\\{#invoke:Représentations antérieures\\|capacite\\|([^\\}]*)\\}\\}",

							"=== Jeux secondaires ===\n{{#invoke:Représentations antérieures|capacite|$1/" + gameShortName + "}}");

					attackPageContents = attackPageContents.replace(gameShortName + "/" + gameShortName, gameShortName);
					attackPageContents = attackPageContents.replace("XD/Colo", "Colo/XD");
//					System.out.println(attackPageContents);

					if (upload) {
						attackPage.setContent(attackPageContents, "Ajout de la capacité " + gameShortName + " aux représentations antérieures");
					} else {
						System.out.println(attackPageContents);
					}

					if (attackPageContentsOrigins.equals(attackPageContents)) {
						System.out.println("\n --- Page was unchanged.");
					} else {
						System.out.println("\n --- Added the image to the page!");
					}
				}

				if (justOne) {
					break;
				}
			}
		}
	}
}
