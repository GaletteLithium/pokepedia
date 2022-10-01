# file = open("ndex_en.txt", "r")
# text = file.read()
# file.close()

# output_file = open("output", "w+", encoding="utf-8")

# pokelist = [a.split(";") for a in text.split("\n")]

# for pokemon in pokelist:
# 	number = pokemon[0]
# 	name = pokemon[1]
# 	name_fr = dict_fr[int(number)]

# 	for i in range(20):
# 		output_file.write('powershell -command "& { iwr https://www.pokemonkidswinterfest.com/badges/large/'
# 			+ number + "_" + name + "_CA-" + str(i) + ".png -OutFile 'CA/" + name_fr + ' (' + str(i) + ")-CA.png'" + ' }"\n')

# output_file.close()

# 10-20 stopped at Ferrothorn
# 0-10 stopped at Greninja

file = open("extra2.txt", "r", encoding="utf-8")
text = file.read()
file.close()

output_file = open("output", "w+", encoding="utf-8")

pokelist = [a.split(";") for a in text.split("\n")]

for pokemon in pokelist:
	number = pokemon[0]
	name = pokemon[1]
	name_fr = pokemon[2]

	output_file.write('powershell -command "& { iwr https://www.pokemonkidswinterfest.com/badges/large/'
				+ number + "_" + name + "_CA.png -OutFile 'CA/" + name_fr + "-CA.png'" + ' }"\n')

	for i in range(20):
		output_file.write('powershell -command "& { iwr https://www.pokemonkidswinterfest.com/badges/large/'
			+ number + "_" + name + "_CA-" + str(i) + ".png -OutFile 'CA/" + name_fr + ' (' + str(i) + ")-CA.png'" + ' }"\n')

output_file.close()