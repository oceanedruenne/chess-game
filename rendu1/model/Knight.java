import java.util.ArrayList;
import java.util.List;

// CAVALIER
public class Knight extends Piece{

    public Color color;
    public Knight(Color couleur)
    {
        this.color = couleur;
    }


    /* getLevalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour le fou
     * depuis sa position
     * */
    @Override
    public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY) {
        List<Tile> nonOccupedTiles = new ArrayList<Tile>();

        // Le cavalier peut leap les autres pièces donc on a pas besoin de vérifier si la case est occupée ou non
        for (int i = posX;i<=posX+2;i++)
        {
            for (int j = posY;j>=posY-2;j--)
            {
                if (i<=8 && j>=0) {
                    if (tiles[i][j].isOccuped()) {
                        break;
                    } else {
                        nonOccupedTiles.add(tiles[i][j]);
                    }
                }
            }
        }

        for (int k = posX;k<=posX+2;k++)
        {
            for (int l = posY;l<=posY+2;l++)
            {
                if (k<=8 && l<=8) {
                    if (tiles[k][l].isOccuped()) {
                        break;
                    } else {
                        nonOccupedTiles.add(tiles[k][l]);
                    }
                }
            }
        }

        for (int m = posX;m>=posX-2;m--)
        {
            for (int n = posY;n<=posY+2;n++)
            {
                if (m>=0 && n<=8) {
                    if (tiles[m][n].isOccuped()) {
                        break;
                    } else {
                        nonOccupedTiles.add(tiles[m][n]);
                    }
                }
            }
        }

        for (int o = posX;o>=posX-2;o--)
        {
            for (int p = posY;p>=posY-2;p--)
            {
                if (o>=0 && p>=0) {
                    if (tiles[o][p].isOccuped()) {
                        break;
                    } else {
                        nonOccupedTiles.add(tiles[o][p]);
                    }
                }
            }
        }

        return nonOccupedTiles;
    }
}
