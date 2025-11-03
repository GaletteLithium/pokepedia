package silvallie.modules.oneTimeUse;

import silvallie.API;
import silvallie.Page;
import silvallie.PageCollection;
import silvallie.Silvallie;

import java.util.concurrent.TimeUnit;

public class addRequestTables {
	public static void main(String[] args) throws InterruptedException {
		long startTime = Silvallie.beginRun();

		String startingFrom = null;
		boolean justOne = true;

		run(startingFrom, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Adds navigation tables for request on Pokémon card categories
	 * @param startingFrom The name of the first page. Set to null to begin from start
	 * @param justOne Set to true to stop after the first page edit. Please use this on the first run to avoid accidents
	 */
	private static void run(String startingFrom, boolean justOne) throws InterruptedException {
		String categoryName = "Pokémon";

		int[] nameSpaces = new int[]{API.NS_MAIN};
		PageCollection pageCollection = new PageCollection(
				nameSpaces,
				API.FILTER_ALL,
				categoryName
		);

//		justOne = true;
		Page typePage = pageCollection.getNextPage();
		typePage = pageCollection.getNextPage();
		String typeTitle = typePage.getTitle();


		if (startingFrom != null) {
			while (!startingFrom.equals(typeTitle)) {
				typePage = pageCollection.getNextPage();
				typeTitle = typePage.getTitle();
			}
		}

		while (typePage != null) {
			typeTitle = typePage.getTitle();
			String pageType = typeTitle; // .replace(" (JCC)", "");

			Page categoryPage = new Page("Catégorie:Carte Pokémon représentant " + pageType);
			String categoryTitle = categoryPage.getTitle();
			String contents = categoryPage.getContent();
			String newContents = contents;

			if (contents == null) {
				System.out.println("No page found for " + pageType);
				typePage = pageCollection.getNextPage();
				continue;
			}

			String newInterwiki = "";
			String interwikiComment = "";

//			String newContents = contents.replaceFirst("\n[[", "\n{{Requête ")

			if (!contents.contains("[[de:")) {
				if (!contents.contains("Méga-") && !contents.contains("Gigamax") &&
						!contents.contains("Primo-") && !contents.contains(" de ") &&
						!contents.contains(" d'") && !contents.contains(",") &&
						!contents.contains("Necrozma ") && !contents.contains("Ultra-") &&
						!contents.contains("Kyurem") && !contents.contains("Infinimax")) {

					System.out.println("Missing interwiki on " + categoryTitle);
					newInterwiki = "\n\n[[de:Sammelkarte von "
							+ "{{subst:#invoke:Data|nompokemon|{{subst:#show: " + pageType + " |? Numéro National }}|langue=de}}]]\n"
							+ "[[en:Category:"
							+ "{{subst:#invoke:Data|nompokemon|{{subst:#show: " + pageType + " |? Numéro National }}|langue=en}} (TCG)]]\n";
					interwikiComment = " + ajout interwiki";
				}
			}

			if (!contents.contains("\n[[")) {
				System.out.println("Missing on " + categoryTitle);
			} else if (!contents.contains("{{Navigation Requêtes Jeux de cartes")) {
				newContents = newContents.replaceFirst("\n\\[\\[", "\n{{Navigation Requêtes Jeux de cartes\n"
						+ "| [[Pokémon représenté::" + pageType + "]]\n"
//						+ "| class=" + pageType.toLowerCase() + "-jcc\n"
						+ "}}\n\n[[");
			}

			newContents = newContents + newInterwiki;

//			System.out.println(contents);

			if (!contents.equals(newContents)) {
				categoryPage.setContent(newContents, "Ajout d'un tableau de requêtes sémantiques" + interwikiComment);

			}
			TimeUnit.SECONDS.sleep(1);


			if (justOne) {
				break;
			}

			typePage = pageCollection.getNextPage();
		}
	}
}
