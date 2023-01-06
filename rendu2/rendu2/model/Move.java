package rendu2.model;


// MOUVEMENT
public class Move {

    private int prevX;
    private int prevY;
    private int destX;
    private int destY;

    private Piece pieceToRemove;

    private boolean upgradePawn;

    // CONSTRUCTEUR
    public Move(int prevX, int prevY, int destX, int destY, Piece pieceToRemove, boolean upgradePawn)
    {
        this.prevX = prevX;
        this.prevY = prevY;
        this.destX = destX;
        this.destY = destY;
        this.pieceToRemove = pieceToRemove;
        this.upgradePawn = upgradePawn;
    }

    /* getPrevX : int
     * Cette fonction permet de renvoyer la coordonnée x de la case de départ
     * */
    public int getPrevX()
    {
        return this.prevX;
    }

    /* getPrevY : int
     * Cette fonction permet de renvoyer la coordonnée y de la case de départ
     * */
    public int getPrevY()
    {
        return this.prevY;
    }

    /* getDestX : int
     * Cette fonction permet de renvoyer la coordonnée x de la case d'arrivée
     * */
    public int getDestX()
    {
        return this.destX;
    }

    /* getDestY : int
     * Cette fonction permet de renvoyer la coordonnée y de la case d'arrivée
     * */
    public int getDestY()
    {
        return this.destY;
    }

    /* getPieceToRemove : Piece
     * Cette fonction permet de renvoyer la pièce qui doit être retirée
     * */
    public Piece getPieceToRemove()
    {
        return this.pieceToRemove;
    }

    /* getUpgradePawn : boolean
     * Cette fonction permet de renvoyer s'il faut améliorer le pion
     * */
    public boolean getUpgradePawn()
    {
        return this.upgradePawn;
    }
}
