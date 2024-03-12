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
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head.next != null) {
            head.next = removeZeroSumSublists(head.next);
        }
        int sum = 0;
        ListNode p = head;
        while(p != null) {
            sum += p.val;
            if (sum == 0) return p.next;
            p = p.next;
        }
        return head;
    }
}