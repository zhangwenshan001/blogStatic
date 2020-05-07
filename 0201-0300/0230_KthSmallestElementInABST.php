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

    private $nums = [];
    /**
     * @param TreeNode $root
     * @param Integer $k
     * @return Integer
     */
    function kthSmallest($root, $k) {
        $this->inorder($root);
        return $this->nums[$k-1];
    }
    
    function inorder($root) {
        if ($root == null) {
            return;
        }
        if ($root->left != null) {
            $this->inorder($root->left);
        }
        $this->nums[] = $root->val;
        if ($root->right !=null) {
            $this->inorder($root->right);
        }
        
        return;
    }
    
    
    
}
