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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curCount = 1;
        while(curCount > 0) {
            int nextCount = 0;
            List<Integer> curRes = new ArrayList<>();
            for(int i =0;i<curCount;i++) {
                TreeNode p = queue.poll();
                curRes.add(p.val);
                if (p.left != null) {
                    nextCount++;
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    nextCount++;
                    queue.offer(p.right);
                }
            }
            res.add(curRes);
            curCount = nextCount;
        }
        
        return res;
    }
}
