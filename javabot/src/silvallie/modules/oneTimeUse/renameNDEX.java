package silvallie.modules.oneTimeUse;

import silvallie.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class renameNDEX {
	/** Fonction pour changer le ndex de Pokémon présents dans une liste. **/
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();

		String pokepediaPath = Util.getPokepediaPath();

		File listPath = new File(pokepediaPath + "Renommages NDEX\\changements.csv");

		FileReader fr					= new FileReader(listPath);
		BufferedReader br					= new BufferedReader(fr);

		String			currentLine			= br.readLine();

		String games = "EV";

		Map<String, String> NdexpkpToName = new Hashtable<String, String>();
		Map<String, String> NameToNdexpkp = new Hashtable<String, String>();
		Map<String, String> NameToNdexzh = new Hashtable<String, String>();
		Map<String, String> NdexzhToName = new Hashtable<String, String>();

		String[] currentInfo;

		currentLine			= br.readLine(); // first line is header
		while (currentLine != null) {
			currentInfo = currentLine.split(";");

			if (currentInfo[0] != null && currentInfo[1] != null && currentInfo[2] != null ) {
				NdexpkpToName.put(currentInfo[0], currentInfo[1]);
				NameToNdexpkp.put(currentInfo[1], currentInfo[0]);
				NameToNdexzh.put(currentInfo[1], currentInfo[2]);
				NdexzhToName.put(currentInfo[2], currentInfo[1]);
			}

			currentLine		= br.readLine();
		}

//		System.out.println(NdexpkpToName.get("934"));
//		System.out.println(NameToNdexzh.get("Olivini"));

		// PAGES DE MINIATURES + ARTICLES DE POKÉMON
//		PageCollection miniaturePageCollection = new PageCollection(
//				new int[] {API.NS_MAIN, API.NS_FILES},
//				API.FILTER_NONREDIRECTS,
//				"Miniature Pokémon (Écarlate et Violet)"
//			);
//
//		Page miniaturePage = miniaturePageCollection.getNextPage();
//		while (miniaturePage != null) {
//			String title = miniaturePage.getTitle();
//			String oldNdex = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9\\?]*)(?<c>[^\\.]*) " + games + "\\.png", "$2");
//			String form = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*) " + games + "\\.png", "$3");
//
//			String name = NdexpkpToName.get(oldNdex);
//
//			if (oldNdex != null && name != null) {
//				String tempTitle = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9\\?]*)(?<c>[^\\.]*) " + games + "\\.png", "$1" + name + "$3 " + games + ".png");
//				String generalTitle = title.replace(" " + games + ".png", ".png");
//				String generalTempTitle = tempTitle.replace(" " + games + ".png", ".png");
//				String numberTitle = "Pokémon n°" + oldNdex + form;
//				String numberTempTitle = "Pokémon n°" + name + form;
//
//				String titleWithoutForm = title.replace(form, "");
//				String tempTitleWithoutForm = tempTitle.replace(form, "");
//				String generalTitleWithoutForm = titleWithoutForm.replace(" " + games + ".png", ".png");
//				String generalTempTitleWithoutForm = tempTitleWithoutForm.replace(" " + games + ".png", ".png");
//				String numberTitleWithoutForm = "Pokémon n°" + oldNdex;
//				String numberTempTitleWithoutForm = "Pokémon n°" + name;
//
//
//				if (!title.equals(tempTitle)) {
//					 API.rename(title, tempTitle, false, "Renommage temporaire pour changer les numéros nationaux");
//					System.out.println(title + " -> " + tempTitle);
//					 API.rename(generalTitle, generalTempTitle, false, "Renommage temporaire pour changer les numéros nationaux");
//					System.out.println(generalTitle + " -> " + generalTempTitle);
//					 API.rename(numberTitle, numberTempTitle, false, "Renommage temporaire pour changer les numéros nationaux");
//					System.out.println(numberTitle + " -> " + numberTempTitle);
//					if (!form.equals("")) {
//						 API.rename(titleWithoutForm, tempTitleWithoutForm, false, "Renommage temporaire pour changer les numéros nationaux");
//						System.out.println(titleWithoutForm + " -> " + tempTitleWithoutForm);
//						 API.rename(generalTitleWithoutForm, generalTempTitleWithoutForm, false, "Renommage temporaire pour changer les numéros nationaux");
//						System.out.println(generalTitleWithoutForm + " -> " + generalTempTitleWithoutForm);
//						 API.rename(numberTitleWithoutForm, numberTempTitleWithoutForm, false, "Renommage temporaire pour changer les numéros nationaux");
//						System.out.println(numberTitleWithoutForm + " -> " + numberTempTitleWithoutForm);
//					}
//					System.out.println("***");
//				}
//			}
//
//			miniaturePage = miniaturePageCollection.getNextPage();
//		}
//		miniaturePageCollection.rewind();
//		System.out.println("\n*** REWIND MINIATURES ***\n");
//
//		miniaturePage = miniaturePageCollection.getNextPage();
//		while (miniaturePage != null) {
//			String title = miniaturePage.getTitle();
//			String oldNdex = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*)\\.png", "$2");
//			String form = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*) " + games + "\\.png", "$3");
//			String name = NdexpkpToName.get(oldNdex);
//
//			if (oldNdex != null && name != null) {
//				String newNdex = NameToNdexzh.get(name);
//
//				String tempTitle = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*)\\.png", "$1" + name + "$3.png");
//				String newTitle = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*)\\.png", "$1" + newNdex + "$3.png");
//				String generalTempTitle = tempTitle.replace(" " + games + ".png", ".png");
//				String generalNewTitle = newTitle.replace(" " + games + ".png", ".png");
//				String numberTempTitle = "Pokémon n°" + name + form;
//				String numberNewTitle = "Pokémon n°" + newNdex + form;
//
//				String tempTitleWithoutForm = tempTitle.replace(form, "");
//				String newTitleWithoutForm = newTitle.replace(form, "");
//				String generalTempTitleWithoutForm = tempTitleWithoutForm.replace(" " + games + ".png", ".png");
//				String generalNewTitleWithoutForm = newTitleWithoutForm.replace(" " + games + ".png", ".png");
//				String numberTempTitleWithoutForm = "Pokémon n°" + name;
//				String numberNewTitleWithoutForm = "Pokémon n°" + newNdex;
//
//				if (!tempTitle.equals(newTitle)) {
//					 API.rename(tempTitle, newTitle, false, "Renommage pour changer les numéros nationaux");
//					System.out.println(tempTitle + " -> " + newTitle);
//					 API.rename(generalTempTitle, generalNewTitle, false, "Renommage pour changer les numéros nationaux");
//					System.out.println(generalTempTitle + " -> " + generalNewTitle);
//					 API.rename(numberTempTitle, numberNewTitle, false, "Renommage pour changer les numéros nationaux");
//					System.out.println(numberTempTitle + " -> " + numberNewTitle);
//
//					// Changement de destination de redirection de la miniature générale
//					Page generalNewPage = new Page(generalNewTitle);
//					String generalNewContents = generalNewPage.getContent();
//					if (generalNewContents == null) {
//						System.err.println("Warning: " + generalNewPage.getTitle() + " doesn't exist.");
//					} else {
//						generalNewContents.replace(oldNdex, newNdex);
//					}
//
//					// System.out.println(generalNewContents);
//					 generalNewPage.setContent(generalNewContents, "Changement de numéros nationaux");
//
//					if (!form.equals("")) {
//						 API.rename(tempTitleWithoutForm, newTitleWithoutForm, false, "Renommage temporaire pour changer les numéros nationaux");
//						System.out.println(tempTitleWithoutForm + " -> " + newTitleWithoutForm);
//						 API.rename(generalTempTitleWithoutForm, generalNewTitleWithoutForm, false, "Renommage temporaire pour changer les numéros nationaux");
//						System.out.println(generalTempTitleWithoutForm + " -> " + generalNewTitleWithoutForm);
//						 API.rename(numberTempTitleWithoutForm, numberNewTitleWithoutForm, false, "Renommage temporaire pour changer les numéros nationaux");
//						System.out.println(numberTempTitleWithoutForm + " -> " + numberNewTitleWithoutForm);
//
//						// Changement de destination de redirection
//						Page generalNewPageWithoutForm = new Page(generalNewTitleWithoutForm);
//						String generalNewContentsWithoutForm = generalNewPageWithoutForm.getContent();
//						if (generalNewContents == null) {
//							System.err.println("Warning: " + generalNewPage.getTitle() + " doesn't exist.");
//						} else {
//							generalNewContentsWithoutForm.replace(oldNdex, newNdex);
//						}
//
//						// System.out.println(generalNewContentsWithoutForm);
//						 generalNewPageWithoutForm.setContent(generalNewContentsWithoutForm, "Changement de numéros nationaux");
//					}
//					System.out.println("***");
//				}
//
//				// Articles de Pokémon
//				Page articlePage = new Page(name);
//				String articleContents = articlePage.getContent();
//				int newNdexInt = Integer.parseInt(newNdex);
//				String previousPokemon = NdexzhToName.get(Integer.toString(newNdexInt - 1));
//				String nextPokemon = NdexzhToName.get(Integer.toString(newNdexInt + 1));
//
//				String newArticleContents = articleContents.replace(oldNdex, newNdex);
//				newArticleContents = newArticleContents.replaceAll("nomPrécédent=[^\\n]*", "nomPrécédent=" + previousPokemon);
//				newArticleContents = newArticleContents.replaceAll("nomSuivant=[^\\n]*", "nomSuivant=" + nextPokemon);
//
//				// System.out.println(newArticleContents);
//				 articlePage.setContent(newArticleContents, "Changement de numéros nationaux");
//			}
//
//			miniaturePage = miniaturePageCollection.getNextPage();
//		}


		// BONUS RÉPARATION
		String[] categoryNames = new String[] {"Miniature Pokémon (Écarlate et Violet)"};
		List<PageCollection> pageCollections = new ArrayList<>();
//		for(int i=0; i<categoryNames.length; i++) {
//
//			PageCollection pageCollection = new PageCollection(
//					new int[] {API.NS_MAIN, API.NS_FILES},
//					API.FILTER_NONREDIRECTS,
//					categoryNames[i]
//				);
//			pageCollections.add(pageCollection);
//			System.out.println(categoryNames[i] + " category dump ok");
//		}
//
//
//		for(PageCollection pageCollection : pageCollections) {
//			Page page = pageCollection.getNextPage();
//
//			while (page != null) {
//
//				String title = page.getTitle();
//				String ndex = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*)\\.png", "$2");
//				String form = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*) " + games + "\\.png", "$3");
//
//				String titleWithoutForm = title.replace(form, "");
//
//				String generalTitle = title.replace(" EV.png", ".png");
//				String generalTitleWithoutForm = generalTitle.replace(form, "");
//				Page pageWithoutForm = new Page(titleWithoutForm);
//				Page generalPage = new Page(generalTitle);
//				Page generalPageWithoutForm = new Page(generalTitleWithoutForm);
//
//
//
//
//				if (ndex != null && !ndex.equals("718")) {
//					String pageWithoutFormContents = pageWithoutForm.getContent();
//					String generalPageContents = generalPage.getContent();
//					String generalPageWithoutFormContents = generalPageWithoutForm.getContent();
//
//					System.out.println(ndex);
//					if (pageWithoutFormContents == null) {
//						System.err.println("Warning: " + pageWithoutForm.getTitle() + " doesn't exist.");
//					} else {
//						// System.out.println(pageContents);
//						pageWithoutFormContents = pageWithoutFormContents.replaceAll("[0-9]+", ndex);
//
//						if (!pageWithoutFormContents.equals(pageWithoutForm.getContent())) {
//							System.out.println(pageWithoutFormContents);
//							pageWithoutForm.setContent(pageWithoutFormContents, "Changement de numéros nationaux");
//						}
//
//					}
//
//					if (generalPageContents == null) {
//						System.err.println("Warning: " + pageWithoutForm.getTitle() + " doesn't exist.");
//					} else {
//						generalPageContents = generalPageContents.replaceAll("[0-9]+", ndex);
//
//						if (!generalPageContents.equals(generalPage.getContent())) {
//							System.out.println(generalPageContents);
//							generalPage.setContent(generalPageContents, "Changement de numéros nationaux");
//						}
//					}
//
//					if (generalPageWithoutFormContents == null) {
//						System.err.println("Warning: " + pageWithoutForm.getTitle() + " doesn't exist.");
//					} else {
//						generalPageWithoutFormContents = generalPageWithoutFormContents.replaceAll("[0-9]+", ndex);
//
//						if (!generalPageWithoutFormContents.equals(generalPageWithoutForm.getContent())) {
//							System.out.println(generalPageWithoutFormContents);
//							generalPageWithoutForm.setContent(generalPageWithoutFormContents, "Changement de numéros nationaux");
//						}
//					}
//				}
//				page = pageCollection.getNextPage();
//			}
//		}
//
//		System.out.println("*** STOP ***");
//		if (true) {return;}

		// SPRITES, IMAGES DU POKÉDEX ET REDIRECTIONS D'ARTWORK
		categoryNames = new String[] {"Sprite Pokémon (Écarlate et Violet)", "Sprite Pokémon chromatique (Écarlate et Violet)", "Image du Pokédex (Écarlate et Violet)"};
		pageCollections = new ArrayList<>();
		for(int i=0; i<categoryNames.length; i++) {

			PageCollection pageCollection = new PageCollection(
					new int[] {API.NS_MAIN, API.NS_FILES},
					API.FILTER_NONREDIRECTS,
					categoryNames[i]
			);
			pageCollections.add(pageCollection);
			System.out.println(categoryNames[i] + " category dump ok");
		}


		int counter = 0;
		for(PageCollection pageCollection : pageCollections) {
			Page spritePage = pageCollection.getNextPage();
			while (spritePage != null) {
				String title = spritePage.getTitle();
				String oldNdex = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9\\?]*)(?<c>[^\\.]*) " + games + "\\.png", "$2");
				String name = NdexpkpToName.get(oldNdex);

				if (oldNdex != null && name != null) {
					String tempTitle = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9\\?]*)(?<c>[^\\.]*) " + games + "\\.png", "$1" + name + "$3 " + games + ".png");


					if (!title.equals(tempTitle)) {
						API.rename(title, tempTitle, false, "Renommage temporaire pour changer les numéros nationaux");
						System.out.println(title + " -> " + tempTitle);
					}
				}

				spritePage = pageCollection.getNextPage();
			}
			pageCollection.rewind();
			System.out.println("\n*** REWIND " + categoryNames[counter] + " ***\n");

			spritePage = pageCollection.getNextPage();
			while (spritePage != null) {
				String title = spritePage.getTitle();
				String oldNdex = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*)\\.png", "$2");
				String name = NdexpkpToName.get(oldNdex);

				if (oldNdex != null && name != null) {
					String newNdex = NameToNdexzh.get(name);

					String tempTitle = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*)\\.png", "$1" + name + "$3.png");
					String newTitle = title.replaceAll("(?<a>[^0-9]*)(?<b>[0-9]*)(?<c>[^\\.]*)\\.png", "$1" + newNdex + "$3.png");

					if (!tempTitle.equals(newTitle)) {
						API.rename(tempTitle, newTitle, false, "Renommage pour changer les numéros nationaux");
						System.out.println(tempTitle + " -> " + newTitle);
					}

					// Changement de redirections pour les redirections d'artwork temporaires
					if (counter == 2) {
						Page artworkPage = new Page("Fichier:" + name + ".png");
						String artworkPageContents = artworkPage.getContent();
						if (artworkPageContents == null) {
							System.err.println("Warning: " + artworkPage.getTitle() + " doesn't exist.");
						} else if (artworkPageContents.contains("Fichier:Pokédex")) {
							artworkPageContents = artworkPageContents.replace(oldNdex, newNdex);

							System.out.println(artworkPageContents);
							artworkPage.setContent(artworkPageContents, "Changement de numéros nationaux");
						}
					}
				}

				spritePage = pageCollection.getNextPage();
			}
			counter++;
		}

		br.close();
		Silvallie.endRun(startTime);
	}
}
