<?php

class Solution {

    /**
     * @param Integer[] $arr
     * @param Integer $k
     * @return Integer
     */
    function getWinner($arr, $k) {
        $n = count($arr);
        $count = [];
    
        $curMax = $arr[0];
        for($i = 1;$i<$n;$i++) {
            $curMax = max($curMax, $arr[$i]);
            if (isset($count[$curMax])) {
                $count[$curMax]++;
            } else {
                $count[$curMax] = 1;
            }
            if ($count[$curMax] == $k) {
                return $curMax;
            }
        }
        
        return $curMax;
        
    }
}
