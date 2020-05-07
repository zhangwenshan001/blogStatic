<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function lengthOfLIS($nums) {
        if ($nums == null || count($nums) == 0) {
            return 0;
        }
        $dp = [];
        
        $n = count($nums);
        $dp[0] = 1;
        $max = 1;
        for($i = 1;$i<$n;$i++) {
            $dp[$i] = PHP_INT_MIN;
            for($j = 0;$j<$i;$j++) {
                $cur = ($nums[$i]>$nums[$j]) ? $dp[$j] + 1: 1;
                $dp[$i] = max($dp[$i], $cur);
            }
            $max = max($max, $dp[$i]);
        }
       
        return $max;
        
    }
}
