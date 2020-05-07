<?php

class Solution {
    

    /**
     * @param Integer[] $A
     * @param Integer[] $B
     * @return Integer
     */
    function maxUncrossedLines($A, $B) {
        $m = count($A);
        $n = count($B);
        
        if ($m == 0 || $n == 0) {
            return 0;
        }
        
        $dp = [];
        $dp[0][0] = ($A[0] == $B[0]) ? 1 : 0;
        for($j = 1;$j<$n;$j++) {
            $dp[0][$j] = ($A[0] == $B[$j] || $dp[0][$j-1]== 1) ? 1 : 0;
        }
        
        for($i = 1;$i<$m;$i++) {
            for($j = 0;$j<$n;$j++) {
                if($j == 0) {
                    $dp[$i][$j] = ($dp[$i-1][$j] == 1 || $A[$i] == $B[$j]) ? 1:0; 
                } else if ($A[$i] == $B[$j]) {
                    $dp[$i][$j] = max($dp[$i-1][$j], $dp[$i][$j-1], 1+$dp[$i-1][$j-1]);
                } else {
                    $dp[$i][$j] = max($dp[$i-1][$j], $dp[$i][$j-1], $dp[$i-1][$j-1]);
                }
            }
        }
        
        return $dp[$m-1][$n-1];
    }
}
