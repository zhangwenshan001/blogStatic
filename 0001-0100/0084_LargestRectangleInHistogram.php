<?php

class Solution {

    /**
     * @param Integer[] $heights
     * @return Integer
     */
    function largestRectangleArea($heights) {
       if (!$heights) {
            return 0;
        }
        $count = count($heights);

        $leftTmp              = [];
        $rightTmp             = [];
        $leftTmp[0]           = -1;
        $rightTmp[$count - 1] = $count;

        for ($i = 1; $i < $count; $i++) {
            $p = $i - 1;
            while ($p >= 0 && $heights[$p] >= $heights[$i]) {
                $p = $leftTmp[$p]; 
            }
            $leftTmp[$i] = $p;

            $p = $count - $i;
            while ($p < $count && $heights[$p] >= $heights[$count - $i - 1]) {
                $p = $rightTmp[$p];
            }
            $rightTmp[$count - $i - 1] = $p;
        }

        $max = PHP_INT_MIN;
        for ($i = 0; $i < $count; $i++) {
            $max = max($max, $heights[$i] * ($rightTmp[$i] - $leftTmp[$i] - 1));
        }

        return $max;
    }
}
