package silvallie.modules;

import silvallie.*;

import java.io.IOException;

public class eraseCategory {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();

		Login.login("Matt.");

		String category = "Miniature d'objet (Rubis et Saphir)";
		boolean justOne = true;

		run(category, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Erases all files from a given category
	 * @param category The name of the category to fetch the pages from
	 * @param justOne Set to true to stop after the first file deletion. Please use this on the first run to avoid accidents
	 */
	private static void run(String category, boolean justOne) {

		PageCollection pageCollection = new PageCollection(
				new int[] {API.NS_FILES},
				API.FILTER_NONREDIRECTS,
				category
		);
		Page page = pageCollection.getNextPage();
		while (page != null) {
			String title = page.getTitle();
			API.delete(title, "[Modif auto] Suppression des fichiers de [[Catégorie:" + category + "]]");

			System.out.println("Deleted " + title);


			page = pageCollection.getNextPage();

			if (justOne) {
				page = null;
			}
		}
	}
}
