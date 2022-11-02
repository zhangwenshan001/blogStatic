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
    TreeNode lowestCommonAncestor;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root, p, q);
        return this.lowestCommonAncestor;
    }
    
    public int findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int leftCount = 0;
        int rightCount = 0;
        if (root.left!=null) {
            leftCount = findLowestCommonAncestor(root.left, p, q);
        } 
        
        if (root.right != null) {
            rightCount = findLowestCommonAncestor(root.right, p, q);
        }
        
        if (leftCount == 2 || rightCount == 2) {
            return 2;
        }
        
        if (leftCount == 1 && rightCount == 1) {
            lowestCommonAncestor = root;
            return 2;
        }
        if (root == p || root== q) {
            if (leftCount == 1 || rightCount == 1) {
                lowestCommonAncestor = root;
                return 2;
            }
            return 1;
        }
        
        return leftCount+rightCount;
    }
}