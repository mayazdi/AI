package algorithms.search;

import algorithms.Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BFS implements Algorithm {
    private boolean first = true;
    private Node initialNode;
    private static ArrayList<Direction> path;

    private ArrayList<Direction> generatePath() {

        ArrayList<Node> Visited = new ArrayList<>();

        if (initialNode.equals(Util.Goal))
            return null;
        Queue<Node> queue = new LinkedList<>();

        ArrayList<Node> nextStates = Util.NextStates(initialNode);
        queue.poll();
        for (Node state : nextStates) {
            if (!Visited.contains(state))
                Visited.add(state);
            if (!state.equals(Util.Goal))
                queue.add(state);
            else break;

        }

        Node head = queue.poll();
        while (head.equals(initialNode)) {
            path.add(head.move);
            head = head.parent;
        }

        return path;

        //start from head of queue,
        //while current node is not the initial grid
        // do -> node = node.parent
        //add current move to path
    }

    @Override
    public String makeMove(String[][] grid) {
        if (first) {
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
            initialNode = new Node(initialGrid);
            path = generatePath();

            first = false;
        }

        if (!path.isEmpty()) {
            switch (path.get(0)) {
                case Up:
                    return "Up";
                case Down:
                    return "Down";
                case Left:
                    return "Left";
                case Right:
                    return "Right";
            }
            path.remove(0);
        }

        return null;
    }
}
