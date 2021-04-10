package sk.stuba.fei.uim.oop.Buttons;



import sk.stuba.fei.uim.oop.MazeGame.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpButton extends JButton implements ActionListener {
    private Game newGame;
    public UpButton(Game game){
        super("↑");
        this.newGame=game;
        addActionListener(this);
        setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int positionX=newGame.getPlayerPositionX();
        int positionY = newGame.getPlayerPositionY();

            if (positionX - 1 >= 0) {
                if (newGame.getMaze()[positionX - 1][positionY] == 1 || newGame.getMaze()[positionX - 1][positionY] == 2) {
                    newGame.getMaze()[positionX][positionY] = 1;
                    newGame.getMaze()[positionX - 1][positionY] = 3;

                }
            }

    }
}
