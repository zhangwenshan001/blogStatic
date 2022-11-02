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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        flattenHandle(queue, null);
    }
    
     public static TreeNode flattenHandle(Queue<TreeNode> queue, TreeNode last) {
            TreeNode curNode = queue.poll();

            TreeNode rightNode = curNode.right;
            TreeNode leftNode = curNode.left;

            if (last == null) {
                last = curNode;
            } else {
                last.right = curNode;
                last.left = null;
                last = last.right;
            }

            if (leftNode != null) {
                queue.offer(leftNode);
                last = flattenHandle(queue, last);
            }

            if (rightNode != null) {
                queue.offer(rightNode);
                last = flattenHandle(queue, last);
            }

            return last;

    }
}
