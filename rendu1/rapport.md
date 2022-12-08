Séance de TP du Mercredi 23 Novembre 2022 : 

    - Apprentissage des règles des échecs (les différentes pièces, leurs mouvements..)
    - Mise en place du dépôt git (fork,clone, création d'une nouvelle blanche, création des dossiers)
    - Réalisation du diagramme de classes UML
    - Décision d'utilisation de designs patterns

Séance de TP du Jeudi 24 Novembre 2022 :

    - Ajout du code de chaque classe
    - Correction du diagramme de classes
    - Ajout de la vue pour le jeu d'échecs
    - Téléchargement des pièces sous format svg afin de les ajouter sur le plateau

Travail à la maison entre deux séances de TP :

    - Vérification de la possibilité de déplacer une pièce avec des boucles et des conditions

Séance de TP du Vendredi 2 Décembre 2022 :
            
    - Code commenté
    - Ajout d'une énumération pour les couleurs


Designs patterns utilisés :

    - Factory → Afin de pouvoir créer les différentes pièces, puisqu'elles ont les mêmes attributs et les mêmes fonctions

Principes de conception utilisés :

     - YAGNI → On ne code que l'essentiel, même si cela reste sommaire
     - KISS → Nous n'utilisons pas de types compliqués
     - Loi de Demeter → Cette loi peut s'appliquer entre le jeu d'échecs, les joueurs et leurs pièces

Designs patterns que l'on va utiliser par la suite :

     - Observer, qu'on va placer dans le contrôleur afin de faire le lien entre le plateau et les pièces

Travail réalisé entre deux séances de TP : 

    - Modification du diagramme de classe ChessGame en ajoutant l'énumération et les dépendances
    - Modification des constructeurs en remplaçant les attributs color de type String par un type Color
    - Ajout des commentaires
    - Modification de la fonction isOccuped() de la classe Tile et ajout d'une fonction setPiece()
    - Ajout d'une classe Board 
    - Utilisation de la PieceFactory
    - Changement de la portée des attributs, passant de public à private


Séance de TP du Lundi 5 Décembre 2022 :

    - Ajout des diagrammes de classe UML View et Controller
    - Ajout de packages model, view, controller
    - Ajout de l'interface Observer et de la classe ObserverPiece
    - Ajout d'une liste d'ObserverPiece et de fonctions relatives à celle-ci dans la classe Piece

RESTE À FAIRE :

    → SI LA CASE EST OCCUPÉE, EST-ELLE OCCUPÉE PAR UNE PIÈCE DE LA MÊME COULEUR QUE CELLE JOUÉE ?
        - Si oui, on ne fait rien
        - Sinon, on vérifie si la pièce peut être leapée. Si c'est le cas, on retire la pièce leapée et on incrémente le score du joueur

    → Ajouter une fonction move pour bouger la pièce
    → Trouver comment placer les images sur le model
    → Comment faire le lien entre le déplacement de ma pièce sur le model et celui dans le controller ?

Séance de TP du Jeudi 8 Décembre 2022 :

    - Ajout de fonctions et d'attributs dans les classes Tile, Board, Player, King
    - Ajout d'une classe Game 
    - Modification du diagramme de classes Model



