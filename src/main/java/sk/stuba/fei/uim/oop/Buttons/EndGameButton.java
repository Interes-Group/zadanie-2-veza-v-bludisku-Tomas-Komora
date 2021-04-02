package sk.stuba.fei.uim.oop.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameButton implements ActionListener {

    public JButton endGameButton(){
        JButton endGame = new JButton("End Game");
        endGame.addActionListener(this);
        return endGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("End Game")){
            System.exit(0);
        }
    }
}
