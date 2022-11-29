import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public String color;
    public boolean moved = false;

    public Pawn(String couleur)
    {
        this.color = couleur;
    }

    public void changePosition(String posX, int posY) {

    }

    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY) {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        if (moved == false)
        {
            for (int i = posY;i<=posY+2;i++)
            {
                if (i<=8) {
                    if (tiles[posX][i].isOccuped()) {
                        break;
                    } else {
                        nonOccupedTiles.add(tiles[posX][i]);
                        moved = true;
                    }
                }
            }
        }
        else
        {
            for (int j = posY;j<=posY+1;j++)
            {
                if (j<=8) {
                    if (tiles[posX][j].isOccuped()) {
                        break;
                    } else {
                        nonOccupedTiles.add(tiles[posX][j]);
                    }
                }
            }
        }

        return nonOccupedTiles;
    }
}
