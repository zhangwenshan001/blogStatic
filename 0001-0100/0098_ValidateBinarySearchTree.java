/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
         if (root == null) {
            return true;
        }

        return isValidBSTHandle(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    private static boolean isValidBSTHandle(TreeNode root, Long min, Long max) {
        if (root.val <=min | root.val >= max) {
            return false;
        }
        if (root.left != null) {
            boolean left = isValidBSTHandle(root.left, min, Long.min(root.val, max));
            if  (left == false) {
                return false;
            }
        }
        if (root.right != null) {
            boolean right = isValidBSTHandle(root.right, Long.max(min, root.val),  max);
            if  (right == false) {
                return false;
            }
        }

        return true;
    }
}
