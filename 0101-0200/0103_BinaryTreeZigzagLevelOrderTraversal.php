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
     * @return Integer[][]
     */
    function zigzagLevelOrder($root) {
        $stackLeft = [];
        $stackRight = [];
        $res = [];
        if ($root == null) {
            return $res;
        }
        array_push($stackLeft, $root);
        while(!empty($stackLeft)){
            $curRes = [];
            while(!empty($stackLeft)){
                $p = array_pop($stackLeft);
                $curRes[] = $p->val;
                if ($p->left != null) array_push($stackRight, $p->left);
                if ($p->right != null) array_push($stackRight, $p->right);
            }
            if (!empty($curRes)) {
                $res[] = $curRes;
            }
           
            $curRes = [];
            while(!empty($stackRight)) {
                $p = array_pop($stackRight);
                $curRes[] = $p->val;
                if ($p->right != null) array_push($stackLeft, $p->right);
                if ($p->left != null) array_push($stackLeft, $p->left);
            }        
            if (!empty($curRes)) {
                $res[] = $curRes;
            }
        }
        
        return $res;
    }
}
