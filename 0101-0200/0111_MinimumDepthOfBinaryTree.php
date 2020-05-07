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
     * @Tag 111
     *
     * @param TreeNode $root
     * @return Integer
     */
    function minDepth($root) {
        if (count($root) == 0) {
            return 0;
        }
        $queue = [$root];
        $depth = 0;
        while(count($queue) != 0) {
            $depth++;
            $count = count($queue);
            for ($i = 0;$i <$count; $i++) {
                if ($queue[$i]->left == null && $queue[$i]->right == null) {
                    return $depth;
                }
                if ($queue[$i]->left != null) {
                    $queue[] = $queue[$i]->left;
                }
                if ($queue[$i]->right != null) {
                    $queue[] = $queue[$i]->right;
                }
                
            }
            for ($i = 0;$i<$count;$i++) {
                array_shift($queue); //delete first
            }
        }

        return $depth;
    }
}
