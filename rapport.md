# Rapport Final

## Répartition des tâches :

Lombart Thibault :
* Gestion des Gits Merges
* Gestion des Tickets
* #6 F2B - Créez les classes permettant de représenter les différents objets qui constituent une scène : les plans, les triangles, les sphères, etc.
* #8 F2D - Quel patron de conception vous permet de créer progressivement une scène, en lui fournissant les éléments qui la constitue au fur et à mesure ? Implantez-le.
* #10 F2F - Écrivez une classe principale définissant une méthode main qui récupère depuis la ligne de commande le nom du fichier décrivant la scène, puis lit ce fichier à l’aide du parser implanté à la question précédente.
* #12 F3A - Créez une classe pour implanter le code de l’algorithme donné plus haut.
* #13 F3B - Complétez votre classe principale pour que celle-ci appelle le code que vous avez écrit afin de vérifier qu’il s’exécute correctement, et génère bien une image dans le fichier de sortie.
* #15 F4A - Complétez les classes représentant les objets de la scène en ajoutant une méthode déterminant la distance entre un point p suivant une direction⃗ d et l’objet en question.
* #16 F4B - Complétez votre algorithme de lancer de rayon pour parcourir les objets de la scène à la re- cherche d’un objet avec lequel le rayon d émis depuis l’œil lookF rom s’intersecte.
* #17 F4C - Testez à nouveau votre code pour vérifier que vous générez bien les images attendues, par exemple en considérant les scènes d’exemples données ci-après.
* #21 F5C - Testez à votre code pour vérifier que vous générez bien les images attendues, par exemple en considérant les scènes d’exemples données ci-après (les fichiers de scène sont disponibles sur ce dépôt Git).
* #25 F6A Apparition des objets plans et triangles
* #26 F6B Complétez la méthode déterminant la distance avec un point dans votre classe représentant un plan en tenant compte de cette formule
* #27 F6C Complétez la méthode déterminant la distance avec un point dans votre classe représentant un triangle en tenant compte de cette formule.
* #28 F6D Utilisez les scènes fournies pour vérifier que le code fournit les images attendues.
* #34 F7E Complétez votre algorithme de lancer de rayon pour que le calcul de la couleur d’un point puisse utiliser le modèle de Blinn-Phong. Et choisir le patron de conception pour tenir compte de ce modèle.
* #36 F7G Complétez la classe responsable de la construction de votre lanceur de rayons pour pouvoir spécifier la valeur du paramètre maxdepth.
* #37 F7H Complétez le parser pour reconnaître le nouveau mot-clef dans le fichier de scène, et ainsi utiliser la valeur choisie dans votre lanceur de rayons

Debloos Lucas :

* #5 F2A - Créez les classes permettant de représenter les différentes lumières qui éclairent une scène.
* #7 F2C - Créez les classes permettant de représenter la scène en tant que telle, avec les informations relatives à la caméra, aux dimensions de l’image, aux lumières, aux objets contenus dans la scène, etc.
* #20 F5B - Complétez votre algorithme de lancer de rayon pour que le calcul de la couleur d’un point puisse utiliser le modèle de Lambert. Quel patron de conception pourrait permettre de choisir entre utiliser ce modèle, ou uniquement celui de base ?
* #30 F7A Choisir le patron de conception qui permet de pouvoir activer ou non la recherche d’une ombre sur le point d’intersection et l'implantez avec l’approche utilisée actuellement dans le projet
* #31 F7B Implantez l’approche permettant d’identifier une ombre potentielle sur un point d’intersection déjà identifié.
* #32 F7C Complétez la classe responsable de la construction de votre lanceur de rayons pour pouvoir spécifier si les ombres doivent être utilisées
* #33 F7D Complétez le parser pour reconnaître le nouveau mot-clef dans le fichier de scène, et ainsi utiliser l’approche choisie dans votre lanceur de rayons.

Lhomme Bryan :

* #2 F1A - Réaliser une première classe Triplet permettant de réaliser toutes les opérations.
* #9 F2E - Créez le parser qui aura la responsabilité de lire un fichier texte donné ayant le format décrit plus haut, en utilisant la classe ajoutée à la question précédente pour construire la scène.
* #18 F5A - Complétez vos classes permettant de représenter les différents types de lumières, afin de pouvoir récupérer la couleur de la lumière, ainsi que la direction de la lumière en un point donné.
* #39 F9A Modifiez le code du lanceur de rayons en tenant compte de l’algorithme donné au dessus.
* #40 F9B Choisir le patron de conception qui permet de choisir une technique d’échantillonnage parmi les trois proposées. Et implantez le avec l’approche utilisée actuellement dans votre projet (un seul vecteur au centre du pixel)
* #41 F9C Implantez la technique d’échantillonnage aléatoire
* #42 F9D Implantez la technique d’échantillonnage par grille
* #43 F9E Complétez la classe responsable de la construction de votre lanceur de rayons pour pouvoir spécifier la technique d’échantillonnage à utiliser
* #44 F9F Complétez le parser de votre lanceur de rayon pour que celui-ci configure l’échantillonnage à appliquer lorsqu’il rencontre l’une de ces lignes

Bouzrou Brayan :

* #22 F-1X Diagramme UML
* #24 F-2X Faire toutes les javadocs
* #49 F-3X Rapport Final
* #3 F1B Définir les classes permettant de représenter un point, un vecteur et une couleur, en respectant strictement les opérations par type de données manipulées.
* #46 F8A - Quel patron de conception vous permet de calculer la couleur d’un point sur un objet, que celui soit d’une couleur unie ou comporte un damier ? Et l'implantez.
* #47 F8B - Implantez le calcul de couleur pour un damier, en suivant les consignes données ci-dessus.

## Choix technique:

Le patron de conception qui permet de créer progressivement une scène, en lui fournissant les éléments qui la constitue au fur et à mesure est le **Builder (Alternatif).**

Le patron de conception qui permet de choisir entre utiliser ce modèle, ou uniquement celui de base est le **Stratégie**.

Le patron de conception qui permet d’éviter de dupliquer la détermination de la couleur de base dans le modèle de Lambert et le **Décorateur**.

Le patron de conception qui permet de pouvoir activer ou non la recherche d’une ombre sur le point d’intersection est le **Stratégie**.

Le patron de conception pour que le calcul de la couleur d’un point puisse utiliser le modèle de Blinn-Phong est le **Décorateur.**

Le patron de conception qui permet d’éviter de dupliquer la détermination de la couleur de base ou celle du modèle de Lambder dans le modèle de Blinn-Phong est le **Décorateur.**

Le patron de conception qui permet de calculer la couleur d’un point sur un objet, que celui soit d’une couleur unie ou comporte un damier est le **Strategie.**

Le patron de conception qui permet de facilement choisir une technique d’échantillonnage parmi les trois proposées est le **Strategie.**
