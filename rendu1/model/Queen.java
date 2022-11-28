import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public Queen()
    {

    }

    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY) {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        for (int i = posX; i >= 0; i--) {
            if (tiles[i][posY].isOccuped()) {
                break;
            } else {
                nonOccupedTiles.add(tiles[i][posY]);
            }
        }

        for (int j = posX; j <= 8; j++) {
            if (tiles[j][posY].isOccuped()) {
                break;
            } else {
                nonOccupedTiles.add(tiles[j][posY]);
            }
        }

        for (int k = posY; k >= 0; k--) {
            if (tiles[posX][k].isOccuped()) {
                break;
            } else {
                nonOccupedTiles.add(tiles[posX][k]);
            }
        }

        for (int l = posY; l <= 8; l++) {
            if (tiles[posX][l].isOccuped()) {
                break;
            } else {
                nonOccupedTiles.add(tiles[posX][l]);
            }
        }

        for (int i = 0;i<8;i++)
        {
            if (tiles[posX+i][posY+i].isOccuped())
            {
                break;
            }
            else
            {
                nonOccupedTiles.add(tiles[posX+i][posY+i]);
            }

            if (tiles[posX+i][posY-i].isOccuped())
            {
                break;
            }
            else
            {
                nonOccupedTiles.add(tiles[posX+i][posY-i]);
            }

            if (tiles[posX-i][posY-i].isOccuped())
            {
                break;
            }
            else
            {
                nonOccupedTiles.add(tiles[posX-i][posY-i]);
            }

            if (tiles[posX-i][posY+i].isOccuped())
            {
                break;
            }
            else
            {
                nonOccupedTiles.add(tiles[posX-i][posY+i]);
            }
        }
        return nonOccupedTiles;
    }
}
