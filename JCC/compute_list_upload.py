expansion	= "Lumière Triomphale"
expansion_link	= expansion # + " (JCC)"
f		= open("liste.txt", "r", encoding="utf-8")
output		= open("description_upload.txt", "w+", encoding="utf-8")
text		= f.read().split("\n")
is_english_set	= False

def de(s):
	if s[0:2] == "EX":
		return "de "
	if s[0].lower() in ["a", "e", "é", "h", "i", "o", "u", "y"]:
		return "d'"
	return "de "

pokemon = ["Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel", "Dracaufeu", "Carapuce", "Carabaffe", "Tortank", "Chenipan", "Chrysacier", "Papilusion", "Aspicot", "Coconfort", "Dardargnan", "Roucool", "Roucoups", "Roucarnage", "Rattata", "Rattatac", "Piafabec", "Rapasdepic", "Abo", "Arbok", "Pikachu", "Raichu", "Sabelette", "Sablaireau", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Mélofée", "Mélodelfe", "Goupix", "Feunard", "Rondoudou", "Grodoudou", "Nosferapti", "Nosferalto", "Mystherbe", "Ortide", "Rafflesia", "Paras", "Parasect", "Mimitoss", "Aéromite", "Taupiqueur", "Triopikeur", "Miaouss", "Persian", "Psykokwak", "Akwakwak", "Férosinge", "Colossinge", "Caninos", "Arcanin", "Ptitard", "Têtarte", "Tartard", "Abra", "Kadabra", "Alakazam", "Machoc", "Machopeur", "Mackogneur", "Chétiflor", "Boustiflor", "Empiflor", "Tentacool", "Tentacruel", "Racaillou", "Gravalanch", "Grolem", "Ponyta", "Galopa", "Ramoloss", "Flagadoss", "Magnéti", "Magnéton", "Canarticho", "Doduo", "Dodrio", "Otaria", "Lamantine", "Tadmorv", "Grotadmorv", "Kokiyas", "Crustabri", "Fantominus", "Spectrum", "Ectoplasma", "Onix", "Soporifik", "Hypnomade", "Krabby", "Krabboss", "Voltorbe", "Électrode", "Noeunoeuf", "Noadkoko", "Osselait", "Ossatueur", "Kicklee", "Tygnon", "Excelangue", "Smogo", "Smogogo", "Rhinocorne", "Rhinoféros", "Leveinard", "Saquedeneu", "Kangourex", "Hypotrempe", "Hypocéan", "Poissirène", "Poissoroy", "Stari", "Staross", "M. Mime", "Insécateur", "Lippoutou", "Élektek", "Magmar", "Scarabrute", "Tauros", "Magicarpe", "Léviator", "Lokhlass", "Métamorph", "Évoli", "Aquali", "Voltali", "Pyroli", "Porygon", "Amonita", "Amonistar", "Kabuto", "Kabutops", "Ptéra", "Ronflex", "Artikodin", "Électhor", "Sulfura", "Minidraco", "Draco", "Dracolosse", "Mewtwo", "Mew",
	"Germignon", "Macronium", "Méganium", "Héricendre", "Feurisson", "Typhlosion", "Kaiminus", "Crocrodil", "Aligatueur", "Fouinette", "Fouinar", "Hoothoot", "Noarfang", "Coxy", "Coxyclaque", "Mimigal", "Migalos", "Nostenfer", "Loupio", "Lanturn", "Pichu", "Mélo", "Toudoudou", "Togepi", "Togetic", "Natu", "Xatu", "Wattouat", "Lainergie", "Pharamp", "Joliflor", "Marill", "Azumarill", "Simularbre", "Tarpaud", "Granivol", "Floravol", "Cotovol", "Capumain", "Tournegrin", "Héliatronc", "Yanma", "Axoloto", "Maraiste", "Mentali", "Noctali", "Cornèbre", "Roigada", "Feuforêve", "Zarbi", "Qulbutoké", "Girafarig", "Pomdepik", "Foretress", "Insolourdo", "Scorplane", "Steelix", "Snubbull", "Granbull", "Qwilfish", "Cizayox", "Caratroc", "Scarhino", "Farfuret", "Teddiursa", "Ursaring", "Limagma", "Volcaropod", "Marcacrin", "Cochignon", "Corayon", "Rémoraid", "Octillery", "Cadoizo", "Démanta", "Airmure", "Malosse", "Démolosse", "Hyporoi", "Phanpy", "Donphan", "Porygon2", "Cerfrousse", "Queulorior", "Debugant", "Kapoera", "Lippouti", "Élekid", "Magby", "Écrémeuh", "Leuphorie", "Raikou", "Entei", "Suicune", "Embrylex", "Ymphect", "Tyranocif", "Lugia", "Ho-Oh", "Celebi",
	"Arcko", "Massko", "Jungko", "Poussifeu", "Galifeu", "Braségali", "Gobou", "Flobio", "Laggron", "Medhyèna", "Grahyèna", "Zigzaton", "Linéon", "Chenipotte", "Armulys", "Charmillon", "Blindalys", "Papinox", "Nénupiot", "Lombre", "Ludicolo", "Grainipiot", "Pifeuil", "Tengalice", "Nirondelle", "Hélédelle", "Goélise", "Bekipan", "Tarsal", "Kirlia", "Gardevoir", "Arakdo", "Maskadra", "Balignon", "Chapignon", "Parecool", "Vigoroth", "Monaflèmit", "Ningale", "Ninjask", "Munja", "Chuchmur", "Ramboum", "Brouhabam", "Makuhita", "Hariyama", "Azurill", "Tarinor", "Skitty", "Delcatty", "Ténéfix", "Mysdibule", "Galekid", "Galegon", "Galeking", "Méditikka", "Charmina", "Dynavolt", "Élecsprint", "Posipi", "Négapi", "Muciole", "Lumivole", "Rosélia", "Gloupti", "Avaltout", "Carvanha", "Sharpedo", "Wailmer", "Wailord", "Chamallot", "Camérupt", "Chartor", "Spoink", "Groret", "Spinda", "Kraknoix", "Vibraninf", "Libégon", "Cacnea", "Cacturne", "Tylton", "Altaria", "Mangriff", "Séviper", "Séléroc", "Solaroc", "Barloche", "Barbicha", "Écrapince", "Colhomard", "Balbuto", "Kaorine", "Lilia", "Vacilys", "Anorith", "Armaldo", "Barpau", "Milobellus", "Morphéo", "Kecleon", "Polichombr", "Branette", "Skelénox", "Téraclope", "Tropius", "Éoko", "Absol", "Okéoké", "Stalgamin", "Oniglali", "Obalie", "Phogleur", "Kaimorse", "Coquiperl", "Serpang", "Rosabyss", "Relicanth", "Lovdisc", "Draby", "Drackhaus", "Drattak", "Terhal", "Métang", "Métalosse", "Regirock", "Regice", "Registeel", "Latias", "Latios", "Kyogre", "Groudon", "Rayquaza", "Jirachi", "Deoxys",
	"Tortipouss", "Boskara", "Torterra", "Ouisticram", "Chimpenfeu", "Simiabraz", "Tiplouf", "Prinplouf", "Pingoléon", "Étourmi", "Étourvol", "Étouraptor", "Keunotor", "Castorno", "Crikzik", "Mélokrik", "Lixy", "Luxio", "Luxray", "Rozbouton", "Roserade", "Kranidos", "Charkos", "Dinoclier", "Bastiodon", "Cheniti", "Cheniselle", "Papilord", "Apitrini", "Apireine", "Pachirisu", "Mustébouée", "Mustéflott", "Ceribou", "Ceriflor", "Sancoki", "Tritosor", "Capidextre", "Baudrive", "Grodrive", "Laporeille", "Lockpin", "Magirêve", "Corboss", "Chaglam", "Chaffreux", "Korillon", "Moufouette", "Moufflair", "Archéomire", "Archéodong", "Manzaï", "Mime Jr.", "Ptiravi", "Pijako", "Spiritomb", "Griknot", "Carmache", "Carchacrok", "Goinfrex", "Riolu", "Lucario", "Hippopotas", "Hippodocus", "Rapion", "Drascore", "Cradopaud", "Coatox", "Vortente", "Écayon", "Luminéon", "Babimanta", "Blizzi", "Blizzaroi", "Dimoret", "Magnézone", "Coudlangue", "Rhinastoc", "Bouldeneu", "Élekable", "Maganon", "Togekiss", "Yanmega", "Phyllali", "Givrali", "Scorvol", "Mammochon", "Porygon-Z", "Gallame", "Tarinorme", "Noctunoir", "Momartik", "Motisma", "Motisma Chaleur", "Motisma Froid", "Motisma Lavage", "Motisma Tonte", "Motisma Hélice", "Créhelf", "Créfollet", "Créfadet", "Dialga", "Palkia", "Heatran", "Regigigas", "Giratina", "Cresselia", "Phione", "Manaphy", "Darkrai", "Shaymin", "Arceus",
	"Victini", "Vipélierre", "Lianaja", "Majaspic", "Gruikui", "Grotichon", "Roitiflam", "Moustillon", "Mateloutre", "Clamiral", "Ratentif", "Miradar", "Ponchiot", "Ponchien", "Mastouffe", "Chacripan", "Léopardus", "Feuillajou", "Feuiloutan", "Flamajou", "Flamoutan", "Flotajou", "Flotoutan", "Munna", "Mushana", "Poichigeon", "Colombeau", "Déflaisan", "Zébibron", "Zéblitz", "Nodulithe", "Géolithe", "Gigalithe", "Chovsourir", "Rhinolove", "Rototaupe", "Minotaupe", "Nanméouïe", "Charpenti", "Ouvrifier", "Bétochef", "Tritonde", "Batracné", "Crapustule", "Judokrak", "Karaclée", "Larveyette", "Couverdure", "Manternel", "Venipatte", "Scobolide", "Brutapode", "Doudouvet", "Farfaduvet", "Chlorobule", "Fragilady", "Bargantua", "Mascaïman", "Escroco", "Crocorible", "Darumarond", "Darumacho", "Maracachi", "Crabicoque", "Crabaraque", "Baggiguane", "Baggaïd", "Cryptéro", "Tutafeh", "Tutankafer", "Carapagos", "Mégapagos", "Arkéapti", "Aéroptéryx", "Miamiasme", "Miasmax", "Zorua", "Zoroark", "Chinchidou", "Pashmilla", "Scrutella", "Mesmérella", "Sidérella", "Nucléos", "Méios", "Symbios", "Couaneton", "Lakmécygne", "Sorbébé", "Sorboul", "Sorbouboul", "Vivaldaim", "Haydaim", "Emolga", "Carabing", "Lançargot", "Trompignon", "Gaulet", "Viskuse", "Moyade", "Mamanbo", "Statitik", "Mygavolt", "Grindur", "Noacier", "Tic", "Clic", "Cliticlic", "Anchwatt", "Lampéroie", "Ohmassacre", "Lewsor", "Neitram", "Funécire", "Mélancolux", "Lugulabre", "Coupenotte", "Incisache", "Tranchodon", "Polarhume", "Polagriffe", "Hexagel", "Escargaume", "Limaspeed", "Limonde", "Kungfouine", "Shaofouine", "Drakkarmin", "Gringolem", "Golemastoc", "Scalpion", "Scalproie", "Frison", "Furaiglon", "Gueriaigle", "Vostourno", "Vaututrice", "Aflamanoir", "Fermite", "Solochi", "Diamat", "Trioxhydre", "Pyronille", "Pyrax", "Cobaltium", "Terrakium", "Viridium", "Boréas", "Fulguris", "Reshiram", "Zekrom", "Démétéros", "Kyurem", "Keldeo", "Meloetta", "Genesect",
	"Marisson", "Boguérisse", "Blindépique", "Feunnec", "Roussil", "Goupelin", "Grenousse", "Croâporal", "Amphinobi", "Sapereau", "Excavarenne", "Passerouge", "Braisillon", "Flambusard", "Lépidonille", "Pérégrain", "Prismillon", "Hélionceau", "Némélios", "Flabébé", "Floette", "Florges", "Cabriolaine", "Chevroum", "Pandespiègle", "Pandarbare", "Couafarel", "Psystigri", "Mistigrix", "Monorpale", "Dimoclès", "Exagide", "Fluvetin", "Cocotine", "Sucroquin", "Cupcanaille", "Sepiatop", "Sepiatroce", "Opermine", "Golgopathe", "Venalgue", "Kravarech", "Flingouste", "Gamblast", "Galvaran", "Iguolta", "Ptyranidur", "Rexillius", "Amagara", "Dragmara", "Nymphali", "Brutalibré", "Dedenne", "Strassie", "Mucuscule", "Colimucus", "Muplodocus", "Trousselin", "Brocélôme", "Desséliande", "Pitrouille", "Banshitrouye", "Grelaçon", "Séracrawl", "Sonistrelle", "Bruyverne", "Xerneas", "Yveltal", "Zygarde", "Diancie", "Hoopa", "Volcanion",
	"Brindibou", "Efflèche", "Archéduc", "Flamiaou", "Matoufeu", "Félinferno", "Otaquin", "Otarlette", "Oratoria", "Picassaut", "Piclairon", "Bazoucan", "Manglouton", "Argouste", "Larvibule", "Chrysapile", "Lucanon", "Crabagarre", "Crabominable", "Plumeline", "Bombydou", "Rubombelle", "Rocabot", "Lougaroc", "Froussardine", "Vorastérie", "Prédastérie", "Tiboudet", "Bourrinos", "Araqua", "Tarenbulle", "Mimantis", "Floramantis", "Spododo", "Lampignon", "Tritox", "Malamandre", "Nounourson", "Chelours", "Croquine", "Candine", "Sucreine", "Guérilande", "Gouroutan", "Quartermac", "Sovkipou", "Sarmuraï", "Bacabouh", "Trépassable", "Concombaffe", "Type:0", "Silvallié", "Météno", "Dodoala", "Boumata", "Togedemaru", "Mimiqui", "Denticrisse", "Draïeul", "Sinistrail", "Bébécaille", "Écaïd", "Ékaïser", "Tokorico", "Tokopiyon", "Tokotoro", "Tokopisco", "Cosmog", "Cosmovum", "Solgaleo", "Lunala", "Zéroïd", "Mouscoto", "Cancrelove", "Câblifère", "Bamboiselle", "Katagami", "Engloutyran", "Necrozma", "Magearna", "Marshadow", "Vémini", "Mandrillon", "Ama-Ama", "Pierroteknik", "Zeraora",
	"Meltan", "Melmetal",
	"Ouistempo", "Badabouin", "Gorythmic", "Flambino", "Lapyro", "Pyrobut", "Larméléon", "Arrozard", "Lézargus", "Rongourmand", "Rongrigou", "Minisange", "Bleuseille", "Corvaillus", "Larvadar", "Coléodôme", "Astronelle", "Goupilou", "Roublenard", "Tournicoton", "Blancoton", "Moumouton", "Moumouflon", "Khélocrok", "Torgamord", "Voltoutou", "Fulgudog", "Charbi", "Wagomine", "Monthracite", "Verpom", "Pomdrapi", "Dratatin", "Dunaja", "Dunaconda", "Nigosier", "Embrochet", "Hastacuda", "Toxizap", "Salarsen", "Grillepattes", "Scolocendre", "Poulpaf", "Krakos", "Théffroi", "Polthégeist", "Bibichut", "Chapotus", "Sorcilence", "Grimalin", "Fourbelin", "Angoliath", "Ixon", "Berserkatt", "Corayôme", "Palarticho", "M. Glaquette", "Tutétékri", "Crèmy", "Charmilly", "Hexadron", "Wattapik", "Frissonille", "Beldeneige", "Dolman", "Bekaglaçon", "Wimessir", "Morpeko", "Charibari", "Pachyradjah", "Galvagon", "Galvagla", "Hydragon", "Hydragla", "Duralugon", "Fantyrm", "Dispareptil", "Lanssorien", "Zacian", "Zamazenta", "Éthernatos", "Wushours", "Shifours", "Zarude", "Regieleki", "Regidrago", "Blizzeval", "Spectreval", "Sylveroy", "Cerbyllin", "Hachécateur", "Ursaking", "Paragruel", "Farfurex", "Qwilpik", "Amovénus",
	"Poussacha", "Matourgeon", "Miascarade", "Chochodile", "Crocogril", "Flâmigator", "Coiffeton", "Canarbello", "Palmaval", "Gourmelet", "Fragroin", "Tissenboule", "Filentrappe", "Lilliterelle", "Gambex", "Pohm", "Pohmotte", "Pohmarmotte", "Compagnol", "Famignol", "Pâtachiot", "Briochien", "Olivini", "Olivado", "Arboliva", "Tapatoès", "Selutin", "Amassel", "Gigansel", "Charbambin", "Carmadura", "Malvalame", "Têtampoule", "Ampibidou", "Zapétrel", "Fulgulairo", "Grondogue", "Dogrino", "Gribouraigne", "Tag-Tag", "Virovent", "Virevorreur", "Terracool", "Terracruel", "Craparoi", "Pimito", "Scovilain", "Léboulérou", "Bérasca", "Flotillon", "Cléopsytra", "Forgerette", "Forgella", "Forgelina", "Taupikeau", "Triopikeau", "Lestombaile", "Dofin", "Superdofin", "Vrombi", "Vrombotor", "Motorizard", "Ferdeter", "Germéclat", "Floréclat", "Toutombe", "Tomberro", "Flamenroule", "Piétacé", "Balbalèze", "Délestin", "Oyacata", "Nigirigon", "Courrousinge", "Terraiste", "Farigiraf", "Deusolourdo", "Scalpereur", "Fort-Ivoire", "Hurle-Queue", "Fongus-Furie", "Flotte-Mèche", "Rampe-Ailes", "Pelage-Sablé", "Roue-de-Fer", "Hotte-de-Fer", "Paume-de-Fer", "Têtes-de-Fer", "Mite-de-Fer", "Épine-de-Fer", "Frigodo", "Cryodo", "Glaivodo", "Mordudor", "Gromago", "Chongjian", "Baojian", "Dinglu", "Yuyu", "Rugit-Lune", "Garde-de-Fer", "Koraidon", "Miraidon", "Serpente-Eau", "Vert-de-Fer", "Pomdramour", "Poltchageist / Onéreuse", "Théffroyable", "Félicanis", "Fortusimia", "Favianos", "Ogerpon", "Pondralugon", "Pomdorochi", "Feu-Perçant", "Ire-Foudre", "Roc-de-Fer", "Chef-de-Fer", "Terapagos", "Pêchaminus"
]
pokemon_en = ["Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro", "Magnemite", "Magneton", "Farfetch'd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew", 
	"Chikorita", "Bayleef", "Meganium", "Cyndaquil", "Quilava", "Typhlosion", "Totodile", "Croconaw", "Feraligatr", "Sentret", "Furret", "Hoothoot", "Noctowl", "Ledyba", "Ledian", "Spinarak", "Ariados", "Crobat", "Chinchou", "Lanturn", "Pichu", "Cleffa", "Igglybuff", "Togepi", "Togetic", "Natu", "Xatu", "Mareep", "Flaaffy", "Ampharos", "Bellossom", "Marill", "Azumarill", "Sudowoodo", "Politoed", "Hoppip", "Skiploom", "Jumpluff", "Aipom", "Sunkern", "Sunflora", "Yanma", "Wooper", "Quagsire", "Espeon", "Umbreon", "Murkrow", "Slowking", "Misdreavus", "Unown", "Wobbuffet", "Girafarig", "Pineco", "Forretress", "Dunsparce", "Gligar", "Steelix", "Snubbull", "Granbull", "Qwilfish", "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa", "Ursaring", "Slugma", "Magcargo", "Swinub", "Piloswine", "Corsola", "Remoraid", "Octillery", "Delibird", "Mantine", "Skarmory", "Houndour", "Houndoom", "Kingdra", "Phanpy", "Donphan", "Porygon2", "Stantler", "Smeargle", "Tyrogue", "Hitmontop", "Smoochum", "Elekid", "Magby", "Miltank", "Blissey", "Raikou", "Entei", "Suicune", "Larvitar", "Pupitar", "Tyranitar", "Lugia", "Ho-Oh", "Celebi",
	"Treecko", "Grovyle", "Sceptile", "Torchic", "Combusken", "Blaziken", "Mudkip", "Marshtomp", "Swampert", "Poochyena", "Mightyena", "Zigzagoon", "Linoone", "Wurmple", "Silcoon", "Beautifly", "Cascoon", "Dustox", "Lotad", "Lombre", "Ludicolo", "Seedot", "Nuzleaf", "Shiftry", "Taillow", "Swellow", "Wingull", "Pelipper", "Ralts", "Kirlia", "Gardevoir", "Surskit", "Masquerain", "Shroomish", "Breloom", "Slakoth", "Vigoroth", "Slaking", "Nincada", "Ninjask", "Shedinja", "Whismur", "Loudred", "Exploud", "Makuhita", "Hariyama", "Azurill", "Nosepass", "Skitty", "Delcatty", "Sableye", "Mawile", "Aron", "Lairon", "Aggron", "Meditite", "Medicham", "Electrike", "Manectric", "Plusle", "Minun", "Volbeat", "Illumise", "Roselia", "Gulpin", "Swalot", "Carvanha", "Sharpedo", "Wailmer", "Wailord", "Numel", "Camerupt", "Torkoal", "Spoink", "Grumpig", "Spinda", "Trapinch", "Vibrava", "Flygon", "Cacnea", "Cacturne", "Swablu", "Altaria", "Zangoose", "Seviper", "Lunatone", "Solrock", "Barboach", "Whiscash", "Corphish", "Crawdaunt", "Baltoy", "Claydol", "Lileep", "Cradily", "Anorith", "Armaldo", "Feebas", "Milotic", "Castform", "Kecleon", "Shuppet", "Banette", "Duskull", "Dusclops", "Tropius", "Chimecho", "Absol", "Wynaut", "Snorunt", "Glalie", "Spheal", "Sealeo", "Walrein", "Clamperl", "Huntail", "Gorebyss", "Relicanth", "Luvdisc", "Bagon", "Shelgon", "Salamence", "Beldum", "Metang", "Metagross", "Regirock", "Regice", "Registeel", "Latias", "Latios", "Kyogre", "Groudon", "Rayquaza", "Jirachi", "Deoxys",
	"Turtwig", "Grotle", "Torterra", "Chimchar", "Monferno", "Infernape", "Piplup", "Prinplup", "Empoleon", "Starly", "Staravia", "Staraptor", "Bidoof", "Bibarel", "Kricketot", "Kricketune", "Shinx", "Luxio", "Luxray", "Budew", "Roserade", "Cranidos", "Rampardos", "Shieldon", "Bastiodon", "Burmy", "Wormadam", "Mothim", "Combee", "Vespiquen", "Pachirisu", "Buizel", "Floatzel", "Cherubi", "Cherrim", "Shellos", "Gastrodon", "Ambipom", "Drifloon", "Drifblim", "Buneary", "Lopunny", "Mismagius", "Honchkrow", "Glameow", "Purugly", "Chingling", "Stunky", "Skuntank", "Bronzor", "Bronzong", "Bonsly", "Mime Jr.", "Happiny", "Chatot", "Spiritomb", "Gible", "Gabite", "Garchomp", "Munchlax", "Riolu", "Lucario", "Hippopotas", "Hippowdon", "Skorupi", "Drapion", "Croagunk", "Toxicroak", "Carnivine", "Finneon", "Lumineon", "Mantyke", "Snover", "Abomasnow", "Weavile", "Magnezone", "Lickilicky", "Rhyperior", "Tangrowth", "Electivire", "Magmortar", "Togekiss", "Yanmega", "Leafeon", "Glaceon", "Gliscor", "Mamoswine", "Porygon-Z", "Gallade", "Probopass", "Dusknoir", "Froslass", "Rotom", "Heat Rotom", "Frost Rotom", "Wash Rotom", "Mow Rotom", "Fan Rotom", "Uxie", "Mesprit", "Azelf", "Dialga", "Palkia", "Heatran", "Regigigas", "Giratina", "Cresselia", "Phione", "Manaphy", "Darkrai", "Shaymin", "Arceus",
	"Victini", "Snivy", "Servine", "Serperior", "Tepig", "Pignite", "Emboar", "Oshawott", "Dewott", "Samurott", "Patrat", "Watchog", "Lillipup", "Herdier", "Stoutland", "Purrloin", "Liepard", "Pansage", "Simisage", "Pansear", "Simisear", "Panpour", "Simipour", "Munna", "Musharna", "Pidove", "Tranquill", "Unfezant", "Blitzle", "Zebstrika", "Roggenrola", "Boldore", "Gigalith", "Woobat", "Swoobat", "Drilbur", "Excadrill", "Audino", "Timburr", "Gurdurr", "Conkeldurr", "Tympole", "Palpitoad", "Seismitoad", "Throh", "Sawk", "Sewaddle", "Swadloon", "Leavanny", "Venipede", "Whirlipede", "Scolipede", "Cottonee", "Whimsicott", "Petilil", "Lilligant", "Basculin", "Sandile", "Krokorok", "Krookodile", "Darumaka", "Darmanitan", "Maractus", "Dwebble", "Crustle", "Scraggy", "Scrafty", "Sigilyph", "Yamask", "Cofagrigus", "Tirtouga", "Carracosta", "Archen", "Archeops", "Trubbish", "Garbodor", "Zorua", "Zoroark", "Minccino", "Cinccino", "Gothita", "Gothorita", "Gothitelle", "Solosis", "Duosion", "Reuniclus", "Ducklett", "Swanna", "Vanillite", "Vanillish", "Vanilluxe", "Deerling", "Sawsbuck", "Emolga", "Karrablast", "Escavalier", "Foongus", "Amoonguss", "Frillish", "Jellicent", "Alomomola", "Joltik", "Galvantula", "Ferroseed", "Ferrothorn", "Klink", "Klang", "Klinklang", "Tynamo", "Eelektrik", "Eelektross", "Elgyem", "Beheeyem", "Litwick", "Lampent", "Chandelure", "Axew", "Fraxure", "Haxorus", "Cubchoo", "Beartic", "Cryogonal", "Shelmet", "Accelgor", "Stunfisk", "Mienfoo", "Mienshao", "Druddigon", "Golett", "Golurk", "Pawniard", "Bisharp", "Bouffalant", "Rufflet", "Braviary", "Vullaby", "Mandibuzz", "Heatmor", "Durant", "Deino", "Zweilous", "Hydreigon", "Larvesta", "Volcarona", "Cobalion", "Terrakion", "Virizion", "Tornadus", "Thundurus", "Reshiram", "Zekrom", "Landorus", "Kyurem", "Keldeo", "Meloetta", "Genesect",
	"Chespin", "Quilladin", "Chesnaught", "Fennekin", "Braixen", "Delphox", "Froakie", "Frogadier", "Greninja", "Bunnelby", "Diggersby", "Fletchling", "Fletchinder", "Talonflame", "Scatterbug", "Spewpa", "Vivillon", "Litleo", "Pyroar", "Flabébé", "Floette", "Florges", "Skiddo", "Gogoat", "Pancham", "Pangoro", "Furfrou", "Espurr", "Meowstic", "Honedge", "Doublade", "Aegislash", "Spritzee", "Aromatisse", "Swirlix", "Slurpuff", "Inkay", "Malamar", "Binacle", "Barbaracle", "Skrelp", "Dragalge", "Clauncher", "Clawitzer", "Helioptile", "Heliolisk", "Tyrunt", "Tyrantrum", "Amaura", "Aurorus", "Sylveon", "Hawlucha", "Dedenne", "Carbink", "Goomy", "Sliggoo", "Goodra", "Klefki", "Phantump", "Trevenant", "Pumpkaboo", "Gourgeist", "Bergmite", "Avalugg", "Noibat", "Noivern", "Xerneas", "Yveltal", "Zygarde", "Diancie", "Hoopa", "Volcanion","Rowlet", "Dartrix", "Decidueye", "Litten", "Torracat", "Incineroar", "Popplio", "Brionne", "Primarina", "Pikipek", "Trumbeak", "Toucannon", "Yungoos", "Gumshoos", "Grubbin", "Charjabug", "Vikavolt", "Crabrawler", "Crabominable", "Oricorio", "Cutiefly", "Ribombee", "Rockruff", "Lycanroc", "Wishiwashi", "Mareanie", "Toxapex", "Mudbray", "Mudsdale", "Dewpider", "Araquanid", "Fomantis", "Lurantis", "Morelull", "Shiinotic", "Salandit", "Salazzle", "Stufful", "Bewear", "Bounsweet", "Steenee", "Tsareena", "Comfey", "Oranguru", "Passimian", "Wimpod", "Golisopod", "Sandygast", "Palossand", "Pyukumuku", "Type: Null", "Silvally", "Minior", "Komala", "Turtonator", "Togedemaru", "Mimikyu", "Bruxish", "Drampa", "Dhelmise", "Jangmo-o", "Hakamo-o", "Kommo-o", "Tapu Koko", "Tapu Lele", "Tapu Bulu", "Tapu Fini", "Cosmog", "Cosmoem", "Solgaleo", "Lunala", "Nihilego", "Buzzwole", "Pheromosa", "Xurkitree", "Celesteela", "Kartana", "Guzzlord", "Necrozma", "Magearna", "Marshadow", "Poipole", "Naganadel", "Stakataka", "Blacephalon", "Zeraora", "Meltan", "Melmetal",
	"Grookey", "Thwackey", "Rillaboom", "Scorbunny", "Raboot", "Cinderace", "Sobble", "Drizzile", "Inteleon", "Skwovet", "Greedent", "Rookidee", "Corvisquire", "Corviknight", "Blipbug", "Dottler", "Orbeetle", "Nickit", "Thievul", "Gossifleur", "Eldegoss", "Wooloo", "Dubwool", "Chewtle", "Drednaw", "Yamper", "Boltund", "Rolycoly", "Carkol", "Coalossal", "Applin", "Flapple", "Appletun", "Silicobra", "Sandaconda", "Cramorant", "Arrokuda", "Barraskewda", "Toxel", "Toxtricity", "Sizzlipede", "Centiskorch", "Clobbopus", "Grapploct", "Sinistea", "Polteageist", "Hatenna", "Hattrem", "Hatterene", "Impidimp", "Morgrem", "Grimmsnarl", "Obstagoon", "Perrserker", "Cursola", "Sirfetch'd", "Mr. Rime", "Runerigus", "Milcery", "Alcremie", "Falinks", "Pincurchin", "Snom", "Frosmoth", "Stonjourner", "Eiscue", "Indeedee", "Morpeko", "Cufant", "Copperajah", "Dracozolt", "Arctozolt", "Dracovish", "Arctovish", "Duraludon", "Dreepy", "Drakloak", "Dragapult", "Zacian", "Zamazenta", "Eternatus", "Kubfu", "Urshifu", "Zarude", "Regieleki", "Regidrago", "Glastrier", "Spectrier", "Calyrex", "Wyrdeer", "Kleavor", "Ursaluna", "Basculegion", "Sneasler", "Overqwil", "Enamorus",
	"Sprigatito", "Floragato", "Meowscarada", "Fuecoco", "Crocalor", "Skeledirge", "Quaxly", "Quaxwell", "Quaquaval", "Lechonk", "Oinkologne", "Tarountula", "Spidops", "Nymble", "Lokix", "Pawmi", "Pawmo", "Pawmot", "Tandemaus", "Maushold", "Fidough", "Dachsbun", "Smoliv", "Dolliv", "Arboliva", "Squawkabilly", "Nacli", "Naclstack", "Garganacl", "Charcadet", "Armarouge", "Ceruledge", "Tadbulb", "Bellibolt", "Wattrel", "Kilowattrel", "Maschiff", "Mabosstiff", "Shroodle", "Grafaiai", "Bramblin", "Brambleghast", "Toedscool", "Toedscruel", "Klawf", "Capsakid", "Scovillain", "Rellor", "Rabsca", "Flittle", "Espathra", "Tinkatink", "Tinkatuff", "Tinkaton", "Wiglett", "Wugtrio", "Bombirdier", "Finizen", "Palafin", "Varoom", "Revavroom", "Cyclizar", "Orthworm", "Glimmet", "Glimmora", "Greavard", "Houndstone", "Flamigo", "Cetoddle", "Cetitan", "Veluza", "Dondozo", "Tatsugiri", "Annihilape", "Clodsire", "Farigiraf", "Dudunsparce", "Kingambit", "Great Tusk", "Scream Tail", "Brute Bonnet", "Flutter Mane", "Slither Wing", "Sandy Shocks", "Iron Treads", "Iron Bundle", "Iron Hands", "Iron Jugulis", "Iron Moth", "Iron Thorns", "Frigibax", "Arctibax", "Baxcalibur", "Gimmighoul", "Gholdengo", "Wo-Chien", "Chien-Pao", "Ting-Lu", "Chi-Yu", "Roaring Moon", "Iron Valiant", "Koraidon", "Miraidon", "Walking Wake", "Iron Leaves", "Dipplin", "Poltchageist", "Sinistcha", "Okidogi", "Munkidori", "Fezandipiti", "Ogerpon", "Archaludon", "Hydrapple", "Gouging Fire", "Raging Bolt", "Iron Boulder", "Iron Crown", "Terapagos", "Pecharunt"
]

no_galar = ["Ixon", "Berserkatt", "Corayôme", "Palarticho", "M. Glaquette", "Tutétékri"]
no_hisui = ["Bargantua", "Paragruel", "Farfurex", "Qwilpik"]
no_paldea = ["Terraiste"]

def extra_category(card_name, page_name, spec):
	page_name	= page_name.replace("[[", "")
	card_name	= card_name.replace(" d'Alola", " <small>d'Alola</small>")
	card_name_split	= card_name.replace(", ", " et ")
	card_name_split	= card_name_split.split(" et ")
	ans		= ""
	all_found	= True

	for item in card_name_split:
		all_found	= False
		locate_small	= item.find("<small>")
		small_part	= ""

		if locate_small != -1:
			item_split	= item.split("<small>")
			item		= item_split[0]
			small_part	= item_split[1][:-8]

		if item[-1] == " ":
			item = item[:-1]
		
		if is_english_set:
			if "'s " in item:
				item = item.split("'s ")[1]
			if "Dark " in item:
				item = item.replace("Dark ", "")
			if " ex" in item:
				item = item.replace(" ex", "")
			if " LV.X" in item:
				item = item.replace(" LV.X", "")
			if " LV.'''''X'''''" in item:
				item = item.replace(" LV.'''''X'''''", "")
		else:
			if " Brillant" in item:
				item = item.replace(" Brillant", "")
			if " Radieux" in item:
				item = item.replace(" Radieux", "")

		if " ♀" in item:
			item = item.replace(" ♀", "♀")
		if " ♂" in item:
			item = item.replace(" ♂", "♂")
		if " δ" in item:
			item = item.replace(" δ", "")
		if "&nbsp;" in item:
			item = item.replace("&nbsp;", "")

		if not is_english_set and item in pokemon:
			all_found = True
			if small_part in ["d'Alola", "Crinière du Couchant", "Ailes de l'Aurore"]:
				item += " " + small_part
			if small_part == "de Galar":
				if not item in no_galar:
					item += " de Galar"
			if small_part == "de Hisui":
				if not item in no_hisui:
					item += " de Hisui"
			if small_part == "de Paldea":
				if not item in no_paldea:
					item += " de Paldea"
			if small_part in ["Cavalier du Froid", "Cavalier d'Effroi"]:
				item += ", le " + small_part
			if item[:7] == "Motisma":
				item = "Motisma"

			item_prefix = ""
			item_suffix = ""

			if spec == "M":
				if item in ["Dracaufeu", "Mewtwo"]:
					item_suffix = " " + input("Which Mega is " + page_name + "? ")
				item_prefix = "Méga-"
			elif spec == "VMAX":
				if item in ["Florizarre", "Dracaufeu", "Tortank", "Papilusion", "Pikachu", "Miaouss", "Mackogneur", "Ectoplasma", "Krabboss", "Lokhlass", "Évoli", "Ronflex", "Miasmax", "Melmetal", "Gorythmic", "Pyrobut", "Lézargus", "Corvaillus", "Astronelle", "Torgamord", "Monthracite", "Pomdrapi", "Dratatin", "Dunaconda", "Salarsen", "Scolocendre", "Sorcilence", "Angoliath", "Charmilly", "Pachyradjah", "Duralugon", "Shifours"]:
					is_gigamax = input("Is " + page_name + " Gigantamax? (o/n) ")
					if is_gigamax != "n":
						item_suffix = " Gigamax"

			ans += "\n[[Catégorie:Scan de carte représentant {0}{1}{2}]]".format(item_prefix, item, item_suffix)
		elif is_english_set and item in pokemon_en:
			# print("Trouvé", item)
			all_found = True
			french_item = pokemon[pokemon_en.index(item)]

			ans += "\n[[Catégorie:Scan de carte représentant {0}]]".format(french_item)
		else:
			break
	if ans != "":
		return ans
	if not is_english_set and "Énergie" in card_name and not "d'Énergie" in card_name and not "Capsule Énergie" in card_name:
		return "\n[[Catégorie:Scan de carte Énergie]]"
	if is_english_set and "Energy" in card_name and card_name[-6:] == "Energy":
		print("Energy card:", card_name)
		return "\n[[Catégorie:Scan de carte Énergie]]"
	else:
		if is_english_set and "Energy" in card_name:
			print("Trainer card:", card_name)
		return "\n[[Catégorie:Scan de carte Dresseur]]"

print("Extension :", expansion)
for card in text:
	card_plus_symbol	= card.split("]]")

	symbol			= ""
	try:
		symbol		= card_plus_symbol[1]
	except IndexError:
		()

	# print(card_plus_symbol)
	spec = ""
	if "{{Symbole JCC|Méga}}" in card_plus_symbol[0]:
		card_plus_symbol[0] = card_plus_symbol[0].replace("Symbole JCC|Méga}}", "")
		spec = "M"
	if "VMAX" in symbol :
		spec = "VMAX"
	card_plus_symbol[0]	= card_plus_symbol[0][2:]

	l_card			= card_plus_symbol[0].split('|')

	page_name		= l_card[0]
	card_name		= l_card[1]

	source = ""
	source = "\n\n{{Informations Fichier\n| source=[https://drive.google.com/drive/folders/1_2YURmd7dYnCX3VuDLQobLNSJbAeavpt Google Drive TCGPocket]\n| auteur=[[DeNA]]\n}}"
	# source = "\n\n{{Informations Fichier\n| source=[https://limitlesstcg.com/cards/fr Limitless]\n| auteur=[[The Pokémon Company]]\n}}"

	new_string = "Scan de la carte {0} de l'[[extension]] [[{2}{3}]].{6}\n\n[[Catégorie:Scan de carte {4}]]{5}\nXXXXX".format(card, symbol, expansion_link, "|" + expansion if expansion != expansion_link else "", de(expansion) + expansion, extra_category(card_name, page_name, spec), source)

	# print(new_string)
	output.write(new_string + "\n")

f.close()
output.close()
print("Done!")