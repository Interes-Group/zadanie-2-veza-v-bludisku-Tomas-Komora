package sk.stuba.fei.uim.oop.MazeGame;

public class Player {

    public int getPlayerWidth(int [][] mazeGrid){
        int width=0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeGrid[x][y]==3)
                    return x;
            }
        }
        return width;
    }
    public int getPlayerHeight(int [][] mazeGrid){
        int height=0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeGrid[x][y]==3)
                    return y;
            }

        }
        return height;
    }
}
