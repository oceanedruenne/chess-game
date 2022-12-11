package model;

import java.util.ArrayList;
import java.util.List;


// FOU
public class Bishop extends Piece {


    // CONSTRUCTEUR
    public Bishop(Color couleur)
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
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
    {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        for (int i = 0;i<8;i++)
        {
            if(posX+i<=8 && posY+i<=8)
            {
                if (tiles[posX + i][posY + i].isOccuped())
                {
                    break;
                }
                else
                {
                    nonOccupedTiles.add(tiles[posX + i][posY + i]);
                }
            }

            if(posX+i<=8 && posY-i>=0)
            {
                if (tiles[posX + i][posY - i].isOccuped())
                {
                    break;
                }
                else
                {
                    nonOccupedTiles.add(tiles[posX + i][posY - i]);
                }
            }

            if(posX-i>=0 && posY-i>=0)
            {
                if (tiles[posX - i][posY - i].isOccuped())
                {
                    break;
                }
                else
                {
                    nonOccupedTiles.add(tiles[posX - i][posY - i]);
                }
            }

            if(posX-i>=0 && posY+i<=8)
            {
                if (tiles[posX - i][posY + i].isOccuped())
                {
                    break;
                }
                else
                {
                    nonOccupedTiles.add(tiles[posX - i][posY + i]);
                }
            }
        }
        return nonOccupedTiles;
    }
}
