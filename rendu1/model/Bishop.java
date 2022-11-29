import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public String color;
    public Bishop(String couleur)
    {
        this.color = couleur;
    }

    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
    {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        for (int i = 0;i<8;i++)
        {
            if(posX+i<=8 && posY+i<=8) {
                if (tiles[posX + i][posY + i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX + i][posY + i]);
                }
            }

            if(posX+i<=8 && posY-i>=0) {
                if (tiles[posX + i][posY - i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX + i][posY - i]);
                }
            }

            if(posX-i>=0 && posY-i>=0) {
                if (tiles[posX - i][posY - i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX - i][posY - i]);
                }
            }

            if(posX-i>=0 && posY+i<=8) {
                if (tiles[posX - i][posY + i].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX - i][posY + i]);
                }
            }
        }
        return nonOccupedTiles;
    }
}
