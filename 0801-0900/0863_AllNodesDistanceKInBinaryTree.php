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
    private $res = [];
    private $K;
    private $target;
    /**
     * @param TreeNode $root
     * @param TreeNode $target
     * @param Integer $K
     * @return Integer[]
     */
    function distanceK($root, $target, $K) {
        $this->K = $K;
        $this->target = $target;
        $this->dfs($root);
        
        return $this->res;
    }
    
    function dfs($root) {
        if ($root == null) {
            return -1;
        }
        
        if ($root->val == $this->target->val) {
            $this->addNode($root, 0); 
            return 1;
        }
        
        $left = $this->dfs($root->left);
        $right = $this->dfs($root->right);
    
        if ($left > 0) {
            if ($left == $this->K) {
                $this->res[] = $root->val;
            } else if ($left < $this->K) {
                $this->addNode($root->right, $left+1);
            }
            
            return $left + 1;
        }
        
        if ($right > 0) {
            if ($right == $this->K) {
                $this->res[] = $root->val;
            } else if ($right < $this->K) {
                $this->addNode($root->left, $right+1);
            }
            
            return $right + 1;
        }
        
        return -1;
    }
    
    function addNode($root, $distance) {
        if ($root == null) {
            return;
        }
    
        if ($distance == $this->K) {
            $this->res[] = $root->val;
            return;
        }
        $this->addNode($root->left, $distance+1);
        $this->addNode($root->right, $distance+1);
        return;
    }
    
    
}
