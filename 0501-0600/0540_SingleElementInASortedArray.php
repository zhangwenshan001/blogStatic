<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function singleNonDuplicate($nums) {
        $i = 0;
        $j = 1;
        
        while($nums[$i] == $nums[$j] && $i < count($nums) && $j < count($nums)) {
            $i = $i + 2;
            $j = $j + 2;
        }
        return $nums[$i];
         
    }
}
