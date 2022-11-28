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
       Image black_rook = new ImageIcon("black_pieces/rook_black.png").getImage();
        black_rook = black_rook.getScaledInstance(64,64,Image.SCALE_SMOOTH);
        JLabel blackRook = new JLabel(new ImageIcon(black_rook));
        blackRook.setSize(64,64);
       tiles[0][0].add(blackRook);


    }
}
