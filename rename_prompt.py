import os
from tkinter import Tk, Label, Entry, Button
from PIL import Image, ImageTk

class RenameWindow:
    def __init__(self, master, file_path):
        self.master = master
        self.master.state("zoomed") # ajouter pour afficher la fenêtre en plein écran
        self.file_path = file_path
        self.filename = os.path.basename(file_path)
        self.master.title(f"Renommer {self.filename}")

        self.label = Label(self.master, text="Nouveau nom :")
        self.label.pack()

        self.entry = Entry(self.master)
        self.entry.pack()
        self.entry.bind('<Return>', self.rename) # ajouter un bind pour la touche entrée
        self.entry.focus_set() # ajouter un focus sur le champ de saisie

        self.img = Image.open(file_path)
        self.img = self.img.resize((320,320))
        self.photo = ImageTk.PhotoImage(self.img)
        self.label_img = Label(self.master, image=self.photo)
        self.label_img.pack()

        self.rename_button = Button(self.master, text="Renommer", command=self.rename)
        self.rename_button.pack()
        self.master.attributes("-topmost", True) # ajouter pour mettre la fenêtre en avant-plan
        self.master.attributes("-topmost", False) # ajouter pour mettre la fenêtre en avant-plan
        self.master.update()

    def rename(self, event=None): # Ajouter un argument event pour gérer le bind
        new_name = self.entry.get()
        new_path = os.path.join(os.path.dirname(self.file_path), new_name)
        os.rename(self.file_path, new_path + ".png")
        self.master.destroy()

folder_path = "." # remplacer par le chemin du dossier

for filename in os.listdir(folder_path):
    file_path = os.path.join(folder_path, filename)
    if not filename.endswith('.jpg') and not filename.endswith('.png'):
        continue
    root = Tk()
    my_gui = RenameWindow(root, file_path)
    root.mainloop()