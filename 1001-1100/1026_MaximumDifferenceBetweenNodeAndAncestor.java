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
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{100001, -1};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);
        if (min != 100001) ans = Math.max(ans, Math.abs(node.val - min));
        if (max != -1) ans = Math.max(ans, Math.abs(node.val - max));
        return new int[]{Math.min(min, node.val), Math.max(max, node.val)};
    }
}