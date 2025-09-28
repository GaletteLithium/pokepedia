from util import pokemon, pokemon_en

filename = "card_list_BLK"
path_file = "Traductions/"

file = open(path_file + filename + ".txt", "r", encoding = "utf-8")
text = file.read()

# \| ([0-9]+)/([0-9]+) \|\| \{\{TCG ID\|Space-Time Smackdown\|([^\|]*)\|([0-9]+)\}\} \|\| \{\{TCG Icon\|([^\}]*)\}\}([^\n]*?) \|\| \{\{Rar/TCGP\|([^\|]*)\|([0-9])\}\}
# \| ([0-9]+)/([0-9]+) \|\| \{\{TCG ID\|Space-Time Smackdown\|([^\|]*) ex\|([0-9]+)\|([^\}]*)\}\}([^\n]*?) \|\| \{\{TCG Icon\|([^\}]*)\}\} \|\| \{\{Rar/TCGP\|([^\|]*)\|([0-9])\}\}
# 1 -> 001
# vocabulaire (types, supporter, objet, outil pokémon...)

for i in range(len(pokemon)):
	for particle in [" (", "-ex", "]]"]:
		text = text.replace(pokemon_en[i] + particle, pokemon[i] + particle)

print(text)
writefile = open(path_file + filename + "_translated.txt", "w+", encoding = "utf-8")
writefile.write(text)
