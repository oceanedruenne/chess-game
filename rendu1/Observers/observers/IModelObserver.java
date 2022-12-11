package observers;

import model.Color;
import model.Piece;
import model.Tile;

public interface IModelObserver {

  public void startGame(String whitePlayerName, String blackPlayerName);
  public void tileSelected(Tile tile);
  public void movePiece(Piece piece); // À voir si je dois ajouter un paramètre
  public void checkedKing(); // Roi en échec
  public void nextRound(); // Tour suivant
  public void checkedMate(Color couleur); // Échec et mat
}
