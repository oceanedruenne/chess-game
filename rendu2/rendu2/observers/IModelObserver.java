package rendu2.observers;

import rendu2.model.Move;
import rendu2.model.Tile;

import java.util.List;

public interface IModelObserver {
  void startGame(String whitePlayerName, String blackPlayerName);
  void tileSelected(int posX, int posY, List<Tile> legalMoves);
  void movePiece(Move move); // À voir si je dois ajouter un paramètre
  void checkedKing(boolean whiteKingIsChecked, boolean blackKingIsChecked); // Roi en échec
  void openEndGameDialog(String winnerName); // Échec et mat
  void openUpgradePawnDialog(int x, int y);
  void upgradePawn(String type, int x, int y);
}
