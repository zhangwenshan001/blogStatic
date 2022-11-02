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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ln = q.val > p.val ? q : p;
        TreeNode sn = q.val < p.val ? q : p;
        if (root.val >= sn.val && root.val <= ln.val) {
            return root;
        }
        
        if (root.val > ln.val) {
            return lowestCommonAncestor(root.left, sn, ln);
        }
        
        return lowestCommonAncestor(root.right, sn, ln);
    }
}
