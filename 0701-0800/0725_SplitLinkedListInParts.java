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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        int count = 0;
        ListNode p = head;
        while(p != null) {
            count++;
            p = p.next;
        }
        int average = count / k;
        int q = count % k;

        p = head;
        for (int i = 0;i<q;i++) {
            ans[i] = p;
            for (int j = 0;j<average;j++) {
                p = p.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }

        for (int i = q;i < k;i++) {
            ans[i] = p;
            for (int j = 0;j<average-1;j++) {
                p = p.next;
            }
            if (p != null) {
                ListNode next = p.next;
                p.next = null;
                p = next;
            }
        }
        return ans;
    }
}