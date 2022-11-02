/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
			return null;
		}

		ListNode pslow = head;
		ListNode pfast = head;

		int circleLength = 0;
		do {
			pfast = pfast.next.next;
			pslow = pslow.next;
			circleLength++;
			if (pfast==null || pfast.next == null) {
				return null;
			}
		} while (pfast != pslow);

		ListNode p = head;
		for(int i = 0;i<circleLength;i++) {
			p = p.next;
		}
		ListNode q = head;
		while(p != q) {
			p = p.next;
			q = q.next;
		}

		return p;
    }
}