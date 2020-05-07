<?php

class Solution {

    /**
     * @param Integer $x
     * @param Integer $y
     * @return Integer
     */
    function hammingDistance($x, $y) {
        $res = 0;
        while($x != 0 || $y != 0) {
            $i = $x % 2;
            $j = $y % 2;
            
            $res += ($i == $j) ? 0 : 1;
            
            $x = $x >> 1;
            $y = $y >> 1;
        }
        
        return $res;
    }
}
