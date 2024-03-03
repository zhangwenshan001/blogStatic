/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode fast = cur;
        ListNode p = cur;

        while(n-- > 0) fast = fast.next;

        while(fast.next != null) {
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return p.next;
    }
}