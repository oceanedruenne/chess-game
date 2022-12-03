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


Designs patterns utilisés :
Singleton -> afin de ne pouvoir instancier qu'une seule partie
Factory-> Afin de pouvoir créer les différentes pièces, puisqu'elles ont les mêmes attributs et les mêmes fonctions

Principes de conception utilisés :
YAGNI -> On ne code que l'essentiel, même si cela reste sommaire
KISS -> Nous n'utilisons pas de types compliqués
Loi de Demeter -> Cette loi peut s'appliquer entre le jeu d'échecs, les joueurs et leurs pièces

Designs patterns que l'on va utiliser par la suite :
- Observer, qu'on va placer dans le contrôleur afin de faire le lien entre le plateau et les pièces

// À faire lors de la prochaine séance de TP (Vendredi 2 Décembre 2022) :
- Réaliser les diagrammes UML pour le contrôleur et pour la vue
- Créer les observers pour les pièces d'échecs
- Mettre les images des pièces sur les cases correspondantes selon leurs coordonnées
- Commenter le code


