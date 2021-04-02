package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Buttons.EndGameButton;
import sk.stuba.fei.uim.oop.Buttons.NewGameButton;

import javax.swing.*;
import java.awt.*;

public class Game {
    public void game(){
        EndGameButton endGame=new EndGameButton();
        NewGameButton newGame=new NewGameButton();
        var frame = new JFrame();
        var panel = new JPanel();
        JButton endGameButton= endGame.endGameButton();
        JButton newGameButton= newGame.newGameButton();
        JButton goUp = new JButton("↑");
        JButton goDown = new JButton("↓");
        JButton goLeft = new JButton("←");
        JButton goRight = new JButton("→");

        Dimension size = endGameButton.getPreferredSize();
        endGameButton.setBounds(400, 10, size.width, size.height);
        panel.setLayout(null);
        panel.add(endGameButton);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        newGameButton.setBounds(400,50,size.width,size.height);
        panel.setLayout(null);
        panel.add(newGameButton);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        goUp.setBounds(440,90,30,30);
        panel.setLayout(null);
        panel.add(goUp);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        goLeft.setBounds(420,130,30,30);
        panel.setLayout(null);
        panel.add(goLeft);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        goRight.setBounds(460,130,30,30);
        panel.setLayout(null);
        panel.add(goRight);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        goDown.setBounds(440,170,30,30);
        panel.setLayout(null);
        panel.add(goDown);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        frame.add(panel);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
