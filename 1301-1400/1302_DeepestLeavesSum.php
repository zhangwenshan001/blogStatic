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

    private $depths = [];
    /**
     * @param TreeNode $root
     * @return Integer
     */
    function deepestLeavesSum($root) {
        $this->deepestLeavesSumHandle($root, 0);
        
        if (count($this->depths) == 0) {
            return 0;
        }
        return $this->depths[count($this->depths)-1];
    }
    
    function deepestLeavesSumHandle($root, $depth) {
        if ($root == null) {
            return;
        }
        if (empty($this->depths[$depth])) {
            $this->depths[$depth] = $root->val;
        } else {
             $this->depths[$depth] = $this->depths[$depth] + $root->val;
        }
        $this->deepestLeavesSumHandle($root->left, $depth+1);
        $this->deepestLeavesSumHandle($root->right, $depth+1);
        
        return;
    }
}
