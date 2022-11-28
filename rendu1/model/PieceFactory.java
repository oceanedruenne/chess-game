public class PieceFactory {

    public String posX;
    public int posY;

    public PieceFactory()
    {

    }

    public Rook createRook()
    {
        return new Rook();
    }

    public Knight createKnight()
    {
        return new Knight();
    }

    public Bishop createBishop()
    {
        return new Bishop();
    }

    public Queen createQueen()
    {
        return new Queen();
    }

    public King createKing()
    {
        return new King();
    }

    public Pawn createPawn()
    {
        return new Pawn();
    }
}
