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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null ||
                inorder == null ||
                preorder.length == 0 ||
                inorder.length == 0) {
            return null;
        }

        return buildTreeHandle(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public static TreeNode buildTreeHandle(int[] preorder, int[] inorder,int prestart,int preend, int instart, int inend) {
        int curNodeVal = preorder[prestart];
        TreeNode result = new TreeNode(curNodeVal);
        //if start=end, it's a leaf node
        if (prestart == preend || instart == inend) {
            return result;
        }

        int count=0;
        while (inorder[instart+count] != curNodeVal) {
            count++;
        }

        if (count > 0) {
            TreeNode leftNode = buildTreeHandle(preorder, inorder, prestart+1, prestart+count, instart, instart+count-1);
            result.left = leftNode;
        }

        if (prestart+count+1 <= preend) {
            TreeNode rightNode = buildTreeHandle(preorder, inorder, prestart+count+1, preend, instart+count+1, inend);
            result.right = rightNode;
        }

        return result;
    }
}