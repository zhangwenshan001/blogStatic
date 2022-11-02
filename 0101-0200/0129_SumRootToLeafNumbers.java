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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        sumNumbers(root.left, root.val);
        sumNumbers(root.right, root.val);
        
        return sum;
    }
    
    public void sumNumbers(TreeNode root, int preNum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += preNum * 10 + root.val;
            return;
        }
        int newPre = preNum * 10 + root.val;
        sumNumbers(root.left, newPre);
        sumNumbers(root.right, newPre);
    }
}