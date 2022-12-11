package model;

import java.util.List;

public abstract class Piece {

    protected Color color;

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
    public abstract List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY);

}
