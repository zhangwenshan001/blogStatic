<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function findMin($nums) {
        $start = 0;
        $end = count($nums) - 1;
        
        while($start < $end && $nums[$start] > $nums[$end]) {
            $mid = (int) (($start + $end) / 2);
            if ($nums[$mid] >= $nums[$start]) {
                $start = $mid + 1;
            } else if ($nums[$mid] < $nums[$end]) {
                $end = $mid;
            }
        }
        
        return $nums[$start];
    }
}
