<?php

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($val = 0, $left = null, $right = null) {
 *         $this->val = $val;
 *         $this->left = $left;
 *         $this->right = $right;
 *     }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function rightSideView($root) {
        if ($root == null) {
            return [];
        }
        
        $queue = [$root];
        
        $res = [];
        while(count($queue) != 0) {
            $count = count($queue);
            $res[] = $queue[$count-1]->val;
            for($i=0;$i<$count;$i++) {
                if ($queue[$i]->left != null) $queue[] = $queue[$i]->left;
                if ($queue[$i]->right != null) $queue[] = $queue[$i]->right;
            }
            for($i=0;$i<$count;$i++) {
                array_shift($queue);
            }
        }
        return $res;
    }
}
