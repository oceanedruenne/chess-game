package rendu2.view;

import rendu2.controler.GameController;
import rendu2.observers.IModelObserver;
import rendu2.observers.IViewObserver;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard extends JFrame implements IModelObserver {
    /* ------------------------------ DÉCLARATION DES ATTRIBUTS --------------------------------- */
    private int selectedPosX;
    private int selectedPosY;
    private List<rendu2.model.Piece> whiteLostPiecesList;
    private List<rendu2.model.Piece> blackLostPiecesList;
    private JPanel whitePanel = new JPanel();
    private JPanel blackPanel = new JPanel();
    private JPanel whiteLostPiecesPanel = new JPanel();
    private JPanel blackLostPiecesPanel = new JPanel();
    public JPanel mainPanel;
    private final JPanel[][] TILES; // Tableau de JPanel à 2 dimensions
    private JPanel[][] whiteLostPieces = new JPanel[4][4];
    private JPanel[][] blackLostPieces = new JPanel[4][4];

    private IViewObserver observer; // L'observer de la vue qui va modifier le modèle
    private JLabel checked;
    private JLabel nameWhitePlayer;
    private JLabel nameBlackPlayer;

    private Dimension dimensions = new Dimension(64, 64); // Taille d'une case
    private Dimension dimensionsPiece = new Dimension(48, 48); // Taille d'une pièce

    public rendu2.model.Board board = new rendu2.model.Board();
    public rendu2.model.Tile[][] tiles = board.getTiles();


    public ChessBoard(rendu2.model.Game game)
    {
        /* ------------------------------ INITIALISATION DES ATTRIBUTS --------------------------------- */
        checked = new JLabel("Échec");
        checked.setFont(new Font("Verdana",Font.PLAIN,16));
        checked.setAlignmentX(Component.CENTER_ALIGNMENT);

        setSize(868,612);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel = new JPanel(); // Panel parent
        mainPanel.setSize(868,612);

        JPanel board = new JPanel(); // Panel englobant le plateau

        this.TILES = new JPanel[8][8]; // Plateau


        game.setObserver(this);

        nameWhitePlayer = new JLabel(game.getWhitePlayerName()); // label pour le nom du joueur blanc
        nameWhitePlayer.setFont(new Font("Verdana",Font.PLAIN,16));
        nameWhitePlayer.setForeground(Color.WHITE);
        nameWhitePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        whitePanel.add(nameWhitePlayer);

        nameBlackPlayer = new JLabel(game.getBlackPlayerName()); // label pour le nom du joueur noir
        nameBlackPlayer.setFont(new Font("Verdana",Font.PLAIN,16));
        nameBlackPlayer.setForeground(Color.BLACK);
        nameBlackPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        blackPanel.add(nameBlackPlayer);

        JLabel capturedPiecesByWhiteLabel = new JLabel("Pièces capturées");
        capturedPiecesByWhiteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        capturedPiecesByWhiteLabel.setForeground(Color.WHITE);
        whitePanel.add(capturedPiecesByWhiteLabel);

        JLabel capturedPiecesByBlackLabel = new JLabel("Pièces capturées");
        capturedPiecesByBlackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        capturedPiecesByBlackLabel.setForeground(Color.WHITE);
        blackPanel.add(capturedPiecesByBlackLabel);


        this.whiteLostPiecesList = new ArrayList<rendu2.model.Piece>();
        this.blackLostPiecesList = new ArrayList<rendu2.model.Piece>();

        board.setLayout(new GridLayout(8, 8)); // Placement des lignes et des colonnes
        board.setSize(512,512);



        setVisible(true); // permet d'afficher le contenu de la fenêtre

        /* -------------------------- CRÉATION DES CASES AVEC LES DIFFÉRENTES COULEURS ----------------------------- */
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel tile = new JPanel();
                tile.setPreferredSize(dimensions);
                tile.setMinimumSize(dimensions);
                if ((i + j + 1) % 2 == 0) {
                    tile.setBackground(new Color(255, 206, 158));
                } else {
                    tile.setBackground(new Color(209, 139, 71));
                }
                add(tile);
                TILES[i][j] = tile;
            }
        }

        /* -------------------------------------- AJOUT DES PIÈCES NOIRES ------------------------------------------- */
        ImageIcon blackRookIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/rook_black.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackRook = new JLabel(blackRookIcon);
        blackRook.setPreferredSize(dimensions);
        TILES[0][0].add(blackRook);

        ImageIcon blackKnightIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/knight_black.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackKnight = new JLabel(blackKnightIcon);
        blackKnight.setPreferredSize(dimensions);
        TILES[0][1].add(blackKnight);

        ImageIcon blackBishopIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/bishop_black.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackBishop = new JLabel(blackBishopIcon);
        blackBishop.setPreferredSize(dimensions);
        TILES[0][2].add(blackBishop);

        ImageIcon blackQueenIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/queen_black.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackQueen = new JLabel(blackQueenIcon);
        blackQueen.setPreferredSize(dimensions);
        TILES[0][3].add(blackQueen);

        ImageIcon blackKingIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/king_black.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackKing = new JLabel(blackKingIcon);
        blackKing.setPreferredSize(dimensions);
        TILES[0][4].add(blackKing);

        ImageIcon blackBishopIcon2 = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/bishop_black.png"))
                        .getImage()
                        .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackBishop2 = new JLabel(blackBishopIcon2);
        blackBishop2.setPreferredSize(dimensions);
        TILES[0][5].add(blackBishop2);


        ImageIcon blackKnightIcon2 = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/knight_black.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackKnight2 = new JLabel(blackKnightIcon2);
        blackKnight2.setPreferredSize(dimensions);
        TILES[0][6].add(blackKnight2);

        ImageIcon blackRookIcon2 = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/rook_black.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );
        JLabel blackRook2 = new JLabel(blackRookIcon2);
        blackRook2.setPreferredSize(dimensions);
        TILES[0][7].add(blackRook2);


        /* ---------------------------- AJOUT DES PIONS NOIRS ---------------------------- */
        for (int i = 0;i<8;i++)
        {
            ImageIcon blackPawnIcon = new ImageIcon(
                    new ImageIcon(getClass().getResource("/rendu2/img/black_pieces/pawn_black.png"))
                     .getImage()
                     .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
            );
            JLabel blackPawn = new JLabel(blackPawnIcon);
            blackPawn.setPreferredSize(dimensions);
            TILES[1][i].add(blackPawn);
        }

        /* -------------------------------------- AJOUT DES PIÈCES BLANCHES ------------------------------------------*/
        ImageIcon whiteRookIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/rook_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteRook = new JLabel(whiteRookIcon);
        whiteRook.setPreferredSize(dimensions);
        TILES[7][0].add(whiteRook);

        ImageIcon whiteKnightIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/knight_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteKnight = new JLabel(whiteKnightIcon);
        whiteKnight.setPreferredSize(dimensions);
        TILES[7][1].add(whiteKnight);

        ImageIcon whiteBishopIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/bishop_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteBishop = new JLabel(whiteBishopIcon);
        whiteBishop.setPreferredSize(dimensions);
        TILES[7][2].add(whiteBishop);

        ImageIcon whiteQueenIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/queen_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteQueen = new JLabel(whiteQueenIcon);
        whiteQueen.setPreferredSize(dimensions);
        TILES[7][3].add(whiteQueen);

        ImageIcon whiteKingIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/king_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteKing = new JLabel(whiteKingIcon);
        whiteKing.setPreferredSize(dimensions);
        TILES[7][4].add(whiteKing);


        ImageIcon whiteBishopIcon2 = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/bishop_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteBishop2 = new JLabel(whiteBishopIcon2);
        whiteBishop2.setPreferredSize(dimensions);
        TILES[7][5].add(whiteBishop2);

        ImageIcon whiteKnightIcon2 = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/knight_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteKnight2 = new JLabel(whiteKnightIcon2);
        whiteKnight2.setPreferredSize(dimensions);
        TILES[7][6].add(whiteKnight2);


        ImageIcon whiteRookIcon2 = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/rook_white.png"))
                .getImage()
                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
        JLabel whiteRook2 = new JLabel(whiteRookIcon2);
        whiteRook2.setPreferredSize(dimensions);
        TILES[7][7].add(whiteRook2);


        /* ---------------------------- AJOUT DES PIONS BLANCS ---------------------------- */
        for (int i = 0;i<8;i++)
        {
            ImageIcon whitePawnIcon = new ImageIcon(
                    new ImageIcon(getClass().getResource("/rendu2/img/white_pieces/pawn_white.png"))
                    .getImage()
                    .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH));
            JLabel whitePawn = new JLabel(whitePawnIcon);
            whitePawn.setPreferredSize(dimensions);
            TILES[6][i].add(whitePawn);
        }

        /* ---------------------------- AJOUT DES CASES DANS LE PLATEAU ---------------------------- */
        for (int i = 0; i < TILES.length;i++)
        {
            for (int j = 0; j < TILES[i].length; j++)
            {
                board.add(TILES[i][j]);
            }
        }

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        whitePanel.setLayout(new BoxLayout(whitePanel, BoxLayout.Y_AXIS));

        whitePanel.setBackground(Color.GRAY);
        whitePanel.setMinimumSize(new Dimension(150,573));
        whitePanel.setMaximumSize(new Dimension(150,573));
        whitePanel.setPreferredSize(new Dimension(150,573));

        blackLostPiecesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        blackLostPiecesPanel.setLayout(new GridLayout(4,4));
        blackLostPiecesPanel.setMinimumSize(new Dimension(128,128));
        blackLostPiecesPanel.setMaximumSize(new Dimension(128,128));
        blackLostPiecesPanel.setPreferredSize(new Dimension(128,128));


        /* --------------------------- CRÉATION DE LA GRILLE POUR LES PIÈCES NOIRES CAPTURÉES ----------------------- */
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JPanel tile = new JPanel();
                tile.setPreferredSize(new Dimension(32,32));
                tile.setMinimumSize(new Dimension(32,32));
                tile.setMaximumSize(new Dimension(32,32));
                tile.setBorder(new LineBorder(Color.BLACK,1));
                tile.setBackground(Color.GRAY);
                blackLostPieces[i][j] = tile;
                blackLostPiecesPanel.add(blackLostPieces[i][j]);
            }
        }

        whitePanel.add(blackLostPiecesPanel, Component.CENTER_ALIGNMENT);

        blackPanel.setLayout(new BoxLayout(blackPanel,BoxLayout.Y_AXIS));
        blackPanel.setBackground(Color.GRAY);
        blackPanel.setMinimumSize(new Dimension(150,573));
        blackPanel.setMaximumSize(new Dimension(150,573));
        blackPanel.setPreferredSize(new Dimension(150,573));

        /* ------------------------- CRÉATION DE LA GRILLE POUR LES PIÈCES BLANCHES CAPTURÉES ----------------------- */
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JPanel tile = new JPanel();
                tile.setPreferredSize(new Dimension(32,32));
                tile.setMinimumSize(new Dimension(32,32));
                tile.setMaximumSize(new Dimension(32,32));
                tile.setBorder(new LineBorder(Color.BLACK,1));
                tile.setBackground(Color.GRAY);

                whiteLostPieces[i][j] = tile;
                whiteLostPiecesPanel.add(whiteLostPieces[i][j]);
            }
        }

        whiteLostPiecesPanel.setLayout(new GridLayout(4,4));
        whiteLostPiecesPanel.setBackground(Color.GRAY);
        whiteLostPiecesPanel.setMinimumSize(new Dimension(128,128));
        whiteLostPiecesPanel.setMaximumSize(new Dimension(128,128));
        whiteLostPiecesPanel.setPreferredSize(new Dimension(128,128));

        blackPanel.add(whiteLostPiecesPanel,Component.CENTER_ALIGNMENT);

        mainPanel.add(whitePanel);
        mainPanel.add(board);
        mainPanel.add(blackPanel);

        add(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        /* --------------------------- MOUSELISTENER POUR GÉRER LES CLICS ----------------------- */

        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel clickedPanel = (JPanel) e.getSource();
                for (int i = 0; i < 8; i++)
                {
                    for (int j = 0; j < 8; j++)
                    {
                        if (TILES[i][j] == clickedPanel)
                        {
                            observer.tileClicked(i,j);
                            break;
                        }
                    }
                }
            }


           @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        /* --------------------------- BOUCLE POUR AJOUTER À CHAQUE CASE LE MOUSELISTENER ----------------------- */
        for (int i = 0;i<TILES.length;i++) {
            for (int j = 0; j < TILES.length; j++) {
                TILES[i][j].addMouseListener(listener);
            }
        }

    }

    /* disableBlackPieces : boolean
     * Cette fonction permet de désactiver les pièces noires
     * depuis sa position
     */
    public boolean disableBlackPieces()
    {
        for (int i = 0; i<8; i++)
        {
            TILES[0][i].setEnabled(false);
        }

        for (int j = 0; j<8 ; j++)
        {
            TILES[1][j].setEnabled(false);
        }

        return true;
    }


    /* startGame :
     * Paramètres : String whitePlayerName, String blackPlayerName
     * Cette fonction permet de démarrer une partie en désactivant les pièces noires
     * depuis sa position
     */
    @Override
    public void startGame(String whitePlayerName, String blackPlayerName) {
        disableBlackPieces();
    }


    /* tileSelected :
     * Paramètres : int posX, int posY, List<Tile> legalMoves
     * Cette fonction permet d'ajouter une bordure verte à la case selectionnée et d'afficher
     * en vert les cases où elle peut aller
     */
    @Override
    public void tileSelected(int posX, int posY, List<rendu2.model.Tile> legalMoves) {

        for (int i = 0; i<8;i++)
        {
            for (int j = 0; j<8;j++)
            {
                if ((i + j + 1) % 2 == 0) {
                    TILES[i][j].setBackground(new Color(255,206,158));
                } else {
                    TILES[i][j].setBackground(new Color(209, 139, 71));
                }
            }
        }
        if (selectedPosX != -1 && selectedPosY != -1 ) {
            TILES[selectedPosX][selectedPosY].setBorder(null);
        }
        this.selectedPosX = posX;
        this.selectedPosY = posY;

        if (posX != -1 && posY != -1 ) {
            TILES[posX][posY].setBorder(new LineBorder(Color.GREEN,5));
        }

        for (rendu2.model.Tile tile : legalMoves)
        {
            TILES[tile.getPosX()][tile.getPosY()].setBackground(Color.GREEN);
        }
    }


    /* movePiece :
     * Paramètres : Move move
     * Cette fonction permet de gérer les mouvements des pièces, en retirant leur image dans leur case de départ
     * pour ajouter cette même image dans leur case d'arrivée
     * en vert les cases où elle peut aller
     */
    @Override
    public void movePiece(rendu2.model.Move move) {
        JLabel pieceImage = (JLabel)TILES[move.getPrevX()][move.getPrevY()].getComponent(0);
        TILES[move.getPrevX()][move.getPrevY()].remove(0);
        TILES[move.getPrevX()][move.getPrevY()].repaint();
        TILES[move.getPrevX()][move.getPrevY()].setBorder(null);

        if (TILES[move.getDestX()][move.getDestY()].getComponentCount() > 0)
        {
            ImageIcon pieceIcon = (ImageIcon) ((JLabel)TILES[move.getDestX()][move.getDestY()].getComponent(0)).getIcon();
            ImageIcon pieceToRemove = new ImageIcon(pieceIcon.getImage().getScaledInstance(16,16, Image.SCALE_SMOOTH));
            JLabel pieceToRemoveLabel = new JLabel(pieceToRemove);


            pieceToRemoveLabel.setPreferredSize(new Dimension(16, 16));
            pieceToRemoveLabel.repaint();

            TILES[move.getDestX()][move.getDestY()].remove(0);

            if (move.getPieceToRemove() != null)
            {
                if (move.getPieceToRemove().getColor() == rendu2.model.Color.BLACK)
                {

                    blackLostPieces[(int)blackLostPiecesList.size()/4][blackLostPiecesList.size()%4].add(pieceToRemoveLabel);
                    blackLostPieces[(int)blackLostPiecesList.size()/4][blackLostPiecesList.size()%4].repaint();
                    this.blackLostPiecesList.add(move.getPieceToRemove());

                    whitePanel.repaint();
                }
                else
                {
                    whiteLostPieces[(int)whiteLostPiecesList.size()/4][whiteLostPiecesList.size()%4].add(pieceToRemoveLabel);
                    whiteLostPieces[(int)whiteLostPiecesList.size()/4][whiteLostPiecesList.size()%4].repaint();
                    this.whiteLostPiecesList.add(move.getPieceToRemove());


                    blackPanel.repaint();
                }
            }
        }
        TILES[move.getDestX()][move.getDestY()].add(pieceImage);
        TILES[move.getDestX()][move.getDestY()].repaint();

    }

    /* checkedKing :
     * Paramètres : boolean whiteKingIsChecked, boolean blackKingIsChecked
     * Cette fonction permet d'ajouter un texte indiquant si le joueur est en échec
     * si c'est le cas
     */
    @Override
    public void checkedKing(boolean whiteKingIsChecked, boolean blackKingIsChecked)
    {

        if (whiteKingIsChecked == true)
        {
            whitePanel.add(checked, Component.BOTTOM_ALIGNMENT);
        }

        else
        {
            whitePanel.remove(checked);
        }

        if (blackKingIsChecked == true)
        {
            blackPanel.add(checked, Component.BOTTOM_ALIGNMENT);
        }

        else
        {
            blackPanel.remove(checked);
        }

        whitePanel.repaint();
        blackPanel.repaint();
    }

    /* upgradePawn :
     * Paramètre : int x, int y
     * Cette fonction permet de modifier le pion en une autre pièce lorsqu'il atteint l'autre camp
     */
    @Override
    public void openUpgradePawnDialog(int x, int y) {
        JDialog dialog = new JDialog(this, "Améliorer le pion");

        JPanel panel = new JPanel();

        ActionListener btnAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                notifyUpgradePawn(button.getText(), x, y);
                dialog.dispose();
            }
        };

        JButton bishopBtn = new JButton("Fou");
        bishopBtn.setSize(100,50);
        bishopBtn.addActionListener(btnAction);
        JButton knightBtn = new JButton("Cavalier");
        knightBtn.setSize(100,50);
        knightBtn.addActionListener(btnAction);
        JButton rookBtn = new JButton("Tour");
        rookBtn.setSize(100,50);
        rookBtn.addActionListener(btnAction);
        JButton queenBtn = new JButton("Reine");
        queenBtn.setSize(100,50);
        queenBtn.addActionListener(btnAction);

        panel.add(bishopBtn);
        panel.add(knightBtn);
        panel.add(rookBtn);
        panel.add(queenBtn);
        dialog.add(panel);

        dialog.setSize(425, 75);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        setEnabled(false);
    }

    private void notifyUpgradePawn(String type, int x, int y) {
        if (x == 0) {
            observer.upgradePawn(type, rendu2.model.Color.WHITE, x, y);

        }
        else if (x == 7) {
            observer.upgradePawn(type, rendu2.model.Color.BLACK, x, y);
        }
    }

    @Override
    public void upgradePawn(String type, int x, int y) {
        String colorStr;
        rendu2.model.Color color;

        if (x == 0) {
            colorStr = "white";
            color = rendu2.model.Color.WHITE;

        }
        else if (x == 7) {
            colorStr = "black";
            color = rendu2.model.Color.BLACK;
        }
        else {
            // should never happen
            return;
        }

        // Initialize icon just in case of type not in switch but it should never happen
        ImageIcon pieceIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/rendu2/img/" + colorStr + "_pieces/pawn_" + colorStr + ".png"))
                        .getImage()
                        .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
        );

        switch (type) {
            case "Fou":
                pieceIcon = new ImageIcon(
                        new ImageIcon(getClass().getResource("/rendu2/img/" + colorStr + "_pieces/bishop_" + colorStr + ".png"))
                                .getImage()
                                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
                );
                break;
            case "Cavalier":
                pieceIcon = new ImageIcon(
                        new ImageIcon(getClass().getResource("/rendu2/img/" + colorStr + "_pieces/knight_" + colorStr + ".png"))
                                .getImage()
                                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
                );
                break;
            case "Tour":
                pieceIcon = new ImageIcon(
                        new ImageIcon(getClass().getResource("/rendu2/img/" + colorStr + "_pieces/rook_" + colorStr + ".png"))
                                .getImage()
                                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
                );
                break;
            case "Reine":
                pieceIcon = new ImageIcon(
                        new ImageIcon(getClass().getResource("/rendu2/img/" + colorStr + "_pieces/queen_" + colorStr + ".png"))
                                .getImage()
                                .getScaledInstance(dimensionsPiece.width, dimensionsPiece.height, Image.SCALE_SMOOTH)
                );
                break;
        }

        JLabel pieceLabel = new JLabel(pieceIcon);
        pieceLabel.setPreferredSize(dimensions);

        TILES[x][y].remove(0);
        TILES[x][y].add(pieceLabel);
        pieceLabel.revalidate();
        pieceLabel.repaint();
        TILES[x][y].repaint();

        setEnabled(true);
    }

    @Override
    public void openEndGameDialog(String winnerName) {
        JDialog dialog = new JDialog(this, "Fin de partie");

        JPanel panel = new JPanel();

        ActionListener btnAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                new GameController(nameWhitePlayer.getText(), nameBlackPlayer.getText());
                dispose();
            }
        };

        JLabel winnerTxt = new JLabel(winnerName + " a gagné");
        nameWhitePlayer.setFont(new Font("Verdana", Font.PLAIN, 16));
        nameWhitePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton restartBtn = new JButton("Recommencer");
        restartBtn.setSize(100, 50);
        restartBtn.addActionListener(btnAction);

        panel.add(winnerTxt);
        panel.add(restartBtn);
        dialog.add(panel);

        dialog.setSize(425, 75);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        setEnabled(false);
    }


    /* setObserver :
     * Paramètre : IViewObserver viewObserver
     * Cette fonction permet de donner une valeur à l'attribut observer
     */
    public void setObserver(IViewObserver viewObserver) {
        this.observer = viewObserver;
    }
}
