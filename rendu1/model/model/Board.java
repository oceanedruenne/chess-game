package model;

public class Board {

    private Tile[][] tiles;
    private PieceFactory pf;

    private King blackKing;

    private King whiteKing;

    private Tile selectedTile;

    // CONSTRUCTEUR
    public Board()
    {
        this.pf = new PieceFactory();
        this.tiles = new Tile[8][8];
        this.initTiles();
        this.initPieces();
    }

    /* initTiles :
     * Cette fonction permet créer les cases du jeu
     * */
    private void initTiles() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = new Tile();
            }
        }
    }


    /* initPieces :
     * Cette fonction permet créer les pièces du jeu et de les placer sur les cases correspondantes
     * */
    private void initPieces()
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

        this.blackKing = (King)tiles[0][4].getPiece();
        this.whiteKing = (King)tiles[7][4].getPiece();
    }


    /* clickedOnTile :
     * Paramètres : int posX, int posY
     * Cette fonction permet de connaître la case sélectionnée
     * */
    public void clickedOnTile(int posX, int posY, Color colorCurrentPlayer) {
        if (tiles[posX][posY].getPiece() == null) {
            return;
        }

        if (tiles[posX][posY].getPiece().getColor() == colorCurrentPlayer)
        {
            selectedTile = tiles[posX][posY];
        }

    }

    /* kingIsChecked : boolean
     * Paramètres : Tile kingTile
     * Cette fonction permet de vérifier si le Roi est en échec
     * */
    public boolean kingIsChecked(Tile kingTile)
    {
       for (Tile[] tabTile : tiles)
       {
           for (Tile tile : tabTile)
           {
               if (tile.getPiece().getColor() != kingTile.getPiece().getColor())
               {
                   if (tile.getPiece().getLegalMoves(tiles, tile.getPosX(), tile.getPosY()).contains(kingTile))
                   {
                       King king = (King)kingTile.getPiece();
                       king.setChecked(true);
                       return true;
                   }
               }
           }
       }

       return false;
    }

    /* kingIsCheckedMate :
     * Paramètres : Tile kingTile
     * Cette fonction permet de vérifier si le Roi est en échec et mat
     * */
    public void kingIsCheckedMate(Tile kingTile)
    {
        King king = (King)kingTile.getPiece();

        if (king.getisChecked() == false)
        {
            return;
        }

        for (Tile[] tabTile : tiles)
        {
            for (Tile tile : tabTile)
            {
                if (tile.getPiece().getColor() != kingTile.getPiece().getColor())
                {
                    if (tile.getPiece().getLegalMoves(tiles, tile.getPosX(), tile.getPosY()).contains(king.getLegalMoves(tiles, kingTile.getPosX(), kingTile.getPosY())))
                    {
                        king.setCheckedMate(true);
                    }
                }
            }
        }
    }

    /* simulateMove :
     * Paramètres : Tile src, Tile dest
     * Cette fonction permet de simuler le mouvement d'une pièce (qui sera utilisée dans la fonction move)
     * */
    public void simulateMove(Tile src,Tile dest)
    {
        dest.setPiece(src.getPiece());
        src.setPiece(null);
    }

    /* canMoveTo : boolean
     * Paramètres : Tile src, Tile dest
     * Cette fonction permet de vérifier si la pièce à la case source peut aller dans la case de destination
     * */
    public boolean canMoveTo(Tile src,Tile dest)
    {
        int prevX = src.getPosX();
        int prevY = src.getPosY();

        if (src.getPiece().getLegalMoves(tiles, prevX, prevY).contains(dest))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /* tileIsEmpty : boolean
     * Paramètres : Tile tile
     * Cette fonction permet de vérifier si la case passée en paramètre est vide ou non
     * */
    public boolean tileIsEmpty(Tile tile)
    {
        if (tile.getPiece() == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /* move : Piece
     * Paramètres : Tile src, Tile dest, Color colorCurrentPlayer
     * Cette fonction permet de bouger une pièce en partant d'une case, pour aller à une autre.
     * */
    public Piece move(int destX, int destY ,Color colorCurrentPlayer)
    {
        Tile src = this.selectedTile;
        Tile dest = this.tiles[destX][destY];
        if (src.getisClicked() == true)
        {
            int prevX = src.getPosX(); // Position X de ma Tile de là où je pars
            int prevY = src.getPosY(); // Position Y de ma Tile de là où je pars
            Color couleur = src.getPiece().getColor(); // Couleur de la pièce selected
            King king; // Roi

            if (colorCurrentPlayer == Color.BLACK)
            {
                king = this.blackKing;
            }
            else
            {
                king = this.whiteKing;
            }

            // Si la pièce de la case est de la même couleur que notre pièce
            if (dest.getPiece().getColor() == couleur)
            {
                src.setIsClicked(false);
                dest.setIsClicked(true);
                return null;
            }

            // Est-ce que la case où je veux aller est dans mes mouvements légaux ?
            if (canMoveTo(src,dest))
            {
                // Si oui, est-ce que la case est vide ?
                if (tileIsEmpty(dest))
                {
                    // On simule le déplacement
                    simulateMove(src,dest);

                    // Est-ce que mon Roi est toujours en échec ?
                    if (this.kingIsChecked(getKingTile(king)))
                    {
                        src.setPiece(dest.getPiece());
                        dest.setPiece(null);
                        src.setIsClicked(false);
                    }
                }
                // Si la case n'est pas vide
                else
                {
                    Piece destPiece = dest.getPiece();
                    // On simule le déplacement
                    simulateMove(src,dest);

                    // Est-ce que mon Roi est toujours en échec ?
                    if (this.kingIsChecked(getKingTile(king)))
                    {
                        src.setPiece(dest.getPiece());
                        dest.setPiece(destPiece);
                        src.setIsClicked(false);
                    }
                    // Sinon, je peux déplacer la pièce (on fait déjà dans la simulation)
                    // Fonction à ajouter pour leap la pièce
                    else {
                            return destPiece;
                    }
                }
            }
            // Si ce n'est pas dans les mouvements légaux, on unselect la pièce
            else {
                src.setIsClicked(false);
            }
        }

        return null;
    }

    /* getKingTile : Tile
     * Paramètre : King king
     * Cette fonction est un getter : Elle permet de renvoyer la case du Roi
     * */
    private Tile getKingTile(King king) {
        for (Tile[] tabTile : tiles) {
            for (Tile tile : tabTile) {
                if (tile.getPiece() == king) {
                    return tile;
                }
            }
        }

        return null;
    }

    /* getSelectedTile : Tile
     * Cette fonction est un getter : Elle permet de renvoyer la case sélectionnée
     * */
    public Tile getSelectedTile() {
        return this.selectedTile;
    }
}