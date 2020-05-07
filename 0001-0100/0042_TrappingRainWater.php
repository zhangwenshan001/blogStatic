<?php

class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
         if (!$height) {
            return 0;
        }

        $count    = count($height);
        $leftMax  = [];
        $rightMax = [];
        for ($i = 0; $i < $count; $i++) {
            $leftMax[$i]               = ($i == 0) ? 0 : max($height[$i - 1], $leftMax[$i - 1]);
            $rightMax[$count - $i - 1] = ($i == 0) ? 0 : max($height[$count - $i], $rightMax[$count - $i]);
        }

        $total = 0;
        for ($i = 0; $i < $count; $i++) {
            if ($leftMax[$i] > $height[$i] && $rightMax[$i] > $height[$i]) {
                $total = $total + min($leftMax[$i], $rightMax[$i]) - $height[$i];
            }
        }

        return $total;
    }
}
