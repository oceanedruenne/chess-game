package rendu2.view;

import rendu2.controler.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainMenu {

    public MainMenu()
    {
        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        mainFrame.setTitle("Menu");
        mainFrame.setSize(500,300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.getContentPane().setBackground(Color.white);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("Jeu d'échecs");
        title.setFont(new Font("Verdana",Font.PLAIN,18));
        title.setBackground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel whitePlayer = new JPanel();
        whitePlayer.setSize(450,450);
        JLabel txtWhitePlayerName = new JLabel("Nom du joueur des pièces blanches");
        JTextField inputWhitePlayerName = new JTextField();
        inputWhitePlayerName.setPreferredSize(new Dimension(400,30));
        inputWhitePlayerName.setBackground(Color.WHITE);
        whitePlayer.add(txtWhitePlayerName);
        whitePlayer.add(inputWhitePlayerName);


        JPanel blackPlayer = new JPanel();
        blackPlayer.setSize(450,450);
        JLabel txtBlackPlayerName = new JLabel("Nom du joueur des pièces noires");

        JTextField inputBlackPlayerName = new JTextField();
        inputBlackPlayerName.setPreferredSize(new Dimension(400,30));
        inputBlackPlayerName.setBackground(Color.WHITE);

        blackPlayer.add(txtBlackPlayerName);
        blackPlayer.add(inputBlackPlayerName);

        JPanel btn = new JPanel();

        JButton btnStart = new JButton("Commencer");
        btnStart.setSize(200,200);

        btn.add(btnStart);

        mainFrame.add(title);
        mainFrame.add(whitePlayer);
        mainFrame.add(blackPlayer);
        mainFrame.add(btn);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String whitePlayerName = inputWhitePlayerName.getText();
                String blackPlayerName = inputBlackPlayerName.getText();
                mainFrame.dispose();
                new GameController(whitePlayerName, blackPlayerName);
            }
        });

        mainFrame.setVisible(true);
    }
}
