package sk.stuba.fei.uim.oop.MazeGame;

import sk.stuba.fei.uim.oop.Moving.MovingMouse;

import java.awt.*;


public class MyCanvas extends Canvas {
    private Game newGame;
    private MovingMouse movingMouse;
    public MyCanvas(Game game) {
        newGame=game;
        movingMouse=new MovingMouse(newGame);
        Canvas canvas = new Canvas();
        addMouseListener(movingMouse);
        addMouseMotionListener(movingMouse);
        canvas.setSize(canvas.getWidth(), canvas.getHeight());
        canvas.setVisible(true);
        setFocusable(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x=30;
        int y=30;
        for(int z=0;z<13;z++){
            for(int s=0;s<13;s++){
                if(newGame.getMaze()[s][z]==1){
                    g.setColor(Color.WHITE);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(newGame.getMaze()[s][z]==0){
                    g.setColor(Color.BLACK);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(newGame.getMaze()[s][z]==3){
                    g.setColor(Color.green);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(newGame.getMaze()[s][z]==4){
                    g.setColor(Color.GRAY);
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
