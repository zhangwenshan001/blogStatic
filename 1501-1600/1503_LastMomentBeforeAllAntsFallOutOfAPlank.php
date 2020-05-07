<?php

class Solution {

    /**
     * @param Integer $n
     * @param Integer[] $left
     * @param Integer[] $right
     * @return Integer
     */
    function getLastMoment($n, $left, $right) {
        $leftCount = count($left);
        $rightCount = count($right);
        
        $max = 0;
        for($i = 0;$i<$leftCount;$i++) {
            $max =max($max, $left[$i]);
        }
        for($i = 0;$i<$rightCount;$i++) {
            $max = max($max, $n-$right[$i]);
        }
        
        return $max;
    }
}
