<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[]
     */
    function singleNumber($nums) {
        $diff = 0;
        foreach($nums as $num) {
            $diff ^= $num;
        } 
        
        $diff &= -$diff;
        
        $res = [0,0];
        foreach($nums as $num) {
            if (($num & $diff) == 0) {
                $res[0] ^= $num;
            } else {
                $res[1] ^= $num;
            }
        }
        
        return $res;
    }
}
