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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        if (root.left == null && root.right==null) {     
            if (root.val != sum) {
                return new ArrayList<List<Integer>>();
            } else {
                List<List<Integer>> res = new ArrayList<List<Integer>>();
                List<Integer> cur = new ArrayList<Integer>();
                cur.add(root.val);
                res.add(cur);
                return res;
            }
        }
        
        List<List<Integer>> leftList = pathSum(root.left, sum-root.val);
        List<List<Integer>> rightList = pathSum(root.right, sum-root.val);
        
        List<List<Integer>> curRes = new ArrayList<List<Integer>>();
        if (leftList != null && leftList.size() > 0) {
            for(int i =0;i<leftList.size();i++) {
                leftList.get(i).add(0,root.val);
                curRes.add(leftList.get(i));
            }
        }
        if (rightList != null && rightList.size() > 0) {
            for(int i =0;i<rightList.size();i++) {
                rightList.get(i).add(0,root.val);
                curRes.add(rightList.get(i));
            }
        }
        
        return curRes;
    }
}