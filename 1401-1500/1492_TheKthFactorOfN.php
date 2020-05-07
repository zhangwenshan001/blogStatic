<?php

class Solution {

    /**
     * @param Integer $n
     * @param Integer $k
     * @return Integer
     */
    function kthFactor($n, $k) {
        $i = 0;
        $factor = 1;
        while($factor <= $n) {
            if ($n % $factor == 0) {
                $i++;
                if ($i == $k) {
                    return $factor;
                }
            }
            $factor++;
        }
        return -1;
        
    }
}
