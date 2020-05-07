<?php

class Solution {

    /**
     * @param Integer $c
     * @return Boolean
     */
    function judgeSquareSum($c) {
        $start = 0;
        $end = (int)sqrt($c);
        
        while($start <= $end) {
            $num = $start * $start + $end * $end;
            if ($num == $c) {
                return true;
            } else if ($num < $c) {
                $start++;
            } else {
                $end--;
            }
        }
        
        return false;
    }
}
