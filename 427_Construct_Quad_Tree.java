/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }

    private Node buildTree(int[][] grid, int r, int c, int size) {
        if (isUniform(grid, r, c, size)) {
            return new Node(grid[r][c] == 1, true);
        }

        int half = size / 2;

        Node topLeft = buildTree(grid, r, c, half);
        Node topRight = buildTree(grid, r, c + half, half);
        Node bottomLeft = buildTree(grid, r + half, c, half);
        Node bottomRight = buildTree(grid, r + half, c + half, half);

        // If not uniform, create an internal node (isLeaf = false, val can be arbitrary)
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isUniform(int[][] grid, int r, int c, int size) {
        int val = grid[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}