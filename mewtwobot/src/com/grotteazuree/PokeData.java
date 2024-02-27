package com.grotteazuree;

import java.util.HashMap;

public class PokeData {


	public static String[] capacites = {"À la Queue", "Abîme", "Aboiement", "Abri", "Acidarmure", "Acide", "Acrobatie", "Acupression", "Aéro Noir", "Aéro-Lames", "Aéroblast", "Aéropique", "Affûtage", "Aiguisage", "Aile d'Acier", "Air Veinard", "Aire d'Eau", "Aire d'Herbe", "Aire de Feu", "Allègement", "Amnésie", "Ampleur", "Anneau Hydro", "Anti-Air", "Anti-Brume", "Anti-Soin", "Appel Attak", "Appel Défense", "Appel Soins", "Après Vous", "Aqua-Jet", "Ardeur Noire", "Armure", "Aromathérapie", "Assaut Noir", "Assistance", "Assurance", "Astuce Force", "Atout", "Atterrissage", "Attraction (attaque)", "Attrition", "Aurasphère", "Aurore (attaque)", "Avalanche", "Avale", "Babil", "Bâillement", "Bain de Smog", "Balance (attaque)", "Balayage", "Balayette", "Ball'Brume", "Ball'Glace", "Ball'Météo", "Ball'Ombre", "Balle Graine", "Bang Sonique", "Barrage", "Baston", "Bec Vrille", "Bélier", "Bélier Noir", "Berceuse", "Blabla Dodo", "Blizzard", "Blocage Noir", "Bluff", "Bomb'Œuf", "Bomb-Beurk", "Bombaimant", "Bombe Acide", "Boost", "Bouclier", "Bouclier Royal", "Boue-Bombe", "Boul'Armure", "Boule Élek", "Boule Roc", "Bourdon", "Boutefeu", "Brouhaha", "Brouillard (attaque)", "Brume", "Brume Capiteuse", "Brume Noire", "Buée Noire", "Bulldoboule", "Bulles d'O", "Cadeau", "Cage-Éclair", "Calcination", "Câlinerie", "Camaraderie", "Camouflage", "Canicule (attaque)", "Canon Graine", "Carnareket", "Cascade", "Casse-Brique", "Cauchemar", "Célébration", "Champ Brumeux", "Champ Herbu", "Champ Électrifié", "Change Éclair", "Changement Vitesse", "Chant Antique", "Chant Canon", "Charge", "Charge Foudre", "Charge Noire", "Charge-Os", "Chargeur", "Charme (attaque)", "Chatouille", "Choc Mental", "Choc Psy", "Choc Venin", "Chute Glace", "Chute Libre", "Chute Noire", "Châtiment", "Ciel Noir", "Clairvoyance", "Claquoir", "Clonage (attaque)", "Close Combat", "Cogne", "Cognobidon", "Colère", "Combo-Griffe", "Confidence", "Constriction", "Contre", "Conversion", "Conversion2", "Copie", "Copie Type", "Coquilame", "Corps Perdu", "Cotogarde", "Coud'Boue", "Coud'Krâne", "Coup Bas", "Coup d'Boule", "Coup d'Jus", "Coup d'Main", "Coup Double", "Coup Victoire", "Coup-Croix", "Coupe", "Coupe Psycho", "Coupe-Vent", "Cradovague", "Crèvecœur", "Croc de Mort", "Croc Fatal", "Crochet Venin", "Croco Larme", "Crocs Éclair", "Crocs Feu", "Crocs Givre", "Croissance", "Cru-Aile", "Cyclone", "Damoclès", "Danse Draco", "Danse du Feu", "Danse Flamme", "Danse-Fleur", "Danse-Folle", "Danse-Lames", "Danse-Lune", "Danse Pluie", "Danse-Plume", "Dard Mortel", "Dard-Nuée", "Dard-Venin", "Déflagration", "Dégommage", "DélugePlasmique", "Demi-Tour", "Dépit", "Dernier Mot", "Dernier Recours", "Destruction", "Détection", "Détrempage", "Détricanon", "Détritus", "Dévorêve", "Direct Toxik", "Distorsion (attaque)", "Don Naturel", "Double Baffe", "Double-Dard", "Double-Pied", "Doux Baiser", "Doux Parfum", "Draco Ascension", "Draco-Queue", "Draco-Rage", "Dracocharge", "Dracochoc", "Dracogriffe", "Draco Météor", "Dracosouffle", "Dynamopoing", "E-Coque", "Éboulement", "Ébullilave", "Ébullition", "Échange (attaque)", "Échange Psy", "Écho (attaque)", "Éclair", "Éclair Croix", "Éclair Fou", "Éclair Gelé", "Éclair Noir", "Éclat Magique", "Éclate Griffe", "Éclate-Roc", "Éclats Glace", "Éco-Sphère", "Écras'Face", "Écrasement", "Écume", "Effort", "Élécanon", "Électacle", "Électrisation", "Embargo", "Empal'Korne", "Encore", "Encornebois", "Enroulement", "Entrave", "Ère Glaciaire", "Éructation", "Éruption", "Escalade", "Essorage", "Étincelle", "Étonnement", "Étreinte", "Étrennes", "Exploforce", "Explonuit", "Explosion", "Extrasenseur", "Exuviation", "Fatal-Foudre", "Faucheuse", "Faux-Chage", "Façade", "Feinte", "Fertilisation", "Feu d'Enfer", "Feu Ensorcelé", "Feu Follet", "Feu Glacé", "Feu Sacré", "Feuille Magik", "Flair", "Flamme Bleue", "Flamme Croix", "Flammèche", "Flash", "Flatterie", "Fléau", "Flying Press", "Folie Noire", "Force", "Force Ajoutée", "Force Cachée", "Force Chtonienne", "Force Cosmik", "Force Poigne", "Force-Nature", "Forte-Paume", "Fouet Lianes", "Fracass'Tête", "Frappe Atlas", "Frappe Psy", "Frénésie", "Froid Noir", "Frotte-Frimousse", "Frustration", "Fulmifer", "Fulmigraine", "Furie", "Garde Florale", "Garde Large", "Gaz Toxik", "Géo-Contrôle", "Giclédo", "Giga Impact", "Giga-Sangsue", "Glaciation", "Glas de Soin", "Gonflette", "Gravité", "Grêle (attaque)", "Gribouille", "Griffe", "Griffe Acier", "Griffe Ombre", "Grimace", "Grincement", "Grobisou", "Grondement", "Groz'Yeux", "Guillotine", "Gyroballe", "Halloween", "Hantise", "Harcèlement", "Hâte", "Hurle-Temps", "Hurlement", "Hydroblast", "Hydrocanon", "Hydroqueue", "Hypnose", "Imitation", "Implore", "Incendie", "Interversion", "Jackpot", "Jet de Sable", "Jet-Pierres", "Jugement", "Koud'Korne", "Lait à Boire", "Lame d'Air", "Lame de Roc", "Lame Ointe", "Lame Pangéenne", "Lame Sainte", "Lame-Feuille", "Lance-Boue", "Lance-Flammes", "Lance-Soleil", "Lancécrou", "Larcin", "Laser Glace", "Léchouille", "Lévikinésie", "Ligotage", "Lilliput", "Lire-Esprit", "Lumi-Éclat", "Luminocanon", "Lumiqueue", "Lutte", "Lyophilisation", "Mach Punch", "Machination", "Mâchouille", "Magné-Contrôle", "Mains Jointes", "Malédiction", "Maléfice Sylvain", "Mania", "Marto-Poing", "Martobois", "Massd'Os", "Mawashi Geri", "Méga-Sangsue", "Mégacorne", "Mégafouet", "Mégaphone", "Météores", "Métronome (attaque)", "Mimi-Queue", "Mimique", "Miroi-Tir", "Mitra-Poing", "Moi d'Abord", "Morphing", "Morsure", "Mort-Ailes", "Mur de Fer", "Mur Lumière", "Nitrocharge", "Nuée de Poudre", "Nœud Herbe", "Ocroupi", "Octazooka", "Œil Miracle", "Ombre Nocturne", "Ombre Portée", "Onde Boréale", "Onde de Choc (attaque)", "Onde Folie", "Onde Noire", "Onde Originelle", "Onde Vide", "Ondes Étranges", "Orage Adamantin", "Osmerang", "Ouragan", "Papillodanse", "Par Ici", "Para-Spore", "Parabocharge", "Paresse", "Partage Force", "Partage Garde", "Passe-Cadeau", "Passe-Passe", "Patience", "Peignée", "Percée Noire", "Permucœur", "Permuforce", "Permugarde", "Photocopie", "Phytomixeur", "Picanon", "Pico-Défense", "Picore", "Picots", "Picpic", "Pics Toxik", "Pied Brûleur", "Pied Sauté", "Pied Voltige", "Piège de Roc", "Piétisol", "Pilonnage", "Pince-Masse", "Piqué", "Piqûre", "Pisto-Poing", "Pistolet à O", "Piège de Venin", "Plaie-Croix", "Plaquage", "Plénitude", "Plongée", "Plumo-Queue", "Poing Boost", "Poing Comète", "Poing Dard", "Poing de Feu", "Poing Météor", "Poing Ombre", "Poing-Éclair", "Poing-Glace", "Poing-Karaté", "Poison-Croix", "Poliroche", "Possessif", "Poudre Dodo", "Poudre Fureur", "Poudre Toxik", "Poudreuse", "Poursuite", "Pouvoir Antique", "Pouvoir Lunaire", "Prescience", "Presse", "Prévention", "Prélèvem. Destin", "Projection", "Protection", "Provoc", "Psycho Boost", "Psyko", "Psykoud'Boul", "Puissance (attaque)", "Puissance Cachée", "Punition", "Purédpois", "Queue de Fer", "Queue-Poison", "Racines", "Rafale Feu", "Rafale Psy", "Rage Noire", "Râle Mâle", "Rancune", "Rapace", "Rayon Chargé", "Rayon Gemme", "Rayon Lune", "Rayon Signal", "Rayon Simple", "Rebond", "Rebondifeu", "Recyclage", "Reflet", "Reflet Magik", "Regard Médusant", "Regard Noir", "Regard Touchant", "Régénération", "Relais", "Relâche", "Rengorgement", "Renversement", "Repli", "Repos", "Représailles", "Requiem", "Retenue", "Retour", "Retour Noir", "Réveil Forcé", "Revenant", "Riposte", "Roc-Boulet", "Ronflement", "Roue de Feu", "Roulade", "Rugissement", "Rune Protect", "Ruse", "Sabotage", "Sacrifice", "Saisie", "Saumure", "Sécrétion", "Séduction", "Séisme", "Sheauriken", "Siffl'Herbe", "Siphon", "Soin", "Sonicboom", "Soucigraine", "Souffle Glacé", "Souffle Noir", "Souplesse", "Souvenir", "Spatio-Rift", "Spore", "Spore Coton", "Stalagtite", "Stimulant", "Stockage", "Stratopercut", "Strido-Son", "Suc Digestif", "Surchauffe", "Surf", "Surpuissance", "Survinsecte", "Synchropeine", "Synthèse", "Tacle Feu", "Tacle Lourd", "Taillade", "Tatamigaeshi", "Techno Buster", "Télékinésie", "Téléport", "Telluriforce", "Tempête Florale", "Tempête de Sable", "Tempête Verte", "Ten-danse", "Ténacité", "Tête de Fer", "Tir de Boue", "Toile", "Toile Gluante", "Toile Élek", "Tomberoche", "Tonnerre", "Torgnoles", "Tornade", "Tour Rapide", "Tourbi-Sable", "Tourmagik", "Tourmente", "Tourniquet", "Tout ou Rien", "Toxik", "Tranch'Air", "Tranch'Herbe", "Tranche", "Tranche-Nuit", "Trempette", "Tricherie", "Triplattaque", "Triple Pied", "Trou Noir", "Tunnel", "Tunnelier", "Typhon Noir", "Ultimapoing", "Ultimawashi", "Ultralaser", "Ultrason", "Uppercut", "Vague Psy", "Vampibaiser", "Vampigraine", "Vampipoing", "Vampirisme", "Vantardise", "Végé-Attak", "Vendetta", "Vengeance", "Vent Argenté", "Vent Arrière", "Vent Féérique", "Vent Glace", "Vent Mauvais", "Vent Violent", "Verrou Enchanté", "Verrouillage (attaque)", "Vibra Soin", "Vibraqua", "Vibrobscur", "Vigilance", "Vitesse Extrême", "Vive-Attaque", "Vœu", "Vœu Soin", "Voile Miroir", "Voix Enjôleuse", "Vol (attaque)", "Vol Magnétik", "Vol-Vie", "Vortex Magma", "Yama Arashi", "Yoga", "Zénith", "Zone Étrange", "Zone Magique"};
	
	public static String[] pokemon = {"Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel", "Dracaufeu", "Carapuce", "Carabaffe", "Tortank", "Chenipan", "Chrysacier", "Papilusion", "Aspicot", "Coconfort", "Dardargnan", "Roucool", "Roucoups", "Roucarnage", "Rattata", "Rattatac", "Piafabec", "Rapasdepic", "Abo", "Arbok", "Pikachu", "Raichu", "Sabelette", "Sablaireau", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Mélofée", "Mélodelfe", "Goupix", "Feunard", "Rondoudou", "Grodoudou", "Nosferapti", "Nosferalto", "Mystherbe", "Ortide", "Rafflesia", "Paras", "Parasect", "Mimitoss", "Aéromite", "Taupiqueur", "Triopikeur", "Miaouss", "Persian", "Psykokwak", "Akwakwak", "Férosinge", "Colossinge", "Caninos", "Arcanin", "Ptitard", "Têtarte", "Tartard", "Abra", "Kadabra", "Alakazam", "Machoc", "Machopeur", "Mackogneur", "Chétiflor", "Boustiflor", "Empiflor", "Tentacool", "Tentacruel", "Racaillou", "Gravalanch", "Grolem", "Ponyta", "Galopa", "Ramoloss", "Flagadoss", "Magnéti", "Magnéton", "Canarticho", "Doduo", "Dodrio", "Otaria", "Lamantine", "Tadmorv", "Grotadmorv", "Kokiyas", "Crustabri", "Fantominus", "Spectrum", "Ectoplasma", "Onix", "Soporifik", "Hypnomade", "Krabby", "Krabboss", "Voltorbe", "Électrode", "Noeunoeuf", "Noadkoko", "Osselait", "Ossatueur", "Kicklee", "Tygnon", "Excelangue", "Smogo", "Smogogo", "Rhinocorne", "Rhinoféros", "Leveinard", "Saquedeneu", "Kangourex", "Hypotrempe", "Hypocéan", "Poissirène", "Poissoroy", "Stari", "Staross", "M. Mime", "Insécateur", "Lippoutou", "Élektek", "Magmar", "Scarabrute", "Tauros", "Magicarpe", "Léviator", "Lokhlass", "Métamorph", "Évoli", "Aquali", "Voltali", "Pyroli", "Porygon", "Amonita", "Amonistar", "Kabuto", "Kabutops", "Ptéra", "Ronflex", "Artikodin", "Électhor", "Sulfura", "Minidraco", "Draco", "Dracolosse", "Mewtwo", "Mew",
			"Germignon", "Macronium", "Méganium", "Héricendre", "Feurisson", "Typhlosion", "Kaiminus", "Crocrodil", "Aligatueur", "Fouinette", "Fouinar", "Hoothoot", "Noarfang", "Coxy", "Coxyclaque", "Mimigal", "Migalos", "Nostenfer", "Loupio", "Lanturn", "Pichu", "Mélo", "Toudoudou", "Togepi", "Togetic", "Natu", "Xatu", "Wattouat", "Lainergie", "Pharamp", "Joliflor", "Marill", "Azumarill", "Simularbre", "Tarpaud", "Granivol", "Floravol", "Cotovol", "Capumain", "Tournegrin", "Héliatronc", "Yanma", "Axoloto", "Maraiste", "Mentali", "Noctali", "Cornèbre", "Roigada", "Feuforêve", "Zarbi", "Qulbutoké", "Girafarig", "Pomdepik", "Foretress", "Insolourdo", "Scorplane", "Steelix", "Snubbull", "Granbull", "Qwilfish", "Cizayox", "Caratroc", "Scarhino", "Farfuret", "Teddiursa", "Ursaring", "Limagma", "Volcaropod", "Marcacrin", "Cochignon", "Corayon", "Rémoraid", "Octillery", "Cadoizo", "Démanta", "Airmure", "Malosse", "Démolosse", "Hyporoi", "Phanpy", "Donphan", "Porygon2", "Cerfrousse", "Queulorior", "Debugant", "Kapoera", "Lippouti", "Élekid", "Magby", "Écrémeuh", "Leuphorie", "Raikou", "Entei", "Suicune", "Embrylex", "Ymphect", "Tyranocif", "Lugia", "Ho-Oh", "Celebi",
			"Arcko", "Massko", "Jungko", "Poussifeu", "Galifeu", "Braségali", "Gobou", "Flobio", "Laggron", "Medhyèna", "Grahyèna", "Zigzaton", "Linéon", "Chenipotte", "Armulys", "Charmillon", "Blindalys", "Papinox", "Nénupiot", "Lombre", "Ludicolo", "Grainipiot", "Pifeuil", "Tengalice", "Nirondelle", "Hélédelle", "Goélise", "Bekipan", "Tarsal", "Kirlia", "Gardevoir", "Arakdo", "Maskadra", "Balignon", "Chapignon", "Parecool", "Vigoroth", "Monaflèmit", "Ningale", "Ninjask", "Munja", "Chuchmur", "Ramboum", "Brouhabam", "Makuhita", "Hariyama", "Azurill", "Tarinor", "Skitty", "Delcatty", "Ténéfix", "Mysdibule", "Galekid", "Galegon", "Galeking", "Méditikka", "Charmina", "Dynavolt", "Élecsprint", "Posipi", "Négapi", "Muciole", "Lumivole", "Rosélia", "Gloupti", "Avaltout", "Carvanha", "Sharpedo", "Wailmer", "Wailord", "Chamallot", "Camérupt", "Chartor", "Spoink", "Groret", "Spinda", "Kraknoix", "Vibraninf", "Libégon", "Cacnea", "Cacturne", "Tylton", "Altaria", "Mangriff", "Séviper", "Séléroc", "Solaroc", "Barloche", "Barbicha", "Écrapince", "Colhomard", "Balbuto", "Kaorine", "Lilia", "Vacilys", "Anorith", "Armaldo", "Barpau", "Milobellus", "Morphéo", "Kecleon", "Polichombr", "Branette", "Skelénox", "Téraclope", "Tropius", "Éoko", "Absol", "Okéoké", "Stalgamin", "Oniglali", "Obalie", "Phogleur", "Kaimorse", "Coquiperl", "Serpang", "Rosabyss", "Relicanth", "Lovdisc", "Draby", "Drackhaus", "Drattak", "Terhal", "Métang", "Métalosse", "Regirock", "Regice", "Registeel", "Latias", "Latios", "Kyogre", "Groudon", "Rayquaza", "Jirachi", "Deoxys",
			"Tortipouss", "Boskara", "Torterra", "Ouisticram", "Chimpenfeu", "Simiabraz", "Tiplouf", "Prinplouf", "Pingoléon", "Étourmi", "Étourvol", "Étouraptor", "Keunotor", "Castorno", "Crikzik", "Mélokrik", "Lixy", "Luxio", "Luxray", "Rozbouton", "Roserade", "Kranidos", "Charkos", "Dinoclier", "Bastiodon", "Cheniti", "Cheniselle", "Papilord", "Apitrini", "Apireine", "Pachirisu", "Mustébouée", "Mustéflott", "Ceribou", "Ceriflor", "Sancoki", "Tritosor", "Capidextre", "Baudrive", "Grodrive", "Laporeille", "Lockpin", "Magirêve", "Corboss", "Chaglam", "Chaffreux", "Korillon", "Moufouette", "Moufflair", "Archéomire", "Archéodong", "Manzaï", "Mime Jr.", "Ptiravi", "Pijako", "Spiritomb", "Griknot", "Carmache", "Carchacrok", "Goinfrex", "Riolu", "Lucario", "Hippopotas", "Hippodocus", "Rapion", "Drascore", "Cradopaud", "Coatox", "Vortente", "Écayon", "Luminéon", "Babimanta", "Blizzi", "Blizzaroi", "Dimoret", "Magnézone", "Coudlangue", "Rhinastoc", "Bouldeneu", "Élekable", "Maganon", "Togekiss", "Yanmega", "Phyllali", "Givrali", "Scorvol", "Mammochon", "Porygon-Z", "Gallame", "Tarinorme", "Noctunoir", "Momartik", "Motisma", "Créhelf", "Créfollet", "Créfadet", "Dialga", "Palkia", "Heatran", "Regigigas", "Giratina", "Cresselia", "Phione", "Manaphy", "Darkrai", "Shaymin", "Arceus",
			"Victini", "Vipélierre", "Lianaja", "Majaspic", "Gruikui", "Grotichon", "Roitiflam", "Moustillon", "Mateloutre", "Clamiral", "Ratentif", "Miradar", "Ponchiot", "Ponchien", "Mastouffe", "Chacripan", "Léopardus", "Feuillajou", "Feuiloutan", "Flamajou", "Flamoutan", "Flotajou", "Flotoutan", "Munna", "Mushana", "Poichigeon", "Colombeau", "Déflaisan", "Zébibron", "Zéblitz", "Nodulithe", "Géolithe", "Gigalithe", "Chovsourir", "Rhinolove", "Rototaupe", "Minotaupe", "Nanméouïe", "Charpenti", "Ouvrifier", "Bétochef", "Tritonde", "Batracné", "Crapustule", "Judokrak", "Karaclée", "Larveyette", "Couverdure", "Manternel", "Venipatte", "Scobolide", "Brutapode", "Doudouvet", "Farfaduvet", "Chlorobule", "Fragilady", "Bargantua", "Mascaïman", "Escroco", "Crocorible", "Darumarond", "Darumacho", "Maracachi", "Crabicoque", "Crabaraque", "Baggiguane", "Baggaïd", "Cryptéro", "Tutafeh", "Tutankafer", "Carapagos", "Mégapagos", "Arkéapti", "Aéroptéryx", "Miamiasme", "Miasmax", "Zorua", "Zoroark", "Chinchidou", "Pashmilla", "Scrutella", "Mesmérella", "Sidérella", "Nucléos", "Méios", "Symbios", "Couaneton", "Lakmécygne", "Sorbébé", "Sorboul", "Sorbouboul", "Vivaldaim", "Haydaim", "Emolga", "Carabing", "Lançargot", "Trompignon", "Gaulet", "Viskuse", "Moyade", "Mamanbo", "Statitik", "Mygavolt", "Grindur", "Noacier", "Tic", "Clic", "Cliticlic", "Anchwatt", "Lampéroie", "Ohmassacre", "Lewsor", "Neitram", "Funécire", "Mélancolux", "Lugulabre", "Coupenotte", "Incisache", "Tranchodon", "Polarhume", "Polagriffe", "Hexagel", "Escargaume", "Limaspeed", "Limonde", "Kungfouine", "Shaofouine", "Drakkarmin", "Gringolem", "Golemastoc", "Scalpion", "Scalproie", "Frison", "Furaiglon", "Gueriaigle", "Vostourno", "Vaututrice", "Aflamanoir", "Fermite", "Solochi", "Diamat", "Trioxhydre", "Pyronille", "Pyrax", "Cobaltium", "Terrakium", "Viridium", "Boréas", "Fulguris", "Reshiram", "Zekrom", "Démétéros", "Kyurem", "Keldeo", "Meloetta", "Genesect",
			"Marisson","Boguérisse","Blindépique","Feunnec","Roussil","Goupelin","Grenousse","Croâporal","Amphinobi","Sapereau","Excavarenne","Passerouge","Braisillon","Flambusard","Lépidonille","Pérégrain","Prismillon","Hélionceau","Némélios","Flabébé","Floette","Florges","Cabriolaine","Chevroum","Pandespiègle","Pandarbare","Couafarel","Psystigri","Mistigrix","Monorpale","Dimoclès","Exagide","Fluvetin","Cocotine","Sucroquin","Cupcanaille","Sepiatop","Sepiatroce","Opermine","Golgopathe","Venalgue","Kravarech","Flingouste","Gamblast","Galvaran","Iguolta","Ptyranidur","Rexillius","Amagara","Dragmara","Nymphali","Brutalibré","Dedenne","Strassie","Mucuscule","Colimucus","Muplodocus","Trousselin","Brocélôme","Desséliande","Pitrouille","Banshitrouye","Grelaçon","Séracrawl","Sonistrelle","Bruyverne","Xerneas","Yveltal","Zygarde", "Diancie", "Hoopa", "Volcanion",
			"Brindibou","Efflèche","Archéduc","Flamiaou","Matoufeu","Félinferno","Otaquin","Otarlette","Oratoria","Picassaut","Piclairon","Bazoucan","Manglouton","Argouste","Larvibule","Chrysapile","Lucanon","Crabagarre","Crabominable","Plumeline","Bombydou","Rubombelle","Rocabot","Lougaroc","Froussardine","Vorastérie","Prédastérie","Tiboudet","Bourrinos","Araqua","Tarenbulle","Mimantis","Floramantis","Spododo","Lampignon","Tritox","Malamandre","Nounourson","Chelours","Croquine","Candine","Sucreine","Guérilande","Gouroutan","Quartermac","Sovkipou","Sarmuraï","Bacabouh","Trépassable","Concombaffe","Type:0","Silvallié","Météno","Dodoala","Boumata","Togedemaru","Mimiqui","Denticrisse","Draïeul","Sinistrail","Bébécaille","Écaïd","Ékaïser","Tokorico","Tokopiyon","Tokotoro","Tokopisco","Cosmog","Cosmovum","Solgaleo","Lunala","Zéroïd","Mouscoto","Cancrelove","Câblifère","Bamboiselle","Katagami","Engloutyran","Necrozma","Magearna","Marshadow","Vémini","Mandrillon","Ama-Ama","Pierroteknik","Zeraora","Meltan","Melmetal",
			"Ouistempo","Badabouin","Gorythmic","Flambino","Lapyro","Pyrobut","Larméléon","Arrozard","Lézargus","Rongourmand","Rongrigou","Minisange","Bleuseille","Corvaillus","Larvadar","Coléodôme","Astronelle","Goupilou","Roublenard","Tournicoton","Blancoton","Moumouton","Moumouflon","Khélocrok","Torgamord","Voltoutou","Fulgudog","Charbi","Wagomine","Monthracite","Verpom","Pomdrapi","Dratatin","Dunaja","Dunaconda","Nigosier","Embrochet","Hastacuda","Toxizap","Salarsen","Grillepattes","Scolocendre","Poulpaf","Krakos","Théffroi","Polthégeist","Bibichut","Chapotus","Sorcilence","Grimalin","Fourbelin","Angoliath","Ixon","Berserkatt","Corayôme","Palarticho","M. Glaquette","Tutétékri","Crèmy","Charmilly","Hexadron","Wattapik","Frissonille","Beldeneige","Dolman","Bekaglaçon","Wimessir","Morpeko","Charibari","Pachyradjah","Galvagon","Galvagla","Hydragon","Hydragla","Duralugon","Fantyrm","Dispareptil","Lanssorien","Zacian","Zamazenta","Éthernatos","Wushours","Shifours","Zarude","Regieleki","Regidrago","Blizzeval","Spectreval","Sylveroy","Cerbyllin","Hachécateur","Ursaking","Paragruel","Farfurex","Qwilpik","Amovénus"
	};
	public static String [] pokemon_en = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro", "Magnemite", "Magneton", "Farfetch'd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew", 
		"Chikorita", "Bayleef", "Meganium", "Cyndaquil", "Quilava", "Typhlosion", "Totodile", "Croconaw", "Feraligatr", "Sentret", "Furret", "Hoothoot", "Noctowl", "Ledyba", "Ledian", "Spinarak", "Ariados", "Crobat", "Chinchou", "Lanturn", "Pichu", "Cleffa", "Igglybuff", "Togepi", "Togetic", "Natu", "Xatu", "Mareep", "Flaaffy", "Ampharos", "Bellossom", "Marill", "Azumarill", "Sudowoodo", "Politoed", "Hoppip", "Skiploom", "Jumpluff", "Aipom", "Sunkern", "Sunflora", "Yanma", "Wooper", "Quagsire", "Espeon", "Umbreon", "Murkrow", "Slowking", "Misdreavus", "Unown", "Wobbuffet", "Girafarig", "Pineco", "Forretress", "Dunsparce", "Gligar", "Steelix", "Snubbull", "Granbull", "Qwilfish", "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa", "Ursaring", "Slugma", "Magcargo", "Swinub", "Piloswine", "Corsola", "Remoraid", "Octillery", "Delibird", "Mantine", "Skarmory", "Houndour", "Houndoom", "Kingdra", "Phanpy", "Donphan", "Porygon2", "Stantler", "Smeargle", "Tyrogue", "Hitmontop", "Smoochum", "Elekid", "Magby", "Miltank", "Blissey", "Raikou", "Entei", "Suicune", "Larvitar", "Pupitar", "Tyranitar", "Lugia", "Ho-Oh", "Celebi",
		"Treecko", "Grovyle", "Sceptile", "Torchic", "Combusken", "Blaziken", "Mudkip", "Marshtomp", "Swampert", "Poochyena", "Mightyena", "Zigzagoon", "Linoone", "Wurmple", "Silcoon", "Beautifly", "Cascoon", "Dustox", "Lotad", "Lombre", "Ludicolo", "Seedot", "Nuzleaf", "Shiftry", "Taillow", "Swellow", "Wingull", "Pelipper", "Ralts", "Kirlia", "Gardevoir", "Surskit", "Masquerain", "Shroomish", "Breloom", "Slakoth", "Vigoroth", "Slaking", "Nincada", "Ninjask", "Shedinja", "Whismur", "Loudred", "Exploud", "Makuhita", "Hariyama", "Azurill", "Nosepass", "Skitty", "Delcatty", "Sableye", "Mawile", "Aron", "Lairon", "Aggron", "Meditite", "Medicham", "Electrike", "Manectric", "Plusle", "Minun", "Volbeat", "Illumise", "Roselia", "Gulpin", "Swalot", "Carvanha", "Sharpedo", "Wailmer", "Wailord", "Numel", "Camerupt", "Torkoal", "Spoink", "Grumpig", "Spinda", "Trapinch", "Vibrava", "Flygon", "Cacnea", "Cacturne", "Swablu", "Altaria", "Zangoose", "Seviper", "Lunatone", "Solrock", "Barboach", "Whiscash", "Corphish", "Crawdaunt", "Baltoy", "Claydol", "Lileep", "Cradily", "Anorith", "Armaldo", "Feebas", "Milotic", "Castform", "Kecleon", "Shuppet", "Banette", "Duskull", "Dusclops", "Tropius", "Chimecho", "Absol", "Wynaut", "Snorunt", "Glalie", "Spheal", "Sealeo", "Walrein", "Clamperl", "Huntail", "Gorebyss", "Relicanth", "Luvdisc", "Bagon", "Shelgon", "Salamence", "Beldum", "Metang", "Metagross", "Regirock", "Regice", "Registeel", "Latias", "Latios", "Kyogre", "Groudon", "Rayquaza", "Jirachi", "Deoxys",
		"Turtwig", "Grotle", "Torterra", "Chimchar", "Monferno", "Infernape", "Piplup", "Prinplup", "Empoleon", "Starly", "Staravia", "Staraptor", "Bidoof", "Bibarel", "Kricketot", "Kricketune", "Shinx", "Luxio", "Luxray", "Budew", "Roserade", "Cranidos", "Rampardos", "Shieldon", "Bastiodon", "Burmy", "Wormadam", "Mothim", "Combee", "Vespiquen", "Pachirisu", "Buizel", "Floatzel", "Cherubi", "Cherrim", "Shellos", "Gastrodon", "Ambipom", "Drifloon", "Drifblim", "Buneary", "Lopunny", "Mismagius", "Honchkrow", "Glameow", "Purugly", "Chingling", "Stunky", "Skuntank", "Bronzor", "Bronzong", "Bonsly", "Mime Jr.", "Happiny", "Chatot", "Spiritomb", "Gible", "Gabite", "Garchomp", "Munchlax", "Riolu", "Lucario", "Hippopotas", "Hippowdon", "Skorupi", "Drapion", "Croagunk", "Toxicroak", "Carnivine", "Finneon", "Lumineon", "Mantyke", "Snover", "Abomasnow", "Weavile", "Magnezone", "Lickilicky", "Rhyperior", "Tangrowth", "Electivire", "Magmortar", "Togekiss", "Yanmega", "Leafeon", "Glaceon", "Gliscor", "Mamoswine", "Porygon-Z", "Gallade", "Probopass", "Dusknoir", "Froslass", "Rotom", "Uxie", "Mesprit", "Azelf", "Dialga", "Palkia", "Heatran", "Regigigas", "Giratina", "Cresselia", "Phione", "Manaphy", "Darkrai", "Shaymin", "Arceus",
		"Victini", "Snivy", "Servine", "Serperior", "Tepig", "Pignite", "Emboar", "Oshawott", "Dewott", "Samurott", "Patrat", "Watchog", "Lillipup", "Herdier", "Stoutland", "Purrloin", "Liepard", "Pansage", "Simisage", "Pansear", "Simisear", "Panpour", "Simipour", "Munna", "Musharna", "Pidove", "Tranquill", "Unfezant", "Blitzle", "Zebstrika", "Roggenrola", "Boldore", "Gigalith", "Woobat", "Swoobat", "Drilbur", "Excadrill", "Audino", "Timburr", "Gurdurr", "Conkeldurr", "Tympole", "Palpitoad", "Seismitoad", "Throh", "Sawk", "Sewaddle", "Swadloon", "Leavanny", "Venipede", "Whirlipede", "Scolipede", "Cottonee", "Whimsicott", "Petilil", "Lilligant", "Basculin", "Sandile", "Krokorok", "Krookodile", "Darumaka", "Darmanitan", "Maractus", "Dwebble", "Crustle", "Scraggy", "Scrafty", "Sigilyph", "Yamask", "Cofagrigus", "Tirtouga", "Carracosta", "Archen", "Archeops", "Trubbish", "Garbodor", "Zorua", "Zoroark", "Minccino", "Cinccino", "Gothita", "Gothorita", "Gothitelle", "Solosis", "Duosion", "Reuniclus", "Ducklett", "Swanna", "Vanillite", "Vanillish", "Vanilluxe", "Deerling", "Sawsbuck", "Emolga", "Karrablast", "Escavalier", "Foongus", "Amoonguss", "Frillish", "Jellicent", "Alomomola", "Joltik", "Galvantula", "Ferroseed", "Ferrothorn", "Klink", "Klang", "Klinklang", "Tynamo", "Eelektrik", "Eelektross", "Elgyem", "Beheeyem", "Litwick", "Lampent", "Chandelure", "Axew", "Fraxure", "Haxorus", "Cubchoo", "Beartic", "Cryogonal", "Shelmet", "Accelgor", "Stunfisk", "Mienfoo", "Mienshao", "Druddigon", "Golett", "Golurk", "Pawniard", "Bisharp", "Bouffalant", "Rufflet", "Braviary", "Vullaby", "Mandibuzz", "Heatmor", "Durant", "Deino", "Zweilous", "Hydreigon", "Larvesta", "Volcarona", "Cobalion", "Terrakion", "Virizion", "Tornadus", "Thundurus", "Reshiram", "Zekrom", "Landorus", "Kyurem", "Keldeo", "Meloetta", "Genesect",
		"Chespin", "Quilladin", "Chesnaught", "Fennekin", "Braixen", "Delphox", "Froakie", "Frogadier", "Greninja", "Bunnelby", "Diggersby", "Fletchling", "Fletchinder", "Talonflame", "Scatterbug", "Spewpa", "Vivillon", "Litleo", "Pyroar", "Flabébé", "Floette", "Florges", "Skiddo", "Gogoat", "Pancham", "Pangoro", "Furfrou", "Espurr", "Meowstic", "Honedge", "Doublade", "Aegislash", "Spritzee", "Aromatisse", "Swirlix", "Slurpuff", "Inkay", "Malamar", "Binacle", "Barbaracle", "Skrelp", "Dragalge", "Clauncher", "Clawitzer", "Helioptile", "Heliolisk", "Tyrunt", "Tyrantrum", "Amaura", "Aurorus", "Sylveon", "Hawlucha", "Dedenne", "Carbink", "Goomy", "Sliggoo", "Goodra", "Klefki", "Phantump", "Trevenant", "Pumpkaboo", "Gourgeist", "Bergmite", "Avalugg", "Noibat", "Noivern", "Xerneas", "Yveltal", "Zygarde", "Diancie", "Hoopa", "Volcanion","Rowlet", "Dartrix", "Decidueye", "Litten", "Torracat", "Incineroar", "Popplio", "Brionne", "Primarina", "Pikipek", "Trumbeak", "Toucannon", "Yungoos", "Gumshoos", "Grubbin", "Charjabug", "Vikavolt", "Crabrawler", "Crabominable", "Oricorio", "Cutiefly", "Ribombee", "Rockruff", "Lycanroc", "Wishiwashi", "Mareanie", "Toxapex", "Mudbray", "Mudsdale", "Dewpider", "Araquanid", "Fomantis", "Lurantis", "Morelull", "Shiinotic", "Salandit", "Salazzle", "Stufful", "Bewear", "Bounsweet", "Steenee", "Tsareena", "Comfey", "Oranguru", "Passimian", "Wimpod", "Golisopod", "Sandygast", "Palossand", "Pyukumuku", "Type: Null", "Silvally", "Minior", "Komala", "Turtonator", "Togedemaru", "Mimikyu", "Bruxish", "Drampa", "Dhelmise", "Jangmo-o", "Hakamo-o", "Kommo-o", "Tapu Koko", "Tapu Lele", "Tapu Bulu", "Tapu Fini", "Cosmog", "Cosmoem", "Solgaleo", "Lunala", "Nihilego", "Buzzwole", "Pheromosa", "Xurkitree", "Celesteela", "Kartana", "Guzzlord", "Necrozma", "Magearna", "Marshadow", "Poipole", "Naganadel", "Stakataka", "Blacephalon", "Zeraora", "Meltan", "Melmetal",
		"Grookey", "Thwackey", "Rillaboom", "Scorbunny", "Raboot", "Cinderace", "Sobble", "Drizzile", "Inteleon", "Skwovet", "Greedent", "Rookidee", "Corvisquire", "Corviknight", "Blipbug", "Dottler", "Orbeetle", "Nickit", "Thievul", "Gossifleur", "Eldegoss", "Wooloo", "Dubwool", "Chewtle", "Drednaw", "Yamper", "Boltund", "Rolycoly", "Carkol", "Coalossal", "Applin", "Flapple", "Appletun", "Silicobra", "Sandaconda", "Cramorant", "Arrokuda", "Barraskewda", "Toxel", "Toxtricity", "Sizzlipede", "Centiskorch", "Clobbopus", "Grapploct", "Sinistea", "Polteageist", "Hatenna", "Hattrem", "Hatterene", "Impidimp", "Morgrem", "Grimmsnarl", "Obstagoon", "Perrserker", "Cursola", "Sirfetch'd", "Mr. Rime", "Runerigus", "Milcery", "Alcremie", "Falinks", "Pincurchin", "Snom", "Frosmoth", "Stonjourner", "Eiscue", "Indeedee", "Morpeko", "Cufant", "Copperajah", "Dracozolt", "Arctozolt", "Dracovish", "Arctovish", "Duraludon", "Dreepy", "Drakloak", "Dragapult", "Zacian", "Zamazenta", "Eternatus", "Kubfu", "Urshifu", "Zarude", "Regieleki", "Regidrago", "Glastrier", "Spectrier", "Calyrex", "Wyrdeer", "Kleavor", "Ursaluna", "Basculegion", "Sneasler", "Overqwil", "Enamorus"
	};
	
	public static String[] pokemon_old_in_g8 = {"Chenipan", "Chrysacier", "Papilusion", "Larvibule", "Chrysapile", "Lucanon", "Hoothoot", "Noarfang", "Poichigeon", "Colombeau", "Déflaisan", "Nénupiot", "Lombre", "Ludicolo", "Grainipiot", "Pifeuil", "Tengalice", "Chacripan", "Léopardus", "Sapereau", "Excavarenne", "Chinchidou ", "Pashmilla", "Croquine", "Candine", "Sucreine", "Mystherbe", "Ortide", "Rafflesia", "Joliflor", "Rozbouton", "Rosélia", "Roserade", "Goélise", "Bekipan", "Statitik", "Mygavolt", "Dynavolt", "Élecsprint", "Goupix", "Feunard", "Caninos", "Arcanin", "Sorbébé", "Sorboul", "Sorbouboul", "Marcacrin", "Cochignon", "Mammochon", "Cadoizo", "Stalgamin", "Oniglali", "Momartik", "Balbuto", "Kaorine", "Tiboudet", "Bourrinos", "Crabicoque", "Crabaraque", "Gringolem", "Golemastoc", "Munna", "Mushana", "Natu", "Xatu", "Nounourson", "Chelours", "Blizzi", "Blizzaroi", "Krabby", "Krabboss", "Axoloto ", "Maraiste", "Écrapince", "Colhomard", "Ningale", "Ninjask", "Munja", "Debugant", "Kicklee", "Tygnon", "Kapoera", "Pandespiègle", "Pandarbare", "Tic", "Clic", "Cliticlic", "Apitrini", "Apireine", "Archéomire", "Archéodong", "Tarsal", "Kirlia", "Gardevoir", "Gallame", "Baudrive", "Grodrive", "Ceribou", "Ceriflor", "Moufouette", "Moufflair", "Tritonde", "Batracné", "Crapustule", "Skelénox", "Téraclope", "Noctunoir", "Machoc", "Machopeur", "Mackogneur", "Fantominus", "Spectrum", "Ectoplasma", "Magicarpe", "Léviator", "Poissirène", "Poissoroy", "Rémoraid", "Octillery", "Kokiyas ", "Crustabri", "Barpau", "Milobellus", "Bargantua", "Froussardine", "Concombaffe", "Miamiasme", "Miasmax", "Taupiqueur", "Triopikeur", "Rototaupe", "Minotaupe", "Nodulithe", "Géolithe", "Gigalithe", "Charpenti", "Ouvrifier", "Bétochef", "Chovsourir", "Rhinolove", "Sonistrelle", "Bruyverne", "Onix", "Steelix", "Miaouss", "Persian", "Bombydou", "Rubombelle", "Grindur", "Noacier", "Pitrouille", "Banshitrouye", "Pichu", "Pikachu", "Raichu", "Évoli", "Aquali", "Voltali", "Pyroli", "Mentali ", "Noctali", "Phyllali", "Givrali", "Nymphali", "Psystigri", "Mistigrix", "Sucroquin", "Cupcanaille", "Fluvetin", "Cocotine", "Araqua", "Tarenbulle", "Okéoké", "Qulbutoké", "Loupio", "Lanturn", "Cradopaud", "Coatox", "Baggiguane", "Baggaïd", "Caratroc", "Barloche", "Barbicha", "Sancoki", "Tritosor", "Sovkipou", "Sarmuraï", "Opermine", "Golgopathe", "Tritox", "Malamandre", "Scalpion", "Scalproie", "Judokrak", "Karaclée", "Smogo ", "Manzaï", "Simularbre", "Mélo", "Mélofée", "Mélodelfe", "Togepi", "Togetic", "Togekiss", "Goinfrex", "Ronflex", "Doudouvet", "Farfaduvet", "Rhinocorne", "Rhinoféros", "Rhinastoc", "Scrutella", "Mesmérella", "Sidérella", "Nucléos", "Méios", "Symbios", "Carabing", "Lançargot", "Escargaume", "Limaspeed", "Lewsor", "Neitram", "Polarhume", "Polagriffe", "Furaiglon", "Gueriaigle", "Vostourno", "Vaututrice", "Rapion", "Drascore", "Funécire", "Mélancolux", "Lugulabre", "Sepiatop", "Sepiatroce", "Farfuret", "Dimoret", "Ténéfix", "Mysdibule", "Maracachi", "Cryptéro", "Riolu", "Lucario", "Chartor ", "Mimiqui", "Qwilfish", "Viskuse", "Moyade", "Vorastérie", "Prédastérie", "Hippopotas", "Hippodocus", "Fermite", "Aflamanoir", "Galvaran", "Iguolta", "Brutalibré", "Kraknoix", "Vibraninf", "Libégon", "Coupenotte", "Incisache", "Tranchodon", "Tutafeh", "Tutankafer", "Monorpale", "Dimoclès", "Exagide", "Brocélôme", "Desséliande", "Spododo", "Lampignon", "Gouroutan", "Quartermac", "Draïeul", "Boumata", "Togedemaru", "Babimanta", "Démanta", "Wailmer", "Wailord", "Grelaçon", "Séracrawl", "Sinistrail", "Lokhlass", "Séléroc", "Solaroc", "Mime Jr.", "M. Mime", "Motisma", "Métamorph", "Salamèche", "Reptincel", "Dracaufeu", "Type:0", "Silvallié", "Embrylex", "Ymphect", "Tyranocif", "Solochi", "Diamat", "Trioxhydre", "Mucuscule", "Colimucus", "Muplodocus", "Bébécaille", "Écaïd", "Ékaïser"};
	
	public static String[] talents = {"Absentéisme","Absorb Eau","Absorb Volt","Acharné","Adaptabilité","Agitation","Ailes Bourrasque","Air Lock","Alerte Neige","Amour Filial","Analyste","Annule Garde","Anti-Bruit","Anticipation","Armumagma","Armurbaston","Armurouillée","Aroma-Voile","Attention","Aura Féérique","Aura Inversée","Aura Ténébreuse","Baigne Sable","Bajoues","Battant","Benêt","Boom Final","Brasier","Brise Moule","Cacophonie","Calque","Chanceux","Cherche Miel","Chlorophylle","Ciel Gris","Coloforce","Colérique","Contestation","Coque Armure","Corps Ardent","Corps Gel","Corps Maudit","Corps Sain","Crachin","Cran","Cuvette","Cœur de Coq","Cœur Noble","Cœur Soin","Don Floral","Début Calme","Déclic Tactique","Défaitiste","Déguisement","Délestage","Écaille Spéciale","Échauffement","Écran Fumée","Écran Poudre","Engrais","Envelocape","Épine de Fer","Esprit Vital","Essaim (talent)","Farceur","Fermeté","Feuille Garde","Filtre","Flora-Voile","Force Pure","Force Sable","Force Soleil","Fouille","Frein","Fuite (talent)","Garde Amie","Garde Magik","Garde Mystik","Glissade","Gloutonnerie","Gluco-Voile","Glue","Griffe Dure","Heavy Metal","Herbivore","Hydratation","Hyper Cutter","Ignifu-Voile","Ignifuge","Illusion","Impassible","Imposteur","Impudence","Inconscient","Infiltration","Insomnia","Intimidation (talent)","Isograisse","Joli Sourire","Lavabo","Lentiteintée","Light Metal","Lumiattirance","Lunatique","Lévitation","Magicien","Magnépiège","Maladresse","Marque Ombre","Matinal","Mauvais Rêve","Mer Primaire","Minus","Miroir Magik","Mode Transe","Moiteur","Momie","Motorisé","Mue","Multi-Coups","Multi-Type","Multiécaille","Médic Nature","Méga Blaster","Météo","Normalise","Œil Composé","Paratonnerre","Pare-Balles","Peau Céleste","Peau Dure","Peau Féérique","Peau Gelée","Peau Miracle","Peau Sèche","Phobique","Pickpocket","Pied Véloce","Pieds Confus","Piège (talent)","Plus","Poing de Fer","Point Poison","Poisseux","Pose Spore","Pression","Prognathe","Protéen","Prédiction","Puanteur","Querelleur","Rage Brûlure","Rage Poison","Ramassage","Regard Vif","Rideau Neige","Rivalité","Récolte","Régé-Force","Sable Volant","Sans Limite","Simple","Sniper","Soin Poison","Solide Roc","Souffle Delta","Statik","Suintement","Symbiose","Synchro","Sécheresse","Sérénité","Technicien","Tempo Perso","Tension","Terre Finale","Toison Herbue","Toison Épaisse","Torche","Torrent","Toxitouche","Turbo","TurboBrasier","Télécharge","Télépathe","Téméraire","Téra-Voltage","Tête de Roc","Vaccin","Ventouse","Victorieux","Voile Sable"};

	/**
	 * Renvoie le nom du Pokémon portant le numéro fourni
	 * @param num le numéro d'un Pokémon dans le Dex nationnal
	 * @return le nom du Pokémon, chaine vide si le numéro fourni n'a aucune correspondance
	 */
	public static String getPokemonName(int num) {
		if ( num > 0 && num <=pokemon.length ) {
			return pokemon[num-1];
		} else {
			return "";
		}
	}
	
	public static int getPokemonNum(String name) {
		int num = 1;
		while ( num > 0 && num <=pokemon.length ) {
			if (pokemon[num-1].equals(name)) {
				return num;
			}
			num += 1;
		}
		return -1;
	}
	
	/**
	 * Renvoie le numéro de la génération auquel un Pokémon appartient
	 * @param num le numéro du Pokémon dans le Dex national
	 * @return le numéro de la génération concernée, 0 si aucune correspondance n'existe
	 */
	public static int getPokemonGen(int num) {
		if(num>=1 && num<=151) return 1;
		if(num>=152 && num<=251) return 2;
		if(num>=252 && num<=386) return 3;
		if(num>=387 && num<=493) return 4;
		if(num>=494 && num<=649) return 5;
		if(num>=650 && num<=721) return 6;
		return 0;
	}
	
	/**
	 * Formate un numéro sur trois caractères
	 * @param num
	 * @return
	 */
	public static String formatNum(int num) {
		if(num<10) return "00"+num;
		if(num<100) return "0"+num;
		return ""+num;
	}
	
	public static boolean isShinyLock(int num) {
		return num==494 //Victini
				|| num==720 //Hoopa
				|| num==721 //Volcanion
				|| num==789 //Cosmog
				|| num==790 //Cosmovum
				|| num==802 //Marshadow
				|| num==807 //Zeraora
				|| num==888 //Zacian
				|| num==889 //Zamazenta
				|| num==890 //Éthernatos
			;
	}
	
	/**
	 * Renvoie la puissance d'une capacité Z à partir de la puissance de sa capacité d'origine
	 * @param p la puissance de la capacité d'origine
	 * @return la puissance de la capacité Z associée, 0 en cas d'anomalie.
	 */
	public static int getZPower(int p) {
		int pz = 0;
		if(0<=p && p<=55) pz = 100;
		else if(60<=p && p<=65) pz = 120;
		else if(70<=p && p<=75) pz = 140;
		else if(80<=p && p<=85) pz = 160;
		else if(90<=p && p<=95) pz = 175;
		else if(p==100) pz = 180;
		else if(p==110) pz = 185;
		else if(120<=p && p<=125) pz = 190;
		else if(p==130) pz = 195;
		else if(140<=p) pz = 200; 
		return pz;
	}
	
	/**
	 * Renvoie le nom de la capacité Z associée à un type
	 * @param type le type élémentaire
	 * @return le nom de la capa
	 */
	public static String getZByType(String type) {
		if(type.equalsIgnoreCase("acier")) return "Vrille Maximum";
		if(type.equalsIgnoreCase("dragon")) return "Chaos Draconique";
		if(type.equalsIgnoreCase("électrik")) return "Fulguro-Lance Gigavolt";
		if(type.equalsIgnoreCase("feu")) return "Pyro-Explosion Cataclysmique";
		if(type.equalsIgnoreCase("insecte")) return "Cocon Fatal";
		if(type.equalsIgnoreCase("plante")) return "Pétalexplosion Éblouissante";
		if(type.equalsIgnoreCase("psy")) return "Psycho-Pulvérisation EX";
		if(type.equalsIgnoreCase("sol")) return "Éruption Géo-Sismique";
		if(type.equalsIgnoreCase("ténèbres")) return "Trou Noir des Ombres";
		if(type.equalsIgnoreCase("combat")) return "Combo Hyper-Furie";
		if(type.equalsIgnoreCase("eau")) return "Super Tourbillon Abyssal";
		if(type.equalsIgnoreCase("fée")) return "Impact Choupinova";
		if(type.equalsIgnoreCase("glace")) return "Laser Cryogénique";
		if(type.equalsIgnoreCase("normal")) return "Turbo-Charge Bulldozer";
		if(type.equalsIgnoreCase("poison")) return "Déluge Causti-Toxique";
		if(type.equalsIgnoreCase("roche")) return "Apocalypse Gigalithique";
		if(type.equalsIgnoreCase("spectre")) return "Appel des Ombres Éternelles";
		if(type.equalsIgnoreCase("vol")) return "Piqué Supersonique";
		return null;
	}
	
	/**
	 * Renvoie le nom du cristal Z associée à un type
	 * @param type le type élémentaire
	 * @return le nom de la capa
	 */
	public static String getCristalByType(String type) {
		if(type.equalsIgnoreCase("acier")) return "Métallozélite";
		if(type.equalsIgnoreCase("dragon")) return "Dracozélite";
		if(type.equalsIgnoreCase("électrik")) return "Voltazélite";
		if(type.equalsIgnoreCase("feu")) return "Pyrozélite";
		if(type.equalsIgnoreCase("insecte")) return "Insectozélite";
		if(type.equalsIgnoreCase("plante")) return "Florazélite";
		if(type.equalsIgnoreCase("psy")) return "Psychézélite";
		if(type.equalsIgnoreCase("sol")) return "Terrazélite";
		if(type.equalsIgnoreCase("ténèbres")) return "Ténébrozélite";
		if(type.equalsIgnoreCase("combat")) return "Combazélite";
		if(type.equalsIgnoreCase("eau")) return "Aquazélite";
		if(type.equalsIgnoreCase("fée")) return "Nymphézélite";
		if(type.equalsIgnoreCase("glace")) return "Cryozélite";
		if(type.equalsIgnoreCase("normal")) return "Normazélite";
		if(type.equalsIgnoreCase("poison")) return "Toxizélite";
		if(type.equalsIgnoreCase("roche")) return "Rocazélite";
		if(type.equalsIgnoreCase("spectre")) return "Spectrozélite";
		if(type.equalsIgnoreCase("vol")) return "Aérozélite";
		return null;
	}
	
	/**
	 * Renvoie l'effet de la capacité Z liée à la capacité de statut fournie
	 * @param move le nom d'une capacité de statut
	 * @return l'effet supplémentaire de la capacité Z
	 */
	public static String getZStatusEffect(String move) {
		if(move.equalsIgnoreCase("À la Queue")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Abri")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Acidarmure")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Acupression")) return "augmente le taux de critiques du lanceur";
		if(move.equalsIgnoreCase("Affilage")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Affûtage")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Aiguisage")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Air Veinard")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Allègement")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Amass'Sable")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Amnésie")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Anneau Hydro")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Anti-Brume")) return "augmente la Précision du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Anti-Soin")) return "augmente l'Attaque Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Appel Défense")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Appel Soins")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Après Vous")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Armure")) return "augmente la Défense du lanceur d'un niveau supplémentaire";
		if(move.equalsIgnoreCase("Aromathérapie")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Assistance")) return "choisit au hasard une capacité connue par un équipier et la transforme en capacité Z";
		if(move.equalsIgnoreCase("Astuce Force")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Atterrissage")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Attraction")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Aurore")) return "annule toutes les baisses de statistique du lanceur";
		if(move.equalsIgnoreCase("Avale")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Bâillement")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Balance")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Barrage")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Blabla Dodo")) return "augmente le taux de critiques du lanceur, choisit au hasard une capacité parmi celles connues par le lanceur et la transforme en capacité Z si c'est une capacité offensive";
		if(move.equalsIgnoreCase("Blockhaus")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Boost")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Bouclier")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Bouclier Royal")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Boul'Armure")) return "augmente la Précision du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Brouillard")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Brume")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Brume Capiteuse")) return "augmente la Défense Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Buée Noire")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Cage-Éclair")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Camaraderie")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Camouflage")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Cauchemar")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Célébration")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Champ Brumeux")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Champ Électrifié")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Champ Herbu")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Champ Psychique")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Chgt Vitesse")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Chargeur")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Charme")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Chatouille")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Clairvoyance")) return "augmente le taux de critiques du lanceur";
		if(move.equalsIgnoreCase("Clonage")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Cognobidon")) return "rend des PV au lanceur avant d'effectuer l'attaque";
		if(move.equalsIgnoreCase("Confidence")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Conversion")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Conversion 2")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Copie")) return "augmente la Précision du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Copie Type")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Cotogarde")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Coup d'Main")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Croco Larme")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Croissance")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Cyclone")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Danse Draco")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Danse Folle")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Danse-Lames")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Danse-Lune")) return null;
		if(move.equalsIgnoreCase("Danse Pluie")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Danse-Plume")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("DélugePlasmique")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Dépit")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Dernier Mot")) return "soigne tous les PV du Pokémon qui entre en combat pour remplacer le lanceur";
		if(move.equalsIgnoreCase("Détection")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Détrempage")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Distorsion")) return "augmente la Précision du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Doux Baiser")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Doux Parfum")) return "augmente la Précision du lanceur d'un niveau";
		if(move.equalsIgnoreCase("E-Coque")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Échange")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Échange Psy")) return "augmente l'Attaque Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Électrisation")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Embargo")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Encore")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Engrenage")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Enroulement")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Entrave")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Étrennes")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Exuviation")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Fertilisation")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Feu Follet")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Fil Toxique")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Flair")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Flash")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Flatterie")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Force Cosmik")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Force-Nature")) return "choisit une capacité en fonction du terrain et la transforme en capacité Z";
		if(move.equalsIgnoreCase("Garde Florale")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Garde Large")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Gaz Toxik")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Géo-Contrôle")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Glas de Soin")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Gonflette")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Gravité")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Grêle")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Gribouille")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Grimace")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Grincement")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Grobisou")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Grondement")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Groz'Yeux")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Halloween")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Hâte")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Hurlement")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Hypnose")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Imitation")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Interversion")) return "augmente la Vitesse du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Jet de Sable")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Lait à Boire")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Lance-Boue")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Larme à l'Œil")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Lévikinésie")) return "augmente l'Attaque Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Lilliput")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Lire-Esprit")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Lumiqueue")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Machination")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Magné-Contrôle")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Mains Jointes")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Malédiction")) return "soigne tous les PV du lanceur s'il est de type Spectre, elle augmente sinon l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Maléfice Sylvain")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Métronome")) return "choisit une capacité au hasard et la transforme en capacité Z si c'est une capacité offensive";
		if(move.equalsIgnoreCase("Mimi-Queue")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Mimique")) return "augmente l'Attaque du lanceur de deux niveaux et transforme l'attaque copiée en capacité Z s'il s'agit d'une capacité offensive";
		if(move.equalsIgnoreCase("Moi d'Abord")) return "augmente la Vitesse du lanceur de deux niveaux et transforme l'attaque copiée en capacité Z";
		if(move.equalsIgnoreCase("Morphing")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Mur de Fer")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Mur Lumière")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Nuée de Poudre")) return "augmente la Défense Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Œil Miracle")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Onde Folie")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Ondes Étranges")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Papillodanse")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Par Ici")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Para-Spore")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Paresse")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Partage Force")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Partage Garde")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Passe-Cadeau")) return "augmente la Vitesse du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Passe-Passe")) return "augmente la Vitesse du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Permucœur")) return "augmente le taux de critiques du lanceur";
		if(move.equalsIgnoreCase("Permuforce")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Permugarde")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Permuvitesse")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Photocopie")) return "augmente la Précision du lanceur d'un niveau et transforme l'attaque copiée en capacité Z s'il s'agit d'une capacité offensive";
		if(move.equalsIgnoreCase("Pico-Défense")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Picots")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Pics Toxik")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Piège de Roc")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Piège de Venin")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Plénitude")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Poliroche")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Possessif")) return "augmente la Défense Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Poudre Dodo")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Poudre Fureur")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Poudre Toxik")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Prévention")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Prélèvem. Destin")) return "force les adversaires à ne cibler que le lanceur";
		if(move.equalsIgnoreCase("Projecteur")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Protection")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Provoc")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Puissance")) return "augmente la Précision du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Purification")) return "augmente l'Attaque, la Défense, l'Attaque Spéciale, la Défense Spéciale et la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Racines")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Râle Mâle")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Rancune")) return "force les adversaires à ne cibler que le lanceur";
		if(move.equalsIgnoreCase("Rayon Lune")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Rayon Simple")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Recyclage")) return "augmente la Vitesse du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Reflet")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Reflet Magik")) return "augmente la Défense Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Regard Médusant")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Regard Noir")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Regard Touchant")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Régénération")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Relais")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Rengorgement")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Renversement")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Repli")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Repos")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Requiem")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Rugissement")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Rune Protect")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Saisie")) return "augmente la Vitesse du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Sécrétion")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Séduction")) return "augmente la Défense Spéciale du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Siffl'Herbe")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Soin")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Soin Floral")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Sommation")) return "augmente l'Attaque Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Soucigraine")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Souvenir")) return "soigne tous les PV du Pokémon qui entre en combat pour remplacer le lanceur";
		if(move.equalsIgnoreCase("Spore")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Spore Coton")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Stockage")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Strido-Son")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Suc Digestif")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Synthèse")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Tatamigaeshi")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Télékinésie")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Téléport")) return "soigne tous les PV du lanceur";
		if(move.equalsIgnoreCase("Tempête de Sable")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Ten-danse")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Ténacité")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Toile")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Toile Gluante")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Tourmagik")) return "augmente la Vitesse du lanceur de deux niveaux";
		if(move.equalsIgnoreCase("Tourmente")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Tourniquet")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Toxik")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Trempette")) return "augmente l'Attaque du lanceur de trois niveaux";
		if(move.equalsIgnoreCase("Trou Noir")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Ultrason")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Vampigraine")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Vantardise")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Vent Arrière")) return "augmente le taux de critiques du lanceur";
		if(move.equalsIgnoreCase("Verrou Enchanté")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Verrouillage")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Vibra Soin")) return "annule toutes les baisses de statistiques du lanceur";
		if(move.equalsIgnoreCase("Vigilance")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Vœu")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Vœu Soin")) return null;
		if(move.equalsIgnoreCase("Voile Aurore")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Vol Magnétik")) return "augmente l'Esquive du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Vol-Force")) return "augmente la Défense du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Yoga")) return "augmente l'Attaque du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Zénith")) return "augmente la Vitesse du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Zone Étrange")) return "augmente la Défense Spéciale du lanceur d'un niveau";
		if(move.equalsIgnoreCase("Zone Magique")) return "augmente la Défense Spéciale du lanceur d'un niveau ";
		return null;
	}
	
	public static String[][] getMiniatCodes() {
		return new String[][] {
			{"001 C", "001", "Clin d'œil"},
			{"003M", "003", "Méga"},
			{"004 C", "004", "Clin d'œil"},
			{"006MX", "006", "Méga X"},
			{"006MY", "006", "Méga Y"},
			{"007 C", "007", "Clin d'œil"},
			{"007l", "007", "Lunettes de Soleil"},
			{"008l", "008", "Lunettes de Soleil"},
			{"009l", "009", "Lunettes de Soleil"},
			{"009M", "009", "Méga"},
			{"015M", "015", "Méga"},
			{"018M", "018", "Méga"},
			{"019a", "019", "Alola"},
			{"020a", "020", "Alola"},
			{"020ad", "020", "Alola Dominant"},
			{"025A", "025", "Amoureux"},
			{"025a", "025", "Anniversaire"},
			{"025Alola", "025", "Casquette d'Alola"},
			{"025C", "025", "Clin d'œil"},
			{"025c", "025", "Catcheur"},
			{"025C 2", "025", "Content"},
			{"025C 3", "025", "Déguisé"},
			{"025C 4", "025", "Confus"},
			{"025CAO", "025", "Casquette Originale"},
			{"025CAH", "025", "Casquette de Hoenn"},
			{"025CAS", "025", "Casquette de Sinnoh"},
			{"025CAU", "025", "Casquette d'Unys"},
			{"025CAK", "025", "Casquette de Kalos"},
			{"025CAA", "025", "Casquette d'Alola"},
			{"025CD", "025", "Dracaufeu"},
			{"025CH", "025", "Ho-Oh"},
			{"025CL", "025", "Lugia"},
			{"025CLE", "025", "Léviator"},
			{"025CLEC", "025", "Léviator chromatique"},
			{"025CM", "025", "Magicarpe"},
			{"025CR", "025", "Rayquaza"},
			{"025CRC", "025", "Rayquaza chromatique"},
			{"025co", "025", "Cosplayer"},
			{"025d", "025", "Docteur"},
			{"025E", "025", "Agacé"},
			{"025E 2", "025", "Assoupi"},
			{"025EC", "025", "Chef pâtissier"},
			{"025ECE", "025", "Danse du lion"},
			{"025ED", "025", "Fin d'année"},
			{"025EDI", "025", "Diplômé"},
			{"025EFE", "025", "Festival d'été"},
			{"025EJE", "025", "Jour des enfants"},
			{"025EK", "025", "Kotatsu"},
			{"025EM", "025", "Promenade à la plage"},
			{"025EP", "025", "Artiste"},
			{"025ESP", "025", "Saison des pluies"},
			{"025EU", "025", "Uniforme"},
			{"025EV", "025", "Cueillette de champignons"},
			{"025F", "025", "Fêtes"},
			{"025f", "025", "Casquette HF"},
			{"025H", "025", "Heureux"},
			{"025h", "025", "Halloween"},
			{"025Hoenn", "025", "Casquette de Hoenn"},
			{"025I", "025", "Impérial"},
			{"025K", "025", "Kimono"},
			{"025k", "025", "Casquette Originale"},
			{"025Kalos", "025", "Casquette de Kalos"},
			{"025Kanto", "025", "Casquette Originale"},
			{"025l", "025", "Style Estival"},
			{"025l", "025", "Lady"},
			{"025M", "025", "Motivé"},
			{"025n", "025", "Noël"},
			{"025Partenaire", "025", "Casquette Partenaire"},
			{"025r", "025", "Rockeur"},
			{"025S", "025", "Surpris"},
			{"025s", "025", "Star"},
			{"025Sinnoh", "025", "Casquette de Sinnoh"},
			{"025Unys", "025", "Casquette d'Unys"},
			{"026a", "026", "Alola"},
			{"026a", "026", "Anniversaire"},
			{"026C", "026", "Clin d'œil"},
			{"026f", "026", "Casquette HF"},
			{"026h", "026", "Halloween"},
			{"026k", "026", "Casquette Originale"},
			{"026l", "026", "Style Estival"},
			{"026n", "026", "Noël"},
			{"027a", "027", "Alola"},
			{"028a", "028", "Alola"},
			{"035C", "035", "Clin d'œil"},
			{"037a", "037", "Alola"},
			{"038a", "038", "Alola"},
			{"039C", "039", "Clin d'œil"},
			{"040C", "040", "Clin d'œil"},
			{"050a", "050", "Alola"},
			{"051a", "051", "Alola"},
			{"052a", "052", "Alola"},
			{"053a", "053", "Alola"},
			{"065M", "065", "Méga"},
			{"074a", "074", "Alola"},
			{"075a", "075", "Alola"},
			{"076a", "076", "Alola"},
			{"080M", "080", "Méga"},
			{"088a", "088", "Alola"},
			{"089a", "089", "Alola"},
			{"094D", "094", "Déguisé"},
			{"094M", "094", "Méga"},
			{"103a", "103", "Alola"},
			{"105a", "105", "Alola"},
			{"105ad", "105", "Alola Dominant"},
			{"113C", "113", "Clin d'œil"},
			{"115M", "115", "Méga"},
			{"127M", "127", "Méga"},
			{"130M", "130", "Méga"},
			{"142M", "142", "Méga"},
			{"150MX", "150", "Méga X"},
			{"150MY", "150", "Méga Y"},
			{"152C", "152", "Clin d'œil"},
			{"155C", "155", "Clin d'œil"},
			{"158C", "158", "Clin d'œil"},
			{"172a", "172", "Anniversaire"},
			{"172h", "172", "Halloween"},
			{"172k", "172", "Casquette Originale"},
			{"172l", "172", "Style Estival"},
			{"172n", "172", "Noël"},
			{"172t", "172", "Troizépi"},
			{"176C", "176", "Clin d'œil"},
			{"181M", "181", "Méga"},
			{"184C", "184", "Clin d'œil"},
			{"187C", "187", "Clin d'œil"},
			{"188C", "188", "Clin d'œil"},
			{"189C", "189", "Clin d'œil"},
			{"201a", "201", "A"},
			{"201b", "201", "B"},
			{"201c", "201", "C"},
			{"201d", "201", "D"},
			{"201e", "201", "E"},
			{"201f", "201", "F"},
			{"201g", "201", "G"},
			{"201h", "201", "H"},
			{"201i", "201", "I"},
			{"201j", "201", "J"},
			{"201k", "201", "K"},
			{"201l", "201", "L"},
			{"201m", "201", "M"},
			{"201n", "201", "N"},
			{"201o", "201", "O"},
			{"201p", "201", "P"},
			{"201q", "201", "Q"},
			{"201r", "201", "R"},
			{"201s", "201", "S"},
			{"201t", "201", "T"},
			{"201u", "201", "U"},
			{"201v", "201", "V"},
			{"201w", "201", "W"},
			{"201x", "201", "X"},
			{"201y", "201", "Y"},
			{"201z", "201", "Z"},
			{"201!", "201", "!"},
			{"201?", "201", "?"},
			{"208M", "208", "Méga"},
			{"209C", "209", "Clin d'œil"},
			{"210C", "210", "Clin d'œil"},
			{"212M", "212", "Méga"},
			{"214M", "214", "Méga"},
			{"225F", "225", "Fêtes"},
			{"229M", "229", "Méga"},
			{"242C", "242", "Clin d'œil"},
			{"248M", "248", "Méga"},
			{"252C", "252", "Clin d'œil"},
			{"254M", "254", "Méga"},
			{"255C", "255", "Clin d'œil"},
			{"257M", "257", "Méga"},
			{"258C", "258", "Clin d'œil"},
			{"260M", "260", "Méga"},
			{"282M", "282", "Méga"},
			{"301C", "301", "Clin d'œil"},
			{"302D", "302", "Déguisé"},
			{"302M", "302", "Méga"},
			{"303M", "303", "Méga"},
			{"306M", "306", "Méga"},
			{"308M", "308", "Méga"},
			{"310M", "310", "Méga"},
			{"319M", "319", "Méga"},
			{"323M", "323", "Méga"},
			{"334M", "334", "Méga"},
			{"351C", "351", "Clin d'œil"},
			{"351n", "351", "Blizzard"},
			{"351p", "351", "Eau de Pluie"},
			{"351s", "351", "Solaire"},
			{"354M", "354", "Méga"},
			{"359M", "359", "Méga"},
			{"362C", "362", "Clin d'œil"},
			{"362M", "362", "Méga"},
			{"362MC", "362", "Méga Clin d'œil"},
			{"373M", "373", "Méga"},
			{"376M", "376", "Méga"},
			{"380M", "380", "Méga"},
			{"381M", "381", "Méga"},
			{"382p", "382", "Primo"},
			{"383p", "383", "Primo"},
			{"384M", "384", "Méga"},
			{"386a", "386", "Attaque"},
			{"386d", "386", "Défense"},
			{"386v", "386", "Vitesse"},
			{"387C", "387", "Clin d'œil"},
			{"390C", "390", "Clin d'œil"},
			{"393C", "393", "Clin d'œil"},
			{"407C", "407", "Clin d'œil"},
			{"412CD", "412", "Déchet"},
			{"412CS", "412", "Sable"},
			{"412d", "412", "Déchet"},
			{"412p", "412", "Plante"},
			{"412s", "412", "Sable"},
			{"413CD", "413", "Déchet"},
			{"413CS", "413", "Sable"},
			{"413d", "413", "Déchet"},
			{"413p", "413", "Plante"},
			{"413s", "413", "Sable"},
			{"420C", "420", "Clin d'œil"},
			{"421C", "421", "Clin d'œil"},
			{"421f", "421", "Couvert"},
			{"421o", "421", "Ensoleillé"},
			{"422e", "422", "Orient"},
			{"422o", "422", "Occident"},
			{"423e", "423", "Orient"},
			{"423o", "423", "Occident"},
			{"428M", "428", "Méga"},
			{"445M", "445", "Méga"},
			{"448M", "448", "Méga"},
			{"459F", "459", "Fêtes"},
			{"460M", "460", "Méga"},
			{"468C", "468", "Clin d'œil"},
			{"475M", "475", "Méga"},
			{"479c", "479", "Chaleur"},
			{"479f", "479", "Froid"},
			{"479h", "479", "Hélice"},
			{"479l", "479", "Lavage"},
			{"479t", "479", "Tonte"},
			{"487a", "487", "Alternative"},
			{"487o", "487", "Originelle"},
			{"489C", "489", "Clin d'œil"},
			{"490C", "490", "Clin d'œil"},
			{"492c", "492", "Céleste"},
			{"492t", "492", "Terrestre"},
			{"493acier", "493", "Acier"},
			{"493combat", "493", "Combat"},
			{"493dragon", "493", "Dragon"},
			{"493eau", "493", "Eau"},
			{"493électrik", "493", "Électrik"},
			{"493électrique", "493", "Électrik"},
			{"493fée", "493", "Fée"},
			{"493feu", "493", "Feu"},
			{"493glace", "493", "Glace"},
			{"493insecte", "493", "Insecte"},
			{"493plante", "493", "Plante"},
			{"493poison", "493", "Poison"},
			{"493psy", "493", "Psy"},
			{"493roche", "493", "Roche"},
			{"493sol", "493", "Sol"},
			{"493spectre", "493", "Spectre"},
			{"493ténèbres", "493", "Ténèbres"},
			{"493vol", "493", "Vol"},
			{"495C", "495", "Clin d'œil"},
			{"498C", "498", "Clin d'œil"},
			{"501C", "501", "Clin d'œil"},
			{"531C", "531", "Clin d'œil"},
			{"531M", "531", "Méga"},
			{"546C", "546", "Clin d'œil"},
			{"547C", "547", "Clin d'œil"},
			{"550b", "550", "Bleu"},
			{"550r", "550", "Rouge"},
			{"555t", "555", "Transe"},
			{"582F", "582", "Fêtes"},
			{"585a", "585", "Automne"},
			{"585e", "585", "Été"},
			{"585h", "585", "Hiver"},
			{"585p", "585", "Printemps"},
			{"586a", "586", "Automne"},
			{"586e", "586", "Été"},
			{"586h", "586", "Hiver"},
			{"586p", "586", "Printemps"},
			{"613F", "613", "Fêtes"},
			{"641t", "641", "Totémique"},
			{"642t", "642", "Totémique"},
			{"645t", "645", "Totémique"},
			{"646b", "646", "Blanc"},
			{"646n", "646", "Noir"},
			{"647d", "647", "Décidé"},
			{"648c", "648", "Chant"},
			{"648d", "648", "Danse"},
			{"649aqua", "649", "Aqua"},
			{"649choc", "649", "Choc"},
			{"649cryo", "649", "Cryo"},
			{"649pyro", "649", "Pyro"},
			{"650C", "650", "Clin d'œil"},
			{"653C", "653", "Clin d'œil"},
			{"656C", "656", "Clin d'œil"},
			{"658s", "658", "Sachanobi"},
			{"666archipel", "666", "Archipel"},
			{"666banquise", "666", "Banquise"},
			{"666blizzard", "666", "Blizzard"},
			{"666continent", "666", "Continent"},
			{"666cyclone", "666", "Cyclone"},
			{"666delta", "666", "Delta"},
			{"666fantaisie", "666", "Fantaisie"},
			{"666floraison", "666", "Floraison"},
			{"666glace", "666", "Glace"},
			{"666jungle", "666", "Jungle"},
			{"666mangrove", "666", "Mangrove"},
			{"666monarchie", "666", "Monarchie"},
			{"666métropole", "666", "Métropole"},
			{"666P", "666", "Poké Ball"},
			{"666poké ball", "666", "Poké Ball"},
			{"666rivage", "666", "Rivage"},
			{"666sable", "666", "Sable"},
			{"666soleillevant", "666", "Soleil Levant"},
			{"666sécheresse", "666", "Sécheresse"},
			{"666verdure", "666", "Verdure"},
			{"666zénith", "666", "Zénith"},
			{"669bla", "669", "Blanche"},
			{"669ble", "669", "Bleue"},
			{"669C", "669", "Clin d'œil"},
			{"669j", "669", "Jaune"},
			{"669o", "669", "Orange"},
			{"669r", "669", "Rouge"},
			{"670bla", "670", "Blanche"},
			{"670ble", "670", "Bleue"},
			{"670C", "670", "Clin d'œil"},
			{"670j", "670", "Jaune"},
			{"670o", "670", "Orange"},
			{"670 r", "670", "Rouge"},
			{"670r", "670", "Rouge"},
			{"671bla", "671", "Blanche"},
			{"671ble", "671", "Bleue"},
			{"671j", "671", "Jaune"},
			{"671o", "671", "Orange"},
			{"671r", "671", "Rouge"},
			{"676cœur", "676", "Cœur"},
			{"676demoiselle", "676", "Demoiselle"},
			{"676diamant", "676", "Diamant"},
			{"676étoile", "676", "Étoile"},
			{"676kabuki", "676", "Kabuki"},
			{"676madame", "676", "Madame"},
			{"676monsieur", "676", "Monsieur"},
			{"676pharaon", "676", "Pharaon"},
			{"676reine", "676", "Reine"},
			{"681a", "681", "Assaut"},
			{"681p", "681", "Parade"},
			{"684C", "684", "Clin d'œil"},
			{"685C", "685", "Clin d'œil"},
			{"703C", "703", "Clin d'œil"},
			{"710D", "710", "Déguisé"},
			{"710ma", "710", "Maxi"},
			{"710mi", "710", "Mini"},
			{"710n", "710", "Normale"},
			{"710u", "710", "Ultra"},
			{"711D", "711", "Déguisé"},
			{"711ma", "711", "Maxi"},
			{"711mi", "711", "Mini"},
			{"711n", "711", "Normale"},
			{"711u", "711", "Ultra"},
			{"716d", "716", "Déchaîné"},
			{"716p", "716", "Paisible"},
			{"718-10", "718", "10%"},
			{"718 10", "718", "10%"},
			{"718p", "718", "Parfaite"},
			{"719M", "719", "Méga"},
			{"720d", "720", "Déchaînée"},
			{"720e", "720", "Enchaînée"},
			{"735d", "735", "Dominant"},
			{"738d", "738", "Dominant"},
			{"741b", "741", "Buyo"},
			{"741f", "741", "Flamenco"},
			{"741h", "741", "Hula"},
			{"741p", "741", "Pom-Pom"},
			{"743d", "743", "Dominant"},
			{"745c", "745", "Crépusculaire"},
			{"745d", "745", "Diurne"},
			{"745n", "745", "Nocturne"},
			{"746b", "746", "Banc"},
			{"746s", "746", "Solitaire"},
			{"752d", "752", "Dominant"},
			{"754d", "754", "Dominant"},
			{"758d", "758", "Dominant"},
			{"773acier", "773", "Acier"},
			{"773combat", "773", "Combat"},
			{"773dragon", "773", "Dragon"},
			{"773eau", "773", "Eau"},
			{"773électrik", "773", "Électrik"},
			{"773fée", "773", "Fée"},
			{"773feu", "773", "Feu"},
			{"773glace", "773", "Glace"},
			{"773insecte", "773", "Insecte"},
			{"773plante", "773", "Plante"},
			{"773poison", "773", "Poison"},
			{"773psy", "773", "Psy"},
			{"773roche", "773", "Roche"},
			{"773sol", "773", "Sol"},
			{"773spectre", "773", "Spectre"},
			{"773ténèbres", "773", "Ténèbres"},
			{"773vol", "773", "Vol"},
			{"774bleu", "774", "Bleu"},
			{"774indigo", "774", "Indigo"},
			{"774jaune", "774", "Jaune"},
			{"774orange", "774", "Orange"},
			{"774rouge", "774", "Rouge"},
			{"774vert", "774", "Vert"},
			{"774violet", "774", "Violet"},
			{"777d", "777", "Dominant"},
			{"778D", "778", "Dominant"},
			{"778d", "778", "Démasquée"},
			{"778dd", "778", "Dominant Démasquée"},
			{"784d", "784", "Dominant"},
			{"800a", "800", "Ailes de l'Aurore"},
			{"800aa", "800", "Ailes de l'Aurore"},
			{"800c", "800", "Crinière du Couchant"},
			{"800cc", "800", "Crinière du Couchant"},
			{"800u", "800", "Ultra"},
		};
	}
	
	public static String[] getForms(int num) {
		// Zarbi
		if(num==201) {
			return new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","?","!"};
		}		
		// Morphéo
		if(num==351) {
			return new String[]{"", "Forme Neige", "Forme Pluie", "Forme Soleil"};
		}
		// Deoxys 
		if(num==386) {
			return new String[]{"", "Forme Attaque", "Forme Défense", "Forme Vitesse"};
		}
		// Cheniti et Cheniselle
		if(num==412 || num==413) {
			return new String[]{"Cape Plante", "Cape Déchet", "Cape Sable"};
		}
		// Ceriflor
		if(num==421) {
			return new String[]{"Forme Ouverte", "Forme Fermée"};
		}
		// Sancoki et Tritosor
		if(num==422 || num==423) {
			return new String[]{"Forme Ouest", "Forme Est"};
		}
		// Motisma
		if(num==479) {
			return new String[]{"", "Forme Froid", "Forme Chaleur", "Forme Hélice", "Forme Tonte", "Forme Lavage"};
		}
		// Giratina
		if(num==487) {
			return new String[]{"-a", "-o"};
		}
		// Shaymin
		if(num==492) {
			return new String[]{"-t", "-c"};
		}
		// Arceus
		if(num==493) {
			return new String[]{"", "-Acier","-Combat","-Dragon","-Eau","-Électrique","-Feu","-Glace","-Insecte","-Plante","-Poison","-Psy","-Roche","-Sol","-Spectre","-Ténèbres","-Vol"};
		}
		// Bargantua
		if(num==550) {
			return new String[]{"R", "B"};
		}
		// Vivaldaim et Haydaim
		if(num==585 || num==586) {
			return new String[]{"Printemps", "Été", "Automne", "Hiver"};
		}
		// Génies
		if(num==641 || num==642 || num==645) {
			return new String[]{"", "-t"};
		}
		// Keldeo
		if(num==647) {
			return new String[]{"-n", "-d"};
		}
		// Meloetta
		if(num==648) {
			return new String[]{"-c", "-d"};
		}
		// Genesect
		if(num==649) {
			return new String[]{"", "-c", "-p"};
		}
		// Exagide
		if(num==681) {
			return new String[]{"-p"};
		}

		return null;
	}
	
	static int getGenerationAttack(String attackName) {
		attackName = attackName.replace(" (capacité)", "");
		Object[][] temporaryDict = new Object[][]{
			{"Abîme", 1}, {"Acidarmure", 1}, {"Acide", 1}, {"Affûtage", 1}, {"Amnésie", 1}, {"Armure", 1}, {"Balayage", 1}, {"Bec Vrille", 1}, {"Bélier", 1}, {"Berceuse", 1}, {"Blizzard", 1}, {"Bombe Œuf", 1}, {"Bouclier", 1}, {"Boul'Armure", 1}, {"Brouillard", 1}, {"Brume", 1}, {"Buée Noire", 1}, {"Bulles d'O", 1}, {"Cage Éclair", 1}, {"Cascade", 1}, {"Charge", 1}, {"Choc Mental", 1}, {"Claquoir", 1}, {"Clonage", 1}, {"Combo-Griffe", 1}, {"Constriction", 1}, {"Conversion", 1}, {"Copie", 1}, {"Coud'Krâne", 1}, {"Coup d'Boule", 1}, {"Coupe", 1}, {"Coupe-Vent", 1}, {"Croc de Mort", 1}, {"Croc Fatal", 1}, {"Croissance", 1}, {"Cru-Ailes", 1}, {"Cyclone", 1}, {"Damoclès", 1}, {"Danse Flammes", 1}, {"Danse Fleurs", 1}, {"Danse Lames", 1}, {"Dard-Nuée", 1}, {"Dard-Venin", 1}, {"Déflagration", 1}, {"Destruction", 1}, {"Détritus", 1}, {"Dévorêve", 1}, {"Double Dard", 1}, {"Double Pied", 1}, {"Draco-Rage", 1}, {"E-Coque", 1}, {"Éboulement", 1}, {"Éclair", 1}, {"Écras'Face", 1}, {"Écrasement", 1}, {"Écume", 1}, {"Empal'Korne", 1}, {"Entrave", 1}, {"Étreinte", 1}, {"Explosion", 1}, {"Fatal-Foudre", 1}, {"Flammèche", 1}, {"Flash", 1}, {"Force", 1}, {"Force Poigne", 1}, {"Fouet Lianes", 1}, {"Frappe Atlas", 1}, {"Frénésie", 1}, {"Furie", 1}, {"Gaz Toxik", 1}, {"Griffe", 1}, {"Grincement", 1}, {"Grobisou", 1}, {"Groz'Yeux", 1}, {"Guillotine", 1}, {"Hâte", 1}, {"Hurlement", 1}, {"Hydrocanon", 1}, {"Hypnose", 1}, {"Jackpot", 1}, {"Jet de Sable", 1}, {"Jet-Pierres", 1}, {"Koud'Korne", 1}, {"Lance-Flammes", 1}, {"Lance-Soleil", 1}, {"Laser Glace", 1}, {"Léchouille", 1}, {"Ligotage", 1}, {"Lilliput", 1}, {"Lutte", 1}, {"Mania", 1}, {"Massd'Os", 1}, {"Mawashi Geri", 1}, {"Méga-Sangsue", 1}, {"Météores", 1}, {"Métronome", 1}, {"Mimi-Queue", 1}, {"Mimique", 1}, {"Morphing", 1}, {"Morsure", 1}, {"Mur Lumière", 1}, {"Ombre Nocturne", 1}, {"Onde Boréale", 1}, {"Onde Folie", 1}, {"Osmerang", 1}, {"Para-Spore", 1}, {"Patience", 1}, {"Picanon", 1}, {"Picpic", 1}, {"Pied Sauté", 1}, {"Pied Voltige", 1}, {"Pilonnage", 1}, {"Pince-Masse", 1}, {"Piqué", 1}, {"Pistolet à O", 1}, {"Plaquage", 1}, {"Poing Comète", 1}, {"Poing Éclair", 1}, {"Poing Feu", 1}, {"Poing Glace", 1}, {"Poing Karaté", 1}, {"Poudre Dodo", 1}, {"Poudre Toxik", 1}, {"Protection", 1}, {"Psyko", 1}, {"Puissance", 1}, {"Purédpois", 1}, {"Rafale Psy", 1}, {"Reflet", 1}, {"Regard Médusant", 1}, {"Repli", 1}, {"Repos", 1}, {"Riposte", 1}, {"Rugissement", 1}, {"Sacrifice", 1}, {"Sécrétion", 1}, {"Séisme", 1}, {"Soin", 1}, {"Sonic Boom", 1}, {"Souplesse", 1}, {"Spore", 1}, {"Surf", 1}, {"Télékinésie", 1}, {"Téléport", 1}, {"Tonnerre", 1}, {"Torgnoles", 1}, {"Tornade", 1}, {"Toxik", 1}, {"Tranch'Herbe", 1}, {"Tranche", 1}, {"Trempette", 1}, {"Triplattaque", 1}, {"Tunnel", 1}, {"Ultimapoing", 1}, {"Ultimawashi", 1}, {"Ultralaser", 1}, {"Ultrason", 1}, {"Uppercut", 1}, {"Vague Psy", 1}, {"Vampigraine", 1}, {"Vampirisme", 1}, {"Vive-Attaque", 1}, {"Vol", 1}, {"Vole-Vie", 1}, {"Yoga", 1},
			{"Abri", 2}, {"Aéroblast", 2}, {"Ailes d'Acier", 2}, {"Ampleur", 2}, {"Attraction", 2}, {"Aurore", 2}, {"Balance", 2}, {"Ball'Ombre", 2}, {"Baston", 2}, {"Blabla Dodo", 2}, {"Bombe Beurk", 2}, {"Boost", 2}, {"Cadeau", 2}, {"Cauchemar", 2}, {"Charge Os", 2}, {"Charme", 2}, {"Clairvoyance", 2}, {"Cognobidon", 2}, {"Colère", 2}, {"Contre", 2}, {"Conversion 2", 2}, {"Corps Perdu", 2}, {"Coud'Boue", 2}, {"Coup Croix", 2}, {"Danse Pluie", 2}, {"Dépit", 2}, {"Détection", 2}, {"Doux Baiser", 2}, {"Doux Parfum", 2}, {"Draco-Souffle", 2}, {"Dynamo-Poing", 2}, {"Éclate-Roc", 2}, {"Élecanon", 2}, {"Encore", 2}, {"Étincelle", 2}, {"Faux-Chage", 2}, {"Feinte", 2}, {"Feu Sacré", 2}, {"Frustration", 2}, {"Giga-Sangsue", 2}, {"Gigotage", 2}, {"Glas de Soin", 2}, {"Gribouille", 2}, {"Griffe Acier", 2}, {"Grimace", 2}, {"Lait à Boire", 2}, {"Larcin", 2}, {"Lien du Destin", 2}, {"Lire-Esprit", 2}, {"Mach Punch", 2}, {"Mâchouille", 2}, {"Malédiction", 2}, {"Mégacorne", 2}, {"Octazooka", 2}, {"Ouragan", 2}, {"Picots", 2}, {"Poudreuse", 2}, {"Poursuite", 2}, {"Pouvoir Antique", 2}, {"Prescience", 2}, {"Puissance Cachée", 2}, {"Queue de Fer", 2}, {"Rayon Lune", 2}, {"Regard Noir", 2}, {"Relais", 2}, {"Requiem", 2}, {"Retour", 2}, {"Ronflement", 2}, {"Roue de Feu", 2}, {"Roulade", 2}, {"Rune Protect", 2}, {"Siphon", 2}, {"Spore Coton", 2}, {"Synthèse", 2}, {"Taillade", 2}, {"Tempête de Sable", 2}, {"Ténacité", 2}, {"Toile", 2}, {"Tour Rapide", 2}, {"Triple Pied", 2}, {"Vantardise", 2}, {"Vent Glace", 2}, {"Verrouillage", 2}, {"Vitesse Extrême", 2}, {"Voile Miroir", 2}, {"Zénith", 2},
			{"Aéropique", 3}, {"Aromathérapie", 3}, {"Assistance", 3}, {"Avale", 3}, {"Bâillement", 3}, {"Ball'Brume", 3}, {"Ball'Glace", 3}, {"Ball'Météo", 3}, {"Balle Graine", 3}, {"Barrage", 3}, {"Bluff", 3}, {"Boule Roc", 3}, {"Brouhaha", 3}, {"Camouflage", 3}, {"Canicule", 3}, {"Casse-Brique", 3}, {"Chargeur", 3}, {"Chatouille", 3}, {"Cogne", 3}, {"Coup d'Main", 3}, {"Crochet Venin", 3}, {"Croco Larme", 3}, {"Danse Draco", 3}, {"Danse Folle", 3}, {"Danse Plumes", 3}, {"Draco-Griffe", 3}, {"Échange", 3}, {"Éclate Griffe", 3}, {"Effort", 3}, {"Électacle", 3}, {"Éruption", 3}, {"Étonnement", 3}, {"Extrasenseur", 3}, {"Façade", 3}, {"Feu Follet", 3}, {"Feuille Magik", 3}, {"Flair", 3}, {"Flatterie", 3}, {"Force Cachée", 3}, {"Force Cosmique", 3}, {"Force Nature", 3}, {"Giclédo", 3}, {"Glaciation", 3}, {"Gonflette", 3}, {"Grêle", 3}, {"Grondement", 3}, {"Hydroblast", 3}, {"Imitation", 3}, {"Implore", 3}, {"Lame Feuille", 3}, {"Lance-Boue", 3}, {"Lumi-Éclat", 3}, {"Lumi-Queue", 3}, {"Mégaphone", 3}, {"Mitra-Poing", 3}, {"Mur de Fer", 3}, {"Ocroupi", 3}, {"Onde de Choc", 3}, {"Par Ici", 3}, {"Paresse", 3}, {"Pied Brûleur", 3}, {"Plénitude", 3}, {"Plongée", 3}, {"Poing Dard", 3}, {"Poing Météore", 3}, {"Poing Ombre", 3}, {"Possessif", 3}, {"Provoc", 3}, {"Psycho-Boost", 3}, {"Queue-Poison", 3}, {"Racines", 3}, {"Rafale Feu", 3}, {"Rancune", 3}, {"Rayon Signal", 3}, {"Rebond", 3}, {"Recyclage", 3}, {"Reflet Magik", 3}, {"Régénération", 3}, {"Relâche", 3}, {"Sabotage", 3}, {"Saisie", 3}, {"Siffl'Herbe", 3}, {"Souvenir", 3}, {"Stalactite", 3}, {"Stimulant", 3}, {"Stockage", 3}, {"Stratopercut", 3}, {"Strido-Son", 3}, {"Surchauffe", 3}, {"Surpuissance", 3}, {"Tir de Boue", 3}, {"Tomberoche", 3}, {"Tour de Magie", 3}, {"Tourbi-Sable", 3}, {"Tourmente", 3}, {"Tourniquet", 3}, {"Tranch'Air", 3}, {"Végé-Attaque", 3}, {"Vendetta", 3}, {"Vent Argenté", 3}, {"Vibraqua", 3}, {"Vœu", 3}, {"Vœu Destructeur", 3},
			{"Acupression", 4}, {"Air Veinard", 4}, {"Anneau Hydro", 4}, {"Anti-Brume", 4}, {"Anti-Soin", 4}, {"Appel Attaque", 4}, {"Appel Défense", 4}, {"Appel Soins", 4}, {"Aqua-Jet", 4}, {"Assurance", 4}, {"Astuce Force", 4}, {"Atout", 4}, {"Atterrissage", 4}, {"Aurasphère", 4}, {"Avalanche", 4}, {"Babil", 4}, {"Bombe Aimant", 4}, {"Boue-Bombe", 4}, {"Bourdon", 4}, {"Boutefeu", 4}, {"Canon Graine", 4}, {"Close Combat", 4}, {"Coup Bas", 4}, {"Coup d'Jus", 4}, {"Coup Double", 4}, {"Coupe Psycho", 4}, {"Crocs Éclair", 4}, {"Crocs Feu", 4}, {"Crocs Givre", 4}, {"Danse Lune", 4}, {"Dégommage", 4}, {"Demi-Tour", 4}, {"Dernier Recours", 4}, {"Détricanon", 4}, {"Direct Toxik", 4}, {"Distorsion", 4}, {"Don Naturel", 4}, {"Draco-Charge", 4}, {"Draco-Choc", 4}, {"Draco-Météore", 4}, {"Ébullilave", 4}, {"Échange Psy", 4}, {"Éclats Glace", 4}, {"Éco-Sphère", 4}, {"Embargo", 4}, {"Escalade", 4}, {"Essorage", 4}, {"Exploforce", 4}, {"Forte-Paume", 4}, {"Fracass'Tête", 4}, {"Fulmifer", 4}, {"Fulmigraine", 4}, {"Giga Impact", 4}, {"Gravité", 4}, {"Griffe Ombre", 4}, {"Gyroballe", 4}, {"Hurle-Temps", 4}, {"Hydro-Queue", 4}, {"Jugement", 4}, {"Lame d'Air", 4}, {"Lame de Roc", 4}, {"Luminocanon", 4}, {"Machination", 4}, {"Marto-Poing", 4}, {"Martobois", 4}, {"Mégafouet", 4}, {"Miroi-Tir", 4}, {"Moi d'Abord", 4}, {"Nœud Herbe", 4}, {"Œil Miracle", 4}, {"Ombre Portée", 4}, {"Onde Vide", 4}, {"Passe-Passe", 4}, {"Permucœur", 4}, {"Permuforce", 4}, {"Permugarde", 4}, {"Photocopie", 4}, {"Picore", 4}, {"Pics Toxik", 4}, {"Piège de Roc", 4}, {"Piqûre", 4}, {"Pisto-Poing", 4}, {"Plaie Croix", 4}, {"Poison Croix", 4}, {"Poliroche", 4}, {"Presse", 4}, {"Psykoud'Boul", 4}, {"Punition", 4}, {"Rapace", 4}, {"Rayon Chargé", 4}, {"Rayon Gemme", 4}, {"Représailles", 4}, {"Réveil Forcé", 4}, {"Revenant", 4}, {"Roc-Boulet", 4}, {"Ruse", 4}, {"Saumure", 4}, {"Séduction", 4}, {"Soucigraine", 4}, {"Spatio-Rift", 4}, {"Suc Digestif", 4}, {"Telluriforce", 4}, {"Tempête Verte", 4}, {"Tête de Fer", 4}, {"Tranche-Nuit", 4}, {"Trou Noir", 4}, {"Vampi-Poing", 4}, {"Vent Arrière", 4}, {"Vent Mauvais", 4}, {"Vibrobscur", 4}, {"Vœu Soin", 4}, {"Vol Magnétik", 4}, {"Vortex Magma", 4},
			{"À la Queue", 5}, {"Aboiement", 5}, {"Acrobatie", 5}, {"Aiguisage", 5}, {"Aire d'Eau", 5}, {"Aire d'Herbe", 5}, {"Aire de Feu", 5}, {"Allègement", 5}, {"Anti-Air", 5}, {"Après Vous", 5}, {"Attrition", 5}, {"Bain de Smog", 5}, {"Balayette", 5}, {"Bombe Acide", 5}, {"Boule Élek", 5}, {"Bulldoboule", 5}, {"Calcination", 5}, {"Change-Éclair", 5}, {"Change-Vitesse", 5}, {"Chant Antique", 5}, {"Chant Canon", 5}, {"Charge Foudre", 5}, {"Châtiment", 5}, {"Choc Psy", 5}, {"Choc Venin", 5}, {"Chute Glace", 5}, {"Chute Libre", 5}, {"Copie-Type", 5}, {"Coqui-Lame", 5}, {"Cotogarde", 5}, {"Coup Victoire", 5}, {"Cradovague", 5}, {"Crève-Cœur", 5}, {"Danse du Feu", 5}, {"Détrempage", 5}, {"Double Baffe", 5}, {"Draco-Queue", 5}, {"Ébullition", 5}, {"Écho", 5}, {"Éclair Croix", 5}, {"Éclair Fou", 5}, {"Éclair Gelé", 5}, {"Encornebois", 5}, {"Enroulement", 5}, {"Ère Glaciaire", 5}, {"Explonuit", 5}, {"Exuviation", 5}, {"Feu d'Enfer", 5}, {"Feu Glacé", 5}, {"Flamme Bleue", 5}, {"Flamme Croix", 5}, {"Force Ajoutée", 5}, {"Frappe Psy", 5}, {"Garde Large", 5}, {"Incendie", 5}, {"Interversion", 5}, {"Lame Ointe", 5}, {"Lame Sainte", 5}, {"Lancécrou", 5}, {"Lévikinésie", 5}, {"Nitrocharge", 5}, {"Papillodanse", 5}, {"Partage Force", 5}, {"Partage Garde", 5}, {"Passe-Cadeau", 5}, {"Peignée", 5}, {"Phytomixeur", 5}, {"Piétisol", 5}, {"Plumo-Queue", 5}, {"Poudre Fureur", 5}, {"Prévention", 5}, {"Projection", 5}, {"Rayon Simple", 5}, {"Rebondifeu", 5}, {"Rengorgement", 5}, {"Souffle Glacé", 5}, {"Survinsecte", 5}, {"Synchropeine", 5}, {"Tacle Feu", 5}, {"Tacle Lourd", 5}, {"Techno-Buster", 5}, {"Ten-Danse", 5}, {"Toile Élek", 5}, {"Tout ou Rien", 5}, {"Tricherie", 5}, {"Tunnelier", 5}, {"Vengeance", 5}, {"Vent Violent", 5}, {"Vibra Soin", 5}, {"Yama Arashi", 5}, {"Zone Étrange", 5}, {"Zone Magique", 5},
			{"Bang Sonique", 6}, {"Bouclier Royal", 6}, {"Brume Capiteuse", 6}, {"Câlinerie", 6}, {"Camaraderie", 6}, {"Célébration", 6}, {"Champ Brumeux", 6}, {"Champ Électrifié", 6}, {"Champ Herbu", 6}, {"Confidence", 6}, {"Dard Mortel", 6}, {"Déluge Plasmique", 6}, {"Dernier Mot", 6}, {"Draco-Ascension", 6}, {"Éclat Magique", 6}, {"Électrisation", 6}, {"Éructation", 6}, {"Étrennes", 6}, {"Fertilisation", 6}, {"Feu Ensorcelé", 6}, {"Flying Press", 6}, {"Force Chtonienne", 6}, {"Frotte-Frimousse", 6}, {"Furie Dimension", 6}, {"Garde Florale", 6}, {"Géo-Contrôle", 6}, {"Halloween", 6}, {"Hantise", 6}, {"Harcèlement", 6}, {"Jet de Vapeur", 6}, {"Lame Pangéenne", 6}, {"Lumière du Néant", 6}, {"Lyophilisation", 6}, {"Magné-Contrôle", 6}, {"Mains Jointes", 6}, {"Maléfice Sylvain", 6}, {"Mort'Ailes", 6}, {"Nuée de Poudre", 6}, {"Onde Originelle", 6}, {"Ondes Étranges", 6}, {"Orage Adamantin", 6}, {"Parabocharge", 6}, {"Pico-Défense", 6}, {"Piège de Venin", 6}, {"Poing Boost", 6}, {"Pouvoir Lunaire", 6}, {"Râle Mâle", 6}, {"Regard Touchant", 6}, {"Renversement", 6}, {"Retenue", 6}, {"Sheauriken", 6}, {"Tatamigaeshi", 6}, {"Tempête Florale", 6}, {"Toile Gluante", 6}, {"TrouDimensionnel", 6}, {"Vampibaiser", 6}, {"Vent Féérique", 6}, {"Verrou Enchanté", 6}, {"Vigilance", 6}, {"Voix Enjôleuse", 6},
			{"Affilage", 7}, {"Amass'Sable", 7}, {"Ancrage", 7}, {"Apocalypse Gigalithique", 7}, {"Apocalypsis Luminis", 7}, {"Appel des Ombres Éternelles", 7}, {"Aqua-Brèche", 7}, {"Aria de l'Écume", 7}, {"Arrogance", 7}, {"Bec-Canon", 7}, {"Blockhaus", 7}, {"Botte Sucrette", 7}, {"Boule Pollen", 7}, {"Caboche-Kaboum", 7}, {"Canon Floral", 7}, {"Carapiège", 7}, {"Cavalerie Lourde", 7}, {"Centrifugifle", 7}, {"Champ Psychique", 7}, {"Chaos Draconique", 7}, {"Choc Météore", 7}, {"Clepto-Mânes", 7}, {"Cocon Fatal", 7}, {"Colère du Gardien d'Alola", 7}, {"Combo Hyper-Furie", 7}, {"Coup Varia-Type", 7}, {"Danse Éveil", 7}, {"Dark Body Press", 7}, {"Dark Lariat", 7}, {"Déluge Causti-Toxique", 7}, {"Dracacophonie Flamboyante", 7}, {"Draco-Marteau", 7}, {"Écrous d'Poing", 7}, {"Électrikipik", 7}, {"Électro-Surf Survolté", 7}, {"Engrenage", 7}, {"Éruption Géo-Sismique", 7}, {"Escarmouche", 7}, {"Estocorne", 7}, {"Évo-Chardasso", 7}, {"Évo-Congélo", 7}, {"Évo-Dynamo", 7}, {"Évo-Écolo", 7}, {"Évo-Fabulo", 7}, {"Évo-Flambo", 7}, {"Évo-Psycho", 7}, {"Évo-Ténébro", 7}, {"Évo-Thalasso", 7}, {"Exécu-Son", 7}, {"Fauche-Âme des Sept Étoiles", 7}, {"Feuillage", 7}, {"Fil Toxique", 7}, {"Flamme Ultime", 7}, {"Fouet de Feu", 7}, {"Fulguro-Lance Gigavolt", 7}, {"Fureur des Plumes Spectrales", 7}, {"Furie-Bond", 7}, {"Gare au Ronflex", 7}, {"Giga-Tonnerre", 7}, {"Hélio-Choc Dévastateur", 7}, {"Hurlement des Roches-Lames", 7}, {"Impact Choupinova", 7}, {"Ire de la Nature", 7}, {"Lame Solaire", 7}, {"Larme à l'Œil", 7}, {"Laser Cryogénique", 7}, {"Laser Prisme", 7}, {"Marteau de Glace", 7}, {"Myria-Flèches", 7}, {"Myria-Vagues", 7}, {"Neuf pour Un", 7}, {"Os Ombre", 7}, {"Patati-Patattrape", 7}, {"Permuvitesse", 7}, {"Pétalexplosion Éblouissante", 7}, {"Photo-Geyser", 7}, {"Pika-Fracas", 7}, {"Pika-Piqué", 7}, {"Pika-Splash", 7}, {"Pika-Sprint", 7}, {"Pikachute Foudroyante", 7}, {"Piqué Supersonique", 7}, {"Plasma Punch", 7}, {"Projecteur", 7}, {"Psycho-Croc", 7}, {"Psycho-Pulvérisation EX", 7}, {"Purification", 7}, {"Pyro-Explosion Cataclysmique", 7}, {"Rayon Spectral", 7}, {"Rayons Séléno-Explosifs", 7}, {"Sanction Suprême", 7}, {"Soin Floral", 7}, {"Sommation", 7}, {"Super Tourbillon Abyssal", 7}, {"Supernova Originelle", 7}, {"Symphonie des Ondines", 7}, {"Tisse Ombre", 7}, {"Trépignement", 7}, {"Trou Noir des Ombres", 7}, {"Turbo-Charge Bulldozer", 7}, {"Vibrécaille", 7}, {"Vif Roc", 7}, {"Voile Aurore", 7}, {"Vole-Force", 7}, {"Vrille Maximum", 7},
			{"Abattage", 8}, {"Acide Malique", 8}, {"Aegis Maxima", 8}, {"Aéromax", 8}, {"Ailes Psycho", 8}, {"Aquatacle", 8}, {"Assaut Frontal", 8}, {"Ballon Brûlant", 8}, {"Big Splash", 8}, {"Bise Glaciaire", 8}, {"Blocage", 8}, {"Branchicrok", 8}, {"Bulles G-Max", 8}, {"Câlin G-Max", 8}, {"Canon Dynamax", 8}, {"Canonnade G-Max", 8}, {"Cent Rancunes", 8}, {"Champlification", 8}, {"Change-Côté", 8}, {"Choc Émotionnel", 8}, {"Choc G-Max", 8}, {"Coaching", 8}, {"Cœur de Rancœur", 8}, {"Combustion G-Max", 8}, {"Corrosion G-Max", 8}, {"Cortège Funèbre", 8}, {"Coup Final G-Max", 8}, {"Coup Fulgurant", 8}, {"Croque Fort", 8}, {"Cryomax", 8}, {"Cure G-Max", 8}, {"Danse Victoire", 8}, {"Double Volée", 8}, {"Dracacophonie", 8}, {"Draco-Énergie", 8}, {"Draco-Flèches", 8}, {"Dracomax", 8}, {"Eau Revoir", 8}, {"Échange Force", 8}, {"Éclat Spectral", 8}, {"Enchantomax", 8}, {"Enlisement G-Max", 8}, {"Esprit Frappeur", 8}, {"Explo-Brume", 8}, {"Extravaillance", 8}, {"Feu Envieux", 8}, {"Fontaine de Vie", 8}, {"Fonte G-Max", 8}, {"Force G", 8}, {"Force Mystique", 8}, {"Foudre G-Max", 8}, {"Fouet G-Max", 8}, {"Fourbette", 8}, {"Fournaise G-Max", 8}, {"Frappe G-Max", 8}, {"Fulguromax", 8}, {"Fureur Ardente", 8}, {"Gâchette G-Max", 8}, {"Garde-à-Joues", 8}, {"Gardomax", 8}, {"Gaz Corrosif", 8}, {"Gladius Maximus", 8}, {"Gliss'Herbe", 8}, {"Goudronnage", 8}, {"Grand Courroux", 8}, {"Griffes Funestes", 8}, {"Hache de Pierre", 8}, {"Hantise G-Max", 8}, {"Herblast", 8}, {"Hydromax", 8}, {"Illusion G-Max", 8}, {"Insectomax", 8}, {"Joute Astrale", 8}, {"Kokiyarme", 8}, {"Lance de Glace", 8}, {"Laser Infinimax", 8}, {"Laser Météore", 8}, {"Lithomax", 8}, {"Métalaser", 8}, {"Métalliroue", 8}, {"Métallomax", 8}, {"Monte-Tension", 8}, {"Multicoup G-Max", 8}, {"Multitoxik", 8}, {"Mur Fumigène", 8}, {"Nappage", 8}, {"Nectar G-Max", 8}, {"Normalomax", 8}, {"Octoprise", 8}, {"Ondes G-Max", 8}, {"Overdrive", 8}, {"Pactole G-Max", 8}, {"Percée G-Max", 8}, {"Percussion G-Max", 8}, {"Pestilence G-Max", 8}, {"Phytomax", 8}, {"Poing Obscur", 8}, {"Poudre Magique", 8}, {"Prière Lunaire", 8}, {"Prise de Bec", 8}, {"Psychomax", 8}, {"Pugilomax", 8}, {"Pyroball G-Max", 8}, {"Pyromax", 8}, {"Rafale Écailles", 8}, {"Rafale G-Max", 8}, {"Ravage Rampant", 8}, {"Récif G-Max", 8}, {"Récolte G-Max", 8}, {"Regard Glaçant", 8}, {"Résonance G-Max", 8}, {"Roue Libre", 8}, {"Sable Ardent", 8}, {"Selve Salvatrice", 8}, {"Sentence G-Max", 8}, {"Sinistromax", 8}, {"Sismomax", 8}, {"Sort Sinistre", 8}, {"Spectromax", 8}, {"Sprint Bouclier", 8}, {"Tambour Battant", 8}, {"Tapotige", 8}, {"Téphra G-Max", 8}, {"Thérémonie", 8}, {"Tir de Précision", 8}, {"Torpeur G-Max", 8}, {"Torrent de Coups", 8}, {"Toxinomax", 8}, {"Triple Axel", 8}, {"Triple Flèche", 8}, {"Troquenard", 8}, {"Typhon Fulgurant", 8}, {"Typhon Hivernal", 8}, {"Typhon Passionné", 8}, {"Typhon Pyrosable", 8}, {"Ultime Bastion", 8}, {"Usure G-Max", 8}, {"Vagues à Lames", 8}, {"Vapeur Féérique", 8}, {"Vaste Pouvoir", 8}, {"Voltageôle", 8},
			{"Bombe au Sirop", 9}, {"Bond", 9}, {"Canon Blindé", 9}, {"Cataclysme", 9}, {"Chaîne Malsaine", 9}, {"Chant Flamboyant", 9}, {"Charge Glaive", 9}, {"Chute de Neige", 9}, {"Crash Brûlant", 9}, {"Crash Magique", 9}, {"Crash Musclé", 9}, {"Crash Obscur", 9}, {"Crash Toxique", 9}, {"Cri Draconique", 9}, {"Cryo-Pirouette", 9}, {"Danse Aquatique", 9}, {"Désherbaffe", 9}, {"Dissonance Psy", 9}, {"Double Décharge", 9}, {"Double Laser", 9}, {"Douche Froide", 9}, {"Décalquage", 9}, {"Décharnement", 9}, {"Dérapage", 9}, {"Fulgurayon", 9}, {"Génusection", 9}, {"Grand Nettoyage", 9}, {"Habanerage", 9}, {"Hommage Posthume", 9}, {"Hydrovapeur", 9}, {"Hyperceuse", 9}, {"Indignition", 9}, {"Lame en Peine", 9}, {"Lame Psychique", 9}, {"Lame Puissante", 9}, {"Lame Tachyonique", 9}, {"Laser Hasard", 9}, {"Lumino-Impact", 9}, {"Lune Rouge", 9}, {"Magie Florale", 9}, {"Marteau Mastoc", 9}, {"Massue Liane", 9}, {"Mortier Matcha", 9}, {"Neigeux de Mots", 9}, {"Nitro Crash", 9}, {"Piège de Fil", 9}, {"Plat du Jour", 9}, {"Pluie Térastrale", 9}, {"Poing de Colère", 9}, {"Poing Sonique", 9}, {"Pression Extrême", 9}, {"Prio-Parade", 9}, {"Prolifération", 9}, {"Queulonage", 9}, {"Rempart Brûlant", 9}, {"Ruée d'Or", 9}, {"Salaison", 9}, {"Second Souffle", 9}, {"Talon-Marteau", 9}, {"Taurogne", 9}, {"Téra Explosion", 9}, {"Toupie Éclat", 9}, {"Tranch'Aqua", 9}, {"Triple Plongeon", 9}, {"Turbo Volt", 9}, {"Vif Éclair", 9}, {"Vindicte", 9}, {"Voix Envoûtante", 9}, {"Volt Assaut", 9}
		};
		
		for (int i = 0; i < temporaryDict.length; i++) {
			if (attackName.equals(temporaryDict[i][0])) {
				return (int) temporaryDict[i][1];
			}
		}
		
		System.err.println("Génération non trouvée pour la capacité " + attackName + ".");
		return 0;
	}
	
	// Returns a list of attacks absent from a specific pair of games
	static String[] getUnavailableAttacks (String games) {
		switch (games) {
			case ("SL"):
				return new String[] {"Écrous d'Poing", "Évo-Chardasso", "Évo-Congélo", "Évo-Dynamo", "Évo-Écolo", "Évo-Fabulo", "Évo-Flambo", "Évo-Psycho", "Évo-Ténébro", "Évo-Thalasso", "Lumière du Néant", "Pika-Fracas", "Pika-Piqué", "Pika-Splash", "Pika-Sprint", "Apocalypsis Luminis", "Caboche-Kaboum", "Dracacophonie Flamboyante", "Hélio-Choc Dévastateur", "Hurlement des Roches-Lames", "Patati-Patattrape", "Photo-Geyser", "Plasma Punch", "Rayons Séléno-Explosifs"};
			case ("USUL"):
				return new String[] {"Écrous d'Poing", "Évo-Chardasso", "Évo-Congélo", "Évo-Dynamo", "Évo-Écolo", "Évo-Fabulo", "Évo-Flambo", "Évo-Psycho", "Évo-Ténébro", "Évo-Thalasso", "Lumière du Néant", "Pika-Fracas", "Pika-Piqué", "Pika-Splash", "Pika-Sprint"};
			case ("LGPE"):
				return new String[] {"À la Queue", "Aboiement", "Acrobatie", "Acupression", "Aéroblast", "Aéropique", "Affilage", "Aiguisage", "Aile d'Acier", "Air Veinard", "Aire d'Eau", "Aire d'Herbe", "Aire de Feu", "Allègement", "Amass'Sable", "Ampleur", "Ancrage", "Anneau Hydro", "Anti-Air", "Anti-Brume", "Anti-Soin", "Apocalypse Gigalithique", "Apocalypsis Luminis", "Appel Attaque", "Appel Défense", "Appel des Ombres Éternelles", "Appel Soins", "Après Vous", "Aqua-Brèche", "Aria de l'Écume", "Aromathérapie", "Arrogance", "Assistance", "Assurance", "Astuce Force", "Atout", "Attraction", "Attrition", "Aurasphère", "Aurore", "Avalanche", "Avale", "Babil", "Balance", "Balayette", "Ball'Brume", "Ball'Glace", "Ball'Météo", "Balle Graine", "Bang Sonique", "Barrage", "Baston", "Bec-Canon", "Blabla Dodo", "Blockhaus", "Bombaimant", "Bombe Acide", "Boost", "Botte Sucrette", "Bouclier Royal", "Boue-Bombe", "Boule Élek", "Boule Pollen", "Boule Roc", "Brouhaha", "Brume Capiteuse", "Bulldoboule", "Caboche-Kaboum", "Cadeau", "Calcination", "Camaraderie", "Camouflage", "Canon Floral", "Canon Graine", "Carapiège", "Carnareket", "Cauchemar", "Cavalerie Lourde", "Célébration", "Centrifugifle", "Champ Brumeux", "Champ Électrifié", "Champ Herbu", "Champ Psychique", "Change Éclair", "Chant Antique", "Chant Canon", "Chaos Draconique", "Charge Foudre", "Charge-Os", "Chargeur", "Charme", "Châtiment", "Chatouille", "Chgt Vitesse", "Choc Météore", "Choc Psy", "Choc Venin", "Chute Glace", "Chute Libre", "Clairvoyance", "Clepto-Mânes", "Close Combat", "Cocon Fatal", "Cogne", "Cognobidon", "Colère du Gardien d'Alola", "Combo Hyper-Furie", "Confidence", "Contre", "Conversion 2", "Copie Type", "Coquilame", "Corps Perdu", "Cotogarde", "Coud'Boue", "Coup d'Jus", "Coup Double", "Coup Varia-Type", "Coup Victoire", "Coup-Croix", "Coupe Psycho", "Cradovague", "Crève-Cœur", "Crochet Venin", "Croco Larme", "Crocs Éclair", "Crocs Feu", "Crocs Givre", "Danse Draco", "Danse du Feu", "Danse Éveil", "Danse Pluie", "Danse-Folle", "Danse-Lune", "Danse-Plume", "Dard Mortel", "Dark Body Press", "Dark Lariat", "Dégommage", "Déluge Causti-Toxique", "DélugePlasmique", "Dépit", "Dernier Mot", "Dernier Recours", "Détection", "Détrempage", "Détricanon", "Distorsion", "Don Naturel", "Double Baffe", "Doux Baiser", "Doux Parfum", "Dracacophonie Flamboyante", "Draco Ascension", "Draco Météore", "Draco-Marteau", "Dracocharge", "Dracogriffe", "Dracosouffle", "Dynamopoing", "Ébullilave", "Échange", "Échange Psy", "Écho", "Éclair Croix", "Éclair Fou", "Éclair Gelé", "Éclate Griffe", "Éclate-Roc", "Éco-Sphère", "Effort", "Élecanon", "Électacle", "Électrikipik", "Électrisation", "Électro-Surf Survolté", "Embargo", "Encornebois", "Engrenage", "Enroulement", "Ère Glaciaire", "Éructation", "Éruption", "Éruption Géo-Sismique", "Escalade", "Escarmouche", "Essorage", "Estocorne", "Étincelle", "Étonnement", "Étrennes", "Exécu-Son", "Exploforce", "Explonuit", "Extrasenseur", "Fauche-Âme des Sept Étoiles", "Faux-Chage", "Feinte", "Fertilisation", "Feu d'Enfer", "Feu Ensorcelé", "Feu Glacé", "Feu Sacré", "Feuillage", "Feuille Magik", "Fil Toxique", "Flair", "Flamme Bleue", "Flamme Croix", "Flamme Ultime", "Flatterie", "Fléau", "Flying Press", "Force Ajoutée", "Force Cachée", "Force Chtonienne", "Force Cosmik", "Force-Nature", "Forte-Paume", "Fouet de Feu", "Fracass'Tête", "Frappe Psy", "Frotte-Frimousse", "Frustration", "Fulguro-Lance Gigavolt", "Fulmifer", "Fulmigraine", "Fureur des Plumes Spectrales", "Furie Dimension", "Furie-Bond", "Garde Florale", "Garde Large", "Gare au Ronflex", "Géo-Contrôle", "Giclédo", "Giga Impact", "Giga-Sangsue", "Giga-Tonnerre", "Glaciation", "Glas de Soin", "Gravité", "Grêle", "Gribouille", "Griffe Acier", "Griffe Ombre", "Grimace", "Grondement", "Gyroballe", "Halloween", "Hantise", "Harcèlement", "Hélio-Choc Dévastateur", "Hurle-Temps", "Hurlement des Roches-Lames", "Hydroblast", "Hydroqueue", "Imitation", "Impact Choupinova", "Implore", "Incendie", "Interversion", "Ire de la Nature", "Jet de Vapeur", "Jugement", "Lait à Boire", "Lame de Roc", "Lame Ointe", "Lame Pangéenne", "Lame Sainte", "Lame Solaire", "Lame-Feuille", "Lance-Boue", "Lancécrou", "Larcin", "Larme à l'Œil", "Laser Cryogénique", "Laser Prisme", "Lévikinésie", "Lire-Esprit", "Lumi-Éclat", "Lumière du Néant", "Lumiqueue", "Lyophilisation", "Mach Punch", "Magné-Contrôle", "Mains Jointes", "Malédiction", "Maléfice Sylvain", "Marteau de Glace", "Marto-Poing", "Martobois", "Mégaphone", "Miroi-Tir", "Mitra-Poing", "Moi d'Abord", "Mort-Ailes", "Mur de Fer", "Myria-Flèches", "Myria-Vagues", "Neuf pour Un", "Nitrocharge", "Nœud Herbe", "Nuée de Poudre", "Ocroupi", "Octazooka", "Œil Miracle", "Ombre Portée", "Onde de Choc", "Onde Originelle", "Onde Vide", "Ondes Étranges", "Orage Adamantin", "Os'Ombre", "Ouragan", "Par Ici", "Parabocharge", "Paresse", "Partage Force", "Partage Garde", "Passe-Cadeau", "Passe-Passe", "Patati-Patattrape", "Peignée", "Permucœur", "Permuforce", "Permugarde", "Permuvitesse", "Pétalexplosion Éblouissante", "Photo-Geyser", "Photocopie", "Phytomixeur", "Pico-Défense", "Picore", "Picots", "Pics Toxik", "Pied Brûleur", "Piège de Venin", "Piétisol", "Pikachute Foudroyante", "Piqué Supersonique", "Piqûre", "Pisto-Poing", "Plasma Punch", "Plongée", "Plumo-Queue", "Poing Boost", "Poing Dard", "Poing Météore", "Poing Ombre", "Poison-Croix", "Poliroche", "Possessif", "Poudre Fureur", "Poudreuse", "Poursuite", "Pouvoir Antique", "Prélèvem. Destin", "Prescience", "Presse", "Prévention", "Projecteur", "Projection", "Psycho Boost", "Psycho-Croc", "Psycho-Pulvérisation EX", "Psykoud'Boul", "Puissance Cachée", "Punition", "Purification", "Pyro-Explosion Cataclysmique", "Queue-Poison", "Racines", "Rafale Feu", "Râle Mâle", "Rancune", "Rapace", "Rayon Chargé", "Rayon Gemme", "Rayon Lune", "Rayon Signal", "Rayon Simple", "Rayon Spectral", "Rayons Séléno-Explosifs", "Rebond", "Rebondifeu", "Recyclage", "Reflet Magik", "Regard Noir", "Regard Touchant", "Régénération", "Relâche", "Relais", "Rengorgement", "Renversement", "Représailles", "Requiem", "Retenue", "Retour", "Réveil Forcé", "Revenant", "Roc-Boulet", "Ronflement", "Roue de Feu", "Roulade", "Rune Protect", "Sabotage", "Saisie", "Sanction Suprême", "Saumure", "Séduction", "Sheauriken", "Siffl'Herbe", "Siphon", "Soin Floral", "Sommation", "Soucigraine", "Souffle Glacé", "Souvenir", "Spatio-Rift", "Spore Coton", "Stalagtite", "Stimulant", "Stockage", "Stratopercut", "Strido-Son", "Suc Digestif", "Super Tourbillon Abyssal", "Supernova Originelle", "Surchauffe", "Survinsecte", "Symphonie des Ondines", "Synchropeine", "Synthèse", "Tacle Feu", "Tacle Lourd", "Taillade", "Tatamigaeshi", "Techno-Buster", "Telluriforce", "Tempête de Sable", "Tempête Florale", "Tempête Verte", "Ten-danse", "Ténacité", "Tête de Fer", "Tir de Boue", "Tisse Ombre", "Toile", "Toile Élek", "Toile Gluante", "Tomberoche", "Tour Rapide", "Tourbi-Sable", "Tourmagik", "Tourmente", "Tourniquet", "Tout ou Rien", "Tranch'Air", "Tranche-Nuit", "Trépignement", "Triple Pied", "Trou Noir", "Trou Noir des Ombres", "TrouDimensionnel", "Turbo-Charge Bulldozer", "Vampibaiser", "Vampipoing", "Vantardise", "Végé-Attak", "Vendetta", "Vengeance", "Vent Argenté", "Vent Arrière", "Vent Féérique", "Vent Glace", "Vent Mauvais", "Vent Violent", "Verrou Enchanté", "Verrouillage", "Vibra Soin", "Vibraqua", "Vibrécaille", "Vif Roc", "Vigilance", "Vitesse Extrême", "Vœu", "Vœu Soin", "Voile Aurore", "Voix Enjôleuse", "Vol Magnétik", "Vol-Force", "Vortex Magma", "Vrille Maximum", "Yama Arashi", "Zénith", "Zone Étrange", "Zone Magique"};
			case ("EB"):
				return new String[] {"Affûtage", "Ailes Psycho", "Air Veinard", "Ampleur", "Anti-Soin", "Apocalypse Gigalithique", "Apocalypsis Luminis", "Appel des Ombres Éternelles", "Appel Soins", "Aquatacle", "Assaut Frontal", "Assistance", "Atout", "Attrition", "Babil", "Ball'Glace", "Bec-Canon", "Bise Glaciaire", "Bombe Aimant", "Bombe Œuf", "Bouclier", "Boue-Bombe", "Bulldoboule", "Camouflage", "Cauchemar", "Chant Antique", "Chaos Draconique", "Chute Libre", "Clairvoyance", "Claquoir", "Cocon Fatal", "Cœur de Rancœur", "Colère du Gardien d'Alola", "Combo Hyper-Furie", "Constriction", "Cortège Funèbre", "Coupe-Vent", "Crève-Cœur", "Croc de Mort", "Danse Éveil", "Danse Victoire", "Dark Body Press", "Déluge Causti-Toxique", "Déluge Plasmique", "Don Naturel", "Double Dard", "Dracacophonie Flamboyante", "Draco-Rage", "Échange Force", "Écume", "Électro-Surf Survolté", "Embargo", "Éruption Géo-Sismique", "Escalade", "Essorage", "Évo-Chardasso", "Évo-Congélo", "Évo-Dynamo", "Évo-Écolo", "Évo-Fabulo", "Évo-Flambo", "Évo-Psycho", "Évo-Ténébro", "Évo-Thalasso", "Extravaillance", "Fauche-Âme des Sept Étoiles", "Feinte", "Fertilisation", "Fil Toxique", "Flair", "Flash", "Force Cachée", "Force Mystique", "Frénésie", "Frustration", "Fulguro-Lance Gigavolt", "Fulmigraine", "Fureur des Plumes Spectrales", "Furie Dimension", "Gare au Ronflex", "Giga-Tonnerre", "Grand Courroux", "Gribouille", "Griffes Funestes", "Hache de Pierre", "Hélio-Choc Dévastateur", "Herblast", "Hurlement des Roches-Lames", "Impact Choupinova", "Jugement", "Lance-Boue", "Laser Cryogénique", "Lévikinésie", "Lumi-Queue", "Lumière du Néant", "Marteau de Glace", "Massd'Os", "Mawashi Geri", "Mimique", "Miroi-Tir", "Moi d'Abord", "Multitoxik", "Mur Fumigène", "Neuf pour Un", "Nuée de Poudre", "Œil Miracle", "Passe-Cadeau", "Patati-Patattrape", "Patience", "Permucœur", "Pétalexplosion Éblouissante", "Picanon", "Pied Sauté", "Pika-Fracas", "Pika-Piqué", "Pika-Splash", "Pika-Sprint", "Pikachute Foudroyante", "Pilonnage", "Piqué Supersonique", "Poing Comète", "Poing Dard", "Poing Karaté", "Poursuite", "Prière Lunaire", "Projecteur", "Psycho-Boost", "Psycho-Pulvérisation EX", "Puissance Cachée", "Punition", "Pyro-Explosion Cataclysmique", "Rayon Signal", "Rayons Séléno-Explosifs", "Rebondifeu", "Régénération", "Retour", "Réveil Forcé", "Saisie", "Séduction", "Siffl'Herbe", "Sonic Boom", "Sprint Bouclier", "Stimulant", "Stratopercut", "Super Tourbillon Abyssal", "Supernova Originelle", "Symphonie des Ondines", "Synchropeine", "Toile", "Torgnoles", "Tourniquet", "Triple Flèche", "Trou Noir", "Trou Noir des Ombres", "TrouDimensionnel", "Turbo-Charge Bulldozer", "Typhon Fulgurant", "Typhon Hivernal", "Typhon Passionné", "Typhon Pyrosable", "Uppercut", "Vague Psy", "Vagues à Lames", "Vent Argenté", "Vent Mauvais", "Vrille Maximum", "Yoga"};
			case ("DEPS"):
				return new String[] {"Abattage", "Acide Malique", "Aegis Maxima", "Aéromax", "Affûtage", "Ailes Psycho", "Air Veinard", "Aire d'Eau", "Aire d'Herbe", "Aire de Feu", "Amass'Sable", "Ampleur", "Ancrage", "Anti-Soin", "Apocalypse Gigalithique", "Apocalypsis Luminis", "Appel des Ombres Éternelles", "Appel Soins", "Aquatacle", "Aria de l'Écume", "Arrogance", "Assaut Frontal", "Assistance", "Atout", "Attrition", "Ball'Glace", "Ballon Brûlant", "Bec-Canon", "Bise Glaciaire", "Blocage", "Blockhaus", "Bombe Aimant", "Bombe Œuf", "Botte Sucrette", "Bouclier", "Bouclier Royal", "Boue-Bombe", "Boule Pollen", "Branchicrok", "Bulldoboule", "Bulles G-Max", "Caboche-Kaboum", "Câlin G-Max", "Camouflage", "Canon Dynamax", "Canon Floral", "Canonnade G-Max", "Carapiège", "Cauchemar", "Célébration", "Cent Rancunes", "Centrifugifle", "Champlification", "Change-Côté", "Chant Antique", "Chaos Draconique", "Charge Foudre", "Chgt Vitesse", "Choc Émotionnel", "Choc G-Max", "Choc Météore", "Chute Libre", "Clairvoyance", "Claquoir", "Clepto-Mânes", "Coaching", "Cocon Fatal", "Cœur de Rancœur", "Colère du Gardien d'Alola", "Combo Hyper-Furie", "Combustion G-Max", "Constriction", "Corrosion G-Max", "Cortège Funèbre", "Coup Final G-Max", "Coup Fulgurant", "Coup Varia-Type", "Coup Victoire", "Coupe-Vent", "Crève-Cœur", "Croc de Mort", "Croque Fort", "Cryomax", "Cure G-Max", "Danse du Feu", "Danse Éveil", "Danse Victoire", "Dark Body Press", "Dark Lariat", "Déluge Causti-Toxique", "Déluge Plasmique", "Don Naturel", "Double Dard", "Double Volée", "Dracacophonie", "Dracacophonie Flamboyante", "Draco-Énergie", "Draco-Flèches", "Draco-Rage", "Dracomax", "Eau Revoir", "Échange Force", "Éclair Croix", "Éclair Gelé", "Éclat Spectral", "Écrous d'Poing", "Écume", "Électrikipik", "Électrisation", "Électro-Surf Survolté", "Embargo", "Enchantomax", "Encornebois", "Engrenage", "Enlisement G-Max", "Ère Glaciaire", "Éruption Géo-Sismique", "Escarmouche", "Esprit Frappeur", "Essorage", "Étrennes", "Évo-Chardasso", "Évo-Congélo", "Évo-Dynamo", "Évo-Écolo", "Évo-Fabulo", "Évo-Flambo", "Évo-Psycho", "Évo-Ténébro", "Évo-Thalasso", "Explo-Brume", "Explonuit", "Extravaillance", "Fauche-Âme des Sept Étoiles", "Feinte", "Fertilisation", "Feu Envieux", "Feu Glacé", "Flair", "Flamme Bleue", "Flamme Croix", "Flying Press", "Fonte G-Max", "Force Cachée", "Force Chtonienne", "Force G", "Force Mystique", "Foudre G-Max", "Fouet de Feu", "Fouet G-Max", "Fourbette", "Fournaise G-Max", "Frappe G-Max", "Frénésie", "Frustration", "Fulguro-Lance Gigavolt", "Fulguromax", "Fureur Ardente", "Fureur des Plumes Spectrales", "Furie Dimension", "Gâchette G-Max", "Garde-à-Joues", "Gardomax", "Gare au Ronflex", "Gaz Corrosif", "Géo-Contrôle", "Giga-Tonnerre", "Gladius Maximus", "Gliss'Herbe", "Goudronnage", "Grand Courroux", "Griffes Funestes", "Hache de Pierre", "Halloween", "Hantise G-Max", "Hélio-Choc Dévastateur", "Herblast", "Hurlement des Roches-Lames", "Hydromax", "Illusion G-Max", "Impact Choupinova", "Incendie", "Insectomax", "Ire de la Nature", "Jet de Vapeur", "Joute Astrale", "Kokiyarme", "Lame Ointe", "Lame Sainte", "Lame Solaire", "Lance de Glace", "Lance-Boue", "Lancécrou", "Laser Cryogénique", "Laser Infinimax", "Laser Météore", "Laser Prisme", "Lévikinésie", "Lithomax", "Lumière du Néant", "Mains Jointes", "Maléfice Sylvain", "Marteau de Glace", "Massd'Os", "Mawashi Geri", "Métalaser", "Métalliroue", "Métallomax", "Mimique", "Miroi-Tir", "Moi d'Abord", "Monte-Tension", "Mort'Ailes", "Multicoup G-Max", "Multitoxik", "Mur Fumigène", "Myria-Flèches", "Myria-Vagues", "Nappage", "Nectar G-Max", "Neuf pour Un", "Normalomax", "Nuée de Poudre", "Octoprise", "Œil Miracle", "Ondes G-Max", "Orage Adamantin", "Os Ombre", "Overdrive", "Pactole G-Max", "Parabocharge", "Passe-Cadeau", "Patati-Patattrape", "Patience", "Peignée", "Percée G-Max", "Percussion G-Max", "Permuvitesse", "Pestilence G-Max", "Pétalexplosion Éblouissante", "Photo-Geyser", "Phytomax", "Picanon", "Pied Sauté", "Pika-Fracas", "Pika-Piqué", "Pika-Splash", "Pika-Sprint", "Pikachute Foudroyante", "Pilonnage", "Piqué Supersonique", "Plasma Punch", "Plumo-Queue", "Poing Comète", "Poing Dard", "Poing Karaté", "Poing Obscur", "Poudre Magique", "Poursuite", "Prière Lunaire", "Prise de Bec", "Projecteur", "Psycho-Croc", "Psycho-Pulvérisation EX", "Psychomax", "Pugilomax", "Punition", "Purification", "Pyro-Explosion Cataclysmique", "Pyroball G-Max", "Pyromax", "Rafale Écailles", "Rafale G-Max", "Ravage Rampant", "Rayon Signal", "Rayon Spectral", "Rayons Séléno-Explosifs", "Rebondifeu", "Récif G-Max", "Récolte G-Max", "Regard Glaçant", "Régénération", "Renversement", "Résonance G-Max", "Retenue", "Retour", "Réveil Forcé", "Roue Libre", "Sable Ardent", "Saisie", "Sanction Suprême", "Séduction", "Selve Salvatrice", "Sentence G-Max", "Sheauriken", "Siffl'Herbe", "Sinistromax", "Sismomax", "Soin Floral", "Sommation", "Sonic Boom", "Sort Sinistre", "Spectromax", "Sprint Bouclier", "Stimulant", "Stratopercut", "Super Tourbillon Abyssal", "Supernova Originelle", "Symphonie des Ondines", "Synchropeine", "Tacle Feu", "Tambour Battant", "Tapotige", "Tatamigaeshi", "Techno-Buster", "Téphra G-Max", "Thérémonie", "Tir de Précision", "Tisse Ombre", "Toile", "Toile Élek", "Torgnoles", "Torpeur G-Max", "Torrent de Coups", "Tourniquet", "Toxinomax", "Triple Axel", "Triple Flèche", "Troquenard", "Trou Noir des Ombres", "TrouDimensionnel", "Turbo-Charge Bulldozer", "Typhon Fulgurant", "Typhon Hivernal", "Typhon Passionné", "Typhon Pyrosable", "Ultime Bastion", "Uppercut", "Usure G-Max", "Vague Psy", "Vagues à Lames", "Vapeur Féérique", "Vaste Pouvoir", "Vent Argenté", "Vent Mauvais", "Verrou Enchanté", "Vibrécaille", "Vif Roc", "Vigilance", "Voltageôle", "Vrille Maximum", "Yoga"};
			case ("LPA"):
				return new String[] {"À la Queue", "Abattage", "Abîme", "Abri", "Acide", "Acide Malique", "Acrobatie", "Acupression", "Aegis Maxima", "Aéroblast", "Aéromax", "Affilage", "Affûtage", "Aiguisage", "Ailes d'Acier", "Air Veinard", "Aire d'Eau", "Aire d'Herbe", "Aire de Feu", "Allègement", "Amass'Sable", "Amnésie", "Ampleur", "Ancrage", "Anneau Hydro", "Anti-Air", "Anti-Brume", "Anti-Soin", "Apocalypse Gigalithique", "Apocalypsis Luminis", "Appel Attaque", "Appel Défense", "Appel des Ombres Éternelles", "Appel Soins", "Après Vous", "Aria de l'Écume", "Armure", "Aromathérapie", "Arrogance", "Assistance", "Assurance", "Astuce Force", "Atout", "Attraction", "Attrition", "Aurore", "Avalanche", "Avale", "Babil", "Bâillement", "Bain de Smog", "Balance", "Balayage", "Balayette", "Ball'Brume", "Ball'Météo", "Balle Graine", "Ballon Brûlant", "Bang Sonique", "Barrage", "Baston", "Bec Vrille", "Bec-Canon", "Bélier", "Berceuse", "Big Splash", "Blabla Dodo", "Blocage", "Blockhaus", "Bluff", "Bombe Aimant", "Bombe Œuf", "Boost", "Botte Sucrette", "Bouclier", "Bouclier Royal", "Boul'Armure", "Boule Élek", "Boule Pollen", "Boule Roc", "Branchicrok", "Brouhaha", "Brouillard", "Brume", "Brume Capiteuse", "Buée Noire", "Bulldoboule", "Bulles d'O", "Bulles G-Max", "Caboche-Kaboum", "Cadeau", "Calcination", "Câlin G-Max", "Camaraderie", "Camouflage", "Canicule", "Canon Dynamax", "Canon Floral", "Canon Graine", "Canonnade G-Max", "Carapiège", "Cascade", "Casse-Brique", "Cauchemar", "Célébration", "Cent Rancunes", "Centrifugifle", "Champ Brumeux", "Champ Électrifié", "Champ Herbu", "Champ Psychique", "Champlification", "Change Éclair", "Change-Côté", "Chant Antique", "Chant Canon", "Chaos Draconique", "Charge Foudre", "Charge Os", "Chargeur", "Charme", "Chatouille", "Chgt Vitesse", "Choc Émotionnel", "Choc G-Max", "Choc Météore", "Choc Psy", "Chute Libre", "Clairvoyance", "Claquoir", "Clepto-Mânes", "Clonage", "Coaching", "Cocon Fatal", "Cogne", "Cognobidon", "Colère du Gardien d'Alola", "Combo Hyper-Furie", "Combo-Griffe", "Combustion G-Max", "Confidence", "Constriction", "Contre", "Conversion", "Conversion 2", "Copie-Type", "Coqui-Lame", "Corps Perdu", "Corrosion G-Max", "Cotogarde", "Coud'Krâne", "Coup Bas", "Coup Croix", "Coup d'Boule", "Coup d'Jus", "Coup d'Main", "Coup Final G-Max", "Coup Fulgurant", "Coup Varia-Type", "Coup Victoire", "Coupe", "Coupe-Vent", "Cradovague", "Crève-Cœur", "Croc de Mort", "Croc Fatal", "Crochet Venin", "Croco Larme", "Croissance", "Croque Fort", "Cru-Ailes", "Cryomax", "Cure G-Max", "Cyclone", "Danse Draco", "Danse du Feu", "Danse Éveil", "Danse Flammes", "Danse Folle", "Danse Lune", "Danse Pluie", "Danse Plumes", "Dard Mortel", "Dark Body Press", "Dark Lariat", "Dégommage", "Déluge Causti-Toxique", "Déluge Plasmique", "Demi-Tour", "Dépit", "Dernier Mot", "Dernier Recours", "Détection", "Détrempage", "Détricanon", "Détritus", "Dévorêve", "Distorsion", "Don Naturel", "Double Baffe", "Double Dard", "Double Pied", "Double Volée", "Doux Baiser", "Doux Parfum", "Dracacophonie", "Dracacophonie Flamboyante", "Draco-Ascension", "Draco-Charge", "Draco-Énergie", "Draco-Flèches", "Draco-Marteau", "Draco-Queue", "Draco-Rage", "Draco-Souffle", "Dracomax", "Dynamo-Poing", "Eau Revoir", "Ébullilave", "Ébullition", "Échange", "Échange Psy", "Écho", "Éclair Croix", "Éclair Gelé", "Éclat Spectral", "Éclate Griffe", "Écras'Face", "Écrasement", "Écrous d'Poing", "Effort", "Élecanon", "Électrikipik", "Électrisation", "Électro-Surf Survolté", "Embargo", "Empal'Korne", "Enchantomax", "Encore", "Encornebois", "Engrenage", "Enlisement G-Max", "Enroulement", "Entrave", "Ère Glaciaire", "Éructation", "Éruption", "Éruption Géo-Sismique", "Escalade", "Escarmouche", "Esprit Frappeur", "Essorage", "Estocorne", "Étreinte", "Étrennes", "Évo-Chardasso", "Évo-Congélo", "Évo-Dynamo", "Évo-Écolo", "Évo-Fabulo", "Évo-Flambo", "Évo-Psycho", "Évo-Ténébro", "Évo-Thalasso", "Exécu-Son", "Explo-Brume", "Exploforce", "Explonuit", "Explosion", "Exuviation", "Façade", "Fauche-Âme des Sept Étoiles", "Feinte", "Fertilisation", "Feu d'Enfer", "Feu Envieux", "Feu Follet", "Feu Glacé", "Feu Sacré", "Fil Toxique", "Flair", "Flamme Bleue", "Flamme Croix", "Flamme Ultime", "Flash", "Flatterie", "Flying Press", "Fontaine de Vie", "Fonte G-Max", "Force", "Force Ajoutée", "Force Cachée", "Force Chtonienne", "Force Cosmique", "Force G", "Force Nature", "Force Poigne", "Forte-Paume", "Foudre G-Max", "Fouet de Feu", "Fouet G-Max", "Fouet Lianes", "Fourbette", "Fournaise G-Max", "Frappe Atlas", "Frappe G-Max", "Frappe Psy", "Frénésie", "Frotte-Frimousse", "Frustration", "Fulguro-Lance Gigavolt", "Fulguromax", "Fulmifer", "Fureur Ardente", "Fureur des Plumes Spectrales", "Furie", "Furie Dimension", "Furie-Bond", "Gâchette G-Max", "Garde Florale", "Garde Large", "Garde-à-Joues", "Gardomax", "Gare au Ronflex", "Gaz Corrosif", "Géo-Contrôle", "Giclédo", "Giga-Sangsue", "Giga-Tonnerre", "Gigotage", "Glaciation", "Gladius Maximus", "Glas de Soin", "Gliss'Herbe", "Goudronnage", "Gravité", "Grêle", "Gribouille", "Griffe", "Griffe Acier", "Grimace", "Grincement", "Grobisou", "Grondement", "Groz'Yeux", "Guillotine", "Gyroballe", "Halloween", "Hantise", "Hantise G-Max", "Harcèlement", "Hâte", "Hélio-Choc Dévastateur", "Hurlement", "Hurlement des Roches-Lames", "Hydroblast", "Hydromax", "Illusion G-Max", "Imitation", "Impact Choupinova", "Implore", "Incendie", "Insectomax", "Interversion", "Ire de la Nature", "Jackpot", "Jet de Sable", "Jet de Vapeur", "Jet-Pierres", "Joute Astrale", "Kokiyarme", "Koud'Korne", "Lait à Boire", "Lame Ointe", "Lame Pangéenne", "Lame Sainte", "Lame Solaire", "Lance de Glace", "Lance-Boue", "Lance-Soleil", "Lancécrou", "Larcin", "Larme à l'Œil", "Laser Cryogénique", "Laser Infinimax", "Laser Météore", "Laser Prisme", "Léchouille", "Lévikinésie", "Lien du Destin", "Ligotage", "Lilliput", "Lire-Esprit", "Lithomax", "Lumi-Éclat", "Lumi-Queue", "Lumière du Néant", "Lyophilisation", "Magné-Contrôle", "Mains Jointes", "Malédiction", "Maléfice Sylvain", "Mania", "Marteau de Glace", "Marto-Poing", "Massd'Os", "Mawashi Geri", "Méga-Sangsue", "Mégafouet", "Mégaphone", "Métalliroue", "Métallomax", "Métronome", "Mimi-Queue", "Mimique", "Miroi-Tir", "Mitra-Poing", "Moi d'Abord", "Monte-Tension", "Morphing", "Mort'Ailes", "Multicoup G-Max", "Mur Lumière", "Myria-Flèches", "Myria-Vagues", "Nappage", "Nectar G-Max", "Neuf pour Un", "Nitrocharge", "Nœud Herbe", "Normalomax", "Nuée de Poudre", "Ocroupi", "Octoprise", "Œil Miracle", "Ombre Nocturne", "Onde Boréale", "Onde de Choc", "Onde Folie", "Onde Originelle", "Onde Vide", "Ondes Étranges", "Ondes G-Max", "Orage Adamantin", "Os Ombre", "Osmerang", "Overdrive", "Pactole G-Max", "Papillodanse", "Par Ici", "Parabocharge", "Paresse", "Partage Force", "Partage Garde", "Passe-Cadeau", "Passe-Passe", "Patati-Patattrape", "Patience", "Peignée", "Percée G-Max", "Percussion G-Max", "Permucœur", "Permuforce", "Permugarde", "Permuvitesse", "Pestilence G-Max", "Pétalexplosion Éblouissante", "Photo-Geyser", "Photocopie", "Phytomax", "Phytomixeur", "Picanon", "Pico-Défense", "Picore", "Picpic", "Pics Toxik", "Pied Brûleur", "Pied Sauté", "Pied Voltige", "Piège de Venin", "Pika-Fracas", "Pika-Piqué", "Pika-Splash", "Pika-Sprint", "Pikachute Foudroyante", "Pilonnage", "Pince-Masse", "Piqué", "Piqué Supersonique", "Piqûre", "Pistolet à O", "Plaquage", "Plasma Punch", "Plongée", "Plumo-Queue", "Poing Boost", "Poing Comète", "Poing Dard", "Poing Karaté", "Poing Météore", "Poing Obscur", "Poing Ombre", "Poliroche", "Possessif", "Poudre Fureur", "Poudre Magique", "Poursuite", "Prescience", "Prévention", "Prise de Bec", "Projecteur", "Projection", "Protection", "Provoc", "Psycho-Boost", "Psycho-Croc", "Psycho-Pulvérisation EX", "Psychomax", "Pugilomax", "Punition", "Purédpois", "Purification", "Pyro-Explosion Cataclysmique", "Pyroball G-Max", "Pyromax", "Queue-Poison", "Racines", "Rafale Écailles", "Rafale Feu", "Rafale G-Max", "Rafale Psy", "Râle Mâle", "Rancune", "Ravage Rampant", "Rayon Lune", "Rayon Signal", "Rayon Simple", "Rayon Spectral", "Rayons Séléno-Explosifs", "Rebond", "Rebondifeu", "Récif G-Max", "Récolte G-Max", "Recyclage", "Reflet", "Reflet Magik", "Regard Glaçant", "Regard Médusant", "Regard Noir", "Régénération", "Relâche", "Relais", "Rengorgement", "Renversement", "Repli", "Représailles", "Requiem", "Résonance G-Max", "Retenue", "Retour", "Réveil Forcé", "Riposte", "Roc-Boulet", "Ronflement", "Roue Libre", "Rugissement", "Rune Protect", "Ruse", "Sable Ardent", "Sabotage", "Sacrifice", "Saisie", "Sanction Suprême", "Saumure", "Sécrétion", "Séduction", "Séisme", "Selve Salvatrice", "Sentence G-Max", "Sheauriken", "Siffl'Herbe", "Sinistromax", "Siphon", "Sismomax", "Soin Floral", "Sommation", "Sonic Boom", "Sort Sinistre", "Soucigraine", "Souffle Glacé", "Souplesse", "Souvenir", "Spectromax", "Spore Coton", "Stalactite", "Stimulant", "Stockage", "Stratopercut", "Strido-Son", "Suc Digestif", "Super Tourbillon Abyssal", "Supernova Originelle", "Surf", "Surpuissance", "Symphonie des Ondines", "Synchropeine", "Synthèse", "Tacle Feu", "Tacle Lourd", "Taillade", "Tambour Battant", "Tapotige", "Tatamigaeshi", "Techno-Buster", "Télékinésie", "Tempête de Sable", "Tempête Florale", "Ten-Danse", "Ténacité", "Téphra G-Max", "Thérémonie", "Tir de Boue", "Tir de Précision", "Tisse Ombre", "Toile", "Toile Élek", "Toile Gluante", "Tomberoche", "Torgnoles", "Torpeur G-Max", "Torrent de Coups", "Tour de Magie", "Tour Rapide", "Tourbi-Sable", "Tourmente", "Tourniquet", "Tout ou Rien", "Toxik", "Toxinomax", "Tranch'Herbe", "Trépignement", "Tricherie", "Triple Axel", "Triple Pied", "Troquenard", "Trou Noir des Ombres", "TrouDimensionnel", "Tunnel", "Tunnelier", "Turbo-Charge Bulldozer", "Ultimapoing", "Ultimawashi", "Ultime Bastion", "Ultrason", "Uppercut", "Usure G-Max", "Vague Psy", "Vampigraine", "Vantardise", "Vapeur Féérique", "Vaste Pouvoir", "Végé-Attaque", "Vendetta", "Vengeance", "Vent Arrière", "Verrou Enchanté", "Verrouillage", "Vibra Soin", "Vibrécaille", "Vif Roc", "Vigilance", "Vitesse Extrême", "Vœu", "Vœu Destructeur", "Vœu Soin", "Voile Aurore", "Voile Miroir", "Voix Enjôleuse", "Vol", "Vol Magnétik", "Vole-Force", "Voltageôle", "Vrille Maximum", "Yama Arashi", "Yoga", "Zénith", "Zone Étrange", "Zone Magique"};
			case ("EV"):
				return new String[] {"Aéromax", "Affilage", "Affûtage", "Air Veinard", "Allègement", "Ampleur", "Ancrage", "Anti-Soin", "Apocalypse Gigalithique", "Apocalypsis Luminis", "Appel des Ombres Éternelles", "Appel Soins", "Aromathérapie", "Assistance", "Atout", "Attrition", "Babil", "Ball'Glace", "Blocage", "Bombe Aimant", "Bombe Œuf", "Bouclier", "Bouclier Royal", "Boue-Bombe", "Branchicrok", "Bulldoboule", "Bulles G-Max", "Caboche-Kaboum", "Câlin G-Max", "Camouflage", "Canonnade G-Max", "Carapiège", "Cauchemar", "Chaos Draconique", "Choc G-Max", "Chute Libre", "Clairvoyance", "Claquoir", "Clepto-Mânes", "Cocon Fatal", "Colère du Gardien d'Alola", "Combo Hyper-Furie", "Combustion G-Max", "Constriction", "Corps Perdu", "Corrosion G-Max", "Coud'Krâne", "Coup Final G-Max", "Coup Varia-Type", "Coup Victoire", "Coupe", "Coupe-Vent", "Crève-Cœur", "Croc de Mort", "Cryomax", "Cure G-Max", "Dark Body Press", "Déluge Causti-Toxique", "Déluge Plasmique", "Don Naturel", "Double Baffe", "Double Dard", "Dracacophonie Flamboyante", "Draco-Rage", "Dracomax", "Échange Force", "Échange Psy", "Écrous d'Poing", "Écume", "Électrisation", "Électro-Surf Survolté", "Embargo", "Enchantomax", "Engrenage", "Enlisement G-Max", "Éruption Géo-Sismique", "Escalade", "Essorage", "Évo-Chardasso", "Évo-Congélo", "Évo-Dynamo", "Évo-Écolo", "Évo-Fabulo", "Évo-Flambo", "Évo-Psycho", "Évo-Ténébro", "Évo-Thalasso", "Fauche-Âme des Sept Étoiles", "Feinte", "Fertilisation", "Flair", "Flamme Ultime", "Flash", "Fonte G-Max", "Force Cachée", "Force Chtonienne", "Force Nature", "Foudre G-Max", "Fouet G-Max", "Fournaise G-Max", "Frappe G-Max", "Frénésie", "Frustration", "Fulguro-Lance Gigavolt", "Fulguromax", "Fureur des Plumes Spectrales", "Gâchette G-Max", "Garde Florale", "Gardomax", "Gare au Ronflex", "Gaz Corrosif", "Géo-Contrôle", "Giga-Tonnerre", "Grêle", "Grobisou", "Halloween", "Hantise G-Max", "Hélio-Choc Dévastateur", "Hurlement des Roches-Lames", "Hydromax", "Illusion G-Max", "Impact Choupinova", "Incendie", "Insectomax", "Ire de la Nature", "Joute Astrale", "Lance-Boue", "Lancécrou", "Laser Cryogénique", "Laser Infinimax", "Lévikinésie", "Lire-Esprit", "Lithomax", "Lumière du Néant", "Mains Jointes", "Massd'Os", "Mawashi Geri", "Métallomax", "Mimique", "Miroi-Tir", "Moi d'Abord", "Mort'Ailes", "Multicoup G-Max", "Myria-Flèches", "Myria-Vagues", "Nectar G-Max", "Neuf pour Un", "Normalomax", "Nuée de Poudre", "Octazooka", "Octoprise", "Œil Miracle", "Ondes G-Max", "Os Ombre", "Osmerang", "Pactole G-Max", "Passe-Cadeau", "Patati-Patattrape", "Patience", "Peignée", "Percée G-Max", "Percussion G-Max", "Pestilence G-Max", "Pétalexplosion Éblouissante", "Phytomax", "Phytomixeur", "Picanon", "Pied Sauté", "Piège de Venin", "Pika-Fracas", "Pika-Piqué", "Pika-Splash", "Pika-Sprint", "Pikachute Foudroyante", "Pilonnage", "Piqué Supersonique", "Plasma Punch", "Poing Boost", "Poing Comète", "Poing Dard", "Poing Karaté", "Poursuite", "Prise de Bec", "Projecteur", "Psycho-Pulvérisation EX", "Psychomax", "Pugilomax", "Puissance Cachée", "Punition", "Purification", "Pyro-Explosion Cataclysmique", "Pyroball G-Max", "Pyromax", "Rafale G-Max", "Rancune", "Rayon Signal", "Rayons Séléno-Explosifs", "Rebondifeu", "Récif G-Max", "Récolte G-Max", "Reflet Magik", "Régénération", "Résonance G-Max", "Retenue", "Retour", "Réveil Forcé", "Sacrifice", "Saisie", "Sanction Suprême", "Séduction", "Sentence G-Max", "Siffl'Herbe", "Sinistromax", "Sismomax", "Sonic Boom", "Spectromax", "Stimulant", "Stratopercut", "Super Tourbillon Abyssal", "Supernova Originelle", "Symphonie des Ondines", "Synchropeine", "Tatamigaeshi", "Techno-Buster", "Télékinésie", "Téphra G-Max", "Toile", "Torgnoles", "Torpeur G-Max", "Tourniquet", "Toxinomax", "Troquenard", "Trou Noir des Ombres", "Turbo-Charge Bulldozer", "Uppercut", "Usure G-Max", "Vague Psy", "Vendetta", "Vent Argenté", "Vent Mauvais", "Vigilance", "Vrille Maximum", "Yama Arashi", "Yoga"};
		}
		return new String[] {};
	}
}
