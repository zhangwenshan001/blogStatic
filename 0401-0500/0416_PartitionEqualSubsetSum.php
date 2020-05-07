<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canPartition($nums) {
        $sum = 0;
        foreach($nums as $num) {
            $sum += $num;
        }
        
        if ($sum % 2 == 1) {
            return false;
        }
        
        $sum = $sum / 2;
    
        $dp = array_pad([], $sum + 1, false);
        $dp[0] = true;
        foreach($nums as $num) {
            for($j = $sum;$j>0;$j--) {
                if ($j-$num >=0) {
                    $dp[$j] = $dp[$j] || $dp[$j - $num];
                }
            }
        }
        return $dp[$sum];
    }
}
