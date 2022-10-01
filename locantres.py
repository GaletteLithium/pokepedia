import sys

l					= sys.argv.copy()
first_time				= True

while len(l) >= 3:
	if first_time:
		first_time		= False
	else:
		print("|-")
	first_location			= l[1]
	first_letter			= l[2]

	try:
		second_location		= l[3]
		second_letter		= l[4]

		print(('| [[Fichier:{0} Antre {1} EB.png|300px]]\n' +
		       '| [[Fichier:{2} Antre {3} EB.png|300px]]\n' +
		       '|-\n' +
		       '| [[{0}/Antres|{0}]]\n' +
		       '| [[{2}/Antres|{2}]]').format(first_location, first_letter, second_location, second_letter))
		
		l[1:] = l[5:]

	except IndexError:
		print(('| colspan="2" | [[Fichier:{0} Antre {1} EB.png|300px]]\n' +
		       '|-\n' +
		       '| colspan="2" | [[{0}/Antres|{0}]]').format(first_location, first_letter))

		l[1:] = l[3:]

