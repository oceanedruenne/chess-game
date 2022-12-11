package controller;
import model.Game;
import model.Tile;
import observers.IViewObserver;
import view.ChessBoard;

/* La classe GameController va observer la View (la fenêtre du jeu) et modifiera le modèle (la classe Game) en conséquences */
public class GameController implements IViewObserver {

    private Game game;
    private ChessBoard view;

    public GameController(String whitePlayerName, String blackPlayerName) {
        this.game = new Game(whitePlayerName, blackPlayerName);
        this.view = new ChessBoard(this.game);
        view.setObserver(this);
        this.game.gameStarted();
    }

    @Override
    public void tileClicked(int posX, int posY) {
        game.tileClicked(posX, posY);
    }


}
