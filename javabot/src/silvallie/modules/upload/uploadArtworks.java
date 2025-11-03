package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.File;

public class uploadArtworks {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Images\\CA\\25-05\\");
		String gamesShortName = "CA";
		String gamesLongName = "Écarlate et Violet";
		boolean generalArtworkRedirection = true;
		boolean justOne = false;

		run(folderPath, gamesShortName, gamesLongName, generalArtworkRedirection, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Uploads Pokémon artworks from a given folder
	 * @param folderPath Path to the folder containing the artworks to upload
	 * @param gamesShortName Abbreviated form of the games the artworks originate from, used in the files' title (example: EV)
	 * @param gamesLongName Long form of the games the artworks originate from, used in the category (example: Écarlate et Violet)
	 * @param generalArtworkRedirection Set to true to create a general redirection (example: Pikachu.png -> Pikachu-EV.png)
	 * @param justOne Set to true to stop after the first upload. Please use this on the first run to avoid accidents
	 */
	static void run(File folderPath, String gamesShortName, String gamesLongName, boolean generalArtworkRedirection, boolean justOne) {
		File[] contents = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";

		assert contents != null;
		for (File content : contents) {
			String uploadName = "Fichier:" + content.getName();
			String uploadNameGame = uploadName.replace(".png", "-" + gamesShortName + ".png");
			// System.out.println(uploadName + "\t" + uploadNameGame);

			if (uploadName.endsWith(".png")) {
				String pokeName = uploadName.replace("Fichier:", "").replace(".png", "");
				String form = pokeName.replaceAll("[^(]*(?<a> \\(.*)", "$1");
				// System.out.println(form);
				if (form.equals(pokeName)) {
					form = "";
				}
				pokeName = pokeName.replaceAll(" \\((?<a>[^)]*)\\)", "");


				String description = "Artwork " + Util.de(pokeName) + "[[" + pokeName + "]]" + form + " pour {{Jeu|" + gamesShortName
						+ "}}.\n\n{{Informations Fichier\n"
						+ "| Source = [https://zukan.pokemon.co.jp/ Site du Pokédex japonais]\n"
						+ "| Auteur = [[The Pokémon Company]]\n"
						+ "}}\n\n[[Catégorie:Artwork Pokémon " + Util.de(gamesLongName) + gamesLongName + "]]\n"
						+ "[[Catégorie:Image Pokémon représentant " + pokeName + "]]";

				boolean uploaded = API.upload(uploadNameGame, content, descriptionHeader + description,
						description);
//						"Correction du fichier");
//						"Suppression des métadonnées");

				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadNameGame);
				page.setContent(descriptionHeader + description, description);


				// Redirection artwork général
				if (generalArtworkRedirection) {
					Page redirectionPage = new Page(uploadName);
					redirectionPage.setContent("#REDIRECTION [[" + uploadNameGame + "]]\n[[Catégorie:Artwork Pokémon]]", "Redirection vers [[" + uploadNameGame + "]]");
				}


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
}
