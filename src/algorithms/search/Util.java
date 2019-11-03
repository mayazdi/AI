package algorithms.search;

import java.util.ArrayList;

enum Direction {
    Right, Left, Up, Down
}


public class Util {
    //goal State
    int Goal [][];

    public Util(){
        Goal = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    }

    public ArrayList<Node> NextStates(Node node) {
        ArrayList<Node> available = new ArrayList<>();
        Node n1, n2, n3, n4;
        if (isValid(node, Direction.Down)) {
            n1 = node;
            n1.grid[n1.blankX][n1.blankY] = n1.grid[n1.blankX][n1.blankY + 1];
            n1.blankY = n1.blankY + 1;
            n1.grid[n1.blankX][n1.blankY] = 0;
            available.add(n1);
        }
        if (isValid(node, Direction.Up)) {
            n2 = node;
            n2.grid[n2.blankX][n2.blankY] = n2.grid[n2.blankX][n2.blankY - 1];
            n2.blankY = n2.blankY - 1;
            n2.grid[n2.blankX][n2.blankY] = 0;
            available.add(n2);
        }
        if (isValid(node, Direction.Right)) {
            n3 = node;
            n3.grid[n3.blankX][n3.blankY] = n3.grid[n3.blankX + 1][n3.blankY];
            n3.blankX = n3.blankX + 1;
            n3.grid[n3.blankX][n3.blankY] = 0;
            available.add(n3);
        }
        if (isValid(node, Direction.Left)) {
            n4 = node;
            n4.grid[n4.blankX][n4.blankY] = n4.grid[n4.blankX - 1][n4.blankY];
            n4.blankX = n4.blankX - 1;
            n4.grid[n4.blankX][n4.blankY] = 0;
            available.add(n4);
        }
        return available;
    }

    private boolean isValid(Node node, Direction direction) {
        boolean Valid = true;
        if (node.blankX == 0 && direction == Direction.Left)
            Valid = false;
        if (node.blankX == 2 && direction == Direction.Right)
            Valid = false;
        if (node.blankY == 0 && direction == Direction.Up)
            Valid = false;
        if (node.blankY == 2 && direction == Direction.Down)
            Valid = false;
        return Valid;
    }
}
