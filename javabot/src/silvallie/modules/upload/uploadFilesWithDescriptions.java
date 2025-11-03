package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class uploadFilesWithDescriptions {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Robot\\renames.csv");
		File listPath = new File(pokepediaPath + "Robot\\renames.csv");
		String fileExtension = ".png";
		boolean upload = true;
		boolean justOne = true;

		run(folderPath, listPath, fileExtension, upload, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Upload contents of a folder and adds a description given in a text file
	 * @param folderPath The path to the folder containing the files
	 * @param listPath The path to the text file containing the descriptions, delimited by lines containing "XXXXX"
	 * @param fileExtension The extension of the files (examples: .png)
	 * @param upload Set to true to upload the files
	 * @param justOne Set to true to stop after the first upload. Please use this on the first run to avoid accidents
	 */
	private static void run(File folderPath, File listPath, String fileExtension, boolean upload, boolean justOne) throws IOException {
		FileReader fr					= new FileReader(listPath);
		BufferedReader br					= new BufferedReader(fr);

		String			delimiter			= "XXXXX";
		String			currentLine			= br.readLine();
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";


		File[] contents = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();

			if (uploadName.endsWith(fileExtension)) {
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
}
