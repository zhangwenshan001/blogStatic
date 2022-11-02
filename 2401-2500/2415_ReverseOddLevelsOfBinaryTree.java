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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }
    private void dfs(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null || node2 == null) return;
        if (level % 2 == 1) { //odd level
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
        dfs(node1.left, node2.right, level+1);
        dfs(node1.right, node2.left, level+1);
    }
    // public TreeNode reverseOddLevels(TreeNode root) {
    //     Queue<TreeNode> evenQueue = new LinkedList<>();
    //     Queue<TreeNode> oddQueue = new LinkedList<>();
    //     List<Integer> stack = new ArrayList<>();
    //     evenQueue.add(root);
    //     boolean isOdd = false;

    //     while(true) {
    //         while(evenQueue.size() > 0) {
    //             TreeNode curNode = evenQueue.poll();
    //             if (curNode.left != null) {
    //                 oddQueue.offer(curNode.left);
    //                 stack.add(curNode.left.val);
    //             }
    //             if (curNode.right != null) {
    //                 oddQueue.offer(curNode.right);
    //                 stack.add(curNode.right.val);
    //             }
    //         }
    //         while(oddQueue.size() > 0) {
    //             TreeNode curNode = oddQueue.poll();
    //             curNode.val = stack.get(stack.size()-1);
    //             stack.remove(stack.size()-1);
    //             if (curNode.left != null) {
    //                 evenQueue.offer(curNode.left);
    //             }
    //             if (curNode.right != null) {
    //                 evenQueue.offer(curNode.right);
    //             }
    //         }
    //         if (evenQueue.size() == 0 && oddQueue.size() == 0) break;
    //     }
    //     return root;
    // }
}