package model;

// CLASSE CASE
public class Tile {

    private Piece piece; // Attribut pièce qui permet de mettre une pièce sur une case
    private int posX;
    private int posY;
    private boolean isClicked = false;

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

<<<<<<< HEAD
    public boolean getisClicked()
    {
        return this.isClicked;
    }

    public void setIsClicked(int posX, int posY)
    {
        if (this.posX == posX && this.posY == posY)
        {
            this.isClicked = true;
        }
    }

    public void unsetIsClicked(int posX, int posY)
    {
        if (this.posX == posX && this.posY == posY)
        {
            this.isClicked = false;
        }
    }

    public Piece getPieceType(int posX, int posY)
    {
        if (this.posX == posX && this.posY == posY)
        {
            Piece piece = this.piece;
        }
        return piece;
    }

=======
    public Piece getPiece() { return this.piece; }
>>>>>>> 4a8f132a6af20a8bbddcfccb9f7f7242cd186853
}
