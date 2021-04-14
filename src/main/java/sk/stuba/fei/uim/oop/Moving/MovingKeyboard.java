package sk.stuba.fei.uim.oop.Moving;

import sk.stuba.fei.uim.oop.MazeGame.Game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingKeyboard extends JPanel implements KeyListener {
    private Game game;
    private int key;
    public MovingKeyboard(Game game){
        this.game=game;
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)
            moveUp();
        else if(key == KeyEvent.VK_DOWN)
            moveDown();
        else if(key == KeyEvent.VK_RIGHT)
            moveRight();
        else if(key == KeyEvent.VK_LEFT)
            moveLeft();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        if(key == KeyEvent.VK_UP || key== KeyEvent.VK_W)
            moveUp();
        else if(key == KeyEvent.VK_DOWN || key== KeyEvent.VK_S)
            moveDown();
        else if(key == KeyEvent.VK_RIGHT || key== KeyEvent.VK_D)
            moveRight();
        else if(key == KeyEvent.VK_LEFT || key== KeyEvent.VK_A)
            moveLeft();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void moveUp( ){
        int positionX=game.getPlayerPositionX();
        int positionY = game.getPlayerPositionY();

        if (positionX - 1 >= 0) {
            if (game.getMaze()[positionX - 1][positionY] == 1 ) {
                game.getMaze()[positionX][positionY] = 1;
                game.getMaze()[positionX - 1][positionY] = 3;

            }
        }
    }
    private void moveDown(){
        int positionX= game.getPlayerPositionX();
        int positionY= game.getPlayerPositionY();
        if (game.getPlayerPositionX()  + 1 < 13) {
            if (game.getMaze()[positionX + 1][positionY] == 1 ) {
                game.getMaze()[positionX][positionY] = 1;
                game.getMaze()[positionX + 1][positionY] = 3;
            }

        }
        if (game.getMaze()[12][11] == 3) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }
    }
    private void moveLeft(){
        int positionX= game.getPlayerPositionX();
        int positionY = game.getPlayerPositionY();


            if(game.getMaze()[positionX][positionY-1]==1 && positionY-1>=0){
                game.getMaze()[positionX][positionY]=1;
                game.getMaze()[positionX][positionY-1]=3;
            }


    }
    private void moveRight(){
        int positionX= game.getPlayerPositionX();
        int positionY = game.getPlayerPositionY();

        if(game.getMaze()[positionX][positionY+1]==1){
            game.getMaze()[positionX][positionY]=1;
            game.getMaze()[positionX][positionY+1]=3;
        }

    }


}
