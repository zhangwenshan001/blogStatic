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
     * @param Integer $val
     * @return ListNode
     */
    function removeElements($head, $val) {
        while($head != null && $head->val == $val) {
            $head = $head->next;
        }
        
        if($head == null) {
            return $head;
        }
        
        $p = $head;
        $next = $p->next;
        
        while($next != null) {
            while($next != null && $next->val == $val) {
                $next = $next->next;
            }
            $p->next = $next;
            $p = $p->next;
            if ($p!=null) {
                $next = $p->next;
            } else {
                break;
            }
        }
        
        return $head;
        
    }
}
