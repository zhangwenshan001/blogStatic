<?php

class Solution {

    /**
     * @param Integer[][] $nums
     * @param Integer $r
     * @param Integer $c
     * @return Integer[][]
     */
    function matrixReshape($nums, $r, $c) {
        $m = count($nums);
        $n = count(current($nums));
        
        if ($m * $n != $r * $c) {
            return $nums;
        }
        
        $res = [];
        $k = 0;
        $l = 0;
        for($i = 0;$i<$m;$i++){
            for($j = 0;$j <$n;$j++) {
                $res[$k][$l++] = $nums[$i][$j];
                if ($l == $c) {
                    $l = 0;
                    $k++;
                }
            }
        }
        
        return $res;
    }
}
