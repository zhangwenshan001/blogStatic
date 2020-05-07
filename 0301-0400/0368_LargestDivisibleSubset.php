<?php

class Solution {
    /**
     * @param Integer[] $nums
     * @return Integer[]
     */
    function largestDivisibleSubset($nums) {
        $l = [];
        $pre = [];
        
        sort($nums);
        
        $max = 0;
        $index = -1;
        
        $n = count($nums);
        for($i = 0;$i<$n;$i++) {
            $l[$i] = 1;
            $pre[$i] = -1;
            for($j=$i-1;$j>=0;$j--) {
                if ($nums[$i] % $nums[$j] == 0 && $l[$j]+1 > $l[$i]) {
                    $l[$i] = $l[$j] + 1;
                    $pre[$i] = $j;
                }
            }
            if ($l[$i]>$max) {
                $max = $l[$i];
                $index = $i;
            }
        }
        
        $res = [];
        while($index != -1) {
            $res[] = $nums[$index];
            $index = $pre[$index];
        }
        
        return $res;
    }
}
