from ability_dict import *
from item_dict import *
from mark_dict import *
from move_dict import *
from poke_dict import *
from type_dict import *
import re

# https://www.serebii.net/scarletviolet/teraraidbattles/3star.shtml

with open('page.html', 'r') as f:
	c = f.read()

i = 0

def findp(c, str, beginning = 0):
	ans = c.find(str, beginning)
	if ans == -1:
		return (len(c))
	return ans

global_difficulty = None
if "Tera Raid Battles - " in c:
	global_difficulty_beginning = findp(c, "- ", findp(c, "Tera Raid Battles - ")) + 2
	global_difficulty_end = findp(c, " Star", global_difficulty_beginning)
	global_difficulty = c[global_difficulty_beginning:global_difficulty_end]
else:
	global_difficulty = 5 # todo remove 5 input("Global difficulty? ")

c = c.replace(" (", "<br>(") #RAW !

poke_list = []
notes_list = []
difficulty_list = []
mark_list = []
teratype_list = []
ability_list = []
moves_list = []
add_moves_list = []
second_week_only_list = []
level_list = []

items_list = []
items_quantity_list = []
items_bracket_list = []

while c.find('<td class="pkmn"', i + 5) != -1:
	i = findp(c, '<td class="pkmn"', i)

	nb_poke_line = 1
	tr = '<tr>'

	poke_beginning = findp(c, ">", i + 22) + 22
	poke_end = findp(c, '"', poke_beginning)
	poke_name = c[poke_beginning:poke_end].replace("Ã©", "é")
	poke_name = poke_name[0].upper() + poke_name[1:] # eevee -> Eevee

	poke_nom = POKE_DICT[poke_name]
	poke_list.append(poke_nom)

	current_note = ""

	# print(poke_nom)

	## Niveau
	i = findp(c, '<b>Level</b>', i + 1)
	level_beginning = findp(c, "Lv.", i + 1) + 4
	level_end = findp(c, '<', level_beginning)
	current_level = c[level_beginning:level_end]
	level_list.append(current_level)

	## Talent
	ability_current_list = []
	end_ability = findp(c, '<b>Moves</b>', i + 1)
	i = findp(c, '<b>Ability?</b>', i + 1)
	hidden_abilities = []
	try:
		hidden_abilities = ABILITY_DICT[poke_name]
	except KeyError:
		()

	while findp(c, '<u>', i + 16) < end_ability:
		ability_beginning = findp(c, '<u>', i + 16) + 3
		ability_end = findp(c, '<', ability_beginning)
		ability_name = c[ability_beginning:ability_end]

		i = ability_beginning

		ability_current_list.append(ability_name)

	all_are_hidden = True
	one_is_hidden = False
	ability_status = ""
	for ability in ability_current_list:
		if ability in hidden_abilities:
			one_is_hidden = True
		else:
			all_are_hidden = False
	match (one_is_hidden, all_are_hidden):
		case (True, True):
			ability_status = "Toujours"
		case (True, False):
			ability_status = "Possible"
		case (False, False):
			ability_status = "Impossible"
		case other:
			print("[WARNING] No abilities were detected.")

	ability_list.append(ability_status)


	## Capacités
	is_additional_move = False
	current_moves = []
	current_add_moves = []

	i = findp(c, '<b>Moves</b>', i + 1)
	next_tera_types = findp(c, '<b>Tera Type</b>', i + 1)
	while findp(c, 'Moves</b>', i + 1) < next_tera_types:
		next_move = findp(c, "<a", i + 1)
		next_cell = findp(c, '<b>', i + 1)
		while next_move <= next_cell:
			i = findp(c, ">", next_move) + 1
			next_move_end = findp(c, "<", i)
			move_name = c[i:next_move_end]
			if move_name != "":
				move_nom = MOVE_DICT[move_name.strip()]

				if is_additional_move:
					current_add_moves.append(move_nom)
				else:
					current_moves.append(move_nom)

			next_move = findp(c, "<a", i + 1)
			next_cell = findp(c, '<b>', i + 1)

		i = next_cell
		is_additional_move = findp(c, '<b>Moves</b>', i) > findp(c, '<b>Additional Moves</b>', i)
		if not is_additional_move:
			moves_list.append(current_moves)
			add_moves_list.append(current_add_moves)
			current_moves = []
			current_add_moves = []
			current_add_moves = []

	# print(moves_list)
	# print(add_moves_list)

	## Type Téracristal
	i = findp(c, '<b>Tera Type</b>', i)
	teratype_beginning = findp(c, '>', i + 17) + 1
	teratype_end = findp(c, '<br>', teratype_beginning)
	teratype_name = c[teratype_beginning:teratype_end]
	match teratype_name:
		case "Random":
			teratype_list.append("")
		case "Default":
			teratype_list.append("Par défaut")
		case other:

			new_teratype_beginning = findp(c, '>', teratype_end) + 1
			new_teratype_end = findp(c, '<', new_teratype_beginning)
			new_teratype_name = c[new_teratype_beginning:new_teratype_end]
			try:
				new_teratype_nom = TYPE_DICT[new_teratype_name]
				teratype_list.append(new_teratype_nom)
			except KeyError:
				print("[WARNING] Non standard tera type encountered: {} / {}.".format(teratype_name, new_teratype_name))
				teratype_list.append("")

	# print(teratype_list)

	## Chromatique
	i = findp(c, '<b>Shiny Rate?</b>', i)
	shiny_beginning = findp(c, '>', i + 14) + 5
	shiny_end = findp(c, '</td>', shiny_beginning)
	shiny_name = c[shiny_beginning:shiny_end].strip()
	current_shiny_status = ""
	match shiny_name:
		case "Never":
			current_shiny_status = "Jamais chromatique."
		case other:
			()

	## Insigne
	i = findp(c, '<b>Mark?</b>', i)
	mark_beginning = findp(c, '>', i + 14) + 1
	mark_end = findp(c, '</td>', mark_beginning)
	mark_name = c[mark_beginning:mark_end].strip()
	current_mark = ""

	match mark_name:
		case "None":
			()
		case other:

			new_mark_beginning = findp(c, '<br>', mark_beginning + 1) + 4
			new_mark_end = findp(c, '<', new_mark_beginning)
			new_mark_name = c[new_mark_beginning:new_mark_end]

			try:
				new_mark_nom = MARK_DICT[new_mark_name.strip()]
				current_mark = new_mark_nom + "."
			except KeyError:
				print("[WARNING] Unknown mark encountered: {} / {}.".format(mark_name, new_mark_name))

	## Capturable
	i = findp(c, '<b>Catchable?</b>', i)
	catchable_beginning = findp(c, '>', i + 14) + 5
	catchable_end = findp(c, '</td>', catchable_beginning)
	catchable_name = c[catchable_beginning:catchable_end].strip()
	current_catchable_status = ""
	match catchable_name:
		case "Only catchable once, can be challenged multiple times":
			current_catchable_status = "Capturable une seule fois."
		case other:
			()

	## Difficulté
	if c.find('<b>Star Level</b>', i + 1) != -1:
		i = c.find('<b>Star Level</b>', i + 1) - 1
	if findp(c, '<b>Star Level</b>', i + 1) > findp(c, '<a ', i + 1):
		if global_difficulty is None:
			print("[WARNING] No difficulty found.")
			difficulty_list.append("0")
		else:
			difficulty_list.append(global_difficulty)
	else:
		i = findp(c, '<b>Star Level</b>', i + 1)
		difficulty_beginning = findp(c, '>', i + 18) + 1
		difficulty_end = findp(c, '<', difficulty_beginning)
		difficulty = c[difficulty_beginning:difficulty_end]
		difficulty_number = 0
		for char in difficulty:
			if char == "â":
				difficulty_number += 1 # Bad encoding of the ☆ character
		difficulty_list.append(str(difficulty_number))

	## Notes
	current_second_week_only_status = ""
	if findp(c, '<b>Notes', i) < findp(c, '<td class="pkmn"', i):
		i = c.find('<b>Notes', i + 1) - 1
		if findp(c, '<b>Notes', i + 1) <= findp(c, '<a ', i + 1):
			i = findp(c, '<b>Notes', i + 1)
			notes_beginning = findp(c, '>', i + 10) + 3
			notes_end = findp(c, '</', notes_beginning)
			notes = c[notes_beginning:notes_end]
			if "run only" in notes:
				current_second_week_only_status = "N'apparaît qu'en deuxième période."




	## Jeu
	current_exclusive_status = ""
	if findp(c, '<b>Game', i) < findp(c, '<td class="pkmn"', i):
		i = c.find('<b>Game', i + 1) - 1
		if findp(c, '<b>Game', i + 1) <= findp(c, '<a ', i + 1):
			i = findp(c, '<b>Game', i + 1)
			game_beginning = findp(c, '>', i + 10) + 3
			game_end = findp(c, '<', game_beginning)
			game_name = c[game_beginning:game_end]
			match game_name:
				case "Scarlet":
					current_exclusive_status = "Exclusif Ec."
				case "Scarlet ONLY":
					current_exclusive_status = "Exclusif Ec."
				case "br>Scarlet":
					current_exclusive_status = "Exclusif Ec."
				case "Violet":
					current_exclusive_status = "Exclusif Vi."
				case "Violet ONLY":
					current_exclusive_status = "Exclusif Vi."
				case "br>Violet":
					current_exclusive_status = "Exclusif Vi."
				case other:
					print("Warning: Game flagged as '{}' but not found.".format(game_name))

	# print(current_exclusive_status)
		
	i -= 1

	## Objets
	for j in range(nb_poke_line):
		i = findp(c, 'Random Item Drops', i + 1)
		end_of_item_table = findp(c, '</tbody>', findp(c, '</tbody>', i + 1) + 1)
		while findp(c, 'title=', i + 1) < end_of_item_table:
			# print(i, c[i:i+50])
			items = []
			item_quantities = []
			item_brackets = []
			next_item = findp(c, "title=", i + 1)
			next_cell = end_of_item_table #findp(c, '</tbody>', i + 1)
			while next_item <= end_of_item_table:
				i = findp(c, '"', next_item) + 1
				next_item_end = findp(c, '"', i)
				item_name = c[i:next_item_end]
				if item_name == "Current Type Tera Shard":
					item_nom = "Téra-Éclat"
					items.append(item_nom)
				elif item_name != "":
					item_nom = ITEM_DICT[item_name]
					if item_nom in ["Perle"]:
						item_nom += " (objet){{!}}" + item_nom
					elif item_nom in ["Banane", "Pomme"]:
						item_nom += " (Paldea){{!}}" + item_nom
					items.append(item_nom)

				next_item = findp(c, "title=", i + 1)
				next_cell = findp(c, '</tbody>', i + 1)

				if item_name != "":
					next_quantity_beginning = findp(c, "*", i) + 1
					if next_quantity_beginning <= next_item:
						next_quantity_end = findp(c, "<", next_quantity_beginning)
						next_quantity = c[next_quantity_beginning:next_quantity_end]
						item_quantities.append(next_quantity)

						next_tag_end = findp(c, ">", next_quantity_end) + 1

						match c[next_quantity_end:next_tag_end]:
							case "</td>":
								item_brackets.append("")
							case "<br>":
								next_bracket_end = findp(c, "<", next_tag_end)
								next_bracket = c[next_tag_end:next_bracket_end]
								match next_bracket:
									case "Guest":
										item_brackets.append("invités")
									case "Host":
										item_brackets.append("hôte")
									case "Once":
										item_brackets.append("unique")
									case other:
										custom_bracket = next_bracket.replace(".", ",").strip()
										if custom_bracket[0] == '(' and custom_bracket[-1] == ')':
											custom_bracket = custom_bracket[1:-1]
										item_brackets.append(custom_bracket)
							case other:
								print("[WARNING] Unusual bracket tag:", c[next_quantity_end:next_tag_end])
								item_brackets.append("")

			items_list.append(items)
			items_quantity_list.append(item_quantities)
			items_bracket_list.append(item_brackets)

	# print(items_list)
	# print(items_quantity_list)
	# print(items_bracket_list)

	current_note = current_exclusive_status + " " + current_mark + " " + current_catchable_status + " " + current_shiny_status + " " + current_second_week_only_status
	current_note = re.sub(" +", " ", current_note)
	notes_list.append(current_note.strip())



# print("Pokémon List:", poke_list)
# print("------")
# print("Notes List:", notes_list)
# print("------")
# print("Difficulty List:", difficulty_list)
# print("------")
# print("Teratype List:", teratype_list)
# print("------")
# print("Ability List:", ability_list)
# print("------")
# print(moves_list)
# print("------")
# print(add_moves_list)
# print("------")
# print("Item List:", items_list)
# print("Item Quantities:", items_quantity_list)
# print("Item Brackets:", items_bracket_list)


ans_pokemon = "{{#invoke:Tableau Pokémon|teracristal|localisations=non|"
ans_items = "{{#invoke:Tableau Objet|teracristal|"

# poke_list = []
# notes_list = []
# teratype_list = []
# ability_list = []
# moves_list = []
# add_moves_list = []

combo = 1
last_pokemon_name = None
last_difficulty = None
for j in range(len(poke_list)):
	pokemon_name = poke_list[j]
	first_bracket_in_pokemon_name = pokemon_name.find("(")
	if first_bracket_in_pokemon_name != -1:
		pokemon_name = pokemon_name[:first_bracket_in_pokemon_name]

	line = ""

	# Determining the "combo" for the number after the header in the items table
	if pokemon_name == last_pokemon_name:
		if last_difficulty == difficulty_list[j]:
			combo += 1
		else:
			combo = 1
			last_difficulty = difficulty_list[j]
	else:
		line = "\n" + pokemon_name
		combo = 1
		last_pokemon_name = pokemon_name
		last_difficulty = difficulty_list[j]
	line += " /"

	if teratype_list[j] != "":
		line += " type-téracristal(" + teratype_list[j] + ")"
	if ability_list[j] != "":
		line += " talent-caché(" + ability_list[j] + ")"
	line += " difficulté(" + difficulty_list[j] + ")"
	line += " niveau(" + level_list[j] + ")"
	if moves_list[j] != [] or add_moves_list[j] != []:
		line += " capacités("
		first_move = True
		for move in moves_list[j]:
			if first_move:
				first_move = False
			else:
				line += ", "
			line += move
		if add_moves_list[j] != []:
			line += "; "
			first_move = True
			for move in add_moves_list[j]:
				if first_move:
					first_move = False
				else:
					line += ", "
				line += move
		line += ")"
	if notes_list[j] != '':
		line += " notes(" + notes_list[j] + ")"
	ans_pokemon += line


	items_pokemon = poke_list[j] + "_" + difficulty_list[j]
	if combo > 1:
		items_pokemon += "_" + str(combo)

	for k in range(len(items_list[j])):
		line_item = items_list[j][k] + " / " + items_quantity_list[j][k]
		if items_bracket_list[j][k] != "":
			line_item += " / " + items_bracket_list[j][k]
		items_pokemon += "\n" + line_item
	ans_items += "\n\n" + items_pokemon

ans_pokemon += "\n}}"
ans_items += "\n}}"

# print(ans_pokemon)
# print("\n")
# print(ans_items)

with open('output.txt', 'w+') as fw:
	fw.write(ans_pokemon + "\n\n== Récompenses ==\n\n" + ans_items + "\n\n{{Cristaux de raid|événementiel=oui}}")

print("Done!")
