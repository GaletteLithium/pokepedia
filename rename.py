import os
import sys
import re


print("Beginning moving files.")
regexp = False

args = sys.argv
if len(args) % 2 != 1:
	raise Error("Invalid number of arguments.")

print("Keys found:")

replacements = []
for i in range(1, len(args), 2):
	replacements.append((args[i], args[i + 1]))
	print("{} -> {}".format(args[i], args[i + 1]))
print("")

bonus_replacements = [("mâle", "♂"), ("femelle", "♀"), ("Buyo", "Buyō")]
for t in bonus_replacements:
	print("{} -> {}".format(t[0], t[1]))
	replacements.append(t)

path = "./"
files = os.listdir(path)

print("Analyzing {} files...".format(len(files)))

cpt = 0
for file in files:
	new_name = file
	for r_old, r_new in replacements:
		if regexp:
			new_name = re.sub(r_old, r_new, new_name)
		else:
			new_name = new_name.replace(r_old, r_new)
	if file != new_name:
		cpt += 1
	os.rename(path+file, path+new_name)

print("Done! {} files moved.".format(cpt))

