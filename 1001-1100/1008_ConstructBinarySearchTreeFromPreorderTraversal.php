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

    private $preorder;
    /**
     * @param Integer[] $preorder
     * @return TreeNode
     */
    function bstFromPreorder($preorder) {
        $this->preorder = $preorder;
        $resNode = $this->bstFromPreorderHandle(0, count($preorder)-1);
        return $resNode;
    }
    
    function bstFromPreorderHandle($start, $end) {
        if ($start > $end) {
            return null;
        }
        $cur = $this->preorder[$start];
        
        if ($start==$end) {
            return new TreeNode($cur);
        }
        
        $i = $start+1;
        while($i <=$end && $this->preorder[$i]<$cur) {
            $i++;
        }
        $leftNode = $this->bstFromPreorderHandle($start+1, $i-1);
        $rightNode = $this->bstFromPreorderHandle($i, $end);
        return new TreeNode($cur, $leftNode, $rightNode);
    }
}
