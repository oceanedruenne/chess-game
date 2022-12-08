import model.Tile;

public interface IModelObserver {

    public void move(int posX, int posY);

    public void changePiece(Tile[][] tiles);

    public void kickPiece(Tile[][] tiles);
}
