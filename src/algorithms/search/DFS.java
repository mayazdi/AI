package algorithms.search;

import algorithms.Algorithm;

import java.util.*;

@SuppressWarnings("ALL")
public class DFS implements Algorithm {
    private boolean first = true;
    private Node initialNode;
    private static Stack<Direction> path;

    private Stack<Direction> generatePath() {
        HashSet<Node> Visited = new HashSet<>();
        if (initialNode.equals(Util.Goal))
            return null;
        Stack<Node> queue = new Stack<>();
        Node head = null;
        ArrayList<Node> nextStates = Util.NextStates(initialNode);
        boolean found = false;
        queue.add(initialNode);
        while (!queue.isEmpty()) {
            for (Node state : nextStates) {
                if (Visited.contains(state) || state.depth>300)
                    continue;
                Visited.add(state);
                queue.add(state);
                if (state.equals(Util.Goal)) {
                    System.out.println("Found!");
                    head = state;
                    found = true;
                    break;
                }
            }
            if (found) break;
            nextStates = Util.NextStates(queue.pop());
        }

        while (!head.equals(initialNode)) {
            path.push(head.move);
            head = head.parent;
        }

        return path;
    }

    @Override
    public String makeMove(String[][] grid) {
        if (first) {
            Util u = new Util();
            path = new Stack<>();

            int emptyX = 0, emptyY = 0;
            int initialGrid[][] = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j].equals(" ")) {
                        emptyX = i;
                        emptyY = j;
                        initialGrid[i][j] = 0;
                        continue;
                    }
                    initialGrid[i][j] = Integer.parseInt(grid[i][j]);
                }
            }
            initialNode = new Node(initialGrid, emptyX, emptyY);
            initialNode.depth = 0;
            initialNode.toString();
            path = generatePath();

            first = false;
        }

        if (!path.isEmpty()) {
            switch (path.pop()) {
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
