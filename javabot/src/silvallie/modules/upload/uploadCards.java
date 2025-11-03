package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class uploadCards {
	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Robot\\JCC\\Extensions\\Méga-Évolution Énergie de base\\");
		File listPath = new File(pokepediaPath + "Robot\\JCC\\description_upload.txt");
		boolean justOne = true;

		FileReader fr					= new FileReader(listPath);
		BufferedReader br					= new BufferedReader(fr);

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

//				if (i<180) {
//					continue;
//				}
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

				TimeUnit.SECONDS.sleep(1);


				if (justOne) {
					break;
				}
			}
		}

		br.close();
		Silvallie.endRun(startTime);
	}
}
