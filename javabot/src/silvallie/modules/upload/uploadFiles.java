package silvallie.modules.upload;

import silvallie.API;
import silvallie.Page;
import silvallie.Silvallie;
import silvallie.Util;

import java.io.File;
import java.io.IOException;

public class uploadFiles {
	/**
	 * @deprecated Since the addition of the multiupload gadget. Please use {@link uploadFilesWithDescriptions}
	 */
	public static void main(String[] args) throws IOException {
		long startTime = Silvallie.beginRun();
		String pokepediaPath = Util.getPokepediaPath();

		// run(path, categoryName);

		Silvallie.endRun(startTime);
	}

	/**
	 * Upload contents of a folder and adds the given category
	 * @param path The path to the folder containing the files
	 * @param categoryName The name of the category (example: Artwork Pokémon d'Épée et Bouclier)
	 */
	private static void run(String path, String categoryName) {
		File folder = new File(path);
		if(!folder.exists() || !folder.isDirectory()) {
			System.out.println("path is not a valid folder");
			return;
		}
		File[] files = folder.listFiles();
		for(int i=0; i<files.length; i++) {
			try {
				if(files[i].isFile()) {
					StringBuffer uploadName = new StringBuffer("Fichier:");
					uploadName.append(files[i].getName());

					StringBuffer description = new StringBuffer();
					description.append("[[Catégorie:"+categoryName+"]]\n");

					API.upload(uploadName.toString(), files[i], "", "Upload "+categoryName);
					Page page = new Page(uploadName.toString());
					page.setContent(description.toString(), "Upload "+categoryName);
					System.out.println("\t["+uploadName.toString()+"] ok");
				}
			} catch (Exception e) {
				System.out.println("["+files[i].getName()+"] "+e.getMessage());
			}
		}
	}
}
