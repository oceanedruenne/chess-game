package view;

import controller.GameController;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainMenu {

    public MainMenu()
    {
        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new GridLayout(2,3));
        mainFrame.setTitle("Menu");
        mainFrame.getContentPane().setBackground(Color.black);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel whitePlayer = new JPanel();
        whitePlayer.setSize(450,450);

        JLabel txtWhitePlayerName = new JLabel("Nom du joueur des pièces blanches");

        JTextField inputWhitePlayerName = new JTextField();
        inputWhitePlayerName.setBounds(250 ,250,200,200);
        inputWhitePlayerName.setBackground(Color.WHITE);

        whitePlayer.add(txtWhitePlayerName);
        whitePlayer.add(inputWhitePlayerName);

        JPanel emptyPanel = new JPanel();


        JPanel blackPlayer = new JPanel();
        blackPlayer.setSize(450,450);
        JLabel txtBlackPlayerName = new JLabel("Nom du joueur des pièces noires");

        JTextField inputBlackPlayerName = new JTextField();
        inputBlackPlayerName.setBounds(250,250,200,200);
        inputBlackPlayerName.setBackground(Color.WHITE);

        blackPlayer.add(txtBlackPlayerName);
        blackPlayer.add(inputBlackPlayerName);

        JPanel btn = new JPanel();

        JButton btnStart = new JButton("Commencer");
        btnStart.setSize(200,200);

        btn.add(btnStart);

        mainFrame.add(whitePlayer);
        mainFrame.add(emptyPanel);
        mainFrame.add(blackPlayer);
        mainFrame.add(emptyPanel);
        mainFrame.add(btn);
        mainFrame.add(emptyPanel);

        String whitePlayerName = inputWhitePlayerName.getText();
        String blackPlayerName = inputBlackPlayerName.getText();

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                new GameController(whitePlayerName, blackPlayerName);
            }
        });

        mainFrame.setSize(900,900);
        mainFrame.setVisible(true);
    }
}
