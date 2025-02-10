import os
from PIL import Image

folder_path = "." # remplacer par le chemin du dossier

for filename in os.listdir(folder_path):
    file_path = os.path.join(folder_path, filename)
    if not filename.endswith('.jpg') and not filename.endswith('.png'):
        continue
    # ouvrir l'image
    img = Image.open(file_path)
    # utiliser la méthode getbbox pour récupérer les dimensions de l'image sans le bord transparent
    bg = Image.new(mode='RGBA', size=img.size, color=(0, 0, 0, 0))
    img = Image.composite(img, bg, img)
    img = img.crop(img.getbbox())
    # enregistrer l'image modifiée
    img.save(file_path)