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
    int count = 0;
    
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>(); 
        preSum.put(0, 1);
        pathSumHandle(root, 0, sum, preSum);
        return count;
    }
    
    public void pathSumHandle(TreeNode root,int curSum, int target, Map<Integer, Integer> preSum) {

    	if (root == null) {
    		return;
    	}	

    	curSum = curSum + root.val;
    	if (preSum.containsKey(curSum - target)) {
    		count += preSum.get(curSum - target);
    	}
    
    	preSum.put(curSum, 1 + preSum.getOrDefault(curSum, 0));

        pathSumHandle(root.left, curSum, target, preSum);
        pathSumHandle(root.right, curSum, target, preSum);

        preSum.put(curSum, preSum.get(curSum) - 1);

    }
}