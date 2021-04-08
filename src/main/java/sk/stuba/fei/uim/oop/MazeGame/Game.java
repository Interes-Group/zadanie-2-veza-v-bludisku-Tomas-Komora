package sk.stuba.fei.uim.oop.MazeGame;


import sk.stuba.fei.uim.oop.Buttons.*;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private JPanel controls;
    private Canvas canvas;
    private int[][]helpMaze;
    public void drawGUI(int[][] maze) {
        helpMaze= maze;
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        controls = buttonPanel();
        canvas = new MyCanvas(helpMaze);
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
        panel.add(new GenerateButton().GenerateButton(helpMaze));
        panel.setLayout(new GridLayout(0,3));
        panel.add(new UpButton().UpButton(helpMaze));
        panel.add(new JTextArea("you won :"+" game"));
        panel.add(new LeftButton().LeftButton(helpMaze));
        panel.add(new DownButton().DownButton(helpMaze));
        panel.add(new RightButton().rightButton(helpMaze));
        return panel;
    }
}
