package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.MazeGame.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftButton extends JButton implements ActionListener {
    private Game game;
    private final int path=1;
    private final int player=3;
    private final int exit=2;

    public LeftButton(Game game){
        super("←");
        this.game =game;
        addActionListener(this);
        setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int positionX= game.getPlayerPositionX();
        int positionY = game.getPlayerPositionY();


        if(game.getMaze()[positionX][positionY-1]==path && positionY-1>=0 || game.getMaze()[positionX][positionY-1] == exit){
            game.getMaze()[positionX][positionY]=path;
            game.getMaze()[positionX][positionY-1]=player;
        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }

    }
}
