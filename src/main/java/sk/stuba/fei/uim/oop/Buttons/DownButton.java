package sk.stuba.fei.uim.oop.Buttons;


import sk.stuba.fei.uim.oop.MazeGame.Game;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownButton extends JButton implements ActionListener {
    private Game game;
    private final int path=1;
    private final int exit=2;
    private final int player=3;

    public DownButton(Game game){
        super("↓");
        this.game =game;
        addActionListener(this);
        setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       int positionX= game.getPlayerPositionX();
       int positionY= game.getPlayerPositionY();
            if (game.getPlayerPositionX()  + 1 < 13) {
                if (game.getMaze()[positionX + 1][positionY] == path || game.getMaze()[positionX + 1][positionY] == exit) {
                    game.getMaze()[positionX][positionY] = path;
                    game.getMaze()[positionX + 1][positionY] = player;

                }

            }

        if (game.getMaze()[11][11] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }

    }

}