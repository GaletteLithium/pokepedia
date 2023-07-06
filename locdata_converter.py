import glob
import os
import sys
import re
from pyuca import Collator

root_path = "D:/Poképédia/Robot"
if len(sys.argv) > 1:
	root_path = sys.argv[1]

print("Python root_path ["+root_path+"]")

os.chdir(root_path)

c = Collator()

foldername = "dumps/locdump/"
seen_games = set()
locations = {}
warnings = ""

game_to_game_long = {
	"RV":			"Pokémon Rouge et Vert",
	"B-JP":			"Pokémon Bleu (Japon)",
	"RB":			"Pokémon Rouge et Bleu",
	"J":			"Pokémon Jaune",
	"O":			"Pokémon Or",
	"A":			"Pokémon Argent",
	"OA":			"Pokémon Or et Argent",
	"C":			"Pokémon Cristal",
	"RS":			"Pokémon Rubis et Saphir",
	"RFVF":			"Pokémon Rouge Feu et Vert Feuille",
	"E":			"Pokémon Émeraude",
	"DP":			"Pokémon Diamant et Perle",
	"HGSS":			"Pokémon Or HeartGold et Argent SoulSilver",
	"Pt":			"Pokémon Platine",
	"NB":			"Pokémon Noir et Blanc",
	"NB2":			"Pokémon Noir 2 et Blanc 2",
	"XY":			"Pokémon X et Y",
	# "Démo-ROSA":	"Pokémon Rubis Oméga et Saphir Alpha _ Version démo spéciale",
	"ROSA":			"Pokémon Rubis Oméga et Saphir Alpha",
	"SL":			"Pokémon Soleil et Lune",
	"USUL":			"Pokémon Ultra-Soleil et Ultra-Lune",
	"LGPE":			"Pokémon Let's Go, Pikachu et Let's Go, Évoli",
	"EB":			"Pokémon Épée et Bouclier",
	"DEPS":			"Pokémon Diamant Étincelant et Perle Scintillante",
	"LPA":			"Légendes Pokémon _ Arceus",
	"EV":			"Pokémon Écarlate et Violet"
}

def get_savepath(game):
	try:
		return "dumps/locdump_converted/" + game_to_game_long[game] + ".txt"
	except KeyError:
		return None

# Directory cleaning
directory = "dumps/locdump_converted/"
try:
	if not os.path.exists(directory):
		os.makedirs(directory)
	else:
		files = [glob.glob(directory + "*.txt", recursive=True)]

		for d in files:
			for f in d:
				try:
					os.remove(f)
				except OSError as e:
			 		print("Error: %s : %s" % (f, e.strerror))

except OSError as e:
	print(e.strerror)

print("Parsing locations...")

filenames = sorted(os.listdir(foldername), key=str.casefold)
for filename in filenames:
	file = open(foldername + filename, "r", encoding="utf-8")

	location = filename[:-4] 	#get rid of the '.txt'
	
	# print("Parsing " + location + "...")

	lines = file.readlines()
	ans = ""
	milieu = None
	started = False
	started_raid = False
	first_line = True
	info_dict_dict = {}

	for line in lines:
		if not started and not started_raid:
			if "{{#invoke:Tableau Pokémon|sauvage" in line:
				game_parameter = "|jeu="
				location_parameter = "|lieu="
				zone_parameter = "|zone="
				beg = line.find(game_parameter)
				end = line.find("|", beg + 1)
				game = line[beg + len(game_parameter):end]

				beg = line.find(location_parameter)
				if beg == -1:
					location_specified = location
				else:
					end = line.find("|", beg + 1)
					location_specified = location + "|" + line[beg + len(location_parameter):end]

				beg = line.find(zone_parameter)
				if beg == -1:
					zone = None
				else:
					end = line.find("|", beg + 1)
					zone = line[beg + len(zone_parameter):end]

				started = True

				savepath = get_savepath(game)

				if not savepath is None:
					if not game in seen_games:
						file = open(savepath, "w+", encoding="utf-8")
						seen_games.add(game)

						savefile = open(savepath, "a", encoding="utf-8") #use "a" mode to append text
						savefile.write("return {\n")
						savefile.close()
					else:
						ans = ",\n"

				if zone is None:
					zone_add_on = ""
				else:
					zone_add_on = "@" + zone

				location_full = location_specified + zone_add_on
				ans = ans + '\t["' + location_full + '"] = {\n'

				if game in locations:
					location_game = locations[game]
					if location_full in location_game:
						warnings = warnings + "\nWARNING: " + location + " is present multiple times."
					else:
						location_game.append(location_full)
				else:
					locations[game] = [location_full]

			elif "{{#invoke:Tableau Pokémon|antre" in line:
				game = "EB"
				started_raid = True
				zone = None
				savepath = get_savepath(game)

				if not savepath is None:
					if not game in seen_games:
						seen_games.add(game)

						savefile = open(savepath, "a", encoding="utf-8") #use "a" mode to append text
						savefile.write("return {\n")
						savefile.close()
					else:
						ans = ",\n"


				ans = ans + '\t["' + location + '"] = {\n'

			elif "{{#invoke:Tableau Pokémon|teracristal" in line:
				game = "EV"
				started_raid = True
				zone = None
				savepath = get_savepath(game)

				if not savepath is None:
					if not game in seen_games:
						file = open(savepath, "w+", encoding="utf-8")
						seen_games.add(game)

						savefile = open(savepath, "a", encoding="utf-8") #use "a" mode to append text
						savefile.write("return {\n")
						savefile.close()
					else:
						ans = ",\n"


				ans = ans + '\t["' + location + '"] = {\n'

			continue
			

		if (" / " in line or line[-1] == "/") and not "nowiki" in line:
			special_info = re.search(r"taux-journée\([^\(]*\)", line)
			if not special_info is None:
				special_info = special_info.group()
				special_value = special_info[:-1].replace("taux-journée(", "")
				line = line.replace(special_info, "taux-matin(" + special_value + ") taux-jour(" + special_value + ")")

			l = line.split("/")
			pokemon = l[0].strip() #erasing an eventual last space at the end
			pokemon_set = set(pokemon.split(", "))
			i = 1

			for i in range(1, len(l)):
				info_dict = {}
				pokemon_called_list = []
				pokemon_called_rate_list = []
				pokemon_tmp_set = list(pokemon_set)
				pokemon_tmp_set.sort()

				if not milieu is None:
					info_dict["milieu"] = milieu

				info = re.search(r"[^\s]*\[[^\]]*\]", l[i])
				if not info is None:
					info_point = info.group()
					info_type = re.search(r"[^\[]*", info_point).group()
					if not '(' in info_type:
						info_info = re.search(r"\[[^\]]*\]", info_point).group()[1:-1]

						info_dict[info_type] = info_info
						# print(info_type, "|", info_info)

						if info_type == "renfort":
							pokemon_called_list = info_info.split(", ")

						l[i] = l[i][:info.span()[0]] + l[i][info.span()[1]:] 	# erase the data we just found


				info = re.search(r"[^\s]*\([^\)]*\)", l[i])
				while not info is None:
					info_point = info.group()
					info_type = re.search(r"[^\(]*", info_point).group()
					info_info = re.search(r"\([^\)]*\)", info_point).group()[1:-1]

					info_dict[info_type] = info_info


					l[i] = l[i][info.span()[1]:] 	# erase the data we just found

					info = re.search(r"[^\s]*\([^\)]*\)", l[i])	# search for other data

					# print(info_type, "|", info_info)
					if info_type == "taux-renfort":
						pokemon_called_rate_list = info_info.split(", ")

				if "localisations" in info_dict and info_dict["localisations"] == "masquer":
					print("MASKED in " + location)
					continue

				for pokemon in pokemon_tmp_set:
					if pokemon in info_dict_dict:
						info_dict_dict[pokemon].append(info_dict)
					else:
						info_dict_dict[pokemon] = [info_dict]

				if pokemon_called_list != []:
					info_dict_copy = info_dict.copy()
					try:
						del info_dict_copy["renfort"]
						del info_dict_copy["taux-renfort"]
					except KeyError:
						()

					for j in range(len(pokemon_called_list)):
						pokemon_called = pokemon_called_list[j]

						if not pokemon_called in pokemon_tmp_set:
							
							for k in range(len(pokemon_tmp_set)):
								pokemon_k = pokemon_tmp_set[k]
								if "(" in pokemon_k:
									pokemon_k_without_parentheses = re.sub(r" [^ ]*\(.*", "", pokemon_k)

									if "nom(" in pokemon_k:
										name_indix = re.search(r"nom\(", pokemon_k).span()[1]
										form_name = pokemon_k[name_indix:pokemon_k.find(")", name_indix)]

										pokemon_tmp_set[k] = pokemon_k_without_parentheses + " " + form_name

									elif "forme(" in pokemon_k:
										name_indix = re.search(r"forme\(", pokemon_k).span()[1]
										form_name = pokemon_k[name_indix:pokemon_k.find(")", name_indix)]

										form_string = " forme " + form_name
										if form_name == "Alola":
											form_string = " d'Alola"

										pokemon_tmp_set[k] = pokemon_k_without_parentheses + form_string

							pokemon_str = pokemon_tmp_set[0]
							if len(pokemon_tmp_set) >= 2:
								for k in range(1, len(pokemon_tmp_set) - 1):
									pokemon_tmp_set_k = pokemon_tmp_set[k]
									pokemon_str	+= ", " + pokemon_tmp_set_k
								pokemon_str += " et " + pokemon_tmp_set[-1]

							info_dict_copy["milieu"] = milieu + " – appelé en renfort par " + pokemon_str

							try:
								info_dict_copy["taux"] = pokemon_called_rate_list[j]
							except IndexError:
								info_dict_copy["taux"] = "100"

							if pokemon_called in info_dict_dict:
								info_dict_dict[pokemon_called].append(info_dict_copy)
							else:
								info_dict_dict[pokemon_called] = [info_dict_copy]


		elif line == "":
			continue

		elif (started or started_raid) and line[:2] == "}}":
			# Reconstruction of the dicts
			tmp_ans = ""
			for pokemon, info_dicts in info_dict_dict.items():
				first_dict = True
				for info_dict in info_dicts:
					if first_dict:
						tmp_ans = '\t\t["' + pokemon + '"] = {{'
						first_dict = False
					else:
						tmp_ans = tmp_ans + ",\n\t\t\t{"

					first_item = True
					for key, item in info_dict.items():
						if first_item:
							first_item = False
						else:
							tmp_ans = tmp_ans + ", "
						tmp_ans = tmp_ans + '["' + key + '"] = "' + item + '"'
					tmp_ans = tmp_ans + "}"
				tmp_ans = tmp_ans + "}"

				if first_line:
					first_line = False
				else:
					ans = ans + ",\n"
				ans = ans + tmp_ans
			ans = ans + "\n\t}"

			if not savepath is None:
				savefile = open(savepath, "a", encoding="utf-8") #use "a" mode to append text
				savefile.write(ans)
				savefile.close()

			# print("** " + game + " **")
			# print(location + " ok")
			# print("")

			#Reset if there is a new module in the page
			ans = ""
			milieu = None
			started = False
			started_raid = False
			first_line = True
			info_dict_dict = {}

		else:
			milieu = line[:-1] # faire un split avec la virgule et la double virgule


			#while
			()

	file.close()

for game in seen_games:
	savepath = get_savepath(game)
	if not savepath is None:
		savefile = open(savepath, "a", encoding="utf-8") #use "a" mode to append text
		savefile.write("\n}")
		savefile.close()

if warnings == "":
	print("No warnings.")
else:
	print(warnings)

# Initial directory cleaning
if True:
	directory = "dumps/locdump/"
	try:
		if not os.path.exists(directory):
			os.makedirs(directory)
		else:
			files = [glob.glob(directory + "*.txt", recursive=True)]

			for d in files:
				for f in d:
					try:
						os.remove(f)
					except OSError as e:
				 		print("Error: %s : %s" % (f, e.strerror))

	except OSError as e:
		print(e.strerror)
