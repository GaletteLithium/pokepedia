package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class uploadCT {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Images\\EV\\CT\\Images\\");
		File listPath = new File(pokepediaPath + "Images\\EV\\CT\\VignettesCT.csv");
		String gamesShort = "EV";
		String games = "Écarlate et Violet";
		boolean justOne = true;

		FileReader fr					= new FileReader(listPath);
		BufferedReader br					= new BufferedReader(fr);

		String			delimiter			= ";";
		String			currentLine			= br.readLine();
		String			descriptionHeader	= "== Description ==\n";


		while (currentLine != null) {
			String[] currentLineSplit = currentLine.split(";");
			String name = currentLineSplit[0];

			if (!name.equals("")) {
				String CTNumber			= name.split(" ")[1];
				String uploadName		= "Fichier:" + name;
				String description		= "Vignette de la [[" + CTNumber + "]] dans {{Jeu|" + gamesShort + "}}.\n\n"
						+ "[[Catégorie:Vignette de CT (" + games + ")]]";
				for(int i=1;i<currentLineSplit.length;i++) {
					description += "\n[[Catégorie:Image Pokémon représentant " + currentLineSplit[i] + "]]";
				}

				System.out.println(folderPath);
				System.out.println(folderPath+ "\\" + name);
				File file = new File(folderPath + "\\" + name);

				boolean uploaded = API.upload("Fichier:" + name, file,
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

			currentLine = br.readLine();
		}

		br.close();
		Silvallie.endRun(startTime);
	}
}
