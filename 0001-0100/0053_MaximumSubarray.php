<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function maxSubArray($nums) {
        $arrayCount = count($nums);

        $max    = PHP_INT_MIN;
        $tmpSum = null;

        for ($i = 0; $i < $arrayCount; $i++) {
            if ($nums[$i] >= 0) {
                $tmpSum = isset($tmpSum) ? $tmpSum + $nums[$i] : $nums[$i];
            } else {
                if (!isset($tmpSum)) {
                    $max = max($max, $nums[$i]);
                } else {
                    $max = max($max, $tmpSum);

                    if ($tmpSum + $nums[$i] < 0) {
                        $tmpSum = null;
                    } else {
                        $tmpSum = $tmpSum + $nums[$i];
                    }
                }
            }
        }

        if (isset($tmpSum) && $tmpSum > $max) {
            $max = $tmpSum;
        }
        return $max;
    }
}
