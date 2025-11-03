package silvallie.modules.oneTimeUse;

import silvallie.Page;
import silvallie.PokeData;
import silvallie.Silvallie;
import silvallie.Util;

import java.util.concurrent.TimeUnit;

public class createFootprintsRedirections {
	public static void main(String[] args) throws InterruptedException {
		long startTime = Silvallie.beginRun();

		String game = "NB";
		String gameLong = Util.gamesShortToGamesLong(game);
		String[] fileNames = {"Fichier:Empreinte 0527.png", "Fichier:Empreinte 0535.png", "Fichier:Empreinte 0541.png", "Fichier:Empreinte 0544.png", "Fichier:Empreinte 0546.png", "Fichier:Empreinte 0548.png", "Fichier:Empreinte 0550.png", "Fichier:Empreinte 0561.png", "Fichier:Empreinte 0562.png", "Fichier:Empreinte 0563.png", "Fichier:Empreinte 0564.png", "Fichier:Empreinte 0577.png", "Fichier:Empreinte 0578.png", "Fichier:Empreinte 0579.png", "Fichier:Empreinte 0582.png", "Fichier:Empreinte 0583.png", "Fichier:Empreinte 0584.png", "Fichier:Empreinte 0589.png", "Fichier:Empreinte 0590.png", "Fichier:Empreinte 0591.png", "Fichier:Empreinte 0592.png", "Fichier:Empreinte 0593.png", "Fichier:Empreinte 0594.png", "Fichier:Empreinte 0597.png", "Fichier:Empreinte 0599.png", "Fichier:Empreinte 0600.png", "Fichier:Empreinte 0601.png", "Fichier:Empreinte 0602.png", "Fichier:Empreinte 0603.png", "Fichier:Empreinte 0604.png", "Fichier:Empreinte 0607.png", "Fichier:Empreinte 0608.png", "Fichier:Empreinte 0609.png", "Fichier:Empreinte 0615.png", "Fichier:Empreinte 0617.png", "Fichier:Empreinte 0618.png", "Fichier:Empreinte 0635.png", "Fichier:Empreinte 0637.png", "Fichier:Empreinte 0641.png", "Fichier:Empreinte 0642.png", "Fichier:Empreinte 0645.png"};
		boolean justOne = true;

		run(game, gameLong, fileNames, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Creates general redirections for footprints files
	 * @param game Abbreviated form of the games the artworks originate from, used in the files' title (example: EV)
	 * @param gameLong Long form of the games the artworks originate from, used in the category (example: Écarlate et Violet)
	 * @param fileNames A exhaustive list of the general redirections to be created
	 * @param justOne Set to true to stop after the first redirection creation. Please use this on the first run to avoid accidents
	 */
	private static void run(String game, String gameLong, String[] fileNames, boolean justOne) throws InterruptedException {
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
}
