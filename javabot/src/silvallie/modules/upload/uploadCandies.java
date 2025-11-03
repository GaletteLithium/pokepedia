package silvallie.modules.upload;

import silvallie.*;

import java.io.File;

public class uploadCandies {

	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Images\\GO\\Bonbons\\");
		boolean justOne = true;

		File[] contents = folderPath.listFiles();
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

		Silvallie.endRun(startTime);
	}
}
