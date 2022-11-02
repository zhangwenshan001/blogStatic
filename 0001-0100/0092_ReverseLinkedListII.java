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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        int count = 0;
        while (pre.next != null && count < left-1) {
            count++;
            pre = pre.next;
        }
        
        ListNode leftP = pre.next;
        ListNode curP = leftP;
        ListNode nextP = curP.next;
        ListNode tmp;
        
        while(count < right-2) {
            tmp = nextP.next;
            nextP.next = curP;
            curP = nextP;
            nextP = tmp;
            count++;
        }
        
        leftP.next = nextP.next;
        nextP.next = curP;
        pre.next = nextP;
        
        return preHead.next;
    }
}