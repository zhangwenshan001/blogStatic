<?php

class Solution {
    
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $tmp = [];
        $c = count($nums);
        for($i = 0;$i < $nums;$i++) {
            $n = $target - $nums[$i];
            if (isset($tmp[$n])) {
                return [$tmp[$n],$i];
            }
            $tmp[$nums[$i]] = $i;
        }
        
        return [];
    }
    
    /*
    function twoSum($nums, $target) {
        if (empty($nums) || count($nums) < 2) {
            return [];
        }
        $count = count($nums);
        for ($i = 0; $i < $count - 1; $i++) {
            for ($j = $i+1;$j<$count;$j++) {
                if ($nums[$i] + $nums[$j] == $target) {
                    return [$i, $j];
                }
            }
        }
    }
    */

}
