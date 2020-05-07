<?php

/**
 * Definition for a Node.
 * class Node {
 *     public $val = null;
 *     public $neighbors = null;
 *     function __construct($val = 0) {
 *         $this->val = $val;
 *         $this->neighbors = array();
 *     }
 * }
 */

class Solution {
    private $nodeList = [];
    /**
     * @param Node $node
     * @return Node
     */
    function cloneGraph($node) {
        if ($node == null) {
            return null;
        }
        $this->dfs($node);
        return $this->nodeList[1];

    }

    function dfs($node) {
        if (empty($this->nodeList[$node->val])) {
            $this->nodeList[$node->val] = new Node($node->val);
        }
        foreach($node->neighbors as $n) {
            if (!empty($this->nodeList[$n->val])) {
                $this->nodeList[$node->val]->neighbors[] = $this->nodeList[$n->val];
            } else {
                $this->dfs($n);
                $this->nodeList[$node->val]->neighbors[] = $this->nodeList[$n->val];
            }
        }

        return;
    }

}