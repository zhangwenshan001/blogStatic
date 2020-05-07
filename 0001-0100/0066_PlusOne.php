<?php

class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits) {
        $n = count($digits) - 1;
        
        while($n >= 0) {
            if ($digits[$n] < 9) {
                $digits[$n] = $digits[$n] + 1;
                return $digits;
            } else {
                $digits[$n] = 0;
            }
            $n--;
        }
        
        array_unshift($digits, 1);
        return $digits;
        
    }
}
