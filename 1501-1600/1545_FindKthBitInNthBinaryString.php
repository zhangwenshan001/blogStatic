<?php

class Solution {

    /**
     * @param Integer $n
     * @param Integer $k
     * @return String
     */
    function findKthBit($n, $k) {
        if ($k == 1) {
            return "0";
        }
        
        $mid = pow(2, $n) - 1;
        if ($k == intval(($mid / 2))) {
            return "1";
        }
        if ($k < intval(($mid / 2))) {
            return $this->findKthBit($n-1, $k);
        } else {
            $tmp = $this->findKthBit($n-1, pow(2,$n)-$k);
            return ($tmp == "1") ? "0" : "1"; 
        }
    }
}
