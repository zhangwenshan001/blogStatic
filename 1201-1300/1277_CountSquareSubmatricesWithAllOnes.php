<?php

class Solution {

    /**
     * @param Integer[][] $matrix
     * @return Integer
     */
    function countSquares($matrix) {
        $sum = 0;
        $m = count($matrix);
        $n = count(current($matrix));
        
        for($i = 0;$i<$m;$i++) {
            for($j = 0;$j<$n;$j++) {
                if ($i > 0 && $j > 0 && $matrix[$i][$j] == 1) {
                    $matrix[$i][$j] =  min($matrix[$i-1][$j], $matrix[$i][$j-1],$matrix[$i-1][$j-1])+1;
                }
                $sum = $sum + $matrix[$i][$j];
            }
        }
        
        return $sum;
    }
}
