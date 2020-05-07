<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums) {
         if (!$nums) {
            return false;
        }

        $lastIndex = count($nums) - 1;
        if ($lastIndex == 0) {
            return true;
        }
        $curIndex = 0;
        $curReach = $nums[$curIndex] + $curIndex;

        while ($curReach > $curIndex) {
            if ($curReach >= $lastIndex) {
                return true;
            }
            $curIndex = $curIndex + 1;
            $curReach = max($curReach, $curIndex + $nums[$curIndex]);
        }

        return false;
    }
}
