package model;

import observers.IModelObserver;


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
        this.whitePlayer = new Player(whitePlayerName, Color.WHITE);
        this.blackPlayer = new Player(blackPlayerName, Color.BLACK);
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
        if (board.getSelectedTile() == null)
        {
            board.clickedOnTile(posX,posY,currentPlayer.getColorOfPieces());
            notifyTileSelected(board.getSelectedTile());
        }
        else
        {
            Piece pieceToRemove = board.move(posX,posY,this.currentPlayer.getColorOfPieces());

            if (currentPlayer == whitePlayer) {
                blackPlayer.addLostPiece(pieceToRemove);
            } else {
                whitePlayer.addLostPiece(pieceToRemove);
            }

            notifyMovedPiece(board.getSelectedTile().getPiece());
        }

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

    /* nextRound :
     * Cette fonction permet de passer au tour suivant
     * */
    public void nextRound()
    {
        nextPlayer();
        notifyNextRound();
    }

    /* notifyGameStarted :
     * Cette fonction permet de notifier la View (fenêtre de jeu) que la partie a commencé (elle doit afficher l'échiquier)
     * */
    private void notifyGameStarted()
    {
        observer.startGame(whitePlayer.getPlayerName(), blackPlayer.getPlayerName());
    }

    /* notifyTileSelected :
     * Cette fonction permet de notifier la View (fenêtre de jeu) qu'une case a été sélectionnée
     * */
    private void notifyTileSelected(Tile tile)
    {
        observer.tileSelected(tile);
    }

    /* notifyMovedPiece :
     * Cette fonction permet de notifier la View (fenêtre de jeu) qu'une pièce a été déplacée
     * */
    private void notifyMovedPiece(Piece piece)
    {
        observer.movePiece(piece);
    }

    /* notifyNextRound :
     * Cette fonction permet de notifier la View (fenêtre de jeu) qu'on change de tour
     * */
    private void notifyNextRound()
    {
        observer.nextRound();
    }

    /* notifyEndGame :
     * Cette fonction permet de notifier la View (fenêtre de jeu) que la partie est terminée
     * */
    private void notifyEndGame(Color couleur)
    {
        observer.checkedMate(couleur);
    }

    /* setObserver :
     * Paramètre : IModelObserver observer
     * Cette fonction est un setter : Elle permet d'attribuer une valeur à l'attribut observer
     * */
    public void setObserver(IModelObserver observer) {
        this.observer = observer;
    }
}
