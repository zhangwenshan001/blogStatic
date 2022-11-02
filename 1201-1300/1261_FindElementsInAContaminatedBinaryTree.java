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
class FindElements {
    TreeNode root;
    boolean[] nums;

    public FindElements(TreeNode root) {
        nums = new boolean[1000001];
        this.root = root;
        this.root.val = 0;
        nums[0] = true;
        recover(this.root);
    }
    
    public void recover(TreeNode p) {
        if (p.left != null &&  p.val <= 500000) {
            p.left.val = 2 * p.val + 1;
            nums[p.left.val] = true;
            recover(p.left);
        }
        
        if (p.right != null && p.val <= 500000) {
            p.right.val = 2 * p.val + 2;
            nums[p.right.val] = true;
            recover(p.right);
        }
    }
    
    public boolean find(int target) {
        return nums[target];
    }
    
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */