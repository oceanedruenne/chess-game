import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public String color;
    public King(String couleur)
    {
        this.color = couleur;
    }

   @Override
   public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
   {
       List<Tile> nonOccupedTiles = new ArrayList<Tile>();
       for (int i = posX-1;i<=posX+1;i++)
       {
           for (int j = posY-1;j<=posY+1;j++)
           {
               if(i>=0 && j>=0 && i<=8 && j<=8) {
                   if (tiles[i][j].isOccuped() == false) {
                       nonOccupedTiles.add(tiles[i][j]);
                   }
               }
           }
       }
       return nonOccupedTiles;

   }
}
