<?php
class Solution {

    /**
     * @param Integer $num
     * @return Boolean
     */
    function isPerfectSquare($num) {
        $n = 1;
        $i = 1;
        while($n < $num) {
            $i++;
            $n = $i * $i;
            if ($n == $num) {
                return true;
            }
            if ($n > $num) {
                return false;
            }
        }
        return true;
    }
}
