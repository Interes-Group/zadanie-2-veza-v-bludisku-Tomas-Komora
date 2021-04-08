package sk.stuba.fei.uim.oop.MazeGame;


import sk.stuba.fei.uim.oop.Buttons.*;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private JPanel controls;
    private Canvas canvas;
    private MazeGenerator mazeGenerator;

    public Game(){
        mazeGenerator = new MazeGenerator();
        drawGUI();
    }
    public void generateMaze(){
        mazeGenerator = new MazeGenerator();
    }
    public int[][] getMaze(){
        return mazeGenerator.getMaze();
    }
    public void drawGUI() {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        controls = buttonPanel();
        canvas = new MyCanvas(this);
        frame.add(controls, BorderLayout.EAST);
        frame.add(canvas, BorderLayout.CENTER);
        frame.setSize(700,420);
        frame.setTitle("Maze Game");
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private JPanel buttonPanel() {
        JPanel panel = new JPanel();
        panel.add(new GenerateButton(this));
        panel.setLayout(new GridLayout(0,3));
        panel.add(new UpButton(this));
        panel.add(new JTextArea("you won :"+" game"));
        panel.add(new LeftButton(this));
        panel.add(new DownButton(this));
        panel.add(new RightButton(this));
        return panel;
    }

    public int getPlayerPositionX(){
        int positionX=0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeGenerator.getMaze()[x][y]==3)
                    positionX= x;
            }
        }
        return positionX;
    }
    public int getPlayerPositionY(){
        int positionY = 0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeGenerator.getMaze()[x][y]==3) {
                    positionY = y;
                }
            }
        }
        return positionY;
    }
}
