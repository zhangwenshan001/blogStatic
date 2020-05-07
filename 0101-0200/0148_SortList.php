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
    function sortList($head) {
        
        if ($head == null) {
            return null;
        }
        if ($head->next == null) {
            return $head;
        }
        
        $fastNode = $head;
        $slowNode = $head;
        $preNode = null;
        
        while($fastNode != null && $fastNode->next !=null) {
            $fastNode = $fastNode->next->next;
            $preNode = $slowNode;
            $slowNode = $slowNode->next;
        }
        //echo $slowNode->val;
        $preNode->next = null;
        
        $leftList = $this->sortList($head);
        $rightList = $this->sortList($slowNode);
        
        return $this->merge($leftList, $rightList);
    }
    
    function merge($node1, $node2)
    {
        $res = null;
        $p = null;
        while($node1 != null && $node2 != null) {
            if ($node1->val < $node2->val) {
                $cur = $node1;
                $node1 = $node1->next;
            } else {
                $cur = $node2;
                $node2 = $node2->next;
            }
            if ($res == null) {
                $res = $cur;
                $p = $cur;
            } else {
                $p->next = $cur;
                $p = $p->next;
            }
        }
        if ($node1 != null) {
            $p->next = $node1;
        }
        if ($node2 != null) {
            $p->next = $node2;
        }
        
        return $res;
    }
}
