import java.util.List;

public abstract class Piece {



    public Piece()
    {

    }

    public abstract List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY);
}
