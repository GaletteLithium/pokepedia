package silvallie.modules.oneTimeUse;

import silvallie.*;

import java.util.concurrent.TimeUnit;

public class generateGeneralItemRedirections {
	public static void main(String[] args) throws InterruptedException {
		long startTime = Silvallie.beginRun();


		String[] gamesNames = {"EB"};
		String[] avoidList = {"Colis", "Canne à Pêche", "Clé Stockage (Sinnoh)", "Clé Secrète", "Clé Stockage", "Objet Perdu", "Objet perdu",
				"Boîte Poffin", "Boîte Sceaux", "Carte Points", "Cherche VS", "Clé Centrale", "Clé Chambre", "Journal", "Lun'Aile", "Plaque Toxik", "Potionsecret",
				"Bâton", "Cuiller Tordue", "Jolie Aile", "Aile Santé", "Aile Force", "Aile Armure", "Aile Esprit", "Aile Mental", "Aile Sprint", "Poignée Pouvoir", "Noigrume Blc", "Noigrume Blu", "Noigrume Jne", "Noigrume Noi", "Noigrume Rge", "Noigrume Ros", "Noigrume Ver", "Écaillerouge", "Plaque Toxik",
				"Colis Chen", "Défense Spéciale", "Spécial +", "Max Élixir", "Max Repousse", "Carte Magn.", "Clé Asc.", "Pokéflûte", "Dent d'Or", "Feuille d'Or", "Feuille Arg.", "Cherche VS",
				"Grain Miracle", "Plaque Fantô", "Poképlumet", "Poképoupée", "Poké Poupée", "Superepousse", "Noigrume Blc", "Noigrume Blu", "Noigrume Jne", "Noigrume Noi", "Noigrume Ros", "Noigrume Rge", "Noigrume Ver",
				"Lettre", "Glas Transp.", "Orbe Bleu", "Orbe Rouge", "Passeconcour", "Seau Wailmer", "Vélo Course",
				"B. Étreinte", "Ballelumière", "Band. Choix", "Band. Muscle", "Band. Pouv.", "Brac. Macho", "Ceint. Force", "Ceint.Noire", "Ceint. Pouv.", "Cendresacrée", "Chaîne Pouv.", "CharmeChroma", "Co. Tréfonds", "Cuillertordu", "Défense Spéc", "Écaillecœur", "Écailledraco", "Écailleocéan", "Flûteblanche", "Foss. Armure", "Foss. Crâne", "Foss. Griffe", "Foss. Plaque", "Foss. Plume", "Foss. Racine", "Foul. Rouge", "Foul. Bleu", "Foul. Rose", "Foul. Vert", "Foul. Jaune", "Glacéternel", "Grain Miracl", "Grif. Rasoir", "Grosseracine", "Herbeblanche", "Herbe Pouv.", "Lent. Pouv.", "Lentil. Zoom", "Lunet. Choix", "Lunet.Noires", "Lunet. Sages", "Morc. Comète", "Morc. Étoile", "Mouch. Choix", "Mouch. Soie", "Pierrefoudre", "Pierreplante", "Pierresoleil", "Plaquesprit", "Plaque Flam", "Plaquinsect", "Plaque Toxic", "Poids Pouv.", "Poign. Pouv.", "Poudre Arg.", "Poudreclaire", "Pouss.Étoile", "Pt de Mire", "Rune Purif.", "Bizar.Encens", "Électiriseur", "Carte Magn.", "Glas Transp.", "Potionsecret",
				"Électiriseur",
				"Aile Argent", "Parc Ball", "Passe",
				"Jus de Baie", "Passeconcour", "Orbe Rouge", "Orbe Bleu", "Vélo Course", "Seau Wailmer", "Pack Devon", "Sac à Suie", "Clé Sous-Sol", "Vélo Cross", "Boîte Pokéblocs", "Lettre", "Passe Éon", "Scanner", "Lunet. Sable", "Clé Salle 1", "Clé Salle 2", "Clé Salle 4", "Clé Salle 6", "Clé Stockage", "Foss. Racine", "Foss. Griffe", "Devon Scope"
		};
		boolean reconnaissance = true;
		boolean justOne = true;

		run(gamesNames, avoidList, reconnaissance, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Creates general redirections for item miniature files.
	 *
	 * <p>It should be used multiple times on each game, from newest to oldest.</p>
	 * @param gamesNames The names of the games to create redirections to (example: EV)
	 * @param avoidList The names of the items to avoid, like the ones that had their names changed
	 * @param reconnaissance Set to true to avoid actually editing the pages, and dress out a list of redirections to be created instead
	 * @param justOne Set to true to stop after the first redirection creation. Please use this on the first run to avoid accidents
	 */
	private static void run(String[] gamesNames, String[] avoidList, boolean reconnaissance, boolean justOne) throws InterruptedException {
		for (int i = 0; i < gamesNames.length; i++) {
			String gamesName = gamesNames[i];
			String gamesNameLong = Util.gamesShortToGamesLong(gamesName);
			String categoryName = "Miniature d'objet (" + gamesNameLong + ")";

			int[] nameSpaces = new int[]{API.NS_FILES};
			PageCollection pageCollection = new PageCollection(
					nameSpaces!=null?nameSpaces:new int[]{API.NS_FILES},
					API.FILTER_NONREDIRECTS,
					categoryName
			);

			Page page = pageCollection.getNextPage();
			String title = page.getTitle();

			// Skipping to a specific item
//			while (!title.equals("Fichier:Miniature Encens Veine EV.png")) {
//				page = pageCollection.getNextPage();
//				title = page.getTitle();
//				continue;
//			}

			while (page != null) {
				TimeUnit.MILLISECONDS.sleep(300);
				title = page.getTitle();
				String redirectionTitle = title.replace(" " + gamesName + ".png", ".png");
				Page redirectionPage = new Page(redirectionTitle);

				boolean avoidPage = false;
				for (String avoidItem : avoidList) {
					if (redirectionTitle.equals("Fichier:Miniature " + avoidItem + ".png")) {
						avoidPage = true;
						break;
					}
				}
				if (avoidPage) {
//					if (!reconnaissance) {
					System.out.println("[AVOID] Redirection depuis " + redirectionTitle + " évitée.");
//					}
					page = pageCollection.getNextPage();
					continue;
				}

				if (redirectionPage.getContent() != null) {
//					System.out.println("FORCING");
					if (!reconnaissance) {
//						System.out.println("[SKIPPED] Redirection depuis " + redirectionTitle + " déjà créée.");
					}
					page = pageCollection.getNextPage();
					continue;
				}

				if (page.getContent().contains("#REDIRECT")) {
					if (!reconnaissance) {
						System.out.println("[REDIRECT]");
					}
					title = page.getContent().replaceAll("#REDIRECT[ION ]*\\[\\[(:|)([^\\]\\n]*)\\]\\]\\n+.*", "$2");
				}

				if (reconnaissance) {
					System.out.println(redirectionTitle + " -> " + title);
				} else {
					String contents = "#REDIRECTION [[" + title + "]]\n[[Catégorie:Miniature d'objet]]";

					redirectionPage.setContent(contents, "Création d'une redirection générale vers [[" + title + "]]");

					System.out.println("Redirection créée vers " + title + ".");
				}

				if (justOne) {
					break;
				}

				page = pageCollection.getNextPage();
			}

			if (justOne) {
				break;
			}

		}
	}
}
