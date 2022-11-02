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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (int i =0;i<lists.length;i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }

        if (pq.isEmpty()) return null;
        ListNode res = pq.remove();
        if (res.next != null) pq.add(res.next);
        ListNode p = res;
        while(!pq.isEmpty()) {
            ListNode crr = pq.remove();
            p.next = crr;
            p = p.next;
            if (crr.next != null) pq.add(crr.next);
        }

        return res;
    }

}