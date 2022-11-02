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
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        return dfs(root, 0, 1, start, end);
    }
    
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if (root == null) {
            return 0;
        }
        
        // if it's the first TreeNode of current level, initial the start[level] and end[level]
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else { // if it's not the first TreeNode of current level, then just update the end 
            end.set(level, order);
        }
        
        int cur = end.get(level) - start.get(level) + 1; // current level
        int left = dfs(root.left, level+1, order*2, start, end);
        int right = dfs(root.right, level+1, order*2 + 1, start, end);
        
        return Math.max(cur, Math.max(left, right));
    }
}
