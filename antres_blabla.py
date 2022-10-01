import sys

while True:
	inp = input()

	l = [int(inp), int(inp) + 1]

	print("""\n=== Faisceau de lumière rouge ===
:;Pokémon

{{{{#lst:Antre {0}|Pokémon}}}}

:;Récompenses

{{{{#lst:Antre {0}|Récompenses}}}}

=== Faisceau de lumière mauve ===
:;Pokémon

{{{{#lst:Antre {1}|Pokémon}}}}

:;Récompenses

{{{{#lst:Antre {1}|Récompenses}}}}\n""".format(l[0], l[1]))