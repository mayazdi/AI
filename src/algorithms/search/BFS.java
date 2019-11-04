package algorithms.search;

import algorithms.Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class BFS implements Algorithm {
    boolean first = true;

    private ArrayList<Direction> path;

    private ArrayList<Direction> makePath(){
        return null;
    }

    @Override
    public String makeMove(String[][] grid) {

        //Turn Initial State to my structure
        //Call BFS on initial state
        //

        if (first){
            path = new ArrayList<>();

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

            Node initialNode = new Node(initialGrid);
            ArrayList<Node> Visited = new ArrayList<>();

            //if (initialNode.equals(Util.Goal))
                //Ends
            Queue<Node> queue = new LinkedList<>();

            ArrayList<Node> nextStates = Util.NextStates(initialNode);
            for (Node state : nextStates) {
                if (!Visited.contains(state))
                    Visited.add(state);
                queue.add(state);

            }
            first = false;


        }


        //Release path step by step


        return null;
    }
}
