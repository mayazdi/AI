package algorithms.search;

import algorithms.Algorithm;

import java.util.ArrayList;

public class BFS implements Algorithm {
    @Override
    public String makeMove(String[][] grid) {
        //Turn Initial State to my structure
        //Call BFS on initial state
        //

        int emptyX, emptyY;
        int initialGrid[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals(' ')) {
                    emptyX = i;
                    emptyY = j;
                    initialGrid[i][j] = 0;
                    continue;
                }
                initialGrid[i][j] = Integer.parseInt(grid[i][j]);
            }
        }

        Node node = new Node(initialGrid);
        ArrayList <Node> Visited = new ArrayList<>();


        return null;
    }
}
