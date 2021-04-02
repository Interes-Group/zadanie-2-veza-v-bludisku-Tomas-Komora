package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton implements ActionListener {

    public JButton newGameButton(){
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(this);
        return newGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Game game = new Game();
        if (e.getActionCommand().equals("New Game")){

            game.game();
        }
    }
}
