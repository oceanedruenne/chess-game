package rendu2.model;

import java.util.ArrayList;
import java.util.List;

// Joueur
public class Player {

    private String namePlayer;
    private List<rendu2.model.Piece> lostPieces;
    private rendu2.model.Color colorOfPieces;

    private boolean played = false;


    // CONSTRUCTEUR
    public Player(String nom, rendu2.model.Color colorOfPieces)
    {
        this.namePlayer = nom;
        this.lostPieces = new ArrayList<rendu2.model.Piece>();
        this.colorOfPieces = colorOfPieces;
    }

    /* getPlayerName : String
     * Cette fonction est un getter : elle permet de renvoyer l'attribut privé namePlayer
     * */
    public String getPlayerName()
    {
        return this.namePlayer;
    }


    /* addLostPiece :
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
