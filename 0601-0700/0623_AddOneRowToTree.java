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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode node, int val, int depth, int cur) {
        if (node == null) return;
        if (depth == cur+1) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = node.left;
            node.left = left;
            right.right = node.right;
            node.right = right;
            return;
        }
        dfs(node.left, val, depth, cur+1);
        dfs(node.right, val, depth, cur+1);
    }
}