package rendu2.model;

import java.util.ArrayList;
import java.util.List;

// TOUR
public class Rook extends Piece {

    // CONSTRUCTEUR
    public Rook(Color couleur)
    {
        this.color = couleur;
    }

    /* getLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour la tour
     * depuis sa position
     * */
   @Override
   public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
   {
       List<Tile> nonOccupedTiles = new ArrayList<Tile>();
       nonOccupedTiles = getHorizontalLegalMoves(tiles,posX,posY);
       return nonOccupedTiles;
   }
}
