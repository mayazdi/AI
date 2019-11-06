package algorithms.search;

import java.util.ArrayList;

public class Util {
    static Node Goal;
    int Final[][];

    public Util() {
        Final = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Goal = new Node(Final, 2, 2);
    }

    //Returns Next Possible States
    private static Node move(Node node, Direction direction) {
        Node moved = null;
        int[][] puzzle = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                puzzle[i][j] = node.grid[i][j];
            }
        }
        switch (direction) {
            case Down:
                moved = new Node(puzzle, node.blankX, node.blankY);
                moved.grid[moved.blankX][moved.blankY] = moved.grid[moved.blankX + 1][moved.blankY];
                moved.grid[moved.blankX + 1][moved.blankY] = 0;
                moved.parent = node;
                moved.blankX++;
                moved.move = Direction.Down;
                break;
            case Up:
                moved = new Node(puzzle, node.blankX, node.blankY);
                moved.grid[moved.blankX][moved.blankY] = moved.grid[moved.blankX - 1][moved.blankY];
                moved.grid[moved.blankX - 1][moved.blankY] = 0;
                moved.parent = node;
                moved.blankX--;
                moved.move = Direction.Up;
                break;
            case Right:
                moved = new Node(puzzle, node.blankX, node.blankY);
                moved.grid[moved.blankX][moved.blankY] = moved.grid[moved.blankX][moved.blankY + 1];
                moved.grid[moved.blankX][moved.blankY + 1] = 0;
                moved.parent = node;
                moved.blankY++;
                moved.move = Direction.Right;
                break;
            case Left:
                moved = new Node(puzzle, node.blankX, node.blankY);
                moved.grid[moved.blankX][moved.blankY] = moved.grid[moved.blankX][moved.blankY - 1];
                moved.grid[moved.blankX][moved.blankY - 1] = 0;
                moved.parent = node;
                moved.blankY--;
                moved.move = Direction.Left;
                break;
        }

        return moved;
    }

    public static ArrayList<Node> NextStates(Node node) {
        ArrayList<Node> available = new ArrayList<>();
        Node n1, n2, n3, n4;
        int depth = node.depth + 1;
        if (isValid(node, Direction.Down)) {
            n1 = move(node, Direction.Down);
            n1.depth = depth;
            available.add(n1);
        }
        if (isValid(node, Direction.Up)) {
            n2 = move(node, Direction.Up);
            n2.depth = depth;
            available.add(n2);
        }
        if (isValid(node, Direction.Right)) {
            n3 = move(node, Direction.Right);
            n3.depth = depth;
            available.add(n3);
        }
        if (isValid(node, Direction.Left)) {
            n4 = move(node, Direction.Left);
            n4.depth = depth;
            available.add(n4);
        }
        return available;
    }

    private static boolean isValid(Node node, Direction direction) {
        boolean Valid = true;
        if (node.blankY == 0 && direction == Direction.Left)
            Valid = false;
        if (node.blankY == 2 && direction == Direction.Right)
            Valid = false;
        if (node.blankX == 0 && direction == Direction.Up)
            Valid = false;
        if (node.blankX == 2 && direction == Direction.Down)
            Valid = false;
        return Valid;
    }
}
