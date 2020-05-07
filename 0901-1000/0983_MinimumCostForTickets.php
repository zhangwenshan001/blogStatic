<?php

class Solution {

    /**
     * @param Integer[] $days
     * @param Integer[] $costs
     * @return Integer
     */
    function mincostTickets($days, $costs) {
        $dayCount = count($days);
        $dp = [];
        
        $dp[$dayCount] = 0;
        $dp[$dayCount - 1] = min($costs);
        
        for($i = $dayCount-2;$i>=0;$i--) {
            $min = $dp[$i+1] + $costs[0];
            $j = $i + 1;
            while($j < $dayCount && $days[$j] - $days[$i] < 7) {
                $j++;
            }
            $min = min($min, $dp[$j] + $costs[1]);
            while($j < $dayCount && $days[$j] - $days[$i] < 30) {
                $j++;
            }
            $min = min($min, $dp[$j] + $costs[2]);
            $dp[$i] = $min;
        }
        
        return $dp[0];
    }
}
