<?php

class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {
        if (empty($grid)) {
            return 0;
        }
        $m = count($grid);
        $n = count($grid[0]);

        for ($i = 1; $i < $m + $n - 1; $i++) {
            for ($j = 0; $j <= $i; $j++) {
                if ($j >= $m || $i - $j >= $n || $i - $j < 0) {
                    continue;
                }
                if ($j == 0) {
                    $grid[$j][$i - $j] = $grid[$j][$i - $j] + $grid[$j][$i - $j - 1];
                } elseif ($i - $j == 0) {
                    $grid[$j][$i - $j] = $grid[$j][$i - $j] + $grid[$j - 1][$i - $j];
                } else {
                    $grid[$j][$i - $j] = $grid[$j][$i - $j] + min($grid[$j - 1][$i - $j], $grid[$j][$i - $j - 1]);
                }
            }
        }

        return $grid[$m - 1][$n - 1];
    }
}
