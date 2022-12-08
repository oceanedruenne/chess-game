package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private Player currentPlayer;

    public Game(Board board, Player whitePlayer, Player blackPlayer)
    {
        this.board = board;
        this.players = new ArrayList<Player>();
        this.players.add(0,whitePlayer);
        this.players.add(1,blackPlayer);
        this.currentPlayer = whitePlayer;
    }

    public void tileClicked(int posX, int posY)
    {
        board.clickedOnTile(posX,posY);
    }

    public void tileUnclicked(int posX, int posY)
    {
        board.unclickedOnTile(posX, posY);
    }

    public Player nextPlayer(Player currentPlayer)
    {
        int index = players.indexOf(currentPlayer);
        Player nextPlayer;

        if (index+1 > 1)
        {
            nextPlayer = players.get(0);
        }
        else
        {
            nextPlayer = players.get(1);
        }

        return nextPlayer;
    }

    public void nextRound()
    {
        this.currentPlayer = nextPlayer(currentPlayer);
    }

    public void kingIsThreatened()
    {

    }

}
