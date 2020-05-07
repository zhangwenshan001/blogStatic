<?php

class Solution {

    /**
     * @param Integer[] $salary
     * @return Float
     */
    function average($salary) {
        $min = PHP_INT_MAX;
        $max = PHP_INT_MIN;
        
        $n = count($salary);
        $sum = 0;
        for($i = 0;$i<$n;$i++){
            if ($salary[$i] < $min) {
                $min = $salary[$i];
            }
            if ($salary[$i] > $max) {
                $max = $salary[$i];
            } 
            $sum += $salary[$i];
        }
       
        return ($sum-$max-$min) / ($n-2);
    }
}
