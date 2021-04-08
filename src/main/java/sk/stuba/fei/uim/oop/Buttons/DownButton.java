package sk.stuba.fei.uim.oop.Buttons;


import sk.stuba.fei.uim.oop.MazeGame.Player;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownButton extends JButton implements ActionListener {
    private int[][]mazeA;
    public JButton DownButton(int [][]maze) {
        mazeA=maze;
        JButton downButton = new JButton("↓");
        downButton.addActionListener(this);
        return downButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int positionX=0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeA[x][y]==3)
                    positionX= x;
            }
        }
        int positionY = 0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeA[x][y]==3)
                    positionY= y;
            }
        }
        if (e.getActionCommand().equals("↓")) {
            if(mazeA[positionX+1][positionY]==1 &&positionX+1>=0){
                mazeA[positionX][positionY]=1;
                mazeA[positionX+1][positionY]=3;
                if(mazeA[0][1]==1){
                    mazeA[0][1]=2;
                }
            }
            repaint();
        }
    }

}