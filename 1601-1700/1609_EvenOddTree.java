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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isEvenIndexed = true;

        while(q.size() > 0) {
            int size = q.size();
            int pre = isEvenIndexed ? 0 : Integer.MAX_VALUE;
            for (int i = 0;i < size;i++) {
                TreeNode cur = q.poll();
                if (isEvenIndexed && (cur.val % 2 == 0 || cur.val <= pre) || !isEvenIndexed && (cur.val % 2 == 1 || cur.val >= pre)) return false;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                pre = cur.val;
            }
            isEvenIndexed = !isEvenIndexed;
        }
        return true;
    }
}