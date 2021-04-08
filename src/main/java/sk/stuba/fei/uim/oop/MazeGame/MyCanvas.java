package sk.stuba.fei.uim.oop.MazeGame;

import java.awt.*;

public class MyCanvas extends Canvas {
    private int[][] maze;

    public MyCanvas(int[][] helpMaze) {
        Canvas canvas = new Canvas();
        canvas.setSize(canvas.getWidth(), canvas.getHeight());
        canvas.setVisible(true);
        maze=helpMaze;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x=30;
        int y=30;
        for(int z=0;z<13;z++){
            for(int s=0;s<13;s++){
                if(maze[s][z]==1){
                    g.setColor(Color.WHITE);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(maze[s][z]==0){
                    g.setColor(Color.BLACK);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(maze[s][z]==3){
                    g.setColor(Color.green);
                    g.fillRect(z*x,s*y,x,y);
                }
                else {
                    g.setColor(Color.RED);
                    g.fillRect(z*x,s*y,x,y);
                }

            }
        }
        repaint();
    }
}
