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
                break;
            case Up:
                moved = new Node(puzzle, node.blankX, node.blankY);
                moved.grid[moved.blankX][moved.blankY] = moved.grid[moved.blankX - 1][moved.blankY];
                moved.grid[moved.blankX - 1][moved.blankY] = 0;
                moved.parent = node;
                moved.blankX--;
                break;
            case Right:
                moved = new Node(puzzle, node.blankX, node.blankY);
                moved.grid[moved.blankX][moved.blankY] = moved.grid[moved.blankX][moved.blankY + 1];
                moved.grid[moved.blankX][moved.blankY + 1] = 0;
                moved.parent = node;
                moved.blankY++;
                break;
            case Left:
                moved = new Node(puzzle, node.blankX, node.blankY);
                moved.grid[moved.blankX][moved.blankY] = moved.grid[moved.blankX][moved.blankY - 1];
                moved.grid[moved.blankX][moved.blankY - 1] = 0;
                moved.parent = node;
                moved.blankY--;
                break;
        }

        return moved;
    }


    public static ArrayList<Node> NextStates(Node node) {
        ArrayList<Node> available = new ArrayList<>();
        Node n1, n2, n3, n4;
        if (isValid(node, Direction.Down)) {
            n1 = move(node, Direction.Down);
            /*n1 = new Node(node.grid, node.blankX, node.blankY);
            System.out.println(n1.blankX + " " + n1.blankY);
            n1.parent = node;
            n1.move = Direction.Down;
            n1.grid[n1.blankX][n1.blankY] = n1.grid[n1.blankX][n1.blankY + 1];
            n1.blankY = n1.blankY + 1;
            n1.grid[n1.blankX][n1.blankY] = 0;*/
            available.add(n1);
            n1.toString();
            System.out.println("Down");
        }
        if (isValid(node, Direction.Up)) {
            n2 = move(node, Direction.Up);
            /*n2 = new Node(node.grid, node.blankX, node.blankY);
            System.out.println(n2.blankX + " " + n2.blankY);
            n2.parent = node;
            n2.move = Direction.Down;
            n2.grid[n2.blankX][n2.blankY] = n2.grid[n2.blankX][n2.blankY - 1];
            n2.blankY = n2.blankY - 1;
            n2.grid[n2.blankX][n2.blankY] = 0;*/
            available.add(n2);
            n2.toString();
            System.out.println("Up");

            // Does what Left Must Do
        }
        if (isValid(node, Direction.Right)) {
            n3 = move(node, Direction.Right);
            /*n3 = new Node(node.grid, node.blankX, node.blankY);
            System.out.println(n3.blankX + " " + n3.blankY);
            n3.parent = node;
            n3.move = Direction.Down;
            n3.grid[n3.blankX][n3.blankY] = n3.grid[n3.blankX + 1][n3.blankY];
            n3.blankX = n3.blankX + 1;
            n3.grid[n3.blankX][n3.blankY] = 0;*/
            available.add(n3);
            n3.toString();
            System.out.println("Right");
        }
        if (isValid(node, Direction.Left)) {
            n4 = move(node, Direction.Left);
            /*n4 = new Node(node.grid, node.blankX, node.blankY);
            System.out.println(n4.blankX + " " + n4.blankY);
            n4.parent = node;
            n4.move = Direction.Down;
            n4.grid[n4.blankX][n4.blankY] = n4.grid[n4.blankX - 1][n4.blankY];
            n4.blankX = n4.blankX - 1;
            n4.grid[n4.blankX][n4.blankY] = 0;*/
            available.add(n4);
            n4.toString();
            System.out.println("Left");
        }
        /*for (Node nd: available){
            nd.toString();
        }*/
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
