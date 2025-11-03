package silvallie.modules;

import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.util.regex.Pattern;

public class addDex {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();

		String region = "Illumis";
		boolean secondary = false;
		boolean justOne = true;

		String deLaRegionDe = "de la région " + Util.de(region);
//		String deLaRegionDe = "";

		String[][] pokemonList = {{"002", "Macronium"}, {"003", "Méganium"}, {"003", "Méga-Méganium"}, {"004", "Gruikui"}, {"005", "Grotichon"}, {"006", "Roitiflam"}, {"006", "Méga-Roitiflam"}, {"007", "Kaiminus"}, {"008", "Crocrodil"}, {"009", "Aligatueur"}, {"009", "Méga-Aligatueur"}, {"010", "Passerouge"}, {"011", "Braisillon"}, {"012", "Flambusard"}, {"013", "Sapereau"}, {"014", "Excavarenne"}, {"015", "Lépidonille"}, {"016", "Pérégrain"}, {"017", "Prismillon"}, {"018", "Aspicot"}, {"019", "Coconfort"}, {"020", "Dardargnan"}, {"020", "Méga-Dardargnan"}, {"021", "Roucool"}, {"022", "Roucoups"}, {"023", "Roucarnage"}, {"023", "Méga-Roucarnage"}, {"024", "Wattouat"}, {"025", "Lainergie"}, {"026", "Pharamp"}, {"026", "Méga-Pharamp"}, {"027", "Ratentif"}, {"028", "Miradar"}, {"029", "Rozbouton"}, {"030", "Rosélia"}, {"031", "Roserade"}, {"032", "Magicarpe"}, {"033", "Léviator"}, {"033", "Méga-Léviator"}, {"034", "Opermine"}, {"035", "Golgopathe"}, {"035", "Méga-Golgopathe"}, {"036", "Stari"}, {"037", "Staross"}, {"037", "Méga-Staross"}, {"038", "Flabébé"}, {"039", "Floette"}, {"039", "Méga-Floette"}, {"040", "Florges"}, {"041", "Cabriolaine"}, {"042", "Chevroum"}, {"043", "Psystigri"}, {"044", "Mistigrix"}, {"045", "Hélionceau"}, {"046", "Némélios"}, {"046", "Méga-Némélios"}, {"047", "Pandespiègle"}, {"048", "Pandarbare"}, {"049", "Miamiasme"}, {"050", "Miasmax"}, {"051", "Dedenne"}, {"052", "Pichu"}, {"053", "Pikachu"}, {"054", "Raichu"}, {"054", "Raichu d'Alola"}, {"055", "Mélo"}, {"056", "Mélofée"}, {"057", "Mélodelfe"}, {"057", "Méga-Mélodelfe"}, {"058", "Mimigal"}, {"059", "Migalos"}, {"060", "Abo"}, {"061", "Arbok"}, {"062", "Abra"}, {"063", "Kadabra"}, {"064", "Alakazam"}, {"064", "Méga-Alakazam"}, {"065", "Fantominus"}, {"066", "Spectrum"}, {"067", "Ectoplasma"}, {"067", "Méga-Ectoplasma"}, {"068", "Venipatte"}, {"069", "Scobolide"}, {"070", "Brutapode"}, {"070", "Méga-Brutapode"}, {"071", "Monorpale"}, {"072", "Dimoclès"}, {"073", "Exagide"}, {"074", "Chétiflor"}, {"075", "Boustiflor"}, {"076", "Empiflor"}, {"076", "Méga-Empiflor"}, {"077", "Feuillajou"}, {"078", "Feuiloutan"}, {"079", "Flamajou"}, {"080", "Flamoutan"}, {"081", "Flotajou"}, {"082", "Flotoutan"}, {"083", "Méditikka"}, {"084", "Charmina"}, {"084", "Méga-Charmina"}, {"085", "Dynavolt"}, {"086", "Élecsprint"}, {"086", "Méga-Élecsprint"}, {"087", "Tarsal"}, {"088", "Kirlia"}, {"089", "Gardevoir"}, {"089", "Méga-Gardevoir"}, {"090", "Gallame"}, {"090", "Méga-Gallame"}, {"091", "Malosse"}, {"092", "Démolosse"}, {"092", "Méga-Démolosse"}, {"093", "Tylton"}, {"094", "Altaria"}, {"094", "Méga-Altaria"}, {"095", "Nanméouïe"}, {"095", "Méga-Nanméouïe"}, {"096", "Fluvetin"}, {"097", "Cocotine"}, {"098", "Sucroquin"}, {"099", "Cupcanaille"}, {"100", "Évoli"}, {"101", "Aquali"}, {"102", "Voltali"}, {"103", "Pyroli"}, {"104", "Mentali"}, {"105", "Noctali"}, {"106", "Phyllali"}, {"107", "Givrali"}, {"108", "Nymphali"}, {"109", "Laporeille"}, {"110", "Lockpin"}, {"110", "Méga-Lockpin"}, {"111", "Polichombr"}, {"112", "Branette"}, {"112", "Méga-Branette"}, {"113", "Sorbébé"}, {"114", "Sorboul"}, {"115", "Sorbouboul"}, {"116", "Chamallot"}, {"117", "Camérupt"}, {"117", "Méga-Camérupt"}, {"118", "Hippopotas"}, {"119", "Hippodocus"}, {"120", "Rototaupe"}, {"121", "Minotaupe"}, {"121", "Méga-Minotaupe"}, {"122", "Mascaïman"}, {"123", "Escroco"}, {"124", "Crocorible"}, {"125", "Machoc"}, {"126", "Machopeur"}, {"127", "Mackogneur"}, {"128", "Griknot"}, {"129", "Carmache"}, {"130", "Carchacrok"}, {"130", "Méga-Carchacrok"}, {"131", "Strassie"}, {"132", "Ténéfix"}, {"132", "Méga-Ténéfix"}, {"133", "Mysdibule"}, {"133", "Méga-Mysdibule"}, {"134", "Absol"}, {"134", "Méga-Absol"}, {"135", "Riolu"}, {"136", "Lucario"}, {"136", "Méga-Lucario"}, {"137", "Ramoloss"}, {"137", "Ramoloss de Galar"}, {"138", "Flagadoss"}, {"138", "Flagadoss de Galar"}, {"138", "Méga-Flagadoss"}, {"139", "Roigada"}, {"139", "Roigada de Galar"}, {"140", "Carvanha"}, {"141", "Sharpedo"}, {"141", "Méga-Sharpedo"}, {"142", "Anchwatt"}, {"143", "Lampéroie"}, {"144", "Ohmassacre"}, {"144", "Méga-Ohmassacre"}, {"145", "Minidraco"}, {"146", "Draco"}, {"147", "Dracolosse"}, {"147", "Méga-Dracolosse"}, {"148", "Bulbizarre"}, {"149", "Herbizarre"}, {"150", "Florizarre"}, {"150", "Méga-Florizarre"}, {"151", "Salamèche"}, {"152", "Reptincel"}, {"153", "Dracaufeu"}, {"153", "Méga-Dracaufeu X"}, {"153", "Méga-Dracaufeu Y"}, {"154", "Carapuce"}, {"155", "Carabaffe"}, {"156", "Tortank"}, {"156", "Méga-Tortank"}, {"157", "Limonde"}, {"157", "Limonde de Galar"}, {"158", "Couafarel"}, {"159", "Sepiatop"}, {"160", "Sepiatroce"}, {"160", "Méga-Sepiatroce"}, {"161", "Venalgue"}, {"162", "Kravarech"}, {"162", "Méga-Kravarech"}, {"163", "Flingouste"}, {"164", "Gamblast"}, {"165", "Mucuscule"}, {"166", "Colimucus"}, {"166", "Colimucus de Hisui"}, {"167", "Muplodocus"}, {"167", "Muplodocus de Hisui"}, {"168", "Cadoizo"}, {"169", "Stalgamin"}, {"170", "Oniglali"}, {"170", "Méga-Oniglali"}, {"171", "Momartik"}, {"171", "Méga-Momartik"}, {"172", "Blizzi"}, {"173", "Blizzaroi"}, {"173", "Méga-Blizzaroi"}, {"174", "Grelaçon"}, {"175", "Séracrawl"}, {"175", "Séracrawl de Hisui"}, {"176", "Insécateur"}, {"177", "Cizayox"}, {"177", "Méga-Cizayox"}, {"178", "Scarabrute"}, {"178", "Méga-Scarabrute"}, {"179", "Scarhino"}, {"179", "Méga-Scarhino"}, {"180", "Emolga"}, {"181", "Brutalibré"}, {"181", "Méga-Brutalibré"}, {"182", "Brocélôme"}, {"183", "Desséliande"}, {"184", "Baggiguane"}, {"185", "Baggaïd"}, {"185", "Méga-Baggaïd"}, {"186", "Sonistrelle"}, {"187", "Bruyverne"}, {"188", "Trousselin"}, {"189", "Funécire"}, {"190", "Mélancolux"}, {"191", "Lugulabre"}, {"191", "Méga-Lugulabre"}, {"192", "Ptéra"}, {"192", "Méga-Ptéra"}, {"193", "Ptyranidur"}, {"194", "Rexillius"}, {"195", "Amagara"}, {"196", "Dragmara"}, {"197", "Onix"}, {"198", "Steelix"}, {"198", "Méga-Steelix"}, {"199", "Galekid"}, {"200", "Galegon"}, {"201", "Galeking"}, {"201", "Méga-Galeking"}, {"202", "Galvaran"}, {"203", "Iguolta"}, {"204", "Pitrouille"}, {"205", "Banshitrouye"}, {"206", "Embrylex"}, {"207", "Ymphect"}, {"208", "Tyranocif"}, {"208", "Méga-Tyranocif"}, {"209", "Grenousse"}, {"210", "Croâporal"}, {"211", "Amphinobi"}, {"211", "Méga-Amphinobi"}, {"212", "Hexadron"}, {"212", "Méga-Hexadron"}, {"213", "Marisson"}, {"214", "Boguérisse"}, {"215", "Blindépique"}, {"215", "Méga-Blindépique"}, {"216", "Airmure"}, {"216", "Méga-Airmure"}, {"217", "Feunnec"}, {"218", "Roussil"}, {"219", "Goupelin"}, {"219", "Méga-Goupelin"}, {"220", "Draby"}, {"221", "Drackhaus"}, {"222", "Drattak"}, {"222", "Méga-Drattak"}, {"223", "Kangourex"}, {"223", "Méga-Kangourex"}, {"224", "Draïeul"}, {"224", "Méga-Draïeul"}, {"225", "Terhal"}, {"226", "Métang"}, {"227", "Métalosse"}, {"227", "Méga-Métalosse"}, {"228", "Xerneas"}, {"229", "Yveltal"}, {"230", "Zygarde"}, {"230", "Méga-Zygarde"}, {"231", "Diancie"}, {"231", "Méga-Diancie"}, {"232", "Mewtwo"}, {"232", "Méga-Mewtwo X"}, {"232", "Méga-Mewtwo Y"}};

		run(region, deLaRegionDe, pokemonList, secondary, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Adds the dex number to the corresponding Poképédia pages
	 * @param region The name of the Pokédex to add (examples: Kalos, Unys-N2B2, Illumis)
	 * @param deLaRegionDe The part to use for the edit description, which is "Ajout du numéro de Pokédex {<code>deLaRegionDe</code>}{<code>region</code>}"
	 * @param pokemonList A list of data containing the dex numbers. Each element should be a list where the first member is a string with the dex number, and the second element is the name of the page where to add the dex number (example: {"002", "Macronium"})
	 * @param secondary Set to true if the game is a secondary game, i.e. not a main game
	 * @param justOne Set to true to stop after the first edit. Please use this on the first run to avoid accidents
	 */
	private static void run(String region, String deLaRegionDe, String[][] pokemonList, boolean secondary, boolean justOne) {
		for (String[] couple : pokemonList) {
			String num = couple[0];
			String pokeName = couple[1];

			Page pokePage = new Page(pokeName);

			String contents = pokePage.getContent();
			String patternSearch;
			String patternSetBeginning;
			String patternSetEnding = "\n";

			if (contents.matches("[^👻]*" + region + "/[0-9]+[^👻]*")) {
				patternSearch = region + "/[0-9]+\n";
				patternSetBeginning = "";
			}
			else if (secondary) {
				if (!contents.contains("dex-secondaires"))  {
					patternSearch = "(?<name>\\|[ ]*dex[ ]*=[^\n]*)\n";
					patternSetBeginning = "$1//";
				} else {
					patternSearch = "(?<name>\\|[ ]*dex-secondaires[ ]*=[^\n]*)\n";
					patternSetBeginning = "$1\n| dex-secondaires=";
				}
			} else {
				if (!contents.contains("| dex"))  {
					patternSearch = "(?<name>\\|[ ]*ndex[ ]*=[^\n]*)\n";
					patternSetBeginning = "$1\n| dex=";
				} else {
					patternSearch = "(?<name>\\|[ ]*dex[ ]*=[^\n]*)\n";
					if (contents.contains("dex=\n") || contents.contains("dex= \n")) {
						patternSetBeginning = "$1";
					} else {
						patternSetBeginning = "$1//";
					}
				}
			}
			Pattern p = Pattern.compile(patternSearch, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

			String newContents = p.matcher(contents).replaceAll(patternSetBeginning + region + "/" + num + patternSetEnding);

//			System.out.println(newContents);
			pokePage.setContent(newContents, "Ajout du numéro de Pokédex " + deLaRegionDe + region);

			if (justOne) {
				break;
			}
		}
	}
}
