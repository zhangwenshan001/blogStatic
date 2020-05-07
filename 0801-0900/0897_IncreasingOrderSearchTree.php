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
     * @return TreeNode
     */
    function increasingBST($root) {
        $res = $this->increasingBSTHandle($root);
        return $res[0];
    }
    
    function increasingBSTHandle($root) {
        if ($root == null) {
            return null;
        }
        
        $newRoot = $root;
        $newTail = $root;

       
        if ($root->right != null) {
            [$rightRoot, $rightTail] = $this->increasingBSTHandle($root->right);
            $root->right = $rightRoot;
            $newTail = $rightTail;
        }
        
        if ($root->left != null) {
            [$leftRoot, $leftTail] = $this->increasingBSTHandle($root->left);
            $leftTail->right = $root;
            $newRoot = $leftRoot;
            $root->left = null;
        } 
        
        return [$newRoot, $newTail];
    }
}
