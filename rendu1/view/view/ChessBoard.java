package view;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {
    private final JPanel[][] tiles;
    public ChessBoard()
    {
        this.tiles = new JPanel[8][8];
        Dimension dimensions = new Dimension(64, 64);
        setLayout(new GridLayout(8,8));
        setSize(900,900);
        setTitle("Jeu d'échecs");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel b = new JPanel();
                b.setPreferredSize(dimensions);
                b.setMinimumSize(dimensions);
                if ((i + j + 1) % 2 == 0) {
                    b.setBackground(new java.awt.Color(255,206,158));
                } else {
                    b.setBackground(new java.awt.Color(209, 139, 71));
                }
                add(b);
                tiles[i][j] = b;
            }
        }
        //Image black_rook = new ImageIcon("black_pieces/rook_black.png").getImage();
        //black_rook = black_rook.getScaledInstance(64,64,Image.SCALE_SMOOTH);
        //JLabel blackRook = new JLabel(new ImageIcon(black_rook));
        // blackRook.setSize(64,64);
        //tiles[0][0].add(blackRook);

        JLabel blackRook = new JLabel("T");
        blackRook.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][0].add(blackRook);

        JLabel blackKnight = new JLabel("C");
        blackKnight.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][1].add(blackKnight);

        JLabel blackBishop = new JLabel("F");
        blackBishop.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][2].add(blackBishop);

        JLabel blackQueen = new JLabel("R");
        blackQueen.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][3].add(blackQueen);

        JLabel blackKing = new JLabel("K");
        blackKing.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][4].add(blackKing);

        JLabel blackBishop2 = new JLabel("F");
        blackBishop2.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][5].add(blackBishop2);

        JLabel blackKnight2 = new JLabel("C");
        blackKnight2.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][6].add(blackKnight2);

        JLabel blackRook2 = new JLabel("T");
        blackRook2.setFont(new Font("Arial",Font.BOLD,30));
        tiles[0][7].add(blackRook2);


        for (int i = 0;i<8;i++)
        {
            JLabel blackPawn = new JLabel("P");
            blackPawn.setFont(new Font("Arial",Font.BOLD,30));
            tiles[1][i].add(blackPawn);
        }

        JLabel whiteRook = new JLabel("T");
        whiteRook.setFont(new Font("Arial",Font.BOLD,30));
        whiteRook.setForeground(Color.WHITE);
        tiles[7][0].add(whiteRook);

        JLabel whiteKnight = new JLabel("C");
        whiteKnight.setFont(new Font("Arial",Font.BOLD,30));
        whiteKnight.setForeground(Color.WHITE);
        tiles[7][1].add(whiteKnight);

        JLabel whiteBishop = new JLabel("F");
        whiteBishop.setFont(new Font("Arial",Font.BOLD,30));
        whiteBishop.setForeground(Color.WHITE);
        tiles[7][2].add(whiteBishop);

        JLabel whiteQueen = new JLabel("R");
        whiteQueen.setFont(new Font("Arial",Font.BOLD,30));
        whiteQueen.setForeground(Color.WHITE);
        tiles[7][3].add(whiteQueen);

        JLabel whiteKing = new JLabel("K");
        whiteKing.setFont(new Font("Arial",Font.BOLD,30));
        whiteKing.setForeground(Color.WHITE);
        tiles[7][4].add(whiteKing);

        JLabel whiteBishop2 = new JLabel("F");
        whiteBishop2.setFont(new Font("Arial",Font.BOLD,30));
        whiteBishop2.setForeground(Color.WHITE);
        tiles[7][5].add(whiteBishop2);

        JLabel whiteKnight2 = new JLabel("C");
        whiteKnight2.setFont(new Font("Arial",Font.BOLD,30));
        whiteKnight2.setForeground(Color.WHITE);
        tiles[7][6].add(whiteKnight2);

        JLabel whiteRook2 = new JLabel("T");
        whiteRook2.setFont(new Font("Arial",Font.BOLD,30));
        whiteRook2.setForeground(Color.WHITE);
        tiles[7][7].add(whiteRook2);

        for (int i = 0;i<8;i++)
        {
            JLabel whitePawn = new JLabel("P");
            whitePawn.setFont(new Font("Arial",Font.BOLD,30));
            whitePawn.setForeground(Color.WHITE);
            tiles[6][i].add(whitePawn);
        }

    }
}
