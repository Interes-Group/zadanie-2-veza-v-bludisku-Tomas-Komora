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
        int positionY =game.getPlayerPositionY();
        int positionX = game.getPlayerPositionX();

        if (positionY - 1 >= wall) {
            if (game.getMaze()[positionY - 1][positionX] == path || game.getMaze()[positionY - 1][positionX] == exit) {
                game.getMaze()[positionY][positionX] = path;
                game.getMaze()[positionY - 1][positionX] = player;

            }
        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }
    }
    private void moveDown(){
        int positionY = game.getPlayerPositionY();
        int positionX = game.getPlayerPositionX();
        if (game.getPlayerPositionY()  + 1 < 13) {
            if (game.getMaze()[positionY + 1][positionX] == path || game.getMaze()[positionY + 1][positionX] == exit) {
                game.getMaze()[positionY][positionX] = path;
                game.getMaze()[positionY + 1][positionX] = player;
            }

        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }
    }
    private void moveLeft(){
        int positionY = game.getPlayerPositionY();
        int positionX = game.getPlayerPositionX();


            if((game.getMaze()[positionY][positionX -1]==path || game.getMaze()[positionY][positionX -1] == exit)&& positionX -1>=0){
                game.getMaze()[positionY][positionX]=path;
                game.getMaze()[positionY][positionX -1]=player;
            }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }


    }
    private void moveRight(){
        int positionY = game.getPlayerPositionY();
        int positionX = game.getPlayerPositionX();

        if(game.getMaze()[positionY][positionX +1]==path || game.getMaze()[positionY][positionX +1] == exit){
            game.getMaze()[positionY][positionX]=path;
            game.getMaze()[positionY][positionX +1]=player;
        }
        if (game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player) {
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
        }

    }


}
