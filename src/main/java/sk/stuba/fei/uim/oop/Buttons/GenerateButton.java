package sk.stuba.fei.uim.oop.Buttons;


import sk.stuba.fei.uim.oop.MazeGame.Game;
import sk.stuba.fei.uim.oop.MazeGame.MazeGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateButton extends JButton implements ActionListener {
    private Game newGame;

    public GenerateButton(Game game){
        super("Generate");
        this.newGame=game;
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        newGame.generateMaze();

    }
}

