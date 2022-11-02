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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0)
        {
            int curSize = q.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0;i<curSize;i++) {
                TreeNode cur = q.poll();
                maxValue = Math.max(maxValue, cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            ans.add(maxValue);
            curSize = q.size();
        }
        return ans;
    }
}