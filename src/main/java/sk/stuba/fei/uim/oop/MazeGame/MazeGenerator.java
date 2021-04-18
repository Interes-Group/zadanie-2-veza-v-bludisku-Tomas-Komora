package sk.stuba.fei.uim.oop.MazeGame;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;

public class MazeGenerator {
    private final int wall=0;
    private final int path=1;
    private final int exit=2;
    private final int player=3;
    private Stack<Node> stack = new Stack<>();
    private Random rand = new Random();
    private int[][] mazeIntro;
    private int dimension=11;
    
    private int[][] maze;
    public MazeGenerator() {
        mazeIntro = new int[11][11];
        generateMaze();
        getMaze();

    }
    private int exitY;
    private int exitX;
    
    public void generateMazeKernel() {
        stack.push(new Node(0,0));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                mazeIntro[next.y][next.x] = path;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
                exitX= next.x;
                exitY= next.y;
            }
        }
        mazeIntro[exitY][exitX]=exit;
    }

    public int getExitY() {
        return exitY+1;
    }

    public int getExitX() {
        return exitX+1;
    }

    private void generateMaze(){
        generateMazeKernel();
        maze=new int[13][13];
        for(int i=0;i<11;i++){
            maze[0][i]=wall;
            maze[11][i]=wall;
        }

        for(int x=1;x<11+1;x++) {
            System.arraycopy(mazeIntro[x - 1], 0, maze[x], 1, 11 + 1 - 1);
        }
        maze[1][1]=player;
       // maze[11][11]=exit;

    }

    public int[][] getMaze() {
        return maze;
    }



    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && mazeIntro[y][x] == path) {
                    numNeighboringOnes++;
                }
            }
        }
        return (numNeighboringOnes < 3) && mazeIntro[node.y][node.x] != path;
    }

    private void randomlyAddNodesToStack(ArrayList<Node> nodes) {
        int targetIndex;
        while (!nodes.isEmpty()) {
            targetIndex = rand.nextInt(nodes.size());
            stack.push(nodes.remove(targetIndex));
        }
    }

    private ArrayList<Node> findNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotCorner(node, x, y)
                        && pointNotNode(node, x, y)) {
                    neighbors.add(new Node(x, y));
                }
            }
        }
        return neighbors;
    }


    private Boolean pointOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < dimension && y < dimension;
    }

    private Boolean pointNotCorner(Node node, int x, int y) {
        return (x == node.x || y == node.y);
    }

    private Boolean pointNotNode(Node node, int x, int y) {
        return !(x == node.x && y == node.y);
    }
}
