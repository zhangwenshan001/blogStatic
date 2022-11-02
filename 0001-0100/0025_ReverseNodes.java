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
    // time complexity O(N)
    // space complexity O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        // if node count in the linked list >= k, reverse the first k nodes, and let kth node -> reverseKGroup(next, k)
        // else return head

        int count = 0;
        ListNode p = head;
        while(p != null && count < k) {
            p = p.next;
            count++;
        }

        if (count < k) return head;

        // init: cur -> tmp -> ... -> (next -> ... )
        ListNode next = reverseKGroup(p, k); 
        ListNode cur = head;
        ListNode tmp;

        for (int i = 0;i<k;i++) {
            tmp = cur.next;
            cur.next = next; 
            next = cur; 
            cur = tmp;  
        }
        return next;
    }
}