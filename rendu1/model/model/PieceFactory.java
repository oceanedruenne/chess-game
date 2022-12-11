package model;

public class PieceFactory {

    // CONSTRUCTEUR
    public PieceFactory()
    {

    }

    /* createRook : Rook
     * Paramètres : Color couleur
     * Cette fonction permet de créer une tour
     * */
    public Rook createRook(Color couleur)
    {
        return new Rook(couleur);
    }

    /* createKnight : Knight
     * Paramètres : Color couleur
     * Cette fonction permet de créer un cavalier
     * */
    public Knight createKnight(Color couleur)
    {
        return new Knight(couleur);
    }

    /* createBishop : Bishop
     * Paramètres : Color couleur
     * Cette fonction permet de créer un fou
     * */
    public Bishop createBishop(Color couleur)
    {
        return new Bishop(couleur);
    }

    /* createQueen : Queen
     * Paramètres : Color couleur
     * Cette fonction permet de créer une reine
     * */
    public Queen createQueen(Color couleur)
    {
        return new Queen(couleur);
    }

    /* createKing : King
     * Paramètres : Color couleur
     * Cette fonction permet de créer un roi
     * */
    public King createKing(Color couleur)
    {
        return new King(couleur);
    }

    /* createPawn : Pawn
     * Paramètres : Color couleur
     * Cette fonction permet de créer un pion
     * */
    public Pawn createPawn(Color couleur)
    {
        return new Pawn(couleur);
    }
}
