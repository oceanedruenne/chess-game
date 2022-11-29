public class PieceFactory {

    public String posX;
    public int posY;
    public PieceFactory()
    {

    }

    public Rook createRook( String couleur)
    {
        return new Rook(couleur);
    }

    public Knight createKnight(String couleur)
    {
        return new Knight(couleur);
    }

    public Bishop createBishop(String couleur)
    {
        return new Bishop(couleur);
    }

    public Queen createQueen(String couleur)
    {
        return new Queen(couleur);
    }

    public King createKing(String couleur)
    {
        return new King(couleur);
    }

    public Pawn createPawn(String couleur)
    {
        return new Pawn(couleur);
    }
}
