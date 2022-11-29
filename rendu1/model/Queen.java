import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public String color;
    public Queen(String couleur)
    {
        this.color = couleur;
    }

    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY) {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        for (int i = posX; i >= 0; i--) {
            if (i>=0) {
                if (tiles[i][posY].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[i][posY]);
                }
            }
        }

        for (int j = posX; j <= 8; j++) {
            if (j<=8) {
                if (tiles[j][posY].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[j][posY]);
                }
            }
        }

        for (int k = posY; k >= 0; k--) {
            if (k>=0) {
                if (tiles[posX][k].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX][k]);
                }
            }
        }

        for (int l = posY; l <= 8; l++) {
            if (l<=8) {
                if (tiles[posX][l].isOccuped()) {
                    break;
                } else {
                    nonOccupedTiles.add(tiles[posX][l]);
                }
            }
        }

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
