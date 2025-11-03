package silvallie.modules;

import silvallie.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class backUpArticles {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		String[] categoryNames = {"Carte du JCC"};
//		String[] categoryNames = {"Carte de l'extension XY Vigueur Spectrale"};

		String startingFrom = null;
//		String startingFrom = "ラッキースタジアム Yokohama (Japanese World Challenge Summer)";

		String outputPath = pokepediaPath + "Robot\\dumps\\card_articles_converted\\";

		run(categoryNames, startingFrom, outputPath);

		Silvallie.endRun(startTime);
	}

	/**
	 * Creates a dump of all articles in one or more given categories
	 * @param categoryNames The names of the categories to go through
	 * @param startingFrom The name of the first page. Set to null to begin from start
	 * @param outputPath The path of the folder to save the dump
	 */
	private static void run(String[] categoryNames, String startingFrom, String outputPath) throws IOException {
		int counter = 0;

		for (String categoryName : categoryNames) {

			int[] nameSpaces = new int[]{API.NS_MAIN};
			PageCollection pageCollection = new PageCollection(
					nameSpaces,
					API.FILTER_ALL,
					categoryName
			);

			Page page = pageCollection.getNextPage();
			String title = page.getTitle();

			if (startingFrom != null) {
				while (!startingFrom.equals(title)) {
					page = pageCollection.getNextPage();
					title = page.getTitle();
				}
			}

			while (page != null) {
				title = page.getTitle();

				if (!title.contains("(")) {
					page = pageCollection.getNextPage();
					continue;
				}

				String formattedTitle = title.replace("?", "_");
				formattedTitle = formattedTitle.replace(":", "_");
				formattedTitle = formattedTitle.replace("\"", "_");
				String contents = page.getContent();

				FileOutputStream outputStream = new FileOutputStream(outputPath + formattedTitle + ".txt");
				byte[] strToBytes = contents.getBytes();
				outputStream.write(strToBytes);

				outputStream.close();

				if (counter % 100 == 0) {
					System.out.println(Integer.toString(counter) + " • " + title);
				}

				page = pageCollection.getNextPage();
				counter++;
			}
		}
	}
}
