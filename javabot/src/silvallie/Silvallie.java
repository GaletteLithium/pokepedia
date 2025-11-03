package silvallie;

import java.io.*;

@SuppressWarnings("unused")
public class Silvallie {
	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = beginRun();
		
		//sync();
		Silvallie bot = new Silvallie();
		bot.run();

		endRun(startTime);
	}

	/**
	 * Begin a run and login
	 * @return startTime The time token the program started at, to use for {@link #endRun}
	 */
	public static long beginRun() {
		long startTime = System.nanoTime();
		System.out.println("start");

		Login.login("Silvallié"); // à commenter
//		Login.login("Matt."); // à commenter
//		API.login(username, password);
		return startTime;
	}

	/**
	 * End the run, printing how much time has elapsed
	 * @param startTime The time token the program started at, given by {@link #beginRun}
	 */
	public static void endRun(long startTime) {
		System.out.println("stop");
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000000;

		System.out.println("Execution time: " + duration / 60 + " min " + duration % 60 + " s");
	}

	@SuppressWarnings("unused")
	public void run() throws IOException, InterruptedException {
		String pokepediaPath = Util.getPokepediaPath();

//		String[] titles = {"Fichier:Miniature 0710 Normale XY.png", "Fichier:Miniature 0711 Mini XY.png", "Fichier:Miniature 0710 Maxi XY.png", "Fichier:Miniature 0710 Ultra XY.png"};
//		for (String title : titles) {
//			Page page = new Page(title);
//			page.setContent("#REDIRECTION [[Fichier:Miniature 0710 XY.png]]\n\n[[Catégorie:Miniature Pokémon (X et Y)]]", "Catégorisation de la redirection");
//			System.out.println(title + " ok");
//		}

//		Login.login("Matt.");
//		API.delete("Fichier:Carte Pop Series 5 1.png");
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
