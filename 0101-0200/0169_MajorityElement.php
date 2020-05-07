<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function majorityElement($nums) {
        sort($nums);
    
        $mid = (int) (count($nums) / 2 ); 
        return $nums[$mid];
    }
}
