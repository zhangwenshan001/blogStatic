/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
			return null;
		}

		Node p = head;
		while(p!=null) {
			Node cp = new Node(p.val);
			cp.next = p.next;
			p.next = cp;
			p = cp.next;
		}

		Node q = head;

		while(q != null) {
			q.next.random = (q.random == null) ? null : q.random.next;
			q = q.next.next;
		}

		p = head;
		Node res = p.next;
		Node cp = res;

		while(cp.next!=null) {
			p.next = cp.next;
			p = p.next;
			cp.next = p.next;
			cp = cp.next;
		}
        p.next = null;

		return res;
    }
}