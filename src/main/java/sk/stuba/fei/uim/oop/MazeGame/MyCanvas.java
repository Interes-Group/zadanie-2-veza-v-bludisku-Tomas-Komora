package sk.stuba.fei.uim.oop.MazeGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends Canvas  implements MouseListener,MouseMotionListener{
    private Game newGame;
    private int numberOfClick=0;
    public MyCanvas(Game game) {
        newGame=game;
        Canvas canvas = new Canvas();
        addMouseListener(this);
        addMouseMotionListener(this);
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


    @Override
    public void mouseClicked(MouseEvent e) {
        int playerPositionX= newGame.getPlayerPositionX();
        int playerPositionY= newGame.getPlayerPositionY();
        if(playerPositionX*30<=e.getY() && (playerPositionX+1)*30>=e.getY() &&
                playerPositionY*30<=e.getX() && (playerPositionY+1)*30>=e.getX()) {
            numberOfClick++;
        }
        if(newGame.getMaze()[e.getY()/30][e.getX()/30]==4){
            newGame.getMaze()[playerPositionX][playerPositionY]=1;
            newGame.getMaze()[e.getY()/30][e.getX()/30]=3;
            numberOfClick++;
        }
        if(newGame.getMaze()[12][11]==3){
            newGame.generateMaze();
            newGame.setGameWins(0);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
    private int posX;
    private int posY;
    @Override
    public void mouseMoved(MouseEvent e) {
        if (numberOfClick % 2 == 1) {
            posX = e.getX() / 30;
            posY = e.getY() / 30;

            if (newGame.getMaze()[posY][posX] == 1 || newGame.getMaze()[posY][posX] == 2) {
                newGame.getMaze()[posY][posX] = 4;
                }
            if (posX > 0 && posY > 0 && posY < 12 && posX < 12) {
                if (newGame.getMaze()[posY][posX - 1] == 4) {
                    newGame.getMaze()[posY][posX - 1] = 1;
                } else if (newGame.getMaze()[posY][posX + 1] == 4) {
                    newGame.getMaze()[posY][posX + 1] = 1;
                } else if (newGame.getMaze()[posY - 1][posX] == 4) {
                    newGame.getMaze()[posY - 1][posX] = 1;
                } else if (newGame.getMaze()[posY + 1][posX] == 4) {
                    newGame.getMaze()[posY + 1][posX] = 1;
                }
            }

        }
    }
}
