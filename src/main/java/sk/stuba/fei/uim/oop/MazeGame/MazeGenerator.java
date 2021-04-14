package sk.stuba.fei.uim.oop.MazeGame;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;

//number in maze 2d array
//0-wall
//1-path
//3-player
//4-moving with mouse place where i can go
public class MazeGenerator {
    private Game game;
    private Stack<Node> stack = new Stack<>();
    private Random rand = new Random();
    private int[][] mazeIntro;
    private int dimension;
    private int dim =11;
    private int[][] maze;
    public MazeGenerator() {
        mazeIntro = new int[dim][dim];
        dimension = dim;
        generateMaze();
        getMaze();

    }

    
    public void generateMazeKernel() {
        stack.push(new Node(0,0));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                mazeIntro[next.y][next.x] = 1;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
            }
        }

    }

    private void generateMaze(){
        generateMazeKernel();
        maze=new int[dim+2][dim+2];
        for(int i=0;i<dim;i++){
            maze[0][i]=0;
            maze[dim][i]=0;
        }
        maze[0][1]=3;
        maze[12][11]=1;
        for(int x=1;x<dim+1;x++) {
            System.arraycopy(mazeIntro[x - 1], 0, maze[x], 1, dim + 1 - 1);
        }
        if(maze[11][11]==0) {
            maze[11][11]=1;
        }

    }

    public int[][] getMaze() {
        return maze;
    }



    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && mazeIntro[y][x] == 1) {
                    numNeighboringOnes++;
                }
            }
        }
        return (numNeighboringOnes < 3) && mazeIntro[node.y][node.x] != 1;
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
