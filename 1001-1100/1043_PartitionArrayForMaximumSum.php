<?php
class Solution {

    /**
     * @param Integer[] $A
     * @param Integer $K
     * @return Integer
     */
    function maxSumAfterPartitioning($A, $K) {
        $n = count($A);
        if ($n == 0) {
            return 0;
        }
        if ($n == 1) {
            return $A[0];
        }
        $maxArr = array_fill(0,$n,array_fill(0,$K,PHP_INT_MIN));
        for($i = 0;$i<$n;$i++) {
            $maxArr[$i][0] = $A[$i];
            for($k = 1;$k<$K;$k++) {
                if ($i+$k < $n) {
                    $maxArr[$i][$k] = max($maxArr[$i][$k-1],$A[$i+$k]);
                }
            }
        }

        $dp = [];
        $dp[$n] = 0;
        $dp[$n-1] = $A[$n-1];
        for($i = $n-2;$i>=0;$i--) {
            $dp[$i] = $A[$i] + $dp[$i+1];
            for($k = 1;$k<$K;$k++) {
                if ($i+$k < $n) {
                    $dp[$i] = max($dp[$i], $maxArr[$i][$k] * ($k+1) + $dp[$i+$k+1]);
                }
            }
        }

        return $dp[0];

    }
}