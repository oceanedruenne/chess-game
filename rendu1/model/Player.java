import java.util.List;

public class Player {

    public String namePlayer;
    public List<Piece> pieceList;
    public int nbPieces = 16;
    public String colorOfPieces;
    public int score = 0;

    public Player(String nom,List<Piece> listPieces, String colorOfPieces)
    {
        this.namePlayer = nom;
        this.pieceList = listPieces;
        this.colorOfPieces = colorOfPieces;
    }
}
