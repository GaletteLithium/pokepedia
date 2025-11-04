package silvallie.modules.oneTimeUse;

import silvallie.Silvallie;
import silvallie.Util;

import java.io.File;
import java.io.IOException;

public class deployModuleItemsCost {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File dumpFolder = new File(pokepediaPath + "Robot\\dumps\\itemdumps\\");
		String gamesShort = "EV";
		String games = "Écarlate et Violet";
		boolean justOne = true;


		run(folderPath, listPath, gamesShort, games, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Uploads card articles from a folder
	 * @param folderPath The folder containing the card articles to be uploaded
	 * @param listPath The path to the text file containing the CT numbers and attack names
	 * @param gamesShort Abbreviated form of the games the images are from, used in the files' title (example: EV)
	 * @param games Long form of the games the images are from, used in the category (example: Écarlate et Violet)
	 * @param justOne Set to true to stop after the first upload. Please use this on the first run to avoid accidents
	 */
	private static void run(File folderPath, File listPath, String gamesShort, String games, boolean justOne) {

	}
}
