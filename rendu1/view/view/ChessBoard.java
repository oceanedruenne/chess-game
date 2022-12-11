package view;

import controller.GameController;
import model.Game;
import model.Piece;
import model.Tile;
import observers.IModelObserver;
import observers.IViewObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessBoard extends JFrame implements IModelObserver {
    private final JPanel[][] TILES; // Tableau de JPanel à 2 dimensions
    private IViewObserver observer; // L'observer de la vue qui va modifier le modèle

    private JPanel leapedWhitePieces = new JPanel(); // Endroit pour les pièces blanches attrapées
    private JPanel leapedBlackPieces = new JPanel(); // Endroit pour les pièces noires attrapées
    public ChessBoard(Game game)
    {
        game.setObserver(this);
        JLabel nameWhitePlayer = new JLabel(); // label pour le nom du joueur blanc
        JLabel nameBlackPlayer = new JLabel(); // label pour le nom du joueur noir

        this.TILES = new JPanel[8][8];
        Dimension dimensions = new Dimension(64, 64); // Taille d'une case
        setLayout(new GridLayout(8,8)); // Placement des lignes et des colonnes
        setSize(900,900); // Taille de la fenêtre
        setTitle("Jeu d'échecs"); // Titre
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Permet de fermer la fenêtre lorsqu'on clique sur la croix
        setVisible(true); // permet d'afficher le contenu de la fenêtre

        /* BOUCLE QUI PERMET DE CRÉER LES CASES DE DIFFÉRENTES COULEURS SELON LE PLACEMENT */
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel tile = new JPanel();
                tile.setPreferredSize(dimensions);
                tile.setMinimumSize(dimensions);
                if ((i + j + 1) % 2 == 0) {
                    tile.setBackground(new Color(255,206,158));
                } else {
                    tile.setBackground(new Color(209, 139, 71));
                }
                add(tile);
                TILES[i][j] = tile;
            }
        }
        /* ---------- AJOUT DES PIÈCES NOIRES ---------- */
        JLabel blackRook = new JLabel("T");
        blackRook.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][0].add(blackRook);

        JLabel blackKnight = new JLabel("C");
        blackKnight.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][1].add(blackKnight);

        JLabel blackBishop = new JLabel("F");
        blackBishop.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][2].add(blackBishop);

        JLabel blackQueen = new JLabel("R");
        blackQueen.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][3].add(blackQueen);

        JLabel blackKing = new JLabel("K");
        blackKing.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][4].add(blackKing);

        JLabel blackBishop2 = new JLabel("F");
        blackBishop2.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][5].add(blackBishop2);

        JLabel blackKnight2 = new JLabel("C");
        blackKnight2.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][6].add(blackKnight2);

        JLabel blackRook2 = new JLabel("T");
        blackRook2.setFont(new Font("Arial",Font.BOLD,30));
        TILES[0][7].add(blackRook2);


        for (int i = 0;i<8;i++)
        {
            JLabel blackPawn = new JLabel("P");
            blackPawn.setFont(new Font("Arial",Font.BOLD,30));
            TILES[1][i].add(blackPawn);
        }

        /* ---------- AJOUT DES PIÈCES BLANCHES ---------- */
        JLabel whiteRook = new JLabel("T");
        whiteRook.setFont(new Font("Arial",Font.BOLD,30));
        whiteRook.setForeground(Color.WHITE);
        TILES[7][0].add(whiteRook);

        JLabel whiteKnight = new JLabel("C");
        whiteKnight.setFont(new Font("Arial",Font.BOLD,30));
        whiteKnight.setForeground(Color.WHITE);
        TILES[7][1].add(whiteKnight);

        JLabel whiteBishop = new JLabel("F");
        whiteBishop.setFont(new Font("Arial",Font.BOLD,30));
        whiteBishop.setForeground(Color.WHITE);
        TILES[7][2].add(whiteBishop);

        JLabel whiteQueen = new JLabel("R");
        whiteQueen.setFont(new Font("Arial",Font.BOLD,30));
        whiteQueen.setForeground(Color.WHITE);
        TILES[7][3].add(whiteQueen);

        JLabel whiteKing = new JLabel("K");
        whiteKing.setFont(new Font("Arial",Font.BOLD,30));
        whiteKing.setForeground(Color.WHITE);
        TILES[7][4].add(whiteKing);

        JLabel whiteBishop2 = new JLabel("F");
        whiteBishop2.setFont(new Font("Arial",Font.BOLD,30));
        whiteBishop2.setForeground(Color.WHITE);
        TILES[7][5].add(whiteBishop2);

        JLabel whiteKnight2 = new JLabel("C");
        whiteKnight2.setFont(new Font("Arial",Font.BOLD,30));
        whiteKnight2.setForeground(Color.WHITE);
        TILES[7][6].add(whiteKnight2);

        JLabel whiteRook2 = new JLabel("T");
        whiteRook2.setFont(new Font("Arial",Font.BOLD,30));
        whiteRook2.setForeground(Color.WHITE);
        TILES[7][7].add(whiteRook2);

        for (int i = 0;i<8;i++)
        {
            JLabel whitePawn = new JLabel("P");
            whitePawn.setFont(new Font("Arial",Font.BOLD,30));
            whitePawn.setForeground(Color.WHITE);
            TILES[6][i].add(whitePawn);
        }

        /* MOUSE LISTENER (en cours de modification)
         * PERMETTRONT LA GESTION DE L'AFFICHAGE DES PIÈCES
         */

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

        for (int i = 0;i<TILES.length;i++) {
            for (int j = 0; j < TILES.length; j++) {
                TILES[i][j].addMouseListener(listener);
            }
        }
    }

    /* ------- FONCTIONS IMPLÉMENTÉES DE L'INTERFACE IMODELOBSERVER*/
    @Override
    public void startGame(String whitePlayerName, String blackPlayerName) {

    }

    @Override
    public void tileSelected(Tile tile) {

    }

    @Override
    public void movePiece(Piece piece) {

    }


    @Override
    public void checkedKing() {

    }

    @Override
    public void nextRound() {

    }

    @Override
    public void checkedMate(model.Color couleur) {

    }

    public void setObserver(IViewObserver viewObserver) {
        this.observer = viewObserver;
    }
}
