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
    Map<String, Integer> serialToId;
    Map<Integer, Integer> idCounts;
    int curId = 1;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialToId = new HashMap<>();
        idCounts = new HashMap<>();

        List<TreeNode> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    
    private int postorder(TreeNode root, List<TreeNode> res) {
        if (root == null) return 0;
        int leftId = postorder(root.left, res);
        int rightId = postorder(root.right, res);
        String curSerial = leftId + ":" + root.val + ":" + rightId;
        int id = serialToId.getOrDefault(curSerial, curId);
        if (id == curId) curId++;
        serialToId.put(curSerial, id);
        idCounts.put(id, idCounts.getOrDefault(id, 0) + 1);
        if (idCounts.get(id) == 2) {
            res.add(root);
        }

        return id;
    }
    
}