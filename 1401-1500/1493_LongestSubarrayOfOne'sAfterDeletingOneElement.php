<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function longestSubarray($nums) {
        $pre = 0;
        $cur = 0;
        $max = 0;
        $flag = true;
        
        $i = 0;
        $n = count($nums);
        while($i<$n) {
            if ($nums[$i] == 0) {
               
                if ($flag){
                    $pre = $cur;
                    $cur = 0;
                    $flag = false;
                }else {
                    $pre = 0;
                    $cur = 0;
                }
                
                $i++;
            } else {
                $flag = true;
                while($i<$n && $nums[$i] == 1) {
                    $cur++;
                    $i++;
                    $max = max($max, $cur+$pre);
                   
                }
            }
            
        }
        
        if ($max == $n) {
            return $n-1;
        }
        return $max;
    }
}
