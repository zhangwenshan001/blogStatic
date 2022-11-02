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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode pNode;
        for (int i = 1;i<preorder.length;i++) {
            TreeNode curNode = new TreeNode(preorder[i]); //当前节点
            pNode = root;
            while (true) {
                if (curNode.val > pNode.val) {
                    if (pNode.right == null) {
                        pNode.right = curNode;
                        break;
                    } else {
                        pNode = pNode.right;
                    }
                } else {
                    if (pNode.left == null) {
                        pNode.left = curNode;
                        break;
                    } else {
                        pNode = pNode.left;
                    }
                }
            }
        }
        return root;
    }
}