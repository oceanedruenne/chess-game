package rendu2.model;

import java.util.ArrayList;
import java.util.List;

// PION
public class Pawn extends Piece {

    private boolean moved = false;

    // CONSTRUCTEUR
    public Pawn(rendu2.model.Color couleur)
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
        List<Tile> legalMoves = new ArrayList<Tile>();
        int moveOne = this.color == rendu2.model.Color.WHITE ? -1 : +1;
        int moveTwo = this.color == Color.WHITE ? -2 : +2;

        if (posX+moveOne >= 0 && posX+moveOne <= 7 && !tiles[posX+moveOne][posY].isOccupied())
        {
            legalMoves.add(tiles[posX+moveOne][posY]);
        }

        /* Si le pion n'a jamais bougé, cela veut dire qu'il est à sa place initiale. La règle des échecs indique
        * que lorsque le pion bouge pour la première fois, il peut bouger de 2 cases, et lors de ses prochains
        * mouvements, il ne bougera que d'une case.
         */
        if (moved == false && posX+moveOne >= 0 && posX+moveOne <= 7 && !tiles[posX+moveOne][posY].isOccupied())
        {
            if (posX+moveTwo >= 0 && posX+moveTwo <= 7 && !tiles[posX+moveTwo][posY].isOccupied())
            {
                legalMoves.add(tiles[posX+moveTwo][posY]);
            }
        }

        if (posX+moveOne >= 0 && posX+moveOne <= 7 && posY-1 >= 0 && tiles[posX+moveOne][posY-1].isOccupied() && tiles[posX+moveOne][posY-1].getPiece().getColor() != this.color)
        {
            legalMoves.add(tiles[posX+moveOne][posY-1]);
        }
        if (posX+moveOne >= 0 && posX+moveOne <= 7 && posY+1 <= 7 && tiles[posX+moveOne][posY+1].isOccupied() && tiles[posX+moveOne][posY+1].getPiece().getColor() != this.color)
        {
            legalMoves.add(tiles[posX+moveOne][posY+1]);
        }

        return legalMoves;
    }

    /* setIsMoved :
     * Paramètre : boolean moved
     * Cette fonction permet de gérer l'attribut moved du pion
     * */
    public void setIsMoved(boolean moved)
    {
        this.moved = moved;
    }

    public boolean getIsMoved() {
        return this.moved;
    }
}
