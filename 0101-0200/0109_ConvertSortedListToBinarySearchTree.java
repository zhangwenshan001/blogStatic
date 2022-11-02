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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast.next!= null && fast.next.next!=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre !=null) {
            pre.next = null;
        }
        TreeNode cur = new TreeNode(slow.val);
        System.out.println(cur.val);
        cur.right = sortedListToBST(slow.next);
        slow.next = null;
        if (slow != head) {
            cur.left = sortedListToBST(head);
        }
          
        return cur;
    }
}