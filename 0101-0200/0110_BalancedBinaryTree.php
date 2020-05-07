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
     * @return Boolean
     */
    function isBalanced($root) {
        $res = $this->handle($root);
        return $res[0];
    }
    
    function handle($root) {
        if ($root == null) {
            return [true, 0];
        }
        
        $left = $this->handle($root->left);
        $right = $this->handle($root->right);
        $depth = max($left[1], $right[1]) + 1;
        echo $depth, $root->val;
        $isBalanced = $left[0] && $right[0] && $left[1] -$right[1] <= 1 &&  $left[1] -$right[1] >= -1;
        return [$isBalanced, $depth];
    }
}
