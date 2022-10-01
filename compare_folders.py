from matplotlib.image import imread, imsave
import numpy as np
import glob
import os
from PIL import Image
import re

epsilon			= 0.0001
is_rgba			= True

original_path		= "Originaux/"
comparison_path		= "Comparaisons/"
results_path		= "Résultats/"

# Directory cleaning
try:
	if not os.path.exists(results_path):
		os.makedirs(results_path)
	else:
		files = glob.glob(results_path + "*.png", recursive=True)

		for f in files:
			try:
				os.remove(f)
			except OSError as e:
		 		print("Error: %s : %s" % (f, e.strerror))

except OSError as e:
	print(e.strerror)


# Routine applied on all images


original_files 		= glob.glob(original_path + "*.png", recursive=True)
comparison_files	= glob.glob(comparison_path + "*.png", recursive=True)

for image_number in range(len(original_files)):
	original_imname		= re.sub(r".*\\", "", original_files[image_number])
	comparison_imname	= re.sub(r".*\\", "", comparison_files[image_number])

	original_image		= imread(original_path + original_imname, "r")
	comparison_image	= imread(comparison_path + comparison_imname, "r")

	if len(original_image) != len(comparison_image) or len(original_image[0]) != len(comparison_image[0]):
		print("Images", original_imname, "and", comparison_imname, "don't have the same size.")

		j = Image.fromarray((np.array(original_image) * 255).astype(np.uint8))
		j.save(results_path + original_imname)

		continue



	# Comparing the two images

	images_are_the_same 	= True

	result_image		= np.zeros_like(original_image)

	for x in range(len(original_image)):
		for y in range(len(original_image[x])):
			if (abs(original_image[x][y] - comparison_image[x][y]) >= epsilon).any():
				images_are_the_same = False

				# for z in range(len(original_image[x][y])):
				# 	result_image[x][y][z] = original_image[x][y][z]

				result_image[x][y] = [1., 0., 0., 1.]

	if not images_are_the_same:
		print(original_imname, "\t", comparison_imname, "\tare not the same.")

		j = Image.fromarray((np.array(result_image) * 255).astype(np.uint8))
		j.save(results_path + original_imname)