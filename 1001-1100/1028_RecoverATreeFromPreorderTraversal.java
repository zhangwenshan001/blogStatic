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
    public TreeNode recoverFromPreorder(String traversal) {
        List<TreeNode> stack = new ArrayList<>();
        int rootVal = 0;
        int i = 0;
        while(i < traversal.length() && traversal.charAt(i) >= '0' && traversal.charAt(i) <= '9') {
            rootVal = rootVal * 10 + traversal.charAt(i) - '0';
            i++;
        }
        TreeNode root = new TreeNode(rootVal);
        stack.add(root);

        while (i < traversal.length()) {
            int depth = 0;
            int cur = 0;
            while(i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            while(i < traversal.length() && traversal.charAt(i) >= '0' && traversal.charAt(i) <= '9') {
                cur = cur * 10 + traversal.charAt(i) - '0';
                i++;
            }
            TreeNode curNode = new TreeNode(cur);
            while(depth < stack.size()) {
                stack.remove(stack.size()-1);
            }
            if (depth == stack.size()) {
                if (stack.get(stack.size()-1).left == null) stack.get(stack.size()-1).left = curNode;
                else stack.get(stack.size()-1).right = curNode;
                stack.add(curNode);
            }
        }
        return root;
    }

}