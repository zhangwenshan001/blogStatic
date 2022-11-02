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
    public int maxLevelSum(TreeNode root) {
        int ans = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(q.size()>0) {
            int size = q.size();
            level++;
            int curSum = 0;
            for (int i = 0;i<size;i++) {
                TreeNode cur = q.poll();
                curSum += cur.val;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            if (curSum > maxSum) {
                ans = level;
                maxSum = curSum;
            }
        }
        return ans;
    }
}
