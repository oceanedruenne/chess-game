package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String namePlayer;
    private List<Piece> lostPieces;
    private Color colorOfPieces;

    private boolean played = false;


    // CONSTRUCTEUR
    public Player(String nom, Color colorOfPieces)
    {
        this.namePlayer = nom;
        this.lostPieces = new ArrayList<Piece>();
        this.colorOfPieces = colorOfPieces;
    }
    /* getPlayerName : String
     * Cette fonction est un getter : elle permet de renvoyer l'attribut privé namePlayer
     * */
    public String getPlayerName()
    {
        return this.namePlayer;
    }

    /* getPieces : List<Piece>
     * Cette fonction est un getter : elle permet de renvoyer la liste des pièces perdues du joueur
     * */
    public List<Piece> getLostPieces()
    {
        return this.lostPieces;
    }

    /* removePiece :
     * Paramètre : Piece piece
     * Cette fonction permet d'ajouter la pièce perdue par le joueur dans la liste
     * */
    public void addLostPiece(Piece piece)
    {
        this.lostPieces.add(piece);
    }


    /* getColorOfPieces : Color
     * Cette fonction est un getter : elle permet de renvoyer la couleur des pièces du joueur
     * */
    public Color getColorOfPieces()
    {
        return colorOfPieces;
    }
}
