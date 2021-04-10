package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.MazeGame.Game;

import javax.swing.*;
import java.awt.*;

public class CanvasText extends Canvas {
    private Game game;

    public CanvasText(Game game){
        canvas(game);
    }
    public Canvas canvas(Game game){
        Canvas canvas = new Canvas();
        this.game = game;
        return canvas;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("you win :" +game.getGameWins(),0,100);
        repaint();
    }

}
