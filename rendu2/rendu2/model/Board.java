package rendu2.model;


import java.util.List;

// PLATEAU DE JEU
public class Board {

    private rendu2.model.Tile[][] tiles;
    private PieceFactory pf;
    private rendu2.model.King blackKing;
    private rendu2.model.King whiteKing;
    private rendu2.model.Tile selectedTile;

    // CONSTRUCTEUR
    public Board()
    {
        this.pf = new PieceFactory();
        this.tiles = new rendu2.model.Tile[8][8];
        this.initTiles();
        this.initPieces();
    }

    /* initTiles :
     * Cette fonction permet créer les cases du jeu
     * */
    private void initTiles() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = new rendu2.model.Tile(i,j);
            }
        }
    }

    /* initPieces :
     * Cette fonction permet créer les pièces du jeu et de les placer sur les cases correspondantes
     * */
    private void initPieces()
    {
        // INITIALISATION DES PIÈCES NOIRES
        tiles[0][0].setPiece(pf.createRook(rendu2.model.Color.BLACK)); // TOUR
        tiles[0][1].setPiece(pf.createKnight(rendu2.model.Color.BLACK)); // CAVALIER
        tiles[0][2].setPiece(pf.createBishop(rendu2.model.Color.BLACK)); // FOU
        tiles[0][3].setPiece(pf.createQueen(rendu2.model.Color.BLACK)); // REINE
        tiles[0][4].setPiece(pf.createKing(rendu2.model.Color.BLACK)); // ROI
        tiles[0][5].setPiece(pf.createBishop(rendu2.model.Color.BLACK)); // FOU
        tiles[0][6].setPiece(pf.createKnight(rendu2.model.Color.BLACK)); // CAVALIER
        tiles[0][7].setPiece(pf.createRook(rendu2.model.Color.BLACK)); // TOUR

        for (int i = 0;i<8;i++)
        {
            tiles[1][i].setPiece(pf.createPawn(rendu2.model.Color.BLACK)); // PION
        }

        // INITIALISATION DES PIÈCES BLANCHES
        tiles[7][0].setPiece(pf.createRook(rendu2.model.Color.WHITE)); // TOUR
        tiles[7][1].setPiece(pf.createKnight(rendu2.model.Color.WHITE)); // CAVALIER
        tiles[7][2].setPiece(pf.createBishop(rendu2.model.Color.WHITE)); // FOU
        tiles[7][3].setPiece(pf.createQueen(rendu2.model.Color.WHITE)); // REINE
        tiles[7][4].setPiece(pf.createKing(rendu2.model.Color.WHITE)); // ROI
        tiles[7][5].setPiece(pf.createBishop(rendu2.model.Color.WHITE)); // FOU
        tiles[7][6].setPiece(pf.createKnight(rendu2.model.Color.WHITE)); // CAVALIER
        tiles[7][7].setPiece(pf.createRook(rendu2.model.Color.WHITE)); // TOUR

        for (int j = 0;j<8;j++)
        {
            tiles[6][j].setPiece(pf.createPawn(rendu2.model.Color.WHITE)); // PION
        }

        this.blackKing = (rendu2.model.King)tiles[0][4].getPiece();
        this.whiteKing = (rendu2.model.King)tiles[7][4].getPiece();
    }


    /* clickedOnTile :
     * Paramètres : int posX, int posY, Color colorCurrentPlayer
     * Cette fonction permet de connaître la case sélectionnée
     * */
    public rendu2.model.Move clickedOnTile(int posX, int posY, rendu2.model.Color colorCurrentPlayer)
    {
        rendu2.model.Tile tileClicked = tiles[posX][posY];

        // S'il n'y a pas de pièce sélectionnée et que la case cliquée est vide on ne fait rien
        if (selectedTile == null && !tileClicked.isOccupied())
        {
            changeSelectedTile(null);
            return null;
        }

        // Si la case cliquée est de la même couleur que le joueur en cours on la sélectionne
        if (tileClicked.isOccupied() && tileClicked.getPiece().getColor() == colorCurrentPlayer)
        {
            changeSelectedTile(tileClicked);
            return null;
        }

        // Si la case cliquée est dans les mouvements autorisés pour la pièce sélectionnée, on bouge la pièce déjà sélectionnée vers cette case
        if (selectedTile != null && selectedTile.getPiece().getLegalMoves(this.tiles, selectedTile.getPosX(), selectedTile.getPosY()).contains(tileClicked))
        {
            rendu2.model.Move move = this.move(posX, posY, colorCurrentPlayer);
            changeSelectedTile(null);

            return move;
        }

        // Sinon on desélectionne la pièce
        if (!tileClicked.isOccupied() )
        {
            changeSelectedTile(null);
            return null;
        }

        changeSelectedTile(null);
        return null;
    }

    /* changeSelectedTile :
     * Paramètres : Tile tileClicked
     * Cette fonction permet de modifier la case selectionnée en cours
     * */
    private void changeSelectedTile(rendu2.model.Tile tileClicked)
    {
        if (selectedTile != null)
        {
            selectedTile.setIsClicked(false);
        }

        selectedTile = tileClicked;

        if (selectedTile != null)
        {
            selectedTile.setIsClicked(true);
        }
    }

    /* kingIsChecked : boolean
     * Paramètres : King king
     * Cette fonction permet de vérifier si le Roi est en échec
     * */
    private boolean kingIsChecked(rendu2.model.King king)
    {
        rendu2.model.Tile kingTile = getKingTile(king);
        for (rendu2.model.Tile[] tabTile : tiles)
        {
           for (rendu2.model.Tile tile : tabTile)
           {
               if (tile.isOccupied() && tile.getPiece().getColor() != kingTile.getPiece().getColor())
               {
                   if (tile.getPiece().getLegalMoves(tiles, tile.getPosX(), tile.getPosY()).contains(kingTile))
                   {
                       king.setChecked(true);
                       return true;
                   }
               }
           }
        }
       return false;
    }

    /* isKingChecked : boolean
     * Paramètres : Color color
     * Cette fonction permet de vérifier si le Roi est en échec selon sa couleur
     * */
    public boolean isKingChecked(rendu2.model.Color color)
    {
        if (color == rendu2.model.Color.WHITE)
        {
            return this.kingIsChecked(whiteKing);
        }
        else
        {
            return this.kingIsChecked(blackKing);
        }
    }

    /* kingIsCheckedMate :
     * Paramètres : King king
     * Cette fonction permet de vérifier si le Roi est en échec et mat
     * */
    public boolean kingIsCheckedMate(rendu2.model.King king)
    {
        rendu2.model.Tile kingTile = getKingTile(king);
        List<rendu2.model.Tile> kingLegalMoves = king.getLegalMoves(tiles, kingTile.getPosX(), kingTile.getPosY());

        // Dans le cas où le roi est bloqué par des pièces alliées comme en début de partie par exemple
        if (kingLegalMoves.isEmpty()) {
            return false;
        }

        for (rendu2.model.Tile[] tabTile : tiles)
        {
            for (rendu2.model.Tile tile : tabTile)
            {
                // Pour chaque pièce ennemie au roi on enlève les mouvements légaux de cette pièce de la liste des mouvements du roi
                if (tile.isOccupied() && tile.getPiece().getColor() != kingTile.getPiece().getColor())
                {
                    kingLegalMoves.removeAll(tile.getPiece().getLegalMoves(tiles, tile.getPosX(), tile.getPosY()));


                    // Si le roi n'a plus de mouvements légaux, il est en échec et mat
                    if (kingLegalMoves.isEmpty()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /* isKingCheckedMate : boolean
     * Paramètres : Color color
     * Cette fonction permet de vérifier si le Roi est en échec et mat selon sa couleur
     * */
    public boolean isKingCheckedMate(rendu2.model.Color color) {
        if (color == rendu2.model.Color.WHITE) {
            return this.kingIsCheckedMate(whiteKing);
        }
        else {
            return this.kingIsCheckedMate(blackKing);
        }
    }

    /* simulateMove :
     * Paramètres : Tile src, Tile dest
     * Cette fonction permet de simuler le mouvement d'une pièce (qui sera utilisée dans la fonction move)
     * */
    public void simulateMove(rendu2.model.Tile src, rendu2.model.Tile dest)
    {
        dest.setPiece(src.getPiece());
        src.setPiece(null);
    }

    /* canMoveTo : boolean
     * Paramètres : Tile src, Tile dest
     * Cette fonction permet de vérifier si la pièce à la case source peut aller dans la case de destination
     * */
    public boolean canMoveTo(rendu2.model.Tile src, rendu2.model.Tile dest)
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
    public boolean tileIsEmpty(rendu2.model.Tile tile)
    {
        return tile.getPiece() == null;
    }


    /* move : Move
     * Paramètres : int destX, int destY, Color colorCurrentPlayer
     * Cette fonction permet de bouger une pièce en partant d'une case, pour aller à une autre.
     * */
    public rendu2.model.Move move(int destX, int destY , rendu2.model.Color colorCurrentPlayer)
    {
        rendu2.model.Tile src = this.selectedTile;
        rendu2.model.Tile dest = this.tiles[destX][destY];

        if (src.getisClicked() == true)
        {
            int prevX = src.getPosX(); // Position X de ma Tile de là où je pars
            int prevY = src.getPosY(); // Position Y de ma Tile de là où je pars
            rendu2.model.King king; // Roi

            if (colorCurrentPlayer == rendu2.model.Color.BLACK)
            {
                king = this.blackKing;
            }
            else
            {
                king = this.whiteKing;
            }

            // Est-ce que la case où je veux aller est dans mes mouvements légaux ?
            if (canMoveTo(src,dest))
            {
                boolean upgradePawn = false;
                if (src.getPiece() instanceof rendu2.model.Pawn) {
                    rendu2.model.Pawn pawn = (rendu2.model.Pawn) src.getPiece();

                    if (pawn.getIsMoved()
                            && ((destX == 0 && pawn.getColor() == rendu2.model.Color.WHITE)
                            || (destX == 7 && pawn.getColor() == rendu2.model.Color.BLACK))) {
                        upgradePawn = true;
                    }
                }

                Piece destPiece = null;

                // Si la case de destination n'est pas vide on récupère sa pièce
                if (!tileIsEmpty(dest)) {
                    destPiece = dest.getPiece();
                }

                // On simule le déplacement
                simulateMove(src,dest);

                // Est-ce que mon Roi est toujours en échec ?
                if (this.kingIsChecked(king))
                {
                    src.setPiece(dest.getPiece());
                    dest.setPiece(destPiece);
                    src.setIsClicked(false);
                }
                else
                {
                    if (dest.getPiece() instanceof rendu2.model.Pawn) {
                        ((rendu2.model.Pawn) dest.getPiece()).setIsMoved(true);
                    }

                    return new rendu2.model.Move(prevX, prevY, destX, destY, destPiece, upgradePawn);
                }
            }
            // Si ce n'est pas dans les mouvements légaux, on unselect la pièce
            else
            {
                src.setIsClicked(false);
            }
        }

        return null;
    }

    /* upgradePawnTo : void
     * Paramètre : String type, Color color, int x, int y
     * Cette fonction permet d'améliorer un pion vers le type sélectionné par le joueur
     * */
    public void upgradePawnTo(String type, Color color, int x, int y) {
        rendu2.model.Tile tile = tiles[x][y];

        // Si jamais la pièce n'est pas un pion on ne fait rien
        if (!(tile.getPiece() instanceof Pawn)) {
            return;
        }

        switch (type) {
            case "Fou":
                tile.setPiece(new Bishop(color));
                break;
            case "Cavalier":
                tile.setPiece(new Knight(color));
                break;
            case "Tour":
                tile.setPiece(new Rook(color));
                break;
            case "Reine":
                tile.setPiece(new Queen(color));
                break;
        }
    }

    /* getKingTile : Tile
     * Paramètre : King king
     * Cette fonction est un getter : Elle permet de renvoyer la case du Roi
     * */
    private rendu2.model.Tile getKingTile(King king) {
        for (rendu2.model.Tile[] tabTile : tiles) {
            for (rendu2.model.Tile tile : tabTile) {
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
    public rendu2.model.Tile getSelectedTile() {
        return this.selectedTile;
    }

    /* getTiles : Tile[][]
     * Cette fonction est un getter : Elle permet de renvoyer toutes les cases
     * */
    public Tile[][] getTiles()
    {
       return this.tiles;
    }

}