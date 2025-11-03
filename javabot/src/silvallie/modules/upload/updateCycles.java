package silvallie.modules.upload;

import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class updateCycles {
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		String path = pokepediaPath + "Robot\\cycles_list.txt";
		int startPage = 1040;
		boolean justOne = true;

		run(path, startPage, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Replace the <code>oeufpas</code> parameter of a given Pokémon list by the associated number of cycles
	 * @param path Path to the text file
	 * @param startPage Index of the first page to be computed, if the program stopped mid-run (0 to begin from start)
	 * @param justOne Set to true to stop after the first successful replacement. Please use this on the first run to avoid accidents
	 */
	private static void run(String path, int startPage, boolean justOne) throws IOException {

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		//ArrayList plutôt que String[] afin que ça marche peu importe le nombre de lignes du fichier
		ArrayList<String[]> tab = new ArrayList<>();

		String line = br.readLine();
		//Ici, on saute le nombre de lignes voulues
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
}
