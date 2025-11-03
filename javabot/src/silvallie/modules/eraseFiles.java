package silvallie.modules;

import silvallie.API;
import silvallie.Login;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class eraseFiles {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		Login.login("Matt.");

		File listPath = new File(pokepediaPath + "Robot\\deletion_list.txt");
		boolean justOne = true;

		run(listPath, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Erases all files from a given text files
	 * @param listPath The path to the text file
	 * @param justOne Set to true to stop after the first file deletion. Please use this on the first run to avoid accidents
	 */
	private static void run(File listPath, boolean justOne) throws IOException {
		FileReader fr						= new FileReader(listPath);
		BufferedReader br						= new BufferedReader(fr);

		String			currentLine				= "currentLine";


		while (!currentLine.isEmpty()) {
			currentLine				= br.readLine();

//			Page page = new Page(currentLine);
//			if (page.getContent() != null) {
//				System.out.println(currentRedirectionPage + " was already written.");
//				continue;
//			}
			API.delete(currentLine, "[Modif auto] Suppression automatique de fichiers");

			System.out.println("Deleted " + currentLine);

			if (justOne) {
				break;
			}
		}

		br.close();
	}
}
