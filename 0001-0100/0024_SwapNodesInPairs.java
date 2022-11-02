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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode pre = new ListNode(-1, head);
        ListNode res = pre;

        ListNode p = head;
        ListNode pp = head.next;

        while(p != null && pp != null) {
            pre.next = pp;
            p.next = pp.next;
            pp.next = p;
            pre = p;
            p = pre.next;
            pp = (p == null) ? null : p.next;
        }

        return res.next;
    }
}