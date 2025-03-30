from bs4 import BeautifulSoup
import re
import requests

# Bug log:
# - Technical Machines have swapped attacks and no Attack section

translation_dict = {
	"Colorless": "Incolore",
	"Darkness": "Obscurité",
	"Dragon": "Dragon",
	"Fairy": "Fée",
	"Fighting": "Combat",
	"Fire": "Feu",
	"Grass": "Plante",
	"Lightning": "Électrique",
	"Metal": "Métal",
	"Psychic": "Psy",
	"Water": "Eau",

	"C": "Incolore",
	"D": "Obscurité",
	"E": "EX",
	"F": "Combat",
	"G": "Plante",
	"L": "Électrique",
	"M": "Métal",
	"N": "Dragon",
	"P": "Psy",
	"R": "Feu",
	"W": "Eau",
	"X": "GX",
	"Y": "Fée",

	"Basic Energy": "Énergie de base",
	"Energy": "Énergie",
	"HIGH-TECH": "HIGH-TECH",
	"Item": "Objet",
	"Pokémon": "Pokémon",
	"Special Energy": "Spéciale",
	"Stadium": "Stade",
	"Supporter": "Supporter",
	"Tool": "Outil Pokémon",
	"Trainer": "Dresseur",

	"Basic": 0,
	"Stage 1": 1,
	"Stage 2": 2
}

# Link replacers in descriptions
link_dict_list = [
	{r"attaque": "[[Attaque (JCC)|attaque]]"},
	{
		r"Banc": "[[Banc (JCC)|Banc]]",
		r"Pokémon de Banc": "[[Pokémon de Banc]]"
	},
	{r"Brûlé": "[[Brûlure (JCC)|Brûlé]]"},
	{
		r"carte Dresseur": "[[Carte Dresseur (JCC)|carte Dresseur]]",
		r"cartes Dresseur": "[[Carte Dresseur (JCC)|cartes Dresseur]]"
	},
	{
		r"carte Énergie de base": "[[carte Énergie de base]]",
		r"cartes Énergie de base": "[[Carte Énergie de base|cartes Énergie de base]]",
		r"carte Énergie": "[[carte Énergie]]",
		r"cartes Énergie": "[[Carte Énergie|cartes Énergie]]",
		r"Énergie de base": "[[Énergie de base]]",
		r"Énergie spéciale": "[[Énergie spéciale]]",
		r"Énergie" : "[[Énergie]]"
	},
	{
		r"carte HIGH-TECH": "[[carte HIGH-TECH]]",
		r"cartes HIGH-TECH": "[[Carte HIGH-TECH|cartes HIGH-TECH]]"
	},
	{
		r"carte Objet": "[[carte Objet]]",
		r"cartes Objet": "[[Carte Objet|cartes Objet]]"
	},
	{
		r"carte Outil Pokémon": "[[carte Outil Pokémon]]",
		r"cartes Outil Pokémon": "[[Carte Outil Pokémon|cartes Outil Pokémon]]",
		r"Outil Pokémon": "[[Outil Pokémon]]",
		r"Outils Pokémon": "[[Outil Pokémon|Outils Pokémon]]"
	},
	{
		r"carte Stade": "[[carte Stade]]",
		r"cartes Stade": "[[Carte Stade|cartes Stade]]",
		r"Stade ": "[[Carte Stade|Stade]] "
	},
	{
		r"carte Supporter": "[[carte Supporter]]",
		r"cartes Supporter": "[[Carte Supporter|cartes Supporter]]"
	},
	{r"Coût de Retraite": "[[Coût de Retraite]]"},
	{
		r"carte Récompense": "[[carte Récompense]]",
		r"cartes Récompense": "[[Carte Récompense|cartes Récompense]]"
	},
	{r"Confus": "[[Confusion (JCC)|Confus]]"},
	{r"Contrôle Pokémon": "[[Contrôle Pokémon]]"},
	{r"deck": "[[deck]]"},
	{
		r"défausse": "[[défausse]]",
		r"Défausse": "[[Défausse]]",
		r"pile de défausse": "[[pile de défausse]]"
	},
	{r"Empoisonné": "[[Empoisonnement (JCC)|Empoisonné]]"},
	{r"Endormi": "[[Sommeil (JCC)|Endormi]]"},
	{r"État Spécial": "[[État Spécial (JCC)|État Spécial]]"},
	{
		r"évoluer": "[[Évolution (JCC)|évoluer]]",
		r"Évolution": "[[Évolution (JCC)|Évolution]]",
		r"carte Évolution": "[[Évolution (JCC)|carte Évolution]]"
	},
	{r"Faiblesse": "[[Faiblesse (JCC)|Faiblesse]]"},
	{r"guérit": "[[Guérison (JCC)|guérit]]"},
	{r"K\.O\.": "[[K.O. (JCC)|K.O.]]"},
	{r"main": "[[main]]"},
	{r"\[\[main\]\]tenant": "maintenant"},
	{
		r"marqueur de dégâts": "[[marqueur de dégâts]]",
		r"marqueurs de dégâts": "[[marqueur de dégâts|marqueurs de dégâts]]"
	},
	{r"Paralysé": "[[Paralysie (JCC)|Paralysé]]"},
	{r"pièce": "[[Pièce (JCC)|pièce]]"},
	{
		r"Pokémon Actif": "[[Pokémon Actif]]",
		r"Actif": "[[Pokémon Actif|Actif]]"
	},
	{r"Pokémon de base": "[[Pokémon de base]]"},
	{r"Pokémon Défenseur": "[[Pokémon Défenseur]]"},
	{r"Pokémon-ex": "[[Pokémon-ex]]"},
	{r"Pokémon-V": "[[Pokémon-V]]"},
	{r"Pokémon-VMAX": "[[Pokémon-VMAX]]"},
	{r"Pokémon-VSTAR": "[[Pokémon-VSTAR]]"},
	{r"Pokémon-V-UNION": "[[Pokémon-V-UNION]]"},
	{r"Poste Actif": "[[Poste Actif]]"},
	{r"Résistance": "[[Résistance (JCC)|Résistance]]"},
	{r"retraite": "[[retraite]]"},
	{
		r"soigner": "[[Soin (JCC)|soigner]]",
		r"soignez": "[[Soin (JCC)|soignez]]",
		r"Soignez": "[[Soin (JCC)|Soignez]]"
	},
	{r"talent": " [[Talent (JCC)|talent]]"},
	{r" type": " [[Type (JCC)|type]]"},
	{r"Ultra-Chimère": " [[Ultra-Chimère (JCC)|Ultra-Chimère]]"},
]


def handle_attack_description(attack_info):
	# Sauts de ligne
	attack_info = re.sub(r"<[br/><]+>", "\n\n", str(attack_info))

	# Texte en italique
	pattern = re.compile(r'<span class="reminder-text">([^<]*)</span>')
	while pattern.search(attack_info):
		attack_info = pattern.sub("''£''", attack_info, 1).replace('£', pattern.search(attack_info).group(1))

	# Suppression des balises restantes
	attack_info	= re.sub(r"<[^>]*>", "", attack_info).strip()

	# Énergies dans le texte
	# print(attack_info)
	for energy in ["C", "D", "F", "G", "L", "M", "N", "P", "R", "W", "Y"]:
		# print(f"[{energy}]", f"[{energy}]" in attack_info)
		attack_info = attack_info.replace(f"[{energy}]", " {{type|" + translation_dict[energy].lower() + "|jcci}} ")

	return attack_info

def generate_wikicode(content, card_info):
	expansion = card_info["expansion"]
	game = "jcc"
	card_number = card_info["number"]
	max_card_number = card_info["max_number"]
	rarity = card_info["rarity"]
	display_name = card_info["name"]
	time = card_info["time"]

	# Symbole JCC pour pouvoir le réutiliser, notamment dans la traduction des noms étrangers
	symbol = None
	if re.search(r"\{\{Symbole JCC\|([^\}]*)\}\}", display_name):
		symbol = re.search(r"\{\{Symbole JCC\|([^\}]*)\}\}", display_name).group(1)


	soup = BeautifulSoup(html_content, 'html.parser')
	text_box = soup.find('div', class_='card-text')
	soup = BeautifulSoup(str(html_content), 'html.parser')

	name = soup.find('span', class_='card-text-name').get_text(strip=True)

	category = soup.find('p', class_='card-text-type').get_text().split(' - ')[0].strip()
	category = translation_dict[category]

	additional_info = ""

	category2 = None
	category3 = None
	if category != "Pokémon":
		try:
			category2 = soup.find('p', class_='card-text-type').get_text().split(' - ')[1].strip()
			category2 = translation_dict[category2]
			category3 = soup.find('p', class_='card-text-type').get_text().split(' - ')[2].strip()
			category3 = translation_dict[category3]
		except IndexError:
			()

	real_name = display_name
	evolution_stage = None
	evolves_from = None
	evolves_from_artwork = None
	trainer = None

	# Gestion de la phrase d'intro, notamment avec le type de carte et la sous-évolution du Pokémon
	if category == "Pokémon":
		pokemon_description_paragraph = "\n\n<!-- Description -->\n| description={{?}}\n| description-jeu={{?}}"

		if "{{Symbole JCC|V}}" in display_name:
			real_name = display_name.replace("{{Symbole JCC|V}}", "")
			pokemon_description_paragraph = ""
			category2 = "V"

		if "{{Symbole JCC|VMAX}}" in display_name:
			real_name = display_name.replace("{{Symbole JCC|VMAX}}", "")
			pokemon_description_paragraph = ""
			category2 = "VMAX"

		if "{{Symbole JCC|VSTAR}}" in display_name:
			real_name = display_name.replace("{{Symbole JCC|VSTAR}}", "")
			pokemon_description_paragraph = ""
			category2 = "VSTAR"

		if "{{Symbole JCC|V-UNION}}" in display_name:
			real_name = display_name.replace("{{Symbole JCC|V-UNION}}", "")
			pokemon_description_paragraph = ""
			category2 = "V-UNION"

		if "{{Symbole JCC|ex}}" in display_name or "{{Symbole JCC|ex JCCP}}" in display_name:
			real_name = display_name.replace("{{Symbole JCC|ex}}", "").replace("{{Symbole JCC|ex JCCP}}", "")
			category2 = "ex"

		if "{{Symbole JCC|ex Téracristal}}" in display_name:
			real_name = display_name.replace("{{Symbole JCC|ex Téracristal}}", "")
			category2 = "ex"
			category3 = "Téracristal"

		special_pokemon_names = ["Morphéo", "Motisma", "Ursaking", "Ogerpon"]
		for special_pokemon_name in special_pokemon_names:
			if special_pokemon_name in display_name:
				real_name = special_pokemon_name

		for region_suffix in ["d'Alola", "de Galar", "de Hisui", "de Paldea"]:
			real_name = real_name.replace("<small>" + region_suffix + "</small>", region_suffix)

		has_trainer = re.search(r"[^\n]* <small>(de |d')([^<]*)</small>", real_name)
		if has_trainer:
			trainer_particle = has_trainer.group(1)
			trainer = has_trainer.group(2)
			if category2 is None:
				category2 = "Dresseur"
			elif category3 is None:
				category3 = "Dresseur"
			else:
				print("ERREUR pas de catégorie suffisante")
		real_name = re.sub(r" <small>d(e |')[^<]*</small>", "", real_name)

		if real_name == display_name:
			real_name = None
		# print(real_name)

		if category2 == "ex":
			pokemon_description_paragraph = ""

		type = soup.find('p', class_='card-text-title').get_text().split(' - ')[1].strip()
		type = translation_dict[type].lower()
		hp = soup.find('p', class_='card-text-title').get_text().split(' - ')[2].replace("HP", "").strip()

		evolution_stage = soup.find('p', class_='card-text-type').get_text().split(' - ')[1].strip()
		evolution_stage = translation_dict[evolution_stage]

		if evolution_stage >= 1:
			evolves_from = soup.find('p', class_='card-text-type')
			soup_evolves_from = BeautifulSoup(str(evolves_from), 'html.parser')
			evolves_from = soup_evolves_from.find('a').get_text(strip=True).replace("’", "'")

			if not trainer is None:
				evolves_from_artwork = evolves_from + ".png"
				evolves_from += " " + trainer_particle + trainer

			# evolve_sentence = f" Elle doit être posée sur un {{{{Requête JCC|[[Nom de carte formaté::{evolves_from}]]|texte={evolves_from}|jeu={game}}}}} pour pouvoir être jouée."


	elif category == "Dresseur":
		if "high-tech" in rarity.lower():
			category3 = "HIGH-TECH"

		if "Capsule Technique" in name or "Machine Technique" in name:
			category3 = "Machine Technique"

	elif category == "Énergie":
		if "high-tech" in rarity.lower():
			if category2 is None:
				category2 = "HIGH-TECH"
			else:
				category3 = "HIGH-TECH"



	soup.find('div', class_='card-text-section').decompose() # Deleting text section as treatment is finished


	abilities = []

	# Talents
	while soup.find('div', class_='card-text-ability'):
		ability_text = soup.find('div', class_='card-text-ability').get_text()

		if not "\nTéracristal" in ability_text:
			ability_name = re.search(r"Ability:[ \n]*([^\n]*)", ability_text).group(1).strip()

			ability_effect = soup.find('p', class_='card-text-ability-effect').get_text(strip=True)

			ability_effect = handle_attack_description(ability_effect)

			ability = {"name": ability_name, "effect": ability_effect}
			abilities.append(ability)

		soup.find('div', class_='card-text-ability').decompose() # Deleting ability as treatment is finished

	abilities_title = None
	if len(abilities) == 1:
		abilities_title = "[[Talent (JCC)|Talent]]"
	elif len(abilities) >= 2:
		abilities_title = "[[Talent (JCC)|Talents]]"

	attacks = []

	# Attaques
	while soup.find('p', class_='card-text-attack-info'):
		attack_info = soup.find('p', class_='card-text-attack-info').get_text()
		attack_energy_string = soup.find('span', class_='ptcg-symbol').get_text(strip=True)
		attack_info = attack_info.replace(attack_energy_string, "", 1).strip().split(" ")

		# Conversion des Énergies en format wiki
		if attack_energy_string == "0":
			attack_energy = None
		else:
			attack_energy = ""
			for energy in attack_energy_string:
				attack_energy += "{{{{type|{}|jcc}}}}".format(translation_dict[energy].lower())

		# On regarde si l'attaque a des dégâts
		has_damage = True
		attack_damage = None
		for char in attack_info[-1]:
			if not char in [str(i) for i in range(10)] + ["+", "×"]:
				has_damage = False

		if has_damage:
			attack_damage = attack_info[-1]


		# On enregistre le nom de l'attaque mot par mot
		attack_name = attack_info[0]
		for i in range(1, len(attack_info) - has_damage):
			attack_name += " " + attack_info[i]

		attack_effect = soup.find('p', class_='card-text-attack-effect')
		attack_effect = handle_attack_description(attack_effect)

		attack = {"name": attack_name, "effect": attack_effect, "energy": attack_energy, "damage": attack_damage}
		attacks.append(attack)

		soup.find('p', class_='card-text-attack-info').decompose() # Deleting attack info as treatment is finished
		soup.find('p', class_='card-text-attack-effect').decompose() # Deleting attack effect as treatment is finished

	if category != "Pokémon":
		attack_info = soup.find('div', class_='card-text-section')
		attack_info = handle_attack_description(attack_info)

		attack = {"name": None, "effect": attack_info, "energy": None, "damage": None}
		attacks.append(attack)

	soup.find('div', class_='card-text-section').decompose() # Deleting text section as treatment is finished

	attacks_title = None
	if category == "Pokémon":
		if len(attacks) == 1:
			attacks_title = "[[Attaque (JCC)|Attaque]]"
		elif len(attacks) >= 2:
			attacks_title = "[[Attaque (JCC)|Attaques]]"

	# Création du paragraphe des facultés
	faculty_paragraph = ""

	# Abilities
	if len(abilities) >= 1:
		for ability_number in range(len(abilities)):
			ability = abilities[ability_number]
			ability_n = ""
			if ability_number != 0:
				ability_n = str(ability_number + 1)

			ability_name = ability["name"]
			ability_effect = ability["effect"]

			faculty_paragraph += f"\n| talent{ability_n}-nom={ability_name}\n| talent{ability_n}-description={ability_effect}"

	# Attacks
	if len(attacks) >= 1:
		for attack_number in range(len(attacks)):
			attack = attacks[attack_number]
			attack_n = ""
			if attack_number != 0:
				attack_n = str(attack_number + 1)

			attack_energy = attack["energy"]
			attack_name = attack["name"]
			attack_effect = attack["effect"]
			attack_damage = attack["damage"]

			if not attack_energy is None:
				faculty_paragraph += f"\n| attaque{attack_n}-type={attack_energy}"
			if not attack_name is None:
				faculty_paragraph += f"\n| attaque{attack_n}-nom={attack_name}"
			if not attack_effect is None and attack_effect != "":
				faculty_paragraph += f"\n| attaque{attack_n}-description={attack_effect}"
			if not attack_damage is None:
				faculty_paragraph += f"\n| attaque{attack_n}-dégâts={attack_damage}"

	# Adding links, but only one of each type
	for link_dict in link_dict_list:
		first_pattern = None
		first_item = None
		first_position = len(faculty_paragraph)

		# Computing which formulation comes first
		for key, item in link_dict.items():
			patterns = [r"(\| [^\n]*?-description=[^=\n]*?)" + key, r"(\| [^\n]*?-description=[^=\n]*?\n\n[^\|][^=\n]*?)" + key]
			for pattern in patterns:
				pattern = re.compile(pattern)
				pattern_search = pattern.search(faculty_paragraph)

				if not pattern_search is None:
					if not "\n| [[" in faculty_paragraph[pattern_search.span()[0]:]:
						# Way to find the beginning of the key
						position_found = re.search(key, faculty_paragraph[pattern_search.span()[0]:]).span()[0]
						if first_pattern is None or first_position > position_found:
							first_pattern = pattern
							first_key = key
							first_item = item
							first_position = position_found

		if not first_pattern is None:
			new_faculty_paragraph = first_pattern.sub(first_pattern.search(faculty_paragraph).group(1) + first_item, faculty_paragraph, 1)

			if new_faculty_paragraph != faculty_paragraph:
				faculty_paragraph = new_faculty_paragraph

	# Weakness, Resistance, Retreat Cost
	if category == "Pokémon":
		wrr = soup.find('p', class_='card-text-wrr').get_text()

		weakness = re.search(r"Weakness:[ \n]*([^\n]*)", wrr).group(1).strip()
		resistance = re.search(r"Resistance:[ \n]*([^\n]*)", wrr).group(1).strip()
		retreat_cost = re.search(r"Retreat:[ \n]*([^\n]*)", wrr).group(1).strip()

		if weakness == "none":
			weakness = None
		else:
			weakness = translation_dict[weakness].lower()

		if resistance == "none":
			resistance = None
		else:
			resistance = translation_dict[resistance].lower()

	# Illustrator
	illustrator = ""
	try:
		illustrator_div = soup.find('div', class_='card-text-section card-text-artist')
		soup_illustrator = BeautifulSoup(str(illustrator_div), 'html.parser')
		illustrator = soup_illustrator.find('a').get_text(strip=True)
	except AttributeError:
		()
	
	# Regulation mark
	regulation_mark = soup.find('div', class_='regulation-mark').get_text(strip=True)[0]

	if category == "Pokémon":
		text_box = f"""{{{{Article carte
<!-- Infobox -->
| nom={display_name}
| extension={expansion}
| jeu={game}
| numerocarte={card_number}
| rareté={rarity}
| illus={illustrator}
| catégorie=Pokémon
| type={type}
| pv={hp}
| stade={evolution_stage}
| retraite={retreat_cost}
| marque-régulation={regulation_mark}

<!-- Facultés -->{faculty_paragraph}{pokemon_description_paragraph}
}}}}"""
	
		if not real_name is None:
			text_box = text_box.replace("| extension=", f"| nomréel={real_name}\n| extension=")
		if not category2 is None:
			text_box = text_box.replace("| type=", f"| sous-catégorie={category2}\n| type=", 1)
		if not category3 is None:
			text_box = text_box.replace("| type=", f"| sous-catégorie2={category3}\n| type=", 1)
		if not trainer is None:
			text_box = text_box.replace("| type=", f"| dresseur={trainer}\n| type=")
		if not time is None:
			text_box = text_box.replace("| stade=", f"| temps={time}\n| stade=")
		if not evolves_from is None:
			print("\tÉvolution de :", evolves_from)
			text_box = text_box.replace("| stade=", f"| niveau-précédent={evolves_from}\n| stade=")
		if not evolves_from_artwork is None:
			text_box = text_box.replace("| stade=", f"| niveau-précédent-artwork={evolves_from_artwork}\n| stade=")
		if not weakness is None:
			text_box = text_box.replace("| retraite=", f"| faiblesse={weakness}\n| retraite=")
		if not resistance is None:
			text_box = text_box.replace("| retraite=", f"| resist={resistance}\n| retraite=")


	# Structure de carte Dresseur ou Énergie
	elif category == "Dresseur" or category == "Énergie":
		faculty_paragraph = faculty_paragraph.replace("| attaque", "| faculté")
		text_box = f"""{{{{Article carte
<!-- Infobox -->
| nom={display_name}
| extension={expansion}
| jeu={game}
| numerocarte={card_number}
| rareté={rarity}
| illus={illustrator}
| catégorie={category}
| marque-régulation={regulation_mark}

<!-- Facultés -->{faculty_paragraph}
}}}}"""

		if category == "Énergie":
			text_box = text_box.replace("| marque-régulation=", f"| type=\n| marque-régulation=")
		if not category2 is None:
			text_box = text_box.replace("| marque-régulation=", f"| sous-catégorie={category2}\n| marque-régulation=")
		if not category3 is None:
			text_box = text_box.replace("| marque-régulation=", f"| sous-catégorie2={category3}\n| marque-régulation=")
		if not time is None:
			text_box = text_box.replace("| marque-régulation=", f"| temps={time}\n| marque-régulation=")

		if category == "Énergie":
			text_box = text_box.replace("| marque-régulation=\n", "")


	# Max set carte
	if not max_card_number is None:
		text_box = text_box.replace("| rareté=", f"| maxsetcarte={max_card_number}\n| rareté=")
		if card_number > max_card_number:
			text_box = text_box.replace("| catégorie=", f"| secrète=oui\n| catégorie=")

	# Foreign names
	english_name = english_link = card_info["english_name"]
	japanese_name = japanese_link = card_info["japanese_name"]
	if symbol in ["ex", "ex Téracristal"]:
		english_name = english_name.replace(" ex", "{{Symbole JCC|" + symbol + "}}")
		japanese_name = japanese_name.replace("ex", "{{Symbole JCC|" + symbol + "}}")

	for region in ["Alolan", "Galarian", "Hisuian", "Paldean"]:
		if region in english_name:
			english_name = english_name.replace(region, "<small>" + region + "</small>")
	for region in ["アローラ", "ガラル", "ヒスイ", "パルデア"]:
		if region in japanese_name:
			japanese_name = japanese_name.replace(region, "<small>" + region + "</small>")

	if category2 == "Dresseur" or category3 == "Dresseur":
		english_name = "<small>" + english_name.replace("'s ", "'s</small> ", 1)
		japanese_name = "<small>" + japanese_name.replace("の", "の</small>", 1)

	if not english_name is None:
		english_card_number = str(int(re.sub(r"[A-Z]*", "", card_number)))
		interwiki = f"\n\n[[en:{english_link} ({english_expansion} {english_card_number})]]"

		text_box = text_box.replace("| extension=", f"| nomen={english_name}\n| extension=") + interwiki
	if not japanese_name is None:
		text_box = text_box.replace("| extension=", f"| nomja={japanese_name}\n| extension=")

	card_info["real_name"] = real_name
	card_info["evolution_stage"] = evolution_stage
	card_info["evolves_from"] = evolves_from
	card_info["text_box"] = text_box
	card_info["faculties"] = faculty_paragraph

	return card_info


def get_card_info_list(expansion, is_promo):
	card_list = open("card_list.txt", "r", encoding="utf-8").read().split("\n|-\n")
	card_info_list = []
	
	for item in card_list[1:]:
		item_list = item.split("\n|")
		max_card_number = None

		# To avoid blank lines
		if len(item_list) == 1:
			continue

		card_number = re.sub(r"<small>[^<]*</small>", "", item_list[0]).replace("| ", "")
		if is_promo:
			card_number = re.sub(r"[A-Z]", "", card_number)
		max_card_number = re.search(r"<small>/([^<]*)</small>", item_list[0])
		if not max_card_number is None:
			max_card_number = max_card_number.group(1)

		card_link = item_list[1].strip()
		if card_link == "":
			card_page = ""
		else:
			card_page = re.search(r"\[\[([^\|]*)", card_link).group(1)
		card_name = re.sub(r"\[\[[^\|]*\|", "", card_link).replace("]]", "").strip()
		card_rarity = "aucune"
		if not is_promo:
			card_rarity = item_list[2].replace(" {{Rareté JCC|", "").replace(" {{rareté JCC|", "").replace("}}", "")

		card_category = None
		card_subcategory = None
		if "type" in item_list[3].lower():
			card_category = "Pokémon"
		else:
			card_subcategory = re.sub(r"\[\[[^\|]*\|", "", item_list[3]).replace("]]", "")
			if "Énergie" in card_subcategory:
				card_category = "Énergie"
			else:
				card_category = "Dresseur"

		time = None
		if not is_promo and len(item_list) > 5 and "symbole jcc" in item_list[4].lower():
			time = item_list[4].lower().replace("{{symbole jcc|temps ", "").replace("}}", "").strip()

		card_info = {
			"expansion": expansion,
			"number": card_number,
			"max_number": max_card_number,
			"link": card_link,
			"page": card_page,
			"name": card_name,
			"rarity": card_rarity,
			"category": card_category,
			"subcategory": card_subcategory,
			"time": time
		}

		card_info_list.append(card_info)
	return card_info_list


def get_other_card_ribbon_info(i):
	other_card = card_info_list[i]
	other_card_number = other_card["number"]
	other_card_name = other_card["name"]
	other_card_article_name = other_card_name
	other_symbol = ""

	symbol_replacements = {
		"{{Symbole JCC|V}}": "-V",
		"{{Symbole JCC|VMAX}}": "-VMAX",
		"{{Symbole JCC|VSTAR}}": "-VSTAR",
		"{{Symbole JCC|ex}}": "-ex",
		"{{Symbole JCC|ex Téracristal}}": "-ex",
		"{{Symbole JCC|ex JCCP}}": "-ex",
		"<small>": "",
		"</small>": ""
	}

	for key, item in symbol_replacements.items():
		tmp = other_card_article_name.replace(key, "")
		if tmp != other_card_article_name:
			other_card_name = other_card_name.replace(key, item)
			if "Symbole JCC" in key:
				other_card_article_name = tmp
				other_symbol += key

	return {
		"card": other_card,
		"number": other_card_number,
		"name": other_card_name,
		"article_name": other_card_article_name,
		"symbol": other_symbol
	}



def get_html_content(url):
	url_content = requests.get(url).content

	filesave = open("page.html", "wb+")
	filesave.write(url_content)
	filesave.close()

	fileread = open("page.html", "r", encoding="utf-8")
	html_content = fileread.read()
	fileread.close()

	return html_content









# Définitions
expansion = "Promo SV"
english_expansion = "SVP Promo"

# expansion = "Écarlate et Violet Aventures Ensemble"
# english_expansion = "Journey Together"

expansion_page = None
abreviation = "SVP"

is_promo = "Promo" in expansion
card_info_list = get_card_info_list(expansion, is_promo)


# Boucle
# r = range(1, len(card_info_list) + 1)
r = range(185, 189)
# r = [53, 159]
r = [p - 1 for p in r]

for i in r:
	print(card_info_list[i]["number"] + " " + card_info_list[i]["name"])
	url_number = str(int(re.sub(r"[A-Z]*", "", card_info_list[i]["number"])))

	# Nom anglais et japonais
	english_url = f"https://limitlesstcg.com/cards/{abreviation}/{url_number}/"
	english_content = get_html_content(f"https://limitlesstcg.com/cards/{abreviation}/{url_number}/")
	# print("English page fetched!")

	english_soup = BeautifulSoup(english_content, 'html.parser')
	english_name = english_soup.find('span', class_='card-text-name').get_text(strip=True)
	japanese_name = None

	other_card_prints = str(english_soup.find('table', class_='card-prints-versions'))
	japanese_card_prints = other_card_prints[other_card_prints.find("JP. Prints"):]
	japanese_url_search = re.search(r'<a href="([^">]*?)">', japanese_card_prints)
	if japanese_url_search:
		japanese_url = "https://limitlesstcg.com/" + japanese_url_search.group(1)

		japanese_content = get_html_content(japanese_url)
		# print("Japanese page fetched!")
		japanese_soup = BeautifulSoup(japanese_content, 'html.parser')
		japanese_name = japanese_soup.find('span', class_='card-text-name').get_text(strip=True)

	card_info_list[i]["english_name"] = english_name
	card_info_list[i]["japanese_name"] = japanese_name

	# Regular content
	html_content = get_html_content(f"https://limitlesstcg.com/cards/fr/{abreviation}/{url_number}/")
	# print("French page fetched!")

	wikicode = generate_wikicode(html_content, card_info_list[i])

# Identical cards
if not is_promo:
	for i in r:
		card = card_info_list[i]
		identical_cards = []

		for j in r:
			if i != j:
				other_card = card_info_list[j]
				if card["name"] == other_card["name"] and card["faculties"] == other_card["faculties"]:
					identical_cards.append(other_card["page"])

		if identical_cards != []:
			identical_cards_paragraph = "<!-- Cartes identiques -->"
			j = 1
			for identical_card in identical_cards:
				str_j = str(j)
				if j == 1:
					str_j = ""
				identical_cards_paragraph += "\n| carte-identique" + str_j + "=" + identical_card
				j += 1

			card["text_box"] = card["text_box"].replace("\n}}", "\n\n" + identical_cards_paragraph + "\n}}")

for i in r:
	card = card_info_list[i]	

	page = card["page"].replace(":", "$")
	text_box = card["text_box"].replace(" ", " ")
	text_box = card["text_box"].replace(" .", ".")
	text_box = re.sub(r"  +", " ", text_box)
	text_box = text_box.replace("- {{type", "-{{type")

	file = open(f"Extensions/{expansion}/{page}.txt".replace(":", "-"), "w+", encoding="utf-8")
	file.write(text_box)
	file.close()