package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.File;

public class uploadItems {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Images\\EV\\objets\\objetsOrdonnésRenommésFiltrés\\no_metadata");
		boolean justOne = true;

		File[] contents = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";

		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();

			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				// Computing the games names from the item title
				String[] uploadNameSplit = uploadName.split(" ");
				String gamesShortName = uploadNameSplit[uploadNameSplit.length - 1];
				gamesShortName = gamesShortName.substring(0, gamesShortName.length()-4);
				String gamesLongName = Util.gamesShortToGamesLong(gamesShortName);

				String itemName = uploadName.replace("Fichier:Miniature ", "").replace(" " + gamesShortName + ".png", "");
				String suffixItemName = "";
				String suffixItemName2 = "";

				// Reworking the item name if needed
				if (itemName.contains(" (tenu)")) {
					itemName = itemName.replace(" (tenu)", "");
					suffixItemName2 = suffixItemName2 + " (tenu)";
				}
				if (itemName.contains(" (inutilisé)")) {
					itemName = itemName.replace(" (inutilisé)", "");
					suffixItemName2 = suffixItemName2 + " (inutilisé)";
				}

				if (itemName.substring(0, 2).equals("CT") || itemName.substring(0, 2).equals("CS") || itemName.substring(0, 2).equals("DT")) {
					String ctcsdt = itemName.substring(0, 2);
					String type = itemName.substring(3);
					itemName = ctcsdt + "]] [[" + type + " (type)|" + type;
				}

//				if (!itemName.contains("Œ")) {
//					continue;
//				}


				// Items that have special links
				if (itemName.length() > 15 && itemName.substring(0, 15).equals("Lettre Végétale")) {
					String letter = itemName.substring(0, 15);
					String pokemon = itemName.substring(15);
					itemName = letter;
					suffixItemName = suffixItemName + pokemon;
				}
				if (itemName.length() > 14 && itemName.substring(0, 14).equals("Malle Penderie")) {
					String malle = itemName.substring(0, 14);
					String color = itemName.substring(14);
					itemName = malle;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 12 && itemName.substring(0, 12).equals("Moticyclette")) {
					String bike = itemName.substring(0, 12);
					String color = itemName.substring(12);
					itemName = bike;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 10 && itemName.substring(0, 10).equals("Bicyclette")) {
					String bike = itemName.substring(0, 10);
					String color = itemName.substring(10);
					itemName = bike;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 7 && itemName.substring(0, 7).equals("Holokit")) {
					String holokit = itemName.substring(0, 7);
					String color = itemName.substring(7);
					itemName = holokit;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 9 && itemName.substring(0, 9).equals("Météorite")) {
					String meteorite = itemName.substring(0, 9);
					String color = itemName.substring(9);
					itemName = meteorite;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 5 && itemName.substring(0, 5).equals("Vokit")) {
					String vokit = itemName.substring(0, 5);
					String color = itemName.substring(5);
					itemName = vokit;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.equals("Œuf (objet)")) {
					itemName = "Œuf";
				}

				// Homonymies
				String itemNameHomonymy = Util.addHomonymy(itemName, gamesShortName);
				if (!itemName.equals(itemNameHomonymy)) {
					itemName = itemNameHomonymy + "|" + itemName;
				}
				String itemLink = "[[" + itemName + "]]";

				// Computing the description of the file
				String description = "Miniature de l'objet " + itemLink + suffixItemName + suffixItemName2 + " dans {{Jeu|" + gamesShortName + "}}."
						+ "\n\n{{Informations Fichier\n"
						+ "| Source = Extraction réalisée par {{Ut|SombrAbsol}}.\n"
						+ "| Auteur = " + Util.gamesShortToEditor(gamesShortName) + "\n"
						+ "}}"
						+ "\n\n[[Catégorie:Miniature d'objet (" + gamesLongName + ")]]";

				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i], descriptionHeader + description,
						description);

//						"Correction du fichier");
//						"Suppression des métadonnées");

				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
				page.setContent(descriptionHeader + description, description);

//				boolean uploaded = false;
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}

				System.out.println(uploadName + " " + uploadSituation);
//				System.out.println(description);

				if (justOne) {
					break;
				}
			}
		}

		Silvallie.endRun(startTime);
	}
}
