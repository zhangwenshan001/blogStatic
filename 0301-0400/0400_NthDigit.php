<?php
class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function findNthDigit($n) {
        if($n <= 9) {
            $base = 1;
            $remain = $n;
        } else if ($n <= 189) {
            $base = 2;
            $remain = $n - 9;
        } else if ($n <= 2889) {
            $base = 3;
            $remain = $n - 189;
        } else if ($n <= 38889) {
            $base = 4;
            $remain = $n - 2889;
        } else if ($n <= 488889) {
            $base = 5;
            $remain = $n - 38889;
        } else if ($n <= 5888889) {
            $base = 6;
            $remain = $n - 488889;
        } else if ($n <= 68888889) {
            $base = 7;
            $remain = $n - 5888889;
        } else if ($n <= 788888889) {
            $base = 8;
            $remain = $n - 68888889;
        } else {
            $base = 9;
            $remain = $n - 788888889;
        }
        
        $num = (int) ($remain / $base) + pow(10, $base-1);
        $pos =  $remain % $base;
        
        if ($pos == 0) {
            return ($num-1) % 10;
        } else {
            return ((int) ($num / pow(10, ($base - $pos)) )) % 10;
        }
        
    }
}
