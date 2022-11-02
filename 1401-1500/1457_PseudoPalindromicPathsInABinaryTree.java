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
    int count;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return count;
        }
        boolean[] tmp = new boolean[9];
        dfs(root, tmp, 0);
        
        return count;
    }
    
    public void dfs(TreeNode node, boolean[] tmp, int num) {    
        if (node == null) {
            return;
        }

        boolean cur = tmp[node.val-1];
        if (!cur) {
            tmp[node.val-1] = true;
            num++;
        } else {
            tmp[node.val-1] = false;
            num--;
        }
        
        if (node.left == null && node.right == null) {
            if (num<=1) {
                count++;
            }
        }
        
        dfs(node.left, tmp, num);
        dfs(node.right, tmp, num);
        if (!cur) {
            tmp[node.val-1] = false;
            num--;
        }else {
            tmp[node.val-1] = true;
            num++;
        }
    }
    
}