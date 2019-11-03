package algorithms.search;

enum Direction {
    Right, Left, Up, Down
}

class Node {
    int[][] State;
    int blankX;
    int blankY;

    public Node(int Size) {
        State = new int[Size][Size];
    }
}

public class Util {
    public void NextStates(Node node) {
        Node no

    }

    private boolean isValid(Node node, Direction direction){
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
