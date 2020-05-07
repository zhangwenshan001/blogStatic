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
     * @return Integer
     */
    function findBottomLeftValue($root) {
        if ($root == null) {
            return null;
        }
        
        $queue = [$root];
        while(count($queue) != 0) {
            
            $res = $queue[0];
            $count = count($queue);
            for($i = 0;$i<$count;$i++) {
                if ($queue[$i]->left != null) {
                    $queue[] =  $queue[$i]->left;
                }
                 if ($queue[$i]->right != null) {
                    $queue[] =  $queue[$i]->right;
                }
            }
            for($i = 0;$i<$count;$i++) {
                array_shift($queue);
            }
            
        }
       
        return $res->val;
    }
}
