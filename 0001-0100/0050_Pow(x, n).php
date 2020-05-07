<?php
class Solution {

    /**
     * @param Float $x
     * @param Integer $n
     * @return Float
     */
    function myPow($x, $n) {
        if ($n == 1) {
            return $x;
        }
        
        $flag = false;
        if ($n < 0){
            $flag = true;
            $n = -$n;
        }
      
        if ($n == 0) {
            if ($x < 0) {
                return PHP_INT_MAX;
            } else {
                return 1;
            }
        }
        
        $newX = $x * $x;
        $newN = (int) ($n / 2);
        if ($n % 2 == 1) {
            $res = $this->myPow($newX, $newN) * $x;
        } else {
            $res = $this->myPow($newX, $newN);
        }
        
        if ($flag) {
            return 1/$res;
        } else {
            return $res;
        }
    }
}
