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
     * @return Integer[][]
     */
    function levelOrderBottom($root) {
        if ($root == null) {
            return [];
        }
        $res = [];
        $queue = [$root];
        while($count = count($queue)) {


            for ($i = 0;$i < $count;$i++) {
                if ($queue[$i]->left != null) {
                    $queue[] = $queue[$i]->left;
                }
                if ($queue[$i]->right != null) {
                    $queue[] = $queue[$i]->right;
                }
            }
            $cur = [];
            for ($i =0;$i<$count;$i++) {
                $cur[] = $queue[0]->val;
                array_shift($queue);
            }
            array_unshift($res, $cur);
        }
        return $res;
    }
}
