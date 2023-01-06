package rendu2.model;

// CLASSE CASE
public class Tile {

    private rendu2.model.Piece piece;
    private int posX;
    private int posY;
    private boolean isClicked = false;

    // CONSTRUCTEUR
    public Tile(int i, int j)
    {
        this.posX = i;
        this.posY = j;
    }

    /* isOccupied : boolean
     * Cette fonction permet de vérifier si une case est occupée par une pièce ou non
     */
    public boolean isOccupied()
    {
        return this.piece != null;
    }

    /* setPiece :
     * Paramètres : Piece piece
     * Cette fonction permet d'affecter une valeur à un attribut
     */
    public void setPiece(rendu2.model.Piece piece)
    {
        this.piece = piece;
    }

    /* getIsClicked : boolean
     * Cette fonction est un getter : Elle permet de renvoyer l'attribut privé isClicked
     */
    public boolean getisClicked()
    {
        return this.isClicked;
    }

    /* setIsClicked :
     * Paramètre : boolean isClicked
     * Cette fonction est un setter : Elle permet d'attribuer une valeur à l'attribut isClicked, passé en paramètre.
     */
    public void setIsClicked(boolean isClicked)
    {
        this.isClicked = isClicked;
    }


    /* getPiece : Piece
     * Cette fonction est un getter : Elle permet de renvoyer une pièce
     */
    public Piece getPiece() { return this.piece; }

    /* getPosX : int
     * Cette fonction est un getter : Elle permet de renvoyer la position X de la case
     */
    public int getPosX() { return this.posX; }

    /* getPosY : int
     * Cette fonction est un getter : Elle permet de renvoyer la position Y de la case
     */
    public int getPosY() { return this.posY; }

    /* setPosX :
     * Paramètre : int posX
     * Cette fonction est un setter : Elle permet d'attribuer une valeur à l'attribut posX, passé en paramètre.
     */
    public void setPosX(int posX) { this.posX = posX; }

    /* setPosY :
     * Paramètre : int posY
     * Cette fonction est un setter : Elle permet d'attribuer une valeur à l'attribut posY, passé en paramètre.
     */
    public void setPosY(int posY) { this.posY = posY; }
}
