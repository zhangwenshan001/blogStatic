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
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
        	if(queue.peek() == null) {
                if (queue.size()>1) {
                    queue.offer(null);
                }	
        		queue.poll();
        	} else {
				if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
				Node cur = queue.poll();
				cur.next = queue.peek();
			}
        }
        
        return root;
    }
}