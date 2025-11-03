package silvallie.modules.oneTimeUse;

import silvallie.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class convertCardArticle {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

//		String[] categoryNames = {"Carte du JCC"};
		String[] categoryNames = {"Carte Promo"};
//		String[] categoryNames = {"Carte de l'extension L'Île Fabuleuse"};
//		String[] categoryNames = {"Carte de l'extension XY Vigueur Spectrale"};
//		String[] categoryNames = {"Carte de l'extension Énergie de base SV"};
//		String[] categoryNames = {"Carte de l'extension Diamant & Perle Trésors Mystérieux"};
//		String[] categoryNames = {"Carte de l'extension Écarlate et Violet Évolutions Prismatiques"};

		String startingFrom = null;
//		startingFrom = "タッチ交換!";

		String outputName = pokepediaPath + "Robot\\card_article.txt";

		boolean post = true;
		boolean verbose = false;
		int howMany = 1;

		run(categoryNames, startingFrom, outputName, post, verbose, howMany);

		Silvallie.endRun(startTime);
	}

	/**
	 * Creates a dump of all articles in one or more given categories
	 * @param categoryNames The names of the categories to go through
	 * @param startingFrom The name of the first page. Set to null to begin from start
	 * @param outputName The path to the file where to write the pages with errors
	 * @param post Set to true to actually edit the pages
	 * @param verbose Set to true to give more detail in the prints while executing
	 * @param howMany How many articles should be reviewed (1 activates <code>verbose</code>)
	 */
	private static void run(String[] categoryNames, String startingFrom, String outputName, boolean post, boolean verbose, int howMany) throws IOException {
		if (howMany == 1) {
			verbose = true;
		}

		String errorLog = "";
		String convertedContents = "";

		int pageCount = 0;
		int errorCount = 0;


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

				// Pour éviter les pages globales comme Énergie Feu
//				if (!title.contains("(")) {
//					page = pageCollection.getNextPage();
//					continue;
//				}

				convertedContents = "";
				String pageErrorLog = "";
				String contents = page.getContent();
				if (verbose) {
					System.out.println(title);
				}

				// CHANGEMENTS GLOBAUX
				// Mauvais liens dans l'intro d'évolution
				if (contents.contains("Scan de carte")) {
					contents = contents.replaceAll("\\[\\[[:]*Catégorie:Scan de carte représentant [^\\|]*\\|([^\\]]*)\\]\\]",
							"{{Requête JCC|[[Nom de carte formaté::$1]]|texte=$1|jeu=jcc}}");
//					System.out.println(contents);
				}
				// liens dans le en français
				for (int i = 0 ; i < 2 ; i++) {
					contents = contents.replaceAll("(en français *: *'+[^\\)]*)\\[\\[([^\\)]*?)\\]\\]", "$1$2");
				}
				// liens noms facultés
				contents = contents.replaceAll("(\\| nom[0-9]?=)\\[\\[([^\n]*)\\]\\]", "$1$2");
				contents = contents.replace("?extension|", "?extension |");
				contents = contents.replace(". Il doit être joué sur un", ". Elle doit être posée sur un");

				// requêtes inutiles
				contents = contents.replace("{{#ask: [[Catégorie:Carte Outil Pokémon]] | ?extension | limit=0 | searchlabel=Outil Pokémon}}", "[[Outil Pokémon]]");
				contents = contents.replace("{{#ask: [[Catégorie:Carte HIGH-TECH]] | ?extension | limit=0 | searchlabel=cartes '''''HIGH-TECH'''''}}", "[[Carte HIGH-TECH|cartes '''''HIGH-TECH''''']]");

				// has text...
				String[] hasTextAttacks = {"Berceuse", "Chant Canon", "Frotte-Frimousse", "Roulade Collégiale", "Marche Nocturne", "Tête de la Fête"};
				for (String hasTextAttack : hasTextAttacks) {
					contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Has text::" + hasTextAttack + "]] | ?extension | limit=0 | searchlabel=" + hasTextAttack + "}}",
							"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Has text::" + hasTextAttack + "]]|texte=" + hasTextAttack + "|jeu=jcc}}");
				}
				// ask Ultra-Chimères
				contents = contents.replace("{{#ask: [[Catégorie:Carte Ultra-Chimère]] [[Catégorie:Carte Pokémon-GX]] | searchlabel=Pokémon-GX Ultra-Chimères | limit=0 | format=table | ?extension}}",
						"{{Requête JCC|[[Sous-catégorie de carte::Carte Pokémon-GX]] [[Sous-catégorie de carte::Carte Ultra-Chimère]]|texte=Pokémon-GX Ultra-Chimères|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Ultra-Chimère]] [[Catégorie:Carte Pokémon-EX]] | searchlabel=Pokémon-EX Ultra-Chimères | limit=0 | format=table | ?extension}}",
						"{{Requête JCC|[[Sous-catégorie de carte::Carte Pokémon-EX]] [[Sous-catégorie de carte::Carte Ultra-Chimère]]|texte=Pokémon-EX Ultra-Chimères|jeu=jcc}}");
				// Pokémon de Style
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Poing Final]] | ?extension | limit=0 | searchlabel=Pokémon Poing Final}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Style de Combat::Poing Final]]|texte=Pokémon Poing Final|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Mille Poings]] | ?extension | limit=0 | searchlabel=Pokémon Mille Poings}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Style de Combat::Mille Poings]]|texte=Pokémon Mille Poings|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Poing de Fusion]] | ?extension | limit=0 | searchlabel=Pokémon Poing de Fusion}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Style de Combat::Poing de Fusion]]|texte=Pokémon Poing de Fusion|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Poing Final]] | ?extension | limit=0 | searchlabel=Poing Final}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Style de Combat::Poing Final]]|texte=Poing Final|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Mille Poings]] | ?extension | limit=0 | searchlabel=Mille Poings}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Style de Combat::Mille Poings]]|texte=Mille Poings|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Poing de Fusion]] | ?extension | limit=0 | searchlabel=Poing de Fusion}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Style de Combat::Poing de Fusion]]|texte=Poing de Fusion|jeu=jcc}}");
				// Temps
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Temps passé]] | ?extension | limit=0 | searchlabel=Pokémon Temps passé}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Temps (JCC)::Passé]]|texte=Pokémon Temps passé|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Temps futur]] | ?extension | limit=0 | searchlabel=Pokémon Temps futur}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Temps (JCC)::Futur]]|texte=Pokémon Temps futur|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Temps passé]]| ?extension |limit=0|searchlabel=Pokémon Temps passé}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Temps (JCC)::Passé]]|texte=Pokémon Temps passé|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Pokémon]] [[Catégorie:Carte Temps futur]]| ?extension |limit=0|searchlabel=Pokémon Temps futur}}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Temps (JCC)::Futur]]|texte=Pokémon Temps futur|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Supporter]] [[Catégorie:Carte Temps passé]] | ?extension | limit=0 | searchlabel=carte Supporter Temps passé}}",
						"{{Requête JCC|[[Sous-catégorie de carte::Carte Supporter]] [[Temps (JCC)::Passé]]|texte=carte Supporter Temps passé|jeu=jcc}}");
				contents = contents.replace("{{#ask: [[Catégorie:Carte Supporter]] [[Catégorie:Carte Temps futur]] | ?extension | limit=0 | searchlabel=carte Supporter Temps futur}}",
						"{{Requête JCC|[[Sous-catégorie de carte::Carte Supporter]] [[Temps (JCC)::Futur]]|texte=carte Supporter Temps futur|jeu=jcc}}");

				// Énergie Plasma
				contents = contents.replaceAll("\\{\\{#ask: *\\[\\[Catégorie(| de carte:):Carte Pokémon\\]\\] \\[\\[Catégorie:Carte de la Team Plasma\\]\\]*[ \\?extension\\|]*limit=0 *\\| *searchlabel=([^\\|\\}]*)[^\\}]*\\}\\}",
						"{{Requête JCC|[[Catégorie de carte::Carte Pokémon]] [[Sous-catégorie de carte::Carte de la Team Plasma]]|texte=$2|jeu=jcc}}");
				contents = contents.replaceAll("\\{\\{#ask: \\[\\[Catégorie(| de carte:):Carte Dresseur(| \\(JCC\\))\\]\\] \\[\\[Catégorie:Carte de la Team Plasma\\]\\] *\\| *\\?extension *\\| *limit=0 \\| searchlabel=([^\\|\\}]*)[^\\}]*\\}\\}",
						"{{Requête JCC|[[Catégorie de carte::Carte Dresseur (JCC)]] [[Sous-catégorie de carte::Carte de la Team Plasma]]|texte=$3|jeu=jcc}}");
				contents = contents.replaceAll("\\{\\{#ask: \\[\\[Catégorie(| de carte:):Carte Énergie\\]\\] \\[\\[Catégorie:Carte de la Team Plasma\\]\\] *\\| *\\?extension *\\| *limit=0 \\| searchlabel=([^\\|\\}]*)[^\\}]*\\}\\}",
						"{{Requête JCC|[[Catégorie de carte::Carte Énergie]] [[Sous-catégorie de carte::Carte de la Team Plasma]]|texte=$2|jeu=jcc}}");
				// évolution symbole
				contents = contents.replace("|jeu=jcc}}{{Symbole JCC|V}} pour", "-V|jeu=jcc}} pour");
				contents = contents.replaceFirst("\\|jeu=jcc\\}\\} *\\{\\{Symbole JCC\\|([^\\}]*)\\}\\} pour", " $1|jeu=jcc}} pour");
				// autres ask
				Pattern pattern = Pattern.compile("(\\{\\{#ask:)([^\n\\}]*)(\\| *searchlabel=)([^\n\\|]+?)( *[\\|\\}]+[^\n\\}]*?\\}\\})");
				Matcher matcher = pattern.matcher(contents);
				String tmpContents = contents;
				while(matcher.find()) {
					String replacing = matcher.group(1) + matcher.group(2) + matcher.group(3) + matcher.group(4) + matcher.group(5);

					if (matcher.group(2).contains("Has text")) {
						continue;
					}
					String label = matcher.group(4);

					if (verbose) {
						System.out.println("\task remplacé : " + replacing + "\n\t -> " + label);
					}

					tmpContents = tmpContents.replace(replacing,
							"{{Requête JCC|[[Nom de carte formaté::" + label + "]]|texte=" + label + "|jeu=jcc}}");
				}
				contents = tmpContents;
				// correction Lien Spirituel
				contents = contents.replaceAll("Nom de carte formaté::'*M'*", "Nom de carte formaté::M");
				if (contents.contains("#ask")) {
					pageErrorLog += "\nask présent sur la page";
				}

				// Description pas en italique
				pattern = Pattern.compile("(== Description du Pokémon ==\n+)([:']*)([^'\n]+[^\n]*[^'\n]+)([']*)");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					String g1 = matcher.group(1);
					String colon = matcher.group(2);
					String g2 = matcher.group(3);
					String end = matcher.group(4);
					contents = contents.replace(g1 + colon + g2 + end, g1 + ":''" + g2 + "''");
				}

				// Donnée has text
//				if (contents.contains("Has text")) {
//					pageErrorLog += "\nHas text enlevé";
//				}

				// Paragraphe de règles
				pattern = Pattern.compile("\n== [^\n]*règle[^\n]* ==\n");
				matcher = pattern.matcher(contents.toLowerCase());
				if (matcher.find()) {
					pageErrorLog += "\nParagraphe de règles présent sur la page.";
				}

				// DÉFINITION DES PARAGRAPHES
				String displayTitle			= "";
				String parBandeaux			= "<!-- Bandeaux de haut de page -->";
				String parInfobox			= "<!-- Infobox -->";
				String parFacultes			= "<!-- Facultés -->";
				String parDescription		= "<!-- Description -->";
				String parAnecdotes			= "<!-- Anecdotes -->";
				String parCartesIdentiques 	= "<!-- Cartes identiques -->";
				String parAutres			= "<!-- Autres -->";
				String interwiki			= "";
				String setHasText			= "";

				if (!contents.contains("{{Infobox Carte")) {
					page = pageCollection.getNextPage();
					continue;
				}

				// DISPLAYTITLE
				pattern = Pattern.compile("(\\{\\{DISPLAYTITLE:[^\n]*\\}\\})");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					displayTitle = matcher.group(1) + "\n";
				}

				// Catégories à garder
				String[] categoriesToKeep = {"Carte Jumbo", "Carte distribuée par les Ligues Pokémon", "Carte Stade avec des effets différents pour chaque joueur",
						"Carte Dresseur ayant un Poké-Body", "Carte Pokémon d'Holon"};
				for (String categoryToKeep : categoriesToKeep) {
					if (contents.contains("\n[[Catégorie:" + categoryToKeep + "]]")) {
						if (interwiki.equals("")) {
							interwiki += "\n\n";
						}
						interwiki += "[[Catégorie:" + categoryToKeep + "]]";
						contents = contents.replace("[[Catégorie:" + categoryToKeep + "]]", "");
					}
				}

				// Has text
				pattern = Pattern.compile("(\\{\\{#set:Has text=[^\n]*\\}\\})");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					setHasText = "\n\n" + matcher.group(1);
					contents = contents.replace(matcher.group(1), "");
				}

				// BANDEAUX DE HAUT DE PAGE
				pattern = Pattern.compile("\\{\\{Titre réel\\|([^\n]*)\\}\\}");
				matcher = pattern.matcher(contents);
				if (matcher.find())
				{
					parBandeaux += "\n| titre-réel=" + (matcher.group(1));
				}
				if (contents.contains("{{Titre réel|")) {

				}
				if (contents.contains("{{Exclusif application JCC|monde}}")) {
					parBandeaux += "\n| exclusif-application-jcc=monde";
				} else if (contents.contains("{{Exclusif application JCC}}")) {
					parBandeaux += "\n| exclusif-application-jcc=oui";
				}
				if (contents.contains("{{Édité par robot}}")) {
					parBandeaux += "\n| édité-par-robot=oui";
				}

				// INFOBOX
				pattern = Pattern.compile("\\{\\{Infobox Carte([^\\£]*?)\\}\\}\n+'''");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					parInfobox += matcher.group(1);
				}

				// Changement du nom


				// On remplace les ESPÈCES DELTA
				parInfobox = parInfobox.replaceAll("(\\| nom=[^\n]*)ESPÈCES DELTA", "$1");

				// On remplace les niveaux qui ne sont pas les NIV.X
				parInfobox = parInfobox.replaceAll(" *(NIV|LV|Niv)\\.[0-9]+", "");
				// Small vides
				parInfobox = parInfobox.replaceAll(" *<small> *</small>", "");

				// Niveau précédent
				String niveauPrecedentTotal = "";
				if (parInfobox.contains("| catégorie=Pokémon")) {
					boolean shouldHavePreviousLevel = parInfobox.contains("| stade=") && !parInfobox.contains("| stade=\n")
							&& !parInfobox.contains("| stade=0") && !parInfobox.toLowerCase().contains("| stade=base")
							&& !parInfobox.contains("| stade=-1") && !parInfobox.toLowerCase().contains("| stade=légende");
					int niveauxPrecedentsTrouves = 0;

					while (true) {
						pattern = Pattern.compile("doit être (posé|placé|joué)[e]* sur un [^\n]*?(\\{\\{[^\n]*?\\}\\})");
						if (parInfobox.toLowerCase().contains("| stade=recréé")) {
							pattern = Pattern.compile("Ne mettez cette carte sur votre([^\\{\n]*)([^\n]*\\}\\})");
						}

						matcher = pattern.matcher(contents);

						if (matcher.find() && niveauxPrecedentsTrouves < 3) {
							niveauxPrecedentsTrouves++;
							String niveauxPrecedentsTrouvesString = "";
							if (niveauxPrecedentsTrouves > 1) {
								niveauxPrecedentsTrouvesString = Integer.toString(niveauxPrecedentsTrouves);
							}

							String match = matcher.group(2);
							String beginString = "{{Requête JCC|[[Nom de carte formaté::";
							int begin = beginString.length();

							if (begin > 0 && !match.substring(0, begin).equals(beginString)) {
								if (niveauxPrecedentsTrouves == 0) {
									pageErrorLog += "\nRequête JCC non trouvée dans la phrase de niveau précédent.";
								}
								break;
							} else {
								String requete = match.substring(0, match.indexOf("}}") + 2);

								int end = match.indexOf("]]", begin);
								String niveauPrecedent = match.substring(begin, end);
								String niveauPrecedentTexte = match.substring(match.indexOf("=", end) + 1, match.indexOf("}}", end));

								// On enlève un éventuel |jeu=jcc
								niveauPrecedentTexte = niveauPrecedentTexte.replaceFirst("\\|.*", "");
								if (!niveauPrecedent.equals(niveauPrecedentTexte)) {
									niveauPrecedent += "\n| niveau-précédent" + niveauxPrecedentsTrouvesString + "-texte=" + niveauPrecedentTexte;
								}

								contents = contents.replace(requete, "");

								if (niveauxPrecedentsTrouves > 1) {
									niveauPrecedentTotal += "\n| niveau-précédent" + niveauxPrecedentsTrouvesString + "=";
								}
								niveauPrecedentTotal += niveauPrecedent;

							}
						} else {
							break;
						}
					} if (niveauxPrecedentsTrouves == 0) {
						if (shouldHavePreviousLevel) {
							// Absence de niveau précédent
							pageErrorLog += "\nErreur : niveau précédent non trouvé, il devrait y en avoir un.";
						}
					} else {
						if (niveauxPrecedentsTrouves >= 2 && verbose) {
							System.out.println("\t2+ niveaux précédents trouvés.");
						}

						String oldInfobox = parInfobox;
						parInfobox = parInfobox.replaceFirst("(\\| stade=[^\n]*)", "$1\n| niveau-précédent=" + niveauPrecedentTotal);
						if (parInfobox.equals(oldInfobox)) {
							pageErrorLog += "\nErreur : le niveau précédent n'a pas pu être ajouté.";
						} else {
							if (!shouldHavePreviousLevel) {
								pageErrorLog += "\nErreur : niveau précédent trouvé, il ne devrait pas y en avoir.";
							}
						}
					}
					parInfobox = parInfobox.replaceFirst("\n\\| niveau-précédent=([^\n]*)-V\n", "\n| niveau-précédent=$1-V\n| niveau-précédent-artwork=$1.png\n");
				}


				// Full Art
				if (contents.contains("[[Catégorie:Carte Full Art]]")) {
					parInfobox = parInfobox.replaceFirst("(\n\\| catégorie=)", "\n| full-art=oui$1");
					contents = contents.replace("[[Catégorie:Carte Full Art]]", "");
				}

				// Préfixe numéro ruban
				parInfobox = parInfobox.replaceFirst("(\\| numerocarte=)([^\n]*?)([0-9]+)", "$1$2$3\n| préfixe-numéro-ruban=$2");

				// Nom trad
				pattern = Pattern.compile("\\(([^\\)]*)en français *:[ '\\[]*([^\\)<\\]']*)");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					// Nom traduit
					parInfobox = parInfobox.replaceFirst("(\\| nom=[^\n]*)", "$1\n| nom-trad=" + matcher.group(2));
					String startMatch = matcher.group(1);
					if (!startMatch.equals("")) {
						if (!startMatch.contains(",")) {
							pageErrorLog += "\nNom transcrit non reconnu.";
						} else {
							startMatch = startMatch.substring(0, startMatch.indexOf(","));
							startMatch = startMatch.replace("''", "");
							parInfobox = parInfobox.replaceFirst("(\\| nom=[^\n]*)", "$1\n| nom-transcrit=" + startMatch);
						}
					}
				} else if (contents.contains("{{Pas de traduction française}}")) {
					// On ajoute quand même le nom de la carte en nom traduit : il est sûrement non précisé car la trad est transparente.
					parInfobox = parInfobox.replaceFirst("(\\| nom=)([^\n]*)", "$1$2\n| nom-trad=$2");

					// Plus jamais un problème
//					System.out.println("\tPas de nom traduit trouvé sur une carte sans traduction française.");
				}

				// Nom du Pokémon
				String pokemonName = "";
				if (parInfobox.contains("| catégorie=Pokémon")) {
					if (parInfobox.contains("| nomréel=")) {
						int begin = parInfobox.indexOf("| nomréel=") + "| nomréel=".length();
						int end = parInfobox.indexOf("\n", begin);
						pokemonName = parInfobox.substring(begin, end);
					} else if (parInfobox.contains("| nom=")) {
						int begin = parInfobox.indexOf("| nom=") + "| nom=".length();
						int end = parInfobox.indexOf("\n", begin);
						pokemonName = parInfobox.substring(begin, end);
					} else {
						pageErrorLog += "\nNom du Pokémon non trouvé.";
					}
				}

				// Extension
				String expansion = "";
				if (parInfobox.contains("| extension=")) {
					int begin = parInfobox.indexOf("| extension=") + "| extension=".length();
					int end = parInfobox.indexOf("\n", begin);
					expansion = parInfobox.substring(begin, end);
				} else {
					pageErrorLog += "\nExtension de la carte non trouvée.";
				}

				// Format
				pattern = Pattern.compile("(\\| format=[^\n]*\n)");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					parInfobox += "\n" + matcher.group(1);
				}

				// Forme du Pokémon
				int introBegin = contents.indexOf("\n}}\n'''", contents.indexOf("{{Infobox Carte"));
				if (introBegin == -1) {
					introBegin = contents.indexOf("\n}}\n\n'''", contents.indexOf("{{Infobox Carte")) + 1;
				}
				introBegin += 3;
				String intro = contents.substring(introBegin, contents.indexOf("\n== "));
				String form = "";

				if (contents.contains("| catégorie=Pokémon")) {
					if ((!contents.contains("| nomréel3") && intro.contains("[[" + pokemonName + "]],")) || intro.contains(pokemonName + "]] sous") || intro.contains(pokemonName + "]] dans")) {
						if (intro.toLowerCase().contains("forme")) {
							form = intro.substring(
									intro.indexOf(" ", intro.indexOf("orme", intro.indexOf(" est"))) + 1, intro.indexOf(".", intro.indexOf("orme")));
						} else if (!intro.toLowerCase().contains("obscur") && !intro.toLowerCase().contains("lumineux")
								&& !intro.toLowerCase().contains("appartenant") && !intro.toLowerCase().contains("chromatique")
								&& !intro.toLowerCase().contains("composée")) {
							pageErrorLog += "\nIntroduction complexe, forme inconnue.";
						}
					} else if (intro.contains(pokemonName + "]] ")) {
						int beginForm = intro.indexOf(pokemonName + "]] ") + (pokemonName + "]] ").length();

						form = intro.substring(beginForm, intro.indexOf(".", beginForm));
						if (form.contains("et ")) {
							form = ""; // ESCOUADES
						}
					}

					if (form.contains("chromatique")) {
						// :)
					} else if (form.contains(":") || form.contains("[[")) {
						pageErrorLog += "\nWarning: forme avec un caractère spécial : « " + form + " »";
					} else if (!form.equals("")) {

						String[] formSplit = form.split(" ");
						String[] formParticles = {"forme", "race", "cape", "temps", "mer", "type", "mode", "motif", "aspect", "coupe", "taille", "style", "plumage"};
						// On retire la particule inutile si elle existe
						String firstWordLower = formSplit[0].toLowerCase();
						for (String formParticle : formParticles) {
							if (firstWordLower.equals(formParticle)) {
								form = form.substring(form.indexOf(" ") + 1);
							}
						}

						parInfobox = parInfobox.replaceFirst("(\\| nom=[^\n]*)", "$1\n| forme=" + form);
					}
				}

				// FACULTÉS
				pattern = Pattern.compile("(== Faculté(|s) ==\n+[^\n][^£]*?)\n+== ");
				matcher = pattern.matcher(contents);

				Pattern patternInfoboxFaculte = Pattern.compile("(\\{\\{[Ii]nfobox Faculté \\(JCC\\)[^£]*\\}\\}|)");
				Matcher matcherInfoboxFaculte;
				if (matcher.find()) {
					String facultesSection = matcher.group(1);
					facultesSection += "\nEND OF SECTION";
					// Pour éviter les multiples espacements entre facultés d'une même sous-section
					facultesSection = facultesSection.replaceAll("\\}\\}\n\n+\\{\\{", "}}\n{{");

					String[][] facultesCles = {{"", "faculté"}, {"Trait Antique", "trait-antique"}, {"Objet", "objet"},
							{"Pouvoir Pokémon", "pouvoir-pokémon"}, {"Poké-Body", "poké-body"}, {"Poké-Power", "poké-power"},
							{"Cap.Spé.", "capspé"}, {"Talent", "talent"}, {"Attaque", "attaque"}
					};

					// Boucle qui tourne sur tous les types de facultés
					for (String[] faculteCles : facultesCles) {
						String faculteHeader = faculteCles[0];
						String faculteArg = faculteCles[1];

						String patternString = "\n+([^£]*?)\n*(==|END OF SECTION)";
						if (faculteHeader.equals("")) {
							patternString = "== [^\\n]*Faculté[^\\n]* ==" + patternString;
						} else {
							patternString = "=== [^\n]*" + faculteHeader + "[^\n]* ===" + patternString;
						}

						Pattern pattern2 = Pattern.compile(patternString);
						Matcher matcher2 = pattern2.matcher(facultesSection);

						if (matcher2.find()) {
							String attackSubsection = matcher2.group(1);

							matcherInfoboxFaculte = patternInfoboxFaculte.matcher(attackSubsection);
							if (matcherInfoboxFaculte.find()) {
								String infoboxFacultes = matcherInfoboxFaculte.group(1);
								String[] infoboxFacultesSplit = infoboxFacultes.split("\n");
								for (String line : infoboxFacultesSplit) {
									if (line.equals("")) {
										parFacultes += "\n";
									} else if (line.substring(0,2).equals("{{") || line.substring(0,2).equals("}}")) {
										continue;
									} else {
										String newLine = line;
										String startLine = "";
										if (line.substring(0,2).equals("| ")) {
											newLine = line.substring(2);
											startLine = "| " + faculteArg;
										}
										String parametre = newLine.replaceFirst("([^=]*)=[^\n]*", "$1");

										if (parametre.equals("faculté") || parametre.equals("format")) {
											continue;
										}

										if (!startLine.equals("")) {
											newLine = "-" + newLine;
										}
										newLine = newLine.replaceFirst("([^=]*)([0-9])(|-trad)=", "$2$1$3=");
										parFacultes += "\n" + startLine + newLine;
									}

								}
							} else {
								if (!faculteArg.equals("faculté")) {
									pageErrorLog += "\nAucune infobox " +  faculteArg + " trouvée.";
								}
							}
						}
					}

					// Multi-type pour les cartes Énergie
					if (parInfobox.contains("| catégorie=Énergie")) {
						Pattern pattern2 =  Pattern.compile("n'importe quel [^\n]* indiqué");
						Matcher matcher2 = pattern2.matcher(facultesSection);
						if (matcher2.find()) {
							parFacultes += "\n| multi-type=oui";
						}
					}
				} else {
					pageErrorLog += "\nAucune faculté trouvée.";
				}


				// DESCRIPTION
				String description = "";
				String descriptionTrad = "";
				String descriptionJeu = "";
				String descriptionForme = "";
				String descriptionRessemblance = "";
				String phraseDescription = "";
				pattern = Pattern.compile("== Description du Pokémon ==\n+(:[^£]*?)\n*== ");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					String descriptionSection = matcher.group(1);
					descriptionSection = descriptionSection.replaceAll("\n+", "\n");
					descriptionSection = descriptionSection.replace("\n''", "''");

					String[] descriptionSectionSplit = descriptionSection.split("\n");
					int numberOfLines = descriptionSectionSplit.length;

					String firstLine = descriptionSectionSplit[0];

					if (!firstLine.substring(0,3).equals(":''")) {
						pageErrorLog += "\nDescription mal formatée.";
					} else {
						description = "\n| description=" + firstLine.replaceFirst(":''([^\n]*)''", "$1");
					}

					if (numberOfLines == 1) {
						pageErrorLog += "\nUne seule ligne trouvée dans la description du Pokémon.";
					} else {
						String secondLine = descriptionSectionSplit[1];
						String gameLine = secondLine;

						if (secondLine.substring(0,3).equals(":''")) {
							descriptionTrad = "\n| description-trad=" + secondLine.replaceFirst(":''([^\n]*)''", "$1");
							if (numberOfLines == 2) {
								pageErrorLog += "\nDescription du Pokémon mal formatée.";
							} else {
								gameLine = descriptionSectionSplit[2];
							}
						}

						Pattern pattern2 = Pattern.compile("\\{\\{(j|J)eu\\|([^\n]*)\\}\\}");
						Matcher matcher2 = pattern2.matcher(gameLine);
						if (matcher2.find()) {
							// Description jeu
							descriptionJeu = "\n| description-jeu=" + matcher2.group(2);

							// Description ressemblance
							if (gameLine.contains("semblable") || gameLine.contains("exception") || gameLine.contains("ressemble")) {
								descriptionRessemblance = "\n| description-ressemblance=semblable";
							} else if (!gameLine.contains("identique") && !gameLine.contains("similaire")
									&& !gameLine.contains("est celle de") && !gameLine.contains("même")) {
								pageErrorLog += "\nFormatage inconnu de la ressemblance dans la dernière ligne du paragraphe Description du Pokémon.";
							}

							// Description forme
							if (gameLine.contains("}},")) {
								if (gameLine.toLowerCase().contains("forme")) {
									descriptionForme = gameLine.substring(
											gameLine.indexOf(" ", gameLine.indexOf("orme", gameLine.indexOf("}},"))) + 1);
								} else if (gameLine.toLowerCase().contains("pour")) {
									descriptionForme = gameLine.substring(
											gameLine.indexOf(" ", gameLine.indexOf("pour", gameLine.indexOf("}},"))) + 1);
								} else {
									if (!gameLine.contains("modification")) {
										// ", à quelques légères modifications près" sur Airmure (Neo Genesis 13)
										pageErrorLog += "\nForme de la description non détectée.";
									}
									descriptionForme = ".";
								}
								// On ajoute le nom du paramètre et on retire le point à la fin
								descriptionForme = descriptionForme.substring(0, descriptionForme.length() - 1);
								if (!descriptionForme.equals("")) {
									String[] descriptionFormeSplit = descriptionForme.split(" ");
									String[] formParticles = {"forme", "race", "cape", "temps", "mer", "type", "mode", "motif", "aspect", "coupe", "taille", "style", "plumage"};
									// On retire la particule inutile si elle existe
									String firstWordLower = descriptionFormeSplit[0].toLowerCase();
									for (String formParticle : formParticles) {
										if (firstWordLower.equals(formParticle)) {
											descriptionForme = descriptionForme.substring(descriptionForme.indexOf(" ") + 1);
										}
									}
									if (descriptionFormeSplit[0].equals(pokemonName)) {
										descriptionForme = descriptionForme.substring(descriptionForme.indexOf(" ") + 1);
									}
									descriptionForme = "\n| description-forme=" + descriptionForme;
								}

							}
						} else {
							// Cette description ne ressemble à celle d'aucun jeu
							if (gameLine.contains("chromatique")) {
								phraseDescription = "\n| phrase-description=Cette description est propre aux Pokémon [[chromatiques]].";
							} else if (!gameLine.contains("aucun") && !gameLine.contains("unique")) {
								pageErrorLog += "\nFormatage inconnu de la dernière ligne du paragraphe Description du Pokémon.";
							}
						}
					}

					parDescription += description + descriptionTrad + descriptionJeu
							+ descriptionForme + descriptionRessemblance + phraseDescription;
				}

				// ANECDOTES ET CARTES IDENTIQUES
				String erreur = ""; // ok
				String erratum = ""; // ok
				String booster = ""; // ok
				String booster2 = ""; // ok
				String booster3 = ""; // ok
				String chromatique = ""; // ok
				String typeTeracristal = ""; // ok
				String reedition = ""; // ok
				String reeditionIllustration = ""; // ok
				String illustrationReutilisee = ""; // ok

				boolean hasError = contents.contains("[[Catégorie:Carte avec erreur]]");
				boolean hasErratum = contents.contains("[[Catégorie:Carte avec erratum]]");
				boolean foundError = !hasError;
				boolean foundErratum = !hasErratum;

				if (contents.contains("[[Catégorie:Carte représentant un Pokémon chromatique]]")) {
					chromatique = "\n| chromatique=oui";
					contents = contents.replace("[[Catégorie:Carte représentant un Pokémon chromatique]]", "");
				}
				contents = contents.replace("[[Catégorie:Carte avec erreur]]", "");
				contents = contents.replace("[[Catégorie:Carte avec erratum]]", "");

				pattern = Pattern.compile("== (Anecdote|Erreur)(|s) ==\n+([^£]*?\n)\n*== ");
				matcher = pattern.matcher(contents);
				if (matcher.find()) {
					String anecdotesSection = matcher.group(3);

//					System.out.println(anecdotesSection);

					String[] anecdotesSectionSplit = anecdotesSection.split("\n");
					for (int i = 0; i < anecdotesSectionSplit.length; i++) {
						String line = anecdotesSectionSplit[i];
						if (line.equals("")) {
							continue;
						}
						boolean removeLine = false;
						String[] lineLinks = Util.getLinks(line);
						String lineLower = line.toLowerCase();


						if (hasError && lineLower.contains("erreur") || lineLower.contains("orthographe")) {
							// Erreur
							erreur = line.replaceFirst("\\** ", "\n| erreur=");
							removeLine = true;
							foundError = true;
						} else if (hasErratum && lineLower.contains("erratum")) {
							// Erratum
							erratum = line.replaceFirst("\\** ", "\n| erratum=");
							removeLine = true;
							foundErratum = true;
						} else {
							if (contents.contains("| catégorie=Pokémon")) {

								// Attaques apprises et talents possibles
								String[] decodingPhases = {"talents possibles", "capacités apprises"};
								boolean[] lineContains = {
										lineLower.contains("talent"),
										line.contains("apprend") && (lineLower.contains("capacité") || lineLower.contains("attaque"))
								};
								// TODO: tester capspé-possible
								String[][] settingNames = {{"talent", "capspé"}, {"attaque"}};
								String[][] settingNamesPlus = {{"attaque", "poké-body", "poké-power"}, {"talent", "capspé", "poké-power", "poké-body", "pouvoir-pokémon"}};
								String[][] breakWords = {{"talent", "talent signature"}, {"capacité"}};
								String[] settingParticles = {"possible", "apprise"};
								String[] settingParticlesPlus = {"talent-possible", "capacité-apprise"};

								for (int j = 0 ; j < decodingPhases.length ; j++) {
									String decodingPhase = decodingPhases[j];

									if (lineContains[j]) {
										String arg = "oui";

										if (line.contains(",") || line.substring(line.indexOf(".") + 1).contains(".")) {
											pageErrorLog += "\nPhrase complexe dans une ligne d'anecdote de " + decodingPhase + ".";
										} else if (line.contains(" pas ")) {
											arg = "non";
										}

										// Analyse des liens sur la ligne
										if (lineLinks.length > 1) {
											for (String lineLink : lineLinks) {
												// On retire les parenthèses du lien
												lineLink = lineLink.replaceAll(" \\([^\\)]*\\)", "");
												String lineLinkLower = lineLink.toLowerCase();

												if (lineLink.equals(pokemonName)) {
													continue;
												}
												boolean brek = false;
												for (String breakWord : breakWords[j]) {
													if (lineLinkLower.equals(breakWord)) {
														brek = true;
														break;
													}
												}
												int whereEndLinks = lineLower.indexOf("capacité");
												if (decodingPhase.equals("talents possibles")) {
													whereEndLinks = lineLower.indexOf("talent");
												} else if (!lineLower.contains("capacité")) {
													whereEndLinks = lineLower.indexOf("attaque");
												}
												if (decodingPhase.equals("capacités apprises") && lineLower.indexOf(lineLinkLower) > whereEndLinks) {
													brek = true;
												}
												if (brek) { break; }

												boolean found = false;
												String[][] settingAlls = {settingNames[j], settingNamesPlus[j]};
												String[] settingParticlesAll = {settingParticles[j], settingParticlesPlus[j]};
												for (int k = 0 ; k < decodingPhases.length; k++) {

													String[] settingAll = settingAlls[k];
													String settingParticle = settingParticlesAll[k];

													for (String settingName : settingAll) {
														// On regarde s'il y a un paramètre de la forme "| attaque-nom=lien trouvé"
														Pattern pattern2 = Pattern.compile("\\| (" + settingName + ")([0-9]*)-nom(|-trad)=(" + lineLinkLower + ")(|-gx| gx| g-max| \\?)(|<[^\n]*)\n");
														Matcher matcher2 = pattern2.matcher(parFacultes.toLowerCase());
														String currentSetting = "";
														String currentRealName = "";

														if (matcher2.find()) {
															currentSetting = matcher2.group(1) + matcher2.group(2);
															String currentAttackName = matcher2.group(4);
															String currentAttackNameInText = currentAttackName;
															Pattern pattern3 = Pattern.compile("\\| (" + settingName + ")" + matcher2.group(2) + "-nom" + matcher2.group(3) + "=([^\n]*?)(|-GX| GX| G-Max| \\?)(|<[^\n]*)\n");

															Matcher matcher3 = pattern3.matcher(parFacultes);

															// On prend le nom tel qu'il est écrit sur la carte plutôt que de regarder une version en lowercase
															if (matcher3.find()) {
																currentAttackNameInText = matcher3.group(2);
															}

															if (!currentAttackNameInText.equals(lineLink)) {
																currentRealName = "\n| " + currentSetting + "-nomréel=" + lineLink;
															}
														} else {

															// On regarde aussi la partie texte du lien au cas où
															int lineLinkIndex = lineLower.indexOf(lineLinkLower);
															if (line.indexOf("|", lineLinkIndex) > 0 && line.indexOf("|", lineLinkIndex) < line.indexOf("]]", lineLinkIndex)) {
																String lineLinkVisual = line.substring(line.indexOf("|", lineLinkIndex) + 1, line.indexOf("]]", lineLinkIndex));

																pattern2 = Pattern.compile("\\| (" + settingName + ")([0-9]*)-nom(|-trad)=(" + lineLinkVisual.toLowerCase() + ")(|-gx| gx| g-max| \\?)(|<[^\\n]*)\n");
																matcher2 = pattern2.matcher(parFacultes.toLowerCase());

																if (matcher2.find()) {
																	currentSetting = matcher2.group(1) + matcher2.group(2);
																	String currentAttackName = matcher2.group(4);
																	String currentAttackNameInText = currentAttackName;
																	Pattern pattern3 = Pattern.compile("\\| (" + settingName + ")" + matcher2.group(2) + "-nom" + matcher2.group(3) + "=([^\n]*?)(|-GX| GX| G-Max| \\?)(|<[^\n]*)\n");

																	Matcher matcher3 = pattern3.matcher(parFacultes);

																	// On prend le nom tel qu'il est écrit sur la carte plutôt que de regarder une version en lowercase
																	if (matcher3.find()) {
																		currentAttackNameInText = matcher3.group(2);
																	}

																	if (!currentAttackNameInText.equals(lineLinkVisual)) {
																		currentRealName = "\n| " + currentSetting + "-nomréel=" + lineLinkVisual;
																	}
																}
															}
														}

														if (!currentSetting.equals("")) {
															String a = "([^£]+\\| " + currentSetting + "-[^\n]*)([^£]*)";
															String b = "$1\n| " + currentSetting + "-" + settingParticle + "=" + arg + currentRealName + "$2";

															parFacultes = parFacultes.replaceFirst(a, b);
															found = true;

															if (currentSetting.contains("4") ||
																	(currentSetting.contains("2") && !currentSetting.contains("attaque"))) {
																pageErrorLog += "\nUn paramètre de " + decodingPhase + " va manquer.";
															}
														}
													}
												}
												if (!found) {
													pageErrorLog += "\n" + lineLink;
													pageErrorLog += "\nLes " + decodingPhase + " ne correspondent pas à la carte.";
												}
											}
											removeLine = true;
										}
									}
								}
							}

							// Boosters
							if (lineLower.contains("être obtenue dans le [[booster (jcc)|booster]]") ||
									lineLower.contains("être obtenue dans les [[booster (jcc)|boosters]]") ||
									lineLower.contains("être obtenue dans les [[booster (jcc)|booster]]s")) {
								String workingLine = line.replace("ooster]]s", "oosters]]");
								workingLine = workingLine.substring(workingLine.indexOf("]]") + 3, workingLine.indexOf(" de "));
								workingLine = workingLine.replace("]]", "");
								workingLine = workingLine.replace("[[", "");

								if (line.contains("Promo")) {
									booster = "\n| booster=" + workingLine + "\n| booster-promo=oui";
								} else if (workingLine.contains(",")) {
									booster = "\n| booster=" + workingLine.substring(0, workingLine.indexOf(","));
									booster2 = "\n| booster2=" + workingLine.substring(workingLine.indexOf(",") + 2, workingLine.indexOf(" et "));
									booster3 = "\n| booster3=" + workingLine.substring(workingLine.indexOf(" et ") + 4);
								} else if (workingLine.contains(" et ")) {
									booster = "\n| booster=" + workingLine.substring(0, workingLine.indexOf(" et "));
									booster2 = "\n| booster2=" + workingLine.substring(workingLine.indexOf(" et ") + 4);
								} else {
									booster = "\n| booster=" + workingLine;
								}
								removeLine = true;
							}

							// Chromatique
							if (line.contains("est [[chromatique]].")) {
								removeLine = true;
							}

							// Type Téracristal
							if (line.contains("téracristallisé")) {
								int lineLinksLength = lineLinks.length;
								int firstLinkIndex = 0;
								// On évite le premier lien
								if (lineLower.contains("[[téracristallisation")) {
									lineLinksLength--;
									firstLinkIndex++;
								}
								if (lineLinksLength > 1) {
									pageErrorLog += "\nErreur : plusieurs liens sur une ligne Téracristal.";
								} else if (lineLinksLength == 0) {
									pageErrorLog += "\nErreur : pas de lien sur une ligne Téracristal.";
								} else {
									typeTeracristal = lineLinks[firstLinkIndex];
									//								if (!typeTeracristal.contains("type")) {
									//									pageErrorLog += "\nLien suspect en tant que type Téracristal.";
									//								}
									typeTeracristal = typeTeracristal.replace(" (type)", "");
									typeTeracristal = "\n| type-téracristal=" + typeTeracristal;
								}
								removeLine = true;
							}

							// Illustration réutilisée
							if (line.contains("L'illustration de cette carte réutilise")) {
								if (lineLinks.length >= 1) {
									illustrationReutilisee = "\n| illustration-réutilisée=" + lineLinks[0];
								} else {
									pageErrorLog += "\nErreur : carte avec illustration réutilisée sans lien.";
								}
								removeLine = true;
							}

							// Réédition
							if (line.contains("réédition]]")) {
								if (lineLinks.length >= 1) {
									reedition = "\n| réédition=" + lineLinks[0];
								} else {
									pageErrorLog += "\nErreur : carte avec réédition sans lien.";
								}
								if (line.contains("illustration différente") || line.contains("artwork différent")) {
									reeditionIllustration = "\n| réédition-illustration=différente";
								}
								removeLine = true;
							}

							// Rééditée (automatiquement géré)
							if (line.contains("rééditée]]")) {
								removeLine = true;
							}

							// Cartes identiques
							if (line.contains("Cette carte existe aussi") || line.contains("en version")) {
								int j = 1;
								for (String lineLink : lineLinks) {
									String lineLinkLower = lineLink.toLowerCase();
									if (!lineLinkLower.contains("(")
											|| expansion.toLowerCase().contains(lineLinkLower)) {
										continue;
									} else {
										String iString = "";
										if (j > 1) {
											iString = Integer.toString(j);
										}
										parCartesIdentiques += "\n| carte-identique" + iString + "=" + lineLink;
										j++;
									}
								}
								if (j > 1) {
									removeLine = true;
								}
							}
						}

						// Suppression de la ligne si la ligne d'anecdote a été utilisée à un meilleur endroit
						if (removeLine) {
							anecdotesSection = anecdotesSection.replace(line + "\n", "");
							// S'il y a des points de précision qui restent sur des lignes retirées, on les décale d'un rang
							for (int j = i + 1; j < anecdotesSectionSplit.length; j++) {
								String nextLine = anecdotesSectionSplit[j];
								if (nextLine.length() > 2 && nextLine.substring(0,2).equals("**")) {
									anecdotesSection = anecdotesSection.replace(nextLine, nextLine.substring(1));
									pageErrorLog += "\nWarning: changement de niveau d'anecdotes";
								} else {
									break;
								}
							}
						}
					}


					String[] anecdotesItems = {erreur, erratum, booster, booster2, booster3,
							chromatique, typeTeracristal, reedition, reeditionIllustration,
							illustrationReutilisee
					};
					for (String anecdotesItem : anecdotesItems) {
						parAnecdotes += anecdotesItem;
					}
					if (anecdotesSection.contains("*")) {
						parAnecdotes += "\n| anecdotes=\n" + anecdotesSection;
					}
				}

				if (!foundError) {
					pageErrorLog +="\nErreur non trouvée.";
				}
				if (!foundErratum) {
					pageErrorLog +="\nErratum non trouvé.";
				}
				if (contents.contains("\n{|")) {
					pageErrorLog += "\nTableau trouvé.";
				}
//				System.out.println("-----");

				// AUTRES
				if (contents.contains("<ref")) {
					parAutres += "\n| références=oui";
				}

				// INTERWIKI
				pattern = Pattern.compile("(\n+\\[\\[[a-z][a-z]\\:[^\n]*\\]\\])");
				matcher = pattern.matcher(contents);
				while (matcher.find()) {
					interwiki += matcher.group(1);
				}

				if (contents.contains("[[Catégorie:]]")) {
					pageErrorLog += "\nCatégories restantes oubliées.";
				}

				// Erreurs finales
				if (convertedContents.contains("| catégorie=Pokémon") && convertedContents.contains("| faculté-nom")) {
					pageErrorLog += "\nSous-section manquante.";
				} else if (convertedContents.contains("| faculté2")) {
					pageErrorLog += "\nfaculté2 trouvée.";
				}
				if (contents.contains("\n[[Catégorie:")) {
					pageErrorLog += "\nCatégorie clandestine trouvée.";
				}

				// MISE EN FORME FINALE
				convertedContents = displayTitle
						+ "{{Article carte\n"
						+ parBandeaux + "\n\n"
						+ parInfobox + "\n\n"
						+ parFacultes + "\n\n"
						+ parDescription + "\n\n"
						+ parAnecdotes + "\n\n"
						+ parCartesIdentiques + "\n\n"
						+ parAutres + "\n}}\n" + setHasText + interwiki;

				for (int i = 0 ; i < 3 ; i++) {
					convertedContents = convertedContents.replaceAll("<!--[^\n]*-->\n*(<!--|\n\\}\\})", "$1");
				}

				// Suppression des paramètres vides
				String tmpConvertedContents = convertedContents;
				pattern = Pattern.compile("\\| ([^\n]*)=\n(.)");
				matcher = pattern.matcher(tmpConvertedContents);
				while (matcher.find()) {
					if (matcher.group(1).equals("anecdotes")) {
						if (!matcher.group(2).equals("*")) {
							convertedContents = convertedContents.replace("| anecdotes=\n", "");
						}
					} else {
						convertedContents = convertedContents.replace("| " + matcher.group(1) + "=\n", "");
					}
				}
				convertedContents = convertedContents.replaceAll("\n\n+", "\n\n");
				convertedContents = convertedContents.replaceFirst("\n+\\}\\}", "\n}}");
				convertedContents = convertedContents.replaceFirst("\n*\\z", "");



				if (pageCount % 100 == 0) {
					System.out.println(Integer.toString(pageCount) + " • " + title);
				}

				howMany--;
				pageCount++;

				if (!pageErrorLog.equals("")) {
					convertedContents = "{{Édité par robot}}\n" + convertedContents;

					pageErrorLog = pageErrorLog.substring(1);
					pageErrorLog = pageErrorLog.replace("\n", " // ");
					errorLog += "\n" + title + " || " + pageErrorLog;
					errorCount++;

					if (verbose) {
						System.err.println(pageErrorLog);
					}
				}

				if (post) {
					page.setContent(convertedContents, "Conversion en modèle Article carte");
					if (verbose) {
						System.out.println(title + " ok");
					}

				}

				page = pageCollection.getNextPage();

				if (howMany == 1) {
					System.out.println(convertedContents);
				} else if (howMany == 0) {
					break;
				}
			}
		}

		FileOutputStream outputStream = new FileOutputStream(outputName);
		byte[] strToBytes = errorLog.getBytes();
		outputStream.write(strToBytes);

		outputStream.close();

		System.out.println("Error count: " + Integer.toString(errorCount) + "/" + Integer.toString(pageCount));
	}
}
