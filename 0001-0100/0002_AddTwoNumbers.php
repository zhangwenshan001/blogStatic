<?php

/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers($l1, $l2) {
        if (!$l1 && !$l2) {
             return null;
        }

        $flag = 0;
        $result = null;
        $last = null;
        while ($l1 && $l2) {
            $cur = new ListNode(($l1->val + $l2->val + $flag) % 10);
            $flag = intval(($l1->val + $l2->val + $flag) / 10);
            if (!$result) {
                $result = $cur;
            }
            if ($last) {
                $last->next = $cur;
            }
            $l1 = $l1->next;
            $l2 = $l2->next;
            $last = $cur;
        }

        $tail = $l1 ? $l1 : $l2;
        while ($tail) {
            $cur = new ListNode(($tail->val + $flag) % 10);
            $flag = intval(($tail->val + $flag) / 10);
            if (!$result) {
                $result = $cur;
            }
            if ($last) {
                $last->next = $cur;
            }
            $tail = $tail->next;
            $last = $cur;
        }

        if ($flag) {
            $cur = new ListNode(1);
            $last->next = $cur;
        }

        return $result;
    }
}
