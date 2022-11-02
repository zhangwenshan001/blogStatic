/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] max = robNewSub(root);
		return Math.max(max[0], max[1]);
    }
    
    public static int[] robNewSub(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int[] left = robNewSub(root.left);
		int[] right = robNewSub(root.right);

		int[] result = new int[2];

		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = root.val + left[0] + right[0];

		return result;
	}
}