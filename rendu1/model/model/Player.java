package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String namePlayer;
    private List<Piece> lostPieces;
    private Color colorOfPieces;

    private boolean played = false;


    public Player(String nom, Color colorOfPieces)
    {
        this.namePlayer = nom;
        this.lostPieces = new ArrayList<Piece>();
        this.colorOfPieces = colorOfPieces;
    }
    public String getPlayerName()
    {
        return this.namePlayer;
    }

    public List<Piece> getLostPieces()
    {
        return this.lostPieces;
    }

    public void removePiece(Piece piece)
    {
        this.lostPieces.remove(piece);
    }


    public Color getColorOfPieces()
    {
        return colorOfPieces;
    }
}
