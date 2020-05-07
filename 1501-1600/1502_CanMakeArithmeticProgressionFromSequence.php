<?php

class Solution {

    /**
     * @param Integer[] $arr
     * @return Boolean
     */
    function canMakeArithmeticProgression($arr) {
        sort($arr);
        $d = $arr[1] - $arr[0];
        $n = count($arr);
        for($i = 2;$i<$n;$i++) {
            if ($arr[$i] - $arr[$i-1] != $d) {
                return false;
            }
        }
        
        return true;
            
    }
}
