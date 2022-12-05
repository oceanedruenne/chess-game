package model;

// CLASSE CASE
public class Tile {

    private Piece piece; // Attribut pièce qui permet de mettre une pièce sur une case
    private int posX;
    private int posY;

    // CONSTRUCTEUR
    public Tile(Piece piece)
    {
        this.piece = piece;
    }
    /* isOccuped : boolean
     * Cette fonction permet de vérifier si une case est occupée par une pièce ou non
     */
    public boolean isOccuped()
    {
        return this.piece == null;
    }

    /* setPiece :
     * Paramètres : Piece piece
     * Cette fonction permet d'affecter une valeur à un attribut
     */
    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }
}
