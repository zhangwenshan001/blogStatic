/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] cur = new int[]{left[1]+1, right[0]+1};
        ans = Math.max(Math.max(ans, cur[0]-1), cur[1]-1);
        return cur;
    }
}