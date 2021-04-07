package sk.stuba.fei.uim.oop.MazeGame;


import sk.stuba.fei.uim.oop.Buttons.*;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private JPanel controls;
    private Canvas canvas;
    public void drawGUI(int[][] maze) {
        int[][] helpMaze= maze;
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
        panel.add(new GenerateButton().GenerateButton());
        panel.setLayout(new GridLayout(0,3));
        panel.add(new UpButton().UpButton());
        panel.add(new JTextArea("you won :"+" game"));
        panel.add(new LeftButton().LeftButton());
        panel.add(new DownButton().DownButton());
        panel.add(new RightButton().rightButton());
        return panel;
    }
}
