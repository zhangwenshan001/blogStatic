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
     * @param Integer $sum
     * @return Boolean
     */
    function hasPathSum($root, $sum) {
        if ($root == null) {
            return false;
        }
        
        return $this->dfs($root, $sum);     
    }
    
    function dfs($root, $sum) {
        if ($root->left == null && $root->right == null) {
            if ($root->val == $sum) {
                return true;
            } else {
                return false;
            }
        }
        
        $leftRes = false;
        if ($root->left != null) {
            $leftRes = $this->dfs($root->left, $sum - $root->val);
        }
        $rightRes = false;
         if ($root->right != null) {
            $rightRes = $this->dfs($root->right, $sum - $root->val);
        }
        
        return  $leftRes||$rightRes; 
    }
}
