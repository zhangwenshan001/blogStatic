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
    public List<TreeNode> generateTrees(int n) {
        return generateTreesFromTo(1, n);
    }

    private List<TreeNode> generateTreesFromTo(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) return ans;

        for (int i = start;i<=end;i++) {
            List<TreeNode> left = generateTreesFromTo(start, i-1);
            List<TreeNode> right = generateTreesFromTo(i+1, end);
            if (left.isEmpty() && right.isEmpty()) ans.add(new TreeNode(i));
            else if (left.isEmpty()) {
                for (TreeNode rn : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.right = rn;
                    ans.add(cur);
                }
            } else if (right.isEmpty()) {
                for (TreeNode ln : left) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = ln;
                    ans.add(cur);
                }
            } else {
                for (TreeNode ln : left) {
                    for (TreeNode rn : right) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = ln;
                        cur.right = rn;
                        ans.add(cur);
                    }
                }
            }
        }

        return ans;
    }
}