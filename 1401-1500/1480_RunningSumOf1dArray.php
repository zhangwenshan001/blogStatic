<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[]
     */
    function runningSum($nums) {
        $res = [];
        $curSum = 0;
        for($i = 0;$i<count($nums);$i++) {
            $curSum += $nums[$i];
            $res[] = $curSum;
        }
        
        return $res;
    }
}
