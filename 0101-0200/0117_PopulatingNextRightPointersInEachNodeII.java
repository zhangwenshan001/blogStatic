/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node p = root; 
        while(p != null) {
            while(p!=null && p.left == null && p.right == null) {
                p = p.next;
            }
            Node cur = p;
            while(cur != null) {
               // System.out.println(cur.val);
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                }
                Node pre = (cur.right != null) ? cur.right : cur.left;
                if (pre != null) {
                    while(cur != null && cur.next!=null && cur.next.left==null && cur.next.right == null) {
                        cur = cur.next;
                    }
                    pre.next = (cur == null || cur.next == null) ? null : 
                    (cur.next.left!= null ? cur.next.left : cur.next.right);
                }
                if (cur != null) cur = cur.next;
            }
            
            
            if (p!=null) p = (p.left != null) ? p.left : p.right;
        }
        
        return root;
        
    }
}