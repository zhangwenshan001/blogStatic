<?php

class Solution {

    private $dp = [];
    /**
     * @param Integer $lo
     * @param Integer $hi
     * @param Integer $k
     * @return Integer
     */
    function getKth($lo, $hi, $k) {
        $res = [];
        for($i = $lo;$i<=$hi;$i++) {
            $res[$i] = [$this->powerPath($i), $i];
        }

        uasort($res, function($x, $y) {

            if($x[0] < $y[0] || ($x[0] ==$y[0]) && $x[1] < $y[1]) {
                return -1;
            } else {
                return 1;
            }
        });

        $i = 1;

        foreach($res as $key => $value) {
            if ($i == $k) {
                return $key;
            }
            $i++;
        }

        return -1;
    }

    function powerPath($num) {
        if(!empty($this->dp[$num])) {
            return $this->dp[$num];
        }
        if ($num == 1) {
            return 0;
        }
        if ($num % 2 ==1) {
            $this->dp[$num] = $this->powerPath(3*$num+1) + 1;
        } else {
            $this->dp[$num] = $this->powerPath($num/2) + 1;
        }
        return $this->dp[$num];

    }
}