package silvallie.modules.oneTimeUse;

import silvallie.*;

public class replacePDMCash {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();

		// run

		Silvallie.endRun(startTime);
	}
	/**
	 * Méthode de remplacement specifique objets et monnaue PDM
	 * @param from chaine à remplacer (regexp)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au remplacement appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param trigger une chaine de texte devant être présente dans les pages pour déclencher le remplacement. Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Évite de casser plein de pages durant les tests.
	 * @author Mewtwo_Ex
	 **/
	private static void run(String from, int[] nameSpaces, String categoryName, String trigger, String firstPageName, boolean justOne) {
		String to = null;

		PageCollection pagesG3 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la troisième génération");
		PageCollection pagesG4 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la quatrième génération");
		PageCollection pagesG5 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la cinquième génération");
		PageCollection pagesG6 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la sixième génération");

		PageCollection pageCollection = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, categoryName);

		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String text;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			if(pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM1}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM2}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM3}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM4}}";
			} else {
				to = null;
			}

			if(to!=null) {
				try {
					text = page.getContent(false);
					if(text!=null && (trigger==null || text.indexOf(trigger)!=-1)) {
						System.out.println("FOUND in page ["+page.getTitle()+"]");

						String newText = text.replaceAll(from, to);

						if(!newText.equals(text)) {
							page.setContent(newText, "Remplacement "+from+" => "+to);
							System.out.println("\tSaved");
							if(justOne) {
								break;
							}
						} else {
							System.out.println("\tSkipped (no change)");
						}
					}
				} catch (Exception e) {
					System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
					e.printStackTrace();
				}
			} else {
				System.out.println("\tSkipped (multigen)");
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}
}
