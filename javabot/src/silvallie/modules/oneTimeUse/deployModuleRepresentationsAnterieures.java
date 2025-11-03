package silvallie.modules.oneTimeUse;

import silvallie.*;

import java.io.File;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class deployModuleRepresentationsAnterieures {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();

		boolean realUpload = true;
		boolean justOne = true;

		run(realUpload, justOne);

		Silvallie.endRun(startTime);
	}

	/**
	 * Deploys the <a href="https://www.pokepedia.fr/Module:Représentations_antérieures">Module:Représentations antérieures</a> on all move pages
	 * @param realUpload Set to true to actually edit the pages
	 * @param justOne Set to true to stop after the first page. Please use this on the first run to avoid accidents
	 */
	@SuppressWarnings("null")
	public static void run(boolean realUpload, boolean justOne) {
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
}
