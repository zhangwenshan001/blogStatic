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
     * @return integer[][]
     */
    function levelOrder($root) {
        if ($root == null || count($root) == 0) {
            return [];
        }
		$queue = [$root];
        $res = [];
        while(count($queue) != 0) {
           // var_dump($queue);  
            $count = count($queue);
            for($i = 0;$i<$count;$i++) {
                $childrenCount = count($queue[$i]->children);
                for($j =0;$j<$childrenCount;$j++) {
                    $queue[] = $queue[$i]->children[$j];
                }
            }
            $curNums = [];
            for($i = 0;$i<$count;$i++) {
                $curNums[] = current($queue)->val;
                array_shift($queue);
            }
            $res[] = $curNums;
        }
        
        return $res;
    }
}
