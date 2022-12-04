public class Board {

    private Tile[][] tiles;
    private PieceFactory pf;

    public Board()
    {
        this.pf = new PieceFactory();
        this.tiles = new Tile[8][8];
    }

    public void initPieces()
    {
        // INITIALISATION DES PIÈCES NOIRES
        tiles[0][0].setPiece(pf.createRook(Color.BLACK)); // TOUR
        tiles[1][0].setPiece(pf.createKnight(Color.BLACK)); // CAVALIER
        tiles[2][0].setPiece(pf.createBishop(Color.BLACK)); // FOU
        tiles[3][0].setPiece(pf.createQueen(Color.BLACK)); // REINE
        tiles[4][0].setPiece(pf.createKing(Color.BLACK)); // ROI
        tiles[5][0].setPiece(pf.createBishop(Color.BLACK)); // FOU
        tiles[6][0].setPiece(pf.createKnight(Color.BLACK)); // CAVALIER
        tiles[7][0].setPiece(pf.createRook(Color.BLACK)); // TOUR

        for (int i = 0;i<8;i++)
        {
            tiles[i][1].setPiece(pf.createPawn(Color.BLACK)); // PION
        }

        // INITIALISATION DES PIÈCES BLANCHES
        tiles[0][7].setPiece(pf.createRook(Color.WHITE)); // TOUR
        tiles[1][7].setPiece(pf.createKnight(Color.WHITE)); // CAVALIER
        tiles[2][7].setPiece(pf.createBishop(Color.WHITE)); // FOU
        tiles[3][7].setPiece(pf.createQueen(Color.WHITE)); // REINE
        tiles[4][7].setPiece(pf.createKing(Color.WHITE)); // ROI
        tiles[5][7].setPiece(pf.createBishop(Color.WHITE)); // FOU
        tiles[6][7].setPiece(pf.createKnight(Color.WHITE)); // CAVALIER
        tiles[7][7].setPiece(pf.createRook(Color.WHITE)); // TOUR

        for (int j = 0;j<8;j++)
        {
            tiles[j][6].setPiece(pf.createPawn(Color.WHITE)); // PION
        }
    }


}
