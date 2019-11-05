package algorithms.search;

public class Node {
    int[][] grid;
    int blankX, blankY;

    Node parent;
    Direction move;


    public Node(int[][] puzzle, int emptyX, int emptyY) {
        this.grid = puzzle;
        this.blankX = emptyX;
        this.blankY = emptyY;
    }

    @Override
    public String toString() {
        for (int i = 0; i < 3; i++)
            System.out.println(this.grid[i][0] + " " + this.grid[i][1] + " " + this.grid[i][2]);
        System.out.println();
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        Node that = (Node) obj;
        if (this.blankX != that.blankX || this.blankY != that.blankY)
            return false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (this.grid[i][j] != that.grid[i][j])
                    return false;
        return true;

    }
}