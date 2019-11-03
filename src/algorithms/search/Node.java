package algorithms.search;

public class Node {
    int[][] grid;
    int blankX, blankY;

    public Node(int[][] puzzle) {
        this.grid = puzzle;
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