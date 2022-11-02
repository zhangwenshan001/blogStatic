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
    int lastDepth = -1;
    boolean hasPreNull = false;
    public boolean isCompleteTree(TreeNode root) {
        return dfs(root, -1);
    }

    private boolean dfs(TreeNode node, int preDeep) {
        // case 1 current is leaf
        if (node.left == null && node.right == null) {
            if (lastDepth < 0) {
                lastDepth = preDeep + 1;
                return true;
            } else {
                if (preDeep + 1 == lastDepth - 1) {
                    if (!hasPreNull) hasPreNull = true;
                    return true;
                } else if (preDeep + 1 == lastDepth) {
                    return !hasPreNull;
                } else {
                    return false;
                }
            }
        }
        // case 1 current is not leaf
        if (node.left == null && node.right != null) return false;
        boolean leftRes = dfs(node.left, preDeep+1);
        if (!leftRes) return false;
        if (node.right == null) {
            if (hasPreNull) return lastDepth-1 == preDeep + 1;
            else {
                hasPreNull = true;
                return preDeep+1 == lastDepth-1;
            }
        }
        return dfs(node.right, preDeep+1);
    }
}