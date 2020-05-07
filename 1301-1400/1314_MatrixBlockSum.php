<?php

class Solution {

    /**
     * @param Integer[][] $mat
     * @param Integer $K
     * @return Integer[][]
     */
    function matrixBlockSum($mat, $K) {
        $m = count($mat);
        $n = count(current($mat));
        
        $rangeSum = [];
        for($i = 0;$i<$m;$i++) {
            $rangeSum[$i][0] = 0;
        }
        for($j = 0;$j<$n;$j++) {
            $rangeSum[0][$j] = 0;
        }
        for($i=0;$i<$m;$i++) {
            for($j = 0;$j<$n;$j++) {
                $rangeSum[$i+1][$j+1] = $rangeSum[$i][$j+1] + $rangeSum[$i+1][$j] - $rangeSum[$i][$j] + $mat[$i][$j];
            }
        }
      
        $ans = [];
        for($i = 0;$i<$m;$i++) {
            for($j = 0;$j<$n;$j++) {
                $r1 = max(0, $i-$K);
                $c1 = max(0, $j-$K);
                $r2 = min($m, $i+$K+1);
                $c2 = min($n, $j+$K+1);
                $ans[$i][$j] = $rangeSum[$r2][$c2] - $rangeSum[$r1][$c2] - $rangeSum[$r2][$c1] + $rangeSum[$r1][$c1];
            }
        }
        return $ans;
    }
}
