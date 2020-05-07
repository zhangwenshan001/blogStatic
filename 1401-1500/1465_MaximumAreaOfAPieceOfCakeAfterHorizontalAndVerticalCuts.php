<?php

class Solution {

    /**
     * @param Integer $h
     * @param Integer $w
     * @param Integer[] $horizontalCuts
     * @param Integer[] $verticalCuts
     * @return Integer
     */
    function maxArea($h, $w, $horizontalCuts, $verticalCuts) {
        sort($horizontalCuts);
        sort($verticalCuts);
        $horizonMax = $horizontalCuts[0];
        $verticalMax = $verticalCuts[0];

        $m = count($horizontalCuts);
        $n = count($verticalCuts);
        for($i = 1;$i<$m;$i++) {
            $horizonMax = max($horizonMax, $horizontalCuts[$i] - $horizontalCuts[$i-1]);
        }
        for($i = 1;$i<$n;$i++) {
            $verticalMax = max($verticalMax,$verticalCuts[$i]-$verticalCuts[$i-1]);
        }
        $horizonMax = max($horizonMax, $h - $horizontalCuts[$m-1]);
        $verticalMax = max($verticalMax, $w - $verticalCuts[$n-1]);

        return ($horizonMax * $verticalMax) % 1000000007;
    }
}