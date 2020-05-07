<?php

/**
 * Definition for a Node.
 * class Node {
 *     public $val = null;
 *     public $children = null;
 *     function __construct($val = 0) {
 *         $this->val = $val;
 *         $this->children = array();
 *     }
 * }
 */

class Solution {
    /**
     * @param Node $root
     * @return integer
     */
    function maxDepth($root) {
        return $this->maxDepthHandle($root, 0);
    }
    
    function maxDepthHandle($root, $depth){
        if ($root == null) {
            return $depth;
        }
        
        if ($root->children == null) {
            return 1;
        }
        $max = 0;
        foreach($root->children as $child) {
            //var_dump($child);
            $max = max($max,  $this->maxDepthHandle($child, $depth)+1); 
        }
  
        return $max;
    }
}
