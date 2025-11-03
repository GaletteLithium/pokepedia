package silvallie.modules.upload;

import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class uploadCardArticles {
	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File folderPath = new File(pokepediaPath + "Robot\\JCC\\limitless_scraping\\Extensions\\Promo ME\\");
		boolean skipExistingArticles = false;
		boolean justOne = true;

		File[] contents = folderPath.listFiles();

		for(int i=0; i<contents.length; i++) {
			String fileName = contents[i].getName();

//			System.out.println(fileName);


			if (fileName.substring(fileName.length()-4,fileName.length()).equals(".txt")) {
				String uploadName = contents[i].getName().replace(".txt", "").replace("$", ":");

				Page page = new Page(uploadName);
				String pageContents = page.getContent();


				if (!skipExistingArticles || pageContents == null || pageContents == "") {

//					System.out.println("\t" + page.getTitle());

					String fileContents = new String(Files.readAllBytes(Paths.get(folderPath + "\\" + fileName)), StandardCharsets.UTF_8);

					String description = "{{Édité par robot|Édition initiale des articles de cartes du JCC.}}\n" + fileContents;

					page.setContent(description, "Édition initiale des articles de cartes");

					System.out.println(uploadName + " ok");

					TimeUnit.SECONDS.sleep(1);

					if (justOne) {
						break;
					}
				}
			}

			Silvallie.endRun(startTime);
		}
	}
}
