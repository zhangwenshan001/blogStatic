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
     * @Tag BFS
     *
     * @param TreeNode $root
     * @param Integer $x
     * @param Integer $y
     * @return Boolean
     */
    function isCousins($root, $x, $y) {
        if ($root == null) {
            return false;
        }
        $queue = [$root];

        while (count($queue) != 0) {
            $count = count($queue);
            $xFlag = false;
            $yFlag = false;
            for($i = 0;$i<$count;$i++) {
                if ($queue[$i]->left != null && $queue[$i]->right != null) {
                    if (($queue[$i]->left->val == $x && $queue[$i]->right->val == $y) ||
                       ($queue[$i]->left->val == $y && $queue[$i]->right->val == $x)) {
                        return false;
                    }
                }
                
                if ($queue[$i]->left != null) {
                    if ($queue[$i]->left->val == $x) {
                        $xFlag = true;
                    }
                    if ($queue[$i]->left->val == $y) {
                        $yFlag = true;
                    }
                    $queue[] = $queue[$i]->left;
                }
    

                if ($queue[$i]->right != null) {
                    if ($queue[$i]->right->val == $x) {
                        $xFlag = true;
                    }
                    if ($queue[$i]->right->val == $y) {
                        $yFlag = true;
                    }
                    $queue[] = $queue[$i]->right;
                }
                
                if ($xFlag && $yFlag) {
                    return true;
                }
            }
            for($i =0;$i<$count;$i++) {
                array_shift($queue);
            }
        }
        return false;   
    }
}
