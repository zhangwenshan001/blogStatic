<?php

class Solution {

    /**
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalRectangle($matrix) {
         if (!$matrix) {
            return 0;
        }

        $m = count($matrix);
        $n = count($matrix[0]);

        $left   = [];
        $right  = [];
        $height = [];

        $maxRec = 0;
        for ($i = 0; $i < $m; $i++) {
            $curLeft = 0;
            for ($j = 0; $j < $n; $j++) {
                if ($matrix[$i][$j] == 1) {
                    $height[$j] = isset($height[$j]) ? $height[$j] + 1 : 1;
                    $left[$j]   = isset($left[$j]) ? max($curLeft, $left[$j]) : $curLeft;
                } else {
                    $height[$j] = 0;
                    $left[$j]   = 0;
                    $curLeft    = $j + 1; 

                }
            }
            $curRight = $n - 1;
            for ($j = $n - 1; $j >= 0; $j--) {
                if ($matrix[$i][$j] == 1) {
                    $right[$j] = isset($right[$j]) ? min($right[$j], $curRight) : $curRight;
                } else {
                    $right[$j] = $n;
                    $curRight  = $j - 1;
                }

                $maxRec = max($maxRec, $height[$j] * ($right[$j] - $left[$j] + 1));
            }
        }

        return $maxRec;
    }
}
