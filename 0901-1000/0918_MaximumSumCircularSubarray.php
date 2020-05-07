<?php

class Solution {

    /**
     * @param Integer[] $A
     * @return Integer
     */
    function maxSubarraySumCircular($A) {
        if ($A == null || count($A) == 0) {
            return 0;
        }
        if (count($A) == 1) {
            return $A[0];
        }
        $sum = $A[0];
        
        $curMax = $A[0];
        $curMin = $A[0];
        
        $max = $A[0];
        $min = $A[0];
        
        $c = count($A);
        
        for($i = 1;$i<$c;$i++) {
            $sum += $A[$i];
            $curMax = max($curMax + $A[$i], $A[$i]);
            $curMin = min($curMin + $A[$i], $A[$i]);
            $max = max($max, $curMax);
            $min = min($min, $curMin);
        }
        if($max <= 0) {
            return $max;
        }
       
        return max($max, $sum-$min);
    }
}
