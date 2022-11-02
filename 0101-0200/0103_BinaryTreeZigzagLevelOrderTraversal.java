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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        int curCount = 1;
        while(curCount > 0) {
            List<Integer> curRes = new ArrayList<>();
            for (int i = 0;i<curCount;i++) {
                TreeNode curNode = queue.poll();
                curRes.add(curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            if (leftToRight) {
                res.add(curRes);
            } else {
                Collections.reverse(curRes);
                res.add(curRes);
            }
            curCount = queue.size();
            leftToRight = !leftToRight;
        }

        return res;
    }
}