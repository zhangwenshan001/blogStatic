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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<TreeNode>();
        List<TreeNode>[] dp = new List[(n+1)/2];
        TreeNode firstNode = new TreeNode(0);
        List<TreeNode> firstRes = new ArrayList<>();
        firstRes.add(firstNode);
        dp[0] = firstRes;
        if (n == 1) return dp[0];
        int i = 1;
        while(2*i+1<=n) {
            List<TreeNode> cur = new ArrayList<>();
            for (int left = 0;left<i;left++) {
                int right = i-1-left;
                for(TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode curNode = new TreeNode(0);
                        curNode.left = leftTree;
                        curNode.right = rightTree;
                        cur.add(curNode);
                    }
                }
            }
            dp[i] = cur;
            i++;
        }
        return dp[(n-1)/2];

    }
}