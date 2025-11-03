package silvallie.modules;

import silvallie.Page;
import silvallie.Silvallie;

import java.util.concurrent.TimeUnit;

public class redirectionsCharmilly {
	public static void main(String[] args) throws InterruptedException {
		long startTime = Silvallie.beginRun();

		boolean isMiniature = false;
		String game = "EV";
		boolean justOne = true;

		run(isMiniature, game, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Creates redirections for all Alcreamie sprites or miniatures that don't have a distinct image
	 * @param isMiniature Set to true if the program should compute over miniatures
	 * @param game Abbreviated form of the game (example: EV)
	 * @param justOne Set to true to stop after the first redirection creation. Please use this on the first run to avoid accidents
	 */
	private static void run(boolean isMiniature, String game, boolean justOne) throws InterruptedException {
		String[] sucres = {"Fraise", "Baie", "Cœur", "Étoile", "Trèfle", "Fleur", "Ruban"};
		String[] nappages = {"Lait Vanille", "Lait Ruby", "Lait Matcha", "Lait Menthe", "Lait Citron", "Lait Salé", "Mélange Ruby", "Mélange Caramel", "Mélange Tricolore"};

		if (isMiniature) {
			for (String nappage : nappages) {
				String target = "Fichier:Miniature 0869 " + nappage + " " + game + ".png";
				for (String sucre : sucres) {
					Page page = new Page("Fichier:Miniature 0869 " + nappage + " " + sucre + " en Sucre " + game + ".png");
					page.setContent("#REDIRECTION [[" + target + "]]", "Redirection vers [[" + target + "]]");
					System.out.println(nappage + " " + sucre + " en Sucre ok");
					System.out.println("-> " + target);
					if (justOne) {
						return;
					}

					TimeUnit.SECONDS.sleep(1);
				}
			}
		} else {
			for (String sucre : sucres) {
				String target = "Fichier:Sprite 0869 " + sucre + " en Sucre chromatique " + game + ".png";
				for (String nappage : nappages) {
					Page page = new Page("Fichier:Sprite 0869 " + nappage + " " + sucre + " en Sucre chromatique " + game + ".png");
					page.setContent("#REDIRECTION [[" + target + "]]", "Redirection vers [[" + target + "]]");
					System.out.println(nappage + " " + sucre + " en Sucre ok");
					System.out.println("-> " + target);
					if (justOne) {
						return;
					}
				}
			}
		}
	}
}
