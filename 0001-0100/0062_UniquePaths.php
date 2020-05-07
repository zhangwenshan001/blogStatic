<?php

class Solution {

    /**
     * @param Integer $m
     * @param Integer $n
     * @return Integer
     */
    function uniquePaths($m, $n) {
        $minNum = min($m, $n);
        $a      = 1;
        $b      = 1;
        for ($i = 0; $i < $minNum - 1; $i++) {
            $a = $a * ($m + $n - 2 - $i);
            $b = $b * ($i + 1);
        }

        return $a / $b;
    }
}
