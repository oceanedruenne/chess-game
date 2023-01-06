package rendu2.model;

// Pièce Factory
public class PieceFactory {

    // CONSTRUCTEUR
    public PieceFactory()
    {

    }

    /* createRook : Rook
     * Paramètres : Color couleur
     * Cette fonction permet de créer une tour
     * */
    public rendu2.model.Rook createRook(rendu2.model.Color couleur)
    {
        return new Rook(couleur);
    }

    /* createKnight : Knight
     * Paramètres : Color couleur
     * Cette fonction permet de créer un cavalier
     * */
    public rendu2.model.Knight createKnight(rendu2.model.Color couleur)
    {
        return new Knight(couleur);
    }

    /* createBishop : Bishop
     * Paramètres : Color couleur
     * Cette fonction permet de créer un fou
     * */
    public rendu2.model.Bishop createBishop(rendu2.model.Color couleur)
    {
        return new Bishop(couleur);
    }

    /* createQueen : Queen
     * Paramètres : Color couleur
     * Cette fonction permet de créer une reine
     * */
    public rendu2.model.Queen createQueen(rendu2.model.Color couleur)
    {
        return new Queen(couleur);
    }

    /* createKing : King
     * Paramètres : Color couleur
     * Cette fonction permet de créer un roi
     * */
    public rendu2.model.King createKing(rendu2.model.Color couleur)
    {
        return new King(couleur);
    }

    /* createPawn : Pawn
     * Paramètres : Color couleur
     * Cette fonction permet de créer un pion
     * */
    public rendu2.model.Pawn createPawn(Color couleur)
    {
        return new Pawn(couleur);
    }
}
