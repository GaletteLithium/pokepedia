expansion		= "Promo SV"
abrv			= "SVP"
# expansion		= "Écarlate et Violet Aventures Ensemble"
# abrv			= "JTG"
prefixe_num		= ""
suffixe_num		= ""
complete_number_entry	= True
complete_number_out	= True
max_number		= 193
max_digits		= 3
ans				= ""

def get_url(card_num):
	# return "https://assets.pokemon.com/assets/cms2-fr-fr/img/cards/web/{0}/{0}_FR_{1}.png".format(abrv, card_num)
	# return "https://dz3we2x72f7ol.cloudfront.net/expansions/stellar-crown/fr-fr/{0}_FR_{1}.png".format(abrv, card_num)
	return "https://limitlesstcg.nyc3.digitaloceanspaces.com/tpci/{0}/{0}_{1}{2}_R_FR.png".format(abrv, card_num, suffixe_num)
	# return "https://limitlesstcg.nyc3.cdn.digitaloceanspaces.com/tpc/SM12a/SM12a_{0}_R_JP.png".format(card_num)

# for i in [67, 150, 177, 198, 200]:
for i in range(173, max_number + 1):
	string_i			= str(i)
	complete_string_i	= prefixe_num + "0" * (max_digits - len(string_i)) + string_i
	string_i			= prefixe_num + string_i

	card_num_entry		= complete_string_i if complete_number_entry else string_i
	card_num_out		= complete_string_i if complete_number_out   else string_i

	print('wget -O "Extensions/{0}/Carte {0} {1}{3}.png" "'.format(expansion, card_num_out, " " + prefixe_num if prefixe_num != "" else "", suffixe_num)
		+ get_url(card_num_entry) + '"')
