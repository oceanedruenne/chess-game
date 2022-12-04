import java.util.ArrayList;
import java.util.List;

public class Player {

    private String namePlayer;
    private List<Piece> lostPieces;
    private Color colorOfPieces;


    public Player(String nom, Color colorOfPieces)
    {
        this.namePlayer = nom;
        this.lostPieces = new ArrayList<Piece>();
        this.colorOfPieces = colorOfPieces;
    }
}
