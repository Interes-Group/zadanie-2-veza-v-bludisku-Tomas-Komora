package sk.stuba.fei.uim.oop.Moving;

import sk.stuba.fei.uim.oop.MazeGame.Game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingKeyboard extends JPanel implements KeyListener {
    private Game game;
    private int key;
    private final int wall=0;
    private final int path=1;
    private final int exit=2;
    private final int player=3;

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

        if (positionX - 1 >= wall) {
            if (game.getMaze()[positionX - 1][positionY] == path || game.getMaze()[positionX - 1][positionY] == exit) {
                game.getMaze()[positionX][positionY] = path;
                game.getMaze()[positionX - 1][positionY] = player;

            }
        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }
    }
    private void moveDown(){
        int positionX= game.getPlayerPositionX();
        int positionY= game.getPlayerPositionY();
        if (game.getPlayerPositionX()  + 1 < 13) {
            if (game.getMaze()[positionX + 1][positionY] == path || game.getMaze()[positionX + 1][positionY] == exit) {
                game.getMaze()[positionX][positionY] = path;
                game.getMaze()[positionX + 1][positionY] = player;
            }

        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }
    }
    private void moveLeft(){
        int positionX= game.getPlayerPositionX();
        int positionY = game.getPlayerPositionY();


            if((game.getMaze()[positionX][positionY-1]==path || game.getMaze()[positionX][positionY-1] == exit)&& positionY-1>=0){
                game.getMaze()[positionX][positionY]=path;
                game.getMaze()[positionX][positionY-1]=player;
            }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }


    }
    private void moveRight(){
        int positionX= game.getPlayerPositionX();
        int positionY = game.getPlayerPositionY();

        if(game.getMaze()[positionX][positionY+1]==path || game.getMaze()[positionX][positionY+1] == exit){
            game.getMaze()[positionX][positionY]=path;
            game.getMaze()[positionX][positionY+1]=player;
        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }

    }


}
