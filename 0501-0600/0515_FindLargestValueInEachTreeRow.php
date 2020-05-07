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
    function largestValues($root) {
        if ($root == null) {
            return [];
        }
        $res = [];
        $queue = [$root];
        
        while (count($queue) != 0) {
            $count = count($queue);
            $max = PHP_INT_MIN;
            for($i = 0;$i< $count;$i++) {
                $max = max($max, $queue[$i]->val);
                if ($queue[$i]->left != null) {
                    $queue[] = $queue[$i]->left;
                }
                if ($queue[$i]->right != null) {
                    $queue[] = $queue[$i]->right;
                }
            }
            $res[] = $max;
            for($i = 0;$i< $count;$i++) {
                array_shift($queue);
            }
        }
        
        return $res;
    }
}
