public class PieceFactory {

    public String posX;
    public int posY;

    public PieceFactory()
    {

    }

    public Rook createRook(String posX, int posY)
    {
        return new Rook(posX,posY);
    }

    public Knight createKnight(String posX, int posY)
    {
        return new Knight(posX,posY);
    }

    public Bishop createBishop(String posX, int posY)
    {
        return new Bishop(posX,posY);
    }

    public Queen createQueen(String posX, int posY)
    {
        return new Queen(posX,posY);
    }

    public King createKing(String posX, int posY)
    {
        return new King(posX,posY);
    }

    public Pawn createPawn(String posX, int posY)
    {
        return new Pawn(posX,posY);
    }
}
