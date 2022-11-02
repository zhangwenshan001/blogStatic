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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length==0) {
            return null;
        }
        TreeNode res = build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        
        return res;
    }
    
    public TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        TreeNode head = new TreeNode(postorder[postEnd]);
        
        int count = 0;
        while(inorder[inStart+count] != postorder[postEnd]) {
            count++;
        }
        
        if (count > 0) {
            head.left = build(inorder, postorder, inStart, inStart+count-1, postStart, postStart+count-1);
        }
        if (inStart+count+1 <= inEnd) {
            head.right = build(inorder, postorder, inStart+count+1, inEnd, postStart+count,postEnd-1);
        } 
        return head;
    }
}