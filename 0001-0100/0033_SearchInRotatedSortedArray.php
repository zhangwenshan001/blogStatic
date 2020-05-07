<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        if (!$nums) {
            return -1;
        }

        $nlen  = count($nums);
        $start = 0;
        $end   = $nlen - 1;
        $mid   = intval(($start + $end) / 2);

        if ($target < $nums[$start] && $target > $nums[$end]) {
            return -1;
        }

        while ($start < $end - 1) {
          
            $startNum = $nums[$start];
            $endNum   = $nums[$end];
            $midNum   = $nums[$mid];

            if ($startNum == $target) {
                return $start;
            }
            if ($endNum == $target) {
                return $end;
            }

            if ($midNum == $target) {
                return $mid;
            }

            if ($target > $startNum && $startNum > $midNum) {
                $end = $mid;
                $mid = intval(($start + $end) / 2);
            } elseif ($target > $startNum && $startNum < $midNum) {
                if ($target > $midNum) {
                    $start = $mid;
                } else {
                    $end = $mid;
                }

                $mid = intval(($start + $end) / 2);
            } elseif ($target < $endNum && $endNum < $midNum) {
                $start = $mid;
                $mid   = intval(($start + $end) / 2);
            } elseif ($target < $endNum && $endNum > $midNum) {
                if ($target > $midNum) {
                    $start = $mid;
                } else {
                    $end = $mid;
                }
                $mid = intval(($start + $end) / 2);
            }

        }

        if ($nums[$start] == $target) {
            return $start;
        }

        if ($nums[$end] == $target) {
            return $end;
        }

        return -1;  
    }
}
