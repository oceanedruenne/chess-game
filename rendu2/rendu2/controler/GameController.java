package rendu2.controler;
import rendu2.model.Color;
import rendu2.model.Game;
import rendu2.observers.IViewObserver;
import rendu2.view.ChessBoard;

/* La classe GameController va observer la View (la fenêtre du jeu) et modifiera le modèle (la classe Game) en conséquences */
public class GameController implements IViewObserver {

    private Game game;
    private ChessBoard view;

    // CONSTRUCTEUR
    public GameController(String whitePlayerName, String blackPlayerName) {
        this.game = new Game(whitePlayerName, blackPlayerName);
        this.view = new ChessBoard(this.game);
        view.setObserver(this);
        this.game.gameStarted();
    }

    /* tileClicked :
     * Paramètres : int posX, int posY
     * Cette fonction permet de modifier la classe Game en lui indiquant quelle case est cliquée
     */
    @Override
    public void tileClicked(int posX, int posY) {
        game.tileClicked(posX, posY);
    }

    /* upgradePawn :
     * Paramètres : int x, int y
     * Cette fonction permet de notifier le modèle qu'un pion a été améliorée
     */
    @Override
    public void upgradePawn(String type, Color color, int x, int y) {
        game.upgradePawnTo(type, color, x, y);
    }


}
