<?php
class Solution {
    private $numMap = [];
    
    /**
     * @param Integer[] $nums
     */
    function __construct($nums) {
        $n = count($nums);
        for($i = 0;$i<$n;$i++) {
            if (isset($this->numMap[$nums[$i]])) {
                $this->numMap[$nums[$i]][] = $i;
            } else {
                $this->numMap[$nums[$i]] = [$i];
            }
        }
    }
  
    /**
     * @param Integer $target
     * @return Integer
     */
    function pick($target) {
        $targetArr = $this->numMap[$target];
        return $targetArr[rand(0, count($targetArr)-1)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * $obj = Solution($nums);
 * $ret_1 = $obj->pick($target);
 */
