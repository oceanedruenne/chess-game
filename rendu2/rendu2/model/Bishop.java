package rendu2.model;

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
    */
    @Override
    public List<rendu2.model.Tile> getLegalMoves(rendu2.model.Tile[][] tiles, int posX, int posY)
    {
        List<rendu2.model.Tile> nonOccupedTiles = new ArrayList<Tile>();
        nonOccupedTiles = getDiagonalLegalMoves(tiles,posX,posY);
        return nonOccupedTiles;
    }
}
