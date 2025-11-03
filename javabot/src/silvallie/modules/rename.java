package silvallie.modules;

import silvallie.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class rename {
	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = Silvallie.beginRun();

		String[] pageList = {"Fichier:Icône 0001 chromatique CM.png", "Fichier:Icône 0001 chromatique CM-v1.png", "Fichier:Icône 0001 CM.png", "Fichier:Icône 0001 Couronne de fête chromatique CM.png", "Fichier:Icône 0001 Couronne de fête CM.png", "Fichier:Icône 0001 Troisième anniversaire chromatique CM.png", "Fichier:Icône 0001 Troisième anniversaire CM.png", "Fichier:Icône 0004 CM.png", "Fichier:Icône 0004 DJ CM.png", "Fichier:Icône 0004 Troisième anniversaire CM.png", "Fichier:Icône 0006 chromatique CM.png", "Fichier:Icône 0006 CM.png", "Fichier:Icône 0006 Peintre chocolatier chromatique CM.png", "Fichier:Icône 0006 Peintre chocolatier CM.png", "Fichier:Icône 0007 Chapeau Carapace chromatique CM.png", "Fichier:Icône 0007 Chapeau Carapace CM.png", "Fichier:Icône 0007 chromatique CM.png", "Fichier:Icône 0007 CM.png", "Fichier:Icône 0007 Imperméable à pois chromatique CM.png", "Fichier:Icône 0007 Imperméable à pois CM.png", "Fichier:Icône 0007 Troisième anniversaire chromatique CM.png", "Fichier:Icône 0007 Troisième anniversaire CM.png", "Fichier:Icône 0025 Agriculteur ♀ CM.png", "Fichier:Icône 0025 Agriculteur ♂ CM.png", "Fichier:Icône 0025 Cadre fleuri ♀ CM.png", "Fichier:Icône 0025 Cadre fleuri ♂ CM.png", "Fichier:Icône 0025 Casquette de détective ♀ CM.png", "Fichier:Icône 0025 Casquette de détective ♂ CM.png", "Fichier:Icône 0025 Chef ♀ CM.png", "Fichier:Icône 0025 Chef ♂ CM.png", "Fichier:Icône 0025 Fan de Ronflex ♀ CM.png", "Fichier:Icône 0025 Fan de Ronflex ♂ CM.png", "Fichier:Icône 0025 Hakama 2022 ♀ CM.png", "Fichier:Icône 0025 Hakama 2022 ♂ CM.png", "Fichier:Icône 0025 Robe de fête ♀ CM.png", "Fichier:Icône 0025 Robe de fête ♂ CM.png", "Fichier:Icône 0025 Smoking de fête ♀ CM.png", "Fichier:Icône 0025 Smoking de fête ♂ CM.png", "Fichier:Icône 0025 Super chef ♀ CM.png", "Fichier:Icône 0025 Super chef ♂ CM.png", "Fichier:Icône 0025 « Sweets » ♀ CM.png", "Fichier:Icône 0025 « Sweets » ♂ CM.png", "Fichier:Icône 0025 ♀ CM.png", "Fichier:Icône 0025 ♂ CM.png", "Fichier:Icône 0026 Alola CM.png", "Fichier:Icône 0026 Alola Pro des pancakes CM.png", "Fichier:Icône 0037 Alola Cape d'hiver CM.png", "Fichier:Icône 0037 Alola CM.png", "Fichier:Icône 0037 Alola Ensemble fleuri CM.png", "Fichier:Icône 0037 Cape d'hiver CM.png", "Fichier:Icône 0037 CM.png", "Fichier:Icône 0037 Pique-nique savoureux CM.png", "Fichier:Icône 0038 Alola CM.png", "Fichier:Icône 0038 Alola Déguisement festif CM.png", "Fichier:Icône 0039 Ballons flottants chromatique CM.png", "Fichier:Icône 0039 Ballons flottants CM.png", "Fichier:Icône 0039 Ballons flottants CM-v1.png", "Fichier:Icône 0039 chromatique CM.png", "Fichier:Icône 0039 CM.png", "Fichier:Icône 0039 CM-v1.png", "Fichier:Icône 0039 Déguisement festif chromatique CM.png", "Fichier:Icône 0039 Déguisement festif CM.png", "Fichier:Icône 0039 Vacances d'été chromatique CM.png", "Fichier:Icône 0039 Vacances d'été CM.png", "Fichier:Icône 0039 Vacances d'été CM-v1.png", "Fichier:Icône 0052 Alola CM.png", "Fichier:Icône 0052 CM.png", "Fichier:Icône 0052 Hakama 2022 CM.png", "Fichier:Icône 0052 Pelotes espiègles CM.png", "Fichier:Icône 0054 Beignet baigné CM.png", "Fichier:Icône 0054 CM.png", "Fichier:Icône 0058 CM.png", "Fichier:Icône 0067 CM.png", "Fichier:Icône 0067 Randonneur CM.png", "Fichier:Icône 0077 Galar CM.png", "Fichier:Icône 0079 Chef spécial CM.png", "Fichier:Icône 0079 CM.png", "Fichier:Icône 0079 Galar chromatique CM.png", "Fichier:Icône 0079 Galar CM.png", "Fichier:Icône 0079 Galar CM-v1.png", "Fichier:Icône 0079 Kotatsu tout doux CM.png", "Fichier:Icône 0083 CM.png", "Fichier:Icône 0094 CM.png", "Fichier:Icône 0094 Halloween CM.png", "Fichier:Icône 0094 Tablier fleuri CM.png", "Fichier:Icône 0100 Hisui CM.png", "Fichier:Icône 0101 CM.png", "Fichier:Icône 0103 Alola CM.png", "Fichier:Icône 0103 chromatique CM.png", "Fichier:Icône 0103 chromatique CM-v1.png", "Fichier:Icône 0103 CM.png", "Fichier:Icône 0113 CM.png", "Fichier:Icône 0113 Œufs colorés CM.png", "Fichier:Icône 0129 chromatique CM.png", "Fichier:Icône 0129 CM.png", "Fichier:Icône 0130 chromatique CM.png", "Fichier:Icône 0130 CM.png", "Fichier:Icône 0131 CM.png", "Fichier:Icône 0132 CM.png", "Fichier:Icône 0132 Morphing Dracolosse CM.png", "Fichier:Icône 0132 Morphing Pikachu CM.png", "Fichier:Icône 0132 Morphing Évoli CM.png", "Fichier:Icône 0133 Chef ♀ CM.png", "Fichier:Icône 0133 Chef ♂ chromatique CM.png", "Fichier:Icône 0133 Chef ♂ CM.png", "Fichier:Icône 0133 Déguisement festif ♀ CM.png", "Fichier:Icône 0133 Déguisement festif ♂ chromatique CM.png", "Fichier:Icône 0133 Déguisement festif ♂ CM.png", "Fichier:Icône 0133 Festival ♀ CM.png", "Fichier:Icône 0133 Festival ♂ chromatique CM.png", "Fichier:Icône 0133 Festival ♂ CM.png", "Fichier:Icône 0133 Robe de fête ♀ CM.png", "Fichier:Icône 0133 Robe de fête ♂ chromatique CM.png", "Fichier:Icône 0133 Robe de fête ♂ CM.png", "Fichier:Icône 0133 Smoking de fête ♀ CM.png", "Fichier:Icône 0133 Smoking de fête ♂ chromatique CM.png", "Fichier:Icône 0133 Smoking de fête ♂ CM.png", "Fichier:Icône 0133 Super chef ♀ CM.png", "Fichier:Icône 0133 Super chef ♂ chromatique CM.png", "Fichier:Icône 0133 Super chef ♂ CM.png", "Fichier:Icône 0133 « Sweets » ♀ CM.png", "Fichier:Icône 0133 « Sweets » ♂ chromatique CM.png", "Fichier:Icône 0133 « Sweets » ♂ CM.png", "Fichier:Icône 0133 ♀ CM.png", "Fichier:Icône 0133 ♂ chromatique CM.png", "Fichier:Icône 0133 ♂ CM.png", "Fichier:Icône 0134 CM.png", "Fichier:Icône 0134 Halloween CM.png", "Fichier:Icône 0134 Splendeur tropicale CM.png", "Fichier:Icône 0135 CM.png", "Fichier:Icône 0135 Firmament brillant CM.png", "Fichier:Icône 0135 Halloween CM.png", "Fichier:Icône 0136 CM.png", "Fichier:Icône 0136 Festival CM.png", "Fichier:Icône 0136 Halloween CM.png", "Fichier:Icône 0143 Beignet douillet CM.png", "Fichier:Icône 0143 CM.png", "Fichier:Icône 0143 Pyjama gros dodo CM.png", "Fichier:Icône 0149 Casquette Dragon CM.png", "Fichier:Icône 0149 CM.png", "Fichier:Icône 0149 Smoking chocolat CM.png", "Fichier:Icône 0150 CM.png", "Fichier:Icône 0151 Bonne étoile CM.png", "Fichier:Icône 0151 Campeur CM.png", "Fichier:Icône 0151 CM.png", "Fichier:Icône 0151 Potager branché CM.png", "Fichier:Icône 0152 CM.png", "Fichier:Icône 0155 CM.png", "Fichier:Icône 0157 Hisui CM.png", "Fichier:Icône 0157 Hisui Maison de thé CM.png", "Fichier:Icône 0158 CM.png", "Fichier:Icône 0162 Champ de fleurs CM.png", "Fichier:Icône 0162 CM.png", "Fichier:Icône 0172 CM.png", "Fichier:Icône 0172 Thé enchanté CM.png", "Fichier:Icône 0173 CM.png", "Fichier:Icône 0173 Doux firmament CM.png", "Fichier:Icône 0175 Casquette Balle Pic chromatique CM.png", "Fichier:Icône 0175 Casquette Balle Pic CM.png", "Fichier:Icône 0175 chromatique CM.png", "Fichier:Icône 0175 CM.png", "Fichier:Icône 0175 Raffinement flottant chromatique CM.png", "Fichier:Icône 0175 Raffinement flottant CM.png", "Fichier:Icône 0178 CM.png", "Fichier:Icône 0182 CM.png", "Fichier:Icône 0183 CM.png", "Fichier:Icône 0183 Déguisement festif CM.png", "Fichier:Icône 0185 chromatique CM.png", "Fichier:Icône 0185 CM.png", "Fichier:Icône 0195 Chocolatier coquet CM.png", "Fichier:Icône 0195 CM.png", "Fichier:Icône 0196 CM.png", "Fichier:Icône 0197 CM.png", "Fichier:Icône 0197 Halloween CM.png", "Fichier:Icône 0202 chromatique CM.png", "Fichier:Icône 0202 CM.png", "Fichier:Icône 0202 Cône de glace chromatique CM.png", "Fichier:Icône 0202 Cône de glace CM.png", "Fichier:Icône 0209 Chapeau de fée chromatique CM.png", "Fichier:Icône 0209 Chapeau de fée CM.png", "Fichier:Icône 0209 chromatique CM.png", "Fichier:Icône 0209 CM.png", "Fichier:Icône 0212 CM.png", "Fichier:Icône 0215 chromatique CM.png", "Fichier:Icône 0215 CM.png", "Fichier:Icône 0215 Hisui chromatique CM.png", "Fichier:Icône 0215 Hisui CM.png", "Fichier:Icône 0215 Hisui Maison de thé chromatique CM.png", "Fichier:Icône 0215 Hisui Maison de thé CM.png", "Fichier:Icône 0215 Maison de thé chromatique CM.png", "Fichier:Icône 0215 Maison de thé CM.png", "Fichier:Icône 0215 Serveur cool chromatique CM.png", "Fichier:Icône 0215 Serveur cool CM.png", "Fichier:Icône 0216 CM.png", "Fichier:Icône 0216 Délices lunaires CM.png", "Fichier:Icône 0222 CM.png", "Fichier:Icône 0233 CM.png", "Fichier:Icône 0249 CM.png", "Fichier:Icône 0250 CM.png", "Fichier:Icône 0251 Bonne étoile chromatique CM.png", "Fichier:Icône 0251 Bonne étoile CM.png", "Fichier:Icône 0251 chromatique CM.png", "Fichier:Icône 0251 CM.png", "Fichier:Icône 0251 Récolte automnale chromatique CM.png", "Fichier:Icône 0251 Récolte automnale CM.png", "Fichier:Icône 0259 CM.png", "Fichier:Icône 0259 Maître sushi CM.png", "Fichier:Icône 0259 Super maître sushi CM.png", "Fichier:Icône 0272 CM.png", "Fichier:Icône 0281 chromatique CM.png", "Fichier:Icône 0281 CM.png", "Fichier:Icône 0281 Robe d'antan chromatique CM.png", "Fichier:Icône 0281 Robe d'antan CM.png", "Fichier:Icône 0281 Serveur rétro chromatique CM.png", "Fichier:Icône 0281 Serveur rétro CM.png", "Fichier:Icône 0282 chromatique CM.png", "Fichier:Icône 0282 CM.png", "Fichier:Icône 0282 Halloween chromatique CM.png", "Fichier:Icône 0282 Halloween CM.png", "Fichier:Icône 0282 Neige royale chromatique CM.png", "Fichier:Icône 0282 Neige royale CM.png", "Fichier:Icône 0303 Chocolatier coquet CM.png", "Fichier:Icône 0303 CM.png", "Fichier:Icône 0303 Solstice d'été CM.png", "Fichier:Icône 0311 Acclameur énergique chromatique CM.png", "Fichier:Icône 0311 Acclameur énergique CM.png", "Fichier:Icône 0311 chromatique CM.png", "Fichier:Icône 0311 CM.png", "Fichier:Icône 0312 Acclameur énergique chromatique CM.png", "Fichier:Icône 0312 Acclameur énergique CM.png", "Fichier:Icône 0312 chromatique CM.png", "Fichier:Icône 0312 CM.png", "Fichier:Icône 0330 CM.png", "Fichier:Icône 0334 CM.png", "Fichier:Icône 0334 Festival CM.png", "Fichier:Icône 0350 CM.png", "Fichier:Icône 0354 CM.png", "Fichier:Icône 0359 CM.png", "Fichier:Icône 0359 Célébration grandiose CM.png", "Fichier:Icône 0363 CM.png", "Fichier:Icône 0363 Déguisement festif CM.png", "Fichier:Icône 0376 CM.png", "Fichier:Icône 0380 CM.png", "Fichier:Icône 0380 Célébration grandiose CM.png", "Fichier:Icône 0381 CM.png", "Fichier:Icône 0381 Célébration grandiose CM.png", "Fichier:Icône 0385 CM.png", "Fichier:Icône 0385 Étoile souhait CM.png", "Fichier:Icône 0389 CM.png", "Fichier:Icône 0389 Festivités CM.png", "Fichier:Icône 0390 chromatique CM.png", "Fichier:Icône 0390 chromatique CM-v1.png", "Fichier:Icône 0390 CM.png", "Fichier:Icône 0390 Explorateur de mine chromatique CM.png", "Fichier:Icône 0390 Explorateur de mine CM.png", "Fichier:Icône 0393 Bonne année 2022 chromatique CM.png", "Fichier:Icône 0393 Bonne année 2022 CM.png", "Fichier:Icône 0393 chromatique CM.png", "Fichier:Icône 0393 CM.png", "Fichier:Icône 0393 Déguisement festif chromatique CM.png", "Fichier:Icône 0393 Déguisement festif CM.png", "Fichier:Icône 0393 Vacancier chromatique CM.png", "Fichier:Icône 0393 Vacancier CM.png", "Fichier:Icône 0396 chromatique CM.png", "Fichier:Icône 0396 CM.png", "Fichier:Icône 0396 Œufs colorés chromatique CM.png", "Fichier:Icône 0396 Œufs colorés CM.png", "Fichier:Icône 0403 CM.png", "Fichier:Icône 0417 chromatique CM.png", "Fichier:Icône 0417 CM.png", "Fichier:Icône 0417 Thé enchanté chromatique CM.png", "Fichier:Icône 0417 Thé enchanté CM.png", "Fichier:Icône 0418 chromatique CM.png", "Fichier:Icône 0418 CM.png", "Fichier:Icône 0418 Surfeur relax chromatique CM.png", "Fichier:Icône 0418 Surfeur relax CM.png", "Fichier:Icône 0429 CM.png", "Fichier:Icône 0429 Halloween CM.png", "Fichier:Icône 0445 CM.png", "Fichier:Icône 0445 Maître sushi CM.png", "Fichier:Icône 0446 Chapeau Goinfre chromatique CM.png", "Fichier:Icône 0446 Chapeau Goinfre CM.png", "Fichier:Icône 0446 chromatique CM.png", "Fichier:Icône 0446 CM.png", "Fichier:Icône 0448 Bal masqué chromatique CM.png", "Fichier:Icône 0448 Bal masqué CM.png", "Fichier:Icône 0448 Chef chromatique CM.png", "Fichier:Icône 0448 Chef CM.png", "Fichier:Icône 0448 chromatique CM.png", "Fichier:Icône 0448 CM.png", "Fichier:Icône 0448 Déguisement festif chromatique CM.png", "Fichier:Icône 0448 Déguisement festif CM.png", "Fichier:Icône 0448 Super chef chromatique CM.png", "Fichier:Icône 0448 Super chef CM.png", "Fichier:Icône 0470 CM.png", "Fichier:Icône 0471 CM.png", "Fichier:Icône 0471 Petit mousse CM.png", "Fichier:Icône 0478 CM.png", "Fichier:Icône 0478 Neige royale CM.png", "Fichier:Icône 0483 CM.png", "Fichier:Icône 0484 CM.png", "Fichier:Icône 0492 Céleste CM.png", "Fichier:Icône 0492 Terrestre CM.png", "Fichier:Icône 0492 Terrestre Maison de thé CM.png", "Fichier:Icône 0494 Chef ardent CM.png", "Fichier:Icône 0494 CM.png", "Fichier:Icône 0494 Roi des fourneaux CM.png", "Fichier:Icône 0495 CM.png", "Fichier:Icône 0495 Pique-nique savoureux CM.png", "Fichier:Icône 0498 CM.png", "Fichier:Icône 0501 chromatique CM.png", "Fichier:Icône 0501 CM.png", "Fichier:Icône 0501 Vacances d'été chromatique CM.png", "Fichier:Icône 0501 Vacances d'été CM.png", "Fichier:Icône 0508 chromatique CM.png", "Fichier:Icône 0508 CM.png", "Fichier:Icône 0511 CM.png", "Fichier:Icône 0531 chromatique CM.png", "Fichier:Icône 0531 CM.png", "Fichier:Icône 0531 Festival d'été chromatique CM.png", "Fichier:Icône 0531 Festival d'été CM.png", "Fichier:Icône 0547 Clonage CM.png", "Fichier:Icône 0547 CM.png", "Fichier:Icône 0547 Raffinement flottant CM.png", "Fichier:Icône 0549 CM.png", "Fichier:Icône 0549 Déguisement festif CM.png", "Fichier:Icône 0559 CM.png", "Fichier:Icône 0570 CM.png", "Fichier:Icône 0570 Firmament brillant CM.png", "Fichier:Icône 0570 Hisui chromatique CM.png", "Fichier:Icône 0570 Hisui CM.png", "Fichier:Icône 0570 Hisui Déguisement festif chromatique CM.png", "Fichier:Icône 0570 Hisui Déguisement festif CM.png", "Fichier:Icône 0570 Hisui Maison de thé chromatique CM.png", "Fichier:Icône 0570 Hisui Maison de thé CM.png", "Fichier:Icône 0572 As du plumeau chromatique CM.png", "Fichier:Icône 0572 As du plumeau CM.png", "Fichier:Icône 0572 chromatique CM.png", "Fichier:Icône 0572 CM.png", "Fichier:Icône 0575 CM.png", "Fichier:Icône 0575 Touriste chic CM.png", "Fichier:Icône 0587 CM.png", "Fichier:Icône 0587 Ruban ravissant CM.png", "Fichier:Icône 0607 CM.png", "Fichier:Icône 0607 Lanterne élégante CM.png", "Fichier:Icône 0609 chromatique CM.png", "Fichier:Icône 0609 CM.png", "Fichier:Icône 0609 Halloween chromatique CM.png", "Fichier:Icône 0609 Halloween CM.png", "Fichier:Icône 0610 CM.png", "Fichier:Icône 0654 CM.png", "Fichier:Icône 0654 Furisode fleuri CM.png", "Fichier:Icône 0654 Halloween CM.png", "Fichier:Icône 0656 CM.png", "Fichier:Icône 0658 Chef spécial chromatique CM.png", "Fichier:Icône 0658 Chef spécial CM.png", "Fichier:Icône 0658 chromatique CM.png", "Fichier:Icône 0658 CM.png", "Fichier:Icône 0658 Happi de festival chromatique CM.png", "Fichier:Icône 0658 Happi de festival CM.png", "Fichier:Icône 0658 Super chef chromatique CM.png", "Fichier:Icône 0658 Super chef CM.png", "Fichier:Icône 0673 CM.png", "Fichier:Icône 0673 Déguisement festif CM.png", "Fichier:Icône 0674 CM.png", "Fichier:Icône 0677 CM.png", "Fichier:Icône 0677 Halloween CM.png", "Fichier:Icône 0685 Chapeau chantilly chromatique CM.png", "Fichier:Icône 0685 Chapeau chantilly CM.png", "Fichier:Icône 0685 chromatique CM.png", "Fichier:Icône 0685 CM.png", "Fichier:Icône 0700 Chocolatier coquet CM.png", "Fichier:Icône 0700 CM.png", "Fichier:Icône 0700 Festival CM.png", "Fichier:Icône 0704 CM.png", "Fichier:Icône 0704 Coussins macarons CM.png", "Fichier:Icône 0719 CM.png", "Fichier:Icône 0719 Étoiles filantes CM.png", "Fichier:Icône 0720 CM.png", "Fichier:Icône 0722 Bûche festive chromatique CM.png", "Fichier:Icône 0722 Bûche festive CM.png", "Fichier:Icône 0722 Chapeau Plumefeuille chromatique CM.png", "Fichier:Icône 0722 Chapeau Plumefeuille CM.png", "Fichier:Icône 0722 chromatique CM.png", "Fichier:Icône 0722 CM.png", "Fichier:Icône 0722 Lit de pétales chromatique CM.png", "Fichier:Icône 0722 Lit de pétales CM.png", "Fichier:Icône 0722 Majordome chromatique CM.png", "Fichier:Icône 0722 Majordome CM.png", "Fichier:Icône 0725 CM.png", "Fichier:Icône 0725 Halloween CM.png", "Fichier:Icône 0730 CM.png", "Fichier:Icône 0733 CM.png", "Fichier:Icône 0743 CM.png", "Fichier:Icône 0760 CM.png", "Fichier:Icône 0760 Pâtissier annelets CM.png", "Fichier:Icône 0762 CM.png", "Fichier:Icône 0762 CM-v1.png", "Fichier:Icône 0762 Déguisement festif CM.png", "Fichier:Icône 0762 Déguisement festif CM-v1.png", "Fichier:Icône 0762 Étoile magique CM.png", "Fichier:Icône 0762 Étoile magique CM-v1.png", "Fichier:Icône 0778 CM.png", "Fichier:Icône 0778 Halloween CM.png", "Fichier:Icône 0778 Thé enchanté CM.png", "Fichier:Icône 0789 CM.png", "Fichier:Icône 0810 Casquette de batteur CM.png", "Fichier:Icône 0810 CM.png", "Fichier:Icône 0810 Rock'n'Roll CM.png", "Fichier:Icône 0813 Casquette football CM.png", "Fichier:Icône 0813 CM.png", "Fichier:Icône 0813 Ensemble fleuri CM.png", "Fichier:Icône 0813 Vacancier au soleil CM.png", "Fichier:Icône 0816 CM.png", "Fichier:Icône 0816 Matelot CM.png", "Fichier:Icône 0818 CM.png", "Fichier:Icône 0818 Serveur charmant CM.png", "Fichier:Icône 0820 Boulanger artisanal CM.png", "Fichier:Icône 0820 CM.png", "Fichier:Icône 0835 Chef glouton CM.png", "Fichier:Icône 0835 CM.png", "Fichier:Icône 0857 CM.png", "Fichier:Icône 0857 Raffinement flottant CM.png", "Fichier:Icône 0869 Lait Matcha CM.png", "Fichier:Icône 0869 Lait Vanille Chocolatier coquet CM.png", "Fichier:Icône 0869 Lait Vanille CM.png", "Fichier:Icône 0869 Mélange Tricolore CM.png", "Fichier:Icône 0872 CM.png", "Fichier:Icône 0872 Imitation glace CM.png", "Fichier:Icône 0880 CM.png", "Fichier:Icône 0886 CM.png", "Fichier:Icône 0898 CM.png", "Fichier:Icône 0906 Chef amical CM.png", "Fichier:Icône 0906 CM.png", "Fichier:Icône 0908 CM.png", "Fichier:Icône 0908 Halloween CM.png", "Fichier:Icône 0909 Chef amical CM.png", "Fichier:Icône 0909 CM.png", "Fichier:Icône 0912 Chef amical CM.png", "Fichier:Icône 0912 CM.png", "Fichier:Icône 0915 CM.png", "Fichier:Icône 0915 Vacances d'été CM.png", "Fichier:Icône 0922 Chef nostalgique CM.png", "Fichier:Icône 0922 CM.png", "Fichier:Icône 0925 CM.png", "Fichier:Icône 0926 CM.png", "Fichier:Icône 0926 Célébration grandiose CM.png", "Fichier:Icône 0929 CM.png", "Fichier:Icône 0937 CM.png", "Fichier:Icône 0939 CM.png", "Fichier:Icône 0959 CM.png", "Fichier:Icône 0959 Tradition mochi CM.png", "Fichier:Icône 0978 Affalée CM.png", "Fichier:Icône 0978 Courbée CM.png", "Fichier:Icône 0978 Raide CM.png", "Fichier:Icône 0980 CM.png", "Fichier:Icône 0985 CM.png", "Fichier:Icône 1000 CM.png", "Fichier:Icône 1007 CM.png", "Fichier:Icône 1008 CM.png", "Fichier:Icône 1012 CM.png", "Fichier:Icône 1017 CM.png", "Fichier:Icône 1017 Turquoise Nouvel An sportif CM.png"};

		int[] namespaces = {API.NS_FILES};
		boolean isDone = false;
		while (!isDone) {
			isDone = renameDoubleRedirections("pdm2", "PDMTO", pageList, null, true, false);
//			isDone = rename("", "", namespaces, "Capture d'écran de Pokémon Donjon Mystère : Explorateurs du Temps et de l'Ombre", null, true, false);
			System.out.println("\n***** ON HOLD *****\n");
			TimeUnit.SECONDS.sleep(10);
		}

		Silvallie.endRun(startTime);
	}

	/**
	 * Méthode de renommage générique
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au renommage appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param keepRedirect true pour maintenir une redirection entre l'ancien et le nouveau nom, false sinon.
	 * @param justOne true pour s'arrêter après le premier remplacement réussi. Évite de casser plein de pages durant les tests.
	 **/
	private static boolean run(String from, String to, int[] nameSpaces, String categoryName, String firstPageName, boolean keepRedirect, boolean justOne) {
		boolean allUploadedAtFirst = true;
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
				API.FILTER_NONREDIRECTS,
				categoryName
		);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String pageName;
		String newPageName;
		while(page!=null) {
//			if (!page.getTitle().equals("Fichier:Antre de la Cascade localisation PMDM.png")) {
//				page = pageCollection.getNextPage();
//				counter++;
//				continue;
//			}
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				pageName = page.getTitle();

				newPageName = pageName.replaceAll(from, to);

//				newPageName = newPageName.replaceAll("Cap ecran ", "");
//				newPageName = newPageName.replaceAll("Cap écran ", "");
//				newPageName = newPageName.replaceAll("ossatueur", "Ossatueur");
//				newPageName = newPageName.replaceAll("xatu", "Xatu");
//				newPageName = newPageName.replaceAll("trempee", "Trempée");
//				newPageName = newPageName.replaceAll("céleste", "Céleste");
//				newPageName = newPageName.replaceAll("leveinard", "Leveinard");
//				newPageName = newPageName.replaceAll("littorale", "Littorale");
//				if (newPageName.contains("localisation")) {
//					newPageName = newPageName.replace(" localisation", "");
//					newPageName = newPageName.replace("Fichier:", "Fichier:Localisation ");
//				}

				if(!newPageName.equals(pageName)) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");
					API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
					System.out.println(pageName + " => " + newPageName);
					System.out.println("\tSaved");
					allUploadedAtFirst = false;

					if(justOne) {
						break;
					}
					TimeUnit.MILLISECONDS.sleep(5000);
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
		return allUploadedAtFirst;
	}


	private static void renameWithTable(String path, boolean keepRedirect, boolean justOne) throws IOException, InterruptedException {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		String currentLine = "currentLine";

		while (!currentLine.equals("")) {
			currentLine = br.readLine();
			String[] currentItems = currentLine.split(";");

			if (currentItems.length != 2) {
				System.err.println("Error with line " + currentLine);
			} else {
				String from = currentItems[0];
				String to = currentItems[1];

				Page toPage = new Page(to);
				String toContents = toPage.getContent();
				if (toContents == null || toContents.equals("")) {
					API.rename(from, to, keepRedirect, "Renommage auto");
					System.out.println("Renamed " + from + " => " + to);
					TimeUnit.SECONDS.sleep(1);

				}

			}

			if (justOne) {
				break;
			}
		}

		br.close();
	}

	private static void addCategory() {
		String category = "[[Catégorie:Artwork Pokémon]]";
		String[] list = {};
		for (String i : list) {
			Page page = new Page("Fichier:" + i + ".png");
			String contents = page.getContent();

			if (contents.contains(category)) {
				System.out.println("Skipped " + page.getTitle());
				continue;
			}

			contents = contents + "\n" + category;
			page.setContent(contents, "Ajout de la catégorie Artwork Pokémon");
			System.out.println("Added category on " + page.getTitle());

//			break;
		}

	}

	private static boolean renameDoubleRedirections(String from, String to, String[] pageList, String firstPageName, boolean keepRedirect, boolean justOne) {
		boolean hadNothingToDo = true;
		int counter = 0;
		String newPageName;

		for (String pageName : pageList) {
			Page page = new Page(pageName);
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				String contents = page.getContent();
				String newContents = contents.replaceAll(from, to);

				newContents = newContents.replaceAll("Cap ecran ", "");
				newContents = newContents.replaceAll("Cap écran ", "");
				newContents = newContents.replaceAll("ossatueur", "Ossatueur");
				newContents = newContents.replaceAll("xatu", "Xatu");
				newContents = newContents.replaceAll("trempee", "Trempée");
				newContents = newContents.replaceAll("céleste", "Céleste");
				newContents = newContents.replaceAll("leveinard", "Leveinard");
				newContents = newContents.replaceAll("littorale", "Littorale");
				if (newContents.contains("localisation")) {
					newContents = newContents.replace(" localisation", "");
					newContents = newContents.replace("Fichier:", "Fichier:Localisation ");
				}

				if (!newContents.equals(contents)) {
					page.setContent(newContents, "Renommage " + from + " => " + to);
					System.out.println(contents + "\n => " + newContents);

					hadNothingToDo = false;
				}

//				newPageName = pageName.replaceAll(from, to);

//				if(!newPageName.equals(pageName)) {
//					System.out.println("FOUND in page ["+page.getTitle()+"]");
//					API.rename(pageName, newPageName, keepRedirect, "Renommage "+pageName+" => "+newPageName);
//					System.out.println(pageName + " => " + newPageName);
//					System.out.println("\tSaved");
//
//					hadNothingToDo = false;
//					TimeUnit.SECONDS.sleep(1);
//				}
//
				if(justOne) {
					break;
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			counter++;
		}

		return hadNothingToDo;
	}

	/**
	 * Méthode de remplacement générique
	 * @param from chaine à remplacer (regexp)
	 * @param to chaine de remplacement (prend en charge les groupes capturants)
	 * @param nameSpaces un tableau d'espaces de nom (voir les constantes de la classe API). Laisser à null pour l'espace de nom principal seul.
	 * @param categoryName le nom de la catégorie à laquelle les articles éligibles au remplacement appartiennent (sans namespace devant). Laisser à null pour pas de filtrage.
	 * @param trigger une chaine de texte devant être présente dans les pages pour déclencher le remplacement. Laisser à null pour pas de filtrage.
	 * @param firstPageName nom de la première page à tester. Surtout utile en cas de plantage ou d'accès rapide durant les tests. Laisser à null sinon.
	 * @param justOne true pour s'arrêter après le premier remplacement réussi. Évite de casser plein de pages durant les tests.
	 **/
	private static void replace(String from, String to, int[] nameSpaces, String categoryName, String trigger, String firstPageName, boolean justOne) {
		PageCollection pageCollection = new PageCollection(
				nameSpaces!=null?nameSpaces:new int[]{API.NS_MAIN},
				API.FILTER_NONREDIRECTS,
				categoryName
		);
		Page page = pageCollection.getNextPage();
		int counter = 0;

		if(firstPageName!=null) {
			System.out.println("Jumping to ["+firstPageName+"]...");
			do {
				page = pageCollection.getNextPage();
			} while(!page.getTitle().equals(firstPageName));
		}

		String text;
		while(page!=null) {
			if(counter>=100) {
				System.out.println(page.getTitle());
				counter = 0;
			}

			try {
				text = page.getContent(false);
				if(text!=null && (trigger==null || text.contains(trigger))) {
					System.out.println("FOUND in page ["+page.getTitle()+"]");

					String newText = text.replaceAll(from, to);

					if(!newText.equals(text)) {
						page.setContent(newText, "Remplacement "+from+" => "+to);
						System.out.println("\tSaved");
						if(justOne) {
							break;
						}
					} else {
						System.out.println("\tSkipped (no change)");
					}
				}
			} catch (Exception e) {
				System.err.println("error with ["+page.getTitle()+"] : ["+e.getMessage()+"]");
				e.printStackTrace();
			}
			page = pageCollection.getNextPage();
			counter++;
		}
	}
}
