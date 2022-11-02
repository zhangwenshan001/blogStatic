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
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> q;

    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<TreeNode>();
        q.offer(root);
        bfs();
    }
    
    public int insert(int val) {
        TreeNode cur = q.peek();
        if (cur.left == null) {
            cur.left = new TreeNode(val);
        } else {
            cur.right = new TreeNode(val);
            bfs();
        }
        return cur.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
    
    public void bfs() {
        while(true) {
            TreeNode cur = q.peek();
            if (cur.left !=null && cur.right!=null) {
                q.offer(cur.left);
                q.offer(cur.right);
                cur = q.poll();
            } else {
                break;
            }
        }
    }
    
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
