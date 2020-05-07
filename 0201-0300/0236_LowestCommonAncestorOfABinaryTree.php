<?php

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */

class Solution {
    /**
     * @param TreeNode $root
     * @param TreeNode $p
     * @param TreeNode $q
     * @return TreeNode
     */
    function lowestCommonAncestor($root, $p, $q) {
        $res = $this->lowestCommonAncestorHandle($root, $p, $q);
        return $res[1];
    }
    
    function lowestCommonAncestorHandle($root,$p,$q) {
        $leftRes = [];
        $rightRes = [];
        
        if ($root->left != null) {
            $leftRes = $this->lowestCommonAncestorHandle($root->left, $p, $q);
        }
        if ($root->right != null) {
            $rightRes = $this->lowestCommonAncestorHandle($root->right, $p, $q);
        }
        
        if (!empty($leftRes) && $leftRes[0] == 3) {
            return [3, $leftRes[1]];
        } 
        if (!empty($rightRes) && $rightRes[0] == 3) {
            return [3,$rightRes[1]];
        }
        
        if (   
            (!empty($leftRes) && !empty($rightRes) && $leftRes[0] > 0 && $rightRes[0] > 0) || 
            (!empty($leftRes) && $leftRes[0] == 1 && $root->val == $q->val) ||
            !empty($leftRes) && ($leftRes[0] == 2 && $root->val == $p->val) ||
            (!empty($rightRes) && $rightRes[0] == 1 && $root->val == $q->val) ||
            (!empty($rightRes) && $rightRes[0] == 2 && $root->val == $p->val)) {
            return [3, $root];
        }
        
        if ($root->val == $p->val) {
            return [1, null];
        } 
        if ($root->val == $q->val) {
            return [2, null];
        }
        
        $statusMax = max($leftRes[0] ?? 0, $rightRes[0]?? 0);
        
        return [$statusMax, null];
    }
}
