package sk.stuba.fei.uim.oop.Buttons;


import sk.stuba.fei.uim.oop.MazeGame.MazeGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateButton extends JButton implements ActionListener {
    private int[][] newMaze;
    MazeGenerator mazeGenerator = new MazeGenerator(11);

    public JButton GenerateButton(int[][] maze){
        newMaze =maze;
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(this);
        return generateButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Generate")){
            for(int x= 0; x <13;x++){
                for(int y=0;y<13;y++){
                    newMaze[x][y]=0;
                }
            }
            newMaze =mazeGenerator.generateMaze(11);

        }
    }
}

