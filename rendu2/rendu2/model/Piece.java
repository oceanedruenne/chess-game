package rendu2.model;

import java.util.ArrayList;
import java.util.List;

// Pièce
public abstract class Piece {

    protected rendu2.model.Color color;

    /* getColor : Color
     * Cette fonction est un getter : elle permet de renvoyer l'attribut privé color
     * */
    public Color getColor()
    {
        return this.color;
    }

    /* getLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour la pièce
     * depuis sa position
     * */
    public abstract List<rendu2.model.Tile> getLegalMoves(rendu2.model.Tile[][] tiles, int posX, int posY);

    /* getDiagonalLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedDiagonalTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements diagonaux possibles pour la pièce
     * depuis sa position
     * */
    public List<rendu2.model.Tile> getDiagonalLegalMoves(rendu2.model.Tile[][] tiles, int posX, int posY)
    {
        List<rendu2.model.Tile> nonOccupedDiagonalTiles = new ArrayList<rendu2.model.Tile>();

        for (int i = 1; i < 8; i++)
        {
            if (posX + i < 8 && posY + i < 8)
            {
                if (!tiles[posX + i][posY + i].isOccupied() || tiles[posX + i][posY + i].getPiece().getColor() != this.color)
                {
                    nonOccupedDiagonalTiles.add(tiles[posX + i][posY + i]);
                }

                if (tiles[posX + i][posY + i].isOccupied())
                {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++)
        {
            if (posX + i < 8 && posY - i >= 0)
            {
                if (!tiles[posX + i][posY - i].isOccupied() || tiles[posX + i][posY - i].getPiece().getColor() != this.color)
                {
                    nonOccupedDiagonalTiles.add(tiles[posX + i][posY - i]);
                }

                if (tiles[posX + i][posY - i].isOccupied())
                {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++)
        {
            if (posX - i >= 0 && posY - i >= 0)
            {
                if (!tiles[posX - i][posY - i].isOccupied() || tiles[posX - i][posY - i].getPiece().getColor() != this.color)
                {
                    nonOccupedDiagonalTiles.add(tiles[posX - i][posY - i]);
                }

                if (tiles[posX - i][posY - i].isOccupied())
                {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++)
        {
            if (posX - i >= 0 && posY + i < 8)
            {
                if (!tiles[posX - i][posY + i].isOccupied() || tiles[posX - i][posY + i].getPiece().getColor() != this.color)
                {
                    nonOccupedDiagonalTiles.add(tiles[posX - i][posY + i]);
                }

                if (tiles[posX - i][posY + i].isOccupied())
                {
                    break;
                }
            }
        }
        return nonOccupedDiagonalTiles;
    }

    /* getHorizontalLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedHorizontalTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements horizontaux possibles pour la pièce
     * depuis sa position
     * */
    public List<rendu2.model.Tile> getHorizontalLegalMoves(rendu2.model.Tile[][] tiles, int posX, int posY)
    {
        List<rendu2.model.Tile> nonOccupedHorizontalTiles = new ArrayList<Tile>();

        for (int i = 1; i <8; i++)
        {
            if (posX - i >= 0)
            {
                if (!tiles[posX-i][posY].isOccupied() || tiles[posX-i][posY].getPiece().getColor() != this.color)
                {
                    nonOccupedHorizontalTiles.add(tiles[posX-i][posY]);
                }

                if (tiles[posX-i][posY].isOccupied())
                {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++)
        {
            if (posX + i < 8)
            {
                if (!tiles[posX+i][posY].isOccupied() || tiles[posX+i][posY].getPiece().getColor() != this.color)
                {
                    nonOccupedHorizontalTiles.add(tiles[posX+i][posY]);
                }

                if (tiles[posX+i][posY].isOccupied())
                {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++)
        {
            if (posY + i < 8)
            {
                if (!tiles[posX][posY+i].isOccupied() || tiles[posX][posY+i].getPiece().getColor() != this.color)
                {
                    nonOccupedHorizontalTiles.add(tiles[posX][posY+i]);
                }

                if (tiles[posX][posY+i].isOccupied())
                {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++)
        {
            if (posY - i >= 0)
            {
                if (!tiles[posX][posY-i].isOccupied() || tiles[posX][posY-i].getPiece().getColor() != this.color)
                {
                    nonOccupedHorizontalTiles.add(tiles[posX][posY-i]);
                }

                if (tiles[posX][posY-i].isOccupied())
                {
                    break;
                }
            }
        }
        return nonOccupedHorizontalTiles;
    }
}
