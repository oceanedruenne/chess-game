package model;

import java.util.ArrayList;
import java.util.List;

// REINE
public class Queen extends Piece{

    // CONSTRUCTEUR
    public Queen(Color couleur)
    {
        this.color = couleur;
    }

    /* getLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour le fou
     * depuis sa position
     * */
    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY) {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        /* LA REINE AYANT LES MOUVEMENTS COMBINÉS DE LA TOUR ET DU FOU
        *  PAR CONSÉQUENT, ON COMBINE LES BOUCLES DE VÉRIFICATION DES
        *  CLASSES BISHOP ET ROOK */
        for (int i = posX; i >= 0; i--) {
            if (i>=0) {
                if (tiles[i][posY].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[i][posY]);
                }
            }
        }

        for (int j = posX; j <= 8; j++) {
            if (j<=8) {
                if (tiles[j][posY].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[j][posY]);
                }
            }
        }

        for (int k = posY; k >= 0; k--) {
            if (k>=0) {
                if (tiles[posX][k].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX][k]);
                }
            }
        }

        for (int l = posY; l <= 8; l++) {
            if (l<=8) {
                if (tiles[posX][l].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX][l]);
                }
            }
        }

        for (int i = 0;i<8;i++)
        {
            if(posX+i<=8 && posY+i<=8) {
                if (tiles[posX + i][posY + i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX + i][posY + i]);
                }
            }

            if(posX+i<=8 && posY-i>=0) {
                if (tiles[posX + i][posY - i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX + i][posY - i]);
                }
            }

            if(posX-i>=0 && posY-i>=0) {
                if (tiles[posX - i][posY - i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX - i][posY - i]);
                }
            }

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
