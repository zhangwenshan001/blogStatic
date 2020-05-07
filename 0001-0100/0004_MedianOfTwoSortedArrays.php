<?php

class Solution {

    /**
     * 找到排序数组的中位数
     * note：根据两个数组长度确定中位数的位置k，再从两个数组往后数k个
     *
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Float
     */
    function findMedianSortedArrays($nums1, $nums2) {
        if (!$nums1 && !$nums2) {
            return;
        }

        $len1 = count($nums1);
        $len2 = count($nums2);

        $goalIndex = intval(($len1 + $len2 - 1) / 2);

        $i = 0;
        $j = 0;
        for ($k = 0; $k < $goalIndex; $k++) {
            if ($j >= $len2 || ($i < $len1 && $nums1[$i] < $nums2[$j])) {
                $i++;
            } else {
                $j++;
            }
        }
        if ($j >= $len2 || ($i < $len1 && $nums1[$i] < $nums2[$j])) {
            $goalNum = $nums1[$i];
            $i++;
        } else {
            $goalNum = $nums2[$j];
            $j++;
        }

        if (($len1 + $len2) % 2 == 1) {
            return $goalNum;
        } else {
            $nextNum = ($j >= $len2 || ($i < $len1 && $nums1[$i] < $nums2[$j])) ? $nums1[$i] : $nums2[$j];
            return ($goalNum + $nextNum) / 2;
        }
    }
}
