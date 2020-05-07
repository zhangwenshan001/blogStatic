<?php

class Solution {

    /**
     * @param TreeNode $root
     * @return TreeNode
     */
    function invertTree($root) {
        if ($root == null) {
            return $root;
        }
        if ($root->left == null && $root->right == null) {
            return $root;
        }
        
        $left = null;
        if ($root->left != null) {
            $left = $this->invertTree($root->left);
        }
        $right = null;
        if ($root->right != null) {
            $right = $this->invertTree($root->right);
        }
        
        $root->left = $right;
        $root->right = $left;
        return $root;
    }
}
