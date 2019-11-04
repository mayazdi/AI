package algorithms.search;

import java.util.ArrayList;


public class Util {
    public static Node Goal;
    int Final [][];

    public Util(){
        Final = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Goal = new Node(Final);
    }

    //Returns Next Possible States
    public static ArrayList<Node> NextStates(Node node) {
        ArrayList<Node> available = new ArrayList<>();
        Node n1, n2, n3, n4;
        if (isValid(node, Direction.Down)) {
            n1 = node;
            n1.parent = node;
            n1.move = Direction.Down;
            n1.grid[n1.blankX][n1.blankY] = n1.grid[n1.blankX][n1.blankY + 1];
            n1.blankY = n1.blankY + 1;
            n1.grid[n1.blankX][n1.blankY] = 0;
            available.add(n1);
        }
        if (isValid(node, Direction.Up)) {
            n2 = node;
            n2.parent = node;
            n2.move = Direction.Down;
            n2.grid[n2.blankX][n2.blankY] = n2.grid[n2.blankX][n2.blankY - 1];
            n2.blankY = n2.blankY - 1;
            n2.grid[n2.blankX][n2.blankY] = 0;
            available.add(n2);
        }
        if (isValid(node, Direction.Right)) {
            n3 = node;
            n3.parent = node;
            n3.move = Direction.Down;
            n3.grid[n3.blankX][n3.blankY] = n3.grid[n3.blankX + 1][n3.blankY];
            n3.blankX = n3.blankX + 1;
            n3.grid[n3.blankX][n3.blankY] = 0;
            available.add(n3);
        }
        if (isValid(node, Direction.Left)) {
            n4 = node;
            n4.parent = node;
            n4.move = Direction.Down;
            n4.grid[n4.blankX][n4.blankY] = n4.grid[n4.blankX - 1][n4.blankY];
            n4.blankX = n4.blankX - 1;
            n4.grid[n4.blankX][n4.blankY] = 0;
            available.add(n4);
        }
        return available;
    }

    private static boolean isValid(Node node, Direction direction) {
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
