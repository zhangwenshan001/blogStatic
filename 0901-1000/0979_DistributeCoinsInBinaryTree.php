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

    private $sum = 0;
    /**
     * @param TreeNode $root
     * @return Integer
     */
    function distributeCoins($root) {
        if ($root == null) {
            return 0;
        }
        
        if ($root->left == null && $root->right == null) {   
            return 0;
        }
        
        if ($root->left != null) {
            $this->distributeCoins($root->left);
            $this->sum += ($root->left->val >= 1) ? ($root->left->val - 1) : (1-$root->left->val);
            $root->val = $root->val + ($root->left->val - 1);
        }
        if ($root->right != null) {
            $this->distributeCoins($root->right);
            $this->sum += ($root->right->val >=1) ? ($root->right->val - 1) : (1-$root->right->val);
            $root->val = $root->val + ($root->right->val - 1);
        }
        
        return $this->sum;
    }
}
