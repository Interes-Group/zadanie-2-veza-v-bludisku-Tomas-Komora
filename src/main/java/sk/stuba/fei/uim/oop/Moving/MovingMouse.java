package sk.stuba.fei.uim.oop.Moving;

import sk.stuba.fei.uim.oop.MazeGame.Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MovingMouse extends Canvas implements MouseListener, MouseMotionListener {
    private Game game;
    private int numberOfClick=0;
    private final int wall=0;
    private final int path=1;
    private final int exit=2;
    private final int player=3;
    private final int validMove=4;
    public MovingMouse(Game game){
        this.game =game;
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int playerPositionX= game.getPlayerPositionX();
        int playerPositionY= game.getPlayerPositionY();
        if(playerPositionX*30<=e.getY() && (playerPositionX+1)*30>=e.getY() &&
                playerPositionY*30<=e.getX() && (playerPositionY+1)*30>=e.getX()) {
            numberOfClick++;
            isValidMove();
        }
        if(game.getMaze()[e.getY()/30][e.getX()/30]==4){
            game.getMaze()[playerPositionX][playerPositionY]=path;
            game.getMaze()[e.getY()/30][e.getX()/30]=player;
            numberOfClick++;
        }
        if(game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] == player){
            game.generateMaze();
            game.setGameWins(game.getGameWins()+1);
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
        posX = e.getX() / 30;
        posY = e.getY() / 30;
        boolean isExit= false;
        if (numberOfClick % 2 == 1 && posX > 0 && posY > 0 && posY < 12 && posX < 12 ) {
            ArrayList<Integer[]> position= isValidMove();
            if (game.getMaze()[posY][posX] == path || game.getMaze()[posY][posX] == exit) {
                for(Integer[] integers : position)
                    if(integers[0]==posY && integers[1]==posX) {
                        if(game.getMaze()[posY][posX] ==exit){
                            isExit=true;
                        }
                        game.getMaze()[posY][posX] = validMove;
                    }
            }
            if(posX > 0 && posY > 0 && posY < 12 && posX < 12 ) {
                if (game.getMaze()[posY][posX - 1] == validMove) {
                    game.getMaze()[posY][posX - 1] = path;
                } else if (game.getMaze()[posY][posX + 1] == validMove) {
                    game.getMaze()[posY][posX + 1] = path;
                } else if (game.getMaze()[posY - 1][posX] == validMove) {
                    game.getMaze()[posY - 1][posX] = path;
                } else if (game.getMaze()[posY + 1][posX] == validMove) {
                    game.getMaze()[posY + 1][posX] = path;
                }
            }
            if(game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()]!=validMove)
                game.getMaze()[game.getMazeGenerator().getExitY()][game.getMazeGenerator().getExitX()] = exit;

        }
    }



    private ArrayList<Integer[]> isValidMove(){
        int playerPositionX = game.getPlayerPositionX();
        int playerPositionY = game.getPlayerPositionY();
        ArrayList<Integer[]> validMove = new ArrayList<>();
        while(true){
            if(game.getMaze()[playerPositionX][playerPositionY]==wall)
                break;
            if(playerPositionX==12){
                validMove.add(new Integer[]{playerPositionX,playerPositionY});
                break;
            }
            validMove.add(new Integer[]{playerPositionX,playerPositionY});
            playerPositionX++;

        }
        playerPositionX= game.getPlayerPositionX();
        if(playerPositionX!=wall) {
            while (true) {
                if (game.getMaze()[playerPositionX][playerPositionY] == wall)
                    break;
                if(playerPositionX==wall){
                    validMove.add(new Integer[]{playerPositionX,playerPositionY});
                    break;
                }
                validMove.add(new Integer[]{playerPositionX,playerPositionY});
                playerPositionX--;
            }
        }
        playerPositionX= game.getPlayerPositionX();
        playerPositionY= game.getPlayerPositionY();
        do {
            validMove.add(new Integer[]{playerPositionX, playerPositionY});
            playerPositionY++;
        } while (game.getMaze()[playerPositionX][playerPositionY] != wall);
        playerPositionY= game.getPlayerPositionY();
        if(playerPositionY!=wall){
            do {
                validMove.add(new Integer[]{playerPositionX, playerPositionY});
                playerPositionY--;
            } while (game.getMaze()[playerPositionX][playerPositionY] != wall);
        }
        for(int i =0; i<validMove.size();i++){
            if(validMove.get(i)[0]== game.getPlayerPositionX() && validMove.get(i)[1]== game.getPlayerPositionY())
                validMove.remove(validMove.get(i));
        }
        return validMove;

    }

}
