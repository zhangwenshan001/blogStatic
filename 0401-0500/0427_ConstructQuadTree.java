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
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructRange(grid, 0, n-1, 0, n-1);
    }

    public Node constructRange(int[][] grid, int iStart, int iEnd, int jStart, int jEnd)
    {
        if (iStart == iEnd && jStart == jEnd) {
            return new Node(grid[iStart][jStart] == 1, true, null, null, null, null);
        }
        Node topLeft = constructRange(grid, iStart, (iStart+iEnd)/2 ,jStart, (jStart+jEnd)/2);
        Node topRight = constructRange(grid, iStart,(iStart+iEnd)/2, (jStart+jEnd)/2+1,  jEnd);
        Node bottomLeft = constructRange(grid, (iStart+iEnd)/2+1, iEnd, jStart, (jStart+jEnd)/2);
        Node bottomRight = constructRange(grid, (iStart+iEnd)/2+1, iEnd, (jStart+jEnd)/2+1, jEnd);

        if (
            topLeft.isLeaf && 
            topRight.isLeaf && 
            bottomLeft.isLeaf && 
            bottomRight.isLeaf && 
            topLeft.val == topRight.val && 
            topRight.val == bottomLeft.val && 
            bottomLeft.val == bottomRight.val
            ) {
            return new Node(topLeft.val, true, null, null, null, null);
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}