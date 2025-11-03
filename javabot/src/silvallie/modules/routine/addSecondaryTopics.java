package silvallie.modules.routine;

import silvallie.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addSecondaryTopics {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();

		String startingFrom = null;
		boolean generateCompleteTopicList = true;
		boolean justOne = true;

		String[] avoidList = {
				"Barpau (Épée et Bouclier Ténèbres Embrasées 038)",
				"Baudrive (Noir & Blanc Explosion Plasma 34)",
				"Capumain (Noir & Blanc Dragons Exaltés 99)",
				"Copieuse (Épée et Bouclier Évolution Céleste 143)",
				"Copieuse (Épée et Bouclier Évolution Céleste 200)",
				"Copieuse (Épée et Bouclier Évolution Céleste 222)",
				"Copieuse (EX Île des Dragons 73)",
				"Copieuse (Expedition 138)",
				"Copieuse (HeartGold & SoulSilver 90)",
				"Copieuse (HS Kit du Dresseur Raichu 21)",
				"Copieuse (L'Appel des Légendes 77)",
				"Copieuse (Soleil et Lune Tempête Céleste 127)",
				"Copieuse (Soleil et Lune Tempête Céleste 163)",
				"Copycat (EX Team Rocket Returns 83)",
				"Dedenne (Épée et Bouclier Stars Étincelantes TG07)",
				"Démolosse (Noir & Blanc Explosion Plasma 56)",
				"Mackogneur (Noir & Blanc Explosion Plasma 49)",
				"Magicarpe (Soleil et Lune Invasion Carmin 17)",
				"Mauvaises actions des Team Rocket (Neo Destiny 103)",
				"Rosélia (Noir & Blanc Dragons Exaltés 13)",
				"Pharamp (Noir & Blanc Dragons Exaltés 40)",
				"Dynavolt (Noir & Blanc Dragons Exaltés 42)",
				"Élecsprint (Noir & Blanc Dragons Exaltés 43)",
				"Élecsprint (Noir & Blanc Dragons Exaltés 44)",
				"Gamblast (Écarlate et Violet 050)",
				"Golemastoc (Noir & Blanc Explosion Plasma 46)",
				"Pokémon Center (Promo Wizards 40)",
				"Roseille (Écarlate et Violet Mascarade Crépusculaire 145)",
				"Roseille (Écarlate et Violet Évolutions Prismatiques 103)",
				"Rosélia (Noir & Blanc Dragons Exaltés 13)",
				"Sapereau (XY Vigueur Spectrale 87)",
				"Tarinor (Écarlate et Violet Mascarade Crépusculaire 101)",
				"Tranchodon (Noir & Blanc Explosion Plasma 69)",
				"Tylton (Noir & Blanc Dragons Exaltés 104)",
				"コイキングごっこピカチュウ (XYプロモカード 150)",
				"ギャラドスごっこピカチュウ (XYプロモカード 151)",
				"スカル団ごっこピカチュウ (サン＆ムーンプロモカード 013)",
				"トウホクのピカチュウ (サン＆ムーンプロモカード 088)",
				"メガトウキョーのピカチュウ (XYプロモカード 098)",
				"メガトウキョーのピカチュウ (XYプロモカード 204)",
				"ボスごっこピカチュウ スカル団 (サン＆ムーンプロモカード 197)",
				"ポンチョを着たピカチュウ (XYプロモカード 203)",
				"ポンチョを着たピカチュウ (XYプロモカード 207)",
				"ポンチョを着たピカチュウ (XYプロモカード 208)",
				"ポンチョを着たピカチュウ (XYプロモカード 230)",
				"ポンチョを着たピカチュウ (XYプロモカード 231)",
				"ポンチョを着たピカチュウ (XYプロモカード 274)",
				"ポンチョを着たピカチュウ (XYプロモカード 275)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 137)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 138)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 139)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 140)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 141)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 142)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 143)",
				"ポンチョを着たイーブイ (サン＆ムーンプロモカード 144)",
				"ポンチョを着たピカチュウ (サン＆ムーンプロモカード 037)",
				"ポンチョを着たピカチュウ (サン＆ムーンプロモカード 038)",
				"ピカチュウ (XYプロモカード 175)",
				"ヨコハマのピカチュウ (サン＆ムーンプロモカード 280)",
				"ヨコハマのピカチュウ (サン＆ムーンプロモカード 281)",
				"ヨコハマのピカチュウ (サン＆ムーンプロモカード 283)",
				"団員ごっこピカチュウ (サン＆ムーンプロモカード 014)"
		};

		run(startingFrom, avoidList, generateCompleteTopicList, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Adds secondary topics on card pages, depending on the Trivia section on the page
	 * @param startingFrom The name of the first page. Set to null to begin from start
	 * @param avoidList A list of pages to avoid editing, when the trivia formulation does not match this program's recognition
	 * @param generateCompleteTopicList Set to true to generate a topic list that takes into account unedited pages
	 * @param justOne Set to true to stop after the first page edit. Please use this on the first run to avoid accidents
	 */
	private static void run(String startingFrom, String[] avoidList, boolean generateCompleteTopicList, boolean justOne) {
		String[] categoryNames = {"Carte du JCCP", "Carte du JCC"};
		String[] keys = {"est visible", "sont visibles", "appara", "est représenté", "sont représenté"};
		List<String> completeTopicList = new ArrayList<String>();


		// Initialising topics for avoided cards
		for (String avoidTitle : avoidList) {
			Page avoidPage = new Page(avoidTitle);
			String avoidContents = avoidPage.getContent();
			int i = 1;
			String iString = "";

			while (true) {
				String replaceResult = avoidContents.replaceAll("[^£]*\\| sujetsecondaire" + iString + "=([^\n]*)[^£]*", "$1");
				if (replaceResult.equals(avoidContents)) {
					break;
				} else if (generateCompleteTopicList) {
					if (!completeTopicList.contains(replaceResult)) {
						completeTopicList.add(replaceResult);
					}
				}

				i = i + 1;
				iString = Integer.toString(i);
			}
		}

//		System.out.println(completeTopicList);

		// To know how many parameters to put in the template
		int topicRecord = 30;

		for (String categoryName : categoryNames) {

			int[] nameSpaces = new int[]{API.NS_MAIN};
			PageCollection pageCollection = new PageCollection(
					nameSpaces,
					API.FILTER_ALL,
					categoryName
			);

			//		justOne = true;
			Page page = pageCollection.getNextPage();
			String title = page.getTitle();

//			startingFrom = "Kapoera (XY Poings Furieux 49)";

			if (startingFrom != null) {
				while (!startingFrom.equals(title)) {
					page = pageCollection.getNextPage();
					title = page.getTitle();
//					System.out.println(title);
				}
			}

			while (page != null) {
				title = page.getTitle();
				boolean avoid = false;
				for (String avoidPage : avoidList) {
					if (title.equals(avoidPage)) {
						avoid = true;
						break;
					}
				}
				if (avoid) {
					page = pageCollection.getNextPage();
					continue;
				}

				System.out.println(title);

				String contents = page.getContent();
				String[] contentsSplit = contents.split("\n");

				int topicNumber = 1;
				String topicsString = "";

				for (String line : contentsSplit) {
					String keyFound = null;

					// Removing lines with forbidden expressions
					for (String key : keys) {
						if (line.contains(key) && !line.contains("immersion")
								&& !line.contains(" que dans ")) {
							keyFound = key;
							break;
						}
					}

					if (keyFound != null) {
						int endPosition = line.indexOf(keyFound);
						String linkLine = line.substring(0, endPosition);
						List<String> foundTopics = new ArrayList<String>();

						// zzzzz
						Pattern pattern = Pattern.compile("\\[\\[([^\\]\\|]*)(\\|[^\\]]*|)\\]\\]");
						Matcher matcher = pattern.matcher(linkLine);
						while (matcher.find()) {
							String topic = matcher.group();
							topic = topic.replaceAll("\\[\\[([^\\]\\|]*)(\\|[^\\]]*|)\\]\\]", "$1");
							topic = topic.substring(0, 1).toUpperCase() + topic.substring(1);
							//				        System.out.println(topic);
							if (!foundTopics.contains(topic)) {
								foundTopics.add(topic);
							}

							//				        System.out.println(topic);
							// Lorsque "Staross d'Ondine" est un sujet, on ajoute "Staross" et "Staross d'Ondine"
							String[] particles = {" de ", " d'"};
							for (String particle : particles) {
								String[] topicSplit = topic.split(particle);
								String[] regions = {"Alola", "Galar", "Hisui", "Paldea"};
								if (topicSplit.length > 1) {
									boolean isRegion = false;
									for (String region : regions) {
										if (topicSplit[1].equals(region)) {
											isRegion = true;
											break;
										}
									}
									if (!isRegion) {
										for (String pokemon : PokeData.pokemon) {
											if (topicSplit[0].equals(pokemon)) {
												if (!foundTopics.contains(topicSplit[0])) {
													foundTopics.add(topicSplit[0]);
												}
												break;
											}
										}
									}
								}
							}

							if (topic.equals("Miaouss (Team Rocket)")) {
								if (!foundTopics.contains("Miaouss")) {
									foundTopics.add("Miaouss");
								}
							}
							if (topic.equals("Terapagos/Pokémon, la série")) {
								if (!foundTopics.contains("Terapagos")) {
									foundTopics.add("Terapagos");
								}
							}
							if (topic.equals("Pichu Troizépi")) {
								if (!foundTopics.contains("Pichu")) {
									foundTopics.add("Pichu");
								}
							}
							if (topic.equals("Capitaine Pikachu") || topic.toLowerCase().equals("pikachu surfeur") ||
									topic.toLowerCase().equals("pikachu volant")) {
								if (!foundTopics.contains("Pikachu")) {
									foundTopics.add("Pikachu");
								}
							}
							// Pour les éléments de Pokémon, la série
							if (topic.contains("/")) {
								String mainTopic = topic.replaceAll("/.*", "");
								if (!foundTopics.contains(mainTopic)) {
									foundTopics.add(mainTopic);
								}
							}
						}

						pattern = Pattern.compile("\\{\\{ps\\|[^\\}]*\\}\\}");
						matcher = pattern.matcher(linkLine);
						while (matcher.find()) {
							String topic = matcher.group();
							topic = topic.replace("{{ps|", "").replace("}}", "");

//					        System.out.println(topic);
							if (topic.equals("Pierre")) {
								topic += " (Kanto)";
							} else if (topic.equals("Flora")) {
								topic += " (Hoenn)";
							} else if (topic.equals("Aurore")) {
								topic += " (Hoenn)";
							} else if (topic.equals("Bianca") || topic.equals("Iris")) {
								topic += " (Unys)";
							}
							String bonusTopic = topic;
							topic += "/Pokémon, la série";
							if (topic.equals("Max/Pokémon, la série")) {
								topic = "Max (frère de Flora)";
								bonusTopic = null;
							}

							if (!foundTopics.contains(topic)) {
								foundTopics.add(topic);
							}
							// Si {{ps|Ondine}} est ajoutée, on ajoute aussi Ondine
							if (bonusTopic != null && !foundTopics.contains(bonusTopic)) {
								foundTopics.add(bonusTopic);
							}

//					        System.out.println(topic);
						}

//					    System.out.println(foundTopics);

						for (var topic : foundTopics) {
							String iString = "";

							//						System.out.println(topic);

							if (topic.toLowerCase().contains("wp:")) {
								continue;
							}

							// Gestion des redirections
							Page topicPage = new Page(topic);
							String topicContents = topicPage.getContent();
							if (topicContents.contains("#REDIRECT")) {
								topic = topicContents.replaceAll("#REDIRECT[^\n]*\\[\\[([^\n]*)\\]\\][^£]*", "$1");
							}

							if (topic.contains("#")) {
								topic = topic.replaceAll("#.*", "");
								if (foundTopics.contains(topic)) {
									continue;
								}
							}

							// Ligue Pokémon d'Unys
							if (topicNumber == 2 && (topic.equals("Unys") || topic.equals("Kalos"))) {
								continue;
							}
							if (topic.equals("Forme") || topic.equals("Badge")
									|| topic.equals("Pokémon chromatique") || topic.equals("Fossile (objet)")) {
								continue;
							}

							// On vérifie que le sujet est bien secondaire
							pattern = Pattern.compile("\\| (nom|nomréel|sujet|sujetnommé)[0-9]*=" + topic.replace("(", "\\(").replace(")", "\\)") + "\n");
							matcher = pattern.matcher(contents);

							if (!matcher.find()) {
								if (topicNumber != 1) {
									iString = Integer.toString(topicNumber);
								}
								topicsString = topicsString + "| sujetsecondaire" + iString + "=" + topic + "\n";
								topicNumber = topicNumber + 1;

								// Ajout à la liste complète des sujets secondaires
								if (generateCompleteTopicList && !completeTopicList.contains(topic)) {
									completeTopicList.add(topic);
								}
							}
						}
					}
				}

				// Ajout des sujets nommés à la liste des sujets secondaires
				Pattern pattern = Pattern.compile("\\| sujetnommé=([^\n]*)");
				Matcher matcher = pattern.matcher(contents);
				if (matcher.find()) {
					String namedTopic = matcher.group();
					namedTopic = namedTopic.replace("| sujetnommé=", "");
					System.out.println(namedTopic);

					// Ajout du sujet nommé à la liste des sujets secondaires
					if (generateCompleteTopicList && !completeTopicList.contains(namedTopic)) {
						completeTopicList.add(namedTopic);
					}
				}

				topicNumber = topicNumber - 1;

				// Ajout des sujets uniquement s'il y en a
				if (topicNumber > 0 || contents.contains("sujetsecondaire")) {
					// On vérifie que la méthode de modification est valide
					if (!contents.contains("| catégorie")) {
						System.err.println("Pas de catégorie sur " + title);
					}
					String modificationType = "Ajout";
					if (contents.contains("sujetsecondaire")) {
						if (topicNumber > 0) {
							modificationType = "Modification";
						} else {
							modificationType = "Suppression";
						}
					}

					// Création de la description
					String description = topicsString.replaceAll("\\| sujetsecondaire[0-9]*=", "]], [[").replace("\n", "");
					if (topicNumber != 0) {
						description = description.substring(6);
					}

					if (topicNumber == 1) {
						description = modificationType + " du sujet secondaire [[" + description + "]]";
					} else {
						description = modificationType + " des sujets secondaires [[" + description + "]]";
					}
					description = description.replace("[[]]", "");

					String newContents = contents.replaceAll("\n\\| sujetsecondaire[^\n]*", "");
					newContents = newContents.replace("| catégorie", topicsString + "| catégorie");

					if (!newContents.equals(contents)) {
						page.setContent(newContents, description);

						// Ajout à la liste complète des sujets uniquement si la carte a changé de sujets
						if (!generateCompleteTopicList) {
							String descriptionCopy = description;
							while (descriptionCopy.contains("[[")) {
								String topic = descriptionCopy.replaceFirst("([^£]*)\\[\\[([^\\]]*)\\]\\]([^£]*)", "$2");
								descriptionCopy = descriptionCopy.replaceFirst("([^£]*)\\[\\[([^\\]]*)\\]\\]([^£]*)", "$1$3");

								if (!completeTopicList.contains(topic)) {
									completeTopicList.add(topic);
								}
							}
						}

						System.out.println(title + " : " + description);

						if (topicNumber - 1 > topicRecord) {
							topicRecord = topicNumber - 1;
							System.out.println("\tNEW RECORD: " + Integer.toString(topicRecord));
						}
					}

					if (justOne) {
						break;
					}
				}

				page = pageCollection.getNextPage();
			}
		}

		// Filtrage des Pokémon
		List<String> filteredCompleteTopicList = new ArrayList<String>();
		for (String topic : completeTopicList) {
			Page topicPage = new Page(topic);
			String contents = topicPage.getContent();

			if (!contents.contains("{{#invoke:Infobox Pokémon")) {
				filteredCompleteTopicList.add(topic);
			}
		}
		String[] titles = filteredCompleteTopicList.toArray(new String[0]);

		System.out.println(filteredCompleteTopicList);

		addSecondaryTopicsSections((String[]) titles, justOne);
	}


	/**
	 * Adds "Secondary topic" sections on pages given in a list if the section is not already there
	 * @param titles A list of pages to add topics
	 * @param justOne Set to true to stop after the first page edit. Please use this on the first run to avoid accidents
	 */
	private static void addSecondaryTopicsSections(String[] titles, boolean justOne) {
		// Terms with custom secondary topics sections, not to be touched
		String[] exclusionList = new String[]{"Ancient Ruins",
				"Éventail Houleux", "Rouleau Tourbillons Mille Poings", "Rouleau Acerbe Poing Final", "Urne de Vitalité", "Corne Résonnante", "Lanterne Accueillante", "Échange Croisé", "Récepteur Croisé", "Pastille Puissance"
		};

		for (String title : titles) {
			boolean isExcluded = false;
			for (String exclusionItem : exclusionList) {
				if (title.contains(exclusionItem)) {
					isExcluded = true;
					break;
				}
			}
			if (isExcluded) {
				continue;
			}


//			System.out.println(title);

			Page page = new Page(title);
			String contents = page.getContent();

			if (contents.contains("== Apparitions sur d'autres cartes ==")) {
				continue;
			}

			contents = contents.replace("<dfn>", "'''").replace("</dfn>", "'''");

			// Finding the way to formulate the title in a sentence
			String intro = title;
			String introRegularCase = intro;
			if (contents.contains("'''")) {
				String introContents = contents.substring(0, contents.indexOf("== ")).replace("[[", "").replace("]]", "");
				intro = introContents.replaceFirst("[^£]*\n+([^\\*']*'?'''[^']*'?[^']*'''),? [^£]*", "$1");
//				System.out.println(intro);

				if (intro.length() > 60) {
					intro = introContents.replaceFirst("([^\\*']*'?'''[^']*'?[^']*'''),? [^£]*", "$1");
				}
				if (intro.length() > 60) {
					System.err.println("Mauvaise détection de l'intro sur " + title);
					intro = title;
				} else {
					introRegularCase = intro.substring(0, 1).toLowerCase() + intro.substring(1);
					intro = intro.replace("'''", "");
					introRegularCase = introRegularCase.replace("'''", "");
				}
			}

			// Declarations
			String jccSectionString = "== Dans le [[Jeu de Cartes à Collectionner]] ==";
			String secondaryTopicSubsection = "=== Apparitions sur d'autres cartes ===\n" +
					intro + " apparaît sur les cartes suivantes :\n\n" +
					"{{Liste des cartes d'un sujet secondaire}}";
			if (intro.contains("Les ")) {
				secondaryTopicSubsection = secondaryTopicSubsection.replace("apparaît", "apparaissent");
			}
			String secondaryTopicSubsectionWithOtherSubsections = secondaryTopicSubsection.replace("sur les cartes", "également sur les cartes");
			String newContents = contents;

			if (contents.contains(jccSectionString)) {

				// Ajout de la première sous-section si elle n'est pas déjà présente
				if (!contents.contains("=== Cartes représentant")) {
					newContents = newContents.replace(jccSectionString,
							jccSectionString + "\n=== Cartes représentant " + introRegularCase + " ===");
				}

				int jccSectionPosition = newContents.indexOf(jccSectionString);
				int nextSectionPosition = newContents.indexOf("\n== ", jccSectionPosition);

				if (nextSectionPosition == -1) {
					int lastCardTemplatePosition = newContents.lastIndexOf("{{Liste des cartes");
					int endOfLastCardTemplatePosition = newContents.indexOf("}}", lastCardTemplatePosition);

					String lastCardTemplate = newContents.substring(lastCardTemplatePosition, endOfLastCardTemplatePosition + 2);
					newContents = newContents.replace(lastCardTemplate, lastCardTemplate + "\n\n" + secondaryTopicSubsectionWithOtherSubsections);
				} else {
					int endOfNextSectionPosition = newContents.indexOf(" ==\n", nextSectionPosition);
					String nextSection = newContents.substring(nextSectionPosition, endOfNextSectionPosition + 4);

					newContents = newContents.replace(nextSection, "\n" + secondaryTopicSubsectionWithOtherSubsections + "\n" + nextSection);
				}

			} else {
				String[] referenceSections = {"Étymologie", "Anecdote", "Voir aussi", "Référence", "Dans d'autres langues", "Noms dans d'autres langues", "Nom dans d'autres langues"};
				int firstFoundIndex = newContents.length();
				String referenceFoundSection = "";

				for (String referenceSection : referenceSections) {
					int currentIndex = newContents.indexOf("== " + referenceSection);
					if (currentIndex != -1 && firstFoundIndex >= currentIndex) {
						firstFoundIndex = currentIndex;
						referenceFoundSection = referenceSection;
					}
				}

				if (!referenceFoundSection.equals("")) {
					newContents = newContents.replace("== " + referenceFoundSection,
							jccSectionString + "\n" + secondaryTopicSubsection + "\n\n== " + referenceFoundSection);
				} else {
					newContents = newContents.replaceFirst("(\n\\{\\{[^\n]*\\}\\}[^=]*\\[\\[[a-zA-Zé]+:[^\n]*\\]\\])",
							"\n" + jccSectionString + "\n" + secondaryTopicSubsection + "\n$1");
					if (newContents.equals(contents)) {
						newContents = newContents.replaceFirst("(\\[\\[[a-zCé]+:[^\n]*\\]\\])", // interwiki or Catégorie
								"\n" + jccSectionString + "\n" + secondaryTopicSubsection + "\n$1");
						if (newContents.equals(contents)) {
							System.err.println("Could not add subsection to " + title);
						}
					}
				}
			}

//			System.out.println(newContents);
			page.setContent(newContents, "/* Dans le Jeu de Cartes à Collectionner */ Ajout des cartes avec " + introRegularCase + " en tant que sujet secondaire");
			System.out.println(title + " ok");

			if (justOne) {
				break;
			}
		}
	}
}
