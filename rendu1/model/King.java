import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King()
    {

    }

   @Override
   public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
   {
       List<Tile> nonOccupedTiles = new ArrayList<Tile>();
       for (int i = posX-1;i<=posX+1;i++)
       {
           for (int j = posY-1;j<=posY+1;j++)
           {
               if (tiles[i][j].isOccuped() == false)
               {
                    nonOccupedTiles.add(tiles[i][j]);
               }
           }
       }
       return nonOccupedTiles;

   }
}
