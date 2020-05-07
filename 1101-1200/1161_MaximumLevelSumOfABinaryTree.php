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
     * @return Integer
     */
    function maxLevelSum($root) {
        if($root == null) {
            return 0;
        }
        $queue = [$root];

        $maxSum = PHP_INT_MIN;
        $level = 0;
        $maxLevel = 0;
        while(count($queue) >0) {
            $level++;
            $count = count($queue);

            $curSum = 0;
            for($i = 0;$i<$count;$i++) {
                $curSum += $queue[$i]->val;
                if ($queue[$i]->left != null) {
                    $queue[] = $queue[$i]->left;
                }
                if ($queue[$i]->right != null) {
                    $queue[] = $queue[$i]->right;
                }
            }

            for($i = 0;$i<$count;$i++) {
                array_shift($queue);
            }
            if ($curSum > $maxSum) {
                $maxSum = $curSum;
                $maxLevel = $level;
            }
        }
        return $maxLevel;
    }
}