package model;

import java.util.ArrayList;
import java.util.List;

// PION
public class Pawn extends Piece{

    private boolean moved = false;

    // CONSTRUCTEUR
    public Pawn(Color couleur)
    {
        this.color = couleur;
    }

    /* getLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour le pion
     * depuis sa position
     * */
    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
    {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        /* Si le pion n'a jamais bougé, cela veut dire qu'il est à sa place initiale. La règle des échecs indique
        * que lorsque le pion bouge pour la première fois, il peut bouger de 2 cases, et lors de ses prochains
        * mouvements, il ne bougera que d'une case.
         */
        if (moved == false)
        {
            for (int i = posY;i<=posY+2;i++)
            {
                if (i<=8) {
                    if (tiles[posX][i].isOccuped())
                    {
                        break;
                    } else
                    {
                        nonOccupedTiles.add(tiles[posX][i]);
                        moved = true;
                    }
                }
            }
        }
        /* Dans ce cas, le pion a déjà bougé. Par conséquent, il ne peut qu'avancer de 1.*/
        else
        {
            for (int j = posY;j<=posY+1;j++)
            {
                if (j<=8) {
                    if (tiles[posX][j].isOccuped())
                    {
                        break;
                    } else
                    {
                        nonOccupedTiles.add(tiles[posX][j]);
                    }
                }
            }
        }
        return nonOccupedTiles;
    }

    /* getIsMoved : boolean
     * Cette fonction est un getter : elle permet de renvoyer l'attribut privé moved
     * */
    public boolean getIsMoved()
    {
        return this.moved;
    }
}
