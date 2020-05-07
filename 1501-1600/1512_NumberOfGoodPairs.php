<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function numIdenticalPairs($nums) {
        $res = 0;
        $tmp = [];
        foreach($nums as $num) {
            if (!isset($tmp[$num])) {
                $tmp[$num] = 1;
            } else {
                $res += $tmp[$num];
                $tmp[$num]++;
            }
        }
        return $res;
    }
}
