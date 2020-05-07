<?php

/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val = 0, $next = null) {
 *         $this->val = $val;
 *         $this->next = $next;
 *     }
 * }
 */
class Solution {

    /**
     * @param ListNode $head
     * @return ListNode
     */
    function oddEvenList($head) {
        if ($head == null || $head->next == null) {
            return $head;
        }
        $oddHead = $head;
        $evenHead = $head->next;
        
        $p1 = $oddHead;
        $p2 = $evenHead;
        
        while($p2!=null && $p2->next !=null) {
            $nextP1 = $p2->next;
            $p1->next = $nextP1;
            $p2->next = $nextP1->next;
            $p1 = $p1->next;
            $p2 = $p2->next;
        }
        
        $p1->next = $evenHead;
        
        return $oddHead;
    }
}
