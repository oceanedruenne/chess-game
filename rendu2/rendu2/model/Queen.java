package rendu2.model;

import java.util.List;

// REINE
public class Queen extends Piece {

    // CONSTRUCTEUR
    public Queen(Color couleur)
    {
        this.color = couleur;
    }

    /* getLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour la reine
     * depuis sa position
     * */
    @Override
    public List<rendu2.model.Tile> getLegalMoves(rendu2.model.Tile[][] tiles, int posX, int posY) {
        List<Tile> legalMoves = getHorizontalLegalMoves(tiles,posX,posY);
        legalMoves.addAll(getDiagonalLegalMoves(tiles,posX,posY));

        return legalMoves;
    }
}
