class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] mark = new boolean[n];
        for (int i = 0;i<n;i++) {
            if (leftChild[i] >= 0) {
                if (mark[leftChild[i]]) return false;
                mark[leftChild[i]] = true;
            } 
            if (rightChild[i] >= 0) {
                if (mark[rightChild[i]]) return false;
                mark[rightChild[i]] = true;
            }
        }
        int root = -1;
        for (int i = 0;i<n;i++) {
            if (!mark[i]) {
                if (root >= 0) return false;
                root = i;
            }
        }
        if (root < 0) return false;
        mark = new boolean[n];
        dfs(leftChild, rightChild, root, mark);
        for (boolean m : mark) {
            if (!m) return false;
        }
        return true;
    }

    private void dfs(int[] leftChild, int[] rightChild, int node, boolean[] mark) {
        if (mark[node]) return;
        mark[node] = true;
        if (leftChild[node] >= 0) dfs(leftChild, rightChild, leftChild[node], mark);
        if (rightChild[node] >= 0) dfs(leftChild, rightChild, rightChild[node], mark);
    }
}