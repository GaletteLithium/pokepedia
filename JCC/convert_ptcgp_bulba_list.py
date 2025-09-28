# LICENSE: SombrAbsol
# (lui taper dessus si quelque chose ici ne fonctionne pas)

import re

DATA_FILE = "cards_en.txt"
OUTPUT_FILE = "cards_fr.txt"
EN_NAMES_FILE = "names_en.txt"
FR_NAMES_FILE = "names_fr.txt"

DEFAULT_EXTENSION_NAME = "Gardiens Astraux"
BOOSTER_NAMES_LIST = ["Solgaleo", "Lunala"]
TYPE_ICONS = {
    "Grass": "plante", "Fire": "feu", "Water": "eau", "Lightning": "électrique",
    "Psychic": "psy", "Fighting": "combat", "Darkness": "obscurité",
    "Metal": "métal", "Dragon": "dragon", "Colorless": "incolore"
}

def load_list_from_file(filename):
    with open(filename, encoding="utf-8") as f:
        return [line.strip() for line in f if line.strip()]

def create_translation_dict(en_names, fr_names):
    return dict(zip(en_names, fr_names))

def extract_total_card_count(lines):
    total = 0
    for line in lines:
        if match := re.search(r"\|\s*\d{3}/(\d{3})", line):
            total = max(total, int(match.group(1)))
    return total

def detect_boosters(lines):
    booster_line = next((l for l in lines if l.startswith("{{TCG Set List/header/packs|")), "")
    found = [b for b in re.findall(r"\|([^|{}]+)", booster_line) if "=" not in b]
    return BOOSTER_NAMES_LIST[:len(found)] if found else BOOSTER_NAMES_LIST[:1]

def detect_promo_extension(lines):
    if match := re.search(r"\|\s*\d{3}/P-([A-Z]+)", "\n".join(lines)):
        return True, f"Promo-{match.group(1)}"
    return False, DEFAULT_EXTENSION_NAME

def translate_name(name, translator):
    name = name.strip()
    is_ex = name.endswith(" ex")
    base_name = name[:-3] if is_ex else name
    core_name = base_name.replace("Alolan ", "").replace("Paldean ", "").replace("Origin Forme ", "")
    fr_name = translator.get(core_name, core_name)

    suffix = ""
    if "Alolan" in base_name:
        suffix = "<small>d'Alola</small>"
    elif "Paldean" in base_name:
        suffix = "<small>de Paldea</small>"
    elif "Origin Forme" in base_name:
        suffix = "<small>Forme Originelle</small>"

    translated = f"{fr_name} {suffix}".strip()
    if is_ex:
        translated += "-ex"

    return translated

def extract_rarity(line):
    match = re.search(r"\{\{(?:Rar/TCGP|rar/TCGP)\|([^|}]+)(?:\|(\d+))?", line)
    if not match:
        return "1 losange"
    r_type, r_val = match.group(1), match.group(2)
    if r_type == "Diamond" and r_val:
        return f"{r_val} losange{'s' if int(r_val) > 1 else ''}"
    elif r_type == "Star" and r_val:
        return f"{r_val} étoile{'s' if int(r_val) > 1 else ''}"
    elif r_type == "Crown":
        return "couronne"
    elif r_type == "Shiny" and r_val:
        return f"chromatique {r_val}"
    return "1 losange"

def extract_type(line):
    for icon, type_fr in TYPE_ICONS.items():
        if f"{{{{TCG Icon|{icon}}}}}" in line:
            return f"{{{{Type|{type_fr}|jcc}}}}"
    if "{{TCG Icon|Item}}" in line:
        return "[[Carte Objet|Objet]]"
    elif "{{TCG Icon|Pokémon Tool}}" in line:
        return "[[Carte Outil Pokémon|Outil Pokémon]]"
    elif "{{TCG Icon|Supporter}}" in line:
        return "[[Carte Supporter|Supporter]]"
    return "–"

def generate_table(lines, translator, boosters, is_promo, extension_name):
    table = '''{| class="tableaustandard sortable centre"
! Numéro
! Nom de la carte
! Type
! Obtention''' if is_promo else '''{| class="tableaustandard sortable centre entetefixe"
! rowspan="2" | Numéro
! rowspan="2" | Nom de la [[Carte Pokémon|carte]]
! rowspan="2" | [[Rareté]]
! rowspan="2" | Type'''

    if len(boosters) > 1 and not is_promo:
        table += f'\n! colspan="{len(boosters)}" | [[Booster (JCC)|Booster]] d\'obtention\n|-'
        for booster in boosters:
            table += f'\n! [[Fichier:Logo Booster {extension_name} {booster} JCCP.png|Booster {booster}|x25px]]'
    table += "\n|-"

    for line in lines:
        if not line.startswith("|"):
            continue

        columns = [c.strip() for c in line.split("||")]
        if len(columns) < 2:
            continue

        if not (match := re.match(r"\|\s*(\d{3})/(\d{3}|P-[A-Z]+)", columns[0])):
            continue
        number = f"{match.group(1)}<small>/{match.group(2)}</small>"

        if not (name_match := re.search(r"\{\{TCG ID\|[^|]+\|([^|}]+)", columns[1])):
            continue
        name_en = name_match.group(1)
        dispalyed_name_fr = translate_name(name_en, translator)
        name_fr = (
                    dispalyed_name_fr.replace("<small>d'Alola</small>", "d'Alola")
                        .replace("<small>de Paldea</small>", "de Paldea")
                        .replace("<small>Forme Originelle</small>", "Forme Originelle")
                  )

        rarity = extract_rarity(line)
        type_ = extract_type(line)

        link = f"[[{name_fr} ({extension_name} {match.group(1)})|{dispalyed_name_fr}]]"
        link = (
            link.replace("-ex]]", "]]{{Symbole JCC|ex JCCP}}")
        )

        final_line = f"|-\n| {number}\n| {link}\n| {type_}"
        if is_promo:
            obtained = columns[3] if len(columns) > 3 else "N/A"
            final_line += f"\n| {obtained}"
        else:
            final_line = f"|-\n| {number}\n| {link}\n| {{{{Rareté JCC|{rarity}}}}}\n| {type_}"
            if len(boosters) > 1:
                availability = [
                    'class="résistance" | ✓' if len(columns) > 4 + i and "{{yes}}" in columns[4 + i].lower()
                    else 'class="faiblesse" | ✗'
                    for i in range(len(boosters))
                ]
                for status in availability:
                    final_line += f"\n| {status}"

        table += f"\n{final_line}"

    table += "\n|}"
    return table.replace("\n\n", "\n").replace("|-\n|-", "|-")

def main():
    en_names = load_list_from_file(EN_NAMES_FILE)
    fr_names = load_list_from_file(FR_NAMES_FILE)
    lines = load_list_from_file(DATA_FILE)

    translator = create_translation_dict(en_names, fr_names)
    total_cards = extract_total_card_count(lines)
    boosters = detect_boosters(lines)
    is_promo, extension_name = detect_promo_extension(lines)

    table = generate_table(lines, translator, boosters, is_promo, extension_name)

    with open(OUTPUT_FILE, "w", encoding="utf-8") as f_out:
        f_out.write(table)

    print(f"Le tableau a été enregistré ({len(boosters)} booster(s), extension : {extension_name}, total affiché : {total_cards})")

if __name__ == "__main__":
    main()
