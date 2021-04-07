package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.MazeGame.Game;
import sk.stuba.fei.uim.oop.MazeGame.MazeGenerator;

public class Assignment2 {
    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(11);
        mazeGenerator.generateMaze();
        int[][]maze =mazeGenerator.okraj(11);
        Game game=new Game();
        game.drawGUI(maze);

    }
}
