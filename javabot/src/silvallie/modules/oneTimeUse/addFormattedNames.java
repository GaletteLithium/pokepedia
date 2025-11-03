package silvallie.modules.oneTimeUse;

import silvallie.*;

public class addFormattedNames {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();


//		startingFrom = "Demanta (Neo Destiny 74)";
//		startingFrom = "Zygarde (Promo SM 15)";

		String categoryName = "Carte Pokémon";
//		String categoryName = "Carte Pokémon δ";
//		String categoryName = "Carte Pokémon représentant Mewtwo";
//		String categoryName = "Pas de traduction française";

		String startingFrom = null;
		boolean justOne = true;

		run(categoryName, startingFrom, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Adds formatted names for cards, primarily for cards in other languages
	 * @param categoryName The name of the category to fetch the pages from
	 * @param startingFrom The name of the first page. Set to null to begin from start
	 * @param justOne Set to true to stop after the first page edit. Please use this on the first run to avoid accidents
	 */
	private static void run(String categoryName, String startingFrom, boolean justOne) {

		int[] nameSpaces = new int[]{API.NS_MAIN};
		PageCollection pageCollection = new PageCollection(
				nameSpaces,
				API.FILTER_ALL,
				categoryName
		);

		Page currentPage = pageCollection.getNextPage();
		String title = currentPage.getTitle();
		String formattedTitle = title;

		if (startingFrom != null) {
			while (!startingFrom.equals(title)) {
//				System.out.println(title);
				currentPage = pageCollection.getNextPage();
				title = currentPage.getTitle();
			}
		}

		while (currentPage != null) {
			String contents = currentPage.getContent();
			title = currentPage.getTitle().replaceAll(" \\(.*", "");;
			formattedTitle = title;
			String suffix = "";


			if (!contents.contains("{{Infobox Carte") || contents.contains("| nomformaté")) {
				currentPage = pageCollection.getNextPage();
				continue;
			}

//			if (contents.contains("#ask:")) {
//				System.out.println(title);
//				currentPage = pageCollection.getNextPage();
//				continue;
//			} else if (startingFrom == null){
//				currentPage = pageCollection.getNextPage();
//				continue;
//			}

			String[][] replacementList = {{"de Team Magma", "de la Team Magma"}, {"de Team Aqua", "de la Team Aqua"},
					{"Deuxmiaou", "Mewtwo"},
					{"Blaine's", "d'Auguste"}, {"Brock's", "de Pierre"}, {"Erika's", "d'Erika"},
					{"Giovanni's", "de Giovanni"}, {"Koga's", "de Koga"}, {"Lt. Surge's", "de Major Bob"},
					{"Misty's", "d'Ondine"}, {"Brock's", "de Pierre"}, {"Rocket's", "de Rocket"}, {"Ｒ団の", "de Rocket"},
					{"Sabrina's", "de Morgane"}, {"Team Rocket's", "de Rocket"},
					{"ロータの", "de Rota"}, {"イマクニ？の", "d'Imakuni?"}, {"ラルースの", "de Larousse"},
					{"アーロンの", "d'Aaron"}, {"アイリーンの", "de Justine"}, {"アカネの", "de Blanche"}, {"アクーシャの", "de Samaya"},
					{"アンズの", "de Jeannine"}, {"イツキの", "de Clément"}, {"イブキの", "de Sandra"}, {"イマクニ?の", "d'Imakuni?"},
					{"エリカの", "d'Erika"}, {"オードリーの", "d'Audrey"}, {"オーヤマの", "d'OOYAMA"}, {"カスミの", "d'Ondine"},
					{"カツラの", "d'Auguste"}, {"カリンの", "de Marion"}, {"キッドの", "de Kidd"}, {"キャサリンの", "de Catherine"},
					{"キョウの", "de Koga"}, {"サトシの", "de Sacha"}, {"ザンナーの", "d'Annie"}, {"シジマの", "de Chuck"},
					{"シップの", "de Shem"}, {"シバの", "d'Aldo"}, {"ショウタの", "de Sid"}, {"タケシの", "de Pierre"},
					{"ツクシの", "d'Hector"}, {"ナツメの", "de Morgane"}, {"バトラーの", "de Butler"}, {"ハヤトの", "d'Albert"},
					{"ハルカの", "de Flora"}, {"ヒトミの", "de Rebecca"}, {"ヒロミの", "de Lizabeth"}, {"ファウンスの", "de Forina"},
					{"ファントムの", "de Fantôme"}, {"マチスの", "de Major Bob"}, {"マツバの", "de Mortimer"}, {"ミカンの", "de Jasmine"},
					{"ヤナギの", "de Frédo"}, {"リオンの", "d'Oakley"}, {"リュウの", "de Rafe"}, {"レッドの", "de Red"},
					{"ロケット団の", "de Rocket"}, {"ロッシの", "de Ross"}, {"ワタルの", "de Peter"}, {"水の都のの", "d'Alto Mare"},
//					{"の", "de"},
					{"アローラ", "d'Alola"}, {"ガラル", "de Galar"}, {"ヒスイ", "de Hisui"}, {"パルデア", "de Paldea"},
					{"-VMAX", "-VMAX"}, {"-V-UNION", "-V-UNION"}, {"-V", "-V"}, {"-VSTAR", "-VSTAR"}, {"-ex", "-ex"}, {" ex", " ex"},
					{"-EX", "-EX"}, {"EX", "-EX"}, {"-GX", "-GX"}, {"GX", "-GX"},
					{"Trash Cloak", "Cape Déchet"}, {"GL", "GL"}, {" G", " G"}, {" C", " C"}, {" M", " M"}, {" Ｍ", "M"}, {" 4", " 4"}, {"FB", "FB"},
					{"NIV.X", ""}, {"LV.X", ""}, {" δ", ""}, {"Dark", "obscur"}, {"TURBO", "TURBO"}, {"☆", "☆"},
					{"Alolan", "d'Alola"}, {"Galarian", "de Galar"}, {"Hisuian", "de Hisui"}, {"Paldean", "de Paldea"},
			};

			String[] formattedTitleSplit = new String[] {formattedTitle}; // .split("&");
			String newFormattedTitle = "";
			if (title.contains("Pikachu")) {
				System.out.println(title);
			}

			for (String titlePart : formattedTitleSplit) {
				suffix = "";
				for (String[] pair : replacementList) {
					if (titlePart.contains(pair[0])) {
						int endOfFound = titlePart.indexOf(pair[0]) + pair[0].length();
//						System.out.println(endOfFound);
//						System.out.println("<" + formattedTitle.substring(endOfFound, endOfFound + 1) + ">");
//						System.out.println(formattedTitle);
						if (titlePart.length() <= endOfFound || (titlePart.substring(endOfFound, endOfFound + 1)).equals(" ")) {
							titlePart = titlePart.replace(pair[0], "").strip();
							suffix = suffix + pair[1];
						}

					}
				}

				String[][] accentReplacements = {{"[ÉÈÊË]", "E"}, {"[éèëê]", "e"}, {"ç", "c"}, {"[âäà]", "a"}};
				String titlePartWithoutAccents = titlePart;

				for (String[] accentReplacement : accentReplacements) {
					titlePartWithoutAccents = titlePartWithoutAccents.replaceAll(accentReplacement[0], accentReplacement[1]);
				}

				for (int i = 0; i < PokeData.pokemon_en.length ; i++) {
					if (titlePart.equals(PokeData.pokemon_en[i])) {
						titlePart = PokeData.pokemon[i];
						break;
					} else if (titlePart.equals(PokeData.pokemon_ja[i])) {
						titlePart = PokeData.pokemon[i];
						break;
					} else {
						String pokeNameWithoutAccents = PokeData.pokemon[i];
						for (String[] accentReplacement : accentReplacements) {
							pokeNameWithoutAccents = pokeNameWithoutAccents.replaceAll(accentReplacement[0], accentReplacement[1]);
						}
						if (titlePartWithoutAccents.equals(pokeNameWithoutAccents)) {
							titlePart = PokeData.pokemon[i];
						}
					}
				}

				if (newFormattedTitle.equals("")) {
					newFormattedTitle = titlePart + " " + suffix;
				} else {
					newFormattedTitle = newFormattedTitle + " et " + titlePart + " " + suffix;
				}
			}

//			if (formattedTitle.contains("&")) {
//				currentPage = pageCollection.getNextPage();
//				continue;
//			}

			newFormattedTitle = newFormattedTitle.strip().replaceAll(" +", " ").replace(" -", "-");
			newFormattedTitle = newFormattedTitle.replaceAll(" et (.*) et ", ", $1 et ");
			newFormattedTitle = newFormattedTitle.replace("アンノーン", "Zarbi").replace("Unown", "Zarbi");

			if (title.equals(newFormattedTitle)) {
				currentPage = pageCollection.getNextPage();
				continue;
			}

			String newContents = contents.replaceFirst("(\\| nom[^\n]*)", "$1\n| nomformaté=" + newFormattedTitle);

			currentPage.setContent(newContents, "Ajout du nom formaté " + newFormattedTitle);
			System.out.println("Ajout de <" + newFormattedTitle + "> pour " + currentPage.getTitle());

			if (justOne) {
				break;
			}

			currentPage = pageCollection.getNextPage();
		}
	}
}
