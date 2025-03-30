package com.grotteazuree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class MewtwoBot {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = System.nanoTime();
		System.out.println("start");

		Login.login("Silvallié"); // à commenter
//		Login.login("Matt."); // à commenter
		// API.login(username, password);
		
		//sync();
		MewtwoBot bot = new MewtwoBot();
		bot.run();

		System.out.println("stop");
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000000;
		
		System.out.println("Execution time: " + Long.toString(duration / 60) + " min " + Long.toString(duration % 60) + " s");
	}


//	String pokepediaPath = "D:\\Poképédia\\";
	String pokepediaPath = "C:\\Users\\ueiht\\Poképédia\\";
	
	@SuppressWarnings("unused")
	public void run() throws IOException, InterruptedException {
		
//		File folderPath = new File(pokepediaPath + "Images\\RFVF\\ObjetsE\\");
//		File folderPath = new File(pokepediaPath + "Images\\HOME\\Pokémon Renders v3 - Copie\\no_metadata\\");
//		File folderPath = new File(pokepediaPath + "Images\\XY\\Vêtements\\");
//		File folderPath = new File(pokepediaPath + "Images\\EV\\Sprites EV DI chromatiques\\no_metadata\\");
//		File folderPath = new File(pokepediaPath + "Images\\CA\\25-05\\");
//		File folderPath = new File(pokepediaPath + "Images\\XD\\Capacités de Pokémon XD\\");
//		File folderPath = new File(pokepediaPath + "Images\\EV\\objets\\objetsOrdonnésRenommésFiltrés\\no_metadata");
//		File folderPath = new File(pokepediaPath + "Images\\Miniatures objets 1G 9G\\Miniatures objets (6G)\\Objets_XY_ROSA\\ROSA\\Inutilisés\\5G");
		
//		File folderPath = new File(pokepediaPath + "Découpes\\Résultats\\objetsHOME\\");
//
//		File folderPath = new File(pokepediaPath + "Robot\\JCC\\Extensions\\Écarlate et Violet Aventures Ensemble\\");
		File folderPath = new File(pokepediaPath + "Robot\\limitless_scraping\\Extensions\\Écarlate et Violet Aventures Ensemble\\");

		File listPath = new File(pokepediaPath + "Robot\\JCC\\description_upload.txt");
//		File listPath = new File(pokepediaPath + "Images\\EV\\CT\\VignettesCT.csv");
//		File listPath = new File(pokepediaPath + "Renommages NDEX\\changements.csv");
//		File listPath = new File(pokepediaPath + "Robot\\deletion_list.txt");
//		File listPath = new File(pokepediaPath + "Robot\\createSpriteRedirections\\N2B2.txt");
		
//		createSpriteRedirections(listPath, "NB.", "N2B2.", "Noir 2 et Blanc 2", false);
//		createSpriteRedirections(listPath, "SL.", "USUL.", "Ultra-Soleil et Ultra-Lune", false);
		
//		String[] titles = {"Fichier:Miniature 0710 Normale XY.png", "Fichier:Miniature 0711 Mini XY.png", "Fichier:Miniature 0710 Maxi XY.png", "Fichier:Miniature 0710 Ultra XY.png"};
//		for (String title : titles) {
//			Page page = new Page(title);
//			page.setContent("#REDIRECTION [[Fichier:Miniature 0710 XY.png]]\n\n[[Catégorie:Miniature Pokémon (X et Y)]]", "Catégorisation de la redirection");
//			System.out.println(title + " ok");
//		}
		
//		uploadAttacks(folderPath, "XD", "XD : Le Souffle des Ténèbres", true, true, false);
		
//		uploadArtworksWithDescription(pokepediaPath + "Images\\CM\\Artworks ReMix\\", false);
		
//		Login.login("Matt.");
//		API.delete("Fichier:Carte Pop Series 5 1.png");
		
//		uploadCards(folderPath, listPath, true);
//		uploadCards(folderPath, listPath, false);
		
//		uploadCT(folderPath, listPath, "EV", "Écarlate et Violet", false);

//		uploadFiles(folderPath, false);
		
//		uploadFilesWithDescriptions(folderPath, listPath, ".png", false, true);

//		File folderPath = new File(pokepediaPath + "Images\\GO\\Bonbons\\");
//		uploadCandies(folderPath, false);
		
//		eraseCategory("Miniature d'objet (Rubis et Saphir)", false);
//		eraseFiles(listPath, false);
		
//		uploadItems(folderPath, false);
//		uploadArtworks(folderPath, "CA", "Écarlate et Violet", true, false);
//		
//		uploadSprites(folderPath, "png", "Upload miniatures EV Le Disque Indigo", "", true, false, 0, false);
//		uploadSprites(folderPath, "png", "Upload empreintes LGPE", "Guide officiel japonais", false, false, 0, false);
//		uploadSprites(folderPath, "ogg", "Upload cris EV", "", false, false, 0, false);
//		uploadSprites(folderPath, "png", "Upload sprites GO", "PokeMiners", false, true, 0, false);
//		uploadSprites(folderPath, "png", "Upload Pokédex EV Le Masque Turquoise", "", false, false, 0, false);
//		uploadSprites(folderPath, "png", "Upload sprites chromatiques EV Le Disque Indigo", "Serebii", false, false, 0, false);
		
//		addDex("Myrtille", false, false);
		
//		deleteDuplicateFiles(false);
		
		int[] namespaces = new int[] {6};
//		rename("Icône", "Portrait", namespaces, "Icône Pokémon chromatique (Café ReMix)", null, true, false);
//		rename("Icône", "Portrait", namespaces, "Ancienne version d'icône Pokémon (Café ReMix)", null, true, false);
//		rename("Icône", "Portrait", namespaces, "Ancienne version d'icône Pokémon chromatique (Café ReMix)", null, true, false);
//		rename("NB2", "N2B2", namespaces, "Miniature Pokémon (Rubis et Saphir)", "Fichier:Miniature 0313 RS.gif", false, false);
//		rename("NB2", "N2B2", namespaces, "Miniature Pokémon (Rouge Feu et Vert Feuille)", null, false, false);
//		rename("NB2", "N2B2", namespaces, "Miniature Pokémon (Émeraude)", null, false, false);
//		rename("NB2", "N2B2", namespaces, "Miniature Pokémon (Diamant et Perle)", null, false, false);
//		rename("NB2", "N2B2", namespaces, "Miniature Pokémon (Platine)", null, false, false);
//		rename("NB2", "N2B2", namespaces, "Miniature Pokémon (Noir et Blanc)", null, false, false);
//		rename("RBJ", "J", namespaces, "Image de capacité de Pokémon Jaune", null, true, false);

//		createRedirections("δ", "Delta", namespaces, "Carte Pokémon ☆", null, false);
		
//		API.rename("Fichier:Carte Promo SV SV001.png", "Fichier:Carte Promo SV SV001.png", false, "Test");
//		
		String[] pageList = {"Fichier:Bonbon Armure L.png", "Fichier:Bonbon Armure M.png", "Fichier:Bonbon Armure S.png", "Fichier:Bonbon Bleu LGPE.png", "Fichier:Bonbon Esprit L.png", "Fichier:Bonbon Esprit M.png", "Fichier:Bonbon Esprit S.png", "Fichier:Bonbon Force L.png", "Fichier:Bonbon Force M.png", "Fichier:Bonbon Force S.png", "Fichier:Bonbon Jaune LGPE.png", "Fichier:Bonbon Machoc LGPE.png", "Fichier:Bonbon Marron LGPE.png", "Fichier:Bonbon Mélofée LGPE.png", "Fichier:Bonbon Mental L.png", "Fichier:Bonbon Mental M.png", "Fichier:Bonbon Mental S.png", "Fichier:Bonbon Otaria LGPE.png", "Fichier:Bonbon Ronflex LGPE.png", "Fichier:Bonbon Salamèche LGPE.png", "Fichier:Bonbon Santé L.png", "Fichier:Bonbon Santé M.png", "Fichier:Bonbon Santé S.png", "Fichier:Bonbon Sprint L.png", "Fichier:Bonbon Sprint M.png", "Fichier:Bonbon Sprint S.png", "Fichier:Bonbon Vert LGPE.png", "Fichier:Bonbon Violet LGPE.png", "Fichier:Bonbon Amonita LGPE.png", "Fichier:Bonbon Artikodin LGPE.png", "Fichier:Bonbon Carapuce LGPE.png", "Fichier:Bonbon Hypotrempe LGPE.png", "Fichier:Bonbon Kokiyas LGPE.png", "Fichier:Bonbon Lokhlass LGPE.png", "Fichier:Bonbon Minidraco LGPE.png", "Fichier:Bonbon Mystherbe LGPE.png", "Fichier:Bonbon Ptitard LGPE.png", "Fichier:Bonbon Saquedeneu LGPE.png", "Fichier:Bonbon Tentacool LGPE.png", "Fichier:Bonbon Abra LGPE.png", "Fichier:Bonbon Chétiflor LGPE.png", "Fichier:Bonbon Férosinge LGPE.png", "Fichier:Bonbon Miaouss LGPE.png", "Fichier:Bonbon Pikachu LGPE.png", "Fichier:Bonbon Ponyta LGPE.png", "Fichier:Bonbon Psykokwak LGPE.png", "Fichier:Bonbon Sabelette LGPE.png", "Fichier:Bonbon Soporifik LGPE.png", "Fichier:Bonbon Stari LGPE.png", "Fichier:Bonbon Électhor LGPE.png", "Fichier:Bonbon Élektek LGPE.png", "Fichier:Bonbon Magnéti LGPE.png", "Fichier:Bonbon Meltan LGPE.png", "Fichier:Bonbon Onix LGPE.png", "Fichier:Bonbon Ptéra LGPE.png", "Fichier:Bonbon Racaillou LGPE.png", "Fichier:Bonbon Rhinocorne LGPE.png", "Fichier:Bonbon Aspicot LGPE.png", "Fichier:Bonbon Canarticho LGPE.png", "Fichier:Bonbon Doduo LGPE.png", "Fichier:Bonbon Kabuto LGPE.png", "Fichier:Bonbon Kangourex LGPE.png", "Fichier:Bonbon Kicklee LGPE.png", "Fichier:Bonbon Osselait LGPE.png", "Fichier:Bonbon Piafabec LGPE.png", "Fichier:Bonbon Roucool LGPE.png", "Fichier:Bonbon Scarabrute LGPE.png", "Fichier:Bonbon Taupiqueur LGPE.png", "Fichier:Bonbon Tauros LGPE.png", "Fichier:Bonbon Tygnon LGPE.png", "Fichier:Bonbon Évoli LGPE.png", "Fichier:Bonbon Excelangue LGPE.png", "Fichier:Bonbon Leveinard LGPE.png", "Fichier:Bonbon M. Mime LGPE.png", "Fichier:Bonbon Mew LGPE.png", "Fichier:Bonbon Métamorph LGPE.png", "Fichier:Bonbon Noeunoeuf LGPE.png", "Fichier:Bonbon Ramoloss LGPE.png", "Fichier:Bonbon Rondoudou LGPE.png", "Fichier:Bonbon Nidoran♀ LGPE.png", "Fichier:Bonbon Poissirène LGPE.png", "Fichier:Bonbon Caninos LGPE.png", "Fichier:Bonbon Goupix LGPE.png", "Fichier:Bonbon Krabby LGPE.png", "Fichier:Bonbon Magicarpe LGPE.png", "Fichier:Bonbon Magmar LGPE.png", "Fichier:Bonbon Paras LGPE.png", "Fichier:Bonbon Porygon LGPE.png", "Fichier:Bonbon Sulfura LGPE.png", "Fichier:Bonbon Voltorbe LGPE.png", "Fichier:Bonbon Bulbizarre LGPE.png", "Fichier:Bonbon Chenipan LGPE.png", "Fichier:Bonbon Insécateur LGPE.png", "Fichier:Bonbon Abo LGPE.png", "Fichier:Bonbon Fantominus LGPE.png", "Fichier:Bonbon Lippoutou LGPE.png", "Fichier:Bonbon Mewtwo LGPE.png", "Fichier:Bonbon Mimitoss LGPE.png", "Fichier:Bonbon Nidoran♂ LGPE.png", "Fichier:Bonbon Nosferapti LGPE.png", "Fichier:Bonbon Rattata LGPE.png", "Fichier:Bonbon Smogo LGPE.png", "Fichier:Bonbon Tadmorv LGPE.png"};
		
//		int[] namespaces = {API.NS_FILES};
//		boolean isDone = false;
//		while (!isDone) {
//			isDone = renameDoubleRedirections("pdm2", "PDMTO", pageList, null, true, false);
////			isDone = rename("", "", namespaces, "Capture d'écran de Pokémon Donjon Mystère : Explorateurs du Temps et de l'Ombre", null, true, false);
//			System.out.println("\n***** ON HOLD *****\n");
//			TimeUnit.SECONDS.sleep(10);
//		}
		
//		Login.login("Matt.");
//		for (String s : pageList) {
//			API.delete(s, "[Auto] Remplacement par des fichiers et redirections qui suivent la nomenclature");
//		}
		
//		String[][] pageList = {{"Fichier:Cap ecran Forêt Pureté pdm.png", "Fichier:Cap ecran Forêt Pureté PDMRB.png"}, {"Fichier:Cap ecran Forêt Pureté localisation pdm.png", "Fichier:Cap ecran Forêt Pureté localisation PDMRB.png"}, {"Fichier:Cap ecran Forêt Givrée pdm.png", "Fichier:Cap ecran Forêt Givrée PDMRB.png"}, {"Fichier:Cap ecran Forêt Givrée localisation pdm.png", "Fichier:Cap ecran Forêt Givrée localisation PDMRB.png"}, {"Fichier:Cap ecran etang barbicha pdm.png", "Fichier:Cap ecran etang barbicha PDMRB.png"}, {"Fichier:Cap ecran Erg Sans Fin pdm.png", "Fichier:Cap ecran Erg Sans Fin PDMRB.png"}, {"Fichier:Cap ecran Erg Sans Fin localisation pdm.png", "Fichier:Cap ecran Erg Sans Fin localisation PDMRB.png"}, {"Fichier:Cap ecran Eau Merveilleuse pdm.png", "Fichier:Cap ecran Eau Merveilleuse PDMRB.png"}, {"Fichier:Cap ecran Eau Merveilleuse localisation pdm.png", "Fichier:Cap ecran Eau Merveilleuse localisation PDMRB.png"}, {"Fichier:Cap ecran Donjon Inconnu pdm.png", "Fichier:Cap ecran Donjon Inconnu PDMRB.png"}, {"Fichier:Cap ecran Colline Dragon pdm.png", "Fichier:Cap ecran Colline Dragon PDMRB.png"}, {"Fichier:Cap ecran Colline Dragon localisation pdm.png", "Fichier:Cap ecran Colline Dragon localisation PDMRB.png"}, {"Fichier:Cap ecran Caverne Australe pdm.png", "Fichier:Cap ecran Caverne Australe PDMRB.png"}, {"Fichier:Cap ecran Caverne Australe localisation pdm.png", "Fichier:Cap ecran Caverne Australe localisation PDMRB.png"}, {"Fichier:Cap ecran Canal Fantaisie pdm.png", "Fichier:Cap ecran Canal Fantaisie PDMRB.png"}, {"Fichier:Cap ecran Canal Fantaisie localisation pdm.png", "Fichier:Cap ecran Canal Fantaisie localisation PDMRB.png"}, {"Fichier:Cap ecran Bois Sinistre pdm.png", "Fichier:Cap ecran Bois Sinistre PDMRB.png"}, {"Fichier:Cap ecran Bois Sinistre localisation pdm.png", "Fichier:Cap ecran Bois Sinistre localisation PDMRB.png"}, {"Fichier:Cap ecran Bois Sinistre 4 pdm.png", "Fichier:Cap ecran Bois Sinistre 4 PDMRB.png"}, {"Fichier:Cap ecran Bois Sinistre 3 pdm.png", "Fichier:Cap ecran Bois Sinistre 3 PDMRB.png"}, {"Fichier:Cap ecran Bassin Cascade pdm.png", "Fichier:Cap ecran Bassin Cascade PDMRB.png"}, {"Fichier:Cap ecran Bassin Cascade localisation pdm.png", "Fichier:Cap ecran Bassin Cascade localisation PDMRB.png"}, {"Fichier:Cap ecran Base Équipe pdm.png", "Fichier:Cap ecran Base Équipe PDMRB.png"}, {"Fichier:Cap ecran Base Équipe localisation pdm.png", "Fichier:Cap ecran Base Équipe localisation PDMRB.png"}, {"Fichier:Cap ecran banque felicite pdm.png", "Fichier:Cap ecran banque felicite PDMRB.png"}, {"Fichier:Voeu de Jirachi Plus de force PDM.png", "Fichier:Voeu de Jirachi Plus de force PDMRB.png"}, {"Fichier:Voeu de Jirachi Plein d'objets PDM.png", "Fichier:Voeu de Jirachi Plein d'objets PDMRB.png"}, {"Fichier:Voeu de Jirachi beaucoup d'argent PDM.png", "Fichier:Voeu de Jirachi beaucoup d'argent PDMRB.png"}, {"Fichier:Carte PDM.png", "Fichier:Carte PDMRB.png"}, {"Fichier:Carte Alternative PDM.png", "Fichier:Carte Alternative PDMRB.png"}};
//		for (String[] item : pageList) {
//			String item0 = item[0];
//			String item1 = item[1];
//			Page page = new Page(item[0]);
//			page.setContent("#REDIRECTION [[" + item1 + "]]", "Création de la redirection vers le fichier déplacé");
//			System.out.println(item0 + " ok");
//			TimeUnit.SECONDS.sleep(3);
//		}
//		
//		refactor("Shifours (Mille Poings)-EB.png", "Shifours (Style Mille Poings)-EB.png", listPath);
//		addCategory();
		
//		uploadCardArticles(folderPath, false, false);
//		addCardTopics(null, false);
//		addRequestTables(null, false);
//		addFormattedNames(null, false);
		addSecondaryTopics(null, true, false);
		
//		String[] titles = {};
//		addSecondaryTopicsSections(titles, true);
		
		String outputPath = pokepediaPath + "Robot\\cards_special_name.txt";
		getSpecialCardNames(null, outputPath, true, false);
		
//		String outputPath = pokepediaPath + "Robot\\card_article.txt";
//		convertCardArticle(null, outputPath, false, true);
		
//		String outputPath = pokepediaPath + "Robot\\dumps\\card_articles_converted\\";
//		backUpArticles(null, outputPath);
		
		
		String[] gamesNames = {"EB"};
//		String[] avoidList = {};
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
//		generateGeneralItemRedirections(gamesNames, avoidList, false, false);
//		createFootprintsRedirections(false);

		
		
//		deployModuleRepresentationsAnterieures(true, false);
		
//		postMissingAttackImagesTable(pokepediaPath + "Robot\\dumps\\tabledump.txt", true);
		
//		updateCycles(pokepediaPath + "Robot\\cycles_list.txt", 1040, false);
			
//		fullUpdateLocations();
		
//		renameNDEX(listPath);
		
	}
	
	public void fullUpdateLocations() throws IOException {
		dumpContentFromPages(false);
		pythonLocDataConverter();
		uploadLocations(false);
		
	}
	
	
	public void savePage(String path, Page page) throws IOException {
		String pageName = page.getTitle();
		String pageSave = pageName.replace(":", "-");
		
		Path saveFilePath = Path.of(path + pageSave + ".txt");			
		String pageContent = page.getContent();
		
		Files.writeString(saveFilePath, pageContent);
		System.out.println(pageName + " dump ok");
	}
	
	public void dumpContentFromPages(boolean justOne) throws IOException {

		String[] categoryNames = new String[] {"Page avec un module Tableau Pokémon"};
//		String[] moreArticles = new String[] {"Pokémon mouvant", "Monde Distorsion", "Réserve Naturelle", "Pokémon Rubis Oméga et Saphir Alpha : Version démo spéciale", "Expédition Dynamax", "Quête des Taupiqueur d'Alola"};
		String path = pokepediaPath + "Robot\\dumps\\locdump\\";
		List<PageCollection> pageCollections = new ArrayList<>();
		for(int i=0; i<categoryNames.length; i++) {
			
			PageCollection pageCollection = new PageCollection(
					new int[] {API.NS_MAIN},
					API.FILTER_NONREDIRECTS,
					categoryNames[i]
				);
			pageCollections.add(pageCollection);
			System.out.println(categoryNames[i] + " category dump ok");
		}
		

		
		System.out.println("\n********\nFILEDUMP\n********\n");
		

		
		int counter = 0;
		for(PageCollection pageCollection : pageCollections) {
			Page page = pageCollection.getNextPage();
	
			while(page!=null) {
				
				savePage(path, page);
				
				if (justOne) {
					break;
				}
				
				page = pageCollection.getNextPage();
			}
			System.out.println("\n********\nCategory " + categoryNames[counter] + " ok\n********\n");
			counter++;
		}
//		for(String article : moreArticles) {
//			Page page = new Page(article);
//			savePage(path, page);
//		}
		System.out.println("\n********\nBonus pages ok\n********\n");
		
	}
	
	public void pythonLocDataConverter() throws IOException {
		Process p = Runtime.getRuntime().exec("python " + pokepediaPath + "Robot\\locdata_converter.py\"");
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
		    System.out.println(line);
		}
	}
	
	@SuppressWarnings("resource")
	public void uploadLocations(boolean justOne) throws IOException {
		File folderPath = new File(pokepediaPath + "Robot\\dumps\\locdump_converted\\");

		File contents[] = folderPath.listFiles();
		
		
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].getName();
			contentString = contentString.replace("_", ":");
			contentString = contentString.replace(".txt", "");
			String uploadName		= "Module:Localisations/Données/" + contentString;
			
			Page filePage = new Page(uploadName);
			

			FileReader		fr		= new FileReader(contents[i]);
			BufferedReader	br		= new BufferedReader(fr);
			String			currentLine			= br.readLine();
			String 			locations = "";
			
			while (currentLine != null) {
				locations		+= currentLine + "\n";
				currentLine		= br.readLine();
			}
			currentLine		= br.readLine();
			
			Page page = new Page(uploadName);
			page.setContent(locations, "Mise à jour des localisations");
			System.out.println(uploadName + " ok");
			
			if (justOne) {
				break;
			}
		}
	}

	public void uploadFiles(File folderPath, boolean justOne) {
		
		File contents[] = folderPath.listFiles();
		
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			String pokeName			= contents[i].getName().replaceAll(" \\(.*", "");
			pokeName = pokeName.replaceAll("-CA[^\n]*.png", "");
			pokeName = pokeName.replaceAll("Type-0", "Type:0");
			String categoryName = pokeName;
			pokeName = pokeName.replaceAll("Zarbi[^\n]*", "Zarbi");
			
			uploadName = uploadName.replace("Type-0", "Type:0");

			String descriptionHeader = "== Description ==\n\n";
			String description = "Corporate Art " + Util.de(pokeName) + "[[" + pokeName + "]].\n\n{{Informations Fichier\n"
					+ "| Source = [https://archives.bulbagarden.net/w/index.php/Category:Pokémon_Dream_World_artwork Bulbapedia], [https://www.wikidex.net/wiki/WikiDex:Proyecto_Pokédex/Ilustraciones_de_Pokémon_en_el_Dream_World Wikidex]\n"
					+ "| Auteur = [[The Pokémon Company]]\n"
					+ "}}\n\n[[Catégorie:Corporate Art de Pokémon]]\n[[Catégorie:Image Pokémon représentant " + categoryName + "]]";
//			String description = "Détourage des localisations EV";
//			String description = "Sprite du vêtement " + uploadName.replace("Fichier:Sprite ", "").replace(" XY.png", "")
//					+ " dans {{Jeu|XY}}.\n\n[[Catégorie:Sprite de vêtement (X et Y)]]";
//			description = description.replace("♂", "(masculin)").replace("♀", "(féminin)");
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				boolean uploaded = API.upload(uploadName, contents[i], descriptionHeader + description, description);

				Page filePage = new Page(uploadName);
				filePage.setContent(descriptionHeader + description, description);
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void renameNDEX(File listPath) throws IOException {
		FileReader		fr					= new FileReader(listPath);
		BufferedReader	br					= new BufferedReader(fr);
		
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
	}
	
	public void uploadCandies(File folderPath, boolean justOne) {
		
		File contents[] = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";
				
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				String pokemon			= uploadName.replace("Fichier:Sprite Bonbon ", "").replace(" GO.png", "");
				String ndex				= Integer.toString(PokeData.getPokemonNum(pokemon));
				ndex = "0".repeat(3 - ndex.length()) + ndex;
				String description = "[[Bonbon#Pokémon GO|Bonbon]] [[" + pokemon + "]] dans {{Jeu|GO}}.\n"
						+ "\n"
						+ "{{Informations Fichier\n"
						+ "| Source = [https://pokemongo.fandom.com/wiki/Category:Candy_assets Pokémon GO Wiki]\n"
						+ "| Auteur = [[Niantic]]\n"
						+ "}}\n"
						+ "\n"
						+ "[[Catégorie:Sprite de Bonbon (GO)|" + ndex + "]]";
				
				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i], descriptionHeader + description,
						description);
//						"Correction du fichier");
//						"Suppression des métadonnées");
				
				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
				page.setContent(descriptionHeader + description, description);
				
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadItems(File folderPath, boolean justOne) {
		File contents[] = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";
				
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				// Computing the games names from the item title
				String[] uploadNameSplit = uploadName.split(" ");
				String gamesShortName = uploadNameSplit[uploadNameSplit.length - 1];
				gamesShortName = gamesShortName.substring(0, gamesShortName.length()-4);
				String gamesLongName = Util.gamesShortToGamesLong(gamesShortName);
				
				String itemName = uploadName.replace("Fichier:Miniature ", "").replace(" " + gamesShortName + ".png", "");
				String suffixItemName = "";
				String suffixItemName2 = "";
				
				// Reworking the item name if needed
				if (itemName.contains(" (tenu)")) {
					itemName = itemName.replace(" (tenu)", "");
					suffixItemName2 = suffixItemName2 + " (tenu)";
				}
				if (itemName.contains(" (inutilisé)")) {
					itemName = itemName.replace(" (inutilisé)", "");
					suffixItemName2 = suffixItemName2 + " (inutilisé)";
				}
				
				if (itemName.substring(0, 2).equals("CT") || itemName.substring(0, 2).equals("CS") || itemName.substring(0, 2).equals("DT")) {
					String ctcsdt = itemName.substring(0, 2);
					String type = itemName.substring(3);
					itemName = ctcsdt + "]] [[" + type + " (type)|" + type;
				}
				
//				if (!itemName.contains("Œ")) {
//					continue;
//				}

				
				// Items that have special links
				if (itemName.length() > 15 && itemName.substring(0, 15).equals("Lettre Végétale")) {
					String letter = itemName.substring(0, 15);
					String pokemon = itemName.substring(15);
					itemName = letter;
					suffixItemName = suffixItemName + pokemon;
				}
				if (itemName.length() > 14 && itemName.substring(0, 14).equals("Malle Penderie")) {
					String malle = itemName.substring(0, 14);
					String color = itemName.substring(14);
					itemName = malle;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 12 && itemName.substring(0, 12).equals("Moticyclette")) {
					String bike = itemName.substring(0, 12);
					String color = itemName.substring(12);
					itemName = bike;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 10 && itemName.substring(0, 10).equals("Bicyclette")) {
					String bike = itemName.substring(0, 10);
					String color = itemName.substring(10);
					itemName = bike;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 7 && itemName.substring(0, 7).equals("Holokit")) {
					String holokit = itemName.substring(0, 7);
					String color = itemName.substring(7);
					itemName = holokit;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 9 && itemName.substring(0, 9).equals("Météorite")) {
					String meteorite = itemName.substring(0, 9);
					String color = itemName.substring(9);
					itemName = meteorite;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.length() > 5 && itemName.substring(0, 5).equals("Vokit")) {
					String vokit = itemName.substring(0, 5);
					String color = itemName.substring(5);
					itemName = vokit;
					suffixItemName = suffixItemName + color;
				}
				if (itemName.equals("Œuf (objet)")) {
					itemName = "Œuf";
				}
				
				// Homonymies
				String itemNameHomonymy = Util.addHomonymy(itemName, gamesShortName);
				if (!itemName.equals(itemNameHomonymy)) {
					itemName = itemNameHomonymy + "|" + itemName;
				}
				String itemLink = "[[" + itemName + "]]";
				
				// Computing the description of the file
				String description = "Miniature de l'objet " + itemLink + suffixItemName + suffixItemName2 + " dans {{Jeu|" + gamesShortName + "}}."
						+ "\n\n{{Informations Fichier\n"
						+ "| Source = Extraction réalisée par {{Ut|SombrAbsol}}.\n"
						+ "| Auteur = " + Util.gamesShortToEditor(gamesShortName) + "\n"
						+ "}}"
						+ "\n\n[[Catégorie:Miniature d'objet (" + gamesLongName + ")]]";
				
				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i], descriptionHeader + description,
						description);
				
//						"Correction du fichier");
//						"Suppression des métadonnées");
				
				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
				page.setContent(descriptionHeader + description, description);
				
//				boolean uploaded = false;
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
//				System.out.println(description);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	// gamesLongName : Écarlate et Violet
	public void uploadArtworks(File folderPath, String gamesShortName, String gamesLongName, boolean generalArtworkRedirection, boolean justOne) {
		File contents[] = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";
				
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			String uploadNameGame	= uploadName.replace(".png", "-" + gamesShortName + ".png");
			// System.out.println(uploadName + "\t" + uploadNameGame);
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				String pokeName = uploadName.replace("Fichier:", "").replace(".png", "");
				String form = pokeName.replaceAll("[^\\(]*(?<a> \\(.*)", "$1");
				// System.out.println(form);
				if (form.equals(pokeName)) {
					form = "";
				}
				pokeName = pokeName.replaceAll(" \\((?<a>[^\\)]*)\\)", "");
				
				
				String description = "Artwork " + Util.de(pokeName) + "[[" + pokeName + "]]" + form + " pour {{Jeu|" + gamesShortName
						+ "}}.\n\n{{Informations Fichier\n"
						+ "| Source = [https://zukan.pokemon.co.jp/ Site du Pokédex japonais]\n"
						+ "| Auteur = [[The Pokémon Company]]\n"
						+ "}}\n\n[[Catégorie:Artwork Pokémon " + Util.de(gamesLongName) + gamesLongName + "]]\n"
						+ "[[Catégorie:Image Pokémon représentant " + pokeName + "]]";
				
				boolean uploaded = API.upload(uploadNameGame, contents[i], descriptionHeader + description,
						description);
//						"Correction du fichier");
//						"Suppression des métadonnées");
				
				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadNameGame);
				page.setContent(descriptionHeader + description, description);
				
				
				// Redirection artwork général
				if (generalArtworkRedirection) {
					Page redirectionPage = new Page(uploadName);
					redirectionPage.setContent("#REDIRECTION [[" + uploadNameGame + "]]\n[[Catégorie:Artwork Pokémon]]", "Redirection vers [[" + uploadNameGame + "]]");
				}
				
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadArtworksWithDescription(String path, boolean justOne) {
		String[][] replacementsList = {{"Léa-CM.png", "[[Léa (Pokémon Café ReMix)|Léa]]", "Image de Léa", "Artwork personnage (Café ReMix)"}, {"Léa (Rouge classique)-CM.png", "[[Léa (Pokémon Café ReMix)|Léa]] (Rouge classique)", "Image de Léa", "Artwork personnage (Café ReMix)"}, {"Léa (Halloween)-CM.png", "[[Léa (Pokémon Café ReMix)|Léa]] (Halloween)", "Image de Léa", "Artwork personnage (Café ReMix)"}, {"Bulbizarre-CM.png", "[[Bulbizarre]]", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon de Café ReMix"}, {"Bulbizarre chromatique-CM.png", "[[Bulbizarre]] [[chromatique]]", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon chromatique de Café ReMix"}, {"Bulbizarre chromatique (Troisième anniversaire)-CM.png", "[[Bulbizarre]] [[chromatique]] (Troisième anniversaire)", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Bulbizarre chromatique (Couronne de fête)-CM.png", "[[Bulbizarre]] [[chromatique]] (Couronne de fête)", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Bulbizarre chromatique (Rouge classique)-CM.png", "[[Bulbizarre]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Bulbizarre (Troisième anniversaire)-CM.png", "[[Bulbizarre]] (Troisième anniversaire)", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Bulbizarre (Couronne de fête)-CM.png", "[[Bulbizarre]] (Couronne de fête)", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Bulbizarre (Rouge classique)-CM.png", "[[Bulbizarre]] (Rouge classique)", "Image Pokémon représentant Bulbizarre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Salamèche-CM.png", "[[Salamèche]]", "Image Pokémon représentant Salamèche", "Artwork Pokémon de Café ReMix"}, {"Salamèche (Troisième anniversaire)-CM.png", "[[Salamèche]] (Troisième anniversaire)", "Image Pokémon représentant Salamèche", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Salamèche (DJ)-CM.png", "[[Salamèche]] (DJ)", "Image Pokémon représentant Salamèche", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Salamèche (Rouge classique)-CM.png", "[[Salamèche]] (Rouge classique)", "Image Pokémon représentant Salamèche", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dracaufeu-CM.png", "[[Dracaufeu]]", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon de Café ReMix"}, {"Dracaufeu chromatique-CM.png", "[[Dracaufeu]] [[chromatique]]", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon chromatique de Café ReMix"}, {"Dracaufeu chromatique (Peintre chocolatier) (2)-CM.png", "[[Dracaufeu]] [[chromatique]] (Peintre chocolatier)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Dracaufeu chromatique (Peintre chocolatier) (3)-CM.png", "[[Dracaufeu]] [[chromatique]] (Peintre chocolatier)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Dracaufeu chromatique (Peintre chocolatier)-CM.png", "[[Dracaufeu]] [[chromatique]] (Peintre chocolatier)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Dracaufeu chromatique (Rouge classique)-CM.png", "[[Dracaufeu]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Dracaufeu (Peintre chocolatier) (2)-CM.png", "[[Dracaufeu]] (Peintre chocolatier)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dracaufeu (Peintre chocolatier) (3)-CM.png", "[[Dracaufeu]] (Peintre chocolatier)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dracaufeu (Peintre chocolatier)-CM.png", "[[Dracaufeu]] (Peintre chocolatier)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dracaufeu (Rouge classique)-CM.png", "[[Dracaufeu]] (Rouge classique)", "Image Pokémon représentant Dracaufeu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Carapuce-CM.png", "[[Carapuce]]", "Image Pokémon représentant Carapuce", "Artwork Pokémon de Café ReMix"}, {"Carapuce chromatique-CM.png", "[[Carapuce]] [[chromatique]]", "Image Pokémon représentant Carapuce", "Artwork Pokémon chromatique de Café ReMix"}, {"Carapuce chromatique (Imperméable à pois)-CM.png", "[[Carapuce]] [[chromatique]] (Imperméable à pois)", "Image Pokémon représentant Carapuce", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Carapuce chromatique (Chapeau Carapace)-CM.png", "[[Carapuce]] [[chromatique]] (Chapeau Carapace)", "Image Pokémon représentant Carapuce", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Carapuce chromatique (Troisième anniversaire)-CM.png", "[[Carapuce]] [[chromatique]] (Troisième anniversaire)", "Image Pokémon représentant Carapuce", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Carapuce chromatique (Rouge classique)-CM.png", "[[Carapuce]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Carapuce", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Carapuce (Imperméable à pois)-CM.png", "[[Carapuce]] (Imperméable à pois)", "Image Pokémon représentant Carapuce", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Carapuce (Chapeau Carapace)-CM.png", "[[Carapuce]] (Chapeau Carapace)", "Image Pokémon représentant Carapuce", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Carapuce (Troisième anniversaire)-CM.png", "[[Carapuce]] (Troisième anniversaire)", "Image Pokémon représentant Carapuce", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Carapuce (Rouge classique)-CM.png", "[[Carapuce]] (Rouge classique)", "Image Pokémon représentant Carapuce", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle-CM.png", "Pikachu mâle", "Image Pokémon représentant Pikachu", "Artwork Pokémon de Café ReMix"}, {"Pikachu mâle (Agriculteur)-CM.png", "[[Pikachu mâle]] (Agriculteur)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (« Sweets »)-CM.png", "[[Pikachu mâle]] (« Sweets »)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Hakama 2022)-CM.png", "[[Pikachu mâle]] (Hakama 2022)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Robe de fête)-CM.png", "[[Pikachu mâle]] (Robe de fête)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Smoking de fête)-CM.png", "[[Pikachu mâle]] (Smoking de fête)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Fan de Ronflex)-CM.png", "[[Pikachu mâle]] (Fan de Ronflex)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Casquette de détective)-CM.png", "[[Pikachu mâle]] (Casquette de détective)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Chef)-CM.png", "[[Pikachu mâle]] (Chef)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Super chef)-CM.png", "[[Pikachu mâle]] (Super chef)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Cadre fleuri)-CM.png", "[[Pikachu mâle]] (Cadre fleuri)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle-CM.png", "Pikachu femelle", "Image Pokémon représentant Pikachu", "Artwork Pokémon de Café ReMix"}, {"Pikachu femelle (Agriculteur)-CM.png", "[[Pikachu femelle]] (Agriculteur)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (« Sweets »)-CM.png", "[[Pikachu femelle]] (« Sweets »)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Hakama 2022)-CM.png", "[[Pikachu femelle]] (Hakama 2022)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Robe de fête)-CM.png", "[[Pikachu femelle]] (Robe de fête)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Smoking de fête)-CM.png", "[[Pikachu femelle]] (Smoking de fête)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Fan de Ronflex)-CM.png", "[[Pikachu femelle]] (Fan de Ronflex)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Casquette de détective)-CM.png", "[[Pikachu femelle]] (Casquette de détective)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Chef)-CM.png", "[[Pikachu femelle]] (Chef)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Super chef)-CM.png", "[[Pikachu femelle]] (Super chef)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Cadre fleuri)-CM.png", "[[Pikachu femelle]] (Cadre fleuri)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu femelle (Rouge classique)-CM.png", "[[Pikachu femelle]] (Rouge classique)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pikachu mâle (Rouge classique)-CM.png", "[[Pikachu mâle]] (Rouge classique)", "Image Pokémon représentant Pikachu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Raichu d'Alola-CM.png", "[[Raichu d'Alola]]", "Image Pokémon représentant Raichu d'Alola", "Artwork Pokémon de Café ReMix"}, {"Raichu d'Alola (Rouge classique)-CM.png", "[[Raichu d'Alola]] (Rouge classique)", "Image Pokémon représentant Raichu d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix-CM.png", "[[Goupix]]", "Image Pokémon représentant Goupix", "Artwork Pokémon de Café ReMix"}, {"Goupix d'Alola-CM.png", "[[Goupix d'Alola]]", "Image Pokémon représentant Goupix d'Alola", "Artwork Pokémon de Café ReMix"}, {"Goupix d'Alola (Cape d'hiver)-CM.png", "[[Goupix d'Alola]] (Cape d'hiver)", "Image Pokémon représentant Goupix d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix d'Alola (Ensemble fleuri)-CM.png", "[[Goupix d'Alola]] (Ensemble fleuri)", "Image Pokémon représentant Goupix d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix d'Alola (Rouge classique)-CM.png", "[[Goupix d'Alola]] (Rouge classique)", "Image Pokémon représentant Goupix d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix (Cape d'hiver)-CM.png", "[[Goupix]] (Cape d'hiver)", "Image Pokémon représentant Goupix", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix (Pique-nique savoureux) (2)-CM.png", "[[Goupix]] (Pique-nique savoureux)", "Image Pokémon représentant Goupix", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix (Pique-nique savoureux) (3)-CM.png", "[[Goupix]] (Pique-nique savoureux)", "Image Pokémon représentant Goupix", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix (Pique-nique savoureux)-CM.png", "[[Goupix]] (Pique-nique savoureux)", "Image Pokémon représentant Goupix", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goupix (Rouge classique)-CM.png", "[[Goupix]] (Rouge classique)", "Image Pokémon représentant Goupix", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Feunard d'Alola-CM.png", "[[Feunard d'Alola]]", "Image Pokémon représentant Feunard d'Alola", "Artwork Pokémon de Café ReMix"}, {"Feunard d'Alola (Déguisement festif) (2)-CM.png", "[[Feunard d'Alola]] (Déguisement festif)", "Image Pokémon représentant Feunard d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Feunard d'Alola (Déguisement festif)-CM.png", "[[Feunard d'Alola]] (Déguisement festif)", "Image Pokémon représentant Feunard d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Feunard d'Alola (Rouge classique)-CM.png", "[[Feunard d'Alola]] (Rouge classique)", "Image Pokémon représentant Feunard d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Rondoudou-CM.png", "[[Rondoudou]]", "Image Pokémon représentant Rondoudou", "Artwork Pokémon de Café ReMix"}, {"Rondoudou chromatique-CM.png", "[[Rondoudou]] [[chromatique]]", "Image Pokémon représentant Rondoudou", "Artwork Pokémon chromatique de Café ReMix"}, {"Rondoudou chromatique (Déguisement festif)-CM.png", "[[Rondoudou]] [[chromatique]] (Déguisement festif)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Rondoudou chromatique (Ballons flottants)-CM.png", "[[Rondoudou]] [[chromatique]] (Ballons flottants)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Rondoudou chromatique (Vacances d'été)-CM.png", "[[Rondoudou]] [[chromatique]] (Vacances d'été)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Rondoudou chromatique (Rouge classique)-CM.png", "[[Rondoudou]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Rondoudou (Déguisement festif)-CM.png", "[[Rondoudou]] (Déguisement festif)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Rondoudou (Ballons flottants)-CM.png", "[[Rondoudou]] (Ballons flottants)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Rondoudou (Vacances d'été)-CM.png", "[[Rondoudou]] (Vacances d'été)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Rondoudou (Rouge classique)-CM.png", "[[Rondoudou]] (Rouge classique)", "Image Pokémon représentant Rondoudou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Miaouss-CM.png", "[[Miaouss]]", "Image Pokémon représentant Miaouss", "Artwork Pokémon de Café ReMix"}, {"Miaouss (Hakama 2022)-CM.png", "[[Miaouss]] (Hakama 2022)", "Image Pokémon représentant Miaouss", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Miaouss (Pelotes espiègles)-CM.png", "[[Miaouss]] (Pelotes espiègles)", "Image Pokémon représentant Miaouss", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Miaouss (Rouge classique)-CM.png", "[[Miaouss]] (Rouge classique)", "Image Pokémon représentant Miaouss", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Psykokwak-CM.png", "[[Psykokwak]]", "Image Pokémon représentant Psykokwak", "Artwork Pokémon de Café ReMix"}, {"Psykokwak (Beignet baigné)-CM.png", "[[Psykokwak]] (Beignet baigné)", "Image Pokémon représentant Psykokwak", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Psykokwak (Rouge classique)-CM.png", "[[Psykokwak]] (Rouge classique)", "Image Pokémon représentant Psykokwak", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Caninos-CM.png", "[[Caninos]]", "Image Pokémon représentant Caninos", "Artwork Pokémon de Café ReMix"}, {"Caninos (Rouge classique)-CM.png", "[[Caninos]] (Rouge classique)", "Image Pokémon représentant Caninos", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Machopeur-CM.png", "[[Machopeur]]", "Image Pokémon représentant Machopeur", "Artwork Pokémon de Café ReMix"}, {"Machopeur (Randonneur)-CM.png", "[[Machopeur]] (Randonneur)", "Image Pokémon représentant Machopeur", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Machopeur (Rouge classique)-CM.png", "[[Machopeur]] (Rouge classique)", "Image Pokémon représentant Machopeur", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ramoloss-CM.png", "[[Ramoloss]]", "Image Pokémon représentant Ramoloss", "Artwork Pokémon de Café ReMix"}, {"Ramoloss de Galar-CM.png", "[[Ramoloss de Galar]]", "Image Pokémon représentant Ramoloss de Galar", "Artwork Pokémon de Café ReMix"}, {"Ramoloss de Galar (Rouge classique)-CM.png", "[[Ramoloss de Galar]] (Rouge classique)", "Image Pokémon représentant Ramoloss de Galar", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ramoloss (Chef spécial)-CM.png", "[[Ramoloss]] (Chef spécial)", "Image Pokémon représentant Ramoloss", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ramoloss (Kotatsu tout doux)-CM.png", "[[Ramoloss]] (Kotatsu tout doux)", "Image Pokémon représentant Ramoloss", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ramoloss (Rouge classique)-CM.png", "[[Ramoloss]] (Rouge classique)", "Image Pokémon représentant Ramoloss", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Canarticho-CM.png", "[[Canarticho]]", "Image Pokémon représentant Canarticho", "Artwork Pokémon de Café ReMix"}, {"Canarticho (Rouge classique)-CM.png", "[[Canarticho]] (Rouge classique)", "Image Pokémon représentant Canarticho", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ectoplasma-CM.png", "[[Ectoplasma]]", "Image Pokémon représentant Ectoplasma", "Artwork Pokémon de Café ReMix"}, {"Ectoplasma (Halloween)-CM.png", "[[Ectoplasma]] (Halloween)", "Image Pokémon représentant Ectoplasma", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ectoplasma (Tablier fleuri)-CM.png", "[[Ectoplasma]] (Tablier fleuri)", "Image Pokémon représentant Ectoplasma", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ectoplasma (Rouge classique)-CM.png", "[[Ectoplasma]] (Rouge classique)", "Image Pokémon représentant Ectoplasma", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Électrode-CM.png", "[[Électrode]]", "Image Pokémon représentant Électrode", "Artwork Pokémon de Café ReMix"}, {"Électrode (Rouge classique)-CM.png", "[[Électrode]] (Rouge classique)", "Image Pokémon représentant Électrode", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Noadkoko-CM.png", "[[Noadkoko]]", "Image Pokémon représentant Noadkoko", "Artwork Pokémon de Café ReMix"}, {"Noadkoko chromatique-CM.png", "[[Noadkoko]] [[chromatique]]", "Image Pokémon représentant Noadkoko", "Artwork Pokémon chromatique de Café ReMix"}, {"Noadkoko chromatique (Rouge classique)-CM.png", "[[Noadkoko]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Noadkoko", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Noadkoko d'Alola-CM.png", "[[Noadkoko d'Alola]]", "Image Pokémon représentant Noadkoko d'Alola", "Artwork Pokémon de Café ReMix"}, {"Noadkoko d'Alola (Rouge classique)-CM.png", "[[Noadkoko d'Alola]] (Rouge classique)", "Image Pokémon représentant Noadkoko d'Alola", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Noadkoko (Rouge classique)-CM.png", "[[Noadkoko]] (Rouge classique)", "Image Pokémon représentant Noadkoko", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Leveinard-CM.png", "[[Leveinard]]", "Image Pokémon représentant Leveinard", "Artwork Pokémon de Café ReMix"}, {"Leveinard (Œufs colorés)-CM.png", "[[Leveinard]] (Œufs colorés)", "Image Pokémon représentant Leveinard", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Leveinard (Rouge classique)-CM.png", "[[Leveinard]] (Rouge classique)", "Image Pokémon représentant Leveinard", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Magicarpe-CM.png", "[[Magicarpe]]", "Image Pokémon représentant Magicarpe", "Artwork Pokémon de Café ReMix"}, {"Magicarpe chromatique-CM.png", "[[Magicarpe]] [[chromatique]]", "Image Pokémon représentant Magicarpe", "Artwork Pokémon chromatique de Café ReMix"}, {"Magicarpe chromatique (dans l'eau)-CM.png", "[[Magicarpe]] [[chromatique]] dans l'eau", "Image Pokémon représentant Magicarpe", "Artwork Pokémon chromatique de Café ReMix"}, {"Magicarpe chromatique (Rouge classique)-CM.png", "[[Magicarpe]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Magicarpe", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Magicarpe chromatique (Rouge classique) (dans l'eau)-CM.png", "[[Magicarpe]] [[chromatique]] (Rouge classique) dans l'eau", "Image Pokémon représentant Magicarpe", "Artwork Pokémon chromatique de Café ReMix"}, {"Magicarpe (dans l'eau)-CM.png", "[[Magicarpe]] dans l'eau", "Image Pokémon représentant Magicarpe", "Artwork Pokémon de Café ReMix"}, {"Magicarpe (Rouge classique)-CM.png", "[[Magicarpe]] (Rouge classique)", "Image Pokémon représentant Magicarpe", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Magicarpe (Rouge classique) (dans l'eau)-CM.png", "[[Magicarpe (Rouge classique) dans l'eau", "Image Pokémon représentant Magicarpe", "Artwork Pokémon de Café ReMix"}, {"Léviator-CM.png", "[[Léviator]]", "Image Pokémon représentant Léviator", "Artwork Pokémon de Café ReMix"}, {"Léviator chromatique-CM.png", "[[Léviator]] [[chromatique]]", "Image Pokémon représentant Léviator", "Artwork Pokémon chromatique de Café ReMix"}, {"Léviator chromatique (dans l'eau)-CM.png", "[[Léviator]] [[chromatique]] dans l'eau", "Image Pokémon représentant Léviator", "Artwork Pokémon chromatique de Café ReMix"}, {"Léviator chromatique (Rouge classique)-CM.png", "[[Léviator]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Léviator", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Léviator chromatique (Rouge classique) (dans l'eau)-CM.png", "[[Léviator]] [[chromatique]] (Rouge classique) dans l'eau", "Image Pokémon représentant Léviator", "Artwork Pokémon chromatique de Café ReMix"}, {"Léviator (dans l'eau)-CM.png", "[[Léviator]] dans l'eau", "Image Pokémon représentant Léviator", "Artwork Pokémon de Café ReMix"}, {"Léviator (Rouge classique)-CM.png", "[[Léviator]] (Rouge classique)", "Image Pokémon représentant Léviator", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Léviator (Rouge classique) (dans l'eau)-CM.png", "[[Léviator (Rouge classique) dans l'eau", "Image Pokémon représentant Léviator", "Artwork Pokémon de Café ReMix"}, {"Lokhlass-CM.png", "[[Lokhlass]]", "Image Pokémon représentant Lokhlass", "Artwork Pokémon de Café ReMix"}, {"Lokhlass (dans l'eau)-CM.png", "[[Lokhlass]] dans l'eau", "Image Pokémon représentant Lokhlass", "Artwork Pokémon de Café ReMix"}, {"Lokhlass (Rouge classique)-CM.png", "[[Lokhlass]] (Rouge classique)", "Image Pokémon représentant Lokhlass", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lokhlass (Rouge classique) (dans l'eau)-CM.png", "[[Lokhlass (Rouge classique) dans l'eau", "Image Pokémon représentant Lokhlass", "Artwork Pokémon de Café ReMix"}, {"Métamorph-CM.png", "[[Métamorph]]", "Image Pokémon représentant Métamorph", "Artwork Pokémon de Café ReMix"}, {"Métamorph (Morphing Pikachu)-CM.png", "[[Métamorph]] (Morphing Pikachu)", "Image Pokémon représentant Métamorph", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Métamorph (Morphing Évoli)-CM.png", "[[Métamorph]] (Morphing Évoli)", "Image Pokémon représentant Métamorph", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Métamorph (Morphing Dracolosse)-CM.png", "[[Métamorph]] (Morphing Dracolosse)", "Image Pokémon représentant Métamorph", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Métamorph (Rouge classique)-CM.png", "[[Métamorph]] (Rouge classique)", "Image Pokémon représentant Métamorph", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle-CM.png", "Évoli mâle", "Image Pokémon représentant Évoli", "Artwork Pokémon de Café ReMix"}, {"Évoli mâle chromatique-CM.png", "[[Évoli mâle]] [[chromatique]]", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique de Café ReMix"}, {"Évoli mâle chromatique (« Sweets »)-CM.png", "[[Évoli mâle]] [[chromatique]] (« Sweets »)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle chromatique (Déguisement festif)-CM.png", "[[Évoli mâle]] [[chromatique]] (Déguisement festif)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle chromatique (Smoking de fête)-CM.png", "[[Évoli mâle]] [[chromatique]] (Smoking de fête)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle chromatique (Robe de fête)-CM.png", "[[Évoli mâle]] [[chromatique]] (Robe de fête)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle chromatique (Chef)-CM.png", "[[Évoli mâle]] [[chromatique]] (Chef)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle chromatique (Super chef)-CM.png", "[[Évoli mâle]] [[chromatique]] (Super chef)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle chromatique (Festival)-CM.png", "[[Évoli mâle]] [[chromatique]] (Festival)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle chromatique (Rouge classique)-CM.png", "[[Évoli mâle]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Évoli", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Évoli mâle (« Sweets »)-CM.png", "[[Évoli mâle]] (« Sweets »)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Déguisement festif)-CM.png", "[[Évoli mâle]] (Déguisement festif)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Smoking de fête)-CM.png", "[[Évoli mâle]] (Smoking de fête)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Robe de fête)-CM.png", "[[Évoli mâle]] (Robe de fête)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Chef)-CM.png", "[[Évoli mâle]] (Chef)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Super chef)-CM.png", "[[Évoli mâle]] (Super chef)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Festival) (2)-CM.png", "[[Évoli mâle]] (Festival)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Festival)-CM.png", "[[Évoli mâle]] (Festival)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle-CM.png", "Évoli femelle", "Image Pokémon représentant Évoli", "Artwork Pokémon de Café ReMix"}, {"Évoli femelle (« Sweets »)-CM.png", "[[Évoli femelle]] (« Sweets »)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Déguisement festif)-CM.png", "[[Évoli femelle]] (Déguisement festif)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Smoking de fête)-CM.png", "[[Évoli femelle]] (Smoking de fête)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Robe de fête)-CM.png", "[[Évoli femelle]] (Robe de fête)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Chef)-CM.png", "[[Évoli femelle]] (Chef)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Super chef)-CM.png", "[[Évoli femelle]] (Super chef)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Festival) (2)-CM.png", "[[Évoli femelle]] (Festival)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Festival)-CM.png", "[[Évoli femelle]] (Festival)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli femelle (Rouge classique)-CM.png", "[[Évoli femelle]] (Rouge classique)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Évoli mâle (Rouge classique)-CM.png", "[[Évoli mâle]] (Rouge classique)", "Image Pokémon représentant Évoli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Aquali-CM.png", "[[Aquali]]", "Image Pokémon représentant Aquali", "Artwork Pokémon de Café ReMix"}, {"Aquali (Halloween)-CM.png", "[[Aquali]] (Halloween)", "Image Pokémon représentant Aquali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Aquali (Splendeur tropicale) (2)-CM.png", "[[Aquali]] (Splendeur tropicale)", "Image Pokémon représentant Aquali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Aquali (Splendeur tropicale)-CM.png", "[[Aquali]] (Splendeur tropicale)", "Image Pokémon représentant Aquali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Aquali (dans l'eau)-CM.png", "[[Aquali]] dans l'eau", "Image Pokémon représentant Aquali", "Artwork Pokémon de Café ReMix"}, {"Aquali (Rouge classique)-CM.png", "[[Aquali]] (Rouge classique)", "Image Pokémon représentant Aquali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Aquali (Rouge classique) (dans l'eau)-CM.png", "[[Aquali (Rouge classique) dans l'eau", "Image Pokémon représentant Aquali", "Artwork Pokémon de Café ReMix"}, {"Voltali-CM.png", "[[Voltali]]", "Image Pokémon représentant Voltali", "Artwork Pokémon de Café ReMix"}, {"Voltali (Halloween)-CM.png", "[[Voltali]] (Halloween)", "Image Pokémon représentant Voltali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Voltali (Firmament brillant)-CM.png", "[[Voltali]] (Firmament brillant)", "Image Pokémon représentant Voltali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Voltali (Rouge classique)-CM.png", "[[Voltali]] (Rouge classique)", "Image Pokémon représentant Voltali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pyroli-CM.png", "[[Pyroli]]", "Image Pokémon représentant Pyroli", "Artwork Pokémon de Café ReMix"}, {"Pyroli (Halloween)-CM.png", "[[Pyroli]] (Halloween)", "Image Pokémon représentant Pyroli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pyroli (Festival)-CM.png", "[[Pyroli]] (Festival)", "Image Pokémon représentant Pyroli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pyroli (Rouge classique)-CM.png", "[[Pyroli]] (Rouge classique)", "Image Pokémon représentant Pyroli", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ronflex-CM.png", "[[Ronflex]]", "Image Pokémon représentant Ronflex", "Artwork Pokémon de Café ReMix"}, {"Ronflex (Pyjama gros dodo)-CM.png", "[[Ronflex]] (Pyjama gros dodo)", "Image Pokémon représentant Ronflex", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ronflex (Beignet douillet) (2)-CM.png", "[[Ronflex]] (Beignet douillet)", "Image Pokémon représentant Ronflex", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ronflex (Beignet douillet) (3)-CM.png", "[[Ronflex]] (Beignet douillet)", "Image Pokémon représentant Ronflex", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ronflex (Beignet douillet)-CM.png", "[[Ronflex]] (Beignet douillet)", "Image Pokémon représentant Ronflex", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ronflex (Rouge classique)-CM.png", "[[Ronflex]] (Rouge classique)", "Image Pokémon représentant Ronflex", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dracolosse-CM.png", "[[Dracolosse]]", "Image Pokémon représentant Dracolosse", "Artwork Pokémon de Café ReMix"}, {"Dracolosse (Smoking chocolat)-CM.png", "[[Dracolosse]] (Smoking chocolat)", "Image Pokémon représentant Dracolosse", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dracolosse (Casquette Dragon)-CM.png", "[[Dracolosse]] (Casquette Dragon)", "Image Pokémon représentant Dracolosse", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dracolosse (Rouge classique)-CM.png", "[[Dracolosse]] (Rouge classique)", "Image Pokémon représentant Dracolosse", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mewtwo-CM.png", "[[Mewtwo]]", "Image Pokémon représentant Mewtwo", "Artwork Pokémon de Café ReMix"}, {"Mewtwo (Rouge classique)-CM.png", "[[Mewtwo]] (Rouge classique)", "Image Pokémon représentant Mewtwo", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mew-CM.png", "[[Mew]]", "Image Pokémon représentant Mew", "Artwork Pokémon de Café ReMix"}, {"Mew (Bonne étoile)-CM.png", "[[Mew]] (Bonne étoile)", "Image Pokémon représentant Mew", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mew (Campeur) (2)-CM.png", "[[Mew]] (Campeur)", "Image Pokémon représentant Mew", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mew (Campeur)-CM.png", "[[Mew]] (Campeur)", "Image Pokémon représentant Mew", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mew (Potager branché) (2)-CM.png", "[[Mew]] (Potager branché)", "Image Pokémon représentant Mew", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mew (Potager branché)-CM.png", "[[Mew]] (Potager branché)", "Image Pokémon représentant Mew", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mew (Rouge classique)-CM.png", "[[Mew]] (Rouge classique)", "Image Pokémon représentant Mew", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Héricendre-CM.png", "[[Héricendre]]", "Image Pokémon représentant Héricendre", "Artwork Pokémon de Café ReMix"}, {"Héricendre (Rouge classique)-CM.png", "[[Héricendre]] (Rouge classique)", "Image Pokémon représentant Héricendre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Typhlosion de Hisui-CM.png", "[[Typhlosion de Hisui]]", "Image Pokémon représentant Typhlosion de Hisui", "Artwork Pokémon de Café ReMix"}, {"Typhlosion de Hisui (Rouge classique)-CM.png", "[[Typhlosion de Hisui]] (Rouge classique)", "Image Pokémon représentant Typhlosion de Hisui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Fouinar-CM.png", "[[Fouinar]]", "Image Pokémon représentant Fouinar", "Artwork Pokémon de Café ReMix"}, {"Fouinar (Rouge classique)-CM.png", "[[Fouinar]] (Rouge classique)", "Image Pokémon représentant Fouinar", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pichu-CM.png", "[[Pichu]]", "Image Pokémon représentant Pichu", "Artwork Pokémon de Café ReMix"}, {"Pichu (Thé enchanté)-CM.png", "[[Pichu]] (Thé enchanté)", "Image Pokémon représentant Pichu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pichu (Rouge classique)-CM.png", "[[Pichu]] (Rouge classique)", "Image Pokémon représentant Pichu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Togepi-CM.png", "[[Togepi]]", "Image Pokémon représentant Togepi", "Artwork Pokémon de Café ReMix"}, {"Togepi chromatique-CM.png", "[[Togepi]] [[chromatique]]", "Image Pokémon représentant Togepi", "Artwork Pokémon chromatique de Café ReMix"}, {"Togepi chromatique (Casquette Balle Pic )-CM.png", "[[Togepi]] [[chromatique]] (Casquette Balle Pic )", "Image Pokémon représentant Togepi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Togepi chromatique (Rouge classique)-CM.png", "[[Togepi]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Togepi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Togepi (Casquette Balle Pic )-CM.png", "[[Togepi]] (Casquette Balle Pic )", "Image Pokémon représentant Togepi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Togepi (Rouge classique)-CM.png", "[[Togepi]] (Rouge classique)", "Image Pokémon représentant Togepi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Xatu-CM.png", "[[Xatu]]", "Image Pokémon représentant Xatu", "Artwork Pokémon de Café ReMix"}, {"Xatu (Rouge classique)-CM.png", "[[Xatu]] (Rouge classique)", "Image Pokémon représentant Xatu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Joliflor-CM.png", "[[Joliflor]]", "Image Pokémon représentant Joliflor", "Artwork Pokémon de Café ReMix"}, {"Joliflor (Rouge classique)-CM.png", "[[Joliflor]] (Rouge classique)", "Image Pokémon représentant Joliflor", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Simularbre-CM.png", "[[Simularbre]]", "Image Pokémon représentant Simularbre", "Artwork Pokémon de Café ReMix"}, {"Simularbre (Rouge classique)-CM.png", "[[Simularbre]] (Rouge classique)", "Image Pokémon représentant Simularbre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Maraiste-CM.png", "[[Maraiste]]", "Image Pokémon représentant Maraiste", "Artwork Pokémon de Café ReMix"}, {"Maraiste (Rouge classique)-CM.png", "[[Maraiste]] (Rouge classique)", "Image Pokémon représentant Maraiste", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Noctali-CM.png", "[[Noctali]]", "Image Pokémon représentant Noctali", "Artwork Pokémon de Café ReMix"}, {"Noctali (Halloween)-CM.png", "[[Noctali]] (Halloween)", "Image Pokémon représentant Noctali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Noctali (Rouge classique)-CM.png", "[[Noctali]] (Rouge classique)", "Image Pokémon représentant Noctali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Qulbutoké-CM.png", "[[Qulbutoké]]", "Image Pokémon représentant Qulbutoké", "Artwork Pokémon de Café ReMix"}, {"Qulbutoké chromatique-CM.png", "[[Qulbutoké]] [[chromatique]]", "Image Pokémon représentant Qulbutoké", "Artwork Pokémon chromatique de Café ReMix"}, {"Qulbutoké chromatique (Cône de glace)-CM.png", "[[Qulbutoké]] [[chromatique]] (Cône de glace)", "Image Pokémon représentant Qulbutoké", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Qulbutoké chromatique (Rouge classique)-CM.png", "[[Qulbutoké]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Qulbutoké", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Qulbutoké (Cône de glace)-CM.png", "[[Qulbutoké]] (Cône de glace)", "Image Pokémon représentant Qulbutoké", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Qulbutoké (Rouge classique)-CM.png", "[[Qulbutoké]] (Rouge classique)", "Image Pokémon représentant Qulbutoké", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Snubbull-CM.png", "[[Snubbull]]", "Image Pokémon représentant Snubbull", "Artwork Pokémon de Café ReMix"}, {"Snubbull chromatique-CM.png", "[[Snubbull]] [[chromatique]]", "Image Pokémon représentant Snubbull", "Artwork Pokémon chromatique de Café ReMix"}, {"Snubbull chromatique (Chapeau de fée)-CM.png", "[[Snubbull]] [[chromatique]] (Chapeau de fée)", "Image Pokémon représentant Snubbull", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Snubbull chromatique (Rouge classique)-CM.png", "[[Snubbull]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Snubbull", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Snubbull (Chapeau de fée)-CM.png", "[[Snubbull]] (Chapeau de fée)", "Image Pokémon représentant Snubbull", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Snubbull (Rouge classique)-CM.png", "[[Snubbull]] (Rouge classique)", "Image Pokémon représentant Snubbull", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Cizayox-CM.png", "[[Cizayox]]", "Image Pokémon représentant Cizayox", "Artwork Pokémon de Café ReMix"}, {"Cizayox (Rouge classique)-CM.png", "[[Cizayox]] (Rouge classique)", "Image Pokémon représentant Cizayox", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Farfuret-CM.png", "[[Farfuret]]", "Image Pokémon représentant Farfuret", "Artwork Pokémon de Café ReMix"}, {"Farfuret chromatique-CM.png", "[[Farfuret]] [[chromatique]]", "Image Pokémon représentant Farfuret", "Artwork Pokémon chromatique de Café ReMix"}, {"Farfuret de Hisui chromatique-CM.png", "[[Farfuret de Hisui]] [[chromatique]]", "Image Pokémon représentant Farfuret de Hisui", "Artwork Pokémon chromatique de Café ReMix"}, {"Farfuret de Hisui chromatique (Rouge classique)-CM.png", "[[Farfuret de Hisui]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Farfuret de Hisui", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Farfuret chromatique (Serveur cool)-CM.png", "[[Farfuret]] [[chromatique]] (Serveur cool)", "Image Pokémon représentant Farfuret", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Farfuret chromatique (Rouge classique)-CM.png", "[[Farfuret]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Farfuret", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Farfuret de Hisui-CM.png", "[[Farfuret de Hisui]]", "Image Pokémon représentant Farfuret de Hisui", "Artwork Pokémon de Café ReMix"}, {"Farfuret de Hisui (Rouge classique)-CM.png", "[[Farfuret de Hisui]] (Rouge classique)", "Image Pokémon représentant Farfuret de Hisui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Farfuret (Serveur cool)-CM.png", "[[Farfuret]] (Serveur cool)", "Image Pokémon représentant Farfuret", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Farfuret (Rouge classique)-CM.png", "[[Farfuret]] (Rouge classique)", "Image Pokémon représentant Farfuret", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Teddiursa-CM.png", "[[Teddiursa]]", "Image Pokémon représentant Teddiursa", "Artwork Pokémon de Café ReMix"}, {"Teddiursa (Rouge classique)-CM.png", "[[Teddiursa]] (Rouge classique)", "Image Pokémon représentant Teddiursa", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Corayon-CM.png", "[[Corayon]]", "Image Pokémon représentant Corayon", "Artwork Pokémon de Café ReMix"}, {"Corayon (Rouge classique)-CM.png", "[[Corayon]] (Rouge classique)", "Image Pokémon représentant Corayon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Porygon2-CM.png", "[[Porygon2]]", "Image Pokémon représentant Porygon2", "Artwork Pokémon de Café ReMix"}, {"Porygon2 (Rouge classique)-CM.png", "[[Porygon2]] (Rouge classique)", "Image Pokémon représentant Porygon2", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ho-Oh-CM.png", "Ho-Oh", "Image Pokémon représentant Ho-Oh", "Artwork Pokémon de Café ReMix"}, {"Ho-Oh (Rouge classique)-CM.png", "[[Ho-Oh]] (Rouge classique)", "Image Pokémon représentant Ho-Oh", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Celebi-CM.png", "[[Celebi]]", "Image Pokémon représentant Celebi", "Artwork Pokémon de Café ReMix"}, {"Celebi chromatique-CM.png", "[[Celebi]] [[chromatique]]", "Image Pokémon représentant Celebi", "Artwork Pokémon chromatique de Café ReMix"}, {"Celebi chromatique (Bonne étoile)-CM.png", "[[Celebi]] [[chromatique]] (Bonne étoile)", "Image Pokémon représentant Celebi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Celebi chromatique (Récolte automnale) (2)-CM.png", "[[Celebi]] [[chromatique]] (Récolte automnale)", "Image Pokémon représentant Celebi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Celebi chromatique (Récolte automnale) (3)-CM.png", "[[Celebi]] [[chromatique]] (Récolte automnale)", "Image Pokémon représentant Celebi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Celebi chromatique (Récolte automnale)-CM.png", "[[Celebi]] [[chromatique]] (Récolte automnale)", "Image Pokémon représentant Celebi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Celebi chromatique (Rouge classique)-CM.png", "[[Celebi]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Celebi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Celebi (Bonne étoile)-CM.png", "[[Celebi]] (Bonne étoile)", "Image Pokémon représentant Celebi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Celebi (Récolte automnale) (2)-CM.png", "[[Celebi]] (Récolte automnale)", "Image Pokémon représentant Celebi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Celebi (Récolte automnale) (3)-CM.png", "[[Celebi]] (Récolte automnale)", "Image Pokémon représentant Celebi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Celebi (Récolte automnale)-CM.png", "[[Celebi]] (Récolte automnale)", "Image Pokémon représentant Celebi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Celebi (Rouge classique)-CM.png", "[[Celebi]] (Rouge classique)", "Image Pokémon représentant Celebi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Flobio-CM.png", "[[Flobio]]", "Image Pokémon représentant Flobio", "Artwork Pokémon de Café ReMix"}, {"Flobio (Maître sushi)-CM.png", "[[Flobio]] (Maître sushi)", "Image Pokémon représentant Flobio", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Flobio (Rouge classique)-CM.png", "[[Flobio]] (Rouge classique)", "Image Pokémon représentant Flobio", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ludicolo-CM.png", "[[Ludicolo]]", "Image Pokémon représentant Ludicolo", "Artwork Pokémon de Café ReMix"}, {"Ludicolo (Rouge classique)-CM.png", "[[Ludicolo]] (Rouge classique)", "Image Pokémon représentant Ludicolo", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Bekipan (Annonces)-CM.png", "[[Bekipan]] (Annonces)", "Image Pokémon représentant Bekipan", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Bekipan (Livraison)-CM.png", "[[Bekipan]] (Livraison)", "Image Pokémon représentant Bekipan", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Kirlia-CM.png", "[[Kirlia]]", "Image Pokémon représentant Kirlia", "Artwork Pokémon de Café ReMix"}, {"Kirlia chromatique-CM.png", "[[Kirlia]] [[chromatique]]", "Image Pokémon représentant Kirlia", "Artwork Pokémon chromatique de Café ReMix"}, {"Kirlia chromatique (Serveur rétro)-CM.png", "[[Kirlia]] [[chromatique]] (Serveur rétro)", "Image Pokémon représentant Kirlia", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Kirlia chromatique (Robe d'antan)-CM.png", "[[Kirlia]] [[chromatique]] (Robe d'antan)", "Image Pokémon représentant Kirlia", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Kirlia chromatique (Rouge classique)-CM.png", "[[Kirlia]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Kirlia", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Kirlia (Serveur rétro)-CM.png", "[[Kirlia]] (Serveur rétro)", "Image Pokémon représentant Kirlia", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Kirlia (Robe d'antan)-CM.png", "[[Kirlia]] (Robe d'antan)", "Image Pokémon représentant Kirlia", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Kirlia (Rouge classique)-CM.png", "[[Kirlia]] (Rouge classique)", "Image Pokémon représentant Kirlia", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Gardevoir-CM.png", "[[Gardevoir]]", "Image Pokémon représentant Gardevoir", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Gardevoir (Neige royale) (2)-CM.png", "[[Gardevoir]] (Neige royale)", "Image Pokémon représentant Gardevoir", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Gardevoir (Neige royale)-CM.png", "[[Gardevoir]] (Neige royale)", "Image Pokémon représentant Gardevoir", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Gardevoir (Halloween)-CM.png", "[[Gardevoir]] (Halloween)", "Image Pokémon représentant Gardevoir", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Gardevoir (Rouge classique)-CM.png", "[[Gardevoir]] (Rouge classique)", "Image Pokémon représentant Gardevoir", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mysdibule-CM.png", "[[Mysdibule]]", "Image Pokémon représentant Mysdibule", "Artwork Pokémon de Café ReMix"}, {"Mysdibule (Chocolatier coquet)-CM.png", "[[Mysdibule]] (Chocolatier coquet)", "Image Pokémon représentant Mysdibule", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mysdibule (Rouge classique)-CM.png", "[[Mysdibule]] (Rouge classique)", "Image Pokémon représentant Mysdibule", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Posipi-CM.png", "[[Posipi]]", "Image Pokémon représentant Posipi", "Artwork Pokémon de Café ReMix"}, {"Posipi chromatique-CM.png", "[[Posipi]] [[chromatique]]", "Image Pokémon représentant Posipi", "Artwork Pokémon chromatique de Café ReMix"}, {"Posipi chromatique (Rouge classique)-CM.png", "[[Posipi]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Posipi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Posipi (Rouge classique)-CM.png", "[[Posipi]] (Rouge classique)", "Image Pokémon représentant Posipi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Négapi-CM.png", "[[Négapi]]", "Image Pokémon représentant Négapi", "Artwork Pokémon de Café ReMix"}, {"Négapi chromatique-CM.png", "[[Négapi]] [[chromatique]]", "Image Pokémon représentant Négapi", "Artwork Pokémon chromatique de Café ReMix"}, {"Négapi chromatique (Rouge classique)-CM.png", "[[Négapi]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Négapi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Négapi (Rouge classique)-CM.png", "[[Négapi]] (Rouge classique)", "Image Pokémon représentant Négapi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Altaria-CM.png", "[[Altaria]]", "Image Pokémon représentant Altaria", "Artwork Pokémon de Café ReMix"}, {"Altaria (Festival)-CM.png", "[[Altaria]] (Festival)", "Image Pokémon représentant Altaria", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Altaria (Rouge classique)-CM.png", "[[Altaria]] (Rouge classique)", "Image Pokémon représentant Altaria", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Milobellus-CM.png", "[[Milobellus]]", "Image Pokémon représentant Milobellus", "Artwork Pokémon de Café ReMix"}, {"Milobellus (dans l'eau)-CM.png", "[[Milobellus]] dans l'eau", "Image Pokémon représentant Milobellus", "Artwork Pokémon de Café ReMix"}, {"Milobellus (Rouge classique)-CM.png", "[[Milobellus]] (Rouge classique)", "Image Pokémon représentant Milobellus", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Milobellus (Rouge classique) (dans l'eau)-CM.png", "[[Milobellus (Rouge classique) dans l'eau", "Image Pokémon représentant Milobellus", "Artwork Pokémon de Café ReMix"}, {"Absol-CM.png", "[[Absol]]", "Image Pokémon représentant Absol", "Artwork Pokémon de Café ReMix"}, {"Absol (Célébration grandiose) (2)-CM.png", "[[Absol]] (Célébration grandiose)", "Image Pokémon représentant Absol", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Absol (Célébration grandiose)-CM.png", "[[Absol]] (Célébration grandiose)", "Image Pokémon représentant Absol", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Absol (Rouge classique)-CM.png", "[[Absol]] (Rouge classique)", "Image Pokémon représentant Absol", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Obalie-CM.png", "[[Obalie]]", "Image Pokémon représentant Obalie", "Artwork Pokémon de Café ReMix"}, {"Obalie (Déguisement festif)-CM.png", "[[Obalie]] (Déguisement festif)", "Image Pokémon représentant Obalie", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Obalie (dans l'eau)-CM.png", "[[Obalie]] dans l'eau", "Image Pokémon représentant Obalie", "Artwork Pokémon de Café ReMix"}, {"Obalie (Rouge classique)-CM.png", "[[Obalie]] (Rouge classique)", "Image Pokémon représentant Obalie", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Obalie (Rouge classique) (dans l'eau)-CM.png", "[[Obalie (Rouge classique) dans l'eau", "Image Pokémon représentant Obalie", "Artwork Pokémon de Café ReMix"}, {"Latias-CM.png", "[[Latias]]", "Image Pokémon représentant Latias", "Artwork Pokémon de Café ReMix"}, {"Latias (Célébration grandiose)-CM.png", "[[Latias]] (Célébration grandiose)", "Image Pokémon représentant Latias", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Latias (Rouge classique)-CM.png", "[[Latias]] (Rouge classique)", "Image Pokémon représentant Latias", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Latios-CM.png", "[[Latios]]", "Image Pokémon représentant Latios", "Artwork Pokémon de Café ReMix"}, {"Latios (Célébration grandiose)-CM.png", "[[Latios]] (Célébration grandiose)", "Image Pokémon représentant Latios", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Latios (Rouge classique)-CM.png", "[[Latios]] (Rouge classique)", "Image Pokémon représentant Latios", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Jirachi-CM.png", "[[Jirachi]]", "Image Pokémon représentant Jirachi", "Artwork Pokémon de Café ReMix"}, {"Jirachi (Étoile souhait) (2)-CM.png", "[[Jirachi]] (Étoile souhait)", "Image Pokémon représentant Jirachi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Jirachi (Étoile souhait)-CM.png", "[[Jirachi]] (Étoile souhait)", "Image Pokémon représentant Jirachi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Jirachi (Rouge classique)-CM.png", "[[Jirachi]] (Rouge classique)", "Image Pokémon représentant Jirachi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Torterra-CM.png", "[[Torterra]]", "Image Pokémon représentant Torterra", "Artwork Pokémon de Café ReMix"}, {"Torterra (Festivités)-CM.png", "[[Torterra]] (Festivités)", "Image Pokémon représentant Torterra", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Torterra (Rouge classique)-CM.png", "[[Torterra]] (Rouge classique)", "Image Pokémon représentant Torterra", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ouisticram-CM.png", "[[Ouisticram]]", "Image Pokémon représentant Ouisticram", "Artwork Pokémon de Café ReMix"}, {"Ouisticram chromatique-CM.png", "[[Ouisticram]] [[chromatique]]", "Image Pokémon représentant Ouisticram", "Artwork Pokémon chromatique de Café ReMix"}, {"Ouisticram chromatique (Explorateur de mine)-CM.png", "[[Ouisticram]] [[chromatique]] (Explorateur de mine)", "Image Pokémon représentant Ouisticram", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Ouisticram chromatique (Rouge classique)-CM.png", "[[Ouisticram]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Ouisticram", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Ouisticram (Explorateur de mine)-CM.png", "[[Ouisticram]] (Explorateur de mine)", "Image Pokémon représentant Ouisticram", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ouisticram (Rouge classique)-CM.png", "[[Ouisticram]] (Rouge classique)", "Image Pokémon représentant Ouisticram", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Tiplouf-CM.png", "[[Tiplouf]]", "Image Pokémon représentant Tiplouf", "Artwork Pokémon de Café ReMix"}, {"Tiplouf chromatique-CM.png", "[[Tiplouf]] [[chromatique]]", "Image Pokémon représentant Tiplouf", "Artwork Pokémon chromatique de Café ReMix"}, {"Tiplouf chromatique (Bonne année 2022)-CM.png", "[[Tiplouf]] [[chromatique]] (Bonne année 2022)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Tiplouf chromatique (Vacancier)-CM.png", "[[Tiplouf]] [[chromatique]] (Vacancier)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Tiplouf chromatique (Déguisement festif)-CM.png", "[[Tiplouf]] [[chromatique]] (Déguisement festif)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Tiplouf chromatique (Rouge classique)-CM.png", "[[Tiplouf]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Tiplouf (Bonne année 2022)-CM.png", "[[Tiplouf]] (Bonne année 2022)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Tiplouf (Vacancier)-CM.png", "[[Tiplouf]] (Vacancier)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Tiplouf (Déguisement festif)-CM.png", "[[Tiplouf]] (Déguisement festif)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Tiplouf (Rouge classique)-CM.png", "[[Tiplouf]] (Rouge classique)", "Image Pokémon représentant Tiplouf", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Étourmi-CM.png", "[[Étourmi]]", "Image Pokémon représentant Étourmi", "Artwork Pokémon de Café ReMix"}, {"Étourmi chromatique-CM.png", "[[Étourmi]] [[chromatique]]", "Image Pokémon représentant Étourmi", "Artwork Pokémon chromatique de Café ReMix"}, {"Étourmi chromatique (Œufs colorés)-CM.png", "[[Étourmi]] [[chromatique]] (Œufs colorés)", "Image Pokémon représentant Étourmi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Étourmi chromatique (Rouge classique)-CM.png", "[[Étourmi]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Étourmi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Étourmi (Œufs colorés)-CM.png", "[[Étourmi]] (Œufs colorés)", "Image Pokémon représentant Étourmi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Étourmi (Rouge classique)-CM.png", "[[Étourmi]] (Rouge classique)", "Image Pokémon représentant Étourmi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pachirisu-CM.png", "[[Pachirisu]]", "Image Pokémon représentant Pachirisu", "Artwork Pokémon de Café ReMix"}, {"Pachirisu (Thé enchanté)-CM.png", "[[Pachirisu]] (Thé enchanté)", "Image Pokémon représentant Pachirisu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pachirisu (Rouge classique)-CM.png", "[[Pachirisu]] (Rouge classique)", "Image Pokémon représentant Pachirisu", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mustébouée-CM.png", "[[Mustébouée]]", "Image Pokémon représentant Mustébouée", "Artwork Pokémon de Café ReMix"}, {"Mustébouée chromatique-CM.png", "[[Mustébouée]] [[chromatique]]", "Image Pokémon représentant Mustébouée", "Artwork Pokémon chromatique de Café ReMix"}, {"Mustébouée chromatique (Surfeur relax)-CM.png", "[[Mustébouée]] [[chromatique]] (Surfeur relax)", "Image Pokémon représentant Mustébouée", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Mustébouée chromatique (Rouge classique)-CM.png", "[[Mustébouée]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Mustébouée", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Mustébouée (Surfeur relax)-CM.png", "[[Mustébouée]] (Surfeur relax)", "Image Pokémon représentant Mustébouée", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mustébouée (Rouge classique)-CM.png", "[[Mustébouée]] (Rouge classique)", "Image Pokémon représentant Mustébouée", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Magirêve-CM.png", "[[Magirêve]]", "Image Pokémon représentant Magirêve", "Artwork Pokémon de Café ReMix"}, {"Magirêve (Halloween)-CM.png", "[[Magirêve]] (Halloween)", "Image Pokémon représentant Magirêve", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Magirêve (Rouge classique)-CM.png", "[[Magirêve]] (Rouge classique)", "Image Pokémon représentant Magirêve", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Carchacrok-CM.png", "[[Carchacrok]]", "Image Pokémon représentant Carchacrok", "Artwork Pokémon de Café ReMix"}, {"Carchacrok (Rouge classique)-CM.png", "[[Carchacrok]] (Rouge classique)", "Image Pokémon représentant Carchacrok", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goinfrex-CM.png", "[[Goinfrex]]", "Image Pokémon représentant Goinfrex", "Artwork Pokémon de Café ReMix"}, {"Goinfrex chromatique-CM.png", "[[Goinfrex]] [[chromatique]]", "Image Pokémon représentant Goinfrex", "Artwork Pokémon chromatique de Café ReMix"}, {"Goinfrex chromatique (Chapeau Goinfre)-CM.png", "[[Goinfrex]] [[chromatique]] (Chapeau Goinfre)", "Image Pokémon représentant Goinfrex", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Goinfrex chromatique (Rouge classique)-CM.png", "[[Goinfrex]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Goinfrex", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Goinfrex (Chapeau Goinfre)-CM.png", "[[Goinfrex]] (Chapeau Goinfre)", "Image Pokémon représentant Goinfrex", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Goinfrex (Rouge classique)-CM.png", "[[Goinfrex]] (Rouge classique)", "Image Pokémon représentant Goinfrex", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lucario-CM.png", "[[Lucario]]", "Image Pokémon représentant Lucario", "Artwork Pokémon de Café ReMix"}, {"Lucario chromatique-CM.png", "[[Lucario]] [[chromatique]]", "Image Pokémon représentant Lucario", "Artwork Pokémon chromatique de Café ReMix"}, {"Lucario chromatique (Super chef)-CM.png", "[[Lucario]] [[chromatique]] (Super chef)", "Image Pokémon représentant Lucario", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lucario chromatique (Déguisement festif)-CM.png", "[[Lucario]] [[chromatique]] (Déguisement festif)", "Image Pokémon représentant Lucario", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lucario chromatique (Chef)-CM.png", "[[Lucario]] [[chromatique]] (Chef)", "Image Pokémon représentant Lucario", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lucario chromatique (Bal masqué)-CM.png", "[[Lucario]] [[chromatique]] (Bal masqué)", "Image Pokémon représentant Lucario", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lucario chromatique (Rouge classique)-CM.png", "[[Lucario]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Lucario", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lucario (Super chef)-CM.png", "[[Lucario]] (Super chef)", "Image Pokémon représentant Lucario", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lucario (Déguisement festif)-CM.png", "[[Lucario]] (Déguisement festif)", "Image Pokémon représentant Lucario", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lucario (Chef)-CM.png", "[[Lucario]] (Chef)", "Image Pokémon représentant Lucario", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lucario (Bal masqué)-CM.png", "[[Lucario]] (Bal masqué)", "Image Pokémon représentant Lucario", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lucario (Rouge classique)-CM.png", "[[Lucario]] (Rouge classique)", "Image Pokémon représentant Lucario", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Givrali-CM.png", "[[Givrali]]", "Image Pokémon représentant Givrali", "Artwork Pokémon de Café ReMix"}, {"Givrali (Rouge classique)-CM.png", "[[Givrali]] (Rouge classique)", "Image Pokémon représentant Givrali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Momartik-CM.png", "[[Momartik]]", "Image Pokémon représentant Momartik", "Artwork Pokémon de Café ReMix"}, {"Momartik (Neige royale)-CM.png", "[[Momartik]] (Neige royale)", "Image Pokémon représentant Momartik", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Momartik (Rouge classique)-CM.png", "[[Momartik]] (Rouge classique)", "Image Pokémon représentant Momartik", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dialga-CM.png", "[[Dialga]]", "Image Pokémon représentant Dialga", "Artwork Pokémon de Café ReMix"}, {"Dialga (Rouge classique)-CM.png", "[[Dialga]] (Rouge classique)", "Image Pokémon représentant Dialga", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Palkia-CM.png", "[[Palkia]]", "Image Pokémon représentant Palkia", "Artwork Pokémon de Café ReMix"}, {"Palkia (Rouge classique)-CM.png", "[[Palkia]] (Rouge classique)", "Image Pokémon représentant Palkia", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Shaymin (Forme Terrestre)-CM.png", "[[Shaymin]] (Forme Terrestre)", "Image Pokémon représentant Shaymin", "Artwork Pokémon de Café ReMix"}, {"Shaymin (Forme Céleste)-CM.png", "[[Shaymin]] (Forme Céleste)", "Image Pokémon représentant Shaymin", "Artwork Pokémon de Café ReMix"}, {"Shaymin (Forme Céleste) (Rouge classique)-CM.png", "[[Shaymin (Forme Céleste) (Rouge classique)", "Image Pokémon représentant Shaymin", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Shaymin (Forme Terrestre) (Rouge classique)-CM.png", "[[Shaymin (Forme Terrestre) (Rouge classique)", "Image Pokémon représentant Shaymin", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Victini-CM.png", "[[Victini]]", "Image Pokémon représentant Victini", "Artwork Pokémon de Café ReMix"}, {"Victini (Chef ardent )-CM.png", "[[Victini]] (Chef ardent )", "Image Pokémon représentant Victini", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Victini (Rouge classique)-CM.png", "[[Victini]] (Rouge classique)", "Image Pokémon représentant Victini", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Vipélierre-CM.png", "[[Vipélierre]]", "Image Pokémon représentant Vipélierre", "Artwork Pokémon de Café ReMix"}, {"Vipélierre (Pique-nique savoureux)-CM.png", "[[Vipélierre]] (Pique-nique savoureux)", "Image Pokémon représentant Vipélierre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Vipélierre (Rouge classique)-CM.png", "[[Vipélierre]] (Rouge classique)", "Image Pokémon représentant Vipélierre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Moustillon-CM.png", "[[Moustillon]]", "Image Pokémon représentant Moustillon", "Artwork Pokémon de Café ReMix"}, {"Moustillon chromatique-CM.png", "[[Moustillon]] [[chromatique]]", "Image Pokémon représentant Moustillon", "Artwork Pokémon chromatique de Café ReMix"}, {"Moustillon chromatique (Vacances d'été)-CM.png", "[[Moustillon]] [[chromatique]] (Vacances d'été)", "Image Pokémon représentant Moustillon", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Moustillon chromatique (Rouge classique)-CM.png", "[[Moustillon]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Moustillon", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Moustillon (Vacances d'été)-CM.png", "[[Moustillon]] (Vacances d'été)", "Image Pokémon représentant Moustillon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Moustillon (Rouge classique)-CM.png", "[[Moustillon]] (Rouge classique)", "Image Pokémon représentant Moustillon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mastouffe-CM.png", "[[Mastouffe]]", "Image Pokémon représentant Mastouffe", "Artwork Pokémon de Café ReMix"}, {"Mastouffe chromatique-CM.png", "[[Mastouffe]] [[chromatique]]", "Image Pokémon représentant Mastouffe", "Artwork Pokémon chromatique de Café ReMix"}, {"Mastouffe chromatique (Rouge classique)-CM.png", "[[Mastouffe]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Mastouffe", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Mastouffe (Rouge classique)-CM.png", "[[Mastouffe]] (Rouge classique)", "Image Pokémon représentant Mastouffe", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nanméouïe-CM.png", "[[Nanméouïe]]", "Image Pokémon représentant Nanméouïe", "Artwork Pokémon de Café ReMix"}, {"Nanméouïe chromatique-CM.png", "[[Nanméouïe]] [[chromatique]]", "Image Pokémon représentant Nanméouïe", "Artwork Pokémon chromatique de Café ReMix"}, {"Nanméouïe chromatique (Festival d'été)-CM.png", "[[Nanméouïe]] [[chromatique]] (Festival d'été)", "Image Pokémon représentant Nanméouïe", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Nanméouïe chromatique (Rouge classique)-CM.png", "[[Nanméouïe]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Nanméouïe", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Nanméouïe (Festival d'été)-CM.png", "[[Nanméouïe]] (Festival d'été)", "Image Pokémon représentant Nanméouïe", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nanméouïe (Rouge classique)-CM.png", "[[Nanméouïe]] (Rouge classique)", "Image Pokémon représentant Nanméouïe", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Charpenti-CM.png", "[[Charpenti]]", "Image Pokémon représentant Charpenti", "Artwork Pokémon de Café ReMix"}, {"Farfaduvet-CM.png", "[[Farfaduvet]]", "Image Pokémon représentant Farfaduvet", "Artwork Pokémon de Café ReMix"}, {"Farfaduvet (Clonage)-CM.png", "[[Farfaduvet]] (Clonage)", "Image Pokémon représentant Farfaduvet", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Farfaduvet (Rouge classique)-CM.png", "[[Farfaduvet]] (Rouge classique)", "Image Pokémon représentant Farfaduvet", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Fragilady-CM.png", "[[Fragilady]]", "Image Pokémon représentant Fragilady", "Artwork Pokémon de Café ReMix"}, {"Fragilady (Rouge classique)-CM.png", "[[Fragilady]] (Rouge classique)", "Image Pokémon représentant Fragilady", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Baggiguane-CM.png", "[[Baggiguane]]", "Image Pokémon représentant Baggiguane", "Artwork Pokémon de Café ReMix"}, {"Baggiguane (Rouge classique)-CM.png", "[[Baggiguane]] (Rouge classique)", "Image Pokémon représentant Baggiguane", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Zorua-CM.png", "[[Zorua]]", "Image Pokémon représentant Zorua", "Artwork Pokémon de Café ReMix"}, {"Zorua de Hisui-CM.png", "[[Zorua de Hisui]]", "Image Pokémon représentant Zorua de Hisui", "Artwork Pokémon de Café ReMix"}, {"Zorua de Hisui (Déguisement festif) (2)-CM.png", "[[Zorua de Hisui]] (Déguisement festif)", "Image Pokémon représentant Zorua de Hisui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Zorua de Hisui (Déguisement festif)-CM.png", "[[Zorua de Hisui]] (Déguisement festif)", "Image Pokémon représentant Zorua de Hisui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Zorua de Hisui (Déguisement festif) (3)-CM.png", "[[Zorua de Hisui]] (Déguisement festif)", "Image Pokémon représentant Zorua de Hisui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Zorua de Hisui (Rouge classique)-CM.png", "[[Zorua de Hisui]] (Rouge classique)", "Image Pokémon représentant Zorua de Hisui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Zorua (Firmament brillant) (2)-CM.png", "[[Zorua]] (Firmament brillant)", "Image Pokémon représentant Zorua", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Zorua (Firmament brillant)-CM.png", "[[Zorua]] (Firmament brillant)", "Image Pokémon représentant Zorua", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Zorua (Rouge classique)-CM.png", "[[Zorua]] (Rouge classique)", "Image Pokémon représentant Zorua", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chinchidou-CM.png", "[[Chinchidou]]", "Image Pokémon représentant Chinchidou", "Artwork Pokémon de Café ReMix"}, {"Chinchidou chromatique-CM.png", "[[Chinchidou]] [[chromatique]]", "Image Pokémon représentant Chinchidou", "Artwork Pokémon chromatique de Café ReMix"}, {"Chinchidou chromatique (As du plumeau)-CM.png", "[[Chinchidou]] [[chromatique]] (As du plumeau)", "Image Pokémon représentant Chinchidou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Chinchidou chromatique (Rouge classique)-CM.png", "[[Chinchidou]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Chinchidou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Chinchidou (As du plumeau)-CM.png", "[[Chinchidou]] (As du plumeau)", "Image Pokémon représentant Chinchidou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chinchidou (Rouge classique)-CM.png", "[[Chinchidou]] (Rouge classique)", "Image Pokémon représentant Chinchidou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mesmérella-CM.png", "[[Mesmérella]]", "Image Pokémon représentant Mesmérella", "Artwork Pokémon de Café ReMix"}, {"Mesmérella (Touriste chic)-CM.png", "[[Mesmérella]] (Touriste chic)", "Image Pokémon représentant Mesmérella", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mesmérella (Rouge classique)-CM.png", "[[Mesmérella]] (Rouge classique)", "Image Pokémon représentant Mesmérella", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Emolga-CM.png", "[[Emolga]]", "Image Pokémon représentant Emolga", "Artwork Pokémon de Café ReMix"}, {"Emolga (Ruban ravissant)-CM.png", "[[Emolga]] (Ruban ravissant)", "Image Pokémon représentant Emolga", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Emolga (Rouge classique)-CM.png", "[[Emolga]] (Rouge classique)", "Image Pokémon représentant Emolga", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Funécire-CM.png", "[[Funécire]]", "Image Pokémon représentant Funécire", "Artwork Pokémon de Café ReMix"}, {"Funécire (Lanterne élégante)-CM.png", "[[Funécire]] (Lanterne élégante)", "Image Pokémon représentant Funécire", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Funécire (Rouge classique)-CM.png", "[[Funécire]] (Rouge classique)", "Image Pokémon représentant Funécire", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lugulabre-CM.png", "[[Lugulabre]]", "Image Pokémon représentant Lugulabre", "Artwork Pokémon de Café ReMix"}, {"Lugulabre chromatique-CM.png", "[[Lugulabre]] [[chromatique]]", "Image Pokémon représentant Lugulabre", "Artwork Pokémon chromatique de Café ReMix"}, {"Lugulabre chromatique (Halloween) (2)-CM.png", "[[Lugulabre]] [[chromatique]] (Halloween)", "Image Pokémon représentant Lugulabre", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lugulabre chromatique (Halloween)-CM.png", "[[Lugulabre]] [[chromatique]] (Halloween)", "Image Pokémon représentant Lugulabre", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lugulabre chromatique (Rouge classique)-CM.png", "[[Lugulabre]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Lugulabre", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Lugulabre (Halloween) (2)-CM.png", "[[Lugulabre]] (Halloween)", "Image Pokémon représentant Lugulabre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lugulabre (Halloween)-CM.png", "[[Lugulabre]] (Halloween)", "Image Pokémon représentant Lugulabre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lugulabre (Rouge classique)-CM.png", "[[Lugulabre]] (Rouge classique)", "Image Pokémon représentant Lugulabre", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Coupenotte-CM.png", "[[Coupenotte]]", "Image Pokémon représentant Coupenotte", "Artwork Pokémon de Café ReMix"}, {"Coupenotte (Rouge classique)-CM.png", "[[Coupenotte]] (Rouge classique)", "Image Pokémon représentant Coupenotte", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Roussil-CM.png", "[[Roussil]]", "Image Pokémon représentant Roussil", "Artwork Pokémon de Café ReMix"}, {"Roussil (Furisode fleuri)-CM.png", "[[Roussil]] (Furisode fleuri)", "Image Pokémon représentant Roussil", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Roussil (Halloween)-CM.png", "[[Roussil]] (Halloween)", "Image Pokémon représentant Roussil", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Roussil (Rouge classique)-CM.png", "[[Roussil]] (Rouge classique)", "Image Pokémon représentant Roussil", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Amphinobi-CM.png", "[[Amphinobi]]", "Image Pokémon représentant Amphinobi", "Artwork Pokémon de Café ReMix"}, {"Amphinobi chromatique-CM.png", "[[Amphinobi]] [[chromatique]]", "Image Pokémon représentant Amphinobi", "Artwork Pokémon chromatique de Café ReMix"}, {"Amphinobi chromatique (Chef spécial)-CM.png", "[[Amphinobi]] [[chromatique]] (Chef spécial)", "Image Pokémon représentant Amphinobi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Amphinobi chromatique (Super chef)-CM.png", "[[Amphinobi]] [[chromatique]] (Super chef)", "Image Pokémon représentant Amphinobi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Amphinobi chromatique (Rouge classique)-CM.png", "[[Amphinobi]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Amphinobi", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Amphinobi (Chef spécial)-CM.png", "[[Amphinobi]] (Chef spécial)", "Image Pokémon représentant Amphinobi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Amphinobi (Super chef)-CM.png", "[[Amphinobi]] (Super chef)", "Image Pokémon représentant Amphinobi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Amphinobi (Rouge classique)-CM.png", "[[Amphinobi]] (Rouge classique)", "Image Pokémon représentant Amphinobi", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chevroum-CM.png", "[[Chevroum]]", "Image Pokémon représentant Chevroum", "Artwork Pokémon de Café ReMix"}, {"Chevroum (Rouge classique)-CM.png", "[[Chevroum]] (Rouge classique)", "Image Pokémon représentant Chevroum", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pandespiègle-CM.png", "[[Pandespiègle]]", "Image Pokémon représentant Pandespiègle", "Artwork Pokémon de Café ReMix"}, {"Pandespiègle (Rouge classique)-CM.png", "[[Pandespiègle]] (Rouge classique)", "Image Pokémon représentant Pandespiègle", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Psystigri-CM.png", "[[Psystigri]]", "Image Pokémon représentant Psystigri", "Artwork Pokémon de Café ReMix"}, {"Psystigri (Rouge classique)-CM.png", "[[Psystigri]] (Rouge classique)", "Image Pokémon représentant Psystigri", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Cupcanaille-CM.png", "[[Cupcanaille]]", "Image Pokémon représentant Cupcanaille", "Artwork Pokémon de Café ReMix"}, {"Cupcanaille chromatique-CM.png", "[[Cupcanaille]] [[chromatique]]", "Image Pokémon représentant Cupcanaille", "Artwork Pokémon chromatique de Café ReMix"}, {"Cupcanaille chromatique (Chapeau chantilly)-CM.png", "[[Cupcanaille]] [[chromatique]] (Chapeau chantilly)", "Image Pokémon représentant Cupcanaille", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Cupcanaille chromatique (Rouge classique)-CM.png", "[[Cupcanaille]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Cupcanaille", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Cupcanaille (Chapeau chantilly)-CM.png", "[[Cupcanaille]] (Chapeau chantilly)", "Image Pokémon représentant Cupcanaille", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Cupcanaille (Rouge classique)-CM.png", "[[Cupcanaille]] (Rouge classique)", "Image Pokémon représentant Cupcanaille", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nymphali-CM.png", "[[Nymphali]]", "Image Pokémon représentant Nymphali", "Artwork Pokémon de Café ReMix"}, {"Nymphali (Festival)-CM.png", "[[Nymphali]] (Festival)", "Image Pokémon représentant Nymphali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nymphali (Chocolatier coquet) (2)-CM.png", "[[Nymphali]] (Chocolatier coquet)", "Image Pokémon représentant Nymphali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nymphali (Chocolatier coquet)-CM.png", "[[Nymphali]] (Chocolatier coquet)", "Image Pokémon représentant Nymphali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nymphali (Rouge classique)-CM.png", "[[Nymphali]] (Rouge classique)", "Image Pokémon représentant Nymphali", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mucuscule-CM.png", "[[Mucuscule]]", "Image Pokémon représentant Mucuscule", "Artwork Pokémon de Café ReMix"}, {"Mucuscule (Coussins macarons)-CM.png", "[[Mucuscule]] (Coussins macarons)", "Image Pokémon représentant Mucuscule", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mucuscule (Rouge classique)-CM.png", "[[Mucuscule]] (Rouge classique)", "Image Pokémon représentant Mucuscule", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Diancie-CM.png", "[[Diancie]]", "Image Pokémon représentant Diancie", "Artwork Pokémon de Café ReMix"}, {"Diancie (Rouge classique)-CM.png", "[[Diancie]] (Rouge classique)", "Image Pokémon représentant Diancie", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Hoopa-CM.png", "[[Hoopa]]", "Image Pokémon représentant Hoopa", "Artwork Pokémon de Café ReMix"}, {"Hoopa (Rouge classique)-CM.png", "[[Hoopa]] (Rouge classique)", "Image Pokémon représentant Hoopa", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Brindibou-CM.png", "[[Brindibou]]", "Image Pokémon représentant Brindibou", "Artwork Pokémon de Café ReMix"}, {"Brindibou chromatique-CM.png", "[[Brindibou]] [[chromatique]]", "Image Pokémon représentant Brindibou", "Artwork Pokémon chromatique de Café ReMix"}, {"Brindibou chromatique (Lit de pétales)-CM.png", "[[Brindibou]] [[chromatique]] (Lit de pétales)", "Image Pokémon représentant Brindibou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Brindibou chromatique (Majordome)-CM.png", "[[Brindibou]] [[chromatique]] (Majordome)", "Image Pokémon représentant Brindibou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Brindibou chromatique (Chapeau Plumefeuille)-CM.png", "[[Brindibou]] [[chromatique]] (Chapeau Plumefeuille)", "Image Pokémon représentant Brindibou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Brindibou chromatique (Rouge classique)-CM.png", "[[Brindibou]] [[chromatique]] (Rouge classique)", "Image Pokémon représentant Brindibou", "Artwork Pokémon chromatique (Personnel) de Café ReMix"}, {"Brindibou (Lit de pétales)-CM.png", "[[Brindibou]] (Lit de pétales)", "Image Pokémon représentant Brindibou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Brindibou (Majordome)-CM.png", "[[Brindibou]] (Majordome)", "Image Pokémon représentant Brindibou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Brindibou (Chapeau Plumefeuille)-CM.png", "[[Brindibou]] (Chapeau Plumefeuille)", "Image Pokémon représentant Brindibou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Brindibou (Rouge classique)-CM.png", "[[Brindibou]] (Rouge classique)", "Image Pokémon représentant Brindibou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Flamiaou-CM.png", "[[Flamiaou]]", "Image Pokémon représentant Flamiaou", "Artwork Pokémon de Café ReMix"}, {"Flamiaou (Rouge classique)-CM.png", "[[Flamiaou]] (Rouge classique)", "Image Pokémon représentant Flamiaou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Bazoucan-CM.png", "[[Bazoucan]]", "Image Pokémon représentant Bazoucan", "Artwork Pokémon de Café ReMix"}, {"Bazoucan (Rouge classique)-CM.png", "[[Bazoucan]] (Rouge classique)", "Image Pokémon représentant Bazoucan", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Rubombelle-CM.png", "[[Rubombelle]]", "Image Pokémon représentant Rubombelle", "Artwork Pokémon de Café ReMix"}, {"Rubombelle (Rouge classique)-CM.png", "[[Rubombelle]] (Rouge classique)", "Image Pokémon représentant Rubombelle", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chelours-CM.png", "[[Chelours]]", "Image Pokémon représentant Chelours", "Artwork Pokémon de Café ReMix"}, {"Chelours (Pâtissier annelets)-CM.png", "[[Chelours]] (Pâtissier annelets)", "Image Pokémon représentant Chelours", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chelours (Rouge classique)-CM.png", "[[Chelours]] (Rouge classique)", "Image Pokémon représentant Chelours", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Candine-CM.png", "[[Candine]]", "Image Pokémon représentant Candine", "Artwork Pokémon de Café ReMix"}, {"Candine (Déguisement festif)-CM.png", "[[Candine]] (Déguisement festif)", "Image Pokémon représentant Candine", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Candine (Étoile magique)-CM.png", "[[Candine]] (Étoile magique)", "Image Pokémon représentant Candine", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Candine (Rouge classique)-CM.png", "[[Candine]] (Rouge classique)", "Image Pokémon représentant Candine", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mimiqui-CM.png", "[[Mimiqui]]", "Image Pokémon représentant Mimiqui", "Artwork Pokémon de Café ReMix"}, {"Mimiqui (Halloween) (2)-CM.png", "[[Mimiqui]] (Halloween)", "Image Pokémon représentant Mimiqui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mimiqui (Halloween)-CM.png", "[[Mimiqui]] (Halloween)", "Image Pokémon représentant Mimiqui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mimiqui (Thé enchanté)-CM.png", "[[Mimiqui]] (Thé enchanté)", "Image Pokémon représentant Mimiqui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mimiqui (Rouge classique)-CM.png", "[[Mimiqui]] (Rouge classique)", "Image Pokémon représentant Mimiqui", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Cosmog-CM.png", "[[Cosmog]]", "Image Pokémon représentant Cosmog", "Artwork Pokémon de Café ReMix"}, {"Cosmog (Rouge classique)-CM.png", "[[Cosmog]] (Rouge classique)", "Image Pokémon représentant Cosmog", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ouistempo-CM.png", "[[Ouistempo]]", "Image Pokémon représentant Ouistempo", "Artwork Pokémon de Café ReMix"}, {"Ouistempo (Rock'n'Roll)-CM.png", "[[Ouistempo]] (Rock'n'Roll)", "Image Pokémon représentant Ouistempo", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ouistempo (Casquette de batteur)-CM.png", "[[Ouistempo]] (Casquette de batteur)", "Image Pokémon représentant Ouistempo", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Ouistempo (Rouge classique)-CM.png", "[[Ouistempo]] (Rouge classique)", "Image Pokémon représentant Ouistempo", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Flambino-CM.png", "[[Flambino]]", "Image Pokémon représentant Flambino", "Artwork Pokémon de Café ReMix"}, {"Flambino (Ensemble fleuri)-CM.png", "[[Flambino]] (Ensemble fleuri)", "Image Pokémon représentant Flambino", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Flambino (Vacancier au soleil)-CM.png", "[[Flambino]] (Vacancier au soleil)", "Image Pokémon représentant Flambino", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Flambino (Casquette football)-CM.png", "[[Flambino]] (Casquette football)", "Image Pokémon représentant Flambino", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Flambino (Rouge classique)-CM.png", "[[Flambino]] (Rouge classique)", "Image Pokémon représentant Flambino", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Larméléon-CM.png", "[[Larméléon]]", "Image Pokémon représentant Larméléon", "Artwork Pokémon de Café ReMix"}, {"Larméléon (Matelot)-CM.png", "[[Larméléon]] (Matelot)", "Image Pokémon représentant Larméléon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Larméléon (Rouge classique)-CM.png", "[[Larméléon]] (Rouge classique)", "Image Pokémon représentant Larméléon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lézargus-CM.png", "[[Lézargus]]", "Image Pokémon représentant Lézargus", "Artwork Pokémon de Café ReMix"}, {"Lézargus (Serveur charmant) (2)-CM.png", "[[Lézargus]] (Serveur charmant)", "Image Pokémon représentant Lézargus", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lézargus (Serveur charmant)-CM.png", "[[Lézargus]] (Serveur charmant)", "Image Pokémon représentant Lézargus", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Lézargus (Rouge classique)-CM.png", "[[Lézargus]] (Rouge classique)", "Image Pokémon représentant Lézargus", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Rongrigou-CM.png", "[[Rongrigou]]", "Image Pokémon représentant Rongrigou", "Artwork Pokémon de Café ReMix"}, {"Rongrigou (Boulanger artisanal)-CM.png", "[[Rongrigou]] (Boulanger artisanal)", "Image Pokémon représentant Rongrigou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Rongrigou (Rouge classique)-CM.png", "[[Rongrigou]] (Rouge classique)", "Image Pokémon représentant Rongrigou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Voltoutou-CM.png", "[[Voltoutou]]", "Image Pokémon représentant Voltoutou", "Artwork Pokémon de Café ReMix"}, {"Voltoutou (Chef glouton) (2)-CM.png", "[[Voltoutou]] (Chef glouton)", "Image Pokémon représentant Voltoutou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Voltoutou (Chef glouton)-CM.png", "[[Voltoutou]] (Chef glouton)", "Image Pokémon représentant Voltoutou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Voltoutou (Rouge classique)-CM.png", "[[Voltoutou]] (Rouge classique)", "Image Pokémon représentant Voltoutou", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chapotus-CM.png", "[[Chapotus]]", "Image Pokémon représentant Chapotus", "Artwork Pokémon de Café ReMix"}, {"Chapotus (Rouge classique)-CM.png", "[[Chapotus]] (Rouge classique)", "Image Pokémon représentant Chapotus", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Charmilly (Lait Vanille)-CM.png", "[[Charmilly]] (Lait Vanille)", "Image Pokémon représentant Charmilly", "Artwork Pokémon de Café ReMix"}, {"Charmilly (Mélange Tricolore)-CM.png", "[[Charmilly]] (Mélange Tricolore)", "Image Pokémon représentant Charmilly", "Artwork Pokémon de Café ReMix"}, {"Charmilly (Mélange Tricolore) (Rouge classique)-CM.png", "[[Charmilly (Mélange Tricolore) (Rouge classique)", "Image Pokémon représentant Charmilly", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Charmilly (Lait Vanille) (Chocolatier coquet)-CM.png", "[[Charmilly (Lait Vanille) (Chocolatier coquet)", "Image Pokémon représentant Charmilly", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Charmilly (Lait Vanille) (Rouge classique)-CM.png", "[[Charmilly (Lait Vanille) (Rouge classique)", "Image Pokémon représentant Charmilly", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Frissonille-CM.png", "[[Frissonille]]", "Image Pokémon représentant Frissonille", "Artwork Pokémon de Café ReMix"}, {"Frissonille (Rouge classique)-CM.png", "[[Frissonille]] (Rouge classique)", "Image Pokémon représentant Frissonille", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Fantyrm-CM.png", "[[Fantyrm]]", "Image Pokémon représentant Fantyrm", "Artwork Pokémon de Café ReMix"}, {"Dispareptil (2)-CM.png", "[[Dispareptil]]", "Image Pokémon représentant Dispareptil", "Artwork Pokémon de Café ReMix"}, {"Fantyrm (Rouge classique)-CM.png", "[[Fantyrm]] (Rouge classique)", "Image Pokémon représentant Fantyrm", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dispareptil (Rouge classique) (2)-CM.png", "[[Dispareptil]] (Rouge classique)", "Image Pokémon représentant Dispareptil", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Dispareptil-CM.png", "[[Dispareptil]]", "Image Pokémon représentant Dispareptil", "Artwork Pokémon de Café ReMix"}, {"Dispareptil (Rouge classique)-CM.png", "[[Dispareptil]] (Rouge classique)", "Image Pokémon représentant Dispareptil", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Sylveroy-CM.png", "[[Sylveroy]]", "Image Pokémon représentant Sylveroy", "Artwork Pokémon de Café ReMix"}, {"Sylveroy (Rouge classique)-CM.png", "[[Sylveroy]] (Rouge classique)", "Image Pokémon représentant Sylveroy", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Poussacha-CM.png", "[[Poussacha]]", "Image Pokémon représentant Poussacha", "Artwork Pokémon de Café ReMix"}, {"Poussacha (Chef amical)-CM.png", "[[Poussacha]] (Chef amical)", "Image Pokémon représentant Poussacha", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Poussacha (Rouge classique)-CM.png", "[[Poussacha]] (Rouge classique)", "Image Pokémon représentant Poussacha", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Miascarade (2)-CM.png", "[[Miascarade]]", "Image Pokémon représentant Miascarade", "Artwork Pokémon de Café ReMix"}, {"Miascarade-CM.png", "[[Miascarade]]", "Image Pokémon représentant Miascarade", "Artwork Pokémon de Café ReMix"}, {"Miascarade (Rouge classique) (2)-CM.png", "[[Miascarade]] (Rouge classique)", "Image Pokémon représentant Miascarade", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Miascarade (Rouge classique)-CM.png", "[[Miascarade]] (Rouge classique)", "Image Pokémon représentant Miascarade", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chochodile-CM.png", "[[Chochodile]]", "Image Pokémon représentant Chochodile", "Artwork Pokémon de Café ReMix"}, {"Chochodile (Chef amical)-CM.png", "[[Chochodile]] (Chef amical)", "Image Pokémon représentant Chochodile", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Chochodile (Rouge classique)-CM.png", "[[Chochodile]] (Rouge classique)", "Image Pokémon représentant Chochodile", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Coiffeton-CM.png", "[[Coiffeton]]", "Image Pokémon représentant Coiffeton", "Artwork Pokémon de Café ReMix"}, {"Coiffeton (Chef amical)-CM.png", "[[Coiffeton]] (Chef amical)", "Image Pokémon représentant Coiffeton", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Coiffeton (Rouge classique)-CM.png", "[[Coiffeton]] (Rouge classique)", "Image Pokémon représentant Coiffeton", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Gourmelet-CM.png", "[[Gourmelet]]", "Image Pokémon représentant Gourmelet", "Artwork Pokémon de Café ReMix"}, {"Gourmelet (Rouge classique)-CM.png", "[[Gourmelet]] (Rouge classique)", "Image Pokémon représentant Gourmelet", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pohmotte-CM.png", "[[Pohmotte]]", "Image Pokémon représentant Pohmotte", "Artwork Pokémon de Café ReMix"}, {"Pohmotte (Chef nostalgique)-CM.png", "[[Pohmotte]] (Chef nostalgique)", "Image Pokémon représentant Pohmotte", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pohmotte (Rouge classique)-CM.png", "[[Pohmotte]] (Rouge classique)", "Image Pokémon représentant Pohmotte", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pâtachiot-CM.png", "[[Pâtachiot]]", "Image Pokémon représentant Pâtachiot", "Artwork Pokémon de Café ReMix"}, {"Pâtachiot (Célébration grandiose)-CM.png", "[[Pâtachiot]] (Célébration grandiose)", "Image Pokémon représentant Pâtachiot", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Pâtachiot (Rouge classique)-CM.png", "[[Pâtachiot]] (Rouge classique)", "Image Pokémon représentant Pâtachiot", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Forgelina (2)-CM.png", "[[Forgelina]]", "Image Pokémon représentant Forgelina", "Artwork Pokémon de Café ReMix"}, {"Forgelina-CM.png", "[[Forgelina]]", "Image Pokémon représentant Forgelina", "Artwork Pokémon de Café ReMix"}, {"Forgelina (Tradition mochi) (2)-CM.png", "[[Forgelina]] (Tradition mochi)", "Image Pokémon représentant Forgelina", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Forgelina (Tradition mochi) (3)-CM.png", "[[Forgelina]] (Tradition mochi)", "Image Pokémon représentant Forgelina", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Forgelina (Tradition mochi)-CM.png", "[[Forgelina]] (Tradition mochi)", "Image Pokémon représentant Forgelina", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Forgelina (Rouge classique)-CM.png", "[[Forgelina]] (Rouge classique)", "Image Pokémon représentant Forgelina", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nigirigon (Forme Courbée)-CM.png", "[[Nigirigon]] (Forme Courbée)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon de Café ReMix"}, {"Nigirigon (Forme Courbée) (2)-CM.png", "[[Nigirigon]] (Forme Courbée)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon de Café ReMix"}, {"Nigirigon (Forme Courbée) (Rouge classique) (2)-CM.png", "[[Nigirigon (Forme Courbée) (Rouge classique)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nigirigon (Forme Courbée) (Rouge classique)-CM.png", "[[Nigirigon (Forme Courbée) (Rouge classique)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nigirigon (Forme Affalée)-CM.png", "[[Nigirigon]] (Forme Affalée)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon de Café ReMix"}, {"Nigirigon (Forme Affalée) (2)-CM.png", "[[Nigirigon]] (Forme Affalée)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon de Café ReMix"}, {"Nigirigon (Forme Affalée) (Rouge classique) (2)-CM.png", "[[Nigirigon (Forme Affalée) (Rouge classique)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nigirigon (Forme Affalée) (Rouge classique)-CM.png", "[[Nigirigon (Forme Affalée) (Rouge classique)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nigirigon (Forme Raide)-CM.png", "[[Nigirigon]] (Forme Raide)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon de Café ReMix"}, {"Nigirigon (Forme Raide) (2)-CM.png", "[[Nigirigon]] (Forme Raide)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon de Café ReMix"}, {"Nigirigon (Forme Raide) (Rouge classique) (2)-CM.png", "[[Nigirigon (Forme Raide) (Rouge classique)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Nigirigon (Forme Raide) (Rouge classique)-CM.png", "[[Nigirigon (Forme Raide) (Rouge classique)", "Image Pokémon représentant Nigirigon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Hurle-Queue-CM.png", "[[Hurle-Queue]]", "Image Pokémon représentant Hurle-Queue", "Artwork Pokémon de Café ReMix"}, {"Hurle-Queue (Rouge classique)-CM.png", "[[Hurle-Queue]] (Rouge classique)", "Image Pokémon représentant Hurle-Queue", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mordudor (Forme Coffre)-CM.png", "[[Mordudor]] (Forme Coffre)", "Image Pokémon représentant Mordudor", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Mordudor (Forme Marche)-CM.png", "[[Mordudor]] (Forme Marche)", "Image Pokémon représentant Mordudor", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Gromago-CM.png", "[[Gromago]]", "Image Pokémon représentant Gromago", "Artwork Pokémon de Café ReMix"}, {"Gromago (Rouge classique)-CM.png", "[[Gromago]] (Rouge classique)", "Image Pokémon représentant Gromago", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Koraidon-CM.png", "[[Koraidon]]", "Image Pokémon représentant Koraidon", "Artwork Pokémon de Café ReMix"}, {"Koraidon (Rouge classique)-CM.png", "[[Koraidon]] (Rouge classique)", "Image Pokémon représentant Koraidon", "Artwork Pokémon (Personnel) de Café ReMix"}, {"Miraidon-CM.png", "[[Miraidon]]", "Image Pokémon représentant Miraidon", "Artwork Pokémon de Café ReMix"}, {"Miraidon (Rouge classique)-CM.png", "[[Miraidon]] (Rouge classique)", "Image Pokémon représentant Miraidon", "Artwork Pokémon (Personnel) de Café ReMix"}};
		String descriptionHeader = ""; // "== Description ==\n\n";
		
		for (String[] replacements : replacementsList) {
			String description = "{{Image reconstruite}}\n"
					+ "== Description ==\n"
					+ "Artwork ZZZ$2 dans {{Jeu|CM}}.\n"
					+ "\n"
					+ "{{Informations Fichier\n"
					+ "| Source = Image reconstruite par 日月. Réutilisation commerciale interdite.\n"
					+ "| Auteur = [[Genius Sonority]]\n"
					+ "}}\n"
					+ "\n"
					+ "[[Catégorie:$4]]\n"
					+ "[[Catégorie:$3]]\n";
			
			for (int i = 0; i < 4; i++) {
				description = description.replace("$" + Integer.toString(i+1), replacements[i]);
			}
			String nameWithoutBrackets = replacements[1].replace("[", "");
			description = description.replace("ZZZ", Util.de(nameWithoutBrackets));
			
			String fileName = replacements[0];
			File file = new File(path + fileName);

			boolean uploaded = API.upload("Fichier:" + replacements[0], file, descriptionHeader + description,
					description);
			
			// These two lines shouldn't do anything unless the description wasn't set by the upload before.
			// For instance, if there was already an existing version.
			Page page = new Page("Fichier:" + fileName);
			page.setContent(descriptionHeader + description, description);

			
			String uploadSituation;
			if (uploaded) {
				uploadSituation = "ok";
			} else {
				uploadSituation = "PAS OK !!!!";
			}
			System.out.println(fileName + " " + uploadSituation);
		
			if (justOne) {
				break;
			}
		}
	}
	
	public void uploadSprites(File folderPath, String extension, String edit_description, String source, boolean createGeneralRedirection, boolean rename, int starting_version, boolean justOne) {
		File contents[] = folderPath.listFiles();
		boolean eraseRedirectsAnyway = true;
		if (!source.equals("")) {
			source = "|source=" + source;
		}
		String description = "== Description ==\n{{#invoke:Description|sprite" + source + "}}";
		// description = "";
		
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String ogUploadName		= "Fichier:" + contents[i].getName();
			String uploadName		= "Fichier:" + contents[i].getName();
			System.out.println(uploadName);
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals("." + extension)) {
				uploadName = uploadName.replace("interrogation", "?");

				
				Page filePage = new Page(uploadName);
				Page ogFilePage = new Page(uploadName);
				String fileContents = filePage.getContent();
				int version = starting_version;
				
				
				if (createGeneralRedirection) {
					
					String generalRedirectionName = uploadName.replaceFirst(" [^\\s]*\\." + extension, "." + extension);
					Page generalRedirectionPage = new Page(generalRedirectionName);
					String generalRedirectionContents = generalRedirectionPage.getContent();
					
					if (generalRedirectionContents == null || !(generalRedirectionContents.contains("#REDIRECT"))) {
						Login.login("Matt.");
						API.delete(generalRedirectionName, "[Modification par robot] Page supprimée pour permettre une nouvelle redirection");					
						Login.login("Silvallié");
					}
					generalRedirectionPage.setContent("#REDIRECTION [[" + uploadName + "]]\n[[Catégorie:Miniature Pokémon]]",
							"Redirection vers [[" + uploadName + "]]");
					
				}
				else if (rename) {
					while (fileContents != null) {
						version++;
						uploadName = ogUploadName.replace(".png", "-v" + version + "." + extension);
	
						filePage = new Page(uploadName);
						fileContents = filePage.getContent();
						
					}
				}
				
				if (version != 0) {
					System.out.println("Renommage "+ogUploadName+" => "+uploadName);
					 API.rename(ogUploadName, uploadName, false, "Renommage "+ogUploadName+" => "+uploadName);
				}
				// to erase
				if (eraseRedirectsAnyway || !fileContents.contains("#REDIRECT")) {
					
					System.out.println("Upload "+ogUploadName);
					boolean uploaded = API.upload(ogUploadName, contents[i], description,
	////						"Correction du fichier");
							edit_description);
					// filePage.setContent(description, edit_description);
					
					if (justOne) {
						break;
					}
				}
			}
		}
	}
	
	public void uploadSprites(File folderPath, String gamesShortName, String gamesLongName, boolean justOne) {
		
		File contents[] = folderPath.listFiles();
		String descriptionHeader = "== Description ==\n\n";
				
		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				String imageType = "Sprite";
				String categoryType = "Sprite";
				if (uploadName.contains("Fichier:Pose ")) {
					imageType = "Pose";
				}
				if (uploadName.contains("Fichier:Miniature ")) {
					imageType = "Miniature";
					categoryType = "Miniature";
				}
				String 		pokeNumberWithForm 	= uploadName.replace("Fichier:" + imageType + " ", "").replace(" " + gamesShortName + ".png", "");
				String[] 	pokeNumberSplit 	= pokeNumberWithForm.split(" ");
				String		pokeNumberString	= pokeNumberSplit[0];
				int 		pokeNumber 			= Integer.parseInt(pokeNumberString);
				String 		pokeName 			= PokeData.getPokemonName(pokeNumber);
				String 		nomSpecialForme 	= null;
				String 		formCategorySuffix 	= "";
				
				int pnsLength = pokeNumberSplit.length;
				int pnsBeginning = 1;
				
				if (pnsBeginning < pnsLength) {
					pnsBeginning++;
					
					
					switch(pokeNumberSplit[pnsBeginning - 1]) {
						case "Alola":
							pokeName += " d'Alola";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Galar":
							pokeName += " de Galar";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Hisui":
							pokeName += " de Hisui";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Méga":
							pokeName = "Méga-" + pokeName;
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Gigamax":
							pokeName += " Gigamax";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Infinimax":
							pokeName += " Infinimax";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Noir":
							if (pokeName == "Kyurem") {
								pokeName += " Noir";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Blanc":
							if (pokeName == "Kyurem") {
								pokeName += " Blanc";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Ailes de l'Auore":
							pokeName += " Ailes de l'Aurore";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Crinière du Couchant":
							pokeName += " Crinière du Couchant";
							pokeNumberSplit[pnsBeginning - 1] = "";
							break;
						case "Ultra":
							if (pokeName == "Necrozma") {
								pokeName = "Ultra-" + pokeName;
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Cavalier du Froid":
							if (pokeName == "Sylveroy") {
								pokeName += " Cavalier du Froid";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						case "Cavalier d'Effroi":
							if (pokeName == "Sylveroy") {
								pokeName += " Cavalier d'Effroi";
								pokeNumberSplit[pnsBeginning - 1] = "";
							};
							break;
						default:
							pnsBeginning--;
							break;
					}
				}
				
				String last = pokeNumberSplit[pnsLength - 1];
				
				switch(pokeNumber) {
					case 25:	// Pikachu
						if (last.equals(pokeNumberString)) {
							break;
						} else if (last.equals("Cosplayeur") || last.equals("Rockeur") || last.equals("Lady")
								 || last.equals("Star") || last.equals("Docteur") || last.equals("Catcheur")
								 || last.equals("Partenaire")) {
							nomSpecialForme = "";
						} else if (pokeNumberSplit[1].equals("Casquette")) {
							nomSpecialForme = " à";
						}
						break;
					case 133:	// Évoli
						if (last.equals("Partenaire")) {
							nomSpecialForme = "";
						}
						break;
					case 201:	// Zarbi
						nomSpecialForme = "";
						formCategorySuffix = " " + pokeNumberSplit[pnsBeginning];
						break;
					case 412:	// Cheniti
						nomSpecialForme = " Cape";
						break;
					case 413:	// Cheniselle
						nomSpecialForme = " Cape";
						break;
					case 421:	// Ceriflor
						nomSpecialForme = " Temps";
						break;
					case 422:	// Sancoki
						nomSpecialForme = " Mer";
						break;
					case 423:	// Tritosor
						nomSpecialForme =  " Mer";
						break;
					case 479:	// Motisma
						nomSpecialForme = "";
						break;
					case 493:	// Arceus
						nomSpecialForme = " Type";
						break;
					case 550:	// Bargantua
						nomSpecialForme = " Motif";
						break;
					case 555:	// Darumacho
						nomSpecialForme = " Mode";
						if (last.equals("") || last.equals(pokeNumberString)) {
							nomSpecialForme += " Normal";
						}
						break;
					case 647:	// Keldeo
						nomSpecialForme = " Aspect";
						if (last.equals("") || last.equals(pokeNumberString)) {
							nomSpecialForme += " Normal";
						}
						break;
					case 649:	// Genesect
						if (!(last.equals("") || last.equals(pokeNumberString))) {
							nomSpecialForme = " avec son [[Module]]";
						}
						break;
					case 666:	// Prismillon
						nomSpecialForme = " Motif";
						break;
					case 669:	// Flabébé
						nomSpecialForme = " Fleur";
						break;
					case 670:	// Floette
						if (!pokeNumberSplit[pnsBeginning].equals("Éternelle")) {
							nomSpecialForme = " Fleur";
						}
						break;
					case 671:	// Florges
						nomSpecialForme = " Fleur";
						break;
					case 676:	// Couafarel
						if (!(last.equals("") || last.equals(pokeNumberString) || last.equals("Sauvage"))) {
							nomSpecialForme = " Coupe";
						}
						break;
					case 710:	// Pitrouille
						nomSpecialForme = " Taille";
						break;
					case 711:	// Banshitrouye
						nomSpecialForme = " Taille";
						break;
					case 716:	// Xerneas
						nomSpecialForme = " Mode";
						break;
					case 720:	// Hoopa
						nomSpecialForme = "";
						break;
					case 741:	// Plumeline
						nomSpecialForme = " Style";
					case 773:	// Silvallié
						nomSpecialForme = " dans sa [[forme]] Type : ";
						break;
					case 774:	// Météno
						if (!(last.equals("") || last.equals(pokeNumberString) || last.equals("Météore"))) {
							nomSpecialForme = " Noyau";
						}
						break;
					case 877:	// Morpeko
						nomSpecialForme = " Mode";
						break;
					case 892:	// Shifours
						nomSpecialForme = " Style";
						break;
				}
				
				
				// suffixes de forme
				String genre = "";
				if (pnsBeginning < pnsLength && pokeNumberSplit[pnsBeginning].equals("♂")) {
					genre = " mâle";
					pokeNumberSplit[pnsBeginning] = "";
					pnsBeginning++;
				} else if (pnsBeginning < pnsLength && pokeNumberSplit[pnsBeginning].equals("♀")) {
					genre = " femelle";
					pokeNumberSplit[pnsBeginning] = "";
					pnsBeginning++;
				}
				
				String dosDescription = "";
				String dosCategorie = "";
				if (pokeNumberSplit[pnsLength - 1].equals("dos")) {
					dosDescription = ", de dos,";
					dosCategorie = " de dos";
					pnsLength--;
				}
				
				String chromatiqueDescription = "";
				String chromatiqueCategorie = "";
				if (pokeNumberSplit[pnsLength - 1].equals("chromatique")) {
					chromatiqueDescription = " [[chromatique]]";
					chromatiqueCategorie = " chromatique";
					pnsLength--;
				}
				

				String forme = "";
				boolean formeInit = false;
				if (nomSpecialForme != null) {
					forme = nomSpecialForme;
					formeInit = true;
				}
				for (int j = 1; j < pnsLength; j++) {
					if (!pokeNumberSplit[j].equals("")) {
						if (!formeInit) {
							forme += " dans sa [[forme]] " + pokeNumberSplit[j];
							formeInit = true;
						} else {
							forme += " " + pokeNumberSplit[j];
						}
					}
				}

				
				String description = imageType + " " + Util.de(pokeName) + "[[" + pokeName + "]]" + genre + chromatiqueDescription
						+ forme + dosDescription + " dans {{Jeu|" + gamesShortName
						+ "}}.\n\n" + "Source : Serebii\n\n" + "[[Catégorie:Image Pokémon représentant " + pokeName + formCategorySuffix
						+ "]]\n[[Catégorie:" + categoryType + " Pokémon" + chromatiqueCategorie + dosCategorie + " (" + gamesLongName + ")]]";

				
				System.out.println(description);
				System.out.println("=============");
				
//				boolean uploaded = true;
				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i], descriptionHeader + description,
//						"Correction du fichier");
						description);
				Page filePage = new Page(uploadName);
				filePage.setContent(descriptionHeader + description, description);
				
				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(contentString);
//				page.setContent(descriptionHeader + description, description);
				
				
				String uploadSituation;
				if (uploaded) {
					uploadSituation = "ok";
				} else {
					uploadSituation = "PAS OK !!!!";
				}
				
				System.out.println(uploadName + " " + uploadSituation);
			
				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadCards(File folderPath, File listPath, boolean justOne) throws IOException, InterruptedException {
		FileReader		fr					= new FileReader(listPath);
		BufferedReader	br					= new BufferedReader(fr);
		
		String			delimiter			= "XXXXX";
		String			currentLine			= br.readLine();
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";
		

		File contents[] = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(".png")) {
				while (currentLine != null && !(currentLine.equals(delimiter))) {
					description		+= currentLine + "\n";
					currentLine		= br.readLine();
				}
				currentLine		= br.readLine();
				
//				if (i<180) {
//					continue;
//				}
				boolean uploaded = API.upload("Fichier:" + contents[i].getName(), contents[i],
						descriptionHeader + description, description);
				String uploadSituation;
				if (uploaded)
					uploadSituation = "ok";
				else
					uploadSituation = "PAS OK !!!!";
				System.out.println(description);

				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
				page.setContent(descriptionHeader + description, description);
				
				System.out.println(uploadName + " " + uploadSituation);
				
				TimeUnit.SECONDS.sleep(1);
				

				if (justOne) {
					break;
				}
			}
		}
		
		br.close();
	}
	
	
	public void uploadCardArticles(File folderPath, boolean skipExistingArticles, boolean justOne) throws IOException {
		File contents[] = folderPath.listFiles();
		
		for(int i=0; i<contents.length; i++) {
			String fileName = contents[i].getName();

			
			if (fileName.substring(fileName.length()-4,fileName.length()).equals(".txt")) {
				String uploadName = contents[i].getName().replace(".txt", "").replace("$", ":");
				
				Page page = new Page(uploadName);
				String pageContents = page.getContent();
				
				if (!skipExistingArticles || pageContents == null || pageContents == "") {

					String fileContents = new String(Files.readAllBytes(Paths.get(folderPath + "\\" + fileName)), StandardCharsets.UTF_8);
					
					if (fileContents.contains("carte-identique")) {
						
					
					String description = "{{Édité par robot|Édition initiale des articles de cartes du JCC.}}\n" + fileContents;
					
					page.setContent(description, "Ajout des cartes identiques");
					
					System.out.println(uploadName + " ok");
					
					if (justOne) {
						break;
					}
					}
				}
				
				

			}
		}
	}
	
	public void uploadCT(File folderPath, File listPath, String gamesShort, String games, boolean justOne) throws IOException {
		FileReader		fr					= new FileReader(listPath);
		BufferedReader	br					= new BufferedReader(fr);
		
		String			delimiter			= ";";
		String			currentLine			= br.readLine();
		String			descriptionHeader	= "== Description ==\n";
		

		while (currentLine != null) {
			String[] currentLineSplit = currentLine.split(";");
			String name = currentLineSplit[0];
			
			if (!name.equals("")) {
				String CTNumber			= name.split(" ")[1];
				String uploadName		= "Fichier:" + name;
				String description		= "Vignette de la [[" + CTNumber + "]] dans {{Jeu|" + gamesShort + "}}.\n\n"
						+ "[[Catégorie:Vignette de CT (" + games + ")]]";
				for(int i=1;i<currentLineSplit.length;i++) {
					description += "\n[[Catégorie:Image Pokémon représentant " + currentLineSplit[i] + "]]";
				}
				
				System.out.println(folderPath);
				System.out.println(folderPath+ "\\" + name);
				File file = new File(folderPath + "\\" + name);
				
				boolean uploaded = API.upload("Fichier:" + name, file,
						descriptionHeader + description, description);
				String uploadSituation;
				if (uploaded)
					uploadSituation = "ok";
				else
					uploadSituation = "PAS OK !!!!";
				System.out.println(description);

				// These two lines shouldn't do anything unless the description wasn't set by the upload before.
				// For instance, if there was already an existing version.
				Page page = new Page(uploadName);
				page.setContent(descriptionHeader + description, description);
				
				System.out.println(uploadName + " " + uploadSituation);
				

				if (justOne) {
					break;
				}
			}

			currentLine = br.readLine();
		}
		
		br.close();
	}
	
	public void uploadAttacks(File folderPath, String gameShortName, String gameLongName, boolean addToPage, boolean upload, boolean justOne) throws IOException {		
		String			delimiter			= "$";
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";
		String			extension			= ".mp4";
		

		File contents[] = folderPath.listFiles();
		boolean skip = true;

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String fileName			= contents[i].getName();
			
			if (fileName.substring(fileName.length()-4,fileName.length()).equals(extension)) {
				String nameList	= fileName.substring(0,fileName.length()-4);
				nameList = nameList.replace("_", "'");
				nameList = nameList.replace("$", "&");
				nameList = nameList.replace(" " + gameShortName + "&", "&");
				
				String[] listNames = nameList.split("&");
				
				String attackName = listNames[0];
				String uploadName = "Fichier:" + attackName + " " + gameShortName + extension;
				String[] attackLinkThenPrecision = attackName.split(" \\(");
				String attackLink = attackLinkThenPrecision[0];
				String attackPrecision = "";
				if (attackLinkThenPrecision.length > 1) {
					attackPrecision = " (" + attackLinkThenPrecision[1];
				}
				
				if (skip && !attackLink.equals("Clairvoyance")) {
					continue;
				} else {
					skip = false;
				}
				
				// homonymies
				Page attackPage = new Page(attackLink);
				String attackPageContents = attackPage.getContent();
				if (attackPageContents.contains("{{homonymie}}") || attackPageContents.contains("{{Homonymie}}")) {
					attackLink = attackLink + " (capacité)|" + attackLink;
				}
				
				description += "Animation de la [[capacité]] [[" + attackLink + "]]" + attackPrecision
							+ " dans {{Jeu|" + gameShortName + "}}.\n\n"
							+ "{{Informations Fichier\n"
							+ "| Source = Capture d'écran par {{Ut|Ludghe}}.\n"
							+ "| Auteur = [[GAME FREAK (studio de développement)|GAME FREAK]]\n"
							+ "}}\n\n"
							+ "[[Catégorie:Image de capacité de Pokémon " + gameLongName + "]]";
				
				for(int j=1; j<listNames.length; j++) {
					description += "\n[[Catégorie:Image Pokémon représentant " + listNames[j] + "]]";
				}
				
				System.out.println("\n=== " + uploadName + " ===");
				System.out.println(description);

				if (upload) {
					boolean uploaded = API.upload(uploadName, contents[i],
							descriptionHeader + description, description);
					String uploadSituation;
					if (uploaded)
						uploadSituation = "ok";
					else
						uploadSituation = "PAS OK !!!!";
//					System.out.println(description);
	
					// These two lines shouldn't do anything unless the description wasn't set by the upload before.
					// For instance, if there was already an existing version.
					Page page = new Page(uploadName);
					page.setContent(descriptionHeader + description, description);
					
					System.out.println(uploadName + " " + uploadSituation);
				}
				
				if (addToPage) {
					attackPage = new Page(attackLink.replaceAll("\\|[^\n]*", ""));
					String attackPageContentsOrigins = attackPage.getContent();

//					Pattern p = Pattern.compile("(?<a>{{#invoke:Représentations antérieures[^}]*)}}");
//					
//					boolean firstGame = true;
//					Stream<MatchResult> strings = p.matcher(attackPageContents).results();
//					
//					for (MatchResult m : (Iterable<MatchResult>) () -> strings.iterator()) {
//						
//						String game = attackPageContents.subSequence(m.start() + 1, attackPageContents.indexOf(".", m.start())).toString();
//						if (firstGame) {
//							firstGame = false;
//						} else {
//							attackPageContents = attackPageContents + "/";
//						}
//						gamesString = gamesString + game;
//					}
//					attackPageContents.replaceFirst(attackPrecision, attackPageContents)

//					attackPageContents = attackPageContentsOrigins.replaceFirst("(?<a>\\{\\{#invoke:Représentations antérieures[^\\n]*)\\}\\}", "$1/NB}}");
					attackPageContents = attackPageContentsOrigins.replaceFirst(
							"(?<a>\\{\\{#invoke:Représentations antérieures[^\\n]*)\\}\\}",
							"=== Jeux principaux ===\n$1}}\n\n=== Jeux secondaires ===\n" +
							"{{#invoke:Représentations antérieures|capacite|" + gameShortName + "}}");
					
//					attackPageContents = attackPageContents.replace("LPA/NB", "NB/LPA");
//					attackPageContents = attackPageContents.replace("DEPS/NB", "NB/DEPS");
//					attackPageContents = attackPageContents.replace("EB/NB", "NB/EB");
//					attackPageContents = attackPageContents.replace("LGPE/NB", "NB/LGPE");
//					attackPageContents = attackPageContents.replace("USUL/NB", "NB/USUL");
//					attackPageContents = attackPageContents.replace("SL/NB", "NB/SL");
//					attackPageContents = attackPageContents.replace("ROSA/NB", "NB/ROSA");
//					attackPageContents = attackPageContents.replace("XY/NB", "NB/XY");
//					attackPageContents = attackPageContents.replace("N2B2/NB", "NB/N2B2");
//					attackPageContents = attackPageContents.replace("NB/NB/", "NB/");
					
					attackPageContents = attackPageContents.replace("=== Jeux principaux ===\n=== Jeux principaux ===", "=== Jeux principaux ===");
					attackPageContents = attackPageContents.replaceAll(
							"=== Jeux secondaires ===\n\\{\\{#invoke:Représentations antérieures\\|capacite\\|" + gameShortName + "\\}\\}\\n+" +
							"=== Jeux secondaires ===\n\\{\\{#invoke:Représentations antérieures\\|capacite\\|([^\\}]*)\\}\\}",
							
							"=== Jeux secondaires ===\n{{#invoke:Représentations antérieures|capacite|$1/" + gameShortName + "}}");
					
					attackPageContents = attackPageContents.replace(gameShortName + "/" + gameShortName, gameShortName);
					attackPageContents = attackPageContents.replace("XD/Colo", "Colo/XD");
//					System.out.println(attackPageContents);
					
					if (upload) {
						attackPage.setContent(attackPageContents, "Ajout de la capacité " + gameShortName + " aux représentations antérieures");
					} else {
						System.out.println(attackPageContents);
					}
					
					if (attackPageContentsOrigins.equals(attackPageContents)) {
						System.out.println("\n --- Page was unchanged.");
					} else {
						System.out.println("\n --- Added the image to the page!");
					}
				}
				

				if (justOne) {
					break;
				}
			}
		}
	}
	
	public void uploadFilesWithDescriptions(File folderPath, File listPath, String fileExtension, boolean justOne, boolean upload) throws IOException {
		FileReader		fr					= new FileReader(listPath);
		BufferedReader	br					= new BufferedReader(fr);

		String			delimiter			= "XXXXX";
		String			currentLine			= br.readLine();
		String			description 		= "";
		String			descriptionHeader	= "== Description ==\n";
		

		File contents[] = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			description				= "";
			String contentString	= contents[i].toString();
			String uploadName		= "Fichier:" + contents[i].getName();
			
			if (uploadName.substring(uploadName.length()-4,uploadName.length()).equals(fileExtension)) {
				while (currentLine != null && !(currentLine.equals(delimiter))) {
					description		+= currentLine + "\n";
					currentLine		= br.readLine();
				}
				currentLine		= br.readLine();
				
				if (upload) {

					boolean uploaded = API.upload(uploadName, contents[i],
							descriptionHeader + description, description);
					String uploadSituation;
					if (uploaded)
						uploadSituation = "ok";
					else
						uploadSituation = "PAS OK !!!!";
					System.out.println(description);

					// These two lines shouldn't do anything unless the description wasn't set by the upload before.
					// For instance, if there was already an existing version.
					Page page = new Page(uploadName);
					page.setContent(descriptionHeader + description, description);
					
					System.out.println(uploadName + " " + uploadSituation);
				} else {
					System.out.println("==== " + uploadName + " ====");
					System.out.println(description);
				}
				

				

				if (justOne) {
					break;
				}
			}
		}
		
		br.close();
	}
	
	public void createSpriteRedirections(File listPath, String from, String to, String gameLongName, boolean justOne) throws IOException {
		FileReader		fr						= new FileReader(listPath);
		BufferedReader	br						= new BufferedReader(fr);

		String			currentLine				= "currentLine";
		String			currentRedirectionPage	= "currentRedirectionPage";
		
		String 			category				= "Sprite Pokémon";

		
		while (!currentLine.equals("")) {
			currentLine				= br.readLine();
			currentRedirectionPage 	= currentLine.replace(from, to);
			category				= "Sprite Pokémon ";
			
			if (currentLine.contains("Miniature")) {
				category = "Miniature Pokémon ";
			}
			if (currentLine.contains(" chromatique ")) {
				category += "chromatique ";
			}
			if (currentLine.contains(" dos ")) {
				category += "de dos ";
			}
			category += "(" + gameLongName + ")";

			Page currentPage = new Page(currentLine);
			if (currentPage.getContent() == null) {
				System.out.println(currentLine + " does not exist.");
				continue;
			}
			if (currentPage.getContent().contains("#REDIRECT")) {
				String oldLine = currentLine;
				currentLine = currentPage.getContent().replaceAll("#REDIRECT[ION ]*\\[\\[(:|)([^\\]\\n]*)\\]\\]\\n+.*", "$2");
				System.out.println(oldLine + " /// " + currentLine);
			}
				
			Page page = new Page(currentRedirectionPage);
			if (page.getContent() != null) {
				System.out.println(currentRedirectionPage + " was already written.");
				if (!page.getContent().contains("#REDIRECT")) {
					System.out.println("passed");
					continue;
				}
				System.out.println("Rewriting.");					
			}
			page.setContent("#REDIRECTION [[" + currentLine + "]]\n\n[[Catégorie:" + category + "]]"
					, "Page redirigée vers [[" + currentLine + "]], ajout automatique de catégorie [[Catégorie:" + category + "]]");
			
			System.out.println(currentRedirectionPage + " => " + currentLine + " ok");

			if (justOne) {
				break;
			}
		}
		
		br.close();
	}
	
	public void deleteDuplicateFiles(boolean justOne) {
		String[] 	filesToKeep		= {"Miniature Lune Ball NB.png", "Miniature Plaque Fantô NB.png", "Miniature Niveau Ball NB.png", "Miniature Orbe Flamme NB.png", "Miniature Baie Charti NB.png", "Miniature Roche Chaude NB.png", "Miniature Masse Ball NB.png", "Miniature Foss. Plaque NB.png", "Miniature Bonbon Rage NB.png", "Miniature Plaque Hydro NB.png", "Miniature Baie Chocco NB.png", "Miniature Nœud Destin NB.png", "Miniature Ralentiqueue NB.png", "Miniature Orbe Vie NB.png", "Miniature Pierre Aube NB.png", "Miniature Baie Cobaba NB.png", "Miniature Baie Sédra NB.png", "Miniature Plaque Fer NB.png", "Miniature Roche Glace NB.png", "Miniature Bulbe NB.png", "Miniature Orbe Toxique NB.png", "Miniature B. Étreinte NB.png", "Miniature Lentil. Zoom NB.png", "Miniature Piquants NB.png", "Miniature Plaque Poing NB.png", "Miniature Balle Fer NB.png", "Miniature Boue Noire NB.png", "Miniature Foss. Armure NB.png", "Miniature Pierre Magma NB.png", "Miniature Plaque Herbe NB.png", "Miniature Plaque Terre NB.png", "Miniature Plaque Ombre NB.png", "Miniature Baie Pomroz NB.png", "Miniature Baie Babiri NB.png", "Miniature Baie Micle NB.png", "Miniature Pierre Éclat NB.png", "Miniature Baie Ratam NB.png", "Miniature Compét'Ball NB.png", "Miniature Speed Ball NB.png", "Miniature Plaque Volt NB.png", "Miniature Roche Lisse NB.png", "Miniature Plaquinsect NB.png", "Miniature Plaque Roc NB.png", "Miniature Plaque Toxic NB.png", "Miniature Roche Humide NB.png", "Miniature Lent. Pouv. NB.png", "Miniature Électiriseur NB.png", "Miniature Foss. Plume NB.png", "Miniature Pile NB.png", "Miniature Baie Lampou NB.png", "Miniature Baie Chérim NB.png", "Miniature Baie Kébia NB.png", "Miniature Lumargile NB.png", "Miniature Pierre Nuit NB.png", "Miniature Mémoire Ball NB.png", "Miniature Soin Ball NB.png", "Miniature Baie Pocpoc NB.png", "Miniature Plaquesprit NB.png", "Miniature Gracidée NB.png", "Miniature Copain Ball NB.png", "Miniature Love Ball NB.png", "Miniature Plaque Flam NB.png", "Miniature Plaque Draco NB.png", "Miniature Croc Rasoir NB.png", "Miniature Pt de Mire NB.png", "Miniature Baie Jaboca NB.png", "Miniature Baie Zalis NB.png", "Miniature Casque Brut NB.png", "Miniature Baie Pommo NB.png", "Miniature Baie Jouca NB.png", "Miniature Bouton Fuite NB.png", "Miniature Poképlumet NB.png", "Miniature Maxi Pépite NB.png", "Miniature Loupe NB.png", "Miniature Baie Nanone NB.png", "Miniature Rapide Ball NB.png", "Miniature Sombre Ball NB.png", "Miniature Carapace Mue NB.png", "Miniature Baie Fraigo NB.png", "Miniature Foss. Crâne NB.png", "Miniature Appât Ball NB.png", "Miniature Plaque Glace NB.png", "Miniature Rêve Ball NB.png", "Miniature Plaque Ciel NB.png", "Miniature Baie Panga NB.png", "Miniature Protecteur NB.png", "Miniature Baie Parma NB.png", "Miniature Magmariseur NB.png"};
		String[] 	filesToDelete	= {"Miniature Lune Ball SL.png", "Miniature Plaque Fantôme SL.png", "Miniature Niveau Ball SL.png", "Miniature Orbe Flamme SL.png", "Miniature Baie Charti SL.png", "Miniature Roche Chaude SL.png", "Miniature Masse Ball SL.png", "Miniature Fossile Plaque SL.png", "Miniature Bonbon Rage SL.png", "Miniature Plaque Hydro SL.png", "Miniature Baie Chocco SL.png", "Miniature Nœud Destin SL.png", "Miniature Ralentiqueue SL.png", "Miniature Orbe Vie SL.png", "Miniature Pierre Aube SL.png", "Miniature Baie Cobaba SL.png", "Miniature Baie Sédra SL.png", "Miniature Plaque Fer SL.png", "Miniature Roche Glace SL.png", "Miniature Bulbe SL.png", "Miniature Orbe Toxique SL.png", "Miniature Bande Étreinte SL.png", "Miniature Lentille Zoom SL.png", "Miniature Piquants SL.png", "Miniature Plaque Poing SL.png", "Miniature Balle Fer SL.png", "Miniature Boue Noire SL.png", "Miniature Fossile Armure SL.png", "Miniature Pierre Magma SL.png", "Miniature Plaque Herbe SL.png", "Miniature Plaque Terre SL.png", "Miniature Plaque Ombre SL.png", "Miniature Baie Pomroz SL.png", "Miniature Baie Babiri SL.png", "Miniature Baie Micle SL.png", "Miniature Pierre Éclat SL.png", "Miniature Baie Ratam SL.png", "Miniature Compét'Ball SL.png", "Miniature Speed Ball SL.png", "Miniature Plaque Volt SL.png", "Miniature Roche Lisse SL.png", "Miniature Plaque Insecte SL.png", "Miniature Plaque Roc SL.png", "Miniature Plaque Toxic SL.png", "Miniature Roche Humide SL.png", "Miniature Lentille Pouvoir SL.png", "Miniature Électriseur SL.png", "Miniature Fossile Plume SL.png", "Miniature Pile SL.png", "Miniature Baie Lampou SL.png", "Miniature Baie Chérim SL.png", "Miniature Baie Kébia SL.png", "Miniature Lumargile SL.png", "Miniature Pierre Nuit SL.png", "Miniature Mémoire Ball SL.png", "Miniature Soin Ball SL.png", "Miniature Baie Pocpoc SL.png", "Miniature Plaque Esprit SL.png", "Miniature Gracidée SL.png", "Miniature Copain Ball SL.png", "Miniature Love Ball SL.png", "Miniature Plaque Flamme SL.png", "Miniature Plaque Draco SL.png", "Miniature Croc Rasoir SL.png", "Miniature Point de Mire SL.png", "Miniature Baie Jaboca SL.png", "Miniature Baie Zalis SL.png", "Miniature Casque Brut SL.png", "Miniature Baie Pommo SL.png", "Miniature Baie Jouca SL.png", "Miniature Bouton Fuite SL.png", "Miniature Poké Plumet SL.png", "Miniature Maxi Pépite SL.png", "Miniature Loupe SL.png", "Miniature Baie Nanone SL.png", "Miniature Rapide Ball SL.png", "Miniature Sombre Ball SL.png", "Miniature Carapace Mue SL.png", "Miniature Baie Fraigo SL.png", "Miniature Fossile Crâne SL.png", "Miniature Appât Ball SL.png", "Miniature Plaque Glace SL.png", "Miniature Rêve Ball SL.png", "Miniature Plaque Ciel SL.png", "Miniature Baie Panga SL.png", "Miniature Protecteur SL.png", "Miniature Baie Parma SL.png", "Miniature Magmariseur SL.png"};
		String		category		= "[[Catégorie:Miniature d'objet (Soleil et Lune)]]";
		
		for(int i = 0; i < filesToKeep.length; i++) {
			String	toKeep			= "Fichier:" + filesToKeep[i];
			String	toDelete		= "Fichier:" + filesToDelete[i];
			Page	pageToKeep		= new Page(toKeep);
			Page	pageToDelete	= new Page(toDelete);
			
//			API.delete(toDelete, "Remplacement par une redirection vers le fichier identique [[" + toKeep + "]]");
			pageToDelete.setContent("#REDIRECTION [[" + toKeep + "]]\n\n" + category, "Création de redirection vers [[" + toKeep + "]]");
			
			System.out.println("ok: " + toKeep + " => " + toDelete);
			
			if (justOne) {
				break;
			}
			
		}
	}
	
	public String generateRow(String attackTitle, boolean useGenerationToAttackDict,
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
		if (!precision.equals("") && !precision.equals(attackName)) {
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
				for(int j=0; j<games.length; j++) {
					String currentGame = games[j];
					
					if (currentGame.equals("Colo") || currentGame.equals("XD")
							|| currentGame.equals("XY")|| currentGame.equals("ROSA")
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
					for (int k=0; k < unavailableAttacksForGame.length; k++) {
						if (attackName.equals(unavailableAttacksForGame[k])) {
							unavailable = true;
							break;
						}
					}
					

					// is the attack exclusive to another game?
					if (!unavailable) {
						boolean isExclusiveToThisGame = false;
						for (String[][] exclusiveAttacksCell : exclusiveAttacks) {
							if (unavailable) { break; }
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
//		};
	};
	
	@SuppressWarnings("resource")
	public void postMissingAttackImagesTable(String path, boolean useGenerationToAttackDict) throws IOException, InterruptedException {

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
	
	public String generateMissingAttackImagesTable(String path, boolean useGenerationToAttackDict) throws IOException, InterruptedException {

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
	
	public String smoothMissingAttackImagesTable(String path) throws IOException {

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String currentLine = br.readLine();
		String fileText = currentLine;

		
		while (!currentLine.equals("|}")) {
			currentLine	= br.readLine();
			fileText = fileText + "\n" + currentLine;
		}
		
		// Request -> Text
		// [[:Première génération|Première génération]] -> Première génération
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
			for (int j = 0; j < absentAttacks.length; j++) {
				String absentAttack = absentAttacks[j];
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
	
	
	public void addDex(String region, boolean secondary, boolean justOne) {
		// String[][] theList = {{"002", "Efflèche"}, {"004", "Héricendre"}, {"005", "Feurisson"}, {"006", "Typhlosion de Hisui"}, {"007", "Moustillon"}, {"008", "Mateloutre"}, {"009", "Clamiral de Hisui"}, {"010", "Keunotor"}, {"011", "Castorno"}, {"012", "Étourmi"}, {"013", "Étourvol"}, {"014", "Étouraptor"}, {"015", "Lixy"}, {"016", "Luxio"}, {"017", "Luxray"}, {"018", "Chenipotte"}, {"019", "Armulys"}, {"020", "Charmillon"}, {"021", "Blindalys"}, {"022", "Papinox"}, {"023", "Ponyta"}, {"024", "Galopa"}, {"025", "Évoli"}, {"026", "Aquali"}, {"027", "Voltali"}, {"028", "Pyroli"}, {"029", "Mentali"}, {"030", "Noctali"}, {"031", "Phyllali"}, {"032", "Givrali"}, {"033", "Nymphali"}, {"034", "Nosferapti"}, {"035", "Nosferalto"}, {"036", "Nostenfer"}, {"037", "Baudrive"}, {"038", "Grodrive"}, {"039", "Crikzik"}, {"040", "Mélokrik"}, {"041", "Mustébouée"}, {"042", "Mustéflott"}, {"043", "Cheniti"}, {"044", "Cheniselle"}, {"045", "Papilord"}, {"046", "Racaillou"}, {"047", "Gravalanch"}, {"048", "Grolem"}, {"049", "Cerfrousse"}, {"050", "Cerbyllin"}, {"051", "Goinfrex"}, {"052", "Ronflex"}, {"053", "Paras"}, {"054", "Parasect"}, {"055", "Pichu"}, {"056", "Pikachu"}, {"057", "Raichu"}, {"058", "Abra"}, {"059", "Kadabra"}, {"060", "Alakazam"}, {"061", "Ouisticram"}, {"062", "Chimpenfeu"}, {"063", "Simiabraz"}, {"064", "Laporeille"}, {"065", "Lockpin"}, {"066", "Ceribou"}, {"067", "Ceriflor"}, {"068", "Psykokwak"}, {"069", "Akwakwak"}, {"070", "Apitrini"}, {"071", "Apireine"}, {"072", "Insécateur"}, {"073", "Cizayox"}, {"074", "Hachécateur"}, {"075", "Scarhino"}, {"076", "Mime Jr."}, {"077", "M. Mime"}, {"078", "Capumain"}, {"079", "Capidextre"}, {"080", "Magicarpe"}, {"081", "Léviator"}, {"082", "Sancoki"}, {"083", "Tritosor"}, {"084", "Qwilfish de Hisui"}, {"085", "Qwilpik"}, {"086", "Ptiravi"}, {"087", "Leveinard"}, {"088", "Leuphorie"}, {"089", "Rozbouton"}, {"090", "Rosélia"}, {"091", "Roserade"}, {"092", "Vortente"}, {"093", "Chlorobule"}, {"094", "Fragilady de Hisui"}, {"095", "Saquedeneu"}, {"096", "Bouldeneu"}, {"097", "Barloche"}, {"098", "Barbicha"}, {"099", "Cradopaud"}, {"100", "Coatox"}, {"101", "Tarsal"}, {"102", "Kirlia"}, {"103", "Gardevoir"}, {"104", "Gallame"}, {"105", "Yanma"}, {"106", "Yanmega"}, {"107", "Hippopotas"}, {"108", "Hippodocus"}, {"109", "Pachirisu"}, {"110", "Moufouette"}, {"111", "Moufflair"}, {"112", "Teddiursa"}, {"113", "Ursaring"}, {"114", "Ursaking"}, {"115", "Mucuscule"}, {"116", "Colimucus de Hisui"}, {"117", "Muplodocus de Hisui"}, {"118", "Onix"}, {"119", "Steelix"}, {"120", "Rhinocorne"}, {"121", "Rhinoféros"}, {"122", "Rhinastoc"}, {"123", "Manzaï"}, {"124", "Simularbre"}, {"125", "Excelangue"}, {"126", "Coudlangue"}, {"127", "Togepi"}, {"128", "Togetic"}, {"129", "Togekiss"}, {"130", "Tortipouss"}, {"131", "Boskara"}, {"132", "Torterra"}, {"133", "Porygon"}, {"134", "Porygon2"}, {"135", "Porygon-Z"}, {"136", "Fantominus"}, {"137", "Spectrum"}, {"138", "Ectoplasma"}, {"139", "Spiritomb"}, {"140", "Cornèbre"}, {"141", "Corboss"}, {"142", "Zarbi"}, {"143", "Obalie"}, {"144", "Phogleur"}, {"145", "Kaimorse"}, {"146", "Rémoraid"}, {"147", "Octillery"}, {"148", "Rapion"}, {"149", "Drascore"}, {"150", "Caninos de Hisui"}, {"151", "Arcanin de Hisui"}, {"152", "Chaglam"}, {"153", "Chaffreux"}, {"154", "Machoc"}, {"155", "Machopeur"}, {"156", "Mackogneur"}, {"157", "Pijako"}, {"158", "Skelénox"}, {"159", "Téraclope"}, {"160", "Noctunoir"}, {"161", "Tiplouf"}, {"162", "Prinplouf"}, {"163", "Pingoléon"}, {"164", "Babimanta"}, {"165", "Démanta"}, {"166", "Bargantua"}, {"167", "Paragruel"}, {"168", "Goupix"}, {"168", "Goupix d'Alola"}, {"169", "Feunard"}, {"169", "Feunard d'Alola"}, {"170", "Tentacool"}, {"171", "Tentacruel"}, {"172", "Écayon"}, {"173", "Luminéon"}, {"174", "Magby"}, {"175", "Magmar"}, {"176", "Maganon"}, {"177", "Magnéti"}, {"178", "Magnéton"}, {"179", "Magnézone"}, {"180", "Archéomire"}, {"181", "Archéodong"}, {"182", "Élekid"}, {"183", "Élektek"}, {"184", "Élekable"}, {"185", "Scorplane"}, {"186", "Scorvol"}, {"187", "Griknot"}, {"188", "Carmache"}, {"189", "Carchacrok"}, {"190", "Tarinor"}, {"191", "Tarinorme"}, {"192", "Voltorbe de Hisui"}, {"193", "Électrode de Hisui"}, {"194", "Motisma"}, {"195", "Korillon"}, {"196", "Éoko"}, {"197", "Feuforêve"}, {"198", "Magirêve"}, {"199", "Mélo"}, {"200", "Mélofée"}, {"201", "Mélodelfe"}, {"202", "Farfuret"}, {"202", "Farfuret de Hisui"}, {"203", "Farfurex"}, {"204", "Dimoret"}, {"205", "Stalgamin"}, {"206", "Oniglali"}, {"207", "Momartik"}, {"208", "Kranidos"}, {"209", "Charkos"}, {"210", "Dinoclier"}, {"211", "Bastiodon"}, {"212", "Marcacrin"}, {"213", "Cochignon"}, {"214", "Mammochon"}, {"215", "Grelaçon"}, {"216", "Séracrawl de Hisui"}, {"217", "Blizzi"}, {"218", "Blizzaroi"}, {"219", "Zorua de Hisui"}, {"220", "Zoroark de Hisui"}, {"221", "Furaiglon"}, {"222", "Gueriaigle de Hisui"}, {"223", "Riolu"}, {"224", "Lucario"}, {"225", "Créhelf"}, {"226", "Créfollet"}, {"227", "Créfadet"}, {"228", "Heatran"}, {"229", "Regigigas"}, {"230", "Cresselia"}, {"231", "Fulguris"}, {"232", "Boréas"}, {"233", "Démétéros"}, {"234", "Amovénus"}, {"235", "Dialga"}, {"236", "Palkia"}, {"237", "Giratina"}, {"238", "Arceus"}, {"239", "Phione"}, {"240", "Manaphy"}, {"241", "Shaymin"}, {"242", "Darkrai"}};
		String[][] theList = {{"2", "Dodrio"}, {"3", "Noeunoeuf"}, {"4", "Noadkoko"}, {"4", "Noadkoko d'Alola"}, {"5", "Rhinocorne"}, {"6", "Rhinoféros"}, {"7", "Rhinastoc"}, {"8", "Mimitoss"}, {"9", "Aéromite"}, {"10", "Élekid"}, {"11", "Élektek"}, {"12", "Élekable"}, {"13", "Magby"}, {"14", "Magmar"}, {"15", "Maganon"}, {"16", "Ptiravi"}, {"17", "Leveinard"}, {"18", "Leuphorie"}, {"19", "Insécateur"}, {"20", "Cizayox"}, {"21", "Hachécateur"}, {"22", "Tauros"}, {"23", "Zébibron"}, {"24", "Zéblitz"}, {"25", "Girafarig"}, {"26", "Farigiraf"}, {"27", "Mascaïman"}, {"28", "Escroco"}, {"29", "Crocorible"}, {"30", "Léboulérou"}, {"31", "Bérasca"}, {"32", "Furaiglon"}, {"33", "Gueriaigle"}, {"34", "Vostourno"}, {"35", "Vaututrice"}, {"36", "Hélionceau"}, {"37", "Némélios"}, {"38", "Vivaldaim"}, {"39", "Haydaim"}, {"40", "Queulorior"}, {"41", "Motisma"}, {"42", "Crèmy"}, {"43", "Charmilly"}, {"44", "Kraknoix"}, {"45", "Vibraninf"}, {"46", "Libégon"}, {"47", "Picassaut"}, {"48", "Piclairon"}, {"49", "Bazoucan"}, {"50", "Tentacool"}, {"51", "Tentacruel"}, {"52", "Hypotrempe"}, {"53", "Hypocéan"}, {"54", "Hyporoi"}, {"55", "Denticrisse"}, {"56", "Doudouvet"}, {"57", "Farfaduvet"}, {"58", "Guérilande"}, {"59", "Parecool"}, {"60", "Vigoroth"}, {"61", "Monaflèmit"}, {"62", "Mystherbe"}, {"63", "Ortide"}, {"64", "Rafflesia"}, {"65", "Joliflor"}, {"66", "Taupiqueur d'Alola"}, {"67", "Triopikeur d'Alola"}, {"68", "Tadmorv d'Alola"}, {"69", "Grotadmorv d'Alola"}, {"70", "Mangriff"}, {"71", "Séviper"}, {"72", "Crabagarre"}, {"73", "Crabominable"}, {"74", "Plumeline"}, {"75", "Ramoloss de Galar"}, {"76", "Flagadoss de Galar"}, {"77", "Roigada de Galar"}, {"78", "Loupio"}, {"79", "Lanturn"}, {"80", "Sepiatop"}, {"81", "Sepiatroce"}, {"82", "Lovdisc"}, {"83", "Écayon"}, {"84", "Luminéon"}, {"85", "Mamanbo"}, {"86", "Chartor"}, {"87", "Passerouge"}, {"88", "Braisillon"}, {"89", "Flambusard"}, {"90", "Araqua"}, {"91", "Tarenbulle"}, {"92", "Debugant"}, {"93", "Kicklee"}, {"94", "Tygnon"}, {"95", "Kapoera"}, {"96", "Racaillou d'Alola"}, {"97", "Gravalanch d'Alola"}, {"98", "Grolem d'Alola"}, {"99", "Rototaupe"}, {"100", "Minotaupe"}, {"101", "Scrutella"}, {"102", "Mesmérella"}, {"103", "Sidérella"}, {"104", "Psystigri"}, {"105", "Mistigrix"}, {"106", "Météno"}, {"107", "Kranidos"}, {"108", "Charkos"}, {"109", "Dinoclier"}, {"110", "Bastiodon"}, {"111", "Chinchidou"}, {"112", "Pashmilla"}, {"113", "Airmure"}, {"114", "Tylton"}, {"115", "Altaria"}, {"116", "Magnéti"}, {"117", "Magnéton"}, {"118", "Magnézone"}, {"119", "Posipi"}, {"120", "Négapi"}, {"121", "Baggiguane"}, {"122", "Baggaïd"}, {"123", "Gringolem"}, {"124", "Golemastoc"}, {"125", "Chamallot"}, {"126", "Camérupt"}, {"127", "Théffroi"}, {"128", "Polthégeist"}, {"129", "Porygon"}, {"130", "Porygon2"}, {"131", "Porygon-Z"}, {"132", "Statitik"}, {"133", "Mygavolt"}, {"134", "Anchwatt"}, {"135", "Lampéroie"}, {"136", "Ohmassacre"}, {"137", "Terhal"}, {"138", "Métang"}, {"139", "Métalosse"}, {"140", "Coupenotte"}, {"141", "Incisache"}, {"142", "Tranchodon"}, {"143", "Otaria"}, {"144", "Lamantine"}, {"145", "Lokhlass"}, {"146", "Qwilfish de Hisui"}, {"147", "Qwilpik"}, {"148", "Nucléos"}, {"149", "Méios"}, {"150", "Symbios"}, {"151", "Snubbull"}, {"152", "Granbull"}, {"153", "Polarhume"}, {"154", "Polagriffe"}, {"155", "Sabelette d'Alola"}, {"156", "Sablaireau d'Alola"}, {"157", "Goupix d'Alola"}, {"158", "Feunard d'Alola"}, {"159", "Blizzi"}, {"160", "Blizzaroi"}, {"161", "Duralugon"}, {"162", "Pondralugon"}, {"163", "Pomdorochi"}, {"164", "Bulbizarre"}, {"165", "Herbizarre"}, {"166", "Florizarre"}, {"167", "Salamèche"}, {"168", "Reptincel"}, {"169", "Dracaufeu"}, {"170", "Carapuce"}, {"171", "Carabaffe"}, {"172", "Tortank"}, {"173", "Germignon"}, {"174", "Macronium"}, {"175", "Méganium"}, {"176", "Héricendre"}, {"177", "Feurisson"}, {"178", "Typhlosion"}, {"179", "Kaiminus"}, {"180", "Crocrodil"}, {"181", "Aligatueur"}, {"182", "Arcko"}, {"183", "Massko"}, {"184", "Jungko"}, {"185", "Poussifeu"}, {"186", "Galifeu"}, {"187", "Braségali"}, {"188", "Gobou"}, {"189", "Flobio"}, {"190", "Laggron"}, {"191", "Tortipouss"}, {"192", "Boskara"}, {"193", "Torterra"}, {"194", "Ouisticram"}, {"195", "Chimpenfeu"}, {"196", "Simiabraz"}, {"197", "Tiplouf"}, {"198", "Prinplouf"}, {"199", "Pingoléon"}, {"200", "Vipélierre"}, {"201", "Lianaja"}, {"202", "Majaspic"}, {"203", "Gruikui"}, {"204", "Grotichon"}, {"205", "Roitiflam"}, {"206", "Moustillon"}, {"207", "Mateloutre"}, {"208", "Clamiral"}, {"209", "Marisson"}, {"210", "Boguérisse"}, {"211", "Blindépique"}, {"212", "Feunnec"}, {"213", "Roussil"}, {"214", "Goupelin"}, {"215", "Grenousse"}, {"216", "Croâporal"}, {"217", "Amphinobi"}, {"218", "Brindibou"}, {"219", "Efflèche"}, {"220", "Archéduc"}, {"221", "Flamiaou"}, {"222", "Matoufeu"}, {"223", "Félinferno"}, {"224", "Otaquin"}, {"225", "Otarlette"}, {"226", "Oratoria"}, {"227", "Ouistempo"}, {"228", "Badabouin"}, {"229", "Gorythmic"}, {"230", "Flambino"}, {"231", "Lapyro"}, {"232", "Pyrobut"}, {"233", "Larméléon"}, {"234", "Arrozard"}, {"235", "Lézargus"}, {"236", "Feu-Perçant"}, {"237", "Ire-Foudre"}, {"238", "Chef-de-Fer"}, {"239", "Roc-de-Fer"}, {"240", "Terapagos"}, {"241", "Serpente-Eau"}, {"242", "Vert-de-Fer"}};
		for (String[] couple : theList) {
			String num = couple[0];
			String pokeName = couple[1];
			
			Page pokePage = new Page(pokeName);
			
			String contents = pokePage.getContent();
			String patternSearch;
			String patternSetBeginning;
			String patternSetEnding = "\n";
			
			if (contents.matches("[^µ]*" + region + "/[0-9]+[^µ]*")) {
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
//			String deLaRegionDe = "de la région " + Util.de(region);
			String deLaRegionDe = "";
			pokePage.setContent(newContents, "Ajout du numéro de Pokédex " + deLaRegionDe + region);
			
			if (justOne) {
				break;
			}
		}
	}
	
	/**
	 * Remplace les "oeufpas" d'une liste de Pokémon donnée dans un fichier texte par le nombre de Cycles associés
	 * @param path : chemin d'accès vers le fichier texte
	 * @param resume : Permets de reprendre à partir d'une certaine ligne du fichier si le programme à été interrompu en cours de route (0 pour commencer du début)
	 * @param justOne : true pour s'arrêter après le premier remplament réussi. Evite de casser plein de pages durant les tests.
	 * @throws IOException
	 */
	public void updateCycles(String path, int startPage, boolean justOne) throws IOException {
	    FileReader fr = new FileReader(path);
	    BufferedReader br = new BufferedReader(fr);
	    //ArrayList plutôt que String[] afin que ça marche peu importe le nombre de lignes du fichier
	    ArrayList<String[]> tab = new ArrayList<>();
	
	    String line = br.readLine();
	    //Ici on saute le nombre de lignes voulues
	    for(int i = 0; i < startPage; i++) {
	        line = br.readLine();
	    }
	
	    //Remplissage du tableau, chaque ligne contient le nom du Pokémon suivi de son nombre de cycles
	    while (line != null) {
	        tab.add(line.split(","));
	        line = br.readLine();
	    }
	
	    for(String[] couple : tab) {
	        String pokeName = couple[0];
	        String cycles = couple[1];
	        if (cycles.equals(" ")) {
	        	cycles = "";
	        }
	        String editString = "Infobox : changement du nombre de pas en nombre de cycles pour le paramètre éclosion";
	
	        Page pokePage = new Page(pokeName);
	        String content = pokePage.getContent();
	        // Recherche la ligne dans l'infobox contenant les oeufpas, et la remplace par le nouveau paramètre eclosion
	        String newContent = content.replaceFirst("oeufpas=\\d*\n", "éclosion="+cycles+"\n");
	
	        // Dans le cas ou ni "oeufpas" ni "éclosion" ne sont déjà présent
	        if(content.equals(newContent) && !content.contains("éclosion=")) {
	            //décomposition pour obtenir un String dont le début se trouve déjà dans l'infobox
	            String[] separation = content.split("#invoke:Infobox Pokémon");
	            String nouveau = separation[1].replaceFirst("}}\n", "| éclosion="+cycles+"\n}}\n");
	            // Recomposition
	            newContent = separation[0] + "#invoke:Infobox Pokémon" + nouveau;
	            editString = "Infobox : ajout du nombre de cycles pour le paramètre éclosion";
	        }
	
	        pokePage.setContent(newContent, editString);
	        System.out.println(pokeName + " ok");
	
	        if (justOne) {
	            System.out.println(newContent);
	            break;
	        }
	    }
	}
	
	/**
	 * Méthode de remplacement specifique objets et monnaue PDM 
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au remplacement appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param trigger une chaine de texte devant être présente dans les pages pour déclencher le remplacement. Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Évite de casser plein de pages durant les tests.
	 **/
	public void replacePDMCash(String from, int[] nameSpaces, String categoryName, String trigger, String firstPageName, boolean justOne) {
		String to = null;
		
		PageCollection pagesG3 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la troisième génération");
		PageCollection pagesG4 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la quatrième génération");
		PageCollection pagesG5 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la cinquième génération");
		PageCollection pagesG6 = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, "Objet de la sixième génération");
		
		PageCollection pageCollection = new PageCollection(nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN}, API.FILTER_NONREDIRECTS, categoryName);
		
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String text;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			if(pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM1}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM2}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && pagesG5.hasPage(page.getTitle()) && !pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM3}}";
			} else if (!pagesG3.hasPage(page.getTitle()) && !pagesG4.hasPage(page.getTitle()) && !pagesG5.hasPage(page.getTitle()) && pagesG6.hasPage(page.getTitle())) {
				to = "{{Monnaie PDM|Jeu=PDM4}}";
			} else {
				to = null;
			}

			if(to!=null) {
				try {
					text = page.getContent(false);
					if(text!=null && (trigger==null || text.indexOf(trigger)!=-1)) {
						System.out.println("FOUND in page ["+page.getTitle()+"]");
	
						String newText = text.replaceAll(from, to);
	
						if(!newText.equals(text)) {
							page.setContent(newText, "Remplacement "+from+" => "+to);
							System.out.println("\tSaved");
							if(justOne) {
								break;
							}
						} else {
							System.out.println("\tSkipped (no change)");
						}
					}
				} catch (Exception e) {
					System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
					e.printStackTrace();
				}
			} else {
				System.out.println("\tSkipped (multigen)");
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}
	
	/**
	 * Méthode de renommage générique. Les tableaux "from" et "to" fonctionnent de paire et doivent donc être de même longueur.
	 * @param from chaines à remplacer (regexp)
	 * @param to chaines de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au renommage appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param keepRedirect true pour maintenir une redirection entre l'ancien et le nouveau nom, false sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Evite de casser plein de pages durant les tests.
	 **/
	public void renameTrainerSprites(String[] from, String[] to, int[] nameSpaces, String categoryName, String firstPageName, boolean keepRedirect, boolean justOne) {
		PageCollection pageCollection = new PageCollection(
			nameSpaces!=null?nameSpaces:new int[]{API.NS_FILES},
						API.FILTER_NONREDIRECTS,
						categoryName
				);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String pageName;
		String newPageName;
		String text;
		int numFromTo;
		while(page!=null) {
			if(counter>=100) {
				//System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();
				newPageName = pageName;
				for(numFromTo=0; numFromTo<from.length; numFromTo++) {
					newPageName = newPageName.replaceAll(from[numFromTo], to[numFromTo]);
				}
				if(!newPageName.equals(pageName)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");
					text = page.getContent(false);
					if(Util.count(text, "[Cc]at[ée]gor[iy]e?\\s*:\\s*[Aa]rtwork Pokémon du Pokémon Global Link") > 1) {
						System.err.println("\tCannot save : multiple categories for ["+page.getTitle()+"]");
					} else {
						API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
						System.out.println("\tSaved");
					}
					if(justOne) {
						break;
					}
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}

	
	/**
	 * Méthode de renommage générique 
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au renommage appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param keepRedirect true pour maintenir une redirection entre l'ancien et le nouveau nom, false sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Evite de casser plein de pages durant les tests.
	 **/
	public boolean rename(String from, String to, int[] nameSpaces, String categoryName, String firstPageName, boolean keepRedirect, boolean justOne) {
		boolean allUploadedAtFirst = true;
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
						API.FILTER_NONREDIRECTS,
						categoryName
				);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String pageName;
		String newPageName;
		while(page!=null) {
//			if (!page.getTitle().equals("Fichier:Antre de la Cascade localisation PMDM.png")) {
//				page = pageCollection.getNextPage();
//				counter++;
//				continue;
//			}
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();
				
				newPageName = pageName.replaceAll(from, to);
				
//				newPageName = newPageName.replaceAll("Cap ecran ", "");
//				newPageName = newPageName.replaceAll("Cap écran ", "");
//				newPageName = newPageName.replaceAll("ossatueur", "Ossatueur");
//				newPageName = newPageName.replaceAll("xatu", "Xatu");
//				newPageName = newPageName.replaceAll("trempee", "Trempée");
//				newPageName = newPageName.replaceAll("céleste", "Céleste");
//				newPageName = newPageName.replaceAll("leveinard", "Leveinard");
//				newPageName = newPageName.replaceAll("littorale", "Littorale");
//				if (newPageName.contains("localisation")) {
//					newPageName = newPageName.replace(" localisation", "");
//					newPageName = newPageName.replace("Fichier:", "Fichier:Localisation ");
//				}
				
				if(!newPageName.equals(pageName)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");
					API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
					System.out.println(pageName + " => " + newPageName);
					System.out.println("\tSaved");
					allUploadedAtFirst = false;
					
					if(justOne) {
						break;
					}
					TimeUnit.MILLISECONDS.sleep(5000);
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
		return allUploadedAtFirst;
	}
	
	public boolean createRedirections(String from, String to, int[] nameSpaces, String categoryName, String firstPageName, boolean justOne) {
		boolean allUploadedAtFirst = true;
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
						API.FILTER_NONREDIRECTS,
						categoryName
				);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String pageName;
		String redirectionName;
		while(page != null) {
//			if (!page.getTitle().equals("Fichier:Antre de la Cascade localisation PMDM.png")) {
//				page = pageCollection.getNextPage();
//				counter++;
//				continue;
//			}
			if(counter >= 100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();
				
				redirectionName = pageName.replaceAll(from, to);
				
				redirectionName = redirectionName.replace("☆", "Étoile");
				
				if(!redirectionName.equals(pageName)) {
					Page redirectionPage = new Page(redirectionName);
					String redirectionContents = redirectionPage.getContent();
					
					if (redirectionContents != null) {
						page = pageCollection.getNextPage();
						counter++;
						continue;
					}
					
					
					redirectionPage.setContent("#REDIRECTION [[" + pageName + "]]",
							"Création d'une redirection vers [[" + pageName + "]]");
					System.out.println(redirectionName + " => " + pageName);
					System.out.println("\tSaved");
					allUploadedAtFirst = false;
					
					if(justOne) {
						break;
					}
					TimeUnit.MILLISECONDS.sleep(300);
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
		return allUploadedAtFirst;
	}

	public void addCategory() {
		String category = "[[Catégorie:Artwork Pokémon]]";
		String[] list = {};
		for (String i : list) {
			Page page = new Page("Fichier:" + i + ".png");
			String contents = page.getContent();
			
			if (contents.contains(category)) {
				System.out.println("Skipped " + page.getTitle());
				continue;
			}
			
			contents = contents + "\n" + category;
			page.setContent(contents, "Ajout de la catégorie Artwork Pokémon");
			System.out.println("Added category on " + page.getTitle());
			
//			break;
		}
		
	}
	
	public boolean renameDoubleRedirections(String from, String to, String[] pageList, String firstPageName, boolean keepRedirect, boolean justOne) {
		boolean hadNothingToDo = true;
		int counter = 0;
		String newPageName;
		
		for (String pageName : pageList) {
			Page page = new Page(pageName);
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				String contents = page.getContent();
				String newContents = contents.replaceAll(from, to);
				
				newContents = newContents.replaceAll("Cap ecran ", "");
				newContents = newContents.replaceAll("Cap écran ", "");
				newContents = newContents.replaceAll("ossatueur", "Ossatueur");
				newContents = newContents.replaceAll("xatu", "Xatu");
				newContents = newContents.replaceAll("trempee", "Trempée");
				newContents = newContents.replaceAll("céleste", "Céleste");
				newContents = newContents.replaceAll("leveinard", "Leveinard");
				newContents = newContents.replaceAll("littorale", "Littorale");
				if (newContents.contains("localisation")) {
					newContents = newContents.replace(" localisation", "");
					newContents = newContents.replace("Fichier:", "Fichier:Localisation ");
				}
				
				if (!newContents.equals(contents)) {
					page.setContent(newContents, "Renommage " + from + " => " + to);
					System.out.println(contents + "\n => " + newContents);
					
					hadNothingToDo = false;
				}
				
//				newPageName = pageName.replaceAll(from, to);
				
//				if(!newPageName.equals(pageName)) {
//					System.out.println("FOUND in page ["+page.getTitle()+"]");
//					API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
//					System.out.println(pageName + " => " + newPageName);
//					System.out.println("\tSaved");
//					
//					hadNothingToDo = false;
////					TimeUnit.SECONDS.sleep(1);
//				}
//				
				if(justOne) {
					break;
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			counter++;
		}
		
		return hadNothingToDo;
	}
	
	/**
	 * Méthode de remplacement générique 
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au remplacement appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param trigger une chaine de texte devant être présente dans les pages pour déclencher le remplacement. Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param justOne true pour s'arrêter après le premier remplament réussi. Evite de casser plein de pages durant les tests.
	 **/
	public void replace(String from, String to, int[] nameSpaces, String categoryName, String trigger, String firstPageName, boolean justOne) {
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
						API.FILTER_NONREDIRECTS,
						categoryName
				);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String text;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				text = page.getContent(false);
				if(text!=null && (trigger==null || text.indexOf(trigger)!=-1)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");

					String newText = text.replaceAll(from, to);

					if(!newText.equals(text)) {
						page.setContent(newText, "Remplacement "+from+" => "+to);
						System.out.println("\tSaved");
						if(justOne) {
							break;
						}
					} else {
						System.out.println("\tSkipped (no change)");
					}
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}
	
	public void eraseCategory(String category, boolean justOne) {
			
		PageCollection pageCollection = new PageCollection(
				new int[] {API.NS_FILES},
				API.FILTER_NONREDIRECTS,
				category
			);
		Page page = pageCollection.getNextPage();
		while (page != null) {
			String title = page.getTitle();
			API.delete(title, "[Modif auto] Suppression des fichiers de [[Catégorie:" + category + "]]");
			
			System.out.println("Deleted " + title);
			
			
			page = pageCollection.getNextPage();
			
			if (justOne) {
				page = null;
			}
		}
	}
	
	public void eraseFiles(File listPath, boolean justOne) throws IOException {
		FileReader		fr						= new FileReader(listPath);
		BufferedReader	br						= new BufferedReader(fr);

		String			currentLine				= "currentLine";

		
		while (!currentLine.equals("")) {
			currentLine				= br.readLine();
				
//			Page page = new Page(currentLine);
//			if (page.getContent() != null) {
//				System.out.println(currentRedirectionPage + " was already written.");
//				continue;
//			}
			API.delete(currentLine, "[Modif auto] Suppression automatique de fichiers");
			
			System.out.println("Deleted " + currentLine);

			if (justOne) {
				break;
			}
		}
		
		br.close();
	}
	
	@SuppressWarnings("null")
	public void deployModuleRepresentationsAnterieures(boolean realUpload, boolean justOne) {
		int[] nameSpaces = new int[]{API.NS_MAIN};
		PageCollection pageCollection = new PageCollection(
						nameSpaces,
						API.FILTER_NONREDIRECTS,
						"Capacité"
				);
		
		Page page = pageCollection.getNextPage();
		for (int i = 0; i < 7; i++) {
			page = pageCollection.getNextPage();
		}
		
		String text;
		while (page != null) {
			System.out.println(page.getTitle());
			
			text = page.getContent();
			int sectionBegin = text.indexOf("== Représentations antérieures ==");
			
			if (sectionBegin != -1) {
				String section = text.substring(sectionBegin, text.indexOf("==", sectionBegin + 40));
				if (!section.contains("{|")) {
					page = pageCollection.getNextPage();
					continue;
				}

				Pattern p = Pattern.compile(" (?<a>[^ ]*)\\.");
				String newSection = "== Représentations antérieures ==\n{{#invoke:Représentations antérieures|capacite|";
				String gamesString = "";
				
				boolean firstGame = true;
				Stream<MatchResult> strings = p.matcher(section).results();
				
				for (MatchResult m : (Iterable<MatchResult>) () -> strings.iterator()) {
					String game = section.subSequence(m.start() + 1, section.indexOf(".", m.start())).toString();
					if (firstGame) {
						firstGame = false;
					} else {
						gamesString = gamesString + "/";
					}
					gamesString = gamesString + game;
				}
				
				newSection = newSection + gamesString + "}}\n\n";

				String newText = text.replace(section, newSection);
				
				if (realUpload) {
					page.setContent(newText, "/* Représentations antérieures */ Déploiement du module Représentations antérieures : " + gamesString);
				} else {
					System.out.println(newText);
				}
				
				if (justOne) {
					break;
				}

				page = pageCollection.getNextPage();
			} else {
				page = pageCollection.getNextPage();
			}	
		}
	}
	
	public void generateGeneralItemRedirections(String[] gamesNames, String[] avoidList, boolean reconnaissance, boolean justOne) throws InterruptedException {
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
	
	public void createFootprintsRedirections(boolean justOne) throws InterruptedException {
		String game = "NB";
		String gameLong = Util.gamesShortToGamesLong(game);
		
		String[] fileNames = {"Fichier:Empreinte 0527.png", "Fichier:Empreinte 0535.png", "Fichier:Empreinte 0541.png", "Fichier:Empreinte 0544.png", "Fichier:Empreinte 0546.png", "Fichier:Empreinte 0548.png", "Fichier:Empreinte 0550.png", "Fichier:Empreinte 0561.png", "Fichier:Empreinte 0562.png", "Fichier:Empreinte 0563.png", "Fichier:Empreinte 0564.png", "Fichier:Empreinte 0577.png", "Fichier:Empreinte 0578.png", "Fichier:Empreinte 0579.png", "Fichier:Empreinte 0582.png", "Fichier:Empreinte 0583.png", "Fichier:Empreinte 0584.png", "Fichier:Empreinte 0589.png", "Fichier:Empreinte 0590.png", "Fichier:Empreinte 0591.png", "Fichier:Empreinte 0592.png", "Fichier:Empreinte 0593.png", "Fichier:Empreinte 0594.png", "Fichier:Empreinte 0597.png", "Fichier:Empreinte 0599.png", "Fichier:Empreinte 0600.png", "Fichier:Empreinte 0601.png", "Fichier:Empreinte 0602.png", "Fichier:Empreinte 0603.png", "Fichier:Empreinte 0604.png", "Fichier:Empreinte 0607.png", "Fichier:Empreinte 0608.png", "Fichier:Empreinte 0609.png", "Fichier:Empreinte 0615.png", "Fichier:Empreinte 0617.png", "Fichier:Empreinte 0618.png", "Fichier:Empreinte 0635.png", "Fichier:Empreinte 0637.png", "Fichier:Empreinte 0641.png", "Fichier:Empreinte 0642.png", "Fichier:Empreinte 0645.png"};
		for (int i = 610; i<=649; i++) {
			String fileName = "Fichier:Empreinte 0" + Integer.toString(i) + ".png";
//			System.out.println(fileName);
			
			boolean stop = false;
			for (String fn : fileNames) {
				if (fileName.equals(fn)) {
					stop = true;
					break;
				}
			}
			if (stop) { continue; }
			
			int ndex = Integer.parseInt(fileName.replace("Fichier:Empreinte ", "").replace(".png", "").replace(" Originelle", ""));
			String pokemon = PokeData.getPokemonName(ndex);
			
//			if (ndex < 367) {
//				continue;
//			}
			
			
			Page generalRedirection = new Page(fileName);
			Page gameRedirection = new Page(fileName.replace(".png", " " + game + ".png"));
			Page generalRedirectionSteps = new Page(fileName.replace("Empreinte", "Empreintes"));
			Page gameRedirectionSteps = new Page(gameRedirection.getTitle().replace("Empreinte", "Empreintes"));
			
//			Login.login("Matt.");
//			API.delete(generalRedirectionSteps.getTitle(), "[Auto] Redirection créée par erreur");
//			API.delete(gameRedirectionSteps.getTitle(), "[Auto] Redirection créée par erreur");
//			Login.login("Silvallié");
			
//			String baseContent = "#REDIRECTION [[Fichier:Empreinte vide.png]]\n";
			String baseContent = "#REDIRECTION [[" + fileName.replace(".png", " NB.png") + "]]\n";
			String footprintCategory = "[[Catégorie:Empreinte de Pokémon]]\n";
//			String footprintsCategory = "[[Catégorie:Empreintes de Pokémon]]\n";
			String footprintCategoryGame = "[[Catégorie:Empreinte de Pokémon (" + gameLong + ")]]\n";
//			String footprintsCategoryGame = "[[Catégorie:Empreintes de Pokémon (" + gameLong + ")]]\n";
			String pokemonCategory = "[[Catégorie:Image Pokémon représentant " + pokemon + "]]\n";
			
			TimeUnit.SECONDS.sleep(1);
			generalRedirection.setContent(baseContent + footprintCategory, "Création de redirection d'empreinte");
//			gameRedirection.setContent(baseContent + footprintCategoryGame, "Création de redirection d'empreinte vide");
//			generalRedirectionSteps.setContent(baseContent + footprintsCategory, "Création de redirection d'empreintes vide");
//			gameRedirectionSteps.setContent(baseContent + footprintsCategoryGame, "Création de redirection d'empreintes vide");
			
			System.out.println(ndex + " " + pokemon + " ok");
			
			if (justOne) {
				break;
			}
		}
	}
	
	public void addCardTopics(String startingFrom, boolean justOne) {

		String categoryName = "Carte Dresseur";
		
		int[] nameSpaces = new int[]{API.NS_MAIN};
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
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
	
	public void addRequestTables(String startingFrom, boolean justOne) throws InterruptedException {
		String categoryName = "Pokémon";
		
		int[] nameSpaces = new int[]{API.NS_MAIN};
		PageCollection pageCollection = new PageCollection(
					nameSpaces,
					API.FILTER_ALL,
					categoryName
				);
		
//		justOne = true;
		Page typePage = pageCollection.getNextPage();
		typePage = pageCollection.getNextPage();
		String typeTitle = typePage.getTitle();
		
		
		if (startingFrom != null) {
			while (!startingFrom.equals(typeTitle)) {
				typePage = pageCollection.getNextPage();
				typeTitle = typePage.getTitle();
			}
		}
		
		while (typePage != null) {
			typeTitle = typePage.getTitle();
			String pageType = typeTitle; // .replace(" (JCC)", "");
			
			Page categoryPage = new Page("Catégorie:Carte Pokémon représentant " + pageType);
			String categoryTitle = categoryPage.getTitle();
			String contents = categoryPage.getContent();
			String newContents = contents;
			
			if (contents == null) {
				System.out.println("No page found for " + pageType);
				typePage = pageCollection.getNextPage();
				continue;
			}
			
			String newInterwiki = "";
			String interwikiComment = "";
			
//			String newContents = contents.replaceFirst("\n[[", "\n{{Requête ")
			
			if (contents.indexOf("[[de:") == -1) {
				if (contents.indexOf("Méga-") == -1 && contents.indexOf("Gigamax") == -1 &&
						contents.indexOf("Primo-") == -1 && contents.indexOf(" de ") == -1 &&
						contents.indexOf(" d'") == -1 && contents.indexOf(",") == -1 &&
						contents.indexOf("Necrozma ") == -1 && contents.indexOf("Ultra-") == -1 &&
						contents.indexOf("Kyurem") == -1 && contents.indexOf("Infinimax") == -1) {

					System.out.println("Missing interwiki on " + categoryTitle);
					newInterwiki = "\n\n[[de:Sammelkarte von "
							+ "{{subst:#invoke:Data|nompokemon|{{subst:#show: " + pageType + " |? Numéro National }}|langue=de}}]]\n"
							+ "[[en:Category:"
							+ "{{subst:#invoke:Data|nompokemon|{{subst:#show: " + pageType + " |? Numéro National }}|langue=en}} (TCG)]]\n";
					interwikiComment = " + ajout interwiki";
				}
			}
			
			if (contents.indexOf("\n[[") == -1) {
				System.out.println("Missing on " + categoryTitle);
			} else if (contents.indexOf("{{Navigation Requêtes Jeux de cartes") == -1) {
				newContents = newContents.replaceFirst("\n\\[\\[", "\n{{Navigation Requêtes Jeux de cartes\n"
						+ "| [[Pokémon représenté::" + pageType + "]]\n"
//						+ "| class=" + pageType.toLowerCase() + "-jcc\n"
						+ "}}\n\n[[");
			}
			
			newContents = newContents + newInterwiki;
			
//			System.out.println(contents);
			
			if (!contents.equals(newContents)) {
				categoryPage.setContent(newContents, "Ajout d'un tableau de requêtes sémantiques" + interwikiComment);
				
			}
			TimeUnit.SECONDS.sleep(1);
			
			
			if (justOne) {
				break;
			}
			
			typePage = pageCollection.getNextPage();
		}
	}
	
	public void addFormattedNames(String startingFrom, boolean justOne) {
		
//		startingFrom = "Demanta (Neo Destiny 74)";
//		startingFrom = "Zygarde (Promo SM 15)";

		String categoryName = "Carte Pokémon";
//		String categoryName = "Carte Pokémon δ";
//		String categoryName = "Carte Pokémon représentant Mewtwo";
//		String categoryName = "Pas de traduction française";
		
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
	
	public void addSecondaryTopics(String startingFrom, boolean generateCompleteTopicList, boolean justOne) {
		String[] categoryNames = {"Carte du JCCP", "Carte du JCC"};
		String[] keys = {"est visible", "sont visibles", "appara", "est représenté", "sont représenté"};
		List<String> completeTopicList = new ArrayList<String>();
		
		String[] avoidList = {
			"Barpau (Épée et Bouclier Ténèbres Embrasées 038)",
			"Baudrive (Noir & Blanc Explosion Plasma 34)",
			"Capumain (Noir & Blanc Dragons Exaltés 99)",
			"Copieuse (Épée et Bouclier Évolution Céleste 143)",
			"Copieuse (Épée et Bouclier Évolution Céleste 200)",
			"Copieuse (Épée et Bouclier Évolution Céleste 222)",
			"Copieuse (EX Île des Dragons 73)",
			"Copieuse (Expedition 138)",
			"Copieuse (HeartGold SoulSilver 90)",
			"Copieuse (HS Kit du Dresseur Raichu 21)",
			"Copieuse (L'Appel des Légendes 77)",
			"Copieuse (Soleil et Lune Tempête Céleste 127)",
			"Copieuse (Soleil et Lune Tempête Céleste 163)",
			"Copycat (EX Team Rocket Returns 83)",
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
				
//				System.out.println(title);
				
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
						    pattern = Pattern.compile("\\| (nom|nomréel|sujet)[0-9]*=" + topic.replace("(", "\\(").replace(")", "\\)") + "\n");
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
						
						if (justOne) {
							break;
						}
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

	public void addSecondaryTopicsSections(String[] titles, boolean justOne) {
		// Terms with custom secondary topics sections, not to be touched
		String[] exclusionList = new String[]{"Ancient Ruins",
				"Éventail Houleux", "Rouleau Tourbillons Mille Poings", "Rouleau Acerbe Poing Final", "Urne de Vitalité", "Corne Résonnante", "Lanterne Accueillante", "Échange Croisé", "Récepteur Croisé", "Pastille Puissance",
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
			
//			if (justOne) {
//				break;
//			}
		}
	}
	
	public void getSpecialCardNames(String startingFrom, String outputName, boolean post, boolean justOne) throws IOException {
		String[] categoryNames = {"Carte du JCC", "Carte du JCCP"};
//		String[] categoryNames = {"Carte de l'extension XY Vigueur Spectrale"};
		String ans = "";
		
		for (String categoryName : categoryNames) {
			
			int[] nameSpaces = new int[]{API.NS_MAIN};
			PageCollection pageCollection = new PageCollection(
						nameSpaces,
						API.FILTER_ALL,
						categoryName
					);
			
			Page page = pageCollection.getNextPage();
			String title = page.getTitle();
			
//			startingFrom = "ラッキースタジアム Yokohama (Japanese World Challenge Summer)";
			
			if (startingFrom != null) {
				while (!startingFrom.equals(title)) {
					page = pageCollection.getNextPage();
					title = page.getTitle();
				}
			}
			
			while (page != null) {
				title = page.getTitle();
//				System.out.println(title);
				String contents = page.getContent();
				
				if (!contents.contains("{{Infobox Carte") && (!contents.contains("{{Article carte"))) {
					page = pageCollection.getNextPage();
					continue;
				}
				
				String[] lines = contents.split("\n");
				String name = "";
				for (String line : lines) {
					if (line.contains("| nom=")) {
						name = line.replace("| nom=", "");
						break;
					}
				}
				if (name.equals("")) {
					System.err.println("Nom non trouvé pour la carte " + title);
				} else {

					// On remplace les ESPÈCES DELTA
					name = name.replace("ESPÈCES DELTA", "");	
					
					// On remplace les niveaux qui ne sont pas les NIV.X
					name = name.replaceAll("(NIV|LV)\\.[0-9]+", "");
					name = name.replaceAll(" *<small> *</small>", "");
					
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
				page = pageCollection.getNextPage();
			}
			ans = ans + "\n";
		}
		
//		System.out.println(ans);
		ans = "<includeonly>{{#switch: {{{1}}}" + ans + "\n| #default = [[{{{1}}}|{{#invoke:Regexp|retirerparentheses|{{{1}}}}}]]\n}}</includeonly><noinclude>{{/Documentation}}</noinclude>";
		
		FileOutputStream outputStream = new FileOutputStream(outputName);
	    byte[] strToBytes = ans.getBytes();
	    outputStream.write(strToBytes);

	    outputStream.close();
	    
	    if (!justOne && post) {
		    Page page = new Page("Modèle:Lien carte");
		    page.setContent(ans, "Mise à jour des liens de cartes");
	    }
	}
	
	public void backUpArticles(String startingFrom, String outputPath) throws IOException {
		String[] categoryNames = {"Carte du JCC"};
//		String[] categoryNames = {"Carte de l'extension XY Vigueur Spectrale"};
		int counter = 0;
		
		for (String categoryName : categoryNames) {
			
			int[] nameSpaces = new int[]{API.NS_MAIN};
			PageCollection pageCollection = new PageCollection(
						nameSpaces,
						API.FILTER_ALL,
						categoryName
					);
			
			Page page = pageCollection.getNextPage();
			String title = page.getTitle();
			
//			startingFrom = "ピカチュウ (XYプロモカード 090)";
			
			if (startingFrom != null) {
				while (!startingFrom.equals(title)) {
					page = pageCollection.getNextPage();
					title = page.getTitle();
				}
			}
			
			while (page != null) {
				title = page.getTitle();
				
				if (!title.contains("(")) {
					page = pageCollection.getNextPage();
					continue;
				}
				
				String formattedTitle = title.replace("?", "_");
				formattedTitle = formattedTitle.replace(":", "_");
				formattedTitle = formattedTitle.replace("\"", "_");
				String contents = page.getContent();
				
				FileOutputStream outputStream = new FileOutputStream(outputPath + formattedTitle + ".txt");
			    byte[] strToBytes = contents.getBytes();
			    outputStream.write(strToBytes);

			    outputStream.close();
				
				if (counter % 100 == 0) {
					System.out.println(Integer.toString(counter) + " • " + title);
				}
			    
				page = pageCollection.getNextPage();
				counter++;
			    
				
			}
		}
	}
	
	public void convertCardArticle(String startingFrom, String outputName, boolean post, boolean justOne) throws IOException {
//		String[] categoryNames = {"Carte du JCC"};
		String[] categoryNames = {"Carte Promo"};
//		String[] categoryNames = {"Carte de l'extension L'Île Fabuleuse"};
//		String[] categoryNames = {"Carte de l'extension XY Vigueur Spectrale"};
//		String[] categoryNames = {"Carte de l'extension Énergie de base SV"};
//		String[] categoryNames = {"Carte de l'extension Diamant & Perle Trésors Mystérieux"};
//		String[] categoryNames = {"Carte de l'extension Écarlate et Violet Évolutions Prismatiques"};
		
		justOne = false;
		post = true;
		boolean verbose = false;
		
		int howMany = -1;
		if (justOne) {
			howMany = 1;
			verbose = true;
		}
		
		String errorLog = "";
		String convertedContents = "";
		
		int pageCount = 0;
		int errorCount = 0;
		
		// WHEN STARTING???
		startingFrom = "タッチ交換!";
		
		
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

				if (justOne) {
					System.out.println(convertedContents);
				}
				if (howMany == 0) {
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
	
	
	
	/**
	 * Upload tout le contenu d'un dossier et affecte les images à la catégorie indiquée.
	 * @param path le chemin local vers un dossier contenu tous les fichiers à uploader.
	 * @param categoryName le nom de la catégorie à laquelle les fichiers doivent être attachés (sans namespace devant).
	 */
	public void upload(String path, String categoryName) {
		File folder = new File(path);
		if(!folder.exists() || !folder.isDirectory()) {
			System.out.println("path is not a valid folder");
			return;
		}
		File[] files = folder.listFiles();
		for(int i=0; i<files.length; i++) {
			try {
				if(files[i].isFile()) {
					StringBuffer uploadName = new StringBuffer("Fichier:");
					uploadName.append(files[i].getName());

					StringBuffer description = new StringBuffer();
					description.append("[[Catégorie:"+categoryName+"]]\n");

					API.upload(uploadName.toString(), files[i], "", "Upload "+categoryName);
					Page page = new Page(uploadName.toString());
					page.setContent(description.toString(), "Upload "+categoryName);
					System.out.println("\t["+uploadName.toString()+"] ok");
				}
			} catch (Exception e) {
				System.out.println("["+files[i].getName()+"] "+e.getMessage());
			}
		}
	}


	public void sync() {
		System.out.println("sync start");
		PageCollection pageCollection = new PageCollection(API.NS_ALL, API.FILTER_ALL);
		Page page = pageCollection.getNextPage();
		int counter = 0;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}
			page.sync();
			page = pageCollection.getNextPage();
			counter++;
		}
		System.out.println("sync stop");
	}

}
