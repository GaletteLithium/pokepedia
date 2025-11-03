package silvallie.modules;

import silvallie.API;
import silvallie.Page;
import silvallie.PageCollection;
import silvallie.Silvallie;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class createRedirections {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();

		String from = "δ";
		String to = "Delta";
		int[] nameSpaces = new int[] {API.NS_FILES};
		String categoryName = "Carte Pokémon ☆";
		String firstPageName = null;
		boolean justOne = true;

		run(from, to, nameSpaces, categoryName, firstPageName, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Creates redirections to the pages of a given category according to a replacement method
	 * @param from The string to be replaced—the one in the target page
	 * @param to The replaced string—the one in the redirection page
	 * @param nameSpaces A table of name spaces (example: new int[] {API.NS_FILES})
	 * @param categoryName The name of the category to fetch the pages from
	 * @param firstPageName The name of the first page, to resume the program execution mid-run. Set to null to begin from start
	 * @param justOne Set to true to stop after the first redirection creation. Please use this on the first run to avoid accidents
	 */
	private static boolean run(String from, String to, int[] nameSpaces, String categoryName, String firstPageName, boolean justOne) {
		boolean allUploadedAtFirst = true;
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
				API.FILTER_NONREDIRECTS,
				categoryName
		);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String pageName;
		String redirectionName;
		while(page != null) {
//			if (!page.getTitle().equals("Fichier:Antre de la Cascade localisation PMDM.png")) {
//				page = pageCollection.getNextPage();
//				counter++;
//				continue;
//			}
			if(counter >= 100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();

				redirectionName = pageName.replaceAll(from, to);

				redirectionName = redirectionName.replace("☆", "Étoile");

				if(!redirectionName.equals(pageName)) {
					Page redirectionPage = new Page(redirectionName);
					String redirectionContents = redirectionPage.getContent();

					if (redirectionContents != null) {
						page = pageCollection.getNextPage();
						counter++;
						continue;
					}


					redirectionPage.setContent("#REDIRECTION [[" + pageName + "]]",
							"Création d'une redirection vers [[" + pageName + "]]");
					System.out.println(redirectionName + " => " + pageName);
					System.out.println("\tSaved");
					allUploadedAtFirst = false;

					if(justOne) {
						break;
					}
					TimeUnit.MILLISECONDS.sleep(300);
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
		return allUploadedAtFirst;
	}

}
