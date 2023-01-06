package rendu2.model;

import java.util.ArrayList;
import java.util.List;


// ROI
public class King extends Piece {

    private boolean isChecked;
    private boolean isCheckedMate;

    // CONSTRUCTEUR
    public King(Color couleur)
    {
        this.color = couleur;
    }


    /* getLegalMoves : List<Tile>
     * Paramètres : Tile[][] tiles, int posX, int posY
     * Variables locales : List<Tile> nonOccupedTiles
     * Cette fonction permet de renvoyer une liste de tous les mouvements possibles pour le roi
     * depuis sa position
     * */
   @Override
   public List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY)
   {
       List<Tile> nonOccupedTiles = new ArrayList<Tile>();
       // Boucle pour les mouvements verticaux
       for (int i = posX-1;i<=posX+1;i++)
       {
           // Boucle pour les mouvements horizontaux
           for (int j = posY-1;j<=posY+1;j++)
           {
               if(i>=0 && j>=0 && i<8 && j<8) {
                   if (!tiles[i][j].isOccupied() || tiles[i][j].getPiece().getColor() != this.color) {
                       nonOccupedTiles.add(tiles[i][j]);
                   }
               }
           }
       }
       return nonOccupedTiles;
   }

    /* setChecked :
     * Paramètres : boolean isChecked
     * Cette fonction est un setter : elle permet de modifier l'attribut isChecked
     * */
   public void setChecked(boolean isChecked)
   {
       this.isChecked = isChecked;
   }

    /* setCheckedMate :
     * Paramètres : boolean isCheckedMate
     * Cette fonction est un setter : elle permet de modifier l'attribut isCheckedMate
     * */
   public void setCheckedMate(boolean isCheckedMate)
   {
       this.isCheckedMate = isCheckedMate;
   }
}
