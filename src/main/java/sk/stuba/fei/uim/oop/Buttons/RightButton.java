package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.MazeGame.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightButton extends JButton implements ActionListener {
    private Game newGame;
    public RightButton(Game game){
        super("→");
        newGame=game;
        addActionListener(this);
        setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int positionX= newGame.getPlayerPositionX();
        int positionY = newGame.getPlayerPositionY();

            if(newGame.getMaze()[positionX][positionY+1]==1 && positionY+1>=0){
                newGame.getMaze()[positionX][positionY]=1;
                newGame.getMaze()[positionX][positionY+1]=3;
            }

    }
}
