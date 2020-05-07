<?php

class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n) {
        if ($n == 1) {
            return 1;
        }
        
        if ($n == 2) {
            return 2;
        }
        $pre = 1;
        $cur = 2;
        for ($i = 3; $i <= $n; $i++) {
            $tmp = $pre;
            $pre = $cur;
            $cur = $tmp + $cur;
        }
        return $cur;
       
    }
}
