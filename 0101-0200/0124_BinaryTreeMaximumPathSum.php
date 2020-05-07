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
    private  $result = -INF;

    /**
     * @param TreeNode $root
     * @return Integer
     */
    function maxPathSum($root) {
        $this->maxPathSumHandle($root);
    	  return $this->result;
    }
    
    function maxPathSumHandle($root) {
        if ($root == null) {
    		  return 0;
    	  }
        $left = max(0, $this->maxPathSumHandle($root->left));
        $right = max(0, $this->maxPathSumHandle($root->right));      
        $this->result = max($this->result, $left + $right + $root->val);
        return max($left, $right) + $root->val;
    }
}
