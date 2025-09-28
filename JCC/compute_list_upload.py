from util import pokemon, pokemon_en

expansion	= "Promo ME"
# expansion	= "Méga-Évolution"
# expansion = "Source Secrète"
expansion_link	= expansion # + " (JCC)"

tcg_pocket = False

f		= open("liste.txt", "r", encoding="utf-8")
output		= open("description_upload.txt", "w+", encoding="utf-8")
text		= f.read().split("\n")
is_english_set	= False



source = ""
if tcg_pocket:
	source = "\n\n{{Informations Fichier\n| source=[https://drive.google.com/drive/folders/1_2YURmd7dYnCX3VuDLQobLNSJbAeavpt Google Drive TCGPocket]\n| auteur=[[DeNA]]\n}}"
else:
	source = "\n\n{{Informations Fichier\n| source=[https://limitlesstcg.com/cards/fr Limitless]\n| auteur=[[The Pokémon Company]]\n}}"


def de(s):
	if s[0:2] == "EX":
		return "de "
	if s[0].lower() in ["a", "e", "é", "h", "i", "o", "u", "y"]:
		return "d'"
	return "de "

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
		mega 		= ""
		mega_type	= ""

		if "Méga-" in item:
			mega = "Méga-"
			item = item.replace("Méga-", "")
			if item[-2:] == " X" or item[-2:] == " Y":
				mega_type = item[-2:]
				item = item[:-2]

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

			ans += "\n[[Catégorie:Scan de carte représentant {0}{1}{2}{3}{4}]]".format(mega, item_prefix, item, mega_type, item_suffix)
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
print("Source :", source)
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

	new_string = "Scan de la carte {0} de l'[[extension]] [[{2}{3}]].{6}\n\n[[Catégorie:Scan de carte {4}]]{5}\nXXXXX".format(card, symbol, expansion_link, "|" + expansion if expansion != expansion_link else "", de(expansion) + expansion, extra_category(card_name, page_name, spec), source)

	# print(new_string)
	output.write(new_string + "\n")

f.close()
output.close()
print("Done!")