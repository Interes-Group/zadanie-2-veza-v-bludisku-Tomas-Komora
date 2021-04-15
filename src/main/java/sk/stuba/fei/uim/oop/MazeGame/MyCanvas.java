package sk.stuba.fei.uim.oop.MazeGame;

import sk.stuba.fei.uim.oop.Moving.MovingMouse;

import java.awt.*;


public class MyCanvas extends Canvas {
    private Game game;
    private final int wall=0;
    private final int path=1;
    private final int exit=2;
    private final int player=3;

    public MyCanvas(Game game) {
        this.game =game;
        MovingMouse movingMouse = new MovingMouse(this.game);
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
                if(game.getMaze()[s][z]==path){
                    g.setColor(Color.WHITE);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(game.getMaze()[s][z]==wall){
                    g.setColor(Color.BLACK);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(game.getMaze()[s][z]==player){
                    g.setColor(Color.green);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(game.getMaze()[s][z]==4){
                    g.setColor(Color.GRAY);
                    g.fillRect(z*x,s*y,x,y);
                }
                else if(game.getMaze()[s][z]==exit){
                    g.setColor(Color.RED);
                    g.fillRect(z*x,s*y,x,y);
                }
            }
        }
        repaint();
    }

}
