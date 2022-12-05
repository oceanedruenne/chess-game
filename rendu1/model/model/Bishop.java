package model;

import java.util.ArrayList;
import java.util.List;


// FOU
public class Bishop extends Piece {

    public Color couleur; // Attribut public de type Couleur (Énumération)

    // CONSTRUCTEUR
    public Bishop(Color couleur)
    {
        this.couleur = couleur;
    }

    /* getLevalMoves : List<Tile>
    * Paramètres : Tile[][] tiles, int posX, int posY
    * Variables locales : List<Tile> nonOccupedTiles
    * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour le fou
    * depuis sa position
    * */
    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
    {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        // On boucle de 0 à 8 du fait qu'un échiquier est de 8x8
        for (int i = 0;i<8;i++)
        {
            // En haut à droite
            if(posX+i<=8 && posY+i<=8) {
                if (tiles[posX + i][posY + i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX + i][posY + i]);
                }
            }
            // En bas à droite
            if(posX+i<=8 && posY-i>=0) {
                if (tiles[posX + i][posY - i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX + i][posY - i]);
                }
            }
            // En haut à gauche
            if(posX-i>=0 && posY-i>=0) {
                if (tiles[posX - i][posY - i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX - i][posY - i]);
                }
            }
            // En bas à gauche
            if(posX-i>=0 && posY+i<=8) {
                if (tiles[posX - i][posY + i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX - i][posY + i]);
                }
            }
        }
        return nonOccupedTiles;
    }
}
