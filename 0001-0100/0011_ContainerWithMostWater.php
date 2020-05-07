<?php

class Solution {

    /**
     * 找到储水量最大的容器
     * note：从两边开始，每次将更短的边往中间靠近一步
     *
     * @param Integer[] $height
     * @return Integer
     */
    function maxArea($height) {
         if (empty($height)) {
            return 0;
        }

        $max = 0;
        $i = 0;
        $j = count($height) - 1;

        while ($i<$j) {
            $max = max($max, ($j-$i)*min($height[$i], $height[$j]));
            if ($height[$i] < $height[$j]) {
                $i++;
            } else {
                $j--;
            }
        }
        return $max;
    }
}
