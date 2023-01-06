package rendu2.model;

import java.util.ArrayList;
import java.util.List;

// CAVALIER
public class Knight extends Piece {

    // CONSTRUCTEUR
    public Knight(Color couleur)
    {
        this.color = couleur;
    }


    /* getLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour le cavalier
     * depuis sa position
     * */
    @Override
    public List<rendu2.model.Tile> getLegalMoves(rendu2.model.Tile[][] tiles, int posX, int posY) {
        List<rendu2.model.Tile> nonOccupedTiles = new ArrayList<Tile>();

        if (posX-2 >= 0 && posY+1 < 8)
        {
            if (!tiles[posX-2][posY+1].isOccupied() || tiles[posX-2][posY+1].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX-2][posY+1]);
            }
        }

        if (posX-2 >= 0 && posY-1 >= 0)
        {
            if (!tiles[posX-2][posY-1].isOccupied() || tiles[posX-2][posY-1].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX-2][posY-1]);
            }
        }

        if (posX-1 >= 0 && posY+2 < 8)
        {
            if (!tiles[posX-1][posY+2].isOccupied() || tiles[posX-1][posY+2].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX-1][posY+2]);
            }
        }

        if (posX+1 < 8 && posY+2 < 8)
        {
            if (!tiles[posX+1][posY+2].isOccupied() || tiles[posX+1][posY+2].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX+1][posY+2]);
            }
        }

        if (posX+2 < 8 && posY-1 >= 0)
        {
            if (!tiles[posX+2][posY-1].isOccupied() || tiles[posX+2][posY-1].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX+2][posY-1]);
            }
        }

        if (posX+2 < 8 && posY+1 < 8)
        {
            if (!tiles[posX+2][posY+1].isOccupied() || tiles[posX+2][posY+1].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX+2][posY+1]);
            }
        }

        if (posX-1 >= 0 && posY-2 >= 0)
        {
            if (!tiles[posX-1][posY-2].isOccupied() || tiles[posX-1][posY-2].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX-1][posY-2]);
            }
        }

        if (posX+1 < 8 && posY-2 >= 0)
        {
            if (!tiles[posX+1][posY-2].isOccupied() || tiles[posX+1][posY-2].getPiece().getColor() != this.color)
            {
                nonOccupedTiles.add(tiles[posX+1][posY-2]);
            }
        }

        return nonOccupedTiles;
    }
}