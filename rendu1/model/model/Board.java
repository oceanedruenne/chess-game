package model;

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
        tiles[0][1].setPiece(pf.createKnight(Color.BLACK)); // CAVALIER
        tiles[0][2].setPiece(pf.createBishop(Color.BLACK)); // FOU
        tiles[0][3].setPiece(pf.createQueen(Color.BLACK)); // REINE
        tiles[0][4].setPiece(pf.createKing(Color.BLACK)); // ROI
        tiles[0][5].setPiece(pf.createBishop(Color.BLACK)); // FOU
        tiles[0][6].setPiece(pf.createKnight(Color.BLACK)); // CAVALIER
        tiles[0][7].setPiece(pf.createRook(Color.BLACK)); // TOUR

        for (int i = 0;i<8;i++)
        {
            tiles[1][i].setPiece(pf.createPawn(Color.BLACK)); // PION
        }

        // INITIALISATION DES PIÈCES BLANCHES
        tiles[7][0].setPiece(pf.createRook(Color.WHITE)); // TOUR
        tiles[7][1].setPiece(pf.createKnight(Color.WHITE)); // CAVALIER
        tiles[7][2].setPiece(pf.createBishop(Color.WHITE)); // FOU
        tiles[7][3].setPiece(pf.createQueen(Color.WHITE)); // REINE
        tiles[7][4].setPiece(pf.createKing(Color.WHITE)); // ROI
        tiles[7][5].setPiece(pf.createBishop(Color.WHITE)); // FOU
        tiles[7][6].setPiece(pf.createKnight(Color.WHITE)); // CAVALIER
        tiles[7][7].setPiece(pf.createRook(Color.WHITE)); // TOUR

        for (int j = 0;j<8;j++)
        {
            tiles[j][6].setPiece(pf.createPawn(Color.WHITE)); // PION
        }
    }


    public void clickedOnTile(int posX, int posY) {
        this.tiles[posX][posY].setIsClicked(posX,posY);
    }

    public void unclickedOnTile(int posX, int posY) {
        this.tiles[posX][posY].unsetIsClicked(posX,posY);
    }
}
