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
     * @param Integer $x
     * @return ListNode
     */
    function partition($head, $x) {
        if ($head == null) {
            return null;
        }
        $ltHead = null;
        $ltNode = null;
        $geHead = null;
        $geNode = null;
        while($head != null) {
            if ($head->val < $x) {
                if ($ltNode == null) {
                    $ltNode = $head;
                    if ($ltHead == null) {
                        $ltHead = $ltNode;
                    }    
                } else {
                    $ltNode->next = $head;
                    $ltNode = $ltNode->next;
                }
            } else {
                if ($geNode == null) {
                    $geNode = $head;
                    if ($geHead == null) {
                        $geHead = $geNode;
                    }
                } else {
                    $geNode->next = $head;
                    $geNode = $geNode->next;
                }
            }
            $head = $head->next;
        }

        if (!$ltHead) {
            return $geHead;
        }
        if ($geNode) {
            $geNode->next = null;
        }
        $ltNode->next = $geHead;
        return $ltHead;
        
    }
}