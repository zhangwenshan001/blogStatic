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
    private $sum=0;

    /**
     * @param TreeNode $root
     * @return Integer
     */
    function sumOfLeftLeaves($root) {
        if ($root == null) {
            return 0;
        }
        if ($root->left != null) {
            $this->handle($root->left, true);
        }
        if ($root->right != null) {
            $this->handle($root->right, false);
        }
        
        return $this->sum;
    }
    
    function handle($p, $flag) {
        if ($p->left == null && $p->right==null && $flag) {
            $this->sum += $p->val;
            return;
        }
        
        if ($p->left != null) {
            $this->handle($p->left, true);
        }
        if ($p->right != null) {
            $this->handle($p->right, false);
        }
    }
}
