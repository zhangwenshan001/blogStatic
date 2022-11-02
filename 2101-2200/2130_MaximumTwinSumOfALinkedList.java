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
    public int pairSum(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        ListNode pre;
        ListNode next = first.next;

        while(second != null && second.next != null) {
            second = second.next.next;
            pre = first;
            first = next;
            next = first.next;
            first.next = pre;
        }
        int ans = 0;
        ListNode p1 = first;
        ListNode p2 = next;

        while(p1 != null && p2 != null) {
            ans = Math.max(ans, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }

        return ans;
    }
}