package silvallie.modules;

import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class createSpriteRedirections {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		File listPath = new File(pokepediaPath + "Robot\\createSpriteRedirections\\N2B2.txt");
		String from = "NB.";
		String to = "N2B2.";
		String gameLongName = "Noir 2 et Blanc 2";
		boolean justOne = true;

		FileReader fr						= new FileReader(listPath);
		BufferedReader br						= new BufferedReader(fr);

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
		Silvallie.endRun(startTime);
	}
}
