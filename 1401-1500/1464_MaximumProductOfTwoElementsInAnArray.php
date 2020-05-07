<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function maxProduct($nums) {
        if(count($nums) ==2) {
            return ($nums[0]-1) * ($nums[1] -1);
        }

        if ($nums[0] >= $nums[1]){
            $max = $nums[0];
            $next = $nums[1];
        } else {
            $max = $nums[1];
            $next = $nums[0];
        }

        for($i = 2;$i<count($nums);$i++) {
            if ($nums[$i] >= $max) {
                $next = $max;
                $max = $nums[$i];
            } else if ($nums[$i] >= $next) {
                $next = $nums[$i];
            }
        }

        return ($max -1) * ($next -1);
    }
}