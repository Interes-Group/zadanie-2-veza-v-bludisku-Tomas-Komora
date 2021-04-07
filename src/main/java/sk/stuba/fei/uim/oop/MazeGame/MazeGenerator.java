package sk.stuba.fei.uim.oop.MazeGame;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import java.util.Arrays;

public class MazeGenerator {

    private Stack<Node> stack = new Stack<>();
    private Random rand = new Random();
    private int[][] maze;
    private int dimension;

    public MazeGenerator(int dim) {
        maze = new int[dim][dim];
        dimension = dim;
    }

    public void generateMaze() {
        stack.push(new Node(0,0));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                maze[next.y][next.x] = 1;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
            }
        }
    }

    public String getRawMaze() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }

    public void print(int dim){
        for(int x=0;x<dim;x++){
            for(int y=0;y<dim;y++){
                if(maze[x][y]==1){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println("\n");
        }
    }

    public void okraj(int dim){
        int[][] newMaze= new int[dim+2][dim+2];
        for(int i=0;i<dim;i++){
            newMaze[0][i]=0;
            newMaze[dim][i]=0;
        }
        for(int x=1;x<dim+1;x++) {
            for (int y = 1; y < dim+1; y++) {
                newMaze[x][y]=maze[x-1][y-1];
            }
        }
        for(int x=0;x<dim+2;x++){
            for(int y=0;y<dim+2;y++){
                if(newMaze[x][y]==1){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }


    }
    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && maze[y][x] == 1) {
                    numNeighboringOnes++;
                }
            }
        }
        return (numNeighboringOnes < 3) && maze[node.y][node.x] != 1;
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