package com.grotteazuree;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	/**
	 * Return the number of occurences of a word in a string
	 * @param str the  complete strring to inspect at
	 * @param word the word we want to count
	 * @return the number of occurences
	 */
	public static int count(String str, String word) {
		if(str==null || word==null) {
			return 0;
		}
		int counter = 0;
		Pattern pattern = Pattern.compile(word, Pattern.MULTILINE);
		Matcher matcher = null;

		matcher = pattern.matcher(str);
		while(matcher.find()) {
			counter++;
		}
		return counter;
	}
	
	public static String de(String str) {
		String name = str.toLowerCase();
		String[] vowels = {"a", "à", "e", "é", "è", "ê", "ë", "i", "î", "ï", "o", "ô", "ö", "u", "û", "ü", "y"};
		String[] de = {"hachécateur", "hariyama", "haydaim", "heatran", "héricendre", "ho-oh", "hoopa", "hoothoot", "hotte-de-fer", "hurle-queue", "ouistempo", "ouisticram", "yanma", "yanmega", "yuyu"};
		String[] d = {"hastacuda", "hélédelle", "héliatronc", "hélionceau", "herbizarre", "hexadron", "hexagel", "hippodocus", "hippopotas", "hydragla", "hydragon", "hypnomade", "hypocéan", "hyporoi", "hypotrempe", "ymphect", "yveltal"};
		
		for (String i : de) {
			if (name.equals(i)) {
				return "de ";
			}
		}
		for (String j : d) {
			if (name.equals(j)) {
				return "d'";
			}
		}
		
		String vowel_name = name.substring(0, 1);
		
		for (String v : vowels) {
			if (vowel_name.equals(v)) {
				return "d'";
			}
		}
		
		return "de ";
	}
	
	public static String gamesShortToRegion(String gamesShort) {
		if (gamesShort.equals("RB") || gamesShort.equals("RV") || gamesShort.equals("J") || gamesShort.equals("RFVF") || gamesShort.equals("LGPE")) {
			return "Kanto";
		} else if (gamesShort.equals("OA") || gamesShort.equals("C") || gamesShort.equals("HGSS")) {
			return "Johto";
		} else if (gamesShort.equals("RS") || gamesShort.equals("E") || gamesShort.equals("ROSA")) {
			return ("Hoenn");
		} else if (gamesShort.equals("DP") || gamesShort.equals("Pt") || gamesShort.equals("DEPS")) {
			return ("Sinnoh");
		} else if (gamesShort.equals("NB") || gamesShort.equals("N2B2")) {
			return ("Unys");
		} else if (gamesShort.equals("XY")) {
			return ("Kalos");
		} else if (gamesShort.equals("SL") || gamesShort.equals("USUL")) {
			return ("Alola");
		} else if (gamesShort.equals("EB")) {
			return ("Galar");
		} else if (gamesShort.equals("EBisa")) {
			return ("Isolarmure");
		} else if (gamesShort.equals("EBtec")) {
			return ("Couronneige");
		} else if (gamesShort.equals("LPA")) {
			return ("Hisui");
		} else if (gamesShort.equals("EV")) {
			return ("Paldea");
		} else if (gamesShort.equals("EVmt")) {
			return ("Septentria");
		} else if (gamesShort.equals("EVdi")) {
			return ("Institut Myrtille");
		}
		System.err.println("Did not find a region for " + gamesShort);
		return "";
	}

	public static String addHomonymy(String itemName, String gamesShort) {
		String region = gamesShortToRegion(gamesShort);

		List<String> itemHomonymiesArray = new ArrayList<String>();
		String[] itemHomonymies = {"Bandeau", "Carte", "Engrais", "Fossile", "Gelée Royale", "Gracidée", "Métronome", "Œuf", "Perle", "Rubis", "Sandwich", "Saphir"};
		for (int i=0; i<itemHomonymies.length; i++) {
			itemHomonymiesArray.add(itemHomonymies[i]);
		}
		
		switch(itemName) {
			case "Banane":
				return itemName + " (Paldea)";
			case "Carte Magn.":
				if (region.equals("Kanto") || region.equals("Johto")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Carte Magnétique":
				if (region.equals("Kanto") || region.equals("Johto")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Clé Ascenseur":
				if (region.equals("Kanto") || region.equals("Kalos")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Clé Hangar":
				if (region.equals("Johto") || region.equals("Hoenn")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Clé Secrète":
				if (region.equals("Kanto") || region.equals("Sinnoh")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Clé Sous-Sol":
				if (region.equals("Johto") || region.equals("Hoenn")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Clé Stockage":
				if (region.equals("Hoenn") || region.equals("Sinnoh")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName + " (Hoenn)";
				}
			case "Colis":
				if (region.equals("Kanto") || region.equals("Sinnoh")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Feuille d'Or":
				if (region.equals("Johto")) {
					return itemName + " (Pokémon Or HeartGold et Argent SoulSilver)";
				} else {
					return itemName;
				}
			case "Galet Noir":
				if (region.equals("Hisui")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName + " (Unys)";
				}
			case "Hyper Ball":
				if (region.equals("Hisui")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Lettre":
				return itemName + " (message)";
			case "Masse Ball":
				if (region.equals("Hisui")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Météorite":
				if (region.equals("Paldea")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName + " (Hoenn)";
				}
			case "Nouilles":
				if (region.equals("Galar") || region.equals("Paldea")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Objet perdu":
				return itemName + " (Kanto)";
			case "Objet Perdu":
				return itemName + " (Hisui)";
			case "Parc Ball":
				return itemName + " (Parc des Amis)";
			case "Poké Ball":
				if (region.equals("Hisui")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Steak Haché":
				if (region.equals("Galar") || region.equals("Paldea")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Super Ball":
				if (region.equals("Hisui")) {
					return itemName + " (" + region + ")";
				} else {
					return itemName;
				}
			case "Pomme":
				return itemName + " (Paldea)"; 
			default:
				if (itemHomonymiesArray.contains(itemName)) {
					return itemName + " (objet)";
				}					
				return itemName;
		}
	}
	
	public static String gamesShortToGamesLong(String gamesShort) {
		switch (gamesShort) {
			case "R":
				return "Rouge";
			case "B":
				return "Bleu";
			case "RB":
				return "Rouge et Bleu";
			case "V":
				return "Vert";
			case "RV":
				return "Rouge et Vert";
			case "J":
				return "Jaune";
			case "O":
				return "Or";
			case "A":
				return "Argent";
			case "OA":
				return "Or et Argent";
			case "C":
				return "Cristal";
			case "Ru":
				return "Rubis";
			case "Sa":
				return "Saphir";
			case "RS":
				return "Rubis et Saphir";
			case "RF":
				return "Rouge Feu";
			case "VF":
				return "Vert Feuille";
			case "RFVF":
				return "Rouge Feu et Vert Feuille";
			case "E":
				return "Émeraude";
			case "D":
				return "Diamant";
			case "P":
				return "Perle";
			case "DP":
				return "Diamant et Perle";
			case "Pt":
				return "Platine";
			case "HG":
				return "Or HeartGold";
			case "SS":
				return "Argent SoulSilver";
			case "HGSS":
				return "Or HeartGold et Argent SoulSilver";
			case "No":
				return "Noir";
			case "Bl":
				return "Blanc";
			case "NB":
				return "Noir et Blanc";
			case "No2":
				return "Noir 2";
			case "Bl2":
				return "Blanc 2";
			case "N2B2":
				return "Noir 2 et Blanc 2";
			case "X":
				return "X";
			case "Y":
				return "Y";
			case "XY":
				return "X et Y";
			case "RuO":
				return "Rubis Oméga";
			case "SaA":
				return "Saphir Alpha";
			case "ROSA":
				return "Rubis Oméga et Saphir Alpha";
			case "So":
				return "Soleil";
			case "Lu":
				return "Lune";
			case "SL":
				return "Soleil et Lune";
			case "US":
				return "Ultra-Soleil";
			case "UL":
				return "Ultra-Lune";
			case "USUL":
				return "Ultra-Soleil et Ultra-Lune";
			case "LGP":
				return "Let's Go, Pikachu";
			case "LGE":
				return "Lets' Go, Évoli";
			case "LGPE":
				return "Let's Go, Pikachu et Let's Go, Évoli";
			case "HOME":
				return "HOME";
			case "Ep":
				return "Épée";
			case "Bo":
				return "Bouclier";
			case "EB":
				return "Épée et Bouclier";
			case "EBisa":
				return "L'île solitaire de l'Armure";
			case "EBtec":
				return "Les terres enneigées de la Couronne";
			case "DE":
				return "Diamant Étincelant";
			case "PS":
				return "Perle Scintillante";
			case "DEPS":
				return "Diamant Étincelant et Perle Scintillante";
			case "LPA":
				return "Légendes Pokémon : Arceus";
			case "Ec":
				return "Écarlate";
			case "Vi":
				return "Violet";
			case "EV":
				return "Écarlate et Violet";
			case "EVmt":
				return "Le Masque Turquoise";
			case "EVdi":
				return "Le Disque Indigo";
			default:
				System.err.println("Did not find game long for " + gamesShort);
				return gamesShort;
		}
	}
	
	public static String gamesShortToEditor (String gamesShort) {
		switch (gamesShort) {
			case "DEPS":
				return "[[ILCA, Inc.]]";
			default:
				return "[[GAME FREAK (studio de développement)|GAME FREAK]]";
		}
	}	
}