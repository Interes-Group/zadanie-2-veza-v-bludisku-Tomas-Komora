package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.MazeGame.Game;
import java.awt.*;

public class CanvasText extends Canvas {
    private Game game;

    public CanvasText(Game game){
        canvas(game);
    }
    public void canvas(Game game){
        this.game = game;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Counter :" +game.getGameWins(),0,100);
        repaint();
    }

}
