<?php

class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function arrangeCoins($n) {
        if ($n <= 0) {
            return 0;
        }
        
        $i = 1;
        while((int)(($i+1)*$i/2) <= $n) {
            $i++;
        }
        
        return $i-1;
    }
}
