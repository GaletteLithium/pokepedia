import os
import re

capa_list = ["Poing Glace", "Poing Éclair", "Danse Lames", "Tornade", "Charge", "Damoclès", "Dard-Venin", "Dard-Nuée", "Morsure", "Flammèche", "Lance-Flammes", "Hydrocanon", "Laser Glace", "Blizzard", "Ultralaser", "Vole-Vie", "Poudre Toxik", "Para-Spore", "Poudre Dodo", "Danse Fleurs", "Éclair", "Tonnerre", "Cage Éclair", "Fatal-Foudre", "Choc Mental", "Psyko", "Hypnose", "Vive-Attaque", "Téléport", "Copie", "Soin", "Puissance", "Destruction", "Déflagration", "Météores", "E-Coque", "Gaz Toxik", "Vampirisme", "Écume", "Spore", "Trempette", "Acidarmure", "Repos", "Éboulement", "Triplattaque", "Tranche", "Lutte", "Roue de Feu", "Poudreuse", "Mach Punch", "Bombe Beurk", "Coud'Boue", "Octazooka", "Picots", "Vent Glace", "Colère", "Roulade", "Faux-Chage", "Étincelle", "Mégacorne", "Queue de Fer", "Puissance Cachée", "Ouragan", "Mâchouille", "Pouvoir Antique", "Ball'Ombre", "Éclate-Roc", "Ball'Glace", "Étonnement", "Tranch'Air", "Surchauffe", "Vent Argenté", "Extrasenseur", "Aéropique", "Mur de Fer", "Draco-Griffe", "Gonflette", "Électacle", "Feuille Magik", "Plénitude", "Lame Feuille", "Vibraqua", "Atterrissage", "Close Combat", "Boutefeu", "Aurasphère", "Direct Toxik", "Vibrobscur", "Tranche-Nuit", "Hydro-Queue", "Lame d'Air", "Plaie Croix", "Bourdon", "Draco-Choc", "Rayon Gemme", "Vampi-Poing", "Éco-Sphère", "Rapace", "Telluriforce", "Giga Impact", "Machination", "Pisto-Poing", "Éclats Glace", "Griffe Ombre", "Crocs Éclair", "Crocs Givre", "Crocs Feu", "Ombre Portée", "Boue-Bombe", "Coupe Psycho", "Psykoud'Boul", "Luminocanon", "Draco-Météore", "Tempête Verte", "Poison Croix", "Tête de Fer", "Lame de Roc", "Piège de Roc", "Jugement", "Rayon Chargé", "Martobois", "Aqua-Jet", "Fracass'Tête", "Coup Double", "Hurle-Temps", "Spatio-Rift", "Presse", "Vortex Magma", "Trou Noir", "Fulmigraine", "Vent Mauvais", "Revenant", "Choc Venin", "Bombe Acide", "Châtiment", "Survinsecte", "Piétisol", "Éclair Fou", "Vent Violent", "Aboiement", "Chute Glace", "Vampibaiser", "Câlinerie", "Vent Féérique", "Pouvoir Lunaire", "Feu Ensorcelé", "Éclat Magique", "Regard Touchant", "Cavalerie Lourde", "Feuillage", "Aqua-Brèche", "Métalaser", "Griffes Funestes", "Sprint Bouclier", "Échange Force", "Hache de Pierre", "Typhon Passionné", "Force Mystique", "Grand Courroux", "Aquatacle", "Herblast", "Bise Glaciaire", "Danse Victoire", "Assaut Frontal", "Multitoxik", "Ailes Psycho", "Cœur de Rancœur", "Mur Fumigène", "Triple Flèche", "Cortège Funèbre", "Vagues à Lames", "Typhon Hivernal", "Typhon Fulgurant", "Typhon Pyrosable", "Prière Lunaire", "Extravaillance"]

foldername = "../Images/Capacités LPA/"

for filename in os.listdir(foldername):
	capa_name = foldername + filename
	capa_name = re.sub(r"(| \([^\)]*\));.*\.mp4", "", capa_name)
	capa_name = re.sub(r".*/", "", capa_name)
	print(capa_name)
	if capa_name in capa_list:
		capa_list.remove(capa_name)

print(capa_list)