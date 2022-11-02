<?php

class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function minOperations($n) {
        if ($n % 2 == 1) {
            $k = intval($n/2);
            return (1+$k) * $k;
        } else {
            return $n*$n/4;
        }
    }
}