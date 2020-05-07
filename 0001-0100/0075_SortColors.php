<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function sortColors(&$nums) {
        $i = 0;
        $j = 0;
        $len = count($nums);
        for($k = 0;$k<$len;$k++){
            $tmp = $nums[$k];
            $nums[$k] = 2;
            if ($tmp < 2) {
                $nums[$j] = 1;
                $j = $j+1;
            }
            if ($tmp == 0) {
                $nums[$i] = 0;
                $i = $i+1;
            }
            
        } 
    }
}
