#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Utilitaire de téléchargement de masse depuis Poképédia
Écrit par SombrAbsol, revu et corrigé par ChatGPT

Ce programme permet de télécharger tous les médias
d'une liste d'URL de pages fichier de Poképédia.
Vous pouvez récupérer ces URL à partir d'AutoWikiBrowser
(par exemple à l'aide du nom de catégorie des médias)
et les enregistrer dans un fichier "urls.txt".
Les URL doivent être de la forme
https://pokepedia.fr/Fichier:nom_fichier.extension

Pour utiliser ce programme, installez les bibliothèques
externes requises en exécutant la commande
"pip install requests beautifulsoup4"
depuis un terminal de commandes.
"""

import requests
from bs4 import BeautifulSoup
import urllib.parse
import os

def download(url):
    encoded_url = urllib.parse.quote(url, safe=":/")
    response = requests.get(encoded_url)
    if response.status_code == 200:
        soup = BeautifulSoup(response.text, "html.parser")
        og_image_tag = soup.find("meta", {"property": "og:image"})
        if og_image_tag:
            media_url = og_image_tag["content"]
            filename = os.path.basename(urllib.parse.urlparse("medias/" + url[29:]).path)
            filename = filename.replace("_", " ")
            path = os.path.join("medias", filename)
            with open(path, "wb") as f:
                f.write(requests.get(media_url).content)
            print(filename + " : téléchargement réussi.")
        else:
            print("\n" + url + "\nBalise <meta property=\"og:image\"> non trouvée.\nTéléchargement impossible.\n")
    else:
        print("\n" + url + "\nErreur lors de la requête HTTP.\nCode d'erreur : " + str(response.status_code) + ".\n")

file = "urls.txt"
folder = "medias"
if os.path.isfile(file):
    if not os.path.exists(folder):
        os.makedirs(folder)
    with open(file, "r", encoding="utf-8") as f:
        urls = f.read().splitlines()
    for url in urls:
        download(url)
else:
    print("Erreur : le fichier " + file + " n'existe pas.")