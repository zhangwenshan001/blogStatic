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
     * @param TreeNode $root1
     * @param TreeNode $root2
     * @return Boolean
     */
    function leafSimilar($root1, $root2) {
       // var_dump($root1);
        $leaves1 = $this->getLeaves($root1);
        $leaves2 = $this->getLeaves($root2);
        
        $c1 = count($leaves1);
        
        if ($c1 != count($leaves2)) {
            return false;
        }
       
        for($i = 0;$i<$c1;$i++) {
            if ($leaves1[$i] != $leaves2[$i]) {
                return false;
            }
        }
        return true;
    }
    
    
    function getLeaves($root) {
        if ($root == null) {
            return [];
        }
        if ($root->left == null && $root->right == null) {
            return [$root->val];
        }
        
        $res = array_merge($this->getLeaves($root->left), $this->getLeaves($root->right));
        return $res;
    }
    
    
}
