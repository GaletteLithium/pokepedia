from item_dict import *
from move_dict import *
from poke_dict import *
from type_dict import *

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

poke_list = []
notes_list = []
difficulty_list = []
teratype_list = []
ability_list = []
moves_list = []
add_moves_list = []

items_list = []
items_quantity_list = []
items_bracket_list = []

while c.find('<td class="pkmn">', i + 5) != -1:
	i = findp(c, '<td class="pkmn">', i)

	nb_poke_line = 0
	tr = '<tr>'
	while findp(c, '<td class="pkmn">', i + 5) < findp(c, '<td>', i + 5):
		nb_poke_line += 1
		i = findp(c, tr + '<td class="pkmn">', i + 5)
		if nb_poke_line > 6:
			raise IndexError
		tr = ''
		poke_beginning = findp(c, ">", i + 22) + 1
		poke_end = findp(c, "<", poke_beginning)
		poke_name = c[poke_beginning:poke_end].replace("Ã©", "é")
		poke_nom = POKE_DICT[poke_name]
		poke_list.append(poke_nom)




	## Jeu
	if c.find('<b>Game?</b>', i + 1) != -1:
		i = c.find('<b>Game?</b>', i + 1) - 1
	for j in range(nb_poke_line):
		if findp(c, '<b>Game?</b>', i + 1) > findp(c, '<a ', i + 1):
			notes_list.append("")
		else:
			i = findp(c, '<b>Game?</b>', i + 1)
			game_beginning = findp(c, '>', i + 14) + 1
			game_end = findp(c, '<', game_beginning)
			game_name = c[game_beginning:game_end]
			match game_name:
				case "Scarlet":
					notes_list.append("Exclusif à Écarlate")
				case "Violet":
					notes_list.append("Exclusif à Violet")
				case other:
					notes_list.append("")

	## Difficulté
	if c.find('<b>Star Level</b>', i + 1) != -1:
		i = c.find('<b>Star Level</b>', i + 1) - 1
	for j in range(nb_poke_line):
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

	## Type Téracristal
	for j in range(nb_poke_line):
		i = findp(c, '<b>Tera Type</b>', i + 1)
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

	## Talent
	for j in range(nb_poke_line):
		i = findp(c, '<b>Ability?</b>', i + 1)
		ability_beginning = findp(c, '>', i + 16) + 1
		ability_end = findp(c, '<', ability_beginning)
		ability_name = c[ability_beginning:ability_end]
		match ability_name:
			case "Random":
				ability_list.append("Impossible")
			case "Standard":
				ability_list.append("Impossible")
			case "Hidden Possible":
				ability_list.append("Possible")
			case "Hidden Ability":
				ability_list.append("Toujours")
			case other:
				print("[WARNING] Undetected ability case: {}.".format(ability_name))
				ability_list.append("")


	## Capacités
	is_additional_move = False
	current_moves = []
	current_add_moves = []

	i = findp(c, '<b>Moves</b>', i + 1)
	while findp(c, 'Moves</b>', i + 1) < findp(c, '<b>Item Drops</b>', i + 1):
		next_move = findp(c, "<a", i + 1)
		next_cell = findp(c, '<b>', i + 1)
		while next_move <= next_cell:
			i = findp(c, ">", next_move) + 1
			next_move_end = findp(c, "<", i)
			move_name = c[i:next_move_end]
			if move_name != "":
				move_nom = MOVE_DICT[move_name]

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
		
	i -= 1

	## Objets
	for j in range(nb_poke_line):
		i = findp(c, '<b>Item Drops</b>', i + 1)
		while findp(c, 'title=', i + 1) < findp(c, '</tbody>', i + 1):
			items = []
			item_quantities = []
			item_brackets = []
			next_item = findp(c, "title=", i + 1)
			next_cell = findp(c, '</tbody>', i + 1)
			while next_item <= next_cell:
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
									case other:
										item_brackets.append(next_bracket.replace(".", ","))
							case other:
								print("[WARNING] Unusual bracket tag:", c[next_quantity_end:next_tag_end])
								item_brackets.append("")

			items_list.append(items)
			items_quantity_list.append(item_quantities)
			items_bracket_list.append(item_brackets)



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


ans_pokemon = "{{#invoke:TestMatt|teracristal|localisations=non|"
ans_items = "{{#invoke:TestMatt|objet|"

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
	fw.write(ans_pokemon + "\n\n\n" + ans_items)

print("Done!")
