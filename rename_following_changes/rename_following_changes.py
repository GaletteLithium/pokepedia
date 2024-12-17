import os
import sys


print("Beginning moving files.")

args = sys.argv
if len(args) % 2 != 1:
	raise Error("Invalid number of arguments.")

print("Keys found:")

file = open("changes.csv", "r", encoding="utf-8")

lines = file.readlines()
replacements = []
for line in lines:
	line_split = line.replace("\n", "").split("\t")
	replacements.append((line_split[0], line_split[1]))
	print("{} -> {}".format(line_split[0], line_split[1]))
print("")

bonus_replacements = [("mâle", "♂"), ("femelle", "♀"), ("Buyo", "Buyō")]
for t in bonus_replacements:
	print("{} -> {}".format(t[0], t[1]))
	replacements.append(t)

path = "Older (v1.0.0) - Copie/"
files = os.listdir(path)

print("Analyzing {} files...".format(len(files)))

cpt = 0
for file in files:
	new_name = file
	for r_old, r_new in replacements:
		new_name = new_name.replace(r_old, r_new)
	if file != new_name:
		cpt += 1
	os.rename(path+file, path+new_name)

print("Done! {} files moved.".format(cpt))




file = open("remove.csv", "r", encoding="utf-8")

cpt = 0
lines = file.readlines()
replacements = []
for line in lines:
	filename = path + "Sprite " + line.strip() + " HOME.png"
	try:
		os.remove(filename)
		cpt += 1
	except FileNotFoundError:
		print("Could not remove {0}.".format(filename))

print("Done! {} files removed.".format(cpt))
