package silvallie.modules.oneTimeUse;

import silvallie.*;

public class addCardTopics {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();

		String startingFrom = null;
		boolean justOne = true;

		run(startingFrom, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Adds main topics on card pages depending on their name
	 * @param startingFrom The name of the first page. Set to null to begin from start
	 * @param justOne Set to true to stop after the first page edit. Please use this on the first run to avoid accidents
	 */
	private static void run(String startingFrom, boolean justOne) {

		String categoryName = "Carte Dresseur";

		int[] nameSpaces = new int[]{API.NS_MAIN};
		PageCollection pageCollection = new PageCollection(
				nameSpaces,
				API.FILTER_NONREDIRECTS,
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

		String[] singlePages = {"A.Z.", "Adamantin", "Admin Rocket", "Adriane", "Alba Minçalor", "Aldo",
				"Alisma", "Alistair", "Alizée", "Althéo", "Alyxia", "Amaryllis", "Anis", "Apia", "Apocyne",
				"Appât Ball", "Armand", "Aromathérapeute", "Arène d'Ondes-sur-Mer", "Arène de Pavonnay",
				"Assurance Échec", "Astera", "Atalante", "Autel de la Lune", "Autel du Soleil", "Baie Oran",
				"Baie Prine", "Baie Sitrus", "Ball Masqué", "Ballon", "Bandeau Choix", "Bandeau Muscle", "Bardane",
				"Barista", "Bayar", "Beladonis", "Bicyclette", "Bouclier Rouillé", "Brome", "Butte du Dynarbre",
				"Bélila", "Canne", "Canon", "Cardus", "Carton Rouge", "Casque Brut", "Cayenn",
				"Ceinture Force", "Cendre Sacrée", "Centre Pokémon", "Cherch'Objet", "Cherche VS", "Chrono Ball",
				"Cimetière Ancien", "Clavel", "Clément", "Colline Clapotis", "Colza", "Copain Ball", "Copieuse",
				"Corde Sortie", "Cormier", "Cornélia", "Cuencia", "Cuisinier", "Danh", "Dhilan", "Dianthéa",
				"Docteure", "Donna", "Erika", "Erio", "Exorciste", "Faiblo Ball", "Fan de Pique-Nique", "Filet Ball",
				"Fille en Kimono", "Fillette", "Flo", "Forêt de Jade", "Forêt de Lumirinth", "Fossile Dôme",
				"Fossile Mâchoire", "Fossile Nageoire", "Fossile Plaque", "Fossile Plume", "Fromage Meumeu", "Gamin",
				"Ghetis", "Gladys", "Gloria", "Graham", "Grusha", "Guido", "Guzma", "Hassa", "Honor Ball", "Huile",
				"Hyper Ball", "Hyper Potion", "Inezia", "Jacq", "Jasmine", "Jeannine", "Jongleur", "Jumelles", "Kabu",
				"Kahili", "Karatéka", "Kassis", "Kata-Sensei de l'Ultra-Forêt", "Kiméra", "Kit de Camping", "Koga",
				"Kokohio", "Labos Lysandre", "Lac Savoir", "Lait Meumeu", "Lavanville", "Laïm", "Lino", "Lithia",
				"Liv", "Lona", "Love Ball", "Lucio", "Lula", "Luxe Ball", "Lysandre", "Léo", "Lévy et Tatia",
				"M. Fuji", "Mademoiselle", "Malasada Maxi", "Marais Bouchebée", "Marcia", "Margie", "Marion", "Mars",
				"Mashynn", "Masse Ball", "Master Ball", "Matis", "Meloco", "Menzi", "Mesaledo", "Miel", "Mimosa",
				"Mine de Galar", "Module Leurre", "Molène", "Mont Abrupt", "Mont Couronné", "Mont Foré",
				"Mont Lanakila", "Montagnard", "Mora", "Mortimer", "Moticyclette", "Motisma Drone", "Motisma-Dex",
				"Motismart", "Multi Exp", "Mystimaniac", "Méga Canne", "Mémoire Ball", "Méridia", "Nabil", "Nacchara",
				"Narcisse", "NigoMix 3000", "Nikodule", "Nikolaï", "Ninja Amateur", "Niveau Ball", "Nix", "Norman",
				"Nèflie", "Okuba", "Oléa", "Ornithologue", "Ortiga", "Ouvrière", "Pania", "Parc Volcanique", "Paulie",
				"Pectorius", "Pepper", "Percila", "Percupio", "Percy", "Peterson", "Pic Venin", "Pieris",
				"Pierrallégée", "Pierre Nuit", "Pierrick", "Pilier Céleste", "Pivonia", "Plateau Indigo",
				"Plume Ball", "Poké Ball", "Poké Enfant", "PokéNav", "PokéStop", "Pokédex", "Pokémaniac",
				"Pont Sagiciel", "Popi", "Potion", "Potion Max", "Professeur Lavande", "Professeur Platane", "Pépite",
				"Pêcheur", "QG Galaxie", "ROM Combat", "ROM Eau", "ROM Feu", "ROM Plante", "ROM Psy", "ROM Électrik",
				"Raphaël Chen", "Rapide Ball", "Rappel", "Rappel Max", "Registre Ami", "Repousse",
				"Restes", "Rolleur Skateuse", "Rollers", "Roseille", "Rosemary", "Roxanne", "Roy", "Ruines d'Alpha",
				"Rune Sort", "Rusti-Cité", "Rêve Ball", "Saguaro", "Sally", "Saltimbanque", "Salvio", "Sara",
				"Saturnin", "Saubohne", "Sbire de la Team Aqua", "Sbire de la Team Flare", "Sbire de la Team Magma",
				"Sbire de la Team Skull", "Sbire de la Team Star", "Sbire de la Team Yell",
				"Scott", "Scout", "Scuba Ball", "Selena", "Senior et Junior", "Sentier Blanche-Cime", "Shehroz",
				"Shehroz Tower", "Sica", "Smarceus", "Smashings", "Sombre Ball", "Sonya", "Sophora", "Spectra",
				"Spruce Keteleeria", "Stade de Greenbury", "Stade de Winscor", "Strykna", "Super Ball",
				"Super Bonbon", "Super Potion", "Sœur Parasol", "Tanguy", "Tcheren", "Temple Frimapic",
				"Temple de Sinnoh", "Terreur", "Timmy", "Total Soin", "Tour Cendrée", "Tour Chétiflor",
				"Tour de l'Eau", "Tour des Ténèbres", "Travis", "Trio des Ombres", "Trou Brothers", "Tully",
				"Ultra Ball", "Ultra-Commando", "Ultra-Dimension", "Vacancière", "Vesper", "Veste de Combat", "Vicky",
				"Vieil Ambre", "Vokit", "Vulné-Assurance", "Vélo Cross", "Xanthin", "Écolier", "Écolière", "Élige",
				"Épée Rouillée", "Éra", "Évoluroc", "Œuf Chance"
		};
		// Ordres du Boss
		// Recherches Professorales
		// ジムバッジ (XYプロモカード)
		String[][] associations = {
				{"Admin Team Aqua", "Admin Team Aqua", "Sarah", "Matthieu"},
				{"Admin Team Magma", "Admin Team Magma", "Kelvin", "Courtney"},
				{"Aide de Nina", "Nina Chen"},
				{"Agatha", "Agatha (Conseil 4)"},
				{"Albert", "Albert (Johto)"},
				{"Ambition de Cynthia", "Cynthia (jeux vidéo)"},
				{"Amis de Galar", "Victor (Galar)", "Gloria", "Travis", "Nabil", "Rosemary"},
				{"Amis de Hisui", "Adamantin", "Nacchara", "Lucia", "Aurel"},
				{"Amis de Sinnoh", "René (jeux vidéo)", "Tanguy", "Louka", "Aurore (jeux vidéo)", "Cynthia (jeux vidéo)"},
				{"Analyse de Léo", "Léo"},
				{"Annette surfe sur le net", "Annette"},
				{"Armando, Rachid et Noa", "Armando", "Rachid (jeux vidéo)", "Noa"},
				{"Arthur", "Arthur (Team Aqua)"},
				{"Arène d'Argenta de Pierre", "Arène d'Argenta"},
				{"Arène d'Azuria d'Ondine", "Arène d'Azuria"},
				{"Atout de Lysandre", "Lysandre"},
				{"Attaque sournoise des Rocket", "Cassidy"},
				{"Attention de Tcheren", "Tcheren"},
				{"Aurore", "Aurore (Châtelaine Combat)"},
				{"Aérozélite : Lame d'Air", "Aérozélite"},
				{"Baie", "Baie (deuxième génération)"},
				{"Baie dorée", "Baie Dorée"},
				{"Baie mirale", "Baie Miracle"},
				{"Balle rapide", "Rapide Ball"},
				{"Bandeau", "Bandeau (objet)"},
				{"Barbara", "Barbara (jeux vidéo)"},
				{"Barbara et Néphie", "Barbara (jeux vidéo)", "Néphie (jeux vidéo)"},
				{"Base Secrète de la Team Aqua", "Planque Aqua"},
				{"Base Secrète de la Team Magma", "Planque Magma"},
				{"Bastien", "Bastien (Champion)"},
				{"Bianca", "Bianca (jeux vidéo)"},
				{"Bill", "Léo"},
				{"Bill's Maintenance", "Léo"},
				{"Blaine", "Auguste"},
				{"Blaine's Gamble", "Auguste"},
				{"Blaine's Last Resort", "Auguste"},
				{"Blaine's Quiz 1", "Auguste"},
				{"Blaine's Quiz 2", "Auguste"},
				{"Blaine's Quiz 3", "Auguste"},
				{"Blanche", "Blanche (Johto)"},
				{"Bonne Canne", "Super Canne"},
				{"Brock", "Pierre (Kanto)"},
				{"Brock's Protection", "Pierre (Kanto)"},
				{"Brock's Training Method", "Pierre (Kanto)"},
				{"Cachette de Team Aqua", "Planque Aqua"},
				{"Cachette de Team Magma", "Planque Magma"},
				{"Canne Ordinaire", "Canne"},
				{"Canne à Pêche de Néphie", "Canne à Pêche"},
				{"Capitaine d'équipe Blanche", "Blanche (Pokémon GO)"},
				{"Capitaine d'équipe Candela", "Candela"},
				{"Capitaine d'équipe Spark", "Spark"},
				{"Capsule Technique : Angle Mort", "CT"},
				{"Capsule Technique : Dés-Évolution", "CT"},
				{"Capsule Technique : Énergisant Spontané", "CT"},
				{"Capsule Technique : Évolution", "CT"},
				{"Capsule Énergie Booster Temps Futur", "Énergie Booster"},
				{"Capsule Énergie Booster Temps Passé", "Énergie Booster"},
				{"Carolina", "Carolina (Unys)"},
				{"Carte", "Carte (objet)"},
				{"Ceinture de Karaté", "Ceinture Noire"},
				{"Celadon City Gym", "Arène de Céladopole"},
				{"Centrale d'Énergie", "Centrale abandonnée"},
				{"Centre Culturel", "Jaderaude"},
				{"Centre Pokémon de Nuit", "Centre Pokémon"},
				{"Centre spatial", "Centre Spatial d'Algatia"},
				{"Cerulean City Gym", "Arène d'Azuria"},
				{"Chammal et Chamsin", "Chammal", "Chamsin"},
				{"Charisme de Giovanni", "Giovanni (jeux vidéo)"},
				{"Chaz", "Chaz (Galar)"},
				{"Choice Band", "Bandeau Choix"},
				{"Chrys", "Chrys (jeux vidéo)"},
				{"Cinnabar City Gym", "Arène de Cramois'Île"},
				{"Cité Parallèle", "Ville Noire", "Forêt Blanche"},
				{"Clem", "Clem (jeux vidéo)"},
				{"Clove", "Clavel"},
				{"Collectionneur de Pokémon", "Collectionneur"},
				{"Combine de Giovanni", "Giovanni (jeux vidéo)"},
				{"Concentration de Cornélia", "Cornélia"},
				{"Conspirateur de Team Aqua", "Team Aqua"},
				{"Conspirateur de Team Magma", "Team Magma"},
				{"Conviction de Marion", "Marion"},
				{"Conviction de Mortimer", "Mortimer"},
				{"Coup d'Œil au Carton Rouge", "Carton Rouge"},
				{"Courrier de Léo", "Léo"},
				{"Cours du Professeur Orme", "Professeur Orme"},
				{"Court d'Entraînement", "Paddoxton"},
				{"Curry Épicé aux Piments", "Curry"},
				{"Cynthia", "Cynthia (jeux vidéo)"},
				{"Cynthia et Percila", "Cynthia (jeux vidéo)", "Percila"},
				{"Dame du Centre Pokémon", "Infirmière Joëlle"},
				{"Damien", "Damien (Conseil 4)"},
				{"Danseuse", "Danseuse (classe)"},
				{"Defender", "Défense +"},
				{"Dernier Recours d'Arthur", "Arthur (Team Aqua)"},
				{"Dernière Chance d'Auguste", "Auguste"},
				{"Dojo des Arts Martiaux", "Dojo de Safrania"},
				{"Dome Fossil", "Fossile Dôme"},
				{"Dracozélite : Dracogriffe", "Dracozélite"},
				{"Dresseurs d'Arène", "Dresseur d'Arène"},
				{"Défenseur", "Défense +"},
				{"Défi de Red", "Red (jeux vidéo)"},
				{"Détermination d'Ondine", "Ondine (jeux vidéo)"},
				{"Dévouement de Bianca", "Bianca (jeux vidéo)"},
				{"Elsa-Mina", "Elsa-Mina (jeux vidéo)"},
				{"Elsa-Mina Prisme Étoile", "Elsa-Mina (jeux vidéo)"},
				{"Employés de la Fondation Æther", "Employé de la Fondation Æther"},
				{"Employés de la Ligue", "Employé de la Ligue"},
				{"Entraînement de Pierre", "Pierre (Kanto)"},
				{"Entraînement de Sage", "Sage"},
				{"Entretien de Leo", "Léo"},
				{"Entretien de Léo", "Léo"},
				{"Erika's Kindness", "Erika"},
				{"Erika's Maids", "Erika"},
				{"Erika's Perfume", "Erika"},
				{"Espace-Temps brisé", "Colonnes Lances"},
				{"Et voila les Team Rocket !", "Team Rocket (trio)"},
				{"Et voilà la Team Rocket !", "Team Rocket (trio)"},
				{"Exil de Giovanni", "Giovanni (jeux vidéo)"},
				{"Expert Belt", "Ceinture Pro"},
				{"Exploration de Leaf", "Leaf"},
				{"Expérience de Nikolaï", "Nikolaï"},
				{"Fast Ball", "Speed Ball"},
				{"Faux Professeur Chen", "Professeur Chen (jeux vidéo)"},
				{"Faveur d'Ondine", "Ondine (jeux vidéo)"},
				{"Faïza", "Faïza (jeux vidéo)"},
				{"Fervor", "Auguste"},
				{"Fierté de Rosemary", "Rosemary"},
				{"Fisherman", "Pêcheur"},
				{"Flûte Pokémon", "Poké Flûte"},
				{"Fossile Armure Dinoclier", "Fossile Armure"},
				{"Fossile Dôme Ancien", "Fossile Dôme"},
				{"Fossile Dôme Kabuto", "Fossile Dôme"},
				{"Fossile Griffe Anorith", "Fossile Griffe"},
				{"Fossile Nautile", "Nautile"},
				{"Fossile Nautile Amonita", "Nautile"},
				{"Fossile Nautile Ancien", "Nautile"},
				{"Fossile Racine Lilia", "Fossile Racine"},
				{"Fossile armure", "Fossile Armure"},
				{"Fossile crâne", "Fossile Crâne"},
				{"Fossile griffe", "Fossile Griffe"},
				{"Fossile racine", "Fossile Racine"},
				{"Fourberie de la Team Rocket", "Team Rocket (organisation)"},
				{"Friend Ball", "Copain Ball"},
				{"Fuchsia City Gym", "Arène de Parmanie"},
				{"Giovanni", "Giovanni (jeux vidéo)"},
				{"Giovanni's Last Resort", "Giovanni (jeux vidéo)"},
				{"Gladio", "Gladio (jeux vidéo)"},
				{"Good Manners", "Erika"},
				{"Guzma et Pectorius", "Guzma", "Pectorius"},
				{"Guérison Totale", "Total Soin"},
				{"Helix Fossil", "Nautile"},
				{"Herbe Sauveuse", "Herbe Rappel"},
				{"Herbe sauveuse", "Herbe Rappel"},
				{"Here Comes Team Rocket!", "Team Rocket (trio)"},
				{"Honor ball", "Honor Ball"},
				{"Hospitalité d'Erika", "Erika"},
				{"Hélio Prisme Étoile", "Hélio"},
				{"Imakuni ?", "Imakuni?"},
				{"Impulsion de Lula", "Lula"},
				{"Incubateur d'Œufs", "Incubateur"},
				{"Indice du Prof. Chen", "Professeur Chen (jeux vidéo)"},
				{"Infirmière Pokémon", "Infirmière Joëlle"},
				{"Installation du Professeur Chen", "Professeur Chen (jeux vidéo)"},
				{"Invitation d'Erika", "Erika"},
				{"Iris", "Iris (jeux vidéo)"},
				{"Jean-Fleuret et Jean-Targe", "Jean-Fleuret", "Jean-Targe"},
				{"Jessie et James", "Jessie", "James"},
				{"Journaliste Télé", "Journalistes"},
				{"Journaliste télé", "Journalistes"},
				{"Jujube et Zhuman", "Morgane", "Zhu"},
				{"Juliette", "Juliette (jeux vidéo)"},
				{"Kiawe", "Kiawe (jeux vidéo)"},
				{"Koga's Ninja Trick", "Koga"},
				{"L'enquête de Beladonis", "Beladonis"},
				{"L'entrainement de Cornil", "Cornil"},
				{"L'entraînement de Cornil", "Cornil"},
				{"L'initiative d'Hélio", "Hélio"},
				{"L'invention du faux professeur Chen", "Professeur Chen (jeux vidéo)"},
				{"La chaleur de Terry", "Terry (Conseil 4)"},
				{"La collection d'Aaron", "Aaron (Conseil 4)"},
				{"La compassion de M. Briney", "M. Marco"},
				{"La contribution de Koner", "Koner"},
				{"La découverte du Professeur Kosmo", "Professeur Kosmo"},
				{"La gentillesse de Maman", "Mère"},
				{"La gentillesse de maman", "Mère"},
				{"La mission de Lucio", "Lucio"},
				{"La pari de l'équipe Galaxie", "Sbire Galaxie"},
				{"La philosophie de Tanguy", "Tanguy"},
				{"La recherche d'Amelle", "Amelle"},
				{"La requête de Lula", "Lula"},
				{"La requête de Vivianne", "Viviane (Sinnoh)"},
				{"La salle de concours Pokémon", "Unionpolis"},
				{"La visite du Prof. Chen", "Professeur Chen (jeux vidéo)"},
				{"La volonté d'Adrien", "Adrien"},
				{"Laboratoire Pokémon", "Laboratoire de Cramois'Île"},
				{"Le choix de Pluton", "Pluton"},
				{"Le complot d'Hélio", "Hélio"},
				{"Le gymnase de Rivamar", "Arène de Rivamar"},
				{"Le projet de M. Rochard", "M. Rochard"},
				{"Le réseau de Cileo", "Ciléo"},
				{"Lem", "Lem (jeux vidéo)"},
				{"Leo", "Léo"},
				{"Les Détroussœurs", "Détroussœurs"},
				{"Les conseils de Cynthia", "Cynthia (jeux vidéo)"},
				{"Les conseils de Pierre", "Pierre Rochard (jeux vidéo)"},
				{"Les sentiments de Cynthia", "Cynthia (jeux vidéo)"},
				{"Lettre du Professeur", "Lettre Prof"},
				{"Lieu de la Fête", "Septemplion"},
				{"Lilie", "Lilie (jeux vidéo)"},
				{"Loubards Pit & Paul", "Loubards"},
				{"Lovis le Teigneux", "Lovis"},
				{"Lt. Surge", "Major Bob"},
				{"Lt. Surge's Secret Plan", "Major Bob"},
				{"Lt. Surge's Treaty", "Major Bob"},
				{"Lucky Egg", "Œuf Chance"},
				{"Lure Ball", "Appât Ball"},
				{"Lysandre Prisme Étoile", "Lysandre"},
				{"Machine Technique : Poing de Crise", "CT"},
				{"Machine Techinque Ancienne", "CT"},
				{"Manipulateur de Team Aqua", "Team Aqua"},
				{"Manipulateur de Team Magma", "Team Magma"},
				{"Marc", "Marc (Hoenn)"},
				{"Mars de la Team Galaxie", "Mars"},
				{"Masque de Monstre", "Masque Turquoise", "Masque du Fourneau", "Masque du Puits", "Masque de la Pierre"},
				{"Masse Ball de Hisui", "Masse Ball (Hisui)"},
				{"Mauvaises actions des Team Rocket", "Team Rocket (organisation)"},
				{"Max", "Max (Team Magma)"},
				{"Max Revive", "Rappel Max"},
				{"Max Élixir", "Élixir Max"},
				{"Maîtrise Aquatique d'Ondine", "Ondine (jeux vidéo)"},
				{"Minion of Team Rocket", "Sbire Rocket"},
				{"Misty", "Ondine (jeux vidéo)"},
				{"Misty's Duel", "Ondine (jeux vidéo)"},
				{"Misty's Tears", "Ondine (jeux vidéo)"},
				{"Misty's Wish", "Ondine (jeux vidéo)"},
				{"Misty's Wrath", "Ondine (jeux vidéo)"},
				{"Mont Selenite", "Mont Sélénite"},
				{"Morgane et Zhu", "Morgane", "Zhu"},
				{"Motisma-Dex Mode Poké Scope", "Motisma-Dex"},
				{"Multi expédition", "Multi Exp"},
				{"Multi expéditions", "Multi Exp"},
				{"Mustar Style Mille Poings", "Mustar"},
				{"Mustar Style Poing Final", "Mustar"},
				{"Mystérieux Fossile", "Fossile Dôme", "Nautile", "Vieil Ambre"},
				{"Mystérieux fossile", "Fossile Dôme", "Nautile", "Vieil Ambre"},
				{"Méfaits de la Team Rocket", "Sbire Rocket"},
				{"Méthode d'entraînement du Prof. Orme", "Professeur Orme"},
				{"Méthode d'entraînement du professeur Orme", "Professeur Orme"},
				{"N", "Natural Harmonia Gropius"},
				{"Normazélite : Charge", "Normazélite"},
				{"Nouveau Pokédex", "Pokédex"},
				{"Nouvelle théorie du Prof. Chen", "Professeur Chen (jeux vidéo)"},
				{"Néphie", "Néphie (jeux vidéo)"},
				{"Observations du Professeur Seko", "Professeur Seko"},
				{"Océan du Néant", "Ultra-Abysses"},
				{"Old Amber", "Vieil Ambre"},
				{"Olivier", "Olivier (jeux vidéo)"},
				{"Ondine et Olga", "Ondine (jeux vidéo)", "Olga (Conseil 4)"},
				{"Pack d'Eaux Fraîches", "Eau Fraîche"},
				{"Panier de Pique-Nique", "Pique-nique (mécanique)"},
				{"Peluche Mélofée", "Poké Poupée"},
				{"Peter", "Peter (jeux vidéo)"},
				{"Peter Prisme Étoile", "Peter (jeux vidéo)"},
				{"Pewter City Gym", "Arène d'Argenta"},
				{"Pierre", "Pierre Rochard (jeux vidéo)"},
				{"Piste Cyclable", "Route 17 (Kanto)"},
				{"Pièce rune", "Pièce Rune"},
				{"Piège de Koga", "Koga"},
				{"Plan du Professeur Turum", "Professeur Turum"},
				{"Pleine Puissance de Lilie", "Lilie (jeux vidéo)"},
				{"PlusPower", "Attaque +"},
				{"Poffin Copain-Copain", "Poffin"},
				{"Pofiterole Envoûtante", "Pofiterole"},
				{"Poké Balle", "Poké Ball"},
				{"Poké Poupée de Lilie", "Poké Poupée"},
				{"Poké radar", "Poké Radar"},
				{"Pokédex HANDY910is", "Pokédex"},
				{"Pokématos 3.0", "Pokématos"},
				{"Pokémon Center", "Centre Pokémon"},
				{"Pokémon Ranger", "Pokémon Ranger (classe de Dresseurs)"},
				{"Pokémon Tower", "Tour Pokémon"},
				{"Poupée Ronflex", "Poupée"},
				{"Prof. Euphorbe", "Professeur Euphorbe (jeux vidéo)"},
				{"Prof. Seko", "Professeur Seko"},
				{"Prof. Sorbier", "Professeur Sorbier"},
				{"Professeur Chen", "Professeur Chen (jeux vidéo)"},
				{"Professeur Keteleeria", "Professeure Keteleeria"},
				{"Professeure Pimprenelle", "Professeure Pimprenelle (jeux vidéo)"},
				{"Professor Elm", "Professeur Orme"},
				{"Professor Oak's Visit", "Professeur Chen (jeux vidéo)"},
				{"Prémonition de Margie", "Margie"},
				{"Rachid", "Rachid (jeux vidéo)"},
				{"Racine Énergie", "Racinénergie"},
				{"Rare Candy", "Super Bonbon"},
				{"Recherches du professeur Chen", "Professeur Chen (jeux vidéo)"},
				{"Red et Blue", "Red (jeux vidéo)", "Blue (jeux vidéo)"},
				{"René", "René (jeux vidéo)"},
				{"Repaire des Rocket !", "Team Rocket (organisation)"},
				{"Rival", "René (jeux vidéo)"},
				{"Rocket's Hideout", "Team Rocket (organisation)"},
				{"Rocket's Mission", "Team Rocket (organisation)"},
				{"Royal Mask", "Professeur Euphorbe (jeux vidéo)"},
				{"Ruse de Max", "Max (Team Magma)"},
				{"Réanimation", "Rappel"},
				{"Réserve Naturelle du Paradis Æther", "Paradis Æther"},
				{"Résolution d'Amaryllis", "Amaryllis"},
				{"Résolution de N", "Natural Harmonia Gropius"},
				{"Résolution de Pierre", "Pierre Rochard (jeux vidéo)"},
				{"Sabrina", "Morgane"},
				{"Sabrina's ESP", "Morgane"},
				{"Sabrina's Gaze", "Morgane"},
				{"Sabrina's Psychic Control", "Morgane"},
				{"Sac Aventure", "Sac"},
				{"Sac de Menzi", "Sac", "Menzi"},
				{"Saffron City Gym", "Arène de Safrania"},
				{"Salle de Maître", "Ligue de Sinnoh"},
				{"Sannah", "Sannah (jeux vidéo)"},
				{"Sbire de la Team Plasma", "Sbire Plasma"},
				{"Secret Mission", "Major Bob"},
				{"Serena", "Serena (jeux vidéo)"},
				{"Siège de la Ligue Pokémon", "Ligue Pokémon (Paldea)"},
				{"Soins de l'Éleveur de Pokémon", "Éleveur"},
				{"Soutien de Néphie", "Néphie (jeux vidéo)"},
				{"Spécialité de Fillette", "Fillette"},
				{"Stade d'Aragon", "Aragon"},
				{"Stade de Damien", "Damien (Conseil 4)"},
				{"Stade de Glacia", "Glacia"},
				{"Stade de Spectra", "Spectra"},
				{"Star Piece", "Morceau d'Étoile"},
				{"Stratégie de Major Bob", "Major Bob"},
				{"Suggestion de Morgane", "Morgane"},
				{"Super Ball de la Team Aqua", "Super Ball", "Team Aqua"},
				{"Super Ball de la Team Magma", "Super Ball", "Team Magma"},
				{"Super bonbon", "Super Bonbon"},
				{"Série de Quiz d'Auguste", "Auguste"},
				{"Tactiques de Blue", "Blue (jeux vidéo)"},
				{"Tarak", "Tarak (jeux vidéo)"},
				{"Team Plasma Ball", "Team Plasma"},
				{"Terrain de Plage", "Cuchalaga"},
				{"The Rocket's Training Gym", "Team Rocket (organisation)"},
				{"The Rocket's Trap", "Team Rocket (organisation)"},
				{"Thermes de Ludester", "Ludester"},
				{"Tierno", "Tierno (jeux vidéo)"},
				{"Tili", "Tili (jeux vidéo)"},
				{"Timmy au dressage", "Timmy"},
				{"Top Dresseur", "Topdresseur"},
				{"Tour de Combat", "Tour de Combat (quatrième génération)"},
				{"Tour radio", "Tour Radio de Doublonville"},
				{"Transfert de Léo", "Léo"},
				{"Troisième Œil du Kinésiste", "Kinésiste"},
				{"Trovato", "Trovato (jeux vidéo)"},
				{"Téléporteur de Léo", "Léo"},
				{"Vaillance de Pierre", "Pierre (Kanto)"},
				{"Vermilion City Gym", "Arène de Carmin sur Mer"},
				{"Vieil Ambre Ancien", "Vieil Ambre"},
				{"Vieil Ambre Ptéra", "Vieil Ambre"},
				{"Ville Gelée", "Janusia"},
				{"Viridian City Gym", "Arène de Jadielle"},
				{"Vitalité de Flo", "Flo"},
				{"Vitalité de la Professeure Olim", "Professeure Olim"},
				{"À la façon du Boss", "Giovanni (jeux vidéo)"},
				{"Écho", "Écho (jeux vidéo)"},
				{"Éclat d'Inezia", "Inezia"},
				{"Éleveur de Pokémon", "Éleveur"},
				{"Éleveuse de Pokémon", "Éleveuse"},
				{"Élève de Paldea", "Étudiant"},
				{"Énergie guérisseuse", "Total Soin"},
				{"あなぬけのヒモ", "Corde Sortie"},
				{"かんこうきゃく", "Vacancière"},
				{"きずぐすり", "Potion"},
				{"ずがいの化石", "Fossile Crâne"},
				{"たての化石", "Fossile Armure"},
				{"ともだちてちょう", "Registre Ami"},
				{"なんでもなおし", "Total Soin"},
				{"にじいろのはな", "Fleur 7 Couleurs"},
				{"ぼうけんのカバン", "Sac"},
				{"アセロラ", "Margie"},
				{"アカネのワザマシン01", "Blanche (Johto)"},
				{"アカネのワザマシン02", "Blanche (Johto)"},
				{"アンズのワザマシン01", "Jeannine"},
				{"アンズのワザマシン02", "Jeannine"},
				{"アーロンの波導", "Seigneur Aaron"},
				{"イツキ", "Clément"},
				{"イツキのワザマシン01", "Clément"},
				{"イツキのワザマシン02", "Clément"},
				{"イブキのワザマシン01", "Sandra (Johto)"},
				{"イブキのワザマシン02", "Sandra (Johto)"},
				{"エフェクトガード", "Défense Spéc"},
				{"エリカのおもてなし", "Erika"},
				{"オーキド博士の出むかえ", "Professeur Chen (jeux vidéo)"},
				{"カスミ&カンナ", "Ondine (jeux vidéo)", "Olga (Conseil 4)"},
				{"カスミのてあて", "Ondine (jeux vidéo)"},
				{"カリンのワザマシン01", "Marion"},
				{"カリンのワザマシン02", "Marion"},
				{"グズマ", "Guzma"},
				{"グラジオ", "Gladio (jeux vidéo)"},
				{"グリーンの戦略", "Blue (jeux vidéo)"},
				{"サカキの計画", "Giovanni (jeux vidéo)"},
				{"サトシのゆうじょう", "Sacha Ketchum"},
				{"シジマのワザマシン01", "Chuck"},
				{"シジマのワザマシン02", "Chuck"},
				{"シバのワザマシン01", "Aldo"},
				{"シバのワザマシン02", "Aldo"},
				{"シロナ", "Cynthia (jeux vidéo)"},
				{"ジャッキーのキャプチャ", "Jack Walker"},
				{"ジュジュベ&ハチクマン", "Morgane", "Zhu"},
				{"ジラルダン", "Gelardan"},
				{"ダートじてんしゃ", "Vélo Cross"},
				{"ツクシのワザマシン01", "Hector (Johto)"},
				{"ツクシのワザマシン02", "Hector (Johto)"},
				{"トオイの気持ち", "Tory Lund"},
				{"ネストボール", "Faiblo Ball"},
				{"ハウ", "Tili (jeux vidéo)"},
				{"ハプウ", "Paulie"},
				{"ハヤトのワザマシン01", "Albert (Johto)"},
				{"ハヤトのワザマシン02", "Albert (Johto)"},
				{"バトラーの手品", "Butler"},
				{"ブルーの探索", "Leaf"},
				{"プラスパワー", "Attaque +"},
				{"プラズマ団のしたっぱ", "Sbire Plasma"},
				{"ホミカ", "Strykna"},
				{"ポケモンタワー", "Tour Pokémon"},
				{"ポケモン図鑑", "Pokédex"},
				{"マオ＆スイレン", "Barbara (jeux vidéo)", "Néphie (jeux vidéo)"},
				{"マコモのお手伝い", "Oryse"},
				{"マサキ", "Léo"},
				{"マサキのパソコン", "Léo"},
				{"マスターボール", "Master Ball"},
				{"マツバのワザマシン01", "Mortimer"},
				{"マツバのワザマシン02", "Mortimer"},
				{"マツリカ", "Oléa"},
				{"マナフィのタマゴ", "Œuf de Manaphy"},
				{"マリィ", "Rosemary"},
				{"ミカンのワザマシン01", "Jasmine"},
				{"ミカンのワザマシン02", "Jasmine"},
				{"ミチーナしんでん", "Michina"},
				{"モンスターボール", "Poké Ball"},
				{"モーモーミルク", "Lait Meumeu"},
				{"ヤナギのワザマシン01", "Frédo"},
				{"ヤナギのワザマシン02", "Frédo"},
				{"ヤーコン", "Bardane"},
				{"リーリエ", "Lilie (jeux vidéo)"},
				{"レッドの挑戦", "Red (jeux vidéo)"},
				{"ロイヤルマスク", "Professeur Euphorbe (jeux vidéo)"},
				{"ロケット団のいやがらせ", "Team Rocket (trio)"},
				{"ロケット団参上!", "Team Rocket (trio)"},
				{"ロトム図鑑", "Motisma-Dex"},
				{"ワタルのワザマシン01", "Peter (jeux vidéo)"},
				{"Ｒ団のワザマシン01", "Team Rocket (organisation)"}
		};

		while (page != null) {
			title = page.getTitle();
			String strippedTitle = title.replaceAll(" \\(.*\\)", "");

//			System.out.println(title + " // '" + strippedTitle + "'");

			String[] topics = {};
			boolean found = false;

			for (String singlePage : singlePages) {
				if (strippedTitle.equals(singlePage)) {
					topics = new String[] {singlePage, singlePage};
					found = true;
					break;
				}
			}
			if (!found) {
				for (String[] association : associations) {
					if (strippedTitle.equals(association[0])) {
						topics = association;
						found = true;
						break;
					}
				}
			}

			if (!found) {
				page = pageCollection.getNextPage();
				continue;
			}

			String contents = page.getContent();
			String originalContent = contents;
			String modificationType = "Ajout";

			for (int i = topics.length - 1; i > 0; i--) {
				String iString = "";
				if (i > 1) {
					iString = Integer.toString(i);
				}

				if (contents.contains("| sujet" + iString + "=")) {
					contents = contents.replaceAll("\\| sujet" + iString + "=[^\n]*", "| sujet" + iString + "=" + topics[i]);
					modificationType = "Modification";
				} else {
					contents = contents.replaceAll("(\\| nom=[^\n]*)", "$1\n| sujet" + iString + "=" + topics[i]);
				}
			}

//			System.out.println(contents);

			String editSummary = "";
			boolean firstTopic = false;
			for (int i = 1; i < topics.length; i++) {
				if (i == 1) {
					editSummary = modificationType + " du sujet [[" + topics[1] + "]]";
				} else if (i == topics.length - 1) {
					editSummary = editSummary + " et [[" + topics[i] + "]]";
				} else {
					editSummary = editSummary + ", [[" + topics[i] + "]]";
				}

				if (i == 2) {
					editSummary = editSummary.replace("du sujet", "des sujets");
				}
			}

			if (!contents.equals(originalContent)) {
				page.setContent(contents, editSummary);
				System.out.println(title + " ok");
			}

			if (justOne) {
				break;
			}

			page = pageCollection.getNextPage();
		}
	}
}
