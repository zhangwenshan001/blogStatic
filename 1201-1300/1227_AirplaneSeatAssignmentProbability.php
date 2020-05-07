<?php
class Solution {

    /**
     * @param Integer $n
     * @return Float
     */
    function nthPersonGetsNthSeat($n) {
        if ($n == 1) {
            return 1;
        }
        if ($n == 2) {
            return 0.5;
        }
        
        $p = 0.5;
        for($i = 3;$i<=$n;$i++) {
            $p = (1/$i) + $p * ($i-2)/$i; 
        }
        return $p;
    }
}
