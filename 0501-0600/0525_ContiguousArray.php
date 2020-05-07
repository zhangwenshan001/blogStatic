<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function findMaxLength($nums) {
        if (count($nums) <= 1) {
            return 0;
        }
        
        $map = [];
        $map[0] = 0;
        $c = count($nums);
        $max = 0;
        $curKey = 0;
        for($i = 1;$i<=$c;$i++) {
            if ($nums[$i-1] == 0) {
                $curKey--;
            } else {
                $curKey++;
            }
            
            if (!isset($map[$curKey])) {
                $map[$curKey] = $i;
            } else {
                $max = max($max, $i - $map[$curKey]);
            }
        }
        
        return $max;
    }
}
