package sk.stuba.fei.uim.oop.MazeGame;


import sk.stuba.fei.uim.oop.Buttons.*;
import sk.stuba.fei.uim.oop.Moving.MovingKeyboard;


import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private MazeGenerator mazeGenerator;
    private int gameWins=0;
    private final int player=3;


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

    public MazeGenerator getMazeGenerator(){
        return mazeGenerator;
    }

    public int getGameWins() {
        return gameWins;
    }

    public void setGameWins(int gameWins) {
        this.gameWins = gameWins;
    }

    public void drawGUI() {
        JFrame frame=new JFrame();
        MovingKeyboard movingKeyboard = new MovingKeyboard(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(movingKeyboard);
        JPanel controls = buttonPanel();
        Canvas canvas = new MyCanvas(this);

        frame.add(controls, BorderLayout.EAST);
        frame.add(canvas, BorderLayout.CENTER);

        frame.setSize(720,420);
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
        panel.add(new CanvasText(this));
        panel.add(new LeftButton(this));
        panel.add(new DownButton(this));
        panel.add(new RightButton(this));
        return panel;
    }

    public int getPlayerPositionX(){
        int positionX=0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeGenerator.getMaze()[x][y]==player)
                    positionX= x;
            }
        }
        return positionX;
    }
    public int getPlayerPositionY(){
        int positionY = 0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeGenerator.getMaze()[x][y]==player) {
                    positionY = y;
                }
            }
        }
        return positionY;
    }


}
