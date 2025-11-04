package silvallie.modules.routine;

import silvallie.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class fullUpdateLocations {
	public static void main(String args[]) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		String dumpPath = pokepediaPath + "Robot\\dumps\\locdump\\";
		String pythonConverterPath = pokepediaPath + "Robot\\locdata_converter.py";
		String convertedDumpPath = pokepediaPath + "Robot\\dumps\\locdump_converted\\";

		dumpContentFromPages(dumpPath, false);
		pythonLocDataConverter(pythonConverterPath);
		uploadLocations(convertedDumpPath, false);

		Silvallie.endRun(startTime);
	}

	/**
	 * Saves the contents of a page at a given dump folder
	 * @param path Path to the folder to save the dump
	 * @param page The page to dump
	 */
	public static void savePage(String path, Page page) throws IOException {
		String pageName = page.getTitle();
		String pageSave = pageName.replace(":", "-");

		Path saveFilePath = Path.of(path + pageSave + ".txt");
		String pageContent = page.getContent();

		Files.writeString(saveFilePath, pageContent);
		System.out.println(pageName + " dump ok");
	}

	/**
	 * Dumps content from all pages from the category <a href="https://www.pokepedia.fr/Catégorie:Page_avec_un_module_Tableau_Pokémon">Page avec un module Tableau Pokémon</a>
	 * and saves it in multiple files in a given folder
	 * @param path Path to the folder to save the dumps
	 * @param justOne Set to true to stop after the first page dump. Please use this on the first run to avoid accidents
	 */
	public static void dumpContentFromPages(String path, boolean justOne) throws IOException {

		String[] categoryNames = new String[] {"Page avec un module Tableau Pokémon"};
//		String[] moreArticles = new String[] {"Pokémon mouvant", "Monde Distorsion", "Réserve Naturelle", "Pokémon Rubis Oméga et Saphir Alpha : Version démo spéciale", "Expédition Dynamax", "Quête des Taupiqueur d'Alola"};
		List<PageCollection> pageCollections = new ArrayList<>();
		for (String categoryName : categoryNames) {

			PageCollection pageCollection = new PageCollection(
					new int[]{API.NS_MAIN},
					API.FILTER_NONREDIRECTS,
					categoryName
			);
			pageCollections.add(pageCollection);
			System.out.println(categoryName + " category dump ok");
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

	/**
	 * Converts the Python script into a Java readable program
	 * @param pythonConverterPath Path to the locdata_converter.py script
	 */
	public static void pythonLocDataConverter(String pythonConverterPath) throws IOException {
		Process p = Runtime.getRuntime().exec("python " + pythonConverterPath + "\"");
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	/**
	 * Uploads the converted dumps to Poképédia
	 * @param path Path to the folder of the converted dumps
	 * @param justOne Set to true to stop after the first dump upload. Please use this on the first run to avoid accidents
	 */
	@SuppressWarnings("resource")
	public static void uploadLocations(String path, boolean justOne) throws IOException {
		File folderPath = new File(path);
		File[] contents = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			String contentString	= contents[i].getName();
			contentString = contentString.replace("_", ":");
			contentString = contentString.replace(".txt", "");
			String uploadName		= "Module:Localisations/Données/" + contentString;

			FileReader fr		= new FileReader(contents[i]);
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
}
