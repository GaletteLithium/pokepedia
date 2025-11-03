package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.File;

public class uploadCA {
	public static void main(String args[]) {
		long startTime = Silvallie.beginRun();

		String folder = "";
		File folderPath = new File(Util.getPokepediaPath() + folder + "\\");

		boolean justOne = false;

		File contents[] = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			String pokeName			= contents[i].getName().replaceAll(" \\(.*", "");
			pokeName = pokeName.replaceAll("-CA[^\n]*.png", "");
			pokeName = pokeName.replaceAll("Type-0", "Type:0");
			String categoryName = pokeName;
			pokeName = pokeName.replaceAll("Zarbi[^\n]*", "Zarbi");

			uploadName = uploadName.replace("Type-0", "Type:0");

			String descriptionHeader = "== Description ==\n\n";
			String description = "Corporate Art " + Util.de(pokeName) + "[[" + pokeName + "]].\n\n{{Informations Fichier\n"
					+ "| Source = [https://archives.bulbagarden.net/w/index.php/Category:Pokémon_Dream_World_artwork Bulbapedia], [https://www.wikidex.net/wiki/WikiDex:Proyecto_Pokédex/Ilustraciones_de_Pokémon_en_el_Dream_World Wikidex]\n"
					+ "| Auteur = [[The Pokémon Company]]\n"
					+ "}}\n\n[[Catégorie:Corporate Art de Pokémon]]\n[[Catégorie:Image Pokémon représentant " + categoryName + "]]";
//			String description = "Détourage des localisations EV";
//			String description = "Sprite du vêtement " + uploadName.replace("Fichier:Sprite ", "").replace(" XY.png", "")
//					+ " dans {{Jeu|XY}}.\n\n[[Catégorie:Sprite de vêtement (X et Y)]]";
//			description = description.replace("♂", "(masculin)").replace("♀", "(féminin)");

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

		Silvallie.endRun(startTime);
	}
}
