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
     * @param Integer[] $nums
     * @return TreeNode
     */
    function sortedArrayToBST($nums) {
        if (empty($nums)) {
            return null;
        }
        return $this->handle($nums, 0, count($nums)-1);
    }
    
    function handle($nums, $start, $end) {
        echo $start, " ", $end;
        if ($start > $end) {
            return null;
        }
        if ($start == $end) {
            return new TreeNode($nums[$start]);
        }
        if ($start + 1 == $end) {
            $curRoot = new TreeNode($nums[$end]);
            $curLeft = new TreeNode($nums[$start]);
            $curRoot->left = $curLeft;
            return $curRoot;
        }
        
        $mid = (int) (($start + $end) / 2);
        $curRoot = new TreeNode($nums[$mid]);
        $curRoot->left = $this->handle($nums, $start, $mid-1);
        $curRoot->right = $this->handle($nums, $mid+1, $end);
        
        return $curRoot;
    }
}
