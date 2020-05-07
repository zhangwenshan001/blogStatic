<?php

class Solution {

    /**
     * @param Integer[][] $matrix
     * @return NULL
     */
    function rotate(&$matrix) {
       if (!$matrix) {
            return;
        }

        $n = count($matrix);

        for ($i = 0; $i < intval($n + 1) / 2; $i++) {
            for ($j = $i; $j < $n - $i - 1; $j++) {
                $tmp                              = $matrix[$i][$j];
                $matrix[$i][$j]                   = $matrix[$n - $j - 1][$i];
                $matrix[$n - $j - 1][$i]          = $matrix[$n - $i - 1][$n - $j - 1];
                $matrix[$n - $i - 1][$n - $j - 1] = $matrix[$j][$n - $i - 1];
                $matrix[$j][$n - $i - 1]          = $tmp;
            }
        }

        return;
    }  
    
}
