package sk.stuba.fei.uim.oop.Buttons;



import sk.stuba.fei.uim.oop.MazeGame.Game;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpButton extends JButton implements ActionListener {
    private Game game;
    private final int path=1;
    private final int exit=2;
    private final int player=3;
    public UpButton(Game game){
        super("↑");
        this.game =game;
        addActionListener(this);
        setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int positionX= game.getPlayerPositionX();
        int positionY = game.getPlayerPositionY();

        if (positionX - 1 >= 0) {
            if (game.getMaze()[positionX - 1][positionY] == path || game.getMaze()[positionX - 1][positionY] == exit) {
                game.getMaze()[positionX][positionY] = path;
                game.getMaze()[positionX - 1][positionY] = player;

            }
        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }

    }
}
