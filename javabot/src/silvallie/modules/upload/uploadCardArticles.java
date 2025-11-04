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

		run(folderPath, skipExistingArticles, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Uploads card articles from a folder
	 * @param folderPath The folder containing the card articles to be uploaded
	 * @param skipExistingArticles Set to true to skip any non-empty articles
	 * @param justOne Set to true to stop after the first upload. Please use this on the first run to avoid accidents
	 */
	private static void run(File folderPath, boolean skipExistingArticles, boolean justOne) throws IOException, InterruptedException {
		File[] contents = folderPath.listFiles();

		assert contents != null;
		for (File content : contents) {
			String fileName = content.getName();

//			System.out.println(fileName);

			if (fileName.endsWith(".txt")) {
				String uploadName = content.getName().replace(".txt", "").replace("$", ":");

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
		}
	}
}
