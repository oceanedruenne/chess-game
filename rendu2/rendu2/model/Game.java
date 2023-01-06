package rendu2.model;

import rendu2.observers.IModelObserver;

import java.util.ArrayList;
import java.util.List;


// JEU
public class Game {

    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private IModelObserver observer;

    // CONSTRUCTEUR
    public Game(String whitePlayerName, String blackPlayerName)
    {
        this.board = new Board();
        this.whitePlayer = new Player(whitePlayerName, rendu2.model.Color.WHITE);
        this.blackPlayer = new Player(blackPlayerName, rendu2.model.Color.BLACK);
        this.currentPlayer = whitePlayer;
    }

    /* gameStarted
     * Cette fonction permet de notifier la vue que la partie a commencé
     * */
    public void gameStarted() {
        notifyGameStarted();
    }


    /* tileClicked :
     * Paramètres : int posX, int posY
     * Cette fonction permet de cliquer sur la case dont les coordonnées sont passées en paramètres
     * */
    public void tileClicked(int posX, int posY)
    {
        Move move = board.clickedOnTile(posX,posY,currentPlayer.getColorOfPieces());
        notifyTileSelected(board.getSelectedTile());

        if (move != null)
        {
            if (move.getPieceToRemove() != null)
            {
                if (currentPlayer == whitePlayer)
                {
                    blackPlayer.addLostPiece(move.getPieceToRemove());
                }
                else
                {
                    whitePlayer.addLostPiece(move.getPieceToRemove());
                }
            }

            if (move.getUpgradePawn()) {
                notifyUpgradePawnDialog(move.getDestX(), move.getDestY());
            }

            notifyMovedPiece(move);
            nextPlayer();
        }

        notifyKingStatus(board.isKingChecked(Color.WHITE), board.isKingChecked(Color.BLACK));
        notifyKingCheckedMate(board.isKingCheckedMate(Color.WHITE), board.isKingCheckedMate(Color.BLACK));
    }

    /* nextPlayer :
     * Cette fonction permet de passer au joueur suivant
     * */
    public void nextPlayer()
    {
        if (this.currentPlayer == whitePlayer)
        {
            this.currentPlayer = blackPlayer;
        }
        else
        {
            this.currentPlayer = whitePlayer;
        }
    }

    public void upgradePawnTo(String type, Color color, int x, int y) {
        board.upgradePawnTo(type, color, x, y);
        this.notifyUpgradePawn(type, x, y);
    }


    /* notifyGameStarted :
     * Cette fonction permet de notifier la View (fenêtre de jeu) que la partie a commencé (elle doit afficher l'échiquier)
     * */
    private void notifyGameStarted()
    {
        observer.startGame(whitePlayer.getPlayerName(), blackPlayer.getPlayerName());
    }

    /* notifyTileSelected :
    * Paramètres : Tile tile
     * Cette fonction permet de notifier la View (fenêtre de jeu) qu'une case a été sélectionnée
     * */
    private void notifyTileSelected(Tile tile)
    {
        int posX = tile == null ? -1 : tile.getPosX();
        int posY = tile == null ? -1 : tile.getPosY();

        List<Tile> legalMoves = new ArrayList<>();

        if (tile != null && tile.isOccupied()) {
            legalMoves = tile.getPiece().getLegalMoves(board.getTiles(), tile.getPosX(), tile.getPosY());
        }

        observer.tileSelected(posX, posY, legalMoves);
    }

    /* notifyMovedPiece :
     * Paramètre : Move move
     * Cette fonction permet de notifier la View (fenêtre de jeu) qu'une pièce a été déplacée
     * */
    private void notifyMovedPiece(Move move)
    {
        observer.movePiece(move);
    }

    /* notifyKingStatus :
     * Paramètres : boolean whiteKingIsChecked, boolean blackKingIsChecked
     * Cette fonction permet de notifier la View (fenêtre du jeu) si les Rois sont en échec ou non
     * */
    private void notifyKingStatus(boolean whiteKingIsChecked, boolean blackKingIsChecked) {
        observer.checkedKing(whiteKingIsChecked, blackKingIsChecked);
    }

    /* notifyKingCheckedMate :
     * Paramètres : boolean whiteKingIsChecked, boolean blackKingIsChecked
     * Cette fonction permet de notifier la View (fenêtre du jeu) si les Rois sont en échec et mat ou non
     * */
    private void notifyKingCheckedMate(boolean whiteKingIsCheckedMate, boolean blackKingIsCheckedMate)
    {
        if (whiteKingIsCheckedMate) {
            observer.openEndGameDialog(this.getBlackPlayerName());
        }
        else if (blackKingIsCheckedMate) {
            observer.openEndGameDialog(this.getWhitePlayerName());
        }
    }

    /* notifyUpgradePawnDialog :
     * Paramètre : int x, int y
     * Cette fonction permet de notifier la View (fenêtre du jeu) que le pion doit changer de type de pièce
     * */
    private void notifyUpgradePawnDialog(int x, int y)
    {
        observer.openUpgradePawnDialog(x, y);
    }

    /* notifyUpgradePawn :
     * Paramètre : int x, int y
     * Cette fonction permet de notifier la View (fenêtre du jeu) que le pion a changé de type de pièce
     * */
    private void notifyUpgradePawn(String type, int x, int y)
    {
        observer.upgradePawn(type, x, y);
    }

    /* setObserver :
     * Paramètre : IModelObserver observer
     * Cette fonction est un setter : Elle permet d'attribuer une valeur à l'attribut observer
     * */
    public void setObserver(IModelObserver observer) {
        this.observer = observer;
    }

    /* getWhitePlayerName : String
     * Cette fonction permet de renvoyer le nom du joueur des pièces blanches. S'il n'a pas de nom, il aura par défaut le nom "Joueur blanc"
     * */
    public String getWhitePlayerName()
    {
        return this.whitePlayer == null || this.whitePlayer.getPlayerName().isEmpty() ? "Joueur blanc" : this.whitePlayer.getPlayerName();
    }

    /* getBlackPlayerName : String
     * Cette fonction permet de renvoyer le nom du joueur des pièces noires. S'il n'a pas de nom, il aura par défaut le nom "Joueur noir"
     * */
    public String getBlackPlayerName()
    {
        return this.blackPlayer == null || this.blackPlayer.getPlayerName().isEmpty() ? "Joueur noir" : this.blackPlayer.getPlayerName();
    }
}
