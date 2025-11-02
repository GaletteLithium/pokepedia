package silvallie.modules;

import silvallie.API;
import silvallie.Page;
import silvallie.PageCollection;
import silvallie.Util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class fullUpdateLocations {


    public static void main(String[] args) throws IOException {
        dumpContentFromPages(false);
        pythonLocDataConverter();
        uploadLocations(false);

    }


    public static void savePage(String path, Page page) throws IOException {
        String pageName = page.getTitle();
        String pageSave = pageName.replace(":", "-");

        Path saveFilePath = Path.of(path + pageSave + ".txt");
        String pageContent = page.getContent();

        Files.writeString(saveFilePath, pageContent);
        System.out.println(pageName + " dump ok");
    }

    public static void dumpContentFromPages(boolean justOne) throws IOException {

        String[] categoryNames = new String[] {"Page avec un module Tableau Pokémon"};
//		String[] moreArticles = new String[] {"Pokémon mouvant", "Monde Distorsion", "Réserve Naturelle", "Pokémon Rubis Oméga et Saphir Alpha : Version démo spéciale", "Expédition Dynamax", "Quête des Taupiqueur d'Alola"};
        String path = Util.getPokepediaPath() + "Robot\\dumps\\locdump\\";
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

    public static void pythonLocDataConverter() throws IOException {
        Process p = Runtime.getRuntime().exec("python " + Util.getPokepediaPath() + "Robot\\locdata_converter.py\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    @SuppressWarnings("resource")
    public static void uploadLocations(boolean justOne) throws IOException {
        File folderPath = new File(Util.getPokepediaPath() + "Robot\\dumps\\locdump_converted\\");

        File contents[] = folderPath.listFiles();


        for(int i=0; i<contents.length; i++) {
            String contentString	= contents[i].getName();
            contentString = contentString.replace("_", ":");
            contentString = contentString.replace(".txt", "");
            String uploadName		= "Module:Localisations/Données/" + contentString;

            Page filePage = new Page(uploadName);


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
