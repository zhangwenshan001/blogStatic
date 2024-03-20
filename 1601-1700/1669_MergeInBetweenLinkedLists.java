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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1;
        int idx = 0;
        while(idx < a-1) {
            p = p.next;
            idx++;
        }
        ListNode pp = p;
        p = p.next;
        idx++;
        pp.next = list2;
        while(pp.next != null) pp = pp.next;
        while(idx < b) {
            p = p.next;
            idx++;
        }
        pp.next = p.next;
        return list1;
    }
}