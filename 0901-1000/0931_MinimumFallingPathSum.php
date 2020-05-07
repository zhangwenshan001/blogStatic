<?php

class Solution {

    /**
     * @param Integer[][] $A
     * @return Integer
     */
    function minFallingPathSum($A) {
        if (empty($A)) {
            return 0;
        }
        
        $m = count($A);
        $n = count(current($A));
        
        $dp = current($A);
        $dpNew = $dp;
        for($i = 1;$i< $m;$i++) {
            if ($n == 1) {
                $dpNew[0] = $dp[0] +  $A[$i][0];
            } else {
                for($j = 0;$j<$n;$j++) {
                    if ($j == 0) {
                        $min = min($dp[$j], $dp[$j+1]);
                    } else if ($j == $n-1) {
                        $min = min($dp[$j], $dp[$j-1]);
                    } else {
                         $min = min($dp[$j], $dp[$j-1], $dp[$j + 1]);
                    }
                    $dpNew[$j] = $A[$i][$j] + $min;
                }
            }
            $dp = $dpNew;
        }
        
        $minPath = PHP_INT_MAX;
        for($i = 0;$i<$n;$i++) {
            $minPath = min($minPath, $dpNew[$i]);
        }
        
        return $minPath;
    }
}
