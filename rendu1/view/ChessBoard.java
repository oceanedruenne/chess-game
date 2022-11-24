import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {
    private final JPanel[][] tiles = new JPanel[8][8];
    public ChessBoard()
    {
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
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                add(b);
                tiles[i][j] = b;
            }
        }
    }
}
