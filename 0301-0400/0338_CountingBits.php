<?php

class Solution {

    /**
     * @param Integer $num
     * @return Integer[]
     */
    function countBits($num) {
        $base = 1;
        $dp = [];
        $dp[0] = 0;

        if ($num == 0) {
            return [0];
        }
        for($i = 1;$i<=$num;$i++) {
            if ($i >= 2 * $base) {
                $base *= 2;
            }
            
            if ($i == $base) {
                $dp[$i] = 1;
            } else {
                $dp[$i] = $dp[$base] + $dp[$i-$base];
            }
            
        }
        
        return $dp;
    }
}
