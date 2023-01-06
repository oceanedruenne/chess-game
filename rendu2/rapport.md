Durant cette deuxième partie de conception du jeu d'échecs, les principes de conception
ainsi que les designs patterns sont restés les mêmes. 
Cependant, il y a eu l'ajout de la classe Move afin de pouvoir séparer les mouvements dans 
une classe à part et que ce soit plus lisible et plus facile à gérer. 

Il y a également eu l'utilisation de boîtes de dialogues lors de deux évenements particuliers : 
        
    → Lors de la promotion d'un pion
    → Lors d'un échec et mat 

Il était demandé de réaliser une fenêtre de fin de jeu lorsqu'un des deux joueurs est en échec 
et mat. Cependant, je trouvais cela plus facile et moins "lourd" d'utiliser des "pop-ups" pour
notifier des joueurs de la promotion d'un pion et d'un échec et mat. 
