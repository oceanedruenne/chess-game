package model;

public class PieceFactory {


    public PieceFactory()
    {

    }

    public Rook createRook(Color couleur)
    {
        return new Rook(couleur);
    }

    public Knight createKnight(Color couleur)
    {
        return new Knight(couleur);
    }

    public Bishop createBishop(Color couleur)
    {
        return new Bishop(couleur);
    }

    public Queen createQueen(Color couleur)
    {
        return new Queen(couleur);
    }

    public King createKing(Color couleur)
    {
        return new King(couleur);
    }

    public Pawn createPawn(Color couleur)
    {
        return new Pawn(couleur);
    }
}
