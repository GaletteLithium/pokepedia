package silvallie.modules;

import silvallie.*;

import java.io.File;
import java.io.IOException;

public class renameTrainerSprites {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();

		// run

		Silvallie.endRun(startTime);
	}

	/**
	 * Méthode de renommage générique. Les tableaux "from" et "to" fonctionnent de paire et doivent donc être de même longueur.
	 * @param from chaines à remplacer (regexp)
	 * @param to chaines de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au renommage appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param keepRedirect true pour maintenir une redirection entre l'ancien et le nouveau nom, false sinon.
	 * @param justOne true pour s'arrêter après le premier remplacement réussi. Évite de casser plein de pages durant les tests.
	 **/
	private static void run(String[] from, String[] to, int[] nameSpaces, String categoryName, String firstPageName, boolean keepRedirect, boolean justOne) {
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_FILES},
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
		String newPageName;
		String text;
		int numFromTo;
		while(page!=null) {
			if(counter>=100) {
				//System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();
				newPageName = pageName;
				for(numFromTo=0; numFromTo<from.length; numFromTo++) {
					newPageName = newPageName.replaceAll(from[numFromTo], to[numFromTo]);
				}
				if(!newPageName.equals(pageName)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");
					text = page.getContent(false);
					if(Util.count(text, "[Cc]at[ée]gor[iy]e?\\s*:\\s*[Aa]rtwork Pokémon du Pokémon Global Link") > 1) {
						System.err.println("\tCannot save : multiple categories for ["+page.getTitle()+"]");
					} else {
						API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
						System.out.println("\tSaved");
					}
					if(justOne) {
						break;
					}
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}
}
