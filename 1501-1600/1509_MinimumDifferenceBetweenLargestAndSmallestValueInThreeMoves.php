<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function minDifference($nums) {
        sort($nums);
        $n =count($nums);
        $start = 0;
        $end = $n-4;
        
        if ($start >= $end) {
            return 0;
        }
        
        $min = PHP_INT_MAX;
        while($end < $n) {
            $min = min($min, $nums[$end] - $nums[$start]);
            $start++;
            $end++;
        }
        
        return $min;
        
    }
}
