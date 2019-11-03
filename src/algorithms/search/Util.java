package algorithms.search;

enum Direction {
    Right, Left, Up, Down
}

class Node {
    int[][] grid;
    int blankX;
    int blankY;

    public Node(int Size) {
        grid = new int[Size][Size];
    }
}

public class Util {
    //goal State

    public void NextStates(Node node) {
        if (isValid(node, Direction.Down)) {
            node.grid[node.blankX][node.blankY] = node.grid[node.blankX][node.blankY + 1];
            node.blankY = node.blankY + 1;
            node.grid[node.blankX][node.blankY] = 0;
        }
        if (isValid(node, Direction.Up)) {
            node.grid[node.blankX][node.blankY] = node.grid[node.blankX][node.blankY - 1];
            node.blankY = node.blankY - 1;
            node.grid[node.blankX][node.blankY] = 0;

        }
        if (isValid(node, Direction.Right)) {
            node.grid[node.blankX][node.blankY] = node.grid[node.blankX + 1][node.blankY];
            node.blankX = node.blankX + 1;
            node.grid[node.blankX][node.blankY] = 0;

        }
        if (isValid(node, Direction.Left)) {
            node.grid[node.blankX][node.blankY] = node.grid[node.blankX - 1][node.blankY];
            node.blankX = node.blankX - 1;
            node.grid[node.blankX][node.blankY] = 0;
        }


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
