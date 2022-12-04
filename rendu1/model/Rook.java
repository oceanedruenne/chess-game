import java.util.ArrayList;
import java.util.List;

// TOUR
public class Rook extends Piece{

    private Color color;
    public Rook(Color couleur)
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
   public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
   {
       List<Tile> nonOccupedTiles = new ArrayList<Tile>();

       // Boucle qui permet de vérifier si les cases sont occupées ou non lorsqu'on veut se déplacer vers la gauche
       for (int i = posX;i>=0;i--)
       {
           if(posX-i>=0) {
               if (tiles[i][posY].isOccuped()) {
                   break;
               } else {
                   nonOccupedTiles.add(tiles[i][posY]);
               }
           }
       }
       // Boucle qui permet de vérifier si les cases sont occupées ou non lorsqu'on veut se déplacer vers la droite
       for (int j = posX;j<=8;j++)
       {
           if (posX+j<=8) {
               if (tiles[j][posY].isOccuped()) {
                   break;
               } else {
                   nonOccupedTiles.add(tiles[j][posY]);
               }
           }
       }

       // Boucle qui permet de vérifier si les cases sont occupées ou non lorsqu'on veut se déplacer vers le haut
       for (int k = posY;k>=0;k--)
       {
           if (posY-k >=0) {
               if (tiles[posX][k].isOccuped()) {
                   break;
               } else {
                   nonOccupedTiles.add(tiles[posX][k]);
               }
           }
       }

       // Boucle qui permet de vérifier si les cases sont occupées ou non lorsqu'on veut se déplacer vers le bas
       for (int l = posY;l<=8;l++)
       {
           if (posY+l<=8) {
               if (tiles[posX][l].isOccuped()) {
                   break;
               } else {
                   nonOccupedTiles.add(tiles[posX][l]);
               }
           }
       }
       return nonOccupedTiles;
   }
}
