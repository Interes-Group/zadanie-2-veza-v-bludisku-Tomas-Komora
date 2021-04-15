package sk.stuba.fei.uim.oop.Buttons;


import sk.stuba.fei.uim.oop.MazeGame.Game;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateButton extends JButton implements ActionListener {
    private Game game;

    public GenerateButton(Game game){
        super("Generate");
        this.game =game;
        addActionListener(this);
        setFocusable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        game.generateMaze();
        game.setGameWins(0);
    }
}

