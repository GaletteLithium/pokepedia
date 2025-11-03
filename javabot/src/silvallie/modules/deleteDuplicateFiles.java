package silvallie.modules;

import silvallie.Page;
import silvallie.Silvallie;

public class deleteDuplicateFiles {
	public static void main(String[] args) {
		long startTime = Silvallie.beginRun();

		String[] 	filesToKeep		= {"Miniature Lune Ball NB.png", "Miniature Plaque Fantô NB.png", "Miniature Niveau Ball NB.png", "Miniature Orbe Flamme NB.png", "Miniature Baie Charti NB.png", "Miniature Roche Chaude NB.png", "Miniature Masse Ball NB.png", "Miniature Foss. Plaque NB.png", "Miniature Bonbon Rage NB.png", "Miniature Plaque Hydro NB.png", "Miniature Baie Chocco NB.png", "Miniature Nœud Destin NB.png", "Miniature Ralentiqueue NB.png", "Miniature Orbe Vie NB.png", "Miniature Pierre Aube NB.png", "Miniature Baie Cobaba NB.png", "Miniature Baie Sédra NB.png", "Miniature Plaque Fer NB.png", "Miniature Roche Glace NB.png", "Miniature Bulbe NB.png", "Miniature Orbe Toxique NB.png", "Miniature B. Étreinte NB.png", "Miniature Lentil. Zoom NB.png", "Miniature Piquants NB.png", "Miniature Plaque Poing NB.png", "Miniature Balle Fer NB.png", "Miniature Boue Noire NB.png", "Miniature Foss. Armure NB.png", "Miniature Pierre Magma NB.png", "Miniature Plaque Herbe NB.png", "Miniature Plaque Terre NB.png", "Miniature Plaque Ombre NB.png", "Miniature Baie Pomroz NB.png", "Miniature Baie Babiri NB.png", "Miniature Baie Micle NB.png", "Miniature Pierre Éclat NB.png", "Miniature Baie Ratam NB.png", "Miniature Compét'Ball NB.png", "Miniature Speed Ball NB.png", "Miniature Plaque Volt NB.png", "Miniature Roche Lisse NB.png", "Miniature Plaquinsect NB.png", "Miniature Plaque Roc NB.png", "Miniature Plaque Toxic NB.png", "Miniature Roche Humide NB.png", "Miniature Lent. Pouv. NB.png", "Miniature Électiriseur NB.png", "Miniature Foss. Plume NB.png", "Miniature Pile NB.png", "Miniature Baie Lampou NB.png", "Miniature Baie Chérim NB.png", "Miniature Baie Kébia NB.png", "Miniature Lumargile NB.png", "Miniature Pierre Nuit NB.png", "Miniature Mémoire Ball NB.png", "Miniature Soin Ball NB.png", "Miniature Baie Pocpoc NB.png", "Miniature Plaquesprit NB.png", "Miniature Gracidée NB.png", "Miniature Copain Ball NB.png", "Miniature Love Ball NB.png", "Miniature Plaque Flam NB.png", "Miniature Plaque Draco NB.png", "Miniature Croc Rasoir NB.png", "Miniature Pt de Mire NB.png", "Miniature Baie Jaboca NB.png", "Miniature Baie Zalis NB.png", "Miniature Casque Brut NB.png", "Miniature Baie Pommo NB.png", "Miniature Baie Jouca NB.png", "Miniature Bouton Fuite NB.png", "Miniature Poképlumet NB.png", "Miniature Maxi Pépite NB.png", "Miniature Loupe NB.png", "Miniature Baie Nanone NB.png", "Miniature Rapide Ball NB.png", "Miniature Sombre Ball NB.png", "Miniature Carapace Mue NB.png", "Miniature Baie Fraigo NB.png", "Miniature Foss. Crâne NB.png", "Miniature Appât Ball NB.png", "Miniature Plaque Glace NB.png", "Miniature Rêve Ball NB.png", "Miniature Plaque Ciel NB.png", "Miniature Baie Panga NB.png", "Miniature Protecteur NB.png", "Miniature Baie Parma NB.png", "Miniature Magmariseur NB.png"};
		String[] 	filesToDelete	= {"Miniature Lune Ball SL.png", "Miniature Plaque Fantôme SL.png", "Miniature Niveau Ball SL.png", "Miniature Orbe Flamme SL.png", "Miniature Baie Charti SL.png", "Miniature Roche Chaude SL.png", "Miniature Masse Ball SL.png", "Miniature Fossile Plaque SL.png", "Miniature Bonbon Rage SL.png", "Miniature Plaque Hydro SL.png", "Miniature Baie Chocco SL.png", "Miniature Nœud Destin SL.png", "Miniature Ralentiqueue SL.png", "Miniature Orbe Vie SL.png", "Miniature Pierre Aube SL.png", "Miniature Baie Cobaba SL.png", "Miniature Baie Sédra SL.png", "Miniature Plaque Fer SL.png", "Miniature Roche Glace SL.png", "Miniature Bulbe SL.png", "Miniature Orbe Toxique SL.png", "Miniature Bande Étreinte SL.png", "Miniature Lentille Zoom SL.png", "Miniature Piquants SL.png", "Miniature Plaque Poing SL.png", "Miniature Balle Fer SL.png", "Miniature Boue Noire SL.png", "Miniature Fossile Armure SL.png", "Miniature Pierre Magma SL.png", "Miniature Plaque Herbe SL.png", "Miniature Plaque Terre SL.png", "Miniature Plaque Ombre SL.png", "Miniature Baie Pomroz SL.png", "Miniature Baie Babiri SL.png", "Miniature Baie Micle SL.png", "Miniature Pierre Éclat SL.png", "Miniature Baie Ratam SL.png", "Miniature Compét'Ball SL.png", "Miniature Speed Ball SL.png", "Miniature Plaque Volt SL.png", "Miniature Roche Lisse SL.png", "Miniature Plaque Insecte SL.png", "Miniature Plaque Roc SL.png", "Miniature Plaque Toxic SL.png", "Miniature Roche Humide SL.png", "Miniature Lentille Pouvoir SL.png", "Miniature Électriseur SL.png", "Miniature Fossile Plume SL.png", "Miniature Pile SL.png", "Miniature Baie Lampou SL.png", "Miniature Baie Chérim SL.png", "Miniature Baie Kébia SL.png", "Miniature Lumargile SL.png", "Miniature Pierre Nuit SL.png", "Miniature Mémoire Ball SL.png", "Miniature Soin Ball SL.png", "Miniature Baie Pocpoc SL.png", "Miniature Plaque Esprit SL.png", "Miniature Gracidée SL.png", "Miniature Copain Ball SL.png", "Miniature Love Ball SL.png", "Miniature Plaque Flamme SL.png", "Miniature Plaque Draco SL.png", "Miniature Croc Rasoir SL.png", "Miniature Point de Mire SL.png", "Miniature Baie Jaboca SL.png", "Miniature Baie Zalis SL.png", "Miniature Casque Brut SL.png", "Miniature Baie Pommo SL.png", "Miniature Baie Jouca SL.png", "Miniature Bouton Fuite SL.png", "Miniature Poké Plumet SL.png", "Miniature Maxi Pépite SL.png", "Miniature Loupe SL.png", "Miniature Baie Nanone SL.png", "Miniature Rapide Ball SL.png", "Miniature Sombre Ball SL.png", "Miniature Carapace Mue SL.png", "Miniature Baie Fraigo SL.png", "Miniature Fossile Crâne SL.png", "Miniature Appât Ball SL.png", "Miniature Plaque Glace SL.png", "Miniature Rêve Ball SL.png", "Miniature Plaque Ciel SL.png", "Miniature Baie Panga SL.png", "Miniature Protecteur SL.png", "Miniature Baie Parma SL.png", "Miniature Magmariseur SL.png"};
		String		category		= "[[Catégorie:Miniature d'objet (Soleil et Lune)]]";
		boolean		justOne			= true;

		for(int i = 0; i < filesToKeep.length; i++) {
			String	toKeep			= "Fichier:" + filesToKeep[i];
			String	toDelete		= "Fichier:" + filesToDelete[i];
			Page 	pageToKeep		= new Page(toKeep);
			Page	pageToDelete	= new Page(toDelete);

//			API.delete(toDelete, "Remplacement par une redirection vers le fichier identique [[" + toKeep + "]]");
			pageToDelete.setContent("#REDIRECTION [[" + toKeep + "]]\n\n" + category, "Création de redirection vers [[" + toKeep + "]]");

			System.out.println("ok: " + toKeep + " => " + toDelete);

			if (justOne) {
				break;
			}
		}

		Silvallie.endRun(startTime);
	}
}
