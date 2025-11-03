package silvallie.modules.routine;

import silvallie.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class getSpecialCardNames {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		String[] categoryNames = {"Carte du JCC", "Carte du JCCP"};
//		String[] categoryNames = {"Carte de l'extension XY Vigueur Spectrale"};

		String startingFrom = null;
//		String startingFrom = "ラッキースタジアム Yokohama (Japanese World Challenge Summer)";

		String outputName = pokepediaPath + "Robot\\cards_special_name.txt";
		String outputAttacksName = pokepediaPath + "Robot\\card_attacks_name.txt";
		boolean merge = true;
		boolean post = true;
		boolean justOne = false;

		run(categoryNames, startingFrom, outputName, outputAttacksName, merge, post, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Browse through all Pokémon cards and save every name not exactly matching the card's title (e.g. due to symbols),
	 * as well as a list of attacks they have
	 * @param categoryNames The names of the categories to go through
	 * @param startingFrom The name of the first page. Set to null to begin from start
	 * @param outputName The path to save the special names dump at
	 * @param outputAttacksName The path to save the attack list dump at
	 * @param merge Set to true to merge the dump with an existing saved dump—useful if the categories are missing items
	 * @param post Set to true to post the result
	 * @param justOne Set to true to stop after the first page inspection. Please use this on the first run to avoid accidents
	 */
	private static void run(String[] categoryNames, String startingFrom, String outputName, String outputAttacksName, boolean merge, boolean post, boolean justOne) throws IOException {
		String ans = "";
		String attacksAns = "";

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
				String contents = page.getContent();

				if (!contents.contains("{{Article carte")) {
					page = pageCollection.getNextPage();
					continue;
				}

				String[] lines = contents.split("\n");
				String name = "";
				String[] attacks = new String[5];
				String[] prefixesAttacks = {"attaque", "attaque2", "attaque3", "attaque4", "vstar"};

				// Finding the name
				String key = "| nom=";
				if (contents.contains(key)) {
					int keyIndex = contents.indexOf(key);
					name = contents.substring(keyIndex + key.length(), contents.indexOf("\n", keyIndex));
				}

				// Finding the more appropriate key for attacks
				for (int i = 0; i < prefixesAttacks.length; i++) {
					String prefixAttack = prefixesAttacks[i];
					key = "| " + prefixAttack + "-nom-formaté=";
					if (!contents.contains(key)) {
						key = "| " + prefixAttack + "-nom-trad=";
						if (contents.contains(key)) {
							if (contents.contains("| " + prefixAttack + "-nom-ref=non")) {
								key = "| " + prefixAttack + "-nom=";
							}
						} else {
							key = "| " + prefixAttack + "-nom=";
						}
					}

					if (contents.contains(key)) {
						int keyIndex = contents.indexOf(key);
						String newAttack = contents.substring(keyIndex + key.length(), contents.indexOf("\n", keyIndex));
						if (!newAttack.isEmpty()) {
							attacks[i] = newAttack;
						}
					}
				}

				if (name.isEmpty()) {
					System.err.println("Nom non trouvé pour la carte " + title);
				} else {
					String articleName = title.replaceAll(" \\([^\n]*\\)", "");

					if (!name.equals(articleName)) {

						String link = "[[" + title + "|" + name + "]]";

						link = link.replaceAll("(\\{\\{[^\\}]*\\}\\})([^\\{]+)\\]\\]", "]]$1[[" + title + "|$2]]"); // Pour les symboles en milieu de nom
						while (link.contains("}}]]")) {
							link = link.replaceAll("(\\{\\{[^\\}]*\\}\\})\\]\\]", "]]$1"); // Pour les symboles en fin de nom
							// Répété pour les multiples symboles, comme sur Énergie Amalgamée
						}
						link = link.replaceAll("(\\[\\[[^\\|\\]]*\\|)(\\{\\{[^\\}]*\\}\\})", "$2$1");
						link = link.replaceAll("\\[\\[[^\\]\\|]*\\| *\\]\\]", ""); // Pour les liens vides dus aux symboles en début de nom

						link = link.replace(" ]]", "]] ");
						link = link.replaceAll("(\\[\\[[^\\|\\]]*\\|) ", " $1");

						String newEntry = "| " + title + " = " + link;
						System.out.println(newEntry);
						ans += "\n" + newEntry;

						if (justOne) {
							break;
						}
					}
				}

				for (String attack : attacks) {
					if (attack != null) {
						attacksAns += attack + "\n";
					}
				}
				page = pageCollection.getNextPage();
			}
			ans = ans + "\n";
		}

//		System.out.println(ans);
		ans = "<includeonly>{{#switch: {{{1}}}" + ans + "\n| #default = [[{{{1}}}|{{#invoke:Regexp|retirerparentheses|{{{1}}}}}]]\n}}</includeonly><noinclude>{{/Documentation}}</noinclude>";

		// Names
		FileOutputStream outputStream = new FileOutputStream(outputName);
		byte[] strToBytes = ans.getBytes();
		outputStream.write(strToBytes);
		String savName = outputName.replace(".txt", "_sav.txt");

		outputStream.close();

		// Attacks
		String[] attacksAnsSplit = attacksAns.split("\n");
		List<String> attacksAnsList = new ArrayList<>(List.of(attacksAnsSplit));
		List<String> attacksAnsListFiltered = new ArrayList<>(new LinkedHashSet<>(attacksAnsList));

		Collections.sort(attacksAnsListFiltered, Util.comparateurSansAccent);
		System.out.println(attacksAnsListFiltered);
		String newAttacksAns = "";
		for (String a : attacksAnsListFiltered) {
			if (a != "") {
				newAttacksAns += a + "\n";
			}
		}

		FileOutputStream outputStreamAttacks = new FileOutputStream(outputAttacksName);
		byte[] strToBytesAttacks = newAttacksAns.getBytes();
		outputStreamAttacks.write(strToBytesAttacks);
		String savAttacksName = outputAttacksName.replace(".txt", "_sav.txt");

		outputStreamAttacks.close();

		if (merge) {
			mergeFiles(outputName, savName, savName);

			byte[] encoded = Files.readAllBytes(Paths.get(savName));
			ans = new String(encoded, "utf-8");
		}

		if (!justOne && post) {
			Page page = new Page("Modèle:Lien carte");
			page.setContent(ans, "Mise à jour des liens de cartes");
		}
	}

	/**
	 * Merge two files, keeping as much as possible the original order
	 * @param inputName1 The first file to merge
	 * @param inputName2 The second file to merge
	 * @param outputName The output path to save the result
	 */
	private static void mergeFiles(String inputName1, String inputName2, String outputName) {
		Set<String> seenLines = new HashSet<>();
		List<String> mergedLines = new ArrayList<>();

		try {
			// Lire le premier fichier et ajouter les lignes
			readAndAddLines(inputName1, seenLines, mergedLines);

			// Lire le deuxième fichier et insérer les nouvelles lignes dans le bon ordre
			try (BufferedReader reader = new BufferedReader(new FileReader(inputName2))) {
				String line;
				int index = 0;

				while ((line = reader.readLine()) != null) {
					if (line.trim().isEmpty()) {
						mergedLines.add(index++, line); // Intercaler ligne vide
					} else if (!seenLines.contains(line)) {
						mergedLines.add(index++, line);
						seenLines.add(line);
					} else {
						// Si déjà vue, avancer l'index mais ne pas l'ajouter
						index = mergedLines.indexOf(line) + 1;
					}
				}
			}

			// Écriture dans le fichier de sortie
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputName))) {
				int emptyCount = 0;

				for (String line : mergedLines) {
					if (line.trim().isEmpty()) {
						emptyCount++;
						if (emptyCount <= 1) {
							writer.write(line);
							writer.newLine();
						}
					} else {
						emptyCount = 0;
						writer.write(line);
						writer.newLine();
					}
				}
			}

			System.out.println("Fusion terminée avec intercalation.");
		} catch (IOException e) {
			System.err.println("Erreur lors de la lecture ou de l'écriture des fichiers : " + e.getMessage());
		}
	}

	/**
	 * Merge two files, keeping as much as possible the original order
	 * @param file The first file to merge
	 * @param seenLines A set of lines already seen
	 * @param mergedLines A set of lines already merged
	 */
	private static void readAndAddLines(String file, Set<String> seenLines, List<String> mergedLines) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				mergedLines.add(line);
				if (!line.trim().isEmpty()) {
					seenLines.add(line);
				}
			}
		}
	}
}
