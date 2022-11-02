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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);

        ListNode rans = new ListNode(0);
        ListNode cur = rans;
        int flag = 0;
        while(rl1 != null || rl2 != null) {
            if (rl1 != null && rl2 != null) {
                int v = (flag + rl1.val + rl2.val) >= 10 ? flag + rl1.val + rl2.val - 10 : flag + rl1.val + rl2.val;
                flag = (flag + rl1.val + rl2.val) >= 10 ? 1 : 0;
                cur.next = new ListNode(v);
                rl1 = rl1.next;
                rl2 = rl2.next;
            } else if (rl1 != null) {
                int v = flag + rl1.val >= 10 ? flag + rl1.val - 10 : flag + rl1.val;
                flag = (flag + rl1.val) >= 10 ? 1 : 0;
                cur.next = new ListNode(v);
                rl1 = rl1.next;
            } else {
                int v = flag + rl2.val >= 10 ? flag + rl2.val - 10 : flag + rl2.val;
                flag = (flag + rl2.val) >= 10 ? 1 : 0;
                cur.next = new ListNode(v);
                rl2 = rl2.next;
            }
            cur = cur.next;
        }
        if (flag == 1) {
            cur.next = new ListNode(1);
        }
        rans = rans.next;

        return reverse(rans);
    }

    private ListNode reverse(ListNode l) {
        ListNode pre = null;
        ListNode cur = l;
        ListNode next = cur.next;
        while(next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }

        cur.next = pre;
        return cur;
    }
}