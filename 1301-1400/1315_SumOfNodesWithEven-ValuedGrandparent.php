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
    function sumEvenGrandparent($root) {
        if ($root == null) {
            return 0;
        }
        $this->dfs($root, false);
        return $this->sum;
    }
    
    function dfs($root, $parentIsEven) {
        $isEven = ($root->val % 2 == 0);
        if ($root->left != null) {
            if ($parentIsEven) {
                $this->sum += $root->left->val;
            }
            $this->dfs($root->left, $isEven);
        }
        if ($root->right != null) {
            if ($parentIsEven) {
                $this->sum += $root->right->val;
            }
            $this->dfs($root->right, $isEven);
        }
        return;
    }
}
