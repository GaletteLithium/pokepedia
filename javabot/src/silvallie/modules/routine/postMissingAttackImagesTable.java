package silvallie.modules.routine;

import silvallie.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class postMissingAttackImagesTable {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		String path = pokepediaPath + "Robot\\dumps\\tabledump.txt";
		boolean useGenerationToAttackDict = true;

		run(path, useGenerationToAttackDict);

		Silvallie.endRun(startTime);
	}

	/**
	 * Posts onto a sandpage the table of the missing attack images on Poképédia
	 * @param path The path where the table dump is saved
	 * @param useGenerationToAttackDict Set to true to use previously configured information. Should only be set to false when new attacks are revealed
	 */
	private static void run(String path, boolean useGenerationToAttackDict) throws IOException, InterruptedException {
		Page page = new Page("Utilisateur:Matt./Tableau des images de capacités");

		if (useGenerationToAttackDict) {
			String contents = generateMissingAttackImagesTable(path, useGenerationToAttackDict);

			System.out.println("Table created!");

			page.setContent(contents, "Mise à jour du tableau");

			System.out.println("Done!");
		} else {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String currentLine = br.readLine();
			String firstStep = currentLine;


			while (!currentLine.equals("|}")) {
				currentLine	= br.readLine();
				firstStep = firstStep + "\n" + currentLine;
			}

			// Rewriting the contents after subst has taken effect
			Path saveFilePath = Path.of(path);
			Files.writeString(saveFilePath, page.getContent());

			// Second step
			String secondStep = smoothMissingAttackImagesTable(path);
			page.setContent(secondStep, "Seconde étape de mise à jour du tableau");
			System.out.println("Second step done!");
		}
	}

	/**
	 * Generates a row of the attack table
	 * @param attackTitle The name of the attack
	 * @param useGenerationToAttackDict Set to true to use previously configured information. Should only be set to false when new attacks are revealed
	 * @param groupedGamesForAttacks A list of lists grouping the games where the attack animations are globally the same. Set to null for a default value
	 * @param generationsGamesForAttacks A list describing what in generation belong each of the element of <code>groupedGamesForAttacks</code>
	 */
	private static String generateRow(String attackTitle, boolean useGenerationToAttackDict,
							  String[][] groupedGamesForAttacks, int[] generationsGamesForAttacks) {
		if (groupedGamesForAttacks == null) {

			groupedGamesForAttacks = new String[][] {{"J"}, {"OA"},
					{"E", "RFVF", "RS"}, {"Colo"}, {"XD"}, {"HGSS", "DP", "Pt"}, {"N2B2", "NB"}, {"ROSA", "XY"},
					{"USUL", "SL"}, {"LGPE"}, {"EB"}, {"DEPS"}, {"LPA"}, {"EV"}};
			generationsGamesForAttacks = new int[] {1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 8, 8, 8, 9};
		}

		String[][][] exclusiveAttacks = {
				{{"RS", "RFVF", "E", "Colo", "XD", "DP", "Pt", "HGSS", "NB", "N2B2", "XY", "ROSA", "SL", "USUL", "EB", "DEPS"}, {"Ball'Météo (Grêle)"}},
				{{"Colo"}, {"Charge Noire"}},
				{{"XD"}, {"Aéro Noir", "Ardeur Noire", "Assaut Noir", "Ball'Météo (Ciel Noir)", "Bélier Noir", "Blocage Noir", "Brume Noire", "Charge Noire", "Chute Noire", "Ciel Noir", "Éclair Noir", "Folie Noire", "Froid Noir", "Onde Noire", "Percée Noire", "Rage Noire", "Retour Noir", "Souffle Noir", "Typhon Noir"}},
				{{"Colo", "XD"}, {"Frustration (0-30)", "Frustration (31-100)", "Frustration (101-200)", "Frustration (201-255)", "Retour (0-62)", "Retour (63-92)", "Retour (93-202)", "Retour (203-255)"}},
				{{"LPA"}, {"Hurle-Temps (Originelle)", "Jugement (Acier)", "Jugement (Combat)", "Jugement (Dragon)", "Jugement (Eau)", "Jugement (Électrik)", "Jugement (Fée)","Jugement (Feu)", "Jugement (Glace)", "Jugement (Insecte)", "Jugement (Normal)", "Jugement (Plante)", "Jugement (Poison)", "Jugement (Psy)", "Jugement (Roche)", "Jugement (Sol)", "Jugement (Spectre)", "Jugement (Ténèbres)", "Jugement (Vol)", "Revenant (Originelle)", "Spatio-Rift (Originelle)", "Typhon Fulgurant (Totémique)", "Typhon Hivernal (Totémique)", "Typhon Passionné (Totémique)", "Typhon Pyrosable (Totémique)"}},
				{{"EV"}, {"Ball'Météo (Neige)"}}
		};

		String ans = "";

		String attackLink = attackTitle;
		String attackName = attackLink.replace(" (capacité)", "");

		// Erase the precisions from the links, except when it's "(capacité)"
		if (attackLink.equals(attackName)) {
			attackLink = attackLink.replaceFirst("(?<a>[^\\(]*) \\((?<b>[^\\)]*)\\)", "$1");
		}

		String precision = attackName.replaceFirst("(?<a>[^\\(]*)\\((?<b>[^\\)]*)\\)", "$2");
		if (!precision.isEmpty() && !precision.equals(attackName)) {
			precision = " (" + precision + ")";
		} else {
			precision = "";
		}
		attackName = attackName.replaceFirst(" \\((?<a>[^\\)]*)\\)", "");

		String attackSymbol = "";
		if (PokeData.isZAbility(attackName)) {
			attackSymbol = " [[Fichier:Miniature Capacité Z SL.png|25px|Capacité Z|link=Capacité Z]]";
		} else if (PokeData.isDynamaxAbility(attackName)) {
			attackSymbol = " [[Fichier:Miniature Gigamax EB.png|25px|Capacité Dynamax|link=Capacité Dynamax]]";
		} else if (PokeData.isGigantamaxAbility(attackName)) {
			attackSymbol = " [[Fichier:Miniature Gigamax EB.png|25px|Capacité Gigamax|link=Capacité Gigamax]]";
		}

		String extension = ".gif";
		if (attackLink.equals(attackName)) {
			ans = ans + "\n|-\n| [[" + attackName + "]]" + attackSymbol
					+ "<br><small>" + precision + "</small>";
		} else {
			ans = ans + "\n|-\n| [[" + attackLink + "|" + attackName + "]]" + attackSymbol
					+ "<br><small>" + precision + "</small>";
		}

		ans = ans + "\n| ";
		int generationAttack = 0;

		if (useGenerationToAttackDict) {
			generationAttack = PokeData.getGenerationAttack(attackLink);
			ans = ans + Integer.toString(generationAttack);
		} else {
			ans = ans + "{{subst:#show:" + attackLink + "|?Génération de la capacité}}";
		}


		for(int i=0; i<groupedGamesForAttacks.length; i++) {
			if (useGenerationToAttackDict && generationsGamesForAttacks[i] < generationAttack) {
				ans = ans + "\n| —";
			} else {
				String[] games = groupedGamesForAttacks[i];
				boolean found = false;
				boolean unavailableFromAll = true;
				String foundFile = "";
				// Searching in all the pairs of games
				for (String currentGame : games) {
					if (currentGame.equals("Colo") || currentGame.equals("XD")
							|| currentGame.equals("XY") || currentGame.equals("ROSA")
							|| currentGame.equals("SL") || currentGame.equals("USUL") || currentGame.equals("LGPE")
							|| currentGame.equals("EB") || currentGame.equals("DEPS") || currentGame.equals("LPA")
							|| currentGame.equals("EV") || currentGame.equals("LPZA")) {
						extension = ".mp4";
					} else {
						extension = ".gif";
					}

					boolean unavailable = false;

					// is the attack unavailable in this game?
					String[] unavailableAttacksForGame = PokeData.getUnavailableAttacks(currentGame);
					for (String attack : unavailableAttacksForGame) {
						if (attackName.equals(attack)) {
							unavailable = true;
							break;
						}
					}


					// is the attack exclusive to another game?
					if (!unavailable) {
						boolean isExclusiveToThisGame = false;
						for (String[][] exclusiveAttacksCell : exclusiveAttacks) {
							if (unavailable) {
								break;
							}
							for (String exclusiveAttack : exclusiveAttacksCell[1]) {
								if (attackTitle.equals(exclusiveAttack)) {
									for (String exclusiveGame : exclusiveAttacksCell[0]) {
										// is exclusive to this game
										if (currentGame.equals(exclusiveGame)) {
											// the attack is exclusive to this game
											isExclusiveToThisGame = true;
											unavailable = false;
											break;
										} else {
											// the attack is exclusive to another game
											if (!isExclusiveToThisGame) {
												unavailable = true;
											}
										}
									}
								}
							}
						}
					}

					if (!unavailable) {
						unavailableFromAll = false;

						String pageName = "Fichier:" + attackName + precision + " " + currentGame + extension;
//						System.out.println("\nChecking...");
//						System.out.println(pageName);
						Page page = new Page(pageName);
						if (page.getContent() != null) {
							found = true;
							foundFile = page.getTitle();
							break;
						}
					}
				}

				if (unavailableFromAll) {
					ans = ans + "\n| —";
				} else if (found) {
					ans = ans + "\n| [[:" + foundFile + "|ok]]";
				} else {
					ans = ans + "\n| [[Fichier:Nocheck.png]]";
				}
			}
		}

		ans = ans.replace("<br><small></small>", "");
		ans = ans.replace("<small> (", "<small>(");

		return ans;
//		if (attackName.equals("Abattage")) {
//			break;
//		}
	}

	/**
	 * Generates a table describing which attack animations are present and which are mising
	 * @param path The path where to save the table dump
	 * @param useGenerationToAttackDict Set to true to use previously configured information. Should only be set to false when new attacks are revealed
	 */
	private static String generateMissingAttackImagesTable(String path, boolean useGenerationToAttackDict) throws IOException, InterruptedException {

		PageCollection pageCollection = new PageCollection(
				new int[] {API.NS_MAIN},
				API.FILTER_NONREDIRECTS,
				"Capacité"
		);

		String[] attacksToDelete = {"Aéro-Lames", "Ampleur", "Cadeau", "Faucheuse", "Hurlement des Roches-Lames", "Kokiyarme", "Malédiction"};
		String[] attacksToAdd = {
				"Aire d'Eau (combinée à Aire de Feu)", "Aire d'Eau (combinée à Aire d'Herbe)", "Aire de Feu (combinée à Aire d'Eau)", "Aire de Feu (combinée à Aire d'Herbe)", "Aire d'Herbe (combinée à Aire d'Eau)", "Aire d'Herbe (combinée à Aire de Feu)", "Ampleur (4)", "Ampleur (5)", "Ampleur (6)", "Ampleur (7)", "Ampleur (8)", "Ampleur (9)", "Ampleur (10)", "Ball'Météo (Soleil)", "Ball'Météo (Pluie)", "Ball'Météo (Grêle)", "Ball'Météo (Neige)", "Ball'Météo (Tempête de sable)", "Ball'Météo (Ciel Noir)", "Bombe au Sirop (chromatique)", "Caboche-Kaboum (chromatique)", "Cadeau (dégâts)", "Cadeau (soin)", "Champlification (Champ Brumeux)", "Champlification (Champ Électrifié)", "Champlification (Champ Herbu)", "Champlification (Champ Psychique)", "Éclair Croix (boostée)", "Flamme Croix (boostée)", "Frustration (0-30)", "Frustration (31-100)", "Frustration (101-200)", "Frustration (201-255)", "Hurle-Temps (Originelle)", "Hurlement des Roches-Lames (Diurne)", "Hurlement des Roches-Lames (Nocturne)", "Hurlement des Roches-Lames (Crépusculaire)", "Jugement (Acier)", "Jugement (Combat)", "Jugement (Dragon)", "Jugement (Eau)", "Jugement (Électrik)", "Jugement (Fée)","Jugement (Feu)", "Jugement (Glace)", "Jugement (Insecte)", "Jugement (Plante)", "Jugement (Poison)", "Jugement (Psy)", "Jugement (Roche)", "Jugement (Sol)", "Jugement (Spectre)", "Jugement (Ténèbres)", "Jugement (Vol)", "Kokiyarme (physique)", "Kokiyarme (spéciale)", "Laser Hasard (sérieux)", "Malédiction (Spectre)", "Malédiction (non-Spectre)", "Massue Liane (Eau)", "Massue Liane (Feu)", "Massue Liane (Roche)", "Monte-Tension (Champ Électrifié)",  "Plat du Jour (Affalée)", "Plat du Jour (Courbée)", "Plat du Jour (Raide)", "Pluie Térastrale (Stellaire)", "Pluie Térastrale (Stellaire, zone)", "Retour (0-62)", "Retour (63-92)", "Retour (93-202)", "Retour (203-255)", "Revenant (Originelle)", "Spatio-Rift (Originelle)", "Taurogne (Paldea Aquatique)", "Taurogne (Paldea Combative)", "Taurogne (Paldea Flamboyante)", "Techno-Buster (Eau)", "Techno-Buster (Électrik)", "Techno-Buster (Feu)", "Techno-Buster (Glace)", "Téra Explosion (Acier)", "Téra Explosion (Combat)", "Téra Explosion (Dragon)", "Téra Explosion (Eau)", "Téra Explosion (Électrik)", "Téra Explosion (Fée)","Téra Explosion (Feu)", "Téra Explosion (Glace)", "Téra Explosion (Insecte)", "Téra Explosion (Normal)", "Téra Explosion (Plante)", "Téra Explosion (Poison)", "Téra Explosion (Psy)", "Téra Explosion (Roche)", "Téra Explosion (Sol)", "Téra Explosion (Spectre)", "Téra Explosion (Stellaire)", "Téra Explosion (Ténèbres)", "Téra Explosion (Vol)", "Typhon Fulgurant (Totémique)", "Typhon Hivernal (Totémique)", "Typhon Passionné (Totémique)", "Typhon Pyrosable (Totémique)"
		};
		String ans = "";


		Page attackPage = pageCollection.getNextPage();

		for (int i=1; i<9; i++) {
			attackPage = pageCollection.getNextPage();
		}

//		while (!attackPage.getTitle().equals("Jugement")) {
//			attackPage = pageCollection.getNextPage();
//		}

		while (attackPage != null) {
			try {
				String attackTitle = attackPage.getTitle();
				boolean isToSkip = false;
				for (String attackToDelete : attacksToDelete) {
					if (attackTitle.equals(attackToDelete)) {
						isToSkip = true;
						break;
					}
				}
				if (!isToSkip) {
					String row = generateRow(attackTitle, useGenerationToAttackDict, null, null);
					System.out.print(row);
					ans = ans + row;
				}
				attackPage = pageCollection.getNextPage();
			} catch (Exception e) {
				System.err.println("Error. Retrying in 10 s.");
				TimeUnit.SECONDS.sleep(10);
			}
		}
		for (String bonusAttack : attacksToAdd) {
			String row = generateRow(bonusAttack, useGenerationToAttackDict, null, null);
			System.out.print(row);
			ans = ans + row;
		}

		System.out.println("|}\n\n\nok");

		Path saveFilePath = Path.of(path);

		ans = "{{Utilisateur:Matt./Bandeau}}\n"
				+ "\n"
				+ "Voici un tableau qui résume quelles images de capacités manquent sur le wiki. Il n'est pas automatiquement à jour, donc pensez à vérifier la dernière date d'édition de cette page.\n"
				+ "\n"
				+ "Pour une meilleure utilisation, il est préférable de trier le tableau par nom puis par génération d'apparition.\n"
				+ "\n__TOC__"
				+ "\n"
				+ "== Tableau des images de capacités ==\n"
				+ "\n<div class=\"center\">\n"
				+ "{| class=\"tableaustandard centre sortable entetefixe tableau-overflow\" style=\"white-space:nowrap\"\n"
				+ "! Capacité\n"
				+ "! Génération<br>d'apparition\n"
				+ "! width=\"50px\" | G1\n"
				+ "! width=\"50px\" | G2\n"
				+ "! width=\"50px\" | G3\n"
				+ "! width=\"50px\" | {{Abréviation|Colo}}\n"
				+ "! width=\"50px\" | {{Abréviation|XD}}\n"
				+ "! width=\"50px\" | G4\n"
				+ "! width=\"50px\" | G5\n"
				+ "! width=\"50px\" | G6\n"
				+ "! width=\"50px\" | {{Abréviation|SL}}<br>{{Abréviation|USUL}}\n"
				+ "! width=\"50px\" | {{Abréviation|LGPE}}\n"
				+ "! width=\"50px\" | {{Abréviation|EB}}\n"
				+ "! width=\"50px\" | {{Abréviation|DEPS}}\n"
				+ "! width=\"50px\" | {{Abréviation|LPA}}\n"
				+ "! width=\"50px\" | {{Abréviation|EV}}"
				+ ans + "\n|}\n</div>";

		Files.writeString(saveFilePath, ans);



		// Attacks with different animations within the same generation
		ans = ans + "\n\n== Différentes animations au sein d'une même génération ==";
		boolean firstTable = true;

		String[][] differingAttacks = {
				{"Brouhaha", "Danse Pluie", "Grêle (capacité)", "Mach Punch", "Puissance Cachée", "Soin", "Spatio-Rift", "Tranch'Herbe"},
				{"Abîme", "Aurasphère", "Cauchemar", "Colère", "Croc de Mort", "Déflagration", "Dynamo-Poing", "Fatal-Foudre", "Feu Sacré", "Giga Impact", "Hâte", "Hydroblast", "Mâchouille", "Mégacorne", "Mégafouet", "Psycho-Boost", "Psyko", "Trou Noir", "Stratopercut", "Surpuissance", "Ultimawashi", "Ultralaser", "Vol (capacité)"},
				{"Vitesse Extrême"},
				{"Aéroblast", "Aéropique", "Blizzard", "Boutefeu", "Cascade", "Cauchemar", "Charge Foudre", "Close Combat", "Colère", "Coup Victoire", "Damoclès", "Déflagration", "Destruction", "Dynamo-Poing", "Éclair Gelé", "Élecanon", "Électacle", "Ère Glaciaire", "Explonuit", "Feu d'Enfer", "Feu Glacé", "Feu Sacré", "Flamme Bleue", "Frappe Psy", "Giga Impact", "Griffe Ombre", "Hâte", "Incendie (capacité)", "Mégacorne", "Mégafouet", "Peignée", "Psycho-Boost", "Psyko", "Siphon", "Spatio-Rift", "Stratopercut", "Surchauffe", "Surpuissance", "Vibraqua", "Vitesse Extrême"},
				{"Déflagration", "Draco-Choc", "Hydroblast", "Lance-Flammes", "Pied Brûleur", "Puissance Cachée"}
				//{"Blizzard", "Brume", "Onde Boréale", "Télékinésie", "Ultimapoing", "Vol (capacité)"}

		};
		String[][][] gamesDifferingAttacks = {
				{{"DP"}, {"Pt", "HGSS"}},
				{{"DP", "Pt"}, {"HGSS"}},
				{{"DP", "HGSS"}, {"Pt"}},
				{{"NB"}, {"N2B2"}},
				{{"XY"}, {"ROSA"}},
				//{{"EB"}, {"DEPS"}},
		};
		int[] generationsGamesDifferingAttacks = {4, 4, 4, 5, 6};

		for (int i = 0; i < differingAttacks.length; i++) {
			String[] attacks = differingAttacks[i];
			String[][] games = gamesDifferingAttacks[i];
			int generation = generationsGamesDifferingAttacks[i];

			String tmpAns = "";

			for (String attack : attacks) {
				int[] generations = {generation, generation};
				String row = generateRow(attack, useGenerationToAttackDict, games, generations);
				System.out.print(row);
				tmpAns = tmpAns + row;
			}

			// Section title
			String gamesLeft = "";
			String gamesRight = "";
			boolean firstGame = true;
			for (int j = 0; j < games[0].length; j++) {
				if (firstGame) {
					firstGame = false;
				} else {
					gamesLeft = gamesLeft + ", ";
				}
				gamesLeft = gamesLeft + "{{Abréviation|" + games[0][j] + "}}";
			}
			firstGame = true;
			for (int j = 0; j < games[1].length; j++) {
				if (firstGame) {
					firstGame = false;
				} else {
					gamesRight = gamesRight + ", ";
				}
				gamesRight = gamesRight + "{{Abréviation|" + games[1][j] + "}}";
			}
			String tableTitle = gamesLeft + " vs " + gamesRight;


			if (firstTable) {
				firstTable = false;
			} else {
				ans = ans + "\n";
			}

			ans = ans + "\n=== " + tableTitle + " ===\n"
					+ "\n"
					+ "{| class=\"tableaustandard centre sortable entetefixe\"\n"
					+ "! Capacité\n"
					+ "! Génération<br>d'apparition\n"
					+ "! width=\"50px\" | " + gamesLeft.replace(", ", "<br>") + "\n"
					+ "! width=\"50px\" | " + gamesRight.replace(", ", "<br>")
					+ tmpAns + "\n|}";

		}

		Files.writeString(saveFilePath, ans);

		return ans;

	}

	/**
	 * Smooths the table so that it is more precise on which animations are missing and which ones are not present in the game
	 * @param path The path where the table dump is saved
	 */
	private static String smoothMissingAttackImagesTable(String path) throws IOException {

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String currentLine = br.readLine();
		String fileText = currentLine;


		while (!currentLine.equals("|}")) {
			currentLine	= br.readLine();
			fileText = fileText + "\n" + currentLine;
		}

		// Request → Text
		// [[:Première génération|Première génération]] → Première génération
		fileText = fileText.replaceAll("\\| \\[\\[[^\\]]*\\]\\] \\(\\[\\[:[^\\|]*\\|(?<a>[^\\]]*)\\]\\]\\)", "| $1");

		// Text -> Number
		fileText = fileText.replace("Première génération", "1");
		fileText = fileText.replace("Deuxième génération", "2");
		fileText = fileText.replace("Troisième génération", "3");
		fileText = fileText.replace("Quatrième génération", "4");
		fileText = fileText.replace("Cinquième génération", "5");
		fileText = fileText.replace("Sixième génération", "6");
		fileText = fileText.replace("Septième génération", "7");
		fileText = fileText.replace("Huitième génération", "8");
		fileText = fileText.replace("Neuvième génération", "9");

		// Replacing nochecks with bars when not available because of anachronism
		String nocheckLine = "\n| [[Fichier:Nocheck.png]]";
		String blankLine = "\n| —";
		for (int i = 2; i < 4; i++) {
			fileText = fileText.replace("| " + Integer.toString(i) + nocheckLine.repeat(i-1),
					"| " + Integer.toString(i) + blankLine.repeat(i-1));
		}
		// Shift due to Colo
		for (int i = 4; i < 8; i++) {
			fileText = fileText.replace("| " + Integer.toString(i) + nocheckLine.repeat(i),
					"| " + Integer.toString(i) + blankLine.repeat(i));
		}
		fileText = fileText.replace("| 8" + nocheckLine.repeat(9), "| 8" + blankLine.repeat(9));
		fileText = fileText.replace("| 9" + nocheckLine.repeat(12), "| 9" + blankLine.repeat(12));

		System.out.println("Done general replacing! Removing specific attacks...");

		// Removing specific attacks not present in games
		String anythingCellRegexp = "\n\\| [^\n]*";
		String nocheckCellRegexp = "\n\\| \\[\\[Fichier:Nocheck\\.png\\]\\]";
		String[] unfullGames = new String[] {"USUL", "LGPE", "EB", "DEPS", "LPA", "EV"};
		for (int i = 0; i < unfullGames.length; i++) {
			String[] absentAttacks = PokeData.getUnavailableAttacks(unfullGames[i]);
			System.out.println("=== " + unfullGames[i] + " ===");
			for (String absentAttack : absentAttacks) {
				fileText = fileText.replaceFirst("(?<a>[^\n]*" + absentAttack +
						"[^\n]*)(?<b>" + anythingCellRegexp.repeat(8 + i) + ")" + nocheckCellRegexp, "$1$2" + blankLine);
				System.out.println(absentAttack);
			}
		}


		Path saveFilePath = Path.of(path);

		Files.writeString(saveFilePath, fileText);

		System.out.println("Done smoothing!");

		return fileText;
	}
}
