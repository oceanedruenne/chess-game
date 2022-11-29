import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    public String color;
    public Rook( String couleur)
    {
        this.color = couleur;
    }

   @Override
   public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
   {
       List<Tile> nonOccupedTiles = new ArrayList<Tile>();

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
